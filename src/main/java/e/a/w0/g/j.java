/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.v0.o;
import e.a.w0.g.j$a;
import e.a.w0.g.j$b;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class j {
    public static final String a = "rx2.purge-enabled";
    public static final boolean b = false;
    public static final String c = "rx2.purge-period-seconds";
    public static final int d;
    public static final AtomicReference e;
    public static final Map f;

    static {
        boolean bl2;
        Object object = new AtomicReference();
        e = object;
        f = object = new ConcurrentHashMap();
        object = new j$b();
        int n10 = 1;
        b = bl2 = j.b(n10 != 0, a, n10 != 0, n10 != 0, (o)object);
        d = j.c(bl2, c, n10, n10, (o)object);
        j.e();
    }

    private j() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static ScheduledExecutorService a(ThreadFactory object) {
        object = Executors.newScheduledThreadPool(1, (ThreadFactory)object);
        j.f(b, (ScheduledExecutorService)object);
        return object;
    }

    public static boolean b(boolean bl2, String string2, boolean bl3, boolean bl4, o o10) {
        if (bl2) {
            Object object;
            try {
                object = o10.apply(string2);
            }
            catch (Throwable throwable) {
                return bl3;
            }
            object = (String)object;
            if (object == null) {
                return bl3;
            }
            string2 = "true";
            return string2.equals(object);
        }
        return bl4;
    }

    public static int c(boolean bl2, String string2, int n10, int n11, o o10) {
        if (bl2) {
            Object object;
            block5: {
                try {
                    object = o10.apply(string2);
                }
                catch (Throwable throwable) {
                    return n10;
                }
                object = (String)object;
                if (object != null) break block5;
                return n10;
            }
            return Integer.parseInt((String)object);
        }
        return n11;
    }

    public static void d() {
        ScheduledExecutorService scheduledExecutorService = e.getAndSet(null);
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        f.clear();
    }

    public static void e() {
        j.g(b);
    }

    public static void f(boolean bl2, ScheduledExecutorService scheduledExecutorService) {
        if (bl2 && (bl2 = scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            ScheduledExecutorService scheduledExecutorService2 = scheduledExecutorService;
            scheduledExecutorService2 = (ScheduledThreadPoolExecutor)scheduledExecutorService;
            Map map = f;
            map.put(scheduledExecutorService2, scheduledExecutorService);
        }
    }

    public static void g(boolean bl2) {
        if (bl2) {
            while (true) {
                AtomicReference atomicReference;
                ScheduledExecutorService scheduledExecutorService;
                if ((scheduledExecutorService = (ScheduledExecutorService)(atomicReference = e).get()) != null) {
                    return;
                }
                int n10 = 1;
                String string2 = "RxSchedulerPurge";
                RxThreadFactory rxThreadFactory = new RxThreadFactory(string2);
                ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(n10, rxThreadFactory);
                boolean bl3 = atomicReference.compareAndSet(scheduledExecutorService, scheduledExecutorService2);
                if (bl3) {
                    j$a j$a = new j$a();
                    int n11 = d;
                    long l10 = n11;
                    long l11 = n11;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    scheduledExecutorService2.scheduleAtFixedRate(j$a, l10, l11, timeUnit);
                    return;
                }
                scheduledExecutorService2.shutdownNow();
            }
        }
    }
}

