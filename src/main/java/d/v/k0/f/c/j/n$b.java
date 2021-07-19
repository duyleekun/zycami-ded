/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import com.zhiyun.zysocket.udp.interactive.UdpInteractiveException;
import d.v.k0.f.c.g;
import d.v.k0.f.c.j.n;
import d.v.k0.f.d.a;
import e.a.s0.b;

public class n$b
implements g {
    public final /* synthetic */ n a;

    public n$b(n n10) {
        this.a = n10;
    }

    public void a(a a10) {
        n.a(this.a).p();
    }

    public void j(UdpInteractiveException udpInteractiveException) {
        int n10 = udpInteractiveException.getErrorCode();
        n.a(this.a).l("\u53d1\u9001\u6570\u636e\u5f02\u5e38", udpInteractiveException, n10);
    }

    public void onComplete() {
        n.d(this.a, 0);
    }

    public void onSubscribe(b b10) {
        n.b(this.a).b(b10);
        n.c(this.a, 0);
    }
}

