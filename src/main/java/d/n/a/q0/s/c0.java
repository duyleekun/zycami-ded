/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;
import d.n.a.q0.s.d0;

public abstract class c0 {
    public final d0 a;

    public c0(d0 d02) {
        this.a = d02;
    }

    public abstract BleIllegalOperationException a(BluetoothGattCharacteristic var1, int var2);
}

