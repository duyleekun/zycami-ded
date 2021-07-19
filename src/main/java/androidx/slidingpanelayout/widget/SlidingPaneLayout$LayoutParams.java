/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Paint
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class SlidingPaneLayout$LayoutParams
extends ViewGroup.MarginLayoutParams {
    private static final int[] ATTRS;
    public Paint dimPaint;
    public boolean dimWhenOffset;
    public boolean slideable;
    public float weight;

    static {
        int[] nArray = new int[]{0x1010181};
        ATTRS = nArray;
    }

    public SlidingPaneLayout$LayoutParams() {
        int n10 = -1;
        super(n10, n10);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(int n10, int n11) {
        super(n10, n11);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        this.weight = 0.0f;
        int[] nArray = ATTRS;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.weight = f10 = context.getFloat(0, 0.0f);
        context.recycle();
    }

    public SlidingPaneLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.weight = 0.0f;
    }

    public SlidingPaneLayout$LayoutParams(SlidingPaneLayout$LayoutParams slidingPaneLayout$LayoutParams) {
        super((ViewGroup.MarginLayoutParams)slidingPaneLayout$LayoutParams);
        float f10;
        this.weight = 0.0f;
        this.weight = f10 = slidingPaneLayout$LayoutParams.weight;
    }
}

