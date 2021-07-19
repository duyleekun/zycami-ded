/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.g0;
import e.a.l0;
import e.a.o0;
import e.a.z;
import io.reactivex.internal.operators.single.SingleToObservable$SingleToObservableObserver;

public final class SingleToObservable
extends z {
    public final o0 a;

    public SingleToObservable(o0 o02) {
        this.a = o02;
    }

    public static l0 h8(g0 g02) {
        SingleToObservable$SingleToObservableObserver singleToObservable$SingleToObservableObserver = new SingleToObservable$SingleToObservableObserver(g02);
        return singleToObservable$SingleToObservableObserver;
    }

    public void K5(g0 object) {
        o0 o02 = this.a;
        object = SingleToObservable.h8((g0)object);
        o02.f((l0)object);
    }
}

