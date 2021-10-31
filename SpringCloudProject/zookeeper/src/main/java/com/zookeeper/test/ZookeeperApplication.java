package com.zookeeper.test;


import org.apache.zookeeper.*;
import org.junit.Test;

import java.io.IOException;

public class ZookeeperApplication {

    @Test
    public void test() throws IOException, InterruptedException, KeeperException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.10.99:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                watchedEvent.getType();
                System.out.println("触发"+watchedEvent.getType());
            }
        });
//        String zook = zooKeeper.create("/zook", "zeng".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(zook);

        String zook1 = zooKeeper.create("/zook/children", "zengValues".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(zook1);
    }
}
