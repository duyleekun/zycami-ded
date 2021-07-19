/*
 * Decompiled with CFR 0.151.
 */
package i.d.u;

import i.d.u.a;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class a$a
extends FilterOutputStream {
    private boolean a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    private boolean f;
    private byte[] g;
    private boolean h;
    private int i;
    private byte[] j;

    public a$a(OutputStream outputStream) {
        this(outputStream, 1);
    }

    public a$a(OutputStream object, int n10) {
        super((OutputStream)object);
        byte[] byArray;
        float f10;
        int n11 = n10 & 8;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n11 != 0) {
            n11 = n12;
            f10 = f11;
        } else {
            n11 = 0;
            object = null;
            f10 = 0.0f;
        }
        this.f = n11;
        n11 = n10 & 1;
        if (n11 == 0) {
            n12 = 0;
            byArray = null;
            f11 = 0.0f;
        }
        this.a = n12;
        n11 = 4;
        f10 = 5.6E-45f;
        if (n12 != 0) {
            n12 = 3;
            f11 = 4.2E-45f;
        } else {
            n12 = n11;
            f11 = f10;
        }
        this.d = n12;
        byArray = new byte[n12];
        this.c = byArray;
        this.b = 0;
        this.e = 0;
        this.h = false;
        object = new byte[n11];
        this.g = (byte[])object;
        this.i = n10;
        object = i.d.u.a.a(n10);
        this.j = (byte[])object;
    }

    public void a() {
        int n10 = this.b;
        if (n10 > 0) {
            boolean bl2 = this.a;
            if (bl2) {
                OutputStream outputStream = this.out;
                byte[] byArray = this.g;
                byte[] byArray2 = this.c;
                int n11 = this.i;
                byte[] byArray3 = i.d.u.a.b(byArray, byArray2, n10, n11);
                outputStream.write(byArray3);
                n10 = 0;
                byArray3 = null;
                this.b = 0;
            } else {
                IOException iOException = new IOException("Base64 input not properly padded.");
                throw iOException;
            }
        }
    }

    public void close() {
        this.a();
        super.close();
        this.c = null;
        this.out = null;
    }

    public void write(int n10) {
        block11: {
            block9: {
                int n11;
                int n12;
                Object object;
                block10: {
                    block8: {
                        int n13;
                        int n14 = this.h;
                        if (n14 != 0) {
                            this.out.write(n10);
                            return;
                        }
                        n14 = this.a;
                        if (n14 == 0) break block8;
                        byte[] byArray = this.c;
                        int n15 = this.b;
                        this.b = n13 = n15 + 1;
                        byArray[n15] = n10 = (int)((byte)n10);
                        n10 = this.d;
                        if (n13 >= n10) {
                            OutputStream outputStream = this.out;
                            byte[] byArray2 = this.g;
                            int n16 = this.i;
                            Object object2 = i.d.u.a.b(byArray2, byArray, n10, n16);
                            outputStream.write((byte[])object2);
                            this.e = n10 = this.e + 4;
                            n14 = this.f;
                            if (n14 != 0 && n10 >= (n14 = 76)) {
                                object2 = this.out;
                                n14 = 10;
                                ((OutputStream)object2).write(n14);
                                this.e = 0;
                            }
                            this.b = 0;
                        }
                        break block9;
                    }
                    object = this.j;
                    n12 = n10 & 0x7F;
                    int n17 = object[n12];
                    n11 = -5;
                    if (n17 <= n11) break block10;
                    object = this.c;
                    n12 = this.b;
                    this.b = n17 = n12 + 1;
                    object[n12] = n10 = (int)((byte)n10);
                    n10 = this.d;
                    if (n17 >= n10) {
                        byte[] byArray = this.g;
                        n12 = this.i;
                        n10 = i.d.u.a.c(object, 0, byArray, 0, n12);
                        object = this.out;
                        byte[] byArray3 = this.g;
                        object.write(byArray3, 0, n10);
                        this.b = 0;
                    }
                    break block9;
                }
                n10 = object[n12];
                if (n10 != n11) break block11;
            }
            return;
        }
        IOException iOException = new IOException("Invalid character in Base64 data.");
        throw iOException;
    }

    public void write(byte[] byArray, int n10, int n11) {
        int n12 = this.h;
        if (n12 != 0) {
            this.out.write(byArray, n10, n11);
            return;
        }
        for (n12 = 0; n12 < n11; ++n12) {
            int n13 = n10 + n12;
            n13 = byArray[n13];
            this.write(n13);
        }
    }
}

