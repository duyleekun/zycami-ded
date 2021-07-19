/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.g;
import e.a.v0.o;
import e.a.w0.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableReplay$c$a;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class FlowableReplay$c
extends j {
    private final Callable b;
    private final o c;

    public FlowableReplay$c(Callable callable, o o10) {
        this.b = callable;
        this.c = o10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m6(d object) {
        Object object3;
        Object object2;
        try {
            object2 = this.b;
            object2 = object2.call();
            object3 = "The connectableFactory returned null";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
            object2 = (e.a.u0.a)object2;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, (d)object);
            return;
        }
        try {
            object3 = this.c;
            object3 = object3.apply(object2);
            Object object4 = "The selector returned a null Publisher";
            object3 = e.a.w0.b.a.g(object3, (String)object4);
            object3 = (c)object3;
            object4 = new SubscriberResourceWrapper((d)object);
            object3.subscribe((d)object4);
            object = new FlowableReplay$c$a(this, (SubscriberResourceWrapper)object4);
            ((e.a.u0.a)object2).O8((g)object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, (d)object);
            return;
        }
    }
}

