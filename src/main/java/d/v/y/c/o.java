/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import d.v.y.b.a;
import d.v.y.c.p;
import d.v.y.c.s1.i.b;
import d.v.y.c.s1.i.c;

public class o
extends p {
    public o() {
        c c10 = new c();
        b b10 = new b();
        super(c10, b10);
    }

    public a n() {
        return ((b)this.f()).d();
    }

    public KeyFunc o() {
        return ((b)this.f()).e();
    }

    public void p(a a10) {
        ((b)this.f()).f(a10);
    }

    public void q(KeyFunc keyFunc) {
        ((b)this.f()).g(keyFunc);
    }
}

