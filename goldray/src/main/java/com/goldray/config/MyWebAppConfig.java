package com.goldray.config;

import com.goldray.backend.interceptor.CheckPrivilegeInterceptor;
import com.goldray.backend.interceptor.FileUploadInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zwb on 2017/3/12.
 */
@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {
    @Value("${custom.imgMaxSize}")
    private long imgMaxSize;

    @Value("${custom.videoMaxSize}")
    private long videoMaxSize;

    @Value("${custom.ch.webfilesDir}")
    private String ch_webfilesDir;

    @Value("${custom.rl.webfilesDir}")
    private String rl_webfilesDir;

    @Value("${custom.includeUri}")
    private String includeUri;

    /**
     * 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        FileUploadInterceptor fui = new FileUploadInterceptor();
        CheckPrivilegeInterceptor cpi = new CheckPrivilegeInterceptor();
        fui.setImgMaxSize(imgMaxSize);
        fui.setVideoMaxSize(videoMaxSize);
        registry.addInterceptor(cpi).addPathPatterns(includeUri.split(","));//权限拦截
        registry.addInterceptor(fui).addPathPatterns("/backend/**");//文件上传拦截器
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(ch_webfilesDir).addResourceLocations("file:" + rl_webfilesDir);
    }
}
