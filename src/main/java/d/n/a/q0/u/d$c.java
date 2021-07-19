/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import d.n.a.o0.a;
import d.n.a.q0.u.d;
import java.util.concurrent.Callable;

public class d$c
implements Callable {
    public final /* synthetic */ d a;

    public d$c(d d10) {
        this.a = d10;
    }

    public BluetoothGatt a() {
        BluetoothGatt bluetoothGatt = this.a.d.a();
        a a10 = d.n.a.o0.a.b;
        BleGattCallbackTimeoutException bleGattCallbackTimeoutException = new BleGattCallbackTimeoutException(bluetoothGatt, a10);
        throw bleGattCallbackTimeoutException;
    }
}

