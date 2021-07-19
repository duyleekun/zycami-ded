/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.transformation.ExpandableBehavior$1;
import java.util.List;

public abstract class ExpandableBehavior
extends CoordinatorLayout$Behavior {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED;
    private int currentState = 0;

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ int access$000(ExpandableBehavior expandableBehavior) {
        return expandableBehavior.currentState;
    }

    private boolean didStateChange(boolean n10) {
        int n11 = 0;
        int n12 = 1;
        if (n10 != 0) {
            int n13;
            n10 = this.currentState;
            if (n10 == 0 || n10 == (n13 = 2)) {
                n11 = n12;
            }
            return n11 != 0;
        }
        n10 = this.currentState;
        if (n10 == n12) {
            n11 = n12;
        }
        return n11 != 0;
    }

    public static ExpandableBehavior from(View object, Class clazz) {
        boolean bl2 = (object = object.getLayoutParams()) instanceof CoordinatorLayout$LayoutParams;
        if (bl2) {
            bl2 = (object = ((CoordinatorLayout$LayoutParams)((Object)object)).getBehavior()) instanceof ExpandableBehavior;
            if (bl2) {
                return (ExpandableBehavior)clazz.cast(object);
            }
            object = new IllegalArgumentException("The view is not associated with ExpandableBehavior");
            throw object;
        }
        object = new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        throw object;
    }

    public ExpandableWidget findExpandableWidget(CoordinatorLayout coordinatorLayout, View view) {
        List list = coordinatorLayout.getDependencies(view);
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view2 = (View)list.get(i10);
            boolean bl2 = this.layoutDependsOn(coordinatorLayout, view, view2);
            if (!bl2) continue;
            return (ExpandableWidget)view2;
        }
        return null;
    }

    public abstract boolean layoutDependsOn(CoordinatorLayout var1, View var2, View var3);

    public boolean onDependentViewChanged(CoordinatorLayout object, View view, View object2) {
        object2 = (ExpandableWidget)object2;
        int n10 = object2.isExpanded();
        if ((n10 = this.didStateChange(n10 != 0)) != 0) {
            n10 = object2.isExpanded();
            int n11 = 1;
            n10 = n10 != 0 ? n11 : 2;
            this.currentState = n10;
            object = object2;
            object = (View)object2;
            boolean bl2 = object2.isExpanded();
            return this.onExpandedStateChange((View)object, view, bl2, n11 != 0);
        }
        return false;
    }

    public abstract boolean onExpandedStateChange(View var1, View var2, boolean var3, boolean var4);

    public boolean onLayoutChild(CoordinatorLayout object, View view, int n10) {
        n10 = (int)(ViewCompat.isLaidOut(view) ? 1 : 0);
        if (n10 == 0 && (object = this.findExpandableWidget((CoordinatorLayout)object, view)) != null) {
            n10 = (int)(object.isExpanded() ? 1 : 0);
            if ((n10 = (int)(this.didStateChange(n10 != 0) ? 1 : 0)) != 0) {
                n10 = (int)(object.isExpanded() ? 1 : 0);
                n10 = n10 != 0 ? 1 : 2;
                this.currentState = n10;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                ExpandableBehavior$1 expandableBehavior$1 = new ExpandableBehavior$1(this, view, n10, (ExpandableWidget)object);
                viewTreeObserver.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)expandableBehavior$1);
            }
        }
        return false;
    }
}

