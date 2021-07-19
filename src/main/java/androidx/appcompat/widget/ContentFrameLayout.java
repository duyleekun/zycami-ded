/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ContentFrameLayout$OnAttachListener;
import androidx.core.view.ViewCompat;

public class ContentFrameLayout
extends FrameLayout {
    private ContentFrameLayout$OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        super();
        this.mDecorPadding = context;
    }

    public void dispatchFitSystemWindows(Rect rect) {
        this.fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        TypedValue typedValue = this.mFixedHeightMajor;
        if (typedValue == null) {
            this.mFixedHeightMajor = typedValue = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        TypedValue typedValue = this.mFixedHeightMinor;
        if (typedValue == null) {
            this.mFixedHeightMinor = typedValue = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        TypedValue typedValue = this.mFixedWidthMajor;
        if (typedValue == null) {
            this.mFixedWidthMajor = typedValue = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        TypedValue typedValue = this.mFixedWidthMinor;
        if (typedValue == null) {
            this.mFixedWidthMinor = typedValue = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        TypedValue typedValue = this.mMinWidthMajor;
        if (typedValue == null) {
            this.mMinWidthMajor = typedValue = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        TypedValue typedValue = this.mMinWidthMinor;
        if (typedValue == null) {
            this.mMinWidthMinor = typedValue = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ContentFrameLayout$OnAttachListener contentFrameLayout$OnAttachListener = this.mAttachListener;
        if (contentFrameLayout$OnAttachListener != null) {
            contentFrameLayout$OnAttachListener.onAttachedFromWindow();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ContentFrameLayout$OnAttachListener contentFrameLayout$OnAttachListener = this.mAttachListener;
        if (contentFrameLayout$OnAttachListener != null) {
            contentFrameLayout$OnAttachListener.onDetachedFromWindow();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void onMeasure(int var1_1, int var2_2) {
        var3_3 = this.getContext().getResources().getDisplayMetrics();
        var4_4 = var3_3.widthPixels;
        var5_5 = var3_3.heightPixels;
        var6_6 = 1;
        var7_7 = 1.4E-45f;
        if (var4_4 < var5_5) {
            var4_4 = var6_6;
        } else {
            var4_4 = 0;
            var8_8 = null;
        }
        var5_5 = View.MeasureSpec.getMode((int)var1_1);
        var9_9 = View.MeasureSpec.getMode((int)var2_2);
        var10_10 = 6;
        var11_11 = 5;
        var12_12 = -1 << -1;
        var13_13 = 0x40000000;
        if (var5_5 != var12_12 || (var14_14 = var4_4 != 0 ? this.mFixedWidthMinor : this.mFixedWidthMajor) == null || (var15_15 = var14_14.type) == 0) ** GOTO lbl-1000
        if (var15_15 == var11_11) {
            var16_16 = var14_14.getDimension(var3_3);
lbl20:
            // 2 sources

            while (true) {
                var17_19 = (int)var16_16;
                break;
            }
        } else {
            if (var15_15 == var10_10) {
                var15_15 = var3_3.widthPixels;
                var18_17 = var15_15;
                var19_18 = var15_15;
                var16_16 = var14_14.getFraction(var18_17, var19_18);
                ** continue;
            }
            var17_19 = 0;
            var14_14 = null;
            var16_16 = 0.0f;
        }
        if (var17_19 > 0) {
            var20_20 = this.mDecorPadding;
            var21_21 = var20_20.left;
            var15_15 = var20_20.right;
            var1_1 = View.MeasureSpec.getSize((int)var1_1);
            var1_1 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var17_19 -= (var21_21 += var15_15), var1_1), (int)var13_13);
            var17_19 = var6_6;
            var16_16 = var7_7;
        } else lbl-1000:
        // 2 sources

        {
            var17_19 = 0;
            var14_14 = null;
            var16_16 = 0.0f;
        }
        if (var9_9 == var12_12 && (var22_22 = var4_4 != 0 ? this.mFixedHeightMajor : this.mFixedHeightMinor) != null && (var15_15 = var22_22.type) != 0) {
            if (var15_15 == var11_11) {
                var23_23 = var22_22.getDimension(var3_3);
lbl47:
                // 2 sources

                while (true) {
                    var9_9 = (int)var23_23;
                    break;
                }
            } else {
                if (var15_15 == var10_10) {
                    var15_15 = var3_3.heightPixels;
                    var18_17 = var15_15;
                    var19_18 = var15_15;
                    var23_23 = var22_22.getFraction(var18_17, var19_18);
                    ** continue;
                }
                var9_9 = 0;
                var22_22 = null;
                var23_24 = 0.0f;
            }
            if (var9_9 > 0) {
                var20_20 = this.mDecorPadding;
                var21_21 = var20_20.top;
                var15_15 = var20_20.bottom;
                var2_2 = View.MeasureSpec.getSize((int)var2_2);
                var2_2 = View.MeasureSpec.makeMeasureSpec((int)Math.min(var9_9 -= (var21_21 += var15_15), var2_2), (int)var13_13);
            }
        }
        super.onMeasure(var1_1, var2_2);
        var1_1 = this.getMeasuredWidth();
        var9_9 = View.MeasureSpec.makeMeasureSpec((int)var1_1, (int)var13_13);
        if (var17_19 != 0 || var5_5 != var12_12 || (var8_8 = var4_4 != 0 ? this.mMinWidthMinor : this.mMinWidthMajor) == null || (var5_5 = var8_8.type) == 0) ** GOTO lbl-1000
        if (var5_5 == var11_11) {
            var24_25 = var8_8.getDimension(var3_3);
lbl71:
            // 2 sources

            while (true) {
                var25_27 = (int)var24_25;
                break;
            }
        } else {
            if (var5_5 == var10_10) {
                var25_27 = var3_3.widthPixels;
                var26_28 = var25_27;
                var24_25 = var25_27;
                var24_25 = var8_8.getFraction(var26_28, var24_25);
                ** continue;
            }
            var25_27 = 0;
            var3_3 = null;
            var24_26 = 0.0f;
        }
        if (var25_27 > 0) {
            var8_8 = this.mDecorPadding;
            var5_5 = var8_8.left;
            var4_4 = var8_8.right;
            var25_27 -= (var5_5 += var4_4);
        }
        if (var1_1 < var25_27) {
            var9_9 = View.MeasureSpec.makeMeasureSpec((int)var25_27, (int)var13_13);
        } else lbl-1000:
        // 2 sources

        {
            var6_6 = 0;
            var7_7 = 0.0f;
        }
        if (var6_6 != 0) {
            super.onMeasure(var9_9, var2_2);
        }
    }

    public void setAttachListener(ContentFrameLayout$OnAttachListener contentFrameLayout$OnAttachListener) {
        this.mAttachListener = contentFrameLayout$OnAttachListener;
    }

    public void setDecorPadding(int n10, int n11, int n12, int n13) {
        Rect rect = this.mDecorPadding;
        rect.set(n10, n11, n12, n13);
        n10 = ViewCompat.isLaidOut((View)this) ? 1 : 0;
        if (n10 != 0) {
            this.requestLayout();
        }
    }
}

