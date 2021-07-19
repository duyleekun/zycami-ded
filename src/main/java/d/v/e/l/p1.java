/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

public class p1 {
    private static long a;

    public static boolean a() {
        return p1.b(500L);
    }

    public static boolean b(long l10) {
        long l11;
        long l12 = System.currentTimeMillis();
        long l13 = a;
        long l14 = 0L;
        long l15 = l14 - (l13 = l12 - l13);
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0 && (l11 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1)) < 0) {
            return true;
        }
        a = l12;
        return false;
    }

    public static void c() {
        a = System.currentTimeMillis();
    }

    public static void d(long l10) {
        a = System.currentTimeMillis() + l10;
    }
}

