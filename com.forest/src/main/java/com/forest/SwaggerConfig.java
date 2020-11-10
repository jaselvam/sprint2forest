package com.forest;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.ant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() 
	{
		String groupName="Admin Access";
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(pathsToBeDocumented()).build().groupName(groupName);
	}
	
	@SuppressWarnings("unchecked")
	private Predicate<String> pathsToBeDocumented() {
		return or(ant("/Admin/**"));
	}
	
	@Bean
	public Docket apii() {
		String groupName="User Access";
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(pathsToBeDocument()).build().groupName(groupName);
	}
	@SuppressWarnings("unchecked")
	private Predicate<String> pathsToBeDocument(){
		return or(ant("/User/**"));
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Admin API").description("Forest Management REST API").license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
	}
	
}
