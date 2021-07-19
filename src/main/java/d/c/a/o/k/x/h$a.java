/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.x;

import java.util.ArrayList;
import java.util.List;

public class h$a {
    public final Object a;
    private List b;
    public h$a c;
    public h$a d = this;

    public h$a() {
        this(null);
    }

    public h$a(Object object) {
        this.c = this;
        this.a = object;
    }

    public void a(Object object) {
        ArrayList arrayList = this.b;
        if (arrayList == null) {
            this.b = arrayList = new ArrayList();
        }
        this.b.add(object);
    }

    public Object b() {
        Object var3_3;
        int n10 = this.c();
        if (n10 > 0) {
            List list = this.b;
            var3_3 = list.remove(n10 += -1);
        } else {
            n10 = 0;
            var3_3 = null;
        }
        return var3_3;
    }

    public int c() {
        int n10;
        List list = this.b;
        if (list != null) {
            n10 = list.size();
        } else {
            n10 = 0;
            list = null;
        }
        return n10;
    }
}

