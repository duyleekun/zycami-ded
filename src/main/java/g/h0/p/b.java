/*
 * Decompiled with CFR 0.151.
 */
package g.h0.p;

import f.h2.t.f0;
import g.h0.p.e;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class b
implements e {
    private final Map a;

    public b(X509Certificate ... x509CertificateArray) {
        f0.p(x509CertificateArray, "caCerts");
        LinkedHashMap<X500Principal, Object> linkedHashMap = new LinkedHashMap<X500Principal, Object>();
        for (X509Certificate x509Certificate : x509CertificateArray) {
            X500Principal x500Principal = x509Certificate.getSubjectX500Principal();
            f0.o(x500Principal, "caCert.subjectX500Principal");
            Object object = linkedHashMap.get(x500Principal);
            if (object == null) {
                linkedHashMap.put(x500Principal, object);
            }
            object = (Set)object;
            object.add((X509Certificate)x509Certificate);
        }
        this.a = linkedHashMap;
    }

    public X509Certificate a(X509Certificate x509Certificate) {
        f0.p(x509Certificate, "cert");
        Iterator iterator2 = x509Certificate.getIssuerX500Principal();
        iterator2 = (Set)this.a.get(iterator2);
        X509Certificate x509Certificate2 = null;
        if (iterator2 != null) {
            boolean bl2;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                boolean bl3;
                Object t10 = iterator2.next();
                Object object = t10;
                object = (X509Certificate)t10;
                object = ((Certificate)object).getPublicKey();
                try {
                    x509Certificate.verify((PublicKey)object);
                    bl3 = true;
                }
                catch (Exception exception) {
                    bl3 = false;
                    object = null;
                }
                if (!bl3) continue;
                x509Certificate2 = t10;
                break;
            }
            x509Certificate2 = x509Certificate2;
        }
        return x509Certificate2;
    }

    public boolean equals(Object object) {
        Map map;
        boolean bl2;
        boolean bl3;
        if (!(object == this || (bl3 = object instanceof b) && (bl2 = f0.g(object = ((b)object).a, map = this.a)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        return ((Object)this.a).hashCode();
    }
}

