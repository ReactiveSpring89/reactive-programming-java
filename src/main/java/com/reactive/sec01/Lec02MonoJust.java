package com.reactive.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<Integer> integerMono = Mono.just(1);
        System.out.println(integerMono);

        integerMono.subscribe(i -> System.out.println("Received : " + i));
    }
}
