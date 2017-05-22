package com.example.rxjava.wineclient.repository;

import com.example.rxjava.wineclient.model.Wine;
import io.reactivex.Flowable;
import org.springframework.data.repository.reactive.RxJava2SortingRepository;

public interface WineRepository extends RxJava2SortingRepository<Wine, Integer> {

    Flowable<Wine> findByType(String type);
    Flowable<Wine> findByAppelation(String appelation);

}
