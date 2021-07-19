/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
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

public class j
extends q {
    private final BluetoothGattDescriptor e;
    private final byte[] f;
    private final int g;

    public j(x0 x02, BluetoothGatt bluetoothGatt, z z10, int n10, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] byArray) {
        a a10 = a.i;
        super(bluetoothGatt, x02, a10, z10);
        this.g = n10;
        this.e = bluetoothGattDescriptor;
        this.f = byArray;
    }

    public i0 d(x0 object) {
        object = ((x0)object).h();
        Object object2 = d.n.a.q0.x.e.b(this.e);
        object = ((e.a.z)object).o2((r)object2).r2();
        object2 = d.n.a.q0.x.e.c();
        return ((i0)object).z0((o)object2);
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        BluetoothGattDescriptor bluetoothGattDescriptor = this.e;
        byte[] byArray = this.f;
        bluetoothGattDescriptor.setValue(byArray);
        bluetoothGattDescriptor = this.e.getCharacteristic();
        int n10 = bluetoothGattDescriptor.getWriteType();
        int n11 = this.g;
        bluetoothGattDescriptor.setWriteType(n11);
        BluetoothGattDescriptor bluetoothGattDescriptor2 = this.e;
        boolean bl2 = bluetoothGatt.writeDescriptor(bluetoothGattDescriptor2);
        bluetoothGattDescriptor.setWriteType(n10);
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DescriptorWriteOperation{");
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", descriptor=");
        UUID uUID = this.e.getUuid();
        byte[] byArray = this.f;
        object = new b$a(uUID, byArray, true);
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

