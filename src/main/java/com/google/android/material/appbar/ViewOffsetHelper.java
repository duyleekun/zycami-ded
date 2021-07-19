/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

public class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    private void updateOffsets() {
        View view = this.view;
        int n10 = this.offsetTop;
        int n11 = view.getTop();
        int n12 = this.layoutTop;
        ViewCompat.offsetTopAndBottom(view, n10 -= (n11 -= n12));
        view = this.view;
        n10 = this.offsetLeft;
        n11 = view.getLeft();
        n12 = this.layoutLeft;
        ViewCompat.offsetLeftAndRight(view, n10 -= (n11 -= n12));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public void onViewLayout() {
        int n10;
        this.layoutTop = n10 = this.view.getTop();
        this.layoutLeft = n10 = this.view.getLeft();
        this.updateOffsets();
    }

    public boolean setLeftAndRightOffset(int n10) {
        int n11 = this.offsetLeft;
        if (n11 != n10) {
            this.offsetLeft = n10;
            this.updateOffsets();
            return true;
        }
        return false;
    }

    public boolean setTopAndBottomOffset(int n10) {
        int n11 = this.offsetTop;
        if (n11 != n10) {
            this.offsetTop = n10;
            this.updateOffsets();
            return true;
        }
        return false;
    }
}

