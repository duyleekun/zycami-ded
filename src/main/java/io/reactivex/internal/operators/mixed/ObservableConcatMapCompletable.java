/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a;
import e.a.d;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.d.b;
import e.a.z;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMapCompletable
extends a {
    public final z a;
    public final o b;
    public final ErrorMode c;
    public final int d;

    public ObservableConcatMapCompletable(z z10, o o10, ErrorMode errorMode, int n10) {
        this.a = z10;
        this.b = o10;
        this.c = errorMode;
        this.d = n10;
    }

    public void L0(d d10) {
        z z10 = this.a;
        Object object = this.b;
        boolean bl2 = e.a.w0.e.d.b.a(z10, (o)object, d10);
        if (!bl2) {
            z10 = this.a;
            o o10 = this.b;
            ErrorMode errorMode = this.c;
            int n10 = this.d;
            object = new ObservableConcatMapCompletable$ConcatMapCompletableObserver(d10, o10, errorMode, n10);
            z10.subscribe((g0)object);
        }
    }
}

