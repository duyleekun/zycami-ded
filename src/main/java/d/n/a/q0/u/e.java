/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothDevice;
import c.b.a.c;
import d.n.a.q0.s.a;
import d.n.a.q0.s.m;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.d;
import d.n.a.q0.u.z;
import d.n.a.q0.x.b;

public final class e
implements c.a.l.e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;
    private final c e;
    private final c f;
    private final c g;

    public e(c c10, c c11, c c12, c c13, c c14, c c15, c c16) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
        this.e = c14;
        this.f = c15;
        this.g = c16;
    }

    public static e a(c c10, c c11, c c12, c c13, c c14, c c15, c c16) {
        e e10 = new e(c10, c11, c12, c13, c14, c15, c16);
        return e10;
    }

    public static d c(BluetoothDevice bluetoothDevice, b b10, x0 x02, a a10, z z10, boolean bl2, m m10) {
        d d10 = new d(bluetoothDevice, b10, x02, a10, z10, bl2, m10);
        return d10;
    }

    public d b() {
        d d10;
        Object object;
        Object object2 = object = this.a.get();
        object2 = (BluetoothDevice)object;
        Object object3 = object = this.b.get();
        object3 = (b)object;
        Object object4 = object = this.c.get();
        object4 = (x0)object;
        Object object5 = object = this.d.get();
        object5 = (a)object;
        Object object6 = object = this.e.get();
        object6 = (z)object;
        boolean bl2 = (Boolean)this.f.get();
        Object object7 = object = this.g.get();
        object7 = (m)object;
        object = d10;
        d10 = new d((BluetoothDevice)object2, (b)object3, (x0)object4, (a)object5, (z)object6, bl2, (m)object7);
        return d10;
    }
}

