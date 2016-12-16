package com.bogdankom.learning.java.ch1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
    Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
    write a method that returns all subdirectories of a given directory. Use a
    lambda expression instead of a FileFilter object. Repeat with a method
    expression.
 */
public class Ex2 {

    private final static String DIR_TO_LIST = ".";

    @Test
    public void litDirs_withFileFilter() throws IOException {
        File someDir = new File(DIR_TO_LIST);
        Arrays.stream(someDir.listFiles((file) -> file.isDirectory())).forEach(System.out::println);
    }

    @Test
    public void litDirs2() throws IOException {
        Files.list(Paths.get(DIR_TO_LIST)).filter(Files::isDirectory).forEach(System.out::println);
    }
}
