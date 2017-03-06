package easy.javadoc.builder.http;

import com.alibaba.fastjson.JSON;
import easy.javadoc.builder.model.InterfaceTypeModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ApiInterfaceRequestHandler extends BaseApiRequestHandler implements IRequestHandler {

    private final Map<String, String> basePackageMap = new HashMap<String, String>();

    public ApiInterfaceRequestHandler(List<BasePackage> basePackages) {
        for (BasePackage basePackage : basePackages) {
            basePackageMap.put(basePackage.getPath(), basePackage.getBasePackage());
        }
    }

    @Override
    public boolean canRequest(HttpServletRequest request) {

        String uri = request.getRequestURI().toLowerCase();
        if (uri.lastIndexOf("/api/interfaces") != -1) {
            return true;
        }

        return false;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String basePackage = request.getParameter("p") == null ? "" : request.getParameter("p");

        InterfaceTypeModel[] byBasepackage = document.findByBasepackage(this.basePackageMap.get(basePackage));

        response.setContentType("application/json;charset=utf-8");

        response.getWriter().write(JSON.toJSONString(byBasepackage));


    }
}
