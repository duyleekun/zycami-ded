/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

public final class AbstractFuture$Failure$1
extends Throwable {
    public AbstractFuture$Failure$1(String string2) {
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

