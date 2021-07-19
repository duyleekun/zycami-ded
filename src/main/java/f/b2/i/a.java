/*
 * Decompiled with CFR 0.151.
 */
package f.b2.i;

import java.util.concurrent.CancellationException;

public final class a {
    private static final CancellationException a(String string2, Throwable throwable) {
        CancellationException cancellationException = new CancellationException(string2);
        cancellationException.initCause(throwable);
        return cancellationException;
    }

    private static final CancellationException b(Throwable throwable) {
        String string2 = throwable != null ? throwable.toString() : null;
        CancellationException cancellationException = new CancellationException(string2);
        cancellationException.initCause(throwable);
        return cancellationException;
    }

    public static /* synthetic */ void c() {
    }
}

