package com.reactive.sec01;

import com.reactive.utils.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> stringMono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1);

        stringMono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
