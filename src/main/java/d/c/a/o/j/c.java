/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.j;

import d.c.a.o.k.x.b;
import java.io.OutputStream;

public final class c
extends OutputStream {
    private final OutputStream a;
    private byte[] b;
    private b c;
    private int d;

    public c(OutputStream outputStream, b b10) {
        this(outputStream, b10, 65536);
    }

    public c(OutputStream object, b b10, int n10) {
        this.a = object;
        this.c = b10;
        object = (byte[])b10.c(n10, byte[].class);
        this.b = (byte[])object;
    }

    private void a() {
        int n10 = this.d;
        if (n10 > 0) {
            OutputStream outputStream = this.a;
            byte[] byArray = this.b;
            outputStream.write(byArray, 0, n10);
            this.d = 0;
        }
    }

    private void h() {
        int n10 = this.d;
        byte[] byArray = this.b;
        int n11 = byArray.length;
        if (n10 == n11) {
            this.a();
        }
    }

    private void q() {
        byte[] byArray = this.b;
        if (byArray != null) {
            b b10 = this.c;
            b10.put(byArray);
            byArray = null;
            this.b = null;
        }
    }

    public void close() {
        try {
            this.flush();
            this.q();
            return;
        }
        finally {
            this.a.close();
        }
    }

    public void flush() {
        this.a();
        this.a.flush();
    }

    public void write(int n10) {
        int n11;
        byte[] byArray = this.b;
        int n12 = this.d;
        this.d = n11 = n12 + 1;
        byArray[n12] = n10 = (int)((byte)n10);
        this.h();
    }

    public void write(byte[] byArray) {
        int n10 = byArray.length;
        this.write(byArray, 0, n10);
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12;
        int n13 = 0;
        do {
            byte[] byArray2;
            int n14;
            n12 = n11 - n13;
            int n15 = n10 + n13;
            int n16 = this.d;
            if (n16 == 0 && n12 >= (n14 = (byArray2 = this.b).length)) {
                this.a.write(byArray, n15, n12);
                return;
            }
            byArray2 = this.b;
            n14 = byArray2.length - n16;
            n12 = Math.min(n12, n14);
            byte[] byArray3 = this.b;
            n14 = this.d;
            System.arraycopy(byArray, n15, byArray3, n14, n12);
            this.d = n15 = this.d + n12;
            this.h();
        } while ((n13 += n12) < n11);
    }
}

