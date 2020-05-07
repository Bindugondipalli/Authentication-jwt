package me.aboullaite;

import me.aboullaite.config.JwtFilter;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@EnableSwagger2

@SpringBootApplication
public class SpringBootJwtApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}
	
	@Bean
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/Authentication/**"))
				.build()
				
				.apiInfo(new ApiInfo("Vendor API Documentation",
						"A Sample API for Vendors",
						"1.0.0",
						"Shopping is Fun",
						new Contact("Dipesh", "www.dipeshcorporation.com", "dipesh@gmail.com"), 
						"Standard API License",
						"www.dipesh.com",
						Collections.emptyList()));
				
				
	}
}

	
	

