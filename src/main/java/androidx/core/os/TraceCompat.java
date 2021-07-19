/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 */
package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        Object object = String.class;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11 && n10 < (n11 = 29)) {
            Class<Trace> clazz = Trace.class;
            String string2 = "TRACE_TAG_APP";
            clazz = clazz.getField(string2);
            n11 = 0;
            string2 = null;
            long l10 = ((Field)((Object)clazz)).getLong(null);
            sTraceTagApp = l10;
            clazz = Trace.class;
            string2 = "isTagEnabled";
            int n12 = 1;
            Class[] classArray = new Class[n12];
            Class<Long> clazz2 = Long.TYPE;
            classArray[0] = clazz2;
            clazz = clazz.getMethod(string2, classArray);
            sIsTagEnabledMethod = clazz;
            clazz = Trace.class;
            string2 = "asyncTraceBegin";
            int n13 = 3;
            Class[] classArray2 = new Class[n13];
            classArray2[0] = clazz2;
            classArray2[n12] = object;
            Class<Integer> clazz3 = Integer.TYPE;
            int n14 = 2;
            classArray2[n14] = clazz3;
            clazz = clazz.getMethod(string2, classArray2);
            sAsyncTraceBeginMethod = clazz;
            clazz = Trace.class;
            string2 = "asyncTraceEnd";
            classArray2 = new Class[n13];
            classArray2[0] = clazz2;
            classArray2[n12] = object;
            classArray2[n14] = clazz3;
            clazz = clazz.getMethod(string2, classArray2);
            sAsyncTraceEndMethod = clazz;
            clazz = Trace.class;
            string2 = "traceCounter";
            classArray = new Class[n13];
            classArray[0] = clazz2;
            classArray[n12] = object;
            classArray[n14] = clazz3;
            object = clazz.getMethod(string2, classArray);
            try {
                sTraceCounterMethod = object;
            }
            catch (Exception exception) {
                clazz = TAG;
                string2 = "Unable to initialize via reflection.";
                Log.i((String)((Object)clazz), (String)string2, (Throwable)exception);
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(String string2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            Trace.beginAsyncSection((String)string2, (int)n10);
        } else {
            n12 = 18;
            if (n11 >= n12) {
                Method method = sAsyncTraceBeginMethod;
                n12 = 0;
                int n13 = 3;
                Object[] objectArray = new Object[n13];
                int n14 = 0;
                long l10 = sTraceTagApp;
                Long l11 = l10;
                objectArray[0] = l11;
                n14 = 1;
                objectArray[n14] = string2;
                int n15 = 2;
                Object object = n10;
                objectArray[n15] = object;
                try {
                    method.invoke(null, objectArray);
                }
                catch (Exception exception) {
                    string2 = TAG;
                    object = "Unable to invoke asyncTraceBegin() via reflection.";
                    Log.v((String)string2, (String)object);
                }
            }
        }
    }

    public static void beginSection(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            Trace.beginSection((String)string2);
        }
    }

    public static void endAsyncSection(String string2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            Trace.endAsyncSection((String)string2, (int)n10);
        } else {
            n12 = 18;
            if (n11 >= n12) {
                Method method = sAsyncTraceEndMethod;
                n12 = 0;
                int n13 = 3;
                Object[] objectArray = new Object[n13];
                int n14 = 0;
                long l10 = sTraceTagApp;
                Long l11 = l10;
                objectArray[0] = l11;
                n14 = 1;
                objectArray[n14] = string2;
                int n15 = 2;
                Object object = n10;
                objectArray[n15] = object;
                try {
                    method.invoke(null, objectArray);
                }
                catch (Exception exception) {
                    string2 = TAG;
                    object = "Unable to invoke endAsyncSection() via reflection.";
                    Log.v((String)string2, (String)object);
                }
            }
        }
    }

    public static void endSection() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            Trace.endSection();
        }
    }

    public static boolean isEnabled() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return Trace.isEnabled();
        }
        n11 = 18;
        if (n10 >= n11) {
            Object object = sIsTagEnabledMethod;
            n11 = 0;
            String string2 = null;
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            long l10 = sTraceTagApp;
            Long l11 = l10;
            objectArray[0] = l11;
            object = ((Method)object).invoke(null, objectArray);
            object = (Boolean)object;
            try {
                return (Boolean)object;
            }
            catch (Exception exception) {
                object = TAG;
                string2 = "Unable to invoke isTagEnabled() via reflection.";
                Log.v((String)object, (String)string2);
            }
        }
        return false;
    }

    public static void setCounter(String string2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            long l10 = n10;
            Trace.setCounter((String)string2, (long)l10);
        } else {
            n12 = 18;
            if (n11 >= n12) {
                Method method = sTraceCounterMethod;
                n12 = 0;
                int n13 = 3;
                Object[] objectArray = new Object[n13];
                int n14 = 0;
                long l11 = sTraceTagApp;
                Long l12 = l11;
                objectArray[0] = l12;
                n14 = 1;
                objectArray[n14] = string2;
                int n15 = 2;
                Object object = n10;
                objectArray[n15] = object;
                try {
                    method.invoke(null, objectArray);
                }
                catch (Exception exception) {
                    string2 = TAG;
                    object = "Unable to invoke traceCounter() via reflection.";
                    Log.v((String)string2, (String)object);
                }
            }
        }
    }
}

