/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.l0;
import e.a.o;
import e.a.o0;
import e.a.w0.e.b.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle$MergeWithObserver;
import java.io.Serializable;

public final class FlowableMergeWithSingle
extends a {
    public final o0 c;

    public FlowableMergeWithSingle(j j10, o0 o02) {
        super(j10);
        this.c = o02;
    }

    public void m6(d object) {
        Serializable serializable = new FlowableMergeWithSingle$MergeWithObserver((d)object);
        object.onSubscribe((e)((Object)serializable));
        this.b.l6((o)((Object)serializable));
        object = this.c;
        serializable = serializable.otherObserver;
        object.f((l0)((Object)serializable));
    }
}

