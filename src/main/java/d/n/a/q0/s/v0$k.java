/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattDescriptor;
import d.n.a.q0.s.v0;
import e.a.g;
import e.a.v0.o;

public class v0$k
implements o {
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ v0 b;

    public v0$k(v0 v02, byte[] byArray) {
        this.b = v02;
        this.a = byArray;
    }

    public g a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        v0 v02 = this.b;
        byte[] byArray = this.a;
        return v02.y(bluetoothGattDescriptor, byArray);
    }
}

