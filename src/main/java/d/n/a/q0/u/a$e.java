/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import com.polidea.rxandroidble2.RxBleConnection$d;
import d.n.a.q0.u.a$e$a;
import d.n.a.q0.u.a$e$b;
import d.n.a.q0.u.a$e$c;
import d.n.a.q0.x.x;
import e.a.e0;
import e.a.f0;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import java.nio.ByteBuffer;

public final class a$e
implements o {
    public final /* synthetic */ x a;
    public final /* synthetic */ ByteBuffer b;
    public final /* synthetic */ RxBleConnection$d c;

    public a$e(x x10, ByteBuffer byteBuffer, RxBleConnection$d rxBleConnection$d) {
        this.a = x10;
        this.b = byteBuffer;
        this.c = rxBleConnection$d;
    }

    private o b(ByteBuffer byteBuffer) {
        a$e$b a$e$b = new a$e$b(this, byteBuffer);
        return a$e$b;
    }

    private r c(x x10) {
        a$e$c a$e$c = new a$e$c(this, x10);
        return a$e$c;
    }

    public e0 a(z z10) {
        Object object = this.a;
        object = this.c((x)object);
        z10 = z10.p6((r)object);
        object = this.b;
        object = this.b((ByteBuffer)object);
        z10 = z10.H3((o)object);
        object = this.c;
        z10 = z10.z0((f0)object);
        object = new a$e$a(this);
        return z10.p6((r)object);
    }
}

