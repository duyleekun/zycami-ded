/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.ne.k0;
import e.a.v0.o;

public final class k
implements o {
    public final /* synthetic */ RxBleConnection a;

    public /* synthetic */ k(RxBleConnection rxBleConnection) {
        this.a = rxBleConnection;
    }

    public final Object apply(Object object) {
        RxBleConnection rxBleConnection = this.a;
        object = (Throwable)object;
        return k0.Q(rxBleConnection, (Throwable)object);
    }
}

