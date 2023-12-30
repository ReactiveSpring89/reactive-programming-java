package com.reactive.sec03;

import com.reactive.sec03.helper.NameProducer;
import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(3);

    }
}
