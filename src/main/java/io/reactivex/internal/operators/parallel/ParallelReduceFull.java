/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.j;
import e.a.v0.c;
import e.a.z0.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelReduceFull$ParallelReduceFullMainSubscriber;

public final class ParallelReduceFull
extends j {
    public final a b;
    public final c c;

    public ParallelReduceFull(a a10, c c10) {
        this.b = a10;
        this.c = c10;
    }

    public void m6(d object) {
        int n10 = this.b.G();
        c c10 = this.c;
        d[] dArray = new ParallelReduceFull$ParallelReduceFullMainSubscriber((d)object, n10, c10);
        object.onSubscribe((e)dArray);
        object = this.b;
        dArray = dArray.subscribers;
        ((a)object).a(dArray);
    }
}

