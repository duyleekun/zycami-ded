/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.widget.CompoundButton
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.core.widget.TintableCompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {
    private static final String TAG = "CompoundButtonCompat";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    private CompoundButtonCompat() {
    }

    public static Drawable getButtonDrawable(CompoundButton object) {
        Object object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return object.getButtonDrawable();
        }
        n10 = (int)(sButtonDrawableFieldFetched ? 1 : 0);
        String string2 = TAG;
        if (!n10) {
            n10 = 1;
            object2 = CompoundButton.class;
            String string3 = "mButtonDrawable";
            object2 = ((Class)object2).getDeclaredField(string3);
            sButtonDrawableField = object2;
            try {
                ((Field)object2).setAccessible(n10 != 0);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                string3 = "Failed to retrieve mButtonDrawable field";
                Log.i((String)string2, (String)string3, (Throwable)noSuchFieldException);
            }
            sButtonDrawableFieldFetched = n10;
        }
        Object object3 = sButtonDrawableField;
        object2 = null;
        if (object3 != null) {
            object = ((Field)object3).get(object);
            try {
                return (Drawable)object;
            }
            catch (IllegalAccessException illegalAccessException) {
                object3 = "Failed to get button drawable via reflection";
                Log.i((String)string2, (String)object3, (Throwable)illegalAccessException);
                sButtonDrawableField = null;
            }
        }
        return null;
    }

    public static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return compoundButton.getButtonTintList();
        }
        n10 = compoundButton instanceof TintableCompoundButton;
        if (n10 != 0) {
            return ((TintableCompoundButton)compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    public static PorterDuff.Mode getButtonTintMode(CompoundButton compoundButton) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return compoundButton.getButtonTintMode();
        }
        n10 = compoundButton instanceof TintableCompoundButton;
        if (n10 != 0) {
            return ((TintableCompoundButton)compoundButton).getSupportButtonTintMode();
        }
        return null;
    }

    public static void setButtonTintList(CompoundButton object, ColorStateList colorStateList) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.setButtonTintList(colorStateList);
        } else {
            n10 = object instanceof TintableCompoundButton;
            if (n10 != 0) {
                object = (TintableCompoundButton)object;
                object.setSupportButtonTintList(colorStateList);
            }
        }
    }

    public static void setButtonTintMode(CompoundButton object, PorterDuff.Mode mode) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.setButtonTintMode(mode);
        } else {
            n10 = object instanceof TintableCompoundButton;
            if (n10 != 0) {
                object = (TintableCompoundButton)object;
                object.setSupportButtonTintMode(mode);
            }
        }
    }
}

