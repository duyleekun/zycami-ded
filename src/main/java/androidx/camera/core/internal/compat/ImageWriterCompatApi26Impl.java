/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageWriter
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.Surface
 */
package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ImageWriterCompatApi26Impl {
    private static final String TAG = "ImageWriterCompatApi26";
    private static Method sNewInstanceMethod;

    static {
        Object object = ImageWriter.class;
        String string2 = "newInstance";
        int n10 = 3;
        Object object2 = new Class[n10];
        int n11 = 0;
        Class clazz = Surface.class;
        object2[0] = clazz;
        n11 = 1;
        clazz = Integer.TYPE;
        object2[n11] = clazz;
        n11 = 2;
        object2[n11] = clazz;
        object = ((Class)object).getMethod(string2, (Class<?>)object2);
        try {
            sNewInstanceMethod = object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string2 = TAG;
            object2 = "Unable to initialize via reflection.";
            Log.i((String)string2, (String)object2, (Throwable)noSuchMethodException);
        }
    }

    private ImageWriterCompatApi26Impl() {
    }

    public static ImageWriter newInstance(Surface object, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        Object object2 = null;
        int n13 = 26;
        if (n12 >= n13) {
            Method method = sNewInstanceMethod;
            n13 = 3;
            Object[] objectArray = new Object[n13];
            objectArray[0] = object;
            int n14 = 1;
            Integer n15 = n10;
            objectArray[n14] = n15;
            n14 = 2;
            n15 = n11;
            objectArray[n14] = n15;
            object = method.invoke(null, objectArray);
            object = Preconditions.checkNotNull(object);
            try {
                return (ImageWriter)object;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
            object2 = object;
        }
        object = new RuntimeException("Unable to invoke newInstance(Surface, int, int) via reflection.", (Throwable)object2);
        throw object;
    }
}

