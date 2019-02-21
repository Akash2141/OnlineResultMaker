package com.OnlineResult.Configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	private static final String SWAGGER_API_VERSION="1.0";
	private static final String title="Online Result Makers";
	private static final String description = "Online Result will be provided....";
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.version(SWAGGER_API_VERSION)
				.build();
		
	}
	
	@Bean
	public Docket productAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.OnlineResult.Controller"))
				.paths(regex("/TeacherData.*"))
				.build();
	}


}
