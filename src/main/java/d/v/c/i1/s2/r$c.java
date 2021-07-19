/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import com.zhiyun.cama.main.me.WebViewFragment;
import com.zhiyun.device.connection.BleConnection;
import d.v.c.i1.s2.r;
import d.v.c.i1.s2.r$a;
import d.v.e0.ce;
import d.v.g0.s;

public class r$c {
    public final /* synthetic */ r a;

    private r$c(r r10) {
        this.a = r10;
    }

    public /* synthetic */ r$c(r r10, r.a a10) {
        this(r10);
    }

    public void a() {
        r.m(this.a).R();
    }

    public void b() {
        this.a.requireActivity().onBackPressed();
    }

    public void c() {
        Object object = BleConnection.W();
        boolean bl2 = ((BleConnection)object).c0();
        if (bl2) {
            s.o(this.a.requireActivity());
            object = BleConnection.W();
            ((BleConnection)object).M();
        } else {
            ce.E0().U();
            object = this.a;
            r.k((r)object);
        }
    }

    public void d() {
        r.k(this.a);
    }

    public void e() {
        WebViewFragment webViewFragment = r.l(this.a);
        if (webViewFragment != null) {
            webViewFragment = r.l(this.a);
            webViewFragment.T();
        }
    }

    public void f() {
        r.r(this.a);
    }
}

