/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.o.a;

import d.v.h.i.a.a$a;
import d.v.v.o.a.b;
import d.v.v.o.a.c$a;
import java.util.List;

public class b$a
implements c$a {
    public final /* synthetic */ long a;
    public final /* synthetic */ long b;
    public final /* synthetic */ b c;

    public b$a(b b10, long l10, long l11) {
        this.c = b10;
        this.a = l10;
        this.b = l11;
    }

    public void a(Exception object) {
        a$a a$a = d.v.v.o.a.b.e(this.c);
        if (a$a != null) {
            a$a = d.v.v.o.a.b.e(this.c);
            String string2 = ((Throwable)object).getMessage();
            a$a.b((Exception)object, string2);
            object = d.v.v.o.a.b.e(this.c);
            object.a();
        }
    }

    public void b(List object) {
        Object object2 = d.v.v.o.a.b.e(this.c);
        if (object2 != null) {
            object2 = this.c;
            a$a a$a = d.v.v.o.a.b.e((b)object2);
            long l10 = this.a;
            long l11 = this.b;
            a$a.c((List)object, l10, l11);
            object = d.v.v.o.a.b.e(this.c);
            object.a();
        }
    }
}

