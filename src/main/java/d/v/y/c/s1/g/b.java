/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.g;

import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import d.v.y.c.s1.a;
import d.v.y.c.s1.c;
import java.util.Map;

public class b
extends a {
    private CCSStatus b;
    private short c;
    private Map d;

    public b() {
        Object object;
        this.b = object = CCSStatus.NO_ERROR;
        this.d = object;
    }

    public byte[] a() {
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 3;
        short s10 = this.c;
        boolean bl2 = this.b();
        byte[] byArray2 = d.v.y.d.b.r(s10, 2, bl2);
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = byArray2;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.b = null;
        this.c = 0;
        this.d = null;
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
        int n11 = object[0];
        int n12 = 3;
        if (n11 == n12) {
            n10 = 1;
            n11 = object[n10];
            Object object2 = CCSStatus.toStatus((byte)n11);
            this.b = object2;
            this.d.clear();
            object2 = this.d;
            n12 = 2;
            object = d.v.y.c.s1.c.c(object, n12);
            object2.putAll(object);
        }
        return n10 != 0;
    }
}

