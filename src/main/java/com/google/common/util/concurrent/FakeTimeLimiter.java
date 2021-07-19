/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class FakeTimeLimiter
implements TimeLimiter {
    public Object callUninterruptiblyWithTimeout(Callable callable, long l10, TimeUnit timeUnit) {
        return this.callWithTimeout(callable, l10, timeUnit);
    }

    public Object callWithTimeout(Callable callable, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull((Object)timeUnit);
        try {
            return callable.call();
        }
        catch (Throwable throwable) {
            ExecutionException executionException = new ExecutionException(throwable);
            throw executionException;
        }
        catch (Error error) {
            ExecutionError executionError = new ExecutionError(error);
            throw executionError;
        }
        catch (Exception exception) {
            ExecutionException executionException = new ExecutionException(exception);
            throw executionException;
        }
        catch (RuntimeException runtimeException) {
            UncheckedExecutionException uncheckedExecutionException = new UncheckedExecutionException(runtimeException);
            throw uncheckedExecutionException;
        }
    }

    public Object newProxy(Object object, Class clazz, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull((Object)timeUnit);
        return object;
    }

    public void runUninterruptiblyWithTimeout(Runnable runnable, long l10, TimeUnit timeUnit) {
        this.runWithTimeout(runnable, l10, timeUnit);
    }

    public void runWithTimeout(Runnable runnable, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull((Object)timeUnit);
        try {
            runnable.run();
            return;
        }
        catch (Throwable throwable) {
            UncheckedExecutionException uncheckedExecutionException = new UncheckedExecutionException(throwable);
            throw uncheckedExecutionException;
        }
        catch (Error error) {
            ExecutionError executionError = new ExecutionError(error);
            throw executionError;
        }
        catch (RuntimeException runtimeException) {
            UncheckedExecutionException uncheckedExecutionException = new UncheckedExecutionException(runtimeException);
            throw uncheckedExecutionException;
        }
    }
}

