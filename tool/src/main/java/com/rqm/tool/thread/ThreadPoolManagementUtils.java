package com.rqm.tool.thread;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class ThreadPoolManagementUtils {

    public static ThreadPoolExecutor getMainThreadPool(){
        return ThreadPoolExecutor.newThreadPool("mainThreadPool",5, 200,100, 60);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1
        ThreadPoolManagementUtils.getMainThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
            }
        });
        // 2
        List<Future<Integer>> futures =new ArrayList<Future<Integer>>();
        futures.add(ThreadPoolManagementUtils.getMainThreadPool().submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 0;
            }
        }));
        if (CollectionUtils.isNotEmpty(futures)){
            for (Future future : futures){
                future.get();
            }
        }
        // 3
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "future1";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "future2";
            }
        });
        CompletableFuture<String> result = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String t, String u) {
                return t+" "+u;
            }
        });
    }
}
