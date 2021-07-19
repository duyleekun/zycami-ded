/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper$Callback;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener;
import com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable;

public class SwipeDismissBehavior$1
extends ViewDragHelper$Callback {
    private static final int INVALID_POINTER_ID = 255;
    private int activePointerId = -1;
    private int originalCapturedViewLeft;
    public final /* synthetic */ SwipeDismissBehavior this$0;

    public SwipeDismissBehavior$1(SwipeDismissBehavior swipeDismissBehavior) {
        this.this$0 = swipeDismissBehavior;
    }

    private boolean shouldDismiss(View view, float f10) {
        int n10 = 0;
        float f11 = 0.0f;
        SwipeDismissBehavior swipeDismissBehavior = null;
        float f12 = f10 - 0.0f;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        int n11 = 0;
        int n12 = 1;
        float f14 = Float.MIN_VALUE;
        if (f13 != false) {
            float f15;
            int n13 = ViewCompat.getLayoutDirection(view);
            if (n13 == n12) {
                n13 = n12;
                float f16 = f14;
            } else {
                n13 = 0;
                view = null;
                float f17 = 0.0f;
            }
            SwipeDismissBehavior swipeDismissBehavior2 = this.this$0;
            int n14 = swipeDismissBehavior2.swipeDirection;
            int n15 = 2;
            if (n14 == n15) {
                return n12 != 0;
            }
            if (!n14) {
                float f18;
                if (n13 != 0 ? (n13 = (int)((f18 = f10 - 0.0f) == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1))) < 0 : f13 > 0) {
                    n11 = n12;
                }
                return n11 != 0;
            }
            if (n14 == n12 && (n13 != 0 ? f13 > 0 : (n13 = (int)((f15 = f10 - 0.0f) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1))) < 0)) {
                n11 = n12;
            }
            return n11 != 0;
        }
        int n16 = view.getLeft();
        n10 = this.originalCapturedViewLeft;
        n16 -= n10;
        float f19 = view.getWidth();
        swipeDismissBehavior = this.this$0;
        f11 = swipeDismissBehavior.dragDismissThreshold;
        int n17 = Math.round(f19 *= f11);
        if ((n16 = Math.abs(n16)) >= n17) {
            n11 = n12;
        }
        return n11 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int clampViewPositionHorizontal(View view, int n10, int n11) {
        int n12;
        int n13;
        n11 = ViewCompat.getLayoutDirection(view);
        n11 = n11 == (n13 = 1) ? n13 : 0;
        SwipeDismissBehavior swipeDismissBehavior = this.this$0;
        int n14 = swipeDismissBehavior.swipeDirection;
        if (n14 == 0) {
            if (n11 != 0) {
                n11 = this.originalCapturedViewLeft;
                n12 = view.getWidth();
                n11 -= n12;
                n12 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp(n11, n10, n12);
            }
            n11 = this.originalCapturedViewLeft;
            n12 = view.getWidth();
            return SwipeDismissBehavior.clamp(n11, n10, n12 += n11);
        } else {
            if (n14 != n13) {
                n11 = this.originalCapturedViewLeft;
                n13 = view.getWidth();
                n11 -= n13;
                n13 = this.originalCapturedViewLeft;
                n12 = view.getWidth() + n13;
                return SwipeDismissBehavior.clamp(n11, n10, n12);
            }
            if (n11 == 0) {
                n11 = this.originalCapturedViewLeft;
                n12 = view.getWidth();
                n11 -= n12;
                n12 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp(n11, n10, n12);
            }
            n11 = this.originalCapturedViewLeft;
            n12 = view.getWidth();
        }
        return SwipeDismissBehavior.clamp(n11, n10, n12 += n11);
    }

    public int clampViewPositionVertical(View view, int n10, int n11) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        return view.getWidth();
    }

    public void onViewCaptured(View view, int n10) {
        this.activePointerId = n10;
        this.originalCapturedViewLeft = n10 = view.getLeft();
        if ((view = view.getParent()) != null) {
            n10 = 1;
            view.requestDisallowInterceptTouchEvent(n10 != 0);
        }
    }

    public void onViewDragStateChanged(int n10) {
        SwipeDismissBehavior$OnDismissListener swipeDismissBehavior$OnDismissListener = this.this$0.listener;
        if (swipeDismissBehavior$OnDismissListener != null) {
            swipeDismissBehavior$OnDismissListener.onDragStateChanged(n10);
        }
    }

    public void onViewPositionChanged(View view, int n10, int n11, int n12, int n13) {
        n11 = this.originalCapturedViewLeft;
        float f10 = n11;
        float f11 = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.this$0;
        float f12 = swipeDismissBehavior.alphaStartSwipeDistance;
        f10 += (f11 *= f12);
        n12 = this.originalCapturedViewLeft;
        f11 = n12;
        f12 = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior2 = this.this$0;
        float f13 = swipeDismissBehavior2.alphaEndSwipeDistance;
        f11 += (f12 *= f13);
        float f14 = n10;
        n13 = (int)(f14 == f10 ? 0 : (f14 < f10 ? -1 : 1));
        f13 = 1.0f;
        if (n13 <= 0) {
            view.setAlpha(f13);
        } else {
            n13 = (int)(f14 == f11 ? 0 : (f14 > f11 ? 1 : -1));
            if (n13 >= 0) {
                view.setAlpha(0.0f);
            } else {
                f14 = SwipeDismissBehavior.fraction(f10, f11, f14);
                f14 = f13 - f14;
                f14 = SwipeDismissBehavior.clamp(0.0f, f14, f13);
                view.setAlpha(f14);
            }
        }
    }

    public void onViewReleased(View view, float f10, float f11) {
        SwipeDismissBehavior$OnDismissListener swipeDismissBehavior$OnDismissListener;
        int n10;
        this.activePointerId = -1;
        int n11 = view.getWidth();
        int n12 = this.shouldDismiss(view, f10);
        if (n12) {
            n12 = view.getLeft();
            n10 = n12 < (n10 = this.originalCapturedViewLeft) ? (n10 -= n11) : (n10 += n11);
            n12 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = this.originalCapturedViewLeft;
            n12 = 0;
            f10 = 0.0f;
            swipeDismissBehavior$OnDismissListener = null;
        }
        Object object = this.this$0.viewDragHelper;
        int n13 = view.getTop();
        n11 = (int)(((ViewDragHelper)object).settleCapturedViewAt(n10, n13) ? 1 : 0);
        if (n11 != 0) {
            SwipeDismissBehavior swipeDismissBehavior = this.this$0;
            object = new SwipeDismissBehavior$SettleRunnable(swipeDismissBehavior, view, n12 != 0);
            ViewCompat.postOnAnimation(view, (Runnable)object);
        } else if (n12 && (swipeDismissBehavior$OnDismissListener = this.this$0.listener) != null) {
            swipeDismissBehavior$OnDismissListener.onDismiss(view);
        }
    }

    public boolean tryCaptureView(View view, int n10) {
        SwipeDismissBehavior swipeDismissBehavior;
        boolean bl2;
        n10 = this.activePointerId;
        int n11 = -1;
        if (n10 == n11 && (bl2 = (swipeDismissBehavior = this.this$0).canSwipeDismissView(view))) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }
}

