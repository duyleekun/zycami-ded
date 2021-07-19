/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import f.l2.i;
import f.l2.q;
import g.h0.d;
import g.t;
import g.t$a;
import h.m;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;

public final class t$b {
    private t$b() {
    }

    public /* synthetic */ t$b(u u10) {
        this();
    }

    public static /* synthetic */ String f(t$b t$b, String string2, int n10, int n11, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Charset charset, int n12, Object object) {
        Charset charset2;
        int n13 = n12;
        int n14 = n12 & 1;
        int n15 = n14 != 0 ? 0 : n10;
        n14 = n13 & 2;
        int n16 = n14 != 0 ? (n14 = string2.length()) : n11;
        n14 = n13 & 8;
        boolean bl6 = n14 != 0 ? false : bl2;
        n14 = n13 & 0x10;
        boolean bl7 = n14 != 0 ? false : bl3;
        n14 = n13 & 0x20;
        boolean bl8 = n14 != 0 ? false : bl4;
        n14 = n13 & 0x40;
        boolean bl9 = n14 != 0 ? false : bl5;
        if ((n13 &= 0x80) != 0) {
            n13 = 0;
            charset2 = null;
        } else {
            charset2 = charset;
        }
        return t$b.e(string2, n15, n16, string3, bl6, bl7, bl8, bl9, charset2);
    }

    private final boolean k(String string2, int n10, int n11) {
        int n12;
        block3: {
            block2: {
                int n13;
                int n14;
                int n15 = n10 + 2;
                n12 = 1;
                if (n15 >= n11 || (n11 = (int)string2.charAt(n10)) != (n14 = 37)) break block2;
                n10 += n12;
                if ((n10 = d.N(string2.charAt(n10))) != (n11 = -1) && (n13 = d.N(string2.charAt(n15))) != n11) break block3;
            }
            n12 = 0;
        }
        return n12 != 0;
    }

    public static /* synthetic */ String n(t$b t$b, String string2, int n10, int n11, boolean bl2, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n13 = n12 & 2) != 0) {
            n11 = string2.length();
        }
        if ((n12 &= 4) != 0) {
            bl2 = false;
        }
        return t$b.m(string2, n10, n11, bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void r(m m10, String string2, int n10, int n11, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Charset charset) {
        String string4 = string2;
        int n12 = n11;
        Charset charset2 = charset;
        int n13 = n10;
        m m11 = null;
        while (true) {
            char c10;
            block8: {
                int n14;
                Charset charset3;
                int n15;
                char c11;
                block13: {
                    Object object;
                    block9: {
                        block10: {
                            block12: {
                                block11: {
                                    char c12;
                                    block7: {
                                        block6: {
                                            if (n13 >= n12) {
                                                object = this;
                                                return;
                                            }
                                            String string5 = "null cannot be cast to non-null type java.lang.String";
                                            Objects.requireNonNull(string4, string5);
                                            c10 = string4.codePointAt(n13);
                                            if (bl2 && (c10 == (c12 = '\t') || c10 == (c12 = '\n') || c10 == (c12 = '\f') || c10 == (c12 = '\r'))) break block6;
                                            c12 = '+';
                                            if (c10 != c12 || !bl4) break block7;
                                            object = bl2 ? "+" : "%2B";
                                            m10.p1((String)object);
                                        }
                                        object = this;
                                        break block8;
                                    }
                                    c12 = ' ';
                                    c11 = '%';
                                    if (c10 < c12 || c10 == (c12 = '\u007f') || c10 >= (c12 = '\u0080') && !bl5) break block9;
                                    c12 = c10;
                                    n15 = 0;
                                    charset3 = null;
                                    n14 = 2;
                                    if ((c12 = (char)(StringsKt__StringsKt.O2(string3, c12, false, n14, null) ? 1 : 0)) != '\u0000') break block10;
                                    if (c10 != c11) break block11;
                                    if (!bl2) break block10;
                                    if (!bl3) break block11;
                                    object = this;
                                    n15 = (int)(this.k(string4, n13, n12) ? 1 : 0);
                                    if (n15 != 0) break block12;
                                    break block13;
                                }
                                object = this;
                            }
                            m10.r1(c10);
                            break block8;
                        }
                        object = this;
                        break block13;
                    }
                    object = this;
                }
                if (m11 == null) {
                    m11 = new m();
                }
                if (charset2 != null && (n15 = f0.g(charset2, charset3 = StandardCharsets.UTF_8)) == 0) {
                    n15 = Character.charCount(c10) + n13;
                    m11.k1(string4, n13, n15, charset2);
                } else {
                    m11.r1(c10);
                }
                while ((n15 = m11.V()) == 0) {
                    n15 = m11.readByte() & 0xFF;
                    m10.b1(c11);
                    char[] cArray = t.t();
                    int n16 = n15 >> 4 & 0xF;
                    n14 = cArray[n16];
                    m10.b1(n14);
                    cArray = t.t();
                    n15 &= 0xF;
                    n15 = cArray[n15];
                    m10.b1(n15);
                }
            }
            c10 = Character.charCount(c10);
            n13 += c10;
        }
    }

    private final void s(m m10, String string2, int n10, int n11, boolean bl2) {
        while (n10 < n11) {
            String string3 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(string2, string3);
            int n12 = string2.codePointAt(n10);
            int n13 = 37;
            if (n12 == n13 && (n13 = n10 + 2) < n11) {
                int n14 = n10 + 1;
                n14 = d.N(string2.charAt(n14));
                int n15 = d.N(string2.charAt(n13));
                int n16 = -1;
                if (n14 != n16 && n15 != n16) {
                    n10 = (n14 << 4) + n15;
                    m10.b1(n10);
                    n10 = Character.charCount(n12) + n13;
                    continue;
                }
            } else {
                n13 = 43;
                if (n12 == n13 && bl2) {
                    n12 = 32;
                    m10.b1(n12);
                    ++n10;
                    continue;
                }
            }
            m10.r1(n12);
            n12 = Character.charCount(n12);
            n10 += n12;
        }
    }

    public final t a(String string2) {
        f0.p(string2, "url");
        return this.h(string2);
    }

    public final t b(URI uRI) {
        f0.p(uRI, "uri");
        return this.i(uRI);
    }

    public final t c(URL uRL) {
        f0.p(uRL, "url");
        return this.j(uRL);
    }

    public final t d(String string2) {
        f0.p(string2, "url");
        return this.l(string2);
    }

    public final String e(String string2, int n10, int n11, String string3, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Charset charset) {
        int n12;
        int n13 = n11;
        String string4 = string3;
        f0.p(string2, "$this$canonicalize");
        Object object = "encodeSet";
        f0.p(string3, (String)object);
        for (int i10 = n10; i10 < n13; i10 += n12) {
            int n14;
            int n15;
            n12 = string2.codePointAt(i10);
            if (n12 >= (n15 = 32) && n12 != (n15 = 127) && (n12 < (n15 = 128) || bl5)) {
                n15 = (char)n12;
                n14 = 2;
                if (!((n15 = (int)(StringsKt__StringsKt.O2(string4, (char)n15, false, n14, null) ? 1 : 0)) != 0 || n12 == (n15 = 37) && (!bl2 || bl3 && (n15 = (int)(this.k(string2, i10, n13) ? 1 : 0)) == 0) || n12 == (n15 = 43) && bl4)) {
                    n12 = Character.charCount(n12);
                    continue;
                }
            }
            m m10 = new m();
            n12 = n10;
            m10.q1(string2, n10, i10);
            object = this;
            n13 = n11;
            string4 = string3;
            n14 = (int)(bl3 ? 1 : 0);
            this.r(m10, string2, i10, n11, string3, bl2, bl3, bl4, bl5, charset);
            return m10.f0();
        }
        n12 = n10;
        object = string2.substring(n10, n11);
        f0.o(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final int g(String string2) {
        int n10;
        String string3 = "scheme";
        f0.p(string2, string3);
        int n11 = string2.hashCode();
        int n12 = 3213448;
        if (n11 != n12) {
            n12 = 99617003;
            if (n11 != n12) return -1;
            string3 = "https";
            n10 = (int)(string2.equals(string3) ? 1 : 0);
            if (n10 == 0) return -1;
            return 443;
        }
        string3 = "http";
        n10 = string2.equals(string3);
        if (n10 == 0) return -1;
        return 80;
    }

    public final t h(String string2) {
        f0.p(string2, "$this$toHttpUrl");
        t$a t$a = new t$a();
        return t$a.A(null, string2).h();
    }

    public final t i(URI object) {
        f0.p(object, "$this$toHttpUrlOrNull");
        object = ((URI)object).toString();
        f0.o(object, "toString()");
        return this.l((String)object);
    }

    public final t j(URL object) {
        f0.p(object, "$this$toHttpUrlOrNull");
        object = ((URL)object).toString();
        f0.o(object, "toString()");
        return this.l((String)object);
    }

    public final t l(String object) {
        String string2 = "$this$toHttpUrlOrNull";
        f0.p(object, string2);
        try {
            object = this.h((String)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = null;
        }
        return object;
    }

    public final String m(String string2, int n10, int n11, boolean bl2) {
        Object object = "$this$percentDecode";
        f0.p(string2, (String)object);
        for (int i10 = n10; i10 < n11; ++i10) {
            int n12;
            int n13 = string2.charAt(i10);
            if (!(n13 == (n12 = 37) || n13 == (n12 = 43) && bl2)) {
                continue;
            }
            object = new m();
            ((m)object).q1(string2, n10, i10);
            this.s((m)object, string2, i10, n11, bl2);
            return ((m)object).f0();
        }
        string2 = string2.substring(n10, n11);
        f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public final void o(List list, StringBuilder stringBuilder) {
        f0.p(list, "$this$toPathString");
        String string2 = "out";
        f0.p(stringBuilder, string2);
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = '/';
            stringBuilder.append(c10);
            String string3 = (String)list.get(i10);
            stringBuilder.append(string3);
        }
    }

    public final List p(String string2) {
        int n10;
        f0.p(string2, "$this$toQueryNamesAndValues");
        ArrayList<String> arrayList = new ArrayList<String>();
        int n11 = 0;
        String string3 = null;
        while (n11 <= (n10 = string2.length())) {
            int n12;
            char c10 = '&';
            int n13 = 4;
            n10 = StringsKt__StringsKt.i3(string2, c10, n11, false, n13, null);
            if (n10 == (n12 = -1)) {
                n10 = string2.length();
            }
            int n14 = n10;
            c10 = '=';
            n13 = 4;
            n10 = StringsKt__StringsKt.i3(string2, c10, n11, false, n13, null);
            String string4 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            if (n10 != n12 && n10 <= n14) {
                string3 = string2.substring(n11, n10);
                f0.o(string3, string4);
                arrayList.add(string3);
                string3 = string2.substring(++n10, n14);
                f0.o(string3, string4);
                arrayList.add(string3);
            } else {
                string3 = string2.substring(n11, n14);
                f0.o(string3, string4);
                arrayList.add(string3);
                n11 = 0;
                string3 = null;
                arrayList.add(null);
            }
            n11 = n14 + 1;
        }
        return arrayList;
    }

    public final void q(List list, StringBuilder stringBuilder) {
        f0.p(list, "$this$toQueryString");
        f0.p(stringBuilder, "out");
        int n10 = list.size();
        i i10 = q.S0(q.n1(0, n10), 2);
        int n11 = i10.e();
        int n12 = i10.f();
        n10 = i10.g();
        if (n10 >= 0 ? n11 <= n12 : n11 >= n12) {
            while (true) {
                String string2 = (String)list.get(n11);
                int n13 = n11 + 1;
                String string3 = (String)list.get(n13);
                if (n11 > 0) {
                    char c10 = '&';
                    stringBuilder.append(c10);
                }
                stringBuilder.append(string2);
                if (string3 != null) {
                    char c11 = '=';
                    stringBuilder.append(c11);
                    stringBuilder.append(string3);
                }
                if (n11 == n12) break;
                n11 += n10;
            }
        }
    }
}

