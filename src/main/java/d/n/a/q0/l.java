/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import d.n.a.j0;
import d.n.a.n0;
import d.n.a.q0.l$a;
import d.n.a.q0.s.o;
import d.n.a.q0.t.b;
import d.n.a.z;
import d.n.a.z$a;
import java.util.concurrent.atomic.AtomicBoolean;

public class l
implements j0 {
    public final BluetoothDevice a;
    public final o b;
    private final d.k.b.b c;
    public final AtomicBoolean d;

    public l(BluetoothDevice bluetoothDevice, o o10, d.k.b.b b10) {
        AtomicBoolean atomicBoolean;
        this.d = atomicBoolean = new AtomicBoolean(false);
        this.a = bluetoothDevice;
        this.b = o10;
        this.c = b10;
    }

    public e.a.z a(boolean bl2) {
        z$a z$a = new z$a();
        z z10 = z$a.b(bl2).d(true).a();
        return this.g(z10);
    }

    public BluetoothDevice b() {
        return this.a;
    }

    public e.a.z c(boolean bl2, n0 n02) {
        z$a z$a = new z$a();
        z z10 = z$a.b(bl2).c(n02).d(true).a();
        return this.g(z10);
    }

    public RxBleConnection$RxBleConnectionState d() {
        return (RxBleConnection$RxBleConnectionState)((Object)this.c.m8());
    }

    public String e() {
        return this.a.getAddress();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof l;
        if (!bl2) {
            return false;
        }
        object = (l)object;
        BluetoothDevice bluetoothDevice = this.a;
        object = ((l)object).a;
        return bluetoothDevice.equals(object);
    }

    public e.a.z f() {
        return this.c.S1().t5(1L);
    }

    public e.a.z g(z z10) {
        l$a l$a = new l$a(this, z10);
        return e.a.z.D1(l$a);
    }

    public String getName() {
        return this.a.getName();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxBleDeviceImpl{");
        String string2 = d.n.a.q0.t.b.d(this.a.getAddress());
        stringBuilder.append(string2);
        stringBuilder.append(", name=");
        string2 = this.a.getName();
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

