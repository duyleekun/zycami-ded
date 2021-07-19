/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import com.uber.autodispose.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class AtomicThrowable
extends AtomicReference {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable throwable) {
        return ExceptionHelper.a(this, throwable);
    }

    public Throwable terminate() {
        return ExceptionHelper.b(this);
    }
}

