/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.NotificationSetupMode;
import d.n.a.q0.s.v0;
import e.a.v0.o;
import e.a.z;

public class v0$e
implements o {
    public final /* synthetic */ NotificationSetupMode a;
    public final /* synthetic */ v0 b;

    public v0$e(v0 v02, NotificationSetupMode notificationSetupMode) {
        this.b = v02;
        this.a = notificationSetupMode;
    }

    public z a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        v0 v02 = this.b;
        NotificationSetupMode notificationSetupMode = this.a;
        return v02.g(bluetoothGattCharacteristic, notificationSetupMode);
    }
}

