/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.v0.c;
import e.a.w0.b.a;
import i.g.d;
import io.reactivex.internal.operators.parallel.ParallelReduce$ParallelReduceSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class ParallelReduce
extends e.a.z0.a {
    public final e.a.z0.a a;
    public final Callable b;
    public final c c;

    public ParallelReduce(e.a.z0.a a10, Callable callable, c c10) {
        this.a = a10;
        this.b = callable;
        this.c = c10;
    }

    public int G() {
        return this.a.G();
    }

    public void V(d[] dArray, Throwable throwable) {
        for (d d10 : dArray) {
            EmptySubscription.error(throwable, d10);
        }
    }

    public void a(d[] dArray) {
        int n10 = this.U(dArray);
        if (n10 == 0) {
            return;
        }
        n10 = dArray.length;
        d[] dArray2 = new d[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            try {
                object = this.b;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.V(dArray, throwable);
                return;
            }
            object = object.call();
            Object object2 = "The initialSupplier returned a null value";
            object = e.a.w0.b.a.g(object, (String)object2);
            d d10 = dArray[i10];
            c c10 = this.c;
            dArray2[i10] = object2 = new ParallelReduce$ParallelReduceSubscriber(d10, object, c10);
        }
        this.a.a(dArray2);
    }
}

