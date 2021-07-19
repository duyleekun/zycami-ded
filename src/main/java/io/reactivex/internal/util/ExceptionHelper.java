/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper$Termination;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    public static final Throwable a;

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

    public static List b(Throwable object) {
        boolean bl2;
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        ArrayDeque<Throwable> arrayDeque = new ArrayDeque<Throwable>();
        arrayDeque.offer((Throwable)object);
        while (!(bl2 = arrayDeque.isEmpty())) {
            object = (Throwable)arrayDeque.removeFirst();
            int n10 = object instanceof CompositeException;
            if (n10 != 0) {
                object = ((CompositeException)object).getExceptions();
                for (n10 = object.size() + -1; n10 >= 0; n10 += -1) {
                    Object e10 = object.get(n10);
                    arrayDeque.offerFirst((Throwable)e10);
                }
                continue;
            }
            arrayList.add((Throwable)object);
        }
        return arrayList;
    }

    public static Throwable c(AtomicReference serializable) {
        Throwable throwable;
        Serializable serializable2 = (Throwable)serializable.get();
        if (serializable2 != (throwable = a)) {
            serializable = serializable.getAndSet(throwable);
            serializable2 = serializable;
            serializable2 = (Throwable)serializable;
        }
        return serializable2;
    }

    public static Exception d(Throwable throwable) {
        boolean bl2 = throwable instanceof Exception;
        if (bl2) {
            return (Exception)throwable;
        }
        throw throwable;
    }

    public static String e(long l10, TimeUnit timeUnit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The source did not signal an event for ");
        stringBuilder.append(l10);
        stringBuilder.append(" ");
        String string2 = timeUnit.toString().toLowerCase();
        stringBuilder.append(string2);
        stringBuilder.append(" and has been terminated.");
        return stringBuilder.toString();
    }

    public static RuntimeException f(Throwable throwable) {
        boolean bl2 = throwable instanceof Error;
        if (!bl2) {
            bl2 = throwable instanceof RuntimeException;
            if (bl2) {
                return (RuntimeException)throwable;
            }
            RuntimeException runtimeException = new RuntimeException(throwable);
            return runtimeException;
        }
        throw (Error)throwable;
    }
}

