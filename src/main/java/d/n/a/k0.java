/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import com.polidea.rxandroidble2.exceptions.BleServiceNotFoundException;
import d.n.a.k0$a;
import d.n.a.k0$b;
import d.n.a.k0$c;
import d.n.a.k0$d;
import d.n.a.k0$e;
import d.n.a.k0$f;
import e.a.i0;
import e.a.o0;
import e.a.q;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import java.util.List;
import java.util.UUID;

public class k0 {
    public final List a;

    public k0(List list) {
        this.a = list;
    }

    public List a() {
        return this.a;
    }

    public i0 b(UUID uUID) {
        k0$b k0$b = new k0$b(this, uUID);
        return i0.o0(k0$b);
    }

    public i0 c(UUID object, UUID uUID) {
        object = this.f((UUID)object);
        k0$c k0$c = new k0$c(this, uUID);
        return ((i0)object).z0(k0$c);
    }

    public i0 d(UUID object, UUID uUID) {
        object = this.b((UUID)object);
        k0$d k0$d = new k0$d(this, uUID);
        return ((i0)object).z0(k0$d);
    }

    public i0 e(UUID object, UUID object2, UUID uUID) {
        object = this.f((UUID)object);
        k0$f k0$f = new k0$f(this, (UUID)object2);
        object = ((i0)object).z0(k0$f);
        object2 = new k0$e(this, uUID);
        return ((i0)object).z0((o)object2);
    }

    public i0 f(UUID object) {
        Object object2 = z.W2(this.a);
        Object object3 = new k0$a(this, (UUID)object);
        object2 = ((z)object2).o2((r)object3).q2();
        object3 = new BleServiceNotFoundException((UUID)object);
        object = i0.e0((Throwable)object3);
        return ((q)object2).w1((o0)object);
    }
}

