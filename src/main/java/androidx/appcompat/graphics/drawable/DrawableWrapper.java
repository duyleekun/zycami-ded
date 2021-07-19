/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapper
extends Drawable
implements Drawable.Callback {
    private Drawable mDrawable;

    public DrawableWrapper(Drawable drawable2) {
        this.setWrappedDrawable(drawable2);
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.mDrawable.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable drawable2) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    public boolean isStateful() {
        return this.mDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public void onBoundsChange(Rect rect) {
        this.mDrawable.setBounds(rect);
    }

    public boolean onLevelChange(int n10) {
        return this.mDrawable.setLevel(n10);
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l10) {
        this.scheduleSelf(runnable, l10);
    }

    public void setAlpha(int n10) {
        this.mDrawable.setAlpha(n10);
    }

    public void setAutoMirrored(boolean bl2) {
        DrawableCompat.setAutoMirrored(this.mDrawable, bl2);
    }

    public void setChangingConfigurations(int n10) {
        this.mDrawable.setChangingConfigurations(n10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl2) {
        this.mDrawable.setDither(bl2);
    }

    public void setFilterBitmap(boolean bl2) {
        this.mDrawable.setFilterBitmap(bl2);
    }

    public void setHotspot(float f10, float f11) {
        DrawableCompat.setHotspot(this.mDrawable, f10, f11);
    }

    public void setHotspotBounds(int n10, int n11, int n12, int n13) {
        DrawableCompat.setHotspotBounds(this.mDrawable, n10, n11, n12, n13);
    }

    public boolean setState(int[] nArray) {
        return this.mDrawable.setState(nArray);
    }

    public void setTint(int n10) {
        DrawableCompat.setTint(this.mDrawable, n10);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.mDrawable, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.setTintMode(this.mDrawable, mode);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        Drawable drawable2;
        boolean bl4 = super.setVisible(bl2, bl3);
        bl2 = bl4 || (bl2 = (drawable2 = this.mDrawable).setVisible(bl2, bl3));
        return bl2;
    }

    public void setWrappedDrawable(Drawable drawable2) {
        Drawable drawable3 = this.mDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        this.mDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
        }
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}

