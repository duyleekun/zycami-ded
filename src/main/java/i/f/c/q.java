/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import i.f.c.v;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class q
extends Mat {
    private static final int b = 6;
    private static final int c = 4;

    public q() {
    }

    public q(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(4, n10 = 6)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public q(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(4, n10 = 6)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public q(v ... vArray) {
        this.W0(vArray);
    }

    public static q Y0(long l10) {
        q q10 = new q(l10);
        return q10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 4;
            int n13 = i.f.c.a.m(6, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(v ... vArray) {
        int n10;
        if (vArray != null && (n10 = vArray.length) != 0) {
            n10 = vArray.length;
            this.V0(n10);
            int n11 = n10 * 4;
            double[] dArray = new double[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10;
                double d11;
                v v10 = vArray[i10];
                int n12 = i10 * 4;
                int n13 = n12 + 0;
                dArray[n13] = d11 = v10.a;
                n13 = n12 + 1;
                dArray[n13] = d11 = v10.b;
                n13 = n12 + 2;
                dArray[n13] = d11 = v10.c;
                dArray[n12 += 3] = d10 = v10.d;
            }
            this.k0(0, 0, dArray);
        }
    }

    public void X0(List vArray) {
        v[] vArray2 = new v[]{};
        vArray = vArray.toArray(vArray2);
        this.W0(vArray);
    }

    public v[] Z0() {
        long l10 = this.P0();
        int n10 = (int)l10;
        v[] vArray = new v[n10];
        if (n10 == 0) {
            return vArray;
        }
        int n11 = n10 * 4;
        double[] dArray = new double[n11];
        this.K(0, 0, dArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            v v10;
            int n12 = i10 * 4;
            double d10 = dArray[n12];
            int n13 = n12 + 1;
            double d11 = dArray[n13];
            int n14 = n12 + 2;
            double d12 = dArray[n14];
            double d13 = dArray[n12 += 3];
            vArray[i10] = v10 = new v(d10, d11, d12, d13);
        }
        return vArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

