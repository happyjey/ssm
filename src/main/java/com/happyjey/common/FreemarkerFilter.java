package com.happyjey.common;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Freemarker配全SiteMesh时的过滤器
 * -----------------------------------------------
 * 为sitemesh的装饰器页面做Freemarker标签解析
 * -----------------------------------------------
 */
public class FreemarkerFilter implements Filter {
    private Locale locale;

    private ApplicationContext ctx;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String localeStr = filterConfig.getInitParameter("locale");
        if(StringUtils.hasText(localeStr)){
            locale = new Locale(localeStr);
        }else {
            locale = Locale.getDefault();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        if(ctx == null){
            /**
             * 使用：ctx = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());
             * 会报异常：NoSuchBeanDefinitionException: No qualifying bean of type [org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver] is defined
             * 原因：
             * 1. ctx获取的是ContextLoaderListener的根WebApplicationContext即根上下文
             * 2. 而后面程序使用ctx根上下文去加载定义在DispatcherServlet私有上下文中的Bean（FreeMarkerViewResolver）,如下：
             *      FreeMarkerViewResolver viewResolver = ctx.getBean(FreeMarkerViewResolver.class);
             * 3. 根上下文是私有上下文的parent上下文，即（私有上下文可以加载定义在根上下文中的Bean，反过来则不行）
             * 方案：
             *      cxt需要使用DispatcherServlet私有上下文。
             */
            ctx = RequestContextUtils.getWebApplicationContext(req);
            if(null == ctx){
                throw new ExceptionInInitializerError("spring context is not loaded!");
            }
        }
        try {
            String name = req.getRequestURI();
            name = name.substring(1, name.lastIndexOf(".ftl"));
            FreeMarkerViewResolver viewResolver = ctx.getBean(FreeMarkerViewResolver.class);
            System.out.println("zzz:"+name);
            System.out.println("zzz:"+locale);
            System.out.println("zzz:"+viewResolver);
            View view = viewResolver.resolveViewName(name, locale);
            System.out.println("zzz:"+view);
//            @SuppressWarnings("unchecked")
//            Map<String, Object> model = (Map<String, Object>) request.getAttribute(ViewRendererServlet.MODEL_ATTRIBUTE);
            view.render(null, req, res);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
