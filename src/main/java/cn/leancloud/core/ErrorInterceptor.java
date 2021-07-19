/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import g.a0;
import g.c0;
import g.u;
import g.u$a;

public class ErrorInterceptor
implements u {
    private void throwError(c0 c02, int n10) {
    }

    public c0 intercept(u$a object) {
        int n10;
        a0 a02 = object.C();
        int n11 = ((c0)(object = object.c(a02))).v0();
        if (n11 >= (n10 = 300)) {
            this.throwError((c0)object, n11);
        }
        return object;
    }
}

