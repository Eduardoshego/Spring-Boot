package br.ueg.appDisciplina.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	public Docket apiDoc() {
		return new Docket( DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.ueg.appDisciplina.controller"))
				.build().apiInfo(metaData());
	}
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("​Projeto Planos de Ensino").description("Projeto para disciplina de Prog. III")
				.version("0.0.1")
				.contact(new Contact("Eduardo", "ueg.br/si/eduardo","eduardoshego1@gmail.com")).license("Apache License version 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
}
