/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import d.v.e0.rd;
import d.v.e0.yd;
import java.util.List;

public class ge {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static float a(yd yd2, yd yd3, int n10) {
        float f10;
        float f11;
        float f12 = 0.0f;
        if (n10 == 0) {
            float f13;
            float f14 = yd2.a();
            n10 = (int)(yd.e(f14) ? 1 : 0);
            if (n10 != 0) {
                yd2 = null;
                f11 = 0.0f;
            } else {
                f11 = yd2.a();
            }
            f14 = yd3.a();
            n10 = (int)(yd.e(f14) ? 1 : 0);
            if (n10 != 0) {
                yd3 = null;
                f13 = 0.0f;
            } else {
                f13 = yd3.a();
            }
            f11 = ge.h(f11, f13);
            return 0.0f + f11;
        }
        int n11 = 1;
        if (n10 == n11) {
            float f15;
            float f16 = yd2.d();
            n10 = (int)(yd.e(f16) ? 1 : 0);
            if (n10 != 0) {
                yd2 = null;
                f11 = 0.0f;
            } else {
                f11 = yd2.d();
            }
            f16 = yd3.d();
            n10 = (int)(yd.e(f16) ? 1 : 0);
            if (n10 != 0) {
                yd3 = null;
                f15 = 0.0f;
            } else {
                f15 = yd3.d();
            }
            f11 = ge.h(f11, f15);
            return 0.0f + f11;
        }
        n11 = 2;
        if (n10 != n11) return f12;
        float f17 = yd2.b();
        n10 = (int)(yd.e(f17) ? 1 : 0);
        if (n10 != 0) {
            yd2 = null;
            f11 = 0.0f;
        } else {
            f11 = yd2.b();
        }
        f17 = yd3.b();
        n10 = (int)(yd.e(f17) ? 1 : 0);
        if (n10 != 0) {
            yd3 = null;
            f10 = 0.0f;
        } else {
            f10 = yd3.b();
        }
        f11 = ge.h(f11, f10);
        return 0.0f + f11;
    }

    public static int b(yd yd2, yd yd3) {
        float f10 = yd2.a();
        float f11 = yd2.d();
        float f12 = yd2.b();
        float f13 = yd3.a();
        float f14 = yd3.d();
        float f15 = yd3.b();
        int n10 = 1199570688;
        float f16 = 65535.0f;
        float f17 = f10 - f16;
        Object object = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
        if (object == false) {
            f10 = 0.0f;
        }
        if ((object = f11 == f16 ? 0 : (f11 > f16 ? 1 : -1)) == false) {
            f11 = 0.0f;
        }
        if ((object = f12 == f16 ? 0 : (f12 > f16 ? 1 : -1)) == false) {
            yd2 = null;
            f12 = 0.0f;
        }
        if ((object = f13 == f16 ? 0 : (f13 > f16 ? 1 : -1)) == false) {
            f13 = 0.0f;
        }
        if ((object = f14 == f16 ? 0 : (f14 > f16 ? 1 : -1)) == false) {
            f14 = 0.0f;
        }
        if ((n10 = (int)(f15 == f16 ? 0 : (f15 > f16 ? 1 : -1))) == 0) {
            yd3 = null;
            f15 = 0.0f;
        }
        f10 = ge.h(f13, f10);
        f11 = ge.h(f14, f11);
        f12 = ge.h(f15, f12);
        double d10 = f10;
        double d11 = 2.0;
        d10 = Math.pow(d10, d11);
        double d12 = Math.pow(f11, d11);
        double d13 = Math.pow(f12, d11);
        return (int)Math.sqrt((d10 += d12) + d13);
    }

    public static List c(long l10, List list) {
        int n10;
        long l11 = 0L;
        double d10 = 0.0;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object <= 0) {
            return list;
        }
        d10 = ge.d(list);
        double d11 = l10;
        d10 /= d11;
        for (int i10 = 1; i10 < (n10 = list.size()); ++i10) {
            n10 = i10 + -1;
            yd yd2 = (yd)list.get(n10);
            yd yd3 = (yd)list.get(i10);
            double d12 = (double)ge.b(yd2, yd3) / d10;
            n10 = (int)d12;
            yd3.h(n10);
        }
        return list;
    }

    public static double d(List list) {
        int n10;
        double d10 = 0.0;
        int n11 = 0;
        while (n11 < (n10 = list.size() + -1)) {
            yd yd2 = (yd)list.get(n11);
            yd yd3 = (yd)list.get(++n11);
            n10 = ge.b(yd2, yd3);
            double d11 = n10;
            d10 += d11;
        }
        return d10;
    }

    public static boolean e(int n10, int n11) {
        int n12 = 1;
        if ((n10 &= (n11 = n12 << n11)) != n11) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static boolean f(int n10, int ... nArray) {
        for (int n11 : nArray) {
            if ((n11 = (int)(ge.e(n10, n11) ? 1 : 0)) == 0) continue;
            return true;
        }
        return false;
    }

    public static Pair g(rd object) {
        int n10 = ((rd)object).b();
        Integer n11 = n10 >>> 8;
        object = n10 & 0xFF;
        return Pair.create(n11, object);
    }

    private static float h(float f10, float f11) {
        float f12;
        float f13 = (f10 = Math.abs(f11 -= f10)) - (f12 = 180.0f);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object > 0) {
            f11 = Math.abs(f11);
            return 360.0f - f11;
        }
        return Math.abs(f11);
    }

    public static boolean i(yd ... ydArray) {
        block1: {
            int n10;
            int n11;
            yd yd2;
            yd yd3;
            int n12;
            int n13 = 0;
            do {
                n12 = ydArray.length;
                n10 = 1;
                if (n13 >= (n12 -= n10)) break block1;
            } while ((n12 = ge.b(yd3 = ydArray[n13], yd2 = ydArray[++n13])) < (n11 = 5));
            return n10 != 0;
        }
        return false;
    }

    public static float j(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    public static int k(int n10, int n11, int n12) {
        return Math.min(Math.max(n10, n11), n12);
    }
}

