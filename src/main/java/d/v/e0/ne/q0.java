/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import d.v.y.c.r0;

public final class q0 {
    private r0 a;
    private String b;
    private long c;
    private int d;
    private byte[] e;

    public q0(r0 object, String string2, long l10, int n10) {
        this.a = object;
        this.b = string2;
        this.c = l10;
        this.d = n10;
        object = object.a();
        this.e = (byte[])object;
    }

    public String a() {
        return this.b;
    }

    public byte[] b() {
        return this.e;
    }

    public r0 c() {
        return this.a;
    }

    public long d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public void f(String string2) {
        this.b = string2;
    }

    public void g(byte[] byArray) {
        this.e = byArray;
    }

    public void h(r0 r02) {
        this.a = r02;
    }

    public void i(long l10) {
        this.c = l10;
    }

    public void j(int n10) {
        this.d = n10;
    }
}

