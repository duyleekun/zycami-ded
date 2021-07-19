/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.b.a;
import e.a.w0.i.b;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

public abstract class FlowableFromIterable$BaseRangeSubscription
extends BasicQueueSubscription {
    private static final long serialVersionUID = -2252972430506210021L;
    public volatile boolean cancelled;
    public Iterator it;
    public boolean once;

    public FlowableFromIterable$BaseRangeSubscription(Iterator iterator2) {
        this.it = iterator2;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void clear() {
        this.it = null;
    }

    public abstract void fastPath();

    public final boolean isEmpty() {
        boolean bl2;
        Iterator iterator2 = this.it;
        if (iterator2 != null && (bl2 = iterator2.hasNext())) {
            bl2 = false;
            iterator2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final Object poll() {
        Iterator iterator2 = this.it;
        if (iterator2 == null) {
            return null;
        }
        boolean bl2 = this.once;
        if (!bl2) {
            boolean bl3;
            this.once = bl3 = true;
        } else {
            boolean bl4 = iterator2.hasNext();
            if (!bl4) {
                return null;
            }
        }
        return a.g(this.it.next(), "Iterator.next() returned a null value");
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

