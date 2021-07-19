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

public class o
extends Mat {
    private static final int b = 5;
    private static final int c = 3;

    public o() {
    }

    public o(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(3, n10 = 5)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public o(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(3, n10 = 5)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public o(t ... tArray) {
        this.W0(tArray);
    }

    public static o Y0(long l10) {
        o o10 = new o(l10);
        return o10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 3;
            int n13 = i.f.c.a.m(5, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(t ... tArray) {
        int n10;
        if (tArray != null && (n10 = tArray.length) != 0) {
            n10 = tArray.length;
            this.V0(n10);
            int n11 = n10 * 3;
            float[] fArray = new float[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                float f11;
                t t10 = tArray[i10];
                int n12 = i10 * 3;
                int n13 = n12 + 0;
                fArray[n13] = f11 = (float)t10.a;
                n13 = n12 + 1;
                double d10 = t10.b;
                fArray[n13] = f11 = (float)d10;
                double d11 = t10.c;
                fArray[n12 += 2] = f10 = (float)d11;
            }
            this.l0(0, 0, fArray);
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
        float[] fArray = new float[n11];
        this.L(0, 0, fArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            t t10;
            int n12 = i10 * 3;
            float f10 = fArray[n12];
            double d10 = f10;
            int n13 = n12 + 1;
            float f11 = fArray[n13];
            double d11 = f11;
            float f12 = fArray[n12 += 2];
            double d12 = f12;
            tArray[i10] = t10 = new t(d10, d11, d12);
        }
        return tArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

