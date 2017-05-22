package com.example.rxjava.wineclient.service;

import com.example.rxjava.wineclient.model.Wine;
import com.example.rxjava.wineclient.repository.WineRepository;
import io.reactivex.Flowable;
import org.springframework.stereotype.Service;

@Service
public class WineService {

    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public Flowable<Wine> getByType(String type) {
        return wineRepository.findByType(type);
    }

    public Flowable<Wine> getByAppelation(String appelation) {
        return wineRepository.findByAppelation(appelation);
    }

}
