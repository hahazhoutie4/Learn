package com.zhoutong.zookeeperTestDemo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CuratorTest {
    private  CuratorFramework client;
    @BeforeEach
    public  void connect(){
        client = CuratorFrameworkFactory.builder()
                .connectString("192.168.2.17:2181")
                .sessionTimeoutMs(1000)
                .connectionTimeoutMs(1000)
                .retryPolicy(new ExponentialBackoffRetry(3000, 10))
                .namespace("zookeeper")         //默认在/zookeeper下操作
                .build();
        client.start();
    }
    @Test
    public void testCreate() throws Exception {
           String s = client.create().forPath("/test2");   //创建节点，节点默认数据为客户机ip地址
             System.out.println(s);
    }

    @Test
    public void testCreateSetData() throws Exception {
           client.create().forPath("/test2","wocao,hellowrewrwr".getBytes());  //设置数据
    }

    @Test
    public void testCreateSetMode() throws Exception {
        client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/test2","wocao,hellowrewrwr".getBytes());
           while(true){
               Thread.sleep(1000);
          }
    }

    //可以创建多级节点 /test/p1
    @Test
    public void testCreatewithmultikeys() throws Exception {
          client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/test/p1","wocao,hellowrewrwr".getBytes());
        Thread.sleep(12000);
    }
    //获取  /zookeeper/test2的数据
    @Test
    public void testGetData() throws Exception {
        byte[] bytes = client.getData().forPath("/test2");
        System.out.println(new String(bytes));

    }
    //查询   /zookeeper/test2下面的子节点
    @Test
    public void getChildListNode() throws Exception {
        List<String> strings = client.getChildren().forPath("/test2");

    }

    //查询 /zookeeper/test2节点的状态信息   ls -s /zookeeper/test2
    @Test
    public void testgetStatus() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/test2");
        System.out.println(stat);

    }
    //为/zookeeper/test2节点修改数据
    @Test
    public void setDataTest() throws Exception {
        client.setData().forPath("/test2","wocao,hellowrewrwr".getBytes());
    }
    //根据版本查询，防止其他线程操作数据
    //stat获取到的version 是当前节点的版本号
    // withVersion(version)，如果数据版本和version不一致，则无法设置数据
    @Test
    public void testSetByVersion() throws Exception {
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/test2");
        //原子性操作，如果version和数据的版本号不一致，则不会修改数据
        int version = stat.getVersion();
        client.setData().withVersion(version).forPath("/test2","haha".getBytes());
    }
    //注册zookeeper监听器
    //监听节点CHANGE\CREATE\UPDATE事件
    @Test
    public void testWatcher(){
        CuratorCache cache = CuratorCache.build(client, "/test2");
        cache.listenable().addListener((type ,  childData,  childData1)-> {
            System.out.println(type);
            if (type == CuratorCacheListener.Type.NODE_CHANGED){
                System.out.println("节点被修改了");
            }
            if (type == CuratorCacheListener.Type.NODE_CREATED){
                System.out.println("节点被创建了");
            }
            if (type == CuratorCacheListener.Type.NODE_DELETED){
                System.out.println("节点被删除了");
            }
            System.out.println(childData);
            System.out.println(childData1);
        });
        cache.start();
        while(true){
            // 监听节点变化,死循环防止监听器释放资源
        }
    }

    //监听对象拿到锁了
    @Test
    public void testConcurrent(){
        Thread t1 =new Thread(new Run(client),"线程1");
        Thread t2 =new Thread(new Run(client),"线程2");
        t1.start();
        t2.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterEach
    public  void close(){
        client.close();
    }

}
