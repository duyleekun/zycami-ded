/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import i.f.c.c;
import i.f.c.u;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class l
extends Mat {
    private static final int b = 5;
    private static final int c = 7;

    public l() {
    }

    public l(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(7, n10 = 5)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public l(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(7, n10 = 5)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public l(c ... cArray) {
        this.W0(cArray);
    }

    public static l Y0(long l10) {
        l l11 = new l(l10);
        return l11;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 7;
            int n13 = i.f.c.a.m(5, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(c ... cArray) {
        int n10;
        if (cArray != null && (n10 = cArray.length) != 0) {
            n10 = cArray.length;
            this.V0(n10);
            int n11 = n10 * 7;
            float[] fArray = new float[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                float f11;
                float f12;
                c c10 = cArray[i10];
                int n12 = i10 * 7;
                int n13 = n12 + 0;
                u u10 = c10.a;
                double d10 = u10.a;
                fArray[n13] = f12 = (float)d10;
                n13 = n12 + 1;
                double d11 = u10.b;
                fArray[n13] = f11 = (float)d11;
                n13 = n12 + 2;
                fArray[n13] = f11 = c10.b;
                n13 = n12 + 3;
                fArray[n13] = f11 = c10.c;
                n13 = n12 + 4;
                fArray[n13] = f11 = c10.d;
                n13 = n12 + 5;
                int n14 = c10.e;
                fArray[n13] = f11 = (float)n14;
                int n15 = c10.f;
                fArray[n12 += 6] = f10 = (float)n15;
            }
            this.l0(0, 0, fArray);
        }
    }

    public void X0(List cArray) {
        c[] cArray2 = new c[]{};
        cArray = cArray.toArray(cArray2);
        this.W0(cArray);
    }

    public c[] Z0() {
        long l10 = this.P0();
        int n10 = (int)l10;
        c[] cArray = new c[n10];
        if (n10 == 0) {
            return cArray;
        }
        int n11 = n10 * 7;
        float[] fArray = new float[n11];
        this.L(0, 0, fArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            c c10;
            int n12 = i10 * 7;
            int n13 = n12 + 0;
            float f10 = fArray[n13];
            int n14 = n12 + 1;
            float f11 = fArray[n14];
            int n15 = n12 + 2;
            float f12 = fArray[n15];
            int n16 = n12 + 3;
            float f13 = fArray[n16];
            int n17 = n12 + 4;
            float f14 = fArray[n17];
            int n18 = n12 + 5;
            float f15 = fArray[n18];
            n18 = (int)f15;
            float f16 = fArray[n12 += 6];
            int n19 = (int)f16;
            cArray[i10] = c10 = new c(f10, f11, f12, f13, f14, n18, n19);
        }
        return cArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

