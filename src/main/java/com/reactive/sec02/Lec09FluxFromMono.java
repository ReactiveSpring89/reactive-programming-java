package com.reactive.sec02;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Mono<String> stringMono = Mono.just("a");

        Flux<String> stringFlux = Flux.from(stringMono);

        stringFlux.subscribe(
                Util.onNext()
        );

        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next()
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


    }
}
