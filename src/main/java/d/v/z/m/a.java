/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.m;

import com.zhiyun.remoteprotocol.constant.HeadCode;
import d.v.z.k.c;
import d.v.z.k.d;
import d.v.z.m.b;
import d.v.z.o.h;

public class a
implements b {
    private HeadCode a;
    private d b;
    private boolean c;

    public a() {
        HeadCode headCode = HeadCode.SENDER_CODE;
        this(headCode);
    }

    public a(HeadCode headCode) {
        this.a = headCode;
        this.f(headCode);
    }

    public boolean a() {
        return this.c;
    }

    public HeadCode b() {
        return this.a;
    }

    public byte[] c() {
        Object object = this.b;
        if (object == null) {
            int n10 = d.v.z.k.b.a();
            this.b = object = d.b(n10);
        }
        object = this.a.getCodeByte();
        byte[] byArray = this.b.getCodeByte();
        byte[][] byArrayArray = new byte[][]{byArray};
        return h.a((byte[])object, byArrayArray);
    }

    public void clear() {
        HeadCode headCode;
        this.a = headCode = HeadCode.SENDER_CODE;
        this.b = null;
    }

    public d d() {
        return this.b;
    }

    public a e() {
        a a10 = new a();
        c c10 = this.b;
        a10.g((d)c10);
        c10 = this.a;
        a10.f((HeadCode)c10);
        boolean bl2 = this.c;
        a10.h(bl2);
        return a10;
    }

    public void f(HeadCode headCode) {
        this.a = headCode;
    }

    public void g(d d10) {
        this.b = d10;
    }

    public int getLength() {
        return 4;
    }

    public void h(boolean bl2) {
        this.c = bl2;
    }

    public boolean parseFrom(byte[] object) {
        int n10 = 0;
        int n11 = 2;
        Object object2 = h.d((byte[])object, 0, n11);
        object = h.d((byte[])object, n11, n11);
        HeadCode headCode = HeadCode.getValue(object2);
        object = d.c((byte[])object);
        if (headCode == null) {
            return false;
        }
        this.f(headCode);
        this.g((d)object);
        object2 = HeadCode.RECEIVER_CODE;
        int n12 = 1;
        if (headCode == object2) {
            n10 = n12;
        }
        this.h(n10 != 0);
        n10 = this.c;
        if (n10 != 0) {
            return n12 != 0;
        }
        d.v.z.k.b.c(((d)object).getCode() + n12);
        return n12 != 0;
    }
}

