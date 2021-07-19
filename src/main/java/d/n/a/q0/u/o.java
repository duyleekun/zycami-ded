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
import d.n.a.q0.u.n;
import d.n.a.q0.u.z;

public final class o
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public o(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static o a(c c10, c c11, c c12, c c13) {
        o o10 = new o(c10, c11, c12, c13);
        return o10;
    }

    public static n c(x0 x02, BluetoothGatt bluetoothGatt, z z10, int n10) {
        n n11 = new n(x02, bluetoothGatt, z10, n10);
        return n11;
    }

    public n b() {
        x0 x02 = (x0)this.a.get();
        BluetoothGatt bluetoothGatt = (BluetoothGatt)this.b.get();
        z z10 = (z)this.c.get();
        int n10 = (Integer)this.d.get();
        n n11 = new n(x02, bluetoothGatt, z10, n10);
        return n11;
    }
}

