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
 *  android.view.Gravity
 */
package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class ForegroundLinearLayout
extends LinearLayoutCompat {
    private Drawable foreground;
    public boolean foregroundBoundsChanged;
    private int foregroundGravity;
    public boolean mForegroundInPadding;
    private final Rect overlayBounds;
    private final Rect selfBounds;

    public ForegroundLinearLayout(Context context) {
        this(context, null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        boolean bl2;
        Rect rect;
        this.selfBounds = rect = new Rect();
        this.overlayBounds = rect = new Rect();
        this.foregroundGravity = 119;
        this.mForegroundInPadding = bl2 = true;
        this.foregroundBoundsChanged = false;
        int[] nArray = R$styleable.ForegroundLinearLayout;
        int[] nArray2 = new int[]{};
        context = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, nArray, n10, 0, nArray2);
        int n11 = R$styleable.ForegroundLinearLayout_android_foregroundGravity;
        n10 = this.foregroundGravity;
        this.foregroundGravity = n11 = context.getInt(n11, n10);
        n11 = R$styleable.ForegroundLinearLayout_android_foreground;
        attributeSet = context.getDrawable(n11);
        if (attributeSet != null) {
            this.setForeground((Drawable)attributeSet);
        }
        n11 = R$styleable.ForegroundLinearLayout_foregroundInsidePadding;
        n11 = (int)(context.getBoolean(n11, bl2) ? 1 : 0);
        this.mForegroundInPadding = n11;
        context.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable2 = this.foreground;
        if (drawable2 != null) {
            int n10 = this.foregroundBoundsChanged;
            if (n10 != 0) {
                n10 = 0;
                this.foregroundBoundsChanged = false;
                Rect rect = this.selfBounds;
                Rect rect2 = this.overlayBounds;
                int n11 = this.getRight();
                int n12 = this.getLeft();
                n11 -= n12;
                n12 = this.getBottom();
                int n13 = this.getTop();
                n12 -= n13;
                n13 = (int)(this.mForegroundInPadding ? 1 : 0);
                if (n13 != 0) {
                    rect.set(0, 0, n11, n12);
                } else {
                    n10 = this.getPaddingLeft();
                    n13 = this.getPaddingTop();
                    int n14 = this.getPaddingRight();
                    n11 -= n14;
                    n14 = this.getPaddingBottom();
                    rect.set(n10, n13, n11, n12 -= n14);
                }
                n10 = this.foregroundGravity;
                n11 = drawable2.getIntrinsicWidth();
                n12 = drawable2.getIntrinsicHeight();
                Gravity.apply((int)n10, (int)n11, (int)n12, (Rect)rect, (Rect)rect2);
                drawable2.setBounds(rect2);
            }
            drawable2.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f10, float f11) {
        super.drawableHotspotChanged(f10, f11);
        Drawable drawable2 = this.foreground;
        if (drawable2 != null) {
            drawable2.setHotspot(f10, f11);
        }
    }

    public void drawableStateChanged() {
        boolean bl2;
        super.drawableStateChanged();
        Drawable drawable2 = this.foreground;
        if (drawable2 != null && (bl2 = drawable2.isStateful())) {
            drawable2 = this.foreground;
            int[] nArray = this.getDrawableState();
            drawable2.setState(nArray);
        }
    }

    public Drawable getForeground() {
        return this.foreground;
    }

    public int getForegroundGravity() {
        return this.foregroundGravity;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable2 = this.foreground;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        n10 = (int)(this.foregroundBoundsChanged ? 1 : 0);
        this.foregroundBoundsChanged = bl2 |= n10;
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        this.foregroundBoundsChanged = true;
    }

    public void setForeground(Drawable drawable2) {
        Object object = this.foreground;
        if (object != drawable2) {
            int n10;
            if (object != null) {
                n10 = 0;
                object.setCallback(null);
                object = this.foreground;
                this.unscheduleDrawable((Drawable)object);
            }
            this.foreground = drawable2;
            if (drawable2 != null) {
                object = null;
                this.setWillNotDraw(false);
                drawable2.setCallback((Drawable.Callback)this);
                int n11 = drawable2.isStateful();
                if (n11 != 0) {
                    object = this.getDrawableState();
                    drawable2.setState((int[])object);
                }
                if ((n11 = this.foregroundGravity) == (n10 = 119)) {
                    object = new Rect();
                    drawable2.getPadding((Rect)object);
                }
            } else {
                boolean bl2 = true;
                this.setWillNotDraw(bl2);
            }
            this.requestLayout();
            this.invalidate();
        }
    }

    public void setForegroundGravity(int n10) {
        int n11 = this.foregroundGravity;
        if (n11 != n10) {
            Drawable drawable2;
            n11 = 0x800007 & n10;
            if (n11 == 0) {
                n11 = 0x800003;
                n10 |= n11;
            }
            if ((n11 = n10 & 0x70) == 0) {
                n10 |= 0x30;
            }
            this.foregroundGravity = n10;
            n11 = 119;
            if (n10 == n11 && (drawable2 = this.foreground) != null) {
                drawable2 = new Rect();
                Drawable drawable3 = this.foreground;
                drawable3.getPadding((Rect)drawable2);
            }
            this.requestLayout();
        }
    }

    public boolean verifyDrawable(Drawable drawable2) {
        boolean bl2;
        Drawable drawable3;
        boolean bl3 = super.verifyDrawable(drawable2);
        if (!bl3 && drawable2 != (drawable3 = this.foreground)) {
            bl2 = false;
            drawable2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

