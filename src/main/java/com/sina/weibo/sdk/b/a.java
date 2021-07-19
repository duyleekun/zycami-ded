/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.b.a$1;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final int J;
    private static final int K;
    private static final int L;
    private static final Comparator N;
    public ThreadPoolExecutor M;

    static {
        int n10;
        J = n10 = Runtime.getRuntime().availableProcessors();
        K = n10 + 1;
        L = n10 * 2 + 1;
        a$1 a$1 = new a$1();
        N = a$1;
    }

    public a() {
        ThreadPoolExecutor threadPoolExecutor = this.M;
        if (threadPoolExecutor == null) {
            int n10 = K;
            int n11 = L;
            long l10 = 1L;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            int n12 = 5;
            Comparator comparator = N;
            PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<Runnable>(n12, comparator);
            this.M = threadPoolExecutor = new ThreadPoolExecutor(n10, n11, l10, timeUnit, priorityBlockingQueue);
        }
    }
}

