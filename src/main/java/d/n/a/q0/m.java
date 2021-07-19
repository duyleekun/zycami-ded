/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0;

import android.bluetooth.BluetoothDevice;
import c.a.l.e;
import c.b.a.c;
import d.k.b.b;
import d.n.a.q0.l;
import d.n.a.q0.s.o;

public final class m
implements e {
    private final c a;
    private final c b;
    private final c c;

    public m(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static m a(c c10, c c11, c c12) {
        m m10 = new m(c10, c11, c12);
        return m10;
    }

    public static l c(BluetoothDevice bluetoothDevice, o o10, b b10) {
        l l10 = new l(bluetoothDevice, o10, b10);
        return l10;
    }

    public l b() {
        BluetoothDevice bluetoothDevice = (BluetoothDevice)this.a.get();
        o o10 = (o)this.b.get();
        b b10 = (b)this.c.get();
        l l10 = new l(bluetoothDevice, o10, b10);
        return l10;
    }
}

