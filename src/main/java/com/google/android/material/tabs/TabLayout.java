/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout$1;
import com.google.android.material.tabs.TabLayout$AdapterChangeListener;
import com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$PagerAdapterObserver;
import com.google.android.material.tabs.TabLayout$SlidingTabIndicator;
import com.google.android.material.tabs.TabLayout$Tab;
import com.google.android.material.tabs.TabLayout$TabLayoutOnPageChangeListener;
import com.google.android.material.tabs.TabLayout$TabView;
import com.google.android.material.tabs.TabLayout$ViewPagerOnTabSelectedListener;
import java.util.ArrayList;

public class TabLayout
extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    public static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    public static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    public static final int INDICATOR_GRAVITY_BOTTOM = 0;
    public static final int INDICATOR_GRAVITY_CENTER = 1;
    public static final int INDICATOR_GRAVITY_STRETCH = 3;
    public static final int INDICATOR_GRAVITY_TOP = 2;
    private static final int INVALID_WIDTH = 255;
    private static final int MIN_INDICATOR_WIDTH = 24;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private static final Pools$Pool tabPool;
    private TabLayout$AdapterChangeListener adapterChangeListener;
    private int contentInsetStart;
    private TabLayout$BaseOnTabSelectedListener currentVpSelectedListener;
    public boolean inlineLabel;
    public int mode;
    private TabLayout$TabLayoutOnPageChangeListener pageChangeListener;
    private PagerAdapter pagerAdapter;
    private DataSetObserver pagerAdapterObserver;
    private final int requestedTabMaxWidth;
    private final int requestedTabMinWidth;
    private ValueAnimator scrollAnimator;
    private final int scrollableTabMinWidth;
    private TabLayout$BaseOnTabSelectedListener selectedListener;
    private final ArrayList selectedListeners;
    private TabLayout$Tab selectedTab;
    private boolean setupViewPagerImplicitly;
    private final TabLayout$SlidingTabIndicator slidingTabIndicator;
    public final int tabBackgroundResId;
    public int tabGravity;
    public ColorStateList tabIconTint;
    public PorterDuff.Mode tabIconTintMode;
    public int tabIndicatorAnimationDuration;
    public boolean tabIndicatorFullWidth;
    public int tabIndicatorGravity;
    public int tabMaxWidth;
    public int tabPaddingBottom;
    public int tabPaddingEnd;
    public int tabPaddingStart;
    public int tabPaddingTop;
    public ColorStateList tabRippleColorStateList;
    public Drawable tabSelectedIndicator;
    public int tabTextAppearance;
    public ColorStateList tabTextColors;
    public float tabTextMultiLineSize;
    public float tabTextSize;
    private final RectF tabViewContentBounds;
    private final Pools$Pool tabViewPool;
    private final ArrayList tabs;
    public boolean unboundedRipple;
    public ViewPager viewPager;

    static {
        Pools$SynchronizedPool pools$SynchronizedPool = new Pools$SynchronizedPool(16);
        tabPool = pools$SynchronizedPool;
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.tabStyle;
        this(context, attributeSet, n10);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        int n11;
        Object object;
        Object object2;
        this.tabs = object2 = new ArrayList();
        this.tabViewContentBounds = object2 = new RectF();
        this.tabMaxWidth = -1 >>> 1;
        super();
        this.selectedListeners = object2;
        float f11 = 1.7E-44f;
        super(12);
        this.tabViewPool = object2;
        object2 = null;
        this.setHorizontalScrollBarEnabled(false);
        this.slidingTabIndicator = object = new TabLayout$SlidingTabIndicator(this, context);
        int n12 = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, n12);
        super.addView((View)object, 0, (ViewGroup.LayoutParams)layoutParams);
        int[] nArray = R$styleable.TabLayout;
        int n13 = R$style.Widget_Design_TabLayout;
        int n14 = 1;
        int[] nArray2 = new int[n14];
        nArray2[0] = n11 = R$styleable.TabLayout_tabTextAppearance;
        attributeSet = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, nArray, n10, n13, nArray2);
        n10 = R$styleable.TabLayout_tabIndicatorHeight;
        n10 = attributeSet.getDimensionPixelSize(n10, n12);
        object.setSelectedIndicatorHeight(n10);
        n10 = R$styleable.TabLayout_tabIndicatorColor;
        n10 = attributeSet.getColor(n10, 0);
        object.setSelectedIndicatorColor(n10);
        n10 = R$styleable.TabLayout_tabIndicator;
        Drawable drawable2 = MaterialResources.getDrawable(context, (TypedArray)attributeSet, n10);
        this.setSelectedTabIndicator(drawable2);
        n10 = R$styleable.TabLayout_tabIndicatorGravity;
        n10 = attributeSet.getInt(n10, 0);
        this.setSelectedTabIndicatorGravity(n10);
        n10 = R$styleable.TabLayout_tabIndicatorFullWidth;
        n10 = (int)(attributeSet.getBoolean(n10, n14 != 0) ? 1 : 0);
        this.setTabIndicatorFullWidth(n10 != 0);
        n10 = R$styleable.TabLayout_tabPadding;
        this.tabPaddingBottom = n10 = attributeSet.getDimensionPixelSize(n10, 0);
        this.tabPaddingEnd = n10;
        this.tabPaddingTop = n10;
        this.tabPaddingStart = n10;
        int n15 = R$styleable.TabLayout_tabPaddingStart;
        this.tabPaddingStart = n10 = attributeSet.getDimensionPixelSize(n15, n10);
        n10 = R$styleable.TabLayout_tabPaddingTop;
        n15 = this.tabPaddingTop;
        this.tabPaddingTop = n10 = attributeSet.getDimensionPixelSize(n10, n15);
        n10 = R$styleable.TabLayout_tabPaddingEnd;
        n15 = this.tabPaddingEnd;
        this.tabPaddingEnd = n10 = attributeSet.getDimensionPixelSize(n10, n15);
        n10 = R$styleable.TabLayout_tabPaddingBottom;
        n15 = this.tabPaddingBottom;
        this.tabPaddingBottom = n10 = attributeSet.getDimensionPixelSize(n10, n15);
        n10 = R$style.TextAppearance_Design_Tab;
        this.tabTextAppearance = n10 = attributeSet.getResourceId(n11, n10);
        object = androidx.appcompat.R$styleable.TextAppearance;
        drawable2 = context.obtainStyledAttributes(n10, (int[])object);
        n15 = androidx.appcompat.R$styleable.TextAppearance_android_textSize;
        n15 = drawable2.getDimensionPixelSize(n15, 0);
        f11 = n15;
        this.tabTextSize = f11;
        n15 = androidx.appcompat.R$styleable.TextAppearance_android_textColor;
        object = MaterialResources.getColorStateList(context, (TypedArray)drawable2, n15);
        this.tabTextColors = object;
        n10 = R$styleable.TabLayout_tabTextColor;
        n15 = (int)(attributeSet.hasValue(n10) ? 1 : 0);
        if (n15 != 0) {
            drawable2 = MaterialResources.getColorStateList(context, (TypedArray)attributeSet, n10);
            this.tabTextColors = drawable2;
        }
        if ((n15 = (int)(attributeSet.hasValue(n10 = R$styleable.TabLayout_tabSelectedTextColor) ? 1 : 0)) != 0) {
            n10 = attributeSet.getColor(n10, 0);
            object = this.tabTextColors;
            n15 = object.getDefaultColor();
            drawable2 = TabLayout.createColorStateList(n15, n10);
            this.tabTextColors = drawable2;
        }
        n10 = R$styleable.TabLayout_tabIconTint;
        drawable2 = MaterialResources.getColorStateList(context, (TypedArray)attributeSet, n10);
        this.tabIconTint = drawable2;
        n10 = R$styleable.TabLayout_tabIconTintMode;
        drawable2 = ViewUtils.parseTintMode(attributeSet.getInt(n10, n12), null);
        this.tabIconTintMode = drawable2;
        n10 = R$styleable.TabLayout_tabRippleColor;
        context = MaterialResources.getColorStateList(context, (TypedArray)attributeSet, n10);
        this.tabRippleColorStateList = context;
        int n16 = R$styleable.TabLayout_tabIndicatorAnimationDuration;
        this.tabIndicatorAnimationDuration = n16 = attributeSet.getInt(n16, 300);
        n16 = R$styleable.TabLayout_tabMinWidth;
        this.requestedTabMinWidth = n16 = attributeSet.getDimensionPixelSize(n16, n12);
        n16 = R$styleable.TabLayout_tabMaxWidth;
        this.requestedTabMaxWidth = n16 = attributeSet.getDimensionPixelSize(n16, n12);
        n16 = R$styleable.TabLayout_tabBackground;
        this.tabBackgroundResId = n16 = attributeSet.getResourceId(n16, 0);
        n16 = R$styleable.TabLayout_tabContentStart;
        this.contentInsetStart = n16 = attributeSet.getDimensionPixelSize(n16, 0);
        n16 = R$styleable.TabLayout_tabMode;
        this.mode = n16 = attributeSet.getInt(n16, n14);
        n16 = R$styleable.TabLayout_tabGravity;
        this.tabGravity = n16 = attributeSet.getInt(n16, 0);
        n16 = R$styleable.TabLayout_tabInlineLabel;
        n16 = (int)(attributeSet.getBoolean(n16, false) ? 1 : 0);
        this.inlineLabel = n16;
        n16 = R$styleable.TabLayout_tabUnboundedRipple;
        n16 = (int)(attributeSet.getBoolean(n16, false) ? 1 : 0);
        this.unboundedRipple = n16;
        attributeSet.recycle();
        context = this.getResources();
        int n17 = R$dimen.design_tab_text_size_2line;
        this.tabTextMultiLineSize = f10 = (float)context.getDimensionPixelSize(n17);
        n17 = R$dimen.design_tab_scrollable_min_width;
        this.scrollableTabMinWidth = n16 = context.getDimensionPixelSize(n17);
        this.applyModeAndGravity();
        return;
        finally {
            drawable2.recycle();
        }
    }

    public static /* synthetic */ RectF access$400(TabLayout tabLayout) {
        return tabLayout.tabViewContentBounds;
    }

    private void addTabFromItemView(TabItem object) {
        int n10;
        TabLayout$Tab tabLayout$Tab = this.newTab();
        CharSequence charSequence = object.text;
        if (charSequence != null) {
            tabLayout$Tab.setText(charSequence);
        }
        if ((charSequence = object.icon) != null) {
            tabLayout$Tab.setIcon((Drawable)charSequence);
        }
        if ((n10 = object.customLayout) != 0) {
            tabLayout$Tab.setCustomView(n10);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(charSequence = object.getContentDescription())) ? 1 : 0)) == 0) {
            object = object.getContentDescription();
            tabLayout$Tab.setContentDescription((CharSequence)object);
        }
        this.addTab(tabLayout$Tab);
    }

    private void addTabView(TabLayout$Tab tabLayout$Tab) {
        TabLayout$TabView tabLayout$TabView = tabLayout$Tab.view;
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
        int n10 = tabLayout$Tab.getPosition();
        LinearLayout.LayoutParams layoutParams = this.createLayoutParamsForTabs();
        tabLayout$SlidingTabIndicator.addView((View)tabLayout$TabView, n10, (ViewGroup.LayoutParams)layoutParams);
    }

    private void addViewInternal(View object) {
        boolean bl2 = object instanceof TabItem;
        if (bl2) {
            object = (TabItem)((Object)object);
            this.addTabFromItemView((TabItem)((Object)object));
            return;
        }
        object = new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        throw object;
    }

    private void animateToTab(int n10) {
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        Object object = this.getWindowToken();
        int n12 = 1;
        int n13 = 0;
        if (object != null && (n11 = (int)(ViewCompat.isLaidOut((View)this) ? 1 : 0)) != 0 && (n11 = (int)(((TabLayout$SlidingTabIndicator)((Object)(object = this.slidingTabIndicator))).childrenNeedLayout() ? 1 : 0)) == 0) {
            n11 = this.getScrollX();
            if (n11 != (n13 = this.calculateScrollXForTab(n10, 0.0f))) {
                this.ensureScrollAnimator();
                ValueAnimator valueAnimator = this.scrollAnimator;
                int n14 = 2;
                int[] nArray = new int[n14];
                nArray[0] = n11;
                nArray[n12] = n13;
                valueAnimator.setIntValues(nArray);
                object = this.scrollAnimator;
                object.start();
            }
            object = this.slidingTabIndicator;
            n12 = this.tabIndicatorAnimationDuration;
            ((TabLayout$SlidingTabIndicator)((Object)object)).animateIndicatorToPosition(n10, n12);
            return;
        }
        this.setScrollPosition(n10, 0.0f, n12 != 0);
    }

    private void applyModeAndGravity() {
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator;
        int n10;
        int n11 = this.mode;
        int n12 = 0;
        if (n11 == 0) {
            n11 = this.contentInsetStart;
            n10 = this.tabPaddingStart;
            n11 -= n10;
            n11 = Math.max(0, n11);
        } else {
            n11 = 0;
            tabLayout$SlidingTabIndicator = null;
        }
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator2 = this.slidingTabIndicator;
        ViewCompat.setPaddingRelative((View)tabLayout$SlidingTabIndicator2, n11, 0, 0, 0);
        n11 = this.mode;
        n12 = 1;
        if (n11 != 0) {
            if (n11 == n12) {
                tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
                tabLayout$SlidingTabIndicator.setGravity(n12);
            }
        } else {
            tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
            n10 = 0x800003;
            tabLayout$SlidingTabIndicator.setGravity(n10);
        }
        this.updateTabViews(n12 != 0);
    }

    private int calculateScrollXForTab(int n10, float f10) {
        int n11 = this.mode;
        int n12 = 0;
        float f11 = 0.0f;
        if (n11 == 0) {
            View view;
            View view2 = this.slidingTabIndicator.getChildAt(n10);
            TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
            int n13 = tabLayout$SlidingTabIndicator.getChildCount();
            if (++n10 < n13) {
                tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
                view = tabLayout$SlidingTabIndicator.getChildAt(n10);
            } else {
                n10 = 0;
                view = null;
            }
            if (view2 != null) {
                n13 = view2.getWidth();
            } else {
                n13 = 0;
                tabLayout$SlidingTabIndicator = null;
            }
            if (view != null) {
                n12 = view.getWidth();
            }
            n10 = view2.getLeft();
            n11 = n13 / 2;
            n10 += n11;
            n11 = this.getWidth() / 2;
            n10 -= n11;
            float f12 = n13 += n12;
            n12 = 0x3F000000;
            f11 = 0.5f;
            f12 = f12 * f11 * f10;
            int n14 = (int)f12;
            n11 = ViewCompat.getLayoutDirection((View)this);
            n10 = n11 == 0 ? (n10 += n14) : (n10 -= n14);
            return n10;
        }
        return 0;
    }

    private void configureTab(TabLayout$Tab object, int n10) {
        ((TabLayout$Tab)object).setPosition(n10);
        Object object2 = this.tabs;
        ((ArrayList)object2).add(n10, object);
        object = this.tabs;
        int n11 = ((ArrayList)object).size();
        while (++n10 < n11) {
            object2 = (TabLayout$Tab)this.tabs.get(n10);
            ((TabLayout$Tab)object2).setPosition(n10);
        }
    }

    private static ColorStateList createColorStateList(int n10, int n11) {
        int n12 = 2;
        int[][] nArrayArray = new int[n12][];
        int[] nArray = new int[n12];
        int[] nArray2 = HorizontalScrollView.SELECTED_STATE_SET;
        nArrayArray[0] = nArray2;
        nArray[0] = n11;
        int[] nArray3 = HorizontalScrollView.EMPTY_STATE_SET;
        int n13 = 1;
        nArrayArray[n13] = nArray3;
        nArray[n13] = n10;
        ColorStateList colorStateList = new ColorStateList((int[][])nArrayArray, nArray);
        return colorStateList;
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private TabLayout$TabView createTabView(TabLayout$Tab object) {
        Object object2;
        Object object3 = this.tabViewPool;
        object3 = object3 != null ? (TabLayout$TabView)((Object)object3.acquire()) : null;
        if (object3 == null) {
            object2 = this.getContext();
            object3 = new TabLayout$TabView(this, (Context)object2);
        }
        ((TabLayout$TabView)((Object)object3)).setTab((TabLayout$Tab)object);
        object3.setFocusable(true);
        int n10 = this.getTabMinWidth();
        object3.setMinimumWidth(n10);
        object2 = TabLayout$Tab.access$100((TabLayout$Tab)object);
        n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n10 != 0) {
            object = TabLayout$Tab.access$200((TabLayout$Tab)object);
            object3.setContentDescription((CharSequence)object);
        } else {
            object = TabLayout$Tab.access$100((TabLayout$Tab)object);
            object3.setContentDescription((CharSequence)object);
        }
        return object3;
    }

    private void dispatchTabReselected(TabLayout$Tab tabLayout$Tab) {
        ArrayList arrayList = this.selectedListeners;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener = (TabLayout$BaseOnTabSelectedListener)this.selectedListeners.get(i10);
            tabLayout$BaseOnTabSelectedListener.onTabReselected(tabLayout$Tab);
        }
    }

    private void dispatchTabSelected(TabLayout$Tab tabLayout$Tab) {
        ArrayList arrayList = this.selectedListeners;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener = (TabLayout$BaseOnTabSelectedListener)this.selectedListeners.get(i10);
            tabLayout$BaseOnTabSelectedListener.onTabSelected(tabLayout$Tab);
        }
    }

    private void dispatchTabUnselected(TabLayout$Tab tabLayout$Tab) {
        ArrayList arrayList = this.selectedListeners;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener = (TabLayout$BaseOnTabSelectedListener)this.selectedListeners.get(i10);
            tabLayout$BaseOnTabSelectedListener.onTabUnselected(tabLayout$Tab);
        }
    }

    private void ensureScrollAnimator() {
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator == null) {
            this.scrollAnimator = valueAnimator = new ValueAnimator();
            Object object = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            valueAnimator.setInterpolator(object);
            valueAnimator = this.scrollAnimator;
            int n10 = this.tabIndicatorAnimationDuration;
            long l10 = n10;
            valueAnimator.setDuration(l10);
            valueAnimator = this.scrollAnimator;
            object = new TabLayout$1(this);
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.tabs;
        int n10 = arrayList.size();
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl3;
            Drawable drawable2;
            Object object = (TabLayout$Tab)this.tabs.get(i10);
            if (object == null || (drawable2 = ((TabLayout$Tab)object).getIcon()) == null || (bl3 = TextUtils.isEmpty((CharSequence)(object = ((TabLayout$Tab)object).getText())))) continue;
            bl2 = true;
            break;
        }
        n10 = bl2 && (n10 = (int)(this.inlineLabel ? 1 : 0)) == 0 ? 72 : 48;
        return n10;
    }

    private int getTabMinWidth() {
        int n10 = this.requestedTabMinWidth;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.mode;
        n10 = n10 == 0 ? this.scrollableTabMinWidth : 0;
        return n10;
    }

    private int getTabScrollRange() {
        int n10 = this.slidingTabIndicator.getWidth();
        int n11 = this.getWidth();
        n10 -= n11;
        n11 = this.getPaddingLeft();
        n10 -= n11;
        n11 = this.getPaddingRight();
        return Math.max(0, n10 -= n11);
    }

    private void removeTabViewAt(int n10) {
        TabLayout$TabView tabLayout$TabView = (TabLayout$TabView)this.slidingTabIndicator.getChildAt(n10);
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
        tabLayout$SlidingTabIndicator.removeViewAt(n10);
        if (tabLayout$TabView != null) {
            tabLayout$TabView.reset();
            Pools$Pool pools$Pool = this.tabViewPool;
            pools$Pool.release((Object)tabLayout$TabView);
        }
        this.requestLayout();
    }

    private void setSelectedTabView(int n10) {
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
        int n11 = tabLayout$SlidingTabIndicator.getChildCount();
        if (n10 < n11) {
            for (int i10 = 0; i10 < n11; ++i10) {
                View view = this.slidingTabIndicator.getChildAt(i10);
                boolean bl2 = true;
                boolean bl3 = i10 == n10 ? bl2 : false;
                view.setSelected(bl3);
                if (i10 != n10) {
                    bl2 = false;
                }
                view.setActivated(bl2);
            }
        }
    }

    private void setupWithViewPager(ViewPager viewPager, boolean bl2, boolean bl3) {
        Object object;
        Object object2 = this.viewPager;
        if (object2 != null) {
            object = this.pageChangeListener;
            if (object != null) {
                object2.removeOnPageChangeListener((ViewPager$OnPageChangeListener)object);
            }
            if ((object2 = this.adapterChangeListener) != null) {
                object = this.viewPager;
                ((ViewPager)((Object)object)).removeOnAdapterChangeListener((ViewPager$OnAdapterChangeListener)object2);
            }
        }
        object2 = this.currentVpSelectedListener;
        object = null;
        if (object2 != null) {
            this.removeOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener)object2);
            this.currentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.viewPager = viewPager;
            object2 = this.pageChangeListener;
            if (object2 == null) {
                this.pageChangeListener = object2 = new TabLayout$TabLayoutOnPageChangeListener(this);
            }
            this.pageChangeListener.reset();
            object2 = this.pageChangeListener;
            viewPager.addOnPageChangeListener((ViewPager$OnPageChangeListener)object2);
            this.currentVpSelectedListener = object2 = new TabLayout$ViewPagerOnTabSelectedListener(viewPager);
            this.addOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener)object2);
            object2 = viewPager.getAdapter();
            if (object2 != null) {
                this.setPagerAdapter((PagerAdapter)object2, bl2);
            }
            if ((object2 = this.adapterChangeListener) == null) {
                this.adapterChangeListener = object2 = new TabLayout$AdapterChangeListener(this);
            }
            object2 = this.adapterChangeListener;
            ((TabLayout$AdapterChangeListener)object2).setAutoRefresh(bl2);
            TabLayout$AdapterChangeListener tabLayout$AdapterChangeListener = this.adapterChangeListener;
            viewPager.addOnAdapterChangeListener(tabLayout$AdapterChangeListener);
            int n10 = viewPager.getCurrentItem();
            bl2 = false;
            tabLayout$AdapterChangeListener = null;
            boolean bl4 = true;
            this.setScrollPosition(n10, 0.0f, bl4);
        } else {
            this.viewPager = null;
            boolean bl5 = false;
            viewPager = null;
            this.setPagerAdapter(null, false);
        }
        this.setupViewPagerImplicitly = bl3;
    }

    private void updateAllTabs() {
        ArrayList arrayList = this.tabs;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            TabLayout$Tab tabLayout$Tab = (TabLayout$Tab)this.tabs.get(i10);
            tabLayout$Tab.updateView();
        }
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        int n10 = this.mode;
        int n11 = 1;
        if (n10 == n11 && (n10 = this.tabGravity) == 0) {
            float f10;
            layoutParams.width = 0;
            n10 = 1065353216;
            layoutParams.weight = f10 = 1.0f;
        } else {
            layoutParams.width = -2;
            n10 = 0;
            float f11 = 0.0f;
            layoutParams.weight = 0.0f;
        }
    }

    public void addOnTabSelectedListener(TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener) {
        ArrayList arrayList = this.selectedListeners;
        boolean bl2 = arrayList.contains(tabLayout$BaseOnTabSelectedListener);
        if (!bl2) {
            arrayList = this.selectedListeners;
            arrayList.add(tabLayout$BaseOnTabSelectedListener);
        }
    }

    public void addTab(TabLayout$Tab tabLayout$Tab) {
        boolean bl2 = this.tabs.isEmpty();
        this.addTab(tabLayout$Tab, bl2);
    }

    public void addTab(TabLayout$Tab tabLayout$Tab, int n10) {
        boolean bl2 = this.tabs.isEmpty();
        this.addTab(tabLayout$Tab, n10, bl2);
    }

    public void addTab(TabLayout$Tab object, int n10, boolean bl2) {
        TabLayout tabLayout = ((TabLayout$Tab)object).parent;
        if (tabLayout == this) {
            this.configureTab((TabLayout$Tab)object, n10);
            this.addTabView((TabLayout$Tab)object);
            if (bl2) {
                ((TabLayout$Tab)object).select();
            }
            return;
        }
        object = new IllegalArgumentException("Tab belongs to a different TabLayout.");
        throw object;
    }

    public void addTab(TabLayout$Tab tabLayout$Tab, boolean bl2) {
        int n10 = this.tabs.size();
        this.addTab(tabLayout$Tab, n10, bl2);
    }

    public void addView(View view) {
        this.addViewInternal(view);
    }

    public void addView(View view, int n10) {
        this.addViewInternal(view);
    }

    public void addView(View view, int n10, ViewGroup.LayoutParams layoutParams) {
        this.addViewInternal(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        this.addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.selectedListeners.clear();
    }

    public TabLayout$Tab createTabFromPool() {
        TabLayout$Tab tabLayout$Tab = (TabLayout$Tab)tabPool.acquire();
        if (tabLayout$Tab == null) {
            tabLayout$Tab = new TabLayout$Tab();
        }
        return tabLayout$Tab;
    }

    public int dpToPx(int n10) {
        float f10 = this.getResources().getDisplayMetrics().density;
        float f11 = n10;
        return Math.round(f10 * f11);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        TabLayout$Tab tabLayout$Tab = this.selectedTab;
        int n10 = tabLayout$Tab != null ? tabLayout$Tab.getPosition() : -1;
        return n10;
    }

    public TabLayout$Tab getTabAt(int n10) {
        TabLayout$Tab tabLayout$Tab;
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.getTabCount())) {
            ArrayList arrayList = this.tabs;
            tabLayout$Tab = (TabLayout$Tab)arrayList.get(n10);
        } else {
            n10 = 0;
            tabLayout$Tab = null;
        }
        return tabLayout$Tab;
    }

    public int getTabCount() {
        return this.tabs.size();
    }

    public int getTabGravity() {
        return this.tabGravity;
    }

    public ColorStateList getTabIconTint() {
        return this.tabIconTint;
    }

    public int getTabIndicatorGravity() {
        return this.tabIndicatorGravity;
    }

    public int getTabMaxWidth() {
        return this.tabMaxWidth;
    }

    public int getTabMode() {
        return this.mode;
    }

    public ColorStateList getTabRippleColor() {
        return this.tabRippleColorStateList;
    }

    public Drawable getTabSelectedIndicator() {
        return this.tabSelectedIndicator;
    }

    public ColorStateList getTabTextColors() {
        return this.tabTextColors;
    }

    public boolean hasUnboundedRipple() {
        return this.unboundedRipple;
    }

    public boolean isInlineLabel() {
        return this.inlineLabel;
    }

    public boolean isTabIndicatorFullWidth() {
        return this.tabIndicatorFullWidth;
    }

    public TabLayout$Tab newTab() {
        TabLayout$TabView tabLayout$TabView;
        TabLayout$Tab tabLayout$Tab = this.createTabFromPool();
        tabLayout$Tab.parent = this;
        tabLayout$Tab.view = tabLayout$TabView = this.createTabView(tabLayout$Tab);
        return tabLayout$Tab;
    }

    public void onAttachedToWindow() {
        boolean bl2;
        super.onAttachedToWindow();
        ViewPager viewPager = this.viewPager;
        if (viewPager == null && (bl2 = (viewPager = this.getParent()) instanceof ViewPager)) {
            bl2 = true;
            this.setupWithViewPager(viewPager, bl2, bl2);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean bl2 = this.setupViewPagerImplicitly;
        if (bl2) {
            this.setupWithViewPager(null);
            bl2 = false;
            this.setupViewPagerImplicitly = false;
        }
    }

    public void onDraw(Canvas canvas) {
        LinearLayout linearLayout;
        int n10;
        for (int i10 = 0; i10 < (n10 = (linearLayout = this.slidingTabIndicator).getChildCount()); ++i10) {
            linearLayout = this.slidingTabIndicator.getChildAt(i10);
            boolean bl2 = linearLayout instanceof TabLayout$TabView;
            if (!bl2) continue;
            linearLayout = (TabLayout$TabView)linearLayout;
            TabLayout$TabView.access$300((TabLayout$TabView)linearLayout, canvas);
        }
        super.onDraw(canvas);
    }

    public void onMeasure(int n10, int n11) {
        block10: {
            ViewGroup.LayoutParams layoutParams;
            View view;
            int n12;
            int n13;
            block12: {
                block14: {
                    block13: {
                        int n14;
                        int n15;
                        block11: {
                            int n16;
                            n13 = this.getDefaultHeight();
                            n13 = this.dpToPx(n13);
                            int n17 = this.getPaddingTop();
                            n13 += n17;
                            n17 = this.getPaddingBottom();
                            n13 += n17;
                            n17 = View.MeasureSpec.getMode((int)n11);
                            n15 = -1 << -1;
                            n12 = 0x40000000;
                            if (n17 != n15) {
                                if (n17 == 0) {
                                    n11 = View.MeasureSpec.makeMeasureSpec((int)n13, (int)n12);
                                }
                            } else {
                                n11 = View.MeasureSpec.getSize((int)n11);
                                n11 = View.MeasureSpec.makeMeasureSpec((int)Math.min(n13, n11), (int)n12);
                            }
                            n13 = View.MeasureSpec.getSize((int)n10);
                            n17 = View.MeasureSpec.getMode((int)n10);
                            if (n17 != 0) {
                                n17 = this.requestedTabMaxWidth;
                                if (n17 <= 0) {
                                    n17 = this.dpToPx(56);
                                    n17 = n13 - n17;
                                }
                                this.tabMaxWidth = n17;
                            }
                            super.onMeasure(n10, n11);
                            n10 = this.getChildCount();
                            n13 = 1;
                            if (n10 != n13) break block10;
                            n10 = 0;
                            view = this.getChildAt(0);
                            n15 = this.mode;
                            if (n15 == 0) break block11;
                            if (n15 != n13) break block12;
                            n15 = view.getMeasuredWidth();
                            if (n15 == (n16 = this.getMeasuredWidth())) break block13;
                            break block14;
                        }
                        n15 = view.getMeasuredWidth();
                        if (n15 < (n14 = this.getMeasuredWidth())) break block14;
                    }
                    n13 = 0;
                    layoutParams = null;
                }
                n10 = n13;
            }
            if (n10 != 0) {
                n10 = this.getPaddingTop();
                n13 = this.getPaddingBottom();
                n10 += n13;
                layoutParams = view.getLayoutParams();
                n13 = layoutParams.height;
                n10 = HorizontalScrollView.getChildMeasureSpec((int)n11, (int)n10, (int)n13);
                n11 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)n12);
                view.measure(n11, n10);
            }
        }
    }

    public void populateFromPagerAdapter() {
        this.removeAllTabs();
        Object object = this.pagerAdapter;
        if (object != null) {
            int n10 = ((PagerAdapter)object).getCount();
            int n11 = 0;
            ViewPager viewPager = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                TabLayout$Tab tabLayout$Tab = this.newTab();
                CharSequence charSequence = this.pagerAdapter.getPageTitle(i10);
                tabLayout$Tab = tabLayout$Tab.setText(charSequence);
                this.addTab(tabLayout$Tab, false);
            }
            viewPager = this.viewPager;
            if (viewPager != null && n10 > 0 && (n10 = viewPager.getCurrentItem()) != (n11 = this.getSelectedTabPosition()) && n10 < (n11 = this.getTabCount())) {
                object = this.getTabAt(n10);
                this.selectTab((TabLayout$Tab)object);
            }
        }
    }

    public boolean releaseFromTabPool(TabLayout$Tab tabLayout$Tab) {
        return tabPool.release(tabLayout$Tab);
    }

    public void removeAllTabs() {
        boolean bl2;
        Object object = this.slidingTabIndicator;
        for (int i10 = object.getChildCount() + -1; i10 >= 0; i10 += -1) {
            this.removeTabViewAt(i10);
        }
        object = this.tabs.iterator();
        while (bl2 = object.hasNext()) {
            TabLayout$Tab tabLayout$Tab = (TabLayout$Tab)object.next();
            object.remove();
            tabLayout$Tab.reset();
            this.releaseFromTabPool(tabLayout$Tab);
        }
        this.selectedTab = null;
    }

    public void removeOnTabSelectedListener(TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener) {
        this.selectedListeners.remove(tabLayout$BaseOnTabSelectedListener);
    }

    public void removeTab(TabLayout$Tab object) {
        TabLayout tabLayout = ((TabLayout$Tab)object).parent;
        if (tabLayout == this) {
            int n10 = ((TabLayout$Tab)object).getPosition();
            this.removeTabAt(n10);
            return;
        }
        object = new IllegalArgumentException("Tab does not belong to this TabLayout.");
        throw object;
    }

    public void removeTabAt(int n10) {
        int n11;
        Object object = this.selectedTab;
        if (object != null) {
            n11 = ((TabLayout$Tab)object).getPosition();
        } else {
            n11 = 0;
            object = null;
        }
        this.removeTabViewAt(n10);
        Object object2 = (TabLayout$Tab)this.tabs.remove(n10);
        if (object2 != null) {
            ((TabLayout$Tab)object2).reset();
            this.releaseFromTabPool((TabLayout$Tab)object2);
        }
        object2 = this.tabs;
        int n12 = ((ArrayList)object2).size();
        for (int i10 = n10; i10 < n12; ++i10) {
            TabLayout$Tab tabLayout$Tab = (TabLayout$Tab)this.tabs.get(i10);
            tabLayout$Tab.setPosition(i10);
        }
        if (n11 == n10) {
            TabLayout$Tab tabLayout$Tab;
            object = this.tabs;
            n11 = (int)(((ArrayList)object).isEmpty() ? 1 : 0);
            if (n11 != 0) {
                n10 = 0;
                tabLayout$Tab = null;
            } else {
                object = this.tabs;
                n10 += -1;
                n10 = Math.max(0, n10);
                tabLayout$Tab = (TabLayout$Tab)((ArrayList)object).get(n10);
            }
            this.selectTab(tabLayout$Tab);
        }
    }

    public void selectTab(TabLayout$Tab tabLayout$Tab) {
        this.selectTab(tabLayout$Tab, true);
    }

    public void selectTab(TabLayout$Tab tabLayout$Tab, boolean n10) {
        TabLayout$Tab tabLayout$Tab2 = this.selectedTab;
        if (tabLayout$Tab2 == tabLayout$Tab) {
            if (tabLayout$Tab2 != null) {
                this.dispatchTabReselected(tabLayout$Tab);
                int n11 = tabLayout$Tab.getPosition();
                this.animateToTab(n11);
            }
        } else {
            int n12 = -1;
            int n13 = tabLayout$Tab != null ? tabLayout$Tab.getPosition() : n12;
            if (n10 != 0) {
                if ((tabLayout$Tab2 == null || (n10 = tabLayout$Tab2.getPosition()) == n12) && n13 != n12) {
                    n10 = 0;
                    boolean bl2 = true;
                    this.setScrollPosition(n13, 0.0f, bl2);
                } else {
                    this.animateToTab(n13);
                }
                if (n13 != n12) {
                    this.setSelectedTabView(n13);
                }
            }
            this.selectedTab = tabLayout$Tab;
            if (tabLayout$Tab2 != null) {
                this.dispatchTabUnselected(tabLayout$Tab2);
            }
            if (tabLayout$Tab != null) {
                this.dispatchTabSelected(tabLayout$Tab);
            }
        }
    }

    public void setInlineLabel(boolean n10) {
        int n11 = this.inlineLabel;
        if (n11 != n10) {
            LinearLayout linearLayout;
            this.inlineLabel = n10;
            for (n10 = 0; n10 < (n11 = (linearLayout = this.slidingTabIndicator).getChildCount()); ++n10) {
                linearLayout = this.slidingTabIndicator.getChildAt(n10);
                boolean bl2 = linearLayout instanceof TabLayout$TabView;
                if (!bl2) continue;
                linearLayout = (TabLayout$TabView)linearLayout;
                linearLayout.updateOrientation();
            }
            this.applyModeAndGravity();
        }
    }

    public void setInlineLabelResource(int n10) {
        n10 = (int)(this.getResources().getBoolean(n10) ? 1 : 0);
        this.setInlineLabel(n10 != 0);
    }

    public void setOnTabSelectedListener(TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener) {
        TabLayout$BaseOnTabSelectedListener tabLayout$BaseOnTabSelectedListener2 = this.selectedListener;
        if (tabLayout$BaseOnTabSelectedListener2 != null) {
            this.removeOnTabSelectedListener(tabLayout$BaseOnTabSelectedListener2);
        }
        this.selectedListener = tabLayout$BaseOnTabSelectedListener;
        if (tabLayout$BaseOnTabSelectedListener != null) {
            this.addOnTabSelectedListener(tabLayout$BaseOnTabSelectedListener);
        }
    }

    public void setPagerAdapter(PagerAdapter pagerAdapter, boolean bl2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.pagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.pagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.pagerAdapter = pagerAdapter;
        if (bl2 && pagerAdapter != null) {
            DataSetObserver dataSetObserver2 = this.pagerAdapterObserver;
            if (dataSetObserver2 == null) {
                this.pagerAdapterObserver = dataSetObserver2 = new TabLayout$PagerAdapterObserver(this);
            }
            dataSetObserver2 = this.pagerAdapterObserver;
            pagerAdapter.registerDataSetObserver(dataSetObserver2);
        }
        this.populateFromPagerAdapter();
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.ensureScrollAnimator();
        this.scrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int n10, float f10, boolean bl2) {
        this.setScrollPosition(n10, f10, bl2, true);
    }

    public void setScrollPosition(int n10, float f10, boolean bl2, boolean bl3) {
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator;
        int n11;
        float f11 = (float)n10 + f10;
        int n12 = Math.round(f11);
        if (n12 >= 0 && n12 < (n11 = (tabLayout$SlidingTabIndicator = this.slidingTabIndicator).getChildCount())) {
            TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator2;
            if (bl3) {
                tabLayout$SlidingTabIndicator2 = this.slidingTabIndicator;
                tabLayout$SlidingTabIndicator2.setIndicatorPositionFromTabPosition(n10, f10);
            }
            if ((tabLayout$SlidingTabIndicator2 = this.scrollAnimator) != null && (bl3 = tabLayout$SlidingTabIndicator2.isRunning())) {
                tabLayout$SlidingTabIndicator2 = this.scrollAnimator;
                tabLayout$SlidingTabIndicator2.cancel();
            }
            n10 = this.calculateScrollXForTab(n10, f10);
            f10 = 0.0f;
            this.scrollTo(n10, 0);
            if (bl2) {
                this.setSelectedTabView(n12);
            }
        }
    }

    public void setSelectedTabIndicator(int n10) {
        if (n10 != 0) {
            Context context = this.getContext();
            Drawable drawable2 = AppCompatResources.getDrawable(context, n10);
            this.setSelectedTabIndicator(drawable2);
        } else {
            n10 = 0;
            Object var3_4 = null;
            this.setSelectedTabIndicator(null);
        }
    }

    public void setSelectedTabIndicator(Drawable object) {
        Drawable drawable2 = this.tabSelectedIndicator;
        if (drawable2 != object) {
            this.tabSelectedIndicator = object;
            object = this.slidingTabIndicator;
            ViewCompat.postInvalidateOnAnimation((View)object);
        }
    }

    public void setSelectedTabIndicatorColor(int n10) {
        this.slidingTabIndicator.setSelectedIndicatorColor(n10);
    }

    public void setSelectedTabIndicatorGravity(int n10) {
        int n11 = this.tabIndicatorGravity;
        if (n11 != n10) {
            this.tabIndicatorGravity = n10;
            TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator = this.slidingTabIndicator;
            ViewCompat.postInvalidateOnAnimation((View)tabLayout$SlidingTabIndicator);
        }
    }

    public void setSelectedTabIndicatorHeight(int n10) {
        this.slidingTabIndicator.setSelectedIndicatorHeight(n10);
    }

    public void setTabGravity(int n10) {
        int n11 = this.tabGravity;
        if (n11 != n10) {
            this.tabGravity = n10;
            this.applyModeAndGravity();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.tabIconTint;
        if (colorStateList2 != colorStateList) {
            this.tabIconTint = colorStateList;
            this.updateAllTabs();
        }
    }

    public void setTabIconTintResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.getContext(), n10);
        this.setTabIconTint(colorStateList);
    }

    public void setTabIndicatorFullWidth(boolean bl2) {
        this.tabIndicatorFullWidth = bl2;
        ViewCompat.postInvalidateOnAnimation((View)this.slidingTabIndicator);
    }

    public void setTabMode(int n10) {
        int n11 = this.mode;
        if (n10 != n11) {
            this.mode = n10;
            this.applyModeAndGravity();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        Object object = this.tabRippleColorStateList;
        if (object != colorStateList) {
            int n10;
            this.tabRippleColorStateList = colorStateList;
            colorStateList = null;
            for (int i10 = 0; i10 < (n10 = (object = this.slidingTabIndicator).getChildCount()); ++i10) {
                object = this.slidingTabIndicator.getChildAt(i10);
                boolean bl2 = object instanceof TabLayout$TabView;
                if (!bl2) continue;
                object = (TabLayout$TabView)((Object)object);
                Context context = this.getContext();
                TabLayout$TabView.access$000((TabLayout$TabView)((Object)object), context);
            }
        }
    }

    public void setTabRippleColorResource(int n10) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(this.getContext(), n10);
        this.setTabRippleColor(colorStateList);
    }

    public void setTabTextColors(int n10, int n11) {
        ColorStateList colorStateList = TabLayout.createColorStateList(n10, n11);
        this.setTabTextColors(colorStateList);
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.tabTextColors;
        if (colorStateList2 != colorStateList) {
            this.tabTextColors = colorStateList;
            this.updateAllTabs();
        }
    }

    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        this.setPagerAdapter(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean n10) {
        int n11 = this.unboundedRipple;
        if (n11 != n10) {
            LinearLayout linearLayout;
            this.unboundedRipple = n10;
            for (n10 = 0; n10 < (n11 = (linearLayout = this.slidingTabIndicator).getChildCount()); ++n10) {
                linearLayout = this.slidingTabIndicator.getChildAt(n10);
                boolean bl2 = linearLayout instanceof TabLayout$TabView;
                if (!bl2) continue;
                linearLayout = (TabLayout$TabView)linearLayout;
                Context context = this.getContext();
                TabLayout$TabView.access$000((TabLayout$TabView)linearLayout, context);
            }
        }
    }

    public void setUnboundedRippleResource(int n10) {
        n10 = (int)(this.getResources().getBoolean(n10) ? 1 : 0);
        this.setUnboundedRipple(n10 != 0);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.setupWithViewPager(viewPager, true);
    }

    public void setupWithViewPager(ViewPager viewPager, boolean bl2) {
        this.setupWithViewPager(viewPager, bl2, false);
    }

    public boolean shouldDelayChildPressedState() {
        int n10 = this.getTabScrollRange();
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public void updateTabViews(boolean bl2) {
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator;
        int n10;
        for (int i10 = 0; i10 < (n10 = (tabLayout$SlidingTabIndicator = this.slidingTabIndicator).getChildCount()); ++i10) {
            tabLayout$SlidingTabIndicator = this.slidingTabIndicator.getChildAt(i10);
            int n11 = this.getTabMinWidth();
            tabLayout$SlidingTabIndicator.setMinimumWidth(n11);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)tabLayout$SlidingTabIndicator.getLayoutParams();
            this.updateTabViewLayoutParams(layoutParams);
            if (!bl2) continue;
            tabLayout$SlidingTabIndicator.requestLayout();
        }
    }
}

