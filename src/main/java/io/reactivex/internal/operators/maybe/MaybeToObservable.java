/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.g0;
import e.a.t;
import e.a.w;
import e.a.w0.c.f;
import e.a.z;
import io.reactivex.internal.operators.maybe.MaybeToObservable$MaybeToObservableObserver;

public final class MaybeToObservable
extends z
implements f {
    public final w a;

    public MaybeToObservable(w w10) {
        this.a = w10;
    }

    public static t h8(g0 g02) {
        MaybeToObservable$MaybeToObservableObserver maybeToObservable$MaybeToObservableObserver = new MaybeToObservable$MaybeToObservableObserver(g02);
        return maybeToObservable$MaybeToObservableObserver;
    }

    public void K5(g0 object) {
        w w10 = this.a;
        object = MaybeToObservable.h8((g0)object);
        w10.g((t)object);
    }

    public w source() {
        return this.a;
    }
}

