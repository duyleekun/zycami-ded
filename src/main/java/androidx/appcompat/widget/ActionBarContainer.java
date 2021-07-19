/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarBackgroundDrawable;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.core.view.ViewCompat;

public class ActionBarContainer
extends FrameLayout {
    private View mActionBarView;
    public Drawable mBackground;
    private View mContextView;
    private int mHeight;
    public boolean mIsSplit;
    public boolean mIsStacked;
    private boolean mIsTransitioning;
    public Drawable mSplitBackground;
    public Drawable mStackedBackground;
    private View mTabContainer;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Object object = new ActionBarBackgroundDrawable(this);
        ViewCompat.setBackground((View)this, object);
        object = R$styleable.ActionBar;
        context = context.obtainStyledAttributes(attributeSet, (int[])object);
        int n10 = R$styleable.ActionBar_background;
        attributeSet = context.getDrawable(n10);
        this.mBackground = attributeSet;
        n10 = R$styleable.ActionBar_backgroundStacked;
        attributeSet = context.getDrawable(n10);
        this.mStackedBackground = attributeSet;
        n10 = R$styleable.ActionBar_height;
        this.mHeight = n10 = context.getDimensionPixelSize(n10, -1);
        n10 = this.getId();
        int n11 = R$id.split_action_bar;
        boolean bl2 = true;
        if (n10 == n11) {
            this.mIsSplit = bl2;
            n10 = R$styleable.ActionBar_backgroundSplit;
            attributeSet = context.getDrawable(n10);
            this.mSplitBackground = attributeSet;
        }
        context.recycle();
        boolean bl3 = this.mIsSplit;
        n10 = 0;
        attributeSet = null;
        if (!(bl3 ? (context = this.mSplitBackground) == null : (context = this.mBackground) == null && (context = this.mStackedBackground) == null)) {
            bl2 = false;
        }
        this.setWillNotDraw(bl2);
    }

    private int getMeasuredHeightWithMargins(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int n10 = view.getMeasuredHeight();
        int n11 = layoutParams.topMargin;
        int n12 = layoutParams.bottomMargin;
        return (n10 += n11) + n12;
    }

    private boolean isCollapsed(View view) {
        int n10;
        int n11;
        int n12;
        if (view != null && (n12 = view.getVisibility()) != (n11 = 8) && (n10 = view.getMeasuredHeight()) != 0) {
            n10 = 0;
            view = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public void drawableStateChanged() {
        int[] nArray;
        boolean bl2;
        super.drawableStateChanged();
        Drawable drawable2 = this.mBackground;
        if (drawable2 != null && (bl2 = drawable2.isStateful())) {
            drawable2 = this.mBackground;
            nArray = this.getDrawableState();
            drawable2.setState(nArray);
        }
        if ((drawable2 = this.mStackedBackground) != null && (bl2 = drawable2.isStateful())) {
            drawable2 = this.mStackedBackground;
            nArray = this.getDrawableState();
            drawable2.setState(nArray);
        }
        if ((drawable2 = this.mSplitBackground) != null && (bl2 = drawable2.isStateful())) {
            drawable2 = this.mSplitBackground;
            nArray = this.getDrawableState();
            drawable2.setState(nArray);
        }
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable2 = this.mBackground;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        if ((drawable2 = this.mStackedBackground) != null) {
            drawable2.jumpToCurrentState();
        }
        if ((drawable2 = this.mSplitBackground) != null) {
            drawable2.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        View view;
        super.onFinishInflate();
        int n10 = R$id.action_bar;
        this.mActionBarView = view = this.findViewById(n10);
        n10 = R$id.action_context_bar;
        this.mContextView = view = this.findViewById(n10);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        boolean bl3 = this.mIsTransitioning;
        if (!bl3 && !(bl2 = super.onInterceptTouchEvent(motionEvent))) {
            bl2 = false;
            motionEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onLayout(boolean var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block10: {
            super.onLayout(var1_1, var2_2, var3_3, var4_4, var5_5);
            var6_6 = this.mTabContainer;
            var3_3 = 8;
            var5_5 = 1;
            var7_7 = 1.4E-45f;
            var8_8 = 0;
            var9_9 = 0.0f;
            var10_10 = null;
            var11_11 = var6_6 != null && (var11_11 = var6_6.getVisibility()) != var3_3 ? var5_5 : 0;
            if (var6_6 != null && (var12_12 = var6_6.getVisibility()) != var3_3) {
                var3_3 = this.getMeasuredHeight();
                var13_13 = (FrameLayout.LayoutParams)var6_6.getLayoutParams();
                var14_14 = var6_6.getMeasuredHeight();
                var14_14 = var3_3 - var14_14;
                var12_12 = var13_13.bottomMargin;
                var6_6.layout(var2_2, var14_14 -= var12_12, var4_4, var3_3 -= var12_12);
            }
            if ((var2_2 = (int)this.mIsSplit) == 0) ** GOTO lbl28
            var6_6 = this.mSplitBackground;
            if (var6_6 != null) {
                var2_2 = this.getMeasuredWidth();
                var3_3 = this.getMeasuredHeight();
                var6_6.setBounds(0, 0, var2_2, var3_3);
            } else {
                while (true) {
                    var5_5 = var8_8;
                    var7_7 = var9_9;
                    break block10;
                    break;
                }
lbl28:
                // 1 sources

                var15_15 = this.mBackground;
                if (var15_15 != null) {
                    var15_15 = this.mActionBarView;
                    var2_2 = var15_15.getVisibility();
                    if (var2_2 == 0) {
                        var15_15 = this.mBackground;
                        var16_16 = this.mActionBarView;
                        var3_3 = var16_16.getLeft();
                        var17_18 = this.mActionBarView;
                        var4_4 = var17_18.getTop();
                        var10_10 = this.mActionBarView;
                        var8_8 = var10_10.getRight();
                        var13_13 = this.mActionBarView;
                        var12_12 = var13_13.getBottom();
                        var15_15.setBounds(var3_3, var4_4, var8_8, var12_12);
                    } else {
                        var15_15 = this.mContextView;
                        if (var15_15 != null && (var2_2 = var15_15.getVisibility()) == 0) {
                            var15_15 = this.mBackground;
                            var16_17 = this.mContextView;
                            var3_3 = var16_17.getLeft();
                            var17_19 = this.mContextView;
                            var4_4 = var17_19.getTop();
                            var10_10 = this.mContextView;
                            var8_8 = var10_10.getRight();
                            var13_13 = this.mContextView;
                            var12_12 = var13_13.getBottom();
                            var15_15.setBounds(var3_3, var4_4, var8_8, var12_12);
                        } else {
                            var15_15 = this.mBackground;
                            var15_15.setBounds(0, 0, 0, 0);
                        }
                    }
                    var8_8 = var5_5;
                    var9_9 = var7_7;
                }
                this.mIsStacked = var11_11;
                if (var11_11 == 0 || (var15_15 = this.mStackedBackground) == null) ** continue;
                var3_3 = var6_6.getLeft();
                var4_4 = var6_6.getTop();
                var8_8 = var6_6.getRight();
                var1_1 = var6_6.getBottom();
                var15_15.setBounds(var3_3, var4_4, var8_8, (int)var1_1);
            }
        }
        if (var5_5 != 0) {
            this.invalidate();
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13;
        View view = this.mActionBarView;
        int n14 = -1 << -1;
        if (view == null && (n13 = View.MeasureSpec.getMode((int)n11)) == n14 && (n13 = this.mHeight) >= 0) {
            n11 = View.MeasureSpec.getSize((int)n11);
            n11 = View.MeasureSpec.makeMeasureSpec((int)Math.min(n13, n11), (int)n14);
        }
        super.onMeasure(n10, n11);
        View view2 = this.mActionBarView;
        if (view2 == null) {
            return;
        }
        n10 = View.MeasureSpec.getMode((int)n11);
        view = this.mTabContainer;
        if (view != null && (n13 = view.getVisibility()) != (n12 = 8) && n10 != (n13 = 0x40000000)) {
            view = this.mActionBarView;
            n13 = this.isCollapsed(view) ? 1 : 0;
            if (n13 == 0) {
                view = this.mActionBarView;
                n13 = this.getMeasuredHeightWithMargins(view);
            } else {
                view = this.mContextView;
                n13 = this.isCollapsed(view) ? 1 : 0;
                if (n13 == 0) {
                    view = this.mContextView;
                    n13 = this.getMeasuredHeightWithMargins(view);
                } else {
                    n13 = 0;
                    view = null;
                }
            }
            n10 = n10 == n14 ? View.MeasureSpec.getSize((int)n11) : -1 >>> 1;
            n11 = this.getMeasuredWidth();
            View view3 = this.mTabContainer;
            n14 = this.getMeasuredHeightWithMargins(view3);
            n10 = Math.min(n13 += n14, n10);
            this.setMeasuredDimension(n11, n10);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable2) {
        int n10;
        View view;
        int n11;
        Drawable drawable3 = this.mBackground;
        if (drawable3 != null) {
            n11 = 0;
            view = null;
            drawable3.setCallback(null);
            drawable3 = this.mBackground;
            this.unscheduleDrawable(drawable3);
        }
        this.mBackground = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
            drawable2 = this.mActionBarView;
            if (drawable2 != null) {
                drawable3 = this.mBackground;
                n10 = drawable2.getLeft();
                view = this.mActionBarView;
                n11 = view.getTop();
                View view2 = this.mActionBarView;
                int n12 = view2.getRight();
                View view3 = this.mActionBarView;
                int n13 = view3.getBottom();
                drawable3.setBounds(n10, n11, n12, n13);
            }
        }
        n10 = this.mIsSplit;
        int n14 = 1;
        n11 = 0;
        view = null;
        if (!(n10 != 0 ? (drawable2 = this.mSplitBackground) == null : (drawable2 = this.mBackground) == null && (drawable2 = this.mStackedBackground) == null)) {
            n14 = 0;
            drawable3 = null;
        }
        this.setWillNotDraw(n14 != 0);
        this.invalidate();
        n10 = Build.VERSION.SDK_INT;
        n14 = 21;
        if (n10 >= n14) {
            this.invalidateOutline();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setSplitBackground(Drawable drawable2) {
        int n10;
        int n11;
        Drawable drawable3 = this.mSplitBackground;
        if (drawable3 != null) {
            n11 = 0;
            drawable3.setCallback(null);
            drawable3 = this.mSplitBackground;
            this.unscheduleDrawable(drawable3);
        }
        this.mSplitBackground = drawable2;
        int n12 = 0;
        drawable3 = null;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
            n10 = this.mIsSplit;
            if (n10 != 0 && (drawable2 = this.mSplitBackground) != null) {
                n11 = this.getMeasuredWidth();
                int n13 = this.getMeasuredHeight();
                drawable2.setBounds(0, 0, n11, n13);
            }
        }
        n10 = this.mIsSplit;
        n11 = 1;
        if (n10 != 0 ? (drawable2 = this.mSplitBackground) == null : (drawable2 = this.mBackground) == null && (drawable2 = this.mStackedBackground) == null) {
            n12 = n11;
        }
        this.setWillNotDraw(n12 != 0);
        this.invalidate();
        n10 = Build.VERSION.SDK_INT;
        n12 = 21;
        if (n10 < n12) return;
        this.invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable2) {
        int n10;
        int n11;
        View view;
        int n12;
        Drawable drawable3 = this.mStackedBackground;
        if (drawable3 != null) {
            n12 = 0;
            view = null;
            drawable3.setCallback(null);
            drawable3 = this.mStackedBackground;
            this.unscheduleDrawable(drawable3);
        }
        this.mStackedBackground = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
            n11 = this.mIsStacked;
            if (n11 != 0 && (drawable2 = this.mStackedBackground) != null) {
                drawable3 = this.mTabContainer;
                n10 = drawable3.getLeft();
                view = this.mTabContainer;
                n12 = view.getTop();
                View view2 = this.mTabContainer;
                int n13 = view2.getRight();
                View view3 = this.mTabContainer;
                int n14 = view3.getBottom();
                drawable2.setBounds(n10, n12, n13, n14);
            }
        }
        n11 = this.mIsSplit;
        n10 = 1;
        n12 = 0;
        view = null;
        if (!(n11 != 0 ? (drawable2 = this.mSplitBackground) == null : (drawable2 = this.mBackground) == null && (drawable2 = this.mStackedBackground) == null)) {
            n10 = 0;
            drawable3 = null;
        }
        this.setWillNotDraw(n10 != 0);
        this.invalidate();
        n11 = Build.VERSION.SDK_INT;
        n10 = 21;
        if (n11 >= n10) {
            this.invalidateOutline();
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.mTabContainer;
        if (view != null) {
            this.removeView(view);
        }
        this.mTabContainer = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            int n10;
            this.addView((View)scrollingTabContainerView);
            view = scrollingTabContainerView.getLayoutParams();
            view.width = -1;
            view.height = n10 = -2;
            view = null;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setTransitioning(boolean bl2) {
        void var1_4;
        this.mIsTransitioning = bl2;
        if (bl2) {
            int n10 = 393216;
        } else {
            int n11 = 262144;
        }
        this.setDescendantFocusability((int)var1_4);
    }

    public void setVisibility(int n10) {
        super.setVisibility(n10);
        n10 = n10 == 0 ? 1 : 0;
        Drawable drawable2 = this.mBackground;
        if (drawable2 != null) {
            drawable2.setVisible(n10 != 0, false);
        }
        if ((drawable2 = this.mStackedBackground) != null) {
            drawable2.setVisible(n10 != 0, false);
        }
        if ((drawable2 = this.mSplitBackground) != null) {
            drawable2.setVisible(n10 != 0, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int n10) {
        if (n10 != 0) {
            return super.startActionModeForChild(view, callback, n10);
        }
        return null;
    }

    public boolean verifyDrawable(Drawable drawable2) {
        boolean bl2;
        boolean bl3;
        Drawable drawable3 = this.mBackground;
        if (drawable2 == drawable3 && !(bl3 = this.mIsSplit) || drawable2 == (drawable3 = this.mStackedBackground) && (bl3 = this.mIsStacked) || drawable2 == (drawable3 = this.mSplitBackground) && (bl3 = this.mIsSplit) || (bl2 = super.verifyDrawable(drawable2))) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }
}

