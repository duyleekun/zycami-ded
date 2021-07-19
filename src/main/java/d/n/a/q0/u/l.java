/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothManager
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothManager;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.a;
import d.n.a.q0.s.m;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.k;
import d.n.a.q0.u.z;
import e.a.h0;

public final class l
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;
    private final c e;
    private final c f;
    private final c g;

    public l(c c10, c c11, c c12, c c13, c c14, c c15, c c16) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
        this.e = c14;
        this.f = c15;
        this.g = c16;
    }

    public static l a(c c10, c c11, c c12, c c13, c c14, c c15, c c16) {
        l l10 = new l(c10, c11, c12, c13, c14, c15, c16);
        return l10;
    }

    public static k c(x0 x02, a a10, String string2, BluetoothManager bluetoothManager, h0 h02, z z10, m m10) {
        k k10 = new k(x02, a10, string2, bluetoothManager, h02, z10, m10);
        return k10;
    }

    public k b() {
        k k10;
        Object object;
        Object object2 = object = this.a.get();
        object2 = (x0)object;
        Object object3 = object = this.b.get();
        object3 = (a)object;
        Object object4 = object = this.c.get();
        object4 = (String)object;
        Object object5 = object = this.d.get();
        object5 = (BluetoothManager)object;
        Object object6 = object = this.e.get();
        object6 = (h0)object;
        Object object7 = object = this.f.get();
        object7 = (z)object;
        Object object8 = object = this.g.get();
        object8 = (m)object;
        object = k10;
        k10 = new k((x0)object2, (a)object3, (String)object4, (BluetoothManager)object5, (h0)object6, (z)object7, (m)object8);
        return k10;
    }
}

