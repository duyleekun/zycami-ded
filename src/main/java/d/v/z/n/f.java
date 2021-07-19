/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.n;

import d.v.z.k.d;
import d.v.z.l.h;
import d.v.z.m.b;
import d.v.z.n.a;
import d.v.z.o.g;
import java.util.Arrays;

public class f
implements a {
    private b a;
    private int b;
    private int c;
    private h d;

    public boolean a() {
        return this.a.a();
    }

    public void b(int n10) {
        this.c = n10;
    }

    public boolean c() {
        d d10 = d.v.z.k.d.a();
        d d11 = this.a.d();
        return d10.equals(d11);
    }

    public void clear() {
        this.a.clear();
        this.d.clear();
    }

    public int d() {
        return this.b;
    }

    public b e() {
        return this.a;
    }

    public void f(h h10) {
        this.d = h10;
    }

    public void g(int n10) {
        this.b = n10;
    }

    public h getData() {
        return this.d;
    }

    public int getLength() {
        return this.d.getLength() + 2 + 1 + 1;
    }

    public int h() {
        return this.c;
    }

    public byte[] i() {
        byte[] byArray = this.getData().c();
        int n10 = this.getLength();
        int n11 = 2;
        int n12 = 1;
        byte[] byArray2 = d.v.z.o.f.q(n10, n11, n12 != 0);
        byte[] byArray3 = d.v.z.o.f.q(this.d(), n12, n12 != 0);
        byte[] byArray4 = d.v.z.o.f.q(this.h(), n12, n12 != 0);
        byte[] byArray5 = this.d.a().getCodeByte();
        byte[][] byArrayArray = new byte[3][];
        byArrayArray[0] = byArray4;
        byArrayArray[n12] = byArray5;
        byArrayArray[n11] = byArray;
        byArray = g.c(d.v.z.o.h.a(byArray3, byArrayArray), n12 != 0);
        byArray3 = this.a.c();
        byte[][] byArrayArray2 = new byte[n11][];
        byArrayArray2[0] = byArray2;
        byArrayArray2[n12] = byArray;
        return d.v.z.o.h.a(byArray3, byArrayArray2);
    }

    public void j(b b10) {
        this.a = b10;
    }

    public boolean parseFrom(byte[] byArray) {
        int n10 = this.a.getLength();
        Object object = this.a;
        byte[] byArray2 = d.v.z.o.h.d(byArray, 0, n10);
        if ((n10 = (int)(object.parseFrom(byArray2) ? 1 : 0)) == 0) {
            return false;
        }
        n10 = this.a.getLength();
        int n11 = 2;
        byArray2 = d.v.z.o.h.d(byArray, n10, n11);
        int n12 = this.a.getLength() + n11;
        int n13 = 1;
        byte[] byArray3 = d.v.z.o.h.d(byArray, n12, n13);
        int n14 = this.a.getLength() + n11 + n13;
        byte[] byArray4 = d.v.z.o.h.d(byArray, n14, n13);
        int n15 = this.a.getLength() + n11 + n13 + n13;
        byte[] byArray5 = d.v.z.o.h.d(byArray, n15, n11);
        int n16 = this.a.getLength() + n11 + n13 + n13 + n11;
        byte by2 = byArray2[0];
        n10 = byArray2[n13];
        n10 = d.v.z.o.f.v(by2, (byte)n10, n13 != 0) - n11 - n13 - n13;
        byArray2 = d.v.z.o.h.d(byArray, n16, n10);
        n16 = byArray.length - n11;
        byArray = d.v.z.o.h.d(byArray, n16, n11);
        n16 = 3;
        byte[][] byArrayArray = new byte[n16][];
        byArrayArray[0] = byArray4;
        byArrayArray[n13] = byArray5;
        byArrayArray[n11] = byArray2;
        byArray5 = d.v.z.o.h.a(byArray3, byArrayArray);
        n15 = g.a(byArray5);
        object = d.v.z.o.f.q(n15, n11, n13 != 0);
        int n17 = Arrays.equals(byArray, (byte[])object);
        if (n17 == 0) {
            return false;
        }
        this.b = n17 = byArray3[0];
        this.c = n17 = byArray4[0];
        return this.d.parseFrom(byArray2);
    }
}

