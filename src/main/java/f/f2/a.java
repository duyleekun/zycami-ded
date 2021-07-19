/*
 * Decompiled with CFR 0.151.
 */
package f.f2;

import f.h2.s.l;
import f.h2.t.c0;
import f.k;

public final class a {
    public static final void a(AutoCloseable autoCloseable, Throwable throwable) {
        if (autoCloseable != null) {
            if (throwable == null) {
                autoCloseable.close();
            } else {
                try {
                    autoCloseable.close();
                }
                catch (Throwable throwable2) {
                    k.a(throwable, throwable2);
                }
            }
        }
    }

    private static final Object b(AutoCloseable autoCloseable, l object) {
        int n10 = 1;
        try {
            object = object.invoke(autoCloseable);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                c0.d(n10);
                a.a(autoCloseable, throwable);
                c0.c(n10);
                throw throwable2;
            }
        }
        c0.d(n10);
        a.a(autoCloseable, null);
        c0.c(n10);
        return object;
    }
}

