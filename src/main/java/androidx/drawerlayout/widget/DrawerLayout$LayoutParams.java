/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.drawerlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerLayout$LayoutParams
extends ViewGroup.MarginLayoutParams {
    private static final int FLAG_IS_CLOSING = 4;
    private static final int FLAG_IS_OPENED = 1;
    private static final int FLAG_IS_OPENING = 2;
    public int gravity = 0;
    public boolean isPeeking;
    public float onScreen;
    public int openState;

    public DrawerLayout$LayoutParams(int n10, int n11) {
        super(n10, n11);
    }

    public DrawerLayout$LayoutParams(int n10, int n11, int n12) {
        this(n10, n11);
        this.gravity = n12;
    }

    public DrawerLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        int[] nArray = DrawerLayout.LAYOUT_ATTRS;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.gravity = n10 = context.getInt(0, 0);
        context.recycle();
    }

    public DrawerLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public DrawerLayout$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public DrawerLayout$LayoutParams(DrawerLayout$LayoutParams drawerLayout$LayoutParams) {
        super((ViewGroup.MarginLayoutParams)drawerLayout$LayoutParams);
        int n10;
        this.gravity = n10 = drawerLayout$LayoutParams.gravity;
    }
}

