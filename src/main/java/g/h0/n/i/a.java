/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.ssl.SSLSockets
 */
package g.h0.n.i;

import android.net.ssl.SSLSockets;
import f.h2.t.f0;
import g.h0.n.h;
import g.h0.n.i.a$a;
import g.h0.n.i.k;
import g.h0.n.i.k$a;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public final class a
implements k {
    public static final a$a a;

    static {
        a$a a$a;
        a = a$a = new a$a(null);
    }

    public boolean a(SSLSocket sSLSocket) {
        f0.p(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket((SSLSocket)sSLSocket);
    }

    public boolean b() {
        return a.b();
    }

    public String c(SSLSocket object) {
        int n10;
        String string2 = "sslSocket";
        f0.p(object, string2);
        object = ((SSLSocket)object).getApplicationProtocol();
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

    public void f(SSLSocket object, String object2, List object3) {
        block10: {
            String[] stringArray;
            f0.p(object, "sslSocket");
            object2 = "protocols";
            f0.p(object3, (String)object2);
            boolean bl2 = true;
            try {
                SSLSockets.setUseSessionTickets((SSLSocket)object, (boolean)bl2);
                object2 = ((SSLSocket)object).getSSLParameters();
                stringArray = "sslParameters";
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = new IOException("Android internal error", illegalArgumentException);
                throw object2;
            }
            f0.o(object2, (String)stringArray);
            stringArray = h.e;
            object3 = stringArray.b((List)object3);
            stringArray = null;
            stringArray = new String[]{};
            object3 = object3.toArray(stringArray);
            if (object3 == null) break block10;
            object3 = (String[])object3;
            ((SSLParameters)object2).setApplicationProtocols((String[])object3);
            ((SSLSocket)object).setSSLParameters((SSLParameters)object2);
            return;
        }
        object2 = "null cannot be cast to non-null type kotlin.Array<T>";
        object = new NullPointerException((String)object2);
        throw object;
    }
}

