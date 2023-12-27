package com.reactive.assignments.sec01;

import com.reactive.utils.Util;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("files03.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("files03.txt", "This is file3")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.delete("files03.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
