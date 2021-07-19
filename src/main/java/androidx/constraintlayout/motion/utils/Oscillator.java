/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    public double PI2;
    public double[] mArea;
    private boolean mNormalized;
    public float[] mPeriod;
    public double[] mPosition;
    public int mType;

    public Oscillator() {
        Object[] objectArray = new float[]{};
        this.mPeriod = objectArray;
        objectArray = new double[0];
        this.mPosition = objectArray;
        this.PI2 = Math.PI * 2;
        this.mNormalized = false;
    }

    public void addPoint(double d10, float f10) {
        float[] fArray = this.mPeriod;
        int n10 = fArray.length + 1;
        double[] dArray = this.mPosition;
        int n11 = Arrays.binarySearch(dArray, d10);
        if (n11 < 0) {
            n11 = -n11 + -1;
        }
        Object[] objectArray = Arrays.copyOf(this.mPosition, n10);
        this.mPosition = objectArray;
        objectArray = Arrays.copyOf(this.mPeriod, n10);
        this.mPeriod = (float[])objectArray;
        objectArray = new double[n10];
        this.mArea = objectArray;
        objectArray = this.mPosition;
        int n12 = n11 + 1;
        n10 = n10 - n11 + -1;
        System.arraycopy(objectArray, n11, objectArray, n12, n10);
        this.mPosition[n11] = d10;
        this.mPeriod[n11] = f10;
        this.mNormalized = false;
    }

    public double getDP(double d10) {
        double d11 = 0.0;
        double d12 = d10 - d11;
        double d13 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (d13 <= 0) {
            d10 = 1.0E-5;
        } else {
            double d14 = 1.0;
            double d15 = d10 - d14;
            d13 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
            if (d13 >= 0) {
                d10 = 0.999999;
            }
        }
        double[] dArray = this.mPosition;
        d13 = Arrays.binarySearch(dArray, d10);
        if (d13 > 0) {
            return d11;
        }
        if (d13 != false) {
            double d16 = -d13 + -1;
            float[] fArray = this.mPeriod;
            float f10 = fArray[d16];
            double d17 = d16 + -1;
            float f11 = fArray[d17];
            double d18 = f10 -= f11;
            dArray = this.mPosition;
            double d19 = dArray[d16];
            double d20 = dArray[d17];
            float f12 = fArray[d17];
            d11 = f12;
            d19 = dArray[d17];
            d11 = d11 - (d18 *= d19) + (d10 *= (d18 /= (d19 -= d20)));
        }
        return d11;
    }

    public double getP(double d10) {
        double d11 = 0.0;
        double d12 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        long l10 = 0x3FF0000000000000L;
        double d13 = 1.0;
        if (d12 < 0) {
            d10 = d11;
        } else {
            d12 = d10 == d13 ? 0 : (d10 > d13 ? 1 : -1);
            if (d12 > 0) {
                d10 = d13;
            }
        }
        double[] dArray = this.mPosition;
        d12 = Arrays.binarySearch(dArray, d10);
        if (d12 > 0) {
            d11 = d13;
        } else if (d12 != false) {
            double d14 = -d12 + -1;
            float[] fArray = this.mPeriod;
            float f10 = fArray[d14];
            double d15 = d14 + -1;
            float f11 = fArray[d15];
            double d16 = f10 -= f11;
            dArray = this.mPosition;
            double d17 = dArray[d14];
            double d18 = dArray[d15];
            d16 /= (d17 -= d18);
            double[] dArray2 = this.mArea;
            d17 = dArray2[d15];
            float f12 = fArray[d15];
            d11 = f12;
            d18 = dArray[d15] * d16;
            d11 -= d18;
            d18 = dArray[d15];
            d18 = d10 - d18;
            d17 += (d11 *= d18);
            d10 *= d10;
            d11 = dArray[d15];
            d18 = dArray[d15];
            d16 *= (d10 -= (d11 *= d18));
            d10 = 2.0;
            d11 = d17 + (d16 /= d10);
        }
        return d11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public double getSlope(double d10) {
        int n10 = this.mType;
        double d11 = 2.0;
        double d12 = 4.0;
        switch (n10) {
            default: {
                double d13 = this.PI2;
                double d14 = this.getDP(d10);
                d13 *= d14;
                d14 = this.PI2;
                d10 = this.getP(d10);
                d14 *= d10;
                d10 = Math.cos(d14);
                return d13 * d10;
            }
            case 6: {
                double d15 = this.getDP(d10) * d12;
                d10 = (this.getP(d10) * d12 + d11) % d12 - d11;
                return d15 * d10;
            }
            case 5: {
                double d13 = -this.PI2;
                double d16 = this.getDP(d10);
                d13 *= d16;
                d16 = this.PI2;
                d10 = this.getP(d10);
                d16 *= d10;
                d10 = Math.sin(d16);
                return d13 * d10;
            }
            case 4: {
                d10 = -this.getDP(d10);
                return d10 * d11;
            }
            case 3: {
                d10 = this.getDP(d10);
                return d10 * d11;
            }
            case 2: {
                double d15 = this.getDP(d10) * d12;
                d10 = this.getP(d10) * d12;
                double d17 = 3.0;
                d10 = Math.signum((d10 + d17) % d12 - d11);
                return d15 * d10;
            }
            case 1: 
        }
        return 0.0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public double getValue(double d10) {
        int n10 = this.mType;
        double d11 = 4.0;
        double d12 = 2.0;
        double d13 = 1.0;
        switch (n10) {
            default: {
                double d14 = this.PI2;
                d10 = this.getP(d10);
                return Math.sin(d14 * d10);
            }
            case 6: {
                d10 = Math.abs(this.getP(d10) * d11 % d11 - d12);
                d10 = d13 - d10;
                d10 *= d10;
                return d13 - d10;
            }
            case 5: {
                double d15 = this.PI2;
                d10 = this.getP(d10);
                return Math.cos(d15 * d10);
            }
            case 4: {
                d10 = (this.getP(d10) * d12 + d13) % d12;
                return d13 - d10;
            }
            case 3: {
                return (this.getP(d10) * d12 + d13) % d12 - d13;
            }
            case 2: {
                d10 = Math.abs((this.getP(d10) * d11 + d13) % d11 - d12);
                return d13 - d10;
            }
            case 1: 
        }
        d10 = this.getP(d10) % d13;
        return Math.signum(0.5 - d10);
    }

    public void normalize() {
        Object[] objectArray;
        int n10;
        double d10;
        float f10;
        int n11;
        Object[] objectArray2;
        float f11;
        float[] fArray;
        int n12;
        int n13;
        Oscillator oscillator = this;
        int n14 = 0;
        double d11 = 0.0;
        float f12 = 0.0f;
        double d12 = d11;
        for (n13 = 0; n13 < (n12 = (fArray = oscillator.mPeriod).length); ++n13) {
            f11 = fArray[n13];
            double d13 = f11;
            d12 += d13;
        }
        n13 = 1;
        f12 = Float.MIN_VALUE;
        double d14 = d11;
        int n15 = n13;
        f11 = f12;
        while (true) {
            objectArray2 = oscillator.mPeriod;
            n11 = objectArray2.length;
            f10 = 2.0f;
            if (n15 >= n11) break;
            n11 = n15 + -1;
            float f13 = objectArray2[n11];
            float f14 = objectArray2[n15];
            f13 = (f13 + f14) / f10;
            objectArray2 = oscillator.mPosition;
            float f15 = objectArray2[n15];
            float f16 = objectArray2[n11];
            f15 -= f16;
            d10 = f13;
            d14 += (f15 *= d10);
            ++n15;
        }
        fArray = null;
        f11 = 0.0f;
        for (n15 = 0; n15 < (n11 = (objectArray2 = oscillator.mPeriod).length); ++n15) {
            float f17;
            double d15 = objectArray2[n15];
            double d16 = d12 / d14;
            objectArray2[n15] = f17 = (float)(d15 *= d16);
        }
        double[] dArray = oscillator.mArea;
        dArray[0] = d11;
        for (n14 = n13; n14 < (n10 = (objectArray = oscillator.mPeriod).length); ++n14) {
            n10 = n14 + -1;
            float f18 = objectArray[n10];
            float f19 = objectArray[n14];
            f18 = (f18 + f19) / f10;
            objectArray = oscillator.mPosition;
            float f20 = objectArray[n14];
            d14 = objectArray[n10];
            f20 -= d14;
            objectArray = oscillator.mArea;
            d14 = objectArray[n10];
            d10 = f18;
            objectArray[n14] = (float)(d14 += (f20 *= d10));
        }
        oscillator.mNormalized = n13;
    }

    public void setType(int n10) {
        this.mType = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pos =");
        String string2 = Arrays.toString(this.mPosition);
        stringBuilder.append(string2);
        stringBuilder.append(" period=");
        string2 = Arrays.toString(this.mPeriod);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

