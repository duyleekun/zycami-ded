/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.v0.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$BaseConcatMapSubscriber;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$c;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.Callable;

public final class FlowableConcatMap$ConcatMapDelayed
extends FlowableConcatMap$BaseConcatMapSubscriber {
    private static final long serialVersionUID = -2945777694260521066L;
    public final d downstream;
    public final boolean veryEnd;

    public FlowableConcatMap$ConcatMapDelayed(d d10, o o10, int n10, boolean bl2) {
        super(o10, n10);
        this.downstream = d10;
        this.veryEnd = bl2;
    }

    public void cancel() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            this.inner.cancel();
            e e10 = this.upstream;
            e10.cancel();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) return;
        while (true) {
            block15: {
                int n11;
                e e10;
                Object object;
                Object object2;
                int n12;
                block16: {
                    block17: {
                        int n13;
                        if ((n10 = (int)(this.cancelled ? 1 : 0)) != 0) {
                            return;
                        }
                        n10 = (int)(this.active ? 1 : 0);
                        if (n10 != 0) break block15;
                        n10 = (int)(this.done ? 1 : 0);
                        if (n10 != 0 && (n12 = this.veryEnd) == 0 && (object2 = (Throwable)this.errors.get()) != null) {
                            object = this.downstream;
                            object2 = this.errors.terminate();
                            object.onError((Throwable)object2);
                            return;
                        }
                        try {
                            object2 = this.queue;
                            object2 = object2.poll();
                            e10 = null;
                            n11 = 1;
                            n13 = object2 == null ? n11 : 0;
                            if (n10 != 0 && n13 != 0) {
                                object = this.errors.terminate();
                                if (object != null) {
                                    object2 = this.downstream;
                                    object2.onError((Throwable)object);
                                    return;
                                }
                                object = this.downstream;
                                object.onComplete();
                                return;
                            }
                            if (n13 != 0) break block15;
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.upstream.cancel();
                            this.errors.addThrowable(throwable);
                            d d12 = this.downstream;
                            object2 = this.errors.terminate();
                            d12.onError((Throwable)object2);
                            return;
                        }
                        try {
                            object = this.mapper;
                            object = object.apply(object2);
                            object2 = "The mapper returned a null Publisher";
                            object = e.a.w0.b.a.g(object, (String)object2);
                            object = (c)object;
                            n12 = this.sourceMode;
                            if (n12 == n11) break block16;
                            n12 = this.consumed + n11;
                            n13 = this.limit;
                            if (n12 != n13) break block17;
                            this.consumed = 0;
                            e10 = this.upstream;
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.upstream.cancel();
                            this.errors.addThrowable(throwable);
                            d d10 = this.downstream;
                            object2 = this.errors.terminate();
                            d10.onError((Throwable)object2);
                            return;
                        }
                        long l10 = n12;
                        e10.request(l10);
                        break block16;
                    }
                    this.consumed = n12;
                }
                if ((n12 = object instanceof Callable) != 0) {
                    object = (Callable)object;
                    try {
                        object = object.call();
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        object2 = this.errors;
                        ((AtomicThrowable)object2).addThrowable(throwable);
                        n10 = (int)(this.veryEnd ? 1 : 0);
                        if (n10 == 0) {
                            this.upstream.cancel();
                            d d11 = this.downstream;
                            object2 = this.errors.terminate();
                            d11.onError((Throwable)object2);
                            return;
                        }
                        n10 = 0;
                        object = null;
                    }
                    if (object == null) continue;
                    object2 = this.inner;
                    n12 = (int)(((SubscriptionArbiter)object2).isUnbounded() ? 1 : 0);
                    if (n12 != 0) {
                        object2 = this.downstream;
                        object2.onNext(object);
                        continue;
                    }
                    this.active = n11;
                    object2 = this.inner;
                    e10 = new FlowableConcatMap$c(object, (d)object2);
                    ((SubscriptionArbiter)object2).setSubscription(e10);
                } else {
                    this.active = n11;
                    object2 = this.inner;
                    object.subscribe((d)object2);
                }
            }
            if ((n10 = this.decrementAndGet()) == 0) break;
        }
    }

    public void innerError(Throwable object) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)object);
        if (bl2) {
            boolean bl3 = this.veryEnd;
            if (!bl3) {
                object = this.upstream;
                object.cancel();
                this.done = bl3 = true;
            }
            bl3 = false;
            object = null;
            this.active = false;
            this.drain();
        } else {
            a.Y((Throwable)object);
        }
    }

    public void innerNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void request(long l10) {
        this.inner.request(l10);
    }

    public void subscribeActual() {
        this.downstream.onSubscribe(this);
    }
}

