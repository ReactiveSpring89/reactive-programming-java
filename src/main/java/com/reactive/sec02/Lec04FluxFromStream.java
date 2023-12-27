package com.reactive.sec02;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6);
        Stream<Integer> stream = list.stream();

        //Flux<Integer> streamFlux = Flux.fromStream(stream);
        Flux<Integer> streamFlux = Flux.fromStream(list::stream);

        streamFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        streamFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
