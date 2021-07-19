/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import e.a.a;
import e.a.g;
import e.a.v0.o;

public final class s0$g
implements o {
    public final /* synthetic */ BluetoothGattCharacteristic a;

    public s0$g(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.a = bluetoothGattCharacteristic;
    }

    public g a(Throwable throwable) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.a;
        BleCannotSetCharacteristicNotificationException bleCannotSetCharacteristicNotificationException = new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 3, throwable);
        return e.a.a.V(bleCannotSetCharacteristicNotificationException);
    }
}

