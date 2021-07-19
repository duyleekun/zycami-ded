/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.drawerlayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.DrawerLayout$LayoutParams;
import androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback$1;

public class DrawerLayout$ViewDragCallback
extends ViewDragHelper$Callback {
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable;
    public final /* synthetic */ DrawerLayout this$0;

    public DrawerLayout$ViewDragCallback(DrawerLayout object, int n10) {
        this.this$0 = object;
        this.mPeekRunnable = object = new DrawerLayout$ViewDragCallback$1(this);
        this.mAbsGravity = n10;
    }

    private void closeOtherDrawer() {
        View view;
        int n10 = this.mAbsGravity;
        int n11 = 3;
        if (n10 == n11) {
            n11 = 5;
        }
        if ((view = this.this$0.findDrawerWithGravity(n11)) != null) {
            DrawerLayout drawerLayout = this.this$0;
            drawerLayout.closeDrawer(view);
        }
    }

    public int clampViewPositionHorizontal(View view, int n10, int n11) {
        DrawerLayout drawerLayout = this.this$0;
        int n12 = 3;
        n11 = (int)(drawerLayout.checkDrawerViewAbsoluteGravity(view, n12) ? 1 : 0);
        if (n11 != 0) {
            int n13 = -view.getWidth();
            n10 = Math.min(n10, 0);
            return Math.max(n13, n10);
        }
        n11 = this.this$0.getWidth();
        int n14 = view.getWidth();
        n14 = n11 - n14;
        n10 = Math.min(n10, n11);
        return Math.max(n14, n10);
    }

    public int clampViewPositionVertical(View view, int n10, int n11) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        int n10;
        DrawerLayout drawerLayout = this.this$0;
        boolean bl2 = drawerLayout.isDrawerView(view);
        if (bl2) {
            n10 = view.getWidth();
        } else {
            n10 = 0;
            view = null;
        }
        return n10;
    }

    public void onEdgeDragStarted(int n10, int n11) {
        Object object;
        DrawerLayout drawerLayout;
        int n12 = 1;
        if ((n10 &= n12) == n12) {
            drawerLayout = this.this$0;
            n12 = 3;
            drawerLayout = drawerLayout.findDrawerWithGravity(n12);
        } else {
            drawerLayout = this.this$0;
            n12 = 5;
            drawerLayout = drawerLayout.findDrawerWithGravity(n12);
        }
        if (drawerLayout != null && (n12 = ((DrawerLayout)(object = this.this$0)).getDrawerLockMode((View)drawerLayout)) == 0) {
            object = this.mDragger;
            ((ViewDragHelper)object).captureChildView((View)drawerLayout, n11);
        }
    }

    public boolean onEdgeLock(int n10) {
        return false;
    }

    public void onEdgeTouched(int n10, int n11) {
        DrawerLayout drawerLayout = this.this$0;
        Runnable runnable = this.mPeekRunnable;
        drawerLayout.postDelayed(runnable, 160L);
    }

    public void onViewCaptured(View view, int n10) {
        ((DrawerLayout$LayoutParams)view.getLayoutParams()).isPeeking = false;
        this.closeOtherDrawer();
    }

    public void onViewDragStateChanged(int n10) {
        DrawerLayout drawerLayout = this.this$0;
        View view = this.mDragger.getCapturedView();
        drawerLayout.updateDrawerState(n10, view);
    }

    public void onViewPositionChanged(View view, int n10, int n11, int n12, int n13) {
        float f10;
        n11 = view.getWidth();
        DrawerLayout drawerLayout = this.this$0;
        n13 = 3;
        n12 = (int)(drawerLayout.checkDrawerViewAbsoluteGravity(view, n13) ? 1 : 0);
        if (n12 != 0) {
            f10 = n10 += n11;
        } else {
            drawerLayout = this.this$0;
            n12 = drawerLayout.getWidth() - n10;
            f10 = n12;
        }
        float f11 = n11;
        this.this$0.setDrawerViewOffset(view, f10 /= f11);
        n11 = 0;
        f11 = 0.0f;
        float f12 = f10 - 0.0f;
        n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
        if (n10 == 0) {
            n10 = 4;
            f10 = 5.6E-45f;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        view.setVisibility(n10);
        this.this$0.invalidate();
    }

    public void onViewReleased(View view, float f10, float f11) {
        Object object;
        Object object2 = this.this$0;
        f11 = ((DrawerLayout)object2).getDrawerViewOffset(view);
        int n10 = view.getWidth();
        DrawerLayout drawerLayout = this.this$0;
        int n11 = drawerLayout.checkDrawerViewAbsoluteGravity(view, 3);
        float f12 = 0.5f;
        if (n11 != 0) {
            float f13 = f10 - 0.0f;
            object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object <= 0 && (object != false || (object = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1)) <= 0)) {
                object = -n10;
            } else {
                object = false;
                f10 = 0.0f;
            }
        } else {
            float f14;
            drawerLayout = this.this$0;
            n11 = drawerLayout.getWidth();
            float f15 = f10 - 0.0f;
            Object object3 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (object3 < 0 || (object = (f14 = f10 - 0.0f) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) == false && (object = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1)) > 0) {
                n11 -= n10;
            }
            object = n11;
        }
        object2 = this.mDragger;
        int n12 = view.getTop();
        ((ViewDragHelper)object2).settleCapturedViewAt((int)object, n12);
        this.this$0.invalidate();
    }

    public void peekDrawer() {
        View view;
        ViewDragHelper viewDragHelper;
        Object object = this.mDragger;
        int n10 = ((ViewDragHelper)object).getEdgeSize();
        int n11 = this.mAbsGravity;
        int n12 = 1;
        int n13 = 0;
        DrawerLayout drawerLayout = null;
        int n14 = 3;
        if (n11 == n14) {
            n11 = n12;
        } else {
            n11 = 0;
            viewDragHelper = null;
        }
        if (n11 != 0) {
            DrawerLayout drawerLayout2 = this.this$0;
            view = drawerLayout2.findDrawerWithGravity(n14);
            if (view != null) {
                n13 = -view.getWidth();
            }
            n13 += n10;
        } else {
            drawerLayout = this.this$0;
            n14 = 5;
            view = drawerLayout.findDrawerWithGravity(n14);
            drawerLayout = this.this$0;
            n13 = drawerLayout.getWidth() - n10;
        }
        if (view != null && (n11 != 0 && (n10 = view.getLeft()) < n13 || n11 == 0 && (n10 = view.getLeft()) > n13) && (n10 = ((DrawerLayout)(object = this.this$0)).getDrawerLockMode(view)) == 0) {
            object = (DrawerLayout$LayoutParams)view.getLayoutParams();
            viewDragHelper = this.mDragger;
            int n15 = view.getTop();
            viewDragHelper.smoothSlideViewTo(view, n13, n15);
            ((DrawerLayout$LayoutParams)object).isPeeking = n12;
            this.this$0.invalidate();
            this.closeOtherDrawer();
            object = this.this$0;
            ((DrawerLayout)object).cancelChildViewTouch();
        }
    }

    public void removeCallbacks() {
        DrawerLayout drawerLayout = this.this$0;
        Runnable runnable = this.mPeekRunnable;
        drawerLayout.removeCallbacks(runnable);
    }

    public void setDragger(ViewDragHelper viewDragHelper) {
        this.mDragger = viewDragHelper;
    }

    public boolean tryCaptureView(View view, int n10) {
        int n11;
        int n12;
        DrawerLayout drawerLayout = this.this$0;
        n10 = (int)(drawerLayout.isDrawerView(view) ? 1 : 0);
        if (n10 != 0 && (n10 = (int)((drawerLayout = this.this$0).checkDrawerViewAbsoluteGravity(view, n12 = this.mAbsGravity) ? 1 : 0)) != 0 && (n11 = (drawerLayout = this.this$0).getDrawerLockMode(view)) == 0) {
            n11 = 1;
        } else {
            n11 = 0;
            view = null;
        }
        return n11 != 0;
    }
}

