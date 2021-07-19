/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import e.a.v0.a;

public final class s0$b
implements a {
    public final /* synthetic */ BluetoothGatt a;
    public final /* synthetic */ BluetoothGattCharacteristic b;
    public final /* synthetic */ boolean c;

    public s0$b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean bl2) {
        this.a = bluetoothGatt;
        this.b = bluetoothGattCharacteristic;
        this.c = bl2;
    }

    public void run() {
        Object object = this.a;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.b;
        boolean bl2 = this.c;
        boolean bl3 = object.setCharacteristicNotification(bluetoothGattCharacteristic, bl2);
        if (bl3) {
            return;
        }
        bluetoothGattCharacteristic = this.b;
        object = new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 1, null);
        throw object;
    }
}

