/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.v0.a;
import e.a.w0.c.n;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableOnBackpressureBuffer$BackpressureBufferSubscriber
extends BasicIntQueueSubscription
implements o {
    private static final long serialVersionUID = -2514538129242366402L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public final d downstream;
    public Throwable error;
    public final a onOverflow;
    public boolean outputFused;
    public final n queue;
    public final AtomicLong requested;
    public e upstream;

    public FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(d object, int n10, boolean bl2, boolean bl3, a a10) {
        AtomicLong atomicLong;
        this.requested = atomicLong = new AtomicLong();
        this.downstream = object;
        this.onOverflow = a10;
        this.delayError = bl3;
        object = bl2 ? new e.a.w0.f.a(n10) : new SpscArrayQueue(n10);
        this.queue = object;
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            Object object = this.upstream;
            object.cancel();
            n10 = this.outputFused;
            if (n10 == 0 && (n10 = this.getAndIncrement()) == 0) {
                object = this.queue;
                object.clear();
            }
        }
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, d d10) {
        boolean bl4 = this.cancelled;
        boolean bl5 = true;
        if (bl4) {
            this.queue.clear();
            return bl5;
        }
        if (bl2) {
            bl2 = this.delayError;
            if (bl2) {
                if (bl3) {
                    Throwable throwable = this.error;
                    if (throwable != null) {
                        d10.onError(throwable);
                    } else {
                        d10.onComplete();
                    }
                    return bl5;
                }
            } else {
                Throwable throwable = this.error;
                if (throwable != null) {
                    this.queue.clear();
                    d10.onError(throwable);
                    return bl5;
                }
                if (bl3) {
                    d10.onComplete();
                    return bl5;
                }
            }
        }
        return false;
    }

    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            int n11;
            n n12 = this.queue;
            d d10 = this.downstream;
            int n13 = n11 = 1;
            do {
                long l10;
                long l11;
                boolean bl2;
                long l12;
                long l13;
                boolean bl3 = this.done;
                boolean bl4 = n12.isEmpty();
                if (bl3 = this.checkTerminated(bl3, bl4, d10)) {
                    return;
                }
                AtomicLong atomicLong = this.requested;
                long l14 = atomicLong.get();
                long l15 = l13 = 0L;
                while ((l12 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1)) != false) {
                    bl2 = this.done;
                    Object object = n12.poll();
                    int n14 = object == null ? n11 : 0;
                    if (bl2 = this.checkTerminated(bl2, n14 != 0, d10)) {
                        return;
                    }
                    if (n14 != 0) break;
                    d10.onNext(object);
                    long l16 = 1L;
                    l15 += l16;
                }
                if (l12 == false) {
                    l12 = (long)this.done;
                    bl2 = n12.isEmpty();
                    if ((l12 = (long)this.checkTerminated((boolean)l12, bl2, d10)) != false) {
                        return;
                    }
                }
                if ((l11 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1)) != false && (bl3 = (l10 = l14 - (l13 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) {
                    atomicLong = this.requested;
                    long l17 = -l15;
                    atomicLong.addAndGet(l17);
                }
                n13 = -n13;
            } while ((n13 = this.addAndGet(n13)) != 0);
        }
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.done = true;
        boolean bl2 = this.outputFused;
        if (bl2) {
            d d10 = this.downstream;
            d10.onComplete();
        } else {
            this.drain();
        }
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        boolean bl2 = this.outputFused;
        if (bl2) {
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            this.drain();
        }
    }

    public void onNext(Object object) {
        Object object2 = this.queue;
        boolean bl2 = object2.offer(object);
        if (!bl2) {
            this.upstream.cancel();
            object2 = "Buffer is full";
            object = new MissingBackpressureException((String)object2);
            object2 = this.onOverflow;
            try {
                object2.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                ((Throwable)object).initCause(throwable);
            }
            this.onError((Throwable)object);
            return;
        }
        bl2 = this.outputFused;
        if (bl2) {
            object = this.downstream;
            object2 = null;
            object.onNext(null);
        } else {
            this.drain();
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    public Object poll() {
        return this.queue.poll();
    }

    public void request(long l10) {
        boolean bl2 = this.outputFused;
        if (!bl2 && (bl2 = SubscriptionHelper.validate(l10))) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.outputFused = true;
            return n11;
        }
        return 0;
    }
}

