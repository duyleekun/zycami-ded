/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ImageButton
 *  android.widget.ImageView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableImageSourceView;

public class AppCompatImageButton
extends ImageButton
implements TintableBackgroundView,
TintableImageSourceView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatImageHelper mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.imageButtonStyle;
        this(context, attributeSet, n10);
    }

    public AppCompatImageButton(Context object, AttributeSet attributeSet, int n10) {
        object = TintContextWrapper.wrap((Context)object);
        super((Context)object, attributeSet, n10);
        object = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object);
        super((View)this);
        this.mBackgroundTintHelper = object;
        ((AppCompatBackgroundHelper)object).loadFromAttributes(attributeSet, n10);
        this.mImageHelper = object = new AppCompatImageHelper((ImageView)this);
        ((AppCompatImageHelper)object).loadFromAttributes(attributeSet, n10);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Object object = this.mBackgroundTintHelper;
        if (object != null) {
            ((AppCompatBackgroundHelper)object).applySupportBackgroundTint();
        }
        if ((object = this.mImageHelper) != null) {
            ((AppCompatImageHelper)object).applySupportImageTint();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        appCompatBackgroundHelper = appCompatBackgroundHelper != null ? appCompatBackgroundHelper.getSupportBackgroundTintList() : null;
        return appCompatBackgroundHelper;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        appCompatBackgroundHelper = appCompatBackgroundHelper != null ? appCompatBackgroundHelper.getSupportBackgroundTintMode() : null;
        return appCompatBackgroundHelper;
    }

    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        appCompatImageHelper = appCompatImageHelper != null ? appCompatImageHelper.getSupportImageTintList() : null;
        return appCompatImageHelper;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        appCompatImageHelper = appCompatImageHelper != null ? appCompatImageHelper.getSupportImageTintMode() : null;
        return appCompatImageHelper;
    }

    public boolean hasOverlappingRendering() {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        boolean bl2 = appCompatImageHelper.hasOverlappingRendering();
        if (bl2 && (bl2 = super.hasOverlappingRendering())) {
            bl2 = true;
        } else {
            bl2 = false;
            appCompatImageHelper = null;
        }
        return bl2;
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable(drawable2);
        }
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(n10);
        }
    }

    public void setImageBitmap(Bitmap object) {
        super.setImageBitmap((Bitmap)object);
        object = this.mImageHelper;
        if (object != null) {
            ((AppCompatImageHelper)object).applySupportImageTint();
        }
    }

    public void setImageDrawable(Drawable object) {
        super.setImageDrawable((Drawable)object);
        object = this.mImageHelper;
        if (object != null) {
            ((AppCompatImageHelper)object).applySupportImageTint();
        }
    }

    public void setImageResource(int n10) {
        this.mImageHelper.setImageResource(n10);
    }

    public void setImageURI(Uri object) {
        super.setImageURI((Uri)object);
        object = this.mImageHelper;
        if (object != null) {
            ((AppCompatImageHelper)object).applySupportImageTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.setSupportImageTintList(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.mImageHelper;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.setSupportImageTintMode(mode);
        }
    }
}

