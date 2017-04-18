package easy.javadoc.web;

import easy.javadoc.builder.http.BasePackage;
import easy.javadoc.builder.http.DocumentApiServlet;
import easy.javadoc.web.websocket.WebSocketConfig;
import org.slf4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class, WebSocketConfig.class})
@ComponentScan
public class App {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(App.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.addListeners((e) -> {
            System.out.println(e.getTimestamp());
            Logger logger = org.slf4j.LoggerFactory.getLogger(App.class);
            logger.info(System.getProperty("user.dir"));
        });
        application.run(args);

    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {

        List<BasePackage> basePackages = new ArrayList<>();
        BasePackage basePackage = new BasePackage("", "easy.javadoc.web.test");
        basePackages.add(basePackage);
        return new ServletRegistrationBean(new DocumentApiServlet(basePackages), "/doc/*");
    }
}
