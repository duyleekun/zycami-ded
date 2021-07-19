/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.RxBleConnection$d;
import com.polidea.rxandroidble2.RxBleConnection$e;
import d.n.a.q0.s.u0;
import d.n.a.q0.u.a;
import d.n.a.q0.u.b;
import d.n.a.q0.u.c;
import d.n.a.q0.u.f;
import d.n.a.q0.u.h;
import d.n.a.q0.u.j;
import d.n.a.q0.u.n;
import d.n.a.q0.u.t;
import d.n.a.q0.u.y;
import java.util.concurrent.TimeUnit;

public interface q {
    public n a(int var1);

    public h b(BluetoothGattDescriptor var1);

    public b c(BluetoothGattCharacteristic var1);

    public t d();

    public f e(int var1, long var2, TimeUnit var4);

    public a f(BluetoothGattCharacteristic var1, RxBleConnection$d var2, RxBleConnection$e var3, u0 var4, byte[] var5);

    public j g(BluetoothGattDescriptor var1, byte[] var2);

    public y h(long var1, TimeUnit var3);

    public c i(BluetoothGattCharacteristic var1, byte[] var2);
}

