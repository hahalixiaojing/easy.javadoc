package easy.javadoc.builder.http;

import com.alibaba.fastjson.JSON;
import easy.javadoc.builder.IDocument;
import easy.javadoc.builder.model.ClassTypeModel;
import easy.javadoc.builder.model.InterfaceTypeModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApiModelRequestHandler extends BaseApiRequestHandler implements IRequestHandler {
    @Override
    public boolean canRequest(HttpServletRequest request) {
        String uri = request.getRequestURI().toLowerCase();
        if (uri.lastIndexOf("api/model") != -1) {
            return true;
        }

        return false;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String type = request.getParameter("type");
        ClassTypeModel classByName = document.findClassByName(type);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(classByName));

    }
}
