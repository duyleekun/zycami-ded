/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public abstract class FlowableRangeLong$BaseRangeSubscription
extends BasicQueueSubscription {
    private static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public final long end;
    public long index;

    public FlowableRangeLong$BaseRangeSubscription(long l10, long l11) {
        this.index = l10;
        this.end = l11;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        long l10;
        this.index = l10 = this.end;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        long l10 = this.index;
        long l11 = this.end;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public final Long poll() {
        long l10 = this.index;
        long l11 = this.end;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return null;
        }
        this.index = l11 = 1L + l10;
        return l10;
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

