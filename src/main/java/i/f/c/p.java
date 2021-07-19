/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import i.f.c.u;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class p
extends Mat {
    private static final int b = 4;
    private static final int c = 2;

    public p() {
    }

    public p(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(2, n10 = 4)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public p(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(2, n10 = 4)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public p(u ... uArray) {
        this.W0(uArray);
    }

    public static p Y0(long l10) {
        p p10 = new p(l10);
        return p10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 2;
            int n13 = i.f.c.a.m(4, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(u ... uArray) {
        int n10;
        if (uArray != null && (n10 = uArray.length) != 0) {
            n10 = uArray.length;
            this.V0(n10);
            int n11 = n10 * 2;
            int[] nArray = new int[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                int n12;
                int n13;
                u u10 = uArray[i10];
                int n14 = i10 * 2;
                int n15 = n14 + 0;
                double d10 = u10.a;
                nArray[n15] = n13 = (int)d10;
                double d11 = u10.b;
                nArray[++n14] = n12 = (int)d11;
            }
            this.m0(0, 0, nArray);
        }
    }

    public void X0(List uArray) {
        u[] uArray2 = new u[]{};
        uArray = uArray.toArray(uArray2);
        this.W0(uArray);
    }

    public u[] Z0() {
        long l10 = this.P0();
        int n10 = (int)l10;
        u[] uArray = new u[n10];
        if (n10 == 0) {
            return uArray;
        }
        int n11 = n10 * 2;
        int[] nArray = new int[n11];
        this.M(0, 0, nArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            u u10;
            int n12 = i10 * 2;
            int n13 = nArray[n12];
            double d10 = n13;
            ++n12;
            n12 = nArray[n12];
            double d11 = n12;
            uArray[i10] = u10 = new u(d10, d11);
        }
        return uArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

