/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.j;

import com.zhiyun.protocol.message.bl.other.OtherStatus;
import d.v.y.c.s1.j.v;
import d.v.y.d.a;

public class u
extends v {
    private String b = "";
    private OtherStatus c;

    public u() {
        OtherStatus otherStatus;
        this.c = otherStatus = OtherStatus.NONE_ERROR;
    }

    public byte[] a() {
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = n10;
        byte[] byArray2 = this.b.getBytes();
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = byArray2;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        OtherStatus otherStatus;
        this.c = otherStatus = OtherStatus.NONE_ERROR;
        this.b = "";
    }

    public String d() {
        return this.b;
    }

    public OtherStatus e() {
        return this.c;
    }

    public void f(String string2) {
        this.b = string2;
    }

    public boolean parseFrom(byte[] object) {
        boolean bl2 = object[0];
        boolean bl3 = true;
        if (bl2 == bl3) {
            object = (Object)OtherStatus.from(object[bl3]);
            this.c = (OtherStatus)((Object)object);
            return bl3;
        }
        return false;
    }
}

