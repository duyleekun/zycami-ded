/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.f0;
import f.k2.e;
import f.k2.e$a;
import f.l2.a;
import f.l2.a$a;
import f.l2.c;
import f.l2.f;
import f.l2.g;
import f.l2.i;
import f.l2.i$a;
import f.l2.k;
import f.l2.l;
import f.l2.l$a;
import f.l2.n;
import f.l2.p;
import java.util.NoSuchElementException;

public class q
extends p {
    public static final float A(float f10, float f11, float f12) {
        Object object = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1);
        if (object <= 0) {
            object = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
            if (object < 0) {
                return f11;
            }
            Object object2 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
            if (object2 > 0) {
                return f12;
            }
            return f10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        stringBuilder.append(f12);
        stringBuilder.append(" is less than minimum ");
        stringBuilder.append(f11);
        stringBuilder.append('.');
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static final int A0(k k10, e object) {
        f0.p(k10, "$this$random");
        String string2 = "random";
        f0.p(object, string2);
        try {
            return f.k2.f.h((e)object, k10);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string3 = illegalArgumentException.getMessage();
            object = new NoSuchElementException(string3);
            throw object;
        }
    }

    public static final int B(int n10, int n11, int n12) {
        if (n11 <= n12) {
            if (n10 < n11) {
                return n11;
            }
            if (n10 > n12) {
                return n12;
            }
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        stringBuilder.append(n12);
        stringBuilder.append(" is less than minimum ");
        stringBuilder.append(n11);
        stringBuilder.append('.');
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private static final long B0(n n10) {
        e$a e$a = e.b;
        return q.C0(n10, e$a);
    }

    public static final int C(int n10, g object) {
        Object object2 = "range";
        f0.p(object, (String)object2);
        int n11 = object instanceof f;
        if (n11 != 0) {
            Integer n12 = n10;
            object = (f)object;
            return ((Number)((Object)q.G(n12, (f)object))).intValue();
        }
        n11 = object.isEmpty();
        if (n11 == 0) {
            object2 = (Number)((Object)object.getStart());
            n11 = ((Number)object2).intValue();
            if (n10 < n11) {
                Number number = (Number)((Object)object.getStart());
                n10 = number.intValue();
            } else {
                object2 = (Number)((Object)object.c());
                n11 = ((Number)object2).intValue();
                if (n10 > n11) {
                    Number number = (Number)((Object)object.c());
                    n10 = number.intValue();
                }
            }
            return n10;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Cannot coerce value to an empty range: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append('.');
        object = ((StringBuilder)object2).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final long C0(n n10, e object) {
        f0.p(n10, "$this$random");
        String string2 = "random";
        f0.p(object, string2);
        try {
            return f.k2.f.i((e)object, n10);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string3 = illegalArgumentException.getMessage();
            object = new NoSuchElementException(string3);
            throw object;
        }
    }

    public static final long D(long l10, long l11, long l12) {
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object <= 0) {
            object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object < 0) {
                return l11;
            }
            Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (object2 > 0) {
                return l12;
            }
            return l10;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot coerce value to an empty range: maximum ");
        charSequence.append(l12);
        charSequence.append(" is less than minimum ");
        charSequence.append(l11);
        charSequence.append('.');
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    private static final Character D0(c c10) {
        e$a e$a = e.b;
        return q.E0(c10, e$a);
    }

    public static final long E(long l10, g g10) {
        Object object = "range";
        f0.p(g10, (String)object);
        Object object2 = g10 instanceof f;
        if (object2 != 0) {
            Long l11 = l10;
            g10 = (f)g10;
            return ((Number)((Object)q.G(l11, (f)g10))).longValue();
        }
        object2 = g10.isEmpty();
        if (object2 == 0) {
            object = (Number)((Object)g10.getStart());
            long l12 = ((Number)object).longValue();
            long l13 = l10 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 < 0) {
                Number number = (Number)((Object)g10.getStart());
                l10 = number.longValue();
            } else {
                object = (Number)((Object)g10.c());
                l12 = ((Number)object).longValue();
                long l14 = l10 - l12;
                object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 > 0) {
                    Number number = (Number)((Object)g10.c());
                    l10 = number.longValue();
                }
            }
            return l10;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot coerce value to an empty range: ");
        charSequence.append(g10);
        charSequence.append('.');
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final Character E0(c c10, e e10) {
        f0.p(c10, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        char c11 = c10.isEmpty();
        if (c11 != '\u0000') {
            return null;
        }
        c11 = c10.e();
        int n10 = c10.f() + '\u0001';
        return Character.valueOf((char)e10.n(c11, n10));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Comparable F(Comparable object, Comparable object2, Comparable comparable) {
        int n10;
        int n11;
        CharSequence charSequence = "$this$coerceIn";
        f0.p(object, (String)charSequence);
        if (object2 != null && comparable != null) {
            int n12 = object2.compareTo(comparable);
            if (n12 <= 0) {
                n12 = object.compareTo(object2);
                if (n12 < 0) {
                    return object2;
                }
                int n13 = object.compareTo(comparable);
                if (n13 <= 0) return object;
                return comparable;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Cannot coerce value to an empty range: maximum ");
            ((StringBuilder)charSequence).append(comparable);
            ((StringBuilder)charSequence).append(" is less than minimum ");
            ((StringBuilder)charSequence).append(object2);
            ((StringBuilder)charSequence).append('.');
            object2 = ((StringBuilder)charSequence).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        if (object2 != null && (n11 = object.compareTo(object2)) < 0) {
            return object2;
        }
        if (comparable == null || (n10 = object.compareTo(comparable)) <= 0) return object;
        return comparable;
    }

    private static final Integer F0(k k10) {
        e$a e$a = e.b;
        return q.G0(k10, e$a);
    }

    public static final Comparable G(Comparable object, f object2) {
        f0.p(object, "$this$coerceIn");
        Object object3 = "range";
        f0.p(object2, (String)object3);
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object3 = object2.getStart();
            bl2 = object2.b((Comparable)object, (Comparable)object3);
            if (bl2 && !(bl2 = object2.b((Comparable)(object3 = object2.getStart()), (Comparable)object))) {
                object = object2.getStart();
            } else {
                object3 = object2.c();
                bl2 = object2.b((Comparable)object3, (Comparable)object);
                if (bl2 && !(bl2 = object2.b((Comparable)object, (Comparable)(object3 = object2.c())))) {
                    object = object2.c();
                }
            }
            return object;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Cannot coerce value to an empty range: ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append('.');
        object2 = ((StringBuilder)object3).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static final Integer G0(k k10, e e10) {
        f0.p(k10, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        boolean bl2 = k10.isEmpty();
        if (bl2) {
            return null;
        }
        return f.k2.f.h(e10, k10);
    }

    public static final Comparable H(Comparable object, g object2) {
        f0.p(object, "$this$coerceIn");
        Object object3 = "range";
        f0.p(object2, (String)object3);
        int n10 = object2 instanceof f;
        if (n10 != 0) {
            object2 = (f)object2;
            return q.G((Comparable)object, (f)object2);
        }
        n10 = object2.isEmpty();
        if (n10 == 0) {
            object3 = object2.getStart();
            n10 = object.compareTo(object3);
            if (n10 < 0) {
                object = object2.getStart();
            } else {
                object3 = object2.c();
                n10 = object.compareTo(object3);
                if (n10 > 0) {
                    object = object2.c();
                }
            }
            return object;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Cannot coerce value to an empty range: ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append('.');
        object2 = ((StringBuilder)object3).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    private static final Long H0(n n10) {
        e$a e$a = e.b;
        return q.I0(n10, e$a);
    }

    public static final short I(short s10, short s11, short s12) {
        if (s11 <= s12) {
            if (s10 < s11) {
                return s11;
            }
            if (s10 > s12) {
                return s12;
            }
            return s10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        stringBuilder.append(s12);
        stringBuilder.append(" is less than minimum ");
        stringBuilder.append(s11);
        stringBuilder.append('.');
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static final Long I0(n n10, e e10) {
        f0.p(n10, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        boolean bl2 = n10.isEmpty();
        if (bl2) {
            return null;
        }
        return f.k2.f.i(e10, n10);
    }

    private static final boolean J(c c10, Character c11) {
        char c12;
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(c10, string2);
        if (c11 != null && (bl2 = c10.j(c12 = c11.charValue()))) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        return bl2;
    }

    public static final a J0(a a10) {
        f0.p(a10, "$this$reversed");
        a$a a$a = a.d;
        char c10 = a10.f();
        char c11 = a10.e();
        int n10 = -a10.g();
        return a$a.a(c10, c11, n10);
    }

    private static final boolean K(k k10, Integer n10) {
        int n11;
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(k10, string2);
        if (n10 != null && (bl2 = k10.j(n11 = n10.intValue()))) {
            bl2 = true;
        } else {
            bl2 = false;
            k10 = null;
        }
        return bl2;
    }

    public static final i K0(i i10) {
        f0.p(i10, "$this$reversed");
        i$a i$a = i.d;
        int n10 = i10.f();
        int n11 = i10.e();
        int n12 = -i10.g();
        return i$a.a(n10, n11, n12);
    }

    private static final boolean L(n n10, Long l10) {
        long l11;
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(n10, string2);
        if (l10 != null && (bl2 = n10.j(l11 = l10.longValue()))) {
            bl2 = true;
        } else {
            bl2 = false;
            n10 = null;
        }
        return bl2;
    }

    public static final l L0(l l10) {
        f0.p(l10, "$this$reversed");
        l$a l$a = l.d;
        long l11 = l10.f();
        long l12 = l10.e();
        long l13 = -l10.g();
        return l$a.a(l11, l12, l13);
    }

    public static final boolean M(g g10, byte by2) {
        f0.p(g10, "$this$contains");
        Double d10 = by2;
        return g10.contains(d10);
    }

    public static final boolean M0(g g10, byte by2) {
        f0.p(g10, "$this$contains");
        Short s10 = by2;
        return g10.contains(s10);
    }

    public static final boolean N(g g10, float f10) {
        f0.p(g10, "$this$contains");
        Double d10 = f10;
        return g10.contains(d10);
    }

    public static final boolean N0(g g10, double d10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Short s10 = q.e1(d10);
        if (s10 != null) {
            bl2 = g10.contains(s10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final boolean O(g g10, int n10) {
        f0.p(g10, "$this$contains");
        Double d10 = n10;
        return g10.contains(d10);
    }

    public static final boolean O0(g g10, float f10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Short s10 = q.f1(f10);
        if (s10 != null) {
            bl2 = g10.contains(s10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final boolean P(g g10, long l10) {
        f0.p(g10, "$this$contains");
        Double d10 = l10;
        return g10.contains(d10);
    }

    public static final boolean P0(g g10, int n10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Short s10 = q.g1(n10);
        if (s10 != null) {
            bl2 = g10.contains(s10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final boolean Q(g g10, short s10) {
        f0.p(g10, "$this$contains");
        Double d10 = s10;
        return g10.contains(d10);
    }

    public static final boolean Q0(g g10, long l10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Short s10 = q.h1(l10);
        if (s10 != null) {
            bl2 = g10.contains(s10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final a R(char c10, char c11) {
        return a.d.a(c10, c11, -1);
    }

    public static final a R0(a a10, int n10) {
        boolean bl2;
        Object object = "$this$step";
        f0.p(a10, (String)object);
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Integer n11 = n10;
        p.a(bl2, n11);
        object = a.d;
        char c10 = a10.e();
        char c11 = a10.f();
        int n12 = a10.g();
        if (n12 <= 0) {
            n10 = -n10;
        }
        return ((a$a)object).a(c10, c11, n10);
    }

    public static final i S(byte by2, byte by3) {
        return i.d.a(by2, by3, -1);
    }

    public static final i S0(i i10, int n10) {
        boolean bl2;
        Object object = "$this$step";
        f0.p(i10, (String)object);
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Integer n11 = n10;
        p.a(bl2, n11);
        object = i.d;
        int n12 = i10.e();
        int n13 = i10.f();
        int n14 = i10.g();
        if (n14 <= 0) {
            n10 = -n10;
        }
        return ((i$a)object).a(n12, n13, n10);
    }

    public static final i T(byte by2, int n10) {
        return i.d.a(by2, n10, -1);
    }

    public static final l T0(l l10, long l11) {
        String string2 = "$this$step";
        f0.p(l10, string2);
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        l13 = l13 > 0 ? (long)1 : (long)0;
        Long l14 = l11;
        p.a((boolean)l13, l14);
        l$a l$a = l.d;
        long l15 = l10.e();
        long l16 = l10.f();
        long l17 = l10.g();
        long l18 = l17 == l12 ? 0 : (l17 < l12 ? -1 : 1);
        if (l18 <= 0) {
            l11 = -l11;
        }
        return l$a.a(l15, l16, l11);
    }

    public static final i U(byte by2, short s10) {
        return i.d.a(by2, s10, -1);
    }

    public static final Byte U0(double d10) {
        Byte by2;
        double d11 = -128;
        int n10 = 127;
        double d12 = n10;
        Object object = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (object >= 0 && (object = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1)) <= 0) {
            byte by3 = (byte)d10;
            by2 = by3;
        } else {
            boolean bl2 = false;
            by2 = null;
        }
        return by2;
    }

    public static final i V(int n10, byte by2) {
        return i.d.a(n10, by2, -1);
    }

    public static final Byte V0(float f10) {
        Byte by2;
        float f11 = -128;
        int n10 = 127;
        float f12 = n10;
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object >= 0 && (object = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) <= 0) {
            byte by3 = (byte)f10;
            by2 = by3;
        } else {
            boolean bl2 = false;
            f10 = 0.0f;
            by2 = null;
        }
        return by2;
    }

    public static final i W(int n10, int n11) {
        return i.d.a(n10, n11, -1);
    }

    public static final Byte W0(int n10) {
        Byte by2;
        int n11 = -128;
        if (n11 <= n10 && (n11 = 127) >= n10) {
            n10 = (byte)n10;
            by2 = (byte)n10;
        } else {
            n10 = 0;
            by2 = null;
        }
        return by2;
    }

    public static final i X(int n10, short s10) {
        return i.d.a(n10, s10, -1);
    }

    public static final Byte X0(long l10) {
        Byte by2;
        long l11 = -128;
        int n10 = 127;
        long l12 = n10;
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object <= 0 && (object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) >= 0) {
            byte by3 = (byte)l10;
            by2 = by3;
        } else {
            boolean bl2 = false;
            by2 = null;
        }
        return by2;
    }

    public static final i Y(short s10, byte by2) {
        return i.d.a(s10, by2, -1);
    }

    public static final Byte Y0(short s10) {
        Byte by2;
        short s11 = (short)-128;
        short s12 = (short)127;
        if (s11 <= s10 && s12 >= s10) {
            s10 = (byte)s10;
            by2 = (byte)s10;
        } else {
            s10 = 0;
            by2 = null;
        }
        return by2;
    }

    public static final i Z(short s10, int n10) {
        return i.d.a(s10, n10, -1);
    }

    public static final Integer Z0(double d10) {
        Integer n10;
        double d11 = -1 << -1;
        int n11 = -1 >>> 1;
        double d12 = n11;
        Object object = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (object >= 0 && (object = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1)) <= 0) {
            int n12 = (int)d10;
            n10 = n12;
        } else {
            boolean bl2 = false;
            n10 = null;
        }
        return n10;
    }

    public static final i a0(short s10, short s11) {
        return i.d.a(s10, s11, -1);
    }

    public static final Integer a1(float f10) {
        Integer n10;
        float f11 = -1 << -1;
        int n11 = -1 >>> 1;
        float f12 = n11;
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object >= 0 && (object = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) <= 0) {
            int n12 = (int)f10;
            n10 = n12;
        } else {
            boolean bl2 = false;
            f10 = 0.0f;
            n10 = null;
        }
        return n10;
    }

    public static final l b0(byte by2, long l10) {
        l$a l$a = l.d;
        long l11 = by2;
        return l$a.a(l11, l10, -1);
    }

    public static final Integer b1(long l10) {
        Integer n10;
        long l11 = -1 << -1;
        int n11 = -1 >>> 1;
        long l12 = n11;
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object <= 0 && (object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) >= 0) {
            int n12 = (int)l10;
            n10 = n12;
        } else {
            boolean bl2 = false;
            n10 = null;
        }
        return n10;
    }

    public static final l c0(int n10, long l10) {
        l$a l$a = l.d;
        long l11 = n10;
        return l$a.a(l11, l10, -1);
    }

    public static final Long c1(double d10) {
        Long l10;
        long l11 = Long.MIN_VALUE;
        double d11 = l11;
        long l12 = Long.MAX_VALUE;
        double d12 = l12;
        Object object = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (object >= 0 && (object = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1)) <= 0) {
            long l13 = (long)d10;
            l10 = l13;
        } else {
            l10 = null;
        }
        return l10;
    }

    public static final l d0(long l10, byte by2) {
        l$a l$a = l.d;
        long l11 = by2;
        return l$a.a(l10, l11, -1);
    }

    public static final Long d1(float f10) {
        Long l10;
        long l11 = Long.MIN_VALUE;
        float f11 = l11;
        long l12 = Long.MAX_VALUE;
        float f12 = l12;
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object >= 0 && (object = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) <= 0) {
            l11 = (long)f10;
            l10 = l11;
        } else {
            f10 = 0.0f;
            l10 = null;
        }
        return l10;
    }

    public static final l e0(long l10, int n10) {
        l$a l$a = l.d;
        long l11 = n10;
        return l$a.a(l10, l11, -1);
    }

    public static final Short e1(double d10) {
        Short s10;
        double d11 = Short.MIN_VALUE;
        int n10 = Short.MAX_VALUE;
        double d12 = n10;
        Object object = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (object >= 0 && (object = d10 == d12 ? 0 : (d10 < d12 ? -1 : 1)) <= 0) {
            short s11 = (short)d10;
            s10 = s11;
        } else {
            boolean bl2 = false;
            s10 = null;
        }
        return s10;
    }

    public static final boolean f(g g10, double d10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Byte by2 = q.U0(d10);
        if (by2 != null) {
            bl2 = g10.contains(by2);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final l f0(long l10, long l11) {
        return l.d.a(l10, l11, -1);
    }

    public static final Short f1(float f10) {
        Short s10;
        float f11 = Short.MIN_VALUE;
        int n10 = Short.MAX_VALUE;
        float f12 = n10;
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object >= 0 && (object = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) <= 0) {
            short s11 = (short)f10;
            s10 = s11;
        } else {
            boolean bl2 = false;
            f10 = 0.0f;
            s10 = null;
        }
        return s10;
    }

    public static final boolean g(g g10, float f10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Byte by2 = q.V0(f10);
        if (by2 != null) {
            bl2 = g10.contains(by2);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final l g0(long l10, short s10) {
        l$a l$a = l.d;
        long l11 = s10;
        return l$a.a(l10, l11, -1);
    }

    public static final Short g1(int n10) {
        Short s10;
        int n11 = Short.MIN_VALUE;
        if (n11 <= n10 && (n11 = Short.MAX_VALUE) >= n10) {
            n10 = (short)n10;
            s10 = (short)n10;
        } else {
            n10 = 0;
            s10 = null;
        }
        return s10;
    }

    public static final boolean h(g g10, int n10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Byte by2 = q.W0(n10);
        if (by2 != null) {
            bl2 = g10.contains(by2);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final l h0(short s10, long l10) {
        l$a l$a = l.d;
        long l11 = s10;
        return l$a.a(l11, l10, -1);
    }

    public static final Short h1(long l10) {
        Short s10;
        long l11 = Short.MIN_VALUE;
        int n10 = Short.MAX_VALUE;
        long l12 = n10;
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object <= 0 && (object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) >= 0) {
            short s11 = (short)l10;
            s10 = s11;
        } else {
            boolean bl2 = false;
            s10 = null;
        }
        return s10;
    }

    public static final boolean i(g g10, long l10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Byte by2 = q.X0(l10);
        if (by2 != null) {
            bl2 = g10.contains(by2);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final boolean i0(g g10, byte by2) {
        f0.p(g10, "$this$contains");
        Float f10 = Float.valueOf(by2);
        return g10.contains(f10);
    }

    public static final c i1(char c10, char c11) {
        c c12 = null;
        int n10 = f0.t(c11, 0);
        if (n10 <= 0) {
            return c.f.a();
        }
        c11 = (char)(c11 + -1);
        c12 = new c(c10, c11);
        return c12;
    }

    public static final boolean j(g g10, short s10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Byte by2 = q.Y0(s10);
        if (by2 != null) {
            bl2 = g10.contains(by2);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final boolean j0(g g10, double d10) {
        f0.p(g10, "$this$contains");
        Float f10 = Float.valueOf((float)d10);
        return g10.contains(f10);
    }

    public static final k j1(byte by2, byte by3) {
        by3 = (byte)(by3 + -1);
        k k10 = new k(by2, by3);
        return k10;
    }

    public static final byte k(byte by2, byte by3) {
        if (by2 < by3) {
            by2 = by3;
        }
        return by2;
    }

    public static final boolean k0(g g10, int n10) {
        f0.p(g10, "$this$contains");
        Float f10 = Float.valueOf(n10);
        return g10.contains(f10);
    }

    public static final k k1(byte by2, int n10) {
        int n11 = -1 << -1;
        if (n10 <= n11) {
            return k.f.a();
        }
        k k10 = new k(by2, n10 += -1);
        return k10;
    }

    public static final double l(double d10, double d11) {
        Object object = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        if (object < 0) {
            d10 = d11;
        }
        return d10;
    }

    public static final boolean l0(g g10, long l10) {
        f0.p(g10, "$this$contains");
        Float f10 = Float.valueOf(l10);
        return g10.contains(f10);
    }

    public static final k l1(byte by2, short s10) {
        s10 = (short)(s10 + -1);
        k k10 = new k(by2, s10);
        return k10;
    }

    public static final float m(float f10, float f11) {
        Object object = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object < 0) {
            f10 = f11;
        }
        return f10;
    }

    public static final boolean m0(g g10, short s10) {
        f0.p(g10, "$this$contains");
        Float f10 = Float.valueOf(s10);
        return g10.contains(f10);
    }

    public static final k m1(int n10, byte by2) {
        by2 = (byte)(by2 + -1);
        k k10 = new k(n10, by2);
        return k10;
    }

    public static final int n(int n10, int n11) {
        if (n10 < n11) {
            n10 = n11;
        }
        return n10;
    }

    public static final boolean n0(g g10, byte by2) {
        f0.p(g10, "$this$contains");
        Integer n10 = by2;
        return g10.contains(n10);
    }

    public static final k n1(int n10, int n11) {
        int n12 = -1 << -1;
        if (n11 <= n12) {
            return k.f.a();
        }
        k k10 = new k(n10, n11 += -1);
        return k10;
    }

    public static final long o(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object < 0) {
            l10 = l11;
        }
        return l10;
    }

    public static final boolean o0(g g10, double d10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Integer n10 = q.Z0(d10);
        if (n10 != null) {
            bl2 = g10.contains(n10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final k o1(int n10, short s10) {
        s10 = (short)(s10 + -1);
        k k10 = new k(n10, s10);
        return k10;
    }

    public static final Comparable p(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "$this$coerceAtLeast");
        String string2 = "minimumValue";
        f0.p(comparable2, string2);
        int n10 = comparable.compareTo(comparable2);
        if (n10 < 0) {
            comparable = comparable2;
        }
        return comparable;
    }

    public static final boolean p0(g g10, float f10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Integer n10 = q.a1(f10);
        if (n10 != null) {
            bl2 = g10.contains(n10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final k p1(short s10, byte by2) {
        by2 = (byte)(by2 + -1);
        k k10 = new k(s10, by2);
        return k10;
    }

    public static final short q(short s10, short s11) {
        if (s10 < s11) {
            s10 = s11;
        }
        return s10;
    }

    public static final boolean q0(g g10, long l10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Integer n10 = q.b1(l10);
        if (n10 != null) {
            bl2 = g10.contains(n10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final k q1(short s10, int n10) {
        int n11 = -1 << -1;
        if (n10 <= n11) {
            return k.f.a();
        }
        k k10 = new k(s10, n10 += -1);
        return k10;
    }

    public static final byte r(byte by2, byte by3) {
        if (by2 > by3) {
            by2 = by3;
        }
        return by2;
    }

    public static final boolean r0(g g10, short s10) {
        f0.p(g10, "$this$contains");
        Integer n10 = s10;
        return g10.contains(n10);
    }

    public static final k r1(short s10, short s11) {
        s11 = (short)(s11 + -1);
        k k10 = new k(s10, s11);
        return k10;
    }

    public static final double s(double d10, double d11) {
        Object object = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (object > 0) {
            d10 = d11;
        }
        return d10;
    }

    public static final boolean s0(g g10, byte by2) {
        f0.p(g10, "$this$contains");
        Long l10 = by2;
        return g10.contains(l10);
    }

    public static final n s1(byte by2, long l10) {
        long l11 = Long.MIN_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return n.f.a();
        }
        l11 = by2;
        n n10 = new n(l11, --l10);
        return n10;
    }

    public static final float t(float f10, float f11) {
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object > 0) {
            f10 = f11;
        }
        return f10;
    }

    public static final boolean t0(g g10, double d10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Long l10 = q.c1(d10);
        if (l10 != null) {
            bl2 = g10.contains(l10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final n t1(int n10, long l10) {
        long l11 = Long.MIN_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return n.f.a();
        }
        l11 = n10;
        n n11 = new n(l11, --l10);
        return n11;
    }

    public static final int u(int n10, int n11) {
        if (n10 > n11) {
            n10 = n11;
        }
        return n10;
    }

    public static final boolean u0(g g10, float f10) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(g10, string2);
        Long l10 = q.d1(f10);
        if (l10 != null) {
            bl2 = g10.contains(l10);
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public static final n u1(long l10, byte by2) {
        long l11 = (long)by2 - 1L;
        n n10 = new n(l10, l11);
        return n10;
    }

    public static final long v(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object > 0) {
            l10 = l11;
        }
        return l10;
    }

    public static final boolean v0(g g10, int n10) {
        f0.p(g10, "$this$contains");
        Long l10 = n10;
        return g10.contains(l10);
    }

    public static final n v1(long l10, int n10) {
        long l11 = (long)n10 - 1L;
        n n11 = new n(l10, l11);
        return n11;
    }

    public static final Comparable w(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "$this$coerceAtMost");
        String string2 = "maximumValue";
        f0.p(comparable2, string2);
        int n10 = comparable.compareTo(comparable2);
        if (n10 > 0) {
            comparable = comparable2;
        }
        return comparable;
    }

    public static final boolean w0(g g10, short s10) {
        f0.p(g10, "$this$contains");
        Long l10 = s10;
        return g10.contains(l10);
    }

    public static final n w1(long l10, long l11) {
        long l12 = Long.MIN_VALUE;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object <= 0) {
            return n.f.a();
        }
        n n10 = new n(l10, --l11);
        return n10;
    }

    public static final short x(short s10, short s11) {
        if (s10 > s11) {
            s10 = s11;
        }
        return s10;
    }

    private static final char x0(c c10) {
        e$a e$a = e.b;
        return q.y0(c10, e$a);
    }

    public static final n x1(long l10, short s10) {
        long l11 = (long)s10 - 1L;
        n n10 = new n(l10, l11);
        return n10;
    }

    public static final byte y(byte by2, byte by3, byte by4) {
        if (by3 <= by4) {
            if (by2 < by3) {
                return by3;
            }
            if (by2 > by4) {
                return by4;
            }
            return by2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        stringBuilder.append(by4);
        stringBuilder.append(" is less than minimum ");
        stringBuilder.append(by3);
        stringBuilder.append('.');
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static final char y0(c c10, e object) {
        char c11;
        f0.p(c10, "$this$random");
        String string2 = "random";
        f0.p(object, string2);
        try {
            c11 = c10.e();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string3 = illegalArgumentException.getMessage();
            object = new NoSuchElementException(string3);
            throw object;
        }
        int n10 = c10.f() + '\u0001';
        return (char)((e)object).n(c11, n10);
    }

    public static final n y1(short s10, long l10) {
        long l11 = Long.MIN_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return n.f.a();
        }
        l11 = s10;
        n n10 = new n(l11, --l10);
        return n10;
    }

    public static final double z(double d10, double d11, double d12) {
        Object object = d11 == d12 ? 0 : (d11 > d12 ? 1 : -1);
        if (object <= 0) {
            object = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
            if (object < 0) {
                return d11;
            }
            Object object2 = d10 == d12 ? 0 : (d10 > d12 ? 1 : -1);
            if (object2 > 0) {
                return d12;
            }
            return d10;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot coerce value to an empty range: maximum ");
        charSequence.append(d12);
        charSequence.append(" is less than minimum ");
        charSequence.append(d11);
        charSequence.append('.');
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    private static final int z0(k k10) {
        e$a e$a = e.b;
        return q.A0(k10, e$a);
    }
}

