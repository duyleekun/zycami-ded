/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.FuturesGetChecked$1;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class FuturesGetChecked {
    private static final Ordering WITH_STRING_PARAM_FIRST;

    static {
        Ordering ordering = Ordering.natural();
        FuturesGetChecked$1 futuresGetChecked$1 = new FuturesGetChecked$1();
        WITH_STRING_PARAM_FIRST = ordering.onResultOf(futuresGetChecked$1).reverse();
    }

    private FuturesGetChecked() {
    }

    private static FuturesGetChecked$GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return FuturesGetChecked$GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    public static void checkExceptionClassValidity(Class clazz) {
        Preconditions.checkArgument(FuturesGetChecked.isCheckedException(clazz), "Futures.getChecked exception type (%s) must not be a RuntimeException", (Object)clazz);
        Preconditions.checkArgument(FuturesGetChecked.hasConstructorUsableByGetChecked(clazz), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", (Object)clazz);
    }

    public static FuturesGetChecked$GetCheckedTypeValidator classValueValidator() {
        return FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.INSTANCE;
    }

    public static Object getChecked(FuturesGetChecked$GetCheckedTypeValidator object, Future future, Class clazz) {
        object.validateClass(clazz);
        try {
            return future.get();
        }
        catch (ExecutionException executionException) {
            FuturesGetChecked.wrapAndThrowExceptionOrError(executionException.getCause(), clazz);
            object = new AssertionError();
            throw object;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw FuturesGetChecked.newWithCause(clazz, interruptedException);
        }
    }

    public static Object getChecked(Future future, Class clazz) {
        return FuturesGetChecked.getChecked(FuturesGetChecked.bestGetCheckedTypeValidator(), future, clazz);
    }

    public static Object getChecked(Future object, Class clazz, long l10, TimeUnit timeUnit) {
        FuturesGetChecked$GetCheckedTypeValidator futuresGetChecked$GetCheckedTypeValidator = FuturesGetChecked.bestGetCheckedTypeValidator();
        futuresGetChecked$GetCheckedTypeValidator.validateClass(clazz);
        try {
            return object.get(l10, timeUnit);
        }
        catch (ExecutionException executionException) {
            FuturesGetChecked.wrapAndThrowExceptionOrError(executionException.getCause(), clazz);
            object = new AssertionError();
            throw object;
        }
        catch (TimeoutException timeoutException) {
            throw FuturesGetChecked.newWithCause(clazz, timeoutException);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw FuturesGetChecked.newWithCause(clazz, interruptedException);
        }
    }

    private static boolean hasConstructorUsableByGetChecked(Class clazz) {
        Exception exception;
        try {
            exception = new Exception();
        }
        catch (Exception exception2) {
            return false;
        }
        FuturesGetChecked.newWithCause(clazz, exception);
        return true;
    }

    public static boolean isCheckedException(Class clazz) {
        return RuntimeException.class.isAssignableFrom(clazz) ^ true;
    }

    private static Object newFromConstructor(Constructor constructor, Throwable throwable) {
        int n10;
        Class<?>[] classArray = constructor.getParameterTypes();
        int n11 = classArray.length;
        Object[] objectArray = new Object[n11];
        for (int i10 = 0; i10 < (n10 = classArray.length); ++i10) {
            Class<?> clazz = classArray[i10];
            Class clazz2 = String.class;
            boolean bl2 = clazz.equals(clazz2);
            if (bl2) {
                objectArray[i10] = clazz = throwable.toString();
                continue;
            }
            clazz2 = Throwable.class;
            n10 = (int)(clazz.equals(clazz2) ? 1 : 0);
            if (n10 != 0) {
                objectArray[i10] = throwable;
                continue;
            }
            return null;
        }
        try {
            return constructor.newInstance(objectArray);
        }
        catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException exception) {
            return null;
        }
    }

    private static Exception newWithCause(Class object, Throwable throwable) {
        Serializable serializable;
        boolean bl2;
        Object object2 = FuturesGetChecked.preferringStrings(Arrays.asList(((Class)object).getConstructors())).iterator();
        while (bl2 = object2.hasNext()) {
            serializable = (Exception)FuturesGetChecked.newFromConstructor((Constructor)object2.next(), throwable);
            if (serializable == null) continue;
            object = ((Throwable)serializable).getCause();
            if (object == null) {
                ((Throwable)serializable).initCause(throwable);
            }
            return serializable;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("No appropriate constructor for exception of type ");
        ((StringBuilder)serializable).append(object);
        ((StringBuilder)serializable).append(" in response to chained exception");
        object = ((StringBuilder)serializable).toString();
        object2 = new IllegalArgumentException((String)object, throwable);
        throw object2;
    }

    private static List preferringStrings(List list) {
        return WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }

    public static FuturesGetChecked$GetCheckedTypeValidator weakSetValidator() {
        return FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.INSTANCE;
    }

    private static void wrapAndThrowExceptionOrError(Throwable throwable, Class serializable) {
        boolean bl2 = throwable instanceof Error;
        if (!bl2) {
            bl2 = throwable instanceof RuntimeException;
            if (bl2) {
                serializable = new UncheckedExecutionException(throwable);
                throw serializable;
            }
            throw FuturesGetChecked.newWithCause(serializable, throwable);
        }
        throwable = (Error)throwable;
        serializable = new ExecutionError((Error)throwable);
        throw serializable;
    }
}

