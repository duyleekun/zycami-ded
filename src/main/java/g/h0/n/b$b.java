/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n;

import f.h2.t.f0;
import g.h0.p.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class b$b
implements e {
    private final X509TrustManager a;
    private final Method b;

    public b$b(X509TrustManager x509TrustManager, Method method) {
        f0.p(x509TrustManager, "trustManager");
        f0.p(method, "findByIssuerAndSignatureMethod");
        this.a = x509TrustManager;
        this.b = method;
    }

    private final X509TrustManager b() {
        return this.a;
    }

    private final Method c() {
        return this.b;
    }

    public static /* synthetic */ b$b e(b$b b$b, X509TrustManager x509TrustManager, Method method, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            x509TrustManager = b$b.a;
        }
        if ((n10 &= 2) != 0) {
            method = b$b.b;
        }
        return b$b.d(x509TrustManager, method);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public X509Certificate a(X509Certificate object) {
        Object object2;
        block12: {
            object2 = "cert";
            f0.p(object, (String)object2);
            object2 = this.b;
            X509TrustManager x509TrustManager = this.a;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            object = ((Method)object2).invoke(x509TrustManager, objectArray);
            if (object == null) break block12;
            object = (TrustAnchor)object;
            return ((TrustAnchor)object).getTrustedCert();
        }
        object2 = "null cannot be cast to non-null type java.security.cert.TrustAnchor";
        try {
            object = new NullPointerException((String)object2);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new AssertionError("unable to get issues and signature", illegalAccessException);
            throw object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            return null;
        }
    }

    public final b$b d(X509TrustManager x509TrustManager, Method method) {
        f0.p(x509TrustManager, "trustManager");
        f0.p(method, "findByIssuerAndSignatureMethod");
        b$b b$b = new b$b(x509TrustManager, method);
        return b$b;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                if (this == object) break block2;
                boolean bl3 = object instanceof b$b;
                if (!bl3) break block3;
                object = (b$b)object;
                Object object2 = this.a;
                X509TrustManager x509TrustManager = ((b$b)object).a;
                bl3 = f0.g(object2, x509TrustManager);
                if (bl3 && (bl2 = f0.g(object2 = this.b, object = ((b$b)object).b))) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n10;
        X509TrustManager x509TrustManager = this.a;
        int n11 = 0;
        if (x509TrustManager != null) {
            n10 = x509TrustManager.hashCode();
        } else {
            n10 = 0;
            x509TrustManager = null;
        }
        n10 *= 31;
        Method method = this.b;
        if (method != null) {
            n11 = ((Object)method).hashCode();
        }
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomTrustRootIndex(trustManager=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", findByIssuerAndSignatureMethod=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

