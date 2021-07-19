/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import d.n.a.q0.s.m;
import d.n.a.q0.u.d;
import java.util.concurrent.Callable;

public class d$e
implements Callable {
    public final /* synthetic */ d a;

    public d$e(d d10) {
        this.a = d10;
    }

    public BluetoothGatt a() {
        m m10 = this.a.g;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState = RxBleConnection$RxBleConnectionState.CONNECTED;
        m10.a(rxBleConnection$RxBleConnectionState);
        return this.a.d.a();
    }
}

