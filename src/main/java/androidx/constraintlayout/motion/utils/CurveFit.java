/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.MonotonicCurveFit
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.ArcCurveFit;
import androidx.constraintlayout.motion.utils.CurveFit$Constant;
import androidx.constraintlayout.motion.utils.LinearCurveFit;
import androidx.constraintlayout.motion.utils.MonotonicCurveFit;

public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE;

    public static CurveFit get(int n10, double[] dArray, double[][] dArray2) {
        int n11 = dArray.length;
        int n12 = 2;
        int n13 = 1;
        if (n11 == n13) {
            n10 = n12;
        }
        if (n10 != 0) {
            if (n10 != n12) {
                LinearCurveFit linearCurveFit = new LinearCurveFit(dArray, dArray2);
                return linearCurveFit;
            }
            double d10 = dArray[0];
            dArray = dArray2[0];
            CurveFit$Constant curveFit$Constant = new CurveFit$Constant(d10, dArray);
            return curveFit$Constant;
        }
        MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArray, dArray2);
        return monotonicCurveFit;
    }

    public static CurveFit getArc(int[] nArray, double[] dArray, double[][] dArray2) {
        ArcCurveFit arcCurveFit = new ArcCurveFit(nArray, dArray, dArray2);
        return arcCurveFit;
    }

    public abstract double getPos(double var1, int var3);

    public abstract void getPos(double var1, double[] var3);

    public abstract void getPos(double var1, float[] var3);

    public abstract double getSlope(double var1, int var3);

    public abstract void getSlope(double var1, double[] var3);

    public abstract double[] getTimePoints();
}

