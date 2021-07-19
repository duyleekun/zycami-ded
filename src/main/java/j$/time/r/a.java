/*
 * Decompiled with CFR 0.151.
 */
package j$.time.r;

import j$.time.Duration;
import j$.time.Instant;
import j$.time.e;
import j$.time.l;
import j$.time.q.s;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class a
implements Comparable,
Serializable {
    private final e a;
    private final l b;
    private final l c;

    a(long l10, l l11, l l12) {
        e e10;
        this.a = e10 = e.Q(l10, 0, l11);
        this.b = l11;
        this.c = l12;
    }

    a(e e10, l l10, l l11) {
        this.a = e10;
        this.b = l10;
        this.c = l11;
    }

    public l C() {
        return this.c;
    }

    public l D() {
        return this.b;
    }

    public long H() {
        e e10 = this.a;
        l l10 = this.b;
        return e10.N(l10);
    }

    List L() {
        boolean bl2 = this.O();
        if (bl2) {
            return Collections.emptyList();
        }
        l l10 = this.b;
        l10 = this.c;
        l[] lArray = new l[]{l10, l10};
        return Arrays.asList(lArray);
    }

    public boolean O() {
        l l10;
        int n10;
        l l11 = this.c;
        int n11 = l11.C();
        if (n11 > (n10 = (l10 = this.b).C())) {
            n11 = 1;
        } else {
            n11 = 0;
            l11 = null;
        }
        return n11 != 0;
    }

    public int compareTo(Object object) {
        object = (a)object;
        Instant instant = this.x();
        object = ((a)object).x();
        return instant.m((Instant)object);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof a;
        if (bl3) {
            boolean bl4;
            object = (a)object;
            s s10 = this.a;
            s s11 = ((a)object).a;
            bl3 = ((e)s10).equals(s11);
            if (!(bl3 && (bl3 = ((l)(s10 = this.b)).equals(s11 = ((a)object).b)) && (bl4 = ((l)(s10 = this.c)).equals(object = ((a)object).c)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = this.b.hashCode();
        n10 ^= n11;
        n11 = Integer.rotateLeft(this.c.hashCode(), 16);
        return n10 ^ n11;
    }

    public e m() {
        e e10 = this.a;
        int n10 = this.c.C();
        int n11 = this.b.C();
        long l10 = n10 - n11;
        return e10.U(l10);
    }

    public e n() {
        return this.a;
    }

    public Duration o() {
        int n10 = this.c.C();
        int n11 = this.b.C();
        return Duration.o(n10 - n11);
    }

    public String toString() {
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("Transition[");
        boolean bl2 = this.O();
        Object object = bl2 ? "Gap" : "Overlap";
        stringBuilder.append((String)object);
        stringBuilder.append(" at ");
        object = this.a;
        stringBuilder.append(object);
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(" to ");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public Instant x() {
        e e10 = this.a;
        l l10 = this.b;
        long l11 = e10.N(l10);
        long l12 = e10.j().C();
        return Instant.L(l11, l12);
    }
}

