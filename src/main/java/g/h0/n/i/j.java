/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import g.h0.n.i.k$a;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public final class j
implements k {
    private k a;
    private final j$a b;

    public j(j$a j$a) {
        f0.p(j$a, "socketAdapterFactory");
        this.b = j$a;
    }

    private final k g(SSLSocket object) {
        synchronized (this) {
            boolean bl2;
            Object object2 = this.a;
            if (object2 == null && (bl2 = (object2 = this.b).a((SSLSocket)object))) {
                object2 = this.b;
                this.a = object = object2.b((SSLSocket)object);
            }
            object = this.a;
            return object;
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        f0.p(sSLSocket, "sslSocket");
        return this.b.a(sSLSocket);
    }

    public boolean b() {
        return true;
    }

    public String c(SSLSocket object) {
        f0.p(object, "sslSocket");
        k k10 = this.g((SSLSocket)object);
        object = k10 != null ? k10.c((SSLSocket)object) : null;
        return object;
    }

    public X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        f0.p(sSLSocketFactory, "sslSocketFactory");
        return k$a.b(this, sSLSocketFactory);
    }

    public boolean e(SSLSocketFactory sSLSocketFactory) {
        f0.p(sSLSocketFactory, "sslSocketFactory");
        return k$a.a(this, sSLSocketFactory);
    }

    public void f(SSLSocket sSLSocket, String string2, List list) {
        f0.p(sSLSocket, "sslSocket");
        f0.p(list, "protocols");
        k k10 = this.g(sSLSocket);
        if (k10 != null) {
            k10.f(sSLSocket, string2, list);
        }
    }
}

