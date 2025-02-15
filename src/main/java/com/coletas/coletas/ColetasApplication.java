package com.coletas.coletas;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.coletas.coletas.config.BuildInfo;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ColetasApplication {

	public static void main(String[] args) {
		BuildInfo.printBuildDetails();
		
		String port = System.getenv("PORT");
		if (port == null || port.isEmpty()) {
			port = "8080";
		}
		int portNumber = Integer.parseInt(port);
		SpringApplication app = new SpringApplication(ColetasApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		app.run(args);
	}
	

}
