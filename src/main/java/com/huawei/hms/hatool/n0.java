/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.m0;
import com.huawei.hms.hatool.n0$a;
import com.huawei.hms.hatool.y;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class n0 {
    public static n0 b;
    public static n0 c;
    public ThreadPoolExecutor a;

    static {
        n0 n02;
        new n0();
        new n0();
        b = n02 = new n0();
        c = n02 = new n0();
    }

    public n0() {
        ThreadPoolExecutor threadPoolExecutor;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(5000);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.a = threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60000L, timeUnit, linkedBlockingQueue);
    }

    public static n0 a() {
        return c;
    }

    public static n0 b() {
        return b;
    }

    public void a(m0 object) {
        Object object2 = this.a;
        n0$a n0$a = new n0$a((Runnable)object);
        try {
            ((ThreadPoolExecutor)object2).execute(n0$a);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = "hmsSdk";
            object2 = "addToQueue() Exception has happened!Form rejected execution";
            y.e((String)object, (String)object2);
        }
    }
}

