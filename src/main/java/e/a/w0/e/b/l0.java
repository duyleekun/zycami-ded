/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.c.m;
import i.g.d;
import io.reactivex.internal.subscriptions.ScalarSubscription;

public final class l0
extends j
implements m {
    private final Object b;

    public l0(Object object) {
        this.b = object;
    }

    public Object call() {
        return this.b;
    }

    public void m6(d d10) {
        Object object = this.b;
        ScalarSubscription scalarSubscription = new ScalarSubscription(d10, object);
        d10.onSubscribe(scalarSubscription);
    }
}

