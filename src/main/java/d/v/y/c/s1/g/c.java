/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.g;

import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import d.v.y.c.s1.a;
import d.v.y.d.b;
import java.util.Map;

public class c
extends a {
    private CCSStatus b;
    private short c;
    private Map d;

    public c() {
        Object object;
        this.b = object = CCSStatus.NO_ERROR;
        this.d = object;
    }

    public byte[] a() {
        short s10;
        int n10;
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = n10 = 2;
        byte[] byArray2 = new byte[n11];
        byArray2[0] = s10 = CCSStatus.toValue(this.b);
        s10 = this.c;
        boolean bl2 = this.b();
        byte[] byArray3 = d.v.y.d.b.r(s10, n10, bl2);
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = byArray2;
        byArrayArray[n11] = byArray3;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        CCSStatus cCSStatus;
        this.c = 0;
        this.d.clear();
        this.b = cCSStatus = CCSStatus.NO_ERROR;
    }

    public Map d() {
        return this.d;
    }

    public CCSStatus e() {
        return this.b;
    }

    public void f(short s10) {
        this.c = s10;
    }

    public void g(CCSStatus cCSStatus) {
        this.b = cCSStatus;
    }

    public boolean parseFrom(byte[] object) {
        int n10 = 0;
        byte by2 = object[0];
        byte by3 = 2;
        if (by2 == by3) {
            n10 = 1;
            by2 = object[n10];
            Object object2 = CCSStatus.toStatus(by2);
            this.b = object2;
            this.d.clear();
            object2 = this.d;
            object = d.v.y.c.s1.c.c(object, by3);
            object2.putAll(object);
        }
        return n10 != 0;
    }
}

