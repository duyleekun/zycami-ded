/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

public abstract class VectorDrawableCommon
extends Drawable
implements TintAwareDrawable {
    public Drawable mDelegateDrawable;

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.applyTheme(drawable2, theme);
        }
    }

    public void clearColorFilter() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    public Drawable getCurrent() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumHeight() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.jumpToCurrentState(drawable2);
        }
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
            return;
        }
        super.onBoundsChange(rect);
    }

    public boolean onLevelChange(int n10) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(n10);
        }
        return super.onLevelChange(n10);
    }

    public void setChangingConfigurations(int n10) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setChangingConfigurations(n10);
            return;
        }
        super.setChangingConfigurations(n10);
    }

    public void setColorFilter(int n10, PorterDuff.Mode mode) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(n10, mode);
            return;
        }
        super.setColorFilter(n10, mode);
    }

    public void setFilterBitmap(boolean bl2) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setFilterBitmap(bl2);
        }
    }

    public void setHotspot(float f10, float f11) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f10, f11);
        }
    }

    public void setHotspotBounds(int n10, int n11, int n12, int n13) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspotBounds(drawable2, n10, n11, n12, n13);
        }
    }

    public boolean setState(int[] nArray) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.setState(nArray);
        }
        return super.setState(nArray);
    }
}

