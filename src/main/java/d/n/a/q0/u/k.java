/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothManager
 *  android.os.DeadObjectException
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.q0.p;
import d.n.a.q0.s.a;
import d.n.a.q0.s.m;
import d.n.a.q0.s.x0;
import d.n.a.q0.t.b;
import d.n.a.q0.u.k$a;
import d.n.a.q0.u.k$b;
import d.n.a.q0.u.z;
import d.n.a.q0.w.j;
import e.a.b0;
import e.a.h0;
import e.a.i;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import java.util.concurrent.TimeUnit;

public class k
extends d.n.a.q0.k {
    private final x0 a;
    private final a b;
    private final String c;
    private final BluetoothManager d;
    private final h0 e;
    private final z f;
    private final m g;

    public k(x0 x02, a a10, String string2, BluetoothManager bluetoothManager, h0 h02, z z10, m m10) {
        this.a = x02;
        this.b = a10;
        this.c = string2;
        this.d = bluetoothManager;
        this.e = h02;
        this.f = z10;
        this.g = m10;
    }

    private i0 e(BluetoothGatt object) {
        Object object2 = this.a;
        h0 h02 = this.e;
        k$b k$b = new k$b((BluetoothGatt)object, (x0)object2, h02);
        object2 = this.f;
        long l10 = ((z)object2).a;
        Object object3 = ((z)object2).b;
        h0 h03 = ((z)object2).c;
        object = i0.x0(object);
        TimeUnit timeUnit = object3;
        object3 = h03;
        h03 = object;
        return k$b.l1(l10, timeUnit, (h0)object3, (o0)object);
    }

    private i0 f(BluetoothGatt object) {
        boolean bl2 = this.g((BluetoothGatt)object);
        object = bl2 ? i0.x0(object) : this.e((BluetoothGatt)object);
        return object;
    }

    private boolean g(BluetoothGatt bluetoothGatt) {
        int n10;
        BluetoothManager bluetoothManager = this.d;
        int n11 = bluetoothManager.getConnectionState((BluetoothDevice)(bluetoothGatt = bluetoothGatt.getDevice()), n10 = 7);
        if (!n11) {
            n11 = 1;
        } else {
            n11 = 0;
            bluetoothGatt = null;
        }
        return n11 != 0;
    }

    public void b(b0 b02, j j10) {
        Object object = this.g;
        Object object2 = RxBleConnection$RxBleConnectionState.DISCONNECTING;
        object.a((RxBleConnection$RxBleConnectionState)((Object)object2));
        object = this.b.a();
        if (object == null) {
            object = new Object[]{};
            object2 = "Disconnect operation has been executed but GATT instance was null - considering disconnected.";
            p.u((String)object2, (Object[])object);
            this.d(b02, j10);
        } else {
            object = this.f((BluetoothGatt)object);
            object2 = this.e;
            object = ((i0)object).O0((h0)object2);
            object2 = new k$a(this, b02, j10);
            ((i0)object).f((l0)object2);
        }
    }

    public BleException c(DeadObjectException deadObjectException) {
        String string2 = this.c;
        BleDisconnectedException bleDisconnectedException = new BleDisconnectedException(deadObjectException, string2, -1);
        return bleDisconnectedException;
    }

    public void d(i i10, j j10) {
        m m10 = this.g;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState = RxBleConnection$RxBleConnectionState.DISCONNECTED;
        m10.a(rxBleConnection$RxBleConnectionState);
        j10.release();
        i10.onComplete();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DisconnectOperation{");
        String string2 = d.n.a.q0.t.b.d(this.c);
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

