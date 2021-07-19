/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.d;
import e.a.g;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable$MergeWithObserver;
import java.io.Serializable;

public final class ObservableMergeWithCompletable
extends a {
    public final g b;

    public ObservableMergeWithCompletable(z z10, g g10) {
        super(z10);
        this.b = g10;
    }

    public void K5(g0 object) {
        Serializable serializable = new ObservableMergeWithCompletable$MergeWithObserver((g0)object);
        object.onSubscribe((b)((Object)serializable));
        this.a.subscribe((g0)((Object)serializable));
        object = this.b;
        serializable = serializable.otherObserver;
        object.f((d)((Object)serializable));
    }
}

