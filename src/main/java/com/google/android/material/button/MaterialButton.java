/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.widget.TextView
 */
package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButtonHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

public class MaterialButton
extends AppCompatButton {
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    private static final String LOG_TAG = "MaterialButton";
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private final MaterialButtonHelper materialButtonHelper;

    public MaterialButton(Context context) {
        this(context, null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.materialButtonStyle;
        this(context, attributeSet, n10);
    }

    public MaterialButton(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        int[] nArray = R$styleable.MaterialButton;
        int n11 = R$style.Widget_MaterialComponents_Button;
        int[] nArray2 = new int[]{};
        context = ThemeEnforcement.obtainStyledAttributes(context, (AttributeSet)object, nArray, n10, n11, nArray2);
        int n12 = R$styleable.MaterialButton_iconPadding;
        this.iconPadding = n12 = context.getDimensionPixelSize(n12, 0);
        n12 = R$styleable.MaterialButton_iconTintMode;
        n12 = context.getInt(n12, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        object = ViewUtils.parseTintMode(n12, mode);
        this.iconTintMode = object;
        object = this.getContext();
        n10 = R$styleable.MaterialButton_iconTint;
        object = MaterialResources.getColorStateList((Context)object, (TypedArray)context, n10);
        this.iconTint = object;
        object = this.getContext();
        n10 = R$styleable.MaterialButton_icon;
        object = MaterialResources.getDrawable((Context)object, (TypedArray)context, n10);
        this.icon = object;
        n12 = R$styleable.MaterialButton_iconGravity;
        this.iconGravity = n12 = context.getInteger(n12, 1);
        n12 = R$styleable.MaterialButton_iconSize;
        this.iconSize = n12 = context.getDimensionPixelSize(n12, 0);
        super(this);
        this.materialButtonHelper = object;
        ((MaterialButtonHelper)object).loadFromAttributes((TypedArray)context);
        context.recycle();
        int n13 = this.iconPadding;
        this.setCompoundDrawablePadding(n13);
        this.updateIcon();
    }

    private boolean isLayoutRTL() {
        int n10;
        int n11 = ViewCompat.getLayoutDirection((View)this);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private boolean isUsingOriginalBackground() {
        boolean bl2;
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        if (materialButtonHelper != null && !(bl2 = materialButtonHelper.isBackgroundOverwritten())) {
            bl2 = true;
        } else {
            bl2 = false;
            materialButtonHelper = null;
        }
        return bl2;
    }

    private void updateIcon() {
        Drawable drawable2 = this.icon;
        if (drawable2 != null) {
            int n10;
            this.icon = drawable2 = drawable2.mutate();
            ColorStateList colorStateList = this.iconTint;
            DrawableCompat.setTintList(drawable2, colorStateList);
            drawable2 = this.iconTintMode;
            if (drawable2 != null) {
                colorStateList = this.icon;
                DrawableCompat.setTintMode((Drawable)colorStateList, (PorterDuff.Mode)drawable2);
            }
            if ((n10 = this.iconSize) == 0) {
                drawable2 = this.icon;
                n10 = drawable2.getIntrinsicWidth();
            }
            int n11 = this.iconSize;
            if (n11 == 0) {
                colorStateList = this.icon;
                n11 = colorStateList.getIntrinsicHeight();
            }
            Drawable drawable3 = this.icon;
            int n12 = this.iconLeft;
            drawable3.setBounds(n12, 0, n10 += n12, n11);
        }
        drawable2 = this.icon;
        TextViewCompat.setCompoundDrawablesRelative((TextView)this, drawable2, null, null, null);
    }

    public ColorStateList getBackgroundTintList() {
        return this.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        int n10 = this.isUsingOriginalBackground();
        if (n10 != 0) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            n10 = materialButtonHelper.getCornerRadius();
        } else {
            n10 = 0;
            Object var2_3 = null;
        }
        return n10;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public ColorStateList getRippleColor() {
        ColorStateList colorStateList;
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            colorStateList = this.materialButtonHelper.getRippleColor();
        } else {
            bl2 = false;
            colorStateList = null;
        }
        return colorStateList;
    }

    public ColorStateList getStrokeColor() {
        ColorStateList colorStateList;
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            colorStateList = this.materialButtonHelper.getStrokeColor();
        } else {
            bl2 = false;
            colorStateList = null;
        }
        return colorStateList;
    }

    public int getStrokeWidth() {
        int n10 = this.isUsingOriginalBackground();
        if (n10 != 0) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            n10 = materialButtonHelper.getStrokeWidth();
        } else {
            n10 = 0;
            Object var2_3 = null;
        }
        return n10;
    }

    public ColorStateList getSupportBackgroundTintList() {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            return this.materialButtonHelper.getSupportBackgroundTintList();
        }
        return super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            return this.materialButtonHelper.getSupportBackgroundTintMode();
        }
        return super.getSupportBackgroundTintMode();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11 && (n10 = (int)(this.isUsingOriginalBackground() ? 1 : 0)) != 0) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.drawStroke(canvas);
        }
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        MaterialButtonHelper materialButtonHelper;
        super.onLayout(n10 != 0, n11, n12, n13, n14);
        n10 = Build.VERSION.SDK_INT;
        int n15 = 21;
        if (n10 == n15 && (materialButtonHelper = this.materialButtonHelper) != null) {
            materialButtonHelper.updateMaskBounds(n14 -= n12, n13 -= n11);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        Drawable drawable2 = this.icon;
        if (drawable2 != null && (n10 = this.iconGravity) == (n11 = 2)) {
            drawable2 = this.getPaint();
            String string2 = this.getText().toString();
            float f10 = drawable2.measureText(string2);
            n10 = (int)f10;
            int n12 = this.iconSize;
            if (n12 == 0) {
                string2 = this.icon;
                n12 = string2.getIntrinsicWidth();
            }
            int n13 = this.getMeasuredWidth() - n10;
            n10 = ViewCompat.getPaddingEnd((View)this);
            n13 = n13 - n10 - n12;
            n10 = this.iconPadding;
            n13 -= n10;
            n10 = ViewCompat.getPaddingStart((View)this);
            n13 = (n13 - n10) / n11;
            n10 = (int)(this.isLayoutRTL() ? 1 : 0);
            if (n10 != 0) {
                n13 = -n13;
            }
            if ((n10 = this.iconLeft) != n13) {
                this.iconLeft = n13;
                this.updateIcon();
            }
        }
    }

    public void setBackground(Drawable drawable2) {
        this.setBackgroundDrawable(drawable2);
    }

    public void setBackgroundColor(int n10) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.setBackgroundColor(n10);
        } else {
            super.setBackgroundColor(n10);
        }
    }

    public void setBackgroundDrawable(Drawable object) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            Object object2 = this.getBackground();
            if (object != object2) {
                String string2 = "Setting a custom background is not supported.";
                Log.i((String)LOG_TAG, (String)string2);
                object2 = this.materialButtonHelper;
                ((MaterialButtonHelper)object2).setBackgroundOverwritten();
                super.setBackgroundDrawable((Drawable)object);
            } else {
                object2 = this.getBackground();
                object = object.getState();
                object2.setState((int[])object);
            }
        } else {
            super.setBackgroundDrawable((Drawable)object);
        }
    }

    public void setBackgroundResource(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setBackgroundDrawable(drawable2);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.setSupportBackgroundTintMode(mode);
    }

    public void setCornerRadius(int n10) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.setCornerRadius(n10);
        }
    }

    public void setCornerRadiusResource(int n10) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            Resources resources = this.getResources();
            n10 = resources.getDimensionPixelSize(n10);
            this.setCornerRadius(n10);
        }
    }

    public void setIcon(Drawable drawable2) {
        Drawable drawable3 = this.icon;
        if (drawable3 != drawable2) {
            this.icon = drawable2;
            this.updateIcon();
        }
    }

    public void setIconGravity(int n10) {
        this.iconGravity = n10;
    }

    public void setIconPadding(int n10) {
        int n11 = this.iconPadding;
        if (n11 != n10) {
            this.iconPadding = n10;
            this.setCompoundDrawablePadding(n10);
        }
    }

    public void setIconResource(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setIcon(drawable2);
    }

    public void setIconSize(int n10) {
        if (n10 >= 0) {
            int n11 = this.iconSize;
            if (n11 != n10) {
                this.iconSize = n10;
                this.updateIcon();
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("iconSize cannot be less than 0");
        throw illegalArgumentException;
    }

    public void setIconTint(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.iconTint;
        if (colorStateList2 != colorStateList) {
            this.iconTint = colorStateList;
            this.updateIcon();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2 = this.iconTintMode;
        if (mode2 != mode) {
            this.iconTintMode = mode;
            this.updateIcon();
        }
    }

    public void setIconTintResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.getContext(), n10);
        this.setIconTint(colorStateList);
    }

    public void setInternalBackground(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(int n10) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            Context context = this.getContext();
            ColorStateList colorStateList = AppCompatResources.getColorStateList(context, n10);
            this.setRippleColor(colorStateList);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeColorResource(int n10) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            Context context = this.getContext();
            ColorStateList colorStateList = AppCompatResources.getColorStateList(context, n10);
            this.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeWidth(int n10) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.setStrokeWidth(n10);
        }
    }

    public void setStrokeWidthResource(int n10) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            Resources resources = this.getResources();
            n10 = resources.getDimensionPixelSize(n10);
            this.setStrokeWidth(n10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.setSupportBackgroundTintList(colorStateList);
        } else {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper != null) {
                super.setSupportBackgroundTintList(colorStateList);
            }
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        boolean bl2 = this.isUsingOriginalBackground();
        if (bl2) {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            materialButtonHelper.setSupportBackgroundTintMode(mode);
        } else {
            MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
            if (materialButtonHelper != null) {
                super.setSupportBackgroundTintMode(mode);
            }
        }
    }
}

