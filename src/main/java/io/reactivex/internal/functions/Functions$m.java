/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.o;

public final class Functions$m
implements o {
    public final Class a;

    public Functions$m(Class clazz) {
        this.a = clazz;
    }

    public Object apply(Object object) {
        return this.a.cast(object);
    }
}

