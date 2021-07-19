/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.b.b;

import com.quvideo.mobile.external.platform.log.OooO00o;
import d.o.a.a.b.b.a;
import d.o.a.a.b.b.b;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.u;
import g.u$a;

public class b$a
implements u {
    public final /* synthetic */ b b;

    public b$a(b b10) {
        this.b = b10;
    }

    public c0 intercept(u$a u$a) {
        String string2;
        Object object;
        Object object2 = u$a.C();
        boolean bl2 = a.f;
        if (bl2) {
            object = "QuVideoHttpCore";
            string2 = "->headerInterceptor";
            OooO00o.OooO00o((String)object, string2);
        }
        if (bl2 = (string2 = "POST").equals(object = ((a0)object2).m())) {
            object = u$a.C().n();
            string2 = ((a0)object2).m();
            object2 = ((a0)object2).f();
            object2 = ((a0$a)object).p(string2, (b0)object2);
            object = this.b;
            d.o.a.a.b.b.b.c((b)object, (a0$a)object2);
            object2 = ((a0$a)object2).b();
        }
        return u$a.c((a0)object2);
    }
}

