/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 */
package androidx.tracing;

import android.os.Build;
import android.util.Log;
import androidx.tracing.TraceApi18Impl;
import androidx.tracing.TraceApi29Impl;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {
    public static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    private Trace() {
    }

    public static void beginAsyncSection(String string2, int n10) {
        block3: {
            Method method = sAsyncTraceBeginMethod;
            if (method != null) break block3;
            try {
                TraceApi29Impl.beginAsyncSection(string2, n10);
                return;
            }
            catch (NoClassDefFoundError | NoSuchMethodError linkageError) {}
        }
        Trace.beginAsyncSectionFallback(string2, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void beginAsyncSectionFallback(String object, int n10) {
        String string2 = "asyncTraceBegin";
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 < n12) return;
        try {
            Class<Integer> clazz;
            Class[] classArray;
            Object object2 = sAsyncTraceBeginMethod;
            n12 = 2;
            int n13 = 1;
            int n14 = 3;
            if (object2 == null) {
                object2 = android.os.Trace.class;
                classArray = new Class[n14];
                clazz = Long.TYPE;
                classArray[0] = clazz;
                clazz = String.class;
                classArray[n13] = clazz;
                classArray[n12] = clazz = Integer.TYPE;
                sAsyncTraceBeginMethod = object2 = ((Class)object2).getMethod(string2, classArray);
            }
            object2 = sAsyncTraceBeginMethod;
            classArray = null;
            Object[] objectArray = new Object[n14];
            long l10 = sTraceTagApp;
            clazz = l10;
            objectArray[0] = clazz;
            objectArray[n13] = object;
            objectArray[n12] = object = Integer.valueOf(n10);
            ((Method)object2).invoke(null, objectArray);
            return;
        }
        catch (Exception exception) {
            Trace.handleException(string2, exception);
        }
    }

    public static void beginSection(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            TraceApi18Impl.beginSection(string2);
        }
    }

    public static void endAsyncSection(String string2, int n10) {
        block3: {
            Method method = sAsyncTraceEndMethod;
            if (method != null) break block3;
            try {
                TraceApi29Impl.endAsyncSection(string2, n10);
                return;
            }
            catch (NoClassDefFoundError | NoSuchMethodError linkageError) {}
        }
        Trace.endAsyncSectionFallback(string2, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void endAsyncSectionFallback(String object, int n10) {
        String string2 = "asyncTraceEnd";
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 < n12) return;
        try {
            Class<Integer> clazz;
            Class[] classArray;
            Object object2 = sAsyncTraceEndMethod;
            n12 = 2;
            int n13 = 1;
            int n14 = 3;
            if (object2 == null) {
                object2 = android.os.Trace.class;
                classArray = new Class[n14];
                clazz = Long.TYPE;
                classArray[0] = clazz;
                clazz = String.class;
                classArray[n13] = clazz;
                classArray[n12] = clazz = Integer.TYPE;
                sAsyncTraceEndMethod = object2 = ((Class)object2).getMethod(string2, classArray);
            }
            object2 = sAsyncTraceEndMethod;
            classArray = null;
            Object[] objectArray = new Object[n14];
            long l10 = sTraceTagApp;
            clazz = l10;
            objectArray[0] = clazz;
            objectArray[n13] = object;
            objectArray[n12] = object = Integer.valueOf(n10);
            ((Method)object2).invoke(null, objectArray);
            return;
        }
        catch (Exception exception) {
            Trace.handleException(string2, exception);
        }
    }

    public static void endSection() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            TraceApi18Impl.endSection();
        }
    }

    private static void handleException(String object, Exception exception) {
        boolean bl2 = exception instanceof InvocationTargetException;
        if (bl2) {
            object = exception.getCause();
            boolean bl3 = object instanceof RuntimeException;
            if (bl3) {
                throw (RuntimeException)object;
            }
            exception = new RuntimeException((Throwable)object);
            throw exception;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call ");
        stringBuilder.append((String)object);
        stringBuilder.append(" via reflection");
        object = stringBuilder.toString();
        Log.v((String)TAG, (String)object, (Throwable)exception);
    }

    public static boolean isEnabled() {
        block3: {
            Method method = sIsTagEnabledMethod;
            if (method != null) break block3;
            try {
                return android.os.Trace.isEnabled();
            }
            catch (NoClassDefFoundError | NoSuchMethodError linkageError) {}
        }
        return Trace.isEnabledFallback();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean isEnabledFallback() {
        String string2 = "isTagEnabled";
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) return false;
        try {
            long l10;
            Class[] classArray;
            Object object = sIsTagEnabledMethod;
            n11 = 1;
            if (object == null) {
                Class<Long> clazz;
                object = android.os.Trace.class;
                classArray = "TRACE_TAG_APP";
                object = ((Class)object).getField((String)classArray);
                sTraceTagApp = l10 = ((Field)object).getLong(null);
                object = android.os.Trace.class;
                classArray = new Class[n11];
                classArray[0] = clazz = Long.TYPE;
                sIsTagEnabledMethod = object = ((Class)object).getMethod(string2, classArray);
            }
            object = sIsTagEnabledMethod;
            Object[] objectArray = new Object[n11];
            l10 = sTraceTagApp;
            classArray = l10;
            objectArray[0] = classArray;
            object = ((Method)object).invoke(null, objectArray);
            object = (Boolean)object;
            return (Boolean)object;
        }
        catch (Exception exception) {
            Trace.handleException(string2, exception);
        }
        return false;
    }

    public static void setCounter(String string2, int n10) {
        block3: {
            Method method = sTraceCounterMethod;
            if (method != null) break block3;
            try {
                TraceApi29Impl.setCounter(string2, n10);
                return;
            }
            catch (NoClassDefFoundError | NoSuchMethodError linkageError) {}
        }
        Trace.setCounterFallback(string2, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void setCounterFallback(String object, int n10) {
        String string2 = "traceCounter";
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 < n12) return;
        try {
            Class<Integer> clazz;
            Class[] classArray;
            Object object2 = sTraceCounterMethod;
            n12 = 2;
            int n13 = 1;
            int n14 = 3;
            if (object2 == null) {
                object2 = android.os.Trace.class;
                classArray = new Class[n14];
                clazz = Long.TYPE;
                classArray[0] = clazz;
                clazz = String.class;
                classArray[n13] = clazz;
                classArray[n12] = clazz = Integer.TYPE;
                sTraceCounterMethod = object2 = ((Class)object2).getMethod(string2, classArray);
            }
            object2 = sTraceCounterMethod;
            classArray = null;
            Object[] objectArray = new Object[n14];
            long l10 = sTraceTagApp;
            clazz = l10;
            objectArray[0] = clazz;
            objectArray[n13] = object;
            objectArray[n12] = object = Integer.valueOf(n10);
            ((Method)object2).invoke(null, objectArray);
            return;
        }
        catch (Exception exception) {
            Trace.handleException(string2, exception);
        }
    }
}

