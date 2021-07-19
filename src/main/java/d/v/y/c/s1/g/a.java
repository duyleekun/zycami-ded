/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.g;

import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import d.v.y.c.w0;

public class a
extends d.v.y.c.s1.a {
    private CCSStatus b;
    private int c;
    private w0 d;

    public byte[] a() {
        return new byte[0];
    }

    public void clear() {
        this.b = null;
        this.c = 0;
        this.d.clear();
    }

    public int d() {
        return this.c;
    }

    public w0 e() {
        return this.d;
    }

    public CCSStatus f() {
        return this.b;
    }

    public void g(int n10) {
        this.c = n10;
    }

    public void h(w0 w02) {
        this.d = w02;
    }

    public void i(CCSStatus cCSStatus) {
        this.b = cCSStatus;
    }

    public boolean parseFrom(byte[] byArray) {
        int n10 = 0;
        Object object = null;
        int n11 = byArray[0];
        int n12 = 4;
        if (n11 == n12) {
            object = CCSStatus.toStatus(byArray[1]);
            this.b = object;
            this.c = n10 = byArray[2];
            object = new w0();
            this.d = object;
            n11 = byArray.length;
            n12 = 3;
            byArray = d.v.y.d.a.e(byArray, n12, n11 -= n12);
            return ((d.v.y.c.a)object).parseFrom(byArray);
        }
        return false;
    }
}

