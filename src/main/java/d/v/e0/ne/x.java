/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.ne.k0;
import e.a.v0.o;

public final class x
implements o {
    public final /* synthetic */ RxBleConnection a;

    public /* synthetic */ x(RxBleConnection rxBleConnection) {
        this.a = rxBleConnection;
    }

    public final Object apply(Object object) {
        RxBleConnection rxBleConnection = this.a;
        object = (Integer)object;
        k0.P(rxBleConnection, (Integer)object);
        return rxBleConnection;
    }
}

