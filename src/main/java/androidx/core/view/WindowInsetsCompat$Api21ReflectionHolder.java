/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.View
 */
package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

public class WindowInsetsCompat$Api21ReflectionHolder {
    private static Field sContentInsets;
    private static boolean sReflectionSucceeded;
    private static Field sStableInsets;
    private static Field sViewAttachInfoField;

    static {
        AnnotatedElement annotatedElement = View.class;
        CharSequence charSequence = "mAttachInfo";
        annotatedElement = ((Class)annotatedElement).getDeclaredField((String)charSequence);
        sViewAttachInfoField = annotatedElement;
        boolean bl2 = true;
        ((Field)annotatedElement).setAccessible(bl2);
        annotatedElement = "android.view.View$AttachInfo";
        annotatedElement = Class.forName((String)((Object)annotatedElement));
        Object object = "mStableInsets";
        object = ((Class)annotatedElement).getDeclaredField((String)object);
        sStableInsets = object;
        ((Field)object).setAccessible(bl2);
        object = "mContentInsets";
        annotatedElement = ((Class)annotatedElement).getDeclaredField((String)object);
        sContentInsets = annotatedElement;
        try {
            ((Field)annotatedElement).setAccessible(bl2);
            sReflectionSucceeded = bl2;
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Failed to get visible insets from AttachInfo ");
            object = reflectiveOperationException.getMessage();
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            object = "WindowInsetsCompat";
            Log.w((String)object, (String)charSequence, (Throwable)reflectiveOperationException);
        }
    }

    private WindowInsetsCompat$Api21ReflectionHolder() {
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        block18: {
            boolean bl2 = sReflectionSucceeded;
            if (bl2 && (bl2 = view.isAttachedToWindow())) {
                Object object = view.getRootView();
                Object object2 = sViewAttachInfoField;
                object = ((Field)object2).get(object);
                if (object == null) break block18;
                object2 = sStableInsets;
                object2 = ((Field)object2).get(object);
                object2 = (Rect)object2;
                Object object3 = sContentInsets;
                object = ((Field)object3).get(object);
                object = (Rect)object;
                if (object2 == null || object == null) break block18;
                object3 = new WindowInsetsCompat$Builder();
                object2 = Insets.of((Rect)object2);
                object2 = ((WindowInsetsCompat$Builder)object3).setStableInsets((Insets)object2);
                object = Insets.of((Rect)object);
                object = ((WindowInsetsCompat$Builder)object2).setSystemWindowInsets((Insets)object);
                object = ((WindowInsetsCompat$Builder)object).build();
                ((WindowInsetsCompat)object).setRootWindowInsets((WindowInsetsCompat)object);
                view = view.getRootView();
                try {
                    ((WindowInsetsCompat)object).copyRootViewBounds(view);
                    return object;
                }
                catch (IllegalAccessException illegalAccessException) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Failed to get insets from AttachInfo. ");
                    object2 = illegalAccessException.getMessage();
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    object2 = "WindowInsetsCompat";
                    Log.w((String)object2, (String)object, (Throwable)illegalAccessException);
                }
            }
        }
        return null;
    }
}

