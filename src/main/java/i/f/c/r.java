/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import i.f.c.w;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class r
extends Mat {
    private static final int b = 4;
    private static final int c = 4;

    public r() {
    }

    public r(long l10) {
        super(l10);
        int n10 = this.G();
        if (n10 == 0) {
            n10 = 4;
            if ((n10 = this.f(n10, n10)) < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
                throw illegalArgumentException;
            }
        }
    }

    public r(Mat object) {
        Range range = Range.a();
        super((Mat)object, range);
        int n10 = this.G();
        if (n10 == 0) {
            n10 = 4;
            if ((n10 = this.f(n10, n10)) < 0) {
                object = new IllegalArgumentException("Incompatible Mat");
                throw object;
            }
        }
    }

    public r(w ... wArray) {
        this.W0(wArray);
    }

    public static r Y0(long l10) {
        r r10 = new r(l10);
        return r10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 4;
            n12 = i.f.c.a.m(n12, n12);
            super.s(n10, n11, n12);
        }
    }

    public void W0(w ... wArray) {
        int n10;
        if (wArray != null && (n10 = wArray.length) != 0) {
            n10 = wArray.length;
            this.V0(n10);
            int n11 = n10 * 4;
            int[] nArray = new int[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                int n12;
                int n13;
                w w10 = wArray[i10];
                int n14 = i10 * 4;
                int n15 = n14 + 0;
                nArray[n15] = n13 = w10.a;
                n15 = n14 + 1;
                nArray[n15] = n13 = w10.b;
                n15 = n14 + 2;
                nArray[n15] = n13 = w10.c;
                nArray[n14 += 3] = n12 = w10.d;
            }
            this.m0(0, 0, nArray);
        }
    }

    public void X0(List wArray) {
        w[] wArray2 = new w[]{};
        wArray = wArray.toArray(wArray2);
        this.W0(wArray);
    }

    public w[] Z0() {
        long l10 = this.P0();
        int n10 = (int)l10;
        w[] wArray = new w[n10];
        if (n10 == 0) {
            return wArray;
        }
        int n11 = n10 * 4;
        int[] nArray = new int[n11];
        this.M(0, 0, nArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            w w10;
            int n12 = i10 * 4;
            int n13 = nArray[n12];
            int n14 = n12 + 1;
            n14 = nArray[n14];
            int n15 = n12 + 2;
            n15 = nArray[n15];
            n12 += 3;
            n12 = nArray[n12];
            wArray[i10] = w10 = new w(n13, n14, n15, n12);
        }
        return wArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

