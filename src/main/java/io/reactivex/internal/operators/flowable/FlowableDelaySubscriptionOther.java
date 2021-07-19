/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther$MainSubscriber;

public final class FlowableDelaySubscriptionOther
extends j {
    public final c b;
    public final c c;

    public FlowableDelaySubscriptionOther(c c10, c c11) {
        this.b = c10;
        this.c = c11;
    }

    public void m6(d object) {
        c c10 = this.b;
        o o10 = new FlowableDelaySubscriptionOther$MainSubscriber((d)object, c10);
        object.onSubscribe((e)((Object)o10));
        object = this.c;
        o10 = o10.other;
        object.subscribe(o10);
    }
}

