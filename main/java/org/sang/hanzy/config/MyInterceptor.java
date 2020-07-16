package org.sang.hanzy.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器的方法按照preHandle-->controller-->postHandle-->afterCompletion的顺序执行
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器preHandle------在业务处理器处理请求之前调用preHandle....");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器postHandle------在业务处理器处理请求执行完成后,生成视图之前执行postHandle....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器afterCompletion------在DispatcherServlet完全处理完请求后调用afterCompletion,可用于清理资源....");
    }
}
