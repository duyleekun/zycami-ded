/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.measurement.zzi;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzj
implements zzh {
    private zzj() {
    }

    public /* synthetic */ zzj(zzi zzi2) {
    }

    public static final ExecutorService zzc(int n10, ThreadFactory threadFactory, int n11) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, (long)60, timeUnit, linkedBlockingQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public final ExecutorService zza(int n10) {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        int n11 = 1;
        return zzj.zzc(n11, threadFactory, n11);
    }

    public final ExecutorService zzb(ThreadFactory threadFactory, int n10) {
        n10 = 1;
        return zzj.zzc(n10, threadFactory, n10);
    }
}

