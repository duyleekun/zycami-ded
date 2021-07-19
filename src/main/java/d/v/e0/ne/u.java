/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.ne.k0;
import e.a.v0.o;
import java.util.UUID;

public final class u
implements o {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ UUID b;

    public /* synthetic */ u(k0 k02, UUID uUID) {
        this.a = k02;
        this.b = uUID;
    }

    public final Object apply(Object object) {
        k0 k02 = this.a;
        UUID uUID = this.b;
        object = (RxBleConnection)object;
        return k02.C(uUID, (RxBleConnection)object);
    }
}

