/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ImageView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable2) {
        boolean bl2;
        TintInfo tintInfo = this.mTmpInfo;
        if (tintInfo == null) {
            this.mTmpInfo = tintInfo = new TintInfo();
        }
        tintInfo = this.mTmpInfo;
        tintInfo.clear();
        Object object = ImageViewCompat.getImageTintList(this.mView);
        boolean bl3 = true;
        if (object != null) {
            tintInfo.mHasTintList = bl3;
            tintInfo.mTintList = object;
        }
        if ((object = ImageViewCompat.getImageTintMode(this.mView)) != null) {
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
            TintInfo tintInfo = this.mInternalImageTint;
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

    public void applySupportImageTint() {
        Drawable drawable2 = this.mView.getDrawable();
        if (drawable2 != null) {
            DrawableUtils.fixDrawable(drawable2);
        }
        if (drawable2 != null) {
            boolean bl2 = this.shouldApplyFrameworkTintUsingColorFilter();
            if (bl2 && (bl2 = this.applyFrameworkTintUsingColorFilter(drawable2))) {
                return;
            }
            TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                int[] nArray = this.mView.getDrawableState();
                AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, nArray);
            } else {
                tintInfo = this.mInternalImageTint;
                if (tintInfo != null) {
                    int[] nArray = this.mView.getDrawableState();
                    AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, nArray);
                }
            }
        }
    }

    public ColorStateList getSupportImageTintList() {
        TintInfo tintInfo = this.mImageTint;
        tintInfo = tintInfo != null ? tintInfo.mTintList : null;
        return tintInfo;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        TintInfo tintInfo = this.mImageTint;
        tintInfo = tintInfo != null ? tintInfo.mTintMode : null;
        return tintInfo;
    }

    public boolean hasOverlappingRendering() {
        boolean bl2;
        Drawable drawable2 = this.mView.getBackground();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        return n10 < n11 || !(bl2 = drawable2 instanceof RippleDrawable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadFromAttributes(AttributeSet attributeSet, int n10) {
        Object object = this.mView.getContext();
        int[] nArray = R$styleable.AppCompatImageView;
        int n11 = 0;
        object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray, n10, 0);
        ImageView imageView = this.mView;
        Context context = imageView.getContext();
        TypedArray typedArray = ((TintTypedArray)object).getWrappedTypeArray();
        ViewCompat.saveAttributeDataForStyleable((View)imageView, context, nArray, attributeSet, typedArray, n10, 0);
        try {
            int n12;
            attributeSet = this.mView;
            attributeSet = attributeSet.getDrawable();
            n10 = -1;
            if (attributeSet == null) {
                n11 = R$styleable.AppCompatImageView_srcCompat;
                if ((n11 = ((TintTypedArray)object).getResourceId(n11, n10)) != n10) {
                    attributeSet = this.mView;
                    attributeSet = attributeSet.getContext();
                    if ((attributeSet = AppCompatResources.getDrawable((Context)attributeSet, n11)) != null) {
                        imageView = this.mView;
                        imageView.setImageDrawable((Drawable)attributeSet);
                    }
                }
            }
            if (attributeSet != null) {
                DrawableUtils.fixDrawable((Drawable)attributeSet);
            }
            if ((n11 = (int)(((TintTypedArray)object).hasValue(n12 = R$styleable.AppCompatImageView_tint) ? 1 : 0)) != 0) {
                imageView = this.mView;
                attributeSet = ((TintTypedArray)object).getColorStateList(n12);
                ImageViewCompat.setImageTintList(imageView, (ColorStateList)attributeSet);
            }
            if ((n11 = (int)(((TintTypedArray)object).hasValue(n12 = R$styleable.AppCompatImageView_tintMode) ? 1 : 0)) == 0) return;
            imageView = this.mView;
            n12 = ((TintTypedArray)object).getInt(n12, n10);
            n10 = 0;
            attributeSet = DrawableUtils.parseTintMode(n12, null);
            ImageViewCompat.setImageTintMode(imageView, (PorterDuff.Mode)attributeSet);
            return;
        }
        finally {
            ((TintTypedArray)object).recycle();
        }
    }

    public void setImageResource(int n10) {
        if (n10 != 0) {
            Context context = this.mView.getContext();
            Drawable drawable2 = AppCompatResources.getDrawable(context, n10);
            if (drawable2 != null) {
                DrawableUtils.fixDrawable(drawable2);
            }
            context = this.mView;
            context.setImageDrawable(drawable2);
        } else {
            ImageView imageView = this.mView;
            Object var2_3 = null;
            imageView.setImageDrawable(null);
        }
        this.applySupportImageTint();
    }

    public void setInternalImageTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            boolean bl2;
            TintInfo tintInfo = this.mInternalImageTint;
            if (tintInfo == null) {
                this.mInternalImageTint = tintInfo = new TintInfo();
            }
            tintInfo = this.mInternalImageTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = bl2 = true;
        } else {
            boolean bl3 = false;
            colorStateList = null;
            this.mInternalImageTint = null;
        }
        this.applySupportImageTint();
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo == null) {
            this.mImageTint = tintInfo = new TintInfo();
        }
        tintInfo = this.mImageTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        this.applySupportImageTint();
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        TintInfo tintInfo = this.mImageTint;
        if (tintInfo == null) {
            this.mImageTint = tintInfo = new TintInfo();
        }
        tintInfo = this.mImageTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        this.applySupportImageTint();
    }
}

