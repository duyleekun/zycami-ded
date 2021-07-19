/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.d;
import g.h0.n.i.f;
import g.h0.n.i.l$a;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public final class l
extends f {
    public static final l$a j;
    private final Class h;
    private final Class i;

    static {
        l$a l$a;
        j = l$a = new l$a(null);
    }

    public l(Class clazz, Class clazz2, Class clazz3) {
        f0.p(clazz, "sslSocketClass");
        f0.p(clazz2, "sslSocketFactoryClass");
        f0.p(clazz3, "paramClass");
        super(clazz);
        this.h = clazz2;
        this.i = clazz3;
    }

    public X509TrustManager d(SSLSocketFactory object) {
        f0.p(object, "sslSocketFactory");
        Object object2 = this.i;
        object = d.Q(object, (Class)object2, "sslParameters");
        f0.m(object);
        String string2 = "x509TrustManager";
        object2 = (X509TrustManager)d.Q(object, X509TrustManager.class, string2);
        if (object2 == null) {
            string2 = "trustManager";
            object2 = object = d.Q(object, X509TrustManager.class, string2);
            object2 = (X509TrustManager)object;
        }
        return object2;
    }

    public boolean e(SSLSocketFactory sSLSocketFactory) {
        f0.p(sSLSocketFactory, "sslSocketFactory");
        return this.h.isInstance(sSLSocketFactory);
    }
}

