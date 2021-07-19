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
import d.n.a.q0.u.m;
import d.n.a.q0.v.l;
import e.a.b0;
import java.util.Collection;

public class m$a
implements BluetoothAdapter.LeScanCallback {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ m b;

    public m$a(m m10, b0 b02) {
        this.b = m10;
        this.a = b02;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int n10, byte[] byArray) {
        Object[] objectArray;
        int n11;
        int n12;
        Object object = this.b.c;
        if (object != null && (n12 = p.m(n11 = 3)) != 0) {
            Object object2;
            n12 = 4;
            objectArray = new Object[n12];
            objectArray[0] = object2 = d.n.a.q0.t.b.d(bluetoothDevice.getAddress());
            objectArray[1] = object2 = bluetoothDevice.getName();
            int n13 = 2;
            objectArray[n13] = object2 = Integer.valueOf(n10);
            String string2 = d.n.a.q0.t.b.a(byArray);
            objectArray[n11] = string2;
            object = "%s, name=%s, rssi=%d, data=%s";
            p.b((String)object, objectArray);
        }
        object = this.b;
        objectArray = ((m)object).c;
        if (objectArray == null || (n11 = (int)((object = ((m)object).b.b(byArray)).containsAll((Collection<?>)(objectArray = this.b.c)) ? 1 : 0)) != 0) {
            object = this.a;
            objectArray = new l(bluetoothDevice, n10, byArray);
            object.onNext(objectArray);
        }
    }
}

