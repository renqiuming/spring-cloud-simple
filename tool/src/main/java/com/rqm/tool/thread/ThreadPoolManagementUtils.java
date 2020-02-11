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

}
