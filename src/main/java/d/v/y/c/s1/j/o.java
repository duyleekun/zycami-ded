/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import d.v.y.c.s1.a;
import d.v.y.c.s1.j.t;
import d.v.y.d.b;

public class o
extends a {
    private int b;
    private short c;
    private short d;
    private short e;
    private short f;
    private short g;
    private short h;
    private int i;

    public byte[] a() {
        return new byte[0];
    }

    public void clear() {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public t d() {
        int n10 = this.b;
        short s10 = this.c;
        short s11 = this.d;
        short s12 = this.e;
        short s13 = this.f;
        short s14 = this.g;
        short s15 = this.h;
        int n11 = this.i;
        t t10 = new t(n10, s10, s11, s12, s13, s14, s15, n11);
        return t10;
    }

    public boolean parseFrom(byte[] byArray) {
        byte by2 = byArray.length;
        int n10 = 0;
        byte by3 = 20;
        if (by2 >= by3) {
            short s10;
            short s11;
            short s12;
            short s13;
            short s14;
            short s15;
            int n11;
            byte by4 = byArray[0];
            n10 = 1;
            by3 = byArray[n10];
            byte by5 = byArray[2];
            boolean bl2 = byArray[3];
            boolean bl3 = this.b();
            this.b = n11 = d.v.y.d.b.u(by4, by3, by5, (byte)(bl2 ? 1 : 0), bl3);
            byte by6 = byArray[4];
            by3 = byArray[5];
            by5 = (byte)(this.b() ? 1 : 0);
            this.c = s15 = d.v.y.d.b.y(by6, by3, by5 != 0);
            byte by7 = byArray[6];
            by3 = byArray[7];
            by5 = this.b();
            this.d = s14 = d.v.y.d.b.y(by7, by3, by5 != 0);
            byte by8 = byArray[8];
            by3 = byArray[9];
            by5 = this.b();
            this.e = s13 = d.v.y.d.b.y(by8, by3, by5 != 0);
            byte by9 = byArray[10];
            by3 = byArray[11];
            by5 = this.b();
            this.f = s12 = d.v.y.d.b.y(by9, by3, by5 != 0);
            byte by10 = byArray[12];
            by3 = byArray[13];
            by5 = this.b();
            this.g = s11 = d.v.y.d.b.y(by10, by3, by5 != 0);
            byte by11 = byArray[14];
            by3 = byArray[15];
            by5 = this.b();
            this.h = s10 = d.v.y.d.b.y(by11, by3, by5 != 0);
            byte by12 = byArray[16];
            by3 = byArray[17];
            by5 = byArray[18];
            int n12 = byArray[19];
            bl2 = this.b();
            this.i = n12 = d.v.y.d.b.u(by12, by3, by5, (byte)n12, bl2);
        }
        return n10 != 0;
    }
}

