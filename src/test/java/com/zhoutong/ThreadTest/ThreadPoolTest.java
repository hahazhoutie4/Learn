package com.zhoutong.ThreadTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest{



    @BeforeEach
    public void init() {
        System.out.println("init");

    }
    @Test
    public void test() {
        ReentrantLock  lock1 = new ReentrantLock(true);
        new Thread(new RunTest(lock1), "线程1").start();
        new Thread(new RunTest(lock1), "线程2").start();
        new Thread(new RunTest(lock1), "线程3").start();
        new Thread(new RunTest(lock1), "线程4").start();
    }



}
