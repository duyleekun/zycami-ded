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
import d.n.a.q0.u.f;
import d.n.a.q0.u.z;

public final class g
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public g(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static g a(c c10, c c11, c c12, c c13) {
        g g10 = new g(c10, c11, c12, c13);
        return g10;
    }

    public static f c(x0 x02, BluetoothGatt bluetoothGatt, z z10, int n10, z z11) {
        f f10 = new f(x02, bluetoothGatt, z10, n10, z11);
        return f10;
    }

    public f b() {
        f f10;
        Object object;
        Object object2 = object = this.a.get();
        object2 = (x0)object;
        Object object3 = object = this.b.get();
        object3 = (BluetoothGatt)object;
        Object object4 = object = this.c.get();
        object4 = (z)object;
        int n10 = (Integer)this.d.get();
        Object object5 = object = this.c.get();
        object5 = (z)object;
        object = f10;
        f10 = new f((x0)object2, (BluetoothGatt)object3, (z)object4, n10, (z)object5);
        return f10;
    }
}

