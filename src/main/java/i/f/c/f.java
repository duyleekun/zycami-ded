/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class f
extends Mat {
    private static final int b = 6;
    private static final int c = 1;

    public f() {
    }

    public f(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(1, n10 = 6)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public f(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(1, n10 = 6)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public f(double ... dArray) {
        this.W0(dArray);
    }

    public static f Y0(long l10) {
        f f10 = new f(l10);
        return f10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = i.f.c.a.m(6, n11);
            super.s(n10, n11, n12);
        }
    }

    public void W0(double ... dArray) {
        int n10;
        if (dArray != null && (n10 = dArray.length) != 0) {
            n10 = dArray.length / 1;
            this.V0(n10);
            n10 = 0;
            this.k0(0, 0, dArray);
        }
    }

    public void X0(List doubleArray) {
        int n10;
        if (doubleArray != null && (n10 = doubleArray.size()) != 0) {
            int n11;
            Object[] objectArray = new Double[]{};
            doubleArray = doubleArray.toArray(objectArray);
            int n12 = doubleArray.length;
            objectArray = new double[n12];
            for (n10 = 0; n10 < (n11 = doubleArray.length); ++n10) {
                Double d10 = doubleArray[n10];
                double d11 = d10;
                objectArray[n10] = d11;
            }
            this.W0((double[])objectArray);
        }
    }

    public double[] Z0() {
        int n10 = 6;
        int n11 = this.f(1, n10);
        if (n11 >= 0) {
            n10 = n11 * 1;
            double[] dArray = new double[n10];
            if (n11 == 0) {
                return dArray;
            }
            this.K(0, 0, dArray);
            return dArray;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Native Mat has unexpected type or size: ");
        String string2 = this.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        RuntimeException runtimeException = new RuntimeException((String)charSequence);
        throw runtimeException;
    }

    public List a1() {
        int n10;
        double[] dArray = this.Z0();
        int n11 = dArray.length;
        Double[] doubleArray = new Double[n11];
        for (int i10 = 0; i10 < (n10 = dArray.length); ++i10) {
            Double d10;
            double d11 = dArray[i10];
            doubleArray[i10] = d10 = Double.valueOf(d11);
        }
        return Arrays.asList(doubleArray);
    }
}

