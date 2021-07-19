/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.FrameLayout
 */
package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class ScrimInsetsFrameLayout
extends FrameLayout {
    public Drawable insetForeground;
    public Rect insets;
    private Rect tempRect;

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        Rect rect;
        this.tempRect = rect = new Rect();
        int[] nArray = R$styleable.ScrimInsetsFrameLayout;
        int n11 = R$style.Widget_Design_ScrimInsetsFrameLayout;
        int[] nArray2 = new int[]{};
        object = ThemeEnforcement.obtainStyledAttributes(object, attributeSet, nArray, n10, n11, nArray2);
        int n12 = R$styleable.ScrimInsetsFrameLayout_insetForeground;
        attributeSet = object.getDrawable(n12);
        this.insetForeground = attributeSet;
        object.recycle();
        this.setWillNotDraw(true);
        super(this);
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)object);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int n10 = this.getWidth();
        int n11 = this.getHeight();
        Rect rect = this.insets;
        if (rect != null && (rect = this.insetForeground) != null) {
            int n12 = canvas.save();
            int n13 = this.getScrollX();
            float f10 = n13;
            float f11 = this.getScrollY();
            canvas.translate(f10, f11);
            Rect rect2 = this.tempRect;
            int n14 = this.insets.top;
            rect2.set(0, 0, n10, n14);
            rect2 = this.insetForeground;
            Rect rect3 = this.tempRect;
            rect2.setBounds(rect3);
            this.insetForeground.draw(canvas);
            rect2 = this.tempRect;
            n14 = this.insets.bottom;
            n14 = n11 - n14;
            rect2.set(0, n14, n10, n11);
            rect2 = this.insetForeground;
            rect3 = this.tempRect;
            rect2.setBounds(rect3);
            this.insetForeground.draw(canvas);
            rect2 = this.tempRect;
            rect3 = this.insets;
            int n15 = rect3.top;
            int n16 = rect3.left;
            n14 = rect3.bottom;
            n14 = n11 - n14;
            rect2.set(0, n15, n16, n14);
            rect2 = this.insetForeground;
            rect3 = this.tempRect;
            rect2.setBounds(rect3);
            this.insetForeground.draw(canvas);
            rect2 = this.tempRect;
            rect3 = this.insets;
            int n17 = rect3.right;
            n17 = n10 - n17;
            n15 = rect3.top;
            n14 = rect3.bottom;
            rect2.set(n17, n15, n10, n11 -= n14);
            Drawable drawable2 = this.insetForeground;
            Rect rect4 = this.tempRect;
            drawable2.setBounds(rect4);
            drawable2 = this.insetForeground;
            drawable2.draw(canvas);
            canvas.restoreToCount(n12);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable2 = this.insetForeground;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable2 = this.insetForeground;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
    }

    public void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
    }
}

