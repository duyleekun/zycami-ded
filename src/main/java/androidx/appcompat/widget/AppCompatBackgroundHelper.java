/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

public class AppCompatBackgroundHelper {
    private int mBackgroundResId = -1;
    private TintInfo mBackgroundTint;
    private final AppCompatDrawableManager mDrawableManager;
    private TintInfo mInternalBackgroundTint;
    private TintInfo mTmpInfo;
    private final View mView;

    public AppCompatBackgroundHelper(View object) {
        this.mView = object;
        object = AppCompatDrawableManager.get();
        this.mDrawableManager = object;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable2) {
        boolean bl2;
        TintInfo tintInfo = this.mTmpInfo;
        if (tintInfo == null) {
            this.mTmpInfo = tintInfo = new TintInfo();
        }
        tintInfo = this.mTmpInfo;
        tintInfo.clear();
        Object object = ViewCompat.getBackgroundTintList(this.mView);
        boolean bl3 = true;
        if (object != null) {
            tintInfo.mHasTintList = bl3;
            tintInfo.mTintList = object;
        }
        if ((object = ViewCompat.getBackgroundTintMode(this.mView)) != null) {
            tintInfo.mHasTintMode = bl3;
            tintInfo.mTintMode = object;
        }
        if (!(bl2 = tintInfo.mHasTintList) && !(bl2 = tintInfo.mHasTintMode)) {
            return false;
        }
        object = this.mView.getDrawableState();
        AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, (int[])object);
        return bl3;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 21;
        if (n10 > n11) {
            TintInfo tintInfo = this.mInternalBackgroundTint;
            if (tintInfo == null) {
                bl2 = false;
            }
            return bl2;
        }
        if (n10 == n11) {
            return bl2;
        }
        return false;
    }

    public void applySupportBackgroundTint() {
        Drawable drawable2 = this.mView.getBackground();
        if (drawable2 != null) {
            boolean bl2 = this.shouldApplyFrameworkTintUsingColorFilter();
            if (bl2 && (bl2 = this.applyFrameworkTintUsingColorFilter(drawable2))) {
                return;
            }
            TintInfo tintInfo = this.mBackgroundTint;
            if (tintInfo != null) {
                int[] nArray = this.mView.getDrawableState();
                AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, nArray);
            } else {
                tintInfo = this.mInternalBackgroundTint;
                if (tintInfo != null) {
                    int[] nArray = this.mView.getDrawableState();
                    AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, nArray);
                }
            }
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo = tintInfo != null ? tintInfo.mTintList : null;
        return tintInfo;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        TintInfo tintInfo = this.mBackgroundTint;
        tintInfo = tintInfo != null ? tintInfo.mTintMode : null;
        return tintInfo;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadFromAttributes(AttributeSet object, int n10) {
        Object object2 = this.mView.getContext();
        int[] nArray = R$styleable.ViewBackgroundHelper;
        int n11 = 0;
        object2 = TintTypedArray.obtainStyledAttributes((Context)object2, (AttributeSet)object, nArray, n10, 0);
        View view = this.mView;
        Context context = view.getContext();
        TypedArray typedArray = ((TintTypedArray)object2).getWrappedTypeArray();
        ViewCompat.saveAttributeDataForStyleable(view, context, nArray, (AttributeSet)object, typedArray, n10, 0);
        try {
            View view2;
            int n12 = R$styleable.ViewBackgroundHelper_android_background;
            n10 = ((TintTypedArray)object2).hasValue(n12) ? 1 : 0;
            n11 = -1;
            if (n10 != 0) {
                int n13;
                this.mBackgroundResId = n12 = ((TintTypedArray)object2).getResourceId(n12, n11);
                object = this.mDrawableManager;
                view2 = this.mView;
                if ((object = ((AppCompatDrawableManager)object).getTintList((Context)(view2 = view2.getContext()), n13 = this.mBackgroundResId)) != null) {
                    this.setInternalBackgroundTint((ColorStateList)object);
                }
            }
            if ((n10 = (int)(((TintTypedArray)object2).hasValue(n12 = R$styleable.ViewBackgroundHelper_backgroundTint) ? 1 : 0)) != 0) {
                view2 = this.mView;
                object = ((TintTypedArray)object2).getColorStateList(n12);
                ViewCompat.setBackgroundTintList(view2, (ColorStateList)object);
            }
            if ((n10 = (int)(((TintTypedArray)object2).hasValue(n12 = R$styleable.ViewBackgroundHelper_backgroundTintMode) ? 1 : 0)) == 0) return;
            view2 = this.mView;
            n12 = ((TintTypedArray)object2).getInt(n12, n11);
            n11 = 0;
            view = null;
            object = DrawableUtils.parseTintMode(n12, null);
            ViewCompat.setBackgroundTintMode(view2, (PorterDuff.Mode)object);
            return;
        }
        finally {
            ((TintTypedArray)object2).recycle();
        }
    }

    public void onSetBackgroundDrawable(Drawable drawable2) {
        this.mBackgroundResId = -1;
        this.setInternalBackgroundTint(null);
        this.applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int n10) {
        ColorStateList colorStateList;
        this.mBackgroundResId = n10;
        AppCompatDrawableManager appCompatDrawableManager = this.mDrawableManager;
        if (appCompatDrawableManager != null) {
            Context context = this.mView.getContext();
            colorStateList = appCompatDrawableManager.getTintList(context, n10);
        } else {
            n10 = 0;
            colorStateList = null;
        }
        this.setInternalBackgroundTint(colorStateList);
        this.applySupportBackgroundTint();
    }

    public void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            boolean bl2;
            TintInfo tintInfo = this.mInternalBackgroundTint;
            if (tintInfo == null) {
                this.mInternalBackgroundTint = tintInfo = new TintInfo();
            }
            tintInfo = this.mInternalBackgroundTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = bl2 = true;
        } else {
            boolean bl3 = false;
            colorStateList = null;
            this.mInternalBackgroundTint = null;
        }
        this.applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo == null) {
            this.mBackgroundTint = tintInfo = new TintInfo();
        }
        tintInfo = this.mBackgroundTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        this.applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mBackgroundTint;
        if (tintInfo == null) {
            this.mBackgroundTint = tintInfo = new TintInfo();
        }
        tintInfo = this.mBackgroundTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        this.applySupportBackgroundTint();
    }
}

