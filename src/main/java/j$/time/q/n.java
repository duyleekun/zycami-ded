/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.LocalDate;
import j$.time.p.j;
import j$.time.p.k;
import j$.time.q.h;
import j$.time.q.o;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.y;
import j$.time.q.z;

final class n
extends o {
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

    public r n(r object, long l10) {
        int n10 = this.L((s)object);
        if (n10 != 0) {
            Object object2 = this.x();
            o o10 = o.d;
            int n11 = ((z)object2).a(l10, o10);
            LocalDate localDate = LocalDate.n((s)object);
            object2 = h.t;
            int n12 = localDate.k((u)object2);
            int n13 = o.Q(localDate);
            int n14 = 53;
            int n15 = 52;
            if (n13 == n14 && (n14 = o.S(n11)) == n15) {
                n13 = n15;
            }
            n15 = 1;
            LocalDate localDate2 = LocalDate.D(n11, n15, 4);
            n10 = localDate2.k((u)object2);
            long l11 = (n13 - n15) * 7 + (n12 -= n10);
            localDate2 = localDate2.Q(l11);
            return object.b(localDate2);
        }
        object = new y("Unsupported field: WeekBasedYear");
        throw object;
    }

    public long o(s object) {
        boolean bl2 = this.L((s)object);
        if (bl2) {
            return o.R(LocalDate.n((s)object));
        }
        object = new y("Unsupported field: WeekBasedYear");
        throw object;
    }

    public String toString() {
        return "WeekBasedYear";
    }

    public z x() {
        return h.E.x();
    }
}

