package com.reactive.sec03;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec06GenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);

                    if(counter >= 10 || country.toLowerCase().equals("canada")) {
                        sink.complete();
                    }
                    return counter + 1;
                }).take(4).subscribe(Util.subscriber());
    }
}
