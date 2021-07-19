/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.m;

import com.zhiyun.remoteprotocol.constant.HeadCode;
import d.v.z.k.c;
import d.v.z.m.a;

public class d
extends a {
    public d() {
        this((d.v.z.k.d)null);
    }

    public d(d.v.z.k.d d10) {
        HeadCode headCode = HeadCode.RECEIVER_CODE;
        super(headCode);
        this.h(true);
        this.g(d10);
    }

    public void clear() {
        super.clear();
        HeadCode headCode = HeadCode.RECEIVER_CODE;
        this.f(headCode);
        this.h(true);
    }

    public d i() {
        d d10 = new d();
        c c10 = this.b();
        d10.f((HeadCode)c10);
        c10 = this.d();
        d10.g((d.v.z.k.d)c10);
        boolean bl2 = this.a();
        d10.h(bl2);
        return d10;
    }
}

