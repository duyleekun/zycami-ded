/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.photo;

import org.opencv.core.Mat;
import org.opencv.photo.CalibrateCRF;

public class CalibrateRobertson
extends CalibrateCRF {
    public CalibrateRobertson(long l10) {
        super(l10);
    }

    private static native void delete(long var0);

    private static native int getMaxIter_0(long var0);

    private static native long getRadiance_0(long var0);

    private static native float getThreshold_0(long var0);

    public static CalibrateRobertson i(long l10) {
        CalibrateRobertson calibrateRobertson = new CalibrateRobertson(l10);
        return calibrateRobertson;
    }

    private static native void setMaxIter_0(long var0, int var2);

    private static native void setThreshold_0(long var0, float var2);

    public void finalize() {
        CalibrateRobertson.delete(this.a);
    }

    public int j() {
        return CalibrateRobertson.getMaxIter_0(this.a);
    }

    public Mat k() {
        long l10 = CalibrateRobertson.getRadiance_0(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public float l() {
        return CalibrateRobertson.getThreshold_0(this.a);
    }

    public void m(int n10) {
        CalibrateRobertson.setMaxIter_0(this.a, n10);
    }

    public void n(float f10) {
        CalibrateRobertson.setThreshold_0(this.a, f10);
    }
}

