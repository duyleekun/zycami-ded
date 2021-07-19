/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSingle$SingleElementSubscriber;

public final class FlowableSingle
extends a {
    public final Object c;
    public final boolean d;

    public FlowableSingle(j j10, Object object, boolean bl2) {
        super(j10);
        this.c = object;
        this.d = bl2;
    }

    public void m6(d d10) {
        j j10 = this.b;
        Object object = this.c;
        boolean bl2 = this.d;
        FlowableSingle$SingleElementSubscriber flowableSingle$SingleElementSubscriber = new FlowableSingle$SingleElementSubscriber(d10, object, bl2);
        j10.l6(flowableSingle$SingleElementSubscriber);
    }
}

