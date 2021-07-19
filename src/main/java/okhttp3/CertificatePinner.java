/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.s.a;
import f.h2.t.f0;
import f.h2.t.t0;
import f.h2.t.u;
import g.h0.p.c;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.CertificatePinner$a;
import okhttp3.CertificatePinner$b;
import okhttp3.CertificatePinner$c;
import okhttp3.CertificatePinner$check$1;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner c;
    public static final CertificatePinner$b d;
    private final Set a;
    private final c b;

    static {
        Object object = new CertificatePinner$b(null);
        d = object;
        object = new CertificatePinner$a();
        c = ((CertificatePinner$a)object).b();
    }

    public CertificatePinner(Set set, c c10) {
        f0.p(set, "pins");
        this.a = set;
        this.b = c10;
    }

    public /* synthetic */ CertificatePinner(Set set, c c10, int n10, u u10) {
        if ((n10 &= 2) != 0) {
            c10 = null;
        }
        this(set, c10);
    }

    public static final String g(Certificate certificate) {
        return d.a(certificate);
    }

    public static final ByteString h(X509Certificate x509Certificate) {
        return d.b(x509Certificate);
    }

    public static final ByteString i(X509Certificate x509Certificate) {
        return d.c(x509Certificate);
    }

    public final void a(String string2, List list) {
        f0.p(string2, "hostname");
        f0.p(list, "peerCertificates");
        CertificatePinner$check$1 certificatePinner$check$1 = new CertificatePinner$check$1(this, list, string2);
        this.c(string2, certificatePinner$check$1);
    }

    public final void b(String string2, Certificate ... object) {
        f0.p(string2, "hostname");
        f0.p(object, "peerCertificates");
        object = ArraysKt___ArraysKt.uy(object);
        this.a(string2, (List)object);
    }

    public final void c(String object, a object2) {
        boolean bl2;
        Object object3;
        Object object4;
        boolean bl3;
        f0.p(object, "hostname");
        f0.p(object2, "cleanedPeerCertificatesFn");
        Object object5 = this.d((String)object);
        boolean bl4 = object5.isEmpty();
        if (bl4) {
            return;
        }
        object2 = (List)object2.invoke();
        Object object6 = object2.iterator();
        while (bl3 = object6.hasNext()) {
            boolean bl5;
            object4 = (X509Certificate)object6.next();
            object3 = object5.iterator();
            ByteString byteString = null;
            ByteString byteString2 = null;
            while (bl5 = object3.hasNext()) {
                String string2;
                boolean bl6;
                int n10;
                Object object7 = (CertificatePinner$c)object3.next();
                String string3 = ((CertificatePinner$c)object7).b();
                int n11 = string3.hashCode();
                if (n11 != (n10 = -903629273)) {
                    n10 = 3528965;
                    if (n11 == n10 && (bl6 = string3.equals(string2 = "sha1"))) {
                        if (byteString2 == null) {
                            byteString2 = d.b((X509Certificate)object4);
                        }
                        if (!(bl5 = f0.g(object7 = ((CertificatePinner$c)object7).a(), byteString2))) continue;
                        return;
                    }
                } else {
                    string2 = "sha256";
                    bl6 = string3.equals(string2);
                    if (bl6) {
                        if (byteString == null) {
                            byteString = d.c((X509Certificate)object4);
                        }
                        if (!(bl5 = f0.g(object7 = ((CertificatePinner$c)object7).a(), byteString))) continue;
                        return;
                    }
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("unsupported hashAlgorithm: ");
                object5 = ((CertificatePinner$c)object7).b();
                ((StringBuilder)object2).append((String)object5);
                object2 = ((StringBuilder)object2).toString();
                object = new AssertionError(object2);
                throw object;
            }
        }
        object6 = new StringBuilder();
        ((StringBuilder)object6).append("Certificate pinning failure!");
        object4 = "\n  Peer certificate chain:";
        ((StringBuilder)object6).append((String)object4);
        object2 = object2.iterator();
        while (true) {
            bl3 = object2.hasNext();
            object3 = "\n    ";
            if (!bl3) break;
            object4 = (X509Certificate)object2.next();
            ((StringBuilder)object6).append((String)object3);
            object3 = d.a((Certificate)object4);
            ((StringBuilder)object6).append((String)object3);
            ((StringBuilder)object6).append(": ");
            object4 = ((X509Certificate)object4).getSubjectDN();
            object3 = "element.subjectDN";
            f0.o(object4, (String)object3);
            object4 = object4.getName();
            ((StringBuilder)object6).append((String)object4);
        }
        object2 = "\n  Pinned certificates for ";
        ((StringBuilder)object6).append((String)object2);
        ((StringBuilder)object6).append((String)object);
        ((StringBuilder)object6).append(":");
        object = object5.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (CertificatePinner$c)object.next();
            ((StringBuilder)object6).append((String)object3);
            ((StringBuilder)object6).append(object2);
        }
        object = ((StringBuilder)object6).toString();
        f0.o(object, "StringBuilder().apply(builderAction).toString()");
        object2 = new SSLPeerUnverifiedException((String)object);
        throw object2;
    }

    public final List d(String string2) {
        boolean bl2;
        f0.p(string2, "hostname");
        Object object = this.a;
        ArrayList arrayList = CollectionsKt__CollectionsKt.E();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Object object2 = e10;
            object2 = (CertificatePinner$c)e10;
            boolean bl3 = ((CertificatePinner$c)object2).e(string2);
            if (!bl3) continue;
            bl3 = arrayList.isEmpty();
            if (bl3) {
                arrayList = new ArrayList();
            }
            Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<T>");
            object2 = t0.g(arrayList);
            object2.add(e10);
        }
        return arrayList;
    }

    public final c e() {
        return this.b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof CertificatePinner;
        if (!bl2) return false;
        object = (CertificatePinner)object;
        Object object2 = ((CertificatePinner)object).a;
        Set set = this.a;
        bl2 = f0.g(object2, set);
        if (!bl2) return false;
        object = ((CertificatePinner)object).b;
        object2 = this.b;
        boolean bl3 = f0.g(object, object2);
        if (!bl3) return false;
        return true;
    }

    public final Set f() {
        return this.a;
    }

    public int hashCode() {
        int n10 = ((Object)this.a).hashCode();
        int n11 = (1517 + n10) * 41;
        c c10 = this.b;
        if (c10 != null) {
            n10 = c10.hashCode();
        } else {
            n10 = 0;
            c10 = null;
        }
        return n11 + n10;
    }

    public final CertificatePinner j(c c10) {
        f0.p(c10, "certificateChainCleaner");
        Object object = this.b;
        boolean bl2 = f0.g(object, c10);
        if (bl2) {
            object = this;
        } else {
            Set set = this.a;
            object = new CertificatePinner(set, c10);
        }
        return object;
    }
}

