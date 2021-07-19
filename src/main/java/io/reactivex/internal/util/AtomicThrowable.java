/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class AtomicThrowable
extends AtomicReference {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable throwable) {
        return ExceptionHelper.a(this, throwable);
    }

    public boolean isTerminated() {
        boolean bl2;
        Throwable throwable;
        Object v10 = this.get();
        if (v10 == (throwable = ExceptionHelper.a)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public Throwable terminate() {
        return ExceptionHelper.c(this);
    }
}

