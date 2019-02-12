package com.javainuse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="...package name...")
@EnableWebMvc

public class MvcConfiguration extends WebMvcConfigurerAdapter{

  @Bean
  public InternalResourceViewResolver viewResolver() {

     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
     viewResolver.setPrefix("WEB-INF/jsp/");
     viewResolver.setSuffix(".html");

   return viewResolver;
}
}