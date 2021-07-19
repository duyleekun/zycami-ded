/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u.o;

public final class b {
    private static final boolean a = false;
    private static final int b = 127;

    private b() {
    }

    public static void a(String string2) {
    }

    public static void b(String string2, Object object) {
    }

    public static void c(String string2, Object object, Object object2) {
    }

    public static void d(String string2, Object object, Object object2, Object object3) {
    }

    public static void e() {
    }

    private static String f(String string2) {
        int n10;
        int n11 = string2.length();
        if (n11 > (n10 = 127)) {
            n11 = 0;
            n10 = 126;
            string2 = string2.substring(0, n10);
        }
        return string2;
    }
}

