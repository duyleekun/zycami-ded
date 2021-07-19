/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import d.v.y.c.s1.j.v;
import d.v.y.d.a;

public class k
extends v {
    private boolean b;

    public byte[] a() {
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 11;
        byte[] byArray2 = new byte[n10];
        byArray2[0] = 0;
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = byArray2;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.b = false;
    }

    public boolean d() {
        return this.b;
    }

    public boolean parseFrom(byte[] byArray) {
        byte by2 = byArray.length;
        byte by3 = 0;
        byte by4 = 2;
        if (by2 >= by4 && (by2 = byArray[0]) == (by4 = 11)) {
            by2 = 1;
            byte by5 = byArray[by2];
            if (by5 == by2) {
                by3 = by2;
            }
            this.b = by3;
            return by2;
        }
        return false;
    }
}

