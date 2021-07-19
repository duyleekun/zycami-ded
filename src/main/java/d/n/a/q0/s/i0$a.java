/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.RxBleConnection$d;
import com.polidea.rxandroidble2.RxBleConnection$e;
import d.n.a.q0.s.i0;
import d.n.a.q0.s.u0;
import d.n.a.q0.u.p;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;
import e.a.v0.o;
import e.a.z;

public class i0$a
implements o {
    public final /* synthetic */ i0 a;

    public i0$a(i0 i02) {
        this.a = i02;
    }

    public z a(BluetoothGattCharacteristic object) {
        i0 i02 = this.a;
        d d10 = i02.a;
        q q10 = i02.c;
        RxBleConnection$d rxBleConnection$d = i02.f;
        RxBleConnection$e rxBleConnection$e = i02.g;
        u0 u02 = i02.e;
        byte[] byArray = i02.h;
        object = q10.f((BluetoothGattCharacteristic)object, rxBleConnection$d, rxBleConnection$e, u02, byArray);
        return d10.d((p)object);
    }
}

