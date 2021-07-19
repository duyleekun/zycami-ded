/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableBuffer$PublisherBufferSkipSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = -5616169793639412593L;
    public Collection buffer;
    public final Callable bufferSupplier;
    public boolean done;
    public final d downstream;
    public int index;
    public final int size;
    public final int skip;
    public e upstream;

    public FlowableBuffer$PublisherBufferSkipSubscriber(d d10, int n10, int n11, Callable callable) {
        this.downstream = d10;
        this.size = n10;
        this.skip = n11;
        this.bufferSupplier = callable;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        Collection collection = this.buffer;
        d d10 = null;
        this.buffer = null;
        if (collection != null) {
            d10 = this.downstream;
            d10.onNext(collection);
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.buffer = null;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        Object object2 = this.buffer;
        int n11 = this.index;
        int n12 = n11 + 1;
        if (n11 == 0) {
            try {
                object2 = this.bufferSupplier;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                this.onError(throwable);
                return;
            }
            object2 = object2.call();
            String string2 = "The bufferSupplier returned a null buffer";
            object2 = e.a.w0.b.a.g(object2, string2);
            this.buffer = object2 = (Collection)object2;
        }
        if (object2 != null) {
            object2.add(object);
            n10 = object2.size();
            n11 = this.size;
            if (n10 == n11) {
                n10 = 0;
                this.buffer = null;
                object = this.downstream;
                object.onNext(object2);
            }
        }
        if (n12 == (n10 = this.skip)) {
            n12 = 0;
        }
        this.index = n12;
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

    /*
     * Enabled aggressive block sorting
     */
    public void request(long l10) {
        int n10;
        e e10;
        int n11 = SubscriptionHelper.validate(l10);
        if (n11 == 0) return;
        n11 = this.get();
        if (n11 == 0) {
            e10 = null;
            n10 = 1;
            n11 = (int)(this.compareAndSet(0, n10) ? 1 : 0);
            if (n11 != 0) {
                n11 = this.size;
                long l11 = n11;
                l11 = b.d(l10, l11);
                int n12 = this.skip;
                int n13 = this.size;
                long l12 = n12 -= n13;
                long l13 = 1L;
                l10 -= l13;
                l10 = b.d(l12, l10);
                e e11 = this.upstream;
                l10 = b.c(l11, l10);
                e11.request(l10);
                return;
            }
        }
        e10 = this.upstream;
        n10 = this.skip;
        long l14 = n10;
        l10 = b.d(l14, l10);
        e10.request(l10);
    }
}

