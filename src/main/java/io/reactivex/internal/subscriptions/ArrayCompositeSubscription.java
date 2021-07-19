/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeSubscription
extends AtomicReferenceArray
implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int n10) {
        super(n10);
    }

    public void dispose() {
        e e10;
        Object e11 = this.get(0);
        if (e11 != (e10 = SubscriptionHelper.CANCELLED)) {
            int n10 = this.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                SubscriptionHelper subscriptionHelper;
                e10 = (e)this.get(i10);
                if (e10 == (subscriptionHelper = SubscriptionHelper.CANCELLED) || (e10 = (e)this.getAndSet(i10, subscriptionHelper)) == subscriptionHelper || e10 == null) continue;
                e10.cancel();
            }
        }
    }

    public boolean isDisposed() {
        SubscriptionHelper subscriptionHelper;
        boolean bl2 = false;
        Object e10 = this.get(0);
        if (e10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        }
        return bl2;
    }

    public e replaceResource(int n10, e e10) {
        e e11;
        boolean bl2;
        do {
            SubscriptionHelper subscriptionHelper;
            if ((e11 = (e)this.get(n10)) != (subscriptionHelper = SubscriptionHelper.CANCELLED)) continue;
            if (e10 != null) {
                e10.cancel();
            }
            return null;
        } while (!(bl2 = this.compareAndSet(n10, e11, e10)));
        return e11;
    }

    public boolean setResource(int n10, e e10) {
        e e11;
        boolean bl2;
        do {
            SubscriptionHelper subscriptionHelper;
            if ((e11 = (e)this.get(n10)) != (subscriptionHelper = SubscriptionHelper.CANCELLED)) continue;
            if (e10 != null) {
                e10.cancel();
            }
            return false;
        } while (!(bl2 = this.compareAndSet(n10, e11, e10)));
        if (e11 != null) {
            e11.cancel();
        }
        return true;
    }
}

