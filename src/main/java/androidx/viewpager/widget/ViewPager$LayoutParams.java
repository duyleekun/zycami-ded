/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

public class ViewPager$LayoutParams
extends ViewGroup.LayoutParams {
    public int childIndex;
    public int gravity;
    public boolean isDecor;
    public boolean needsMeasure;
    public int position;
    public float widthFactor;

    public ViewPager$LayoutParams() {
        int n10 = -1;
        super(n10, n10);
        this.widthFactor = 0.0f;
    }

    public ViewPager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        this.widthFactor = 0.0f;
        int[] nArray = ViewPager.LAYOUT_ATTRS;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.gravity = n10 = context.getInteger(0, 48);
        context.recycle();
    }
}

