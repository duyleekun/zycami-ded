/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.m;

import com.zhiyun.remoteprotocol.constant.HeadCode;
import d.v.z.k.d;
import d.v.z.m.a;

public class c
extends a {
    public c() {
        d d10 = d.a();
        this.g(d10);
    }

    public void clear() {
        d.v.z.k.c c10 = HeadCode.SENDER_CODE;
        this.f((HeadCode)c10);
        c10 = d.a();
        this.g((d)c10);
    }

    public c i() {
        c c10 = new c();
        d.v.z.k.c c11 = this.d();
        c10.g((d)c11);
        c11 = this.b();
        c10.f((HeadCode)c11);
        boolean bl2 = this.a();
        c10.h(bl2);
        return c10;
    }
}

