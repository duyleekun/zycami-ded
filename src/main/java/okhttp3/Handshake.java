/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.s.a;
import f.h2.t.f0;
import f.t;
import f.w;
import f.x1.u;
import g.h;
import java.io.Serializable;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okhttp3.Handshake$Companion;
import okhttp3.TlsVersion;

public final class Handshake {
    public static final Handshake$Companion e;
    private final t a;
    private final TlsVersion b;
    private final h c;
    private final List d;

    static {
        Handshake$Companion handshake$Companion;
        e = handshake$Companion = new Handshake$Companion(null);
    }

    public Handshake(TlsVersion object, h h10, List list, a a10) {
        f0.p(object, "tlsVersion");
        f0.p(h10, "cipherSuite");
        f0.p(list, "localCertificates");
        f0.p(a10, "peerCertificatesFn");
        this.b = object;
        this.c = h10;
        this.d = list;
        super(a10);
        object = w.c((a)object);
        this.a = object;
    }

    public static final Handshake h(SSLSession sSLSession) {
        return e.b(sSLSession);
    }

    public static final Handshake i(TlsVersion tlsVersion, h h10, List list, List list2) {
        return e.c(tlsVersion, h10, list, list2);
    }

    private final String j(Certificate object) {
        boolean bl2 = object instanceof X509Certificate;
        if (bl2) {
            object = ((Object)((X509Certificate)object).getSubjectDN()).toString();
        } else {
            object = ((Certificate)object).getType();
            String string2 = "type";
            f0.o(object, string2);
        }
        return object;
    }

    public final h a() {
        return this.c;
    }

    public final List b() {
        return this.d;
    }

    public final Principal c() {
        return this.l();
    }

    public final List d() {
        return this.m();
    }

    public final Principal e() {
        return this.n();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        List list;
        boolean bl2 = object instanceof Handshake;
        if (!bl2) return false;
        object = (Handshake)object;
        TlsVersion tlsVersion = ((Handshake)object).b;
        TlsVersion tlsVersion2 = this.b;
        if (tlsVersion != tlsVersion2) return false;
        h h10 = ((Handshake)object).c;
        h h11 = this.c;
        bl2 = f0.g(h10, h11);
        if (!bl2) return false;
        List list2 = ((Handshake)object).m();
        bl2 = f0.g(list2, list = this.m());
        if (!bl2) return false;
        object = ((Handshake)object).d;
        List list3 = this.d;
        boolean bl3 = f0.g(object, list3);
        if (!bl3) return false;
        return true;
    }

    public final TlsVersion f() {
        return this.b;
    }

    public final h g() {
        return this.c;
    }

    public int hashCode() {
        int n10 = this.b.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = this.c.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = ((Object)this.m()).hashCode();
        n11 = (n11 + n10) * 31;
        n10 = ((Object)this.d).hashCode();
        return n11 + n10;
    }

    public final List k() {
        return this.d;
    }

    public final Principal l() {
        Object object = CollectionsKt___CollectionsKt.r2(this.d);
        boolean bl2 = object instanceof X509Certificate;
        X500Principal x500Principal = null;
        if (!bl2) {
            object = null;
        }
        if ((object = (X509Certificate)object) != null) {
            x500Principal = ((X509Certificate)object).getSubjectX500Principal();
        }
        return x500Principal;
    }

    public final List m() {
        return (List)this.a.getValue();
    }

    public final Principal n() {
        Object object = CollectionsKt___CollectionsKt.r2(this.m());
        boolean bl2 = object instanceof X509Certificate;
        X500Principal x500Principal = null;
        if (!bl2) {
            object = null;
        }
        if ((object = (X509Certificate)object) != null) {
            x500Principal = ((X509Certificate)object).getSubjectX500Principal();
        }
        return x500Principal;
    }

    public final TlsVersion o() {
        return this.b;
    }

    public String toString() {
        Object object;
        boolean bl2;
        Iterator iterator2 = this.m();
        int n10 = 10;
        int c10 = u.Y((Iterable)((Object)iterator2), n10);
        Serializable serializable = new ArrayList(c10);
        iterator2 = iterator2.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Certificate)iterator2.next();
            object = this.j((Certificate)object);
            serializable.add(object);
        }
        iterator2 = serializable.toString();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("Handshake{");
        ((StringBuilder)serializable).append("tlsVersion=");
        object = this.b;
        ((StringBuilder)serializable).append(object);
        char c11 = ' ';
        ((StringBuilder)serializable).append(c11);
        ((StringBuilder)serializable).append("cipherSuite=");
        Object object2 = this.c;
        ((StringBuilder)serializable).append(object2);
        ((StringBuilder)serializable).append(c11);
        object2 = "peerCertificates=";
        ((StringBuilder)serializable).append((String)object2);
        ((StringBuilder)serializable).append((String)((Object)iterator2));
        ((StringBuilder)serializable).append(c11);
        ((StringBuilder)serializable).append("localCertificates=");
        iterator2 = this.d;
        n10 = u.Y((Iterable)((Object)iterator2), n10);
        object = new ArrayList(n10);
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object3 = (Certificate)iterator2.next();
            object3 = this.j((Certificate)object3);
            object.add(object3);
        }
        ((StringBuilder)serializable).append(object);
        ((StringBuilder)serializable).append('}');
        return ((StringBuilder)serializable).toString();
    }
}

