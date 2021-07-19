/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

public final class CallbackException
extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public CallbackException(Throwable throwable) {
        super("Unexpected exception thrown by non-Glide code", throwable);
    }
}

