/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.features2d;

import i.f.c.r;
import i.f.h.a;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.features2d.Feature2D;

public class MSER
extends Feature2D {
    public MSER(long l10) {
        super(l10);
    }

    public static MSER A(int n10, int n11, int n12, double d10, double d11) {
        return MSER.u(MSER.create_4(n10, n11, n12, d10, d11));
    }

    public static MSER B(int n10, int n11, int n12, double d10, double d11, int n13) {
        return MSER.u(MSER.create_3(n10, n11, n12, d10, d11, n13));
    }

    public static MSER C(int n10, int n11, int n12, double d10, double d11, int n13, double d12) {
        return MSER.u(MSER.create_2(n10, n11, n12, d10, d11, n13, d12));
    }

    public static MSER D(int n10, int n11, int n12, double d10, double d11, int n13, double d12, double d13) {
        return MSER.u(MSER.create_1(n10, n11, n12, d10, d11, n13, d12, d13));
    }

    public static MSER E(int n10, int n11, int n12, double d10, double d11, int n13, double d12, double d13, int n14) {
        return MSER.u(MSER.create_0(n10, n11, n12, d10, d11, n13, d12, d13, n14));
    }

    private static native long create_0(int var0, int var1, int var2, double var3, double var5, int var7, double var8, double var10, int var12);

    private static native long create_1(int var0, int var1, int var2, double var3, double var5, int var7, double var8, double var10);

    private static native long create_2(int var0, int var1, int var2, double var3, double var5, int var7, double var8);

    private static native long create_3(int var0, int var1, int var2, double var3, double var5, int var7);

    private static native long create_4(int var0, int var1, int var2, double var3, double var5);

    private static native long create_5(int var0, int var1, int var2, double var3);

    private static native long create_6(int var0, int var1, int var2);

    private static native long create_7(int var0, int var1);

    private static native long create_8(int var0);

    private static native long create_9();

    private static native void delete(long var0);

    private static native void detectRegions_0(long var0, long var2, long var4, long var6);

    private static native String getDefaultName_0(long var0);

    private static native int getDelta_0(long var0);

    private static native int getMaxArea_0(long var0);

    private static native int getMinArea_0(long var0);

    private static native boolean getPass2Only_0(long var0);

    private static native void setDelta_0(long var0, int var2);

    private static native void setMaxArea_0(long var0, int var2);

    private static native void setMinArea_0(long var0, int var2);

    private static native void setPass2Only_0(long var0, boolean var2);

    public static MSER u(long l10) {
        MSER mSER = new MSER(l10);
        return mSER;
    }

    public static MSER v() {
        return MSER.u(MSER.create_9());
    }

    public static MSER w(int n10) {
        return MSER.u(MSER.create_8(n10));
    }

    public static MSER x(int n10, int n11) {
        return MSER.u(MSER.create_7(n10, n11));
    }

    public static MSER y(int n10, int n11, int n12) {
        return MSER.u(MSER.create_6(n10, n11, n12));
    }

    public static MSER z(int n10, int n11, int n12, double d10) {
        return MSER.u(MSER.create_5(n10, n11, n12, d10));
    }

    public void F(Mat mat, List list, r r10) {
        Mat mat2 = new Mat();
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = r10.a;
        MSER.detectRegions_0(l10, l11, l12, l13);
        i.f.h.a.u(mat2, list);
        mat2.u0();
    }

    public int G() {
        return MSER.getDelta_0(this.a);
    }

    public int H() {
        return MSER.getMaxArea_0(this.a);
    }

    public int I() {
        return MSER.getMinArea_0(this.a);
    }

    public boolean J() {
        return MSER.getPass2Only_0(this.a);
    }

    public void K(int n10) {
        MSER.setDelta_0(this.a, n10);
    }

    public void L(int n10) {
        MSER.setMaxArea_0(this.a, n10);
    }

    public void M(int n10) {
        MSER.setMinArea_0(this.a, n10);
    }

    public void N(boolean bl2) {
        MSER.setPass2Only_0(this.a, bl2);
    }

    public String d() {
        return MSER.getDefaultName_0(this.a);
    }

    public void finalize() {
        MSER.delete(this.a);
    }
}

