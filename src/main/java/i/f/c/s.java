/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import i.f.c.u;
import i.f.c.x;
import i.f.c.z;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class s
extends Mat {
    private static final int b = 5;
    private static final int c = 5;

    public s() {
    }

    public s(long l10) {
        super(l10);
        int n10 = this.G();
        if (n10 == 0) {
            n10 = 5;
            if ((n10 = this.f(n10, n10)) < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
                throw illegalArgumentException;
            }
        }
    }

    public s(Mat object) {
        Range range = Range.a();
        super((Mat)object, range);
        int n10 = this.G();
        if (n10 == 0) {
            n10 = 5;
            if ((n10 = this.f(n10, n10)) < 0) {
                object = new IllegalArgumentException("Incompatible Mat");
                throw object;
            }
        }
    }

    public s(x ... xArray) {
        this.W0(xArray);
    }

    public static s Y0(long l10) {
        s s10 = new s(l10);
        return s10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 5;
            n12 = i.f.c.a.m(n12, n12);
            super.s(n10, n11, n12);
        }
    }

    public void W0(x ... xArray) {
        int n10;
        if (xArray != null && (n10 = xArray.length) != 0) {
            n10 = xArray.length;
            this.V0(n10);
            int n11 = n10 * 5;
            float[] fArray = new float[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                float f11;
                float f12;
                x x10 = xArray[i10];
                int n12 = i10 * 5;
                int n13 = n12 + 0;
                Object object = x10.a;
                fArray[n13] = f12 = (float)((u)object).a;
                n13 = n12 + 1;
                fArray[n13] = f11 = (float)((u)object).b;
                n13 = n12 + 2;
                object = x10.b;
                double d10 = ((z)object).a;
                fArray[n13] = f12 = (float)d10;
                n13 = n12 + 3;
                double d11 = ((z)object).b;
                fArray[n13] = f11 = (float)d11;
                double d12 = x10.c;
                fArray[n12 += 4] = f10 = (float)d12;
            }
            this.l0(0, 0, fArray);
        }
    }

    public void X0(List xArray) {
        x[] xArray2 = new x[]{};
        xArray = xArray.toArray(xArray2);
        this.W0(xArray);
    }

    public x[] Z0() {
        long l10 = this.P0();
        int n10 = (int)l10;
        x[] xArray = new x[n10];
        if (n10 == 0) {
            return xArray;
        }
        int n11 = 5;
        float[] fArray = new float[n11];
        for (int i10 = 0; i10 < n10; ++i10) {
            x x10;
            this.L(i10, 0, fArray);
            float f10 = fArray[0];
            double d10 = f10;
            int n12 = 1;
            float f11 = fArray[n12];
            double d11 = f11;
            u u10 = new u(d10, d11);
            double d12 = fArray[2];
            int n13 = 3;
            float f12 = fArray[n13];
            double d13 = f12;
            z z10 = new z(d12, d13);
            int n14 = 4;
            float f13 = fArray[n14];
            d12 = f13;
            xArray[i10] = x10 = new x(u10, z10, d12);
        }
        return xArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

