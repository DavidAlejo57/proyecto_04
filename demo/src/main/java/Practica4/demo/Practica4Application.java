package Practica4.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practica4Application {
	
	@Autowired
	String String;

	public static void main(String[] args) {
		SpringApplication.run(Practica4Application.class, args);
	}
	
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Holi "+String);
	}

}
