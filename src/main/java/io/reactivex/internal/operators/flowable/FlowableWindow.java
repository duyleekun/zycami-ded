/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableWindow$WindowExactSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWindow$WindowOverlapSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWindow$WindowSkipSubscriber;

public final class FlowableWindow
extends a {
    public final long c;
    public final long d;
    public final int e;

    public FlowableWindow(j j10, long l10, long l11, int n10) {
        super(j10);
        this.c = l10;
        this.d = l11;
        this.e = n10;
    }

    public void m6(d d10) {
        long l10 = this.d;
        long l11 = this.c;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            j j10 = this.b;
            l11 = this.c;
            object = this.e;
            FlowableWindow$WindowExactSubscriber flowableWindow$WindowExactSubscriber = new FlowableWindow$WindowExactSubscriber(d10, l11, (int)object);
            j10.l6(flowableWindow$WindowExactSubscriber);
        } else {
            Object object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object2 > 0) {
                FlowableWindow$WindowSkipSubscriber flowableWindow$WindowSkipSubscriber;
                j j11 = this.b;
                long l13 = this.c;
                long l14 = this.d;
                int n10 = this.e;
                FlowableWindow$WindowSkipSubscriber flowableWindow$WindowSkipSubscriber2 = flowableWindow$WindowSkipSubscriber;
                flowableWindow$WindowSkipSubscriber = new FlowableWindow$WindowSkipSubscriber(d10, l13, l14, n10);
                j11.l6(flowableWindow$WindowSkipSubscriber);
            } else {
                FlowableWindow$WindowOverlapSubscriber flowableWindow$WindowOverlapSubscriber;
                j j12 = this.b;
                long l15 = this.c;
                long l16 = this.d;
                int n11 = this.e;
                FlowableWindow$WindowOverlapSubscriber flowableWindow$WindowOverlapSubscriber2 = flowableWindow$WindowOverlapSubscriber;
                flowableWindow$WindowOverlapSubscriber = new FlowableWindow$WindowOverlapSubscriber(d10, l15, l16, n11);
                j12.l6(flowableWindow$WindowOverlapSubscriber);
            }
        }
    }
}

