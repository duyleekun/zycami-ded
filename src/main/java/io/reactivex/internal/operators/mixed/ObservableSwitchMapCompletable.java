/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a;
import e.a.d;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.d.b;
import e.a.z;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable$SwitchMapCompletableObserver;

public final class ObservableSwitchMapCompletable
extends a {
    public final z a;
    public final o b;
    public final boolean c;

    public ObservableSwitchMapCompletable(z z10, o o10, boolean bl2) {
        this.a = z10;
        this.b = o10;
        this.c = bl2;
    }

    public void L0(d d10) {
        z z10 = this.a;
        Object object = this.b;
        boolean bl2 = e.a.w0.e.d.b.a(z10, (o)object, d10);
        if (!bl2) {
            z10 = this.a;
            o o10 = this.b;
            boolean bl3 = this.c;
            object = new ObservableSwitchMapCompletable$SwitchMapCompletableObserver(d10, o10, bl3);
            z10.subscribe((g0)object);
        }
    }
}

