/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import com.zhiyun.zysocket.udp.interactive.UdpInteractiveException;
import d.v.k0.f.c.f;
import d.v.k0.f.c.g;
import d.v.k0.f.c.j.l;
import d.v.k0.f.c.j.m;
import d.v.k0.f.d.a;
import e.a.s0.b;

public class m$b
implements g {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ m b;

    public m$b(m m10, boolean bl2) {
        this.b = m10;
        this.a = bl2;
    }

    public void a(a a10) {
        f f10;
        int n10;
        Object object = m.c(this.b);
        if (object == null) {
            m.d(this.b).o(a10);
            return;
        }
        int n11 = a10.f();
        if (n11 == (n10 = (f10 = m.c(this.b)).b())) {
            object = m.d(this.b);
            ((l)object).m(a10);
        } else {
            object = m.d(this.b);
            ((l)object).o(a10);
        }
    }

    public void j(UdpInteractiveException udpInteractiveException) {
        Object object = udpInteractiveException.getUdpMessage();
        int n10 = udpInteractiveException.getErrorCode();
        if (object != null) {
            int n11;
            int n12;
            Object object2 = m.c(this.b);
            if (object2 != null && (n12 = ((a)object).f()) == (n11 = ((f)(object2 = m.c(this.b))).b())) {
                n12 = 1;
            } else {
                n12 = 0;
                object = null;
            }
            if (n12 != 0) {
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
            }
            object = n12 != 0 ? "\u5fc3\u8df3\u63a5\u6536\u5f02\u5e38" : "\u63a5\u6536\u6570\u636e\u5f02\u5e38";
            object2 = m.d(this.b);
            ((l)object2).l((String)object, udpInteractiveException, n10);
        }
    }

    public void onComplete() {
        boolean bl2 = this.a;
        if (!bl2) {
            m m10 = this.b;
            int n10 = 1;
            m.e(m10, n10);
        }
    }

    public void onSubscribe(b object) {
        e.a.s0.a a10 = m.a(this.b);
        a10.b((b)object);
        boolean bl2 = this.a;
        if (!bl2) {
            object = this.b;
            int n10 = 1;
            m.b((m)object, n10);
        }
    }
}

