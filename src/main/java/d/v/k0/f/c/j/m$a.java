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

public class m$a
implements g {
    public final /* synthetic */ m a;

    public m$a(m m10) {
        this.a = m10;
    }

    public void a(a object) {
        int n10;
        f f10 = m.c(this.a);
        if (f10 == null) {
            m.d(this.a).p();
            return;
        }
        int n11 = ((a)object).f();
        if (n11 == (n10 = (f10 = m.c(this.a)).c())) {
            object = m.d(this.a);
            ((l)object).n();
        } else {
            object = m.d(this.a);
            ((l)object).p();
        }
    }

    public void j(UdpInteractiveException udpInteractiveException) {
        Object object = udpInteractiveException.getUdpMessage();
        int n10 = udpInteractiveException.getErrorCode();
        if (object != null) {
            int n11;
            int n12;
            Object object2 = m.c(this.a);
            if (object2 != null && (n12 = ((a)object).f()) == (n11 = ((f)(object2 = m.c(this.a))).c())) {
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
                    case 302: {
                        n10 = 502;
                        break;
                    }
                    case 301: {
                        n10 = 501;
                        break;
                    }
                    case 300: {
                        n10 = 500;
                    }
                }
            }
            object = n12 != 0 ? "\u5fc3\u8df3\u53d1\u6536\u5f02\u5e38" : "\u53d1\u9001\u6570\u636e\u5f02\u5e38";
            object2 = m.d(this.a);
            ((l)object2).l((String)object, udpInteractiveException, n10);
        }
    }

    public void onComplete() {
        m.e(this.a, 0);
    }

    public void onSubscribe(b b10) {
        m.a(this.a).b(b10);
        m.b(this.a, 0);
    }
}

