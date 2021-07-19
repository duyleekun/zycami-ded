/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    private HandlerCompat() {
    }

    public static Handler createAsync(Looper object) {
        Object object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return Handler.createAsync((Looper)object);
        }
        n11 = 16;
        if (n10 >= n11) {
            object2 = Handler.class;
            n11 = 3;
            Object object3 = new Class[n11];
            Class clazz = Looper.class;
            object3[0] = clazz;
            clazz = Handler.Callback.class;
            int n12 = 1;
            object3[n12] = clazz;
            clazz = Boolean.TYPE;
            int n13 = 2;
            object3[n13] = clazz;
            object2 = object2.getDeclaredConstructor((Class<?>)object3);
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            object3 = null;
            objectArray[n12] = null;
            object3 = Boolean.TRUE;
            objectArray[n13] = object3;
            object2 = object2.newInstance(objectArray);
            try {
                return object2;
            }
            catch (InvocationTargetException invocationTargetException) {
                object = invocationTargetException.getCause();
                n10 = object instanceof RuntimeException;
                if (n10 == 0) {
                    n10 = object instanceof Error;
                    if (n10 != 0) {
                        throw (Error)object;
                    }
                    object2 = new RuntimeException((Throwable)object);
                    throw object2;
                }
                throw (RuntimeException)object;
            }
            catch (IllegalAccessException | InstantiationException | NoSuchMethodException reflectiveOperationException) {
                object2 = TAG;
                objectArray = "Unable to invoke Handler(Looper, Callback, boolean) constructor";
                Log.v((String)object2, (String)objectArray);
            }
        }
        object2 = new Handler(object);
        return object2;
    }

    public static Handler createAsync(Looper object, Handler.Callback object2) {
        Object object3;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return Handler.createAsync((Looper)object, (Handler.Callback)object2);
        }
        n11 = 16;
        if (n10 >= n11) {
            object3 = Handler.class;
            n11 = 3;
            Object object4 = new Class[n11];
            Class clazz = Looper.class;
            object4[0] = clazz;
            clazz = Handler.Callback.class;
            int n12 = 1;
            object4[n12] = clazz;
            clazz = Boolean.TYPE;
            int n13 = 2;
            object4[n13] = clazz;
            object3 = object3.getDeclaredConstructor((Class<?>)object4);
            Object[] objectArray = new Object[n11];
            objectArray[0] = object;
            objectArray[n12] = object2;
            object4 = Boolean.TRUE;
            objectArray[n13] = object4;
            object3 = object3.newInstance(objectArray);
            try {
                return object3;
            }
            catch (InvocationTargetException invocationTargetException) {
                object = invocationTargetException.getCause();
                boolean bl2 = object instanceof RuntimeException;
                if (!bl2) {
                    bl2 = object instanceof Error;
                    if (bl2) {
                        throw (Error)object;
                    }
                    object2 = new RuntimeException((Throwable)object);
                    throw object2;
                }
                throw (RuntimeException)object;
            }
            catch (IllegalAccessException | InstantiationException | NoSuchMethodException reflectiveOperationException) {
                object3 = TAG;
                objectArray = "Unable to invoke Handler(Looper, Callback, boolean) constructor";
                Log.v((String)object3, (String)objectArray);
            }
        }
        object3 = new Handler(object, object2);
        return object3;
    }

    public static boolean postDelayed(Handler handler, Runnable runnable, Object object, long l10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return handler.postDelayed(runnable, object, l10);
        }
        runnable = Message.obtain((Handler)handler, (Runnable)runnable);
        ((Message)runnable).obj = object;
        return handler.sendMessageDelayed((Message)runnable, l10);
    }
}

