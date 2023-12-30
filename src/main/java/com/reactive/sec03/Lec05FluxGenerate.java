package com.reactive.sec03;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
            synchronousSink.complete();
        }).take(3).subscribe(Util.subscriber());
    }
}
