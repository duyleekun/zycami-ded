/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.e.a.a.a.a;
import j$.time.f;
import j$.time.p.b;
import j$.time.p.c;
import j$.time.p.d;
import j$.time.p.j;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.r;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.x;
import j$.time.q.z;
import java.io.Serializable;
import java.util.Objects;

final class e
implements d,
r,
t,
Serializable {
    private final transient b a;
    private final transient f b;

    private e(b b10, f f10) {
        Objects.requireNonNull(b10, "date");
        Objects.requireNonNull(f10, "time");
        this.a = b10;
        this.b = f10;
    }

    private e C(long l10) {
        b b10 = this.a;
        return this.L(b10, 0L, 0L, 0L, l10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private e L(b b10, long l10, long l11, long l12, long l13) {
        f f10;
        e e10 = this;
        b b11 = b10;
        long l14 = l10 | l11 | l12 | l13;
        long l15 = 0L;
        long l16 = l14 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false) {
            f10 = this.b;
            return e10.O(b11, f10);
        }
        l14 = 86400000000000L;
        l15 = l13 / l14;
        long l17 = 86400L;
        long l18 = l12 / l17 + l15;
        l15 = 1440L;
        long l19 = l11 / l15 + l18;
        l18 = 24;
        long l20 = l10 / l18 + l19;
        l19 = l13 % l14;
        l17 = l12 % l17;
        long l21 = 1000000000L;
        l17 = l17 * l21 + l19;
        l15 = l11 % l15;
        l19 = 60000000000L;
        l15 = l15 * l19 + l17;
        l17 = l10 % l18 * 3600000000000L + l15;
        f f11 = this.b;
        l15 = f11.T();
        l18 = Math.floorDiv(l17 += l15, l14) + l20;
        long l22 = (l14 = Math.floorMod(l17, l14)) - l15;
        Object object2 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
        f10 = object2 == false ? this.b : f.O(l14);
        i i10 = i.i;
        b11 = b11.a(l18, i10);
        return e10.O(b11, f10);
    }

    private e O(r r10, f f10) {
        f f11;
        t t10 = this.a;
        if (t10 == r10 && (f11 = this.b) == f10) {
            return this;
        }
        r10 = c.m(t10.f(), r10);
        t10 = new e((b)r10, f10);
        return t10;
    }

    static e m(j object, r r10) {
        Object object2 = (r10 = (e)r10).f();
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

    static e n(b b10, f f10) {
        e e10 = new e(b10, f10);
        return e10;
    }

    private e x(long l10) {
        b b10 = this.a;
        i i10 = i.i;
        b b11 = b10.a(l10, i10);
        f f10 = this.b;
        return this.O(b11, f10);
    }

    e D(long l10) {
        b b10 = this.a;
        return this.L(b10, 0L, 0L, l10, 0L);
    }

    public e P(t t10) {
        boolean bl2 = t10 instanceof b;
        if (bl2) {
            t10 = (b)t10;
            f f10 = this.b;
            return this.O((r)((Object)t10), f10);
        }
        bl2 = t10 instanceof f;
        if (bl2) {
            b b10 = this.a;
            t10 = (f)t10;
            return this.O(b10, (f)t10);
        }
        bl2 = t10 instanceof e;
        if (bl2) {
            j j10 = this.a.f();
            t10 = (e)t10;
            return e.m(j10, (r)((Object)t10));
        }
        j j11 = this.a.f();
        t10 = (e)t10.e(this);
        return e.m(j11, (r)((Object)t10));
    }

    public e Q(u object, long l10) {
        boolean bl2 = object instanceof h;
        if (bl2) {
            Object object2 = object;
            object2 = (h)object;
            bl2 = ((h)object2).C();
            if (bl2) {
                object2 = this.a;
                object = this.b.V((u)object, l10);
                return this.O((r)object2, (f)object);
            }
            object = this.a.c((u)object, l10);
            f f10 = this.b;
            return this.O((r)object, f10);
        }
        j j10 = this.a.f();
        object = object.n(this, l10);
        return e.m(j10, (r)object);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof d;
        if (bl3) {
            int n10 = this.M((d)(object = (d)object));
            if (n10 != 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof h;
        boolean bl4 = true;
        if (bl3) {
            boolean bl5;
            bl3 = ((h)(u10 = (h)u10)).m();
            if (!bl3 && !(bl5 = ((h)u10).C())) {
                bl4 = false;
            }
            return bl4;
        }
        if (u10 == null || !(bl2 = u10.L(this))) {
            bl4 = false;
        }
        return bl4;
    }

    public long h(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            long l10;
            Object object = u10;
            object = (h)u10;
            bl2 = ((h)object).C();
            if (bl2) {
                object = this.b;
                l10 = ((f)object).h(u10);
            } else {
                object = this.a;
                l10 = object.h(u10);
            }
            return l10;
        }
        return u10.o(this);
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = this.b.hashCode();
        return n10 ^ n11;
    }

    public z i(u object) {
        boolean bl2 = object instanceof h;
        if (bl2) {
            Object object2 = object;
            object2 = (h)object;
            bl2 = ((h)object2).C();
            if (bl2) {
                object2 = this.b;
                object = ((f)object2).i((u)object);
            } else {
                object2 = this.a;
                object = object2.i((u)object);
            }
            return object;
        }
        return object.D(this);
    }

    public f j() {
        return this.b;
    }

    public int k(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            int n10;
            Object object = u10;
            object = (h)u10;
            bl2 = ((h)object).C();
            if (bl2) {
                object = this.b;
                n10 = ((f)object).k(u10);
            } else {
                object = this.a;
                n10 = object.k(u10);
            }
            return n10;
        }
        z z10 = this.i(u10);
        long l10 = this.h(u10);
        return z10.a(l10, u10);
    }

    public b l() {
        return this.a;
    }

    public e o(long l10, x x10) {
        long l11 = l10;
        Object object = x10;
        int n10 = x10 instanceof i;
        if (n10 != 0) {
            Object object2 = x10;
            object2 = (i)x10;
            n10 = ((Enum)object2).ordinal();
            switch (n10) {
                default: {
                    object = this.a.a(l10, x10);
                    object2 = this.b;
                    return this.O((r)object, (f)object2);
                }
                case 6: {
                    long l12 = 256L;
                    long l13 = l10 / l12;
                    e e10 = this.x(l13);
                    long l14 = l10 % l12 * (long)12;
                    b b10 = e10.a;
                    return e10.L(b10, l14, 0L, 0L, 0L);
                }
                case 5: {
                    object2 = this.a;
                    object = this;
                    long l15 = l10;
                    l11 = 0L;
                    long l16 = 0L;
                    return this.L((b)object2, l10, 0L, l11, l16);
                }
                case 4: {
                    object2 = this.a;
                    object = this;
                    l11 = 0L;
                    long l17 = 0L;
                    return this.L((b)object2, 0L, l10, l11, l17);
                }
                case 3: {
                    object2 = this.a;
                    object = this;
                    return this.L((b)object2, 0L, 0L, l10, 0L);
                }
                case 2: {
                    long l18 = 86400000L;
                    long l19 = l10 / l18;
                    e e11 = this.x(l19);
                    l18 = l10 % l18 * 1000000L;
                    return e11.C(l18);
                }
                case 1: {
                    long l20 = 86400000000L;
                    long l21 = l10 / l20;
                    e e12 = this.x(l21);
                    l20 = l10 % l20 * 1000L;
                    return e12.C(l20);
                }
                case 0: 
            }
            return this.C(l10);
        }
        j j10 = this.a.f();
        object = x10.n(this, l10);
        return e.m(j10, (r)object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a.toString();
        stringBuilder.append(string2);
        stringBuilder.append('T');
        string2 = this.b.toString();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

