/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscriptions;

import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BooleanSubscription
extends AtomicBoolean
implements e {
    private static final long serialVersionUID = -8127758972444290902L;

    public void cancel() {
        this.lazySet(true);
    }

    public boolean isCancelled() {
        return this.get();
    }

    public void request(long l10) {
        SubscriptionHelper.validate(l10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BooleanSubscription(cancelled=");
        boolean bl2 = this.get();
        stringBuilder.append(bl2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

