/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.AnimatorListenerAdapter
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.view.Window$Callback
 *  android.view.WindowInsets
 *  android.widget.OverScroller
 */
package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback;
import androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;

public class ActionBarOverlayLayout
extends ViewGroup
implements DecorContentParent,
NestedScrollingParent,
NestedScrollingParent2,
NestedScrollingParent3 {
    private static final int ACTION_BAR_ANIMATE_DELAY = 600;
    public static final int[] ATTRS;
    private static final String TAG = "ActionBarOverlayLayout";
    private int mActionBarHeight;
    public ActionBarContainer mActionBarTop;
    private ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    public boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;
    private WindowInsetsCompat mBaseInnerInsets;
    private final Rect mBaseInnerInsetsRect;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    public ViewPropertyAnimator mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private OverScroller mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets;
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;
    private WindowInsetsCompat mLastInnerInsets;
    private final Rect mLastInnerInsetsRect;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    public final AnimatorListenerAdapter mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility = 0;

    static {
        int n10 = R$attr.actionBarSize;
        int[] nArray = new int[]{n10, 16842841};
        ATTRS = nArray;
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context object, AttributeSet object2) {
        super(object, object2);
        super();
        this.mBaseContentInsets = object2;
        super();
        this.mLastBaseContentInsets = object2;
        super();
        this.mContentInsets = object2;
        super();
        this.mBaseInnerInsetsRect = object2;
        super();
        this.mLastBaseInnerInsetsRect = object2;
        super();
        this.mInnerInsetsRect = object2;
        super();
        this.mLastInnerInsetsRect = object2;
        object2 = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = object2;
        this.mLastBaseInnerInsets = object2;
        this.mInnerInsets = object2;
        this.mLastInnerInsets = object2;
        super(this);
        this.mTopAnimatorListener = object2;
        super(this);
        this.mRemoveActionBarHideOffset = object2;
        super(this);
        this.mAddActionBarHideOffset = object2;
        this.init((Context)object);
        super(this);
        this.mParentHelper = object;
    }

    private void addActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(View object, Rect rect, boolean n10, boolean n11, boolean bl2, boolean n12) {
        int n13;
        float f10;
        int n14;
        object = (ActionBarOverlayLayout$LayoutParams)object.getLayoutParams();
        int n15 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 != 0 && (n10 = object.leftMargin) != (n14 = rect.left)) {
            object.leftMargin = n14;
            n10 = n15;
            f10 = f11;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        if (n11 != 0 && (n11 = object.topMargin) != (n14 = rect.top)) {
            object.topMargin = n14;
            n10 = n15;
            f10 = f11;
        }
        if (n12 != 0 && (n11 = object.rightMargin) != (n12 = rect.right)) {
            object.rightMargin = n12;
            n10 = n15;
            f10 = f11;
        }
        if (bl2 && (n11 = object.bottomMargin) != (n13 = rect.bottom)) {
            object.bottomMargin = n13;
        } else {
            n15 = n10;
            f11 = f10;
        }
        return n15 != 0;
    }

    private DecorToolbar getDecorToolbar(View object) {
        boolean bl2 = object instanceof DecorToolbar;
        if (bl2) {
            return (DecorToolbar)object;
        }
        bl2 = object instanceof Toolbar;
        if (bl2) {
            return ((Toolbar)((Object)object)).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        object = object.getClass().getSimpleName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    private void init(Context context) {
        int n10;
        Drawable drawable2;
        int n11;
        Resources.Theme theme = this.getContext().getTheme();
        int[] nArray = ATTRS;
        theme = theme.obtainStyledAttributes(nArray);
        int n12 = 0;
        nArray = null;
        this.mActionBarHeight = n11 = theme.getDimensionPixelSize(0, 0);
        n11 = 1;
        this.mWindowContentOverlay = drawable2 = theme.getDrawable(n11);
        if (drawable2 == null) {
            n10 = n11;
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setWillNotDraw(n10 != 0);
        theme.recycle();
        theme = context.getApplicationInfo();
        int n13 = theme.targetSdkVersion;
        n10 = 19;
        if (n13 < n10) {
            n12 = n11;
        }
        this.mIgnoreWindowContentOverlay = n12;
        theme = new OverScroller(context);
        this.mFlingEstimator = theme;
    }

    private void postAddActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        Runnable runnable = this.mAddActionBarHideOffset;
        this.postDelayed(runnable, 600L);
    }

    private void postRemoveActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        Runnable runnable = this.mRemoveActionBarHideOffset;
        this.postDelayed(runnable, 600L);
    }

    private void removeActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float f10) {
        Object object = this.mFlingEstimator;
        int n10 = (int)f10;
        int n11 = -1 << -1;
        int n12 = -1 >>> 1;
        object.fling(0, 0, 0, n10, 0, 0, n11, n12);
        OverScroller overScroller = this.mFlingEstimator;
        int n13 = overScroller.getFinalY();
        object = this.mActionBarTop;
        int n14 = object.getHeight();
        if (n13 > n14) {
            n13 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n13 = 0;
            f10 = 0.0f;
            overScroller = null;
        }
        return n13;
    }

    public boolean canShowOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ActionBarOverlayLayout$LayoutParams;
    }

    public void dismissPopups() {
        this.pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        int n10;
        super.draw(canvas);
        Object object = this.mWindowContentOverlay;
        if (object != null && (n10 = this.mIgnoreWindowContentOverlay) == 0) {
            Object object2;
            object = this.mActionBarTop;
            n10 = object.getVisibility();
            if (n10 == 0) {
                object = this.mActionBarTop;
                float f10 = object.getBottom();
                object2 = this.mActionBarTop;
                float f11 = object2.getTranslationY();
                f10 += f11;
                f11 = 0.5f;
                n10 = (int)(f10 += f11);
            } else {
                n10 = 0;
                object = null;
                float f12 = 0.0f;
            }
            object2 = this.mWindowContentOverlay;
            int n11 = this.getWidth();
            Drawable drawable2 = this.mWindowContentOverlay;
            int n12 = drawable2.getIntrinsicHeight() + n10;
            object2.setBounds(0, n10, n11, n12);
            object = this.mWindowContentOverlay;
            object.draw(canvas);
        }
    }

    public boolean fitSystemWindows(Rect rect) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return super.fitSystemWindows(rect);
        }
        this.pullChildren();
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this;
        Rect rect2 = rect;
        n10 = (int)(this.applyInsets((View)actionBarContainer, rect, bl2, bl3, false, bl4) ? 1 : 0);
        this.mBaseInnerInsetsRect.set(rect);
        rect = this.mBaseInnerInsetsRect;
        actionBarContainer = this.mBaseContentInsets;
        ViewUtils.computeFitSystemWindows((View)this, rect, (Rect)actionBarContainer);
        rect = this.mLastBaseInnerInsetsRect;
        actionBarContainer = this.mBaseInnerInsetsRect;
        boolean bl5 = rect.equals((Object)actionBarContainer);
        n11 = 1;
        if (!bl5) {
            rect = this.mLastBaseInnerInsetsRect;
            actionBarOverlayLayout = this.mBaseInnerInsetsRect;
            rect.set((Rect)actionBarOverlayLayout);
            n10 = n11;
        }
        if (!(bl5 = (rect = this.mLastBaseContentInsets).equals((Object)(rect2 = this.mBaseContentInsets)))) {
            rect = this.mLastBaseContentInsets;
            actionBarOverlayLayout = this.mBaseContentInsets;
            rect.set((Rect)actionBarOverlayLayout);
            n10 = n11;
        }
        if (n10) {
            this.requestLayout();
        }
        return n11 != 0;
    }

    public ActionBarOverlayLayout$LayoutParams generateDefaultLayoutParams() {
        int n10 = -1;
        ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = new ActionBarOverlayLayout$LayoutParams(n10, n10);
        return actionBarOverlayLayout$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = new ActionBarOverlayLayout$LayoutParams(layoutParams);
        return actionBarOverlayLayout$LayoutParams;
    }

    public ActionBarOverlayLayout$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = new ActionBarOverlayLayout$LayoutParams(context, attributeSet);
        return actionBarOverlayLayout$LayoutParams;
    }

    public int getActionBarHideOffset() {
        int n10;
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        if (actionBarContainer != null) {
            float f10 = actionBarContainer.getTranslationY();
            n10 = -((int)f10);
        } else {
            n10 = 0;
            float f11 = 0.0f;
            actionBarContainer = null;
        }
        return n10;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        this.pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    public void haltActionBarHideOffsetAnimations() {
        Runnable runnable = this.mRemoveActionBarHideOffset;
        this.removeCallbacks(runnable);
        runnable = this.mAddActionBarHideOffset;
        this.removeCallbacks(runnable);
        runnable = this.mCurrentActionBarTopAnimator;
        if (runnable != null) {
            runnable.cancel();
        }
    }

    public boolean hasIcon() {
        this.pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        this.pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    public boolean hideOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public void initFeature(int n10) {
        this.pullChildren();
        int n11 = 2;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                n11 = 109;
                if (n10 == n11) {
                    n10 = 1;
                    this.setOverlayMode(n10 != 0);
                }
            } else {
                DecorToolbar decorToolbar = this.mDecorToolbar;
                decorToolbar.initIndeterminateProgress();
            }
        } else {
            DecorToolbar decorToolbar = this.mDecorToolbar;
            decorToolbar.initProgress();
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    public boolean isOverflowMenuShowPending() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    public WindowInsets onApplyWindowInsets(WindowInsets object) {
        Rect rect;
        this.pullChildren();
        object = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)object, (View)this);
        int n10 = ((WindowInsetsCompat)object).getSystemWindowInsetLeft();
        int n11 = ((WindowInsetsCompat)object).getSystemWindowInsetTop();
        int n12 = ((WindowInsetsCompat)object).getSystemWindowInsetRight();
        int n13 = ((WindowInsetsCompat)object).getSystemWindowInsetBottom();
        Object object2 = new Rect(n10, n11, n12, n13);
        Object object3 = this.mActionBarTop;
        boolean bl2 = true;
        Object object4 = this;
        n10 = (int)(this.applyInsets((View)object3, (Rect)object2, true, true, false, bl2) ? 1 : 0);
        object3 = this.mBaseContentInsets;
        ViewCompat.computeSystemWindowInsets((View)this, (WindowInsetsCompat)object, (Rect)object3);
        object3 = this.mBaseContentInsets;
        int n14 = ((Rect)object3).left;
        n12 = ((Rect)object3).top;
        n13 = ((Rect)object3).right;
        n11 = ((Rect)object3).bottom;
        object3 = ((WindowInsetsCompat)object).inset(n14, n12, n13, n11);
        this.mBaseInnerInsets = object3;
        object2 = this.mLastBaseInnerInsets;
        n11 = (int)(((WindowInsetsCompat)object2).equals(object3) ? 1 : 0);
        n14 = 1;
        if (n11 == 0) {
            this.mLastBaseInnerInsets = object4 = this.mBaseInnerInsets;
            n10 = n14;
        }
        if ((n11 = (int)((object3 = this.mLastBaseContentInsets).equals(rect = this.mBaseContentInsets) ? 1 : 0)) == 0) {
            object4 = this.mLastBaseContentInsets;
            object3 = this.mBaseContentInsets;
            object4.set((Rect)object3);
        } else {
            n14 = n10;
        }
        if (n14 != 0) {
            this.requestLayout();
        }
        return ((WindowInsetsCompat)object).consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration = this.getContext();
        this.init((Context)configuration);
        ViewCompat.requestApplyInsets((View)this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.haltActionBarHideOffsetAnimations();
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        n10 = this.getChildCount();
        n11 = this.getPaddingLeft();
        n12 = this.getPaddingTop();
        for (n13 = 0; n13 < n10; ++n13) {
            int n15;
            View view = this.getChildAt(n13);
            int n16 = view.getVisibility();
            if (n16 == (n15 = 8)) continue;
            ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)view.getLayoutParams();
            n15 = view.getMeasuredWidth();
            int n17 = view.getMeasuredHeight();
            int n18 = actionBarOverlayLayout$LayoutParams.leftMargin + n11;
            n16 = actionBarOverlayLayout$LayoutParams.topMargin + n12;
            view.layout(n18, n16, n15 += n18, n17 += n16);
        }
    }

    public void onMeasure(int n10, int n11) {
        this.pullChildren();
        Object object = this.mActionBarTop;
        Object object2 = null;
        boolean bl2 = false;
        Object object3 = this;
        int n12 = n10;
        int n13 = n11;
        this.measureChildWithMargins((View)object, n10, 0, n11, 0);
        object3 = (ActionBarOverlayLayout$LayoutParams)this.mActionBarTop.getLayoutParams();
        int n14 = this.mActionBarTop.getMeasuredWidth();
        n12 = ((ViewGroup.MarginLayoutParams)object3).leftMargin;
        n14 += n12;
        n12 = ((ViewGroup.MarginLayoutParams)object3).rightMargin;
        n14 += n12;
        n12 = 0;
        Object object4 = null;
        int n15 = Math.max(0, n14);
        object = this.mActionBarTop;
        n14 = object.getMeasuredHeight();
        int n16 = ((ViewGroup.MarginLayoutParams)object3).topMargin;
        n14 += n16;
        int n17 = ((ViewGroup.MarginLayoutParams)object3).bottomMargin;
        int n18 = Math.max(0, n14 += n17);
        object3 = this.mActionBarTop;
        n17 = object3.getMeasuredState();
        int n19 = View.combineMeasuredStates((int)0, (int)n17);
        n17 = ViewCompat.getWindowSystemUiVisibility((View)this) & 0x100;
        if (n17 != 0) {
            n17 = 1;
        } else {
            n17 = 0;
            object3 = null;
        }
        if (n17 != 0) {
            n14 = this.mActionBarHeight;
            n16 = (int)(this.mHasNonEmbeddedTabs ? 1 : 0);
            if (n16 != 0 && (object2 = this.mActionBarTop.getTabContainer()) != null) {
                n16 = this.mActionBarHeight;
                n14 += n16;
            }
        } else {
            object = this.mActionBarTop;
            n14 = object.getVisibility();
            if (n14 != (n16 = 8)) {
                object = this.mActionBarTop;
                n14 = object.getMeasuredHeight();
            } else {
                n14 = 0;
                object = null;
            }
        }
        object2 = this.mContentInsets;
        Object object5 = this.mBaseContentInsets;
        object2.set((Rect)object5);
        int n20 = Build.VERSION.SDK_INT;
        int n21 = 21;
        if (n20 >= n21) {
            object2 = this.mBaseInnerInsets;
            this.mInnerInsets = object2;
        } else {
            object2 = this.mInnerInsetsRect;
            object5 = this.mBaseInnerInsetsRect;
            object2.set((Rect)object5);
        }
        n16 = (int)(this.mOverlayMode ? 1 : 0);
        if (n16 == 0 && n17 == 0) {
            object3 = this.mContentInsets;
            ((Rect)object3).top = n16 = ((Rect)object3).top + n14;
            ((Rect)object3).bottom = n16 = ((Rect)object3).bottom + 0;
            if (n20 >= n21) {
                object3 = this.mInnerInsets.inset(0, n14, 0, 0);
                this.mInnerInsets = object3;
            }
        } else if (n20 >= n21) {
            n17 = this.mInnerInsets.getSystemWindowInsetLeft();
            object2 = this.mInnerInsets;
            n16 = ((WindowInsetsCompat)object2).getSystemWindowInsetTop() + n14;
            n14 = this.mInnerInsets.getSystemWindowInsetRight();
            object5 = this.mInnerInsets;
            n13 = ((WindowInsetsCompat)object5).getSystemWindowInsetBottom() + 0;
            object3 = Insets.of(n17, n16, n14, n13);
            object4 = this.mInnerInsets;
            object = new WindowInsetsCompat$Builder((WindowInsetsCompat)object4);
            object3 = object.setSystemWindowInsets((Insets)object3).build();
            this.mInnerInsets = object3;
        } else {
            object3 = this.mInnerInsetsRect;
            ((Rect)object3).top = n16 = ((Rect)object3).top + n14;
            ((Rect)object3).bottom = n14 = ((Rect)object3).bottom + 0;
        }
        object = this.mContent;
        object4 = this.mContentInsets;
        n16 = 1;
        n13 = 1;
        bl2 = true;
        boolean bl3 = true;
        object3 = this;
        this.applyInsets((View)object, (Rect)object4, n16 != 0, n13 != 0, bl2, bl3);
        if (n20 >= n21 && (n17 = (int)(((WindowInsetsCompat)(object3 = this.mLastInnerInsets)).equals(object = this.mInnerInsets) ? 1 : 0)) == 0) {
            this.mLastInnerInsets = object3 = this.mInnerInsets;
            object = this.mContent;
            ViewCompat.dispatchApplyWindowInsets((View)object, (WindowInsetsCompat)object3);
        } else if (n20 < n21 && (n17 = (int)((object3 = this.mLastInnerInsetsRect).equals(object = this.mInnerInsetsRect) ? 1 : 0)) == 0) {
            object3 = this.mLastInnerInsetsRect;
            object = this.mInnerInsetsRect;
            object3.set((Rect)object);
            object3 = this.mContent;
            object = this.mInnerInsetsRect;
            ((ContentFrameLayout)((Object)object3)).dispatchFitSystemWindows((Rect)object);
        }
        object = this.mContent;
        object3 = this;
        n12 = n10;
        n13 = n11;
        this.measureChildWithMargins((View)object, n10, 0, n11, 0);
        object3 = (ActionBarOverlayLayout$LayoutParams)this.mContent.getLayoutParams();
        n14 = this.mContent.getMeasuredWidth();
        n12 = ((ViewGroup.MarginLayoutParams)object3).leftMargin;
        n14 += n12;
        n12 = ((ViewGroup.MarginLayoutParams)object3).rightMargin;
        n14 += n12;
        n14 = Math.max(n15, n14);
        n12 = this.mContent.getMeasuredHeight();
        n16 = ((ViewGroup.MarginLayoutParams)object3).topMargin;
        n12 += n16;
        n17 = ((ViewGroup.MarginLayoutParams)object3).bottomMargin;
        n12 += n17;
        n17 = Math.max(n18, n12);
        n12 = this.mContent.getMeasuredState();
        n12 = View.combineMeasuredStates((int)n19, (int)n12);
        n16 = this.getPaddingLeft();
        n13 = this.getPaddingRight();
        n14 += (n16 += n13);
        n16 = this.getPaddingTop();
        n13 = this.getPaddingBottom();
        n17 += (n16 += n13);
        n16 = this.getSuggestedMinimumHeight();
        n17 = Math.max(n17, n16);
        n16 = this.getSuggestedMinimumWidth();
        n14 = View.resolveSizeAndState((int)Math.max(n14, n16), (int)n10, (int)n12);
        n17 = View.resolveSizeAndState((int)n17, (int)n11, (int)(n12 <<= 16));
        this.setMeasuredDimension(n14, n17);
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean bl2) {
        boolean bl3 = this.mHideOnContentScroll;
        if (bl3 && bl2) {
            bl3 = this.shouldHideActionBarOnFling(f11);
            if (bl3) {
                this.addActionBarHideOffset();
            } else {
                this.removeActionBarHideOffset();
            }
            this.mAnimatingForFling = bl3 = true;
            return bl3;
        }
        return false;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public void onNestedPreScroll(View view, int n10, int n11, int[] nArray) {
    }

    public void onNestedPreScroll(View view, int n10, int n11, int[] nArray, int n12) {
        if (n12 == 0) {
            this.onNestedPreScroll(view, n10, n11, nArray);
        }
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13) {
        int n14;
        this.mHideOnContentScrollReference = n14 = this.mHideOnContentScrollReference + n11;
        this.setActionBarHideOffset(n14);
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13, int n14) {
        if (n14 == 0) {
            this.onNestedScroll(view, n10, n11, n12, n13);
        }
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13, int n14, int[] nArray) {
        this.onNestedScroll(view, n10, n11, n12, n13, n14);
    }

    public void onNestedScrollAccepted(View object, View view, int n10) {
        int n11;
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mParentHelper;
        nestedScrollingParentHelper.onNestedScrollAccepted((View)object, view, n10);
        this.mHideOnContentScrollReference = n11 = this.getActionBarHideOffset();
        this.haltActionBarHideOffsetAnimations();
        object = this.mActionBarVisibilityCallback;
        if (object != null) {
            object.onContentScrollStarted();
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int n10, int n11) {
        if (n11 == 0) {
            this.onNestedScrollAccepted(view, view2, n10);
        }
    }

    public boolean onStartNestedScroll(View object, View view, int n10) {
        int n11 = n10 & 2;
        if (n11 != 0 && (n11 = (object = this.mActionBarTop).getVisibility()) == 0) {
            return this.mHideOnContentScroll;
        }
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int n10, int n11) {
        boolean bl2;
        if (n11 == 0 && (bl2 = this.onStartNestedScroll(view, view2, n10))) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void onStopNestedScroll(View object) {
        int n10 = this.mHideOnContentScroll;
        if (n10 != 0 && (n10 = this.mAnimatingForFling) == 0) {
            n10 = this.mHideOnContentScrollReference;
            ActionBarContainer actionBarContainer = this.mActionBarTop;
            int n11 = actionBarContainer.getHeight();
            if (n10 <= n11) {
                this.postRemoveActionBarHideOffset();
            } else {
                this.postAddActionBarHideOffset();
            }
        }
        if ((object = this.mActionBarVisibilityCallback) != null) {
            object.onContentScrollStopped();
        }
    }

    public void onStopNestedScroll(View view, int n10) {
        if (n10 == 0) {
            this.onStopNestedScroll(view);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int n10) {
        ActionBarOverlayLayout$ActionBarVisibilityCallback actionBarOverlayLayout$ActionBarVisibilityCallback;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            super.onWindowSystemUiVisibilityChanged(n10);
        }
        this.pullChildren();
        n11 = this.mLastSystemUiVisibility ^ n10;
        this.mLastSystemUiVisibility = n10;
        n12 = n10 & 4;
        int n13 = 0;
        int n14 = 1;
        n12 = n12 == 0 ? n14 : 0;
        if ((n10 &= 0x100) != 0) {
            n13 = n14;
        }
        if ((actionBarOverlayLayout$ActionBarVisibilityCallback = this.mActionBarVisibilityCallback) != null) {
            n14 = n13 ^ 1;
            actionBarOverlayLayout$ActionBarVisibilityCallback.enableContentAnimations(n14 != 0);
            if (n12 == 0 && n13 != 0) {
                actionBarOverlayLayout$ActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
                actionBarOverlayLayout$ActionBarVisibilityCallback.hideForSystem();
            } else {
                actionBarOverlayLayout$ActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
                actionBarOverlayLayout$ActionBarVisibilityCallback.showForSystem();
            }
        }
        if ((n10 = n11 & 0x100) != 0 && (actionBarOverlayLayout$ActionBarVisibilityCallback = this.mActionBarVisibilityCallback) != null) {
            ViewCompat.requestApplyInsets((View)this);
        }
    }

    public void onWindowVisibilityChanged(int n10) {
        super.onWindowVisibilityChanged(n10);
        this.mWindowVisibility = n10;
        ActionBarOverlayLayout$ActionBarVisibilityCallback actionBarOverlayLayout$ActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarOverlayLayout$ActionBarVisibilityCallback != null) {
            actionBarOverlayLayout$ActionBarVisibilityCallback.onWindowVisibilityChanged(n10);
        }
    }

    public void pullChildren() {
        Object object = this.mContent;
        if (object == null) {
            int n10 = R$id.action_bar_activity_content;
            object = (ContentFrameLayout)this.findViewById(n10);
            this.mContent = object;
            n10 = R$id.action_bar_container;
            object = (ActionBarContainer)this.findViewById(n10);
            this.mActionBarTop = object;
            n10 = R$id.action_bar;
            object = this.findViewById(n10);
            object = this.getDecorToolbar((View)object);
            this.mDecorToolbar = object;
        }
    }

    public void restoreToolbarHierarchyState(SparseArray sparseArray) {
        this.pullChildren();
        this.mDecorToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray sparseArray) {
        this.pullChildren();
        this.mDecorToolbar.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int n10) {
        this.haltActionBarHideOffsetAnimations();
        int n11 = this.mActionBarTop.getHeight();
        n10 = Math.min(n10, n11);
        n10 = Math.max(0, n10);
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        float f10 = -n10;
        actionBarContainer.setTranslationY(f10);
    }

    public void setActionBarVisibilityCallback(ActionBarOverlayLayout$ActionBarVisibilityCallback actionBarOverlayLayout$ActionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = actionBarOverlayLayout$ActionBarVisibilityCallback;
        actionBarOverlayLayout$ActionBarVisibilityCallback = this.getWindowToken();
        if (actionBarOverlayLayout$ActionBarVisibilityCallback != null) {
            actionBarOverlayLayout$ActionBarVisibilityCallback = this.mActionBarVisibilityCallback;
            int n10 = this.mWindowVisibility;
            actionBarOverlayLayout$ActionBarVisibilityCallback.onWindowVisibilityChanged(n10);
            int n11 = this.mLastSystemUiVisibility;
            if (n11 != 0) {
                this.onWindowSystemUiVisibilityChanged(n11);
                ViewCompat.requestApplyInsets((View)this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean bl2) {
        this.mHasNonEmbeddedTabs = bl2;
    }

    public void setHideOnContentScrollEnabled(boolean bl2) {
        boolean bl3 = this.mHideOnContentScroll;
        if (bl2 != bl3) {
            this.mHideOnContentScroll = bl2;
            if (!bl2) {
                this.haltActionBarHideOffsetAnimations();
                bl2 = false;
                this.setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int n10) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(n10);
    }

    public void setIcon(Drawable drawable2) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(drawable2);
    }

    public void setLogo(int n10) {
        this.pullChildren();
        this.mDecorToolbar.setLogo(n10);
    }

    public void setMenu(Menu menu2, MenuPresenter$Callback menuPresenter$Callback) {
        this.pullChildren();
        this.mDecorToolbar.setMenu(menu2, menuPresenter$Callback);
    }

    public void setMenuPrepared() {
        this.pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    /*
     * Unable to fully structure code
     */
    public void setOverlayMode(boolean var1_1) {
        this.mOverlayMode = var1_1;
        if (var1_1 == 0) ** GOTO lbl-1000
        var2_2 = this.getContext().getApplicationInfo();
        var1_1 = var2_2.targetSdkVersion;
        var3_3 = 19;
        if (var1_1 < var3_3) {
            var1_1 = 1;
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = 0;
            var2_2 = null;
        }
        this.mIgnoreWindowContentOverlay = var1_1;
    }

    public void setShowingForActionMode(boolean bl2) {
    }

    public void setUiOptions(int n10) {
    }

    public void setWindowCallback(Window.Callback callback) {
        this.pullChildren();
        this.mDecorToolbar.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.pullChildren();
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }
}

