package k1oud.career.wholecareer.concurrency.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockResearch {

    static volatile ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {

        new Thread().setPriority(11);

    }
}
