/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.l;
import e.a.v0.o;

public final class Functions$g
implements o {
    public final l a;

    public Functions$g(l l10) {
        this.a = l10;
    }

    public Object a(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 7;
        if (n10 == n11) {
            l l10 = this.a;
            Object object2 = object[0];
            Object object3 = object[1];
            Object object4 = object[2];
            Object object5 = object[3];
            Object object6 = object[4];
            Object object7 = object[5];
            Object object8 = object[6];
            return l10.a(object2, object3, object4, object5, object6, object7, object8);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 7 expected but got ");
        int n12 = ((Object[])object).length;
        stringBuilder.append(n12);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

