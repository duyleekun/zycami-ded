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
import d.n.a.q0.t.b;
import d.n.a.q0.u.z;
import d.n.a.q0.x.e;
import e.a.i0;
import e.a.v0.r;

public class h
extends q {
    private final BluetoothGattDescriptor e;

    public h(x0 x02, BluetoothGatt bluetoothGatt, z z10, BluetoothGattDescriptor bluetoothGattDescriptor) {
        a a10 = a.h;
        super(bluetoothGatt, x02, a10, z10);
        this.e = bluetoothGattDescriptor;
    }

    public i0 d(x0 object) {
        object = ((x0)object).g();
        r r10 = d.n.a.q0.x.e.b(this.e);
        return ((e.a.z)object).o2(r10).r2();
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        BluetoothGattDescriptor bluetoothGattDescriptor = this.e;
        return bluetoothGatt.readDescriptor(bluetoothGattDescriptor);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DescriptorReadOperation{");
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", descriptor=");
        object = b.v(this.e, false);
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

