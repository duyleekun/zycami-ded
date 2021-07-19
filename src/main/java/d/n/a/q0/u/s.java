/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import c.a.l.e;
import d.n.a.q0.s.x0;
import d.n.a.q0.t.c;
import d.n.a.q0.u.r;
import d.n.a.q0.u.z;
import e.a.h0;

public final class s
implements e {
    private final c.b.a.c a;
    private final c.b.a.c b;
    private final c.b.a.c c;
    private final c.b.a.c d;
    private final c.b.a.c e;
    private final c.b.a.c f;
    private final c.b.a.c g;

    public s(c.b.a.c c10, c.b.a.c c11, c.b.a.c c12, c.b.a.c c13, c.b.a.c c14, c.b.a.c c15, c.b.a.c c16) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
        this.e = c14;
        this.f = c15;
        this.g = c16;
    }

    public static s a(c.b.a.c c10, c.b.a.c c11, c.b.a.c c12, c.b.a.c c13, c.b.a.c c14, c.b.a.c c15, c.b.a.c c16) {
        s s10 = new s(c10, c11, c12, c13, c14, c15, c16);
        return s10;
    }

    public static r c(x0 x02, BluetoothGatt bluetoothGatt, c c10, z z10, h0 h02, h0 h03, c.b.a.c c11) {
        r r10 = new r(x02, bluetoothGatt, c10, z10, h02, h03, c11);
        return r10;
    }

    public r b() {
        r r10;
        Object object;
        Object object2 = object = this.a.get();
        object2 = (x0)object;
        Object object3 = object = this.b.get();
        object3 = (BluetoothGatt)object;
        Object object4 = object = this.c.get();
        object4 = (c)object;
        Object object5 = object = this.d.get();
        object5 = (z)object;
        Object object6 = object = this.e.get();
        object6 = (h0)object;
        Object object7 = object = this.f.get();
        object7 = (h0)object;
        c.b.a.c c10 = this.g;
        object = r10;
        r10 = new r((x0)object2, (BluetoothGatt)object3, (c)object4, (z)object5, (h0)object6, (h0)object7, c10);
        return r10;
    }
}

