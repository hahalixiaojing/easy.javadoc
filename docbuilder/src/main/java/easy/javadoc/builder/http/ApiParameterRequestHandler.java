package easy.javadoc.builder.http;

import com.alibaba.fastjson.JSON;
import easy.javadoc.builder.IDocument;
import easy.javadoc.builder.model.ParameterModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiParameterRequestHandler extends BaseApiRequestHandler implements IRequestHandler {
    @Override
    public boolean canRequest(HttpServletRequest request) {
        String uri = request.getRequestURI().toLowerCase();
        if (uri.lastIndexOf("api/parameters") != -1) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String type = request.getParameter("type");
        String method = request.getParameter("method");

        ParameterModel[] parameters = document.findMethodParameters(type, method);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(parameters));


    }
}
