/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import l.a.h.a$a;
import l.a.h.c;
import l.a.h.d;

public class a
extends d
implements Map {
    public c m;

    public a() {
    }

    public a(int n10) {
        super(n10);
    }

    public a(d d10) {
        super(d10);
    }

    private c q() {
        c c10 = this.m;
        if (c10 == null) {
            this.m = c10 = new a$a(this);
        }
        return this.m;
    }

    public Set entrySet() {
        return this.q().l();
    }

    public Set keySet() {
        return this.q().m();
    }

    public boolean p(Collection collection) {
        return l.a.h.c.j(this, collection);
    }

    public void putAll(Map object) {
        int n10 = this.c;
        int n11 = object.size();
        this.e(n10 += n11);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            this.put(k10, entry);
        }
    }

    public boolean r(Collection collection) {
        return l.a.h.c.o(this, collection);
    }

    public boolean s(Collection collection) {
        return l.a.h.c.p(this, collection);
    }

    public Collection values() {
        return this.q().n();
    }
}

