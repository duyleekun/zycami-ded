/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import d.n.a.e0$b;
import d.n.a.q0.x.m$a;
import d.n.a.q0.x.m$b;
import d.n.a.q0.x.m$c;
import d.n.a.q0.x.m$d;
import d.n.a.q0.x.r;
import d.n.a.q0.x.y;
import e.a.g0;
import e.a.h0;
import e.a.i0;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class m
extends z {
    public final y a;
    public final z b;
    public final z c;
    private final r d;
    private final h0 e;

    public m(y y10, z z10, z z11, r r10, h0 h02) {
        this.a = y10;
        this.b = z10;
        this.c = z11;
        this.d = r10;
        this.e = h02;
    }

    public static z h8(y object, z object2, z z10) {
        boolean bl2 = ((y)object).d();
        object = bl2 ? e0$b.c : e0$b.d;
        object = ((z)object2).I5(object);
        object2 = new m$c(z10);
        return ((z)object).N5((o)object2);
    }

    private static i0 i8(r object, h0 object2) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        object2 = z.m3(0L, 1L, timeUnit, (h0)object2);
        m$b m$b = new m$b((r)object);
        object = ((z)object2).p6(m$b).x1();
        object2 = new m$a();
        return ((i0)object).z0((o)object2);
    }

    public void K5(g0 g02) {
        Object object = this.a;
        boolean bl2 = ((y)object).c();
        if (!bl2) {
            object = e.a.s0.c.b();
            g02.onSubscribe((b)object);
            g02.onComplete();
            return;
        }
        object = this.d;
        Object object2 = this.e;
        object = m.i8((r)object, (h0)object2);
        object2 = new m$d(this);
        ((i0)object).k0((o)object2).subscribe(g02);
    }
}

