/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.i7;

import d.v.c.s0.i7.k$a;
import d.v.c.s0.i7.k$c$a;
import d.v.c.s0.i7.k$d;
import d.v.c.s0.i7.k$e;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m.a.a;

public class k$c {
    private static final int a = 0;
    private static final int b = 0;
    private static final int c = 0;
    private static final int d = 30;
    private static final ThreadFactory e;
    private static final BlockingQueue f;
    public static final ThreadPoolExecutor g;

    static {
        LinkedBlockingQueue<Runnable> linkedBlockingQueue;
        int n10;
        int n11;
        int n12;
        a = n12 = Runtime.getRuntime().availableProcessors();
        int n13 = Math.min(n12 + -1, 4);
        b = n11 = Math.max(2, n13);
        c = n10 = n12 * 2 + 1;
        k$c$a k$c$a = new k$c$a();
        e = k$c$a;
        f = linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        Object[] objectArray = new StringBuilder();
        objectArray.append("static initializer:  CPU_COUNT = ");
        objectArray.append(n12);
        objectArray.append(" CORE_POOL_SIZE = ");
        objectArray.append(n11);
        objectArray.append(" MAXIMUM_POOL_SIZE = ");
        objectArray.append(n10);
        Object object = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.i((String)object, objectArray);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        object = new ThreadPoolExecutor(n11, n10, (long)30, timeUnit, linkedBlockingQueue, k$c$a);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        g = object;
    }

    private k$c() {
    }

    public /* synthetic */ k$c(k$a k$a) {
        this();
    }

    public void a(k$d k$d) {
        ThreadPoolExecutor threadPoolExecutor = g;
        k$e k$e = new k$e(k$d);
        threadPoolExecutor.execute(k$e);
    }
}

