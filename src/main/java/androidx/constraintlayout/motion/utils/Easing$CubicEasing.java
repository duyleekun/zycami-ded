/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.Easing;

public class Easing$CubicEasing
extends Easing {
    private static double d_error = 1.0E-4;
    private static double error = 0.01;
    public double x1;
    public double x2;
    public double y1;
    public double y2;

    public Easing$CubicEasing(double d10, double d11, double d12, double d13) {
        this.setup(d10, d11, d12, d13);
    }

    public Easing$CubicEasing(String string2) {
        double d10;
        double d11;
        double d12;
        this.str = string2;
        int n10 = string2.indexOf(40);
        int n11 = 44;
        int n12 = string2.indexOf(n11, n10);
        this.x1 = d12 = Double.parseDouble(string2.substring(++n10, n12).trim());
        n10 = string2.indexOf(n11, ++n12);
        this.y1 = d11 = Double.parseDouble(string2.substring(n12, n10).trim());
        n11 = string2.indexOf(n11, ++n10);
        this.x2 = d11 = Double.parseDouble(string2.substring(n10, n11).trim());
        n10 = string2.indexOf(41, ++n11);
        this.y2 = d10 = Double.parseDouble(string2.substring(n11, n10).trim());
    }

    private double getDiffX(double d10) {
        double d11 = 1.0;
        double d12 = d11 - d10;
        double d13 = 3.0;
        double d14 = d12 * d13 * d12;
        double d15 = this.x1;
        d14 *= d15;
        d12 = d12 * 6.0 * d10;
        double d16 = this.x2;
        d15 = d16 - d15;
        d13 = d13 * d10 * d10;
        return (d14 += (d12 *= d15)) + (d13 *= (d11 -= d16));
    }

    private double getDiffY(double d10) {
        double d11 = 1.0;
        double d12 = d11 - d10;
        double d13 = 3.0;
        double d14 = d12 * d13 * d12;
        double d15 = this.y1;
        d14 *= d15;
        d12 = d12 * 6.0 * d10;
        double d16 = this.y2;
        d15 = d16 - d15;
        d13 = d13 * d10 * d10;
        return (d14 += (d12 *= d15)) + (d13 *= (d11 -= d16));
    }

    private double getX(double d10) {
        double d11 = 1.0 - d10;
        double d12 = 3.0 * d11;
        d11 = d11 * d12 * d10;
        d12 = d12 * d10 * d10;
        double d13 = d10 * d10 * d10;
        d10 = this.x1 * d11;
        d11 = this.x2 * d12;
        return d10 + d11 + d13;
    }

    private double getY(double d10) {
        double d11 = 1.0 - d10;
        double d12 = 3.0 * d11;
        d11 = d11 * d12 * d10;
        d12 = d12 * d10 * d10;
        double d13 = d10 * d10 * d10;
        d10 = this.y1 * d11;
        d11 = this.y2 * d12;
        return d10 + d11 + d13;
    }

    public double get(double d10) {
        double d11;
        double d12;
        Object object;
        double d13 = 0.0;
        double d14 = d10 - d13;
        Object object2 = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
        if (object2 <= 0) {
            return d13;
        }
        d13 = 1.0;
        double d15 = d10 - d13;
        object2 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
        if (object2 >= 0) {
            return d13;
        }
        double d16 = d13 = 0.5;
        double d17 = d13;
        while ((object = (d12 = d16 - (d11 = error)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) > 0) {
            d11 = this.getX(d17);
            d16 *= d13;
            object = d11 == d10 ? 0 : (d11 < d10 ? -1 : 1);
            if (object < 0) {
                d17 += d16;
                continue;
            }
            d17 -= d16;
        }
        d13 = d17 - d16;
        d11 = this.getX(d13);
        d17 += d16;
        d16 = this.getX(d17);
        d13 = this.getY(d13);
        d17 = this.getY(d17) - d13;
        return (d17 *= (d10 -= d11)) / (d16 -= d11) + d13;
    }

    public double getDiff(double d10) {
        double d11;
        double d12;
        Object object;
        double d13;
        double d14 = d13 = 0.5;
        double d15 = d13;
        while ((object = (d12 = d14 - (d11 = d_error)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) > 0) {
            d11 = this.getX(d15);
            d14 *= d13;
            object = d11 == d10 ? 0 : (d11 < d10 ? -1 : 1);
            if (object < 0) {
                d15 += d14;
                continue;
            }
            d15 -= d14;
        }
        d10 = d15 - d14;
        d13 = this.getX(d10);
        d15 += d14;
        d14 = this.getX(d15);
        d10 = this.getY(d10);
        d15 = this.getY(d15) - d10;
        return d15 / (d14 -= d13);
    }

    public void setup(double d10, double d11, double d12, double d13) {
        this.x1 = d10;
        this.y1 = d11;
        this.x2 = d12;
        this.y2 = d13;
    }
}

