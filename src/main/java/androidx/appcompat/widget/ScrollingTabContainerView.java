/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.AbsListView$LayoutParams
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.HorizontalScrollView
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.LinearLayoutCompat$LayoutParams;
import androidx.appcompat.widget.ScrollingTabContainerView$1;
import androidx.appcompat.widget.ScrollingTabContainerView$TabAdapter;
import androidx.appcompat.widget.ScrollingTabContainerView$TabClickListener;
import androidx.appcompat.widget.ScrollingTabContainerView$TabView;
import androidx.appcompat.widget.ScrollingTabContainerView$VisibilityAnimListener;

public class ScrollingTabContainerView
extends HorizontalScrollView
implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator;
    private boolean mAllowCollapse;
    private int mContentHeight;
    public int mMaxTabWidth;
    private int mSelectedTabIndex;
    public int mStackedTabMaxWidth;
    private ScrollingTabContainerView$TabClickListener mTabClickListener;
    public LinearLayoutCompat mTabLayout;
    public Runnable mTabSelector;
    private Spinner mTabSpinner;
    public final ScrollingTabContainerView$VisibilityAnimListener mVisAnimListener;
    public ViewPropertyAnimator mVisibilityAnim;

    static {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        sAlphaInterpolator = decelerateInterpolator;
    }

    public ScrollingTabContainerView(Context object) {
        super(object);
        int n10;
        ScrollingTabContainerView$VisibilityAnimListener scrollingTabContainerView$VisibilityAnimListener;
        this.mVisAnimListener = scrollingTabContainerView$VisibilityAnimListener = new ScrollingTabContainerView$VisibilityAnimListener(this);
        this.setHorizontalScrollBarEnabled(false);
        object = ActionBarPolicy.get(object);
        int n11 = object.getTabContainerHeight();
        this.setContentHeight(n11);
        this.mStackedTabMaxWidth = n10 = object.getStackedTabMaxWidth();
        object = this.createTabLayout();
        this.mTabLayout = object;
        super(-2, -1);
        this.addView((View)object, (ViewGroup.LayoutParams)scrollingTabContainerView$VisibilityAnimListener);
    }

    private Spinner createSpinner() {
        Object object = this.getContext();
        int n10 = R$attr.actionDropDownStyle;
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner((Context)object, null, n10);
        object = new LinearLayoutCompat$LayoutParams(-2, -1);
        appCompatSpinner.setLayoutParams((ViewGroup.LayoutParams)object);
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat createTabLayout() {
        Object object = this.getContext();
        int n10 = R$attr.actionBarTabBarStyle;
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat((Context)object, null, n10);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        object = new LinearLayoutCompat$LayoutParams(-2, -1);
        linearLayoutCompat.setLayoutParams((ViewGroup.LayoutParams)object);
        return linearLayoutCompat;
    }

    private boolean isCollapsed() {
        boolean bl2;
        Spinner spinner = this.mTabSpinner;
        if (spinner != null && (spinner = spinner.getParent()) == this) {
            bl2 = true;
        } else {
            bl2 = false;
            spinner = null;
        }
        return bl2;
    }

    private void performCollapse() {
        boolean bl2 = this.isCollapsed();
        if (bl2) {
            return;
        }
        Object object = this.mTabSpinner;
        if (object == null) {
            this.mTabSpinner = object = this.createSpinner();
        }
        object = this.mTabLayout;
        this.removeView((View)object);
        object = this.mTabSpinner;
        int n10 = -2;
        int n11 = -1;
        Object object2 = new ViewGroup.LayoutParams(n10, n11);
        this.addView((View)object, (ViewGroup.LayoutParams)object2);
        object = this.mTabSpinner.getAdapter();
        if (object == null) {
            object = this.mTabSpinner;
            object2 = new ScrollingTabContainerView$TabAdapter(this);
            object.setAdapter((SpinnerAdapter)object2);
        }
        if ((object = this.mTabSelector) != null) {
            this.removeCallbacks((Runnable)object);
            bl2 = false;
            object = null;
            this.mTabSelector = null;
        }
        object = this.mTabSpinner;
        int n12 = this.mSelectedTabIndex;
        object.setSelection(n12);
    }

    private boolean performExpand() {
        int n10 = this.isCollapsed();
        if (n10 == 0) {
            return false;
        }
        Object object = this.mTabSpinner;
        this.removeView((View)object);
        object = this.mTabLayout;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        this.addView((View)object, layoutParams);
        n10 = this.mTabSpinner.getSelectedItemPosition();
        this.setTabSelected(n10);
        return false;
    }

    public void addTab(ActionBar$Tab object, int n10, boolean bl2) {
        boolean bl3;
        object = this.createTabView((ActionBar$Tab)object, false);
        LinearLayoutCompat linearLayoutCompat = this.mTabLayout;
        int n11 = -1;
        float f10 = 1.0f;
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = new LinearLayoutCompat$LayoutParams(0, n11, f10);
        linearLayoutCompat.addView((View)object, n10, (ViewGroup.LayoutParams)linearLayoutCompat$LayoutParams);
        Object object2 = this.mTabSpinner;
        if (object2 != null) {
            object2 = (ScrollingTabContainerView$TabAdapter)object2.getAdapter();
            object2.notifyDataSetChanged();
        }
        if (bl2) {
            n10 = 1;
            ((ScrollingTabContainerView$TabView)((Object)object)).setSelected(n10 != 0);
        }
        if (bl3 = this.mAllowCollapse) {
            this.requestLayout();
        }
    }

    public void addTab(ActionBar$Tab object, boolean bl2) {
        boolean bl3;
        object = this.createTabView((ActionBar$Tab)object, false);
        LinearLayoutCompat linearLayoutCompat = this.mTabLayout;
        int n10 = -1;
        float f10 = 1.0f;
        LinearLayoutCompat$LayoutParams linearLayoutCompat$LayoutParams = new LinearLayoutCompat$LayoutParams(0, n10, f10);
        linearLayoutCompat.addView((View)object, (ViewGroup.LayoutParams)linearLayoutCompat$LayoutParams);
        Object object2 = this.mTabSpinner;
        if (object2 != null) {
            object2 = (ScrollingTabContainerView$TabAdapter)object2.getAdapter();
            object2.notifyDataSetChanged();
        }
        if (bl2) {
            bl2 = true;
            ((ScrollingTabContainerView$TabView)((Object)object)).setSelected(bl2);
        }
        if (bl3 = this.mAllowCollapse) {
            this.requestLayout();
        }
    }

    public void animateToTab(int n10) {
        View view = this.mTabLayout.getChildAt(n10);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            this.removeCallbacks(runnable);
        }
        this.mTabSelector = runnable = new ScrollingTabContainerView$1(this, view);
        this.post(runnable);
    }

    public void animateToVisibility(int n10) {
        Object object = this.mVisibilityAnim;
        if (object != null) {
            object.cancel();
        }
        long l10 = 200L;
        ViewPropertyAnimator viewPropertyAnimator = null;
        if (n10 == 0) {
            int n11 = this.getVisibility();
            if (n11 != 0) {
                this.setAlpha(0.0f);
            }
            viewPropertyAnimator = this.animate();
            n11 = 1065353216;
            float f10 = 1.0f;
            viewPropertyAnimator = viewPropertyAnimator.alpha(f10);
            viewPropertyAnimator.setDuration(l10);
            object = sAlphaInterpolator;
            viewPropertyAnimator.setInterpolator((TimeInterpolator)object);
            object = this.mVisAnimListener;
            ScrollingTabContainerView$VisibilityAnimListener scrollingTabContainerView$VisibilityAnimListener = ((ScrollingTabContainerView$VisibilityAnimListener)((Object)object)).withFinalVisibility(viewPropertyAnimator, n10);
            viewPropertyAnimator.setListener((Animator.AnimatorListener)scrollingTabContainerView$VisibilityAnimListener);
            viewPropertyAnimator.start();
        } else {
            ViewPropertyAnimator viewPropertyAnimator2 = this.animate();
            viewPropertyAnimator = viewPropertyAnimator2.alpha(0.0f);
            viewPropertyAnimator.setDuration(l10);
            object = sAlphaInterpolator;
            viewPropertyAnimator.setInterpolator((TimeInterpolator)object);
            object = this.mVisAnimListener;
            ScrollingTabContainerView$VisibilityAnimListener scrollingTabContainerView$VisibilityAnimListener = ((ScrollingTabContainerView$VisibilityAnimListener)((Object)object)).withFinalVisibility(viewPropertyAnimator, n10);
            viewPropertyAnimator.setListener((Animator.AnimatorListener)scrollingTabContainerView$VisibilityAnimListener);
            viewPropertyAnimator.start();
        }
    }

    public ScrollingTabContainerView$TabView createTabView(ActionBar$Tab object, boolean bl2) {
        Context context = this.getContext();
        ScrollingTabContainerView$TabView scrollingTabContainerView$TabView = new ScrollingTabContainerView$TabView(this, context, (ActionBar$Tab)object, bl2);
        if (bl2) {
            boolean bl4 = false;
            scrollingTabContainerView$TabView.setBackgroundDrawable(null);
            int n10 = -1;
            int n11 = this.mContentHeight;
            object = new AbsListView.LayoutParams(n10, n11);
            scrollingTabContainerView$TabView.setLayoutParams((ViewGroup.LayoutParams)object);
        } else {
            boolean bl3 = true;
            scrollingTabContainerView$TabView.setFocusable(bl3);
            object = this.mTabClickListener;
            if (object == null) {
                this.mTabClickListener = object = new ScrollingTabContainerView$TabClickListener(this);
            }
            object = this.mTabClickListener;
            scrollingTabContainerView$TabView.setOnClickListener((View.OnClickListener)object);
        }
        return scrollingTabContainerView$TabView;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            this.post(runnable);
        }
    }

    public void onConfigurationChanged(Configuration object) {
        int n10;
        super.onConfigurationChanged((Configuration)object);
        object = ActionBarPolicy.get(this.getContext());
        int n11 = ((ActionBarPolicy)object).getTabContainerHeight();
        this.setContentHeight(n11);
        this.mStackedTabMaxWidth = n10 = ((ActionBarPolicy)object).getStackedTabMaxWidth();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            this.removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView adapterView, View view, int n10, long l10) {
        ((ScrollingTabContainerView$TabView)view).getTab().select();
    }

    public void onMeasure(int n10, int n11) {
        LinearLayoutCompat linearLayoutCompat;
        int n12;
        n11 = View.MeasureSpec.getMode((int)n10);
        int n13 = 1;
        int n14 = 0;
        int n15 = 0x40000000;
        int n16 = n11 == n15 ? n13 : 0;
        this.setFillViewport(n16 != 0);
        LinearLayoutCompat linearLayoutCompat2 = this.mTabLayout;
        int n17 = linearLayoutCompat2.getChildCount();
        if (n17 > n13 && (n11 == n15 || n11 == (n12 = -1 << -1))) {
            n11 = 2;
            float f10 = 2.8E-45f;
            if (n17 > n11) {
                f10 = View.MeasureSpec.getSize((int)n10);
                n17 = 1053609165;
                float f11 = 0.4f;
                this.mMaxTabWidth = n11 = (int)(f10 *= f11);
            } else {
                this.mMaxTabWidth = n17 = View.MeasureSpec.getSize((int)n10) / n11;
            }
            n11 = this.mMaxTabWidth;
            n17 = this.mStackedTabMaxWidth;
            this.mMaxTabWidth = n11 = Math.min(n11, n17);
        } else {
            n11 = -1;
            float f12 = 0.0f / 0.0f;
            this.mMaxTabWidth = n11;
        }
        n11 = View.MeasureSpec.makeMeasureSpec((int)this.mContentHeight, (int)n15);
        if (n16 != 0 || (n15 = (int)(this.mAllowCollapse ? 1 : 0)) == 0) {
            n13 = 0;
            linearLayoutCompat = null;
        }
        if (n13 != 0) {
            this.mTabLayout.measure(0, n11);
            linearLayoutCompat = this.mTabLayout;
            n13 = linearLayoutCompat.getMeasuredWidth();
            n14 = View.MeasureSpec.getSize((int)n10);
            if (n13 > n14) {
                this.performCollapse();
            } else {
                this.performExpand();
            }
        } else {
            this.performExpand();
        }
        n13 = this.getMeasuredWidth();
        super.onMeasure(n10, n11);
        n10 = this.getMeasuredWidth();
        if (n16 != 0 && n13 != n10) {
            n10 = this.mSelectedTabIndex;
            this.setTabSelected(n10);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }

    public void removeAllTabs() {
        boolean bl2;
        this.mTabLayout.removeAllViews();
        Object object = this.mTabSpinner;
        if (object != null) {
            object = (ScrollingTabContainerView$TabAdapter)object.getAdapter();
            object.notifyDataSetChanged();
        }
        if (bl2 = this.mAllowCollapse) {
            this.requestLayout();
        }
    }

    public void removeTabAt(int n10) {
        LinearLayoutCompat linearLayoutCompat = this.mTabLayout;
        linearLayoutCompat.removeViewAt(n10);
        Object object = this.mTabSpinner;
        if (object != null) {
            object = (ScrollingTabContainerView$TabAdapter)object.getAdapter();
            object.notifyDataSetChanged();
        }
        if ((n10 = (int)(this.mAllowCollapse ? 1 : 0)) != 0) {
            this.requestLayout();
        }
    }

    public void setAllowCollapse(boolean bl2) {
        this.mAllowCollapse = bl2;
    }

    public void setContentHeight(int n10) {
        this.mContentHeight = n10;
        this.requestLayout();
    }

    public void setTabSelected(int n10) {
        this.mSelectedTabIndex = n10;
        LinearLayoutCompat linearLayoutCompat = this.mTabLayout;
        int n11 = linearLayoutCompat.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = this.mTabLayout.getChildAt(i10);
            boolean bl2 = i10 == n10;
            view.setSelected(bl2);
            if (!bl2) continue;
            this.animateToTab(n10);
        }
        linearLayoutCompat = this.mTabSpinner;
        if (linearLayoutCompat != null && n10 >= 0) {
            linearLayoutCompat.setSelection(n10);
        }
    }

    public void updateTab(int n10) {
        LinearLayoutCompat linearLayoutCompat = this.mTabLayout;
        ((ScrollingTabContainerView$TabView)linearLayoutCompat.getChildAt(n10)).update();
        Object object = this.mTabSpinner;
        if (object != null) {
            object = (ScrollingTabContainerView$TabAdapter)object.getAdapter();
            object.notifyDataSetChanged();
        }
        if ((n10 = (int)(this.mAllowCollapse ? 1 : 0)) != 0) {
            this.requestLayout();
        }
    }
}

