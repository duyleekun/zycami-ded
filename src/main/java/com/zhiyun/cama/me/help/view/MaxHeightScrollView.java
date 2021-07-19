/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View$MeasureSpec
 *  android.widget.ScrollView
 */
package com.zhiyun.cama.me.help.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.zhiyun.cama.R$styleable;

public class MaxHeightScrollView
extends ScrollView {
    private int a;

    public MaxHeightScrollView(Context context) {
        super(context);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context, attributeSet);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.MaxHeightScrollView;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = this.a;
        this.a = n10 = context.getLayoutDimension(0, n10);
        context.recycle();
    }

    public void onMeasure(int n10, int n11) {
        int n12 = this.a;
        if (n12 > 0) {
            n11 = View.MeasureSpec.makeMeasureSpec((int)n12, (int)(-1 << -1));
        }
        super.onMeasure(n10, n11);
    }

    public void setMaxHeight(int n10) {
        this.a = n10;
        this.invalidate();
    }
}

