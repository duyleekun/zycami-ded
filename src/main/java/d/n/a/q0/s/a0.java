/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import d.n.a.q0.s.a0$a;
import d.n.a.q0.s.c0;
import e.a.a;

public class a0 {
    public final c0 a;

    public a0(c0 c02) {
        this.a = c02;
    }

    public a a(BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10) {
        a0$a a0$a = new a0$a(this, bluetoothGattCharacteristic, n10);
        return e.a.a.X(a0$a);
    }
}

