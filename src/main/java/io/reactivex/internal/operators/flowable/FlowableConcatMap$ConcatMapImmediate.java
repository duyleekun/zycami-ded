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
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableConcatMap$ConcatMapImmediate
extends FlowableConcatMap$BaseConcatMapSubscriber {
    private static final long serialVersionUID = 7898995095634264146L;
    public final d downstream;
    public final AtomicInteger wip;

    public FlowableConcatMap$ConcatMapImmediate(d object, o o10, int n10) {
        super(o10, n10);
        this.downstream = object;
        this.wip = object = new AtomicInteger();
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
        block18: {
            Object object = this.wip;
            int n10 = ((AtomicInteger)object).getAndIncrement();
            if (n10 != 0) break block18;
            while (true) {
                block15: {
                    int n12;
                    int n11;
                    FlowableConcatMap$c flowableConcatMap$c;
                    Object object2;
                    block16: {
                        block17: {
                            e e10;
                            int n13;
                            if ((n10 = (int)(this.cancelled ? 1 : 0)) != 0) {
                                return;
                            }
                            n10 = (int)(this.active ? 1 : 0);
                            if (n10 != 0) break block15;
                            n10 = (int)(this.done ? 1 : 0);
                            try {
                                object2 = this.queue;
                                object2 = object2.poll();
                                flowableConcatMap$c = null;
                                n11 = 1;
                                if (object2 == null) {
                                    n13 = n11;
                                } else {
                                    n13 = 0;
                                    e10 = null;
                                }
                                if (n10 != 0 && n13 != 0) {
                                    this.downstream.onComplete();
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
                            if (object == null) {
                                continue;
                            }
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.upstream.cancel();
                            this.errors.addThrowable(throwable);
                            d d11 = this.downstream;
                            object2 = this.errors.terminate();
                            d11.onError((Throwable)object2);
                            return;
                        }
                        object2 = this.inner;
                        n12 = (int)(((SubscriptionArbiter)object2).isUnbounded() ? 1 : 0);
                        if (n12 != 0) {
                            n12 = this.get();
                            if (n12 != 0 || (n12 = (int)(this.compareAndSet(0, n11) ? 1 : 0)) == 0) continue;
                            object2 = this.downstream;
                            object2.onNext(object);
                            n10 = (int)(this.compareAndSet(n11, 0) ? 1 : 0);
                            if (n10 != 0) continue;
                            object = this.downstream;
                            object2 = this.errors.terminate();
                            object.onError((Throwable)object2);
                            return;
                        }
                        this.active = n11;
                        object2 = this.inner;
                        flowableConcatMap$c = new FlowableConcatMap$c(object, (d)object2);
                        ((SubscriptionArbiter)object2).setSubscription(flowableConcatMap$c);
                    } else {
                        this.active = n11;
                        object2 = this.inner;
                        object.subscribe((d)object2);
                    }
                }
                if ((n10 = ((AtomicInteger)(object = this.wip)).decrementAndGet()) == 0) break;
            }
        }
    }

    public void innerError(Throwable object) {
        Serializable serializable = this.errors;
        boolean bl2 = serializable.addThrowable((Throwable)object);
        if (bl2) {
            object = this.upstream;
            object.cancel();
            int n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.downstream;
                serializable = this.errors.terminate();
                object.onError((Throwable)serializable);
            }
        } else {
            a.Y((Throwable)object);
        }
    }

    public void innerNext(Object object) {
        int n10 = this.get();
        if (n10 == 0) {
            n10 = 0;
            Throwable throwable = null;
            int n11 = 1;
            boolean bl2 = this.compareAndSet(0, n11);
            if (bl2) {
                d d10 = this.downstream;
                d10.onNext(object);
                boolean bl3 = this.compareAndSet(n11, 0);
                if (bl3) {
                    return;
                }
                object = this.downstream;
                throwable = this.errors.terminate();
                object.onError(throwable);
            }
        }
    }

    public void onError(Throwable object) {
        Serializable serializable = this.errors;
        boolean bl2 = serializable.addThrowable((Throwable)object);
        if (bl2) {
            object = this.inner;
            ((SubscriptionArbiter)object).cancel();
            int n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.downstream;
                serializable = this.errors.terminate();
                object.onError((Throwable)serializable);
            }
        } else {
            a.Y((Throwable)object);
        }
    }

    public void request(long l10) {
        this.inner.request(l10);
    }

    public void subscribeActual() {
        this.downstream.onSubscribe(this);
    }
}

