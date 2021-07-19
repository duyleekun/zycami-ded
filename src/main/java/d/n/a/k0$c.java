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
import com.polidea.rxandroidble2.exceptions.BleCharacteristicNotFoundException;
import d.n.a.k0;
import e.a.v0.o;
import java.util.UUID;

public class k0$c
implements o {
    public final /* synthetic */ UUID a;
    public final /* synthetic */ k0 b;

    public k0$c(k0 k02, UUID uUID) {
        this.b = k02;
        this.a = uUID;
    }

    public BluetoothGattCharacteristic a(BluetoothGattService object) {
        UUID uUID = this.a;
        if ((object = object.getCharacteristic(uUID)) != null) {
            return object;
        }
        uUID = this.a;
        object = new BleCharacteristicNotFoundException(uUID);
        throw object;
    }
}

