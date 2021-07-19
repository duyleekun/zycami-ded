/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import d.n.a.q0.p;
import d.n.a.q0.t.b;
import d.n.a.q0.u.w;
import d.n.a.q0.v.e;
import d.n.a.q0.v.g;
import d.n.a.q0.v.k;
import e.a.b0;

public class w$a
implements BluetoothAdapter.LeScanCallback {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ w b;

    public w$a(w w10, b0 b02) {
        this.b = w10;
        this.a = b02;
    }

    public void onLeScan(BluetoothDevice object, int n10, byte[] byArray) {
        Object object2;
        int n11;
        int n12;
        Object object3 = this.b.c;
        boolean n122 = ((e)object3).a();
        if (!n122 && (n12 = p.m(n11 = 3)) != 0 && (n12 = p.i()) != 0) {
            Object object4;
            n12 = 4;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object4 = d.n.a.q0.t.b.d(object.getAddress());
            objectArray[1] = object4 = object.getName();
            int n13 = 2;
            objectArray[n13] = object4 = Integer.valueOf(n10);
            String string2 = d.n.a.q0.t.b.a(byArray);
            objectArray[n11] = string2;
            object3 = "%s, name=%s, rssi=%d, data=%s";
            p.b((String)object3, objectArray);
        }
        if ((n10 = (int)(((e)(object2 = this.b.c)).b((k)(object = ((g)(object3 = this.b.b)).b((BluetoothDevice)object, n10, byArray))) ? 1 : 0)) != 0) {
            object2 = this.a;
            object2.onNext(object);
        }
    }
}

