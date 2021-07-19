/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.x;

import d.v.c.y1.f.q;
import d.v.c.y1.f.x.g0$a;
import java.util.List;
import java.util.function.Consumer;

public final class k
implements Consumer {
    public final /* synthetic */ List a;
    public final /* synthetic */ List b;

    public /* synthetic */ k(List list, List list2) {
        this.a = list;
        this.b = list2;
    }

    public final void accept(Object object) {
        List list = this.a;
        List list2 = this.b;
        object = (q)object;
        g0$a.a(list, list2, (q)object);
    }
}

