/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.l.g;
import h.k;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.internal.http2.ErrorCode;

public final class g$d
extends k {
    public final /* synthetic */ g n;

    public g$d(g g10) {
        this.n = g10;
    }

    public void B() {
        g g10 = this.n;
        ErrorCode errorCode = ErrorCode.CANCEL;
        g10.f(errorCode);
        this.n.h().b1();
    }

    public final void D() {
        boolean bl2 = this.w();
        if (!bl2) {
            return;
        }
        throw this.x(null);
    }

    public IOException x(IOException iOException) {
        String string2 = "timeout";
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(string2);
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}

