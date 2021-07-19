/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import java.util.Arrays;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class k
extends Mat {
    private static final int b = 4;
    private static final int c = 1;

    public k() {
    }

    public k(long l10) {
        super(l10);
        int n10;
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(1, n10 = 4)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public k(Mat object) {
        int n10;
        Range range = Range.a();
        super((Mat)object, range);
        int n11 = this.G();
        if (n11 == 0 && (n11 = this.f(1, n10 = 4)) < 0) {
            object = new IllegalArgumentException("Incompatible Mat");
            throw object;
        }
    }

    public k(int ... nArray) {
        this.W0(nArray);
    }

    public static k Y0(long l10) {
        k k10 = new k(l10);
        return k10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = i.f.c.a.m(4, n11);
            super.s(n10, n11, n12);
        }
    }

    public void W0(int ... nArray) {
        int n10;
        if (nArray != null && (n10 = nArray.length) != 0) {
            n10 = nArray.length / 1;
            this.V0(n10);
            n10 = 0;
            this.m0(0, 0, nArray);
        }
    }

    public void X0(List integerArray) {
        int n10;
        if (integerArray != null && (n10 = integerArray.size()) != 0) {
            int n11;
            Object[] objectArray = new Integer[]{};
            integerArray = integerArray.toArray(objectArray);
            int n12 = integerArray.length;
            objectArray = new int[n12];
            for (n10 = 0; n10 < (n11 = integerArray.length); ++n10) {
                Integer n13 = integerArray[n10];
                n11 = n13;
                objectArray[n10] = n11;
            }
            this.W0((int[])objectArray);
        }
    }

    public int[] Z0() {
        int n10 = 4;
        int n11 = this.f(1, n10);
        if (n11 >= 0) {
            n10 = n11 * 1;
            int[] nArray = new int[n10];
            if (n11 == 0) {
                return nArray;
            }
            this.M(0, 0, nArray);
            return nArray;
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
        int[] nArray = this.Z0();
        int n11 = nArray.length;
        Integer[] integerArray = new Integer[n11];
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            Integer n12;
            n10 = nArray[i10];
            integerArray[i10] = n12 = Integer.valueOf(n10);
        }
        return Arrays.asList(integerArray);
    }
}

