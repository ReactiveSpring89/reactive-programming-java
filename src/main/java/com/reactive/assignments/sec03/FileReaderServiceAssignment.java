package com.reactive.assignments.sec03;

import com.reactive.utils.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderServiceAssignment {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");

        fileReaderService.read(path)
                .take(20)
                .subscribe(Util.subscriber());
    }
}
