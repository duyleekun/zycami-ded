/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

public final class ExceptionHelper$Termination
extends Throwable {
    public ExceptionHelper$Termination() {
        super("No further exceptions");
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

