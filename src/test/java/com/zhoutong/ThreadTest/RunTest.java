package com.zhoutong.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

public class RunTest implements Runnable{

    private ReentrantLock lock;

    private static int count = 120;

    public RunTest(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        IO:
        while(true) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "正在运行,count:" + count);
            if(count > 0) {
                count--;
            }else{
                break IO;
            }
            lock.unlock();
        }
    }
}
