/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.animation.Interpolator
 *  android.widget.LinearLayout$LayoutParams
 */
package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior$1;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior$BaseDragCallback;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState;
import com.google.android.material.appbar.AppBarLayout$LayoutParams;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import com.google.android.material.appbar.HeaderBehavior;
import com.google.android.material.appbar.HeaderScrollingViewBehavior;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class AppBarLayout$BaseBehavior
extends HeaderBehavior {
    private static final int INVALID_POSITION = 255;
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    private WeakReference lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    private int offsetDelta;
    private int offsetToChildIndexOnLayout = -1;
    private boolean offsetToChildIndexOnLayoutIsMinHeight;
    private float offsetToChildIndexOnLayoutPerc;
    private AppBarLayout$BaseBehavior$BaseDragCallback onDragCallback;

    public AppBarLayout$BaseBehavior() {
    }

    public AppBarLayout$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ int access$000(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior) {
        return appBarLayout$BaseBehavior.offsetDelta;
    }

    private void animateOffsetTo(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int n10, float f10) {
        int n11;
        int n12 = Math.abs(this.getTopBottomOffsetForScrollingSibling() - n10);
        f10 = Math.abs(f10);
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            object = 1148846080;
            f11 = 1000.0f;
            float f13 = (float)n12 / f10 * f11;
            n11 = Math.round(f13) * 3;
        } else {
            f10 = n12;
            float f14 = appBarLayout.getHeight();
            f10 = f10 / f14 + 1.0f;
            n12 = 1125515264;
            f14 = 150.0f;
            n11 = (int)(f10 *= f14);
        }
        this.animateOffsetWithDuration(coordinatorLayout, appBarLayout, n10, n11);
    }

    private void animateOffsetWithDuration(CoordinatorLayout coordinatorLayout, AppBarLayout object, int n10, int n11) {
        int n12 = this.getTopBottomOffsetForScrollingSibling();
        if (n12 == n10) {
            boolean bl2;
            coordinatorLayout = this.offsetAnimator;
            if (coordinatorLayout != null && (bl2 = coordinatorLayout.isRunning())) {
                coordinatorLayout = this.offsetAnimator;
                coordinatorLayout.cancel();
            }
            return;
        }
        ValueAnimator valueAnimator = this.offsetAnimator;
        if (valueAnimator == null) {
            this.offsetAnimator = valueAnimator = new ValueAnimator();
            Object object2 = AnimationUtils.DECELERATE_INTERPOLATOR;
            valueAnimator.setInterpolator(object2);
            valueAnimator = this.offsetAnimator;
            object2 = new AppBarLayout$BaseBehavior$1(this, coordinatorLayout, (AppBarLayout)((Object)object));
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
        } else {
            valueAnimator.cancel();
        }
        coordinatorLayout = this.offsetAnimator;
        long l10 = Math.min(n11, 600);
        coordinatorLayout.setDuration(l10);
        coordinatorLayout = this.offsetAnimator;
        object = new int[2];
        object[0] = (AppBarLayout)n12;
        object[1] = (AppBarLayout)n10;
        coordinatorLayout.setIntValues((int[])object);
        this.offsetAnimator.start();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean canScrollChildren(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
        int n10;
        boolean bl2 = appBarLayout.hasScrollableChildren();
        if (!bl2) return 0 != 0;
        int n11 = coordinatorLayout.getHeight();
        int n12 = view.getHeight();
        if ((n11 -= n12) > (n10 = appBarLayout.getHeight())) return 0 != 0;
        return 1 != 0;
    }

    private static boolean checkFlag(int n10, int n11) {
        n10 = (n10 &= n11) == n11 ? 1 : 0;
        return n10 != 0;
    }

    private View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
        int n10 = coordinatorLayout.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = coordinatorLayout.getChildAt(i10);
            boolean bl2 = view instanceof NestedScrollingChild;
            if (!bl2) continue;
            return view;
        }
        return null;
    }

    private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int n10) {
        n10 = Math.abs(n10);
        int n11 = appBarLayout.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = appBarLayout.getChildAt(i10);
            int n12 = view.getTop();
            if (n10 < n12 || n10 > (n12 = view.getBottom())) continue;
            return view;
        }
        return null;
    }

    private int getChildIndexOnOffset(AppBarLayout appBarLayout, int n10) {
        int n11 = appBarLayout.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            Object object = appBarLayout.getChildAt(i10);
            int n13 = object.getTop();
            int n14 = object.getBottom();
            object = (AppBarLayout$LayoutParams)object.getLayoutParams();
            int n15 = ((AppBarLayout$LayoutParams)((Object)object)).getScrollFlags();
            int n16 = 32;
            if ((n15 = (int)(AppBarLayout$BaseBehavior.checkFlag(n15, n16) ? 1 : 0)) != 0) {
                n15 = ((LinearLayout.LayoutParams)object).topMargin;
                n13 -= n15;
                n12 = ((LinearLayout.LayoutParams)object).bottomMargin;
                n14 += n12;
            }
            if (n13 > (n12 = -n10) || n14 < n12) continue;
            return i10;
        }
        return -1;
    }

    private int interpolateOffset(AppBarLayout appBarLayout, int n10) {
        int n11 = Math.abs(n10);
        int n12 = appBarLayout.getChildCount();
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n14;
            View view = appBarLayout.getChildAt(i10);
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams)view.getLayoutParams();
            Interpolator interpolator2 = appBarLayout$LayoutParams.getScrollInterpolator();
            int n15 = view.getTop();
            if (n11 < n15 || n11 > (n15 = view.getBottom())) continue;
            if (interpolator2 == null) break;
            n12 = appBarLayout$LayoutParams.getScrollFlags();
            i10 = n12 & 1;
            if (i10 != 0) {
                i10 = view.getHeight();
                n15 = appBarLayout$LayoutParams.topMargin;
                i10 += n15;
                int n16 = appBarLayout$LayoutParams.bottomMargin;
                n13 = 0 + (i10 += n16);
                if ((n12 &= 2) != 0) {
                    n12 = ViewCompat.getMinimumHeight(view);
                    n13 -= n12;
                }
            }
            if ((n12 = (int)(ViewCompat.getFitsSystemWindows(view) ? 1 : 0)) != 0) {
                n14 = appBarLayout.getTopInset();
                n13 -= n14;
            }
            if (n13 <= 0) break;
            n14 = view.getTop();
            float f10 = n13;
            float f11 = (float)(n11 -= n14) / f10;
            f11 = interpolator2.getInterpolation(f11);
            n14 = Math.round(f10 * f11);
            n10 = Integer.signum(n10);
            n11 = view.getTop() + n14;
            return n10 * n11;
        }
        return n10;
    }

    private boolean shouldJumpElevationState(CoordinatorLayout object, AppBarLayout appBarLayout) {
        object = ((CoordinatorLayout)object).getDependents((View)appBarLayout);
        int n10 = object.size();
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            CoordinatorLayout$Behavior coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)((View)object.get(i10)).getLayoutParams()).getBehavior();
            boolean bl3 = coordinatorLayout$Behavior instanceof AppBarLayout$ScrollingViewBehavior;
            if (!bl3) continue;
            int n11 = ((HeaderScrollingViewBehavior)(coordinatorLayout$Behavior = (AppBarLayout$ScrollingViewBehavior)coordinatorLayout$Behavior)).getOverlayTop();
            if (n11 != 0) {
                bl2 = true;
            }
            return bl2;
        }
        return false;
    }

    private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        int n10;
        View view;
        AppBarLayout$LayoutParams appBarLayout$LayoutParams;
        int n11;
        int n12;
        int n13 = this.getTopBottomOffsetForScrollingSibling();
        int n14 = this.getChildIndexOnOffset(appBarLayout, n13);
        if (n14 >= 0 && (n12 = (n11 = (appBarLayout$LayoutParams = (AppBarLayout$LayoutParams)(view = appBarLayout.getChildAt(n14)).getLayoutParams()).getScrollFlags()) & 0x11) == (n10 = 17)) {
            int n15;
            n12 = -view.getTop();
            n10 = -view.getBottom();
            int n16 = appBarLayout.getChildCount() + -1;
            if (n14 == n16) {
                n14 = appBarLayout.getTopInset();
                n10 += n14;
            }
            if ((n16 = (int)(AppBarLayout$BaseBehavior.checkFlag(n11, n14 = 2) ? 1 : 0)) != 0) {
                n15 = ViewCompat.getMinimumHeight(view);
                n10 += n15;
            } else {
                n16 = (int)(AppBarLayout$BaseBehavior.checkFlag(n11, 5) ? 1 : 0);
                if (n16 != 0) {
                    n15 = ViewCompat.getMinimumHeight(view) + n10;
                    if (n13 < n15) {
                        n12 = n15;
                    } else {
                        n10 = n15;
                    }
                }
            }
            n15 = (int)(AppBarLayout$BaseBehavior.checkFlag(n11, 32) ? 1 : 0);
            if (n15 != 0) {
                n15 = appBarLayout$LayoutParams.topMargin;
                n12 += n15;
                n15 = appBarLayout$LayoutParams.bottomMargin;
                n10 -= n15;
            }
            if (n13 < (n15 = (n10 + n12) / n14)) {
                n12 = n10;
            }
            n13 = -appBarLayout.getTotalScrollRange();
            n13 = MathUtils.clamp(n12, n13, 0);
            n14 = 0;
            this.animateOffsetTo(coordinatorLayout, appBarLayout, n13, 0.0f);
        }
    }

    private void stopNestedScrollIfNeeded(int n10, AppBarLayout appBarLayout, View view, int n11) {
        int n12 = 1;
        if (n11 == n12) {
            n11 = this.getTopBottomOffsetForScrollingSibling();
            if (n10 < 0 && n11 == 0 || n10 > 0 && n11 == (n10 = -appBarLayout.getDownNestedScrollRange())) {
                ViewCompat.stopNestedScroll(view, n12);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private void updateAppBarLayoutDrawableState(CoordinatorLayout var1_1, AppBarLayout var2_2, int var3_3, int var4_4, boolean var5_5) {
        var6_6 = AppBarLayout$BaseBehavior.getAppBarChildOnOffset(var2_2, var3_3);
        if (var6_6 != null) {
            block10: {
                var7_7 = (AppBarLayout$LayoutParams)var6_6.getLayoutParams();
                var8_8 = var7_7.getScrollFlags();
                var9_9 = var8_8 & 1;
                var10_10 = 1;
                if (var9_9 != 0) {
                    var9_9 = ViewCompat.getMinimumHeight(var6_6);
                    if (var4_4 > 0 && (var4_4 = var8_8 & 12) != 0) {
                        var3_3 = -var3_3;
                        var4_4 = var6_6.getBottom() - var9_9;
                        var11_11 = var2_2.getTopInset();
                        if (var3_3 >= (var4_4 -= var11_11)) {
                            while (true) {
                                var3_3 = var10_10;
                                break block10;
                                break;
                            }
                        }
                    } else {
                        var4_4 = var8_8 & 2;
                        if (var4_4 != 0) {
                            var3_3 = -var3_3;
                            var4_4 = var6_6.getBottom() - var9_9;
                            if (var3_3 >= (var4_4 -= (var11_11 = var2_2.getTopInset()))) ** continue;
                        }
                    }
                }
                var3_3 = 0;
            }
            var4_4 = (int)var2_2.isLiftOnScroll();
            if (var4_4 != 0 && (var12_12 = this.findFirstScrollingChild(var1_1)) != null) {
                var3_3 = var12_12.getScrollY();
                if (var3_3 <= 0) {
                    var10_10 = 0;
                }
                var3_3 = var10_10;
            }
            var3_3 = (int)var2_2.setLiftedState((boolean)var3_3);
            var4_4 = Build.VERSION.SDK_INT;
            var11_11 = 11;
            if (var4_4 >= var11_11 && (var5_5 || var3_3 != 0 && (var13_13 = this.shouldJumpElevationState(var1_1, var2_2)))) {
                var2_2.jumpDrawablesToCurrentState();
            }
        }
    }

    public boolean canDragView(AppBarLayout object) {
        boolean bl2;
        int n10;
        AppBarLayout$BaseBehavior$BaseDragCallback appBarLayout$BaseBehavior$BaseDragCallback = this.onDragCallback;
        if (appBarLayout$BaseBehavior$BaseDragCallback != null) {
            return appBarLayout$BaseBehavior$BaseDragCallback.canDrag((AppBarLayout)((Object)object));
        }
        object = this.lastNestedScrollingChildRef;
        boolean bl3 = true;
        if (object != null && ((object = (View)((Reference)object).get()) == null || (n10 = object.isShown()) == 0 || (bl2 = object.canScrollVertically(n10 = -1)))) {
            bl3 = false;
            appBarLayout$BaseBehavior$BaseDragCallback = null;
        }
        return bl3;
    }

    public int getMaxDragOffset(AppBarLayout appBarLayout) {
        return -appBarLayout.getDownNestedScrollRange();
    }

    public int getScrollRangeForDragFling(AppBarLayout appBarLayout) {
        return appBarLayout.getTotalScrollRange();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        int n10 = this.getTopAndBottomOffset();
        int n11 = this.offsetDelta;
        return n10 + n11;
    }

    public boolean isOffsetAnimatorRunning() {
        boolean bl2;
        ValueAnimator valueAnimator = this.offsetAnimator;
        if (valueAnimator != null && (bl2 = valueAnimator.isRunning())) {
            bl2 = true;
        } else {
            bl2 = false;
            valueAnimator = null;
        }
        return bl2;
    }

    public void onFlingFinished(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.snapToChildIfNeeded(coordinatorLayout, appBarLayout);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int n10) {
        int n11;
        int n12;
        n10 = (int)(super.onLayoutChild(coordinatorLayout, (View)appBarLayout, n10) ? 1 : 0);
        int n13 = appBarLayout.getPendingAction();
        int n14 = this.offsetToChildIndexOnLayout;
        if (n14 >= 0 && (n12 = n13 & 8) == 0) {
            View view = appBarLayout.getChildAt(n14);
            n14 = -view.getBottom();
            n12 = (int)(this.offsetToChildIndexOnLayoutIsMinHeight ? 1 : 0);
            if (n12 != 0) {
                n13 = ViewCompat.getMinimumHeight(view);
                n12 = appBarLayout.getTopInset();
                n13 += n12;
            } else {
                float f10 = view.getHeight();
                float f11 = this.offsetToChildIndexOnLayoutPerc;
                n13 = Math.round(f10 *= f11);
            }
            this.setHeaderTopBottomOffset(coordinatorLayout, (View)appBarLayout, n14 += n13);
        } else if (n13 != 0) {
            n14 = n13 & 4;
            n12 = 1;
            float f12 = Float.MIN_VALUE;
            n14 = n14 != 0 ? n12 : 0;
            n11 = n13 & 2;
            if (n11 != 0) {
                n13 = -appBarLayout.getUpNestedPreScrollRange();
                if (n14 != 0) {
                    this.animateOffsetTo(coordinatorLayout, appBarLayout, n13, 0.0f);
                } else {
                    this.setHeaderTopBottomOffset(coordinatorLayout, (View)appBarLayout, n13);
                }
            } else if ((n13 &= n12) != 0) {
                if (n14 != 0) {
                    this.animateOffsetTo(coordinatorLayout, appBarLayout, 0, 0.0f);
                } else {
                    this.setHeaderTopBottomOffset(coordinatorLayout, (View)appBarLayout, 0);
                }
            }
        }
        appBarLayout.resetPendingAction();
        this.offsetToChildIndexOnLayout = -1;
        n13 = this.getTopAndBottomOffset();
        n14 = -appBarLayout.getTotalScrollRange();
        n13 = MathUtils.clamp(n13, n14, 0);
        this.setTopAndBottomOffset(n13);
        n11 = this.getTopAndBottomOffset();
        this.updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, n11, 0, true);
        int n15 = this.getTopAndBottomOffset();
        appBarLayout.dispatchOffsetUpdates(n15);
        return n10 != 0;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int n10, int n11, int n12, int n13) {
        Object object = (CoordinatorLayout$LayoutParams)appBarLayout.getLayoutParams();
        int n14 = object.height;
        int n15 = -2;
        if (n14 == n15) {
            int n16 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            object = coordinatorLayout;
            coordinatorLayout.onMeasureChild((View)appBarLayout, n10, n11, n16, n13);
            return true;
        }
        return super.onMeasureChild(coordinatorLayout, (View)appBarLayout, n10, n11, n12, n13);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int n10, int n11, int[] nArray, int n12) {
        if (n11 != 0) {
            int n13;
            if (n11 < 0) {
                n10 = -appBarLayout.getTotalScrollRange();
                n13 = appBarLayout.getDownNestedPreScrollRange() + n10;
            } else {
                n10 = -appBarLayout.getUpNestedPreScrollRange();
                n13 = 0;
            }
            int n14 = n10;
            if (n10 != n13) {
                int n15;
                n10 = 1;
                nArray[n10] = n15 = this.scroll(coordinatorLayout, (View)appBarLayout, n11, n14, n13);
                this.stopNestedScrollIfNeeded(n11, appBarLayout, view, n12);
            }
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int n10, int n11, int n12, int n13, int n14) {
        int n15;
        if (n13 < 0) {
            n10 = appBarLayout.getDownNestedScrollRange();
            int n16 = -n10;
            this.scroll(coordinatorLayout, (View)appBarLayout, n13, n16, 0);
            this.stopNestedScrollIfNeeded(n13, appBarLayout, view, n14);
        }
        if (n15 = appBarLayout.isLiftOnScroll()) {
            n15 = view.getScrollY();
            if (n15 > 0) {
                n15 = 1;
            } else {
                n15 = 0;
                coordinatorLayout = null;
            }
            appBarLayout.setLiftedState(n15 != 0);
        }
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
        boolean bl2 = parcelable instanceof AppBarLayout$BaseBehavior$SavedState;
        if (bl2) {
            float f10;
            int n10;
            parcelable = (AppBarLayout$BaseBehavior$SavedState)parcelable;
            Parcelable parcelable2 = parcelable.getSuperState();
            super.onRestoreInstanceState(coordinatorLayout, (View)appBarLayout, parcelable2);
            this.offsetToChildIndexOnLayout = n10 = parcelable.firstVisibleChildIndex;
            this.offsetToChildIndexOnLayoutPerc = f10 = parcelable.firstVisibleChildPercentageShown;
            n10 = (int)(parcelable.firstVisibleChildAtMinimumHeight ? 1 : 0);
            this.offsetToChildIndexOnLayoutIsMinHeight = n10;
        } else {
            super.onRestoreInstanceState(coordinatorLayout, (View)appBarLayout, parcelable);
            int n11 = -1;
            float f11 = 0.0f / 0.0f;
            this.offsetToChildIndexOnLayout = n11;
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        coordinatorLayout = super.onSaveInstanceState(coordinatorLayout, (View)appBarLayout);
        int n10 = this.getTopAndBottomOffset();
        int n11 = appBarLayout.getChildCount();
        boolean bl2 = false;
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = appBarLayout.getChildAt(i10);
            int n12 = view.getBottom() + n10;
            int n13 = view.getTop() + n10;
            if (n13 > 0 || n12 < 0) continue;
            AppBarLayout$BaseBehavior$SavedState appBarLayout$BaseBehavior$SavedState = new AppBarLayout$BaseBehavior$SavedState((Parcelable)coordinatorLayout);
            appBarLayout$BaseBehavior$SavedState.firstVisibleChildIndex = i10;
            int n14 = ViewCompat.getMinimumHeight(view);
            int n15 = appBarLayout.getTopInset();
            if (n12 == (n14 += n15)) {
                bl2 = true;
            }
            appBarLayout$BaseBehavior$SavedState.firstVisibleChildAtMinimumHeight = bl2;
            float f10 = n12;
            float f11 = view.getHeight();
            appBarLayout$BaseBehavior$SavedState.firstVisibleChildPercentageShown = f10 /= f11;
            return appBarLayout$BaseBehavior$SavedState;
        }
        return coordinatorLayout;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int n10, int n11) {
        boolean bl2;
        int n12 = n10 & 2;
        if (n12 != 0 && ((n12 = (int)(appBarLayout.isLiftOnScroll() ? 1 : 0)) != 0 || (bl2 = this.canScrollChildren(coordinatorLayout, appBarLayout, view)))) {
            bl2 = true;
        } else {
            bl2 = false;
            coordinatorLayout = null;
        }
        if (bl2 && (appBarLayout = this.offsetAnimator) != null) {
            appBarLayout.cancel();
        }
        this.lastNestedScrollingChildRef = null;
        this.lastStartedType = n11;
        return bl2;
    }

    public void onStopNestedScroll(CoordinatorLayout weakReference, AppBarLayout appBarLayout, View view, int n10) {
        int n11 = this.lastStartedType;
        if (n11 == 0 || n10 == (n11 = 1)) {
            this.snapToChildIfNeeded((CoordinatorLayout)((Object)weakReference), appBarLayout);
        }
        this.lastNestedScrollingChildRef = weakReference = new WeakReference<View>(view);
    }

    public void setDragCallback(AppBarLayout$BaseBehavior$BaseDragCallback appBarLayout$BaseBehavior$BaseDragCallback) {
        this.onDragCallback = appBarLayout$BaseBehavior$BaseDragCallback;
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int n10, int n11, int n12) {
        int n13 = this.getTopBottomOffsetForScrollingSibling();
        int n14 = 0;
        if (n11 != 0 && n13 >= n11 && n13 <= n12) {
            int n15 = MathUtils.clamp(n10, n11, n12);
            if (n13 != n15) {
                n10 = (int)(appBarLayout.hasChildWithInterpolator() ? 1 : 0);
                n10 = n10 != 0 ? this.interpolateOffset(appBarLayout, n15) : n15;
                n11 = (int)(this.setTopAndBottomOffset(n10) ? 1 : 0);
                n14 = n13 - n15;
                this.offsetDelta = n10 = n15 - n10;
                if (n11 == 0 && (n10 = (int)(appBarLayout.hasChildWithInterpolator() ? 1 : 0)) != 0) {
                    coordinatorLayout.dispatchDependentViewsChanged((View)appBarLayout);
                }
                n10 = this.getTopAndBottomOffset();
                appBarLayout.dispatchOffsetUpdates(n10);
                n10 = n15 < n13 ? -1 : 1;
                this.updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, n15, n10, false);
            }
        } else {
            this.offsetDelta = 0;
        }
        return n14;
    }
}

