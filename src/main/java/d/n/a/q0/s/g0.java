/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.internal.BleIllegalOperationException;
import d.n.a.q0.p;
import d.n.a.q0.s.c0;
import d.n.a.q0.s.d0;

public class g0
extends c0 {
    public g0(d0 d02) {
        super(d02);
    }

    public BleIllegalOperationException a(BluetoothGattCharacteristic object, int n10) {
        object = this.a.a((BluetoothGattCharacteristic)object, n10);
        Object[] objectArray = new Object[]{};
        p.u((String)object, objectArray);
        return null;
    }
}

