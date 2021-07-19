/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b2.w.l;

import d.v.c.b2.w.l.b;
import d.v.c.b2.w.l.c$a;
import d.v.c.b2.x.d;
import d.v.h.i.a.a$a;
import java.util.ArrayList;
import java.util.List;

public class c
implements b {
    private String a;
    private long b;
    private long c;
    private int d;
    private d.v.v.o.a.b e;
    private List f;
    private d g;
    private boolean h;

    public c(String string2, long l10, long l11, int n10) {
        ArrayList arrayList;
        this.f = arrayList = new ArrayList();
        this.a = string2;
        this.b = l10;
        this.c = l11;
        this.d = n10;
    }

    public static /* synthetic */ List a(c c10) {
        return c10.f;
    }

    public static /* synthetic */ List g(c c10, List list) {
        c10.f = list;
        return list;
    }

    public static /* synthetic */ d h(c c10) {
        return c10.g;
    }

    public static /* synthetic */ String i(c c10) {
        return c10.a;
    }

    public static /* synthetic */ boolean j(c c10, boolean bl2) {
        c10.h = bl2;
        return bl2;
    }

    private void l(String object, long l10, long l11, int n10) {
        boolean bl2 = this.h;
        if (bl2) {
            return;
        }
        this.h = true;
        Object object2 = new d.v.v.o.a.b();
        this.e = object2;
        ((d.v.v.o.a.b)object2).a((String)object);
        object = this.e;
        object2 = new c$a(this);
        ((d.v.v.o.a.b)object).c((a$a)object2);
        this.e.b(l10, l11, n10);
    }

    public void b() {
        d.v.v.o.a.b b10 = this.e;
        if (b10 != null) {
            b10.release();
        }
    }

    public boolean f() {
        return d.v.j.b.f(this.f) ^ true;
    }

    public List m() {
        boolean bl2 = this.f();
        if (!bl2) {
            String string2 = this.a;
            long l10 = this.b;
            long l11 = this.c;
            int n10 = this.d;
            this.l(string2, l10, l11, n10);
        }
        return this.f;
    }

    public void n(d d10) {
        this.g = d10;
    }

    public void o(int n10) {
        this.d = n10;
    }
}

