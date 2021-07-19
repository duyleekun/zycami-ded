/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.os.DeadObjectException
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.RxBleConnection$d;
import com.polidea.rxandroidble2.RxBleConnection$e;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import d.n.a.q0.k;
import d.n.a.q0.p;
import d.n.a.q0.s.u0;
import d.n.a.q0.s.x0;
import d.n.a.q0.t.b;
import d.n.a.q0.u.a$a;
import d.n.a.q0.u.a$b;
import d.n.a.q0.u.a$c;
import d.n.a.q0.u.a$d;
import d.n.a.q0.u.a$e;
import d.n.a.q0.u.a$f;
import d.n.a.q0.u.a$g;
import d.n.a.q0.u.z;
import d.n.a.q0.w.j;
import d.n.a.q0.x.x;
import e.a.b0;
import e.a.g0;
import e.a.h0;
import e.a.v0.o;
import e.a.v0.r;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class a
extends k {
    private final BluetoothGatt a;
    private final x0 b;
    private final h0 c;
    private final z d;
    private final BluetoothGattCharacteristic e;
    private final u0 f;
    private final RxBleConnection$d g;
    private final RxBleConnection$e h;
    public final byte[] i;
    private byte[] j;

    public a(BluetoothGatt bluetoothGatt, x0 x02, h0 h02, z z10, BluetoothGattCharacteristic bluetoothGattCharacteristic, u0 u02, RxBleConnection$d rxBleConnection$d, RxBleConnection$e rxBleConnection$e, byte[] byArray) {
        this.a = bluetoothGatt;
        this.b = x02;
        this.c = h02;
        this.d = z10;
        this.e = bluetoothGattCharacteristic;
        this.f = u02;
        this.g = rxBleConnection$d;
        this.h = rxBleConnection$e;
        this.i = byArray;
    }

    public static o d(RxBleConnection$d rxBleConnection$d, ByteBuffer byteBuffer, x x10) {
        a$e a$e = new a$e(x10, byteBuffer, rxBleConnection$d);
        return a$e;
    }

    private static o e(RxBleConnection$e rxBleConnection$e, ByteBuffer byteBuffer, int n10, a$g a$g) {
        a$f a$f = new a$f(rxBleConnection$e, a$g, n10, byteBuffer);
        return a$f;
    }

    private e.a.z g(int n10, ByteBuffer byteBuffer, a$g a$g) {
        e.a.z z10 = this.b.e();
        a$c a$c = new a$c(this, z10, byteBuffer, n10, a$g);
        return e.a.z.y1(a$c);
    }

    private static r i(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        a$d a$d = new a$d(bluetoothGattCharacteristic);
        return a$d;
    }

    public void b(b0 object, j object2) {
        u0 u02 = this.f;
        int n10 = u02.a();
        if (n10 > 0) {
            Object object3 = this.a;
            Object object4 = d.n.a.o0.a.f;
            Object object5 = new BleGattCallbackTimeoutException((BluetoothGatt)object3, (d.n.a.o0.a)object4);
            e.a.z z10 = e.a.z.m2((Throwable)object5);
            object5 = ByteBuffer.wrap(this.i);
            object3 = new x((b0)object, (j)object2);
            object = new a$a(this, (ByteBuffer)object5, n10);
            object2 = this.g(n10, (ByteBuffer)object5, (a$g)object);
            object4 = this.c;
            object2 = ((e.a.z)object2).L5((h0)object4);
            object4 = d.n.a.q0.u.a.i(this.e);
            e.a.z z11 = ((e.a.z)object2).o2((r)object4).b6(1L);
            object2 = this.d;
            long l10 = ((z)object2).a;
            TimeUnit timeUnit = ((z)object2).b;
            h0 h02 = ((z)object2).c;
            object2 = z11.H6(l10, timeUnit, h02, z10);
            object4 = d.n.a.q0.u.a.d(this.g, (ByteBuffer)object5, (x)object3);
            object2 = ((e.a.z)object2).C4((o)object4);
            object = d.n.a.q0.u.a.e(this.h, (ByteBuffer)object5, n10, (a$g)object);
            object = ((e.a.z)object2).Z4((o)object);
            object2 = new a$b(this, (x)object3);
            ((e.a.z)object).subscribe((g0)object2);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("batchSizeProvider value must be greater than zero (now: ");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(")");
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public BleException c(DeadObjectException deadObjectException) {
        String string2 = this.a.getDevice().getAddress();
        BleDisconnectedException bleDisconnectedException = new BleDisconnectedException(deadObjectException, string2, -1);
        return bleDisconnectedException;
    }

    public byte[] f(ByteBuffer byteBuffer, int n10) {
        byte[] byArray;
        int n11 = byteBuffer.remaining();
        n10 = Math.min(n11, n10);
        byte[] byArray2 = this.j;
        if (byArray2 == null || (n11 = byArray2.length) != n10) {
            byArray = new byte[n10];
            this.j = byArray;
        }
        byArray = this.j;
        byteBuffer.get(byArray);
        return this.j;
    }

    public void h(byte[] object, a$g object2) {
        Object[] objectArray;
        int n10 = p.m(3);
        if (n10 != 0) {
            n10 = 2;
            objectArray = new Object[n10];
            objectArray[0] = object2 = Integer.valueOf(object2.get());
            int n11 = 1;
            String string2 = d.n.a.q0.t.b.a(object);
            objectArray[n11] = string2;
            object2 = "Writing batch #%04d: %s";
            p.b((String)object2, objectArray);
        }
        this.e.setValue(object);
        object = this.a;
        object2 = this.e;
        boolean bl2 = object.writeCharacteristic((BluetoothGattCharacteristic)object2);
        if (bl2) {
            return;
        }
        object = new BleGattCannotStartException;
        object2 = this.a;
        objectArray = d.n.a.o0.a.f;
        object((BluetoothGatt)object2, (d.n.a.o0.a)objectArray);
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharacteristicLongWriteOperation{");
        Object object = d.n.a.q0.t.b.c(this.a);
        stringBuilder.append((String)object);
        stringBuilder.append(", characteristic=");
        object = d.n.a.q0.t.b.u(this.e, false);
        stringBuilder.append(object);
        stringBuilder.append(", maxBatchSize=");
        int n10 = this.f.a();
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

