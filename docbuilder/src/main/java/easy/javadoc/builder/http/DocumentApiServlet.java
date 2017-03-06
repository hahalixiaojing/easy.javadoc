package easy.javadoc.builder.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DocumentApiServlet extends HttpServlet {

    private final DocumentServletDispatcher dispatcher;

    public DocumentApiServlet(List<BasePackage> basePackages) {
        dispatcher = new DocumentServletDispatcher();
        dispatcher.registerReqeustHandler(new ApiInterfaceRequestHandler(basePackages));
        dispatcher.registerReqeustHandler(new ApiModelRequestHandler());
        dispatcher.registerReqeustHandler(new ApiParameterRequestHandler());
        dispatcher.registerReqeustHandler(new PageRequestHandler());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.dispatcher.execute(req, resp);
    }
}
