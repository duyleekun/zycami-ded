/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe$MergeWithObserver;
import java.io.Serializable;

public final class ObservableMergeWithMaybe
extends a {
    public final w b;

    public ObservableMergeWithMaybe(z z10, w w10) {
        super(z10);
        this.b = w10;
    }

    public void K5(g0 object) {
        Serializable serializable = new ObservableMergeWithMaybe$MergeWithObserver((g0)object);
        object.onSubscribe((b)((Object)serializable));
        this.a.subscribe((g0)((Object)serializable));
        object = this.b;
        serializable = serializable.otherObserver;
        object.g((t)((Object)serializable));
    }
}

