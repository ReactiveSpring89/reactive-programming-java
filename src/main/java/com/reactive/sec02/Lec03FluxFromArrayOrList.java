package com.reactive.sec02;

import com.reactive.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "c");

        Flux.fromIterable(stringList)
                .subscribe(Util.onNext());

        Integer[] arr = {11,22,33,44};

        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}
