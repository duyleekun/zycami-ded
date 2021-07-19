/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.v0.n;
import e.a.v0.o;

public final class Functions$i
implements o {
    public final n a;

    public Functions$i(n n10) {
        this.a = n10;
    }

    public Object a(Object[] object) {
        int n10 = ((Object[])object).length;
        int n11 = 9;
        if (n10 == n11) {
            n n12 = this.a;
            Object object2 = object[0];
            Object object3 = object[1];
            Object object4 = object[2];
            Object object5 = object[3];
            Object object6 = object[4];
            Object object7 = object[5];
            Object object8 = object[6];
            Object object9 = object[7];
            Object object10 = object[8];
            return n12.a(object2, object3, object4, object5, object6, object7, object8, object9, object10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array of size 9 expected but got ");
        int n13 = ((Object[])object).length;
        stringBuilder.append(n13);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

