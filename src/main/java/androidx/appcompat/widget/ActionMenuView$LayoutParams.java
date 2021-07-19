/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat$LayoutParams;

public class ActionMenuView$LayoutParams
extends LinearLayoutCompat$LayoutParams {
    public int cellsUsed;
    public boolean expandable;
    public boolean expanded;
    public int extraPixels;
    public boolean isOverflowButton;
    public boolean preventEdgeOffset;

    public ActionMenuView$LayoutParams(int n10, int n11) {
        super(n10, n11);
        this.isOverflowButton = false;
    }

    public ActionMenuView$LayoutParams(int n10, int n11, boolean bl2) {
        super(n10, n11);
        this.isOverflowButton = bl2;
    }

    public ActionMenuView$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionMenuView$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ActionMenuView$LayoutParams(ActionMenuView$LayoutParams actionMenuView$LayoutParams) {
        super((ViewGroup.LayoutParams)actionMenuView$LayoutParams);
        boolean bl2;
        this.isOverflowButton = bl2 = actionMenuView$LayoutParams.isOverflowButton;
    }
}

