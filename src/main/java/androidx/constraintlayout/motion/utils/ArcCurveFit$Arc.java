/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class ArcCurveFit$Arc {
    private static final double EPSILON = 0.001;
    private static final String TAG = "Arc";
    private static double[] ourPercent = new double[91];
    public boolean linear;
    public double mArcDistance;
    public double mArcVelocity;
    public double mEllipseA;
    public double mEllipseB;
    public double mEllipseCenterX;
    public double mEllipseCenterY;
    public double[] mLut;
    public double mOneOverDeltaTime;
    public double mTime1;
    public double mTime2;
    public double mTmpCosAngle;
    public double mTmpSinAngle;
    public boolean mVertical;
    public double mX1;
    public double mX2;
    public double mY1;
    public double mY2;

    public ArcCurveFit$Arc(int n10, double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16;
        double d17;
        double d18;
        ArcCurveFit$Arc arcCurveFit$Arc = this;
        int n11 = n10;
        double d19 = d10;
        double d20 = d11;
        double d21 = d12;
        double d22 = d13;
        double d23 = d14;
        double d24 = d15;
        int n12 = 0;
        this.linear = false;
        int n13 = 1;
        if (n10 == n13) {
            n12 = n13;
        }
        arcCurveFit$Arc.mVertical = n12;
        arcCurveFit$Arc.mTime1 = d19;
        arcCurveFit$Arc.mTime2 = d20;
        double d25 = 1.0;
        d19 = d20 - d19;
        arcCurveFit$Arc.mOneOverDeltaTime = d19 = d25 / d19;
        int n14 = 3;
        if (n14 == n11) {
            arcCurveFit$Arc.linear = n13;
        }
        double d26 = d23 - d21;
        double d27 = d24 - d22;
        int n15 = arcCurveFit$Arc.linear;
        if (n15 == 0 && (n15 = (d18 = (d25 = Math.abs(d26)) - (d17 = 0.001)) == 0.0 ? 0 : (d18 < 0.0 ? -1 : 1)) >= 0 && (n15 = (int)((d16 = (d25 = Math.abs(d27)) - d17) == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1))) >= 0) {
            double[] dArray = new double[101];
            arcCurveFit$Arc.mLut = dArray;
            n15 = arcCurveFit$Arc.mVertical ? 1 : 0;
            n12 = n15 != 0 ? -1 : n13;
            d24 = n12;
            arcCurveFit$Arc.mEllipseA = d26 *= d24;
            if (n15 == 0) {
                n13 = -1;
            }
            d26 = n13;
            arcCurveFit$Arc.mEllipseB = d27 *= d26;
            d26 = n15 != 0 ? d23 : d21;
            arcCurveFit$Arc.mEllipseCenterX = d26;
            d26 = n15 != 0 ? d22 : d15;
            arcCurveFit$Arc.mEllipseCenterY = d26;
            d19 = d12;
            d20 = d13;
            d21 = d14;
            d22 = d15;
            this.buildTable(d12, d13, d14, d15);
            d26 = arcCurveFit$Arc.mArcDistance;
            d27 = arcCurveFit$Arc.mOneOverDeltaTime;
            arcCurveFit$Arc.mArcVelocity = d26 *= d27;
            return;
        }
        arcCurveFit$Arc.linear = n13;
        arcCurveFit$Arc.mX1 = d21;
        arcCurveFit$Arc.mX2 = d23;
        arcCurveFit$Arc.mY1 = d22;
        double d28 = d15;
        arcCurveFit$Arc.mY2 = d15;
        arcCurveFit$Arc.mArcDistance = d28 = Math.hypot(d27, d26);
        double d29 = arcCurveFit$Arc.mOneOverDeltaTime;
        arcCurveFit$Arc.mArcVelocity = d28 *= d29;
        d28 = arcCurveFit$Arc.mTime2;
        d29 = arcCurveFit$Arc.mTime1;
        d23 = d28 - d29;
        arcCurveFit$Arc.mEllipseCenterX = d26 /= d23;
        arcCurveFit$Arc.mEllipseCenterY = d27 /= (d28 -= d29);
    }

    private void buildTable(double d10, double d11, double d12, double d13) {
        int n10;
        double[] dArray;
        int n11;
        int n12;
        double d14;
        double[] dArray2;
        int n13;
        ArcCurveFit$Arc arcCurveFit$Arc = this;
        double d15 = d12 - d10;
        double d16 = d11 - d13;
        double d17 = 0.0;
        double d18 = 0.0;
        double d19 = 0.0;
        for (int i10 = 0; i10 < (n13 = (dArray2 = ourPercent).length); ++i10) {
            double d20 = 90.0;
            d14 = (double)i10 * d20;
            n13 = dArray2.length + -1;
            double d21 = d17;
            d17 = n13;
            double d22 = Math.toRadians(d14 /= d17);
            d17 = Math.sin(d22);
            d22 = Math.cos(d22);
            d17 *= d15;
            d22 *= d16;
            if (i10 > 0) {
                d18 = d17 - d18;
                d19 = d22 - d19;
                d18 = Math.hypot(d18, d19);
                d18 = d21 + d18;
                double[] dArray3 = ourPercent;
                dArray3[i10] = d18;
            } else {
                d18 = d21;
            }
            d19 = d22;
            double d23 = d17;
            d17 = d18;
            d18 = d23;
        }
        d18 = d17;
        arcCurveFit$Arc.mArcDistance = d17;
        double[] dArray4 = null;
        for (n12 = 0; n12 < (n11 = (dArray = ourPercent).length); ++n12) {
            dArray[n12] = d16 = dArray[n12] / d18;
        }
        for (n13 = 0; n13 < (n10 = (dArray4 = arcCurveFit$Arc.mLut).length); ++n13) {
            double d24 = n13;
            dArray4 = ourPercent;
            d14 = dArray4.length + -1;
            n12 = Arrays.binarySearch(dArray4, d24 /= d14);
            if (n12 >= 0) {
                dArray = arcCurveFit$Arc.mLut;
                double[] dArray5 = ourPercent;
                n11 = dArray5.length + -1;
                dArray[n13] = d16 = (double)(n12 /= n11);
                d14 = 0.0;
                continue;
            }
            int n14 = -1;
            if (n12 == n14) {
                dArray4 = arcCurveFit$Arc.mLut;
                dArray4[n13] = d14 = 0.0;
                continue;
            }
            d14 = 0.0;
            n12 = -n12;
            n14 = n12 + -2;
            double d25 = n14;
            double[] dArray6 = ourPercent;
            d18 = dArray6[n14];
            d24 -= d18;
            d18 = dArray6[n12 += -1];
            d19 = dArray6[n14];
            d25 += (d24 /= (d18 -= d19));
            n12 = dArray6.length + -1;
            d15 = n12;
            dArray4 = arcCurveFit$Arc.mLut;
            dArray4[n13] = d25 /= d15;
        }
    }

    public double getDX() {
        double d10 = this.mEllipseA;
        double d11 = this.mTmpCosAngle;
        d10 *= d11;
        d11 = -this.mEllipseB;
        double d12 = this.mTmpSinAngle;
        d11 *= d12;
        d12 = this.mArcVelocity;
        d11 = Math.hypot(d10, d11);
        d12 /= d11;
        boolean bl2 = this.mVertical;
        if (bl2) {
            d10 = -d10;
        }
        return d10 * d12;
    }

    public double getDY() {
        double d10 = this.mEllipseA;
        double d11 = this.mTmpCosAngle;
        d10 *= d11;
        d11 = -this.mEllipseB;
        double d12 = this.mTmpSinAngle;
        d11 *= d12;
        d12 = this.mArcVelocity;
        d10 = Math.hypot(d10, d11);
        d12 /= d10;
        boolean bl2 = this.mVertical;
        d10 = bl2 ? -d11 * d12 : d11 * d12;
        return d10;
    }

    public double getLinearDX(double d10) {
        return this.mEllipseCenterX;
    }

    public double getLinearDY(double d10) {
        return this.mEllipseCenterY;
    }

    public double getLinearX(double d10) {
        double d11 = this.mTime1;
        d10 -= d11;
        d11 = this.mOneOverDeltaTime;
        d10 *= d11;
        d11 = this.mX1;
        double d12 = this.mX2 - d11;
        return d11 + (d10 *= d12);
    }

    public double getLinearY(double d10) {
        double d11 = this.mTime1;
        d10 -= d11;
        d11 = this.mOneOverDeltaTime;
        d10 *= d11;
        d11 = this.mY1;
        double d12 = this.mY2 - d11;
        return d11 + (d10 *= d12);
    }

    public double getX() {
        double d10 = this.mEllipseCenterX;
        double d11 = this.mEllipseA;
        double d12 = this.mTmpSinAngle;
        return d10 + (d11 *= d12);
    }

    public double getY() {
        double d10 = this.mEllipseCenterY;
        double d11 = this.mEllipseB;
        double d12 = this.mTmpCosAngle;
        return d10 + (d11 *= d12);
    }

    public double lookup(double d10) {
        double d11 = 0.0;
        double d12 = d10 - d11;
        double d13 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (d13 <= 0) {
            return d11;
        }
        d11 = 1.0;
        double d14 = d10 - d11;
        d13 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (d13 >= 0) {
            return d11;
        }
        double[] dArray = this.mLut;
        double d15 = dArray.length + -1;
        int n10 = (int)(d10 *= d15);
        double d16 = n10;
        d10 -= d16;
        d16 = dArray[n10];
        int n11 = n10 + 1;
        double d17 = dArray[n11];
        double d18 = dArray[n10];
        return d16 + (d10 *= (d17 -= d18));
    }

    public void setPoint(double d10) {
        double d11;
        boolean bl2 = this.mVertical;
        if (bl2) {
            d11 = this.mTime2 - d10;
        } else {
            d11 = this.mTime1;
            d11 = d10 - d11;
        }
        d10 = this.mOneOverDeltaTime;
        d11 *= d10;
        d11 = this.lookup(d11) * 1.5707963267948966;
        this.mTmpSinAngle = d10 = Math.sin(d11);
        this.mTmpCosAngle = d10 = Math.cos(d11);
    }
}

