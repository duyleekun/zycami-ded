/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.DrawableContainer$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat;

public abstract class DrawableContainer$DrawableContainerState
extends Drawable.ConstantState {
    public boolean mAutoMirrored;
    public boolean mCanConstantState;
    public int mChangingConfigurations;
    public boolean mCheckedConstantSize;
    public boolean mCheckedConstantState;
    public boolean mCheckedOpacity;
    public boolean mCheckedPadding;
    public boolean mCheckedStateful;
    public int mChildrenChangingConfigurations;
    public ColorFilter mColorFilter;
    public int mConstantHeight;
    public int mConstantMinimumHeight;
    public int mConstantMinimumWidth;
    public Rect mConstantPadding;
    public boolean mConstantSize;
    public int mConstantWidth;
    public int mDensity;
    public boolean mDither;
    public SparseArray mDrawableFutures;
    public Drawable[] mDrawables;
    public int mEnterFadeDuration;
    public int mExitFadeDuration;
    public boolean mHasColorFilter;
    public boolean mHasTintList;
    public boolean mHasTintMode;
    public int mLayoutDirection;
    public boolean mMutated;
    public int mNumChildren;
    public int mOpacity;
    public final DrawableContainer mOwner;
    public Resources mSourceRes;
    public boolean mStateful;
    public ColorStateList mTintList;
    public PorterDuff.Mode mTintMode;
    public boolean mVariablePadding;

    public DrawableContainer$DrawableContainerState(DrawableContainer$DrawableContainerState sparseArray, DrawableContainer drawableArray, Resources rect) {
        int n10;
        int n11;
        Rect rect2;
        boolean bl2;
        int n12 = 0;
        this.mVariablePadding = false;
        this.mConstantSize = false;
        this.mDither = bl2 = true;
        this.mEnterFadeDuration = 0;
        this.mExitFadeDuration = 0;
        this.mOwner = drawableArray;
        int n13 = 0;
        drawableArray = null;
        if (rect != null) {
            rect2 = rect;
        } else if (sparseArray != null) {
            rect2 = sparseArray.mSourceRes;
        } else {
            n11 = 0;
            rect2 = null;
        }
        this.mSourceRes = rect2;
        if (sparseArray != null) {
            n11 = sparseArray.mDensity;
        } else {
            n11 = 0;
            rect2 = null;
        }
        this.mDensity = n10 = DrawableContainer.resolveDensity((Resources)rect, n11);
        if (sparseArray != null) {
            this.mChangingConfigurations = n11 = sparseArray.mChangingConfigurations;
            this.mChildrenChangingConfigurations = n11 = sparseArray.mChildrenChangingConfigurations;
            this.mCheckedConstantState = bl2;
            this.mCanConstantState = bl2;
            n11 = sparseArray.mVariablePadding ? 1 : 0;
            this.mVariablePadding = n11;
            n11 = sparseArray.mConstantSize ? 1 : 0;
            this.mConstantSize = n11;
            n11 = sparseArray.mDither ? 1 : 0;
            this.mDither = n11;
            n11 = sparseArray.mMutated ? 1 : 0;
            this.mMutated = n11;
            this.mLayoutDirection = n11 = sparseArray.mLayoutDirection;
            this.mEnterFadeDuration = n11 = sparseArray.mEnterFadeDuration;
            this.mExitFadeDuration = n11 = sparseArray.mExitFadeDuration;
            n11 = sparseArray.mAutoMirrored ? 1 : 0;
            this.mAutoMirrored = n11;
            rect2 = sparseArray.mColorFilter;
            this.mColorFilter = rect2;
            n11 = sparseArray.mHasColorFilter ? 1 : 0;
            this.mHasColorFilter = n11;
            rect2 = sparseArray.mTintList;
            this.mTintList = rect2;
            rect2 = sparseArray.mTintMode;
            this.mTintMode = rect2;
            n11 = sparseArray.mHasTintList ? 1 : 0;
            this.mHasTintList = n11;
            n11 = sparseArray.mHasTintMode ? 1 : 0;
            this.mHasTintMode = n11;
            n11 = sparseArray.mDensity;
            if (n11 == n10) {
                n10 = sparseArray.mCheckedPadding ? 1 : 0;
                if (n10 != 0) {
                    rect = sparseArray.mConstantPadding;
                    if (rect != null) {
                        rect = sparseArray.mConstantPadding;
                        super(rect);
                    }
                    this.mConstantPadding = drawableArray;
                    this.mCheckedPadding = bl2;
                }
                if ((n13 = sparseArray.mCheckedConstantSize) != 0) {
                    this.mConstantWidth = n13 = sparseArray.mConstantWidth;
                    this.mConstantHeight = n13 = sparseArray.mConstantHeight;
                    this.mConstantMinimumWidth = n13 = sparseArray.mConstantMinimumWidth;
                    this.mConstantMinimumHeight = n13 = sparseArray.mConstantMinimumHeight;
                    this.mCheckedConstantSize = bl2;
                }
            }
            if ((n13 = sparseArray.mCheckedOpacity) != 0) {
                this.mOpacity = n13 = sparseArray.mOpacity;
                this.mCheckedOpacity = bl2;
            }
            if ((n13 = (int)(sparseArray.mCheckedStateful ? 1 : 0)) != 0) {
                n13 = sparseArray.mStateful ? 1 : 0;
                this.mStateful = n13;
                this.mCheckedStateful = bl2;
            }
            drawableArray = sparseArray.mDrawables;
            this.mDrawables = rect = new Drawable[drawableArray.length];
            this.mNumChildren = n10 = sparseArray.mNumChildren;
            sparseArray = sparseArray.mDrawableFutures;
            if (sparseArray != null) {
                this.mDrawableFutures = sparseArray = sparseArray.clone();
            } else {
                n10 = this.mNumChildren;
                this.mDrawableFutures = sparseArray = new SparseArray(n10);
            }
            int n14 = this.mNumChildren;
            while (n12 < n14) {
                rect = drawableArray[n12];
                if (rect != null) {
                    SparseArray sparseArray2;
                    rect = drawableArray[n12].getConstantState();
                    if (rect != null) {
                        sparseArray2 = this.mDrawableFutures;
                        sparseArray2.put(n12, (Object)rect);
                    } else {
                        rect = this.mDrawables;
                        sparseArray2 = drawableArray[n12];
                        rect[n12] = sparseArray2;
                    }
                }
                ++n12;
            }
        } else {
            int n15 = 10;
            sparseArray = new Drawable[n15];
            this.mDrawables = sparseArray;
            this.mNumChildren = 0;
        }
    }

    private void createAllFutures() {
        SparseArray sparseArray = this.mDrawableFutures;
        if (sparseArray != null) {
            int n10 = sparseArray.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                SparseArray sparseArray2 = this.mDrawableFutures;
                int n11 = sparseArray2.keyAt(i10);
                Drawable.ConstantState constantState = (Drawable.ConstantState)this.mDrawableFutures.valueAt(i10);
                Drawable[] drawableArray = this.mDrawables;
                Resources resources = this.mSourceRes;
                constantState = constantState.newDrawable(resources);
                constantState = this.prepareDrawable((Drawable)constantState);
                drawableArray[n11] = constantState;
            }
            n10 = 0;
            sparseArray = null;
            this.mDrawableFutures = null;
        }
    }

    private Drawable prepareDrawable(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            n10 = this.mLayoutDirection;
            DrawableCompat.setLayoutDirection(drawable2, n10);
        }
        drawable2 = drawable2.mutate();
        DrawableContainer drawableContainer = this.mOwner;
        drawable2.setCallback((Drawable.Callback)drawableContainer);
        return drawable2;
    }

    public final int addChild(Drawable drawable2) {
        int n10;
        int n11;
        int n12 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n13 = drawableArray.length;
        if (n12 >= n13) {
            n13 = n12 + 10;
            this.growArray(n12, n13);
        }
        drawable2.mutate();
        int n14 = 1;
        drawable2.setVisible(false, n14 != 0);
        DrawableContainer drawableContainer = this.mOwner;
        drawable2.setCallback((Drawable.Callback)drawableContainer);
        this.mDrawables[n12] = drawable2;
        this.mNumChildren = n11 = this.mNumChildren + n14;
        n14 = this.mChildrenChangingConfigurations;
        this.mChildrenChangingConfigurations = n10 = drawable2.getChangingConfigurations() | n14;
        this.invalidateCache();
        this.mConstantPadding = null;
        this.mCheckedPadding = false;
        this.mCheckedConstantSize = false;
        this.mCheckedConstantState = false;
        return n12;
    }

    public final void applyTheme(Resources.Theme theme) {
        if (theme != null) {
            this.createAllFutures();
            int n10 = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                Drawable drawable2 = drawableArray[i10];
                if (drawable2 == null || (n11 = DrawableCompat.canApplyTheme(drawable2 = drawableArray[i10])) == 0) continue;
                drawable2 = drawableArray[i10];
                DrawableCompat.applyTheme(drawable2, theme);
                n11 = this.mChildrenChangingConfigurations;
                Drawable drawable3 = drawableArray[i10];
                int n12 = drawable3.getChangingConfigurations();
                this.mChildrenChangingConfigurations = n11 |= n12;
            }
            theme = DrawableContainer$Api21Impl.getResources(theme);
            this.updateDensity((Resources)theme);
        }
    }

    public boolean canApplyTheme() {
        int n10 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Drawable drawable2 = drawableArray[i10];
            boolean bl3 = true;
            if (!(drawable2 != null ? (bl2 = DrawableCompat.canApplyTheme(drawable2)) : (drawable2 = (Drawable.ConstantState)this.mDrawableFutures.get(i10)) != null && (bl2 = DrawableContainer$Api21Impl.canApplyTheme((Drawable.ConstantState)drawable2)))) continue;
            return bl3;
        }
        return false;
    }

    public boolean canConstantState() {
        boolean bl2 = this.mCheckedConstantState;
        if (bl2) {
            return this.mCanConstantState;
        }
        this.createAllFutures();
        this.mCheckedConstantState = bl2 = true;
        int n10 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        for (int i10 = 0; i10 < n10; ++i10) {
            Drawable.ConstantState constantState = drawableArray[i10].getConstantState();
            if (constantState != null) continue;
            this.mCanConstantState = false;
            return false;
        }
        this.mCanConstantState = bl2;
        return bl2;
    }

    public final void clearMutated() {
        this.mMutated = false;
    }

    public void computeConstantSize() {
        int n10;
        this.mCheckedConstantSize = true;
        this.createAllFutures();
        int n11 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        this.mConstantHeight = n10 = -1;
        this.mConstantWidth = n10;
        this.mConstantMinimumHeight = 0;
        this.mConstantMinimumWidth = 0;
        for (n10 = 0; n10 < n11; ++n10) {
            int n12;
            int n13;
            Drawable drawable2 = drawableArray[n10];
            int n14 = drawable2.getIntrinsicWidth();
            if (n14 > (n13 = this.mConstantWidth)) {
                this.mConstantWidth = n14;
            }
            if ((n14 = drawable2.getIntrinsicHeight()) > (n13 = this.mConstantHeight)) {
                this.mConstantHeight = n14;
            }
            if ((n14 = drawable2.getMinimumWidth()) > (n13 = this.mConstantMinimumWidth)) {
                this.mConstantMinimumWidth = n14;
            }
            if ((n12 = drawable2.getMinimumHeight()) <= (n14 = this.mConstantMinimumHeight)) continue;
            this.mConstantMinimumHeight = n12;
        }
    }

    public final int getCapacity() {
        return this.mDrawables.length;
    }

    public int getChangingConfigurations() {
        int n10 = this.mChangingConfigurations;
        int n11 = this.mChildrenChangingConfigurations;
        return n10 | n11;
    }

    public final Drawable getChild(int n10) {
        int n11;
        Drawable drawable2 = this.mDrawables[n10];
        if (drawable2 != null) {
            return drawable2;
        }
        drawable2 = this.mDrawableFutures;
        if (drawable2 != null && (n11 = drawable2.indexOfKey(n10)) >= 0) {
            Drawable.ConstantState constantState = (Drawable.ConstantState)this.mDrawableFutures.valueAt(n11);
            Drawable[] drawableArray = this.mSourceRes;
            constantState = constantState.newDrawable((Resources)drawableArray);
            constantState = this.prepareDrawable((Drawable)constantState);
            drawableArray = this.mDrawables;
            drawableArray[n10] = constantState;
            this.mDrawableFutures.removeAt(n11);
            SparseArray sparseArray = this.mDrawableFutures;
            n10 = sparseArray.size();
            if (n10 == 0) {
                this.mDrawableFutures = null;
            }
            return constantState;
        }
        return null;
    }

    public final int getChildCount() {
        return this.mNumChildren;
    }

    public final int getConstantHeight() {
        boolean bl2 = this.mCheckedConstantSize;
        if (!bl2) {
            this.computeConstantSize();
        }
        return this.mConstantHeight;
    }

    public final int getConstantMinimumHeight() {
        boolean bl2 = this.mCheckedConstantSize;
        if (!bl2) {
            this.computeConstantSize();
        }
        return this.mConstantMinimumHeight;
    }

    public final int getConstantMinimumWidth() {
        boolean bl2 = this.mCheckedConstantSize;
        if (!bl2) {
            this.computeConstantSize();
        }
        return this.mConstantMinimumWidth;
    }

    public final Rect getConstantPadding() {
        int n10;
        boolean bl2 = this.mVariablePadding;
        Rect rect = null;
        if (bl2) {
            return null;
        }
        Rect rect2 = this.mConstantPadding;
        if (rect2 == null && (n10 = this.mCheckedPadding) == 0) {
            this.createAllFutures();
            rect2 = new Rect();
            n10 = this.mNumChildren;
            Drawable[] drawableArray = this.mDrawables;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                Drawable drawable2 = drawableArray[i10];
                int n12 = drawable2.getPadding(rect2);
                if (n12 == 0) continue;
                if (rect == null) {
                    rect = new Rect(0, 0, 0, 0);
                }
                if ((n12 = rect2.left) > (n11 = rect.left)) {
                    rect.left = n12;
                }
                if ((n12 = rect2.top) > (n11 = rect.top)) {
                    rect.top = n12;
                }
                if ((n12 = rect2.right) > (n11 = rect.right)) {
                    rect.right = n12;
                }
                if ((n12 = rect2.bottom) <= (n11 = rect.bottom)) continue;
                rect.bottom = n12;
            }
            this.mCheckedPadding = true;
            this.mConstantPadding = rect;
            return rect;
        }
        return rect2;
    }

    public final int getConstantWidth() {
        boolean bl2 = this.mCheckedConstantSize;
        if (!bl2) {
            this.computeConstantSize();
        }
        return this.mConstantWidth;
    }

    public final int getEnterFadeDuration() {
        return this.mEnterFadeDuration;
    }

    public final int getExitFadeDuration() {
        return this.mExitFadeDuration;
    }

    public final int getOpacity() {
        int n10;
        int n11;
        int n12 = this.mCheckedOpacity;
        if (n12 != 0) {
            return this.mOpacity;
        }
        this.createAllFutures();
        n12 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        if (n12 > 0) {
            Drawable drawable2 = drawableArray[0];
            n11 = drawable2.getOpacity();
        } else {
            n11 = -2;
        }
        for (int i10 = n10 = 1; i10 < n12; ++i10) {
            Drawable drawable3 = drawableArray[i10];
            int n13 = drawable3.getOpacity();
            n11 = Drawable.resolveOpacity((int)n11, (int)n13);
        }
        this.mOpacity = n11;
        this.mCheckedOpacity = n10;
        return n11;
    }

    public void growArray(int n10, int n11) {
        Drawable[] drawableArray = new Drawable[n11];
        Drawable[] drawableArray2 = this.mDrawables;
        if (drawableArray2 != null) {
            System.arraycopy(drawableArray2, 0, drawableArray, 0, n10);
        }
        this.mDrawables = drawableArray;
    }

    public void invalidateCache() {
        this.mCheckedOpacity = false;
        this.mCheckedStateful = false;
    }

    public final boolean isConstantSize() {
        return this.mConstantSize;
    }

    public final boolean isStateful() {
        boolean bl2;
        int n10 = this.mCheckedStateful;
        if (n10 != 0) {
            return this.mStateful;
        }
        this.createAllFutures();
        n10 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        boolean bl3 = false;
        int n11 = 0;
        while (true) {
            bl2 = true;
            if (n11 >= n10) break;
            Drawable drawable2 = drawableArray[n11];
            boolean bl4 = drawable2.isStateful();
            if (bl4) {
                bl3 = bl2;
                break;
            }
            ++n11;
        }
        this.mStateful = bl3;
        this.mCheckedStateful = bl2;
        return bl3;
    }

    public void mutate() {
        int n10 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        for (int i10 = 0; i10 < n10; ++i10) {
            Drawable drawable2 = drawableArray[i10];
            if (drawable2 == null) continue;
            drawable2 = drawableArray[i10];
            drawable2.mutate();
        }
        this.mMutated = true;
    }

    public final void setConstantSize(boolean bl2) {
        this.mConstantSize = bl2;
    }

    public final void setEnterFadeDuration(int n10) {
        this.mEnterFadeDuration = n10;
    }

    public final void setExitFadeDuration(int n10) {
        this.mExitFadeDuration = n10;
    }

    public final boolean setLayoutDirection(int n10, int n11) {
        int n12 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            Drawable drawable2 = drawableArray[i10];
            if (drawable2 == null) continue;
            int n14 = Build.VERSION.SDK_INT;
            int n15 = 23;
            if (n14 >= n15) {
                drawable2 = drawableArray[i10];
                n14 = DrawableCompat.setLayoutDirection(drawable2, n10) ? 1 : 0;
            } else {
                n14 = 0;
                drawable2 = null;
            }
            if (i10 != n11) continue;
            n13 = n14;
        }
        this.mLayoutDirection = n10;
        return n13 != 0;
    }

    public final void setVariablePadding(boolean bl2) {
        this.mVariablePadding = bl2;
    }

    public final void updateDensity(Resources resources) {
        if (resources != null) {
            this.mSourceRes = resources;
            int n10 = this.mDensity;
            int n11 = DrawableContainer.resolveDensity(resources, n10);
            n10 = this.mDensity;
            this.mDensity = n11;
            if (n10 != n11) {
                n11 = 0;
                resources = null;
                this.mCheckedConstantSize = false;
                this.mCheckedPadding = false;
            }
        }
    }
}

