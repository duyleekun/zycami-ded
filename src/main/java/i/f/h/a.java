/*
 * Decompiled with CFR 0.151.
 */
package i.f.h;

import i.f.c.b;
import i.f.c.c;
import i.f.c.d;
import i.f.c.e;
import i.f.c.l;
import i.f.c.m;
import i.f.c.o;
import i.f.c.p;
import i.f.c.t;
import i.f.c.u;
import i.f.c.v;
import i.f.c.w;
import i.f.c.x;
import i.f.c.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.opencv.core.Mat;

public class a {
    public static Mat A(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.A;
            int n12 = 1;
            mat = new Mat(n10, n12, n11);
            n11 = n10 * 2;
            int[] nArray = new int[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                int n13;
                int n14;
                Mat mat2 = (Mat)list.get(i10);
                long l10 = mat2.a;
                int n15 = i10 * 2;
                nArray[n15] = n14 = (int)(l10 >> 32);
                long l11 = -1;
                nArray[n15 += n12] = n13 = (int)(l10 &= l11);
            }
            mat.m0(0, 0, nArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat B(List list) {
        return a.I(list, 6);
    }

    public static Mat C(List list) {
        return a.I(list, 5);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Mat D(List object, int n10) {
        Mat mat;
        int n11 = object != null ? object.size() : 0;
        if (n11 <= 0) {
            return new Mat();
        }
        int n12 = 4;
        int n13 = 1;
        if (n10 != n12) {
            n12 = 5;
            if (n10 != n12) {
                n12 = 6;
                if (n10 != n12) {
                    object = new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
                    throw object;
                }
                n12 = i.f.c.a.J;
                mat = new Mat(n11, n13, n12);
                n12 = n11 * 3;
                double[] dArray = new double[n12];
                n13 = 0;
                while (true) {
                    double d10;
                    double d11;
                    if (n13 >= n11) {
                        mat.k0(0, 0, dArray);
                        return mat;
                    }
                    t t10 = (t)object.get(n13);
                    int n14 = n13 * 3;
                    dArray[n14] = d11 = t10.a;
                    int n15 = n14 + 1;
                    dArray[n15] = d10 = t10.b;
                    dArray[n14 += 2] = d11 = t10.c;
                    ++n13;
                }
            }
            n12 = i.f.c.a.F;
            mat = new Mat(n11, n13, n12);
            n12 = n11 * 3;
            float[] fArray = new float[n12];
            n13 = 0;
            while (true) {
                float f10;
                float f11;
                float f12;
                if (n13 >= n11) {
                    mat.l0(0, 0, fArray);
                    return mat;
                }
                t t11 = (t)object.get(n13);
                int n16 = n13 * 3;
                fArray[n16] = f12 = (float)t11.a;
                int n17 = n16 + 1;
                double d12 = t11.b;
                fArray[n17] = f11 = (float)d12;
                double d13 = t11.c;
                fArray[n16 += 2] = f10 = (float)d13;
                ++n13;
            }
        }
        n12 = i.f.c.a.B;
        mat = new Mat(n11, n13, n12);
        n12 = n11 * 3;
        int[] nArray = new int[n12];
        n13 = 0;
        while (true) {
            int n18;
            int n19;
            int n20;
            if (n13 >= n11) {
                mat.m0(0, 0, nArray);
                return mat;
            }
            t t12 = (t)object.get(n13);
            int n21 = n13 * 3;
            nArray[n21] = n20 = (int)t12.a;
            n20 = n21 + 1;
            double d14 = t12.b;
            nArray[n20] = n19 = (int)d14;
            double d15 = t12.c;
            nArray[n21 += 2] = n18 = (int)d15;
            ++n13;
        }
    }

    public static Mat E(List list) {
        return a.D(list, 6);
    }

    public static Mat F(List list) {
        return a.D(list, 5);
    }

    public static Mat G(List list) {
        return a.D(list, 4);
    }

    public static Mat H(List list) {
        return a.I(list, 4);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Mat I(List object, int n10) {
        Mat mat;
        int n11 = object != null ? object.size() : 0;
        if (n11 <= 0) {
            return new Mat();
        }
        int n12 = 4;
        int n13 = 1;
        if (n10 != n12) {
            n12 = 5;
            if (n10 != n12) {
                n12 = 6;
                if (n10 != n12) {
                    object = new IllegalArgumentException("'typeDepth' can be CV_32S, CV_32F or CV_64F");
                    throw object;
                }
                n12 = i.f.c.a.I;
                mat = new Mat(n11, n13, n12);
                n12 = n11 * 2;
                double[] dArray = new double[n12];
                int n14 = 0;
                while (true) {
                    double d10;
                    if (n14 >= n11) {
                        mat.k0(0, 0, dArray);
                        return mat;
                    }
                    u u10 = (u)object.get(n14);
                    int n15 = n14 * 2;
                    dArray[n15] = d10 = u10.a;
                    dArray[n15 += n13] = d10 = u10.b;
                    ++n14;
                }
            }
            n12 = i.f.c.a.E;
            mat = new Mat(n11, n13, n12);
            n12 = n11 * 2;
            float[] fArray = new float[n12];
            int n16 = 0;
            while (true) {
                float f10;
                float f11;
                if (n16 >= n11) {
                    mat.l0(0, 0, fArray);
                    return mat;
                }
                u u11 = (u)object.get(n16);
                int n17 = n16 * 2;
                fArray[n17] = f11 = (float)u11.a;
                double d11 = u11.b;
                fArray[n17 += n13] = f10 = (float)d11;
                ++n16;
            }
        }
        n12 = i.f.c.a.A;
        mat = new Mat(n11, n13, n12);
        n12 = n11 * 2;
        int[] nArray = new int[n12];
        int n18 = 0;
        while (true) {
            int n19;
            int n20;
            if (n18 >= n11) {
                mat.m0(0, 0, nArray);
                return mat;
            }
            u u12 = (u)object.get(n18);
            int n21 = n18 * 2;
            nArray[n21] = n20 = (int)u12.a;
            double d12 = u12.b;
            nArray[n21 += n13] = n19 = (int)d12;
            ++n18;
        }
    }

    public static Mat J(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.K;
            mat = new Mat(n10, 1, n11);
            n11 = n10 * 4;
            double[] dArray = new double[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10;
                double d11;
                v v10 = (v)list.get(i10);
                int n12 = i10 * 4;
                dArray[n12] = d11 = v10.a;
                int n13 = n12 + 1;
                dArray[n13] = d10 = v10.b;
                n13 = n12 + 2;
                dArray[n13] = d10 = v10.c;
                dArray[n12 += 3] = d11 = v10.d;
            }
            mat.k0(0, 0, dArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat K(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.C;
            mat = new Mat(n10, 1, n11);
            n11 = n10 * 4;
            int[] nArray = new int[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                int n12;
                int n13;
                int n14;
                w w10 = (w)list.get(i10);
                int n15 = i10 * 4;
                nArray[n15] = n14 = w10.a;
                n14 = n15 + 1;
                nArray[n14] = n13 = w10.b;
                n14 = n15 + 2;
                nArray[n14] = n13 = w10.c;
                nArray[n15 += 3] = n12 = w10.d;
            }
            mat.m0(0, 0, nArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat L(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.d(5);
            mat = new Mat(n10, 1, n11);
            n11 = n10 * 5;
            float[] fArray = new float[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                float f11;
                float f12;
                float f13;
                x x10 = (x)list.get(i10);
                int n12 = i10 * 5;
                u u10 = x10.a;
                fArray[n12] = f13 = (float)u10.a;
                int n13 = n12 + 1;
                fArray[n13] = f12 = (float)u10.b;
                int n14 = n12 + 2;
                z z10 = x10.b;
                double d10 = z10.a;
                fArray[n14] = f11 = (float)d10;
                n14 = n12 + 3;
                double d11 = z10.b;
                fArray[n14] = f13 = (float)d11;
                double d12 = x10.c;
                fArray[n12 += 4] = f10 = (float)d12;
            }
            mat.l0(0, 0, fArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat M(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.n;
            mat = new Mat(n10, 1, n11);
            byte[] byArray = new byte[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                byte by2;
                Byte by3 = (Byte)list.get(i10);
                byArray[i10] = by2 = by3.byteValue();
            }
            mat.i0(0, 0, byArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat N(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.H;
            mat = new Mat(n10, 1, n11);
            double[] dArray = new double[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10;
                Double d11 = (Double)list.get(i10);
                dArray[i10] = d10 = d11.doubleValue();
            }
            mat.k0(0, 0, dArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat O(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.D;
            mat = new Mat(n10, 1, n11);
            float[] fArray = new float[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                Float f11 = (Float)list.get(i10);
                fArray[i10] = f10 = f11.floatValue();
            }
            mat.l0(0, 0, fArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat P(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.z;
            mat = new Mat(n10, 1, n11);
            int[] nArray = new int[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                int n12;
                Integer n13 = (Integer)list.get(i10);
                nArray[i10] = n12 = n13.intValue();
            }
            mat.m0(0, 0, nArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat Q(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.j;
            mat = new Mat(n10, 1, n11);
            byte[] byArray = new byte[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                byte by2;
                Byte by3 = (Byte)list.get(i10);
                byArray[i10] = by2 = by3.byteValue();
            }
            mat.i0(0, 0, byArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat R(List object, List list) {
        e e10;
        int n10;
        if (object != null) {
            n10 = object.size();
        } else {
            n10 = 0;
            e10 = null;
        }
        if (n10 > 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                e10 = (e)object.next();
                list.add(e10);
            }
            object = a.A(list);
        } else {
            object = new Mat();
        }
        return object;
    }

    public static Mat S(List object, List list) {
        l l10;
        int n10;
        if (object != null) {
            n10 = object.size();
        } else {
            n10 = 0;
            l10 = null;
        }
        if (n10 > 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                l10 = (l)object.next();
                list.add(l10);
            }
            object = a.A(list);
        } else {
            object = new Mat();
        }
        return object;
    }

    public static Mat T(List object, List list) {
        m m10;
        int n10;
        if (object != null) {
            n10 = object.size();
        } else {
            n10 = 0;
            m10 = null;
        }
        if (n10 > 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                m10 = (m)object.next();
                list.add(m10);
            }
            object = a.A(list);
        } else {
            object = new Mat();
        }
        return object;
    }

    public static Mat U(List object, List list) {
        o o10;
        int n10;
        if (object != null) {
            n10 = object.size();
        } else {
            n10 = 0;
            o10 = null;
        }
        if (n10 > 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                o10 = (o)object.next();
                list.add(o10);
            }
            object = a.A(list);
        } else {
            object = new Mat();
        }
        return object;
    }

    public static Mat V(List object, List list) {
        p p10;
        int n10;
        if (object != null) {
            n10 = object.size();
        } else {
            n10 = 0;
            p10 = null;
        }
        if (n10 > 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                p10 = (p)object.next();
                list.add(p10);
            }
            object = a.A(list);
        } else {
            object = new Mat();
        }
        return object;
    }

    public static Mat W(List object, List list) {
        d d10;
        int n10;
        if (object != null) {
            n10 = object.size();
        } else {
            n10 = 0;
            d10 = null;
        }
        if (n10 > 0) {
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                d10 = (d)object.next();
                list.add(d10);
            }
            object = a.A(list);
        } else {
            object = new Mat();
        }
        return object;
    }

    public static void a(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.K;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                n11 = n10 * 4;
                double[] dArray = new double[n11];
                ((Mat)object).K(0, 0, dArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    int n13 = n12 * 4;
                    double d10 = dArray[n13];
                    int n14 = (int)d10;
                    int n15 = n13 + 1;
                    double d11 = dArray[n15];
                    n15 = (int)d11;
                    int n16 = n13 + 2;
                    double d12 = dArray[n16];
                    n16 = (int)d12;
                    double d13 = dArray[n13 += 3];
                    float f10 = (float)d13;
                    object = new b(n14, n15, n16, f10);
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_64FC4 != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("Output List can't be null");
        throw object;
    }

    public static void b(Mat object, List object2) {
        if (object2 != null) {
            int n10;
            int n11 = ((Mat)object).B0();
            int n12 = i.f.c.a.f(7);
            if (n12 == (n10 = ((Mat)object).Q0()) && (n12 = ((Mat)object).l()) == (n10 = 1)) {
                object2.clear();
                n12 = n11 * 7;
                double[] dArray = new double[n12];
                ((Mat)object).K(0, 0, dArray);
                for (n10 = 0; n10 < n11; ++n10) {
                    int n13 = n10 * 7;
                    double d10 = dArray[n13];
                    float f10 = (float)d10;
                    int n14 = n13 + 1;
                    double d11 = dArray[n14];
                    float f11 = (float)d11;
                    int n15 = n13 + 2;
                    double d12 = dArray[n15];
                    float f12 = (float)d12;
                    int n16 = n13 + 3;
                    double d13 = dArray[n16];
                    float f13 = (float)d13;
                    int n17 = n13 + 4;
                    double d14 = dArray[n17];
                    float f14 = (float)d14;
                    int n18 = n13 + 5;
                    double d15 = dArray[n18];
                    n18 = (int)d15;
                    double d16 = dArray[n13 += 6];
                    int n19 = (int)d16;
                    object = new c(f10, f11, f12, f13, f14, n18, n19);
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_64FC(7) != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("Output List can't be null");
        throw object;
    }

    public static void c(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.A;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                n11 = n10 * 2;
                int[] nArray = new int[n11];
                ((Mat)object).M(0, 0, nArray);
                for (int i10 = 0; i10 < n10; ++i10) {
                    int n13 = i10 * 2;
                    int n14 = nArray[n13];
                    long l10 = n14;
                    int n15 = 32;
                    l10 <<= n15;
                    n13 += n12;
                    n13 = nArray[n13];
                    long l11 = n13;
                    long l12 = 0xFFFFFFFFL;
                    object = new Mat(l10 |= (l11 &= l12));
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_32SC2 != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("mats == null");
        throw object;
    }

    public static void d(Mat object, List object2) {
        block4: {
            block5: {
                block9: {
                    block7: {
                        int n10;
                        int n11;
                        int n12;
                        int n13;
                        int n14;
                        block8: {
                            block6: {
                                if (object2 == null) break block4;
                                n14 = ((Mat)object).B0();
                                n13 = ((Mat)object).Q0();
                                n12 = ((Mat)object).l();
                                if (n12 != (n11 = 1)) break block5;
                                object2.clear();
                                n12 = i.f.c.a.A;
                                if (n13 != n12) break block6;
                                n13 = n14 * 2;
                                int[] nArray = new int[n13];
                                ((Mat)object).M(0, 0, nArray);
                                for (n10 = 0; n10 < n14; ++n10) {
                                    n12 = n10 * 2;
                                    int n15 = nArray[n12];
                                    double d10 = n15;
                                    n12 += n11;
                                    n12 = nArray[n12];
                                    double d11 = n12;
                                    object = new u(d10, d11);
                                    object2.add(object);
                                }
                                break block7;
                            }
                            n12 = i.f.c.a.E;
                            if (n13 != n12) break block8;
                            n13 = n14 * 2;
                            float[] fArray = new float[n13];
                            ((Mat)object).L(0, 0, fArray);
                            while (n10 < n14) {
                                n12 = n10 * 2;
                                float f10 = fArray[n12];
                                double d12 = f10;
                                float f11 = fArray[n12 += n11];
                                double d13 = f11;
                                object = new u(d12, d13);
                                object2.add(object);
                                ++n10;
                            }
                            break block7;
                        }
                        n12 = i.f.c.a.I;
                        if (n13 == n12) {
                            n13 = n14 * 2;
                            double[] dArray = new double[n13];
                            ((Mat)object).K(0, 0, dArray);
                            while (n10 < n14) {
                                n12 = n10 * 2;
                                double d14 = dArray[n12];
                                double d15 = dArray[n12 += n11];
                                object = new u(d14, d15);
                                object2.add(object);
                                ++n10;
                            }
                        }
                        break block9;
                    }
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Input Mat should be of CV_32SC2, CV_32FC2 or CV_64FC2 type\n");
                stringBuilder.append(object);
                object = stringBuilder.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Input Mat should have one column\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("Output List can't be null");
        throw object;
    }

    public static void e(Mat mat, List list) {
        a.d(mat, list);
    }

    public static void f(Mat mat, List list) {
        a.d(mat, list);
    }

    public static void g(Mat object, List object2) {
        block4: {
            block5: {
                block9: {
                    block7: {
                        int n10;
                        int n11;
                        int n12;
                        int n13;
                        block8: {
                            block6: {
                                if (object2 == null) break block4;
                                n13 = ((Mat)object).B0();
                                n12 = ((Mat)object).Q0();
                                n11 = ((Mat)object).l();
                                if (n11 != (n10 = 1)) break block5;
                                object2.clear();
                                n11 = i.f.c.a.B;
                                if (n12 != n11) break block6;
                                n12 = n13 * 3;
                                int[] nArray = new int[n12];
                                ((Mat)object).M(0, 0, nArray);
                                for (n10 = 0; n10 < n13; ++n10) {
                                    n11 = n10 * 3;
                                    double d10 = nArray[n11];
                                    int n14 = n11 + 1;
                                    n14 = nArray[n14];
                                    double d11 = n14;
                                    n11 += 2;
                                    n11 = nArray[n11];
                                    double d12 = n11;
                                    object = new t(d10, d11, d12);
                                    object2.add(object);
                                }
                                break block7;
                            }
                            n11 = i.f.c.a.F;
                            if (n12 != n11) break block8;
                            n12 = n13 * 3;
                            float[] fArray = new float[n12];
                            ((Mat)object).L(0, 0, fArray);
                            while (n10 < n13) {
                                n11 = n10 * 3;
                                double d13 = fArray[n11];
                                int n15 = n11 + 1;
                                float f10 = fArray[n15];
                                double d14 = f10;
                                float f11 = fArray[n11 += 2];
                                double d15 = f11;
                                object = new t(d13, d14, d15);
                                object2.add(object);
                                ++n10;
                            }
                            break block7;
                        }
                        n11 = i.f.c.a.J;
                        if (n12 == n11) {
                            n12 = n13 * 3;
                            double[] dArray = new double[n12];
                            ((Mat)object).K(0, 0, dArray);
                            while (n10 < n13) {
                                n11 = n10 * 3;
                                double d16 = dArray[n11];
                                int n16 = n11 + 1;
                                double d17 = dArray[n16];
                                double d18 = dArray[n11 += 2];
                                object = new t(d16, d17, d18);
                                object2.add(object);
                                ++n10;
                            }
                        }
                        break block9;
                    }
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Input Mat should be of CV_32SC3, CV_32FC3 or CV_64FC3 type\n");
                stringBuilder.append(object);
                object = stringBuilder.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Input Mat should have one column\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("Output List can't be null");
        throw object;
    }

    public static void h(Mat mat, List list) {
        a.g(mat, list);
    }

    public static void i(Mat mat, List list) {
        a.g(mat, list);
    }

    public static void j(Mat mat, List list) {
        a.g(mat, list);
    }

    public static void k(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.C;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                n11 = n10 * 4;
                int[] nArray = new int[n11];
                ((Mat)object).M(0, 0, nArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    int n13 = n12 * 4;
                    int n14 = nArray[n13];
                    int n15 = n13 + 1;
                    n15 = nArray[n15];
                    int n16 = n13 + 2;
                    n16 = nArray[n16];
                    n13 += 3;
                    n13 = nArray[n13];
                    object = new w(n14, n15, n16, n13);
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_32SC4 != m.type() ||  m.rows()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("rs == null");
        throw object;
    }

    public static void l(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.K;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                n11 = n10 * 4;
                double[] dArray = new double[n11];
                ((Mat)object).K(0, 0, dArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    int n13 = n12 * 4;
                    double d10 = dArray[n13];
                    int n14 = n13 + 1;
                    double d11 = dArray[n14];
                    int n15 = n13 + 2;
                    double d12 = dArray[n15];
                    double d13 = dArray[n13 += 3];
                    object = new v(d10, d11, d12, d13);
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_64FC4 != m.type() ||  m.rows()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("rs == null");
        throw object;
    }

    public static void m(Mat object, List object2) {
        if (object2 != null) {
            int n10;
            int n11 = ((Mat)object).B0();
            int n12 = i.f.c.a.d(5);
            if (n12 == (n10 = ((Mat)object).Q0()) && (n12 = ((Mat)object).l()) == (n10 = 1)) {
                object2.clear();
                n12 = n11 * 5;
                float[] fArray = new float[n12];
                ((Mat)object).L(0, 0, fArray);
                for (n10 = 0; n10 < n11; ++n10) {
                    int n13 = n10 * 5;
                    float f10 = fArray[n13];
                    double d10 = f10;
                    int n14 = n13 + 1;
                    float f11 = fArray[n14];
                    double d11 = f11;
                    u u10 = new u(d10, d11);
                    int n15 = n13 + 2;
                    float f12 = fArray[n15];
                    double d12 = f12;
                    int n16 = n13 + 3;
                    float f13 = fArray[n16];
                    double d13 = f13;
                    z z10 = new z(d12, d13);
                    float f14 = fArray[n13 += 4];
                    d12 = f14;
                    object = new x(u10, z10, d12);
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_32FC5 != m.type() ||  m.rows()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("rs == null");
        throw object;
    }

    public static void n(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.n;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                byte[] byArray = new byte[n10];
                ((Mat)object).J(0, 0, byArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    byte by2 = byArray[n12];
                    object = by2;
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_8SC1 != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("Output List can't be null");
        throw object;
    }

    public static void o(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.H;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                double[] dArray = new double[n10];
                ((Mat)object).K(0, 0, dArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    double d10 = dArray[n12];
                    object = d10;
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_64FC1 != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("ds == null");
        throw object;
    }

    public static void p(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.D;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                float[] fArray = new float[n10];
                ((Mat)object).L(0, 0, fArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    float f10 = fArray[n12];
                    object = Float.valueOf(f10);
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_32FC1 != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("fs == null");
        throw object;
    }

    public static void q(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.z;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                int[] nArray = new int[n10];
                ((Mat)object).M(0, 0, nArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    int n13 = nArray[n12];
                    object = n13;
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_32SC1 != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("is == null");
        throw object;
    }

    public static void r(Mat object, List object2) {
        if (object2 != null) {
            int n10 = ((Mat)object).B0();
            int n11 = i.f.c.a.j;
            int n12 = ((Mat)object).Q0();
            if (n11 == n12 && (n11 = ((Mat)object).l()) == (n12 = 1)) {
                object2.clear();
                byte[] byArray = new byte[n10];
                ((Mat)object).J(0, 0, byArray);
                for (n12 = 0; n12 < n10; ++n12) {
                    byte by2 = byArray[n12];
                    object = by2;
                    object2.add(object);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CvType.CV_8UC1 != m.type() ||  m.cols()!=1\n");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new IllegalArgumentException("Output List can't be null");
        throw object;
    }

    public static void s(Mat iterator2, List list) {
        if (list != null) {
            if (iterator2 != null) {
                int n10 = ((Mat)((Object)iterator2)).B0();
                ArrayList arrayList = new ArrayList(n10);
                a.c((Mat)((Object)iterator2), arrayList);
                list.clear();
                iterator2 = arrayList.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    Mat mat = (Mat)iterator2.next();
                    e e10 = new e(mat);
                    list.add(e10);
                    mat.u0();
                }
                arrayList.clear();
                return;
            }
            iterator2 = new Iterator("Input Mat can't be null");
            throw iterator2;
        }
        iterator2 = new Iterator("Output List can't be null");
        throw iterator2;
    }

    public static void t(Mat iterator2, List list) {
        if (list != null) {
            if (iterator2 != null) {
                int n10 = ((Mat)((Object)iterator2)).B0();
                ArrayList arrayList = new ArrayList(n10);
                a.c((Mat)((Object)iterator2), arrayList);
                iterator2 = arrayList.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    Mat mat = (Mat)iterator2.next();
                    l l10 = new l(mat);
                    list.add(l10);
                    mat.u0();
                }
                arrayList.clear();
                return;
            }
            iterator2 = new Iterator("Input Mat can't be null");
            throw iterator2;
        }
        iterator2 = new Iterator("Output List can't be null");
        throw iterator2;
    }

    public static void u(Mat iterator2, List list) {
        if (list != null) {
            if (iterator2 != null) {
                int n10 = ((Mat)((Object)iterator2)).B0();
                ArrayList arrayList = new ArrayList(n10);
                a.c((Mat)((Object)iterator2), arrayList);
                iterator2 = arrayList.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    Mat mat = (Mat)iterator2.next();
                    p p10 = new p(mat);
                    list.add(p10);
                    mat.u0();
                }
                arrayList.clear();
                return;
            }
            iterator2 = new Iterator("Input Mat can't be null");
            throw iterator2;
        }
        iterator2 = new Iterator("Output List can't be null");
        throw iterator2;
    }

    public static void v(Mat iterator2, List list) {
        if (list != null) {
            if (iterator2 != null) {
                int n10 = ((Mat)((Object)iterator2)).B0();
                ArrayList arrayList = new ArrayList(n10);
                a.c((Mat)((Object)iterator2), arrayList);
                iterator2 = arrayList.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    Mat mat = (Mat)iterator2.next();
                    m m10 = new m(mat);
                    list.add(m10);
                    mat.u0();
                }
                arrayList.clear();
                return;
            }
            iterator2 = new Iterator("Input Mat can't be null");
            throw iterator2;
        }
        iterator2 = new Iterator("Output List can't be null");
        throw iterator2;
    }

    public static void w(Mat iterator2, List list) {
        if (list != null) {
            if (iterator2 != null) {
                int n10 = ((Mat)((Object)iterator2)).B0();
                ArrayList arrayList = new ArrayList(n10);
                a.c((Mat)((Object)iterator2), arrayList);
                iterator2 = arrayList.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    Mat mat = (Mat)iterator2.next();
                    o o10 = new o(mat);
                    list.add(o10);
                    mat.u0();
                }
                arrayList.clear();
                return;
            }
            iterator2 = new Iterator("Input Mat can't be null");
            throw iterator2;
        }
        iterator2 = new Iterator("Output List can't be null");
        throw iterator2;
    }

    public static void x(Mat iterator2, List list) {
        if (list != null) {
            if (iterator2 != null) {
                int n10 = ((Mat)((Object)iterator2)).B0();
                ArrayList arrayList = new ArrayList(n10);
                a.c((Mat)((Object)iterator2), arrayList);
                iterator2 = arrayList.iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    Mat mat = (Mat)iterator2.next();
                    ArrayList arrayList2 = new ArrayList();
                    a.n(mat, arrayList2);
                    list.add(arrayList2);
                    mat.u0();
                }
                arrayList.clear();
                return;
            }
            iterator2 = new Iterator("Input Mat can't be null");
            throw iterator2;
        }
        iterator2 = new Iterator("Output List can't be null");
        throw iterator2;
    }

    public static Mat y(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.K;
            mat = new Mat(n10, 1, n11);
            n11 = n10 * 4;
            double[] dArray = new double[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10;
                double d11;
                b b10 = (b)list.get(i10);
                int n12 = i10 * 4;
                dArray[n12] = d11 = (double)b10.a;
                int n13 = n12 + 1;
                dArray[n13] = d10 = (double)b10.b;
                n13 = n12 + 2;
                int n14 = b10.c;
                dArray[n13] = d10 = (double)n14;
                float f10 = b10.d;
                dArray[n12 += 3] = d11 = (double)f10;
            }
            mat.k0(0, 0, dArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }

    public static Mat z(List list) {
        Mat mat;
        int n10 = list != null ? list.size() : 0;
        if (n10 > 0) {
            int n11 = i.f.c.a.f(7);
            mat = new Mat(n10, 1, n11);
            n11 = n10 * 7;
            double[] dArray = new double[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10;
                double d11;
                double d12;
                c c10 = (c)list.get(i10);
                int n12 = i10 * 7;
                u u10 = c10.a;
                dArray[n12] = d12 = u10.a;
                int n13 = n12 + 1;
                dArray[n13] = d11 = u10.b;
                int n14 = n12 + 2;
                dArray[n14] = d12 = (double)c10.b;
                n14 = n12 + 3;
                dArray[n14] = d12 = (double)c10.c;
                n14 = n12 + 4;
                float f10 = c10.d;
                dArray[n14] = d12 = (double)f10;
                n14 = n12 + 5;
                n13 = c10.e;
                dArray[n14] = d12 = (double)n13;
                int n15 = c10.f;
                dArray[n12 += 6] = d10 = (double)n15;
            }
            mat.k0(0, 0, dArray);
        } else {
            mat = new Mat();
        }
        return mat;
    }
}

