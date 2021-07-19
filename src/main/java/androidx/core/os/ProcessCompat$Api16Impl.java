/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.os;

import java.lang.reflect.Method;

public class ProcessCompat$Api16Impl {
    private static Method sMethodUserIdIsAppMethod;
    private static boolean sResolved;
    private static final Object sResolvedLock;

    static {
        Object object;
        sResolvedLock = object = new Object();
    }

    private ProcessCompat$Api16Impl() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static boolean isApplicationUid(int n10) {
        Object[] objectArray;
        Object object;
        boolean bl2;
        Object object2;
        int n11;
        block8: {
            Class<Integer> clazz;
            n11 = 1;
            object2 = sResolvedLock;
            // MONITORENTER : object2
            bl2 = sResolved;
            if (bl2) break block8;
            sResolved = n11;
            object = "android.os.UserId";
            object = Class.forName((String)object);
            objectArray = "isApp";
            Class[] classArray = new Class[n11];
            classArray[0] = clazz = Integer.TYPE;
            sMethodUserIdIsAppMethod = object = ((Class)object).getDeclaredMethod((String)objectArray, classArray);
        }
        // MONITOREXIT : object2
        try {
            Object object3;
            object2 = sMethodUserIdIsAppMethod;
            if (object2 == null) return n11 != 0;
            bl2 = false;
            object = null;
            objectArray = new Object[n11];
            objectArray[0] = object3 = Integer.valueOf(n10);
            object3 = ((Method)object2).invoke(null, objectArray);
            if ((object3 = (Boolean)object3) != null) {
                return (Boolean)object3;
            }
            object3 = new NullPointerException();
            throw object3;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return n11 != 0;
    }
}

