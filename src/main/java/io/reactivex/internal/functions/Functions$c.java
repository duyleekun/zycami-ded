/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.h;
import e.a.v0.o;

public final class Functions$c
implements o {
    public final h a;

    public Functions$c(h h10) {
        this.a = h10;
    }

    public Object a(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 3;
        if (n10 == n11) {
            h h10 = this.a;
            Object object2 = object[0];
            Object object3 = object[1];
            object = object[2];
            return h10.a(object2, object3, object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 3 expected but got ");
        int n12 = ((Object[])object).length;
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

