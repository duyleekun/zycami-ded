/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle$MergeWithObserver;
import java.io.Serializable;

public final class ObservableMergeWithSingle
extends a {
    public final o0 b;

    public ObservableMergeWithSingle(z z10, o0 o02) {
        super(z10);
        this.b = o02;
    }

    public void K5(g0 object) {
        Serializable serializable = new ObservableMergeWithSingle$MergeWithObserver((g0)object);
        object.onSubscribe((b)((Object)serializable));
        this.a.subscribe((g0)((Object)serializable));
        object = this.b;
        serializable = serializable.otherObserver;
        object.f((l0)((Object)serializable));
    }
}

