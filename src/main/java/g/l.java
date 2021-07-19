/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.j.c;
import g.l$b;
import g.s;
import g.t;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public final class l {
    private static final Pattern j;
    private static final Pattern k;
    private static final Pattern l;
    private static final Pattern m;
    public static final l$b n;
    private final String a;
    private final String b;
    private final long c;
    private final String d;
    private final String e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    static {
        l$b l$b;
        n = l$b = new l$b(null);
        j = Pattern.compile("(\\d{2,4})[^\\d]*");
        k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        l = Pattern.compile("(\\d{1,2})[^\\d]*");
        m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private l(String string2, String string3, long l10, String string4, String string5, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.a = string2;
        this.b = string3;
        this.c = l10;
        this.d = string4;
        this.e = string5;
        this.f = bl2;
        this.g = bl3;
        this.h = bl4;
        this.i = bl5;
    }

    public /* synthetic */ l(String string2, String string3, long l10, String string4, String string5, boolean bl2, boolean bl3, boolean bl4, boolean bl5, u u10) {
        this(string2, string3, l10, string4, string5, bl2, bl3, bl4, bl5);
    }

    public static final /* synthetic */ Pattern j() {
        return l;
    }

    public static final /* synthetic */ Pattern k() {
        return k;
    }

    public static final /* synthetic */ Pattern l() {
        return m;
    }

    public static final /* synthetic */ Pattern m() {
        return j;
    }

    public static final l t(t t10, String string2) {
        return n.e(t10, string2);
    }

    public static final List u(t t10, s s10) {
        return n.g(t10, s10);
    }

    public final String a() {
        return this.d;
    }

    public final long b() {
        return this.c;
    }

    public final boolean c() {
        return this.i;
    }

    public final boolean d() {
        return this.g;
    }

    public final String e() {
        return this.a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        Object object2 = object instanceof l;
        if (!object2) return false;
        object = (l)object;
        String string2 = ((l)object).a;
        String string3 = this.a;
        object2 = f0.g(string2, string3);
        if (!object2) return false;
        string2 = ((l)object).b;
        string3 = this.b;
        object2 = f0.g(string2, string3);
        if (!object2) return false;
        long l10 = ((l)object).c;
        long l11 = this.c;
        long l12 = l10 - l11;
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2) return false;
        string2 = ((l)object).d;
        string3 = this.d;
        object2 = f0.g(string2, string3);
        if (!object2) return false;
        string2 = ((l)object).e;
        string3 = this.e;
        object2 = f0.g(string2, string3);
        if (!object2) return false;
        object2 = ((l)object).f;
        boolean bl2 = this.f;
        if (object2 != bl2) return false;
        object2 = ((l)object).g;
        bl2 = this.g;
        if (object2 != bl2) return false;
        object2 = ((l)object).h;
        bl2 = this.h;
        if (object2 != bl2) return false;
        boolean bl3 = ((l)object).i;
        object2 = this.i;
        if (bl3 != object2) return false;
        return true;
    }

    public final String f() {
        return this.e;
    }

    public final boolean g() {
        return this.h;
    }

    public final boolean h() {
        return this.f;
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = this.b.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = Long.hashCode(this.c);
        n11 = (n11 + n10) * 31;
        n10 = this.d.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.e.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = Boolean.hashCode(this.f);
        n11 = (n11 + n10) * 31;
        n10 = Boolean.hashCode(this.g);
        n11 = (n11 + n10) * 31;
        n10 = Boolean.hashCode(this.h);
        n11 = (n11 + n10) * 31;
        n10 = Boolean.hashCode(this.i);
        return n11 + n10;
    }

    public final String i() {
        return this.b;
    }

    public final String n() {
        return this.d;
    }

    public final long o() {
        return this.c;
    }

    public final boolean p() {
        return this.i;
    }

    public final boolean q() {
        return this.g;
    }

    public final boolean r(t t10) {
        boolean bl2;
        String string2;
        String string3;
        Object object = "url";
        f0.p(t10, (String)object);
        boolean bl3 = this.i;
        if (bl3) {
            object = t10.F();
            string3 = this.d;
            bl3 = f0.g(object, string3);
        } else {
            object = n;
            string3 = t10.F();
            string2 = this.d;
            bl3 = l$b.a((l$b)object, string3, string2);
        }
        boolean bl4 = false;
        string3 = null;
        if (!bl3) {
            return false;
        }
        object = n;
        string2 = this.e;
        bl3 = l$b.b((l$b)object, t10, string2);
        if (!bl3) {
            return false;
        }
        bl3 = this.f;
        if (!bl3 || (bl2 = t10.G())) {
            bl4 = true;
        }
        return bl4;
    }

    public final String s() {
        return this.a;
    }

    public String toString() {
        return this.y(false);
    }

    public final String v() {
        return this.e;
    }

    public final boolean w() {
        return this.h;
    }

    public final boolean x() {
        return this.f;
    }

    public final String y(boolean bl2) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.a;
        stringBuilder.append((String)object);
        stringBuilder.append('=');
        object = this.b;
        stringBuilder.append((String)object);
        Object object2 = this.h;
        if (object2) {
            long l10 = this.c;
            long l11 = Long.MIN_VALUE;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object2) {
                object = "; max-age=0";
                stringBuilder.append((String)object);
            } else {
                stringBuilder.append("; expires=");
                long l13 = this.c;
                object = new Date(l13);
                object = g.h0.j.c.b((Date)object);
                stringBuilder.append((String)object);
            }
        }
        if (!(object2 = this.i)) {
            object = "; domain=";
            stringBuilder.append((String)object);
            if (bl2) {
                string2 = ".";
                stringBuilder.append(string2);
            }
            string2 = this.d;
            stringBuilder.append(string2);
        }
        stringBuilder.append("; path=");
        string2 = this.e;
        stringBuilder.append(string2);
        bl2 = this.f;
        if (bl2) {
            string2 = "; secure";
            stringBuilder.append(string2);
        }
        if (bl2 = this.g) {
            string2 = "; httponly";
            stringBuilder.append(string2);
        }
        string2 = stringBuilder.toString();
        f0.o(string2, "toString()");
        return string2;
    }

    public final String z() {
        return this.b;
    }
}

