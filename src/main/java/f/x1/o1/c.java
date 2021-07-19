/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.h2.t.x0.g;
import f.l2.q;
import f.x1.n;
import f.x1.o1.b;
import f.x1.o1.c$a;
import f.x1.o1.c$b;
import f.x1.o1.c$e;
import f.x1.o1.c$f;
import f.x1.o1.d;
import f.x1.o1.e;
import f.x1.o1.f;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class c
implements Map,
g {
    private static final int m = -1640531527;
    private static final int n = 8;
    private static final int o = 2;
    private static final int p = 255;
    private static final c$a q;
    private int a;
    private int b;
    private e c;
    private f d;
    private d e;
    private boolean f;
    private Object[] g;
    private Object[] h;
    private int[] i;
    private int[] j;
    private int k;
    private int l;

    static {
        c$a c$a;
        q = c$a = new c$a(null);
    }

    public c() {
        this(8);
    }

    public c(int n10) {
        Object[] objectArray = f.x1.o1.b.d(n10);
        int[] nArray = new int[n10];
        int[] nArray2 = new int[c$a.a(q, n10)];
        this(objectArray, null, nArray, nArray2, 2, 0);
    }

    private c(Object[] object, Object[] objectArray, int[] nArray, int[] nArray2, int n10, int n11) {
        int n12;
        this.g = object;
        this.h = objectArray;
        this.i = nArray;
        this.j = nArray2;
        this.k = n10;
        this.l = n11;
        object = q;
        int n13 = this.B();
        this.a = n12 = c$a.b((c$a)object, n13);
    }

    private final int B() {
        return this.j.length;
    }

    private final int F(Object object) {
        int n10;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        int n11 = this.a;
        return (n10 *= -1640531527) >>> n11;
    }

    private final boolean H(Collection object) {
        int n10 = object.isEmpty();
        int n11 = 0;
        if (n10 != 0) {
            return false;
        }
        n10 = object.size();
        this.v(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            n10 = (int)(this.I(entry) ? 1 : 0);
            if (n10 == 0) continue;
            n11 = n10 = 1;
        }
        return n11 != 0;
    }

    private final boolean I(Map.Entry entry) {
        Object k10 = entry.getKey();
        int n10 = this.m(k10);
        Object[] objectArray = this.n();
        int n11 = 1;
        if (n10 >= 0) {
            entry = entry.getValue();
            objectArray[n10] = entry;
            return n11 != 0;
        }
        n10 = -n10 - n11;
        Object object = objectArray[n10];
        Object v10 = entry.getValue();
        boolean bl2 = f0.g(v10, object) ^ n11;
        if (bl2) {
            entry = entry.getValue();
            objectArray[n10] = entry;
            return n11 != 0;
        }
        return false;
    }

    private final boolean J(int n10) {
        Object object = this.g[n10];
        int n11 = this.F(object);
        int n12 = this.k;
        while (true) {
            int[] nArray = this.j;
            int n13 = nArray[n11];
            int n14 = 1;
            if (n13 == 0) {
                nArray[n11] = n12 = n10 + 1;
                this.i[n10] = n11;
                return n14 != 0;
            }
            if ((n12 += -1) < 0) {
                return false;
            }
            int n15 = n11 + -1;
            if (n11 == 0) {
                n11 = this.B() - n14;
                continue;
            }
            n11 = n15;
        }
    }

    private final void K(int n10) {
        Object object;
        int n11 = this.l;
        int n12 = this.size();
        if (n11 > n12) {
            this.q();
        }
        n11 = this.B();
        n12 = 0;
        if (n10 != n11) {
            Object object2 = new int[n10];
            this.j = object2;
            object2 = q;
            this.a = n10 = c$a.b((c$a)object2, n10);
        } else {
            object = this.j;
            n11 = this.B();
            f.x1.n.l2(object, 0, 0, n11);
        }
        while (n12 < (n10 = this.l)) {
            n10 = n12 + 1;
            n11 = (int)(this.J(n12) ? 1 : 0);
            if (n11 != 0) {
                n12 = n10;
                continue;
            }
            object = new IllegalStateException;
            object("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void M(int n10) {
        int n11;
        int n12 = this.k * 2;
        int n13 = this.B() / 2;
        n12 = f.l2.q.u(n12, n13);
        n13 = 0;
        int n14 = n12;
        int n15 = 0;
        int[] nArray = null;
        n12 = n10;
        do {
            int n16 = n10 + -1;
            n10 = n10 == 0 ? this.B() + -1 : n16;
            n16 = this.k;
            if (++n15 > n16) {
                this.j[n12] = 0;
                return;
            }
            int[] nArray2 = this.j;
            int n17 = nArray2[n10];
            if (n17 == 0) {
                nArray2[n12] = 0;
                return;
            }
            n11 = -1;
            if (n17 < 0) {
                nArray2[n12] = n11;
            } else {
                Object[] objectArray = this.g;
                int n18 = n17 + -1;
                Object object = objectArray[n18];
                n16 = this.F(object) - n10;
                int n19 = this.B() + -1;
                if ((n16 &= n19) < n15) continue;
                this.j[n12] = n17;
                nArray = this.i;
                nArray[n18] = n12;
            }
            n12 = n10;
            n15 = 0;
            nArray = null;
        } while ((n14 += n11) >= 0);
        this.j[n12] = n11;
    }

    private final void O(int n10) {
        int n11;
        f.x1.o1.b.f(this.g, n10);
        int n12 = this.i[n10];
        this.M(n12);
        int[] nArray = this.i;
        nArray[n10] = n11 = -1;
        this.b = n10 = this.size() + n11;
    }

    public static final /* synthetic */ Object[] b(c c10) {
        return c10.n();
    }

    public static final /* synthetic */ Object[] c(c c10) {
        return c10.g;
    }

    public static final /* synthetic */ int e(c c10) {
        return c10.l;
    }

    public static final /* synthetic */ int[] f(c c10) {
        return c10.i;
    }

    public static final /* synthetic */ Object[] g(c c10) {
        return c10.h;
    }

    public static final /* synthetic */ void h(c c10, int n10) {
        c10.O(n10);
    }

    public static final /* synthetic */ void i(c c10, Object[] objectArray) {
        c10.g = objectArray;
    }

    public static final /* synthetic */ void j(c c10, int n10) {
        c10.l = n10;
    }

    public static final /* synthetic */ void k(c c10, int[] nArray) {
        c10.i = nArray;
    }

    public static final /* synthetic */ void l(c c10, Object[] objectArray) {
        c10.h = objectArray;
    }

    private final Object[] n() {
        Object[] objectArray = this.h;
        if (objectArray != null) {
            return objectArray;
        }
        objectArray = f.x1.o1.b.d(this.z());
        this.h = objectArray;
        return objectArray;
    }

    private final void q() {
        int n10;
        int n11;
        Object[] objectArray = this.h;
        Object[] objectArray2 = null;
        int n12 = 0;
        for (n11 = 0; n11 < (n10 = this.l); ++n11) {
            int n13;
            Object object = this.i;
            n10 = object[n11];
            if (n10 < 0) continue;
            object = this.g;
            object[n12] = n13 = object[n11];
            if (objectArray != null) {
                object = objectArray[n11];
                objectArray[n12] = object;
            }
            ++n12;
        }
        objectArray2 = this.g;
        f.x1.o1.b.g(objectArray2, n12, n10);
        if (objectArray != null) {
            n11 = this.l;
            f.x1.o1.b.g(objectArray, n12, n11);
        }
        this.l = n12;
    }

    private final boolean t(Map object) {
        boolean bl2;
        int n10;
        int n11 = this.size();
        if (n11 == (n10 = object.size()) && (bl2 = this.r((Collection)(object = object.entrySet())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private final void u(int n10) {
        int n11 = this.z();
        if (n10 > n11) {
            n11 = this.z() * 3 / 2;
            if (n10 <= n11) {
                n10 = n11;
            }
            Object object = f.x1.o1.b.e(this.g, n10);
            this.g = object;
            object = this.h;
            if (object != null) {
                object = f.x1.o1.b.e(object, n10);
            } else {
                n11 = 0;
                object = null;
            }
            this.h = object;
            object = Arrays.copyOf(this.i, n10);
            String string2 = "java.util.Arrays.copyOf(this, newSize)";
            f0.o(object, string2);
            this.i = (int[])object;
            object = q;
            n10 = c$a.a((c$a)object, n10);
            n11 = this.B();
            if (n10 > n11) {
                this.K(n10);
            }
        } else {
            n11 = this.l + n10;
            n10 = this.size();
            if ((n11 -= n10) > (n10 = this.z())) {
                n10 = this.B();
                this.K(n10);
            }
        }
    }

    private final void v(int n10) {
        int n11 = this.l + n10;
        this.u(n11);
    }

    private final int x(Object object) {
        int n10 = this.F(object);
        int n11 = this.k;
        while (true) {
            int[] nArray = this.j;
            int n12 = nArray[n10];
            int n13 = -1;
            if (n12 == 0) {
                return n13;
            }
            if (n12 > 0) {
                Object object2 = this.g;
                boolean bl2 = f0.g(object2 = object2[n12 += -1], object);
                if (bl2) {
                    return n12;
                }
            }
            if ((n11 += n13) < 0) {
                return n13;
            }
            n12 = n10 + -1;
            if (n10 == 0) {
                n10 = this.B() + -1;
                continue;
            }
            n10 = n12;
        }
    }

    private final int y(Object object) {
        int n10;
        int n11 = this.l;
        while ((n11 += (n10 = -1)) >= 0) {
            Object object2 = this.i;
            n10 = object2[n11];
            if (n10 < 0) continue;
            object2 = this.h;
            f0.m(object2);
            n10 = (int)(f0.g(object2 = (Object)object2[n11], object) ? 1 : 0);
            if (n10 == 0) continue;
            return n11;
        }
        return n10;
    }

    private final int z() {
        return this.g.length;
    }

    public Set A() {
        d d10 = this.e;
        if (d10 == null) {
            this.e = d10 = new d(this);
        }
        return d10;
    }

    public Set C() {
        e e10 = this.c;
        if (e10 == null) {
            this.c = e10 = new e(this);
        }
        return e10;
    }

    public int D() {
        return this.b;
    }

    public Collection E() {
        f f10 = this.d;
        if (f10 == null) {
            this.d = f10 = new f(this);
        }
        return f10;
    }

    public final c$e G() {
        c$e c$e = new c$e(this);
        return c$e;
    }

    public final boolean L(Map.Entry entry) {
        f0.p(entry, "entry");
        this.p();
        Object k10 = entry.getKey();
        int n10 = this.x(k10);
        if (n10 < 0) {
            return false;
        }
        Object object = this.h;
        f0.m(object);
        object = object[n10];
        entry = entry.getValue();
        boolean bl2 = f0.g(object, entry);
        boolean bl3 = true;
        if (bl2 ^= bl3) {
            return false;
        }
        this.O(n10);
        return bl3;
    }

    public final int N(Object object) {
        this.p();
        int n10 = this.x(object);
        if (n10 < 0) {
            return -1;
        }
        this.O(n10);
        return n10;
    }

    public final boolean P(Object object) {
        this.p();
        int n10 = this.y(object);
        if (n10 < 0) {
            return false;
        }
        this.O(n10);
        return true;
    }

    public final c$f Q() {
        c$f c$f = new c$f(this);
        return c$f;
    }

    public void clear() {
        int n10;
        this.p();
        int n11 = this.l + -1;
        if (n11 >= 0) {
            n10 = 0;
            while (true) {
                int[] nArray;
                int n12;
                if ((n12 = (nArray = this.i)[n10]) >= 0) {
                    int[] nArray2 = this.j;
                    nArray2[n12] = 0;
                    nArray[n10] = n12 = -1;
                }
                if (n10 == n11) break;
                ++n10;
            }
        }
        Object[] objectArray = this.g;
        n10 = this.l;
        f.x1.o1.b.g(objectArray, 0, n10);
        objectArray = this.h;
        if (objectArray != null) {
            n10 = this.l;
            f.x1.o1.b.g(objectArray, 0, n10);
        }
        this.b = 0;
        this.l = 0;
    }

    public boolean containsKey(Object object) {
        int n10 = this.x(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean containsValue(Object object) {
        int n10 = this.y(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        if (!(object == this || (bl3 = object instanceof Map) && (bl2 = this.t((Map)(object = (Map)object))))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object get(Object object) {
        int n10 = this.x(object);
        if (n10 < 0) {
            return null;
        }
        Object[] objectArray = this.h;
        f0.m(objectArray);
        return objectArray[n10];
    }

    public int hashCode() {
        int n10;
        c$b c$b = this.w();
        int n11 = 0;
        while ((n10 = c$b.hasNext()) != 0) {
            n10 = c$b.k();
            n11 += n10;
        }
        return n11;
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public final int m(Object object) {
        this.p();
        block0: while (true) {
            int n10 = this.F(object);
            int n11 = this.k * 2;
            int n12 = this.B() / 2;
            n11 = f.l2.q.u(n11, n12);
            n12 = 0;
            while (true) {
                Object object2;
                int[] nArray = this.j;
                int n13 = nArray[n10];
                int n14 = 1;
                if (n13 <= 0) {
                    int n15;
                    n11 = this.l;
                    n13 = this.z();
                    if (n11 >= n13) {
                        this.v(n14);
                        continue block0;
                    }
                    n11 = this.l;
                    this.l = n13 = n11 + 1;
                    object2 = this.g;
                    object2[n11] = object;
                    this.i[n11] = n10;
                    object = this.j;
                    object[n10] = n13;
                    this.b = n15 = this.size() + n14;
                    n15 = this.k;
                    if (n12 > n15) {
                        this.k = n12;
                    }
                    return n11;
                }
                object2 = this.g;
                int n16 = n13 + -1;
                boolean bl2 = f0.g(object2 = object2[n16], object);
                if (bl2) {
                    return -n13;
                }
                if (++n12 > n11) {
                    n10 = this.B() * 2;
                    this.K(n10);
                    continue block0;
                }
                n13 = n10 + -1;
                if (n10 == 0) {
                    n10 = this.B() - n14;
                    continue;
                }
                n10 = n13;
            }
            break;
        }
    }

    public final Map o() {
        this.p();
        this.f = true;
        return this;
    }

    public final void p() {
        boolean bl2 = this.f;
        if (!bl2) {
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Object put(Object object, Object object2) {
        this.p();
        int n10 = this.m(object);
        Object[] objectArray = this.n();
        if (n10 < 0) {
            n10 = -n10 + -1;
            Object object3 = objectArray[n10];
            objectArray[n10] = object2;
            return object3;
        }
        objectArray[n10] = object2;
        return null;
    }

    public void putAll(Map object) {
        f0.p(object, "from");
        this.p();
        object = object.entrySet();
        this.H((Collection)object);
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean r(Collection iterator2) {
        boolean bl2;
        Object object = "m";
        f0.p(iterator2, (String)object);
        iterator2 = iterator2.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = iterator2.next();
            if (object != null) {
                object = (Map.Entry)object;
                bl2 = this.s((Map.Entry)object);
                if (bl2) continue;
            }
            return false;
        }
        return true;
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public Object remove(Object object) {
        int n10 = this.N(object);
        if (n10 < 0) {
            return null;
        }
        Object[] objectArray = this.h;
        f0.m(objectArray);
        Object object2 = objectArray[n10];
        f.x1.o1.b.f(objectArray, n10);
        return object2;
    }

    public final boolean s(Map.Entry entry) {
        f0.p(entry, "entry");
        Object object = entry.getKey();
        int n10 = this.x(object);
        if (n10 < 0) {
            return false;
        }
        Object[] objectArray = this.h;
        f0.m(objectArray);
        object = objectArray[n10];
        entry = entry.getValue();
        return f0.g(object, entry);
    }

    public String toString() {
        boolean bl2;
        int n10 = this.size() * 3 + 2;
        CharSequence charSequence = new StringBuilder(n10);
        charSequence.append("{");
        c$b c$b = this.w();
        int n11 = 0;
        while (bl2 = c$b.hasNext()) {
            if (n11 > 0) {
                String string2 = ", ";
                charSequence.append(string2);
            }
            c$b.j((StringBuilder)charSequence);
            ++n11;
        }
        charSequence.append("}");
        charSequence = charSequence.toString();
        f0.o(charSequence, "sb.toString()");
        return charSequence;
    }

    public final c$b w() {
        c$b c$b = new c$b(this);
        return c$b;
    }
}

