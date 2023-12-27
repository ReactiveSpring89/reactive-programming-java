package com.reactive.sec02;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(3, 10)
                .subscribe(
                        Util.onNext()
                );

        String name = "Tanaya";

        Flux.range(1, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .subscribe(System.out::println);
    }
}
