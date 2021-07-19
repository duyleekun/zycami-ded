/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.view.View
 */
package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonBackgroundDrawable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

public class MaterialButtonHelper {
    private static final float CORNER_RADIUS_ADJUSTMENT = 1.0E-5f;
    private static final int DEFAULT_BACKGROUND_COLOR = 255;
    private static final boolean IS_LOLLIPOP;
    private GradientDrawable backgroundDrawableLollipop;
    private boolean backgroundOverwritten;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private final Rect bounds;
    private final Paint buttonStrokePaint;
    private GradientDrawable colorableBackgroundDrawableCompat;
    private int cornerRadius;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private GradientDrawable maskDrawableLollipop;
    private final MaterialButton materialButton;
    private final RectF rectF;
    private ColorStateList rippleColor;
    private GradientDrawable rippleDrawableCompat;
    private ColorStateList strokeColor;
    private GradientDrawable strokeDrawableLollipop;
    private int strokeWidth;
    private Drawable tintableBackgroundDrawableCompat;
    private Drawable tintableRippleDrawableCompat;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        n10 = n10 >= n11 ? 1 : 0;
        IS_LOLLIPOP = n10;
    }

    public MaterialButtonHelper(MaterialButton materialButton) {
        Paint paint;
        this.buttonStrokePaint = paint = new Paint(1);
        this.bounds = paint;
        super();
        this.rectF = paint;
        this.backgroundOverwritten = false;
        this.materialButton = materialButton;
    }

    private Drawable createBackgroundCompat() {
        GradientDrawable gradientDrawable;
        this.colorableBackgroundDrawableCompat = gradientDrawable = new GradientDrawable();
        float f10 = this.cornerRadius;
        float f11 = 1.0E-5f;
        gradientDrawable.setCornerRadius(f10 += f11);
        gradientDrawable = this.colorableBackgroundDrawableCompat;
        int n10 = -1;
        f10 = 0.0f / 0.0f;
        gradientDrawable.setColor(n10);
        gradientDrawable = DrawableCompat.wrap((Drawable)this.colorableBackgroundDrawableCompat);
        this.tintableBackgroundDrawableCompat = gradientDrawable;
        ColorStateList colorStateList = this.backgroundTint;
        DrawableCompat.setTintList((Drawable)gradientDrawable, colorStateList);
        gradientDrawable = this.backgroundTintMode;
        if (gradientDrawable != null) {
            colorStateList = this.tintableBackgroundDrawableCompat;
            DrawableCompat.setTintMode((Drawable)colorStateList, (PorterDuff.Mode)gradientDrawable);
        }
        this.rippleDrawableCompat = gradientDrawable = new GradientDrawable();
        float f12 = (float)this.cornerRadius + f11;
        gradientDrawable.setCornerRadius(f12);
        this.rippleDrawableCompat.setColor(n10);
        gradientDrawable = DrawableCompat.wrap((Drawable)this.rippleDrawableCompat);
        this.tintableRippleDrawableCompat = gradientDrawable;
        Drawable[] drawableArray = this.rippleColor;
        DrawableCompat.setTintList((Drawable)gradientDrawable, (ColorStateList)drawableArray);
        drawableArray = new Drawable[2];
        colorStateList = this.tintableBackgroundDrawableCompat;
        drawableArray[0] = colorStateList;
        colorStateList = this.tintableRippleDrawableCompat;
        drawableArray[1] = colorStateList;
        gradientDrawable = new LayerDrawable(drawableArray);
        return this.wrapDrawableWithInset((Drawable)gradientDrawable);
    }

    private Drawable createBackgroundLollipop() {
        GradientDrawable gradientDrawable;
        this.backgroundDrawableLollipop = gradientDrawable = new GradientDrawable();
        float f10 = this.cornerRadius;
        float f11 = 1.0E-5f;
        gradientDrawable.setCornerRadius(f10 += f11);
        gradientDrawable = this.backgroundDrawableLollipop;
        int n10 = -1;
        gradientDrawable.setColor(n10);
        this.updateTintAndTintModeLollipop();
        this.strokeDrawableLollipop = gradientDrawable = new GradientDrawable();
        float f12 = (float)this.cornerRadius + f11;
        gradientDrawable.setCornerRadius(f12);
        this.strokeDrawableLollipop.setColor(0);
        gradientDrawable = this.strokeDrawableLollipop;
        int n11 = this.strokeWidth;
        ColorStateList colorStateList = this.strokeColor;
        gradientDrawable.setStroke(n11, colorStateList);
        Drawable[] drawableArray = new Drawable[2];
        colorStateList = this.backgroundDrawableLollipop;
        drawableArray[0] = colorStateList;
        GradientDrawable gradientDrawable2 = this.strokeDrawableLollipop;
        drawableArray[1] = gradientDrawable2;
        gradientDrawable = new LayerDrawable(drawableArray);
        gradientDrawable = this.wrapDrawableWithInset((Drawable)gradientDrawable);
        this.maskDrawableLollipop = gradientDrawable2 = new GradientDrawable();
        float f13 = (float)this.cornerRadius + f11;
        gradientDrawable2.setCornerRadius(f13);
        this.maskDrawableLollipop.setColor(n10);
        ColorStateList colorStateList2 = RippleUtils.convertToRippleDrawableColor(this.rippleColor);
        gradientDrawable2 = this.maskDrawableLollipop;
        MaterialButtonBackgroundDrawable materialButtonBackgroundDrawable = new MaterialButtonBackgroundDrawable(colorStateList2, (InsetDrawable)gradientDrawable, (Drawable)gradientDrawable2);
        return materialButtonBackgroundDrawable;
    }

    private GradientDrawable unwrapBackgroundDrawable() {
        Drawable drawable2;
        boolean bl2 = IS_LOLLIPOP;
        if (bl2 && (drawable2 = this.materialButton.getBackground()) != null) {
            return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
        }
        return null;
    }

    private GradientDrawable unwrapStrokeDrawable() {
        Drawable drawable2;
        boolean bl2 = IS_LOLLIPOP;
        if (bl2 && (drawable2 = this.materialButton.getBackground()) != null) {
            return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.materialButton.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
        }
        return null;
    }

    private void updateStroke() {
        GradientDrawable gradientDrawable;
        boolean bl2 = IS_LOLLIPOP;
        if (bl2 && (gradientDrawable = this.strokeDrawableLollipop) != null) {
            MaterialButton materialButton = this.materialButton;
            gradientDrawable = this.createBackgroundLollipop();
            materialButton.setInternalBackground((Drawable)gradientDrawable);
        } else if (!bl2) {
            MaterialButton materialButton = this.materialButton;
            materialButton.invalidate();
        }
    }

    private void updateTintAndTintModeLollipop() {
        GradientDrawable gradientDrawable = this.backgroundDrawableLollipop;
        if (gradientDrawable != null) {
            ColorStateList colorStateList = this.backgroundTint;
            DrawableCompat.setTintList((Drawable)gradientDrawable, colorStateList);
            gradientDrawable = this.backgroundTintMode;
            if (gradientDrawable != null) {
                colorStateList = this.backgroundDrawableLollipop;
                DrawableCompat.setTintMode((Drawable)colorStateList, (PorterDuff.Mode)gradientDrawable);
            }
        }
    }

    private InsetDrawable wrapDrawableWithInset(Drawable drawable2) {
        int n10 = this.insetLeft;
        int n11 = this.insetTop;
        int n12 = this.insetRight;
        int n13 = this.insetBottom;
        InsetDrawable insetDrawable = new InsetDrawable(drawable2, n10, n11, n12, n13);
        return insetDrawable;
    }

    public void drawStroke(Canvas canvas) {
        int n10;
        ColorStateList colorStateList;
        if (canvas != null && (colorStateList = this.strokeColor) != null && (n10 = this.strokeWidth) > 0) {
            colorStateList = this.bounds;
            Rect rect = this.materialButton.getBackground().getBounds();
            colorStateList.set(rect);
            colorStateList = this.rectF;
            rect = this.bounds;
            int n11 = rect.left;
            float f10 = n11;
            int n12 = this.strokeWidth;
            float f11 = n12;
            float f12 = 2.0f;
            f10 += (f11 /= f12);
            f11 = this.insetLeft;
            f10 += f11;
            int n13 = rect.top;
            f11 = n13;
            float f13 = (float)n12 / f12;
            f11 += f13;
            f13 = this.insetTop;
            f11 += f13;
            int n14 = rect.right;
            f13 = n14;
            float f14 = (float)n12 / f12;
            f13 -= f14;
            int n15 = this.insetRight;
            f14 = n15;
            float f15 = rect.bottom;
            float f16 = (float)n12 / f12;
            f15 -= f16;
            n12 = this.insetBottom;
            f16 = n12;
            colorStateList.set(f10, f11, f13 -= f14, f15 -= f16);
            n10 = this.cornerRadius;
            float f17 = n10;
            int n16 = this.strokeWidth;
            f15 = (float)n16 / f12;
            rect = this.rectF;
            Paint paint = this.buttonStrokePaint;
            canvas.drawRoundRect((RectF)rect, f17 -= f15, f17, paint);
        }
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public void loadFromAttributes(TypedArray object) {
        Object object2;
        int n10 = R$styleable.MaterialButton_android_insetLeft;
        int n11 = 0;
        MaterialButton materialButton = null;
        this.insetLeft = n10 = object.getDimensionPixelOffset(n10, 0);
        n10 = R$styleable.MaterialButton_android_insetRight;
        this.insetRight = n10 = object.getDimensionPixelOffset(n10, 0);
        n10 = R$styleable.MaterialButton_android_insetTop;
        this.insetTop = n10 = object.getDimensionPixelOffset(n10, 0);
        n10 = R$styleable.MaterialButton_android_insetBottom;
        this.insetBottom = n10 = object.getDimensionPixelOffset(n10, 0);
        n10 = R$styleable.MaterialButton_cornerRadius;
        this.cornerRadius = n10 = object.getDimensionPixelSize(n10, 0);
        n10 = R$styleable.MaterialButton_strokeWidth;
        this.strokeWidth = n10 = object.getDimensionPixelSize(n10, 0);
        n10 = R$styleable.MaterialButton_backgroundTintMode;
        n10 = object.getInt(n10, -1);
        Object object3 = PorterDuff.Mode.SRC_IN;
        this.backgroundTintMode = object2 = ViewUtils.parseTintMode(n10, object3);
        object2 = this.materialButton.getContext();
        int n12 = R$styleable.MaterialButton_backgroundTint;
        object2 = MaterialResources.getColorStateList((Context)object2, object, n12);
        this.backgroundTint = object2;
        object2 = this.materialButton.getContext();
        n12 = R$styleable.MaterialButton_strokeColor;
        object2 = MaterialResources.getColorStateList((Context)object2, object, n12);
        this.strokeColor = object2;
        object2 = this.materialButton.getContext();
        n12 = R$styleable.MaterialButton_rippleColor;
        object = MaterialResources.getColorStateList((Context)object2, object, n12);
        this.rippleColor = object;
        object = this.buttonStrokePaint;
        object2 = Paint.Style.STROKE;
        object.setStyle((Paint.Style)object2);
        object = this.buttonStrokePaint;
        n10 = this.strokeWidth;
        float f10 = n10;
        object.setStrokeWidth(f10);
        object = this.buttonStrokePaint;
        object2 = this.strokeColor;
        if (object2 != null) {
            object3 = this.materialButton.getDrawableState();
            n11 = object2.getColorForState((int[])object3, 0);
        }
        object.setColor(n11);
        object = this.materialButton;
        int n13 = ViewCompat.getPaddingStart((View)object);
        object2 = this.materialButton;
        n10 = object2.getPaddingTop();
        materialButton = this.materialButton;
        n11 = ViewCompat.getPaddingEnd((View)materialButton);
        object3 = this.materialButton;
        n12 = object3.getPaddingBottom();
        MaterialButton materialButton2 = this.materialButton;
        int n14 = IS_LOLLIPOP;
        Drawable drawable2 = n14 != 0 ? this.createBackgroundLollipop() : this.createBackgroundCompat();
        materialButton2.setInternalBackground(drawable2);
        materialButton2 = this.materialButton;
        n14 = this.insetLeft;
        n13 += n14;
        n14 = this.insetTop;
        n10 += n14;
        n14 = this.insetRight;
        n11 += n14;
        n14 = this.insetBottom;
        ViewCompat.setPaddingRelative((View)materialButton2, n13, n10, n11, n12 += n14);
    }

    public void setBackgroundColor(int n10) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        boolean bl2 = IS_LOLLIPOP;
        if (bl2 && (gradientDrawable2 = this.backgroundDrawableLollipop) != null) {
            gradientDrawable2.setColor(n10);
        } else if (!bl2 && (gradientDrawable = this.colorableBackgroundDrawableCompat) != null) {
            gradientDrawable.setColor(n10);
        }
    }

    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        MaterialButton materialButton = this.materialButton;
        ColorStateList colorStateList = this.backgroundTint;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton = this.materialButton;
        colorStateList = this.backgroundTintMode;
        materialButton.setSupportBackgroundTintMode((PorterDuff.Mode)colorStateList);
    }

    public void setCornerRadius(int n10) {
        int n11 = this.cornerRadius;
        if (n11 != n10) {
            GradientDrawable gradientDrawable;
            GradientDrawable gradientDrawable2;
            this.cornerRadius = n10;
            n11 = (int)(IS_LOLLIPOP ? 1 : 0);
            float f10 = 1.0E-5f;
            if (n11 != 0 && (gradientDrawable2 = this.backgroundDrawableLollipop) != null && (gradientDrawable2 = this.strokeDrawableLollipop) != null && (gradientDrawable2 = this.maskDrawableLollipop) != null) {
                GradientDrawable gradientDrawable3;
                n11 = Build.VERSION.SDK_INT;
                int n12 = 21;
                float f11 = 2.9E-44f;
                if (n11 == n12) {
                    gradientDrawable3 = this.unwrapBackgroundDrawable();
                    f11 = (float)n10 + f10;
                    gradientDrawable3.setCornerRadius(f11);
                    gradientDrawable3 = this.unwrapStrokeDrawable();
                    gradientDrawable3.setCornerRadius(f11);
                }
                gradientDrawable3 = this.backgroundDrawableLollipop;
                float f12 = (float)n10 + f10;
                gradientDrawable3.setCornerRadius(f12);
                this.strokeDrawableLollipop.setCornerRadius(f12);
                gradientDrawable3 = this.maskDrawableLollipop;
                gradientDrawable3.setCornerRadius(f12);
            } else if (n11 == 0 && (gradientDrawable = this.colorableBackgroundDrawableCompat) != null && (gradientDrawable2 = this.rippleDrawableCompat) != null) {
                float f13 = (float)n10 + f10;
                gradientDrawable.setCornerRadius(f13);
                gradientDrawable = this.rippleDrawableCompat;
                gradientDrawable.setCornerRadius(f13);
                MaterialButton materialButton = this.materialButton;
                materialButton.invalidate();
            }
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.rippleColor;
        if (colorStateList2 != colorStateList) {
            Drawable drawable2;
            boolean bl2;
            this.rippleColor = colorStateList;
            boolean bl3 = IS_LOLLIPOP;
            if (bl3 && (bl2 = (drawable2 = this.materialButton.getBackground()) instanceof RippleDrawable)) {
                colorStateList2 = (RippleDrawable)this.materialButton.getBackground();
                colorStateList2.setColor(colorStateList);
            } else if (!bl3 && (colorStateList2 = this.tintableRippleDrawableCompat) != null) {
                DrawableCompat.setTintList((Drawable)colorStateList2, colorStateList);
            }
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.strokeColor;
        if (colorStateList2 != colorStateList) {
            this.strokeColor = colorStateList;
            colorStateList2 = this.buttonStrokePaint;
            int n10 = 0;
            if (colorStateList != null) {
                int[] nArray = this.materialButton.getDrawableState();
                n10 = colorStateList.getColorForState(nArray, 0);
            }
            colorStateList2.setColor(n10);
            this.updateStroke();
        }
    }

    public void setStrokeWidth(int n10) {
        int n11 = this.strokeWidth;
        if (n11 != n10) {
            this.strokeWidth = n10;
            Paint paint = this.buttonStrokePaint;
            float f10 = n10;
            paint.setStrokeWidth(f10);
            this.updateStroke();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.backgroundTint;
        if (colorStateList2 != colorStateList) {
            this.backgroundTint = colorStateList;
            boolean bl2 = IS_LOLLIPOP;
            if (bl2) {
                this.updateTintAndTintModeLollipop();
            } else {
                colorStateList2 = this.tintableBackgroundDrawableCompat;
                if (colorStateList2 != null) {
                    DrawableCompat.setTintList((Drawable)colorStateList2, colorStateList);
                }
            }
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2 = this.backgroundTintMode;
        if (mode2 != mode) {
            this.backgroundTintMode = mode;
            boolean bl2 = IS_LOLLIPOP;
            if (bl2) {
                this.updateTintAndTintModeLollipop();
            } else {
                mode2 = this.tintableBackgroundDrawableCompat;
                if (mode2 != null && mode != null) {
                    DrawableCompat.setTintMode((Drawable)mode2, mode);
                }
            }
        }
    }

    public void updateMaskBounds(int n10, int n11) {
        GradientDrawable gradientDrawable = this.maskDrawableLollipop;
        if (gradientDrawable != null) {
            int n12 = this.insetLeft;
            int n13 = this.insetTop;
            int n14 = this.insetRight;
            n11 -= n14;
            n14 = this.insetBottom;
            gradientDrawable.setBounds(n12, n13, n11, n10 -= n14);
        }
    }
}

