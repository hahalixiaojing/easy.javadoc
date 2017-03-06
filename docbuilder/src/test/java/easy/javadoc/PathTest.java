package easy.javadoc;

public class PathTest {

    @org.junit.Test
    public void keyPath() {

        String path1 = "/doc/page/location.js";
        String path3 = "/doc/page/";

        String[] p1 = path1.split("/");
        String[] p3 = path3.split("/");

        String path4 = "/doc/page/v1/";
        String path2 = "/doc/page/v1/location.js";

        String[] p4 = path4.split("/");
        String[] p2 = path2.split("/");

        String uri = "";
        String t = "";
        if (uri.endsWith("/doc/page/")) {

            t = "";
        }
    }
}
