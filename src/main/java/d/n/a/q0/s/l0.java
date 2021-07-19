/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import com.polidea.rxandroidble2.RxBleConnection;
import d.n.a.q0.s.k0;

public final class l0
implements e {
    private final c a;
    private final c b;

    public l0(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static l0 a(c c10, c c11) {
        l0 l02 = new l0(c10, c11);
        return l02;
    }

    public static k0 c(RxBleConnection rxBleConnection, int n10) {
        k0 k02 = new k0(rxBleConnection, n10);
        return k02;
    }

    public k0 b() {
        RxBleConnection rxBleConnection = (RxBleConnection)this.a.get();
        int n10 = (Integer)this.b.get();
        k0 k02 = new k0(rxBleConnection, n10);
        return k02;
    }
}

