/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.c;
import e.a.v0.o;

public final class Functions$b
implements o {
    public final c a;

    public Functions$b(c c10) {
        this.a = c10;
    }

    public Object a(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 2;
        if (n10 == n11) {
            c c10 = this.a;
            Object object2 = object[0];
            object = object[1];
            return c10.apply(object2, object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 2 expected but got ");
        int n12 = ((Object[])object).length;
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

