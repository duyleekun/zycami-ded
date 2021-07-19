/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import com.zhiyun.zysocket.udp.interactive.UdpInteractiveException;
import d.v.k0.f.c.g;
import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.o;
import d.v.k0.f.d.a;
import d.v.k0.g.d;
import e.a.s0.b;

public class o$a
implements g {
    public final /* synthetic */ o a;

    public o$a(o o10) {
        this.a = o10;
    }

    public void a(a object) {
        object = o.b(this.a);
        if (object != null) {
            object = o.b(this.a);
            object.e();
        }
    }

    public void j(UdpInteractiveException udpInteractiveException) {
        int n10 = udpInteractiveException.getErrorCode();
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
        k k10 = o.b(this.a);
        d.h("\u53d1\u9001\u6570\u636e\u5f02\u5e38", udpInteractiveException, n10, k10);
    }

    public void onComplete() {
    }

    public void onSubscribe(b b10) {
        o.a(this.a).b(b10);
    }
}

