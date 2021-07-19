/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.g;

import com.zhiyun.protocol.message.bl.ccs.CCSStatus;
import d.v.y.c.s1.a;
import d.v.y.c.s1.c;
import d.v.y.d.b;
import d.v.y.d.g;
import java.nio.charset.Charset;
import java.util.Map;

public class e
extends a {
    private CCSStatus b;
    private Map c;
    private short d;
    private String e;

    public e() {
        Object object;
        this.b = object = CCSStatus.NO_ERROR;
        this.c = object;
    }

    public byte[] a() {
        short s10;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = n10;
        byte[] byArray2 = new byte[n10];
        byArray2[0] = s10 = CCSStatus.toValue(CCSStatus.NO_ERROR);
        s10 = this.d;
        Object object = this.e;
        Object object2 = d.v.y.c.s1.c.d(s10, (String)object);
        short s11 = (Short)((g)object2).a;
        boolean bl2 = this.b();
        int n11 = 2;
        object = d.v.y.d.b.r(s11, n11, bl2);
        object2 = (String)((g)object2).b;
        Object object3 = Charset.forName("utf-8");
        object2 = ((String)object2).getBytes((Charset)object3);
        object3 = new byte[n10];
        object3[0] = false;
        byte[][] byArrayArray = new byte[4][];
        byArrayArray[0] = byArray2;
        byArrayArray[n10] = (byte[])object;
        byArrayArray[n11] = (byte[])object2;
        byArrayArray[3] = (byte[])object3;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        CCSStatus cCSStatus;
        this.c.clear();
        this.b = cCSStatus = CCSStatus.NO_ERROR;
    }

    public Map d() {
        return this.c;
    }

    public CCSStatus e() {
        return this.b;
    }

    public void f(short s10, String string2) {
        this.d = s10;
        this.e = string2;
    }

    public void g(CCSStatus cCSStatus) {
        this.b = cCSStatus;
    }

    public boolean parseFrom(byte[] object) {
        Object object2 = null;
        boolean bl2 = object[0];
        boolean bl3 = true;
        if (bl2 == bl3) {
            object2 = CCSStatus.toStatus(object[bl3]);
            this.b = object2;
            this.c.clear();
            object2 = this.c;
            object = d.v.y.c.s1.c.c(object, 2);
            object2.putAll(object);
            return bl3;
        }
        return false;
    }
}

