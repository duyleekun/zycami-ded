/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.m;
import e.a.v0.o;

public final class Functions$h
implements o {
    public final m a;

    public Functions$h(m m10) {
        this.a = m10;
    }

    public Object a(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 8;
        if (n10 == n11) {
            m m10 = this.a;
            Object object2 = object[0];
            Object object3 = object[1];
            Object object4 = object[2];
            Object object5 = object[3];
            Object object6 = object[4];
            Object object7 = object[5];
            Object object8 = object[6];
            Object object9 = object[7];
            return m10.a(object2, object3, object4, object5, object6, object7, object8, object9);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 8 expected but got ");
        int n12 = ((Object[])object).length;
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

