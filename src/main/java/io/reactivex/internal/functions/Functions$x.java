/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.o;
import java.util.concurrent.Callable;

public final class Functions$x
implements Callable,
o {
    public final Object a;

    public Functions$x(Object object) {
        this.a = object;
    }

    public Object apply(Object object) {
        return this.a;
    }

    public Object call() {
        return this.a;
    }
}

