/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0.v;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import d.n.a.q0.v.k;
import d.n.a.r0.c;
import e.a.v0.o;

public final class u$d
implements o {
    public k a(k k10) {
        BluetoothDevice bluetoothDevice = k10.a();
        int n10 = k10.b();
        long l10 = k10.e();
        c c10 = k10.d();
        ScanCallbackType scanCallbackType = ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH;
        k k11 = new k(bluetoothDevice, n10, l10, c10, scanCallbackType);
        return k11;
    }
}

