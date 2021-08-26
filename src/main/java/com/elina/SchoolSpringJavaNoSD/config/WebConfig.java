package com.elina.SchoolSpringJavaNoSD.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan({"com.elina.SchoolSpringJavaNoSD"})
public class WebConfig implements WebMvcConfigurer {

}
