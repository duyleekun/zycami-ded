/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.n;

import d.v.y.c.s1.c;
import java.util.HashMap;
import java.util.Map;

public class a
extends d.v.y.c.s1.a {
    private int b;
    private Map c;

    public a() {
        HashMap hashMap;
        this.c = hashMap = new HashMap();
        this.b = 0;
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 7;
        byte[] byArray2 = new byte[n10];
        byArray2[0] = by2 = (byte)this.b;
        byte[] byArray3 = d.v.y.c.s1.c.b(this.c);
        byte[][] byArrayArray = new byte[2][];
        byArrayArray[0] = byArray2;
        byArrayArray[n10] = byArray3;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.b = 0;
        this.c.clear();
    }

    public Map d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public void f(Map map) {
        this.c = map;
    }

    public void g(int n10) {
        this.b = n10;
    }

    public boolean parseFrom(byte[] object) {
        Object n10 = false;
        Object bl2 = object[0];
        boolean bl3 = true;
        int bl4 = 7;
        if ((bl2 = bl2 == bl4 ? (Object)bl3 : (Object)false) != false) {
            n10 = object[bl3];
            this.b = n10;
            this.c = object = d.v.y.c.s1.c.a((byte[])object, 2);
            return bl3;
        }
        return false;
    }
}

