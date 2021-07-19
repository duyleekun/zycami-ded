/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = 3240706908776709697L;
    public final long bufferSize;
    public volatile boolean cancelled;
    public final Deque deque;
    public volatile boolean done;
    public final d downstream;
    public Throwable error;
    public final e.a.v0.a onOverflow;
    public final AtomicLong requested;
    public final BackpressureOverflowStrategy strategy;
    public e upstream;

    public FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber(d arrayDeque, e.a.v0.a a10, BackpressureOverflowStrategy backpressureOverflowStrategy, long l10) {
        this.downstream = arrayDeque;
        this.onOverflow = a10;
        this.strategy = backpressureOverflowStrategy;
        this.bufferSize = l10;
        arrayDeque = new ArrayDeque();
        this.requested = arrayDeque;
        this.deque = arrayDeque = new ArrayDeque();
    }

    public void cancel() {
        this.cancelled = true;
        Object object = this.upstream;
        object.cancel();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            object = this.deque;
            this.clear((Deque)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear(Deque deque) {
        synchronized (deque) {
            deque.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        Deque deque = this.deque;
        d d10 = this.downstream;
        int n12 = n10 = 1;
        do {
            boolean bl2;
            long l10;
            long l11;
            Serializable serializable = this.requested;
            long l12 = serializable.get();
            long l13 = l11 = 0L;
            while ((l10 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1)) != false) {
                boolean bl3 = this.cancelled;
                if (bl3) {
                    this.clear(deque);
                    return;
                }
                bl3 = this.done;
                // MONITORENTER : deque
                Object e10 = deque.poll();
                // MONITOREXIT : deque
                int n13 = e10 == null ? n10 : 0;
                if (bl3) {
                    Throwable throwable = this.error;
                    if (throwable != null) {
                        this.clear(deque);
                        d10.onError(throwable);
                        return;
                    }
                    if (n13 != 0) {
                        d10.onComplete();
                        return;
                    }
                }
                if (n13 != 0) break;
                d10.onNext(e10);
                long l14 = 1L;
                l13 += l14;
            }
            if (l10 == false) {
                bl2 = this.cancelled;
                if (bl2) {
                    this.clear(deque);
                    return;
                }
                bl2 = this.done;
                // MONITORENTER : deque
                boolean bl4 = deque.isEmpty();
                // MONITOREXIT : deque
                if (bl2) {
                    serializable = this.error;
                    if (serializable != null) {
                        this.clear(deque);
                        d10.onError((Throwable)serializable);
                        return;
                    }
                    if (bl4) {
                        d10.onComplete();
                        return;
                    }
                }
            }
            if (bl2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) {
                serializable = this.requested;
                b.e(serializable, l13);
            }
            n12 = -n12;
        } while ((n12 = this.addAndGet(n12)) != 0);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onNext(Object object) {
        int n10;
        int n11;
        Object object2;
        block10: {
            float f10;
            block8: {
                block11: {
                    block9: {
                        boolean bl2 = this.done;
                        if (bl2) {
                            return;
                        }
                        object2 = this.deque;
                        // MONITORENTER : object2
                        int n12 = object2.size();
                        long l10 = n12;
                        long l11 = this.bufferSize;
                        n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                        n11 = 0;
                        n10 = 1;
                        f10 = Float.MIN_VALUE;
                        if (n12 != 0) break block8;
                        int[] nArray = FlowableOnBackpressureBufferStrategy$a.a;
                        BackpressureOverflowStrategy backpressureOverflowStrategy = this.strategy;
                        int n13 = backpressureOverflowStrategy.ordinal();
                        n12 = nArray[n13];
                        if (n12 == n10) break block9;
                        n13 = 2;
                        if (n12 != n13) break block10;
                        object2.poll();
                        object2.offer(object);
                        break block11;
                    }
                    object2.pollLast();
                    object2.offer(object);
                }
                int n14 = n10;
                n10 = 0;
                f10 = 0.0f;
                n11 = n14;
                break block10;
            }
            object2.offer(object);
            n10 = 0;
            f10 = 0.0f;
        }
        // MONITOREXIT : object2
        if (n11 != 0) {
            object = this.onOverflow;
            if (object == null) return;
            try {
                object.run();
                return;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.upstream;
                object2.cancel();
                this.onError(throwable);
                return;
            }
        }
        if (n10 != 0) {
            this.upstream.cancel();
            object = new MissingBackpressureException();
            this.onError((Throwable)object);
            return;
        }
        this.drain();
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

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }
}

