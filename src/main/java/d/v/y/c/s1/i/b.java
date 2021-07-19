/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.i;

import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import d.v.y.c.s1.a;

public class b
extends a {
    private final d.v.y.b.a b;
    private d.v.y.b.a c;
    private KeyFunc d;

    public b() {
        Object object;
        this.b = object = new d.v.y.b.a(0);
        this.c = object = new d.v.y.b.a(0);
        object = KeyFunc.DEFAULT;
        this.d = object;
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 17;
        int n11 = this.c.f;
        boolean bl2 = this.b();
        int n12 = 2;
        byte[] byArray2 = d.v.y.d.b.r(n11, n12, bl2);
        byte[] byArray3 = new byte[n10];
        byArray3[0] = by2 = (byte)this.d.value;
        byte[][] byArrayArray = new byte[n12][];
        byArrayArray[0] = byArray2;
        byArrayArray[n10] = byArray3;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        Object object;
        this.c = object = this.b;
        object = KeyFunc.DEFAULT;
        this.d = object;
    }

    public d.v.y.b.a d() {
        return this.c;
    }

    public KeyFunc e() {
        return this.d;
    }

    public void f(d.v.y.b.a a10) {
        this.c = a10;
    }

    public void g(KeyFunc keyFunc) {
        this.d = keyFunc;
    }

    public boolean parseFrom(byte[] object) {
        int n10;
        int bl2 = ((Object)object).length;
        byte s10 = false;
        int bl3 = 4;
        if (bl2 >= bl3 && (bl2 = (int)object[0]) == (n10 = 17 != 0)) {
            d.v.y.b.a a10;
            bl2 = true;
            s10 = object[bl2];
            Object object2 = object[2];
            boolean bl4 = this.b();
            s10 = (byte)d.v.y.d.b.y(s10, (byte)object2, bl4);
            this.c = a10 = new d.v.y.b.a(s10);
            object = KeyFunc.from((int)object[3]);
            this.d = (KeyFunc)((Object)object);
            return bl2;
        }
        return false;
    }
}

