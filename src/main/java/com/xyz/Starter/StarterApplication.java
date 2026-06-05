package com.xyz.Starter;

import com.xyz.Starter.Rest.StarterRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Marks this as the main Spring Boot application class.
// Enables component scanning, autoconfiguration, and configuration support.
public class StarterApplication implements CommandLineRunner {

	/*
	 * Dependency Injection
	 *
	 * Spring will automatically inject the StarterRest bean
	 * through the constructor.
	 *
	 * Constructor Injection is the recommended approach because:
	 * 1. Dependencies can be marked final.
	 * 2. Makes the dependency mandatory.
	 * 3. Easier to test.
	 */

	private final StarterRest starterRest;

	// Constructor Injection
	public StarterApplication(StarterRest starterRest) {
		this.starterRest = starterRest;
	}

	/*
	 * Alternative: Field Injection (Not Recommended)
	 *
	 * @Autowired
	 * private StarterRest starterRest;
	 *
	 * Spring injects the dependency directly into the field.
	 * Constructor injection is generally preferred.
	 */

	public static void main(String[] args) {

		// Creates the ApplicationContext (IoC Container)
		// Scans for beans and starts the Spring Boot application.
		SpringApplication.run(StarterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// This method runs automatically after the application starts.

		System.out.println("Application Started Successfully");

		// Example usage of injected bean
		// starterRest.someMethod();
	}
}