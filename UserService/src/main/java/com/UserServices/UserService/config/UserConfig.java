package com.UserServices.UserService.config;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.client.RestTemplate;



	
	
	@Configuration
	public class UserConfig {
		
		@Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
//		}
//		@Bean
//	    public Docket api() { 
//	        return new Docket(DocumentationType.SWAGGER_2)  
//	          .select()                                  
//	          .apis(RequestHandlerSelectors.any())              
//	          .paths(PathSelectors.any())                          
//	          .build();                                           
//	    }
		
		
//		@Bean
//		public OpenAPI customOpenAPI() {
//			return new OpenAPI()
//					.info(new Info()) ;
//		}
	}



