package vttp.workshop111;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class Application {

	@Bean   // Spring annotation
	public CommonsRequestLoggingFilter log() {   // Configure a method to create an instance of logger
		
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();

	  	logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	
	}
	
	public static void main(String[] args) {
		// SpringApplication.run(Application.class, args);

		SpringApplication app = new SpringApplication(Application.class);		// instantiate

		String port = "8080";
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);    // Parse the command line arguments
			
		if (cliOpts.containsOption("port")) {
			port = cliOpts.getOptionValues("port").get(0); // get the first value (Get value of port if it is set from command line)
		}

		// Set the port to listen before starting the application
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);     // Start application

	}

}
