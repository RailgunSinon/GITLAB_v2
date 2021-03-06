package com;

import org.junit.Test;
import prepare.util.Util;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

/**
 * Created by Admin on 8/6/2018.
 */
public class AppTestThreadState {

    /**
     * Fill in the gaps and insert instructions to make code executable
     *
     * @throws InterruptedException
     */
    @Test
    public void testThreadState() throws InterruptedException {
        // TODO: change instantiation
        Thread thread1 = createThread(() -> {
            while(true){
                int i = 0;
            }
        });
        Thread thread2 = createThread(() -> {
            while(true){
                int i = 0;
            }
        });

        assertEquals(thread1.getState(), Thread.State.NEW);
        assertEquals(thread2.getState(), Thread.State.NEW);

        thread1.start();
        thread2.start();

        assertEquals(thread1.getState(), Thread.State.RUNNABLE);
        assertEquals(thread2.getState(), Thread.State.RUNNABLE);

        // Add delay if necessary
        // TODO: fill the gap

        thread1.interrupt();
        thread2.interrupt();

       Thread thread5 = createThread(() -> {
            try {
                sleep(10000);
            } catch (InterruptedException e) {

            }
        });
        Thread thread6= createThread(() -> {
            try {
                sleep(10000);
            } catch (InterruptedException e) {

            }
        });

        thread5.start();
        thread6.start();
        Thread.sleep(100);
        // threads should run task to be put on hold
        assertEquals(thread5.getState(), Thread.State.TIMED_WAITING);
        assertEquals(thread6.getState(), Thread.State.TIMED_WAITING);
        assertEquals(Thread.currentThread().getState(), Thread.State.RUNNABLE);

        thread1.interrupt();
        thread2.interrupt();

    }

    private Thread createThread() {
        final Thread thread = new Thread();
        return thread;
    }

    private Thread createThread(Runnable runnable) {
        final Thread thread = new Thread(runnable);
        return thread;
    }

}
