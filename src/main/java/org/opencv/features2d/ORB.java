/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import org.opencv.features2d.Feature2D;

public class ORB
extends Feature2D {
    public static final int b = 0;
    public static final int c = 1;

    public ORB(long l10) {
        super(l10);
    }

    public static ORB A(int n10, float f10, int n11, int n12, int n13) {
        return ORB.u(ORB.create_4(n10, f10, n11, n12, n13));
    }

    public static ORB B(int n10, float f10, int n11, int n12, int n13, int n14) {
        return ORB.u(ORB.create_3(n10, f10, n11, n12, n13, n14));
    }

    public static ORB C(int n10, float f10, int n11, int n12, int n13, int n14, int n15) {
        return ORB.u(ORB.create_2(n10, f10, n11, n12, n13, n14, n15));
    }

    public static ORB D(int n10, float f10, int n11, int n12, int n13, int n14, int n15, int n16) {
        return ORB.u(ORB.create_1(n10, f10, n11, n12, n13, n14, n15, n16));
    }

    public static ORB E(int n10, float f10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        return ORB.u(ORB.create_0(n10, f10, n11, n12, n13, n14, n15, n16, n17));
    }

    private static native long create_0(int var0, float var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    private static native long create_1(int var0, float var1, int var2, int var3, int var4, int var5, int var6, int var7);

    private static native long create_2(int var0, float var1, int var2, int var3, int var4, int var5, int var6);

    private static native long create_3(int var0, float var1, int var2, int var3, int var4, int var5);

    private static native long create_4(int var0, float var1, int var2, int var3, int var4);

    private static native long create_5(int var0, float var1, int var2, int var3);

    private static native long create_6(int var0, float var1, int var2);

    private static native long create_7(int var0, float var1);

    private static native long create_8(int var0);

    private static native long create_9();

    private static native void delete(long var0);

    private static native String getDefaultName_0(long var0);

    private static native int getEdgeThreshold_0(long var0);

    private static native int getFastThreshold_0(long var0);

    private static native int getFirstLevel_0(long var0);

    private static native int getMaxFeatures_0(long var0);

    private static native int getNLevels_0(long var0);

    private static native int getPatchSize_0(long var0);

    private static native double getScaleFactor_0(long var0);

    private static native int getScoreType_0(long var0);

    private static native int getWTA_K_0(long var0);

    private static native void setEdgeThreshold_0(long var0, int var2);

    private static native void setFastThreshold_0(long var0, int var2);

    private static native void setFirstLevel_0(long var0, int var2);

    private static native void setMaxFeatures_0(long var0, int var2);

    private static native void setNLevels_0(long var0, int var2);

    private static native void setPatchSize_0(long var0, int var2);

    private static native void setScaleFactor_0(long var0, double var2);

    private static native void setScoreType_0(long var0, int var2);

    private static native void setWTA_K_0(long var0, int var2);

    public static ORB u(long l10) {
        ORB oRB = new ORB(l10);
        return oRB;
    }

    public static ORB v() {
        return ORB.u(ORB.create_9());
    }

    public static ORB w(int n10) {
        return ORB.u(ORB.create_8(n10));
    }

    public static ORB x(int n10, float f10) {
        return ORB.u(ORB.create_7(n10, f10));
    }

    public static ORB y(int n10, float f10, int n11) {
        return ORB.u(ORB.create_6(n10, f10, n11));
    }

    public static ORB z(int n10, float f10, int n11, int n12) {
        return ORB.u(ORB.create_5(n10, f10, n11, n12));
    }

    public int F() {
        return ORB.getEdgeThreshold_0(this.a);
    }

    public int G() {
        return ORB.getFastThreshold_0(this.a);
    }

    public int H() {
        return ORB.getFirstLevel_0(this.a);
    }

    public int I() {
        return ORB.getMaxFeatures_0(this.a);
    }

    public int J() {
        return ORB.getNLevels_0(this.a);
    }

    public int K() {
        return ORB.getPatchSize_0(this.a);
    }

    public double L() {
        return ORB.getScaleFactor_0(this.a);
    }

    public int M() {
        return ORB.getScoreType_0(this.a);
    }

    public int N() {
        return ORB.getWTA_K_0(this.a);
    }

    public void O(int n10) {
        ORB.setEdgeThreshold_0(this.a, n10);
    }

    public void P(int n10) {
        ORB.setFastThreshold_0(this.a, n10);
    }

    public void Q(int n10) {
        ORB.setFirstLevel_0(this.a, n10);
    }

    public void R(int n10) {
        ORB.setMaxFeatures_0(this.a, n10);
    }

    public void S(int n10) {
        ORB.setNLevels_0(this.a, n10);
    }

    public void T(int n10) {
        ORB.setPatchSize_0(this.a, n10);
    }

    public void U(double d10) {
        ORB.setScaleFactor_0(this.a, d10);
    }

    public void V(int n10) {
        ORB.setScoreType_0(this.a, n10);
    }

    public void W(int n10) {
        ORB.setWTA_K_0(this.a, n10);
    }

    public String d() {
        return ORB.getDefaultName_0(this.a);
    }

    public void finalize() {
        ORB.delete(this.a);
    }
}

