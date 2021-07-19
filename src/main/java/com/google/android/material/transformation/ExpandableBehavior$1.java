/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.transformation.ExpandableBehavior;

public class ExpandableBehavior$1
implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ExpandableBehavior this$0;
    public final /* synthetic */ View val$child;
    public final /* synthetic */ ExpandableWidget val$dep;
    public final /* synthetic */ int val$expectedState;

    public ExpandableBehavior$1(ExpandableBehavior expandableBehavior, View view, int n10, ExpandableWidget expandableWidget) {
        this.this$0 = expandableBehavior;
        this.val$child = view;
        this.val$expectedState = n10;
        this.val$dep = expandableWidget;
    }

    public boolean onPreDraw() {
        this.val$child.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        ExpandableBehavior expandableBehavior = this.this$0;
        int n10 = ExpandableBehavior.access$000(expandableBehavior);
        int n11 = this.val$expectedState;
        if (n10 == n11) {
            ExpandableWidget expandableWidget;
            expandableBehavior = this.this$0;
            ExpandableWidget expandableWidget2 = expandableWidget = this.val$dep;
            expandableWidget2 = (View)expandableWidget;
            View view = this.val$child;
            n11 = (int)(expandableWidget.isExpanded() ? 1 : 0);
            expandableBehavior.onExpandedStateChange((View)expandableWidget2, view, n11 != 0, false);
        }
        return false;
    }
}

