/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.w0.i.b;
import e.a.w0.i.n;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableBuffer$PublisherBufferOverlappingSubscriber
extends AtomicLong
implements o,
e,
e.a.v0.e {
    private static final long serialVersionUID = -7370244972039324525L;
    public final Callable bufferSupplier;
    public final ArrayDeque buffers;
    public volatile boolean cancelled;
    public boolean done;
    public final d downstream;
    public int index;
    public final AtomicBoolean once;
    public long produced;
    public final int size;
    public final int skip;
    public e upstream;

    public FlowableBuffer$PublisherBufferOverlappingSubscriber(d arrayDeque, int n10, int n11, Callable callable) {
        this.downstream = arrayDeque;
        this.size = n10;
        this.skip = n11;
        this.bufferSupplier = callable;
        arrayDeque = new ArrayDeque();
        this.once = arrayDeque;
        this.buffers = arrayDeque = new ArrayDeque();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public boolean getAsBoolean() {
        return this.cancelled;
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        long l10 = this.produced;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            b.e(this, l10);
        }
        d d10 = this.downstream;
        ArrayDeque arrayDeque = this.buffers;
        n.g(d10, arrayDeque, this, this);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.buffers.clear();
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10;
        int n11;
        Object object2;
        Object object3;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        Object object4 = this.buffers;
        int n12 = this.index;
        int n13 = n12 + 1;
        if (n12 == 0) {
            try {
                object3 = this.bufferSupplier;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                this.onError(throwable);
                return;
            }
            object3 = object3.call();
            object2 = "The bufferSupplier returned a null buffer";
            object3 = e.a.w0.b.a.g(object3, (String)object2);
            object3 = (Collection)object3;
            ((ArrayDeque)object4).offer(object3);
        }
        if ((object3 = (Collection)((ArrayDeque)object4).peek()) != null && (n11 = object3.size() + 1) == (n10 = this.size)) {
            ((ArrayDeque)object4).poll();
            object3.add(object);
            long l10 = this.produced;
            long l11 = 1L;
            this.produced = l10 += l11;
            object2 = this.downstream;
            object2.onNext(object3);
        }
        object4 = ((ArrayDeque)object4).iterator();
        while ((n12 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
            object3 = (Collection)object4.next();
            object3.add(object);
        }
        int n14 = this.skip;
        if (n13 == n14) {
            n13 = 0;
        }
        this.index = n13;
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        boolean n10 = SubscriptionHelper.validate(l10);
        if (n10) {
            boolean bl2;
            boolean bl3;
            d d10 = this.downstream;
            ArrayDeque arrayDeque = this.buffers;
            boolean bl4 = n.i(l10, d10, arrayDeque, this, this);
            if (bl4) {
                return;
            }
            Object object = this.once;
            boolean bl5 = ((AtomicBoolean)object).get();
            if (!bl5 && (bl3 = ((AtomicBoolean)(object = this.once)).compareAndSet(false, bl2 = true))) {
                long l11 = this.skip;
                long l12 = 1L;
                l10 -= l12;
                l10 = b.d(l11, l10);
                int n11 = this.size;
                l11 = n11;
                l10 = b.c(l11, l10);
                object = this.upstream;
                object.request(l10);
            } else {
                int n12 = this.skip;
                long l13 = n12;
                l10 = b.d(l13, l10);
                object = this.upstream;
                object.request(l10);
            }
        }
    }
}

