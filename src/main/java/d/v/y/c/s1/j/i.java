/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import com.zhiyun.protocol.core.entities.ErrorStatus;
import d.v.y.c.s1.j.v;
import d.v.y.d.a;
import d.v.y.d.b;

public class i
extends v {
    private int b;
    private int c;
    private boolean d;
    private int e;

    private ErrorStatus g(int n10) {
        boolean bl2;
        ErrorStatus errorStatus = new ErrorStatus(n10);
        errorStatus.axislock = bl2 = d.v.y.d.b.c(n10, 7);
        errorStatus.overheat = bl2 = d.v.y.d.b.c(n10, 6);
        errorStatus.lowpos = bl2 = d.v.y.d.b.c(n10, 5);
        errorStatus.noload = bl2 = d.v.y.d.b.c(n10, 4);
        errorStatus.bit3 = bl2 = d.v.y.d.b.c(n10, 3);
        errorStatus.bit2 = bl2 = d.v.y.d.b.c(n10, 2);
        errorStatus.bit1 = bl2 = d.v.y.d.b.c(n10, 1);
        n10 = (int)(d.v.y.d.b.c(n10, 0) ? 1 : 0);
        errorStatus.bit0 = n10;
        return errorStatus;
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 16;
        byte[] byArray2 = new byte[n10];
        byArray2[0] = by2 = (byte)this.b;
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = byArray2;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.b = 0;
        this.e = 0;
        this.c = 0;
        this.d = false;
    }

    public int d() {
        return this.c;
    }

    public ErrorStatus e() {
        int n10 = this.e;
        return this.g(n10);
    }

    public boolean f() {
        return this.d;
    }

    public void h(int n10) {
        this.b = n10;
    }

    public boolean parseFrom(byte[] byArray) {
        int n10;
        int n11 = byArray.length;
        int n12 = 0;
        int n13 = 1;
        if (n11 > n13 && (n11 = byArray[0]) == (n10 = 16)) {
            n11 = (byArray = a.d(byArray, n13)).length;
            if (n11 >= n13) {
                this.e = n11 = byArray[0];
            }
            if ((n11 = byArray.length) >= (n10 = 2)) {
                int n14;
                n11 = (byArray[n13] & 0xF0) >>> 7;
                if (n11 == n13) {
                    n12 = n13;
                }
                this.d = n12;
                this.c = n14 = (byArray[n13] << n13 & 0xFF) >> n13;
            }
            return n13 != 0;
        }
        return false;
    }
}

