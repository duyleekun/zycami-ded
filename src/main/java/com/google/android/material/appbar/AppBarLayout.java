/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.Interpolator
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout$1;
import com.google.android.material.appbar.AppBarLayout$BaseOnOffsetChangedListener;
import com.google.android.material.appbar.AppBarLayout$LayoutParams;
import com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener;
import com.google.android.material.appbar.ViewUtilsLollipop;
import com.google.android.material.internal.ThemeEnforcement;
import java.util.List;

public class AppBarLayout
extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = 255;
    public static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    public static final int PENDING_ACTION_COLLAPSED = 2;
    public static final int PENDING_ACTION_EXPANDED = 1;
    public static final int PENDING_ACTION_FORCE = 8;
    public static final int PENDING_ACTION_NONE;
    private int downPreScrollRange;
    private int downScrollRange;
    private boolean haveChildWithInterpolator;
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List listeners;
    private int pendingAction;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        boolean bl2;
        float f10;
        int n10;
        boolean bl3;
        int n11;
        int n112;
        this.totalScrollRange = n112 = -1;
        this.downPreScrollRange = n112;
        this.downScrollRange = n112;
        n112 = 0;
        this.pendingAction = 0;
        this.setOrientation(1);
        int bl22 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (bl22 >= n12) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider((View)this);
            n11 = R$style.Widget_Design_AppBarLayout;
            ViewUtilsLollipop.setStateListAnimatorFromAttrs((View)this, attributeSet, 0, n11);
        }
        int[] nArray = R$styleable.AppBarLayout;
        int n13 = R$style.Widget_Design_AppBarLayout;
        int[] nArray2 = new int[]{};
        object = ThemeEnforcement.obtainStyledAttributes((Context)object, attributeSet, nArray, 0, n13, nArray2);
        int n14 = R$styleable.AppBarLayout_android_background;
        attributeSet = object.getDrawable(n14);
        ViewCompat.setBackground((View)this, (Drawable)attributeSet);
        int n15 = R$styleable.AppBarLayout_expanded;
        n11 = (int)(object.hasValue(n15) ? 1 : 0);
        if (n11 != 0) {
            boolean bl4 = object.getBoolean(n15, false);
            this.setExpanded(bl4, false, false);
        }
        if (bl22 >= n12 && (bl3 = object.hasValue(n10 = R$styleable.AppBarLayout_elevation))) {
            int n16 = object.getDimensionPixelSize(n10, 0);
            f10 = n16;
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator((View)this, f10);
        }
        int n17 = 26;
        f10 = 3.6E-44f;
        if (bl22 >= n17) {
            int n18;
            boolean bl5;
            int n19 = R$styleable.AppBarLayout_android_keyboardNavigationCluster;
            boolean bl6 = object.hasValue(n19);
            if (bl6) {
                boolean bl7 = object.getBoolean(n19, false);
                this.setKeyboardNavigationCluster(bl7);
            }
            if (bl5 = object.hasValue(n18 = R$styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                boolean bl8 = object.getBoolean(n18, false);
                this.setTouchscreenBlocksFocus(bl8);
            }
        }
        int n20 = R$styleable.AppBarLayout_liftOnScroll;
        this.liftOnScroll = bl2 = object.getBoolean(n20, false);
        object.recycle();
        object = new AppBarLayout$1(this);
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)object);
    }

    private boolean hasCollapsibleChild() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams)this.getChildAt(i10).getLayoutParams();
            boolean bl2 = appBarLayout$LayoutParams.isCollapsible();
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private void invalidateScrollRanges() {
        int n10;
        this.totalScrollRange = n10 = -1;
        this.downPreScrollRange = n10;
        this.downScrollRange = n10;
    }

    /*
     * WARNING - void declaration
     */
    private void setExpanded(boolean n10, boolean bl2, boolean bl3) {
        void var3_6;
        void var2_5;
        n10 = n10 != 0 ? 1 : 2;
        int n11 = 0;
        if (bl2) {
            int n12 = 4;
        } else {
            boolean bl4 = false;
        }
        n10 |= var2_5;
        if (var3_6 != false) {
            n11 = 8;
        }
        this.pendingAction = n10 |= n11;
        this.requestLayout();
    }

    private boolean setLiftableState(boolean bl2) {
        boolean bl3 = this.liftable;
        if (bl3 != bl2) {
            this.liftable = bl2;
            this.refreshDrawableState();
            return true;
        }
        return false;
    }

    public void addOnOffsetChangedListener(AppBarLayout$BaseOnOffsetChangedListener appBarLayout$BaseOnOffsetChangedListener) {
        boolean bl2;
        List<AppBarLayout$BaseOnOffsetChangedListener> list = this.listeners;
        if (list == null) {
            this.listeners = list = new List<AppBarLayout$BaseOnOffsetChangedListener>();
        }
        if (appBarLayout$BaseOnOffsetChangedListener != null && !(bl2 = (list = this.listeners).contains(appBarLayout$BaseOnOffsetChangedListener))) {
            list = this.listeners;
            list.add(appBarLayout$BaseOnOffsetChangedListener);
        }
    }

    public void addOnOffsetChangedListener(AppBarLayout$OnOffsetChangedListener appBarLayout$OnOffsetChangedListener) {
        this.addOnOffsetChangedListener((AppBarLayout$BaseOnOffsetChangedListener)appBarLayout$OnOffsetChangedListener);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof AppBarLayout$LayoutParams;
    }

    public void dispatchOffsetUpdates(int n10) {
        List list = this.listeners;
        if (list != null) {
            int n11 = list.size();
            for (int i10 = 0; i10 < n11; ++i10) {
                AppBarLayout$BaseOnOffsetChangedListener appBarLayout$BaseOnOffsetChangedListener = (AppBarLayout$BaseOnOffsetChangedListener)this.listeners.get(i10);
                if (appBarLayout$BaseOnOffsetChangedListener == null) continue;
                appBarLayout$BaseOnOffsetChangedListener.onOffsetChanged(this, n10);
            }
        }
    }

    public AppBarLayout$LayoutParams generateDefaultLayoutParams() {
        AppBarLayout$LayoutParams appBarLayout$LayoutParams = new AppBarLayout$LayoutParams(-1, -2);
        return appBarLayout$LayoutParams;
    }

    public AppBarLayout$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        AppBarLayout$LayoutParams appBarLayout$LayoutParams = new AppBarLayout$LayoutParams(context, attributeSet);
        return appBarLayout$LayoutParams;
    }

    public AppBarLayout$LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (n10 = layoutParams instanceof LinearLayout.LayoutParams) != 0) {
            layoutParams = (LinearLayout.LayoutParams)layoutParams;
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = new AppBarLayout$LayoutParams((LinearLayout.LayoutParams)layoutParams);
            return appBarLayout$LayoutParams;
        }
        n10 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        if (n10 != 0) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = new AppBarLayout$LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
            return appBarLayout$LayoutParams;
        }
        AppBarLayout$LayoutParams appBarLayout$LayoutParams = new AppBarLayout$LayoutParams(layoutParams);
        return appBarLayout$LayoutParams;
    }

    public int getDownNestedPreScrollRange() {
        int n10 = this.downPreScrollRange;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n11 = 0;
        int n12 = 0;
        for (n10 = this.getChildCount() + -1; n10 >= 0; n10 += -1) {
            View view = this.getChildAt(n10);
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams)view.getLayoutParams();
            int n13 = view.getMeasuredHeight();
            int n14 = appBarLayout$LayoutParams.scrollFlags;
            int n15 = n14 & 5;
            int n16 = 5;
            if (n15 == n16) {
                int n17;
                n15 = appBarLayout$LayoutParams.topMargin;
                int n18 = appBarLayout$LayoutParams.bottomMargin;
                n12 += (n15 += n18);
                n18 = n14 & 8;
                if (n18 != 0) {
                    n17 = ViewCompat.getMinimumHeight(view);
                    n12 += n17;
                    continue;
                }
                n18 = n14 & 2;
                n17 = n18 != 0 ? ViewCompat.getMinimumHeight(view) : this.getTopInset();
                n12 += (n13 -= n17);
                continue;
            }
            if (n12 > 0) break;
        }
        this.downPreScrollRange = n10 = Math.max(0, n12);
        return n10;
    }

    public int getDownNestedScrollRange() {
        int n10 = this.downScrollRange;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.getChildCount();
        n11 = 0;
        int n12 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams)view.getLayoutParams();
            int n13 = view.getMeasuredHeight();
            int n14 = appBarLayout$LayoutParams.topMargin;
            int n15 = appBarLayout$LayoutParams.bottomMargin;
            n13 += (n14 += n15);
            int n16 = appBarLayout$LayoutParams.scrollFlags;
            n14 = n16 & 1;
            if (n14 == 0) break;
            n12 += n13;
            if ((n16 &= 2) == 0) continue;
            n10 = ViewCompat.getMinimumHeight(view);
            i10 = this.getTopInset();
            n12 -= (n10 += i10);
            break;
        }
        this.downScrollRange = n10 = Math.max(0, n12);
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final int getMinimumHeightForVisibleOverlappingContent() {
        int n10;
        int n11 = this.getTopInset();
        int n12 = ViewCompat.getMinimumHeight((View)this);
        if (n12 != 0) {
            return n12 * 2 + n11;
        }
        n12 = this.getChildCount();
        if (n12 >= (n10 = 1)) {
            View view = this.getChildAt(n12 -= n10);
            n12 = ViewCompat.getMinimumHeight(view);
        } else {
            n12 = 0;
            Object var4_5 = null;
        }
        if (n12 == 0) return this.getHeight() / 3;
        return n12 * 2 + n11;
    }

    public int getPendingAction() {
        return this.pendingAction;
    }

    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        int n10;
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            n10 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            n10 = 0;
            windowInsetsCompat = null;
        }
        return n10;
    }

    public final int getTotalScrollRange() {
        int n10 = this.totalScrollRange;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.getChildCount();
        n11 = 0;
        int n12 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams)view.getLayoutParams();
            int n13 = view.getMeasuredHeight();
            int n14 = appBarLayout$LayoutParams.scrollFlags;
            int n15 = n14 & 1;
            if (n15 == 0) break;
            n15 = appBarLayout$LayoutParams.topMargin;
            n13 += n15;
            int n16 = appBarLayout$LayoutParams.bottomMargin;
            n12 += (n13 += n16);
            n16 = n14 & 2;
            if (n16 == 0) continue;
            n10 = ViewCompat.getMinimumHeight(view);
            n12 -= n10;
            break;
        }
        n10 = this.getTopInset();
        n12 -= n10;
        this.totalScrollRange = n10 = Math.max(0, n12);
        return n10;
    }

    public int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }

    public boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    public boolean hasScrollableChildren() {
        int n10 = this.getTotalScrollRange();
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public int[] onCreateDrawableState(int n10) {
        int[] nArray = this.tmpStatesArray;
        if (nArray == null) {
            int n11 = 4;
            this.tmpStatesArray = nArray = new int[n11];
        }
        nArray = this.tmpStatesArray;
        int n12 = nArray.length;
        int[] nArray2 = super.onCreateDrawableState(n10 += n12);
        n12 = 0;
        int n13 = this.liftable;
        int n14 = R$attr.state_liftable;
        if (n13 == 0) {
            n14 = -n14;
        }
        nArray[0] = n14;
        n12 = 1;
        n14 = n13 != 0 && (n14 = (int)(this.lifted ? 1 : 0)) != 0 ? R$attr.state_lifted : -R$attr.state_lifted;
        nArray[n12] = n14;
        n12 = 2;
        n14 = R$attr.state_collapsible;
        if (n13 == 0) {
            n14 = -n14;
        }
        nArray[n12] = n14;
        n12 = 3;
        n13 = n13 != 0 && (n13 = this.lifted) != 0 ? R$attr.state_collapsed : -R$attr.state_collapsed;
        nArray[n12] = n13;
        return LinearLayout.mergeDrawableStates((int[])nArray2, (int[])nArray);
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        void var5_7;
        boolean bl3;
        int n14;
        int n15;
        super.onLayout(bl2, n15, n14, (int)(bl3 ? 1 : 0), (int)var5_7);
        this.invalidateScrollRanges();
        boolean bl4 = false;
        this.haveChildWithInterpolator = false;
        n15 = this.getChildCount();
        n14 = 0;
        while (true) {
            bl3 = true;
            if (n14 >= n15) break;
            Interpolator interpolator2 = ((AppBarLayout$LayoutParams)this.getChildAt(n14).getLayoutParams()).getScrollInterpolator();
            if (interpolator2 != null) {
                this.haveChildWithInterpolator = bl3;
                break;
            }
            ++n14;
        }
        if ((n15 = (int)(this.liftableOverride ? 1 : 0)) == 0) {
            boolean bl5;
            n15 = (int)(this.liftOnScroll ? 1 : 0);
            if (n15 != 0 || (n15 = (int)(this.hasCollapsibleChild() ? 1 : 0)) != 0) {
                bl5 = bl3;
            }
            this.setLiftableState(bl5);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        this.invalidateScrollRanges();
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        boolean bl2 = ViewCompat.getFitsSystemWindows((View)this);
        if (bl2) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            bl2 = false;
            windowInsetsCompat2 = null;
        }
        WindowInsetsCompat windowInsetsCompat3 = this.lastInsets;
        boolean bl3 = ObjectsCompat.equals(windowInsetsCompat3, windowInsetsCompat2);
        if (!bl3) {
            this.lastInsets = windowInsetsCompat2;
            this.invalidateScrollRanges();
        }
        return windowInsetsCompat;
    }

    public void removeOnOffsetChangedListener(AppBarLayout$BaseOnOffsetChangedListener appBarLayout$BaseOnOffsetChangedListener) {
        List list = this.listeners;
        if (list != null && appBarLayout$BaseOnOffsetChangedListener != null) {
            list.remove(appBarLayout$BaseOnOffsetChangedListener);
        }
    }

    public void removeOnOffsetChangedListener(AppBarLayout$OnOffsetChangedListener appBarLayout$OnOffsetChangedListener) {
        this.removeOnOffsetChangedListener((AppBarLayout$BaseOnOffsetChangedListener)appBarLayout$OnOffsetChangedListener);
    }

    public void resetPendingAction() {
        this.pendingAction = 0;
    }

    public void setExpanded(boolean bl2) {
        boolean bl3 = ViewCompat.isLaidOut((View)this);
        this.setExpanded(bl2, bl3);
    }

    public void setExpanded(boolean bl2, boolean bl3) {
        this.setExpanded(bl2, bl3, true);
    }

    public void setLiftOnScroll(boolean bl2) {
        this.liftOnScroll = bl2;
    }

    public boolean setLiftable(boolean bl2) {
        this.liftableOverride = true;
        return this.setLiftableState(bl2);
    }

    public boolean setLifted(boolean bl2) {
        return this.setLiftedState(bl2);
    }

    public boolean setLiftedState(boolean bl2) {
        boolean bl3 = this.lifted;
        if (bl3 != bl2) {
            this.lifted = bl2;
            this.refreshDrawableState();
            return true;
        }
        return false;
    }

    public void setOrientation(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            super.setOrientation(n10);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        throw illegalArgumentException;
    }

    public void setTargetElevation(float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator((View)this, f10);
        }
    }
}

