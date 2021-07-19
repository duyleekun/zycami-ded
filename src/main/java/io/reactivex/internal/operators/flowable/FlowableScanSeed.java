/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.c;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableScanSeed$ScanSeedSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class FlowableScanSeed
extends a {
    public final c c;
    public final Callable d;

    public FlowableScanSeed(j j10, Callable callable, c c10) {
        super(j10);
        this.c = c10;
        this.d = callable;
    }

    public void m6(d d10) {
        Object object;
        try {
            object = this.d;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.call();
        Object object2 = "The seed supplied is null";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.b;
        c c10 = this.c;
        int n10 = j.f0();
        FlowableScanSeed$ScanSeedSubscriber flowableScanSeed$ScanSeedSubscriber = new FlowableScanSeed$ScanSeedSubscriber(d10, c10, object, n10);
        ((j)object2).l6(flowableScanSeed$ScanSeedSubscriber);
    }
}

