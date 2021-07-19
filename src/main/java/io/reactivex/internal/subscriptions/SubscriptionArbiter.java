/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import e.a.w0.b.a;
import e.a.w0.i.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class SubscriptionArbiter
extends AtomicInteger
implements e {
    private static final long serialVersionUID = -2189523197179400958L;
    public e actual;
    public final boolean cancelOnReplace;
    public volatile boolean cancelled;
    public final AtomicLong missedProduced;
    public final AtomicLong missedRequested;
    public final AtomicReference missedSubscription;
    public long requested;
    public boolean unbounded;

    public SubscriptionArbiter(boolean bl2) {
        Serializable serializable;
        this.cancelOnReplace = bl2;
        this.missedSubscription = serializable = new Serializable();
        this.missedRequested = serializable;
        super();
        this.missedProduced = serializable;
    }

    public void cancel() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            this.drain();
        }
    }

    public final void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        this.drainLoop();
    }

    public final void drainLoop() {
        SubscriptionArbiter subscriptionArbiter = this;
        Object object = false;
        long l10 = 0L;
        int n10 = 1;
        e e10 = null;
        long l11 = l10;
        do {
            AtomicLong atomicLong;
            long l12;
            long l13;
            long l14;
            AtomicLong atomicLong2;
            long l15;
            long l16;
            long l17;
            e e11;
            if ((e11 = (e)subscriptionArbiter.missedSubscription.get()) != null) {
                e11 = subscriptionArbiter.missedSubscription.getAndSet(null);
            }
            if ((l17 = (l16 = (l15 = (atomicLong2 = subscriptionArbiter.missedRequested).get()) - l10) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false) {
                atomicLong2 = subscriptionArbiter.missedRequested;
                l15 = atomicLong2.getAndSet(l10);
            }
            if ((l14 = (l13 = (l12 = (atomicLong = subscriptionArbiter.missedProduced).get()) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                atomicLong = subscriptionArbiter.missedProduced;
                l12 = atomicLong.getAndSet(l10);
            }
            e e12 = subscriptionArbiter.actual;
            boolean bl2 = subscriptionArbiter.cancelled;
            if (bl2) {
                if (e12 != null) {
                    e12.cancel();
                    subscriptionArbiter.actual = null;
                }
                if (e11 != null) {
                    e11.cancel();
                }
            } else {
                long l18;
                long l19 = subscriptionArbiter.requested;
                long l20 = Long.MAX_VALUE;
                long l21 = l19 - l20;
                Object object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                if (object2 != false) {
                    long l22;
                    long l23 = (l19 = b.c(l19, l15)) - l20;
                    Object object3 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
                    if (object3 != false && (l17 = (l22 = (l19 -= l12) - l10) == 0L ? 0 : (l22 < 0L ? -1 : 1)) < 0) {
                        SubscriptionHelper.reportMoreProduced(l19);
                        l19 = l10;
                    }
                    subscriptionArbiter.requested = l19;
                }
                if (e11 != null) {
                    Object object4;
                    if (e12 != null && (object4 = subscriptionArbiter.cancelOnReplace)) {
                        e12.cancel();
                    }
                    subscriptionArbiter.actual = e11;
                    object4 = l19 == l10 ? 0 : (l19 < l10 ? -1 : 1);
                    if (object4) {
                        l11 = b.c(l11, l19);
                        e10 = e11;
                    }
                } else if (e12 != null && (l18 = l15 == l10 ? 0 : (l15 < l10 ? -1 : 1)) != false) {
                    l11 = b.c(l11, l15);
                    e10 = e12;
                }
            }
            n10 = -n10;
        } while ((n10 = subscriptionArbiter.addAndGet(n10)) != 0);
        object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object) {
            e10.request(l11);
        }
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isUnbounded() {
        return this.unbounded;
    }

    public final void produced(long l10) {
        int n10;
        int n11 = this.unbounded;
        if (n11 != 0) {
            return;
        }
        n11 = this.get();
        if (n11 == 0 && (n11 = (int)(this.compareAndSet(0, n10 = 1) ? 1 : 0)) != 0) {
            int n12;
            long l11 = this.requested;
            long l12 = Long.MAX_VALUE;
            long l13 = l11 - l12;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object != false) {
                long l14 = (l11 -= l10) - (l10 = 0L);
                object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object < 0) {
                    SubscriptionHelper.reportMoreProduced(l11);
                    l11 = l10;
                }
                this.requested = l11;
            }
            if ((n12 = this.decrementAndGet()) == 0) {
                return;
            }
            this.drainLoop();
            return;
        }
        b.a(this.missedProduced, l10);
        this.drain();
    }

    public final void request(long l10) {
        int n10 = SubscriptionHelper.validate(l10);
        if (n10 != 0) {
            Object object;
            n10 = this.unbounded;
            if (n10 != 0) {
                return;
            }
            n10 = this.get();
            if (n10 == 0) {
                object = null;
                int n11 = 1;
                n10 = (int)(this.compareAndSet(0, n11) ? 1 : 0);
                if (n10 != 0) {
                    long l11 = this.requested;
                    long l12 = Long.MAX_VALUE;
                    long l13 = l11 - l12;
                    n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                    if (n10 != 0) {
                        this.requested = l11 = b.c(l11, l10);
                        n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
                        if (n10 == 0) {
                            this.unbounded = n11;
                        }
                    }
                    object = this.actual;
                    n11 = this.decrementAndGet();
                    if (n11 != 0) {
                        this.drainLoop();
                    }
                    if (object != null) {
                        object.request(l10);
                    }
                    return;
                }
            }
            object = this.missedRequested;
            b.a((AtomicLong)object, l10);
            this.drain();
        }
    }

    public final void setSubscription(e e10) {
        int n10 = this.cancelled;
        if (n10 != 0) {
            e10.cancel();
            return;
        }
        Object object = "s is null";
        a.g(e10, (String)object);
        n10 = this.get();
        if (n10 == 0) {
            object = null;
            int n11 = 1;
            n10 = (int)(this.compareAndSet(0, n11) ? 1 : 0);
            if (n10 != 0) {
                long l10;
                long l11;
                object = this.actual;
                if (object != null && (n11 = (int)(this.cancelOnReplace ? 1 : 0)) != 0) {
                    object.cancel();
                }
                this.actual = e10;
                long l12 = this.requested;
                int n12 = this.decrementAndGet();
                if (n12 != 0) {
                    this.drainLoop();
                }
                if ((n12 = (int)((l11 = l12 - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
                    e10.request(l12);
                }
                return;
            }
        }
        if ((e10 = ((AtomicReference)(object = this.missedSubscription)).getAndSet(e10)) != null && (n10 = (int)(this.cancelOnReplace ? 1 : 0)) != 0) {
            e10.cancel();
        }
        this.drain();
    }
}

