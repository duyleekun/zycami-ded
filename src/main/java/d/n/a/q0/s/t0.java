/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.s;
import d.n.a.q0.s.s0;
import d.n.a.q0.s.x0;

public final class t0
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;
    private final c e;
    private final c f;

    public t0(c c10, c c11, c c12, c c13, c c14, c c15) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
        this.e = c14;
        this.f = c15;
    }

    public static t0 a(c c10, c c11, c c12, c c13, c c14, c c15) {
        t0 t02 = new t0(c10, c11, c12, c13, c14, c15);
        return t02;
    }

    public static s0 c(byte[] byArray, byte[] byArray2, byte[] byArray3, BluetoothGatt bluetoothGatt, x0 x02, Object object) {
        Object object2 = object;
        object2 = (s)object;
        s0 s02 = new s0(byArray, byArray2, byArray3, bluetoothGatt, x02, (s)object2);
        return s02;
    }

    public s0 b() {
        s0 s02;
        Object object;
        Object object2 = object = this.a.get();
        object2 = (byte[])object;
        Object object3 = object = this.b.get();
        object3 = (byte[])object;
        Object object4 = object = this.c.get();
        object4 = (byte[])object;
        Object object5 = object = this.d.get();
        object5 = (BluetoothGatt)object;
        Object object6 = object = this.e.get();
        object6 = (x0)object;
        Object object7 = object = this.f.get();
        object7 = (s)object;
        object = s02;
        s02 = new s0((byte[])object2, (byte[])object3, (byte[])object4, (BluetoothGatt)object5, (x0)object6, (s)object7);
        return s02;
    }
}

