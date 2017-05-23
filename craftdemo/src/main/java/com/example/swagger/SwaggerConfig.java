package com.example.swagger;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.HeapdumpMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.ShutdownMvcEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;
import com.example.controller.CraftDemoEndPoint;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

   @Bean
   public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
            .groupName("Application API")
            .select()
            .apis(RequestHandlerSelectorsExt.withAppInterface())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .directModelSubstitute(LocalDate.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class);
   }

   @Bean
   public UiConfiguration uiConfig() {
      return UiConfiguration.DEFAULT;
   }

   private ApiInfo apiInfo() {
      return new ApiInfoBuilder()
            .title("Verizon Wireless - Jitr Automated Security API")
            .description("Jitr Automated Security API")
            .version("2.0 on ")
            .contact("dhanunjayudu@gmail.com")
            .build();
   }

   @Bean
   public Docket actuator() {
      return new Docket(DocumentationType.SWAGGER_2)
            .groupName("Spring Boot Actuator").select()
            .apis(RequestHandlerSelectorsExt.withInterface())
            .paths(PathSelectors.any())
            .build();
   }

   static class RequestHandlerSelectorsExt {
      public static Predicate<RequestHandler> withInterface() {
         return new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
               return (declaringClass(input) == EndpointMvcAdapter.class)
                     || (declaringClass(input) == EnvironmentMvcEndpoint.class)
                     || (declaringClass(input) == HealthMvcEndpoint.class)
                     || (declaringClass(input) == HeapdumpMvcEndpoint.class)
                     || (declaringClass(input) == MetricsMvcEndpoint.class)
                     || (declaringClass(input) == ShutdownMvcEndpoint.class);
            }
         };
      }

      public static Predicate<RequestHandler> withAppInterface() {
         return new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
               return declaringClass(input) == CraftDemoEndPoint.class;
            }
         };
      }

      private static Class<?> declaringClass(RequestHandler input) {
         return input.getHandlerMethod().getMethod().getDeclaringClass();
      }
   }
}
