/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.CurveFit;

public class CurveFit$Constant
extends CurveFit {
    public double mTime;
    public double[] mValue;

    public CurveFit$Constant(double d10, double[] dArray) {
        this.mTime = d10;
        this.mValue = dArray;
    }

    public double getPos(double d10, int n10) {
        return this.mValue[n10];
    }

    public void getPos(double d10, double[] dArray) {
        double[] dArray2 = this.mValue;
        int n10 = dArray2.length;
        System.arraycopy(dArray2, 0, dArray, 0, n10);
    }

    public void getPos(double d10, float[] fArray) {
        double[] dArray;
        int n10;
        for (int i10 = 0; i10 < (n10 = (dArray = this.mValue).length); ++i10) {
            float f10;
            double d11 = dArray[i10];
            fArray[i10] = f10 = (float)d11;
        }
    }

    public double getSlope(double d10, int n10) {
        return 0.0;
    }

    public void getSlope(double d10, double[] dArray) {
        double[] dArray2;
        int n10;
        for (int i10 = 0; i10 < (n10 = (dArray2 = this.mValue).length); ++i10) {
            double d11;
            dArray[i10] = d11 = 0.0;
        }
    }

    public double[] getTimePoints() {
        double d10 = this.mTime;
        double[] dArray = new double[]{d10};
        return dArray;
    }
}

