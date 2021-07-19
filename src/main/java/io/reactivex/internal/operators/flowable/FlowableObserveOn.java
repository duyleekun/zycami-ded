/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableObserveOn$ObserveOnConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableObserveOn$ObserveOnSubscriber;

public final class FlowableObserveOn
extends a {
    public final h0 c;
    public final boolean d;
    public final int e;

    public FlowableObserveOn(j j10, h0 h02, boolean bl2, int n10) {
        super(j10);
        this.c = h02;
        this.d = bl2;
        this.e = n10;
    }

    public void m6(d d10) {
        h0$c h0$c = this.c.c();
        boolean bl2 = d10 instanceof e.a.w0.c.a;
        if (bl2) {
            j j10 = this.b;
            d10 = (e.a.w0.c.a)d10;
            boolean bl3 = this.d;
            int n10 = this.e;
            FlowableObserveOn$ObserveOnConditionalSubscriber flowableObserveOn$ObserveOnConditionalSubscriber = new FlowableObserveOn$ObserveOnConditionalSubscriber((e.a.w0.c.a)d10, h0$c, bl3, n10);
            j10.l6(flowableObserveOn$ObserveOnConditionalSubscriber);
        } else {
            j j11 = this.b;
            boolean bl4 = this.d;
            int n11 = this.e;
            FlowableObserveOn$ObserveOnSubscriber flowableObserveOn$ObserveOnSubscriber = new FlowableObserveOn$ObserveOnSubscriber(d10, h0$c, bl4, n11);
            j11.l6(flowableObserveOn$ObserveOnSubscriber);
        }
    }
}

