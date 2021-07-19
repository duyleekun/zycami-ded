/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper$Callback;
import com.google.android.material.behavior.SwipeDismissBehavior$1;
import com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener;

public class SwipeDismissBehavior
extends CoordinatorLayout$Behavior {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END;
    public float alphaEndSwipeDistance;
    public float alphaStartSwipeDistance;
    private final ViewDragHelper$Callback dragCallback;
    public float dragDismissThreshold;
    private boolean interceptingEvents;
    public SwipeDismissBehavior$OnDismissListener listener;
    private float sensitivity = 0.0f;
    private boolean sensitivitySet;
    public int swipeDirection = 2;
    public ViewDragHelper viewDragHelper;

    public SwipeDismissBehavior() {
        float f10;
        this.dragDismissThreshold = f10 = 0.5f;
        this.alphaStartSwipeDistance = 0.0f;
        this.alphaEndSwipeDistance = f10;
        SwipeDismissBehavior$1 swipeDismissBehavior$1 = new SwipeDismissBehavior$1(this);
        this.dragCallback = swipeDismissBehavior$1;
    }

    public static float clamp(float f10, float f11, float f12) {
        return Math.min(Math.max(f10, f11), f12);
    }

    public static int clamp(int n10, int n11, int n12) {
        return Math.min(Math.max(n10, n11), n12);
    }

    private void ensureViewDragHelper(ViewGroup object) {
        Object object2 = this.viewDragHelper;
        if (object2 == null) {
            boolean bl2 = this.sensitivitySet;
            if (bl2) {
                float f10 = this.sensitivity;
                ViewDragHelper$Callback viewDragHelper$Callback = this.dragCallback;
                object = ViewDragHelper.create(object, f10, viewDragHelper$Callback);
            } else {
                object2 = this.dragCallback;
                object = ViewDragHelper.create(object, (ViewDragHelper$Callback)object2);
            }
            this.viewDragHelper = object;
        }
    }

    public static float fraction(float f10, float f11, float f12) {
        return (f12 -= f10) / (f11 -= f10);
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    public int getDragState() {
        int n10;
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            n10 = viewDragHelper.getViewDragState();
        } else {
            n10 = 0;
            viewDragHelper = null;
        }
        return n10;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int n10 = this.interceptingEvents;
        int n11 = motionEvent.getActionMasked();
        if (n11 != 0) {
            int n12 = 1;
            if (n11 == n12 || n11 == (n12 = 3)) {
                this.interceptingEvents = false;
            }
        } else {
            float f10 = motionEvent.getX();
            n10 = (int)f10;
            float f11 = motionEvent.getY();
            n11 = (int)f11;
            n10 = (int)(coordinatorLayout.isPointInChildBounds(view, n10, n11) ? 1 : 0);
            this.interceptingEvents = n10;
        }
        if (n10 != 0) {
            this.ensureViewDragHelper(coordinatorLayout);
            return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(CoordinatorLayout object, View view, MotionEvent motionEvent) {
        object = this.viewDragHelper;
        if (object != null) {
            ((ViewDragHelper)object).processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }

    public void setDragDismissDistance(float f10) {
        this.dragDismissThreshold = f10 = SwipeDismissBehavior.clamp(0.0f, f10, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f10) {
        this.alphaEndSwipeDistance = f10 = SwipeDismissBehavior.clamp(0.0f, f10, 1.0f);
    }

    public void setListener(SwipeDismissBehavior$OnDismissListener swipeDismissBehavior$OnDismissListener) {
        this.listener = swipeDismissBehavior$OnDismissListener;
    }

    public void setSensitivity(float f10) {
        this.sensitivity = f10;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f10) {
        this.alphaStartSwipeDistance = f10 = SwipeDismissBehavior.clamp(0.0f, f10, 1.0f);
    }

    public void setSwipeDirection(int n10) {
        this.swipeDirection = n10;
    }
}

