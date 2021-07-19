/*
 * Decompiled with CFR 0.151.
 */
package f.j2;

import f.h2.t.f0;
import f.j2.f;
import f.m2.n;

public final class b
implements f {
    private Object a;

    public Object a(Object object, n object2) {
        f0.p(object2, "property");
        object = this.a;
        if (object != null) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Property ");
        object2 = object2.getName();
        stringBuilder.append((String)object2);
        stringBuilder.append(" should be initialized before get.");
        object2 = stringBuilder.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public void b(Object object, n n10, Object object2) {
        f0.p(n10, "property");
        f0.p(object2, "value");
        this.a = object2;
    }
}

