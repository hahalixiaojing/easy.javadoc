package easy.javadoc.web.controllers;

import com.alibaba.fastjson.JSON;
import easy.javadoc.builder.DocumentBuilder;
import easy.javadoc.builder.IDocument;
import easy.javadoc.builder.doc.Document;
import easy.javadoc.builder.model.ClassTypeModel;
import easy.javadoc.builder.model.InterfaceTypeModel;
import easy.javadoc.builder.model.ParameterModel;
import easy.javadoc.web.JsonResponseBody;
import easy.javadoc.web.test.TestEnum;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static com.alibaba.fastjson.JSON.toJSONString;
import static java.lang.System.in;

@Controller
@RequestMapping("/papa")
public class HomeController {

    private final IDocument document;
    public HomeController() {
        DocumentBuilder builder = new DocumentBuilder();
        document = builder.build();
    }

    @GetMapping("/interfaces")
    @JsonResponseBody
    public InterfaceTypeModel[] getInterfaces(@RequestParam(name = "basepackage",defaultValue = "easy.javadoc.web.test") String basepackage) throws Exception {

        return document.findByBasepackage(basepackage);
    }

    @GetMapping("/model")
    @JsonResponseBody
    public ClassTypeModel getTypeModel(@RequestParam(name = "type") String type) throws Exception {
        return document.findClassByName(type);
    }

    @GetMapping("/parameters")
    @JsonResponseBody
    public ParameterModel[] getParameters(@RequestParam(name = "type") String type, @RequestParam(name = "method") String method) throws Exception {

        return document.findMethodParameters( type, method);
    }
    @GetMapping("/enum")
    @JsonResponseBody
    public String getenum(){
        return TestEnum.values()[0].name();
    }
}
