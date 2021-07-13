package com.example.rest.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.rest.controller"))
				.paths(PathSelectors.regex("/api.*"))
				.build().apiInfo(getMyApiInfo());
	}
	
	public ApiInfo getMyApiInfo() {
		return new ApiInfo("REST Api Documentation for CRUD Application", // title
							"This is simple CRUD app using Rest service and MySQL database.",	//description
							"0.0.1-SNAPSHOT",	// version
							null, //Terms of Service URL 
							new Contact("Pravin", null, "pravinssdabhade@gmail.com"), //developer contact 
							null, //license provider name
							null,	//license URL
							Collections.emptyList());	//client names
	}
	
//	Swagger Annotations:
//		a. @ApiOperation : For a method in Restcontroller, provide alias name
//
//		b. @Api : For a RestController class, provide alias name
//
//		c. @ApiIgnore : To avoid a class/method display at swagger
//
//
//		*) To avoid Swagger in Production or any environment, use profiles
//				@Profile({"default","qa"})
}
