/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Method;
import k.n;
import k.p;
import k.w;

public final class n$p
extends n {
    private final Method a;
    private final int b;

    public n$p(Method method, int n10) {
        this.a = method;
        this.b = n10;
    }

    public void a(p object, Object object2) {
        if (object2 != null) {
            ((p)object).m(object2);
            return;
        }
        object = this.a;
        int n10 = this.b;
        Object[] objectArray = new Object[]{};
        throw w.o((Method)object, n10, "@Url parameter is null.", objectArray);
    }
}

