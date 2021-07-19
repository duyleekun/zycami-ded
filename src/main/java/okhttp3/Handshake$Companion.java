/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.t.f0;
import f.h2.t.u;
import g.h;
import g.h0.d;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.Handshake;
import okhttp3.Handshake$Companion$get$1;
import okhttp3.Handshake$Companion$handshake$1;
import okhttp3.TlsVersion;

public final class Handshake$Companion {
    private Handshake$Companion() {
    }

    public /* synthetic */ Handshake$Companion(u u10) {
        this();
    }

    private final List d(Certificate[] object) {
        if (object != null) {
            int n10 = ((Certificate[])object).length;
            object = d.z(Arrays.copyOf(object, n10));
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public final Handshake a(SSLSession sSLSession) {
        f0.p(sSLSession, "sslSession");
        return this.b(sSLSession);
    }

    public final Handshake b(SSLSession object) {
        f0.p(object, "$this$handshake");
        Object object2 = object.getCipherSuite();
        if (object2 != null) {
            Object object3;
            int n10;
            int n11 = ((String)object2).hashCode();
            if (n11 != (n10 = 1019404634) ? n11 != (n10 = 1208658923) || (n11 = (int)(((String)object2).equals(object3 = "SSL_NULL_WITH_NULL_NULL") ? 1 : 0)) == 0 : (n11 = (int)(((String)object2).equals(object3 = "TLS_NULL_WITH_NULL_NULL") ? 1 : 0)) == 0) {
                object2 = h.s1.b((String)object2);
                object3 = object.getProtocol();
                if (object3 != null) {
                    Object object4 = "NONE";
                    n10 = (int)(f0.g(object4, object3) ? 1 : 0);
                    if (n10 == 0) {
                        object4 = TlsVersion.Companion;
                        object3 = object4.a((String)object3);
                        object4 = object.getPeerCertificates();
                        try {
                            object4 = this.d((Certificate[])object4);
                        }
                        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
                            object4 = CollectionsKt__CollectionsKt.E();
                        }
                        object = object.getLocalCertificates();
                        object = this.d((Certificate[])object);
                        Handshake$Companion$handshake$1 handshake$Companion$handshake$1 = new Handshake$Companion$handshake$1((List)object4);
                        Handshake handshake2 = new Handshake((TlsVersion)((Object)object3), (h)object2, (List)object, handshake$Companion$handshake$1);
                        return handshake2;
                    }
                    object = new IOException("tlsVersion == NONE");
                    throw object;
                }
                object2 = "tlsVersion == null".toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("cipherSuite == ");
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object = new IOException((String)object2);
            throw object;
        }
        object2 = "cipherSuite == null".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public final Handshake c(TlsVersion tlsVersion, h h10, List list, List list2) {
        f0.p((Object)tlsVersion, "tlsVersion");
        f0.p(h10, "cipherSuite");
        f0.p(list, "peerCertificates");
        f0.p(list2, "localCertificates");
        list = d.c0(list);
        list2 = d.c0(list2);
        Handshake$Companion$get$1 handshake$Companion$get$1 = new Handshake$Companion$get$1(list);
        Handshake handshake2 = new Handshake(tlsVersion, h10, list2, handshake$Companion$get$1);
        return handshake2;
    }
}

