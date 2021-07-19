/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a1.a;
import e.a.d;
import e.a.g;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMerge$CompletableMergeSubscriber
extends AtomicInteger
implements o,
b {
    private static final long serialVersionUID = -2108443387387077490L;
    public final boolean delayErrors;
    public final d downstream;
    public final AtomicThrowable error;
    public final int maxConcurrency;
    public final e.a.s0.a set;
    public e upstream;

    public CompletableMerge$CompletableMergeSubscriber(d object, int n10, boolean bl2) {
        this.downstream = object;
        this.maxConcurrency = n10;
        this.delayErrors = bl2;
        this.set = object = new e.a.s0.a();
        this.error = object = new AtomicThrowable();
        this.lazySet(1);
    }

    public void dispose() {
        this.upstream.cancel();
        this.set.dispose();
    }

    public void innerComplete(CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver object) {
        Object object2 = this.set;
        ((e.a.s0.a)object2).c((b)object);
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            object = (Throwable)this.error.get();
            if (object != null) {
                object2 = this.downstream;
                object2.onError((Throwable)object);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        } else {
            n10 = this.maxConcurrency;
            int n11 = -1 >>> 1;
            if (n10 != n11) {
                object = this.upstream;
                long l10 = 1L;
                object.request(l10);
            }
        }
    }

    public void innerError(CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver object, Throwable throwable) {
        e.a.s0.a a10 = this.set;
        a10.c((b)object);
        boolean n10 = this.delayErrors;
        if (!n10) {
            this.upstream.cancel();
            this.set.dispose();
            object = this.error;
            boolean bl2 = ((AtomicThrowable)object).addThrowable(throwable);
            if (bl2) {
                object = null;
                int n11 = this.getAndSet(0);
                if (n11 > 0) {
                    object = this.downstream;
                    throwable = this.error.terminate();
                    object.onError(throwable);
                }
            } else {
                a.Y(throwable);
            }
        } else {
            object = this.error;
            boolean bl3 = ((AtomicThrowable)object).addThrowable(throwable);
            if (bl3) {
                int n12 = this.decrementAndGet();
                if (n12 == 0) {
                    object = this.downstream;
                    throwable = this.error.terminate();
                    object.onError(throwable);
                } else {
                    int n13 = this.maxConcurrency;
                    int n14 = -1 >>> 1;
                    if (n13 != n14) {
                        object = this.upstream;
                        long l10 = 1L;
                        object.request(l10);
                    }
                }
            } else {
                a.Y(throwable);
            }
        }
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    public void onComplete() {
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            Object object = (Throwable)this.error.get();
            if (object != null) {
                object = this.downstream;
                Throwable throwable = this.error.terminate();
                object.onError(throwable);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void onError(Throwable object) {
        boolean bl2 = this.delayErrors;
        if (!bl2) {
            this.set.dispose();
            Serializable serializable = this.error;
            bl2 = serializable.addThrowable((Throwable)object);
            if (bl2) {
                object = null;
                int n10 = this.getAndSet(0);
                if (n10 > 0) {
                    object = this.downstream;
                    serializable = this.error.terminate();
                    object.onError((Throwable)serializable);
                }
            } else {
                a.Y((Throwable)object);
            }
        } else {
            Serializable serializable = this.error;
            bl2 = serializable.addThrowable((Throwable)object);
            if (bl2) {
                int n11 = this.decrementAndGet();
                if (n11 == 0) {
                    object = this.downstream;
                    serializable = this.error.terminate();
                    object.onError((Throwable)serializable);
                }
            } else {
                a.Y((Throwable)object);
            }
        }
    }

    public void onNext(g g10) {
        this.getAndIncrement();
        CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver completableMerge$CompletableMergeSubscriber$MergeInnerObserver = new CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver(this);
        this.set.b(completableMerge$CompletableMergeSubscriber$MergeInnerObserver);
        g10.f(completableMerge$CompletableMergeSubscriber$MergeInnerObserver);
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.maxConcurrency;
            int n11 = -1 >>> 1;
            if (n10 == n11) {
                long l10 = Long.MAX_VALUE;
                e10.request(l10);
            } else {
                long l11 = n10;
                e10.request(l11);
            }
        }
    }
}

