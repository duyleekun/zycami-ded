/*
 * Decompiled with CFR 0.151.
 */
package g.h0.p;

import f.h2.t.f0;
import f.q2.u;
import g.h0.a;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

public final class d
implements HostnameVerifier {
    private static final int a = 2;
    private static final int b = 7;
    public static final d c;

    static {
        d d10;
        c = d10 = new d();
    }

    private d() {
    }

    private final List b(X509Certificate object, int n10) {
        block17: {
            ArrayList arrayList;
            block18: {
                object = ((X509Certificate)object).getSubjectAlternativeNames();
                if (object == null) break block17;
                arrayList = new ArrayList();
                object = object.iterator();
                while (true) {
                    boolean bl2 = object.hasNext();
                    if (!bl2) break block18;
                    Object object2 = object.next();
                    if ((object2 = (List)object2) == null) continue;
                    int n11 = object2.size();
                    int n12 = 2;
                    if (n11 < n12) continue;
                    n11 = 0;
                    Object var8_8 = null;
                    var8_8 = object2.get(0);
                    Integer n13 = n10;
                    n11 = (int)(f0.g(var8_8, n13) ? 1 : 0);
                    n12 = 1;
                    if ((n11 ^= n12) != 0) continue;
                    if ((object2 = object2.get(n12)) == null) continue;
                    if (object2 == null) break;
                    object2 = (String)object2;
                    arrayList.add(object2);
                    continue;
                    break;
                }
                String string2 = "null cannot be cast to non-null type kotlin.String";
                try {
                    object = new NullPointerException(string2);
                    throw object;
                }
                catch (CertificateParsingException certificateParsingException) {
                    return CollectionsKt__CollectionsKt.E();
                }
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.E();
    }

    /*
     * WARNING - void declaration
     */
    private final boolean d(String object, String string2) {
        Object charSequence;
        boolean c10;
        int n10;
        boolean bl2;
        String string3;
        boolean c11;
        boolean c12 = true;
        if (object != null && (c11 = object.length())) {
            c11 = false;
            string3 = null;
        } else {
            c11 = c12;
        }
        if (!(c11 || (bl2 = u.q2((String)object, string3 = ".", false, n10 = 2, null)) || (c10 = u.H1((String)object, (String)(charSequence = ".."), false, n10, null)))) {
            boolean bl3;
            void var9_13;
            int n11;
            if (string2 != null && (n11 = string2.length()) != 0) {
                boolean bl4 = false;
            } else {
                boolean bl5 = c12;
            }
            if (var9_13 == false && !(bl3 = u.q2(string2, string3, false, n10, null)) && !(bl2 = u.H1(string2, (String)charSequence, false, n10, null))) {
                bl2 = u.H1((String)object, string3, false, n10, null);
                if (!bl2) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append(string3);
                    object = ((StringBuilder)charSequence).toString();
                }
                charSequence = object;
                int n12 = u.H1(string2, string3, false, n10, null);
                if (n12 == 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(string3);
                    string2 = ((StringBuilder)object).toString();
                }
                object = Locale.US;
                f0.o(object, "Locale.US");
                string3 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(string2, string3);
                object = string2.toLowerCase((Locale)object);
                f0.o(object, "(this as java.lang.String).toLowerCase(locale)");
                string2 = "*";
                int n13 = StringsKt__StringsKt.P2((CharSequence)object, string2, false, n10, null);
                if (n13 == 0) {
                    return f0.g(charSequence, object);
                }
                string2 = "*.";
                boolean bl6 = u.q2((String)object, string2, false, n10, null);
                if (bl6) {
                    int n14;
                    int n15 = 42;
                    int n16 = 1;
                    int n17 = 0;
                    int n18 = 4;
                    int n19 = StringsKt__StringsKt.i3((CharSequence)object, (char)n15, n16, false, n18, null);
                    if (n19 == (n14 = -1)) {
                        int n20 = ((String)charSequence).length();
                        if (n20 < (n15 = ((String)object).length())) {
                            return false;
                        }
                        n13 = f0.g(string2, object);
                        if (n13 != 0) {
                            return false;
                        }
                        Objects.requireNonNull(object, string3);
                        object = ((String)object).substring((int)(c12 ? 1 : 0));
                        string2 = "(this as java.lang.String).substring(startIndex)";
                        f0.o(object, string2);
                        n13 = u.H1((String)charSequence, (String)object, false, n10, null);
                        if (n13 == 0) {
                            return false;
                        }
                        n13 = ((String)charSequence).length();
                        n12 = ((String)object).length();
                        if ((n13 -= n12) > 0) {
                            char c13 = '.';
                            n15 = n13 + -1;
                            n16 = 0;
                            n17 = 4;
                            n18 = 0;
                            n12 = StringsKt__StringsKt.w3((CharSequence)charSequence, c13, n15, false, n17, null);
                            if (n12 != n14) {
                                return false;
                            }
                        }
                        return c12;
                    }
                }
            }
        }
        return false;
    }

    private final boolean e(String string2, X509Certificate iterator2) {
        Object object = Locale.US;
        f0.o(object, "Locale.US");
        Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
        string2 = string2.toLowerCase((Locale)object);
        object = "(this as java.lang.String).toLowerCase(locale)";
        f0.o(string2, (String)object);
        iterator2 = this.b((X509Certificate)((Object)iterator2), 2);
        boolean bl2 = iterator2 instanceof Collection;
        boolean bl3 = false;
        if (!bl2 || !(bl2 = iterator2.isEmpty())) {
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                d d10 = c;
                object = (String)iterator2.next();
                bl2 = d10.d(string2, (String)object);
                if (!bl2) continue;
                bl3 = true;
                break;
            }
        }
        return bl3;
    }

    private final boolean f(String string2, X509Certificate iterator2) {
        string2 = g.h0.a.e(string2);
        iterator2 = this.b((X509Certificate)((Object)iterator2), 7);
        boolean bl2 = iterator2 instanceof Collection;
        boolean bl3 = false;
        if (!bl2 || !(bl2 = iterator2.isEmpty())) {
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                String string3 = g.h0.a.e((String)iterator2.next());
                bl2 = f0.g(string2, string3);
                if (!bl2) continue;
                bl3 = true;
                break;
            }
        }
        return bl3;
    }

    public final List a(X509Certificate object) {
        f0.p(object, "certificate");
        List list = this.b((X509Certificate)object, 7);
        object = this.b((X509Certificate)object, 2);
        return CollectionsKt___CollectionsKt.o4(list, (Iterable)object);
    }

    public final boolean c(String string2, X509Certificate x509Certificate) {
        f0.p(string2, "host");
        String string3 = "certificate";
        f0.p(x509Certificate, string3);
        boolean bl2 = g.h0.d.h(string2);
        boolean bl3 = bl2 ? this.f(string2, x509Certificate) : this.e(string2, x509Certificate);
        return bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean verify(String object, SSLSession object2) {
        block8: {
            Certificate[] certificateArray;
            f0.p(object, "host");
            f0.p(object2, "session");
            boolean bl2 = false;
            try {
                certificateArray = object2.getPeerCertificates();
            }
            catch (SSLException sSLException) {
                return bl2;
            }
            Certificate certificate = certificateArray[0];
            if (certificate == null) break block8;
            X509Certificate x509Certificate = (X509Certificate)certificate;
            return this.c((String)object, x509Certificate);
        }
        String string2 = "null cannot be cast to non-null type java.security.cert.X509Certificate";
        object = new NullPointerException(string2);
        throw object;
    }
}

