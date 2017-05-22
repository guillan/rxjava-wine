package com.example.rxjava.wineclient.controller;

import com.example.rxjava.wineclient.model.Wine;
import com.example.rxjava.wineclient.service.WineService;
import io.reactivex.Flowable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WineController {

    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping(value = "/types/{type}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flowable<Wine> getByType(@PathVariable String type) {
        return wineService.getByType(type);
                //.doOnNext(c -> {Thread.sleep(1000l);});
    }

    @GetMapping(value = "/appelations/{appelation}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flowable<Wine> getByAppelation(@PathVariable String appelation) {
        return wineService.getByAppelation(appelation);
                //.doOnNext(c -> {Thread.sleep(1000l);});
    }
}
