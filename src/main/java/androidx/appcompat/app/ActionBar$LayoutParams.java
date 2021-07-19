/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.appcompat.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;

public class ActionBar$LayoutParams
extends ViewGroup.MarginLayoutParams {
    public int gravity = 0;

    public ActionBar$LayoutParams(int n10) {
        this(-2, -1, n10);
    }

    public ActionBar$LayoutParams(int n10, int n11) {
        super(n10, n11);
        this.gravity = 8388627;
    }

    public ActionBar$LayoutParams(int n10, int n11, int n12) {
        super(n10, n11);
        this.gravity = n12;
    }

    public ActionBar$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = R$styleable.ActionBarLayout;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.ActionBarLayout_android_layout_gravity;
        this.gravity = n10 = context.getInt(n10, 0);
        context.recycle();
    }

    public ActionBar$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ActionBar$LayoutParams(ActionBar$LayoutParams actionBar$LayoutParams) {
        super((ViewGroup.MarginLayoutParams)actionBar$LayoutParams);
        int n10;
        this.gravity = n10 = actionBar$LayoutParams.gravity;
    }
}

