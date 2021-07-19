/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$OnHierarchyChangeListener
 */
package androidx.coordinatorlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class CoordinatorLayout$HierarchyChangeListener
implements ViewGroup.OnHierarchyChangeListener {
    public final /* synthetic */ CoordinatorLayout this$0;

    public CoordinatorLayout$HierarchyChangeListener(CoordinatorLayout coordinatorLayout) {
        this.this$0 = coordinatorLayout;
    }

    public void onChildViewAdded(View view, View view2) {
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.this$0.mOnHierarchyChangeListener;
        if (onHierarchyChangeListener != null) {
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        CoordinatorLayout coordinatorLayout = this.this$0;
        int n10 = 2;
        coordinatorLayout.onChildViewsChanged(n10);
        coordinatorLayout = this.this$0.mOnHierarchyChangeListener;
        if (coordinatorLayout != null) {
            coordinatorLayout.onChildViewRemoved(view, view2);
        }
    }
}

