package com.rqm.tool;

import com.rqm.tool.thread.ThreadPoolManagementUtils;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author renqiuming
 * @date 2020/2/11 下午4:25
 */
@SpringBootTest
public class ThreadTest {

    @Test
    public void threadPoolManagementUtilsTest() {
        ThreadPoolManagementUtils.getMainThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run");
            }
        });
    }

    @Test
    public void futureTest() throws ExecutionException, InterruptedException {
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        futures.add(ThreadPoolManagementUtils.getMainThreadPool().submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("thread end");
                return 0;
            }
        }));
        if (CollectionUtils.isNotEmpty(futures)) {
            for (Future future : futures) {
                future.get();
            }
        }
        System.out.println("future end");
    }

    @Test
    public void completableFutureTest() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("future1 end");
                return "future1";
            }
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("future2 end");
                return "future2";
            }
        });
        CompletableFuture<String> result = future1.thenCombine(future2, new BiFunction<String, String, String>() {
            @Override
            public String apply(String t, String u) {
                return t + " " + u;
            }
        });
        System.out.println("CompletableFuture end");
    }

    @Test
    public void futureTaskTest() throws ExecutionException, InterruptedException {
        Callable<String> aCallable = () -> {
            System.out.println("A task start");
            Thread.sleep(5000);
            System.out.println("A task end");

            return "A task return";
        };
        Callable<String> bCallable = () -> {
            System.out.println("B task start");
            Thread.sleep(2000);
            System.out.println("B task end");
            return "B task return";
        };
        FutureTask<String> aTask = new FutureTask<>(aCallable);
        FutureTask<String> bTask = new FutureTask<>(bCallable);
        ThreadPoolManagementUtils.getMainThreadPool().submit(aTask);
        ThreadPoolManagementUtils.getMainThreadPool().submit(bTask);
        System.out.println(aTask.get());
        System.out.println(bTask.get());
        System.out.println("test end");
    }
}
