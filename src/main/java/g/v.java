/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.l2.i;
import f.l2.q;
import f.q2.u;
import g.v$a;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt___ArraysKt;

public final class v {
    private static final String e = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final String f = "\"([^\"]*)\"";
    private static final Pattern g;
    private static final Pattern h;
    public static final v$a i;
    private final String a;
    private final String b;
    private final String c;
    private final String[] d;

    static {
        v$a v$a;
        i = v$a = new v$a(null);
        g = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        h = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private v(String string2, String string3, String string4, String[] stringArray) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = stringArray;
    }

    public /* synthetic */ v(String string2, String string3, String string4, String[] stringArray, f.h2.t.u u10) {
        this(string2, string3, string4, stringArray);
    }

    public static final /* synthetic */ Pattern c() {
        return h;
    }

    public static final /* synthetic */ Pattern d() {
        return g;
    }

    public static /* synthetic */ Charset g(v v10, Charset charset, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            charset = null;
        }
        return v10.f(charset);
    }

    public static final v h(String string2) {
        return i.c(string2);
    }

    public static final v j(String string2) {
        return i.d(string2);
    }

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final Charset e() {
        return v.g(this, null, 1, null);
    }

    public boolean equals(Object object) {
        String string2;
        boolean bl2;
        boolean bl3 = object instanceof v;
        if (bl3 && (bl2 = f0.g(object = ((v)object).a, string2 = this.a))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Charset f(Charset charset) {
        String string2 = this.i("charset");
        if (string2 == null) return charset;
        try {
            return Charset.forName(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return charset;
        }
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final String i(String stringArray) {
        f0.p(stringArray, "name");
        i i10 = q.S0(ArraysKt___ArraysKt.Id(this.d), 2);
        int n10 = i10.e();
        int n11 = i10.f();
        int n12 = i10.g();
        if (n12 >= 0 ? n10 <= n11 : n10 >= n11) {
            while (true) {
                int n13;
                String string2;
                boolean bl2;
                if (bl2 = u.I1(string2 = this.d[n10], (String)stringArray, (n13 = 1) != 0)) {
                    stringArray = this.d;
                    return stringArray[n10 += n13];
                }
                if (n10 == n11) break;
                n10 += n12;
            }
        }
        return null;
    }

    public final String k() {
        return this.c;
    }

    public final String l() {
        return this.b;
    }

    public String toString() {
        return this.a;
    }
}

