/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.LocalDate;
import j$.time.c;
import j$.time.format.B;
import j$.time.j;
import j$.time.p.k;
import j$.time.q.b_0;
import j$.time.q.e;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import j$.time.q.y;
import j$.time.q.z;
import java.io.Serializable;

public final class Year
implements r,
t,
Comparable,
Serializable {
    private final int a;

    static {
        j$.time.format.t t10 = new j$.time.format.t();
        h h10 = h.E;
        B b10 = B.d;
        t10.p(h10, 4, 10, b10).w();
    }

    private Year(int n10) {
        this.a = n10;
    }

    public static Year of(int n10) {
        Object object = h.E;
        long l10 = n10;
        ((h)object).P(l10);
        object = new Year(n10);
        return object;
    }

    public LocalDate atDay(int n10) {
        return LocalDate.O(this.a, n10);
    }

    public r b(t t10) {
        return (Year)t10.e(this);
    }

    public int compareTo(Object object) {
        object = (Year)object;
        int n10 = this.a;
        int n11 = ((Year)object).a;
        return n10 - n11;
    }

    public Object d(w w10) {
        w w11 = b_0.a;
        if (w10 == w11) {
            return k.a;
        }
        w11 = e.a;
        if (w10 == w11) {
            return i.l;
        }
        return s.super.d(w10);
    }

    public r e(r object) {
        k k10;
        Object object2 = j$.time.p.j.A((s)object);
        boolean bl2 = object2.equals(k10 = k.a);
        if (bl2) {
            object2 = h.E;
            long l10 = this.a;
            return object.c((u)object2, l10);
        }
        object = new c("Adjustment only supported on ISO date-time");
        throw object;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof Year;
        if (n10 != 0) {
            n10 = this.a;
            object = (Year)object;
            int n11 = ((Year)object).a;
            if (n10 != n11) {
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
            h h10 = h.E;
            if (u10 != h10 && u10 != (h10 = h.D) && u10 != (h10 = h.F)) {
                bl4 = false;
            }
            return bl4;
        }
        if (u10 == null || !(bl2 = u10.L(this))) {
            bl4 = false;
        }
        return bl4;
    }

    public long h(u object) {
        int n10 = object instanceof h;
        if (n10 != 0) {
            Object object2 = j.a;
            Object object3 = object;
            object3 = (h)object;
            int n11 = ((Enum)object3).ordinal();
            n10 = object2[n11];
            if (n10 != (n11 = 1)) {
                int n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 == n12) {
                        int n13 = this.a;
                        if (n13 < n11) {
                            n11 = 0;
                            object3 = null;
                        }
                        return n11;
                    }
                    object2 = new y;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Unsupported field: ");
                    ((StringBuilder)object3).append(object);
                    object = ((StringBuilder)object3).toString();
                    object2((String)object);
                    throw object2;
                }
                return this.a;
            }
            int n14 = this.a;
            if (n14 < n11) {
                n14 = 1 - n14;
            }
            return n14;
        }
        return object.o(this);
    }

    public int hashCode() {
        return this.a;
    }

    public z i(u u10) {
        h h10 = h.D;
        if (u10 == h10) {
            int n10 = this.a;
            long l10 = 1L;
            long l11 = n10 <= 0 ? 1000000000L : 999999999L;
            return z.i(l10, l11);
        }
        return s.super.i(u10);
    }

    public int k(u u10) {
        z z10 = this.i(u10);
        long l10 = this.h(u10);
        return z10.a(l10, u10);
    }

    public Year m(long l10, x object) {
        int n10 = object instanceof i;
        if (n10 != 0) {
            x x10 = object;
            x10 = (i)object;
            n10 = ((Enum)((Object)x10)).ordinal();
            switch (n10) {
                default: {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Unsupported unit: ");
                    charSequence.append(object);
                    charSequence = charSequence.toString();
                    y y10 = new y((String)charSequence);
                    throw y10;
                }
                case 14: {
                    object = h.F;
                    l10 = Math.addExact(this.h((u)object), l10);
                    return this.o((u)object, l10);
                }
                case 13: {
                    l10 = j$.c.a(l10, 1000);
                    return this.n(l10);
                }
                case 12: {
                    l10 = j$.c.a(l10, 100);
                    return this.n(l10);
                }
                case 11: {
                    l10 = j$.c.a(l10, 10);
                    return this.n(l10);
                }
                case 10: 
            }
            return this.n(l10);
        }
        return (Year)object.n(this, l10);
    }

    public Year n(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        h h10 = h.E;
        long l13 = (long)this.a + l10;
        return Year.of(h10.O(l13));
    }

    public Year o(u object, long l10) {
        int n10 = object instanceof h;
        if (n10 != 0) {
            u u10 = object;
            u10 = (h)object;
            ((h)u10).P(l10);
            int[] nArray = j.a;
            n10 = ((Enum)((Object)u10)).ordinal();
            n10 = nArray[n10];
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 == n12) {
                        object = h.F;
                        long l11 = this.h((u)object);
                        long l12 = l11 - l10;
                        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                        if (object2 == false) {
                            object = this;
                        } else {
                            object2 = this.a;
                            object = Year.of(n11 -= object2);
                        }
                        return object;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported field: ");
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    y y10 = new y((String)object);
                    throw y10;
                }
                return Year.of((int)l10);
            }
            int n13 = this.a;
            if (n13 < n11) {
                long l13 = 1L;
                l10 = l13 - l10;
            }
            return Year.of((int)l10);
        }
        return (Year)object.n(this, l10);
    }

    public String toString() {
        return Integer.toString(this.a);
    }
}

