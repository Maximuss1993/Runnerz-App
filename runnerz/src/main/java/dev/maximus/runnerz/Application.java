package dev.maximus.runnerz;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import dev.maximus.runnerz.user.User;
import dev.maximus.runnerz.user.UserHttpClient;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Application {
	
	//private static final Logger logMessage = LoggerFactory.getLogger(Application.class);
				
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}
	
	@Bean
	CommandLineRunner runner(UserHttpClient client) {
		return args->{
			List<User> users= client.findAll();
			System.out.println(users);
		};
	}
}
