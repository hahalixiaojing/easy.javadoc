package easy.javadoc.builder.http;


import easy.javadoc.builder.IDocument;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class PageRequestHandler implements IRequestHandler {
    private static final String pageBasePath = "/doc/page/";

    @Override
    public boolean canRequest(HttpServletRequest request) {
        String uri = request.getRequestURI().toLowerCase();
        if (uri.contains("/doc/page/") || uri.contains("/doc/resource/")) {
            return true;
        }
        return false;
    }

    private String contentType(HttpServletRequest request) {
        String uri = request.getRequestURI().toLowerCase();

        if (uri.endsWith(".html") || uri.endsWith(".htm")) {
            return "text/html;charset=utf-8";
        }
        if (uri.endsWith(".js")) {
            return "application/javascript; charset=utf-8";
        }
        if (uri.endsWith(".css")) {
            return "text/css;charset=utf-8";
        }
        return "text/html;charset=utf-8";
    }

    private String getFilePath(HttpServletRequest request) {
        String uri = request.getRequestURI().toLowerCase();
        if (uri.endsWith(".html")) {
            return "/html" + uri.substring(uri.lastIndexOf("/"));
        }
        if (uri.contains("/doc/resource/") && uri.endsWith(".js")) {
            return "/html/script" + uri.substring(uri.lastIndexOf("/"));
        }
        if (uri.contains("/doc/resource/") && uri.endsWith(".css")) {
            return "/html/css" + uri.substring(uri.lastIndexOf("/"));
        }
        return "/html/interface.html";
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setContentType(this.contentType(request));
        InputStream is = null;
        try {
            is = this.getClass().getResourceAsStream(this.getFilePath(request));
            BufferedReader br = null;
            try {
                br = new BufferedReader(new InputStreamReader(is, Charset.forName("utf-8")));
                String s = "";
                StringBuilder stringBuilder = new StringBuilder();
                while ((s = br.readLine()) != null) {
                    stringBuilder.append(s);
                    stringBuilder.append(SystemUtils.LINE_SEPARATOR);
                }
                response.getWriter().write(stringBuilder.toString());
            } finally {
                br.close();
            }
        } finally {
            is.close();
        }
    }
}
