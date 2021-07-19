/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ce$h1;
import d.v.e0.ce$h1$a$a;
import d.v.e0.ce$h1$a$b;
import e.a.e0;
import e.a.h0;
import e.a.q0.c.a;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import java.util.List;

public class ce$h1$a
implements o {
    public final /* synthetic */ List a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ce$h1 c;

    public ce$h1$a(ce$h1 ce$h1, List list, int n10) {
        this.c = ce$h1;
        this.a = list;
        this.b = n10;
    }

    public e0 a(byte[] object) {
        int n10;
        Object object2 = this.a;
        int s10 = object2.indexOf(object);
        Object object3 = this.c;
        boolean bl2 = ((ce$h1)object3).b;
        if (bl2) {
            n10 = s10 + 1;
        }
        object3 = ((ce$h1)object3).d;
        short s11 = (short)n10;
        object = ce.n((ce)object3, bl2, s11, (byte[])object);
        object2 = new ce$h1$a$b(this);
        object = ((z)object).H3((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((h0)object2);
        object2 = new ce$h1$a$a(this);
        return ((z)object).f2((g)object2);
    }
}

