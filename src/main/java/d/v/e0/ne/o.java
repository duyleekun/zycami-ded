/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.ne.k0;

public final class o
implements e.a.v0.o {
    public final /* synthetic */ RxBleConnection a;

    public /* synthetic */ o(RxBleConnection rxBleConnection) {
        this.a = rxBleConnection;
    }

    public final Object apply(Object object) {
        RxBleConnection rxBleConnection = this.a;
        object = (Boolean)object;
        k0.A(rxBleConnection, (Boolean)object);
        return rxBleConnection;
    }
}

