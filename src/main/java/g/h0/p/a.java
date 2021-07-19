/*
 * Decompiled with CFR 0.151.
 */
package g.h0.p;

import f.h2.t.f0;
import g.h0.p.a$a;
import g.h0.p.c;
import g.h0.p.e;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class a
extends c {
    private static final int c = 9;
    public static final a$a d;
    private final e b;

    static {
        a$a a$a;
        d = a$a = new a$a(null);
    }

    public a(e e10) {
        f0.p(e10, "trustRootIndex");
        this.b = e10;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate serializable) {
        Principal principal = x509Certificate.getIssuerDN();
        Principal principal2 = serializable.getSubjectDN();
        boolean bl2 = f0.g(principal, principal2);
        boolean bl3 = true;
        if (bl2 ^= bl3) {
            return false;
        }
        serializable = serializable.getPublicKey();
        try {
            x509Certificate.verify((PublicKey)serializable);
        }
        catch (GeneralSecurityException generalSecurityException) {
            bl3 = false;
            principal2 = null;
        }
        return bl3;
    }

    public List a(List object, String object2) {
        int n10;
        f0.p(object, "chain");
        f0.p(object2, "hostname");
        object2 = new ArrayDeque(object);
        object = new ArrayList();
        Object object3 = object2.removeFirst();
        f0.o(object3, "queue.removeFirst()");
        object.add(object3);
        object3 = null;
        int n11 = 0;
        block0: for (int i10 = 0; i10 < (n10 = 9); ++i10) {
            boolean bl2;
            n10 = object.size();
            int n12 = 1;
            Object object4 = object.get(n10 -= n12);
            String string2 = "null cannot be cast to non-null type java.security.cert.X509Certificate";
            Objects.requireNonNull(object4, string2);
            object4 = (X509Certificate)object4;
            Object object5 = this.b.a((X509Certificate)object4);
            if (object5 != null) {
                n11 = object.size();
                if (n11 > n12 || (n11 = f0.g(object4, object5) ^ n12) != 0) {
                    object.add(object5);
                }
                if ((n11 = (int)(this.b((X509Certificate)object5, (X509Certificate)object5) ? 1 : 0)) != 0) {
                    return object;
                }
                n11 = n12;
                continue;
            }
            Iterator iterator2 = object2.iterator();
            object5 = "queue.iterator()";
            f0.o(iterator2, (String)object5);
            while (bl2 = iterator2.hasNext()) {
                object5 = iterator2.next();
                Objects.requireNonNull(object5, string2);
                boolean bl3 = this.b((X509Certificate)object4, (X509Certificate)(object5 = (X509Certificate)object5));
                if (!bl3) continue;
                iterator2.remove();
                object.add(object5);
                continue block0;
            }
            if (n11 != 0) {
                return object;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to find a trusted cert that signed ");
            ((StringBuilder)object2).append(object4);
            object2 = ((StringBuilder)object2).toString();
            object = new SSLPeerUnverifiedException((String)object2);
            throw object;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Certificate chain too long: ");
        ((StringBuilder)object3).append(object);
        object = ((StringBuilder)object3).toString();
        object2 = new SSLPeerUnverifiedException((String)object);
        throw object2;
    }

    public boolean equals(Object object) {
        e e10;
        boolean bl2;
        boolean bl3;
        boolean bl4 = true;
        if (!(object == this || (bl3 = object instanceof a) && (bl2 = f0.g(object = ((a)object).b, e10 = this.b)))) {
            bl4 = false;
        }
        return bl4;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}

