/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.ne.k0;
import d.v.e0.ne.q0;
import e.a.v0.o;

public final class t
implements o {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ RxBleConnection b;

    public /* synthetic */ t(k0 k02, RxBleConnection rxBleConnection) {
        this.a = k02;
        this.b = rxBleConnection;
    }

    public final Object apply(Object object) {
        k0 k02 = this.a;
        RxBleConnection rxBleConnection = this.b;
        object = (q0)object;
        return k02.H(rxBleConnection, (q0)object);
    }
}

