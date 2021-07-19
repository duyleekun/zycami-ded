/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$BuilderImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class WindowInsetsCompat$BuilderImpl20
extends WindowInsetsCompat$BuilderImpl {
    private static Constructor sConstructor;
    private static boolean sConstructorFetched = false;
    private static Field sConsumedField;
    private static boolean sConsumedFieldFetched = false;
    private WindowInsets mInsets;
    private Insets mStableInsets;

    public WindowInsetsCompat$BuilderImpl20() {
        WindowInsets windowInsets;
        this.mInsets = windowInsets = WindowInsetsCompat$BuilderImpl20.createWindowInsetsInstance();
    }

    public WindowInsetsCompat$BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
        windowInsetsCompat = windowInsetsCompat.toWindowInsets();
        this.mInsets = windowInsetsCompat;
    }

    private static WindowInsets createWindowInsetsInstance() {
        Rect rect;
        String string2;
        Constructor constructor;
        String string3;
        int n10;
        boolean bl2;
        block24: {
            String string4;
            bl2 = sConsumedFieldFetched;
            n10 = 1;
            string3 = "WindowInsetsCompat";
            if (!bl2) {
                constructor = WindowInsets.class;
                string4 = "CONSUMED";
                constructor = ((Class)((Object)constructor)).getDeclaredField(string4);
                try {
                    sConsumedField = constructor;
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    string4 = "Could not retrieve WindowInsets.CONSUMED field";
                    Log.i((String)string3, (String)string4, (Throwable)reflectiveOperationException);
                }
                sConsumedFieldFetched = n10;
            }
            constructor = sConsumedField;
            string4 = null;
            if (constructor != null) {
                constructor = ((Field)((Object)constructor)).get(null);
                constructor = (WindowInsets)constructor;
                if (constructor == null) break block24;
                try {
                    string2 = new WindowInsets((WindowInsets)constructor);
                    return string2;
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    string2 = "Could not get value from WindowInsets.CONSUMED field";
                    Log.i((String)string3, (String)string2, (Throwable)reflectiveOperationException);
                }
            }
        }
        bl2 = sConstructorFetched;
        string2 = null;
        if (!bl2) {
            constructor = WindowInsets.class;
            rect = new Class[n10];
            Class<Rect> clazz = Rect.class;
            rect[0] = clazz;
            constructor = ((Class)((Object)constructor)).getConstructor((Class<?>)rect);
            try {
                sConstructor = constructor;
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                rect = "Could not retrieve WindowInsets(Rect) constructor";
                Log.i((String)string3, (String)rect, (Throwable)reflectiveOperationException);
            }
            sConstructorFetched = n10;
        }
        if ((constructor = sConstructor) != null) {
            Object[] objectArray = new Object[n10];
            rect = new Rect();
            objectArray[0] = rect;
            constructor = constructor.newInstance(objectArray);
            try {
                return (WindowInsets)constructor;
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                objectArray = "Could not invoke WindowInsets(Rect) constructor";
                Log.i((String)string3, (String)objectArray, (Throwable)reflectiveOperationException);
            }
        }
        return null;
    }

    public WindowInsetsCompat build() {
        this.applyInsetTypes();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mInsets);
        Object object = this.mInsetsTypeMask;
        windowInsetsCompat.setOverriddenInsets((Insets[])object);
        object = this.mStableInsets;
        windowInsetsCompat.setStableInsets((Insets)object);
        return windowInsetsCompat;
    }

    public void setStableInsets(Insets insets) {
        this.mStableInsets = insets;
    }

    public void setSystemWindowInsets(Insets insets) {
        WindowInsets windowInsets = this.mInsets;
        if (windowInsets != null) {
            int n10 = insets.left;
            int n11 = insets.top;
            int n12 = insets.right;
            int n13 = insets.bottom;
            insets = windowInsets.replaceSystemWindowInsets(n10, n11, n12, n13);
            this.mInsets = insets;
        }
    }
}

