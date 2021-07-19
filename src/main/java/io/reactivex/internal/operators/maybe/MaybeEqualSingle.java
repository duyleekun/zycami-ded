/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.i0;
import e.a.l0;
import e.a.v0.d;
import e.a.w;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle$EqualCoordinator;

public final class MaybeEqualSingle
extends i0 {
    public final w a;
    public final w b;
    public final d c;

    public MaybeEqualSingle(w w10, w w11, d d10) {
        this.a = w10;
        this.b = w11;
        this.c = d10;
    }

    public void e1(l0 object) {
        Object object2 = this.c;
        MaybeEqualSingle$EqualCoordinator maybeEqualSingle$EqualCoordinator = new MaybeEqualSingle$EqualCoordinator((l0)object, (d)object2);
        object.onSubscribe(maybeEqualSingle$EqualCoordinator);
        object = this.a;
        object2 = this.b;
        maybeEqualSingle$EqualCoordinator.subscribe((w)object, (w)object2);
    }
}

