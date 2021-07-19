/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection;
import d.v.e0.pd;
import e.a.v0.o;
import java.util.UUID;

public final class v
implements o {
    public final /* synthetic */ UUID a;

    public /* synthetic */ v(UUID uUID) {
        this.a = uUID;
    }

    public final Object apply(Object object) {
        UUID uUID = this.a;
        object = (RxBleConnection)object;
        return pd.p(uUID, (RxBleConnection)object);
    }
}

