package com.reactive.sec04;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 99)
                .subscribe(Util.subscriber());

    }
}
