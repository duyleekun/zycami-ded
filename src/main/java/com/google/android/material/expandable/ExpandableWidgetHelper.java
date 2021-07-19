/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;

public final class ExpandableWidgetHelper {
    private boolean expanded = false;
    private int expandedComponentIdHint = 0;
    private final View widget;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        expandableWidget = (View)expandableWidget;
        this.widget = expandableWidget;
    }

    private void dispatchExpandedStateChanged() {
        Object object = this.widget.getParent();
        boolean bl2 = object instanceof CoordinatorLayout;
        if (bl2) {
            object = (CoordinatorLayout)object;
            View view = this.widget;
            ((CoordinatorLayout)object).dispatchDependentViewsChanged(view);
        }
    }

    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        int n10;
        boolean bl2;
        this.expanded = bl2 = bundle.getBoolean("expanded", false);
        String string2 = "expandedComponentIdHint";
        this.expandedComponentIdHint = n10 = bundle.getInt(string2, 0);
        n10 = (int)(this.expanded ? 1 : 0);
        if (n10 != 0) {
            this.dispatchExpandedStateChanged();
        }
    }

    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        int n10 = this.expanded;
        bundle.putBoolean("expanded", n10 != 0);
        n10 = this.expandedComponentIdHint;
        bundle.putInt("expandedComponentIdHint", n10);
        return bundle;
    }

    public boolean setExpanded(boolean bl2) {
        boolean bl3 = this.expanded;
        if (bl3 != bl2) {
            this.expanded = bl2;
            this.dispatchExpandedStateChanged();
            return true;
        }
        return false;
    }

    public void setExpandedComponentIdHint(int n10) {
        this.expandedComponentIdHint = n10;
    }
}

