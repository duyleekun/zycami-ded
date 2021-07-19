/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.d.b;
import e.a.z;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMapSingle
extends z {
    public final z a;
    public final o b;
    public final ErrorMode c;
    public final int d;

    public ObservableConcatMapSingle(z z10, o o10, ErrorMode errorMode, int n10) {
        this.a = z10;
        this.b = o10;
        this.c = errorMode;
        this.d = n10;
    }

    public void K5(g0 g02) {
        z z10 = this.a;
        Object object = this.b;
        boolean bl2 = e.a.w0.e.d.b.c(z10, (o)object, g02);
        if (!bl2) {
            z10 = this.a;
            o o10 = this.b;
            int n10 = this.d;
            ErrorMode errorMode = this.c;
            object = new ObservableConcatMapSingle$ConcatMapSingleMainObserver(g02, o10, n10, errorMode);
            z10.subscribe((g0)object);
        }
    }
}

