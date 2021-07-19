/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import d.v.e0.ne.p0;
import d.v.e0.ne.p0$a$a;
import d.v.y.c.r0;
import e.a.b0;
import e.a.c0;

public class p0$a
implements c0 {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ p0 b;

    public p0$a(p0 p02, r0 r02) {
        this.b = p02;
        this.a = r02;
    }

    public void subscribe(b0 b02) {
        p0 p02 = this.b;
        r0 r02 = this.a;
        p0$a$a p0$a$a = new p0$a$a(this, b02);
        p0.e(p02, r02, p0$a$a);
    }
}

