/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber;

public final class FlowableSubscribeOn
extends a {
    public final h0 c;
    public final boolean d;

    public FlowableSubscribeOn(j j10, h0 h02, boolean bl2) {
        super(j10);
        this.c = h02;
        this.d = bl2;
    }

    public void m6(d d10) {
        h0$c h0$c = this.c.c();
        j j10 = this.b;
        boolean bl2 = this.d;
        FlowableSubscribeOn$SubscribeOnSubscriber flowableSubscribeOn$SubscribeOnSubscriber = new FlowableSubscribeOn$SubscribeOnSubscriber(d10, h0$c, j10, bl2);
        d10.onSubscribe(flowableSubscribeOn$SubscribeOnSubscriber);
        h0$c.b(flowableSubscribeOn$SubscribeOnSubscriber);
    }
}

