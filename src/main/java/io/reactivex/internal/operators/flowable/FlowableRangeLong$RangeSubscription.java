/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription;

public final class FlowableRangeLong$RangeSubscription
extends FlowableRangeLong$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    public final d downstream;

    public FlowableRangeLong$RangeSubscription(d d10, long l10, long l11) {
        super(l10, l11);
        this.downstream = d10;
    }

    public void fastPath() {
        long l10;
        long l11 = this.end;
        d d10 = this.downstream;
        long l12 = this.index;
        while ((l10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) != false) {
            l10 = (long)this.cancelled;
            if (l10 != false) {
                return;
            }
            Long l13 = l12;
            d10.onNext(l13);
            long l14 = 1L;
            l12 += l14;
        }
        boolean bl2 = this.cancelled;
        if (bl2) {
            return;
        }
        d10.onComplete();
    }

    public void slowPath(long l10) {
        long l11;
        long l12;
        long l13 = this.end;
        long l14 = this.index;
        d d10 = this.downstream;
        long l15 = 0L;
        do {
            long l16 = l15;
            while (true) {
                Object object;
                if ((object = l16 == l10 ? 0 : (l16 < l10 ? -1 : 1)) != false && (object = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1)) != false) {
                    object = this.cancelled;
                    if (object != false) {
                        return;
                    }
                    Long l17 = l14;
                    d10.onNext(l17);
                    long l18 = 1L;
                    l16 += l18;
                    l14 += l18;
                    continue;
                }
                Object object2 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1);
                if (object2 == false) {
                    object2 = this.cancelled;
                    if (object2 == false) {
                        d10.onComplete();
                    }
                    return;
                }
                l10 = this.get();
                long l19 = l16 - l10;
                object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object == false) break;
            }
            this.index = l14;
            l10 = -l16;
        } while ((l12 = (l11 = (l10 = this.addAndGet(l10)) - l15) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false);
    }
}

