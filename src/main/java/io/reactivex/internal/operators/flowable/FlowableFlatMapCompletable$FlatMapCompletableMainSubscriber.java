/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.d;
import e.a.g;
import e.a.s0.b;
import e.a.v0.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;

public final class FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber
extends BasicIntQueueSubscription
implements e.a.o {
    private static final long serialVersionUID = 8443155186132538303L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final i.g.d downstream;
    public final AtomicThrowable errors;
    public final o mapper;
    public final int maxConcurrency;
    public final e.a.s0.a set;
    public e upstream;

    public FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber(i.g.d object, o o10, boolean bl2, int n10) {
        this.downstream = object;
        this.mapper = o10;
        this.delayErrors = bl2;
        this.errors = object = new AtomicThrowable();
        this.set = object = new e.a.s0.a();
        this.maxConcurrency = n10;
        this.lazySet(1);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void clear() {
    }

    public void innerComplete(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer flowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer) {
        this.set.c(flowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer);
        this.onComplete();
    }

    public void innerError(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer flowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer, Throwable throwable) {
        this.set.c(flowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer);
        this.onError(throwable);
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            Object object = this.errors.terminate();
            if (object != null) {
                i.g.d d10 = this.downstream;
                d10.onError((Throwable)object);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        } else {
            n10 = this.maxConcurrency;
            int n11 = -1 >>> 1;
            if (n10 != n11) {
                e e10 = this.upstream;
                long l10 = 1L;
                e10.request(l10);
            }
        }
    }

    public void onError(Throwable object) {
        Object object2 = this.errors;
        boolean n10 = ((AtomicThrowable)object2).addThrowable((Throwable)object);
        if (n10) {
            int n11 = this.delayErrors;
            if (n11 != 0) {
                n11 = this.decrementAndGet();
                if (n11 == 0) {
                    object = this.errors.terminate();
                    object2 = this.downstream;
                    object2.onError((Throwable)object);
                } else {
                    n11 = this.maxConcurrency;
                    int n12 = -1 >>> 1;
                    if (n11 != n12) {
                        object = this.upstream;
                        long l10 = 1L;
                        object.request(l10);
                    }
                }
            } else {
                this.cancel();
                object = null;
                n11 = this.getAndSet(0);
                if (n11 > 0) {
                    object = this.errors.terminate();
                    object2 = this.downstream;
                    object2.onError((Throwable)object);
                }
            }
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        e.a.s0.a a10;
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null CompletableSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (g)object;
        this.getAndIncrement();
        object2 = new FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber$InnerConsumer(this);
        boolean bl2 = this.cancelled;
        if (!bl2 && (bl2 = (a10 = this.set).b((b)object2))) {
            object.f((d)object2);
        }
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

    public Object poll() {
        return null;
    }

    public void request(long l10) {
    }

    public int requestFusion(int n10) {
        return n10 & 2;
    }
}

