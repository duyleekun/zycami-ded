/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import org.opencv.photo.CalibrateCRF;

public class CalibrateDebevec
extends CalibrateCRF {
    public CalibrateDebevec(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native float getLambda_0(long var0);

    private static native boolean getRandom_0(long var0);

    private static native int getSamples_0(long var0);

    public static CalibrateDebevec i(long l10) {
        CalibrateDebevec calibrateDebevec = new CalibrateDebevec(l10);
        return calibrateDebevec;
    }

    private static native void setLambda_0(long var0, float var2);

    private static native void setRandom_0(long var0, boolean var2);

    private static native void setSamples_0(long var0, int var2);

    public void finalize() {
        CalibrateDebevec.delete(this.a);
    }

    public float j() {
        return CalibrateDebevec.getLambda_0(this.a);
    }

    public boolean k() {
        return CalibrateDebevec.getRandom_0(this.a);
    }

    public int l() {
        return CalibrateDebevec.getSamples_0(this.a);
    }

    public void m(float f10) {
        CalibrateDebevec.setLambda_0(this.a, f10);
    }

    public void n(boolean bl2) {
        CalibrateDebevec.setRandom_0(this.a, bl2);
    }

    public void o(int n10) {
        CalibrateDebevec.setSamples_0(this.a, n10);
    }
}

