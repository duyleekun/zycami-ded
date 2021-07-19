/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.oe;

import d.v.e0.yd;
import java.util.List;

public class n {
    private static final float[][] a;

    static {
        float[] fArray;
        float[] fArray2;
        float[][] fArrayArray = new float[6][];
        int n10 = 3;
        float[] fArray3 = fArray2 = new float[n10];
        fArray2[0] = 1.0f;
        fArray3[1] = 0.0f;
        fArray3[2] = 0.0f;
        fArrayArray[0] = fArray2;
        float[] fArray4 = fArray2 = new float[n10];
        fArray2[0] = -1.0f;
        fArray4[1] = 0.0f;
        fArray4[2] = 0.0f;
        fArrayArray[1] = fArray2;
        float[] fArray5 = fArray2 = new float[n10];
        fArray2[0] = 0.0f;
        fArray5[1] = 1.0f;
        fArray5[2] = 0.0f;
        fArrayArray[2] = fArray2;
        float[] fArray6 = fArray2 = new float[n10];
        fArray2[0] = 0.0f;
        fArray6[1] = -1.0f;
        fArray6[2] = 0.0f;
        fArrayArray[n10] = fArray2;
        float[] fArray7 = fArray2 = new float[n10];
        fArray2[0] = 0.0f;
        fArray7[1] = 0.0f;
        fArray7[2] = 1.0f;
        fArrayArray[4] = fArray2;
        float[] fArray8 = fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray8[1] = 0.0f;
        fArray8[2] = -1.0f;
        fArrayArray[5] = fArray;
        a = fArrayArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static float a(yd yd2, yd yd3, int n10) {
        float f10;
        float f11;
        float f12 = 65535.0f;
        float f13 = 0.0f;
        if (n10 == 0) {
            float f14;
            float f15 = yd2.a();
            float f16 = f15 - f12;
            n10 = (int)(f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1));
            if (n10 == 0) {
                yd2 = null;
                f11 = 0.0f;
            } else {
                f11 = yd2.a();
            }
            f15 = yd3.a();
            n10 = (int)(f15 == f12 ? 0 : (f15 > f12 ? 1 : -1));
            if (n10 == 0) {
                yd3 = null;
                f14 = 0.0f;
            } else {
                f14 = yd3.a();
            }
            f11 = n.e(f11, f14);
            return 0.0f + f11;
        }
        int n11 = 1;
        if (n10 == n11) {
            float f17;
            float f18 = yd2.d();
            float f19 = f18 - f12;
            n10 = (int)(f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1));
            if (n10 == 0) {
                yd2 = null;
                f11 = 0.0f;
            } else {
                f11 = yd2.d();
            }
            f18 = yd3.d();
            n10 = (int)(f18 == f12 ? 0 : (f18 > f12 ? 1 : -1));
            if (n10 == 0) {
                yd3 = null;
                f17 = 0.0f;
            } else {
                f17 = yd3.d();
            }
            f11 = n.e(f11, f17);
            return 0.0f + f11;
        }
        n11 = 2;
        if (n10 != n11) return f13;
        float f20 = yd2.b();
        float f21 = f20 - f12;
        n10 = (int)(f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1));
        if (n10 == 0) {
            yd2 = null;
            f11 = 0.0f;
        } else {
            f11 = yd2.b();
        }
        f20 = yd3.b();
        n10 = (int)(f20 == f12 ? 0 : (f20 > f12 ? 1 : -1));
        if (n10 == 0) {
            yd3 = null;
            f10 = 0.0f;
        } else {
            f10 = yd3.b();
        }
        f11 = n.e(f11, f10);
        return 0.0f + f11;
    }

    public static boolean b(List object, int n10) {
        Class<n> clazz = n.class;
        synchronized (clazz) {
            Object object2;
            int n11;
            int n12;
            int n13;
            block34: {
                n13 = 0;
                n12 = object.size();
                n11 = 4;
                object2 = 5.6E-45f;
                if (n12 == n11) break block34;
                return false;
            }
            Object object3 = object.get(0);
            object3 = (Integer)object3;
            n12 = (Integer)object3;
            float f10 = n12;
            n11 = 1166016512;
            object2 = 4096.0f;
            f10 /= object2;
            int n14 = 1;
            Object object4 = object.get(n14);
            object4 = (Integer)object4;
            int n15 = (Integer)object4;
            float f11 = (float)n15 / object2;
            int n16 = 2;
            Object object5 = object.get(n16);
            object5 = (Integer)object5;
            int n17 = (Integer)object5;
            float f12 = (float)n17 / object2;
            n11 = 3;
            object2 = 4.2E-45f;
            object = object.get(n11);
            object = (Integer)object;
            int n18 = (Integer)object;
            float f13 = n18;
            n11 = 1120403456;
            f13 /= 100.0f;
            object2 = f10 * f10;
            float f14 = f11 * f11;
            object2 += f14;
            f14 = f12 * f12;
            double d10 = object2 += f14;
            d10 = Math.sqrt(d10);
            object2 = (float)d10;
            try {
                f13 = Math.abs(f13);
                f14 = 0.3f;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (Exception exception) {
                return false;
            }
            n18 = (int)(f13 == f14 ? 0 : (f13 < f14 ? -1 : 1));
            if (n18 <= 0) {
                n18 = 1065353216;
                f13 = 1.0f;
                object2 -= f13;
                f13 = Math.abs(object2);
                n18 = (int)(f13 == f14 ? 0 : (f13 < f14 ? -1 : 1));
                if (n18 <= 0) {
                    object = a;
                    Object object6 = object[n10];
                    object2 = object6[0];
                    f10 -= object2;
                    f10 = Math.abs(f10);
                    n12 = (int)(f10 == f14 ? 0 : (f10 < f14 ? -1 : 1));
                    if (n12 <= 0) {
                        object3 = object[n10];
                        f10 = (float)object3[n14];
                        f11 -= f10;
                        f10 = Math.abs(f11);
                        n12 = (int)(f10 == f14 ? 0 : (f10 < f14 ? -1 : 1));
                        if (n12 <= 0) {
                            object = object[n10];
                            f13 = (float)object[n16];
                            f12 -= f13;
                            f13 = Math.abs(f12);
                            n18 = (int)(f13 == f14 ? 0 : (f13 < f14 ? -1 : 1));
                            if (n18 <= 0) {
                                n13 = n14;
                            }
                        }
                    }
                }
            }
            return n13 != 0;
        }
    }

    public static int c(yd yd2, yd yd3) {
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
        f10 = n.e(f13, f10);
        f11 = n.e(f14, f11);
        f12 = n.e(f15, f12);
        double d10 = f10;
        double d11 = 2.0;
        d10 = Math.pow(d10, d11);
        double d12 = Math.pow(f11, d11);
        double d13 = Math.pow(f12, d11);
        return (int)Math.sqrt((d10 += d12) + d13);
    }

    public static double d(List list) {
        int n10;
        double d10 = 0.0;
        int n11 = 0;
        while (n11 < (n10 = list.size() + -1)) {
            yd yd2 = (yd)list.get(n11);
            yd yd3 = (yd)list.get(++n11);
            n10 = n.c(yd2, yd3);
            double d11 = n10;
            d10 += d11;
        }
        return d10;
    }

    private static float e(float f10, float f11) {
        float f12;
        float f13 = (f10 = Math.abs(f11 -= f10)) - (f12 = 180.0f);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object > 0) {
            f11 = Math.abs(f11);
            return 360.0f - f11;
        }
        return Math.abs(f11);
    }

    public static boolean f(List list) {
        block1: {
            int n10;
            int n11;
            yd yd2;
            yd yd3;
            int n12;
            int n13 = 0;
            do {
                n12 = list.size();
                n10 = 1;
                if (n13 >= (n12 -= n10)) break block1;
            } while ((n12 = n.c(yd3 = (yd)list.get(n13), yd2 = (yd)list.get(++n13))) < (n11 = 5));
            return n10 != 0;
        }
        return false;
    }

    public static String g(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return "";
                        }
                        return ".covrx";
                    }
                    return ".cov";
                }
                return ".update";
            }
            return ".ccs";
        }
        return ".ptz";
    }
}

