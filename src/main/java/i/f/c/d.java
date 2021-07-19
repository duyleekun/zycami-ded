/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.a;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.opencv.core.Mat;
import org.opencv.core.Range;

public class d
extends Mat {
    private static final int b = 0;
    private static final int c = 1;

    public d() {
    }

    public d(int n10, int n11, byte ... byArray) {
        this.W0(n10, n11, byArray);
    }

    public d(long l10) {
        super(l10);
        int n10 = this.G();
        if (n10 == 0 && (n10 = this.f(1, 0)) < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Incompatible Mat");
            throw illegalArgumentException;
        }
    }

    public d(Mat object) {
        Range range = Range.a();
        super((Mat)object, range);
        int n10 = this.G();
        if (n10 == 0) {
            range = null;
            n10 = this.f(1, 0);
            if (n10 < 0) {
                object = new IllegalArgumentException("Incompatible Mat");
                throw object;
            }
        }
    }

    public d(byte ... byArray) {
        this.X0(byArray);
    }

    public static d Z0(long l10) {
        d d10 = new d(l10);
        return d10;
    }

    public void V0(int n10) {
        if (n10 > 0) {
            int n11 = 1;
            int n12 = i.f.c.a.m(0, n11);
            super.s(n10, n11, n12);
        }
    }

    public void W0(int n10, int n11, byte ... object) {
        if (n10 >= 0) {
            int n12;
            int n13;
            Objects.requireNonNull(object);
            if (n11 >= 0 && (n13 = n11 + n10) <= (n12 = ((byte[])object).length)) {
                n13 = ((Object)object).length;
                if (n13 == 0) {
                    return;
                }
                n13 = n11 / 1;
                this.V0(n13);
                this.j0(0, 0, (byte[])object, n10, n11);
                return;
            }
            object = new StringBuilder;
            ((StringBuilder)object)();
            ((StringBuilder)object).append("invalid 'length' parameter: ");
            String string2 = Integer.toString(n11);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("offset < 0");
        throw illegalArgumentException;
    }

    public void X0(byte ... byArray) {
        int n10;
        if (byArray != null && (n10 = byArray.length) != 0) {
            n10 = byArray.length / 1;
            this.V0(n10);
            n10 = 0;
            this.i0(0, 0, byArray);
        }
    }

    public void Y0(List byteArray) {
        int n10;
        if (byteArray != null && (n10 = byteArray.size()) != 0) {
            int n11;
            Object[] objectArray = new Byte[]{};
            byteArray = byteArray.toArray(objectArray);
            int n12 = byteArray.length;
            objectArray = new byte[n12];
            for (n10 = 0; n10 < (n11 = byteArray.length); ++n10) {
                Byte by2 = byteArray[n10];
                n11 = by2.byteValue();
                objectArray[n10] = (Byte)n11;
            }
            this.X0((byte[])objectArray);
        }
    }

    public byte[] a1() {
        CharSequence charSequence = null;
        int n10 = this.f(1, 0);
        if (n10 >= 0) {
            int n11 = n10 * 1;
            byte[] byArray = new byte[n11];
            if (n10 == 0) {
                return byArray;
            }
            this.J(0, 0, byArray);
            return byArray;
        }
        charSequence = new StringBuilder();
        charSequence.append("Native Mat has unexpected type or size: ");
        String string2 = this.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        RuntimeException runtimeException = new RuntimeException((String)charSequence);
        throw runtimeException;
    }

    public List b1() {
        int n10;
        byte[] byArray = this.a1();
        int n11 = byArray.length;
        Byte[] byteArray = new Byte[n11];
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            Byte by2;
            n10 = byArray[i10];
            byteArray[i10] = by2 = Byte.valueOf((byte)n10);
        }
        return Arrays.asList(byteArray);
    }
}

