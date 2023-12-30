package com.reactive.sec03;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFixed {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            int counter = 0;
            do {
                country = Util.faker().country().name();
                System.out.println("Emitting country : " + country + " counter : " + counter);
                fluxSink.next(country);
                counter++;
            } while(!country.toLowerCase().equals("canada") && !fluxSink.isCancelled()
            && counter < 10);

            fluxSink.complete();
        }).take(3).subscribe(Util.subscriber("CountrySubscriber"));
    }
}
