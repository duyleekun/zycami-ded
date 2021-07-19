/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener;
import com.google.android.material.appbar.CollapsingToolbarLayout$2;
import com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams;
import com.google.android.material.appbar.CollapsingToolbarLayout$OffsetUpdateListener;
import com.google.android.material.appbar.ViewOffsetHelper;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;

public class CollapsingToolbarLayout
extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    public final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;
    private Drawable contentScrim;
    public int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    public WindowInsetsCompat lastInsets;
    private AppBarLayout$OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;
    public Drawable statusBarScrim;
    private final Rect tmpRect;
    private Toolbar toolbar;
    private View toolbarDirectChild;
    private int toolbarId;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context object, AttributeSet object2, int n10) {
        super(object, object2, n10);
        long l10;
        CollapsingTextHelper collapsingTextHelper;
        int n11;
        Rect rect;
        boolean bl2;
        this.refreshToolbar = bl2 = true;
        this.tmpRect = rect = new Rect();
        this.scrimVisibleHeightTrigger = n11 = -1;
        this.collapsingTextHelper = collapsingTextHelper = new CollapsingTextHelper((View)this);
        TimeInterpolator timeInterpolator = AnimationUtils.DECELERATE_INTERPOLATOR;
        collapsingTextHelper.setTextSizeInterpolator(timeInterpolator);
        int[] nArray = R$styleable.CollapsingToolbarLayout;
        int n12 = R$style.Widget_Design_CollapsingToolbar;
        timeInterpolator = null;
        int[] nArray2 = new int[]{};
        object = ThemeEnforcement.obtainStyledAttributes(object, object2, nArray, n10, n12, nArray2);
        int n13 = R$styleable.CollapsingToolbarLayout_expandedTitleGravity;
        n13 = object.getInt(n13, 8388691);
        collapsingTextHelper.setExpandedTextGravity(n13);
        n13 = R$styleable.CollapsingToolbarLayout_collapsedTitleGravity;
        n13 = object.getInt(n13, 8388627);
        collapsingTextHelper.setCollapsedTextGravity(n13);
        n13 = R$styleable.CollapsingToolbarLayout_expandedTitleMargin;
        this.expandedMarginBottom = n13 = object.getDimensionPixelSize(n13, 0);
        this.expandedMarginEnd = n13;
        this.expandedMarginTop = n13;
        this.expandedMarginStart = n13;
        n13 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        n10 = (int)(object.hasValue(n13) ? 1 : 0);
        if (n10 != 0) {
            this.expandedMarginStart = n13 = object.getDimensionPixelSize(n13, 0);
        }
        if ((n10 = (int)(object.hasValue(n13 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd) ? 1 : 0)) != 0) {
            this.expandedMarginEnd = n13 = object.getDimensionPixelSize(n13, 0);
        }
        if ((n10 = (int)(object.hasValue(n13 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop) ? 1 : 0)) != 0) {
            this.expandedMarginTop = n13 = object.getDimensionPixelSize(n13, 0);
        }
        if ((n10 = (int)(object.hasValue(n13 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom) ? 1 : 0)) != 0) {
            this.expandedMarginBottom = n13 = object.getDimensionPixelSize(n13, 0);
        }
        n13 = R$styleable.CollapsingToolbarLayout_titleEnabled;
        n13 = (int)(object.getBoolean(n13, bl2) ? 1 : 0);
        this.collapsingTitleEnabled = n13;
        n13 = R$styleable.CollapsingToolbarLayout_title;
        object2 = object.getText(n13);
        this.setTitle((CharSequence)object2);
        n13 = R$style.TextAppearance_Design_CollapsingToolbar_Expanded;
        collapsingTextHelper.setExpandedTextAppearance(n13);
        n13 = androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title;
        collapsingTextHelper.setCollapsedTextAppearance(n13);
        n13 = R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        n10 = (int)(object.hasValue(n13) ? 1 : 0);
        if (n10 != 0) {
            n13 = object.getResourceId(n13, 0);
            collapsingTextHelper.setExpandedTextAppearance(n13);
        }
        if ((n10 = (int)(object.hasValue(n13 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance) ? 1 : 0)) != 0) {
            n13 = object.getResourceId(n13, 0);
            collapsingTextHelper.setCollapsedTextAppearance(n13);
        }
        n13 = R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger;
        this.scrimVisibleHeightTrigger = n13 = object.getDimensionPixelSize(n13, n11);
        n13 = R$styleable.CollapsingToolbarLayout_scrimAnimationDuration;
        this.scrimAnimationDuration = l10 = (long)object.getInt(n13, 600);
        n13 = R$styleable.CollapsingToolbarLayout_contentScrim;
        object2 = object.getDrawable(n13);
        this.setContentScrim((Drawable)object2);
        n13 = R$styleable.CollapsingToolbarLayout_statusBarScrim;
        object2 = object.getDrawable(n13);
        this.setStatusBarScrim((Drawable)object2);
        n13 = R$styleable.CollapsingToolbarLayout_toolbarId;
        this.toolbarId = n13 = object.getResourceId(n13, n11);
        object.recycle();
        this.setWillNotDraw(false);
        super(this);
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)object);
    }

    private void animateScrim(int n10) {
        Object object;
        this.ensureToolbar();
        ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            this.scrimAnimator = valueAnimator = new ValueAnimator();
            long l10 = this.scrimAnimationDuration;
            valueAnimator.setDuration(l10);
            valueAnimator = this.scrimAnimator;
            int n11 = this.scrimAlpha;
            object = n10 > n11 ? (Object)AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : (Object)AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            valueAnimator.setInterpolator((TimeInterpolator)object);
            valueAnimator = this.scrimAnimator;
            object = new CollapsingToolbarLayout$2;
            ((CollapsingToolbarLayout$2)object)(this);
            valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        } else {
            boolean bl2 = valueAnimator.isRunning();
            if (bl2) {
                valueAnimator = this.scrimAnimator;
                valueAnimator.cancel();
            }
        }
        valueAnimator = this.scrimAnimator;
        int n12 = this.scrimAlpha;
        object = new int[]{n12, n10};
        valueAnimator.setIntValues((int[])object);
        this.scrimAnimator.start();
    }

    private void ensureToolbar() {
        Toolbar toolbar;
        boolean bl2 = this.refreshToolbar;
        if (!bl2) {
            return;
        }
        bl2 = false;
        Object object = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int n10 = this.toolbarId;
        int n11 = -1;
        if (n10 != n11) {
            this.toolbar = toolbar = (Toolbar)this.findViewById(n10);
            if (toolbar != null) {
                toolbar = this.findDirectChild((View)toolbar);
                this.toolbarDirectChild = toolbar;
            }
        }
        toolbar = this.toolbar;
        n11 = 0;
        if (toolbar == null) {
            n10 = this.getChildCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                View view = this.getChildAt(i10);
                boolean bl3 = view instanceof Toolbar;
                if (!bl3) continue;
                object = view;
                object = (Toolbar)view;
                break;
            }
            this.toolbar = object;
        }
        this.updateDummyView();
        this.refreshToolbar = false;
    }

    private View findDirectChild(View view) {
        for (ViewParent viewParent = view.getParent(); viewParent != this && viewParent != null; viewParent = viewParent.getParent()) {
            boolean bl2 = viewParent instanceof View;
            if (!bl2) continue;
            view = viewParent;
            view = (View)viewParent;
        }
        return view;
    }

    private static int getHeightWithMargins(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int n10 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        if (n10 != 0) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            int n11 = view.getHeight();
            n10 = layoutParams.topMargin;
            int n12 = layoutParams.bottomMargin;
            return (n11 += n10) + n12;
        }
        return view.getHeight();
    }

    public static ViewOffsetHelper getViewOffsetHelper(View view) {
        int n10 = R$id.view_offset_helper;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper)view.getTag(n10);
        if (viewOffsetHelper == null) {
            viewOffsetHelper = new ViewOffsetHelper(view);
            view.setTag(n10, (Object)viewOffsetHelper);
        }
        return viewOffsetHelper;
    }

    private boolean isToolbarChild(View view) {
        Object object = this.toolbarDirectChild;
        boolean bl2 = true;
        if (!(object != null && object != this ? view == object : view == (object = this.toolbar))) {
            bl2 = false;
        }
        return bl2;
    }

    private void updateContentDescriptionFromTitle() {
        CharSequence charSequence = this.getTitle();
        this.setContentDescription(charSequence);
    }

    private void updateDummyView() {
        View view;
        boolean bl2;
        Object object;
        boolean bl3 = this.collapsingTitleEnabled;
        if (!bl3 && (object = this.dummyView) != null && (bl2 = (object = object.getParent()) instanceof ViewGroup)) {
            object = (ViewGroup)object;
            view = this.dummyView;
            object.removeView(view);
        }
        if ((bl3 = this.collapsingTitleEnabled) && (object = this.toolbar) != null) {
            object = this.dummyView;
            if (object == null) {
                view = this.getContext();
                this.dummyView = object = new View((Context)view);
            }
            if ((object = this.dummyView.getParent()) == null) {
                object = this.toolbar;
                view = this.dummyView;
                int n10 = -1;
                object.addView(view, n10, n10);
            }
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof CollapsingToolbarLayout$LayoutParams;
    }

    public void draw(Canvas canvas) {
        int n10;
        int n11;
        super.draw(canvas);
        this.ensureToolbar();
        Object object = this.toolbar;
        if (object == null && (object = this.contentScrim) != null && (n11 = this.scrimAlpha) > 0) {
            object = object.mutate();
            n11 = this.scrimAlpha;
            object.setAlpha(n11);
            object = this.contentScrim;
            object.draw(canvas);
        }
        if ((n10 = this.collapsingTitleEnabled) != 0 && (n10 = this.drawCollapsingTitle) != 0) {
            object = this.collapsingTextHelper;
            ((CollapsingTextHelper)object).draw(canvas);
        }
        if ((object = this.statusBarScrim) != null && (n10 = this.scrimAlpha) > 0) {
            object = this.lastInsets;
            n11 = 0;
            if (object != null) {
                n10 = ((WindowInsetsCompat)object).getSystemWindowInsetTop();
            } else {
                n10 = 0;
                object = null;
            }
            if (n10 > 0) {
                Drawable drawable2 = this.statusBarScrim;
                int n12 = -this.currentOffset;
                int n13 = this.getWidth();
                int n14 = this.currentOffset;
                drawable2.setBounds(0, n12, n13, n10 -= n14);
                object = this.statusBarScrim.mutate();
                n11 = this.scrimAlpha;
                object.setAlpha(n11);
                object = this.statusBarScrim;
                object.draw(canvas);
            }
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l10) {
        int n10;
        Drawable drawable2 = this.contentScrim;
        int n11 = 1;
        if (drawable2 != null && (n10 = this.scrimAlpha) > 0 && (n10 = (int)(this.isToolbarChild(view) ? 1 : 0)) != 0) {
            drawable2 = this.contentScrim.mutate();
            int n12 = this.scrimAlpha;
            drawable2.setAlpha(n12);
            drawable2 = this.contentScrim;
            drawable2.draw(canvas);
            n10 = n11;
        } else {
            n10 = 0;
            drawable2 = null;
        }
        boolean bl2 = super.drawChild(canvas, view, l10);
        if (!bl2 && n10 == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void drawableStateChanged() {
        boolean bl2;
        boolean bl3;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        Object object = this.statusBarScrim;
        boolean bl4 = false;
        if (object != null && (bl3 = object.isStateful())) {
            bl2 = object.setState(nArray);
            bl4 = false | bl2;
        }
        if ((object = this.contentScrim) != null && (bl3 = object.isStateful())) {
            bl2 = object.setState(nArray);
            bl4 |= bl2;
        }
        if ((object = this.collapsingTextHelper) != null) {
            boolean bl5 = ((CollapsingTextHelper)object).setState(nArray);
            bl4 |= bl5;
        }
        if (bl4) {
            this.invalidate();
        }
    }

    public CollapsingToolbarLayout$LayoutParams generateDefaultLayoutParams() {
        int n10 = -1;
        CollapsingToolbarLayout$LayoutParams collapsingToolbarLayout$LayoutParams = new CollapsingToolbarLayout$LayoutParams(n10, n10);
        return collapsingToolbarLayout$LayoutParams;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        CollapsingToolbarLayout$LayoutParams collapsingToolbarLayout$LayoutParams = new CollapsingToolbarLayout$LayoutParams(context, attributeSet);
        return collapsingToolbarLayout$LayoutParams;
    }

    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        CollapsingToolbarLayout$LayoutParams collapsingToolbarLayout$LayoutParams = new CollapsingToolbarLayout$LayoutParams(layoutParams);
        return collapsingToolbarLayout$LayoutParams;
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    public final int getMaxOffsetForPinChild(View view) {
        ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(view);
        CollapsingToolbarLayout$LayoutParams collapsingToolbarLayout$LayoutParams = (CollapsingToolbarLayout$LayoutParams)view.getLayoutParams();
        int n10 = this.getHeight();
        int n11 = viewOffsetHelper.getLayoutTop();
        n10 -= n11;
        int n12 = view.getHeight();
        n10 -= n12;
        n12 = collapsingToolbarLayout$LayoutParams.bottomMargin;
        return n10 - n12;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int n10 = this.scrimVisibleHeightTrigger;
        if (n10 >= 0) {
            return n10;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            n10 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            n10 = 0;
            windowInsetsCompat = null;
        }
        int n11 = ViewCompat.getMinimumHeight((View)this);
        if (n11 > 0) {
            n11 = n11 * 2 + n10;
            n10 = this.getHeight();
            return Math.min(n11, n10);
        }
        return this.getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public CharSequence getTitle() {
        CharSequence charSequence;
        boolean bl2 = this.collapsingTitleEnabled;
        if (bl2) {
            charSequence = this.collapsingTextHelper.getText();
        } else {
            bl2 = false;
            charSequence = null;
        }
        return charSequence;
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object object = this.getParent();
        boolean bl2 = object instanceof AppBarLayout;
        if (bl2) {
            Object object2 = object;
            bl2 = ViewCompat.getFitsSystemWindows((View)object);
            ViewCompat.setFitsSystemWindows((View)this, bl2);
            object2 = this.onOffsetChangedListener;
            if (object2 == null) {
                object2 = new CollapsingToolbarLayout$OffsetUpdateListener(this);
                this.onOffsetChangedListener = object2;
            }
            object = (AppBarLayout)((Object)object);
            object2 = this.onOffsetChangedListener;
            ((AppBarLayout)((Object)object)).addOnOffsetChangedListener((AppBarLayout$OnOffsetChangedListener)object2);
            ViewCompat.requestApplyInsets((View)this);
        }
    }

    public void onDetachedFromWindow() {
        boolean bl2;
        Object object = this.getParent();
        AppBarLayout$OnOffsetChangedListener appBarLayout$OnOffsetChangedListener = this.onOffsetChangedListener;
        if (appBarLayout$OnOffsetChangedListener != null && (bl2 = object instanceof AppBarLayout)) {
            object = (AppBarLayout)((Object)object);
            ((AppBarLayout)((Object)object)).removeOnOffsetChangedListener(appBarLayout$OnOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        int n15;
        View view;
        int n16;
        Object object;
        int n17;
        super.onLayout(n10 != 0, n11, n12, n13, n14);
        Object object2 = this.lastInsets;
        int n18 = 0;
        if (object2 != null) {
            n10 = object2.getSystemWindowInsetTop();
            n17 = this.getChildCount();
            object = null;
            for (n16 = 0; n16 < n17; ++n16) {
                view = this.getChildAt(n16);
                n15 = ViewCompat.getFitsSystemWindows(view);
                if (n15 != 0 || (n15 = view.getTop()) >= n10) continue;
                ViewCompat.offsetTopAndBottom(view, n10);
            }
        }
        if ((n10 = this.collapsingTitleEnabled) != 0 && (object2 = this.dummyView) != null) {
            n10 = ViewCompat.isAttachedToWindow((View)object2);
            n17 = 1;
            if (n10 != 0 && (n10 = (object2 = this.dummyView).getVisibility()) == 0) {
                n10 = n17;
            } else {
                n10 = 0;
                object2 = null;
            }
            this.drawCollapsingTitle = n10;
            if (n10 != 0) {
                int n19;
                Toolbar toolbar;
                Toolbar toolbar2;
                n10 = ViewCompat.getLayoutDirection((View)this);
                if (n10 != n17) {
                    n17 = 0;
                }
                object2 = this.toolbarDirectChild;
                if (object2 == null) {
                    object2 = this.toolbar;
                }
                n10 = this.getMaxOffsetForPinChild((View)object2);
                object = this.dummyView;
                view = this.tmpRect;
                DescendantOffsetUtils.getDescendantRect((ViewGroup)this, (View)object, (Rect)view);
                object = this.collapsingTextHelper;
                view = this.tmpRect;
                int n20 = view.left;
                if (n17 != 0) {
                    toolbar2 = this.toolbar;
                    n15 = toolbar2.getTitleMarginEnd();
                } else {
                    toolbar2 = this.toolbar;
                    n15 = toolbar2.getTitleMarginStart();
                }
                n20 += n15;
                toolbar2 = this.tmpRect;
                n15 = ((Rect)toolbar2).top + n10;
                int n21 = this.toolbar.getTitleMarginTop();
                n15 += n21;
                Rect rect = this.tmpRect;
                n21 = rect.right;
                if (n17 != 0) {
                    toolbar = this.toolbar;
                    n19 = toolbar.getTitleMarginStart();
                } else {
                    toolbar = this.toolbar;
                    n19 = toolbar.getTitleMarginEnd();
                }
                n21 += n19;
                toolbar = this.tmpRect;
                n19 = ((Rect)toolbar).bottom + n10;
                n10 = this.toolbar.getTitleMarginBottom();
                ((CollapsingTextHelper)object).setCollapsedBounds(n20, n15, n21, n19 -= n10);
                object2 = this.collapsingTextHelper;
                n16 = n17 != 0 ? this.expandedMarginEnd : this.expandedMarginStart;
                view = this.tmpRect;
                n20 = view.top;
                n15 = this.expandedMarginTop;
                n13 -= n11;
                n11 = n17 != 0 ? this.expandedMarginStart : this.expandedMarginEnd;
                n13 -= n11;
                n14 -= n12;
                n11 = this.expandedMarginBottom;
                ((CollapsingTextHelper)object2).setExpandedBounds(n16, n20 += n15, n13, n14 -= n11);
                object2 = this.collapsingTextHelper;
                ((CollapsingTextHelper)object2).recalculate();
            }
        }
        n10 = this.getChildCount();
        while (n18 < n10) {
            ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(this.getChildAt(n18));
            viewOffsetHelper.onViewLayout();
            ++n18;
        }
        object2 = this.toolbar;
        if (object2 != null) {
            n10 = this.collapsingTitleEnabled;
            if (n10 != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(object2 = this.collapsingTextHelper.getText())) ? 1 : 0)) != 0) {
                object2 = this.toolbar.getTitle();
                this.setTitle((CharSequence)object2);
            }
            if ((object2 = this.toolbarDirectChild) != null && object2 != this) {
                n10 = CollapsingToolbarLayout.getHeightWithMargins((View)object2);
                this.setMinimumHeight(n10);
            } else {
                object2 = this.toolbar;
                n10 = CollapsingToolbarLayout.getHeightWithMargins((View)object2);
                this.setMinimumHeight(n10);
            }
        }
        this.updateScrimVisibility();
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        this.ensureToolbar();
        super.onMeasure(n10, n11);
        n11 = View.MeasureSpec.getMode((int)n11);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            n12 = windowInsetsCompat.getSystemWindowInsetTop();
        } else {
            n12 = 0;
            windowInsetsCompat = null;
        }
        if (n11 == 0 && n12 > 0) {
            n11 = this.getMeasuredHeight() + n12;
            n12 = 0x40000000;
            n11 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n12);
            super.onMeasure(n10, n11);
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null) {
            n13 = 0;
            drawable2.setBounds(0, 0, n10, n11);
        }
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
            this.requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void setCollapsedTitleGravity(int n10) {
        this.collapsingTextHelper.setCollapsedTextGravity(n10);
    }

    public void setCollapsedTitleTextAppearance(int n10) {
        this.collapsingTextHelper.setCollapsedTextAppearance(n10);
    }

    public void setCollapsedTitleTextColor(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setCollapsedTitleTextColor(colorStateList);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.collapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(Drawable drawable2) {
        Drawable drawable3 = this.contentScrim;
        if (drawable3 != drawable2) {
            Drawable drawable4 = null;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            if (drawable2 != null) {
                drawable4 = drawable2.mutate();
            }
            this.contentScrim = drawable4;
            if (drawable4 != null) {
                int n10 = this.getWidth();
                int n11 = this.getHeight();
                drawable4.setBounds(0, 0, n10, n11);
                this.contentScrim.setCallback((Drawable.Callback)this);
                drawable2 = this.contentScrim;
                n11 = this.scrimAlpha;
                drawable2.setAlpha(n11);
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void setContentScrimColor(int n10) {
        ColorDrawable colorDrawable = new ColorDrawable(n10);
        this.setContentScrim((Drawable)colorDrawable);
    }

    public void setContentScrimResource(int n10) {
        Drawable drawable2 = ContextCompat.getDrawable(this.getContext(), n10);
        this.setContentScrim(drawable2);
    }

    public void setExpandedTitleColor(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setExpandedTitleTextColor(colorStateList);
    }

    public void setExpandedTitleGravity(int n10) {
        this.collapsingTextHelper.setExpandedTextGravity(n10);
    }

    public void setExpandedTitleMargin(int n10, int n11, int n12, int n13) {
        this.expandedMarginStart = n10;
        this.expandedMarginTop = n11;
        this.expandedMarginEnd = n12;
        this.expandedMarginBottom = n13;
        this.requestLayout();
    }

    public void setExpandedTitleMarginBottom(int n10) {
        this.expandedMarginBottom = n10;
        this.requestLayout();
    }

    public void setExpandedTitleMarginEnd(int n10) {
        this.expandedMarginEnd = n10;
        this.requestLayout();
    }

    public void setExpandedTitleMarginStart(int n10) {
        this.expandedMarginStart = n10;
        this.requestLayout();
    }

    public void setExpandedTitleMarginTop(int n10) {
        this.expandedMarginTop = n10;
        this.requestLayout();
    }

    public void setExpandedTitleTextAppearance(int n10) {
        this.collapsingTextHelper.setExpandedTextAppearance(n10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.collapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.collapsingTextHelper.setExpandedTypeface(typeface);
    }

    public void setScrimAlpha(int n10) {
        int n11 = this.scrimAlpha;
        if (n10 != n11) {
            Object object = this.contentScrim;
            if (object != null && (object = this.toolbar) != null) {
                ViewCompat.postInvalidateOnAnimation((View)object);
            }
            this.scrimAlpha = n10;
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void setScrimAnimationDuration(long l10) {
        this.scrimAnimationDuration = l10;
    }

    public void setScrimVisibleHeightTrigger(int n10) {
        int n11 = this.scrimVisibleHeightTrigger;
        if (n11 != n10) {
            this.scrimVisibleHeightTrigger = n10;
            this.updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean bl2) {
        boolean bl3 = ViewCompat.isLaidOut((View)this);
        bl3 = bl3 && !(bl3 = this.isInEditMode());
        this.setScrimsShown(bl2, bl3);
    }

    public void setScrimsShown(boolean n10, boolean bl2) {
        int n11 = this.scrimsAreShown;
        if (n11 != n10) {
            n11 = 255;
            if (bl2) {
                if (!n10) {
                    n11 = 0;
                }
                this.animateScrim(n11);
            } else {
                if (!n10) {
                    n11 = 0;
                }
                this.setScrimAlpha(n11);
            }
            this.scrimsAreShown = n10;
        }
    }

    public void setStatusBarScrim(Drawable drawable2) {
        Object object = this.statusBarScrim;
        if (object != drawable2) {
            Drawable drawable3 = null;
            if (object != null) {
                object.setCallback(null);
            }
            if (drawable2 != null) {
                drawable3 = drawable2.mutate();
            }
            this.statusBarScrim = drawable3;
            if (drawable3 != null) {
                boolean bl2 = drawable3.isStateful();
                if (bl2) {
                    drawable2 = this.statusBarScrim;
                    object = this.getDrawableState();
                    drawable2.setState((int[])object);
                }
                drawable2 = this.statusBarScrim;
                int n10 = ViewCompat.getLayoutDirection((View)this);
                DrawableCompat.setLayoutDirection(drawable2, n10);
                drawable2 = this.statusBarScrim;
                n10 = this.getVisibility();
                drawable3 = null;
                if (n10 == 0) {
                    n10 = 1;
                } else {
                    n10 = 0;
                    object = null;
                }
                drawable2.setVisible(n10 != 0, false);
                this.statusBarScrim.setCallback((Drawable.Callback)this);
                drawable2 = this.statusBarScrim;
                n10 = this.scrimAlpha;
                drawable2.setAlpha(n10);
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void setStatusBarScrimColor(int n10) {
        ColorDrawable colorDrawable = new ColorDrawable(n10);
        this.setStatusBarScrim((Drawable)colorDrawable);
    }

    public void setStatusBarScrimResource(int n10) {
        Drawable drawable2 = ContextCompat.getDrawable(this.getContext(), n10);
        this.setStatusBarScrim(drawable2);
    }

    public void setTitle(CharSequence charSequence) {
        this.collapsingTextHelper.setText(charSequence);
        this.updateContentDescriptionFromTitle();
    }

    public void setTitleEnabled(boolean bl2) {
        boolean bl3 = this.collapsingTitleEnabled;
        if (bl2 != bl3) {
            this.collapsingTitleEnabled = bl2;
            this.updateContentDescriptionFromTitle();
            this.updateDummyView();
            this.requestLayout();
        }
    }

    public void setVisibility(int n10) {
        int n11;
        super.setVisibility(n10);
        n10 = n10 == 0 ? 1 : 0;
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != null && (n11 = drawable2.isVisible()) != n10) {
            drawable2 = this.statusBarScrim;
            drawable2.setVisible(n10 != 0, false);
        }
        if ((drawable2 = this.contentScrim) != null && (n11 = (int)(drawable2.isVisible() ? 1 : 0)) != n10) {
            drawable2 = this.contentScrim;
            drawable2.setVisible(n10 != 0, false);
        }
    }

    public final void updateScrimVisibility() {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null || (drawable2 = this.statusBarScrim) != null) {
            int n10 = this.getHeight();
            int n11 = this.currentOffset;
            if ((n10 += n11) < (n11 = this.getScrimVisibleHeightTrigger())) {
                n10 = 1;
            } else {
                n10 = 0;
                drawable2 = null;
            }
            this.setScrimsShown(n10 != 0);
        }
    }

    public boolean verifyDrawable(Drawable drawable2) {
        boolean bl2;
        Drawable drawable3;
        boolean bl3 = super.verifyDrawable(drawable2);
        if (!bl3 && drawable2 != (drawable3 = this.contentScrim) && drawable2 != (drawable3 = this.statusBarScrim)) {
            bl2 = false;
            drawable2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

