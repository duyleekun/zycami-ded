/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.a0;
import h.k;
import h.z;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class l0
extends k {
    private final Socket n;

    public l0(Socket socket) {
        f0.p(socket, "socket");
        this.n = socket;
    }

    public void B() {
        block5: {
            Object object = "Failed to close timed out socket ";
            Socket socket = this.n;
            try {
                socket.close();
            }
            catch (AssertionError assertionError) {
                boolean bl2 = z.e(assertionError);
                if (bl2) {
                    Logger logger = a0.a();
                    Level level = Level.WARNING;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String)object);
                    object = this.n;
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    logger.log(level, (String)object, (Throwable)((Object)assertionError));
                    break block5;
                }
                throw assertionError;
            }
            catch (Exception exception) {
                Logger logger = a0.a();
                Level level = Level.WARNING;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object);
                object = this.n;
                stringBuilder.append(object);
                object = stringBuilder.toString();
                logger.log(level, (String)object, exception);
            }
        }
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

