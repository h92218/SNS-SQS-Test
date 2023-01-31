package com.dominos.pilot_3.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress;

@Component
public class CommonInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출된다. 여기서 false를 리턴하면 다음 내용(Controller)을 실행하지 않는다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("################ REQUEST ################");
        logger.info("# Server           = {}", InetAddress.getLocalHost().getHostAddress());
        logger.info("# Host           	= {}", request.getRemoteHost());
        logger.info("# RequestURI     	= {}", request.getRequestURI());
        logger.debug("# RequestURL     	= {}", request.getRequestURL().toString());
        logger.debug("# QueryString    	= {}", request.getQueryString());
        logger.debug("# ContextPath    	= {}", request.getContextPath());
        logger.debug("# ServletPath    	= {}", request.getServletPath());
        logger.debug("# Method         	= {}", request.getMethod());
        logger.debug("# Port           	= {}", request.getServerPort());
        logger.info("########################################\n");
        return true;
    }

    // 클라이언트의 요청을 처리한 뒤에 호출된다. 컨트롤러에서 예외가 발생되면 실행되지 않는다.
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("[postHandle]");
    }

    // afterCompletion : 클라이언트 요청을 마치고 클라이언트에서 뷰를 통해 응답을 전송한뒤 실행이 된다. 뷰를 생성할 때에 예외가 발생할 경우에도 실행이 된다.
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("[afterCompletion]");
    }
}
