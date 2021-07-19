/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.c.d;
import i.f.c.e;
import i.f.c.l;
import i.f.c.y;
import i.f.h.a;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;

public class Features2d {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;

    public static void a(Mat mat, l l10, Mat mat2) {
        long l11 = mat.a;
        long l12 = l10.a;
        long l13 = mat2.a;
        Features2d.drawKeypoints_2(l11, l12, l13);
    }

    public static void b(Mat mat, l l10, Mat mat2, y y10) {
        long l11 = mat.a;
        long l12 = l10.a;
        long l13 = mat2.a;
        Object object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Features2d.drawKeypoints_1(l11, l12, l13, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void c(Mat mat, l l10, Mat mat2, y y10, int n10) {
        long l11 = mat.a;
        long l12 = l10.a;
        long l13 = mat2.a;
        Object object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        Features2d.drawKeypoints_0(l11, l12, l13, (double)object2, (double)object3, (double)object4, (double)object5, n10);
    }

    public static void d(Mat mat, l l10, Mat mat2, l l11, e e10, Mat mat3) {
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        long l15 = l11.a;
        long l16 = e10.a;
        long l17 = mat3.a;
        Features2d.drawMatches_4(l12, l13, l14, l15, l16, l17);
    }

    private static native void drawKeypoints_0(long var0, long var2, long var4, double var6, double var8, double var10, double var12, int var14);

    private static native void drawKeypoints_1(long var0, long var2, long var4, double var6, double var8, double var10, double var12);

    private static native void drawKeypoints_2(long var0, long var2, long var4);

    private static native void drawMatchesKnn_0(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18, double var20, double var22, double var24, double var26, long var28, int var30);

    private static native void drawMatchesKnn_1(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18, double var20, double var22, double var24, double var26, long var28);

    private static native void drawMatchesKnn_2(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18, double var20, double var22, double var24, double var26);

    private static native void drawMatchesKnn_3(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18);

    private static native void drawMatchesKnn_4(long var0, long var2, long var4, long var6, long var8, long var10);

    private static native void drawMatches_0(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18, double var20, double var22, double var24, double var26, long var28, int var30);

    private static native void drawMatches_1(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18, double var20, double var22, double var24, double var26, long var28);

    private static native void drawMatches_2(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18, double var20, double var22, double var24, double var26);

    private static native void drawMatches_3(long var0, long var2, long var4, long var6, long var8, long var10, double var12, double var14, double var16, double var18);

    private static native void drawMatches_4(long var0, long var2, long var4, long var6, long var8, long var10);

    public static void e(Mat mat, l l10, Mat mat2, l l11, e e10, Mat mat3, y y10) {
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        long l15 = l11.a;
        long l16 = e10.a;
        long l17 = mat3.a;
        double[] dArray = y10.a;
        double d10 = dArray[0];
        double d11 = dArray[1];
        double d12 = dArray[2];
        double d13 = dArray[3];
        Features2d.drawMatches_3(l12, l13, l14, l15, l16, l17, d10, d11, d12, d13);
    }

    public static void f(Mat mat, l l10, Mat mat2, l l11, e e10, Mat mat3, y y10, y y11) {
        Object object = mat;
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        long l15 = l11.a;
        long l16 = e10.a;
        long l17 = mat3.a;
        double[] dArray = y10.a;
        double d10 = dArray[0];
        int n10 = 1;
        double d11 = dArray[n10];
        int n11 = 2;
        double d12 = dArray[n11];
        int n12 = 3;
        double d13 = dArray[n12];
        object = y11;
        object = y11.a;
        Object object2 = object[0];
        Object object3 = object[n10];
        Object object4 = object[n11];
        Object object5 = object[n12];
        Features2d.drawMatches_2(l12, l13, l14, l15, l16, l17, d10, d11, d12, d13, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static void g(Mat mat, l l10, Mat mat2, l l11, e e10, Mat mat3, y y10, y y11, d d10) {
        Object object = mat;
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        long l15 = l11.a;
        long l16 = e10.a;
        long l17 = mat3.a;
        double[] dArray = y10.a;
        double d11 = dArray[0];
        int n10 = 1;
        double d12 = dArray[n10];
        int n11 = 2;
        double d13 = dArray[n11];
        int n12 = 3;
        double d14 = dArray[n12];
        long l18 = l12;
        object = y11;
        object = y11.a;
        Object object2 = object[0];
        Object object3 = object[n10];
        Object object4 = object[n11];
        Object object5 = object[n12];
        object = d10;
        long l19 = d10.a;
        l12 = l18;
        Features2d.drawMatches_1(l18, l13, l14, l15, l16, l17, d11, d12, d13, d14, (double)object2, (double)object3, (double)object4, (double)object5, l19);
    }

    public static void h(Mat mat, l l10, Mat mat2, l l11, e e10, Mat mat3, y y10, y y11, d d10, int n10) {
        Object object = mat;
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        long l15 = l11.a;
        long l16 = e10.a;
        long l17 = mat3.a;
        double[] dArray = y10.a;
        double d11 = dArray[0];
        int n11 = 1;
        double d12 = dArray[n11];
        int n12 = 2;
        double d13 = dArray[n12];
        int n13 = 3;
        double d14 = dArray[n13];
        long l18 = l12;
        object = y11;
        object = y11.a;
        Object object2 = object[0];
        Object object3 = object[n11];
        Object object4 = object[n12];
        Object object5 = object[n13];
        object = d10;
        long l19 = d10.a;
        l12 = l18;
        Features2d.drawMatches_0(l18, l13, l14, l15, l16, l17, d11, d12, d13, d14, (double)object2, (double)object3, (double)object4, (double)object5, l19, n10);
    }

    public static void i(Mat mat, l l10, Mat mat2, l l11, List list, Mat mat3) {
        Object object = list;
        int n10 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n10);
        object = i.f.h.a.R((List)object, object2);
        object2 = mat;
        long l12 = mat.a;
        long l13 = l10.a;
        long l14 = mat2.a;
        long l15 = l11.a;
        long l16 = ((Mat)object).a;
        object = mat3;
        long l17 = mat3.a;
        Features2d.drawMatchesKnn_4(l12, l13, l14, l15, l16, l17);
    }

    public static void j(Mat mat, l l10, Mat mat2, l l11, List list, Mat mat3, y y10) {
        Object object = list;
        int n10 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n10);
        object = i.f.h.a.R((List)object, object2);
        object2 = mat;
        long l12 = mat.a;
        object2 = l10;
        long l13 = l10.a;
        object2 = mat2;
        long l14 = mat2.a;
        object2 = l11;
        long l15 = l11.a;
        long l16 = ((Mat)object).a;
        object = mat3;
        long l17 = mat3.a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        Object object4 = object[1];
        Object object5 = object[2];
        Object object6 = object[3];
        Features2d.drawMatchesKnn_3(l12, l13, l14, l15, l16, l17, (double)object3, (double)object4, (double)object5, (double)object6);
    }

    public static void k(Mat mat, l l10, Mat mat2, l l11, List list, Mat mat3, y y10, y y11) {
        Object object = list;
        int n10 = list != null ? list.size() : 0;
        Object object2 = new ArrayList(n10);
        object = i.f.h.a.R((List)object, object2);
        object2 = mat;
        long l12 = mat.a;
        object2 = l10;
        long l13 = l10.a;
        object2 = mat2;
        long l14 = mat2.a;
        object2 = l11;
        long l15 = l11.a;
        long l16 = ((Mat)object).a;
        object = mat3;
        long l17 = mat3.a;
        object = y10;
        object = y10.a;
        Object object3 = object[0];
        int n11 = 1;
        Object object4 = object[n11];
        int n12 = 2;
        Object object5 = object[n12];
        int n13 = 3;
        Object object6 = object[n13];
        object = y11;
        object = y11.a;
        Object object7 = object[0];
        Object object8 = object[n11];
        Object object9 = object[n12];
        Object object10 = object[n13];
        Features2d.drawMatchesKnn_2(l12, l13, l14, l15, l16, l17, (double)object3, (double)object4, (double)object5, (double)object6, (double)object7, (double)object8, (double)object9, (double)object10);
    }

    public static void l(Mat mat, l l10, Mat mat2, l l11, List list, Mat mat3, y y10, y y11, List list2) {
        Object object = list;
        Object object2 = list2;
        int n10 = list != null ? list.size() : 0;
        Object object3 = new ArrayList(n10);
        object = i.f.h.a.R((List)object, object3);
        n10 = object2 != null ? list2.size() : 0;
        object3 = new ArrayList(n10);
        object2 = i.f.h.a.W((List)object2, object3);
        object3 = mat;
        long l12 = mat.a;
        object3 = l10;
        long l13 = l10.a;
        object3 = mat2;
        long l14 = mat2.a;
        object3 = l11;
        long l15 = l11.a;
        long l16 = ((Mat)object).a;
        object = mat3;
        long l17 = mat3.a;
        object = y10;
        object = y10.a;
        Object object4 = object[0];
        int n11 = 1;
        Object object5 = object[n11];
        int n12 = 2;
        Object object6 = object[n12];
        int n13 = 3;
        Object object7 = object[n13];
        object = y11;
        object = y11.a;
        Object object8 = object[0];
        Object object9 = object[n11];
        Object object10 = object[n12];
        Object object11 = object[n13];
        long l18 = ((Mat)object2).a;
        Features2d.drawMatchesKnn_1(l12, l13, l14, l15, l16, l17, (double)object4, (double)object5, (double)object6, (double)object7, (double)object8, (double)object9, (double)object10, (double)object11, l18);
    }

    public static void m(Mat mat, l l10, Mat mat2, l l11, List list, Mat mat3, y y10, y y11, List list2, int n10) {
        Object object = list;
        Object object2 = list2;
        int n11 = list != null ? list.size() : 0;
        Object object3 = new ArrayList(n11);
        object = i.f.h.a.R((List)object, object3);
        n11 = object2 != null ? list2.size() : 0;
        object3 = new ArrayList(n11);
        object2 = i.f.h.a.W((List)object2, object3);
        object3 = mat;
        long l12 = mat.a;
        object3 = l10;
        long l13 = l10.a;
        object3 = mat2;
        long l14 = mat2.a;
        object3 = l11;
        long l15 = l11.a;
        long l16 = ((Mat)object).a;
        object = mat3;
        long l17 = mat3.a;
        object = y10;
        object = y10.a;
        Object object4 = object[0];
        int n12 = 1;
        Object object5 = object[n12];
        int n13 = 2;
        Object object6 = object[n13];
        int n14 = 3;
        Object object7 = object[n14];
        object = y11;
        object = y11.a;
        Object object8 = object[0];
        Object object9 = object[n12];
        Object object10 = object[n13];
        Object object11 = object[n14];
        long l18 = ((Mat)object2).a;
        Features2d.drawMatchesKnn_0(l12, l13, l14, l15, l16, l17, (double)object4, (double)object5, (double)object6, (double)object7, (double)object8, (double)object9, (double)object10, (double)object11, l18, n10);
    }
}

