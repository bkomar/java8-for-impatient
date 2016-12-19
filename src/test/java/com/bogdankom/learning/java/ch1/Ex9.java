package com.bogdankom.learning.java.ch1;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ex9 {

    @Test
    public void testExtended() {
        Collection2<String> extendedColl = new ArrayList2();
        extendedColl.add("some");
        extendedColl.add("somefsss");
        extendedColl.add("some String212");
        extendedColl.add("some String123");

        //prints all strings where value is less than 10
        extendedColl.forEachIf(System.out::println, v -> v.length() < 10);
    }
}

interface Collection2<T> extends Collection<T> {

    default void forEachIf(Consumer<T> consumer, Predicate<T> predicate) {
        forEach(item -> {
            if (predicate.test(item)) {
                consumer.accept(item);
            }
        });
    }
}

class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {

}
