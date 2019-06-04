package com.lakeslove.blog.config;

import com.lakeslove.blog.filter.LoginFilter;
import java.io.File;
import java.io.FileNotFoundException;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.AbstractServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ImportResource(
    {
        "classpath:xml/spring_context.xml"
    }
)
public class BaseConfig {

  /**
   * 配置tomcat的根目录，
   * 因为tomcat默认的跟目录是src下面的webapp/WEB-INF
   * @return
   */
  @Bean
  public AbstractServletWebServerFactory embeddedServletContainerFactory() throws FileNotFoundException {
    TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
    //ResourceUtils.getFile("classpath:")获取的是classes的目录
    File resourcesFile = ResourceUtils.getFile("classpath:xml").getParentFile();
    tomcatServletWebServerFactory.setDocumentRoot(resourcesFile);
    return tomcatServletWebServerFactory;
  }

  @Bean
  public FilterRegistrationBean loginFilter() {
    FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<>();
    registration.setName("loginFilter");
    registration.setFilter(new LoginFilter());
    registration.addUrlPatterns("/manager/*");
    registration.addInitParameter("indexPath", "/login.htm");
    registration.setOrder(1);
    return registration;
  }


  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/templates/views");
    viewResolver.setSuffix(".jsp");
    viewResolver.setViewClass(JstlView.class);
    return viewResolver;
  }

  //tiles 配置开始
  @Bean
  public ViewResolver viewResolver() {
    TilesViewResolver tilesViewResolver = new TilesViewResolver();
    tilesViewResolver.setOrder(1);
    return tilesViewResolver;
  }

  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    tilesConfigurer.setDefinitions("classpath:templates/tiles/tiles.xml");
    tilesConfigurer.setCheckRefresh(true);
    return tilesConfigurer;
  }

  @Bean
  public ResourceBundleMessageSource messageSource(){
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames(
        "message.message_error",
        "message.message_generic",
        "message.message_validate"
    );
    messageSource.setUseCodeAsDefaultMessage(false);
    messageSource.setCacheSeconds(600);
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

}
