/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$GroupJoinDisposable;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver;

public final class ObservableGroupJoin
extends a {
    public final e0 b;
    public final o c;
    public final o d;
    public final c e;

    public ObservableGroupJoin(e0 e02, e0 e03, o o10, o o11, c c10) {
        super(e02);
        this.b = e03;
        this.c = o10;
        this.d = o11;
        this.e = c10;
    }

    public void K5(g0 g02) {
        Object object = this.c;
        o o10 = this.d;
        c c10 = this.e;
        ObservableGroupJoin$GroupJoinDisposable observableGroupJoin$GroupJoinDisposable = new ObservableGroupJoin$GroupJoinDisposable(g02, (o)object, o10, c10);
        g02.onSubscribe(observableGroupJoin$GroupJoinDisposable);
        g02 = new ObservableGroupJoin$LeftRightObserver(observableGroupJoin$GroupJoinDisposable, true);
        observableGroupJoin$GroupJoinDisposable.disposables.b((b)((Object)g02));
        object = new ObservableGroupJoin$LeftRightObserver(observableGroupJoin$GroupJoinDisposable, false);
        observableGroupJoin$GroupJoinDisposable.disposables.b((b)object);
        this.a.subscribe(g02);
        this.b.subscribe((g0)object);
    }
}

