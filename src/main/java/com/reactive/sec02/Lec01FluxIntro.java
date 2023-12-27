package com.reactive.sec02;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> integerFlux = Flux.just(1, 2, 3, 4, "a", Util.faker().name().fullName());

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}
