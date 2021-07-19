/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.l2.i;
import f.l2.q;
import f.x1.d1;
import g.h0.d;
import g.t$a;
import g.t$b;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class t {
    private static final char[] k;
    public static final String l = " \"':;<=>@[]^`{}|/\\?#";
    public static final String m = " \"':;<=>@[]^`{}|/\\?#";
    public static final String n = " \"<>^`{}|/\\?#";
    public static final String o = "[]";
    public static final String p = " \"'<>#";
    public static final String q = " \"'<>#&=";
    public static final String r = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String s = "\\^`{|}";
    public static final String t = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String u = "";
    public static final String v = " \"#<>\\^`{|}";
    public static final t$b w;
    private final boolean a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List g;
    private final List h;
    private final String i;
    private final String j;

    static {
        Object object = new t$b(null);
        w = object;
        Object object2 = object = (Object)new char[16];
        object2[0] = 48;
        object2[1] = 49;
        object2[2] = 50;
        object2[3] = 51;
        object2[4] = 52;
        object2[5] = 53;
        object2[6] = 54;
        object2[7] = 55;
        object2[8] = 56;
        object2[9] = 57;
        object2[10] = 65;
        object2[11] = 66;
        object2[12] = 67;
        object2[13] = 68;
        object2[14] = 69;
        object2[15] = 70;
        k = (char[])object;
    }

    public t(String string2, String string3, String string4, String string5, int n10, List list, List list2, String string6, String string7) {
        boolean bl2;
        f0.p(string2, "scheme");
        f0.p(string3, "username");
        f0.p(string4, "password");
        f0.p(string5, "host");
        f0.p(list, "pathSegments");
        f0.p(string7, "url");
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = string5;
        this.f = n10;
        this.g = list;
        this.h = list2;
        this.i = string6;
        this.j = string7;
        this.a = bl2 = f0.g(string2, "https");
    }

    public static final t C(String string2) {
        return w.h(string2);
    }

    public static final t D(URI uRI) {
        return w.i(uRI);
    }

    public static final t E(URL uRL) {
        return w.j(uRL);
    }

    public static final t J(String string2) {
        return w.l(string2);
    }

    public static final /* synthetic */ char[] t() {
        return k;
    }

    public static final int u(String string2) {
        return w.g(string2);
    }

    public final String A() {
        String string2 = this.c;
        int n10 = string2.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return u;
        }
        n10 = this.b.length() + 3;
        String string3 = this.j;
        int n11 = string3.length();
        int n12 = g.h0.d.q(string3, ":@", n10, n11);
        String string4 = this.j;
        Objects.requireNonNull(string4, "null cannot be cast to non-null type java.lang.String");
        string2 = string4.substring(n10, n12);
        f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public final String B() {
        return this.i;
    }

    public final String F() {
        return this.e;
    }

    public final boolean G() {
        return this.a;
    }

    public final t$a H() {
        t$a t$a = new t$a();
        Object object = this.b;
        t$a.X((String)object);
        object = this.A();
        t$a.S((String)object);
        object = this.w();
        t$a.O((String)object);
        object = this.e;
        t$a.T((String)object);
        int n10 = this.f;
        Object object2 = w;
        String string2 = this.b;
        int n11 = ((t$b)object2).g(string2);
        n10 = n10 != n11 ? this.f : -1;
        t$a.V(n10);
        t$a.r().clear();
        object = t$a.r();
        object2 = this.y();
        object.addAll(object2);
        object = this.z();
        t$a.m((String)object);
        object = this.v();
        t$a.N((String)object);
        return t$a;
    }

    public final t$a I(String object) {
        Object object2 = "link";
        f0.p(object, (String)object2);
        object2 = new t$a();
        try {
            object = ((t$a)object2).A(this, (String)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = null;
        }
        return object;
    }

    public final String K() {
        return this.d;
    }

    public final List L() {
        return this.g;
    }

    public final int M() {
        return this.g.size();
    }

    public final int N() {
        return this.f;
    }

    public final String O() {
        Object object = this.h;
        if (object == null) {
            return null;
        }
        object = new StringBuilder();
        t$b t$b = w;
        List list = this.h;
        t$b.q(list, (StringBuilder)object);
        return ((StringBuilder)object).toString();
    }

    public final String P(String object) {
        f0.p(object, "name");
        Iterable iterable = this.h;
        if (iterable == null) {
            return null;
        }
        int n10 = iterable.size();
        iterable = f.l2.q.S0(f.l2.q.n1(0, n10), 2);
        int n11 = ((i)iterable).e();
        int n12 = ((i)iterable).f();
        n10 = ((i)iterable).g();
        if (n10 >= 0 ? n11 <= n12 : n11 >= n12) {
            while (true) {
                String string2;
                boolean bl2;
                if (bl2 = f0.g(object, string2 = (String)this.h.get(n11))) {
                    object = this.h;
                    return (String)object.get(++n11);
                }
                if (n11 == n12) break;
                n11 += n10;
            }
        }
        return null;
    }

    public final String Q(int n10) {
        List list = this.h;
        if (list != null) {
            Object e10 = list.get(n10 *= 2);
            f0.m(e10);
            return (String)e10;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }

    public final Set R() {
        Collection<Object> collection = this.h;
        if (collection == null) {
            return d1.k();
        }
        collection = new Collection<Object>();
        List list = this.h;
        int n10 = list.size();
        i i10 = f.l2.q.S0(f.l2.q.n1(0, n10), 2);
        n10 = i10.e();
        int n11 = i10.f();
        int n12 = i10.g();
        if (n12 >= 0 ? n10 <= n11 : n10 >= n11) {
            while (true) {
                Object e10 = this.h.get(n10);
                f0.m(e10);
                ((HashSet)collection).add(e10);
                if (n10 == n11) break;
                n10 += n12;
            }
        }
        collection = Collections.unmodifiableSet(collection);
        f0.o(collection, "Collections.unmodifiableSet(result)");
        return collection;
    }

    public final String S(int n10) {
        List list = this.h;
        if (list != null) {
            n10 = n10 * 2 + 1;
            return (String)list.get(n10);
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }

    public final List T(String object) {
        f0.p(object, "name");
        ArrayList<Object> arrayList = this.h;
        if (arrayList == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        arrayList = new ArrayList<Object>();
        List list = this.h;
        int n10 = list.size();
        i i10 = f.l2.q.S0(f.l2.q.n1(0, n10), 2);
        n10 = i10.e();
        int n11 = i10.f();
        int n12 = i10.g();
        if (n12 >= 0 ? n10 <= n11 : n10 >= n11) {
            while (true) {
                Object object2;
                boolean bl2;
                if (bl2 = f0.g(object, object2 = (String)this.h.get(n10))) {
                    object2 = this.h;
                    int n13 = n10 + 1;
                    object2 = object2.get(n13);
                    arrayList.add(object2);
                }
                if (n10 == n11) break;
                n10 += n12;
            }
        }
        object = Collections.unmodifiableList(arrayList);
        f0.o(object, "Collections.unmodifiableList(result)");
        return object;
    }

    public final int U() {
        int n10;
        List list = this.h;
        if (list != null) {
            n10 = list.size() / 2;
        } else {
            n10 = 0;
            list = null;
        }
        return n10;
    }

    public final String V() {
        t$a t$a = this.I("/...");
        f0.m(t$a);
        String string2 = u;
        return t$a.Y(string2).B(string2).h().toString();
    }

    public final t W(String object) {
        String string2 = "link";
        f0.p(object, string2);
        object = this.I((String)object);
        object = object != null ? ((t$a)object).h() : null;
        return object;
    }

    public final String X() {
        return this.b;
    }

    public final String Y() {
        Object object = this.e;
        boolean bl2 = g.h0.d.h((String)object);
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            object = PublicSuffixDatabase.j.c();
            String string2 = this.e;
            object = ((PublicSuffixDatabase)object).e(string2);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final URI Z() {
        URI uRI;
        Object object = this.H().G().toString();
        try {
            return new URI((String)object);
        }
        catch (URISyntaxException uRISyntaxException) {
            try {
                String string2 = "[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]";
                Regex regex = new Regex(string2);
                string2 = u;
                object = regex.replace((CharSequence)object, string2);
                uRI = URI.create((String)object);
                object = "try {\n        val stripp\u2026e) // Unexpected!\n      }";
            }
            catch (Exception exception) {
                object = new RuntimeException(uRISyntaxException);
                throw object;
            }
            f0.o(uRI, (String)object);
        }
        return uRI;
    }

    public final String a() {
        return this.v();
    }

    public final URL a0() {
        Object object;
        try {
            object = this.j;
        }
        catch (MalformedURLException malformedURLException) {
            object = new RuntimeException(malformedURLException);
            throw object;
        }
        URL uRL = new URL((String)object);
        return uRL;
    }

    public final String b() {
        return this.w();
    }

    public final String b0() {
        return this.c;
    }

    public final String c() {
        return this.x();
    }

    public final List d() {
        return this.y();
    }

    public final String e() {
        return this.z();
    }

    public boolean equals(Object object) {
        String string2;
        boolean bl2;
        boolean bl3 = object instanceof t;
        if (bl3 && (bl2 = f0.g(object = ((t)object).j, string2 = this.j))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public final String f() {
        return this.A();
    }

    public final String g() {
        return this.i;
    }

    public final String h() {
        return this.e;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public final String i() {
        return this.d;
    }

    public final List j() {
        return this.g;
    }

    public final int k() {
        return this.M();
    }

    public final int l() {
        return this.f;
    }

    public final String m() {
        return this.O();
    }

    public final Set n() {
        return this.R();
    }

    public final int o() {
        return this.U();
    }

    public final String p() {
        return this.b;
    }

    public final URI q() {
        return this.Z();
    }

    public final URL r() {
        return this.a0();
    }

    public final String s() {
        return this.c;
    }

    public String toString() {
        return this.j;
    }

    public final String v() {
        String string2 = this.i;
        if (string2 == null) {
            return null;
        }
        int n10 = StringsKt__StringsKt.i3(this.j, '#', 0, false, 6, null) + 1;
        String string3 = this.j;
        Objects.requireNonNull(string3, "null cannot be cast to non-null type java.lang.String");
        string2 = string3.substring(n10);
        f0.o(string2, "(this as java.lang.String).substring(startIndex)");
        return string2;
    }

    public final String w() {
        String string2 = this.d;
        int n10 = string2.length();
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return u;
        }
        String string3 = this.j;
        int n12 = this.b.length() + 3;
        n10 = StringsKt__StringsKt.i3(string3, ':', n12, false, 4, null) + n11;
        n11 = StringsKt__StringsKt.i3(this.j, '@', 0, false, 6, null);
        string3 = this.j;
        Objects.requireNonNull(string3, "null cannot be cast to non-null type java.lang.String");
        string2 = string3.substring(n10, n11);
        f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public final String x() {
        String string2 = this.j;
        int n10 = this.b.length() + 3;
        int n11 = StringsKt__StringsKt.i3(string2, '/', n10, false, 4, null);
        String string3 = this.j;
        n10 = string3.length();
        int n12 = g.h0.d.q(string3, "?#", n11, n10);
        String string4 = this.j;
        Objects.requireNonNull(string4, "null cannot be cast to non-null type java.lang.String");
        string2 = string4.substring(n11, n12);
        f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public final List y() {
        String string2 = this.j;
        int n10 = this.b.length() + 3;
        int n11 = 0;
        char c10 = '\u0004';
        String string3 = null;
        int n12 = StringsKt__StringsKt.i3(string2, '/', n10, false, c10, null);
        String string4 = this.j;
        n10 = string4.length();
        String string5 = "?#";
        int n13 = g.h0.d.q(string4, string5, n12, n10);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (n12 < n13) {
            string5 = this.j;
            c10 = '/';
            n11 = g.h0.d.p(string5, c10, ++n12, n13);
            String string6 = this.j;
            string3 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(string6, string3);
            string2 = string6.substring(n12, n11);
            string6 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string2, string6);
            arrayList.add(string2);
            n12 = n11;
        }
        return arrayList;
    }

    public final String z() {
        Object object = this.h;
        if (object == null) {
            return null;
        }
        int n10 = StringsKt__StringsKt.i3(this.j, '?', 0, false, 6, null) + 1;
        String string2 = this.j;
        int n11 = string2.length();
        int n12 = g.h0.d.p(string2, '#', n10, n11);
        String string3 = this.j;
        Objects.requireNonNull(string3, "null cannot be cast to non-null type java.lang.String");
        object = string3.substring(n10, n12);
        f0.o(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return object;
    }
}

