/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import i.f.c.t;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class n
extends Mat {
    private static final int b = 4;
    private static final int c = 3;

    public n() {
    }

    public n(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(3, n10 = 4)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public n(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(3, n10 = 4)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public n(t ... tArray) {
        this.W0(tArray);
    }

    public static n Y0(long l10) {
        n n10 = new n(l10);
        return n10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 3;
            int n13 = i.f.c.a.m(4, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(t ... tArray) {
        int n10;
        if (tArray != null && (n10 = tArray.length) != 0) {
            n10 = tArray.length;
            this.V0(n10);
            int n11 = n10 * 3;
            int[] nArray = new int[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                int n12;
                int n13;
                t t10 = tArray[i10];
                int n14 = i10 * 3;
                int n15 = n14 + 0;
                nArray[n15] = n13 = (int)t10.a;
                n15 = n14 + 1;
                double d10 = t10.b;
                nArray[n15] = n13 = (int)d10;
                double d11 = t10.c;
                nArray[n14 += 2] = n12 = (int)d11;
            }
            this.m0(0, 0, nArray);
        }
    }

    public void X0(List tArray) {
        t[] tArray2 = new t[]{};
        tArray = tArray.toArray(tArray2);
        this.W0(tArray);
    }

    public t[] Z0() {
        long l10 = this.P0();
        int n10 = (int)l10;
        t[] tArray = new t[n10];
        if (n10 == 0) {
            return tArray;
        }
        int n11 = n10 * 3;
        int[] nArray = new int[n11];
        this.M(0, 0, nArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            t t10;
            int n12 = i10 * 3;
            int n13 = nArray[n12];
            double d10 = n13;
            int n14 = n12 + 1;
            n14 = nArray[n14];
            double d11 = n14;
            n12 += 2;
            n12 = nArray[n12];
            double d12 = n12;
            tArray[i10] = t10 = new t(d10, d11, d12);
        }
        return tArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

