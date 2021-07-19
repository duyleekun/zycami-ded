/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.s;
import java.lang.reflect.Method;
import k.n;
import k.p;
import k.w;

public final class n$h
extends n {
    private final Method a;
    private final int b;

    public n$h(Method method, int n10) {
        this.a = method;
        this.b = n10;
    }

    public void d(p object, s s10) {
        if (s10 != null) {
            ((p)object).c(s10);
            return;
        }
        object = this.a;
        int n10 = this.b;
        Object[] objectArray = new Object[]{};
        throw w.o((Method)object, n10, "Headers parameter must not be null.", objectArray);
    }
}

