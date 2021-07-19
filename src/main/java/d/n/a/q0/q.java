/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.os.DeadObjectException
 */
package d.n.a.q0;

import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import d.n.a.o0.a;
import d.n.a.q0.k;
import d.n.a.q0.s.x0;
import d.n.a.q0.t.b;
import d.n.a.q0.u.z;
import d.n.a.q0.w.j;
import d.n.a.q0.x.x;
import e.a.b0;
import e.a.h0;
import e.a.i0;
import java.util.concurrent.TimeUnit;

public abstract class q
extends k {
    private final BluetoothGatt a;
    private final x0 b;
    private final a c;
    private final z d;

    public q(BluetoothGatt bluetoothGatt, x0 x02, a a10, z z10) {
        this.a = bluetoothGatt;
        this.b = x02;
        this.c = a10;
        this.d = z10;
    }

    public final void b(b0 object, j object2) {
        x x10 = new x((b0)object, (j)object2);
        object = this.b;
        Object object3 = this.d((x0)object);
        object = this.d;
        long l10 = ((z)object).a;
        TimeUnit timeUnit = ((z)object).b;
        h0 h02 = ((z)object).c;
        object = this.a;
        object2 = this.b;
        i0 i02 = this.f((BluetoothGatt)object, (x0)object2, h02);
        ((i0)object3).l1(l10, timeUnit, h02, i02).v1().subscribe(x10);
        object = this.a;
        boolean bl2 = this.e((BluetoothGatt)object);
        if (!bl2) {
            x10.cancel();
            object2 = this.a;
            object3 = this.c;
            object = new BleGattCannotStartException((BluetoothGatt)object2, (a)object3);
            x10.onError((Throwable)object);
        }
    }

    public BleException c(DeadObjectException deadObjectException) {
        String string2 = this.a.getDevice().getAddress();
        BleDisconnectedException bleDisconnectedException = new BleDisconnectedException(deadObjectException, string2, -1);
        return bleDisconnectedException;
    }

    public abstract i0 d(x0 var1);

    public abstract boolean e(BluetoothGatt var1);

    public i0 f(BluetoothGatt object, x0 x02, h0 object2) {
        x02 = this.a;
        object2 = this.c;
        object = new BleGattCallbackTimeoutException((BluetoothGatt)x02, (a)object2);
        return i0.e0((Throwable)object);
    }

    public String toString() {
        return d.n.a.q0.t.b.c(this.a);
    }
}

