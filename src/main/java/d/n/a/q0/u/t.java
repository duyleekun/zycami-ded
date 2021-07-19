/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import d.n.a.o0.a;
import d.n.a.q0.q;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.z;
import e.a.i0;

public class t
extends q {
    public t(x0 x02, BluetoothGatt bluetoothGatt, z z10) {
        a a10 = a.k;
        super(bluetoothGatt, x02, a10, z10);
    }

    public i0 d(x0 x02) {
        return x02.j().r2();
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readRemoteRssi();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReadRssiOperation{");
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

