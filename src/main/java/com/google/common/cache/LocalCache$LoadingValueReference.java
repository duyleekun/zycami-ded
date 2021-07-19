/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$LoadingValueReference$1;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.ReferenceEntry;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class LocalCache$LoadingValueReference
implements LocalCache$ValueReference {
    public final SettableFuture futureValue;
    public volatile LocalCache$ValueReference oldValue;
    public final Stopwatch stopwatch;

    public LocalCache$LoadingValueReference() {
        LocalCache$ValueReference localCache$ValueReference = LocalCache.unset();
        this(localCache$ValueReference);
    }

    public LocalCache$LoadingValueReference(LocalCache$ValueReference localCache$ValueReference) {
        Object object = SettableFuture.create();
        this.futureValue = object;
        this.stopwatch = object = Stopwatch.createUnstarted();
        this.oldValue = localCache$ValueReference;
    }

    private ListenableFuture fullyFailedFuture(Throwable throwable) {
        return Futures.immediateFailedFuture(throwable);
    }

    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, ReferenceEntry referenceEntry) {
        return this;
    }

    public long elapsedNanos() {
        Stopwatch stopwatch = this.stopwatch;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return stopwatch.elapsed(timeUnit);
    }

    public Object get() {
        return this.oldValue.get();
    }

    public ReferenceEntry getEntry() {
        return null;
    }

    public LocalCache$ValueReference getOldValue() {
        return this.oldValue;
    }

    public int getWeight() {
        return this.oldValue.getWeight();
    }

    public boolean isActive() {
        return this.oldValue.isActive();
    }

    public boolean isLoading() {
        return true;
    }

    public ListenableFuture loadFuture(Object object, CacheLoader object2) {
        Object object3;
        block16: {
            boolean bl2;
            block13: {
                block15: {
                    block14: {
                        boolean bl3;
                        try {
                            object3 = this.stopwatch;
                        }
                        catch (Throwable throwable) {
                            bl3 = this.setException(throwable);
                            object2 = bl3 ? this.futureValue : this.fullyFailedFuture(throwable);
                            bl2 = throwable instanceof InterruptedException;
                            if (bl2) {
                                Thread thread = Thread.currentThread();
                                thread.interrupt();
                            }
                            return object2;
                        }
                        ((Stopwatch)object3).start();
                        object3 = this.oldValue;
                        object3 = object3.get();
                        if (object3 != null) break block13;
                        object = ((CacheLoader)object2).load(object);
                        bl3 = this.set(object);
                        if (!bl3) break block14;
                        object = this.futureValue;
                        break block15;
                    }
                    object = Futures.immediateFuture(object);
                }
                return object;
            }
            object = ((CacheLoader)object2).reload(object, object3);
            if (object != null) break block16;
            bl2 = false;
            object = null;
            return Futures.immediateFuture(null);
        }
        object2 = new LocalCache$LoadingValueReference$1(this);
        object3 = MoreExecutors.directExecutor();
        return Futures.transform((ListenableFuture)object, (Function)object2, (Executor)object3);
    }

    public void notifyNewValue(Object object) {
        if (object != null) {
            this.set(object);
        } else {
            this.oldValue = object = LocalCache.unset();
        }
    }

    public boolean set(Object object) {
        return this.futureValue.set(object);
    }

    public boolean setException(Throwable throwable) {
        return this.futureValue.setException(throwable);
    }

    public Object waitForValue() {
        return Uninterruptibles.getUninterruptibly(this.futureValue);
    }
}

