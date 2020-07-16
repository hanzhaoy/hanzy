package org.sang.hanzy.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {

    //和我们编写的Servlet程序一样，Filter的创建和销毁由WEB服务器负责。
    // web 应用程序启动时，web 服务器将创建Filter 的实例对象，并调用其init方法，读取web.xml配置，
    // 完成对象的初始化功能，从而为后续的用户请求作好拦截的准备工作（filter对象只会创建一次，init方法也只会执行一次）。
    // 开发人员通过init方法的参数，可获得代表当前filter配置信息的FilterConfig对象
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器----web 应用程序启动时，web 服务器将创建Filter 的实例对象，并调用其init方法");
    }

    //这个方法完成实际的过滤操作。当客户请求访问与过滤器关联的URL的时候，Servlet过滤器将先执行doFilter方法。
    // FilterChain参数用于访问后续过滤器。
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器----Web服务器每次在调用web资源的service方法之前，都会先调用一下filter的doFilter方法");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //Filter对象创建后会驻留在内存，当web应用移除或服务器停止时才销毁。
    // 在Web容器卸载 Filter 对象之前被调用。
    // 该方法在Filter的生命周期中仅执行一次。在这个方法中，可以释放过滤器使用的资源。
    @Override
    public void destroy() {
        System.out.println("过滤器----在Web容器卸载 Filter 对象之前被调用");
    }
}
