package easy.javadoc.web;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixiaojing3 on 2016/11/28.
 */
public class GlobalExceptionHandler extends HandlerExceptionResolverComposite {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {

        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("status", "500");
        attributes.put("message", "服务器错误");

        logger.error(ex.getMessage(), ex);

        ModelAndView mv = new ModelAndView();
        FastJsonJsonView fastJsonView = new FastJsonJsonView();
        fastJsonView.setContentType("text/html;charset=utf-8");

        fastJsonView.setAttributesMap(attributes);
        mv.setView(fastJsonView);

        return mv;
    }
}
