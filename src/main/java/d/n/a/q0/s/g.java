/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.q0.s.a;
import d.n.a.q0.s.d;

public final class g
implements e {
    private final c a;

    public g(c c10) {
        this.a = c10;
    }

    public static g a(c c10) {
        g g10 = new g(c10);
        return g10;
    }

    public static BluetoothGatt c(a a10) {
        return (BluetoothGatt)l.b(d.m(a10), "Cannot return null from a non-@Nullable @Provides method");
    }

    public BluetoothGatt b() {
        return (BluetoothGatt)l.b(d.m((a)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

