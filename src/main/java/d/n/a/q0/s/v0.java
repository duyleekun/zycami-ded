/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import c.b.a.c;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleConnection$c;
import d.n.a.i0;
import d.n.a.q0.j;
import d.n.a.q0.s.a0;
import d.n.a.q0.s.m0;
import d.n.a.q0.s.s;
import d.n.a.q0.s.s0;
import d.n.a.q0.s.v0$a;
import d.n.a.q0.s.v0$b;
import d.n.a.q0.s.v0$c;
import d.n.a.q0.s.v0$d;
import d.n.a.q0.s.v0$e;
import d.n.a.q0.s.v0$f;
import d.n.a.q0.s.v0$g;
import d.n.a.q0.s.v0$h;
import d.n.a.q0.s.v0$i;
import d.n.a.q0.s.v0$j;
import d.n.a.q0.s.v0$k;
import d.n.a.q0.s.x0;
import d.n.a.q0.s.z0;
import d.n.a.q0.u.f;
import d.n.a.q0.u.n;
import d.n.a.q0.u.p;
import d.n.a.q0.u.q;
import d.n.a.q0.u.t;
import d.n.a.q0.w.d;
import e.a.a;
import e.a.e0;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class v0
implements RxBleConnection {
    private final d e;
    public final x0 f;
    public final BluetoothGatt g;
    private final q h;
    private final c i;
    public final h0 j;
    private final z0 k;
    private final s0 l;
    private final m0 m;
    private final s n;
    private final a0 o;

    public v0(d d10, x0 x02, BluetoothGatt bluetoothGatt, z0 z02, s0 s02, m0 m02, s s10, q q10, c c10, h0 h02, a0 a02) {
        this.e = d10;
        this.f = x02;
        this.g = bluetoothGatt;
        this.k = z02;
        this.l = s02;
        this.m = m02;
        this.n = s10;
        this.h = q10;
        this.i = c10;
        this.j = h02;
        this.o = a02;
    }

    public z A(i0 i02) {
        j j10 = d.n.a.q0.j.c;
        return this.i(i02, j10);
    }

    public int a() {
        return this.m.a();
    }

    public z b(UUID object, NotificationSetupMode notificationSetupMode) {
        object = this.z((UUID)object);
        v0$e v0$e = new v0$e(this, notificationSetupMode);
        return ((e.a.i0)object).k0(v0$e);
    }

    public a c(UUID object, UUID object2, UUID uUID, byte[] byArray) {
        e.a.i0 i02 = this.p();
        v0$a v0$a = new v0$a(this, (UUID)object, (UUID)object2, uUID);
        object = i02.h0(v0$a);
        object2 = new v0$k(this, byArray);
        return ((e.a.i0)object).i0((o)object2);
    }

    public e.a.i0 d(BluetoothGattCharacteristic object) {
        a a10 = this.o.a((BluetoothGattCharacteristic)object, 2);
        d d10 = this.e;
        object = this.h.c((BluetoothGattCharacteristic)object);
        object = d10.d((p)object);
        return a10.q((e0)object).r2();
    }

    public z e(UUID object, NotificationSetupMode notificationSetupMode) {
        object = this.z((UUID)object);
        v0$d v0$d = new v0$d(this, notificationSetupMode);
        return ((e.a.i0)object).k0(v0$d);
    }

    public z f(UUID uUID) {
        NotificationSetupMode notificationSetupMode = NotificationSetupMode.DEFAULT;
        return this.e(uUID, notificationSetupMode);
    }

    public z g(BluetoothGattCharacteristic object, NotificationSetupMode notificationSetupMode) {
        a a10 = this.o.a((BluetoothGattCharacteristic)object, 32);
        object = this.l.d((BluetoothGattCharacteristic)object, notificationSetupMode, true);
        return a10.q((e0)object);
    }

    public z h(BluetoothGattCharacteristic object, NotificationSetupMode notificationSetupMode) {
        a a10 = this.o.a((BluetoothGattCharacteristic)object, 16);
        object = this.l.d((BluetoothGattCharacteristic)object, notificationSetupMode, false);
        return a10.q((e0)object);
    }

    public z i(i0 i02, j j10) {
        d d10 = this.e;
        v0$b v0$b = new v0$b(this, i02, j10);
        return d10.d(v0$b);
    }

    public e.a.i0 j(int n10) {
        d d10 = this.e;
        n n11 = this.h.a(n10);
        return d10.d(n11).r2();
    }

    public e.a.i0 k(BluetoothGattCharacteristic object, byte[] byArray) {
        a a10 = this.o.a((BluetoothGattCharacteristic)object, 76);
        d d10 = this.e;
        object = this.h.i((BluetoothGattCharacteristic)object, byArray);
        object = d10.d((p)object);
        return a10.q((e0)object).r2();
    }

    public z l() {
        return this.f.b();
    }

    public z m(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        NotificationSetupMode notificationSetupMode = NotificationSetupMode.DEFAULT;
        return this.g(bluetoothGattCharacteristic, notificationSetupMode);
    }

    public e.a.i0 n(BluetoothGattDescriptor object) {
        Object object2 = this.e;
        object = this.h.b((BluetoothGattDescriptor)object);
        object = object2.d((p)object).r2();
        object2 = new v0$j(this);
        return ((e.a.i0)object).z0((o)object2);
    }

    public e.a.i0 o(UUID object, UUID object2, UUID uUID) {
        e.a.i0 i02 = this.p();
        v0$i v0$i = new v0$i(this, (UUID)object, (UUID)object2, uUID);
        object = i02.h0(v0$i);
        object2 = new v0$h(this);
        return ((e.a.i0)object).h0((o)object2);
    }

    public e.a.i0 p() {
        z0 z02 = this.k;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return z02.a(20, timeUnit);
    }

    public z q(UUID uUID) {
        NotificationSetupMode notificationSetupMode = NotificationSetupMode.DEFAULT;
        return this.b(uUID, notificationSetupMode);
    }

    public RxBleConnection$c r() {
        return (RxBleConnection$c)this.i.get();
    }

    public e.a.i0 s(UUID object) {
        object = this.z((UUID)object);
        v0$f v0$f = new v0$f(this);
        return ((e.a.i0)object).h0(v0$f);
    }

    public a t(int n10, long l10, TimeUnit timeUnit) {
        int n11 = 2;
        if (n10 != n11 && n10 != 0 && n10 != (n11 = 1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Connection priority must have valid value from BluetoothGatt (received ");
            stringBuilder.append(n10);
            stringBuilder.append(")");
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            return a.V(illegalArgumentException);
        }
        long l11 = 0L;
        long l12 = l10 - l11;
        n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n11 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Delay must be bigger than 0");
            return a.V(illegalArgumentException);
        }
        d d10 = this.e;
        f f10 = this.h.e(n10, l10, timeUnit);
        return d10.d(f10).k3();
    }

    public e.a.i0 u(long l10, TimeUnit timeUnit) {
        return this.k.a(l10, timeUnit);
    }

    public e.a.i0 v(UUID object, byte[] byArray) {
        object = this.z((UUID)object);
        v0$g v0$g = new v0$g(this, byArray);
        return ((e.a.i0)object).h0(v0$g);
    }

    public e.a.i0 w() {
        d d10 = this.e;
        t t10 = this.h.d();
        return d10.d(t10).r2();
    }

    public z x(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        NotificationSetupMode notificationSetupMode = NotificationSetupMode.DEFAULT;
        return this.h(bluetoothGattCharacteristic, notificationSetupMode);
    }

    public a y(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] byArray) {
        return this.n.a(bluetoothGattDescriptor, byArray);
    }

    public e.a.i0 z(UUID uUID) {
        e.a.i0 i02 = this.p();
        v0$c v0$c = new v0$c(this, uUID);
        return i02.h0(v0$c);
    }
}

