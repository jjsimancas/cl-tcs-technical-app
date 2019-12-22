package cl.tcs.technical.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ClTcsTechnicalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClTcsTechnicalAppApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("cl.tcs.technical.app.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Prueba Tecnica TCS",
				"Prueba tecnica desarrollada en Spring para optar a cargo de desarrollador",
				"API TCS",
				"Teminos de Servicio",
				new Contact("Juan Simancas", "https://www.linkedin.com/in/juan-simancas-03636a32/",
						"jjsimancas@gmail.com	"),
				"License of API", "API license URL", Collections.emptyList());
	}

}
