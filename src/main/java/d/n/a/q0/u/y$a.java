/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothDevice;
import d.n.a.k0;
import d.n.a.q0.t.c;
import d.n.a.q0.u.y;
import e.a.v0.g;

public class y$a
implements g {
    public final /* synthetic */ y a;

    public y$a(y y10) {
        this.a = y10;
    }

    public void a(k0 k02) {
        y y10 = this.a;
        c c10 = y10.f;
        y10 = y10.e.getDevice();
        c10.m(k02, (BluetoothDevice)y10);
    }
}

