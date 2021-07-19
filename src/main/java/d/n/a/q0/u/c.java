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
import d.n.a.q0.t.b$a;
import d.n.a.q0.u.z;
import d.n.a.q0.x.e;
import e.a.i0;
import e.a.v0.o;
import e.a.v0.r;
import java.util.UUID;

public class c
extends q {
    private final BluetoothGattCharacteristic e;
    private final byte[] f;

    public c(x0 x02, BluetoothGatt bluetoothGatt, z z10, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] byArray) {
        a a10 = a.e;
        super(bluetoothGatt, x02, a10, z10);
        this.e = bluetoothGattCharacteristic;
        this.f = byArray;
    }

    public i0 d(x0 object) {
        object = ((x0)object).e();
        Object object2 = d.n.a.q0.x.e.a(this.e.getUuid());
        object = ((e.a.z)object).o2((r)object2).r2();
        object2 = d.n.a.q0.x.e.c();
        return ((i0)object).z0((o)object2);
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.e;
        byte[] byArray = this.f;
        bluetoothGattCharacteristic.setValue(byArray);
        bluetoothGattCharacteristic = this.e;
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharacteristicWriteOperation{");
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", characteristic=");
        UUID uUID = this.e.getUuid();
        byte[] byArray = this.f;
        object = new b$a(uUID, byArray, true);
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

