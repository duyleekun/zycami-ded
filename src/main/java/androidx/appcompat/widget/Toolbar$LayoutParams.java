/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar$LayoutParams;

public class Toolbar$LayoutParams
extends ActionBar$LayoutParams {
    public static final int CUSTOM = 0;
    public static final int EXPANDED = 2;
    public static final int SYSTEM = 1;
    public int mViewType = 0;

    public Toolbar$LayoutParams(int n10) {
        this(-2, -1, n10);
    }

    public Toolbar$LayoutParams(int n10, int n11) {
        super(n10, n11);
        this.gravity = 8388627;
    }

    public Toolbar$LayoutParams(int n10, int n11, int n12) {
        super(n10, n11);
        this.gravity = n12;
    }

    public Toolbar$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Toolbar$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public Toolbar$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super((ViewGroup.LayoutParams)marginLayoutParams);
        this.copyMarginsFromCompat(marginLayoutParams);
    }

    public Toolbar$LayoutParams(ActionBar$LayoutParams actionBar$LayoutParams) {
        super(actionBar$LayoutParams);
    }

    public Toolbar$LayoutParams(Toolbar$LayoutParams toolbar$LayoutParams) {
        super(toolbar$LayoutParams);
        int n10;
        this.mViewType = n10 = toolbar$LayoutParams.mViewType;
    }

    public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int n10;
        int n11;
        this.leftMargin = n11 = marginLayoutParams.leftMargin;
        this.topMargin = n11 = marginLayoutParams.topMargin;
        this.rightMargin = n11 = marginLayoutParams.rightMargin;
        this.bottomMargin = n10 = marginLayoutParams.bottomMargin;
    }
}

