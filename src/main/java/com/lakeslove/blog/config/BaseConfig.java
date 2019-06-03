package com.lakeslove.blog.config;

import java.io.File;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.AbstractServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ImportResource(
    {
        "classpath:xml/spring_context.xml",
        "classpath:xml/springmvc_context.xml"
    }
)
public class BaseConfig {

//    @Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/templates/views");
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);
//        return viewResolver;
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        return new TilesViewResolver();
//    }
//    @Bean
//    public TilesConfigurer tilesConfigurer(){
//        TilesConfigurer tiles = new TilesConfigurer();
//        tiles.setDefinitions("classpath:xml/tiles.xml");//这里的路径可以是固定路径名，也可以时模糊匹配
//        tiles.setCheckRefresh(true);
//        return tiles;
//    }

    @Bean
    public AbstractServletWebServerFactory embeddedServletContainerFactory() {

        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setDocumentRoot(
            new File("/Users/lakeslove/workspace/workspace2/blogtest/springboot/blog/src/main/resources"));
        return  tomcatServletWebServerFactory;
    }
}
