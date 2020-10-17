package com.project.webclient.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class WebClientOAuth2Controller {

    private WebClient webClient;

    @GetMapping("external")
    public Mono<String> getExternel() {
        return webClient.get().uri("http://localhost:8080/status").retrieve().bodyToMono(String.class)
                .map(retorno -> "Eu recebi externamente um " + retorno);
    }
}