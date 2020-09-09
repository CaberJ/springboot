package cn.caber.caberspringbootstudy.filter;


import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@Order(1)//@Order注解表示执行过滤顺序，值越小，越先执行
@ServletComponentScan//这个使用来扫描@WebFilter 的让@WebFilter起作用,加载入口类上时，可扫描项目下全部的filter
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter  初始化了");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("访问了");
        System.out.println("Remote Host:"+servletRequest.getRemoteHost());
        System.out.println("Remote Address:"+servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("访问完了，要返回了");

    }

    @Override
    public void destroy() {

    }
}
