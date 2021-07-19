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

public class m
extends Mat {
    private static final int b = 5;
    private static final int c = 2;

    public m() {
    }

    public m(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(2, n10 = 5)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public m(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(2, n10 = 5)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public m(u ... uArray) {
        this.W0(uArray);
    }

    public static m Y0(long l10) {
        m m10 = new m(l10);
        return m10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 2;
            int n13 = i.f.c.a.m(5, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(u ... uArray) {
        int n10;
        if (uArray != null && (n10 = uArray.length) != 0) {
            n10 = uArray.length;
            this.V0(n10);
            int n11 = n10 * 2;
            float[] fArray = new float[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                float f11;
                u u10 = uArray[i10];
                int n12 = i10 * 2;
                int n13 = n12 + 0;
                double d10 = u10.a;
                fArray[n13] = f11 = (float)d10;
                double d11 = u10.b;
                fArray[++n12] = f10 = (float)d11;
            }
            this.l0(0, 0, fArray);
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
        float[] fArray = new float[n11];
        this.L(0, 0, fArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            u u10;
            int n12 = i10 * 2;
            float f10 = fArray[n12];
            double d10 = f10;
            float f11 = fArray[++n12];
            double d11 = f11;
            uArray[i10] = u10 = new u(d10, d11);
        }
        return uArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

