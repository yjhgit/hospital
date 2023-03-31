package com.yayangchun.traditionalchinesemedicinemuseum.configura;


import com.yayangchun.traditionalchinesemedicinemuseum.Interceptor.IndexInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
  注册类中有很多方法,不止能够完成注册拦截器,还有很多其他的东西也可以实现注册
*/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * 被拦截的路径
     */
    String[] addPathPatterns = {
            "/doctor/**",
            "/admin/**",
            "/adminPage/**",
            "/receptionApi/**"
    };
    /**
     * 忽略路径
     */
    String[] excludePathPatterns = {
            "/login/**",
            "/doc/**",
            "/websocket/**",
            "/reception/**",
            "/chat/**"

    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IndexInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
