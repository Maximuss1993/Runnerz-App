package dev.maximus.runnerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//@Bean
	//CommandLineRunner runner(RunRepository runRepository) {
	//	return args->{
		//	Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), 5, Location.INDOOR);
			//runRepository.create(run);
		//};
		
	//}

	

}
