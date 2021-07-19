/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.RxBleConnection$d;
import com.polidea.rxandroidble2.RxBleConnection$e;
import d.n.a.q0.s.u0;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.a;
import d.n.a.q0.u.b;
import d.n.a.q0.u.c;
import d.n.a.q0.u.f;
import d.n.a.q0.u.h;
import d.n.a.q0.u.j;
import d.n.a.q0.u.n;
import d.n.a.q0.u.q;
import d.n.a.q0.u.t;
import d.n.a.q0.u.y;
import d.n.a.q0.u.z;
import e.a.h0;
import java.util.concurrent.TimeUnit;

public class r
implements q {
    private final x0 a;
    private final BluetoothGatt b;
    private final d.n.a.q0.t.c c;
    private final z d;
    private final h0 e;
    private final h0 f;
    private final c.b.a.c g;

    public r(x0 x02, BluetoothGatt bluetoothGatt, d.n.a.q0.t.c c10, z z10, h0 h02, h0 h03, c.b.a.c c11) {
        this.a = x02;
        this.b = bluetoothGatt;
        this.c = c10;
        this.d = z10;
        this.e = h02;
        this.f = h03;
        this.g = c11;
    }

    public n a(int n10) {
        x0 x02 = this.a;
        BluetoothGatt bluetoothGatt = this.b;
        z z10 = this.d;
        n n11 = new n(x02, bluetoothGatt, z10, n10);
        return n11;
    }

    public h b(BluetoothGattDescriptor bluetoothGattDescriptor) {
        x0 x02 = this.a;
        BluetoothGatt bluetoothGatt = this.b;
        z z10 = this.d;
        h h10 = new h(x02, bluetoothGatt, z10, bluetoothGattDescriptor);
        return h10;
    }

    public b c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        x0 x02 = this.a;
        BluetoothGatt bluetoothGatt = this.b;
        z z10 = this.d;
        b b10 = new b(x02, bluetoothGatt, z10, bluetoothGattCharacteristic);
        return b10;
    }

    public t d() {
        return (t)this.g.get();
    }

    public f e(int n10, long l10, TimeUnit timeUnit) {
        f f10;
        x0 x02 = this.a;
        BluetoothGatt bluetoothGatt = this.b;
        z z10 = this.d;
        Object object = this.f;
        z z11 = new z(l10, timeUnit, (h0)object);
        object = f10;
        f10 = new f(x02, bluetoothGatt, z10, n10, z11);
        return f10;
    }

    public a f(BluetoothGattCharacteristic bluetoothGattCharacteristic, RxBleConnection$d rxBleConnection$d, RxBleConnection$e rxBleConnection$e, u0 u02, byte[] byArray) {
        BluetoothGatt bluetoothGatt = this.b;
        x0 x02 = this.a;
        h0 h02 = this.e;
        z z10 = this.d;
        a a10 = new a(bluetoothGatt, x02, h02, z10, bluetoothGattCharacteristic, u02, rxBleConnection$d, rxBleConnection$e, byArray);
        return a10;
    }

    public j g(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] byArray) {
        x0 x02 = this.a;
        BluetoothGatt bluetoothGatt = this.b;
        z z10 = this.d;
        j j10 = new j(x02, bluetoothGatt, z10, 2, bluetoothGattDescriptor, byArray);
        return j10;
    }

    public y h(long l10, TimeUnit timeUnit) {
        x0 x02 = this.a;
        BluetoothGatt bluetoothGatt = this.b;
        d.n.a.q0.t.c c10 = this.c;
        h0 h02 = this.f;
        z z10 = new z(l10, timeUnit, h02);
        y y10 = new y(x02, bluetoothGatt, c10, z10);
        return y10;
    }

    public c i(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] byArray) {
        x0 x02 = this.a;
        BluetoothGatt bluetoothGatt = this.b;
        z z10 = this.d;
        c c10 = new c(x02, bluetoothGatt, z10, bluetoothGattCharacteristic, byArray);
        return c10;
    }
}

