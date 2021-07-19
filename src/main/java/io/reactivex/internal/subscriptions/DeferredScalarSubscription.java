/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import i.g.d;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public class DeferredScalarSubscription
extends BasicIntQueueSubscription {
    public static final int CANCELLED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 2;
    public static final int NO_REQUEST_HAS_VALUE = 1;
    public static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    public final d downstream;
    public Object value;

    public DeferredScalarSubscription(d d10) {
        this.downstream = d10;
    }

    public void cancel() {
        this.set(4);
        this.value = null;
    }

    public final void clear() {
        this.lazySet(32);
        this.value = null;
    }

    public final void complete(Object object) {
        int n10;
        int n11 = this.get();
        do {
            d d10;
            int n12 = 8;
            n10 = 4;
            if (n11 == n12) {
                this.value = object;
                n11 = 16;
                this.lazySet(n11);
                d10 = this.downstream;
                d10.onNext(object);
                int n13 = this.get();
                if (n13 != n10) {
                    d10.onComplete();
                }
                return;
            }
            n12 = n11 & 0xFFFFFFFD;
            if (n12 != 0) {
                return;
            }
            n12 = 2;
            if (n11 == n12) {
                n11 = 3;
                this.lazySet(n11);
                d10 = this.downstream;
                d10.onNext(object);
                int n14 = this.get();
                if (n14 != n10) {
                    d10.onComplete();
                }
                return;
            }
            this.value = object;
            d10 = null;
            n12 = 1;
            n11 = (int)(this.compareAndSet(0, n12) ? 1 : 0);
            if (n11 == 0) continue;
            return;
        } while ((n11 = this.get()) != n10);
        this.value = null;
    }

    public final boolean isCancelled() {
        int n10;
        int n11 = this.get();
        n11 = n11 == (n10 = 4) ? 1 : 0;
        return n11 != 0;
    }

    public final boolean isEmpty() {
        int n10;
        int n11 = this.get();
        n11 = n11 != (n10 = 16) ? 1 : 0;
        return n11 != 0;
    }

    public final Object poll() {
        int n10;
        int n11 = this.get();
        if (n11 == (n10 = 16)) {
            this.lazySet(32);
            Object object = this.value;
            this.value = null;
            return object;
        }
        return null;
    }

    public final void request(long l10) {
        int n10 = SubscriptionHelper.validate(l10);
        if (n10 != 0) {
            int n11;
            do {
                Object object;
                if ((n11 = (n10 = this.get()) & 0xFFFFFFFE) != 0) {
                    return;
                }
                n11 = 1;
                if (n10 == n11) {
                    n10 = (int)(this.compareAndSet(n11, 3) ? 1 : 0);
                    if (n10 != 0 && (object = this.value) != null) {
                        n11 = 0;
                        this.value = null;
                        d d10 = this.downstream;
                        d10.onNext(object);
                        n10 = this.get();
                        int n12 = 4;
                        if (n10 != n12) {
                            d10.onComplete();
                        }
                    }
                    return;
                }
                object = null;
            } while ((n10 = (int)(this.compareAndSet(0, n11 = 2) ? 1 : 0)) == 0);
        }
    }

    public final int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.lazySet(8);
            return n11;
        }
        return 0;
    }

    public final boolean tryCancel() {
        int n10 = 4;
        int n11 = this.getAndSet(n10);
        n10 = n11 != n10 ? 1 : 0;
        return n10 != 0;
    }
}

