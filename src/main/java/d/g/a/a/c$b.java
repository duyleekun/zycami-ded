/*
 * Decompiled with CFR 0.151.
 */
package d.g.a.a;

import d.g.a.a.b;
import d.g.a.a.c$a;
import d.g.a.a.h;
import d.g.a.a.k;
import java.util.ArrayList;
import java.util.List;

public final class c$b {
    public k a;
    public List b;

    private c$b(List object) {
        if (object != null) {
            ArrayList arrayList;
            this.b = arrayList = new ArrayList(object);
        }
        this.a = object = new b();
    }

    public /* synthetic */ c$b(List list, c$a c$a) {
        this(list);
    }

    public List a() {
        return this.b;
    }

    public k b() {
        return this.a;
    }

    public boolean c() {
        boolean bl2;
        Object object = this.a();
        if (object != null && (object = this.b()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public c$b d(h h10) {
        if (h10 != null) {
            List<h> list = this.b;
            if (list == null) {
                list = new List<h>();
                this.b = list;
                list.add(h10);
            } else {
                boolean bl2 = list.contains(h10);
                if (!bl2) {
                    list = this.b;
                    list.add(h10);
                }
            }
        }
        return this;
    }
}

