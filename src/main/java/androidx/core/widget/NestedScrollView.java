/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.AnimationUtils
 *  android.widget.EdgeEffect
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.OverScroller
 */
package androidx.core.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.core.widget.NestedScrollView$AccessibilityDelegate;
import androidx.core.widget.NestedScrollView$OnScrollChangeListener;
import androidx.core.widget.NestedScrollView$SavedState;
import java.util.ArrayList;

public class NestedScrollView
extends FrameLayout
implements NestedScrollingParent3,
NestedScrollingChild3,
ScrollingView {
    private static final NestedScrollView$AccessibilityDelegate ACCESSIBILITY_DELEGATE;
    public static final int ANIMATED_SCROLL_GAP = 250;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final int INVALID_POINTER = 255;
    public static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private NestedScrollView$OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private NestedScrollView$SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    static {
        Object object = new NestedScrollView$AccessibilityDelegate();
        ACCESSIBILITY_DELEGATE = object;
        object = new int[1];
        object[0] = 16843130;
        SCROLLVIEW_STYLEABLE = (int[])object;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        boolean bl2;
        Rect rect;
        this.mTempRect = rect = new Rect();
        this.mIsLayoutDirty = bl2 = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = bl2;
        this.mActivePointerId = -1;
        int n11 = 2;
        int[] nArray = new int[n11];
        this.mScrollOffset = nArray;
        int[] nArray2 = new int[n11];
        this.mScrollConsumed = nArray2;
        this.initScrollView();
        nArray2 = SCROLLVIEW_STYLEABLE;
        object = object.obtainStyledAttributes(attributeSet, nArray2, n10, 0);
        boolean bl3 = object.getBoolean(0, false);
        this.setFillViewport(bl3);
        object.recycle();
        super((ViewGroup)this);
        this.mParentHelper = object;
        super((View)this);
        this.mChildHelper = object;
        this.setNestedScrollingEnabled(bl2);
        object = ACCESSIBILITY_DELEGATE;
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)object);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        this.stopNestedScroll(1);
    }

    private boolean canScroll() {
        int n10 = this.getChildCount();
        boolean bl2 = false;
        if (n10 > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            n10 = view.getHeight();
            int n11 = layoutParams.topMargin;
            n10 += n11;
            int n12 = layoutParams.bottomMargin;
            n10 += n12;
            n12 = this.getHeight();
            n11 = this.getPaddingTop();
            n12 -= n11;
            n11 = this.getPaddingBottom();
            if (n10 > (n12 -= n11)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private static int clamp(int n10, int n11, int n12) {
        if (n11 < n12 && n10 >= 0) {
            int n13 = n11 + n10;
            if (n13 > n12) {
                return n12 - n11;
            }
            return n10;
        }
        return 0;
    }

    private void doScrollY(int n10) {
        if (n10 != 0) {
            boolean bl2 = this.mSmoothScrollingEnabled;
            if (bl2) {
                this.smoothScrollBy(0, n10);
            } else {
                this.scrollBy(0, n10);
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.recycleVelocityTracker();
        this.stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            edgeEffect = this.mEdgeGlowBottom;
            edgeEffect.onRelease();
        }
    }

    private void ensureGlows() {
        int n10;
        int n11 = this.getOverScrollMode();
        if (n11 != (n10 = 2)) {
            EdgeEffect edgeEffect = this.mEdgeGlowTop;
            if (edgeEffect == null) {
                EdgeEffect edgeEffect2;
                edgeEffect = this.getContext();
                this.mEdgeGlowTop = edgeEffect2 = new EdgeEffect((Context)edgeEffect);
                this.mEdgeGlowBottom = edgeEffect2 = new EdgeEffect((Context)edgeEffect);
            }
        } else {
            n11 = 0;
            Object var3_4 = null;
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
    }

    private View findFocusableViewInBounds(boolean bl2, int n10, int n11) {
        int n12 = 2;
        ArrayList arrayList = this.getFocusables(n12);
        int n13 = arrayList.size();
        View view = null;
        int n14 = 0;
        for (int i10 = 0; i10 < n13; ++i10) {
            int n15;
            View view2 = (View)arrayList.get(i10);
            int n16 = view2.getTop();
            int n17 = view2.getBottom();
            int n18 = 1;
            float f10 = Float.MIN_VALUE;
            if (n10 >= n17 || n16 >= n11) continue;
            int n19 = n10 < n16 && n17 < n11 ? n18 : 0;
            if (view == null) {
                view = view2;
                n14 = n19;
                continue;
            }
            n16 = bl2 && n16 < (n15 = view.getTop()) || !bl2 && n17 > (n16 = view.getBottom()) ? n18 : 0;
            if (n14 != 0) {
                if (n19 == 0 || n16 == 0) continue;
            } else {
                if (n19 != 0) {
                    view = view2;
                    n14 = n18;
                    continue;
                }
                if (n16 == 0) continue;
            }
            view = view2;
        }
        return view;
    }

    private float getVerticalScrollFactorCompat() {
        float f10 = this.mVerticalScrollFactor;
        Context context = null;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object == false) {
            boolean bl2;
            int n10;
            Object object2 = new TypedValue();
            context = this.getContext();
            Resources.Theme theme = context.getTheme();
            boolean bl3 = theme.resolveAttribute(n10 = 16842829, object2, bl2 = true);
            if (bl3) {
                context = context.getResources().getDisplayMetrics();
                this.mVerticalScrollFactor = f10 = object2.getDimension((DisplayMetrics)context);
            } else {
                object2 = new IllegalStateException("Expected theme to define listPreferredItemHeight.");
                throw object2;
            }
        }
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int n10, int n11) {
        int n12 = this.getChildCount();
        boolean bl2 = false;
        if (n12 > 0) {
            n12 = this.getScrollY();
            View view = this.getChildAt(0);
            int n13 = view.getTop() - n12;
            if (n11 >= n13 && n11 < (n13 = view.getBottom() - n12) && n10 >= (n11 = view.getLeft()) && n10 < (n11 = view.getRight())) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = velocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        int n10;
        int n11;
        OverScroller overScroller;
        Context context = this.getContext();
        this.mScroller = overScroller = new OverScroller(context);
        this.setFocusable(true);
        this.setDescendantFocusability(262144);
        this.setWillNotDraw(false);
        overScroller = ViewConfiguration.get((Context)this.getContext());
        this.mTouchSlop = n11 = overScroller.getScaledTouchSlop();
        this.mMinimumVelocity = n11 = overScroller.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = n10 = overScroller.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = velocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean isOffScreen(View view) {
        int n10 = this.getHeight();
        return this.isWithinDeltaOfScreen(view, 0, n10) ^ true;
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        boolean bl2;
        boolean bl3 = true;
        if (view == view2) {
            return bl3;
        }
        boolean bl4 = (view = view.getParent()) instanceof ViewGroup;
        if (!bl4 || !(bl2 = NestedScrollView.isViewDescendantOf(view, view2))) {
            bl3 = false;
        }
        return bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isWithinDeltaOfScreen(View view, int n10, int n11) {
        Rect rect = this.mTempRect;
        view.getDrawingRect(rect);
        rect = this.mTempRect;
        this.offsetDescendantRectToMyCoords(view, rect);
        view = this.mTempRect;
        int n12 = view.bottom + n10;
        int n13 = this.getScrollY();
        if (n12 < n13) return 0 != 0;
        view = this.mTempRect;
        n12 = view.top - n10;
        if (n12 > (n10 = this.getScrollY() + n11)) return 0 != 0;
        return 1 != 0;
    }

    private void onNestedScrollInternal(int n10, int n11, int[] nArray) {
        int n12 = this.getScrollY();
        this.scrollBy(0, n10);
        int n13 = this.getScrollY();
        int n14 = n13 - n12;
        if (nArray != null) {
            n12 = 1;
            nArray[n12] = n13 = nArray[n12] + n14;
        }
        int n15 = n10 - n14;
        this.mChildHelper.dispatchNestedScroll(0, n14, 0, n15, null, n11, nArray);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getActionIndex();
        int n12 = motionEvent.getPointerId(n11);
        if (n12 == (n10 = this.mActivePointerId)) {
            int n13;
            n11 = n11 == 0 ? 1 : 0;
            float f10 = motionEvent.getY(n11);
            this.mLastMotionY = n12 = (int)f10;
            this.mActivePointerId = n13 = motionEvent.getPointerId(n11);
            motionEvent = this.mVelocityTracker;
            if (motionEvent != null) {
                motionEvent.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            velocityTracker = null;
            this.mVelocityTracker = null;
        }
    }

    private void runAnimatedScroll(boolean bl2) {
        int n10;
        int n11 = 1;
        if (bl2) {
            int n12 = 2;
            this.startNestedScroll(n12, n11);
        } else {
            this.stopNestedScroll(n11);
        }
        this.mLastScrollerY = n10 = this.getScrollY();
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    private boolean scrollAndFocus(int n10, int n11, int n12) {
        View view;
        int n13 = this.getHeight();
        int n14 = this.getScrollY();
        n13 += n14;
        int n15 = 0;
        int n16 = 1;
        int n17 = 33;
        n17 = n10 == n17 ? n16 : 0;
        Object object = this.findFocusableViewInBounds(n17 != 0, n11, n12);
        if (object == null) {
            object = this;
        }
        if (n11 < n14 || n12 > n13) {
            n11 = n17 != 0 ? (n11 -= n14) : n12 - n13;
            this.doScrollY(n11);
            n15 = n16;
        }
        if (object != (view = this.findFocus())) {
            object.requestFocus(n10);
        }
        return n15 != 0;
    }

    private void scrollToChild(View view) {
        Rect rect = this.mTempRect;
        view.getDrawingRect(rect);
        rect = this.mTempRect;
        this.offsetDescendantRectToMyCoords(view, rect);
        view = this.mTempRect;
        int n10 = this.computeScrollDeltaToGetChildRectOnScreen((Rect)view);
        if (n10 != 0) {
            rect = null;
            this.scrollBy(0, n10);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean bl2) {
        int n10 = this.computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean bl3 = n10 != 0;
        if (bl3) {
            if (bl2) {
                this.scrollBy(0, n10);
            } else {
                this.smoothScrollBy(0, n10);
            }
        }
        return bl3;
    }

    private void smoothScrollBy(int n10, int n11, int n12, boolean bl2) {
        long l10;
        int n13 = this.getChildCount();
        if (n13 == 0) {
            return;
        }
        long l11 = AnimationUtils.currentAnimationTimeMillis();
        long l12 = this.mLastScroll;
        long l13 = (l11 -= l12) - (l12 = 250L);
        n13 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        if (n13 > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            n13 = view.getHeight();
            int n14 = layoutParams.topMargin;
            n13 += n14;
            int n15 = layoutParams.bottomMargin;
            n13 += n15;
            n15 = this.getHeight();
            n14 = this.getPaddingTop();
            n15 -= n14;
            n14 = this.getPaddingBottom();
            int n16 = this.getScrollY();
            n13 -= (n15 -= n14);
            n13 = Math.max(0, n13);
            n11 = Math.min(n11 + n16, n13);
            n10 = Math.max(0, n11);
            int n17 = n10 - n16;
            OverScroller overScroller = this.mScroller;
            int n18 = this.getScrollX();
            overScroller.startScroll(n18, n16, 0, n17, n12);
            this.runAnimatedScroll(bl2);
        } else {
            OverScroller overScroller = this.mScroller;
            n12 = (int)(overScroller.isFinished() ? 1 : 0);
            if (n12 == 0) {
                this.abortAnimatedScroll();
            }
            this.scrollBy(n10, n11);
        }
        this.mLastScroll = l10 = AnimationUtils.currentAnimationTimeMillis();
    }

    public void addView(View object) {
        int n10 = this.getChildCount();
        if (n10 <= 0) {
            super.addView(object);
            return;
        }
        object = new IllegalStateException("ScrollView can host only one direct child");
        throw object;
    }

    public void addView(View object, int n10) {
        int n11 = this.getChildCount();
        if (n11 <= 0) {
            super.addView(object, n10);
            return;
        }
        object = new IllegalStateException("ScrollView can host only one direct child");
        throw object;
    }

    public void addView(View object, int n10, ViewGroup.LayoutParams layoutParams) {
        int n11 = this.getChildCount();
        if (n11 <= 0) {
            super.addView(object, n10, layoutParams);
            return;
        }
        object = new IllegalStateException("ScrollView can host only one direct child");
        throw object;
    }

    public void addView(View object, ViewGroup.LayoutParams layoutParams) {
        int n10 = this.getChildCount();
        if (n10 <= 0) {
            super.addView(object, layoutParams);
            return;
        }
        object = new IllegalStateException("ScrollView can host only one direct child");
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    public boolean arrowScroll(int var1_1) {
        var2_2 = this.findFocus();
        if (var2_2 == this) {
            var3_3 = 0;
            var2_2 = null;
        }
        var4_4 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, var2_2, var1_1);
        var5_5 = this.getMaxScrollAmount();
        if (var4_4 == null) ** GOTO lbl-1000
        var6_6 = this.getHeight();
        if ((var6_6 = (int)this.isWithinDeltaOfScreen(var4_4, var5_5, var6_6)) != 0) {
            var7_7 = this.mTempRect;
            var4_4.getDrawingRect(var7_7);
            var7_7 = this.mTempRect;
            this.offsetDescendantRectToMyCoords(var4_4, var7_7);
            var7_7 = this.mTempRect;
            var5_5 = this.computeScrollDeltaToGetChildRectOnScreen(var7_7);
            this.doScrollY(var5_5);
            var4_4.requestFocus(var1_1);
        } else lbl-1000:
        // 2 sources

        {
            var8_8 = 33;
            var6_6 = 0;
            var9_9 = 130;
            if (var1_1 == var8_8 && (var8_8 = this.getScrollY()) < var5_5) {
                var5_5 = this.getScrollY();
            } else if (var1_1 == var9_9 && (var8_8 = this.getChildCount()) > 0) {
                var4_4 = this.getChildAt(0);
                var10_10 = (FrameLayout.LayoutParams)var4_4.getLayoutParams();
                var8_8 = var4_4.getBottom();
                var11_11 = var10_10.bottomMargin;
                var8_8 += var11_11;
                var11_11 = this.getScrollY();
                var12_12 = this.getHeight();
                var11_11 += var12_12;
                var12_12 = this.getPaddingBottom();
                var5_5 = Math.min(var8_8 -= (var11_11 -= var12_12), var5_5);
            }
            if (var5_5 == 0) {
                return false;
            }
            if (var1_1 != var9_9) {
                var5_5 = -var5_5;
            }
            this.doScrollY(var5_5);
        }
        if (var2_2 != null && (var1_1 = (int)var2_2.isFocused()) != 0 && (var1_1 = (int)this.isOffScreen(var2_2)) != 0) {
            var1_1 = this.getDescendantFocusability();
            var3_3 = 131072;
            this.setDescendantFocusability(var3_3);
            this.requestFocus();
            this.setDescendantFocusability(var1_1);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        NestedScrollView nestedScrollView = this;
        Object object = this.mScroller;
        Object object2 = object.isFinished();
        if (object2 != 0) {
            return;
        }
        this.mScroller.computeScrollOffset();
        object2 = this.mScroller.getCurrY();
        int n10 = this.mLastScrollerY;
        int n11 = object2 - n10;
        this.mLastScrollerY = object2;
        int[] nArray = this.mScrollConsumed;
        Object object3 = 1;
        Object object4 = 0;
        nArray[object3] = 0;
        n10 = 0;
        float f10 = 0.0f;
        OverScroller overScroller = null;
        int n12 = 1;
        object = this;
        int n13 = n11;
        this.dispatchNestedPreScroll(0, n11, nArray, null, n12);
        object = this.mScrollConsumed;
        object2 = object[object3];
        int n14 = n11 - object2;
        int n15 = this.getScrollRange();
        if (n14 != 0) {
            int n16 = this.getScrollY();
            n10 = 0;
            f10 = 0.0f;
            overScroller = null;
            int n17 = this.getScrollX();
            n12 = 0;
            object = this;
            n13 = n14;
            n11 = n15;
            this.overScrollByCompat(0, n14, n17, n16, 0, n15, 0, 0, false);
            n13 = this.getScrollY() - n16;
            int[] nArray2 = this.mScrollConsumed;
            nArray2[object3] = 0;
            n17 = 0;
            nArray = null;
            int[] nArray3 = this.mScrollOffset;
            n11 = 1;
            this.dispatchNestedScroll(0, n13, 0, n14 -= n13, nArray3, n11, nArray2);
            object = this.mScrollConsumed;
            object2 = object[object3];
            n14 -= object2;
        }
        if (n14 != 0) {
            object2 = this.getOverScrollMode();
            if (object2 == 0 || object2 == object3 && n15 > 0) {
                object4 = object3;
            }
            if (object4 != 0) {
                this.ensureGlows();
                if (n14 < 0) {
                    object = nestedScrollView.mEdgeGlowTop;
                    object2 = object.isFinished();
                    if (object2 != 0) {
                        object = nestedScrollView.mEdgeGlowTop;
                        overScroller = nestedScrollView.mScroller;
                        f10 = overScroller.getCurrVelocity();
                        n10 = (int)f10;
                        object.onAbsorb(n10);
                    }
                } else {
                    object = nestedScrollView.mEdgeGlowBottom;
                    object2 = object.isFinished();
                    if (object2 != 0) {
                        object = nestedScrollView.mEdgeGlowBottom;
                        overScroller = nestedScrollView.mScroller;
                        f10 = overScroller.getCurrVelocity();
                        n10 = (int)f10;
                        object.onAbsorb(n10);
                    }
                }
            }
            this.abortAnimatedScroll();
        }
        if ((object2 = (Object)(object = nestedScrollView.mScroller).isFinished()) == 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        } else {
            nestedScrollView.stopNestedScroll((int)object3);
        }
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int n10 = this.getChildCount();
        int n11 = 0;
        if (n10 == 0) {
            return 0;
        }
        n10 = this.getHeight();
        int n12 = this.getScrollY();
        int n13 = n12 + n10;
        int n14 = this.getVerticalFadingEdgeLength();
        int n15 = rect.top;
        if (n15 > 0) {
            n12 += n14;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int n16 = rect.bottom;
        int n17 = view.getHeight();
        int n18 = layoutParams.topMargin;
        n17 += n18;
        n16 = rect.bottom;
        n18 = layoutParams.bottomMargin;
        n14 = n16 < (n17 += n18) ? n13 - n14 : n13;
        if (n16 > n14 && (n17 = rect.top) > n12) {
            n16 = rect.height();
            int n19 = n16 > n10 ? rect.top - n12 : rect.bottom - n14;
            n10 = view.getBottom();
            n11 = layoutParams.bottomMargin;
            n10 = n10 + n11 - n13;
            n11 = Math.min(n19 += 0, n10);
        } else {
            n13 = rect.top;
            if (n13 < n12 && n16 < n14) {
                int n20;
                n13 = rect.height();
                if (n13 > n10) {
                    n20 = rect.bottom;
                    n11 = 0 - (n14 -= n20);
                } else {
                    n20 = rect.top;
                    n11 = 0 - (n12 -= n20);
                }
                n20 = -this.getScrollY();
                n11 = Math.max(n11, n20);
            }
        }
        return n11;
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        int n10 = super.computeVerticalScrollOffset();
        return Math.max(0, n10);
    }

    public int computeVerticalScrollRange() {
        int n10 = this.getChildCount();
        int n11 = this.getHeight();
        int n12 = this.getPaddingBottom();
        n11 -= n12;
        n12 = this.getPaddingTop();
        n11 -= n12;
        if (n10 == 0) {
            return n11;
        }
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        n12 = view.getBottom();
        int n13 = layoutParams.bottomMargin;
        n12 += n13;
        n13 = this.getScrollY();
        n11 = n12 - n11;
        n10 = Math.max(0, n11);
        if (n13 < 0) {
            n12 -= n13;
        } else if (n13 > n10) {
            n12 += (n13 -= n10);
        }
        return n12;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        boolean bl3 = super.dispatchKeyEvent(keyEvent);
        if (!bl3 && !(bl2 = this.executeKeyEvent(keyEvent))) {
            bl2 = false;
            keyEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean bl2) {
        return this.mChildHelper.dispatchNestedFling(f10, f11, bl2);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.mChildHelper.dispatchNestedPreFling(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2) {
        return this.dispatchNestedPreScroll(n10, n11, nArray, nArray2, 0);
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2, int n12) {
        return this.mChildHelper.dispatchNestedPreScroll(n10, n11, nArray, nArray2, n12);
    }

    public void dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray, int n14, int[] nArray2) {
        this.mChildHelper.dispatchNestedScroll(n10, n11, n12, n13, nArray, n14, nArray2);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray) {
        return this.mChildHelper.dispatchNestedScroll(n10, n11, n12, n13, nArray);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray, int n14) {
        return this.mChildHelper.dispatchNestedScroll(n10, n11, n12, n13, nArray, n14);
    }

    public void draw(Canvas canvas) {
        int n10 = Build.VERSION.SDK_INT;
        super.draw(canvas);
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            int n11;
            int n12;
            int n13;
            int n14;
            int n15 = this.getScrollY();
            EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
            int n16 = edgeEffect2.isFinished();
            int n17 = 0;
            int n18 = 21;
            if (n16 == 0) {
                int n19;
                float f10;
                n16 = canvas.save();
                n14 = this.getWidth();
                n13 = this.getHeight();
                n12 = Math.min(0, n15);
                if (n10 >= n18 && (n11 = this.getClipToPadding()) == 0) {
                    n11 = 0;
                    f10 = 0.0f;
                } else {
                    n11 = this.getPaddingLeft();
                    n19 = this.getPaddingRight();
                    n14 -= (n11 += n19);
                    n11 = this.getPaddingLeft() + 0;
                }
                if (n10 >= n18 && (n19 = (int)(this.getClipToPadding() ? 1 : 0)) != 0) {
                    n19 = this.getPaddingTop();
                    int n20 = this.getPaddingBottom();
                    n13 -= (n19 += n20);
                    n19 = this.getPaddingTop();
                    n12 += n19;
                }
                f10 = n11;
                float f11 = n12;
                canvas.translate(f10, f11);
                EdgeEffect edgeEffect3 = this.mEdgeGlowTop;
                edgeEffect3.setSize(n14, n13);
                EdgeEffect edgeEffect4 = this.mEdgeGlowTop;
                n14 = (int)(edgeEffect4.draw(canvas) ? 1 : 0);
                if (n14 != 0) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                canvas.restoreToCount(n16);
            }
            if ((n16 = (int)((edgeEffect2 = this.mEdgeGlowBottom).isFinished() ? 1 : 0)) == 0) {
                n16 = canvas.save();
                n14 = this.getWidth();
                n13 = this.getHeight();
                n12 = this.getScrollRange();
                n15 = Math.max(n12, n15) + n13;
                if (n10 < n18 || (n12 = (int)(this.getClipToPadding() ? 1 : 0)) != 0) {
                    n12 = this.getPaddingLeft();
                    n11 = this.getPaddingRight();
                    n14 -= (n12 += n11);
                    n12 = this.getPaddingLeft();
                    n17 = 0 + n12;
                }
                if (n10 >= n18 && (n10 = (int)(this.getClipToPadding() ? 1 : 0)) != 0) {
                    n10 = this.getPaddingTop();
                    n18 = this.getPaddingBottom();
                    n13 -= (n10 += n18);
                    n10 = this.getPaddingBottom();
                    n15 -= n10;
                }
                float f12 = n17 - n14;
                float f13 = n15;
                canvas.translate(f12, f13);
                f12 = 180.0f;
                f13 = n14;
                n17 = 0;
                canvas.rotate(f12, f13, 0.0f);
                this.mEdgeGlowBottom.setSize(n14, n13);
                EdgeEffect edgeEffect5 = this.mEdgeGlowBottom;
                n10 = (int)(edgeEffect5.draw(canvas) ? 1 : 0);
                if (n10 != 0) {
                    ViewCompat.postInvalidateOnAnimation((View)this);
                }
                canvas.restoreToCount(n16);
            }
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        Rect rect = this.mTempRect;
        rect.setEmpty();
        int n10 = this.canScroll();
        boolean bl2 = false;
        int n11 = 130;
        if (n10 == 0) {
            int n12;
            n10 = this.isFocused();
            if (n10 != 0 && (n12 = keyEvent.getKeyCode()) != (n10 = 4)) {
                keyEvent = this.findFocus();
                if (keyEvent == this) {
                    n12 = 0;
                    keyEvent = null;
                }
                if ((keyEvent = (rect = FocusFinder.getInstance()).findNextFocus((ViewGroup)this, (View)keyEvent, n11)) != null && keyEvent != this && (n12 = (int)(keyEvent.requestFocus(n11) ? 1 : 0)) != 0) {
                    bl2 = true;
                }
            }
            return bl2;
        }
        n10 = keyEvent.getAction();
        if (n10 == 0) {
            n10 = keyEvent.getKeyCode();
            int n13 = 19;
            int n14 = 33;
            if (n10 != n13) {
                n13 = 20;
                if (n10 != n13) {
                    n13 = 62;
                    if (n10 == n13) {
                        boolean bl3 = keyEvent.isShiftPressed();
                        if (bl3) {
                            n11 = n14;
                        }
                        this.pageScroll(n11);
                    }
                } else {
                    boolean bl4 = keyEvent.isAltPressed();
                    bl2 = !bl4 ? this.arrowScroll(n11) : this.fullScroll(n11);
                }
            } else {
                boolean bl5 = keyEvent.isAltPressed();
                bl2 = !bl5 ? this.arrowScroll(n14) : this.fullScroll(n14);
            }
        }
        return bl2;
    }

    public void fling(int n10) {
        int n11 = this.getChildCount();
        if (n11 > 0) {
            OverScroller overScroller = this.mScroller;
            int n12 = this.getScrollX();
            int n13 = this.getScrollY();
            int n14 = -1 << -1;
            int n15 = -1 >>> 1;
            overScroller.fling(n12, n13, 0, n10, 0, 0, n14, n15, 0, 0);
            n10 = 1;
            this.runAnimatedScroll(n10 != 0);
        }
    }

    public boolean fullScroll(int n10) {
        Rect rect;
        Rect rect2;
        int n11 = 1;
        int n12 = 0;
        FrameLayout.LayoutParams layoutParams = null;
        int n13 = 130;
        if (n10 == n13) {
            n13 = n11;
        } else {
            n13 = 0;
            rect2 = null;
        }
        int n14 = this.getHeight();
        Rect rect3 = this.mTempRect;
        rect3.top = 0;
        rect3.bottom = n14;
        if (n13 != 0 && (n12 = this.getChildCount()) > 0) {
            rect = this.getChildAt(n12 -= n11);
            layoutParams = (FrameLayout.LayoutParams)rect.getLayoutParams();
            rect2 = this.mTempRect;
            n11 = rect.getBottom();
            n12 = layoutParams.bottomMargin;
            n11 += n12;
            n12 = this.getPaddingBottom();
            rect2.bottom = n11 += n12;
            rect = this.mTempRect;
            rect.top = n12 = rect.bottom - n14;
        }
        rect = this.mTempRect;
        n12 = rect.top;
        n11 = rect.bottom;
        return this.scrollAndFocus(n10, n12, n11);
    }

    public float getBottomFadingEdgeStrength() {
        int n10 = this.getChildCount();
        if (n10 == 0) {
            return 0.0f;
        }
        float f10 = 0.0f;
        View view = this.getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        int n11 = this.getVerticalFadingEdgeLength();
        int n12 = this.getHeight();
        int n13 = this.getPaddingBottom();
        n10 = view.getBottom();
        int n14 = layoutParams.bottomMargin;
        n10 += n14;
        n14 = this.getScrollY();
        if ((n10 = n10 - n14 - (n12 -= n13)) < n11) {
            f10 = n10;
            float f11 = n11;
            return f10 / f11;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int)((float)this.getHeight() * 0.5f);
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public int getScrollRange() {
        int n10 = this.getChildCount();
        int n11 = 0;
        if (n10 > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            n10 = view.getHeight();
            int n12 = layoutParams.topMargin;
            n10 += n12;
            int n13 = layoutParams.bottomMargin;
            n10 += n13;
            n13 = this.getHeight();
            n12 = this.getPaddingTop();
            n13 -= n12;
            n12 = this.getPaddingBottom();
            n11 = Math.max(0, n10 -= (n13 -= n12));
        }
        return n11;
    }

    public float getTopFadingEdgeStrength() {
        int n10 = this.getChildCount();
        if (n10 == 0) {
            return 0.0f;
        }
        n10 = this.getVerticalFadingEdgeLength();
        int n11 = this.getScrollY();
        if (n11 < n10) {
            float f10 = n11;
            float f11 = n10;
            return f10 / f11;
        }
        return 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int n10) {
        return this.mChildHelper.hasNestedScrollingParent(n10);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    public void measureChild(View view, int n10, int n11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int n12 = this.getPaddingLeft();
        int n13 = this.getPaddingRight();
        n11 = layoutParams.width;
        n10 = FrameLayout.getChildMeasureSpec((int)n10, (int)(n12 += n13), (int)n11);
        n11 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        view.measure(n10, n11);
    }

    public void measureChildWithMargins(View view, int n10, int n11, int n12, int n13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        n13 = this.getPaddingLeft();
        int n14 = this.getPaddingRight();
        n13 += n14;
        n14 = marginLayoutParams.leftMargin;
        n13 += n14;
        n14 = marginLayoutParams.rightMargin;
        n13 = n13 + n14 + n11;
        n11 = marginLayoutParams.width;
        n10 = FrameLayout.getChildMeasureSpec((int)n10, (int)n13, (int)n11);
        n11 = marginLayoutParams.topMargin;
        n12 = marginLayoutParams.bottomMargin;
        n11 = View.MeasureSpec.makeMeasureSpec((int)(n11 + n12), (int)0);
        view.measure(n10, n11);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getSource() & 2;
        if (n11 != 0 && (n11 = motionEvent.getAction()) == (n10 = 8) && (n11 = (int)(this.mIsBeingDragged ? 1 : 0)) == 0) {
            float f10 = motionEvent.getAxisValue(9);
            float f11 = 0.0f;
            float f12 = f10 - 0.0f;
            n11 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n11 != 0) {
                f11 = this.getVerticalScrollFactorCompat();
                int n12 = (int)(f10 *= f11);
                n11 = this.getScrollRange();
                n10 = this.getScrollY();
                n12 = n10 - n12;
                if (n12 < 0) {
                    n11 = 0;
                    f11 = 0.0f;
                } else if (n12 <= n11) {
                    n11 = n12;
                }
                if (n11 != n10) {
                    n12 = this.getScrollX();
                    super.scrollTo(n12, n11);
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onInterceptTouchEvent(MotionEvent object) {
        boolean bl2;
        int n10 = object.getAction();
        int n11 = 2;
        int n12 = 1;
        if (n10 == n11 && (bl2 = this.mIsBeingDragged)) {
            return n12 != 0;
        }
        bl2 = false;
        if ((n10 &= 0xFF) != 0) {
            int n13 = -1;
            float f10 = 0.0f / 0.0f;
            if (n10 != n12) {
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 6;
                        if (n10 != n11) return this.mIsBeingDragged;
                        this.onSecondaryPointerUp((MotionEvent)object);
                        return this.mIsBeingDragged;
                    }
                } else {
                    n10 = this.mActivePointerId;
                    if (n10 == n13) return this.mIsBeingDragged;
                    int n14 = object.findPointerIndex(n10);
                    if (n14 == n13) {
                        object = new StringBuilder();
                        String string2 = "Invalid pointerId=";
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(n10);
                        ((StringBuilder)object).append(" in onInterceptTouchEvent");
                        object = ((StringBuilder)object).toString();
                        String string3 = TAG;
                        Log.e((String)string3, (String)object);
                        return this.mIsBeingDragged;
                    } else {
                        float f11 = object.getY(n14);
                        n10 = (int)f11;
                        n13 = this.mLastMotionY;
                        if ((n13 = Math.abs(n10 - n13)) <= (n14 = this.mTouchSlop) || (n11 &= (n13 = this.getNestedScrollAxes())) != 0) return this.mIsBeingDragged;
                        this.mIsBeingDragged = n12;
                        this.mLastMotionY = n10;
                        this.initVelocityTrackerIfNotExists();
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.addMovement((MotionEvent)object);
                        this.mNestedYOffset = 0;
                        object = this.getParent();
                        if (object == null) return this.mIsBeingDragged;
                        object.requestDisallowInterceptTouchEvent(n12 != 0);
                    }
                    return this.mIsBeingDragged;
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = n13;
            this.recycleVelocityTracker();
            OverScroller overScroller = this.mScroller;
            int n15 = this.getScrollX();
            int n16 = this.getScrollY();
            int n17 = this.getScrollRange();
            boolean bl3 = overScroller.springBack(n15, n16, 0, 0, 0, n17);
            if (bl3) {
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
            this.stopNestedScroll(0);
            return this.mIsBeingDragged;
        }
        float f12 = object.getY();
        n10 = (int)f12;
        float f13 = object.getX();
        int n18 = (int)f13;
        if ((n18 = (int)(this.inChild(n18, n10) ? 1 : 0)) == 0) {
            this.mIsBeingDragged = false;
            this.recycleVelocityTracker();
            return this.mIsBeingDragged;
        } else {
            this.mLastMotionY = n10;
            this.mActivePointerId = n10 = object.getPointerId(0);
            this.initOrResetVelocityTracker();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.addMovement((MotionEvent)object);
            this.mScroller.computeScrollOffset();
            object = this.mScroller;
            int n19 = object.isFinished() ^ n12;
            this.mIsBeingDragged = n19;
            this.startNestedScroll(n11, 0);
        }
        return this.mIsBeingDragged;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        super.onLayout(n10 != 0, n11, n12, n13, n14);
        n10 = 0;
        View view = null;
        this.mIsLayoutDirty = false;
        View view2 = this.mChildToScrollTo;
        if (view2 != null && (n11 = (int)(NestedScrollView.isViewDescendantOf(view2, (View)this) ? 1 : 0)) != 0) {
            view2 = this.mChildToScrollTo;
            this.scrollToChild(view2);
        }
        n11 = 0;
        view2 = null;
        this.mChildToScrollTo = null;
        n13 = (int)(this.mIsLaidOut ? 1 : 0);
        if (n13 == 0) {
            NestedScrollView$SavedState nestedScrollView$SavedState = this.mSavedState;
            if (nestedScrollView$SavedState != null) {
                n13 = this.getScrollX();
                NestedScrollView$SavedState nestedScrollView$SavedState2 = this.mSavedState;
                int n15 = nestedScrollView$SavedState2.scrollPosition;
                this.scrollTo(n13, n15);
                this.mSavedState = null;
            }
            if ((n11 = this.getChildCount()) > 0) {
                view = this.getChildAt(0);
                view2 = (FrameLayout.LayoutParams)view.getLayoutParams();
                n10 = view.getMeasuredHeight();
                n13 = view2.topMargin;
                n10 += n13;
                n11 = view2.bottomMargin;
                n10 += n11;
            }
            n14 -= n12;
            n11 = this.getPaddingTop();
            n14 -= n11;
            n11 = this.getPaddingBottom();
            n14 -= n11;
            n11 = this.getScrollY();
            n10 = NestedScrollView.clamp(n11, n14, n10);
            if (n10 != n11) {
                n11 = this.getScrollX();
                this.scrollTo(n11, n10);
            }
        }
        n10 = this.getScrollX();
        n11 = this.getScrollY();
        this.scrollTo(n10, n11);
        this.mIsLaidOut = true;
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        int n12 = this.mFillViewport;
        if (n12 == 0) {
            return;
        }
        if ((n11 = View.MeasureSpec.getMode((int)n11)) == 0) {
            return;
        }
        n11 = this.getChildCount();
        if (n11 > 0) {
            n11 = 0;
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n13 = view.getMeasuredHeight();
            int n14 = this.getMeasuredHeight();
            int n15 = this.getPaddingTop();
            n14 -= n15;
            n15 = this.getPaddingBottom();
            n14 -= n15;
            n15 = layoutParams.topMargin;
            n14 -= n15;
            n15 = layoutParams.bottomMargin;
            if (n13 < (n14 -= n15)) {
                n13 = this.getPaddingLeft();
                n15 = this.getPaddingRight();
                n13 += n15;
                n15 = layoutParams.leftMargin;
                n13 += n15;
                n15 = layoutParams.rightMargin;
                n12 = layoutParams.width;
                n10 = FrameLayout.getChildMeasureSpec((int)n10, (int)(n13 += n15), (int)n12);
                n12 = View.MeasureSpec.makeMeasureSpec((int)n14, (int)0x40000000);
                view.measure(n10, n12);
            }
        }
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean bl2) {
        if (!bl2) {
            boolean bl3 = true;
            this.dispatchNestedFling(0.0f, f11, bl3);
            int n10 = (int)f11;
            this.fling(n10);
            return bl3;
        }
        return false;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return this.dispatchNestedPreFling(f10, f11);
    }

    public void onNestedPreScroll(View view, int n10, int n11, int[] nArray) {
        this.onNestedPreScroll(view, n10, n11, nArray, 0);
    }

    public void onNestedPreScroll(View view, int n10, int n11, int[] nArray, int n12) {
        this.dispatchNestedPreScroll(n10, n11, nArray, null, n12);
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13) {
        this.onNestedScrollInternal(n13, 0, null);
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13, int n14) {
        this.onNestedScrollInternal(n13, n14, null);
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13, int n14, int[] nArray) {
        this.onNestedScrollInternal(n13, n14, nArray);
    }

    public void onNestedScrollAccepted(View view, View view2, int n10) {
        this.onNestedScrollAccepted(view, view2, n10, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int n10, int n11) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n10, n11);
        this.startNestedScroll(2, n11);
    }

    public void onOverScrolled(int n10, int n11, boolean bl2, boolean bl3) {
        super.scrollTo(n10, n11);
    }

    public boolean onRequestFocusInDescendants(int n10, Rect rect) {
        int n11 = 2;
        if (n10 == n11) {
            n10 = 130;
        } else {
            n11 = 1;
            if (n10 == n11) {
                n10 = 33;
            }
        }
        View view = rect == null ? FocusFinder.getInstance().findNextFocus((ViewGroup)this, null, n10) : FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)this, rect, n10);
        if (view == null) {
            return false;
        }
        boolean bl2 = this.isOffScreen(view);
        if (bl2) {
            return false;
        }
        return view.requestFocus(n10, rect);
    }

    public void onRestoreInstanceState(Parcelable object) {
        boolean bl2 = object instanceof NestedScrollView$SavedState;
        if (!bl2) {
            super.onRestoreInstanceState(object);
            return;
        }
        object = (NestedScrollView$SavedState)((Object)object);
        Parcelable parcelable = object.getSuperState();
        super.onRestoreInstanceState(parcelable);
        this.mSavedState = object;
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        Parcelable parcelable = super.onSaveInstanceState();
        NestedScrollView$SavedState nestedScrollView$SavedState = new NestedScrollView$SavedState(parcelable);
        nestedScrollView$SavedState.scrollPosition = n10 = this.getScrollY();
        return nestedScrollView$SavedState;
    }

    public void onScrollChanged(int n10, int n11, int n12, int n13) {
        super.onScrollChanged(n10, n11, n12, n13);
        NestedScrollView$OnScrollChangeListener nestedScrollView$OnScrollChangeListener = this.mOnScrollChangeListener;
        if (nestedScrollView$OnScrollChangeListener != null) {
            nestedScrollView$OnScrollChangeListener.onScrollChange(this, n10, n11, n12, n13);
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        View view = this.findFocus();
        if (view != null && this != view) {
            Rect rect = null;
            n11 = (int)(this.isWithinDeltaOfScreen(view, 0, n13) ? 1 : 0);
            if (n11 != 0) {
                rect = this.mTempRect;
                view.getDrawingRect(rect);
                rect = this.mTempRect;
                this.offsetDescendantRectToMyCoords(view, rect);
                view = this.mTempRect;
                n10 = this.computeScrollDeltaToGetChildRectOnScreen((Rect)view);
                this.doScrollY(n10);
            }
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int n10) {
        return this.onStartNestedScroll(view, view2, n10, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int n10, int n11) {
        int n12 = n10 & 2;
        n12 = n12 != 0 ? 1 : 0;
        return n12 != 0;
    }

    public void onStopNestedScroll(View view) {
        this.onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int n10) {
        this.mParentHelper.onStopNestedScroll(view, n10);
        this.stopNestedScroll(n10);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object object;
        NestedScrollView nestedScrollView = this;
        MotionEvent motionEvent2 = motionEvent;
        this.initVelocityTrackerIfNotExists();
        Object object2 = motionEvent.getActionMasked();
        if (object2 == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent motionEvent3 = MotionEvent.obtain((MotionEvent)motionEvent);
        float f10 = nestedScrollView.mNestedYOffset;
        Object object3 = 0;
        float f11 = 0.0f;
        motionEvent3.offsetLocation(0.0f, f10);
        Object object4 = 2;
        f10 = 2.8E-45f;
        int n10 = 1;
        if (object2 != 0) {
            int n11 = -1;
            float f12 = 0.0f / 0.0f;
            if (object2 != n10) {
                if (object2 != object4) {
                    object4 = 3;
                    f10 = 4.2E-45f;
                    if (object2 != object4) {
                        object4 = 5;
                        f10 = 7.0E-45f;
                        if (object2 != object4) {
                            object4 = 6;
                            f10 = 8.4E-45f;
                            if (object2 == object4) {
                                this.onSecondaryPointerUp(motionEvent);
                                object2 = nestedScrollView.mActivePointerId;
                                object2 = motionEvent2.findPointerIndex(object2);
                                float f13 = motionEvent2.getY(object2);
                                nestedScrollView.mLastMotionY = object2 = (int)f13;
                            }
                        } else {
                            object2 = motionEvent.getActionIndex();
                            f10 = motionEvent2.getY(object2);
                            nestedScrollView.mLastMotionY = object4 = (int)f10;
                            nestedScrollView.mActivePointerId = object2 = motionEvent2.getPointerId(object2);
                        }
                    } else {
                        object2 = nestedScrollView.mIsBeingDragged;
                        if (object2 != 0 && (object2 = this.getChildCount()) > 0) {
                            OverScroller overScroller = nestedScrollView.mScroller;
                            int n12 = this.getScrollX();
                            int n13 = this.getScrollY();
                            boolean bl2 = false;
                            boolean bl3 = false;
                            int n14 = this.getScrollRange();
                            object2 = overScroller.springBack(n12, n13, 0, 0, 0, n14);
                            if (object2 != 0) {
                                ViewCompat.postInvalidateOnAnimation((View)this);
                            }
                        }
                        nestedScrollView.mActivePointerId = n11;
                        this.endDrag();
                    }
                } else {
                    object2 = nestedScrollView.mActivePointerId;
                    int n15 = motionEvent2.findPointerIndex(object2);
                    if (n15 == n11) {
                        object = new StringBuilder();
                        object.append("Invalid pointerId=");
                        object4 = nestedScrollView.mActivePointerId;
                        object.append((int)object4);
                        object.append(" in onTouchEvent");
                        object = object.toString();
                        String string2 = TAG;
                        Log.e((String)string2, (String)object);
                    } else {
                        Object object5;
                        float f14 = motionEvent2.getY(n15);
                        int n16 = (int)f14;
                        object2 = nestedScrollView.mLastMotionY - n16;
                        object4 = nestedScrollView.mIsBeingDragged;
                        if (object4 == 0 && (object4 = Math.abs(object2)) > (object3 = nestedScrollView.mTouchSlop)) {
                            object5 = this.getParent();
                            if (object5 != null) {
                                object5.requestDisallowInterceptTouchEvent(n10 != 0);
                            }
                            nestedScrollView.mIsBeingDragged = n10;
                            if (object2 > 0) {
                                object4 = nestedScrollView.mTouchSlop;
                                object2 -= object4;
                            } else {
                                object4 = nestedScrollView.mTouchSlop;
                                object2 += object4;
                            }
                        }
                        int n17 = object2;
                        object2 = nestedScrollView.mIsBeingDragged;
                        if (object2 != 0) {
                            object4 = 0;
                            f10 = 0.0f;
                            object5 = null;
                            int[] nArray = nestedScrollView.mScrollConsumed;
                            int[] nArray2 = nestedScrollView.mScrollOffset;
                            int[] nArray3 = null;
                            object = this;
                            object3 = n17;
                            object2 = this.dispatchNestedPreScroll(0, n17, nArray, nArray2, 0);
                            if (object2 != 0) {
                                object = nestedScrollView.mScrollConsumed;
                                object2 = object[n10];
                                n17 -= object2;
                                object2 = nestedScrollView.mNestedYOffset;
                                object5 = nestedScrollView.mScrollOffset;
                                object4 = object5[n10];
                                nestedScrollView.mNestedYOffset = object2 += object4;
                            }
                            int n18 = n17;
                            object = nestedScrollView.mScrollOffset;
                            object2 = object[n10];
                            nestedScrollView.mLastMotionY = n16 -= object2;
                            int n19 = this.getScrollY();
                            Object object6 = this.getScrollRange();
                            object2 = this.getOverScrollMode();
                            int n20 = object2 != 0 && (object2 != n10 || object6 <= 0) ? 0 : n10;
                            object4 = 0;
                            f10 = 0.0f;
                            object5 = null;
                            n11 = 0;
                            f12 = 0.0f;
                            nArray = null;
                            int n21 = this.getScrollY();
                            nArray3 = null;
                            n17 = 0;
                            int[] nArray4 = null;
                            Object object7 = 1;
                            object = this;
                            object3 = n18;
                            n16 = object6;
                            Object object8 = object6;
                            object6 = object7;
                            object2 = this.overScrollByCompat(0, n18, 0, n21, 0, n16, 0, 0, (boolean)object7);
                            if (object2 != 0 && (object2 = (Object)nestedScrollView.hasNestedScrollingParent(0)) == 0) {
                                object = nestedScrollView.mVelocityTracker;
                                object.clear();
                            }
                            object3 = this.getScrollY() - n19;
                            n21 = n18 - object3;
                            nArray4 = nestedScrollView.mScrollConsumed;
                            nArray4[n10] = 0;
                            f10 = 0.0f;
                            n11 = 0;
                            f12 = 0.0f;
                            nArray = null;
                            nArray3 = nestedScrollView.mScrollOffset;
                            n16 = 0;
                            object = this;
                            this.dispatchNestedScroll(0, (int)object3, 0, n21, nArray3, 0, nArray4);
                            object2 = nestedScrollView.mLastMotionY;
                            object5 = nestedScrollView.mScrollOffset;
                            object3 = object5[n10];
                            nestedScrollView.mLastMotionY = object2 -= object3;
                            object2 = nestedScrollView.mNestedYOffset;
                            object4 = object5[n10];
                            nestedScrollView.mNestedYOffset = object2 += object4;
                            if (n20 != 0) {
                                object = nestedScrollView.mScrollConsumed;
                                object2 = object[n10];
                                object2 = n18 - object2;
                                this.ensureGlows();
                                object4 = n19 + object2;
                                if (object4 < 0) {
                                    object5 = nestedScrollView.mEdgeGlowTop;
                                    f14 = object2;
                                    object3 = this.getHeight();
                                    f11 = object3;
                                    f14 /= f11;
                                    f11 = motionEvent2.getX(n15);
                                    n11 = this.getWidth();
                                    f12 = n11;
                                    EdgeEffectCompat.onPull((EdgeEffect)object5, f14, f11 /= f12);
                                    object = nestedScrollView.mEdgeGlowBottom;
                                    object2 = object.isFinished();
                                    if (object2 == 0) {
                                        object = nestedScrollView.mEdgeGlowBottom;
                                        object.onRelease();
                                    }
                                } else {
                                    object3 = object8;
                                    if (object4 > object8) {
                                        object5 = nestedScrollView.mEdgeGlowBottom;
                                        f14 = object2;
                                        f11 = this.getHeight();
                                        f14 /= f11;
                                        object3 = 1065353216;
                                        f12 = motionEvent2.getX(n15);
                                        n21 = this.getWidth();
                                        float f15 = n21;
                                        f11 = 1.0f - (f12 /= f15);
                                        EdgeEffectCompat.onPull((EdgeEffect)object5, f14, f11);
                                        object = nestedScrollView.mEdgeGlowTop;
                                        object2 = object.isFinished();
                                        if (object2 == 0) {
                                            object = nestedScrollView.mEdgeGlowTop;
                                            object.onRelease();
                                        }
                                    }
                                }
                                if ((object = nestedScrollView.mEdgeGlowTop) != null && ((object2 = (Object)object.isFinished()) == 0 || (object2 = (Object)(object = nestedScrollView.mEdgeGlowBottom).isFinished()) == 0)) {
                                    ViewCompat.postInvalidateOnAnimation((View)this);
                                }
                            }
                        }
                    }
                }
            } else {
                object = nestedScrollView.mVelocityTracker;
                f10 = 1.401E-42f;
                float f16 = nestedScrollView.mMaximumVelocity;
                object.computeCurrentVelocity(1000, f16);
                object4 = nestedScrollView.mActivePointerId;
                float f17 = object.getYVelocity(object4);
                object2 = (int)f17;
                object4 = Math.abs(object2);
                int n22 = nestedScrollView.mMinimumVelocity;
                if (object4 >= n22) {
                    f10 = object2 = -object2;
                    n22 = (int)(nestedScrollView.dispatchNestedPreFling(0.0f, f10) ? 1 : 0);
                    if (n22 == 0) {
                        nestedScrollView.dispatchNestedFling(0.0f, f10, n10 != 0);
                        nestedScrollView.fling((int)object2);
                    }
                } else {
                    OverScroller overScroller = nestedScrollView.mScroller;
                    int n23 = this.getScrollX();
                    int n24 = this.getScrollY();
                    boolean bl4 = false;
                    boolean bl5 = false;
                    int n25 = this.getScrollRange();
                    object2 = overScroller.springBack(n23, n24, 0, 0, 0, n25);
                    if (object2 != 0) {
                        ViewCompat.postInvalidateOnAnimation((View)this);
                    }
                }
                nestedScrollView.mActivePointerId = n11;
                this.endDrag();
            }
        } else {
            object2 = this.getChildCount();
            if (object2 == 0) {
                return false;
            }
            object = nestedScrollView.mScroller;
            object2 = object.isFinished() ^ n10;
            nestedScrollView.mIsBeingDragged = object2;
            if (object2 != 0 && (object = this.getParent()) != null) {
                object.requestDisallowInterceptTouchEvent(n10 != 0);
            }
            if ((object2 = (Object)(object = nestedScrollView.mScroller).isFinished()) == 0) {
                this.abortAnimatedScroll();
            }
            float f18 = motionEvent.getY();
            nestedScrollView.mLastMotionY = object2 = (int)f18;
            nestedScrollView.mActivePointerId = object2 = motionEvent2.getPointerId(0);
            nestedScrollView.startNestedScroll((int)object4, 0);
        }
        object = nestedScrollView.mVelocityTracker;
        if (object != null) {
            object.addMovement(motionEvent3);
        }
        motionEvent3.recycle();
        return n10 != 0;
    }

    public boolean overScrollByCompat(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, boolean bl2) {
        NestedScrollView nestedScrollView = this;
        int n18 = this.getOverScrollMode();
        int n19 = this.computeHorizontalScrollRange();
        int n20 = this.computeHorizontalScrollExtent();
        int n21 = 0;
        int n22 = 1;
        n19 = n19 > n20 ? n22 : 0;
        n20 = this.computeVerticalScrollRange();
        int n23 = this.computeVerticalScrollExtent();
        n20 = n20 > n23 ? n22 : 0;
        n19 = n18 != 0 && (n18 != n22 || n19 == 0) ? 0 : n22;
        n18 = n18 != 0 && (n18 != n22 || n20 == 0) ? 0 : n22;
        n20 = n12 + n10;
        n19 = n19 == 0 ? 0 : n16;
        n23 = n13 + n11;
        n18 = n18 == 0 ? 0 : n17;
        int n24 = -n19;
        int n25 = -n18;
        n18 += n15;
        if (n20 > (n19 += n14)) {
            n20 = n19;
            n19 = n22;
        } else if (n20 < n24) {
            n19 = n22;
            n20 = n24;
        } else {
            n19 = 0;
        }
        if (n23 > n18) {
            n23 = n18;
            n18 = n22;
        } else if (n23 < n25) {
            n18 = n22;
            n23 = n25;
        } else {
            n18 = 0;
        }
        if (n18 != 0 && (n24 = (int)(this.hasNestedScrollingParent(n22) ? 1 : 0)) == 0) {
            OverScroller overScroller = nestedScrollView.mScroller;
            n25 = 0;
            int n26 = this.getScrollRange();
            n11 = n20;
            n12 = n23;
            n13 = 0;
            n14 = 0;
            n15 = 0;
            n16 = n26;
            overScroller.springBack(n20, n23, 0, 0, 0, n26);
        }
        this.onOverScrolled(n20, n23, n19 != 0, n18 != 0);
        if (n19 != 0 || n18 != 0) {
            n21 = n22;
        }
        return n21 != 0;
    }

    public boolean pageScroll(int n10) {
        Rect rect;
        int n11 = 1;
        int n12 = 0;
        Rect rect2 = null;
        int n13 = 130;
        n13 = n10 == n13 ? n11 : 0;
        int n14 = this.getHeight();
        if (n13 != 0) {
            rect2 = this.mTempRect;
            rect2.top = n13 = this.getScrollY() + n14;
            n12 = this.getChildCount();
            if (n12 > 0) {
                rect = this.getChildAt(n12 -= n11);
                rect2 = (FrameLayout.LayoutParams)rect.getLayoutParams();
                n11 = rect.getBottom();
                n12 = rect2.bottomMargin;
                n11 += n12;
                n12 = this.getPaddingBottom();
                rect2 = this.mTempRect;
                n13 = rect2.top + n14;
                if (n13 > (n11 += n12)) {
                    rect2.top = n11 -= n14;
                }
            }
        } else {
            rect = this.mTempRect;
            rect.top = n13 = this.getScrollY() - n14;
            rect = this.mTempRect;
            n13 = rect.top;
            if (n13 < 0) {
                rect.top = 0;
            }
        }
        rect = this.mTempRect;
        n12 = rect.top;
        rect.bottom = n14 += n12;
        return this.scrollAndFocus(n10, n12, n14);
    }

    public void requestChildFocus(View view, View view2) {
        boolean bl2 = this.mIsLayoutDirty;
        if (!bl2) {
            this.scrollToChild(view2);
        } else {
            this.mChildToScrollTo = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        int n10 = view.getLeft();
        int n11 = view.getScrollX();
        n10 -= n11;
        n11 = view.getTop();
        int n12 = view.getScrollY();
        rect.offset(n10, n11 -= n12);
        return this.scrollToChildRect(rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        if (bl2) {
            this.recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(bl2);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    public void scrollTo(int n10, int n11) {
        int n12 = this.getChildCount();
        if (n12 > 0) {
            View view = this.getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
            int n13 = this.getWidth();
            int n14 = this.getPaddingLeft();
            n13 -= n14;
            n14 = this.getPaddingRight();
            n13 -= n14;
            n14 = view.getWidth();
            int n15 = layoutParams.leftMargin;
            n14 += n15;
            n15 = layoutParams.rightMargin;
            n14 += n15;
            n15 = this.getHeight();
            int n16 = this.getPaddingTop();
            n15 -= n16;
            n16 = this.getPaddingBottom();
            n15 -= n16;
            n12 = view.getHeight();
            n16 = layoutParams.topMargin;
            n12 += n16;
            int n17 = layoutParams.bottomMargin;
            n10 = NestedScrollView.clamp(n10, n13, n14);
            n11 = NestedScrollView.clamp(n11, n15, n12 += n17);
            n12 = this.getScrollX();
            if (n10 != n12 || n11 != (n12 = this.getScrollY())) {
                super.scrollTo(n10, n11);
            }
        }
    }

    public void setFillViewport(boolean bl2) {
        boolean bl3 = this.mFillViewport;
        if (bl2 != bl3) {
            this.mFillViewport = bl2;
            this.requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.mChildHelper.setNestedScrollingEnabled(bl2);
    }

    public void setOnScrollChangeListener(NestedScrollView$OnScrollChangeListener nestedScrollView$OnScrollChangeListener) {
        this.mOnScrollChangeListener = nestedScrollView$OnScrollChangeListener;
    }

    public void setSmoothScrollingEnabled(boolean bl2) {
        this.mSmoothScrollingEnabled = bl2;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int n10, int n11) {
        this.smoothScrollBy(n10, n11, 250, false);
    }

    public final void smoothScrollBy(int n10, int n11, int n12) {
        this.smoothScrollBy(n10, n11, n12, false);
    }

    public final void smoothScrollTo(int n10, int n11) {
        this.smoothScrollTo(n10, n11, 250, false);
    }

    public final void smoothScrollTo(int n10, int n11, int n12) {
        this.smoothScrollTo(n10, n11, n12, false);
    }

    public void smoothScrollTo(int n10, int n11, int n12, boolean bl2) {
        int n13 = this.getScrollX();
        n10 -= n13;
        n13 = this.getScrollY();
        this.smoothScrollBy(n10, n11 -= n13, n12, bl2);
    }

    public void smoothScrollTo(int n10, int n11, boolean bl2) {
        this.smoothScrollTo(n10, n11, 250, bl2);
    }

    public boolean startNestedScroll(int n10) {
        return this.startNestedScroll(n10, 0);
    }

    public boolean startNestedScroll(int n10, int n11) {
        return this.mChildHelper.startNestedScroll(n10, n11);
    }

    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }

    public void stopNestedScroll(int n10) {
        this.mChildHelper.stopNestedScroll(n10);
    }
}

