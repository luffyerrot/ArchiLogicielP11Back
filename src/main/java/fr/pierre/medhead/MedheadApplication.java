package fr.pierre.medhead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MedheadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedheadApplication.class, args);
	}

}
