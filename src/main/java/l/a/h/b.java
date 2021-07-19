/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

public class b {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final Object[] c = new Object[0];

    private b() {
    }

    public static int a(int[] nArray, int n10, int n11) {
        n10 += -1;
        int n12 = 0;
        while (n12 <= n10) {
            int n13 = n12 + n10 >>> 1;
            int n14 = nArray[n13];
            if (n14 < n11) {
                n12 = ++n13;
                continue;
            }
            if (n14 > n11) {
                n10 = n13 += -1;
                continue;
            }
            return n13;
        }
        return ~n12;
    }

    public static int b(long[] lArray, int n10, long l10) {
        n10 += -1;
        int n11 = 0;
        while (n11 <= n10) {
            int n12 = n11 + n10 >>> 1;
            long l11 = lArray[n12];
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object < 0) {
                n11 = ++n12;
                continue;
            }
            if (object > 0) {
                n10 = n12 += -1;
                continue;
            }
            return n12;
        }
        return ~n11;
    }

    public static boolean c(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static int d(int n10) {
        int n11;
        for (int i10 = 4; i10 < (n11 = 32); ++i10) {
            n11 = (1 << i10) + -12;
            if (n10 > n11) continue;
            return n11;
        }
        return n10;
    }

    public static int e(int n10) {
        return l.a.h.b.d(n10 * 4) / 4;
    }

    public static int f(int n10) {
        return l.a.h.b.d(n10 * 8) / 8;
    }
}

