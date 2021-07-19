/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.d;
import e.a.g;
import e.a.j;
import e.a.o;
import e.a.w0.e.b.a;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable$MergeWithSubscriber;
import java.io.Serializable;

public final class FlowableMergeWithCompletable
extends a {
    public final g c;

    public FlowableMergeWithCompletable(j j10, g g10) {
        super(j10);
        this.c = g10;
    }

    public void m6(i.g.d object) {
        Serializable serializable = new FlowableMergeWithCompletable$MergeWithSubscriber((i.g.d)object);
        object.onSubscribe((e)((Object)serializable));
        this.b.l6((o)((Object)serializable));
        object = this.c;
        serializable = serializable.otherObserver;
        object.f((d)((Object)serializable));
    }
}

