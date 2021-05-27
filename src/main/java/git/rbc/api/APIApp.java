package git.rbc.api;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
//@EnableResourceServer
public class APIApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(APIApp.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "9092"));
		app.run(args);
	}

}