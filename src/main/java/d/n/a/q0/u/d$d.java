/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCallback
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import d.n.a.q0.u.d;
import d.n.a.q0.u.d$d$a;
import d.n.a.q0.x.b;
import d.n.a.q0.x.o;
import e.a.e0;
import e.a.i0;
import e.a.k0;
import e.a.l0;
import e.a.m0;
import e.a.o0;
import e.a.y0.e;
import e.a.z;

public class d$d
implements m0 {
    public final /* synthetic */ d a;

    public d$d(d d10) {
        this.a = d10;
    }

    public void subscribe(k0 object) {
        Object object2 = this.a.d();
        Object object3 = this.a.c.f();
        d$d$a d$d$a = new d$d$a(this);
        object3 = ((z)object3).o2(d$d$a);
        object2 = ((i0)object2).Q((e0)object3);
        object3 = this.a.c.n().r2();
        object2 = ((i0)object2).M0((o0)object3).x2();
        object3 = o.c((k0)object);
        object2 = (e)((i0)object2).h((l0)object3);
        object.setDisposable((e.a.s0.b)object2);
        object = this.a.g;
        object2 = RxBleConnection$RxBleConnectionState.CONNECTING;
        object.a((RxBleConnection$RxBleConnectionState)((Object)object2));
        object = this.a;
        object2 = ((d)object).b;
        object3 = ((d)object).a;
        boolean bl2 = ((d)object).f;
        object = ((d)object).c.a();
        object = ((b)object2).a((BluetoothDevice)object3, bl2, (BluetoothGattCallback)object);
        this.a.d.b((BluetoothGatt)object);
    }
}

