/*
 * Decompiled with CFR 0.151.
 */
package g.h0.o;

import f.x1.t;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;

public final class a
extends ProxySelector {
    public static final a a;

    static {
        a a10;
        a = a10 = new a();
    }

    private a() {
    }

    public void connectFailed(URI uRI, SocketAddress socketAddress, IOException iOException) {
    }

    public List select(URI serializable) {
        if (serializable != null) {
            return t.k(Proxy.NO_PROXY);
        }
        String string2 = "uri must not be null".toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }
}

