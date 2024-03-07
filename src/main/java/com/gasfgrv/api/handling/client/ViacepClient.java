package com.gasfgrv.api.handling.client;


import com.gasfgrv.api.handling.dto.ViacepResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Component
public class ViacepClient {

    private final RestTemplate restTemplate;

    public ViacepClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<ResponseEntity<ViacepResponse>> chamarApi(String cep) {
        String url = "https://viacep.com.br/ws/%s/json/".formatted(cep);
        return CompletableFuture.supplyAsync(() -> restTemplate.getForEntity(url, ViacepResponse.class));
    }

}
