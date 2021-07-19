/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a;

import d.j.d.a.b;
import d.j.d.a.k;
import d.j.d.a.l$a;
import d.j.d.a.o.h;

public class l {
    private final h a;

    public l() {
        h h10;
        this.a = h10 = new h();
    }

    public l(b b10) {
        Object object = new h();
        this.a = object;
        object = new l$a(this);
        b10.b((Runnable)object);
    }

    public static /* synthetic */ h a(l l10) {
        return l10.a;
    }

    public k b() {
        return this.a;
    }

    public void c(Exception exception) {
        this.a.z(exception);
    }

    public void d(Object object) {
        this.a.A(object);
    }
}

