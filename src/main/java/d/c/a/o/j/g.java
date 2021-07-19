/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.j;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class g
extends FilterInputStream {
    private static final int c = 2;
    private static final byte[] d;
    private static final int e;
    private static final int f;
    private final byte a;
    private int b;

    static {
        int n10;
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[29];
        byte[] byArray3 = byArray;
        byArray2[0] = -1;
        byArray3[1] = -31;
        byArray2[2] = 0;
        byArray3[3] = 28;
        byArray2[4] = 69;
        byArray3[5] = 120;
        byArray2[6] = 105;
        byArray3[7] = 102;
        byArray2[8] = 0;
        byArray3[9] = 0;
        byArray2[10] = 77;
        byArray3[11] = 77;
        byArray2[12] = 0;
        byArray3[13] = 0;
        byArray2[14] = 0;
        byArray3[15] = 0;
        byArray2[16] = 0;
        byArray3[17] = 8;
        byArray2[18] = 0;
        byArray3[19] = 1;
        byArray2[20] = 1;
        byArray3[21] = 18;
        byArray2[22] = 0;
        byArray3[23] = 2;
        byArray2[24] = 0;
        byArray3[25] = 0;
        byArray2[26] = 0;
        byArray3[27] = 1;
        byArray3[28] = 0;
        d = byArray;
        e = n10 = byArray.length;
        f = n10 + 2;
    }

    public g(InputStream object, int n10) {
        super((InputStream)object);
        int n11 = -1;
        if (n10 >= n11 && n10 <= (n11 = 8)) {
            n11 = (byte)n10;
            this.a = (byte)n11;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot add invalid orientation: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void mark(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int n10;
        int n11 = this.b;
        int n12 = 2;
        if (n11 >= n12 && n11 <= (n10 = f)) {
            if (n11 == n10) {
                n11 = this.a;
            } else {
                byte[] byArray = d;
                n11 -= n12;
                n11 = byArray[n11] & 0xFF;
            }
        } else {
            n11 = super.read();
        }
        n12 = -1;
        if (n11 != n12) {
            this.b = n12 = this.b + 1;
        }
        return n11;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        int n13 = this.b;
        int n14 = f;
        if (n13 > n14) {
            n12 = super.read(byArray, n10, n11);
        } else if (n13 == n14) {
            byArray[n10] = n11 = (int)this.a;
            n12 = 1;
        } else {
            int n15 = 2;
            if (n13 < n15) {
                n12 = super.read(byArray, n10, n15 -= n13);
            } else {
                n11 = Math.min(n14 - n13, n11);
                byte[] byArray2 = d;
                n14 = this.b - n15;
                System.arraycopy(byArray2, n14, byArray, n10, n11);
                n12 = n11;
            }
        }
        if (n12 > 0) {
            this.b = n10 = this.b + n12;
        }
        return n12;
    }

    public void reset() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public long skip(long l10) {
        long l11;
        long l12 = (l10 = super.skip(l10)) - (l11 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l11 = (long)this.b + l10;
            object = (int)l11;
            this.b = (int)object;
        }
        return l10;
    }
}

