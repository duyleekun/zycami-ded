/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.p.j;
import j$.time.p.k;
import j$.time.q.h;
import j$.time.q.o;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.y;
import j$.time.q.z;

final class l
extends o {
    public boolean L(s object) {
        boolean bl2;
        Object object2 = h.B;
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
        long l11 = this.o(r10);
        this.x().b(l10, this);
        h h10 = h.B;
        long l12 = r10.h(h10);
        l10 = (l10 - l11) * (long)3 + l12;
        return r10.c(h10, l10);
    }

    public long o(s object) {
        boolean bl2 = this.L((s)object);
        if (bl2) {
            h h10 = h.B;
            return (object.h(h10) + (long)2) / (long)3;
        }
        object = new y("Unsupported field: QuarterOfYear");
        throw object;
    }

    public String toString() {
        return "QuarterOfYear";
    }

    public z x() {
        return z.i(1L, 4);
    }
}

