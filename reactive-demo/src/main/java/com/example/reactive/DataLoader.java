package com.example.reactive;

import java.util.concurrent.TimeUnit;

/**
 * 模拟串行(堵塞)场景
 * @author ziwing
 * @date 2021/3/29
 */
public class DataLoader {

    public void load(){
        long start = System.currentTimeMillis();
        doLoad();
        long costTime = System.currentTimeMillis() - start;
        System.out.println("load() 总耗时 " + costTime + " 毫秒");
    }

    public void doLoad(){
        loadConfigurations();
        loadUsers();
        loadOrders();
    }

    /**
     * 模拟第一次加载资源
     */
    public void loadConfigurations(){
        loadMock("loadConfigurations", 1);
    }

    /**
     * 模拟第二次加载资源
     */
    public void loadUsers(){
        loadMock("loadUsers", 2);
    }

    /**
     * 模拟第三次加载资源
     */
    public void loadOrders(){
        loadMock("loadOrders", 3);
    }



    /**
     * 模拟加载事件
     * @param source 执行操作
     * @param seconds 加载事件
     */
    public void loadMock(String source, int seconds){
        try {
            long start = System.currentTimeMillis();
            long millis = TimeUnit.SECONDS.toMillis(seconds);
            Thread.sleep(millis);
            long costTime = System.currentTimeMillis() - start;
            System.out.printf("[线程: %s] %s 耗时: %d 毫秒\n",
                    Thread.currentThread().getName(), source, costTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataLoader().load();
    }


}
