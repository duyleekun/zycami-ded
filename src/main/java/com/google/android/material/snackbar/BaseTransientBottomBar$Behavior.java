/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.BaseTransientBottomBar$BehaviorDelegate;

public class BaseTransientBottomBar$Behavior
extends SwipeDismissBehavior {
    private final BaseTransientBottomBar$BehaviorDelegate delegate;

    public BaseTransientBottomBar$Behavior() {
        BaseTransientBottomBar$BehaviorDelegate baseTransientBottomBar$BehaviorDelegate;
        this.delegate = baseTransientBottomBar$BehaviorDelegate = new BaseTransientBottomBar$BehaviorDelegate(this);
    }

    public static /* synthetic */ void access$000(BaseTransientBottomBar$Behavior baseTransientBottomBar$Behavior, BaseTransientBottomBar baseTransientBottomBar) {
        baseTransientBottomBar$Behavior.setBaseTransientBottomBar(baseTransientBottomBar);
    }

    private void setBaseTransientBottomBar(BaseTransientBottomBar baseTransientBottomBar) {
        this.delegate.setBaseTransientBottomBar(baseTransientBottomBar);
    }

    public boolean canSwipeDismissView(View view) {
        return this.delegate.canSwipeDismissView(view);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.delegate.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}

