/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0;

import android.bluetooth.BluetoothDevice;
import c.a.l.e;
import c.a.l.l;
import d.n.a.q0.c;
import d.n.a.q0.x.y;

public final class d
implements e {
    private final c.b.a.c a;
    private final c.b.a.c b;

    public d(c.b.a.c c10, c.b.a.c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static d a(c.b.a.c c10, c.b.a.c c11) {
        d d10 = new d(c10, c11);
        return d10;
    }

    public static BluetoothDevice c(String string2, y y10) {
        return (BluetoothDevice)l.b(c.c(string2, y10), "Cannot return null from a non-@Nullable @Provides method");
    }

    public BluetoothDevice b() {
        String string2 = (String)this.a.get();
        y y10 = (y)this.b.get();
        return (BluetoothDevice)l.b(c.c(string2, y10), "Cannot return null from a non-@Nullable @Provides method");
    }
}

