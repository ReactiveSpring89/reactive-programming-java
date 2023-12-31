package com.reactive.sec03;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());
    }
}
