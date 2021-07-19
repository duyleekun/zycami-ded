/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattDescriptor;
import d.n.a.q0.u.p;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;
import e.a.a;

public class s {
    private final d a;
    private final q b;

    public s(d d10, q q10) {
        this.a = d10;
        this.b = q10;
    }

    public a a(BluetoothGattDescriptor object, byte[] byArray) {
        d d10 = this.a;
        object = this.b.g((BluetoothGattDescriptor)object, byArray);
        return d10.d((p)object).k3();
    }
}

