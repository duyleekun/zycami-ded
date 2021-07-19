/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.j;
import e.a.v0.o;

public final class Functions$e
implements o {
    private final j a;

    public Functions$e(j j10) {
        this.a = j10;
    }

    public Object a(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 5;
        if (n10 == n11) {
            j j10 = this.a;
            Object object2 = object[0];
            Object object3 = object[1];
            Object object4 = object[2];
            Object object5 = object[3];
            Object object6 = object[4];
            return j10.a(object2, object3, object4, object5, object6);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 5 expected but got ");
        int n12 = ((Object[])object).length;
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

