/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.widget.ImageView
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.core.widget.TintableImageSourceView;

public class ImageViewCompat {
    private ImageViewCompat() {
    }

    public static ColorStateList getImageTintList(ImageView object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return object.getImageTintList();
        }
        n10 = object instanceof TintableImageSourceView;
        object = n10 != 0 ? ((TintableImageSourceView)object).getSupportImageTintList() : null;
        return object;
    }

    public static PorterDuff.Mode getImageTintMode(ImageView object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return object.getImageTintMode();
        }
        n10 = object instanceof TintableImageSourceView;
        object = n10 != 0 ? ((TintableImageSourceView)object).getSupportImageTintMode() : null;
        return object;
    }

    public static void setImageTintList(ImageView object, ColorStateList colorStateList) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            Object object2;
            object.setImageTintList(colorStateList);
            if (n10 == n11 && (colorStateList = object.getDrawable()) != null && (object2 = object.getImageTintList()) != null) {
                n10 = (int)(colorStateList.isStateful() ? 1 : 0);
                if (n10 != 0) {
                    object2 = object.getDrawableState();
                    colorStateList.setState((int[])object2);
                }
                object.setImageDrawable((Drawable)colorStateList);
            }
        } else {
            n10 = object instanceof TintableImageSourceView;
            if (n10 != 0) {
                object = (TintableImageSourceView)object;
                object.setSupportImageTintList(colorStateList);
            }
        }
    }

    public static void setImageTintMode(ImageView object, PorterDuff.Mode mode) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            Object object2;
            object.setImageTintMode(mode);
            if (n10 == n11 && (mode = object.getDrawable()) != null && (object2 = object.getImageTintList()) != null) {
                n10 = (int)(mode.isStateful() ? 1 : 0);
                if (n10 != 0) {
                    object2 = object.getDrawableState();
                    mode.setState((int[])object2);
                }
                object.setImageDrawable((Drawable)mode);
            }
        } else {
            n10 = object instanceof TintableImageSourceView;
            if (n10 != 0) {
                object = (TintableImageSourceView)object;
                object.setSupportImageTintMode(mode);
            }
        }
    }
}

