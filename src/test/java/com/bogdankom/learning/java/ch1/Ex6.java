package com.bogdankom.learning.java.ch1;

import org.junit.Test;

/**
 * Didn’t you always hate it that you had to deal with checked exceptions in a
 * Runnable? Write a method uncheck that catches all checked exceptions and turns
 * them into unchecked exceptions. For example,
 * new Thread(uncheck( () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
 * // Look, no catch (InterruptedException)!
 * Hint: Define an interface RunnableEx whose run method may throw any exceptions.
 * Then implement public static Runnable uncheck(RunnableEx runner). Use a
 * lambda expression inside the uncheck function.
 * Why can’t you just use Callable<Void> instead of RunnableEx?
 */
public class Ex6 {

    @Test
    public void testIgnoredEx() {
        new Thread(uncheck(() -> {
                    System.out.println("Inside Thread...");
                }
        )).start();
    }

    public static Runnable uncheck(RunnableEx runnerEx) {
        return () -> {
            try {
                runnerEx.run();
            } catch (Exception ex) {
                //ignore exception
            }
        };
    }
}

@FunctionalInterface
interface RunnableEx {
    void run() throws Exception;
}
