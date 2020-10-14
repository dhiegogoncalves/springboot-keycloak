package com.project.webclient;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;

@SpringBootApplication
public class WebclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclientApplication.class, args);
	}

}

@Component
@AllArgsConstructor
class Runner implements ApplicationRunner {

	WebClient WebClient;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		WebClient.get().uri("http://localhost:8080/status").retrieve().bodyToMono(String.class)
				.subscribe(System.out::print);
	}
}