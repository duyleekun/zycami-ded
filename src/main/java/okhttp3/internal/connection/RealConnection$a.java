/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.t.f0;
import f.h2.t.u;
import g.e0;
import g.h0.i.g;
import java.net.Socket;
import okhttp3.internal.connection.RealConnection;

public final class RealConnection$a {
    private RealConnection$a() {
    }

    public /* synthetic */ RealConnection$a(u u10) {
        this();
    }

    public final RealConnection a(g g10, e0 e02, Socket socket, long l10) {
        f0.p(g10, "connectionPool");
        f0.p(e02, "route");
        f0.p(socket, "socket");
        RealConnection realConnection = new RealConnection(g10, e02);
        RealConnection.j(realConnection, socket);
        realConnection.I(l10);
        return realConnection;
    }
}

