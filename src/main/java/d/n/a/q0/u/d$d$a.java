/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import d.n.a.q0.u.d$d;
import e.a.v0.r;

public class d$d$a
implements r {
    public final /* synthetic */ d.d a;

    public d$d$a(d.d d10) {
        this.a = d10;
    }

    public boolean a(RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState) {
        boolean bl2;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState2 = RxBleConnection$RxBleConnectionState.CONNECTED;
        if (rxBleConnection$RxBleConnectionState == rxBleConnection$RxBleConnectionState2) {
            bl2 = true;
        } else {
            bl2 = false;
            rxBleConnection$RxBleConnectionState = null;
        }
        return bl2;
    }
}

