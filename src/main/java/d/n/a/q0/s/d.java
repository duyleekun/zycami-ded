/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import c.b.a.c;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleConnection$c;
import d.n.a.n0;
import d.n.a.q0.s.a;
import d.n.a.q0.s.c0;
import d.n.a.q0.s.i0;
import d.n.a.q0.s.m0;
import d.n.a.q0.s.n;
import d.n.a.q0.s.u;
import d.n.a.q0.s.v0;
import d.n.a.q0.s.w;
import d.n.a.q0.s.x;
import d.n.a.q0.s.y;
import d.n.a.q0.u.q;
import d.n.a.q0.u.r;
import d.n.a.q0.u.z;
import d.n.a.q0.w.e;
import d.n.a.q0.x.h;
import e.a.h0;
import java.util.concurrent.TimeUnit;

public abstract class d {
    public static final String a = "operation-timeout";

    public static int k() {
        return 3;
    }

    public static int l() {
        return 23;
    }

    public static BluetoothGatt m(a a10) {
        return a10.a();
    }

    public static h n() {
        h h10 = new h(1, 2, 4, 8, 16, 32, 64);
        return h10;
    }

    public static c0 o(boolean bl2, c c10, c c11) {
        if (bl2) {
            return (c0)c10.get();
        }
        return (c0)c11.get();
    }

    public static z p(h0 h02, n0 object) {
        long l10 = object.b;
        object = object.a;
        z z10 = new z(l10, (TimeUnit)((Object)object), h02);
        return z10;
    }

    public abstract d.n.a.q0.w.d a(e var1);

    public abstract n b(e var1);

    public abstract m0 c(d.n.a.q0.s.n0 var1);

    public abstract n d(u var1);

    public abstract x e(w var1);

    public abstract y f(w var1);

    public abstract RxBleConnection$c g(i0 var1);

    public abstract n h(d.n.a.q0.s.n0 var1);

    public abstract q i(r var1);

    public abstract RxBleConnection j(v0 var1);
}

