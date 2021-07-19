/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.completable.CompletableConcatIterable$ConcatInnerObserver;
import java.util.Iterator;

public final class CompletableConcatIterable
extends a {
    public final Iterable a;

    public CompletableConcatIterable(Iterable iterable) {
        this.a = iterable;
    }

    public void L0(d d10) {
        Object object;
        try {
            object = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, d10);
            return;
        }
        object = object.iterator();
        Object object2 = "The iterator returned is null";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (Iterator)object;
        object2 = new CompletableConcatIterable$ConcatInnerObserver(d10, (Iterator)object);
        object = ((CompletableConcatIterable$ConcatInnerObserver)object2).sd;
        d10.onSubscribe((b)object);
        ((CompletableConcatIterable$ConcatInnerObserver)object2).next();
    }
}

