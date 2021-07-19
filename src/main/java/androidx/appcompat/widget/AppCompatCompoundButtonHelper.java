/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CompoundButton
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

public class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;
    private final CompoundButton mView;

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    public void applyButtonTint() {
        boolean bl2;
        Drawable drawable2 = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (drawable2 != null && ((bl2 = this.mHasButtonTint) || (bl2 = this.mHasButtonTintMode))) {
            Object object;
            drawable2 = DrawableCompat.wrap(drawable2).mutate();
            bl2 = this.mHasButtonTint;
            if (bl2) {
                object = this.mButtonTintList;
                DrawableCompat.setTintList(drawable2, object);
            }
            if (bl2 = this.mHasButtonTintMode) {
                object = this.mButtonTintMode;
                DrawableCompat.setTintMode(drawable2, (PorterDuff.Mode)object);
            }
            if (bl2 = drawable2.isStateful()) {
                object = this.mView.getDrawableState();
                drawable2.setState((int[])object);
            }
            object = this.mView;
            object.setButtonDrawable(drawable2);
        }
    }

    public int getCompoundPaddingLeft(int n10) {
        Drawable drawable2;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 < n12 && (drawable2 = CompoundButtonCompat.getButtonDrawable(this.mView)) != null) {
            n11 = drawable2.getIntrinsicWidth();
            n10 += n11;
        }
        return n10;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadFromAttributes(AttributeSet attributeSet, int n10) {
        CompoundButton compoundButton;
        int n11;
        CompoundButton compoundButton2;
        Object object;
        block9: {
            object = this.mView.getContext();
            int[] nArray = R$styleable.CompoundButton;
            object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray, n10, 0);
            compoundButton2 = this.mView;
            Context context = compoundButton2.getContext();
            TypedArray typedArray = ((TintTypedArray)object).getWrappedTypeArray();
            ViewCompat.saveAttributeDataForStyleable((View)compoundButton2, context, nArray, attributeSet, typedArray, n10, 0);
            n11 = R$styleable.CompoundButton_buttonCompat;
            n10 = ((TintTypedArray)object).hasValue(n11) ? 1 : 0;
            if (n10 != 0 && (n11 = ((TintTypedArray)object).getResourceId(n11, 0)) != 0) {
                try {
                    compoundButton = this.mView;
                    compoundButton2 = compoundButton.getContext();
                    attributeSet = AppCompatResources.getDrawable((Context)compoundButton2, n11);
                    compoundButton.setButtonDrawable((Drawable)attributeSet);
                    n11 = 1;
                    break block9;
                }
                catch (Resources.NotFoundException notFoundException) {}
            }
            n11 = 0;
            attributeSet = null;
        }
        if (n11 == 0 && (n10 = (int)(((TintTypedArray)object).hasValue(n11 = R$styleable.CompoundButton_android_button) ? 1 : 0)) != 0 && (n11 = ((TintTypedArray)object).getResourceId(n11, 0)) != 0) {
            compoundButton = this.mView;
            compoundButton2 = compoundButton.getContext();
            attributeSet = AppCompatResources.getDrawable((Context)compoundButton2, n11);
            compoundButton.setButtonDrawable((Drawable)attributeSet);
        }
        if ((n10 = (int)(((TintTypedArray)object).hasValue(n11 = R$styleable.CompoundButton_buttonTint) ? 1 : 0)) != 0) {
            compoundButton = this.mView;
            attributeSet = ((TintTypedArray)object).getColorStateList(n11);
            CompoundButtonCompat.setButtonTintList(compoundButton, (ColorStateList)attributeSet);
        }
        if ((n10 = (int)(((TintTypedArray)object).hasValue(n11 = R$styleable.CompoundButton_buttonTintMode) ? 1 : 0)) == 0) return;
        compoundButton = this.mView;
        int n12 = -1;
        n11 = ((TintTypedArray)object).getInt(n11, n12);
        n12 = 0;
        compoundButton2 = null;
        attributeSet = DrawableUtils.parseTintMode(n11, null);
        CompoundButtonCompat.setButtonTintMode(compoundButton, (PorterDuff.Mode)attributeSet);
        return;
    }

    public void onSetButtonDrawable() {
        boolean bl2 = this.mSkipNextApply;
        if (bl2) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        this.applyButtonTint();
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        this.applyButtonTint();
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        this.applyButtonTint();
    }
}

