/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.g;
import e.a.y;

public final class Functions$c0
implements g {
    public final g a;

    public Functions$c0(g g10) {
        this.a = g10;
    }

    public void a(Throwable object) {
        g g10 = this.a;
        object = y.b((Throwable)object);
        g10.accept(object);
    }
}

