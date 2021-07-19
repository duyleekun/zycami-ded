/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import androidx.appcompat.graphics.drawable.DrawableContainer$1;
import androidx.appcompat.graphics.drawable.DrawableContainer$Api21Impl;
import androidx.appcompat.graphics.drawable.DrawableContainer$BlockInvalidateCallback;
import androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableContainer
extends Drawable
implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainer";
    private int mAlpha = 255;
    private Runnable mAnimationRunnable;
    private DrawableContainer$BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex = -1;
    private Drawable mCurrDrawable;
    private DrawableContainer$DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initializeDrawableForDisplay(Drawable drawable2) {
        DrawableContainer$BlockInvalidateCallback drawableContainer$BlockInvalidateCallback = this.mBlockInvalidateCallback;
        if (drawableContainer$BlockInvalidateCallback == null) {
            DrawableContainer$BlockInvalidateCallback drawableContainer$BlockInvalidateCallback2;
            this.mBlockInvalidateCallback = drawableContainer$BlockInvalidateCallback2 = new DrawableContainer$BlockInvalidateCallback();
        }
        DrawableContainer$BlockInvalidateCallback drawableContainer$BlockInvalidateCallback3 = this.mBlockInvalidateCallback;
        Drawable.Callback callback = drawable2.getCallback();
        DrawableContainer$BlockInvalidateCallback drawableContainer$BlockInvalidateCallback4 = drawableContainer$BlockInvalidateCallback3.wrap(callback);
        drawable2.setCallback((Drawable.Callback)drawableContainer$BlockInvalidateCallback4);
        try {
            DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
            int n10 = drawableContainer$DrawableContainerState.mEnterFadeDuration;
            if (n10 <= 0 && (n10 = (int)(this.mHasAlpha ? 1 : 0)) != 0) {
                n10 = this.mAlpha;
                drawable2.setAlpha(n10);
            }
            DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState2 = this.mDrawableContainerState;
            int n11 = drawableContainer$DrawableContainerState2.mHasColorFilter;
            if (n11 != 0) {
                ColorFilter colorFilter = drawableContainer$DrawableContainerState2.mColorFilter;
                drawable2.setColorFilter(colorFilter);
            } else {
                n11 = drawableContainer$DrawableContainerState2.mHasTintList;
                if (n11 != 0) {
                    ColorStateList colorStateList = drawableContainer$DrawableContainerState2.mTintList;
                    DrawableCompat.setTintList(drawable2, colorStateList);
                }
                DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState3 = this.mDrawableContainerState;
                n11 = drawableContainer$DrawableContainerState3.mHasTintMode;
                if (n11 != 0) {
                    PorterDuff.Mode mode = drawableContainer$DrawableContainerState3.mTintMode;
                    DrawableCompat.setTintMode(drawable2, mode);
                }
            }
            n10 = this.isVisible() ? 1 : 0;
            n11 = 1;
            drawable2.setVisible(n10 != 0, n11 != 0);
            DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState4 = this.mDrawableContainerState;
            n10 = drawableContainer$DrawableContainerState4.mDither;
            drawable2.setDither(n10 != 0);
            int[] nArray = this.getState();
            drawable2.setState(nArray);
            n10 = this.getLevel();
            drawable2.setLevel(n10);
            Rect rect = this.getBounds();
            drawable2.setBounds(rect);
            n10 = Build.VERSION.SDK_INT;
            n11 = 23;
            if (n10 >= n11) {
                n11 = DrawableCompat.getLayoutDirection(this);
                DrawableCompat.setLayoutDirection(drawable2, n11);
            }
            if (n10 >= (n11 = 19)) {
                DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState5 = this.mDrawableContainerState;
                n11 = drawableContainer$DrawableContainerState5.mAutoMirrored ? 1 : 0;
                DrawableCompat.setAutoMirrored(drawable2, n11 != 0);
            }
            Rect rect2 = this.mHotspotBounds;
            int n12 = 21;
            if (n10 < n12) return;
            if (rect2 == null) return;
            n10 = rect2.left;
            n12 = rect2.top;
            int n13 = rect2.right;
            n11 = rect2.bottom;
            DrawableCompat.setHotspotBounds(drawable2, n10, n12, n13, n11);
            return;
        }
        finally {
            Drawable.Callback callback2 = this.mBlockInvalidateCallback.unwrap();
            drawable2.setCallback(callback2);
        }
    }

    private boolean needsMirroring() {
        int n10 = this.isAutoMirrored();
        int n11 = 1;
        if (n10 == 0 || (n10 = DrawableCompat.getLayoutDirection(this)) != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public static int resolveDensity(Resources resources, int n10) {
        if (resources != null) {
            resources = resources.getDisplayMetrics();
            n10 = resources.densityDpi;
        }
        if (n10 == 0) {
            n10 = 160;
        }
        return n10;
    }

    public void animate(boolean bl2) {
        int n10;
        block8: {
            float f10;
            int n11;
            float f11;
            block6: {
                long l10;
                block5: {
                    long l11;
                    Drawable drawable2;
                    long l12;
                    long l13;
                    block7: {
                        block4: {
                            Drawable drawable3;
                            block2: {
                                block1: {
                                    long l14;
                                    block3: {
                                        n10 = 1;
                                        f11 = Float.MIN_VALUE;
                                        this.mHasAlpha = n10;
                                        l13 = SystemClock.uptimeMillis();
                                        drawable3 = this.mCurrDrawable;
                                        l12 = 255L;
                                        l10 = 0L;
                                        if (drawable3 == null) break block1;
                                        l14 = this.mEnterAnimationEnd;
                                        long l15 = l14 - l10;
                                        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                                        if (l16 == false) break block2;
                                        l16 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1);
                                        if (l16 > 0) break block3;
                                        int n12 = this.mAlpha;
                                        drawable3.setAlpha(n12);
                                        this.mEnterAnimationEnd = l10;
                                        break block2;
                                    }
                                    l14 = (l14 - l13) * l12;
                                    int n13 = (int)l14;
                                    DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
                                    int n14 = drawableContainer$DrawableContainerState.mEnterFadeDuration;
                                    n13 /= n14;
                                    n13 = 255 - n13;
                                    n14 = this.mAlpha;
                                    n13 = n13 * n14 / 255;
                                    drawable3.setAlpha(n13);
                                    n11 = n10;
                                    f10 = f11;
                                    break block4;
                                }
                                this.mEnterAnimationEnd = l10;
                            }
                            n11 = 0;
                            drawable3 = null;
                            f10 = 0.0f;
                        }
                        drawable2 = this.mLastDrawable;
                        if (drawable2 == null) break block5;
                        l11 = this.mExitAnimationEnd;
                        long l17 = l11 - l10;
                        long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                        if (l18 == false) break block6;
                        l18 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                        if (l18 > 0) break block7;
                        drawable2.setVisible(false, false);
                        n10 = 0;
                        f11 = 0.0f;
                        this.mLastDrawable = null;
                        this.mExitAnimationEnd = l10;
                        break block6;
                    }
                    l11 = (l11 - l13) * l12;
                    n11 = (int)l11;
                    DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
                    int n15 = drawableContainer$DrawableContainerState.mExitFadeDuration;
                    n11 /= n15;
                    n15 = this.mAlpha;
                    n11 = n11 * n15 / 255;
                    drawable2.setAlpha(n11);
                    break block8;
                }
                this.mExitAnimationEnd = l10;
            }
            n10 = n11;
            f11 = f10;
        }
        if (bl2 && n10 != 0) {
            Runnable runnable = this.mAnimationRunnable;
            long l19 = 16;
            this.scheduleSelf(runnable, l13 += l19);
        }
    }

    public void applyTheme(Resources.Theme theme) {
        this.mDrawableContainerState.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    public void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    public DrawableContainer$DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    public void draw(Canvas canvas) {
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if ((drawable2 = this.mLastDrawable) != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getChangingConfigurations() {
        int n10 = super.getChangingConfigurations();
        int n11 = this.mDrawableContainerState.getChangingConfigurations();
        return n10 | n11;
    }

    public final Drawable.ConstantState getConstantState() {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        boolean bl2 = drawableContainer$DrawableContainerState.canConstantState();
        if (bl2) {
            int n10;
            drawableContainer$DrawableContainerState = this.mDrawableContainerState;
            drawableContainer$DrawableContainerState.mChangingConfigurations = n10 = this.getChangingConfigurations();
            return this.mDrawableContainerState;
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    public int getCurrentIndex() {
        return this.mCurIndex;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.mHotspotBounds;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        int n10 = drawableContainer$DrawableContainerState.isConstantSize();
        if (n10 != 0) {
            return this.mDrawableContainerState.getConstantHeight();
        }
        drawableContainer$DrawableContainerState = this.mCurrDrawable;
        n10 = drawableContainer$DrawableContainerState != null ? drawableContainer$DrawableContainerState.getIntrinsicHeight() : -1;
        return n10;
    }

    public int getIntrinsicWidth() {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        int n10 = drawableContainer$DrawableContainerState.isConstantSize();
        if (n10 != 0) {
            return this.mDrawableContainerState.getConstantWidth();
        }
        drawableContainer$DrawableContainerState = this.mCurrDrawable;
        n10 = drawableContainer$DrawableContainerState != null ? drawableContainer$DrawableContainerState.getIntrinsicWidth() : -1;
        return n10;
    }

    public int getMinimumHeight() {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        int n10 = drawableContainer$DrawableContainerState.isConstantSize();
        if (n10 != 0) {
            return this.mDrawableContainerState.getConstantMinimumHeight();
        }
        drawableContainer$DrawableContainerState = this.mCurrDrawable;
        if (drawableContainer$DrawableContainerState != null) {
            n10 = drawableContainer$DrawableContainerState.getMinimumHeight();
        } else {
            n10 = 0;
            drawableContainer$DrawableContainerState = null;
        }
        return n10;
    }

    public int getMinimumWidth() {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        int n10 = drawableContainer$DrawableContainerState.isConstantSize();
        if (n10 != 0) {
            return this.mDrawableContainerState.getConstantMinimumWidth();
        }
        drawableContainer$DrawableContainerState = this.mCurrDrawable;
        if (drawableContainer$DrawableContainerState != null) {
            n10 = drawableContainer$DrawableContainerState.getMinimumWidth();
        } else {
            n10 = 0;
            drawableContainer$DrawableContainerState = null;
        }
        return n10;
    }

    public int getOpacity() {
        int n10;
        Object object = this.mCurrDrawable;
        if (object != null && (n10 = (int)(object.isVisible() ? 1 : 0)) != 0) {
            object = this.mDrawableContainerState;
            n10 = ((DrawableContainer$DrawableContainerState)((Object)object)).getOpacity();
        } else {
            n10 = -2;
        }
        return n10;
    }

    public void getOutline(Outline outline) {
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            DrawableContainer$Api21Impl.getOutline(drawable2, outline);
        }
    }

    public boolean getPadding(Rect rect) {
        int n10;
        int n11;
        int n12;
        Rect rect2 = this.mDrawableContainerState.getConstantPadding();
        if (rect2 != null) {
            rect.set(rect2);
            n12 = rect2.left;
            n11 = rect2.top;
            n12 |= n11;
            n11 = rect2.bottom;
            n10 = rect2.right | (n12 |= n11);
            if (n10 != 0) {
                n10 = 1;
            } else {
                n10 = 0;
                rect2 = null;
            }
        } else {
            rect2 = this.mCurrDrawable;
            n10 = rect2 != null ? rect2.getPadding(rect) : super.getPadding(rect);
        }
        n12 = this.needsMirroring() ? 1 : 0;
        if (n12 != 0) {
            n12 = rect.left;
            rect.left = n11 = rect.right;
            rect.right = n12;
        }
        return n10 != 0;
    }

    public void invalidateDrawable(Drawable drawable2) {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        if (drawableContainer$DrawableContainerState != null) {
            drawableContainer$DrawableContainerState.invalidateCache();
        }
        if (drawable2 == (drawableContainer$DrawableContainerState = this.mCurrDrawable) && (drawable2 = this.getCallback()) != null) {
            drawable2 = this.getCallback();
            drawable2.invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    public void jumpToCurrentState() {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2;
        float f10;
        boolean bl3;
        Drawable drawable2 = this.mLastDrawable;
        boolean bl4 = true;
        float f11 = Float.MIN_VALUE;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            drawable2 = null;
            this.mLastDrawable = null;
            bl3 = bl4;
            f10 = f11;
        } else {
            bl3 = false;
            f10 = 0.0f;
            drawable2 = null;
        }
        Drawable drawable3 = this.mCurrDrawable;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
            bl2 = this.mHasAlpha;
            if (bl2) {
                drawable3 = this.mCurrDrawable;
                int n10 = this.mAlpha;
                drawable3.setAlpha(n10);
            }
        }
        if (bl2 = (l13 = (l12 = this.mExitAnimationEnd) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
            this.mExitAnimationEnd = l11;
            bl3 = bl4;
            f10 = f11;
        }
        if (bl2 = (l10 = (l12 = this.mEnterAnimationEnd) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1)) {
            this.mEnterAnimationEnd = l11;
        } else {
            bl4 = bl3;
            f11 = f10;
        }
        if (bl4) {
            this.invalidateSelf();
        }
    }

    public Drawable mutate() {
        Object object;
        boolean bl2 = this.mMutated;
        if (!bl2 && (object = super.mutate()) == this) {
            object = this.cloneConstantState();
            ((DrawableContainer$DrawableContainerState)((Object)object)).mutate();
            this.setConstantState((DrawableContainer$DrawableContainerState)((Object)object));
            this.mMutated = bl2 = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
        if ((drawable2 = this.mCurrDrawable) != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int n10) {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        int n11 = this.getCurrentIndex();
        return drawableContainer$DrawableContainerState.setLayoutDirection(n10, n11);
    }

    public boolean onLevelChange(int n10) {
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(n10);
        }
        drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setLevel(n10);
        }
        return false;
    }

    public boolean onStateChange(int[] nArray) {
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            return drawable2.setState(nArray);
        }
        drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            return drawable2.setState(nArray);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l10) {
        Drawable drawable3 = this.mCurrDrawable;
        if (drawable2 == drawable3 && (drawable2 = this.getCallback()) != null) {
            drawable2 = this.getCallback();
            drawable2.scheduleDrawable((Drawable)this, runnable, l10);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean selectDrawable(int var1_1) {
        var2_2 = this.mCurIndex;
        var3_3 = 0;
        if (var1_1 == var2_2) {
            return false;
        }
        var4_4 = SystemClock.uptimeMillis();
        var6_5 = this.mDrawableContainerState;
        var2_2 = var6_5.mExitFadeDuration;
        var7_6 = 0L;
        if (var2_2 > 0) {
            var6_5 = this.mLastDrawable;
            if (var6_5 != null) {
                var6_5.setVisible(false, false);
            }
            if ((var6_5 = this.mCurrDrawable) != null) {
                this.mLastDrawable = var6_5;
                var6_5 = this.mDrawableContainerState;
                var2_2 = var6_5.mExitFadeDuration;
                this.mExitAnimationEnd = var9_7 = (long)var2_2 + var4_4;
            } else {
                this.mLastDrawable = null;
                this.mExitAnimationEnd = var7_6;
            }
        } else {
            var6_5 = this.mCurrDrawable;
            if (var6_5 != null) {
                var6_5.setVisible(false, false);
            }
        }
        if (var1_1 < 0) ** GOTO lbl-1000
        var6_5 = this.mDrawableContainerState;
        var3_3 = var6_5.mNumChildren;
        if (var1_1 < var3_3) {
            var6_5 = var6_5.getChild(var1_1);
            this.mCurrDrawable = var6_5;
            this.mCurIndex = var1_1;
            if (var6_5 != null) {
                var11_8 /* !! */  = this.mDrawableContainerState;
                var1_1 = var11_8 /* !! */ .mEnterFadeDuration;
                if (var1_1 > 0) {
                    var12_9 = var1_1;
                    this.mEnterAnimationEnd = var4_4 += var12_9;
                }
                this.initializeDrawableForDisplay((Drawable)var6_5);
            }
        } else lbl-1000:
        // 2 sources

        {
            this.mCurrDrawable = null;
            this.mCurIndex = var1_1 = -1;
        }
        var9_7 = this.mEnterAnimationEnd;
        var1_1 = var9_7 == var7_6 ? 0 : (var9_7 < var7_6 ? -1 : 1);
        var2_2 = 1;
        if (var1_1 != 0 || (var1_1 = (int)((cfr_temp_0 = (var14_10 = this.mExitAnimationEnd) - var7_6) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) != 0) {
            var11_8 /* !! */  = this.mAnimationRunnable;
            if (var11_8 /* !! */  == null) {
                this.mAnimationRunnable = var11_8 /* !! */  = new DrawableContainer$1(this);
            } else {
                this.unscheduleSelf(var11_8 /* !! */ );
            }
            this.animate((boolean)var2_2);
        }
        this.invalidateSelf();
        return var2_2;
    }

    public void setAlpha(int n10) {
        int n11 = this.mHasAlpha;
        if (n11 == 0 || (n11 = this.mAlpha) != n10) {
            n11 = 1;
            this.mHasAlpha = n11;
            this.mAlpha = n10;
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                long l10 = this.mEnterAnimationEnd;
                long l11 = 0L;
                long l12 = l10 - l11;
                long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (l13 == false) {
                    drawable2.setAlpha(n10);
                } else {
                    n10 = 0;
                    this.animate(false);
                }
            }
        }
    }

    public void setAutoMirrored(boolean bl2) {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        boolean bl3 = drawableContainer$DrawableContainerState.mAutoMirrored;
        if (bl3 != bl2) {
            drawableContainer$DrawableContainerState.mAutoMirrored = bl2;
            drawableContainer$DrawableContainerState = this.mCurrDrawable;
            if (drawableContainer$DrawableContainerState != null) {
                DrawableCompat.setAutoMirrored((Drawable)drawableContainer$DrawableContainerState, bl2);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        boolean bl2;
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        drawableContainer$DrawableContainerState.mHasColorFilter = bl2 = true;
        ColorFilter colorFilter2 = drawableContainer$DrawableContainerState.mColorFilter;
        if (colorFilter2 != colorFilter) {
            drawableContainer$DrawableContainerState.mColorFilter = colorFilter;
            drawableContainer$DrawableContainerState = this.mCurrDrawable;
            if (drawableContainer$DrawableContainerState != null) {
                drawableContainer$DrawableContainerState.setColorFilter(colorFilter);
            }
        }
    }

    public void setConstantState(DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState) {
        this.mDrawableContainerState = drawableContainer$DrawableContainerState;
        int n10 = this.mCurIndex;
        if (n10 >= 0) {
            drawableContainer$DrawableContainerState = drawableContainer$DrawableContainerState.getChild(n10);
            this.mCurrDrawable = drawableContainer$DrawableContainerState;
            if (drawableContainer$DrawableContainerState != null) {
                this.initializeDrawableForDisplay((Drawable)drawableContainer$DrawableContainerState);
            }
        }
        this.mLastDrawable = null;
    }

    public void setCurrentIndex(int n10) {
        this.selectDrawable(n10);
    }

    public void setDither(boolean bl2) {
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        boolean bl3 = drawableContainer$DrawableContainerState.mDither;
        if (bl3 != bl2) {
            drawableContainer$DrawableContainerState.mDither = bl2;
            drawableContainer$DrawableContainerState = this.mCurrDrawable;
            if (drawableContainer$DrawableContainerState != null) {
                drawableContainer$DrawableContainerState.setDither(bl2);
            }
        }
    }

    public void setEnterFadeDuration(int n10) {
        this.mDrawableContainerState.mEnterFadeDuration = n10;
    }

    public void setExitFadeDuration(int n10) {
        this.mDrawableContainerState.mExitFadeDuration = n10;
    }

    public void setHotspot(float f10, float f11) {
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f10, f11);
        }
    }

    public void setHotspotBounds(int n10, int n11, int n12, int n13) {
        Rect rect = this.mHotspotBounds;
        if (rect == null) {
            this.mHotspotBounds = rect = new Rect(n10, n11, n12, n13);
        } else {
            rect.set(n10, n11, n12, n13);
        }
        rect = this.mCurrDrawable;
        if (rect != null) {
            DrawableCompat.setHotspotBounds((Drawable)rect, n10, n11, n12, n13);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        boolean bl2;
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        drawableContainer$DrawableContainerState.mHasTintList = bl2 = true;
        ColorStateList colorStateList2 = drawableContainer$DrawableContainerState.mTintList;
        if (colorStateList2 != colorStateList) {
            drawableContainer$DrawableContainerState.mTintList = colorStateList;
            drawableContainer$DrawableContainerState = this.mCurrDrawable;
            DrawableCompat.setTintList((Drawable)drawableContainer$DrawableContainerState, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        boolean bl2;
        DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState = this.mDrawableContainerState;
        drawableContainer$DrawableContainerState.mHasTintMode = bl2 = true;
        PorterDuff.Mode mode2 = drawableContainer$DrawableContainerState.mTintMode;
        if (mode2 != mode) {
            drawableContainer$DrawableContainerState.mTintMode = mode;
            drawableContainer$DrawableContainerState = this.mCurrDrawable;
            DrawableCompat.setTintMode((Drawable)drawableContainer$DrawableContainerState, mode);
        }
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        boolean bl4 = super.setVisible(bl2, bl3);
        Drawable drawable2 = this.mLastDrawable;
        if (drawable2 != null) {
            drawable2.setVisible(bl2, bl3);
        }
        if ((drawable2 = this.mCurrDrawable) != null) {
            drawable2.setVisible(bl2, bl3);
        }
        return bl4;
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        Drawable drawable3 = this.mCurrDrawable;
        if (drawable2 == drawable3 && (drawable2 = this.getCallback()) != null) {
            drawable2 = this.getCallback();
            drawable2.unscheduleDrawable((Drawable)this, runnable);
        }
    }

    public final void updateDensity(Resources resources) {
        this.mDrawableContainerState.updateDensity(resources);
    }
}

