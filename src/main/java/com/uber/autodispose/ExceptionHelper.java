/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import com.uber.autodispose.ExceptionHelper$Termination;
import io.reactivex.exceptions.CompositeException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    private static final Throwable a;

    static {
        ExceptionHelper$Termination exceptionHelper$Termination = new ExceptionHelper$Termination();
        a = exceptionHelper$Termination;
    }

    private ExceptionHelper() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static boolean a(AtomicReference atomicReference, Throwable throwable) {
        int n10;
        Throwable throwable2;
        Throwable throwable3;
        boolean bl2;
        do {
            Throwable throwable4;
            if ((throwable3 = (Throwable)atomicReference.get()) == (throwable4 = a)) {
                return false;
            }
            n10 = 1;
            if (throwable3 == null) {
                throwable2 = throwable;
                continue;
            }
            int n11 = 2;
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = throwable3;
            throwableArray[n10] = throwable;
            throwable2 = new CompositeException(throwableArray);
        } while (!(bl2 = atomicReference.compareAndSet(throwable3, throwable2)));
        return n10 != 0;
    }

    public static Throwable b(AtomicReference serializable) {
        Throwable throwable;
        Serializable serializable2 = (Throwable)serializable.get();
        if (serializable2 != (throwable = a)) {
            serializable = serializable.getAndSet(throwable);
            serializable2 = serializable;
            serializable2 = (Throwable)serializable;
        }
        return serializable2;
    }
}

