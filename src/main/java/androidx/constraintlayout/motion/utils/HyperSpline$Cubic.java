/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.utils;

public class HyperSpline$Cubic {
    public static final double HALF = 0.5;
    public static final double THIRD = 0.3333333333333333;
    public double mA;
    public double mB;
    public double mC;
    public double mD;

    public HyperSpline$Cubic(double d10, double d11, double d12, double d13) {
        this.mA = d10;
        this.mB = d11;
        this.mC = d12;
        this.mD = d13;
    }

    public double eval(double d10) {
        double d11 = this.mD * d10;
        double d12 = this.mC;
        d11 = (d11 + d12) * d10;
        d12 = this.mB;
        d11 = (d11 + d12) * d10;
        d10 = this.mA;
        return d11 + d10;
    }

    public double vel(double d10) {
        double d11 = this.mD * 0.3333333333333333 * d10;
        double d12 = this.mC * 0.5;
        d11 = (d11 + d12) * d10;
        d10 = this.mB;
        return d11 + d10;
    }
}

