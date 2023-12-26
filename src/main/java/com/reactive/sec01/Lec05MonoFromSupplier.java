package com.reactive.sec01;

import com.reactive.utils.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        //Mono<String> stringMono = Mono.just(getName());

        Mono<String> stringMono = Mono.fromSupplier(Lec05MonoFromSupplier::getName);
        stringMono.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = Lec05MonoFromSupplier::getName;
        Mono<String> stringMono1 = Mono.fromCallable(stringCallable);
        stringMono1.subscribe(
            Util.onNext()
        );
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
