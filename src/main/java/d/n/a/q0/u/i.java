/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.h;
import d.n.a.q0.u.z;

public final class i
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public i(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static i a(c c10, c c11, c c12, c c13) {
        i i10 = new i(c10, c11, c12, c13);
        return i10;
    }

    public static h c(x0 x02, BluetoothGatt bluetoothGatt, z z10, BluetoothGattDescriptor bluetoothGattDescriptor) {
        h h10 = new h(x02, bluetoothGatt, z10, bluetoothGattDescriptor);
        return h10;
    }

    public h b() {
        x0 x02 = (x0)this.a.get();
        BluetoothGatt bluetoothGatt = (BluetoothGatt)this.b.get();
        z z10 = (z)this.c.get();
        BluetoothGattDescriptor bluetoothGattDescriptor = (BluetoothGattDescriptor)this.d.get();
        h h10 = new h(x02, bluetoothGatt, z10, bluetoothGattDescriptor);
        return h10;
    }
}

