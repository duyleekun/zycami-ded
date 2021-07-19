/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.e;

import d.c.a.o.k.s;
import d.c.a.u.k;

public class b
implements s {
    private final byte[] a;

    public b(byte[] byArray) {
        byArray = (byte[])k.d(byArray);
        this.a = byArray;
    }

    public byte[] a() {
        return this.a;
    }

    public Class b() {
        return byte[].class;
    }

    public int getSize() {
        return this.a.length;
    }

    public void recycle() {
    }
}

