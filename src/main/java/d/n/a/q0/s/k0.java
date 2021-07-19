/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import com.polidea.rxandroidble2.RxBleConnection;
import d.n.a.q0.s.u0;

public class k0
implements u0 {
    private final RxBleConnection a;
    private final int b;

    public k0(RxBleConnection rxBleConnection, int n10) {
        this.a = rxBleConnection;
        this.b = n10;
    }

    public int a() {
        int n10 = this.a.a();
        int n11 = this.b;
        return n10 - n11;
    }
}

