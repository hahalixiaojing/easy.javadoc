package easy.javadoc.builder.http;

import easy.javadoc.builder.DocumentBuilder;
import easy.javadoc.builder.IDocument;

/**
 * Created by lixiaojing3 on 2017/2/23.
 */
public abstract class BaseApiRequestHandler {
    public static final IDocument document;
    static {
        DocumentBuilder builder = new DocumentBuilder();
        document = builder.build();
    }
}
