/*
 * Decompiled with CFR 0.151.
 */
package i.a.b;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class d {
    private final int a;
    private final d b;
    private Map c;
    private d d;
    private Set e;

    public d() {
        this(0);
    }

    public d(int n10) {
        Object object = new HashMap();
        this.c = object;
        object = null;
        this.d = null;
        this.e = null;
        this.a = n10;
        if (n10 == 0) {
            object = this;
        }
        this.b = object;
    }

    private d j(Character object, boolean bl2) {
        d d10;
        Map map = this.c;
        object = (d)map.get(object);
        if (!bl2 && object == null && (d10 = this.b) != null) {
            object = d10;
        }
        return object;
    }

    public void a(String string2) {
        TreeSet treeSet = this.e;
        if (treeSet == null) {
            this.e = treeSet = new TreeSet();
        }
        this.e.add(string2);
    }

    public void b(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            this.a(string2);
        }
    }

    public d c(Character c10) {
        d d10 = this.k(c10);
        if (d10 == null) {
            int n10 = this.a + 1;
            d10 = new d(n10);
            Map map = this.c;
            map.put(c10, d10);
        }
        return d10;
    }

    public Collection d() {
        Collection<Object> collection = this.e;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        return collection;
    }

    public d e() {
        return this.d;
    }

    public int f() {
        return this.a;
    }

    public Collection g() {
        return this.c.values();
    }

    public Collection h() {
        return this.c.keySet();
    }

    public d i(Character c10) {
        return this.j(c10, false);
    }

    public d k(Character c10) {
        return this.j(c10, true);
    }

    public void l(d d10) {
        this.d = d10;
    }
}

