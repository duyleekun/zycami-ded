/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.t0.a;
import e.a.v0.c;
import e.a.v0.g;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableGenerate$GeneratorSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class FlowableGenerate
extends j {
    public final Callable b;
    public final c c;
    public final g d;

    public FlowableGenerate(Callable callable, c c10, g g10) {
        this.b = callable;
        this.c = c10;
        this.d = g10;
    }

    public void m6(d d10) {
        Callable callable;
        try {
            callable = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        callable = callable.call();
        c c10 = this.c;
        g g10 = this.d;
        FlowableGenerate$GeneratorSubscription flowableGenerate$GeneratorSubscription = new FlowableGenerate$GeneratorSubscription(d10, c10, g10, callable);
        d10.onSubscribe(flowableGenerate$GeneratorSubscription);
    }
}

