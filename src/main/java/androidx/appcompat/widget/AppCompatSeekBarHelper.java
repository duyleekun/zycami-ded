/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.SeekBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatProgressBarHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

public class AppCompatSeekBarHelper
extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint = false;
    private boolean mHasTickMarkTintMode = false;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList = null;
    private PorterDuff.Mode mTickMarkTintMode = null;
    private final SeekBar mView;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super((ProgressBar)seekBar);
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        boolean bl2;
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null && ((bl2 = this.mHasTickMarkTint) || (bl2 = this.mHasTickMarkTintMode))) {
            boolean bl3;
            Object object;
            this.mTickMark = drawable2 = DrawableCompat.wrap(drawable2.mutate());
            bl2 = this.mHasTickMarkTint;
            if (bl2) {
                object = this.mTickMarkTintList;
                DrawableCompat.setTintList(drawable2, object);
            }
            if (bl3 = this.mHasTickMarkTintMode) {
                drawable2 = this.mTickMark;
                object = this.mTickMarkTintMode;
                DrawableCompat.setTintMode(drawable2, (PorterDuff.Mode)object);
            }
            if (bl3 = (drawable2 = this.mTickMark).isStateful()) {
                drawable2 = this.mTickMark;
                object = this.mView.getDrawableState();
                drawable2.setState((int[])object);
            }
        }
    }

    public void drawTickMarks(Canvas canvas) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2 = this.mView;
            int n10 = drawable2.getMax();
            int n11 = 1;
            float f10 = Float.MIN_VALUE;
            if (n10 > n11) {
                float f11;
                Drawable drawable3 = this.mTickMark;
                int n12 = drawable3.getIntrinsicWidth();
                Drawable drawable4 = this.mTickMark;
                int n13 = drawable4.getIntrinsicHeight();
                if (n12 >= 0) {
                    n12 /= 2;
                } else {
                    n12 = n11;
                    f11 = f10;
                }
                if (n13 >= 0) {
                    n11 = n13 / 2;
                }
                drawable4 = this.mTickMark;
                int n14 = -n12;
                int n15 = -n11;
                drawable4.setBounds(n14, n15, n12, n11);
                SeekBar seekBar = this.mView;
                n11 = seekBar.getWidth();
                n12 = this.mView.getPaddingLeft();
                n11 -= n12;
                drawable3 = this.mView;
                n12 = drawable3.getPaddingRight();
                f10 = n11 -= n12;
                f11 = n10;
                f10 /= f11;
                n12 = canvas.save();
                float f12 = this.mView.getPaddingLeft();
                SeekBar seekBar2 = this.mView;
                n14 = seekBar2.getHeight() / 2;
                float f13 = n14;
                canvas.translate(f12, f13);
                f12 = 0.0f;
                drawable4 = null;
                for (n13 = 0; n13 <= n10; ++n13) {
                    this.mTickMark.draw(canvas);
                    n14 = 0;
                    f13 = 0.0f;
                    seekBar2 = null;
                    canvas.translate(f10, 0.0f);
                }
                canvas.restoreToCount(n12);
            }
        }
    }

    public void drawableStateChanged() {
        Object object;
        boolean bl2;
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null && (bl2 = drawable2.isStateful()) && (bl2 = drawable2.setState(object = this.mView.getDrawableState()))) {
            object = this.mView;
            object.invalidateDrawable(drawable2);
        }
    }

    public Drawable getTickMark() {
        return this.mTickMark;
    }

    public ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    public PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    public void loadFromAttributes(AttributeSet attributeSet, int n10) {
        SeekBar seekBar;
        super.loadFromAttributes(attributeSet, n10);
        Object object = this.mView.getContext();
        int[] nArray = R$styleable.AppCompatSeekBar;
        boolean bl2 = false;
        object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray, n10, 0);
        SeekBar seekBar2 = this.mView;
        Context context = seekBar2.getContext();
        TypedArray typedArray = ((TintTypedArray)object).getWrappedTypeArray();
        ViewCompat.saveAttributeDataForStyleable((View)seekBar2, context, nArray, attributeSet, typedArray, n10, 0);
        int n11 = R$styleable.AppCompatSeekBar_android_thumb;
        attributeSet = ((TintTypedArray)object).getDrawableIfKnown(n11);
        if (attributeSet != null) {
            seekBar = this.mView;
            seekBar.setThumb((Drawable)attributeSet);
        }
        n11 = R$styleable.AppCompatSeekBar_tickMark;
        attributeSet = ((TintTypedArray)object).getDrawable(n11);
        this.setTickMark((Drawable)attributeSet);
        n11 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        n10 = (int)(((TintTypedArray)object).hasValue(n11) ? 1 : 0);
        bl2 = true;
        if (n10 != 0) {
            n10 = -1;
            n11 = ((TintTypedArray)object).getInt(n11, n10);
            seekBar = this.mTickMarkTintMode;
            attributeSet = DrawableUtils.parseTintMode(n11, (PorterDuff.Mode)seekBar);
            this.mTickMarkTintMode = attributeSet;
            this.mHasTickMarkTintMode = bl2;
        }
        if ((n10 = (int)(((TintTypedArray)object).hasValue(n11 = R$styleable.AppCompatSeekBar_tickMarkTint) ? 1 : 0)) != 0) {
            attributeSet = ((TintTypedArray)object).getColorStateList(n11);
            this.mTickMarkTintList = attributeSet;
            this.mHasTickMarkTint = bl2;
        }
        ((TintTypedArray)object).recycle();
        this.applyTickMarkTint();
    }

    public void setTickMark(Drawable drawable2) {
        Object object = this.mTickMark;
        if (object != null) {
            object.setCallback(null);
        }
        this.mTickMark = drawable2;
        if (drawable2 != null) {
            object = this.mView;
            drawable2.setCallback((Drawable.Callback)object);
            object = this.mView;
            int n10 = ViewCompat.getLayoutDirection((View)object);
            DrawableCompat.setLayoutDirection(drawable2, n10);
            n10 = (int)(drawable2.isStateful() ? 1 : 0);
            if (n10 != 0) {
                object = this.mView.getDrawableState();
                drawable2.setState((int[])object);
            }
            this.applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    public void setTickMarkTintList(ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        this.applyTickMarkTint();
    }

    public void setTickMarkTintMode(PorterDuff.Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        this.applyTickMarkTint();
    }
}

