/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGattCharacteristic;
import d.n.a.q0.x.d;
import e.a.v0.r;
import java.util.UUID;

public final class a$d
implements r {
    public final /* synthetic */ BluetoothGattCharacteristic a;

    public a$d(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.a = bluetoothGattCharacteristic;
    }

    public boolean a(d object) {
        object = (UUID)((d)object).a;
        UUID uUID = this.a.getUuid();
        return ((UUID)object).equals(uUID);
    }
}

