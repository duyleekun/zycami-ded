/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.x;

import android.bluetooth.BluetoothGattDescriptor;
import d.n.a.q0.x.d;
import e.a.v0.r;

public final class e$c
implements r {
    public final /* synthetic */ BluetoothGattDescriptor a;

    public e$c(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.a = bluetoothGattDescriptor;
    }

    public boolean a(d d10) {
        d10 = (BluetoothGattDescriptor)d10.a;
        BluetoothGattDescriptor bluetoothGattDescriptor = this.a;
        return ((Object)d10).equals(bluetoothGattDescriptor);
    }
}

