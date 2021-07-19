/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.t.f0;
import f.h2.t.u;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public final class RouteSelector$a {
    private RouteSelector$a() {
    }

    public /* synthetic */ RouteSelector$a(u u10) {
        this();
    }

    public final String a(InetSocketAddress object) {
        f0.p(object, "$this$socketHost");
        InetAddress inetAddress = ((InetSocketAddress)object).getAddress();
        if (inetAddress != null) {
            object = inetAddress.getHostAddress();
            f0.o(object, "address.hostAddress");
            return object;
        }
        object = ((InetSocketAddress)object).getHostName();
        f0.o(object, "hostName");
        return object;
    }
}

