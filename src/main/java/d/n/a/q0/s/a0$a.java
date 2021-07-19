/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import d.n.a.q0.s.a0;
import d.n.a.q0.s.c0;
import e.a.v0.a;

public class a0$a
implements a {
    public final /* synthetic */ BluetoothGattCharacteristic a;
    public final /* synthetic */ int b;
    public final /* synthetic */ a0 c;

    public a0$a(a0 a02, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10) {
        this.c = a02;
        this.a = bluetoothGattCharacteristic;
        this.b = n10;
    }

    public void run() {
        Object object = this.a;
        int n10 = object.getProperties();
        int n11 = this.b;
        if ((n10 &= n11) == 0) {
            object = this.c.a;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.a;
            if ((object = ((c0)object).a(bluetoothGattCharacteristic, n11)) != null) {
                throw object;
            }
        }
    }
}

