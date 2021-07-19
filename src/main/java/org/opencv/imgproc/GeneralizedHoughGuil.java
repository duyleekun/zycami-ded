/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.imgproc;

import org.opencv.imgproc.GeneralizedHough;

public class GeneralizedHoughGuil
extends GeneralizedHough {
    public GeneralizedHoughGuil(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native double getAngleEpsilon_0(long var0);

    private static native double getAngleStep_0(long var0);

    private static native int getAngleThresh_0(long var0);

    private static native int getLevels_0(long var0);

    private static native double getMaxAngle_0(long var0);

    private static native double getMaxScale_0(long var0);

    private static native double getMinAngle_0(long var0);

    private static native double getMinScale_0(long var0);

    private static native int getPosThresh_0(long var0);

    private static native double getScaleStep_0(long var0);

    private static native int getScaleThresh_0(long var0);

    private static native double getXi_0(long var0);

    private static native void setAngleEpsilon_0(long var0, double var2);

    private static native void setAngleStep_0(long var0, double var2);

    private static native void setAngleThresh_0(long var0, int var2);

    private static native void setLevels_0(long var0, int var2);

    private static native void setMaxAngle_0(long var0, double var2);

    private static native void setMaxScale_0(long var0, double var2);

    private static native void setMinAngle_0(long var0, double var2);

    private static native void setMinScale_0(long var0, double var2);

    private static native void setPosThresh_0(long var0, int var2);

    private static native void setScaleStep_0(long var0, double var2);

    private static native void setScaleThresh_0(long var0, int var2);

    private static native void setXi_0(long var0, double var2);

    public static GeneralizedHoughGuil z(long l10) {
        GeneralizedHoughGuil generalizedHoughGuil = new GeneralizedHoughGuil(l10);
        return generalizedHoughGuil;
    }

    public double A() {
        return GeneralizedHoughGuil.getAngleEpsilon_0(this.a);
    }

    public double B() {
        return GeneralizedHoughGuil.getAngleStep_0(this.a);
    }

    public int C() {
        return GeneralizedHoughGuil.getAngleThresh_0(this.a);
    }

    public int D() {
        return GeneralizedHoughGuil.getLevels_0(this.a);
    }

    public double E() {
        return GeneralizedHoughGuil.getMaxAngle_0(this.a);
    }

    public double F() {
        return GeneralizedHoughGuil.getMaxScale_0(this.a);
    }

    public double G() {
        return GeneralizedHoughGuil.getMinAngle_0(this.a);
    }

    public double H() {
        return GeneralizedHoughGuil.getMinScale_0(this.a);
    }

    public int I() {
        return GeneralizedHoughGuil.getPosThresh_0(this.a);
    }

    public double J() {
        return GeneralizedHoughGuil.getScaleStep_0(this.a);
    }

    public int K() {
        return GeneralizedHoughGuil.getScaleThresh_0(this.a);
    }

    public double L() {
        return GeneralizedHoughGuil.getXi_0(this.a);
    }

    public void M(double d10) {
        GeneralizedHoughGuil.setAngleEpsilon_0(this.a, d10);
    }

    public void N(double d10) {
        GeneralizedHoughGuil.setAngleStep_0(this.a, d10);
    }

    public void O(int n10) {
        GeneralizedHoughGuil.setAngleThresh_0(this.a, n10);
    }

    public void P(int n10) {
        GeneralizedHoughGuil.setLevels_0(this.a, n10);
    }

    public void Q(double d10) {
        GeneralizedHoughGuil.setMaxAngle_0(this.a, d10);
    }

    public void R(double d10) {
        GeneralizedHoughGuil.setMaxScale_0(this.a, d10);
    }

    public void S(double d10) {
        GeneralizedHoughGuil.setMinAngle_0(this.a, d10);
    }

    public void T(double d10) {
        GeneralizedHoughGuil.setMinScale_0(this.a, d10);
    }

    public void U(int n10) {
        GeneralizedHoughGuil.setPosThresh_0(this.a, n10);
    }

    public void V(double d10) {
        GeneralizedHoughGuil.setScaleStep_0(this.a, d10);
    }

    public void W(int n10) {
        GeneralizedHoughGuil.setScaleThresh_0(this.a, n10);
    }

    public void X(double d10) {
        GeneralizedHoughGuil.setXi_0(this.a, d10);
    }

    public void finalize() {
        GeneralizedHoughGuil.delete(this.a);
    }
}

