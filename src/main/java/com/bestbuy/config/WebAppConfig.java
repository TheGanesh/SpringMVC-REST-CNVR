package com.bestbuy.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.bestbuy")
public class WebAppConfig extends WebMvcConfigurerAdapter {


  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.
    useJaf(false).
    mediaType("xml", MediaType.APPLICATION_XML).
    mediaType("json", MediaType.APPLICATION_JSON).
    defaultContentType(MediaType.APPLICATION_JSON);
  } 


  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    MappingJacksonHttpMessageConverter jmc = new MappingJacksonHttpMessageConverter();
    jmc.setPrettyPrint(true);
    converters.add(jmc);

    Jaxb2RootElementHttpMessageConverter j2 = new Jaxb2RootElementHttpMessageConverter();
    converters.add(j2);
    return;
  }
  
  
}
