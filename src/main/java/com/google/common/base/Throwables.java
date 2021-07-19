/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables$1;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Throwables {
    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
    public static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
    private static final Method getStackTraceDepthMethod;
    private static final Method getStackTraceElementMethod;
    private static final Object jla;

    static {
        Object object;
        jla = object = Throwables.getJLA();
        Method method = null;
        Method method2 = object == null ? null : Throwables.getGetMethod();
        getStackTraceElementMethod = method2;
        if (object != null) {
            method = Throwables.getSizeMethod();
        }
        getStackTraceDepthMethod = method;
    }

    private Throwables() {
    }

    public static /* synthetic */ Method access$000() {
        return getStackTraceElementMethod;
    }

    public static /* synthetic */ Object access$100() {
        return jla;
    }

    public static /* synthetic */ Object access$200(Method method, Object object, Object[] objectArray) {
        return Throwables.invokeAccessibleNonThrowingMethod(method, object, objectArray);
    }

    public static /* synthetic */ Method access$300() {
        return getStackTraceDepthMethod;
    }

    public static List getCausalChain(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        Serializable serializable = new Serializable(4);
        serializable.add(throwable);
        boolean bl2 = false;
        Throwable throwable2 = throwable;
        while ((throwable = throwable.getCause()) != null) {
            serializable.add(throwable);
            if (throwable != throwable2) {
                if (bl2) {
                    throwable2 = throwable2.getCause();
                }
                bl2 ^= true;
                continue;
            }
            serializable = new Serializable("Loop in causal chain detected.", throwable);
            throw serializable;
        }
        return Collections.unmodifiableList(serializable);
    }

    public static Throwable getCauseAs(Throwable throwable, Class clazz) {
        Throwable throwable2;
        try {
            throwable2 = throwable.getCause();
        }
        catch (ClassCastException classCastException) {
            classCastException.initCause(throwable);
            throw classCastException;
        }
        clazz = clazz.cast(throwable2);
        return (Throwable)((Object)clazz);
    }

    private static Method getGetMethod() {
        Class<Integer> clazz = Integer.TYPE;
        Class[] classArray = new Class[]{Throwable.class, clazz};
        return Throwables.getJlaMethod("getStackTraceElement", classArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Object getJLA() {
        Object object = null;
        Object object2 = SHARED_SECRETS_CLASSNAME;
        Object[] objectArray = null;
        object2 = Class.forName((String)object2, false, null);
        String string2 = "getJavaLangAccess";
        Class[] classArray = new Class[]{};
        object2 = ((Class)object2).getMethod(string2, classArray);
        objectArray = new Object[]{};
        try {
            return ((Method)object2).invoke(null, objectArray);
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
        catch (Throwable throwable) {
            return object;
        }
    }

    private static Method getJlaMethod(String string2, Class ... classArray) {
        Object object = JAVA_LANG_ACCESS_CLASSNAME;
        object = Class.forName((String)object, false, null);
        try {
            return ((Class)object).getMethod(string2, classArray);
        }
        catch (Throwable throwable) {
            return null;
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
    }

    public static Throwable getRootCause(Throwable throwable) {
        Throwable throwable2;
        boolean bl2 = false;
        Throwable throwable3 = throwable;
        while ((throwable2 = throwable.getCause()) != null) {
            if (throwable2 != throwable3) {
                if (bl2) {
                    throwable3 = throwable = throwable3.getCause();
                }
                bl2 ^= true;
                throwable = throwable2;
                continue;
            }
            throwable = new IllegalArgumentException("Loop in causal chain detected.", throwable2);
            throw throwable;
        }
        return throwable;
    }

    private static Method getSizeMethod() {
        Object object;
        Object object2;
        int n10;
        Object object3;
        block10: {
            object3 = "getStackTraceDepth";
            n10 = 1;
            object2 = new Class[n10];
            object = Throwable.class;
            object2[0] = object;
            object3 = Throwables.getJlaMethod((String)object3, object2);
            if (object3 != null) break block10;
            return null;
        }
        object2 = Throwables.getJLA();
        Object[] objectArray = new Object[n10];
        object = new Throwable();
        objectArray[0] = object;
        try {
            ((Method)object3).invoke(object2, objectArray);
            return object3;
        }
        catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException exception) {
            return null;
        }
    }

    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    private static Object invokeAccessibleNonThrowingMethod(Method method, Object object, Object ... objectArray) {
        try {
            return method.invoke(object, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw Throwables.propagate(invocationTargetException.getCause());
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new RuntimeException(illegalAccessException);
            throw object;
        }
    }

    private static List jlaStackTrace(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        Throwables$1 throwables$1 = new Throwables$1(throwable);
        return throwables$1;
    }

    public static List lazyStackTrace(Throwable list) {
        boolean bl2 = Throwables.lazyStackTraceIsLazy();
        list = bl2 ? Throwables.jlaStackTrace((Throwable)((Object)list)) : Collections.unmodifiableList(Arrays.asList(((Throwable)((Object)list)).getStackTrace()));
        return list;
    }

    public static boolean lazyStackTraceIsLazy() {
        boolean bl2;
        Method method = getStackTraceElementMethod;
        if (method != null && (method = getStackTraceDepthMethod) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            method = null;
        }
        return bl2;
    }

    public static RuntimeException propagate(Throwable throwable) {
        Throwables.throwIfUnchecked(throwable);
        RuntimeException runtimeException = new RuntimeException(throwable);
        throw runtimeException;
    }

    public static void propagateIfInstanceOf(Throwable throwable, Class clazz) {
        if (throwable != null) {
            Throwables.throwIfInstanceOf(throwable, clazz);
        }
    }

    public static void propagateIfPossible(Throwable throwable) {
        if (throwable != null) {
            Throwables.throwIfUnchecked(throwable);
        }
    }

    public static void propagateIfPossible(Throwable throwable, Class clazz) {
        Throwables.propagateIfInstanceOf(throwable, clazz);
        Throwables.propagateIfPossible(throwable);
    }

    public static void propagateIfPossible(Throwable throwable, Class clazz, Class clazz2) {
        Preconditions.checkNotNull(clazz2);
        Throwables.propagateIfInstanceOf(throwable, clazz);
        Throwables.propagateIfPossible(throwable, clazz2);
    }

    public static void throwIfInstanceOf(Throwable throwable, Class clazz) {
        Preconditions.checkNotNull(throwable);
        boolean bl2 = clazz.isInstance(throwable);
        if (!bl2) {
            return;
        }
        throw (Throwable)clazz.cast(throwable);
    }

    public static void throwIfUnchecked(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        boolean bl2 = throwable instanceof RuntimeException;
        if (!bl2) {
            bl2 = throwable instanceof Error;
            if (!bl2) {
                return;
            }
            throw (Error)throwable;
        }
        throw (RuntimeException)throwable;
    }
}

