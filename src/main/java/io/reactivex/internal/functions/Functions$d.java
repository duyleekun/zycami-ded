/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.i;
import e.a.v0.o;

public final class Functions$d
implements o {
    public final i a;

    public Functions$d(i i10) {
        this.a = i10;
    }

    public Object a(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 4;
        if (n10 == n11) {
            i i10 = this.a;
            Object object2 = object[0];
            Object object3 = object[1];
            Object object4 = object[2];
            object = object[3];
            return i10.a(object2, object3, object4, object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 4 expected but got ");
        int n12 = ((Object[])object).length;
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

