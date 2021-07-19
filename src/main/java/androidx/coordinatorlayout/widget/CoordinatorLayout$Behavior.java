/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$BaseSavedState
 */
package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.WindowInsetsCompat;

public abstract class CoordinatorLayout$Behavior {
    public CoordinatorLayout$Behavior() {
    }

    public CoordinatorLayout$Behavior(Context context, AttributeSet attributeSet) {
    }

    public static Object getTag(View view) {
        return ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).mBehaviorTag;
    }

    public static void setTag(View view, Object object) {
        ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).mBehaviorTag = object;
    }

    public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
        float f10 = this.getScrimOpacity(coordinatorLayout, view);
        view = null;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object > 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
            coordinatorLayout = null;
        }
        return (boolean)object;
    }

    public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
        return false;
    }

    public int getScrimColor(CoordinatorLayout coordinatorLayout, View view) {
        return -16777216;
    }

    public float getScrimOpacity(CoordinatorLayout coordinatorLayout, View view) {
        return 0.0f;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View view, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
    }

    public void onDetachedFromLayoutParams() {
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int n10) {
        return false;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int n10, int n11, int n12, int n13) {
        return false;
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f10, float f11, boolean bl2) {
        return false;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f10, float f11) {
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n10, int n11, int[] nArray) {
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n10, int n11, int[] nArray, int n12) {
        if (n12 == 0) {
            this.onNestedPreScroll(coordinatorLayout, view, view2, n10, n11, nArray);
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n10, int n11, int n12, int n13) {
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n10, int n11, int n12, int n13, int n14) {
        if (n14 == 0) {
            this.onNestedScroll(coordinatorLayout, view, view2, n10, n11, n12, n13);
        }
    }

    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n10) {
    }

    public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n10, int n11) {
        if (n11 == 0) {
            this.onNestedScrollAccepted(coordinatorLayout, view, view2, view3, n10);
        }
    }

    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean bl2) {
        return false;
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        return View.BaseSavedState.EMPTY_STATE;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n10) {
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n10, int n11) {
        if (n11 == 0) {
            return this.onStartNestedScroll(coordinatorLayout, view, view2, view3, n10);
        }
        return false;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2) {
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n10) {
        if (n10 == 0) {
            this.onStopNestedScroll(coordinatorLayout, view, view2);
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return false;
    }
}

