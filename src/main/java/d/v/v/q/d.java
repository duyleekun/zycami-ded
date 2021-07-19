/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package d.v.v.q;

import android.graphics.PointF;
import java.math.BigDecimal;

public class d {
    public static StringBuilder a(StringBuilder stringBuilder, double d10, double d11) {
        stringBuilder.append("(");
        StringBuilder stringBuilder2 = new StringBuilder();
        float f10 = d.f(d10);
        stringBuilder2.append(f10);
        stringBuilder2.append(",");
        String string2 = stringBuilder2.toString();
        stringBuilder.append(string2);
        f10 = d.f(d11);
        stringBuilder.append(f10);
        stringBuilder.append(")");
        return stringBuilder;
    }

    public static double b(double d10, float f10, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        double d11 = d.c(d10, f10, pointF, pointF2, pointF3, pointF4);
        double d12 = 1.0E-8;
        double d13 = d.c(d10 - d12, f10, pointF, pointF2, pointF3, pointF4);
        return (d11 - d13) / d12;
    }

    public static double c(double d10, float f10, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        double d11 = d10;
        double d12 = pointF.x;
        double d13 = 1.0 - d10;
        double d14 = 3.0;
        double d15 = d.g(d13, d14);
        d12 *= d15;
        float f11 = pointF3.x;
        float f12 = 3.0f;
        double d16 = (double)(f11 * f12) * d10;
        double d17 = 2.0;
        double d18 = d.g(d13, d17);
        d12 += (d16 *= d18);
        d15 = (double)(pointF4.x * f12) * d13;
        d13 = d.g(d10, d17);
        d12 += (d15 *= d13);
        d13 = pointF2.x;
        d11 = d.g(d10, d14);
        d12 += (d13 *= d11);
        d11 = f10;
        return d12 - d11;
    }

    public static double d(double d10, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        double d11 = d10;
        double d12 = pointF.y;
        double d13 = 1.0 - d10;
        double d14 = 3.0;
        double d15 = d.g(d13, d14);
        d12 *= d15;
        float f10 = pointF3.y;
        float f11 = 3.0f;
        double d16 = (double)(f10 * f11) * d10;
        double d17 = 2.0;
        double d18 = d.g(d13, d17);
        d12 += (d16 *= d18);
        d15 = (double)(pointF4.y * f11) * d13;
        d13 = d.g(d10, d17);
        d12 += (d15 *= d13);
        d13 = pointF2.y;
        d11 = d.g(d10, d14);
        return d12 + (d13 *= d11);
    }

    public static double e(float f10, PointF pointF, PointF pointF2) {
        double d10;
        float f11 = pointF2.x;
        float f12 = pointF.x;
        f11 -= f12;
        PointF pointF3 = new PointF();
        f12 = pointF.x;
        pointF3.x = f12 += (f11 /= 3.0f);
        pointF3.y = f12 = pointF.y;
        PointF pointF4 = new PointF();
        f12 = pointF.x;
        pointF4.x = f12 += (f11 *= 2.0f);
        pointF4.y = f11 = pointF2.y;
        double d11 = d10 = 0.5;
        int n10 = 0;
        while (true) {
            int n11 = 1000;
            f11 = 1.401E-42f;
            if (n10 >= n11) break;
            d10 = d11;
            double d12 = d.c(d11, f10, pointF, pointF2, pointF3, pointF4);
            d10 = d.b(d11, f10, pointF, pointF2, pointF3, pointF4);
            d10 = d12 / d10;
            d11 -= d10;
            d10 = 0.0;
            double d13 = d12 - d10;
            n11 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
            if (n11 == 0) break;
            ++n10;
        }
        d10 = d11;
        return d.d(d11, pointF, pointF2, pointF3, pointF4);
    }

    public static float f(double d10) {
        BigDecimal bigDecimal = new BigDecimal(d10);
        return bigDecimal.setScale(2, 4).floatValue();
    }

    public static double g(double d10, double d11) {
        return Math.pow(d10, d11);
    }
}

