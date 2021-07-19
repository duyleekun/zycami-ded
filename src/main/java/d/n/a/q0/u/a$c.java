/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import d.n.a.q0.u.a;
import d.n.a.q0.u.a$g;
import d.n.a.q0.x.o;
import e.a.b0;
import e.a.c0;
import e.a.g0;
import e.a.s0.b;
import e.a.y0.d;
import e.a.z;
import java.nio.ByteBuffer;

public class a$c
implements c0 {
    public final /* synthetic */ z a;
    public final /* synthetic */ ByteBuffer b;
    public final /* synthetic */ int c;
    public final /* synthetic */ a$g d;
    public final /* synthetic */ a e;

    public a$c(a a10, z z10, ByteBuffer byteBuffer, int n10, a$g a$g) {
        this.e = a10;
        this.a = z10;
        this.b = byteBuffer;
        this.c = n10;
        this.d = a$g;
    }

    public void subscribe(b0 b02) {
        Object object = this.a;
        Object object2 = o.a(b02);
        object = (d)((z)object).i((g0)object2);
        b02.setDisposable((b)object);
        object = this.e;
        object2 = this.b;
        int n10 = this.c;
        object = ((a)object).f((ByteBuffer)object2, n10);
        object2 = this.e;
        a$g a$g = this.d;
        try {
            ((a)object2).h((byte[])object, a$g);
        }
        catch (Throwable throwable) {
            b02.onError(throwable);
        }
    }
}

