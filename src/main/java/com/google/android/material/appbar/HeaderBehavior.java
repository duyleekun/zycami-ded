/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.widget.OverScroller
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.HeaderBehavior$FlingRunnable;
import com.google.android.material.appbar.ViewOffsetBehavior;

public abstract class HeaderBehavior
extends ViewOffsetBehavior {
    private static final int INVALID_POINTER = 255;
    private int activePointerId;
    private Runnable flingRunnable;
    private boolean isBeingDragged;
    private int lastMotionY;
    public OverScroller scroller;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    public HeaderBehavior() {
        int n10;
        this.activePointerId = n10 = -1;
        this.touchSlop = n10;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        this.activePointerId = n10 = -1;
        this.touchSlop = n10;
    }

    private void ensureVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            this.velocityTracker = velocityTracker = VelocityTracker.obtain();
        }
    }

    public boolean canDragView(View view) {
        return false;
    }

    public final boolean fling(CoordinatorLayout coordinatorLayout, View view, int n10, int n11, float f10) {
        Object object;
        boolean bl2;
        HeaderBehavior headerBehavior = this;
        Runnable runnable = this.flingRunnable;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            bl2 = false;
            runnable = null;
            this.flingRunnable = null;
        }
        if ((runnable = headerBehavior.scroller) == null) {
            object = view.getContext();
            runnable = new OverScroller(object);
            headerBehavior.scroller = runnable;
        }
        OverScroller overScroller = headerBehavior.scroller;
        int n12 = this.getTopAndBottomOffset();
        int n13 = Math.round(f10);
        overScroller.fling(0, n12, 0, n13, 0, 0, n10, n11);
        runnable = headerBehavior.scroller;
        bl2 = runnable.computeScrollOffset();
        if (bl2) {
            object = coordinatorLayout;
            headerBehavior.flingRunnable = runnable = new HeaderBehavior$FlingRunnable(this, coordinatorLayout, view);
            ViewCompat.postOnAnimation(view, runnable);
            return true;
        }
        object = coordinatorLayout;
        this.onFlingFinished(coordinatorLayout, view);
        return false;
    }

    public int getMaxDragOffset(View view) {
        return -view.getHeight();
    }

    public int getScrollRangeForDragFling(View view) {
        return view.getHeight();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return this.getTopAndBottomOffset();
    }

    public void onFlingFinished(CoordinatorLayout coordinatorLayout, View view) {
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        block10: {
            int n10;
            int n11;
            float f10;
            int n12;
            int n13;
            block7: {
                float f11;
                int n14;
                block8: {
                    block9: {
                        n13 = this.touchSlop;
                        if (n13 < 0) {
                            ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)coordinatorLayout.getContext());
                            this.touchSlop = n13 = viewConfiguration.getScaledTouchSlop();
                        }
                        n13 = motionEvent.getAction();
                        n12 = 2;
                        f10 = 2.8E-45f;
                        n11 = 1;
                        if (n13 == n12 && (n13 = (int)(this.isBeingDragged ? 1 : 0)) != 0) {
                            return n11 != 0;
                        }
                        n13 = motionEvent.getActionMasked();
                        if (n13 == 0) break block7;
                        n14 = -1;
                        f11 = 0.0f / 0.0f;
                        if (n13 == n11) break block8;
                        if (n13 == n12) break block9;
                        int n15 = 3;
                        if (n13 == n15) break block8;
                        break block10;
                    }
                    int n16 = this.activePointerId;
                    if (n16 != n14 && (n16 = motionEvent.findPointerIndex(n16)) != n14) {
                        f11 = motionEvent.getY(n16);
                        n14 = (int)f11;
                        n16 = this.lastMotionY;
                        if ((n16 = Math.abs(n14 - n16)) > (n13 = this.touchSlop)) {
                            this.isBeingDragged = n11;
                            this.lastMotionY = n14;
                        }
                    }
                    break block10;
                }
                this.isBeingDragged = false;
                this.activePointerId = n14;
                coordinatorLayout = this.velocityTracker;
                if (coordinatorLayout != null) {
                    coordinatorLayout.recycle();
                    n14 = 0;
                    f11 = 0.0f;
                    coordinatorLayout = null;
                    this.velocityTracker = null;
                }
                break block10;
            }
            this.isBeingDragged = false;
            float f12 = motionEvent.getX();
            n13 = (int)f12;
            f10 = motionEvent.getY();
            n12 = (int)f10;
            n11 = (int)(this.canDragView(view) ? 1 : 0);
            if (n11 != 0 && (n10 = coordinatorLayout.isPointInChildBounds(view, n13, n12)) != 0) {
                this.lastMotionY = n12;
                this.activePointerId = n10 = motionEvent.getPointerId(0);
                this.ensureVelocityTracker();
            }
        }
        coordinatorLayout = this.velocityTracker;
        if (coordinatorLayout != null) {
            coordinatorLayout.addMovement(motionEvent);
        }
        return this.isBeingDragged;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        block16: {
            int n10;
            block15: {
                float f10;
                int n11;
                int n12;
                block11: {
                    int n13;
                    int n14;
                    block14: {
                        ViewConfiguration viewConfiguration;
                        block12: {
                            int n15;
                            int n16;
                            block13: {
                                n12 = this.touchSlop;
                                if (n12 < 0) {
                                    viewConfiguration = ViewConfiguration.get((Context)coordinatorLayout.getContext());
                                    this.touchSlop = n12 = viewConfiguration.getScaledTouchSlop();
                                }
                                n12 = motionEvent.getActionMasked();
                                n10 = 1;
                                n16 = 0;
                                if (n12 == 0) break block11;
                                n14 = -1;
                                float f11 = 0.0f / 0.0f;
                                if (n12 == n10) break block12;
                                n15 = 2;
                                if (n12 == n15) break block13;
                                n13 = 3;
                                if (n12 == n13) break block14;
                                break block15;
                            }
                            n12 = this.activePointerId;
                            if ((n12 = motionEvent.findPointerIndex(n12)) == n14) {
                                return false;
                            }
                            float f12 = motionEvent.getY(n12);
                            n12 = (int)f12;
                            n16 = this.lastMotionY - n12;
                            n14 = (int)(this.isBeingDragged ? 1 : 0);
                            if (n14 == 0 && (n14 = Math.abs(n16)) > (n15 = this.touchSlop)) {
                                this.isBeingDragged = n10;
                                n16 = n16 > 0 ? (n16 -= n15) : (n16 += n15);
                            }
                            int n17 = n16;
                            n16 = (int)(this.isBeingDragged ? 1 : 0);
                            if (n16 != 0) {
                                this.lastMotionY = n12;
                                int n18 = this.getMaxDragOffset(view);
                                boolean bl2 = false;
                                this.scroll(coordinatorLayout, view, n17, n18, 0);
                            }
                            break block15;
                        }
                        viewConfiguration = this.velocityTracker;
                        if (viewConfiguration != null) {
                            viewConfiguration.addMovement(motionEvent);
                            this.velocityTracker.computeCurrentVelocity(1000);
                            viewConfiguration = this.velocityTracker;
                            int n19 = this.activePointerId;
                            float f13 = viewConfiguration.getYVelocity(n19);
                            n12 = this.getScrollRangeForDragFling(view);
                            int n20 = -n12;
                            this.fling(coordinatorLayout, view, n20, 0, f13);
                        }
                    }
                    this.isBeingDragged = false;
                    this.activePointerId = n14;
                    coordinatorLayout = this.velocityTracker;
                    if (coordinatorLayout != null) {
                        coordinatorLayout.recycle();
                        n13 = 0;
                        coordinatorLayout = null;
                        this.velocityTracker = null;
                    }
                    break block15;
                }
                float f14 = motionEvent.getX();
                n12 = (int)f14;
                int n21 = coordinatorLayout.isPointInChildBounds(view, n12, n11 = (int)(f10 = motionEvent.getY()));
                if (n21 == 0 || (n21 = this.canDragView(view)) == 0) break block16;
                this.lastMotionY = n11;
                this.activePointerId = n21 = motionEvent.getPointerId(0);
                this.ensureVelocityTracker();
            }
            coordinatorLayout = this.velocityTracker;
            if (coordinatorLayout != null) {
                coordinatorLayout.addMovement(motionEvent);
            }
            return n10 != 0;
        }
        return false;
    }

    public final int scroll(CoordinatorLayout coordinatorLayout, View view, int n10, int n11, int n12) {
        int n13 = this.getTopBottomOffsetForScrollingSibling() - n10;
        return this.setHeaderTopBottomOffset(coordinatorLayout, view, n13, n11, n12);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int n10) {
        return this.setHeaderTopBottomOffset(coordinatorLayout, view, n10, -1 << -1, -1 >>> 1);
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int n10, int n11, int n12) {
        int n13;
        int n14 = this.getTopAndBottomOffset();
        if (n11 != 0 && n14 >= n11 && n14 <= n12 && n14 != (n13 = MathUtils.clamp(n10, n11, n12))) {
            this.setTopAndBottomOffset(n13);
            n14 -= n13;
        } else {
            n14 = 0;
        }
        return n14;
    }
}

