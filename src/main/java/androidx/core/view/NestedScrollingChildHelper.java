/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;

public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int n10, int n11, int n12, int n13, int[] nArray, int n14, int[] nArray2) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this;
        int[] nArray3 = nArray;
        int n15 = this.isNestedScrollingEnabled();
        if (n15 != 0) {
            n15 = n14;
            ViewParent viewParent = this.getNestedScrollingParentForType(n14);
            if (viewParent == null) {
                return false;
            }
            int n16 = 1;
            if (n10 == 0 && n11 == 0 && n12 == 0 && n13 == 0) {
                if (nArray != null) {
                    nArray[0] = 0;
                    nArray[n16] = 0;
                }
            } else {
                Object object;
                int n17;
                int n18;
                int n19;
                Object object2;
                if (nArray3 != null) {
                    object2 = nestedScrollingChildHelper.mView;
                    object2.getLocationInWindow(nArray3);
                    int n20 = nArray3[0];
                    n19 = nArray3[n16];
                    n18 = n20;
                    n17 = n19;
                } else {
                    n18 = 0;
                    n17 = 0;
                }
                if (nArray2 == null) {
                    object2 = this.getTempNestedScrollConsumed();
                    object2[0] = (View)false;
                    object2[n16] = (View)false;
                    object = object2;
                } else {
                    object = nArray2;
                }
                object2 = nestedScrollingChildHelper.mView;
                n19 = n10;
                ViewParentCompat.onNestedScroll(viewParent, object2, n10, n11, n12, n13, n14, object);
                if (nArray3 != null) {
                    View view = nestedScrollingChildHelper.mView;
                    view.getLocationInWindow(nArray3);
                    nArray3[0] = n15 = nArray3[0] - n18;
                    nArray3[n16] = n15 = nArray3[n16] - n17;
                }
                return n16 != 0;
            }
        }
        return false;
    }

    private ViewParent getNestedScrollingParentForType(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return null;
            }
            return this.mNestedScrollingParentNonTouch;
        }
        return this.mNestedScrollingParentTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        int[] nArray = this.mTempNestedScrollConsumed;
        if (nArray == null) {
            int n10 = 2;
            this.mTempNestedScrollConsumed = nArray = new int[n10];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int n10, ViewParent viewParent) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                this.mNestedScrollingParentNonTouch = viewParent;
            }
        } else {
            this.mNestedScrollingParentTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean bl2) {
        ViewParent viewParent;
        boolean bl3 = this.isNestedScrollingEnabled();
        View view = null;
        if (bl3 && (viewParent = this.getNestedScrollingParentForType(0)) != null) {
            view = this.mView;
            return ViewParentCompat.onNestedFling(viewParent, view, f10, f11, bl2);
        }
        return false;
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        ViewParent viewParent;
        boolean bl2 = this.isNestedScrollingEnabled();
        View view = null;
        if (bl2 && (viewParent = this.getNestedScrollingParentForType(0)) != null) {
            view = this.mView;
            return ViewParentCompat.onNestedPreFling(viewParent, view, f10, f11);
        }
        return false;
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2) {
        return this.dispatchNestedPreScroll(n10, n11, nArray, nArray2, 0);
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2, int n12) {
        boolean n13 = this.isNestedScrollingEnabled();
        int n14 = 0;
        if (n13) {
            ViewParent viewParent = this.getNestedScrollingParentForType(n12);
            if (viewParent == null) {
                return false;
            }
            int n15 = 1;
            if (n10 == 0 && n11 == 0) {
                if (nArray2 != null) {
                    nArray2[0] = 0;
                    nArray2[n15] = 0;
                }
            } else {
                int n16;
                int n17;
                int n18;
                View view;
                if (nArray2 != null) {
                    view = this.mView;
                    view.getLocationInWindow(nArray2);
                    int n19 = nArray2[0];
                    n18 = nArray2[n15];
                    n17 = n19;
                    n16 = n18;
                } else {
                    n17 = 0;
                    n16 = 0;
                }
                if (nArray == null) {
                    nArray = this.getTempNestedScrollConsumed();
                }
                nArray[0] = 0;
                nArray[n15] = 0;
                view = this.mView;
                n18 = n10;
                ViewParentCompat.onNestedPreScroll(viewParent, view, n10, n11, nArray, n12);
                if (nArray2 != null) {
                    View view2 = this.mView;
                    view2.getLocationInWindow(nArray2);
                    nArray2[0] = n10 = nArray2[0] - n17;
                    nArray2[n15] = n10 = nArray2[n15] - n16;
                }
                if ((n10 = nArray[0]) != 0 || (n10 = nArray[n15]) != 0) {
                    n14 = n15;
                }
            }
        }
        return n14 != 0;
    }

    public void dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray, int n14, int[] nArray2) {
        this.dispatchNestedScrollInternal(n10, n11, n12, n13, nArray, n14, nArray2);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray) {
        return this.dispatchNestedScrollInternal(n10, n11, n12, n13, nArray, 0, null);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray, int n14) {
        return this.dispatchNestedScrollInternal(n10, n11, n12, n13, nArray, n14, null);
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int n10) {
        ViewParent viewParent = this.getNestedScrollingParentForType(n10);
        if (viewParent != null) {
            n10 = 1;
        } else {
            n10 = 0;
            viewParent = null;
        }
        return n10 != 0;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        boolean bl3 = this.mIsNestedScrollingEnabled;
        if (bl3) {
            View view = this.mView;
            ViewCompat.stopNestedScroll(view);
        }
        this.mIsNestedScrollingEnabled = bl2;
    }

    public boolean startNestedScroll(int n10) {
        return this.startNestedScroll(n10, 0);
    }

    public boolean startNestedScroll(int n10, int n11) {
        boolean bl2 = this.hasNestedScrollingParent(n11);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        bl2 = this.isNestedScrollingEnabled();
        if (bl2) {
            View view = this.mView;
            for (ViewParent viewParent = this.mView.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
                View view2 = this.mView;
                boolean bl4 = ViewParentCompat.onStartNestedScroll(viewParent, view, view2, n10, n11);
                if (bl4) {
                    this.setNestedScrollingParentForType(n11, viewParent);
                    view2 = this.mView;
                    ViewParentCompat.onNestedScrollAccepted(viewParent, view, view2, n10, n11);
                    return bl3;
                }
                bl4 = viewParent instanceof View;
                if (!bl4) continue;
                view = viewParent;
                view = (View)viewParent;
            }
        }
        return false;
    }

    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }

    public void stopNestedScroll(int n10) {
        ViewParent viewParent = this.getNestedScrollingParentForType(n10);
        if (viewParent != null) {
            View view = this.mView;
            ViewParentCompat.onStopNestedScroll(viewParent, view, n10);
            viewParent = null;
            this.setNestedScrollingParentForType(n10, null);
        }
    }
}

