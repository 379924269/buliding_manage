package com.dnp.bulidingmanage.common.config;

import com.dnp.bulidingmanage.common.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册拦截器
 * @Author 华仔
 * @Author 2017/10/16 10:02
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：除了login，其他都拦截判断
        String excludePathPatterns[] = {"/manager/login", "/manager/notLogin", "/swagger-resources/**", "/"};
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        registry.addResourceHandler("/swagger-resources/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/swagger-resources/");
    }
}
