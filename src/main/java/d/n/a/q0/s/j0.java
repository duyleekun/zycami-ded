/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import com.polidea.rxandroidble2.RxBleConnection;
import d.n.a.q0.s.i0;
import d.n.a.q0.s.k0;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;

public final class j0
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public j0(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static j0 a(c c10, c c11, c c12, c c13) {
        j0 j02 = new j0(c10, c11, c12, c13);
        return j02;
    }

    public static i0 c(d d10, Object object, RxBleConnection rxBleConnection, q q10) {
        object = (k0)object;
        i0 i02 = new i0(d10, (k0)object, rxBleConnection, q10);
        return i02;
    }

    public i0 b() {
        d d10 = (d)this.a.get();
        k0 k02 = (k0)this.b.get();
        RxBleConnection rxBleConnection = (RxBleConnection)this.c.get();
        q q10 = (q)this.d.get();
        i0 i02 = new i0(d10, k02, rxBleConnection, q10);
        return i02;
    }
}

