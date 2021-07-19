/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.o;
import e.a.t;
import e.a.w;
import e.a.w0.e.b.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe$MergeWithObserver;
import java.io.Serializable;

public final class FlowableMergeWithMaybe
extends a {
    public final w c;

    public FlowableMergeWithMaybe(j j10, w w10) {
        super(j10);
        this.c = w10;
    }

    public void m6(d object) {
        Serializable serializable = new FlowableMergeWithMaybe$MergeWithObserver((d)object);
        object.onSubscribe((e)((Object)serializable));
        this.b.l6((o)((Object)serializable));
        object = this.c;
        serializable = serializable.otherObserver;
        object.g((t)((Object)serializable));
    }
}

