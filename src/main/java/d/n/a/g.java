/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothManager
 *  android.content.Context
 */
package d.n.a;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;

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

    public static BluetoothManager c(Context context) {
        return (BluetoothManager)l.b(b$d.j(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public BluetoothManager b() {
        return (BluetoothManager)l.b(b$d.j((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

