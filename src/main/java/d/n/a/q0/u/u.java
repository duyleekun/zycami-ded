/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.t;
import d.n.a.q0.u.z;

public final class u
implements e {
    private final c a;
    private final c b;
    private final c c;

    public u(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static u a(c c10, c c11, c c12) {
        u u10 = new u(c10, c11, c12);
        return u10;
    }

    public static t c(x0 x02, BluetoothGatt bluetoothGatt, z z10) {
        t t10 = new t(x02, bluetoothGatt, z10);
        return t10;
    }

    public t b() {
        x0 x02 = (x0)this.a.get();
        BluetoothGatt bluetoothGatt = (BluetoothGatt)this.b.get();
        z z10 = (z)this.c.get();
        t t10 = new t(x02, bluetoothGatt, z10);
        return t10;
    }
}

