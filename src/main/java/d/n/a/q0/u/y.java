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
import d.n.a.q0.t.c;
import d.n.a.q0.u.y$a;
import d.n.a.q0.u.y$b;
import d.n.a.q0.u.z;
import e.a.h0;
import e.a.i0;
import java.util.concurrent.Callable;

public class y
extends q {
    public final BluetoothGatt e;
    public final c f;

    public y(x0 x02, BluetoothGatt bluetoothGatt, c c10, z z10) {
        a a10 = a.c;
        super(bluetoothGatt, x02, a10, z10);
        this.e = bluetoothGatt;
        this.f = c10;
    }

    public i0 d(x0 object) {
        object = ((x0)object).k().r2();
        y$a y$a = new y$a(this);
        return ((i0)object).b0(y$a);
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.discoverServices();
    }

    public i0 f(BluetoothGatt bluetoothGatt, x0 object, h0 h02) {
        object = new y$b(this, bluetoothGatt, h02);
        return i0.I((Callable)object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ServiceDiscoveryOperation{");
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

