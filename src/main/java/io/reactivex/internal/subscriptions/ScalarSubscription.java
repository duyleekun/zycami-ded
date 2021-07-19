/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import e.a.w0.c.l;
import i.g.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;

public final class ScalarSubscription
extends AtomicInteger
implements l {
    public static final int CANCELLED = 2;
    public static final int NO_REQUEST = 0;
    public static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    public final d subscriber;
    public final Object value;

    public ScalarSubscription(d d10, Object object) {
        this.subscriber = d10;
        this.value = object;
    }

    public void cancel() {
        this.lazySet(2);
    }

    public void clear() {
        this.lazySet(1);
    }

    public boolean isCancelled() {
        int n10;
        int n11 = this.get();
        n11 = n11 == (n10 = 2) ? 1 : 0;
        return n11 != 0;
    }

    public boolean isEmpty() {
        int n10 = this.get();
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public Object poll() {
        int n10 = this.get();
        if (n10 == 0) {
            this.lazySet(1);
            return this.value;
        }
        return null;
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (!bl2) {
            return;
        }
        d d10 = null;
        int n10 = 1;
        bl2 = this.compareAndSet(0, n10);
        if (bl2) {
            d10 = this.subscriber;
            Object object = this.value;
            d10.onNext(object);
            n10 = this.get();
            int n11 = 2;
            if (n10 != n11) {
                d10.onComplete();
            }
        }
    }

    public int requestFusion(int n10) {
        return n10 & 1;
    }
}

