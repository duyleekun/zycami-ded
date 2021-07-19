/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import d.v.e0.sd;
import e.a.v0.g;

public final class y
implements g {
    public final /* synthetic */ sd a;

    public /* synthetic */ y(sd sd2) {
        this.a = sd2;
    }

    public final void accept(Object object) {
        sd sd2 = this.a;
        object = (RxBleConnection$RxBleConnectionState)((Object)object);
        sd.d(sd2, (RxBleConnection$RxBleConnectionState)((Object)object));
    }
}

