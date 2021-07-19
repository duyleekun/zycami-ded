/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.util.Log
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ResourcesCompat$ThemeCompat$ImplApi23 {
    private static Method sRebaseMethod;
    private static boolean sRebaseMethodFetched;
    private static final Object sRebaseMethodLock;

    static {
        Object object;
        sRebaseMethodLock = object = new Object();
    }

    private ResourcesCompat$ThemeCompat$ImplApi23() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void rebase(Resources.Theme theme) {
        Object object = sRebaseMethodLock;
        synchronized (object) {
            block9: {
                Object object2;
                boolean bl2 = sRebaseMethodFetched;
                Object object3 = null;
                if (!bl2) {
                    bl2 = true;
                    Object object4 = Resources.Theme.class;
                    String string2 = "rebase";
                    try {
                        Class[] classArray = new Class[]{};
                        sRebaseMethod = object4 = ((Class)object4).getDeclaredMethod(string2, classArray);
                        ((Method)object4).setAccessible(bl2);
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        string2 = "ResourcesCompat";
                        String string3 = "Failed to retrieve rebase() method";
                        Log.i((String)string2, (String)string3, (Throwable)noSuchMethodException);
                    }
                    sRebaseMethodFetched = bl2;
                }
                if ((object2 = sRebaseMethod) != null) {
                    Object var0_3;
                    try {
                        object3 = new Object[]{};
                        ((Method)object2).invoke(theme, object3);
                        break block9;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        // empty catch block
                    }
                    object2 = "ResourcesCompat";
                    object3 = "Failed to invoke rebase() method via reflection";
                    Log.i((String)object2, (String)object3, (Throwable)var0_3);
                    var0_3 = null;
                    sRebaseMethod = null;
                }
            }
            return;
        }
    }
}

