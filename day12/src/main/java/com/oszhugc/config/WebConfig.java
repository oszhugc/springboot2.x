package com.oszhugc.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Administrator on 2019\3\6 0006.
 */
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //使得"/login/page"映射为"login.jsp"
        registry.addViewController("/login/page").setViewName("login");
        //使得/logout/page映射为logout_welcome.jsp
        registry.addViewController("/logout/page").setViewName("logout_welcome");
        //使得/logout映射logout.jsp
        registry.addViewController("/logout").setViewName("logout");
    }

}
