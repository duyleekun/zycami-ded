/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.z0;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;

public final class a1
implements e {
    private final c a;
    private final c b;
    private final c c;

    public a1(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static a1 a(c c10, c c11, c c12) {
        a1 a12 = new a1(c10, c11, c12);
        return a12;
    }

    public static z0 c(d d10, BluetoothGatt bluetoothGatt, q q10) {
        z0 z02 = new z0(d10, bluetoothGatt, q10);
        return z02;
    }

    public z0 b() {
        d d10 = (d)this.a.get();
        BluetoothGatt bluetoothGatt = (BluetoothGatt)this.b.get();
        q q10 = (q)this.c.get();
        z0 z02 = new z0(d10, bluetoothGatt, q10);
        return z02;
    }
}

