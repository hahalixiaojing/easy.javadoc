package easy.javadoc.builder.http;

import easy.javadoc.builder.IDocument;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IRequestHandler {
    boolean canRequest(HttpServletRequest request);

    void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
