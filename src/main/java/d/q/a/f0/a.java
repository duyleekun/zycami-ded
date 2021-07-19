/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.f0;

import e.a.v0.e;
import java.util.Objects;

public final class a {
    private static volatile e a;
    public static volatile boolean b;

    private a() {
    }

    public static boolean a() {
        return b;
    }

    public static void b() {
        b = true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean c(e e10) {
        Objects.requireNonNull(e10, "defaultChecker == null");
        e e11 = a;
        if (e11 != null) return e11.getAsBoolean();
        try {
            return e10.getAsBoolean();
        }
        catch (Exception exception) {
            throw e.a.t0.a.a(exception);
        }
    }

    public static void d() {
        d.q.a.f0.a.e(null);
    }

    public static void e(e object) {
        boolean bl2 = b;
        if (!bl2) {
            a = object;
            return;
        }
        object = new IllegalStateException("Plugins can't be changed anymore");
        throw object;
    }
}

