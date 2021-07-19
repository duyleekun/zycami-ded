/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.e.a.a.a.a;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.e;
import j$.time.k;
import j$.time.l;
import j$.time.p.d;
import j$.time.p.g;
import j$.time.p.h;
import j$.time.p.j;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.x;
import j$.time.r.c;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

final class i
implements g,
Serializable {
    private final transient j$.time.p.e a;
    private final transient l b;
    private final transient k c;

    private i(j$.time.p.e e10, l l10, k k10) {
        Objects.requireNonNull(e10, "dateTime");
        this.a = e10;
        Objects.requireNonNull(l10, "offset");
        this.b = l10;
        this.c = k10;
    }

    static i m(j object, r r10) {
        Object object2 = (r10 = (i)r10).f();
        boolean bl2 = object.equals(object2);
        if (bl2) {
            return r10;
        }
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("Chronology mismatch, required: ");
        object = object.q();
        stringBuilder.append((String)object);
        stringBuilder.append(", actual: ");
        object = r10.f().q();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new ClassCastException((String)object);
        throw object2;
    }

    static i n(j comparable, Instant r10, k k10) {
        l l10 = k10.m().d((Instant)r10);
        Objects.requireNonNull(l10, "offset");
        long l11 = r10.x();
        int n10 = r10.C();
        r10 = e.Q(l11, n10, l10);
        comparable = (j$.time.p.e)comparable.I(r10);
        r10 = new i((j$.time.p.e)comparable, l10, k10);
        return r10;
    }

    public k J() {
        return this.c;
    }

    public g a(long l10, x x10) {
        boolean bl2 = x10 instanceof j$.time.q.i;
        if (bl2) {
            r r10 = this.a.o(l10, x10);
            j j10 = this.f();
            r10 = r10.e(this);
            return i.m(j10, r10);
        }
        j j11 = this.f();
        r r11 = x10.n(this, l10);
        return i.m(j11, r11);
    }

    public g c(u object, long l10) {
        block2: {
            block3: {
                Object object2;
                block4: {
                    Object object3;
                    block6: {
                        k k10;
                        block9: {
                            List list;
                            block7: {
                                boolean bl2;
                                block8: {
                                    int n10;
                                    Object object4;
                                    block5: {
                                        bl2 = object instanceof j$.time.q.h;
                                        if (!bl2) break block2;
                                        object2 = object;
                                        object2 = (j$.time.q.h)object;
                                        object4 = h.a;
                                        n10 = ((Enum)object2).ordinal();
                                        int n11 = object4[n10];
                                        if (n11 == (n10 = 1)) break block3;
                                        int n12 = 2;
                                        if (n11 == n12) break block4;
                                        object = this.a.Q((u)object, l10);
                                        k10 = this.c;
                                        object3 = this.b;
                                        object2 = "zone";
                                        Objects.requireNonNull(k10, (String)object2);
                                        bl2 = k10 instanceof l;
                                        if (!bl2) break block5;
                                        object2 = k10;
                                        object2 = (l)k10;
                                        object3 = new i((j$.time.p.e)object, (l)object2, k10);
                                        break block6;
                                    }
                                    object2 = k10.m();
                                    list = ((c)object2).g((e)(object4 = (Object)e.n((s)object)));
                                    int n13 = list.size();
                                    if (n13 == n10) break block7;
                                    n10 = list.size();
                                    if (n10 != 0) break block8;
                                    object3 = ((c)object2).f((e)object4);
                                    object2 = ((j$.time.r.a)object3).o();
                                    long l11 = ((Duration)object2).getSeconds();
                                    object = ((j$.time.p.e)object).D(l11);
                                    object3 = ((j$.time.r.a)object3).C();
                                    break block9;
                                }
                                if (object3 != null && (bl2 = list.contains(object3))) break block9;
                            }
                            object3 = (l)list.get(0);
                        }
                        Objects.requireNonNull(object3, "offset");
                        object3 = object2 = new i((j$.time.p.e)object, (l)object3, k10);
                    }
                    return object3;
                }
                object = l.O(((j$.time.q.h)object2).O(l10));
                Serializable serializable = this.a;
                long l12 = serializable.N((l)object);
                long l13 = serializable.j().C();
                object = Instant.L(l12, l13);
                serializable = this.c;
                return i.n(this.f(), (Instant)object, (k)serializable);
            }
            long l14 = this.H();
            object = j$.time.q.i.e;
            return this.a(l10 -= l14, (x)object);
        }
        j j10 = this.f();
        object = object.n(this, l10);
        return i.m(j10, (r)object);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof g;
        if (bl3) {
            int n10 = this.u((g)(object = (g)object));
            if (n10 != 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof j$.time.q.h;
        if (!(bl3 || u10 != null && (bl2 = u10.L(this)))) {
            bl2 = false;
            u10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = this.b.hashCode();
        n10 ^= n11;
        n11 = Integer.rotateLeft(this.c.hashCode(), 3);
        return n10 ^ n11;
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        Object object = this.a.toString();
        charSequence.append((String)object);
        object = this.b.toString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object = this.b;
        k k10 = this.c;
        if (object != k10) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append('[');
            charSequence = this.c.toString();
            ((StringBuilder)object).append((String)charSequence);
            char c10 = ']';
            ((StringBuilder)object).append(c10);
            charSequence = ((StringBuilder)object).toString();
        }
        return charSequence;
    }

    public d v() {
        return this.a;
    }

    public l z() {
        return this.b;
    }
}

