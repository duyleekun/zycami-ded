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
import d.n.a.q0.s.a0;
import d.n.a.q0.s.m0;
import d.n.a.q0.s.s;
import d.n.a.q0.s.s0;
import d.n.a.q0.s.v0;
import d.n.a.q0.s.x0;
import d.n.a.q0.s.z0;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;
import e.a.h0;

public final class w0
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;
    private final c e;
    private final c f;
    private final c g;
    private final c h;
    private final c i;
    private final c j;
    private final c k;

    public w0(c c10, c c11, c c12, c c13, c c14, c c15, c c16, c c17, c c18, c c19, c c20) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
        this.e = c14;
        this.f = c15;
        this.g = c16;
        this.h = c17;
        this.i = c18;
        this.j = c19;
        this.k = c20;
    }

    public static w0 a(c c10, c c11, c c12, c c13, c c14, c c15, c c16, c c17, c c18, c c19, c c20) {
        w0 w02 = new w0(c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20);
        return w02;
    }

    public static v0 c(d d10, x0 x02, BluetoothGatt bluetoothGatt, Object object, Object object2, Object object3, Object object4, q q10, c c10, h0 h02, a0 a02) {
        Object object5 = object;
        object5 = (z0)object;
        Object object6 = object2;
        object6 = (s0)object2;
        Object object7 = object3;
        object7 = (m0)object3;
        Object object8 = object4;
        object8 = (s)object4;
        v0 v02 = new v0(d10, x02, bluetoothGatt, (z0)object5, (s0)object6, (m0)object7, (s)object8, q10, c10, h02, a02);
        return v02;
    }

    public v0 b() {
        v0 v02;
        Object object;
        Object object2 = object = this.a.get();
        object2 = (d)object;
        Object object3 = object = this.b.get();
        object3 = (x0)object;
        Object object4 = object = this.c.get();
        object4 = (BluetoothGatt)object;
        Object object5 = object = this.d.get();
        object5 = (z0)object;
        Object object6 = object = this.e.get();
        object6 = (s0)object;
        Object object7 = object = this.f.get();
        object7 = (m0)object;
        Object object8 = object = this.g.get();
        object8 = (s)object;
        Object object9 = object = this.h.get();
        object9 = (q)object;
        c c10 = this.i;
        Object object10 = object = this.j.get();
        object10 = (h0)object;
        Object object11 = object = this.k.get();
        object11 = (a0)object;
        object = v02;
        v02 = new v0((d)object2, (x0)object3, (BluetoothGatt)object4, (z0)object5, (s0)object6, (m0)object7, (s)object8, (q)object9, c10, (h0)object10, (a0)object11);
        return v02;
    }
}

