/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleConnection$c;
import com.polidea.rxandroidble2.RxBleConnection$d;
import com.polidea.rxandroidble2.RxBleConnection$e;
import d.n.a.q0.s.f0;
import d.n.a.q0.s.i0$a;
import d.n.a.q0.s.k0;
import d.n.a.q0.s.r;
import d.n.a.q0.s.u0;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;
import e.a.v0.o;
import e.a.z;
import java.util.UUID;

public final class i0
implements RxBleConnection$c {
    public final d a;
    private final RxBleConnection b;
    public final q c;
    private e.a.i0 d;
    public u0 e;
    public RxBleConnection$d f;
    public RxBleConnection$e g;
    public byte[] h;

    public i0(d d10, k0 k02, RxBleConnection rxBleConnection, q q10) {
        e.a.f0 f02 = new f0();
        this.f = f02;
        this.g = f02;
        this.a = d10;
        this.e = k02;
        this.b = rxBleConnection;
        this.c = q10;
    }

    public RxBleConnection$c a(int n10) {
        r r10 = new r(n10);
        this.e = r10;
        return this;
    }

    public RxBleConnection$c b(UUID object) {
        this.d = object = this.b.z((UUID)object);
        return this;
    }

    public z build() {
        Object object = this.d;
        if (object != null) {
            Object object2 = this.h;
            if (object2 != null) {
                object2 = new i0$a;
                object2(this);
                return ((e.a.i0)object).k0((o)object2);
            }
            object = new IllegalArgumentException("setBytes() needs to be called before build()");
            throw object;
        }
        object = new IllegalArgumentException("setCharacteristicUuid() or setCharacteristic() needs to be called before build()");
        throw object;
    }

    public RxBleConnection$c c(RxBleConnection$d rxBleConnection$d) {
        this.f = rxBleConnection$d;
        return this;
    }

    public RxBleConnection$c d(RxBleConnection$e rxBleConnection$e) {
        this.g = rxBleConnection$e;
        return this;
    }

    public RxBleConnection$c e(BluetoothGattCharacteristic object) {
        object = e.a.i0.x0(object);
        this.d = object;
        return this;
    }

    public RxBleConnection$c f(byte[] byArray) {
        this.h = byArray;
        return this;
    }
}

