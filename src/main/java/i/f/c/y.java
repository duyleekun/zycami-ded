/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import java.util.Arrays;

public class y {
    public double[] a;

    public y(double d10) {
        double d11 = 0.0;
        double[] dArray = new double[]{d10, d11, d11, d11};
        this.a = dArray;
    }

    public y(double d10, double d11) {
        double d12 = 0.0;
        double[] dArray = new double[]{d10, d11, d12, d12};
        this.a = dArray;
    }

    public y(double d10, double d11, double d12) {
        double[] dArray = new double[]{d10, d11, d12, 0.0};
        this.a = dArray;
    }

    public y(double d10, double d11, double d12, double d13) {
        double[] dArray = new double[]{d10, d11, d12, d13};
        this.a = dArray;
    }

    public y(double[] dArray) {
        int n10;
        int n11 = 4;
        if (dArray != null && (n10 = dArray.length) == n11) {
            dArray = (double[])dArray.clone();
            this.a = dArray;
        } else {
            double[] dArray2 = new double[n11];
            this.a = dArray2;
            this.g(dArray);
        }
    }

    public static y a(double d10) {
        y y10 = new y(d10, d10, d10, d10);
        return y10;
    }

    public y b() {
        double[] dArray = this.a;
        y y10 = new y(dArray);
        return y10;
    }

    public y c() {
        y y10;
        Object object = this.a;
        double d10 = object[0];
        double d11 = -object[1];
        double d12 = -object[2];
        double d13 = -object[3];
        object = y10;
        y10 = new y(d10, d11, d12, d13);
        return y10;
    }

    public boolean d() {
        double d10;
        double d11;
        double d12;
        double[] dArray = this.a;
        boolean bl2 = true;
        double d13 = dArray[bl2];
        double d14 = 0.0;
        double d15 = d13 - d14;
        Object object = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
        if (object != false || (object = (d12 = (d13 = dArray[2]) - d14) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) != false || (d11 = (d10 = (d13 = dArray[object = (Object)3]) - d14) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) != false) {
            bl2 = false;
        }
        return bl2;
    }

    public y e(y y10) {
        return this.f(y10, 1.0);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof y;
        if (!bl3) {
            return false;
        }
        object = (y)object;
        double[] dArray = this.a;
        object = ((y)object).a;
        boolean bl4 = Arrays.equals(dArray, (double[])object);
        if (!bl4) {
            return false;
        }
        return bl2;
    }

    public y f(y object, double d10) {
        y y10;
        Object object2 = this.a;
        double d11 = object2[0];
        object = ((y)object).a;
        Object object3 = object[0];
        double d12 = d11 * object3 * d10;
        int n10 = 1;
        object3 = object2[n10];
        Object object4 = object[n10];
        reference var15_10 = object3 * object4 * d10;
        int n11 = 2;
        object4 = object2[n11];
        Object object5 = object[n11];
        reference var20_13 = object4 * object5 * d10;
        int n12 = 3;
        object5 = object2[n12];
        reference var23_15 = object[n12];
        var23_15 = object5 * var23_15 * d10;
        object2 = y10;
        y10 = new y(d12, (double)var15_10, (double)var20_13, (double)var23_15);
        return y10;
    }

    public void g(double[] dArray) {
        int n10 = 0;
        int n11 = 3;
        int n12 = 2;
        int n13 = 1;
        double d10 = 0.0;
        if (dArray != null) {
            double[] dArray2 = this.a;
            int n14 = dArray.length;
            double d11 = n14 > 0 ? dArray[0] : d10;
            dArray2[0] = d11;
            n10 = dArray.length;
            d11 = n10 > n13 ? dArray[n13] : d10;
            dArray2[n13] = d11;
            n10 = dArray.length;
            d11 = n10 > n12 ? dArray[n12] : d10;
            dArray2[n12] = d11;
            n10 = dArray.length;
            if (n10 > n11) {
                d10 = dArray[n11];
            }
            dArray2[n11] = d10;
        } else {
            dArray = this.a;
            dArray[n11] = d10;
            dArray[n12] = d10;
            dArray[n13] = d10;
            dArray[0] = d10;
        }
    }

    public int hashCode() {
        int n10 = Arrays.hashCode(this.a);
        return 31 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        double d10 = this.a[0];
        stringBuilder.append(d10);
        String string2 = ", ";
        stringBuilder.append(string2);
        double d11 = this.a[1];
        stringBuilder.append(d11);
        stringBuilder.append(string2);
        d11 = this.a[2];
        stringBuilder.append(d11);
        stringBuilder.append(string2);
        d10 = this.a[3];
        stringBuilder.append(d10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

