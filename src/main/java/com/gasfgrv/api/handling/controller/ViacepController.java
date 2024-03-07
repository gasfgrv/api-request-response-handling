package com.gasfgrv.api.handling.controller;

import com.gasfgrv.api.handling.client.ViacepClient;
import com.gasfgrv.api.handling.dto.ViacepResponse;
import com.gasfgrv.api.handling.response.Response;
import com.gasfgrv.api.handling.response.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/v1/cep")
public class ViacepController {

    private final ViacepClient client;

    public ViacepController(ViacepClient client) {
        this.client = client;
    }

    @GetMapping
    public ResponseEntity<Response<ViacepResponse>> getCep(@RequestParam String cep) {
        CompletableFuture<ResponseEntity<ViacepResponse>> future = client.chamarApi(cep);
        return ResponseEntity.ok(new ResponseBuilder<ViacepResponse>()
                        .addData(future.join().getBody())
                        .build());
    }

}
