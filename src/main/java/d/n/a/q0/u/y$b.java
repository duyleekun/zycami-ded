/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import d.n.a.o0.a;
import d.n.a.q0.u.y;
import d.n.a.q0.u.y$b$a;
import e.a.h0;
import e.a.i0;
import e.a.o0;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class y$b
implements Callable {
    public final /* synthetic */ BluetoothGatt a;
    public final /* synthetic */ h0 b;
    public final /* synthetic */ y c;

    public y$b(y y10, BluetoothGatt bluetoothGatt, h0 h02) {
        this.c = y10;
        this.a = bluetoothGatt;
        this.b = h02;
    }

    public o0 a() {
        Object object = this.a.getServices();
        int n10 = object.size();
        if (n10 == 0) {
            BluetoothGatt bluetoothGatt = this.a;
            a a10 = d.n.a.o0.a.c;
            object = new BleGattCallbackTimeoutException(bluetoothGatt, a10);
            return i0.e0((Throwable)object);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.b;
        object = i0.p1(5, timeUnit, h02);
        y$b$a y$b$a = new y$b$a(this);
        return ((i0)object).h0(y$b$a);
    }
}

