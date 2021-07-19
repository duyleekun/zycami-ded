/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.h0;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.z;

public final class ObservableInternalHelper$k
implements o {
    private final o a;
    private final h0 b;

    public ObservableInternalHelper$k(o o10, h0 h02) {
        this.a = o10;
        this.b = h02;
    }

    public e0 a(z z10) {
        z10 = z.O7((e0)e.a.w0.b.a.g(this.a.apply(z10), "The selector returned a null ObservableSource"));
        h0 h02 = this.b;
        return z10.i4(h02);
    }
}

