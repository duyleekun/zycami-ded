/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import com.polidea.rxandroidble2.RxBleConnection$e;
import d.n.a.q0.u.a$f$a;
import d.n.a.q0.u.a$f$b;
import d.n.a.q0.u.a$g;
import e.a.e0;
import e.a.f0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import java.nio.ByteBuffer;

public final class a$f
implements o {
    public final /* synthetic */ RxBleConnection$e a;
    public final /* synthetic */ a$g b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ByteBuffer d;

    public a$f(RxBleConnection$e rxBleConnection$e, a$g a$g, int n10, ByteBuffer byteBuffer) {
        this.a = rxBleConnection$e;
        this.b = a$g;
        this.c = n10;
        this.d = byteBuffer;
    }

    private g b() {
        a$f$b a$f$b = new a$f$b(this);
        return a$f$b;
    }

    private o c() {
        a$f$a a$f$a = new a$f$a(this);
        return a$f$a;
    }

    public e0 a(z z10) {
        Object object = this.c();
        z10 = z10.s2((o)object);
        object = this.b();
        z10 = z10.f2((g)object);
        object = this.a;
        return z10.z0((f0)object);
    }
}

