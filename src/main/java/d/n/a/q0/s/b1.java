/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;
import d.n.a.q0.s.c0;
import d.n.a.q0.s.d0;
import java.util.UUID;

public class b1
extends c0 {
    public b1(d0 d02) {
        super(d02);
    }

    public BleIllegalOperationException a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10) {
        String string2 = this.a.a(bluetoothGattCharacteristic, n10);
        UUID uUID = bluetoothGattCharacteristic.getUuid();
        int n11 = bluetoothGattCharacteristic.getProperties();
        BleIllegalOperationException bleIllegalOperationException = new BleIllegalOperationException(string2, uUID, n11, n10);
        return bleIllegalOperationException;
    }
}

