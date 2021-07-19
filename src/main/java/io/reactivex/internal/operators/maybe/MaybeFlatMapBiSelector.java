/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.v0.c;
import e.a.v0.o;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector$FlatMapBiMainObserver;

public final class MaybeFlatMapBiSelector
extends a {
    public final o b;
    public final c c;

    public MaybeFlatMapBiSelector(w w10, o o10, c c10) {
        super(w10);
        this.b = o10;
        this.c = c10;
    }

    public void t1(t t10) {
        w w10 = this.a;
        o o10 = this.b;
        c c10 = this.c;
        MaybeFlatMapBiSelector$FlatMapBiMainObserver maybeFlatMapBiSelector$FlatMapBiMainObserver = new MaybeFlatMapBiSelector$FlatMapBiMainObserver(t10, o10, c10);
        w10.g(maybeFlatMapBiSelector$FlatMapBiMainObserver);
    }
}

