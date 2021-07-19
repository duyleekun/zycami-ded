/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import d.n.a.q0.u.k$b;
import e.a.v0.r;

public class k$b$b
implements r {
    public final /* synthetic */ k$b a;

    public k$b$b(k$b k$b) {
        this.a = k$b;
    }

    public boolean a(RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState) {
        boolean bl2;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState2 = RxBleConnection$RxBleConnectionState.DISCONNECTED;
        if (rxBleConnection$RxBleConnectionState == rxBleConnection$RxBleConnectionState2) {
            bl2 = true;
        } else {
            bl2 = false;
            rxBleConnection$RxBleConnectionState = null;
        }
        return bl2;
    }
}

