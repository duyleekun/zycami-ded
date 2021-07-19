/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.c.a;
import io.reactivex.internal.operators.flowable.FlowableRange$BaseRangeSubscription;

public final class FlowableRange$RangeConditionalSubscription
extends FlowableRange$BaseRangeSubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    public final a downstream;

    public FlowableRange$RangeConditionalSubscription(a a10, int n10, int n11) {
        super(n10, n11);
        this.downstream = a10;
    }

    public void fastPath() {
        int n10 = this.end;
        a a10 = this.downstream;
        for (int i10 = this.index; i10 != n10; ++i10) {
            boolean bl2 = this.cancelled;
            if (bl2) {
                return;
            }
            Integer n11 = i10;
            a10.tryOnNext(n11);
        }
        n10 = (int)(this.cancelled ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        a10.onComplete();
    }

    public void slowPath(long l10) {
        long l11;
        long l12;
        int n10 = this.end;
        int n11 = this.index;
        a a10 = this.downstream;
        long l13 = 0L;
        do {
            long l14 = l13;
            while (true) {
                Object object;
                if ((object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) != false && n11 != n10) {
                    object = this.cancelled;
                    if (object != false) {
                        return;
                    }
                    Integer n12 = n11;
                    object = a10.tryOnNext(n12);
                    if (object != false) {
                        long l15 = 1L;
                        l14 += l15;
                    }
                    ++n11;
                    continue;
                }
                if (n11 == n10) {
                    boolean bl2 = this.cancelled;
                    if (!bl2) {
                        a10.onComplete();
                    }
                    return;
                }
                l10 = this.get();
                long l16 = l14 - l10;
                object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object == false) break;
            }
            this.index = n11;
            l10 = -l14;
        } while ((l12 = (l11 = (l10 = this.addAndGet(l10)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false);
    }
}

