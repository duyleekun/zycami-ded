/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import java.io.Closeable;
import java.io.IOException;

public final class u1 {
    private u1() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

