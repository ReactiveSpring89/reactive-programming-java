package com.reactive.assignments.sec03;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class EmitCountryUsingSynchronousSink {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting " + country);

            synchronousSink.next(country);

            atomicInteger.incrementAndGet();
            
            if(country.toLowerCase().equals("canada") || atomicInteger.get() >= 10 ) {
                synchronousSink.complete();
            }

        }).subscribe(Util.subscriber());
    }
}
