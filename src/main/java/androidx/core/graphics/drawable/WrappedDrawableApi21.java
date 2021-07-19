/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Outline
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.drawable.WrappedDrawableApi14;
import androidx.core.graphics.drawable.WrappedDrawableState;
import java.lang.reflect.Method;

public class WrappedDrawableApi21
extends WrappedDrawableApi14 {
    private static final String TAG = "WrappedDrawableApi21";
    private static Method sIsProjectedDrawableMethod;

    public WrappedDrawableApi21(Drawable drawable2) {
        super(drawable2);
        this.findAndCacheIsProjectedDrawableMethod();
    }

    public WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        this.findAndCacheIsProjectedDrawableMethod();
    }

    private void findAndCacheIsProjectedDrawableMethod() {
        Object object = sIsProjectedDrawableMethod;
        if (object == null) {
            object = Drawable.class;
            String string2 = "isProjected";
            Object object2 = null;
            object2 = new Class[]{};
            object = ((Class)object).getDeclaredMethod(string2, (Class<?>)object2);
            try {
                sIsProjectedDrawableMethod = object;
            }
            catch (Exception exception) {
                string2 = TAG;
                object2 = "Failed to retrieve Drawable#isProjected() method";
                Log.w((String)string2, (String)object2, (Throwable)exception);
            }
        }
    }

    public Rect getDirtyBounds() {
        return this.mDrawable.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.mDrawable.getOutline(outline);
    }

    public boolean isCompatTintEnabled() {
        Drawable drawable2;
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        int n11 = 21;
        if (n10 == n11 && ((n11 = (drawable2 = this.mDrawable) instanceof GradientDrawable) != 0 || (n11 = drawable2 instanceof DrawableContainer) != 0 || (n11 = drawable2 instanceof InsetDrawable) != 0 || (n10 = drawable2 instanceof RippleDrawable) != 0)) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isProjected() {
        Object object;
        Object object2 = this.mDrawable;
        if (object2 != null && (object = sIsProjectedDrawableMethod) != null) {
            Object[] objectArray = new Object[]{};
            object2 = ((Method)object).invoke(object2, objectArray);
            object2 = (Boolean)object2;
            try {
                return (Boolean)object2;
            }
            catch (Exception exception) {
                object = TAG;
                objectArray = "Error calling Drawable#isProjected() method";
                Log.w((String)object, (String)objectArray, (Throwable)exception);
            }
        }
        return false;
    }

    public void setHotspot(float f10, float f11) {
        this.mDrawable.setHotspot(f10, f11);
    }

    public void setHotspotBounds(int n10, int n11, int n12, int n13) {
        this.mDrawable.setHotspotBounds(n10, n11, n12, n13);
    }

    public boolean setState(int[] nArray) {
        boolean bl2 = super.setState(nArray);
        if (bl2) {
            this.invalidateSelf();
            return true;
        }
        return false;
    }

    public void setTint(int n10) {
        boolean bl2 = this.isCompatTintEnabled();
        if (bl2) {
            super.setTint(n10);
        } else {
            Drawable drawable2 = this.mDrawable;
            drawable2.setTint(n10);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        boolean bl2 = this.isCompatTintEnabled();
        if (bl2) {
            super.setTintList(colorStateList);
        } else {
            Drawable drawable2 = this.mDrawable;
            drawable2.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        boolean bl2 = this.isCompatTintEnabled();
        if (bl2) {
            super.setTintMode(mode);
        } else {
            Drawable drawable2 = this.mDrawable;
            drawable2.setTintMode(mode);
        }
    }
}

