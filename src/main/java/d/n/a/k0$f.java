/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattService
 */
package d.n.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import d.n.a.k0;
import e.a.v0.o;
import java.util.UUID;

public class k0$f
implements o {
    public final /* synthetic */ UUID a;
    public final /* synthetic */ k0 b;

    public k0$f(k0 k02, UUID uUID) {
        this.b = k02;
        this.a = uUID;
    }

    public BluetoothGattCharacteristic a(BluetoothGattService bluetoothGattService) {
        UUID uUID = this.a;
        return bluetoothGattService.getCharacteristic(uUID);
    }
}

