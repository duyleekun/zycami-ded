/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.jsse.BCSSLParameters
 *  org.bouncycastle.jsse.BCSSLSocket
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.c;
import g.h0.n.h;
import g.h0.n.i.g$a;
import g.h0.n.i.g$b;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import g.h0.n.i.k$a;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

public final class g
implements k {
    private static final j$a a;
    public static final g$b b;

    static {
        Object object = new g$b(null);
        b = object;
        a = object = new g$a();
    }

    public static final /* synthetic */ j$a g() {
        return a;
    }

    public boolean a(SSLSocket sSLSocket) {
        f0.p(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    public boolean b() {
        return c.h.b();
    }

    public String c(SSLSocket object) {
        int n10;
        String string2 = "sslSocket";
        f0.p(object, string2);
        object = ((BCSSLSocket)object).getApplicationProtocol();
        if (object == null || (n10 = ((String)object).hashCode()) == 0 && (n10 = (int)(((String)object).equals(string2 = "") ? 1 : 0)) != 0) {
            object = null;
        }
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

    public void f(SSLSocket sSLSocket, String string2, List stringArray) {
        f0.p(sSLSocket, "sslSocket");
        string2 = "protocols";
        f0.p(stringArray, string2);
        boolean bl2 = this.a(sSLSocket);
        if (bl2) {
            sSLSocket = (BCSSLSocket)sSLSocket;
            string2 = sSLSocket.getParameters();
            f0.o(string2, "sslParameters");
            stringArray = h.e.b((List)stringArray);
            Object object = new String[]{};
            stringArray = stringArray.toArray((T[])object);
            object = "null cannot be cast to non-null type kotlin.Array<T>";
            Objects.requireNonNull(stringArray, (String)object);
            string2.setApplicationProtocols(stringArray);
            sSLSocket.setParameters((BCSSLParameters)string2);
        }
    }
}

