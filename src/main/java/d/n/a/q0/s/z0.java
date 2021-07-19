/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import d.n.a.q0.s.z0$a;
import d.n.a.q0.s.z0$b;
import d.n.a.q0.s.z0$c;
import d.n.a.q0.s.z0$d;
import d.n.a.q0.s.z0$e;
import d.n.a.q0.s.z0$f;
import d.n.a.q0.s.z0$g;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;
import e.a.d1.a;
import e.a.d1.c;
import e.a.i0;
import e.a.o0;
import e.a.v0.g;
import e.a.v0.o;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class z0 {
    public final d a;
    public final BluetoothGatt b;
    public final q c;
    private i0 d;
    public final c e;
    public boolean f;

    public z0(d d10, BluetoothGatt bluetoothGatt, q q10) {
        c c10;
        this.e = c10 = e.a.d1.a.n8().l8();
        this.f = false;
        this.a = d10;
        this.b = bluetoothGatt;
        this.c = q10;
        this.d();
    }

    private e.a.q b() {
        Object object = new z0$f(this);
        object = i0.o0((Callable)object);
        z0$e z0$e = new z0$e(this);
        return ((i0)object).g0(z0$e);
    }

    private i0 c() {
        return this.e.r2();
    }

    private o e() {
        z0$g z0$g = new z0$g(this);
        return z0$g;
    }

    private static o f() {
        z0$d z0$d = new z0$d();
        return z0$d;
    }

    public i0 a(long l10, TimeUnit timeUnit) {
        boolean bl2 = this.f;
        if (bl2) {
            return this.d;
        }
        i0 i02 = this.d;
        z0$a z0$a = new z0$a(this, l10, timeUnit);
        return i02.a0(z0$a);
    }

    public void d() {
        this.f = false;
        Object object = this.b();
        Object object2 = z0.f();
        object = ((e.a.q)object).D0((o)object2);
        object2 = this.c();
        o o10 = this.e();
        object2 = ((i0)object2).h0(o10);
        object = ((e.a.q)object).w1((o0)object2);
        object2 = new z0$c(this);
        object2 = Functions.a((e.a.v0.a)object2);
        object = ((i0)object).b0((g)object2);
        object2 = new z0$b(this);
        object2 = Functions.a((e.a.v0.a)object2);
        this.d = object = ((i0)object).Y((g)object2).q();
    }
}

