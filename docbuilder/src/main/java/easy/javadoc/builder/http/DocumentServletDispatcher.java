package easy.javadoc.builder.http;


import easy.javadoc.builder.DocumentBuilder;
import easy.javadoc.builder.IDocument;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentServletDispatcher {

    private final List<IRequestHandler> requestHandlers = new ArrayList<IRequestHandler>();

    public void registerReqeustHandler(IRequestHandler requestHandler) {
        this.requestHandlers.add(requestHandler);
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI().toLowerCase();
        if (uri.endsWith("/doc/page")) {
            response.sendRedirect("/doc/page/");
            return;
        }

        for (IRequestHandler requestHandler : this.requestHandlers) {
            if (requestHandler.canRequest(request)) {
                try {

                    requestHandler.execute(request, response);

                } catch (Exception e) {
                    response.setContentType("text/html;chartset=utf-8");
                    response.getWriter().write(e.getMessage());
                }
                response.flushBuffer();
                break;
            }
        }
    }
}
