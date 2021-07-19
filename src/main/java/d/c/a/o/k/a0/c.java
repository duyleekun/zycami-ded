/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.a0;

import d.c.a.o.k.a0.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    private final Map a;
    private final List b;
    private int c;
    private int d;

    public c(Map object) {
        int n10;
        this.a = object;
        Set set = object.keySet();
        Serializable serializable = new ArrayList(set);
        this.b = serializable;
        object = object.values().iterator();
        while ((n10 = object.hasNext()) != 0) {
            serializable = (Integer)object.next();
            int n11 = this.c;
            n10 = (Integer)serializable;
            this.c = n11 += n10;
        }
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        int n10 = this.c;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public d c() {
        Object object;
        int n10;
        Object object2 = this.b;
        int n11 = this.d;
        Object object3 = (Integer)this.a.get(object2 = (d)object2.get(n11));
        int n12 = (Integer)object3;
        if (n12 == (n10 = 1)) {
            this.a.remove(object2);
            object3 = this.b;
            n12 = this.d;
            object3.remove(n12);
        } else {
            object = this.a;
            n11 = (Integer)object3 - n10;
            object3 = n11;
            object.put(object2, object3);
        }
        this.c = n11 = this.c - n10;
        object3 = this.b;
        n11 = (int)(object3.isEmpty() ? 1 : 0);
        if (n11 != 0) {
            n11 = 0;
            object3 = null;
        } else {
            n11 = this.d + n10;
            object = this.b;
            n12 = object.size();
            n11 %= n12;
        }
        this.d = n11;
        return object2;
    }
}

