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
import com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.snackbar.SnackbarManager$Callback;

public class BaseTransientBottomBar$BehaviorDelegate {
    private SnackbarManager$Callback managerCallback;

    public BaseTransientBottomBar$BehaviorDelegate(SwipeDismissBehavior swipeDismissBehavior) {
        swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
        swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
        swipeDismissBehavior.setSwipeDirection(0);
    }

    public boolean canSwipeDismissView(View view) {
        return view instanceof BaseTransientBottomBar$SnackbarBaseLayout;
    }

    public void onInterceptTouchEvent(CoordinatorLayout object, View object2, MotionEvent motionEvent) {
        int n10 = motionEvent.getActionMasked();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11 || n10 == (n11 = 3)) {
                object = SnackbarManager.getInstance();
                object2 = this.managerCallback;
                ((SnackbarManager)object).restoreTimeoutIfPaused((SnackbarManager$Callback)object2);
            }
        } else {
            float f10;
            int n12;
            float f11 = motionEvent.getX();
            n10 = (int)f11;
            boolean bl2 = ((CoordinatorLayout)object).isPointInChildBounds((View)object2, n10, n12 = (int)(f10 = motionEvent.getY()));
            if (bl2) {
                object = SnackbarManager.getInstance();
                object2 = this.managerCallback;
                ((SnackbarManager)object).pauseTimeout((SnackbarManager$Callback)object2);
            }
        }
    }

    public void setBaseTransientBottomBar(BaseTransientBottomBar object) {
        this.managerCallback = object = ((BaseTransientBottomBar)object).managerCallback;
    }
}

