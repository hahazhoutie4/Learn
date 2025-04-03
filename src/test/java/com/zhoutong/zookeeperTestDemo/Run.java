package com.zhoutong.zookeeperTestDemo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

class Run implements Runnable{
    public static int count =100;
    private InterProcessLock lock;
    private CuratorFramework client;

    public Run(CuratorFramework client){
        this.client = client;
        lock = new InterProcessMutex(client,"/lock");
    }

    @Override
    public void run() {
        while(true){
            try {
                lock.acquire(6L, TimeUnit.SECONDS);
                client.setData().forPath("/test2",(Thread.currentThread().getName()+"设置数据"+ System.currentTimeMillis()).getBytes()); //当前线程设置的数据
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    lock.release();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}