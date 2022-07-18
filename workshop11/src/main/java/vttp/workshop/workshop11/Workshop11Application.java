package vttp.workshop.workshop11;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop11Application {

	public static void main(String[] args) {
		// SpringApplication.run(Workshop11Application.class, args);

		SpringApplication app = new SpringApplication(Workshop11Application.class);

		String port = "3000";	// default port
		ApplicationArguments input = new DefaultApplicationArguments(args);

		if (input.containsOption("port")) {
			port = input.getOptionValues("port").get(0);
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);
	}

}
