/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.k.b.b;
import d.n.a.q0.s.w$a;
import d.n.a.q0.s.w$b;
import d.n.a.q0.s.w$c;
import d.n.a.q0.s.w$d;
import d.n.a.q0.s.w$e;
import d.n.a.q0.s.w$f;
import d.n.a.q0.s.w$g;
import d.n.a.q0.s.x;
import d.n.a.q0.s.y;
import e.a.v0.a;
import e.a.v0.g;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;

public class w
implements x,
y {
    private final b a;
    private final z b;
    private final z c;

    public w(String object, d.n.a.q0.x.y object2, z object3) {
        b b10;
        this.a = b10 = d.k.b.b.k8();
        object2 = w.e((d.n.a.q0.x.y)object2, (z)object3);
        object3 = new w$c(this, (String)object);
        object = ((z)object2).H3((o)object3);
        object2 = new w$b(this);
        object = ((z)object).f2((g)object2);
        object2 = new w$a(this);
        object = ((z)object).c(b10, (g)object2);
        object2 = b10.q2().L1();
        object3 = new w$d(this, (e.a.s0.b)object);
        this.b = object = ((z)object2).h2((a)object3).L4().i8(0);
        object2 = new w$e(this);
        this.c = object = ((z)object).s2((o)object2);
    }

    private static z e(d.n.a.q0.x.y object, z object2) {
        w$g w$g = new w$g();
        object2 = ((z)object2).H3(w$g);
        object = ((d.n.a.q0.x.y)object).d();
        object = ((z)object2).I5(object);
        object2 = new w$f();
        return ((z)object).o2((r)object2);
    }

    public void a(BleGattException bleGattException) {
        this.a.accept(bleGattException);
    }

    public z b() {
        return this.c;
    }

    public void c(BleDisconnectedException bleDisconnectedException) {
        this.a.accept(bleDisconnectedException);
    }

    public z d() {
        return this.b;
    }
}

