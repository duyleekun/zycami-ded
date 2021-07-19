/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.internal.mlkit_common.zzal;
import com.google.mlkit.common.sdkinternal.zzh;
import com.google.mlkit.common.sdkinternal.zzi;
import com.google.mlkit.common.sdkinternal.zzj;
import java.util.Deque;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MlKitThreadPool
extends zzal {
    private static final ThreadLocal zzd;
    private final ExecutorService zza;
    private final ThreadFactory zzb;
    private final WeakHashMap zzc;

    static {
        zzj zzj2 = new zzj();
        zzd = zzj2;
    }

    public MlKitThreadPool() {
        ThreadPoolExecutor threadPoolExecutor;
        int n10 = Runtime.getRuntime().availableProcessors();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        zzi zzi2 = new zzi(this);
        WeakHashMap weakHashMap = threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(0, n10, (long)60, timeUnit, linkedBlockingQueue, zzi2);
        this.zza = threadPoolExecutor;
        weakHashMap = Executors.defaultThreadFactory();
        this.zzb = weakHashMap;
        this.zzc = weakHashMap = new WeakHashMap();
    }

    public static final /* synthetic */ void zza(Runnable runnable) {
        MlKitThreadPool.zzd(runnable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Thread zzc(Runnable runnable) {
        runnable = this.zzb.newThread(runnable);
        WeakHashMap weakHashMap = this.zzc;
        synchronized (weakHashMap) {
            WeakHashMap weakHashMap2 = this.zzc;
            weakHashMap2.put(runnable, null);
            return runnable;
        }
    }

    private static void zzd(Runnable runnable) {
        Deque deque = (Deque)zzd.get();
        deque.add(runnable);
        int n10 = deque.size();
        int n11 = 1;
        if (n10 > n11) {
            return;
        }
        do {
            runnable.run();
            deque.removeFirst();
        } while ((runnable = (Runnable)deque.peekFirst()) != null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void execute(Runnable runnable) {
        Object object = this.zzc;
        // MONITORENTER : object
        Object object2 = this.zzc;
        Thread thread = Thread.currentThread();
        boolean bl2 = ((WeakHashMap)object2).containsKey(thread);
        // MONITOREXIT : object
        if (bl2) {
            MlKitThreadPool.zzd(runnable);
            return;
        }
        object = this.zza;
        object2 = new zzh(runnable);
        object.execute((Runnable)object2);
    }

    public final /* synthetic */ Object zza() {
        return ((zzal)this).zzb();
    }

    public final /* synthetic */ Thread zzb(Runnable runnable) {
        return this.zzc(runnable);
    }

    public final ExecutorService zzb() {
        return this.zza;
    }
}

