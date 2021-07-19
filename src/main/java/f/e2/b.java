/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.h2.s.l;
import f.h2.t.c0;
import f.k;
import java.io.Closeable;

public final class b {
    public static final void a(Closeable closeable, Throwable throwable) {
        if (closeable != null) {
            if (throwable == null) {
                closeable.close();
            } else {
                try {
                    closeable.close();
                }
                catch (Throwable throwable2) {
                    k.a(throwable, throwable2);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static final Object b(Closeable closeable, l object) {
        boolean bl2 = false;
        int n10 = 1;
        try {
            object = object.invoke(closeable);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                block9: {
                    block10: {
                        c0.d(n10);
                        bl2 = f.d2.l.a(n10, n10, 0);
                        if (bl2) break block10;
                        if (closeable == null) break block9;
                        try {
                            closeable.close();
                            break block9;
                        }
                        catch (Throwable throwable3) {}
                    }
                    b.a(closeable, throwable);
                }
                c0.c(n10);
                throw throwable2;
            }
        }
        c0.d(n10);
        bl2 = f.d2.l.a(n10, n10, 0);
        if (bl2) {
            bl2 = false;
            b.a(closeable, null);
        } else if (closeable != null) {
            closeable.close();
        }
        c0.c(n10);
        return object;
    }
}

