/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.ml.StatModel;

public class DTrees
extends StatModel {
    public static final int f = 0;
    public static final int g = 256;
    public static final int h = 512;
    public static final int i = 768;

    public DTrees(long l10) {
        super(l10);
    }

    public static DTrees C(String string2) {
        return DTrees.r(DTrees.load_1(string2));
    }

    public static DTrees D(String string2, String string3) {
        return DTrees.r(DTrees.load_0(string2, string3));
    }

    private static native long create_0();

    private static native void delete(long var0);

    private static native int getCVFolds_0(long var0);

    private static native int getMaxCategories_0(long var0);

    private static native int getMaxDepth_0(long var0);

    private static native int getMinSampleCount_0(long var0);

    private static native long getPriors_0(long var0);

    private static native float getRegressionAccuracy_0(long var0);

    private static native boolean getTruncatePrunedTree_0(long var0);

    private static native boolean getUse1SERule_0(long var0);

    private static native boolean getUseSurrogates_0(long var0);

    private static native long load_0(String var0, String var1);

    private static native long load_1(String var0);

    public static DTrees r(long l10) {
        DTrees dTrees = new DTrees(l10);
        return dTrees;
    }

    public static DTrees s() {
        return DTrees.r(DTrees.create_0());
    }

    private static native void setCVFolds_0(long var0, int var2);

    private static native void setMaxCategories_0(long var0, int var2);

    private static native void setMaxDepth_0(long var0, int var2);

    private static native void setMinSampleCount_0(long var0, int var2);

    private static native void setPriors_0(long var0, long var2);

    private static native void setRegressionAccuracy_0(long var0, float var2);

    private static native void setTruncatePrunedTree_0(long var0, boolean var2);

    private static native void setUse1SERule_0(long var0, boolean var2);

    private static native void setUseSurrogates_0(long var0, boolean var2);

    public boolean A() {
        return DTrees.getUse1SERule_0(this.a);
    }

    public boolean B() {
        return DTrees.getUseSurrogates_0(this.a);
    }

    public void E(int n10) {
        DTrees.setCVFolds_0(this.a, n10);
    }

    public void F(int n10) {
        DTrees.setMaxCategories_0(this.a, n10);
    }

    public void G(int n10) {
        DTrees.setMaxDepth_0(this.a, n10);
    }

    public void H(int n10) {
        DTrees.setMinSampleCount_0(this.a, n10);
    }

    public void I(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        DTrees.setPriors_0(l10, l11);
    }

    public void J(float f10) {
        DTrees.setRegressionAccuracy_0(this.a, f10);
    }

    public void K(boolean bl2) {
        DTrees.setTruncatePrunedTree_0(this.a, bl2);
    }

    public void L(boolean bl2) {
        DTrees.setUse1SERule_0(this.a, bl2);
    }

    public void M(boolean bl2) {
        DTrees.setUseSurrogates_0(this.a, bl2);
    }

    public void finalize() {
        DTrees.delete(this.a);
    }

    public int t() {
        return DTrees.getCVFolds_0(this.a);
    }

    public int u() {
        return DTrees.getMaxCategories_0(this.a);
    }

    public int v() {
        return DTrees.getMaxDepth_0(this.a);
    }

    public int w() {
        return DTrees.getMinSampleCount_0(this.a);
    }

    public Mat x() {
        long l10 = DTrees.getPriors_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public float y() {
        return DTrees.getRegressionAccuracy_0(this.a);
    }

    public boolean z() {
        return DTrees.getTruncatePrunedTree_0(this.a);
    }
}

