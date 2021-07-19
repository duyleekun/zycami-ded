/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import androidx.core.util.Pools$Pool;
import d.c.a.o.k.i$b;
import d.c.a.o.k.j;
import d.c.a.o.k.k;
import d.c.a.o.k.n$a;
import d.c.a.o.k.z.a;
import d.c.a.u.o.a$d;

public class i$b$a
implements a$d {
    public final /* synthetic */ i$b a;

    public i$b$a(i$b i$b) {
        this.a = i$b;
    }

    public j a() {
        j j10;
        Object object = this.a;
        a a10 = ((i$b)object).a;
        a a11 = ((i$b)object).b;
        a a12 = ((i$b)object).c;
        a a13 = ((i$b)object).d;
        k k10 = ((i$b)object).e;
        n$a n$a = ((i$b)object).f;
        Pools$Pool pools$Pool = ((i$b)object).g;
        object = j10;
        j10 = new j(a10, a11, a12, a13, k10, n$a, pools$Pool);
        return j10;
    }
}

