/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.conscrypt.Conscrypt
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.d;
import g.h0.n.d$a;
import g.h0.n.i.i;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

public final class i$a
implements j$a {
    public boolean a(SSLSocket sSLSocket) {
        boolean bl2;
        f0.p(sSLSocket, "sslSocket");
        d$a d$a = d.h;
        boolean bl3 = d$a.d();
        if (bl3 && (bl2 = Conscrypt.isConscrypt((SSLSocket)sSLSocket))) {
            bl2 = true;
        } else {
            bl2 = false;
            sSLSocket = null;
        }
        return bl2;
    }

    public k b(SSLSocket object) {
        f0.p(object, "sslSocket");
        object = new i();
        return object;
    }
}

