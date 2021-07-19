/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.r;

public final class Functions$n
implements r {
    public final Class a;

    public Functions$n(Class clazz) {
        this.a = clazz;
    }

    public boolean test(Object object) {
        return this.a.isInstance(object);
    }
}

