/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.e.a.a.a.a;
import j$.time.p.j;
import j$.time.q.B;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.q;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.u;
import j$.time.q.x;
import j$.time.q.z;

class A
implements u {
    private static final z f = z.i(1L, 7);
    private static final z g;
    private static final z h;
    private static final z i;
    private final String a;
    private final B b;
    private final x c;
    private final x d;
    private final z e;

    static {
        long l10 = 0L;
        long l11 = 1L;
        g = z.k(l10, l11, 4, 6);
        h = z.k(l10, l11, 52, 54);
        i = z.j(1L, 52, 53);
    }

    private A(String string2, B b10, x x10, x x11, z z10) {
        this.a = string2;
        this.b = b10;
        this.c = x10;
        this.d = x11;
        this.e = z10;
    }

    private int a(int n10, int n11) {
        return (n11 + -1 + (n10 += 7)) / 7;
    }

    private int b(s s10) {
        int n10 = this.b.d().m();
        h h10 = j$.time.q.h.t;
        return Math.floorMod(s10.k(h10) - n10, 7) + 1;
    }

    private int c(s object) {
        int n10 = this.b((s)object);
        Object object2 = j$.time.q.h.x;
        int n11 = object.k((u)object2);
        n10 = this.k(n11, n10);
        int n12 = this.a(n10, n11);
        if (n12 == 0) {
            object = j.A((s)object).r((s)object);
            long l10 = n11;
            i i10 = j$.time.q.i.i;
            object = object.w(l10, i10);
            return this.c((s)object);
        }
        n11 = 50;
        if (n12 > n11) {
            object = object.i((u)object2);
            long l11 = ((z)object).d();
            int n13 = (int)l11;
            object2 = this.b;
            int n14 = ((B)object2).e() + n13;
            n13 = this.a(n10, n14);
            if (n12 >= n13) {
                n12 = n12 - n13 + 1;
            }
        }
        return n12;
    }

    static A d(B b10) {
        i i10 = j$.time.q.i.i;
        i i11 = j$.time.q.i.j;
        z z10 = f;
        A a10 = new A("DayOfWeek", b10, i10, i11, z10);
        return a10;
    }

    static A e(B b10) {
        x x10 = q.d;
        i i10 = j$.time.q.i.q;
        z z10 = j$.time.q.h.E.x();
        A a10 = new A("WeekBasedYear", b10, x10, i10, z10);
        return a10;
    }

    static A f(B b10) {
        i i10 = j$.time.q.i.j;
        i i11 = j$.time.q.i.k;
        z z10 = g;
        A a10 = new A("WeekOfMonth", b10, i10, i11, z10);
        return a10;
    }

    static A g(B b10) {
        i i10 = j$.time.q.i.j;
        x x10 = q.d;
        z z10 = i;
        A a10 = new A("WeekOfWeekBasedYear", b10, i10, x10, z10);
        return a10;
    }

    static A h(B b10) {
        i i10 = j$.time.q.i.j;
        i i11 = j$.time.q.i.l;
        z z10 = h;
        A a10 = new A("WeekOfYear", b10, i10, i11, z10);
        return a10;
    }

    private z i(s object, u u10) {
        int n10 = this.b((s)object);
        int n11 = object.k(u10);
        n10 = this.k(n11, n10);
        object = object.i(u10);
        int n12 = (int)((z)object).e();
        long l10 = this.a(n10, n12);
        int n13 = (int)((z)object).d();
        long l11 = this.a(n10, n13);
        return z.i(l10, l11);
    }

    private z j(s s10) {
        Object object = j$.time.q.h.x;
        int n10 = s10.g((u)object);
        if (n10 == 0) {
            return h;
        }
        n10 = this.b(s10);
        int n11 = s10.k((u)object);
        n10 = this.k(n11, n10);
        int n12 = this.a(n10, n11);
        if (n12 == 0) {
            s10 = j.A(s10).r(s10);
            long l10 = n11 + 7;
            i i10 = j$.time.q.i.i;
            s10 = s10.w(l10, i10);
            return this.j(s10);
        }
        object = s10.i((u)object);
        long l11 = ((z)object).d();
        int n13 = (int)l11;
        B b10 = this.b;
        int n14 = b10.e() + n13;
        if (n12 >= (n10 = this.a(n10, n14))) {
            s10 = j.A(s10).r(s10);
            long l12 = n13 - n11 + 1 + 7;
            i i11 = j$.time.q.i.i;
            s10 = s10.a(l12, i11);
            return this.j(s10);
        }
        long l13 = n10 + -1;
        return z.i(1L, l13);
    }

    private int k(int n10, int n11) {
        n10 -= n11;
        n11 = 7;
        n10 = Math.floorMod(n10, n11);
        int n12 = -n10;
        int n13 = n10 + 1;
        B b10 = this.b;
        int n14 = b10.e();
        if (n13 > n14) {
            n12 = 7 - n10;
        }
        return n12;
    }

    public boolean C() {
        return false;
    }

    public z D(s object) {
        Object object2 = this.d;
        x x10 = j$.time.q.i.j;
        if (object2 == x10) {
            return this.e;
        }
        x10 = j$.time.q.i.k;
        if (object2 == x10) {
            object2 = j$.time.q.h.w;
            return this.i((s)object, (u)object2);
        }
        x10 = j$.time.q.i.l;
        if (object2 == x10) {
            object2 = j$.time.q.h.x;
            return this.i((s)object, (u)object2);
        }
        x10 = B.h;
        if (object2 == x10) {
            return this.j((s)object);
        }
        object = j$.time.q.i.q;
        if (object2 == object) {
            return j$.time.q.h.E.x();
        }
        object2 = j$.e.a.a.a.a.b("unreachable, rangeUnit: ");
        x10 = this.d;
        ((StringBuilder)object2).append(x10);
        ((StringBuilder)object2).append(", this: ");
        ((StringBuilder)object2).append(this);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public boolean L(s s10) {
        block4: {
            Object object;
            block6: {
                x x10;
                block7: {
                    block5: {
                        object = j$.time.q.h.t;
                        boolean bl2 = s10.g((u)object);
                        if (!bl2) break block4;
                        object = this.d;
                        x10 = j$.time.q.i.j;
                        if (object == x10) {
                            return true;
                        }
                        x10 = j$.time.q.i.k;
                        if (object != x10) break block5;
                        object = j$.time.q.h.w;
                        break block6;
                    }
                    x10 = j$.time.q.i.l;
                    if (object != x10 && object != (x10 = B.h)) break block7;
                    object = j$.time.q.h.x;
                    break block6;
                }
                x10 = j$.time.q.i.q;
                if (object != x10) break block4;
                object = j$.time.q.h.E;
            }
            return s10.g((u)object);
        }
        return false;
    }

    public boolean m() {
        return true;
    }

    public r n(r object, long l10) {
        int n10;
        Object object2 = this.e;
        int n11 = ((z)object2).a(l10, this);
        if (n11 == (n10 = object.k(this))) {
            return object;
        }
        x x10 = this.d;
        i i10 = j$.time.q.i.q;
        if (x10 == i10) {
            object2 = B.a(this.b);
            n11 = object.k((u)object2);
            u u10 = B.b(this.b);
            n10 = object.k(u10);
            object = j.A((s)object);
            int n12 = (int)l10;
            int n13 = 1;
            object = object.B(n12, n13, n13);
            n12 = this.b((s)object);
            n12 = this.k(n13, n12);
            int n14 = object.E();
            int n15 = this.b.e() + n14;
            n14 = this.a(n12, n15) - n13;
            n10 = Math.min(n10, n14);
            n12 = -n12;
            n11 = n11 - n13 + n12;
            l10 = (n10 - n13) * 7 + n11;
            object2 = j$.time.q.i.i;
            return object.a(l10, (x)object2);
        }
        l10 = n11 - n10;
        object2 = this.c;
        return object.a(l10, (x)object2);
    }

    public long o(s object) {
        Object object2;
        Object object3;
        block15: {
            int n10;
            block11: {
                block14: {
                    int n11;
                    block13: {
                        block12: {
                            block10: {
                                object3 = this.d;
                                object2 = j$.time.q.i.j;
                                if (object3 != object2) break block10;
                                n10 = this.b((s)object);
                                break block11;
                            }
                            object2 = j$.time.q.i.k;
                            if (object3 != object2) break block12;
                            int n12 = this.b((s)object);
                            object2 = j$.time.q.h.w;
                            n11 = object.k((u)object2);
                            n12 = this.k(n11, n12);
                            n11 = this.a(n12, n11);
                            break block13;
                        }
                        object2 = j$.time.q.i.l;
                        if (object3 != object2) break block14;
                        int n13 = this.b((s)object);
                        object2 = j$.time.q.h.x;
                        n11 = object.k((u)object2);
                        n13 = this.k(n11, n13);
                        n11 = this.a(n13, n11);
                    }
                    return n11;
                }
                object2 = B.h;
                if (object3 != object2) break block15;
                n10 = this.c((s)object);
            }
            return n10;
        }
        object2 = j$.time.q.i.q;
        if (object3 == object2) {
            int n14 = this.b((s)object);
            object2 = j$.time.q.h.E;
            int n15 = object.k((u)object2);
            Object object4 = j$.time.q.h.x;
            int n16 = object.k((u)object4);
            if ((n16 = this.a(n14 = this.k(n16, n14), n16)) == 0) {
                n15 += -1;
            } else {
                object = object.i((u)object4);
                long l10 = ((z)object).d();
                int n17 = (int)l10;
                object4 = this.b;
                int n18 = ((B)object4).e() + n17;
                n17 = this.a(n14, n18);
                if (n16 >= n17) {
                    ++n15;
                }
            }
            return n15;
        }
        object3 = j$.e.a.a.a.a.b("unreachable, rangeUnit: ");
        object2 = this.d;
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append(", this: ");
        ((StringBuilder)object3).append(this);
        object3 = ((StringBuilder)object3).toString();
        object = new IllegalStateException((String)object3);
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append("[");
        string2 = this.b.toString();
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public z x() {
        return this.e;
    }
}

