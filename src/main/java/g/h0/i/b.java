/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import g.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

public final class b {
    private int a;
    private boolean b;
    private boolean c;
    private final List d;

    public b(List list) {
        f0.p(list, "connectionSpecs");
        this.d = list;
    }

    private final boolean c(SSLSocket sSLSocket) {
        List list = this.d;
        int n10 = list.size();
        for (int i10 = this.a; i10 < n10; ++i10) {
            k k10 = (k)this.d.get(i10);
            boolean bl2 = k10.h(sSLSocket);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final k a(SSLSocket object) {
        char c10;
        k k10;
        int n10;
        Object object2;
        Object object3;
        block2: {
            object3 = "sslSocket";
            f0.p(object, (String)object3);
            object2 = this.d;
            int n11 = object2.size();
            for (n10 = this.a; n10 < n11; n10 += 1) {
                k10 = (k)this.d.get(n10);
                boolean bl2 = k10.h((SSLSocket)object);
                if (!bl2) continue;
                this.a = n10 += 1;
                break block2;
            }
            c10 = '\u0000';
            k10 = null;
        }
        if (k10 != null) {
            this.b = n10 = (int)(this.c((SSLSocket)object) ? 1 : 0);
            n10 = (int)(this.c ? 1 : 0);
            k10.f((SSLSocket)object, n10 != 0);
            return k10;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unable to find acceptable protocols. isFallback=");
        c10 = this.c;
        ((StringBuilder)object2).append(c10 != 0);
        c10 = ',';
        ((StringBuilder)object2).append(c10);
        ((StringBuilder)object2).append(" modes=");
        List list = this.d;
        ((StringBuilder)object2).append(list);
        ((StringBuilder)object2).append(c10);
        ((StringBuilder)object2).append(" supported protocols=");
        object = object.getEnabledProtocols();
        f0.m(object);
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object3 = new UnknownServiceException((String)object);
        throw object3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean b(IOException iOException) {
        Throwable throwable;
        boolean bl2;
        String string2 = "e";
        f0.p(iOException, string2);
        this.c = bl2 = true;
        boolean bl3 = this.b;
        if (!bl3) return false;
        bl3 = iOException instanceof ProtocolException;
        if (!(bl3 || (bl3 = iOException instanceof InterruptedIOException) || (bl3 = iOException instanceof SSLHandshakeException) && (bl3 = (throwable = iOException.getCause()) instanceof CertificateException) || (bl3 = iOException instanceof SSLPeerUnverifiedException))) {
            boolean bl4 = iOException instanceof SSLException;
            if (bl4) return bl2;
        }
        return false;
    }
}

