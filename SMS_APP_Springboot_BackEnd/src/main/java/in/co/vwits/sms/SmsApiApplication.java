package in.co.vwits.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SmsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsApiApplication.class, args);
	}
	
	//CORS CONFIGURATION
	@Bean
	public WebMvcConfigurer get() {
		WebMvcConfigurer c = new WebMvcConfigurer() {
			
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
				//to do need to improve configuration
			}
		
		};
	return c;
	}
}