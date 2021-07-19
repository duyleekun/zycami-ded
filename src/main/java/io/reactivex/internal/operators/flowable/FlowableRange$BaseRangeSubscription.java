/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public abstract class FlowableRange$BaseRangeSubscription
extends BasicQueueSubscription {
    private static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final int end;
    public int index;

    public FlowableRange$BaseRangeSubscription(int n10, int n11) {
        this.index = n10;
        this.end = n11;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        int n10;
        this.index = n10 = this.end;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        int n10 = this.index;
        int n11 = this.end;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public final Integer poll() {
        int n10 = this.index;
        int n11 = this.end;
        if (n10 == n11) {
            return null;
        }
        this.index = n11 = n10 + 1;
        return n10;
    }

    public final void request(long l10) {
        long l11;
        long l12;
        long l13;
        Object object = SubscriptionHelper.validate(l10);
        if (object && !(object = (l13 = (l12 = b.a(this, l10)) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
            l12 = Long.MAX_VALUE;
            long l14 = l10 - l12;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (!object) {
                this.fastPath();
            } else {
                this.slowPath(l10);
            }
        }
    }

    public final int requestFusion(int n10) {
        return n10 & 1;
    }

    public abstract void slowPath(long var1);
}

