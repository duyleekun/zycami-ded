/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.icu.util.ULocale
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        block18: {
            Object object = String.class;
            Class[] classArray = "libcore.icu.ICU";
            int n10 = Build.VERSION.SDK_INT;
            String string2 = "addLikelySubtags";
            int n11 = 1;
            int n12 = 21;
            if (n10 < n12) {
                classArray = Class.forName((String)classArray);
                if (classArray == null) break block18;
                Class[] classArray2 = "getScript";
                Class[] classArray3 = new Class[n11];
                classArray3[0] = object;
                classArray2 = classArray.getMethod((String)classArray2, classArray3);
                sGetScriptMethod = classArray2;
                classArray2 = new Class[n11];
                classArray2[0] = object;
                object = classArray.getMethod(string2, classArray2);
                try {
                    sAddLikelySubtagsMethod = object;
                }
                catch (Exception exception) {
                    sGetScriptMethod = null;
                    sAddLikelySubtagsMethod = null;
                    classArray = TAG;
                    Log.w((String)classArray, (Throwable)exception);
                }
            } else {
                int n13 = 24;
                if (n10 < n13) {
                    try {
                        object = Class.forName((String)classArray);
                    }
                    catch (Exception exception) {
                        classArray = new IllegalStateException(exception);
                        throw classArray;
                    }
                    classArray = new Class[n11];
                    Class<Locale> clazz = Locale.class;
                    classArray[0] = clazz;
                    object = ((Class)object).getMethod(string2, classArray);
                    sAddLikelySubtagsMethod = object;
                }
            }
        }
    }

    private ICUCompat() {
    }

    private static String addLikelySubtags(Locale object) {
        block7: {
            String string2 = TAG;
            object = ((Locale)object).toString();
            Object object2 = sAddLikelySubtagsMethod;
            if (object2 == null) break block7;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            object2 = ((Method)object2).invoke(null, objectArray);
            try {
                return (String)object2;
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.w((String)string2, (Throwable)invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.w((String)string2, (Throwable)illegalAccessException);
            }
        }
        return object;
    }

    private static String getScript(String object) {
        block7: {
            String string2 = TAG;
            Method method = sGetScriptMethod;
            if (method == null) break block7;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            object = method.invoke(null, objectArray);
            try {
                return (String)object;
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.w((String)string2, (Throwable)invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.w((String)string2, (Throwable)illegalAccessException);
            }
        }
        return null;
    }

    public static String maximizeAndGetScript(Locale object) {
        String string2 = TAG;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return ULocale.addLikelySubtags((ULocale)ULocale.forLocale((Locale)object)).getScript();
        }
        n11 = 21;
        if (n10 >= n11) {
            n10 = 1;
            Object object2 = new Object[n10];
            n11 = 0;
            Method method = null;
            object2[0] = object;
            method = sAddLikelySubtagsMethod;
            object2 = method.invoke(null, (Object[])object2);
            object2 = (Locale)object2;
            try {
                return ((Locale)object2).getScript();
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.w((String)string2, (Throwable)illegalAccessException);
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.w((String)string2, (Throwable)invocationTargetException);
            }
            return ((Locale)object).getScript();
        }
        if ((object = ICUCompat.addLikelySubtags((Locale)object)) != null) {
            return ICUCompat.getScript((String)object);
        }
        return null;
    }
}

