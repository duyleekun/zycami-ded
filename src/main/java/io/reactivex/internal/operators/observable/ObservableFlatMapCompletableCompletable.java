/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.v0.o;
import e.a.w0.c.d;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver;

public final class ObservableFlatMapCompletableCompletable
extends e.a.a
implements d {
    public final e0 a;
    public final o b;
    public final boolean c;

    public ObservableFlatMapCompletableCompletable(e0 e02, o o10, boolean bl2) {
        this.a = e02;
        this.b = o10;
        this.c = bl2;
    }

    public void L0(e.a.d d10) {
        e0 e02 = this.a;
        o o10 = this.b;
        boolean bl2 = this.c;
        ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver observableFlatMapCompletableCompletable$FlatMapCompletableMainObserver = new ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver(d10, o10, bl2);
        e02.subscribe(observableFlatMapCompletableCompletable$FlatMapCompletableMainObserver);
    }

    public z i() {
        e0 e02 = this.a;
        o o10 = this.b;
        boolean bl2 = this.c;
        ObservableFlatMapCompletable observableFlatMapCompletable = new ObservableFlatMapCompletable(e02, o10, bl2);
        return e.a.a1.a.R(observableFlatMapCompletable);
    }
}

