/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import d.n.a.q0.s.v0;
import e.a.o0;
import e.a.v0.o;

public class v0$g
implements o {
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ v0 b;

    public v0$g(v0 v02, byte[] byArray) {
        this.b = v02;
        this.a = byArray;
    }

    public o0 a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        v0 v02 = this.b;
        byte[] byArray = this.a;
        return v02.k(bluetoothGattCharacteristic, byArray);
    }
}

