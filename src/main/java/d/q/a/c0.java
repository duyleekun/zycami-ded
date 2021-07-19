/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.OutsideScopeException;
import d.q.a.b0;
import d.q.a.c;
import d.q.a.n;
import e.a.a;
import e.a.v0.g;

public final class c0 {
    private c0() {
    }

    public static a a(b0 b02) {
        c c10 = new c(b02);
        return a.G(c10);
    }

    public static /* synthetic */ e.a.g b(b0 b02) {
        try {
            return b02.a();
        }
        catch (OutsideScopeException outsideScopeException) {
            g g10 = n.c();
            if (g10 != null) {
                g10.accept(outsideScopeException);
                return a.y();
            }
            return a.V(outsideScopeException);
        }
    }
}

