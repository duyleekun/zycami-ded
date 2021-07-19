/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableState;

public class WrappedDrawableApi14
extends Drawable
implements Drawable.Callback,
WrappedDrawable,
TintAwareDrawable {
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private boolean mColorFilterSet;
    private int mCurrentColor;
    private PorterDuff.Mode mCurrentMode;
    public Drawable mDrawable;
    private boolean mMutated;
    public WrappedDrawableState mState;

    public WrappedDrawableApi14(Drawable drawable2) {
        WrappedDrawableState wrappedDrawableState;
        this.mState = wrappedDrawableState = this.mutateConstantState();
        this.setWrappedDrawable(drawable2);
    }

    public WrappedDrawableApi14(WrappedDrawableState wrappedDrawableState, Resources resources) {
        this.mState = wrappedDrawableState;
        this.updateLocalState(resources);
    }

    private WrappedDrawableState mutateConstantState() {
        WrappedDrawableState wrappedDrawableState = this.mState;
        WrappedDrawableState wrappedDrawableState2 = new WrappedDrawableState(wrappedDrawableState);
        return wrappedDrawableState2;
    }

    private void updateLocalState(Resources resources) {
        WrappedDrawableState wrappedDrawableState = this.mState;
        if (wrappedDrawableState != null && (wrappedDrawableState = wrappedDrawableState.mDrawableState) != null) {
            resources = wrappedDrawableState.newDrawable(resources);
            this.setWrappedDrawable((Drawable)resources);
        }
    }

    private boolean updateTint(int[] nArray) {
        boolean bl2 = this.isCompatTintEnabled();
        if (!bl2) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.mState;
        ColorStateList colorStateList = wrappedDrawableState.mTint;
        wrappedDrawableState = wrappedDrawableState.mTintMode;
        if (colorStateList != null && wrappedDrawableState != null) {
            int n10 = colorStateList.getDefaultColor();
            int n11 = colorStateList.getColorForState(nArray, n10);
            int n12 = this.mColorFilterSet;
            if (n12 == 0 || n11 != (n12 = this.mCurrentColor) || wrappedDrawableState != (colorStateList = this.mCurrentMode)) {
                this.setColorFilter(n11, (PorterDuff.Mode)wrappedDrawableState);
                this.mCurrentColor = n11;
                this.mCurrentMode = wrappedDrawableState;
                this.mColorFilterSet = n11 = 1;
                return n11 != 0;
            }
        } else {
            this.mColorFilterSet = false;
            this.clearColorFilter();
        }
        return false;
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    public int getChangingConfigurations() {
        int n10;
        int n11 = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.mState;
        if (wrappedDrawableState != null) {
            n10 = wrappedDrawableState.getChangingConfigurations();
        } else {
            n10 = 0;
            wrappedDrawableState = null;
        }
        n11 |= n10;
        n10 = this.mDrawable.getChangingConfigurations();
        return n11 | n10;
    }

    public Drawable.ConstantState getConstantState() {
        boolean bl2;
        WrappedDrawableState wrappedDrawableState = this.mState;
        if (wrappedDrawableState != null && (bl2 = wrappedDrawableState.canConstantState())) {
            int n10;
            wrappedDrawableState = this.mState;
            wrappedDrawableState.mChangingConfigurations = n10 = this.getChangingConfigurations();
            return this.mState;
        }
        return null;
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

    public int getLayoutDirection() {
        return DrawableCompat.getLayoutDirection(this.mDrawable);
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

    public final Drawable getWrappedDrawable() {
        return this.mDrawable;
    }

    public void invalidateDrawable(Drawable drawable2) {
        this.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.isAutoMirrored(this.mDrawable);
    }

    public boolean isCompatTintEnabled() {
        return true;
    }

    public boolean isStateful() {
        WrappedDrawableState wrappedDrawableState;
        boolean bl2 = this.isCompatTintEnabled();
        if (bl2 && (wrappedDrawableState = this.mState) != null) {
            wrappedDrawableState = wrappedDrawableState.mTint;
        } else {
            bl2 = false;
            wrappedDrawableState = null;
        }
        if (wrappedDrawableState != null && (bl2 = wrappedDrawableState.isStateful()) || (bl2 = (wrappedDrawableState = this.mDrawable).isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            wrappedDrawableState = null;
        }
        return bl2;
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    public Drawable mutate() {
        Object object;
        boolean bl2 = this.mMutated;
        if (!bl2 && (object = super.mutate()) == this) {
            object = this.mutateConstantState();
            this.mState = object;
            object = this.mDrawable;
            if (object != null) {
                object.mutate();
            }
            if ((object = this.mState) != null) {
                Object object2 = this.mDrawable;
                object2 = object2 != null ? object2.getConstantState() : null;
                object.mDrawableState = object2;
            }
            this.mMutated = bl2 = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable2 = this.mDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int n10) {
        return DrawableCompat.setLayoutDirection(this.mDrawable, n10);
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

    public boolean setState(int[] nArray) {
        Drawable drawable2 = this.mDrawable;
        boolean bl2 = drawable2.setState(nArray);
        boolean bl3 = this.updateTint(nArray);
        if (!bl3 && !bl2) {
            bl3 = false;
            nArray = null;
        } else {
            bl3 = true;
        }
        return bl3;
    }

    public void setTint(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setTintList(colorStateList);
    }

    public void setTintList(ColorStateList object) {
        this.mState.mTint = object;
        object = this.getState();
        this.updateTint((int[])object);
    }

    public void setTintMode(PorterDuff.Mode object) {
        this.mState.mTintMode = object;
        object = this.getState();
        this.updateTint((int[])object);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        Drawable drawable2;
        boolean bl4 = super.setVisible(bl2, bl3);
        bl2 = bl4 || (bl2 = (drawable2 = this.mDrawable).setVisible(bl2, bl3));
        return bl2;
    }

    public final void setWrappedDrawable(Drawable drawable2) {
        boolean bl2;
        Object object = this.mDrawable;
        if (object != null) {
            bl2 = false;
            object.setCallback(null);
        }
        this.mDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
            int n10 = drawable2.isVisible();
            bl2 = true;
            this.setVisible(n10 != 0, bl2);
            object = drawable2.getState();
            this.setState((int[])object);
            n10 = drawable2.getLevel();
            this.setLevel(n10);
            object = drawable2.getBounds();
            this.setBounds((Rect)object);
            object = this.mState;
            if (object != null) {
                drawable2 = drawable2.getConstantState();
                object.mDrawableState = drawable2;
            }
        }
        this.invalidateSelf();
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}

