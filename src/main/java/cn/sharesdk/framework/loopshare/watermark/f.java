/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.loopshare.watermark;

import cn.sharesdk.framework.loopshare.watermark.f$1;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class f {
    private static int a = 5;
    private static int b = 100;
    private static int c = 10000;
    private static BlockingQueue d;
    private static ThreadFactory e;
    private static ThreadPoolExecutor f;

    static {
        Object object = new ArrayBlockingQueue(10);
        d = object;
        e = object = new f$1();
        int n10 = a;
        int n11 = b;
        long l10 = c;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue blockingQueue = d;
        ThreadFactory threadFactory = e;
        f = object = new ThreadPoolExecutor(n10, n11, l10, timeUnit, (BlockingQueue<Runnable>)blockingQueue, threadFactory);
    }

    public static void a(Runnable runnable) {
        f.execute(runnable);
    }
}

