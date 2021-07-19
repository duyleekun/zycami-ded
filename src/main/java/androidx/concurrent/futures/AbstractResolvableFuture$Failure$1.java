/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

public final class AbstractResolvableFuture$Failure$1
extends Throwable {
    public AbstractResolvableFuture$Failure$1(String string2) {
        super(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public Throwable fillInStackTrace() {
        // MONITORENTER : this
        // MONITOREXIT : this
        return this;
    }
}

