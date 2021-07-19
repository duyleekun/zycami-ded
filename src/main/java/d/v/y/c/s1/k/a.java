/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.k;

import d.v.y.c.s1.k.e;
import d.v.y.d.b;
import d.v.y.d.c;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Objects;

public class a
extends e {
    private int b;
    private int c;
    private int d;
    private int e;
    private byte[] f;

    public a() {
        byte[] byArray = new byte[]{};
        this.f = byArray;
    }

    public byte[] a() {
        int n10;
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = 22;
        int n12 = this.b;
        int n13 = this.b();
        byte[] byArray2 = d.v.y.d.b.s(n12, n13 != 0);
        n13 = this.c;
        boolean bl2 = this.b();
        byte[] byArray3 = d.v.y.d.b.s(n13, bl2);
        byte[] byArray4 = new byte[n11];
        byArray4[0] = n10 = (int)this.d;
        n10 = this.e;
        boolean bl3 = this.b();
        byte[] byArray5 = d.v.y.d.b.s(n10, bl3);
        byte[][] byArrayArray = new byte[5][];
        byArrayArray[0] = byArray2;
        byArrayArray[n11] = byArray3;
        byArrayArray[2] = byArray4;
        byArrayArray[3] = byArray5;
        byte[] byArray6 = this.f;
        byArrayArray[4] = byArray6;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.k(0);
        this.l(0);
        this.j(false);
        this.m(0);
        byte[] byArray = new byte[]{};
        this.i(byArray);
    }

    public byte[] d() {
        return this.f;
    }

    public boolean e() {
        int n10 = this.d;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.e;
    }

    public void i(byte[] byArray) {
        Objects.requireNonNull(byArray);
        this.f = byArray;
    }

    public void j(boolean bl2) {
        this.d = (int)(bl2 ? 1 : 0);
    }

    public void k(int n10) {
        this.b = n10 = Math.max(0, n10);
    }

    public void l(int n10) {
        this.c = n10;
    }

    public void m(int n10) {
        this.e = n10;
    }

    public boolean parseFrom(byte[] object) {
        int n10;
        int n11 = this.b();
        if ((n11 = ((ByteBuffer)(object = (Object)d.v.y.d.c.b((byte[])object, n11 != 0))).get()) != (n10 = 22)) {
            return false;
        }
        this.b = n11 = ((ByteBuffer)object).getInt();
        this.c = n11 = ((ByteBuffer)object).getInt();
        this.d = n11 = (int)((ByteBuffer)object).get();
        this.e = n11 = ((ByteBuffer)object).getInt();
        byte[] byArray = new byte[((Buffer)object).remaining()];
        ((ByteBuffer)object).get(byArray);
        this.f = byArray;
        return true;
    }
}

