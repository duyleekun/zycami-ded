/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.Log
 */
package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BundleCompat$BundleCompatBaseImpl {
    private static final String TAG = "BundleCompatBaseImpl";
    private static Method sGetIBinderMethod;
    private static boolean sGetIBinderMethodFetched;
    private static Method sPutIBinderMethod;
    private static boolean sPutIBinderMethodFetched;

    private BundleCompat$BundleCompatBaseImpl() {
    }

    /*
     * WARNING - void declaration
     */
    public static IBinder getBinder(Bundle object, String string2) {
        String string3;
        Object object2;
        boolean bl2 = sGetIBinderMethodFetched;
        String string4 = TAG;
        boolean bl3 = true;
        if (!bl2) {
            object2 = Bundle.class;
            string3 = "getIBinder";
            Class[] classArray = new Class[bl3];
            Class<String> clazz = String.class;
            classArray[0] = clazz;
            object2 = ((Class)object2).getMethod(string3, classArray);
            sGetIBinderMethod = object2;
            try {
                ((Method)object2).setAccessible(bl3);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                string3 = "Failed to retrieve getIBinder method";
                Log.i((String)string4, (String)string3, (Throwable)noSuchMethodException);
            }
            sGetIBinderMethodFetched = bl3;
        }
        object2 = sGetIBinderMethod;
        string3 = null;
        if (object2 != null) {
            void var0_4;
            Object[] objectArray = new Object[bl3];
            objectArray[0] = string2;
            object = ((Method)object2).invoke(object, objectArray);
            try {
                return (IBinder)object;
            }
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException) {
                // empty catch block
            }
            string2 = "Failed to invoke getIBinder via reflection";
            Log.i((String)string4, (String)string2, (Throwable)var0_4);
            sGetIBinderMethod = null;
        }
        return null;
    }

    public static void putBinder(Bundle bundle, String string2, IBinder iBinder) {
        block16: {
            Object object;
            boolean bl2 = sPutIBinderMethodFetched;
            String string3 = TAG;
            int n10 = 2;
            boolean bl3 = true;
            if (!bl2) {
                object = Bundle.class;
                String string4 = "putIBinder";
                Class[] classArray = new Class[n10];
                Class<String> clazz = String.class;
                classArray[0] = clazz;
                clazz = IBinder.class;
                classArray[bl3] = clazz;
                object = ((Class)object).getMethod(string4, classArray);
                sPutIBinderMethod = object;
                try {
                    ((Method)object).setAccessible(bl3);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    string4 = "Failed to retrieve putIBinder method";
                    Log.i((String)string3, (String)string4, (Throwable)noSuchMethodException);
                }
                sPutIBinderMethodFetched = bl3;
            }
            if ((object = sPutIBinderMethod) != null) {
                Object var0_4;
                Object[] objectArray = new Object[n10];
                objectArray[0] = string2;
                objectArray[bl3] = iBinder;
                try {
                    ((Method)object).invoke(bundle, objectArray);
                    break block16;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (IllegalAccessException illegalAccessException) {
                }
                catch (InvocationTargetException invocationTargetException) {
                    // empty catch block
                }
                string2 = "Failed to invoke putIBinder via reflection";
                Log.i((String)string3, (String)string2, (Throwable)var0_4);
                var0_4 = null;
                sPutIBinderMethod = null;
            }
        }
    }
}

