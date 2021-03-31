package com.example.reactive;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟并行场景
 * @author ziwing
 * @date 2021/3/29
 */
public class ParallelDataLoader extends DataLoader{

    public void doLoad(){
        // 创建具有3个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);
        completionService.submit(super::loadConfigurations, null);
        completionService.submit(super::loadUsers, null);
        Future<Object> submit = completionService.submit(super::loadOrders, null);

        int count = 0;
        while (count < 3){
            if (completionService.poll() != null){
                count++;
            }
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new ParallelDataLoader().load();
    }

}
