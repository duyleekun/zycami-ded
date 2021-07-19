/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.i;

import d.r.a.i.l;
import d.r.a.i.l$a;
import d.r.a.i.l$b;
import d.r.a.u.s;

public final class l$a$a
implements l$b {
    public final /* synthetic */ l$a a;

    public l$a$a(l$a l$a) {
        this.a = l$a;
    }

    public final void a() {
        Object object = this.a;
        l l10 = ((l$a)object).d;
        object = ((l$a)object).b;
        l.e(l10, (String)object);
    }

    public final void b() {
        Object object = new StringBuilder("pkg name : ");
        Object object2 = l.l(this.a.d).getPackageName();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" \u901a\u77e5\u5c55\u793a\u5931\u8d25");
        object = ((StringBuilder)object).toString();
        s.h("OnNotificationArrivedTask", (String)object);
        s.j(l.m(this.a.d), "\u7cfb\u7edf\u9519\u8bef\u5bfc\u81f4\u901a\u77e5\u5c55\u793a\u5931\u8d25");
        object = this.a;
        object2 = ((l$a)object).d;
        object = ((l$a)object).b;
        l.f((l)object2, (String)object, 2119);
    }
}

