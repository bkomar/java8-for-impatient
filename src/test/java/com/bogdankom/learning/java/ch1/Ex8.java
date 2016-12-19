package com.bogdankom.learning.java.ch1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * What happens when a lambda expression captures values in an enhanced
 * for loop such as this one?
 */
public class Ex8 {

    @Test
    public void testClosure() {
        String[] names = { "Peter", "Paul", "Mary" };
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        runners.forEach(r -> new Thread(r).start());

        List<Runnable> runners1 = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners1.add(() -> System.out.println(name));
        }
        runners1.forEach(r -> new Thread(r).start());
    }
}
