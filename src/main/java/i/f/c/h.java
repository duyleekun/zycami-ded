/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class h
extends Mat {
    private static final int b = 5;
    private static final int c = 6;

    public h() {
    }

    public h(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(6, n10 = 5)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public h(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(6, n10 = 5)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public h(float ... fArray) {
        this.W0(fArray);
    }

    public static h Y0(long l10) {
        h h10 = new h(l10);
        return h10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = 6;
            int n13 = i.f.c.a.m(5, n12);
            super.s(n10, n11, n13);
        }
    }

    public void W0(float ... fArray) {
        int n10;
        if (fArray != null && (n10 = fArray.length) != 0) {
            n10 = fArray.length / 6;
            this.V0(n10);
            n10 = 0;
            this.l0(0, 0, fArray);
        }
    }

    public void X0(List floatArray) {
        int n10;
        if (floatArray != null && (n10 = floatArray.size()) != 0) {
            int n11;
            Object[] objectArray = new Float[]{};
            floatArray = floatArray.toArray(objectArray);
            int n12 = floatArray.length;
            objectArray = new float[n12];
            for (n10 = 0; n10 < (n11 = floatArray.length); ++n10) {
                Float f10 = floatArray[n10];
                float f11 = f10.floatValue();
                objectArray[n10] = f11;
            }
            this.W0((float[])objectArray);
        }
    }

    public float[] Z0() {
        int n10 = 5;
        int n11 = this.f(6, n10);
        if (n11 >= 0) {
            n10 = n11 * 6;
            float[] fArray = new float[n10];
            if (n11 == 0) {
                return fArray;
            }
            this.L(0, 0, fArray);
            return fArray;
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
        float[] fArray = this.Z0();
        int n11 = fArray.length;
        Float[] floatArray = new Float[n11];
        for (int i10 = 0; i10 < (n10 = fArray.length); ++i10) {
            Float f10;
            float f11 = fArray[i10];
            floatArray[i10] = f10 = Float.valueOf(f11);
        }
        return Arrays.asList(floatArray);
    }
}

