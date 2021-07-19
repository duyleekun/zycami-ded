/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.j;
import e.a.z0.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscription;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionDelayError;

public final class ParallelJoin
extends j {
    public final a b;
    public final int c;
    public final boolean d;

    public ParallelJoin(a a10, int n10, boolean bl2) {
        this.b = a10;
        this.c = n10;
        this.d = bl2;
    }

    public void m6(d object) {
        d[] dArray;
        boolean bl2 = this.d;
        if (bl2) {
            a a10 = this.b;
            int n10 = a10.G();
            int n11 = this.c;
            dArray = new ParallelJoin$JoinSubscriptionDelayError((d)object, n10, n11);
        } else {
            a a11 = this.b;
            int n12 = a11.G();
            int n13 = this.c;
            dArray = new ParallelJoin$JoinSubscription((d)object, n12, n13);
        }
        object.onSubscribe((e)dArray);
        object = this.b;
        dArray = dArray.subscribers;
        ((a)object).a(dArray);
    }
}

