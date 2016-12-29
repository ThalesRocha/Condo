package br.com.haka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.haka")
public class CondoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CondoApplication.class, args);
	}
}
