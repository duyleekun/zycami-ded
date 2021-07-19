/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.h0$c;
import e.a.w0.g.i$a;
import i.g.d;
import io.reactivex.internal.operators.parallel.ParallelRunOn;

public final class ParallelRunOn$a
implements i$a {
    public final d[] a;
    public final d[] b;
    public final /* synthetic */ ParallelRunOn c;

    public ParallelRunOn$a(ParallelRunOn parallelRunOn, d[] dArray, d[] dArray2) {
        this.c = parallelRunOn;
        this.a = dArray;
        this.b = dArray2;
    }

    public void a(int n10, h0$c h0$c) {
        ParallelRunOn parallelRunOn = this.c;
        d[] dArray = this.a;
        d[] dArray2 = this.b;
        parallelRunOn.V(n10, dArray, dArray2, h0$c);
    }
}

