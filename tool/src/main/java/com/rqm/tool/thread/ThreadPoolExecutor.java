package com.rqm.tool.thread;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
public class ThreadPoolExecutor extends ThreadPoolTaskExecutor {
    private static Map<String, ThreadPoolExecutor> poolExecutorMap = new ConcurrentHashMap(12);
    private static Lock lock = new ReentrantLock();

    public ThreadPoolExecutor() {
    }

    public static ThreadPoolExecutor newThreadPool(String name, int coreSize) {
        return newThreadPool(name, coreSize, coreSize);
    }

    public static ThreadPoolExecutor newThreadPool(String name, int coreSize, int maxSize) {
        return newThreadPool(name, coreSize, maxSize, 2147483647);
    }

    public static ThreadPoolExecutor newThreadPool(String name, int coreSize, int maxSize, int queueCapacity) {
        return newThreadPool(name, coreSize, maxSize, queueCapacity, 2147483647);
    }

    public static ThreadPoolExecutor newThreadPool(String name, int coreSize, int maxSize, int queueCapacity, int keepAliveSeconds) {
        if (!poolExecutorMap.containsKey(name)) {
            ThreadPoolExecutor threadPoolExecutor;
            try {
                lock.lock();
                if (!poolExecutorMap.containsKey(name)) {
                    threadPoolExecutor = createThreadPool(name, coreSize, maxSize, queueCapacity, keepAliveSeconds);
                    poolExecutorMap.put(name, threadPoolExecutor);
                    return (ThreadPoolExecutor)poolExecutorMap.get(name);
                }

                threadPoolExecutor = (ThreadPoolExecutor)poolExecutorMap.get(name);
            } finally {
                lock.unlock();
            }

            return threadPoolExecutor;
        } else {
            return (ThreadPoolExecutor)poolExecutorMap.get(name);
        }
    }


    private static ThreadPoolExecutor createThreadPool(String name, int coreSize, int maxSize, int queueCapacity, int keepAliveSeconds) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        threadPoolExecutor.setCorePoolSize(coreSize);
        threadPoolExecutor.setMaxPoolSize(maxSize);
        threadPoolExecutor.setQueueCapacity(queueCapacity);
        threadPoolExecutor.setKeepAliveSeconds(keepAliveSeconds);
        threadPoolExecutor.setThreadGroupName(name);
        threadPoolExecutor.afterPropertiesSet();
        return threadPoolExecutor;
    }

    private static ThreadPoolExecutor createThreadPool(String name, int coreSize, ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        threadPoolExecutor.setCorePoolSize(coreSize);
        threadPoolExecutor.setThreadFactory(threadFactory);
        threadPoolExecutor.afterPropertiesSet();
        threadPoolExecutor.setThreadGroupName(name);
        return threadPoolExecutor;
    }
}

