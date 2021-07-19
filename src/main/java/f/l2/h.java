/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.f0;
import f.l2.g;
import f.l2.g$a;

public class h
implements g {
    private final Comparable a;
    private final Comparable b;

    public h(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "start");
        f0.p(comparable2, "endInclusive");
        this.a = comparable;
        this.b = comparable2;
    }

    public Comparable c() {
        return this.b;
    }

    public boolean contains(Comparable comparable) {
        f0.p(comparable, "value");
        return g$a.a(this, comparable);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        Comparable comparable;
        Object object2;
        boolean bl2 = object instanceof h;
        if (!bl2) return false;
        bl2 = this.isEmpty();
        if (bl2) {
            object2 = object;
            object2 = (h)object;
            bl2 = ((h)object2).isEmpty();
            if (bl2) return true;
        }
        if (!(bl2 = f0.g(object2 = this.getStart(), comparable = ((h)(object = (h)object)).getStart()))) return false;
        object2 = this.c();
        boolean bl3 = f0.g(object2, object = ((h)object).c());
        if (!bl3) return false;
        return true;
    }

    public Comparable getStart() {
        return this.a;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
        } else {
            Comparable comparable = this.getStart();
            n10 = comparable.hashCode() * 31;
            Comparable comparable2 = this.c();
            int n11 = comparable2.hashCode();
            n10 += n11;
        }
        return n10;
    }

    public boolean isEmpty() {
        return g$a.b(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Comparable comparable = this.getStart();
        stringBuilder.append(comparable);
        stringBuilder.append("..");
        comparable = this.c();
        stringBuilder.append(comparable);
        return stringBuilder.toString();
    }
}

