/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import d.n.a.o0.a;
import d.n.a.q0.q;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.z;
import d.n.a.q0.x.e;
import e.a.i0;
import e.a.v0.o;
import e.a.v0.r;

public class b
extends q {
    private final BluetoothGattCharacteristic e;

    public b(x0 x02, BluetoothGatt bluetoothGatt, z z10, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        a a10 = a.d;
        super(bluetoothGatt, x02, a10, z10);
        this.e = bluetoothGattCharacteristic;
    }

    public i0 d(x0 object) {
        object = ((x0)object).d();
        Object object2 = d.n.a.q0.x.e.a(this.e.getUuid());
        object = ((e.a.z)object).o2((r)object2).r2();
        object2 = d.n.a.q0.x.e.c();
        return ((i0)object).z0((o)object2);
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.e;
        return bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharacteristicReadOperation{");
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", characteristic=");
        object = d.n.a.q0.t.b.u(this.e, false);
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

