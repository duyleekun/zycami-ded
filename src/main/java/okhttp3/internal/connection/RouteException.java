/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.t.f0;
import f.k;
import java.io.IOException;

public final class RouteException
extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    public RouteException(IOException iOException) {
        f0.p(iOException, "firstConnectException");
        super(iOException);
        this.firstConnectException = iOException;
        this.lastConnectException = iOException;
    }

    public final void addConnectException(IOException iOException) {
        f0.p(iOException, "e");
        k.a(this.firstConnectException, iOException);
        this.lastConnectException = iOException;
    }

    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }
}

