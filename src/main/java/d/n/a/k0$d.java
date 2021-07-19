/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.exceptions.BleDescriptorNotFoundException;
import d.n.a.k0;
import e.a.v0.o;
import java.util.UUID;

public class k0$d
implements o {
    public final /* synthetic */ UUID a;
    public final /* synthetic */ k0 b;

    public k0$d(k0 k02, UUID uUID) {
        this.b = k02;
        this.a = uUID;
    }

    public BluetoothGattDescriptor a(BluetoothGattCharacteristic object) {
        UUID uUID = this.a;
        if ((object = object.getDescriptor(uUID)) != null) {
            return object;
        }
        uUID = this.a;
        object = new BleDescriptorNotFoundException(uUID);
        throw object;
    }
}

