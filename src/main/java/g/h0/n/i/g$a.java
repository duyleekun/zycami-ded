/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.jsse.BCSSLSocket
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.c;
import g.h0.n.c$a;
import g.h0.n.i.g;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLSocket;

public final class g$a
implements j$a {
    public boolean a(SSLSocket sSLSocket) {
        boolean bl2;
        f0.p(sSLSocket, "sslSocket");
        c$a c$a = c.h;
        boolean bl3 = c$a.b();
        if (bl3 && (bl2 = sSLSocket instanceof BCSSLSocket)) {
            bl2 = true;
        } else {
            bl2 = false;
            sSLSocket = null;
        }
        return bl2;
    }

    public k b(SSLSocket object) {
        f0.p(object, "sslSocket");
        object = new g();
        return object;
    }
}

