/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.d.b;
import e.a.z;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver;

public final class ObservableSwitchMapMaybe
extends z {
    public final z a;
    public final o b;
    public final boolean c;

    public ObservableSwitchMapMaybe(z z10, o o10, boolean bl2) {
        this.a = z10;
        this.b = o10;
        this.c = bl2;
    }

    public void K5(g0 g02) {
        z z10 = this.a;
        Object object = this.b;
        boolean bl2 = e.a.w0.e.d.b.b(z10, (o)object, g02);
        if (!bl2) {
            z10 = this.a;
            o o10 = this.b;
            boolean bl3 = this.c;
            object = new ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(g02, o10, bl3);
            z10.subscribe((g0)object);
        }
    }
}

