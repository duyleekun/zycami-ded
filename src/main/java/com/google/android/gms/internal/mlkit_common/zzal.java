/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzz;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class zzal
extends zzz
implements ExecutorService {
    public boolean awaitTermination(long l10, TimeUnit timeUnit) {
        return this.zzb().awaitTermination(l10, timeUnit);
    }

    public void execute(Runnable runnable) {
        this.zzb().execute(runnable);
    }

    public List invokeAll(Collection collection) {
        return this.zzb().invokeAll(collection);
    }

    public List invokeAll(Collection collection, long l10, TimeUnit timeUnit) {
        return this.zzb().invokeAll(collection, l10, timeUnit);
    }

    public Object invokeAny(Collection collection) {
        return this.zzb().invokeAny(collection);
    }

    public Object invokeAny(Collection collection, long l10, TimeUnit timeUnit) {
        return this.zzb().invokeAny(collection, l10, timeUnit);
    }

    public boolean isShutdown() {
        return this.zzb().isShutdown();
    }

    public boolean isTerminated() {
        return this.zzb().isTerminated();
    }

    public void shutdown() {
        this.zzb().shutdown();
    }

    public List shutdownNow() {
        return this.zzb().shutdownNow();
    }

    public Future submit(Runnable runnable) {
        return this.zzb().submit(runnable);
    }

    public Future submit(Runnable runnable, Object object) {
        return this.zzb().submit(runnable, object);
    }

    public Future submit(Callable callable) {
        return this.zzb().submit(callable);
    }

    public /* synthetic */ Object zza() {
        return this.zzb();
    }

    public abstract ExecutorService zzb();
}

