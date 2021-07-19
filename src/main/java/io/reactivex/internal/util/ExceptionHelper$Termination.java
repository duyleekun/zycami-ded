/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

public final class ExceptionHelper$Termination
extends Throwable {
    private static final long serialVersionUID = -4649703670690200604L;

    public ExceptionHelper$Termination() {
        super("No further exceptions");
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}

