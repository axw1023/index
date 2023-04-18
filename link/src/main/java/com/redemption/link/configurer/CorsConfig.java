package com.redemption.link.configurer;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.core.Ordered;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.filter.CorsFilter;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration

public class CorsConfig implements WebMvcConfigurer {


  @Override

  public void addCorsMappings(CorsRegistry registry) {

    registry.addMapping("/**")

        .allowedOriginPatterns("*")

        .allowedMethods("GET", "POST", "PUT", "DELETE")

        .allowedHeaders("*")

        .allowCredentials(true)

        .maxAge(3600)

        .exposedHeaders("Authorization");

  }



//  如果在服务端加上了@CrossOrigin注解或其他CORS配置，但是前端仍然报跨域错误，可能是因为浏览器默认发送的是一个带有OPTIONS方法的预检请求。预检请求的目的是为了检查实际请求是否安全，以及服务器是否愿意接受实际请求。
//  如果服务器没有正确处理预检请求，会导致浏览器拒绝实际请求，从而报跨域错误。为了解决这个问题，可以在服务器端配置支持预检请求的响应头
//  下面的配置中，我们不仅允许了所有来源的跨域请求，还配置了支持预检请求的响应头，包括Access-Control-Allow-Origin、Access-Control-Allow-Methods、Access-Control-Allow-Headers、Access-Control-Allow-Credentials、Access-Control-Max-Age和Access-Control-Expose-Headers。在最后一个配置中，我们通过FilterRegistrationBean注册了一个全局的CORS过滤器，以确保所有请求都能正确处理CORS问题。



  @Bean

  public FilterRegistrationBean<CorsFilter> corsFilter() {

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

    CorsConfiguration config = new CorsConfiguration();

    config.addAllowedOriginPattern("*");

    config.addAllowedHeader("*");

    config.addAllowedMethod("*");

    config.setAllowCredentials(true);

    config.setMaxAge(3600L);

    source.registerCorsConfiguration("/**", config);

    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

    return bean;

  }

}


