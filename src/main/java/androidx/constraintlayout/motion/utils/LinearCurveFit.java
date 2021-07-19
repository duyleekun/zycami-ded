/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.CurveFit;

public class LinearCurveFit
extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArray, double[][] dArray2) {
        double d10;
        this.mTotalLength = d10 = 0.0 / 0.0;
        int cfr_ignored_0 = dArray.length;
        double[] dArray3 = dArray2[0];
        int n10 = dArray3.length;
        this.mT = dArray;
        this.mY = dArray2;
        int n11 = 2;
        if (n10 > n11) {
            int n12;
            double d11 = 0.0;
            double d12 = d11;
            double d13 = d11;
            for (int i10 = 0; i10 < (n12 = dArray.length); ++i10) {
                double d14 = dArray2[i10][0];
                double[] dArray4 = dArray2[i10];
                double d15 = dArray4[0];
                if (i10 > 0) {
                    d12 = d14 - d12;
                    d13 = d15 - d13;
                    Math.hypot(d12, d13);
                }
                d12 = d14;
                d13 = d15;
            }
            this.mTotalLength = d11;
        }
    }

    private double getLength2D(double d10) {
        LinearCurveFit linearCurveFit = this;
        double d11 = this.mTotalLength;
        Object object = Double.isNaN(d11);
        double d12 = 0.0;
        if (object != 0) {
            return d12;
        }
        double[] dArray = this.mT;
        int n10 = dArray.length;
        double d13 = dArray[0];
        double d14 = d10 - d13;
        Object object2 = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
        if (object2 <= 0) {
            return d12;
        }
        object2 = true;
        double d15 = dArray[n10 -= object2];
        double d16 = d10 - d15;
        object = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
        if (object >= 0) {
            return this.mTotalLength;
        }
        d15 = d12;
        double d17 = d12;
        double d18 = d12;
        object = 0;
        dArray = null;
        while (object < n10) {
            double[] dArray2;
            double d19;
            double d20;
            double d21;
            Object object3 = linearCurveFit.mY;
            double[] dArray3 = object3[object];
            double d22 = dArray3[0];
            object3 = object3[object];
            double[] dArray4 = object3[object2];
            if (object > 0) {
                d17 = d22 - d17;
                d18 = (double)(dArray4 - d18);
                d17 = Math.hypot(d17, d18);
                d15 += d17;
            }
            if ((d21 = (d20 = d10 - (d19 = (dArray2 = linearCurveFit.mT)[object])) == 0.0 ? 0 : (d20 > 0.0 ? 1 : -1)) == false) {
                return d15;
            }
            d21 = object + 1;
            d18 = dArray2[d21];
            double d23 = d10 - d18;
            Object object4 = d23 == 0.0 ? 0 : (d23 < 0.0 ? -1 : 1);
            if (object4 < 0) {
                d12 = dArray2[d21];
                d18 = dArray2[object];
                d12 -= d18;
                d18 = dArray2[object];
                d18 = (d10 - d18) / d12;
                double[][] dArray5 = linearCurveFit.mY;
                double d24 = dArray5[object][0];
                double d25 = dArray5[d21][0];
                double d26 = dArray5[object][object2];
                d12 = dArray5[d21][object2];
                d17 = 1.0 - d18;
                d26 *= d17;
                d11 = (double)(dArray4 - (d26 += (d12 *= d18)));
                d24 *= d17;
                double d27 = d22 - (d24 += (d25 *= d18));
                d11 = Math.hypot(d11, d27);
                return d15 + d11;
            }
            object = d21;
            d17 = d22;
            d18 = (double)dArray4;
        }
        return d12;
    }

    public double getPos(double d10, int n10) {
        Object object = this.mT;
        int n11 = ((double[])object).length;
        int n12 = 0;
        double d11 = object[0];
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object2 <= 0) {
            return this.mY[0][n10];
        }
        d11 = object[n11 += -1];
        double d13 = d10 - d11;
        Object object3 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object3 >= 0) {
            return this.mY[n11][n10];
        }
        while (n12 < n11) {
            object = this.mT;
            d11 = object[n12];
            double d14 = d10 - d11;
            object2 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object2 == false) {
                return this.mY[n12][n10];
            }
            object2 = n12 + 1;
            double d15 = object[object2];
            double d16 = d10 - d15;
            Object object4 = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
            if (object4 < 0) {
                d15 = object[object2];
                double d17 = object[n12];
                d15 -= d17;
                d17 = object[n12];
                d10 = (d10 - d17) / d15;
                object = this.mY;
                d15 = object[n12][n10];
                void var16_12 = object[object2][n10];
                d17 = 1.0 - d10;
                return (d15 *= d17) + (var16_12 *= d10);
            }
            n12 = (int)object2;
        }
        return 0.0;
    }

    public void getPos(double d10, double[] dArray) {
        int n10;
        double[] dArray2 = this.mT;
        int n11 = dArray2.length;
        Object object = this.mY;
        object = object[0];
        int n12 = ((double[][])object).length;
        double d11 = dArray2[0];
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object2 <= 0) {
            Object var13_11 = null;
            for (int i10 = 0; i10 < n12; ++i10) {
                double d13;
                double[] dArray3 = this.mY[0];
                dArray[i10] = d13 = dArray3[i10];
            }
            return;
        }
        d11 = dArray2[n11 += -1];
        double d14 = d10 - d11;
        Object object3 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object3 >= 0) {
            for (n10 = 0; n10 < n12; ++n10) {
                double[] dArray4 = this.mY[n11];
                dArray[n10] = d11 = dArray4[n10];
            }
            return;
        }
        object3 = false;
        dArray2 = null;
        while (object3 < n11) {
            double d15;
            double d16;
            double d17;
            double d18;
            double[] dArray5 = this.mT;
            double d19 = dArray5[object3];
            double d20 = d10 - d19;
            object2 = d20 == 0.0 ? 0 : (d20 > 0.0 ? 1 : -1);
            if (object2 == false) {
                dArray5 = null;
                for (object2 = (Object)false; object2 < n12; ++object2) {
                    double[] dArray6 = this.mY[object3];
                    dArray[object2] = d18 = dArray6[object2];
                }
            }
            if ((d17 = (d16 = d10 - (d18 = (dArray5 = this.mT)[d15 = object3 + true])) == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1)) < 0) {
                d18 = dArray5[d15];
                double d21 = dArray5[object3];
                d18 -= d21;
                d21 = dArray5[object3];
                d10 = (d10 - d21) / d18;
                while (n10 < n12) {
                    Object object4 = this.mY;
                    dArray5 = object4[object3];
                    d18 = dArray5[n10];
                    object4 = object4[d15];
                    d21 = (double)object4[n10];
                    double d22 = 1.0 - d10;
                    d18 *= d22;
                    dArray[n10] = d18 += (d21 *= d10);
                    ++n10;
                }
                return;
            }
            object3 = d15;
        }
    }

    public void getPos(double d10, float[] fArray) {
        int n10;
        double[] dArray = this.mT;
        int n11 = dArray.length;
        Object object = this.mY;
        object = object[0];
        int n12 = ((double[][])object).length;
        double d11 = dArray[0];
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object2 <= 0) {
            Object var13_11 = null;
            float f10 = 0.0f;
            for (int i10 = 0; i10 < n12; ++i10) {
                float f11;
                double[] dArray2 = this.mY[0];
                double d13 = dArray2[i10];
                fArray[i10] = f11 = (float)d13;
            }
            return;
        }
        d11 = dArray[n11 += -1];
        double d14 = d10 - d11;
        Object object3 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object3 >= 0) {
            for (n10 = 0; n10 < n12; ++n10) {
                float f12;
                double[] dArray3 = this.mY[n11];
                d11 = dArray3[n10];
                fArray[n10] = f12 = (float)d11;
            }
            return;
        }
        object3 = false;
        dArray = null;
        while (object3 < n11) {
            double d15;
            double d16;
            double d17;
            double d18;
            double[] dArray4 = this.mT;
            double d19 = dArray4[object3];
            double d20 = d10 - d19;
            object2 = d20 == 0.0 ? 0 : (d20 > 0.0 ? 1 : -1);
            if (object2 == false) {
                dArray4 = null;
                for (object2 = (Object)false; object2 < n12; ++object2) {
                    float f13;
                    double[] dArray5 = this.mY[object3];
                    d18 = dArray5[object2];
                    fArray[object2] = f13 = (float)d18;
                }
            }
            if ((d17 = (d16 = d10 - (d18 = (dArray4 = this.mT)[d15 = object3 + true])) == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1)) < 0) {
                d18 = dArray4[d15];
                double d21 = dArray4[object3];
                d18 -= d21;
                d21 = dArray4[object3];
                d10 = (d10 - d21) / d18;
                while (n10 < n12) {
                    float f14;
                    Object object4 = this.mY;
                    dArray4 = object4[object3];
                    d18 = dArray4[n10];
                    object4 = object4[d15];
                    d21 = (double)object4[n10];
                    double d22 = 1.0 - d10;
                    d18 *= d22;
                    fArray[n10] = f14 = (float)(d18 += (d21 *= d10));
                    ++n10;
                }
                return;
            }
            object3 = d15;
        }
    }

    public double getSlope(double d10, int n10) {
        int n11;
        Object object;
        double d11;
        Object object2 = this.mT;
        int n12 = ((double[])object2).length;
        int n13 = 0;
        double d12 = object2[0];
        double d13 = d10 - d12;
        Object object3 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object3 < 0) {
            d10 = object2[0];
        } else {
            object3 = n12 + -1;
            d11 = object2[object3];
            double d14 = d10 - d11;
            object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object >= 0) {
                d10 = object2[object3];
            }
        }
        while (n13 < (n11 = n12 + -1)) {
            object2 = this.mT;
            object3 = n13 + 1;
            d11 = object2[object3];
            double d15 = d10 - d11;
            object = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
            if (object <= 0) {
                d10 = object2[object3];
                d11 = object2[n13];
                d10 -= d11;
                d11 = object2[n13];
                object2 = this.mY;
                d11 = object2[n13][n10];
                return (double)((object2[object3][n10] - d11) / d10);
            }
            n13 = (int)object3;
        }
        return 0.0;
    }

    public void getSlope(double d10, double[] dArray) {
        Object object;
        double[] dArray2 = this.mT;
        int n10 = dArray2.length;
        Object object2 = this.mY;
        int n11 = 0;
        object2 = object2[0];
        int n12 = ((double[][])object2).length;
        double d11 = dArray2[0];
        double d12 = d10 - d11;
        Object object3 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object3 <= 0) {
            d10 = dArray2[0];
        } else {
            object3 = n10 + -1;
            double d13 = dArray2[object3];
            double d14 = d10 - d13;
            object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object >= 0) {
                d10 = dArray2[object3];
            }
        }
        int n13 = 0;
        dArray2 = null;
        while (n13 < (object3 = (Object)(n10 + -1))) {
            double[] dArray3 = this.mT;
            object = n13 + 1;
            double d15 = dArray3[object];
            double d16 = d10 - d15;
            Object object4 = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
            if (object4 <= 0) {
                d10 = dArray3[object];
                d15 = dArray3[n13];
                d10 -= d15;
                d15 = dArray3[n13];
                while (n11 < n12) {
                    Object object5 = this.mY;
                    dArray3 = object5[n13];
                    d15 = dArray3[n11];
                    object5 = object5[object];
                    reference var21_17 = (object5[n11] - d15) / d10;
                    dArray[n11] = (double)var21_17;
                    ++n11;
                }
                break;
            }
            n13 = (int)object;
        }
    }

    public double[] getTimePoints() {
        return this.mT;
    }
}

