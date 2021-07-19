/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import i.f.c.b;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class e
extends Mat {
    private static final int b = 5;
    private static final int c = 4;

    public e() {
    }

    public e(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(4, n10 = 5)) < 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Incompatible Mat: ");
            String string2 = this.toString();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
    }

    public e(Mat object) {
        int n10;
        Object object2 = Range.a();
        super((Mat)object, (Range)object2);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(4, n10 = 5)) < 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Incompatible Mat: ");
            String string2 = this.toString();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
    }

    public e(b ... bArray) {
        this.W0(bArray);
    }

    public static e Y0(long l10) {
        e e10 = new e(l10);
        return e10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 4;
            int n13 = i.f.c.a.m(5, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(b ... bArray) {
        int n10;
        if (bArray != null && (n10 = bArray.length) != 0) {
            n10 = bArray.length;
            this.V0(n10);
            int n11 = n10 * 4;
            float[] fArray = new float[n11];
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10;
                float f11;
                b b10 = bArray[i10];
                int n12 = i10 * 4;
                int n13 = n12 + 0;
                fArray[n13] = f11 = (float)b10.a;
                n13 = n12 + 1;
                fArray[n13] = f11 = (float)b10.b;
                n13 = n12 + 2;
                int n14 = b10.c;
                fArray[n13] = f11 = (float)n14;
                fArray[n12 += 3] = f10 = b10.d;
            }
            this.l0(0, 0, fArray);
        }
    }

    public void X0(List bArray) {
        b[] bArray2 = new b[]{};
        bArray = bArray.toArray(bArray2);
        this.W0(bArray);
    }

    public b[] Z0() {
        long l10 = this.P0();
        int n10 = (int)l10;
        b[] bArray = new b[n10];
        if (n10 == 0) {
            return bArray;
        }
        int n11 = n10 * 4;
        float[] fArray = new float[n11];
        this.L(0, 0, fArray);
        for (int i10 = 0; i10 < n10; ++i10) {
            b b10;
            int n12 = i10 * 4;
            int n13 = n12 + 0;
            float f10 = fArray[n13];
            n13 = (int)f10;
            int n14 = n12 + 1;
            float f11 = fArray[n14];
            n14 = (int)f11;
            int n15 = n12 + 2;
            float f12 = fArray[n15];
            n15 = (int)f12;
            float f13 = fArray[n12 += 3];
            bArray[i10] = b10 = new b(n13, n14, n15, f13);
        }
        return bArray;
    }

    public List a1() {
        return Arrays.asList(this.Z0());
    }
}

