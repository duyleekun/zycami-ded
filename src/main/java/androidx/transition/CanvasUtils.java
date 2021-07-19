/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 */
package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    private CanvasUtils() {
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void enableZ(Canvas object, boolean bl2) {
        InvocationTargetException invocationTargetException2222;
        block13: {
            Object[] objectArray;
            block12: {
                Object object2;
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 21;
                if (n10 < n11) {
                    return;
                }
                n11 = 29;
                if (n10 >= n11) {
                    if (bl2) {
                        object.enableZ();
                        return;
                    }
                    object.disableZ();
                    return;
                }
                n11 = 28;
                if (n10 == n11) {
                    object = new IllegalStateException("This method doesn't work on Pie!");
                    throw object;
                }
                n10 = (int)(sOrderMethodsFetched ? 1 : 0);
                n11 = 0;
                if (!n10) {
                    n10 = 1;
                    object2 = Canvas.class;
                    String string2 = "insertReorderBarrier";
                    try {
                        Class[] classArray = new Class[]{};
                        sReorderBarrierMethod = object2 = ((Class)object2).getDeclaredMethod(string2, classArray);
                        ((Method)object2).setAccessible(n10 != 0);
                        object2 = Canvas.class;
                        string2 = "insertInorderBarrier";
                        classArray = new Class[]{};
                        sInorderBarrierMethod = object2 = ((Class)object2).getDeclaredMethod(string2, classArray);
                        ((Method)object2).setAccessible(n10 != 0);
                    }
                    catch (NoSuchMethodException noSuchMethodException) {}
                    sOrderMethodsFetched = n10;
                }
                if (bl2) {
                    try {
                        objectArray = sReorderBarrierMethod;
                        if (objectArray == null) break block12;
                        object2 = new Object[]{};
                        objectArray.invoke(object, (Object[])object2);
                    }
                    catch (InvocationTargetException invocationTargetException2222) {
                        break block13;
                    }
                }
            }
            if (bl2) return;
            Method method = sInorderBarrierMethod;
            if (method == null) return;
            objectArray = new Object[]{};
            method.invoke(object, objectArray);
            return;
        }
        Throwable throwable = invocationTargetException2222.getCause();
        RuntimeException runtimeException = new RuntimeException(throwable);
        throw runtimeException;
        catch (IllegalAccessException illegalAccessException) {}
    }
}

