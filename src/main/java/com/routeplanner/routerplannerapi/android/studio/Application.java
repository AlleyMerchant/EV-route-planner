package com.routeplanner.routerplannerapi.android.studio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.routeplanner.routerplannerapi.android.studio"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//endpoints to expose
//Login
//Logout
//save route
//fetch route
