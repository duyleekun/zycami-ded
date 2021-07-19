/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.p.j;
import j$.time.q.h;
import j$.time.q.o;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.y;
import j$.time.q.z;

final class k
extends o {
    public z D(s object) {
        boolean bl2 = this.L((s)object);
        if (bl2) {
            long l10;
            Enum enum_ = o.b;
            long l11 = object.h((u)((Object)enum_));
            long l12 = 1L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            long l14 = 91;
            if (l13 == false) {
                object = j$.time.p.k.a;
                enum_ = h.E;
                l11 = object.h((u)((Object)enum_));
                boolean bl3 = ((j$.time.p.k)object).y(l11);
                if (bl3) {
                    object = z.i(l12, l14);
                } else {
                    l11 = 90;
                    object = z.i(l12, l11);
                }
                return object;
            }
            long l15 = 2;
            long l16 = l11 - l15;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 == false) {
                return z.i(l12, l14);
            }
            long l17 = 3;
            long l18 = l11 - l17;
            object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object2 != false && (object2 = (l10 = l11 - (l17 = (long)4)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                return this.x();
            }
            return z.i(l12, 92);
        }
        object = new y("Unsupported field: DayOfQuarter");
        throw object;
    }

    public boolean L(s object) {
        boolean bl2;
        Object object2 = h.x;
        boolean bl3 = object.g((u)object2);
        if (bl3 && (bl3 = object.g((u)(object2 = h.B))) && (bl3 = object.g((u)(object2 = h.E))) && (bl2 = (object = j.A((s)object)).equals(object2 = j$.time.p.k.a))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public r n(r r10, long l10) {
        long l11 = this.o(r10);
        this.x().b(l10, this);
        h h10 = h.x;
        long l12 = r10.h(h10);
        l10 = l10 - l11 + l12;
        return r10.c(h10, l10);
    }

    public long o(s object) {
        int n10 = this.L((s)object);
        if (n10 != 0) {
            h h10 = h.x;
            n10 = object.k(h10);
            h h11 = h.B;
            int n11 = object.k(h11);
            h h12 = h.E;
            long l10 = object.h(h12);
            object = o.O();
            n11 = (n11 + -1) / 3;
            j$.time.p.k k10 = j$.time.p.k.a;
            int n12 = k10.y(l10);
            if (n12 != 0) {
                n12 = 4;
            } else {
                n12 = 0;
                h12 = null;
            }
            Object object2 = object[n11 += n12];
            return n10 - object2;
        }
        object = new y("Unsupported field: DayOfQuarter");
        throw object;
    }

    public String toString() {
        return "DayOfQuarter";
    }

    public z x() {
        return z.j(1L, 90, 92);
    }
}

