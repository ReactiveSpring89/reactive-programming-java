package com.reactive.sec02;

import com.reactive.sec02.helper.NameGenerator;
import com.reactive.utils.Util;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);

        NameGenerator.getNamesFlux(5)
                .subscribe(Util.onNext());

    }
}
