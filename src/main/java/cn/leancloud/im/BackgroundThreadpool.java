/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BackgroundThreadpool {
    private static final BackgroundThreadpool INSTANCE;
    private ThreadPoolExecutor executor;
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    static {
        BackgroundThreadpool backgroundThreadpool;
        INSTANCE = backgroundThreadpool = new BackgroundThreadpool();
    }

    private BackgroundThreadpool() {
        ThreadPoolExecutor threadPoolExecutor;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<Runnable>();
        int n10 = 1;
        ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
        this.executor = threadPoolExecutor = new ThreadPoolExecutor(n10, 2, 10, timeUnit, linkedBlockingDeque);
        super(n10);
        this.scheduledThreadPoolExecutor = threadPoolExecutor2;
    }

    public static BackgroundThreadpool getInstance() {
        return INSTANCE;
    }

    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public void executeDelayed(Runnable runnable, long l10) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.scheduledThreadPoolExecutor;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        scheduledThreadPoolExecutor.schedule(runnable, l10, timeUnit);
    }

    public void removeScheduledTask(Runnable runnable) {
        this.scheduledThreadPoolExecutor.remove(runnable);
    }
}

