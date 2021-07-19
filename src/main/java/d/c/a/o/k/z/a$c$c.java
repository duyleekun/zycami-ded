/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.z;

import d.c.a.o.k.z.a$c;

public class a$c$c
implements a$c {
    public void a(Throwable throwable) {
        if (throwable == null) {
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Request threw uncaught throwable", throwable);
        throw runtimeException;
    }
}

