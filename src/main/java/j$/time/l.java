/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.k;
import j$.time.q.c;
import j$.time.q.g;
import j$.time.q.h;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.y;
import j$.time.q.z;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class l
extends k
implements s,
t,
Comparable,
Serializable {
    private static final ConcurrentMap d;
    private static final ConcurrentMap e;
    public static final l f;
    public static final l g;
    public static final l h;
    private final int b;
    private final transient String c;

    static {
        ConcurrentHashMap concurrentHashMap;
        int n10 = 16;
        float f10 = 0.75f;
        int n11 = 4;
        d = concurrentHashMap = new ConcurrentHashMap(n10, f10, n11);
        e = concurrentHashMap = new ConcurrentHashMap(n10, f10, n11);
        f = l.O(0);
        g = l.O(-64800);
        h = l.O(64800);
    }

    private l(int n10) {
        String string2;
        this.b = n10;
        if (n10 == 0) {
            string2 = "Z";
        } else {
            int n11 = Math.abs(n10);
            StringBuilder stringBuilder = new StringBuilder();
            int n12 = n11 / 3600;
            int n13 = n11 / 60 % 60;
            string2 = n10 < 0 ? "-" : "+";
            stringBuilder.append(string2);
            n10 = 10;
            String string3 = n12 < n10 ? "0" : "";
            stringBuilder.append(string3);
            stringBuilder.append(n12);
            String string4 = ":0";
            string3 = ":";
            String string5 = n13 < n10 ? string4 : string3;
            stringBuilder.append(string5);
            stringBuilder.append(n13);
            if ((n11 %= 60) != 0) {
                if (n11 >= n10) {
                    string4 = string3;
                }
                stringBuilder.append(string4);
                stringBuilder.append(n11);
            }
            string2 = stringBuilder.toString();
        }
        this.c = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static l D(String string2) {
        int n10;
        CharSequence charSequence;
        int n11;
        int n12;
        char c10;
        int n13;
        int n14;
        int n15;
        block6: {
            block8: {
                block7: {
                    block11: {
                        block9: {
                            int n16;
                            block10: {
                                Objects.requireNonNull(string2, "offsetId");
                                l l10 = (l)e.get(string2);
                                if (l10 != null) {
                                    return l10;
                                }
                                n15 = string2.length();
                                n14 = 2;
                                n13 = 1;
                                c10 = '\u0000';
                                if (n15 == n14) break block7;
                                n14 = 3;
                                if (n15 == n14) break block8;
                                n12 = 5;
                                if (n15 == n12) break block9;
                                n11 = 6;
                                n16 = 4;
                                if (n15 == n11) break block10;
                                n11 = 7;
                                if (n15 != n11) {
                                    n14 = 9;
                                    if (n15 != n14) {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Invalid ID for ZoneOffset, invalid format: ");
                                        stringBuilder.append(string2);
                                        string2 = stringBuilder.toString();
                                        j$.time.c c11 = new j$.time.c(string2);
                                        throw c11;
                                    }
                                    n15 = l.P(string2, n13, false);
                                    n14 = l.P(string2, n16, n13 != 0);
                                    n13 = l.P(string2, n11, n13 != 0);
                                    break block6;
                                } else {
                                    n15 = l.P(string2, n13, false);
                                    n14 = l.P(string2, n14, false);
                                    n13 = l.P(string2, n12, false);
                                }
                                break block6;
                            }
                            n15 = l.P(string2, n13, false);
                            n14 = l.P(string2, n16, n13 != 0);
                            break block11;
                        }
                        n15 = l.P(string2, n13, false);
                        n14 = l.P(string2, n14, false);
                    }
                    n13 = 0;
                    break block6;
                }
                StringBuilder stringBuilder = new StringBuilder();
                n14 = string2.charAt(0);
                stringBuilder.append((char)n14);
                charSequence = "0";
                stringBuilder.append((String)charSequence);
                n10 = string2.charAt(n13);
                stringBuilder.append((char)n10);
                string2 = stringBuilder.toString();
            }
            n15 = l.P(string2, n13, false);
            n14 = 0;
            charSequence = null;
            n13 = 0;
        }
        c10 = string2.charAt(0);
        n12 = 43;
        n11 = 45;
        if (c10 != n12 && c10 != n11) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Invalid ID for ZoneOffset, plus/minus not found when expected: ");
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            j$.time.c c12 = new j$.time.c(string2);
            throw c12;
        }
        if (c10 == n11) {
            n10 = -n15;
            n15 = -n14;
            n14 = -n13;
            return l.L(n10, n15, n14);
        }
        return l.L(n15, n14, n13);
    }

    public static l L(int n10, int n11, int n12) {
        int n13 = -18;
        if (n10 >= n13 && n10 <= (n13 = 18)) {
            int n14;
            if (n10 > 0) {
                if (n11 < 0 || n12 < 0) {
                    j$.time.c c10 = new j$.time.c("Zone offset minutes and seconds must be positive because hours is positive");
                    throw c10;
                }
            } else if (n10 < 0) {
                if (n11 > 0 || n12 > 0) {
                    j$.time.c c11 = new j$.time.c("Zone offset minutes and seconds must be negative because hours is negative");
                    throw c11;
                }
            } else if (n11 > 0 && n12 < 0 || n11 < 0 && n12 > 0) {
                j$.time.c c12 = new j$.time.c("Zone offset minutes and seconds must have the same sign");
                throw c12;
            }
            String string2 = " is not in the range -59 to 59";
            int n15 = -59;
            if (n11 >= n15 && n11 <= (n14 = 59)) {
                if (n12 >= n15 && n12 <= n14) {
                    int n16 = Math.abs(n10);
                    if (n16 == n13 && (n13 = n11 | n12) != 0) {
                        j$.time.c c13 = new j$.time.c("Zone offset not in valid range: -18:00 to +18:00");
                        throw c13;
                    }
                    return l.O(n11 * 60 + (n10 *= 3600) + n12);
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Zone offset seconds not in valid range: value ");
                charSequence.append(n12);
                charSequence.append(string2);
                charSequence = charSequence.toString();
                j$.time.c c14 = new j$.time.c((String)charSequence);
                throw c14;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Zone offset minutes not in valid range: value ");
            stringBuilder.append(n11);
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            j$.time.c c15 = new j$.time.c(string3);
            throw c15;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Zone offset hours not in valid range: value ");
        stringBuilder.append(n10);
        stringBuilder.append(" is not in the range -18 to 18");
        String string4 = stringBuilder.toString();
        j$.time.c c16 = new j$.time.c(string4);
        throw c16;
    }

    public static l O(int n10) {
        int n11 = -64800;
        if (n10 >= n11 && n10 <= (n11 = 64800)) {
            n11 = n10 % 900;
            if (n11 == 0) {
                ConcurrentMap concurrentMap = d;
                Object object = n10;
                l l10 = (l)concurrentMap.get(object);
                if (l10 == null) {
                    l10 = new l(n10);
                    concurrentMap.putIfAbsent(object, l10);
                    Object object2 = concurrentMap.get(object);
                    l10 = object2;
                    l10 = (l)object2;
                    object2 = e;
                    object = l10.c;
                    object2.putIfAbsent((Object)object, (l)l10);
                }
                return l10;
            }
            l l11 = new l(n10);
            return l11;
        }
        j$.time.c c10 = new j$.time.c("Zone offset not in valid range: -18:00 to +18:00");
        throw c10;
    }

    private static int P(CharSequence charSequence, int n10, boolean n11) {
        int n12;
        int n13;
        if (n11 != 0) {
            n11 = n10 + -1;
            if ((n11 = charSequence.charAt(n11)) != (n13 = 58)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid ID for ZoneOffset, colon not found when expected: ");
                stringBuilder.append((Object)charSequence);
                charSequence = stringBuilder.toString();
                j$.time.c c10 = new j$.time.c((String)charSequence);
                throw c10;
            }
        }
        n11 = charSequence.charAt(n10);
        ++n10;
        n10 = charSequence.charAt(n10);
        n13 = 48;
        if (n11 >= n13 && n11 <= (n12 = 57) && n10 >= n13 && n10 <= n12) {
            n11 = (n11 - n13) * 10;
            return n10 - n13 + n11;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid ID for ZoneOffset, non numeric characters found: ");
        stringBuilder.append((Object)charSequence);
        charSequence = stringBuilder.toString();
        j$.time.c c11 = new j$.time.c((String)charSequence);
        throw c11;
    }

    public int C() {
        return this.b;
    }

    public int compareTo(Object object) {
        int n10 = ((l)object).b;
        int n11 = this.b;
        return n10 - n11;
    }

    public Object d(w w10) {
        w w11 = j$.time.q.c.a;
        if (w10 != w11 && w10 != (w11 = j$.time.q.g.a)) {
            return s.super.d(w10);
        }
        return this;
    }

    public r e(r r10) {
        h h10 = j$.time.q.h.H;
        long l10 = this.b;
        return r10.c(h10, l10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof l;
        if (n10 != 0) {
            n10 = this.b;
            object = (l)object;
            int n11 = ((l)object).b;
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
            h h10 = j$.time.q.h.H;
            if (u10 != h10) {
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
        Object object2 = j$.time.q.h.H;
        if (object == object2) {
            return this.b;
        }
        boolean bl2 = object instanceof h;
        if (!bl2) {
            return object.o(this);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new y((String)object);
        throw object2;
    }

    public int hashCode() {
        return this.b;
    }

    public z i(u u10) {
        return s.super.i(u10);
    }

    public int k(u object) {
        Object object2 = j$.time.q.h.H;
        if (object == object2) {
            return this.b;
        }
        boolean bl2 = object instanceof h;
        if (!bl2) {
            object2 = s.super.i((u)object);
            long l10 = this.h((u)object);
            return ((z)object2).a(l10, (u)object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new y((String)object);
        throw object2;
    }

    public j$.time.r.c m() {
        return j$.time.r.c.j(this);
    }

    public String q() {
        return this.c;
    }

    public String toString() {
        return this.c;
    }
}

