package com.reactive.sec03;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
//        Flux.create(fluxSink -> {
//            for(int i = 0; i < 10; i++) {
//                fluxSink.next(i);
//            }
//            fluxSink.complete();
//        }).subscribe(Util.subscriber());

        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while(!country.toLowerCase().equals("canada"));

            fluxSink.complete();
        }).subscribe(Util.subscriber("CountrySubscriber"));
    }
}
