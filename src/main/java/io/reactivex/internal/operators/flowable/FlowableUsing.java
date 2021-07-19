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
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.operators.flowable.FlowableUsing$UsingSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class FlowableUsing
extends j {
    public final Callable b;
    public final o c;
    public final g d;
    public final boolean e;

    public FlowableUsing(Callable callable, o o10, g g10, boolean bl2) {
        this.b = callable;
        this.c = o10;
        this.d = g10;
        this.e = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m6(d d10) {
        Callable callable;
        try {
            callable = this.b;
            callable = callable.call();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        try {
            Object object2 = this.c;
            object2 = object2.apply(callable);
            Object object = "The sourceSupplier returned a null Publisher";
            object2 = e.a.w0.b.a.g(object2, (String)object);
            object2 = (c)object2;
            g g10 = this.d;
            boolean bl2 = this.e;
            object = new FlowableUsing$UsingSubscriber(d10, callable, g10, bl2);
            object2.subscribe((d)object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            try {
                g g11 = this.d;
                g11.accept(callable);
            }
            catch (Throwable throwable2) {
                e.a.t0.a.b(throwable2);
                Throwable[] throwableArray = new Throwable[]{throwable, throwable2};
                CompositeException compositeException = new CompositeException(throwableArray);
                EmptySubscription.error(compositeException, d10);
                return;
            }
            EmptySubscription.error(throwable, d10);
            return;
        }
    }
}

