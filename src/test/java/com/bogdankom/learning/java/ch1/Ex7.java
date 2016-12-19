package com.bogdankom.learning.java.ch1;

import org.junit.Test;

/**
 * Write a static method andThen that takes as parameters two Runnable instances
 * and returns a Runnable that runs the first, then the second. In the main method,
 * pass two lambda expressions into a call to andThen, and run the returned
 * instance.
 */
public class Ex7 {

    @Test
    public void testRunnables() {
        new Thread(andThen(
                () -> System.out.println("Running in the first thread"),
                () -> System.out.println("Running in the second thread")
        )).start();
    }

    static Runnable andThen(Runnable run1, Runnable run2) {
        return () -> {
            new Thread(run1).start();
            new Thread(run2).start();
        };
    }

}
