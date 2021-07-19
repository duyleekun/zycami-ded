/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.io.Closer$LoggingSuppressor;
import com.google.common.io.Closer$SuppressingSuppressor;
import com.google.common.io.Closer$Suppressor;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public final class Closer
implements Closeable {
    private static final Closer$Suppressor SUPPRESSOR;
    private final Deque stack;
    public final Closer$Suppressor suppressor;
    private Throwable thrown;

    static {
        boolean bl2 = Closer$SuppressingSuppressor.isAvailable();
        Closer$Suppressor closer$Suppressor = bl2 ? Closer$SuppressingSuppressor.INSTANCE : Closer$LoggingSuppressor.INSTANCE;
        SUPPRESSOR = closer$Suppressor;
    }

    public Closer(Closer$Suppressor closer$Suppressor) {
        ArrayDeque arrayDeque;
        this.stack = arrayDeque = new ArrayDeque(4);
        this.suppressor = closer$Suppressor = (Closer$Suppressor)Preconditions.checkNotNull(closer$Suppressor);
    }

    public static Closer create() {
        Closer$Suppressor closer$Suppressor = SUPPRESSOR;
        Closer closer = new Closer(closer$Suppressor);
        return closer;
    }

    public void close() {
        Object object;
        boolean bl2;
        Throwable throwable = this.thrown;
        while (!(bl2 = (object = this.stack).isEmpty())) {
            object = (Closeable)this.stack.removeFirst();
            try {
                object.close();
            }
            catch (Throwable throwable2) {
                if (throwable == null) {
                    throwable = throwable2;
                    continue;
                }
                Closer$Suppressor closer$Suppressor = this.suppressor;
                closer$Suppressor.suppress((Closeable)object, throwable, throwable2);
            }
        }
        object = this.thrown;
        if (object == null && throwable != null) {
            Throwables.propagateIfPossible(throwable, IOException.class);
            object = new AssertionError((Object)throwable);
            throw object;
        }
    }

    public Closeable register(Closeable closeable) {
        if (closeable != null) {
            Deque deque = this.stack;
            deque.addFirst(closeable);
        }
        return closeable;
    }

    public RuntimeException rethrow(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        this.thrown = throwable;
        Throwables.propagateIfPossible(throwable, IOException.class);
        RuntimeException runtimeException = new RuntimeException(throwable);
        throw runtimeException;
    }

    public RuntimeException rethrow(Throwable throwable, Class serializable) {
        Preconditions.checkNotNull(throwable);
        this.thrown = throwable;
        Throwables.propagateIfPossible(throwable, IOException.class);
        Throwables.propagateIfPossible(throwable, serializable);
        serializable = new RuntimeException(throwable);
        throw serializable;
    }

    public RuntimeException rethrow(Throwable throwable, Class serializable, Class clazz) {
        Preconditions.checkNotNull(throwable);
        this.thrown = throwable;
        Throwables.propagateIfPossible(throwable, IOException.class);
        Throwables.propagateIfPossible(throwable, serializable, clazz);
        serializable = new RuntimeException(throwable);
        throw serializable;
    }
}

