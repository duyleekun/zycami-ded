/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import com.zhiyun.zysocket.udp.interactive.UdpInteractiveException;
import d.v.k0.f.c.g;
import d.v.k0.f.c.h;
import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.o;
import d.v.k0.f.d.a;
import d.v.k0.g.d;
import e.a.s0.b;

public class o$b
implements g {
    public final /* synthetic */ o a;

    public o$b(o o10) {
        this.a = o10;
    }

    public void a(a object) {
        Object object2 = o.b(this.a);
        if (object2 != null) {
            object2 = o.b(this.a);
            object2.j((a)object);
        }
        if ((object2 = o.c(this.a)) != null) {
            object2 = o.c(this.a);
            object = ((a)object).d();
            ((h)object2).c((String)object);
        }
    }

    public void j(UdpInteractiveException udpInteractiveException) {
        int n10 = udpInteractiveException.getErrorCode();
        switch (n10) {
            default: {
                break;
            }
            case 402: {
                n10 = 602;
                break;
            }
            case 401: {
                n10 = 601;
                break;
            }
            case 400: {
                n10 = 600;
            }
        }
        k k10 = o.b(this.a);
        d.h("\u63a5\u6536\u6570\u636e\u5f02\u5e38", udpInteractiveException, n10, k10);
    }

    public void onComplete() {
    }

    public void onSubscribe(b b10) {
        o.a(this.a).b(b10);
    }
}

