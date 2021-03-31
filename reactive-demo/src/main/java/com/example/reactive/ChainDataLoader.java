package com.example.reactive;

import java.util.concurrent.CompletableFuture;

/**
 * 并行场景，但是需要上一个请求结果
 * @author ziwing
 * @date 2021/3/29
 */
public class ChainDataLoader extends DataLoader{

    public void doLoad(){
        String msg = "加载成功";
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> {
                    System.out.println("线程: " + Thread.currentThread().getName() + " " + msg);
                })
                .join();
        System.out.println("线程: " + Thread.currentThread().getName() +" --> " + msg);
    }

    public static void main(String[] args) {
        new ChainDataLoader().load();
    }
}
