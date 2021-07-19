/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.LocalDate;
import j$.time.p.j;
import j$.time.p.k;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.o;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.y;
import j$.time.q.z;

final class m
extends o {
    public z D(s object) {
        boolean bl2 = this.L((s)object);
        if (bl2) {
            return o.P(LocalDate.n((s)object));
        }
        object = new y("Unsupported field: WeekOfWeekBasedYear");
        throw object;
    }

    public boolean L(s object) {
        boolean bl2;
        Object object2 = h.y;
        boolean bl3 = object.g((u)object2);
        if (bl3 && (bl2 = (object = j.A((s)object)).equals(object2 = k.a))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public r n(r r10, long l10) {
        this.x().b(l10, this);
        long l11 = this.o(r10);
        l10 = Math.subtractExact(l10, l11);
        i i10 = i.j;
        return r10.a(l10, i10);
    }

    public long o(s object) {
        boolean bl2 = this.L((s)object);
        if (bl2) {
            return o.Q(LocalDate.n((s)object));
        }
        object = new y("Unsupported field: WeekOfWeekBasedYear");
        throw object;
    }

    public String toString() {
        return "WeekOfWeekBasedYear";
    }

    public z x() {
        return z.j(1L, 52, 53);
    }
}

