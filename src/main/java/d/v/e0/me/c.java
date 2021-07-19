/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothGatt
 *  android.os.Build$VERSION
 */
package d.v.e0.me;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.os.Build;
import d.n.a.i0;
import d.n.a.q0.s.x0;
import e.a.h0;
import e.a.z;

public class c
implements i0 {
    public z a(BluetoothGatt bluetoothGatt, x0 object, h0 h02) {
        object = Boolean.TRUE;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return z.t3(object);
        }
        h02 = BluetoothAdapter.getDefaultAdapter();
        n10 = (int)(h02.isLe2MPhySupported() ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            h02 = null;
            n11 = 2;
            bluetoothGatt.setPreferredPhy(n11, n11, 0);
        }
        return z.t3(object);
    }
}

