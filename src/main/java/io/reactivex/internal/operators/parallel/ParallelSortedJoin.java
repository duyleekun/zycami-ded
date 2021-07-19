/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.j;
import e.a.z0.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin$SortedJoinSubscription;
import java.util.Comparator;

public final class ParallelSortedJoin
extends j {
    public final a b;
    public final Comparator c;

    public ParallelSortedJoin(a a10, Comparator comparator) {
        this.b = a10;
        this.c = comparator;
    }

    public void m6(d object) {
        int n10 = this.b.G();
        Comparator comparator = this.c;
        d[] dArray = new ParallelSortedJoin$SortedJoinSubscription((d)object, n10, comparator);
        object.onSubscribe((e)dArray);
        object = this.b;
        dArray = dArray.subscribers;
        ((a)object).a(dArray);
    }
}

