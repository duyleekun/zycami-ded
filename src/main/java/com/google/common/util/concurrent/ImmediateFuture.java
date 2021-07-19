/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImmediateFuture
implements ListenableFuture {
    public static final ListenableFuture NULL;
    private static final Logger log;
    private final Object value;

    static {
        ImmediateFuture immediateFuture = new ImmediateFuture(null);
        NULL = immediateFuture;
        log = Logger.getLogger(ImmediateFuture.class.getName());
    }

    public ImmediateFuture(Object object) {
        this.value = object;
    }

    public void addListener(Runnable object, Executor executor) {
        Preconditions.checkNotNull(object, "Runnable was null.");
        String string2 = "Executor was null.";
        Preconditions.checkNotNull(executor, string2);
        try {
            executor.execute((Runnable)object);
        }
        catch (RuntimeException runtimeException) {
            Logger logger = log;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "RuntimeException while executing runnable ";
            stringBuilder.append(string3);
            stringBuilder.append(object);
            stringBuilder.append(" with executor ");
            stringBuilder.append(executor);
            object = stringBuilder.toString();
            logger.log(level, (String)object, runtimeException);
        }
    }

    public boolean cancel(boolean bl2) {
        return false;
    }

    public Object get() {
        return this.value;
    }

    public Object get(long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        return this.get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append("[status=SUCCESS, result=[");
        object = this.value;
        stringBuilder.append(object);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}

