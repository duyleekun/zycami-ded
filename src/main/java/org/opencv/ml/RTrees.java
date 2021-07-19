/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import i.f.c.a0;
import org.opencv.core.Mat;
import org.opencv.ml.DTrees;

public class RTrees
extends DTrees {
    public RTrees(long l10) {
        super(l10);
    }

    public static RTrees N(long l10) {
        RTrees rTrees = new RTrees(l10);
        return rTrees;
    }

    public static RTrees O() {
        return RTrees.N(RTrees.create_0());
    }

    public static RTrees U(String string2) {
        return RTrees.N(RTrees.load_1(string2));
    }

    public static RTrees V(String string2, String string3) {
        return RTrees.N(RTrees.load_0(string2, string3));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native int getActiveVarCount_0(long var0);

    private static native boolean getCalculateVarImportance_0(long var0);

    private static native double[] getTermCriteria_0(long var0);

    private static native long getVarImportance_0(long var0);

    private static native void getVotes_0(long var0, long var2, long var4, int var6);

    private static native long load_0(String var0, String var1);

    private static native long load_1(String var0);

    private static native void setActiveVarCount_0(long var0, int var2);

    private static native void setCalculateVarImportance_0(long var0, boolean var2);

    private static native void setTermCriteria_0(long var0, int var2, int var3, double var4);

    public int P() {
        return RTrees.getActiveVarCount_0(this.a);
    }

    public boolean Q() {
        return RTrees.getCalculateVarImportance_0(this.a);
    }

    public a0 R() {
        double[] dArray = RTrees.getTermCriteria_0(this.a);
        a0 a02 = new a0(dArray);
        return a02;
    }

    public Mat S() {
        long l10 = RTrees.getVarImportance_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void T(Mat mat, Mat mat2, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        RTrees.getVotes_0(l10, l11, l12, n10);
    }

    public void W(int n10) {
        RTrees.setActiveVarCount_0(this.a, n10);
    }

    public void X(boolean bl2) {
        RTrees.setCalculateVarImportance_0(this.a, bl2);
    }

    public void Y(a0 a02) {
        long l10 = this.a;
        int n10 = a02.a;
        int n11 = a02.b;
        double d10 = a02.c;
        RTrees.setTermCriteria_0(l10, n10, n11, d10);
    }

    public void finalize() {
        RTrees.delete(this.a);
    }
}

