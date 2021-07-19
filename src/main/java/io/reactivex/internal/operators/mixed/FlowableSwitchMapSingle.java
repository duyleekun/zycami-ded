/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.j;
import e.a.v0.o;
import i.g.d;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber;

public final class FlowableSwitchMapSingle
extends j {
    public final j b;
    public final o c;
    public final boolean d;

    public FlowableSwitchMapSingle(j j10, o o10, boolean bl2) {
        this.b = j10;
        this.c = o10;
        this.d = bl2;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        boolean bl2 = this.d;
        FlowableSwitchMapSingle$SwitchMapSingleSubscriber flowableSwitchMapSingle$SwitchMapSingleSubscriber = new FlowableSwitchMapSingle$SwitchMapSingleSubscriber(d10, o10, bl2);
        j10.l6(flowableSwitchMapSingle$SwitchMapSingleSubscriber);
    }
}

