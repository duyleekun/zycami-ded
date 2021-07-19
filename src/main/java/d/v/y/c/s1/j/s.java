/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import d.v.y.c.s1.j.v;
import d.v.y.d.a;

public class s
extends v {
    private static final byte c = 0;
    private static final byte d = 1;
    private boolean b;

    public byte[] a() {
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 2;
        byte[] byArray2 = new byte[n10];
        boolean bl2 = this.b;
        byArray2[0] = (byte)(bl2 ? 1 : 0);
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

    public void e(boolean bl2) {
        this.b = bl2;
    }

    public boolean parseFrom(byte[] byArray) {
        byte by2 = byArray.length;
        byte by3 = 2;
        byte by4 = 0;
        if (by2 >= by3 && (by2 = byArray[0]) == by3) {
            by2 = 1;
            byte by5 = byArray[by2];
            if (by5 == by2) {
                by4 = by2;
            }
            this.b = by4;
            return by2;
        }
        return false;
    }
}

