/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a;
import e.a.d;
import e.a.j;
import e.a.v0.o;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable$SwitchMapCompletableObserver;

public final class FlowableSwitchMapCompletable
extends a {
    public final j a;
    public final o b;
    public final boolean c;

    public FlowableSwitchMapCompletable(j j10, o o10, boolean bl2) {
        this.a = j10;
        this.b = o10;
        this.c = bl2;
    }

    public void L0(d d10) {
        j j10 = this.a;
        o o10 = this.b;
        boolean bl2 = this.c;
        FlowableSwitchMapCompletable$SwitchMapCompletableObserver flowableSwitchMapCompletable$SwitchMapCompletableObserver = new FlowableSwitchMapCompletable$SwitchMapCompletableObserver(d10, o10, bl2);
        j10.l6(flowableSwitchMapCompletable$SwitchMapCompletableObserver);
    }
}

