package com.bogdankom.learning.java.ch1;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArraySet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
    Is the comparator code in the Arrays.sort method called in the same thread as
    the call to sort or a different thread?
 */
public class Ex1 {

    private String content;
    private CopyOnWriteArraySet threadIds = new CopyOnWriteArraySet();
    private String[] toBeSorted;
    private Comparator<String> comparator;

    @Before
    public void setUp() throws URISyntaxException, IOException {
        content = new String(Files
                .readAllBytes(Paths.get(ClassLoader.getSystemResource("forSorting.txt").toURI())));
        threadIds.clear();
        comparator = (x, y) -> {
            threadIds.add(Thread.currentThread().getName());
            return x.compareTo(y);
        };
        toBeSorted = content.split("\\W+");
    }

    @Test
    public void ex1() {
        Arrays.sort(toBeSorted, comparator);
        Arrays.asList(toBeSorted).stream().forEach(System.out::println);
        //means it is executed in single thread
        assertEquals(1, threadIds.size());
    }

    @Test
    public void ex1_parallelSorting() {
        Arrays.parallelSort(toBeSorted, comparator);
        Arrays.asList(toBeSorted).stream().forEach(System.out::println);
        //means it is executed in single thread
        assertTrue(threadIds.size() > 1);
    }
}
