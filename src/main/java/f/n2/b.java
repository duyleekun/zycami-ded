/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import java.util.HashSet;
import java.util.Iterator;

public final class b
extends f.x1.b {
    private final HashSet c;
    private final Iterator d;
    private final l e;

    public b(Iterator hashSet, l l10) {
        f0.p(hashSet, "source");
        f0.p(l10, "keySelector");
        this.d = hashSet;
        this.e = l10;
        this.c = hashSet = new HashSet();
    }

    public void b() {
        Iterator iterator2;
        boolean bl2;
        while (bl2 = (iterator2 = this.d).hasNext()) {
            HashSet hashSet = this.c;
            iterator2 = this.d.next();
            Object object = this.e.invoke(iterator2);
            boolean bl3 = hashSet.add(object);
            if (!bl3) continue;
            this.e(iterator2);
            return;
        }
        this.c();
    }
}

