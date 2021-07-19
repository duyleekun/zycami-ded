/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.calib3d;

import org.opencv.calib3d.StereoMatcher;

public class StereoSGBM
extends StereoMatcher {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;

    public StereoSGBM(long l10) {
        super(l10);
    }

    public static StereoSGBM A(int n10, int n11, int n12, int n13, int n14) {
        return StereoSGBM.u(StereoSGBM.create_6(n10, n11, n12, n13, n14));
    }

    public static StereoSGBM B(int n10, int n11, int n12, int n13, int n14, int n15) {
        return StereoSGBM.u(StereoSGBM.create_5(n10, n11, n12, n13, n14, n15));
    }

    public static StereoSGBM C(int n10, int n11, int n12, int n13, int n14, int n15, int n16) {
        return StereoSGBM.u(StereoSGBM.create_4(n10, n11, n12, n13, n14, n15, n16));
    }

    public static StereoSGBM D(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        return StereoSGBM.u(StereoSGBM.create_3(n10, n11, n12, n13, n14, n15, n16, n17));
    }

    public static StereoSGBM E(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18) {
        return StereoSGBM.u(StereoSGBM.create_2(n10, n11, n12, n13, n14, n15, n16, n17, n18));
    }

    public static StereoSGBM F(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19) {
        return StereoSGBM.u(StereoSGBM.create_1(n10, n11, n12, n13, n14, n15, n16, n17, n18, n19));
    }

    public static StereoSGBM G(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20) {
        return StereoSGBM.u(StereoSGBM.create_0(n10, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20));
    }

    private static native long create_0(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    private static native long create_1(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9);

    private static native long create_10(int var0);

    private static native long create_11();

    private static native long create_2(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    private static native long create_3(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7);

    private static native long create_4(int var0, int var1, int var2, int var3, int var4, int var5, int var6);

    private static native long create_5(int var0, int var1, int var2, int var3, int var4, int var5);

    private static native long create_6(int var0, int var1, int var2, int var3, int var4);

    private static native long create_7(int var0, int var1, int var2, int var3);

    private static native long create_8(int var0, int var1, int var2);

    private static native long create_9(int var0, int var1);

    private static native void delete(long var0);

    private static native int getMode_0(long var0);

    private static native int getP1_0(long var0);

    private static native int getP2_0(long var0);

    private static native int getPreFilterCap_0(long var0);

    private static native int getUniquenessRatio_0(long var0);

    private static native void setMode_0(long var0, int var2);

    private static native void setP1_0(long var0, int var2);

    private static native void setP2_0(long var0, int var2);

    private static native void setPreFilterCap_0(long var0, int var2);

    private static native void setUniquenessRatio_0(long var0, int var2);

    public static StereoSGBM u(long l10) {
        StereoSGBM stereoSGBM = new StereoSGBM(l10);
        return stereoSGBM;
    }

    public static StereoSGBM v() {
        return StereoSGBM.u(StereoSGBM.create_11());
    }

    public static StereoSGBM w(int n10) {
        return StereoSGBM.u(StereoSGBM.create_10(n10));
    }

    public static StereoSGBM x(int n10, int n11) {
        return StereoSGBM.u(StereoSGBM.create_9(n10, n11));
    }

    public static StereoSGBM y(int n10, int n11, int n12) {
        return StereoSGBM.u(StereoSGBM.create_8(n10, n11, n12));
    }

    public static StereoSGBM z(int n10, int n11, int n12, int n13) {
        return StereoSGBM.u(StereoSGBM.create_7(n10, n11, n12, n13));
    }

    public int H() {
        return StereoSGBM.getMode_0(this.a);
    }

    public int I() {
        return StereoSGBM.getP1_0(this.a);
    }

    public int J() {
        return StereoSGBM.getP2_0(this.a);
    }

    public int K() {
        return StereoSGBM.getPreFilterCap_0(this.a);
    }

    public int L() {
        return StereoSGBM.getUniquenessRatio_0(this.a);
    }

    public void M(int n10) {
        StereoSGBM.setMode_0(this.a, n10);
    }

    public void N(int n10) {
        StereoSGBM.setP1_0(this.a, n10);
    }

    public void O(int n10) {
        StereoSGBM.setP2_0(this.a, n10);
    }

    public void P(int n10) {
        StereoSGBM.setPreFilterCap_0(this.a, n10);
    }

    public void Q(int n10) {
        StereoSGBM.setUniquenessRatio_0(this.a, n10);
    }

    public void finalize() {
        StereoSGBM.delete(this.a);
    }
}

