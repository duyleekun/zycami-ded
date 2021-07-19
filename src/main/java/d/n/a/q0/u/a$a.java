/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import d.n.a.q0.u.a;
import d.n.a.q0.u.a$g;
import java.nio.ByteBuffer;

public class a$a
implements a$g {
    public final /* synthetic */ ByteBuffer a;
    public final /* synthetic */ int b;
    public final /* synthetic */ a c;

    public a$a(a a10, ByteBuffer byteBuffer, int n10) {
        this.c = a10;
        this.a = byteBuffer;
        this.b = n10;
    }

    public int get() {
        float f10 = this.a.position();
        float f11 = this.b;
        return (int)Math.ceil(f10 / f11) + -1;
    }
}

