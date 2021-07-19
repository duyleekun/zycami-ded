/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableElementAt$ElementAtSubscriber;

public final class FlowableElementAt
extends a {
    public final long c;
    public final Object d;
    public final boolean e;

    public FlowableElementAt(j j10, long l10, Object object, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = object;
        this.e = bl2;
    }

    public void m6(d d10) {
        j j10 = this.b;
        long l10 = this.c;
        Object object = this.d;
        boolean bl2 = this.e;
        FlowableElementAt$ElementAtSubscriber flowableElementAt$ElementAtSubscriber = new FlowableElementAt$ElementAtSubscriber(d10, l10, object, bl2);
        j10.l6(flowableElementAt$ElementAtSubscriber);
    }
}

