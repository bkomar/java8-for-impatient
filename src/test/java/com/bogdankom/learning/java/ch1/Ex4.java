package com.bogdankom.learning.java.ch1;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Given an array of File objects, sort it so that the directories come before the
 * files, and within each group, elements are sorted by path name. Use a lambda
 * expression, not a Comparator.
 */
public class Ex4 {

    private final static String DIR_TO_LIST = ".";

    @Test
    public void testListAndSort() {
        File someDir = new File(DIR_TO_LIST);
        Arrays.stream(someDir.listFiles()).sorted((f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory() || f1.isHidden() || f2.isHidden()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.compareTo(f2);
            }
        }).forEach(System.out::println);
    }
}