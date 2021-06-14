package com.nanhai.core.framework.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RibbonInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(RibbonInterceptor.class);

    @Autowired
    private MyRestTemplate myRestTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String lpfId = request.getHeader("Authorization");
        log.info("token:{}",lpfId);

        if (myRestTemplate == null) {  //解决service为null无法注入问题
            BeanFactory factory =
                    WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            myRestTemplate = (MyRestTemplate) factory.getBean("myRestTemplate");
        }

        myRestTemplate.header("Authorization", lpfId);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub;
    }
}

