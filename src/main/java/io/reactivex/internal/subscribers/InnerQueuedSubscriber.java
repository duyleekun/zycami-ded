/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.w0.c.l;
import e.a.w0.c.o;
import e.a.w0.h.g;
import e.a.w0.i.n;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class InnerQueuedSubscriber
extends AtomicReference
implements e.a.o,
e {
    private static final long serialVersionUID = 22876611072430776L;
    public volatile boolean done;
    public int fusionMode;
    public final int limit;
    public final g parent;
    public final int prefetch;
    public long produced;
    public volatile o queue;

    public InnerQueuedSubscriber(g g10, int n10) {
        this.parent = g10;
        this.prefetch = n10;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(this, throwable);
    }

    public void onNext(Object object) {
        int n10 = this.fusionMode;
        if (n10 == 0) {
            g g10 = this.parent;
            g10.innerNext(this, object);
        } else {
            object = this.parent;
            object.drain();
        }
    }

    public void onSubscribe(e e10) {
        int n10 = SubscriptionHelper.setOnce(this, e10);
        if (n10 != 0) {
            Object object;
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n11;
                object = e10;
                object = (l)e10;
                int n12 = object.requestFusion(3);
                if (n12 == (n11 = 1)) {
                    this.fusionMode = n12;
                    this.queue = object;
                    this.done = n11;
                    this.parent.innerComplete(this);
                    return;
                }
                n11 = 2;
                if (n12 == n11) {
                    this.fusionMode = n12;
                    this.queue = object;
                    n10 = this.prefetch;
                    n.j(e10, n10);
                    return;
                }
            }
            this.queue = object = n.c(this.prefetch);
            n10 = this.prefetch;
            n.j(e10, n10);
        }
    }

    public o queue() {
        return this.queue;
    }

    public void request(long l10) {
        int n10 = this.fusionMode;
        int n11 = 1;
        if (n10 != n11) {
            long l11 = this.produced + l10;
            long l12 = l11 - (l10 = (long)this.limit);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object >= 0) {
                this.produced = l10 = 0L;
                e e10 = (e)this.get();
                e10.request(l11);
            } else {
                this.produced = l11;
            }
        }
    }

    public void requestOne() {
        int n10 = this.fusionMode;
        int n11 = 1;
        if (n10 != n11) {
            long l10 = this.produced + 1L;
            long l11 = this.limit;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                this.produced = l11 = 0L;
                e e10 = (e)this.get();
                e10.request(l10);
            } else {
                this.produced = l10;
            }
        }
    }

    public void setDone() {
        this.done = true;
    }
}

