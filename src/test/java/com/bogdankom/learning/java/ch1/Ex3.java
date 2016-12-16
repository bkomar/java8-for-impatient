package com.bogdankom.learning.java.ch1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * 3. Using the list(FilenameFilter) method of the java.io.File class, write a method
 * that returns all files in a given directory with a given extension. Use a lambda
 * expression, not a FilenameFilter. Which variables from the enclosing scope does
 * it capture?
 */
public class Ex3 {

    private final static String DIR_TO_LIST = ".";
    private final static String FILE_EXT = ".xml";

    @Test
    public void litFilesExt_withFilenameFilter() {
        File someDir = new File(DIR_TO_LIST);
        Arrays.stream(someDir.list((dir, filename) -> filename.endsWith(FILE_EXT))).forEach(System.out::println);
    }
}

