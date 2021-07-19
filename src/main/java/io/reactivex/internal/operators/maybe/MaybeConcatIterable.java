/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.j;
import e.a.w0.b.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable$ConcatMaybeObserver;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;

public final class MaybeConcatIterable
extends j {
    public final Iterable b;

    public MaybeConcatIterable(Iterable iterable) {
        this.b = iterable;
    }

    public void m6(d d10) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.iterator();
        Object object2 = "The sources Iterable returned a null Iterator";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (Iterator)object;
        object2 = new MaybeConcatIterable$ConcatMaybeObserver(d10, (Iterator)object);
        d10.onSubscribe((e)object2);
        ((MaybeConcatIterable$ConcatMaybeObserver)object2).drain();
    }
}

