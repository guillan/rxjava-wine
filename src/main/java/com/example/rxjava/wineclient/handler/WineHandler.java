package com.example.rxjava.wineclient.handler;

import com.example.rxjava.wineclient.model.Wine;
import com.example.rxjava.wineclient.service.WineService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class WineHandler {

    private final WineService wineService;

    public WineHandler(WineService wineService) {
        this.wineService = wineService;
    }


    public Mono<ServerResponse> getByType(ServerRequest request) {
        return ok()
                .contentType(TEXT_EVENT_STREAM)
                .body(RxJava2Adapter.flowableToFlux(wineService.getByType(request.pathVariable("type"))), Wine.class);
    }

    public Mono<ServerResponse> getByAppelation(ServerRequest request) {
        return ok()
                .contentType(TEXT_EVENT_STREAM)
                .body(RxJava2Adapter.flowableToFlux(wineService.getByAppelation(request.pathVariable("appelation"))), Wine.class);
    }

}
