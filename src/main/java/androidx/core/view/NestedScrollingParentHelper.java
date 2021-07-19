/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
    private int mNestedScrollAxesNonTouch;
    private int mNestedScrollAxesTouch;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
    }

    public int getNestedScrollAxes() {
        int n10 = this.mNestedScrollAxesTouch;
        int n11 = this.mNestedScrollAxesNonTouch;
        return n10 | n11;
    }

    public void onNestedScrollAccepted(View view, View view2, int n10) {
        this.onNestedScrollAccepted(view, view2, n10, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int n10, int n11) {
        int n12 = 1;
        if (n11 == n12) {
            this.mNestedScrollAxesNonTouch = n10;
        } else {
            this.mNestedScrollAxesTouch = n10;
        }
    }

    public void onStopNestedScroll(View view) {
        this.onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int n10) {
        int n11 = 1;
        if (n10 == n11) {
            this.mNestedScrollAxesNonTouch = 0;
        } else {
            this.mNestedScrollAxesTouch = 0;
        }
    }
}

