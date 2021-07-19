/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.u;
import f.h2.t.u0;
import f.m2.s;

public final class v0$a {
    private v0$a() {
    }

    public /* synthetic */ v0$a(u u10) {
        this();
    }

    public final String a(s object) {
        f0.p(object, "typeParameter");
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = object.h();
        int[] nArray = u0.a;
        int n10 = object2.ordinal();
        n10 = nArray[n10];
        int n11 = 2;
        if (n10 != n11) {
            n11 = 3;
            if (n10 == n11) {
                object2 = "out ";
                stringBuilder.append((String)object2);
            }
        } else {
            object2 = "in ";
            stringBuilder.append((String)object2);
        }
        object = object.getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        f0.o(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }
}

