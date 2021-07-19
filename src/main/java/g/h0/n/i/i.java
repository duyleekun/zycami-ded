/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.conscrypt.Conscrypt
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.d;
import g.h0.n.h;
import g.h0.n.i.i$a;
import g.h0.n.i.i$b;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import g.h0.n.i.k$a;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

public final class i
implements k {
    private static final j$a a;
    public static final i$b b;

    static {
        Object object = new i$b(null);
        b = object;
        a = object = new i$a();
    }

    public static final /* synthetic */ j$a g() {
        return a;
    }

    public boolean a(SSLSocket sSLSocket) {
        f0.p(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt((SSLSocket)sSLSocket);
    }

    public boolean b() {
        return d.h.d();
    }

    public String c(SSLSocket object) {
        String string2 = "sslSocket";
        f0.p(object, string2);
        boolean bl2 = this.a((SSLSocket)object);
        object = bl2 ? Conscrypt.getApplicationProtocol((SSLSocket)object) : null;
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

    public void f(SSLSocket sSLSocket, String stringArray, List object) {
        f0.p(sSLSocket, "sslSocket");
        stringArray = "protocols";
        f0.p(object, (String)stringArray);
        boolean bl2 = this.a(sSLSocket);
        if (bl2) {
            bl2 = true;
            Conscrypt.setUseSessionTickets((SSLSocket)sSLSocket, (boolean)bl2);
            stringArray = h.e.b((List)object);
            object = new String[]{};
            stringArray = stringArray.toArray((T[])object);
            object = "null cannot be cast to non-null type kotlin.Array<T>";
            Objects.requireNonNull(stringArray, (String)object);
            Conscrypt.setApplicationProtocols((SSLSocket)sSLSocket, (String[])stringArray);
        }
    }
}

