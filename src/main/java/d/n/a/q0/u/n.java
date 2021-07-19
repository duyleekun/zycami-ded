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

public class n
extends q {
    private final int e;

    public n(x0 x02, BluetoothGatt bluetoothGatt, z z10, int n10) {
        a a10 = a.l;
        super(bluetoothGatt, x02, a10, z10);
        this.e = n10;
    }

    public i0 d(x0 x02) {
        return x02.i().r2();
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        int n10 = this.e;
        return bluetoothGatt.requestMtu(n10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MtuRequestOperation{");
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append(", mtu=");
        int n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

