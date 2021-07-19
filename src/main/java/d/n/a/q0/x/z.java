/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 */
package d.n.a.q0.x;

import android.bluetooth.BluetoothAdapter;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.x.y;

public final class z
implements e {
    private final c a;

    public z(c c10) {
        this.a = c10;
    }

    public static z a(c c10) {
        z z10 = new z(c10);
        return z10;
    }

    public y b() {
        BluetoothAdapter bluetoothAdapter = (BluetoothAdapter)this.a.get();
        y y10 = new y(bluetoothAdapter);
        return y10;
    }
}

