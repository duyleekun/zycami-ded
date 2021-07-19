/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.OverScroller
 */
package com.google.android.material.appbar;

import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.HeaderBehavior;

public class HeaderBehavior$FlingRunnable
implements Runnable {
    private final View layout;
    private final CoordinatorLayout parent;
    public final /* synthetic */ HeaderBehavior this$0;

    public HeaderBehavior$FlingRunnable(HeaderBehavior headerBehavior, CoordinatorLayout coordinatorLayout, View view) {
        this.this$0 = headerBehavior;
        this.parent = coordinatorLayout;
        this.layout = view;
    }

    public void run() {
        Object object = this.layout;
        if (object != null && (object = this.this$0.scroller) != null) {
            boolean bl2 = object.computeScrollOffset();
            if (bl2) {
                object = this.this$0;
                CoordinatorLayout coordinatorLayout = this.parent;
                View view = this.layout;
                OverScroller overScroller = ((HeaderBehavior)object).scroller;
                int n10 = overScroller.getCurrY();
                ((HeaderBehavior)object).setHeaderTopBottomOffset(coordinatorLayout, view, n10);
                object = this.layout;
                ViewCompat.postOnAnimation((View)object, this);
            } else {
                object = this.this$0;
                CoordinatorLayout coordinatorLayout = this.parent;
                View view = this.layout;
                ((HeaderBehavior)object).onFlingFinished(coordinatorLayout, view);
            }
        }
    }
}

