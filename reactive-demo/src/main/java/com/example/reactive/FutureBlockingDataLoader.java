package com.example.reactive;

import java.util.concurrent.*;

/**
 * 并行场景，但是需要上一个请求的结果，约等于阻塞
 * @author ziwing
 * @date 2021/3/29
 */
public class FutureBlockingDataLoader extends DataLoader{

    public void doLoad(){
        // 创建具有3个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        runCompletely(executorService.submit(super::loadConfigurations));
        runCompletely(executorService.submit(super::loadUsers));
        runCompletely(executorService.submit(super::loadOrders));
        executorService.shutdown();
    }

    private void runCompletely(Future<?> future){

        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }

}
