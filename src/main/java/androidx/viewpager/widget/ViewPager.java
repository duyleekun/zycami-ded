/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.database.DataSetObserver
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.FocusFinder
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.SoundEffectConstants
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.animation.Interpolator
 *  android.widget.EdgeEffect
 *  android.widget.Scroller
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager$1;
import androidx.viewpager.widget.ViewPager$2;
import androidx.viewpager.widget.ViewPager$3;
import androidx.viewpager.widget.ViewPager$4;
import androidx.viewpager.widget.ViewPager$DecorView;
import androidx.viewpager.widget.ViewPager$ItemInfo;
import androidx.viewpager.widget.ViewPager$LayoutParams;
import androidx.viewpager.widget.ViewPager$MyAccessibilityDelegate;
import androidx.viewpager.widget.ViewPager$OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import androidx.viewpager.widget.ViewPager$PageTransformer;
import androidx.viewpager.widget.ViewPager$PagerObserver;
import androidx.viewpager.widget.ViewPager$SavedState;
import androidx.viewpager.widget.ViewPager$ViewPositionComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator COMPARATOR;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = 255;
    public static final int[] LAYOUT_ATTRS;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator;
    private static final ViewPager$ViewPositionComparator sPositionComparator;
    private int mActivePointerId;
    public PagerAdapter mAdapter;
    private List mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    public int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager$OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private ViewPager$PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private ViewPager$OnPageChangeListener mOnPageChangeListener;
    private List mOnPageChangeListeners;
    private int mPageMargin;
    private ViewPager$PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ViewPager$ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    static {
        Object object = new int[]{16842931};
        LAYOUT_ATTRS = object;
        object = new ViewPager$1;
        object();
        COMPARATOR = object;
        object = new ViewPager$2;
        object();
        sInterpolator = (Interpolator)object;
        object = new ViewPager$ViewPositionComparator;
        object();
        sPositionComparator = object;
    }

    public ViewPager(Context object) {
        super(object);
        int n10;
        int n11;
        super();
        this.mItems = object;
        super();
        this.mTempItem = object;
        super();
        this.mTempRect = object;
        this.mRestoredCurItem = n11 = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = n10 = 1;
        this.mActivePointerId = n11;
        this.mFirstLayout = n10;
        this.mNeedCalculatePageOffsets = false;
        ViewPager$3 viewPager$3 = new ViewPager$3(this);
        this.mEndScrollRunnable = viewPager$3;
        this.mScrollState = 0;
        this.initViewPager();
    }

    public ViewPager(Context object, AttributeSet object2) {
        super(object, object2);
        int n10;
        int n11;
        super();
        this.mItems = object;
        super();
        this.mTempItem = object;
        super();
        this.mTempRect = object;
        this.mRestoredCurItem = n11 = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = n10 = 1;
        this.mActivePointerId = n11;
        this.mFirstLayout = n10;
        this.mNeedCalculatePageOffsets = false;
        super(this);
        this.mEndScrollRunnable = object2;
        this.mScrollState = 0;
        this.initViewPager();
    }

    private void calculatePageOffsets(ViewPager$ItemInfo viewPager$ItemInfo, int n10, ViewPager$ItemInfo object) {
        Object object2;
        float f10;
        float f11;
        int n11;
        Object object3;
        int n12;
        int n13;
        float f12;
        int n14;
        float f13;
        float f14;
        int n15;
        PagerAdapter pagerAdapter = this.mAdapter;
        int n16 = pagerAdapter.getCount();
        int n17 = this.getClientWidth();
        if (n17 > 0) {
            n15 = this.mPageMargin;
            f14 = n15;
            f13 = n17;
            f14 /= f13;
        } else {
            n15 = 0;
            f14 = 0.0f;
        }
        n17 = 0;
        f13 = 0.0f;
        if (object != null) {
            Object object4;
            float f15;
            int n18 = ((ViewPager$ItemInfo)object).position;
            n14 = viewPager$ItemInfo.position;
            if (n18 < n14) {
                f12 = ((ViewPager$ItemInfo)object).offset;
                f15 = ((ViewPager$ItemInfo)object).widthFactor;
                f12 = f12 + f15 + f14;
                ++n18;
                n13 = 0;
                object = null;
                f15 = 0.0f;
                while (n18 <= (n12 = viewPager$ItemInfo.position) && n13 < (n12 = ((ArrayList)(object3 = this.mItems)).size())) {
                    object3 = (ViewPager$ItemInfo)this.mItems.get(n13);
                    while (n18 > (n11 = ((ViewPager$ItemInfo)object3).position) && n13 < (n11 = ((ArrayList)(object4 = this.mItems)).size() + -1)) {
                        object3 = (ViewPager$ItemInfo)this.mItems.get(++n13);
                    }
                    while (n18 < (n11 = ((ViewPager$ItemInfo)object3).position)) {
                        object4 = this.mAdapter;
                        f11 = ((PagerAdapter)object4).getPageWidth(n18) + f14;
                        f12 += f11;
                        ++n18;
                    }
                    ((ViewPager$ItemInfo)object3).offset = f12;
                    f10 = ((ViewPager$ItemInfo)object3).widthFactor + f14;
                    f12 += f10;
                    ++n18;
                }
            } else if (n18 > n14) {
                object2 = this.mItems;
                n14 = ((ArrayList)object2).size() + -1;
                f15 = ((ViewPager$ItemInfo)object).offset;
                n18 += -1;
                while (n18 >= (n12 = viewPager$ItemInfo.position) && n14 >= 0) {
                    object3 = (ViewPager$ItemInfo)this.mItems.get(n14);
                    while (n18 < (n11 = ((ViewPager$ItemInfo)object3).position) && n14 > 0) {
                        object3 = (ViewPager$ItemInfo)this.mItems.get(n14 += -1);
                    }
                    while (n18 > (n11 = ((ViewPager$ItemInfo)object3).position)) {
                        object4 = this.mAdapter;
                        f11 = ((PagerAdapter)object4).getPageWidth(n18) + f14;
                        f15 -= f11;
                        n18 += -1;
                    }
                    f11 = ((ViewPager$ItemInfo)object3).widthFactor + f14;
                    ((ViewPager$ItemInfo)object3).offset = f15 -= f11;
                    n18 += -1;
                }
            }
        }
        object = this.mItems;
        n13 = ((ArrayList)object).size();
        float f16 = viewPager$ItemInfo.offset;
        n14 = viewPager$ItemInfo.position;
        n12 = n14 + -1;
        if (n14 == 0) {
            f11 = f16;
        } else {
            n11 = -8388609;
            f11 = -3.4028235E38f;
        }
        this.mFirstOffset = f11;
        n11 = 1065353216;
        f11 = 1.0f;
        if (n14 == (n16 += -1)) {
            f12 = viewPager$ItemInfo.widthFactor + f16 - f11;
        } else {
            n14 = 0x7F7FFFFF;
            f12 = Float.MAX_VALUE;
        }
        this.mLastOffset = f12;
        n14 = n10 + -1;
        while (n14 >= 0) {
            int n19;
            ViewPager$ItemInfo viewPager$ItemInfo2 = (ViewPager$ItemInfo)this.mItems.get(n14);
            while (n12 > (n19 = viewPager$ItemInfo2.position)) {
                PagerAdapter pagerAdapter2 = this.mAdapter;
                int n20 = n12 + -1;
                f10 = pagerAdapter2.getPageWidth(n12) + f14;
                f16 -= f10;
                n12 = n20;
            }
            float f17 = viewPager$ItemInfo2.widthFactor + f14;
            viewPager$ItemInfo2.offset = f16 -= f17;
            if (n19 == 0) {
                this.mFirstOffset = f16;
            }
            n14 += -1;
            n12 += -1;
        }
        f16 = viewPager$ItemInfo.offset;
        f12 = viewPager$ItemInfo.widthFactor;
        f16 = f16 + f12 + f14;
        int n21 = viewPager$ItemInfo.position + 1;
        ++n10;
        while (n10 < n13) {
            object2 = (ViewPager$ItemInfo)this.mItems.get(n10);
            while (n21 < (n12 = ((ViewPager$ItemInfo)object2).position)) {
                object3 = this.mAdapter;
                int n22 = n21 + 1;
                float f18 = ((PagerAdapter)object3).getPageWidth(n21) + f14;
                f16 += f18;
                n21 = n22;
            }
            if (n12 == n16) {
                this.mLastOffset = f10 = ((ViewPager$ItemInfo)object2).widthFactor + f16 - f11;
            }
            ((ViewPager$ItemInfo)object2).offset = f16;
            f12 = ((ViewPager$ItemInfo)object2).widthFactor + f14;
            f16 += f12;
            ++n10;
            ++n21;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean bl2) {
        Object object;
        int n10;
        int n11;
        Scroller scroller;
        int n12 = this.mScrollState;
        int n13 = 1;
        int n14 = 2;
        if ((n12 = n12 == n14 ? n13 : 0) != 0) {
            this.setScrollingCacheEnabled(false);
            scroller = this.mScroller;
            n14 = scroller.isFinished() ^ n13;
            if (n14 != 0) {
                scroller = this.mScroller;
                scroller.abortAnimation();
                n14 = this.getScrollX();
                n11 = this.getScrollY();
                Scroller scroller2 = this.mScroller;
                n10 = scroller2.getCurrX();
                Scroller scroller3 = this.mScroller;
                int n15 = scroller3.getCurrY();
                if (n14 != n10 || n11 != n15) {
                    this.scrollTo(n10, n15);
                    if (n10 != n14) {
                        this.pageScrolled(n10);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        scroller = null;
        for (n14 = 0; n14 < (n11 = ((ArrayList)(object = this.mItems)).size()); ++n14) {
            object = (ViewPager$ItemInfo)this.mItems.get(n14);
            n10 = ((ViewPager$ItemInfo)object).scrolling;
            if (n10 == 0) continue;
            ((ViewPager$ItemInfo)object).scrolling = false;
            n12 = n13;
        }
        if (n12 != 0) {
            if (bl2) {
                Runnable runnable = this.mEndScrollRunnable;
                ViewCompat.postOnAnimation((View)this, runnable);
            } else {
                Runnable runnable = this.mEndScrollRunnable;
                runnable.run();
            }
        }
    }

    private int determineTargetPage(int n10, float f10, int n11, int n12) {
        int n13;
        float f11;
        int n14;
        if ((n12 = Math.abs(n12)) > (n14 = this.mFlingDistance) && (n12 = Math.abs(n11)) > (n14 = this.mMinimumVelocity)) {
            if (n11 <= 0) {
                ++n10;
            }
        } else {
            n11 = this.mCurItem;
            if (n10 >= n11) {
                n11 = 1053609165;
                f11 = 0.4f;
            } else {
                n11 = 1058642330;
                f11 = 0.6f;
            }
            n13 = (int)(f10 += f11);
            n10 += n13;
        }
        Object object = this.mItems;
        n13 = ((ArrayList)object).size();
        if (n13 > 0) {
            object = this.mItems;
            f11 = 0.0f;
            object = (ViewPager$ItemInfo)((ArrayList)object).get(0);
            Object object2 = this.mItems;
            n12 = ((ArrayList)object2).size() + -1;
            object2 = (ViewPager$ItemInfo)((ArrayList)object2).get(n12);
            n13 = ((ViewPager$ItemInfo)object).position;
            n11 = ((ViewPager$ItemInfo)object2).position;
            n10 = Math.min(n10, n11);
            n10 = Math.max(n13, n10);
        }
        return n10;
    }

    private void dispatchOnPageScrolled(int n10, float f10, int n11) {
        Object object = this.mOnPageChangeListener;
        if (object != null) {
            object.onPageScrolled(n10, f10, n11);
        }
        if ((object = this.mOnPageChangeListeners) != null) {
            int n12 = object.size();
            for (int i10 = 0; i10 < n12; ++i10) {
                ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = (ViewPager$OnPageChangeListener)this.mOnPageChangeListeners.get(i10);
                if (viewPager$OnPageChangeListener == null) continue;
                viewPager$OnPageChangeListener.onPageScrolled(n10, f10, n11);
            }
        }
        if ((object = this.mInternalPageChangeListener) != null) {
            object.onPageScrolled(n10, f10, n11);
        }
    }

    private void dispatchOnPageSelected(int n10) {
        Object object = this.mOnPageChangeListener;
        if (object != null) {
            object.onPageSelected(n10);
        }
        if ((object = this.mOnPageChangeListeners) != null) {
            int n11 = object.size();
            for (int i10 = 0; i10 < n11; ++i10) {
                ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = (ViewPager$OnPageChangeListener)this.mOnPageChangeListeners.get(i10);
                if (viewPager$OnPageChangeListener == null) continue;
                viewPager$OnPageChangeListener.onPageSelected(n10);
            }
        }
        if ((object = this.mInternalPageChangeListener) != null) {
            object.onPageSelected(n10);
        }
    }

    private void dispatchOnScrollStateChanged(int n10) {
        Object object = this.mOnPageChangeListener;
        if (object != null) {
            object.onPageScrollStateChanged(n10);
        }
        if ((object = this.mOnPageChangeListeners) != null) {
            int n11 = object.size();
            for (int i10 = 0; i10 < n11; ++i10) {
                ViewPager$OnPageChangeListener viewPager$OnPageChangeListener = (ViewPager$OnPageChangeListener)this.mOnPageChangeListeners.get(i10);
                if (viewPager$OnPageChangeListener == null) continue;
                viewPager$OnPageChangeListener.onPageScrollStateChanged(n10);
            }
        }
        if ((object = this.mInternalPageChangeListener) != null) {
            object.onPageScrollStateChanged(n10);
        }
    }

    private void enableLayers(boolean bl2) {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = bl2 ? this.mPageTransformerLayerType : 0;
            View view = this.getChildAt(i10);
            view.setLayerType(n11, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            velocityTracker = null;
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        int n10;
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = n10 = view.getLeft();
        rect.right = n10 = view.getRight();
        rect.top = n10 = view.getTop();
        rect.bottom = n10 = view.getBottom();
        for (view = view.getParent(); (n10 = view instanceof ViewGroup) != 0 && view != this; view = view.getParent()) {
            view = (ViewGroup)view;
            n10 = rect.left;
            int n11 = view.getLeft();
            rect.left = n10 += n11;
            n10 = rect.right;
            n11 = view.getRight();
            rect.right = n10 += n11;
            n10 = rect.top;
            n11 = view.getTop();
            rect.top = n10 += n11;
            n10 = rect.bottom;
            n11 = view.getBottom();
            rect.bottom = n10 += n11;
        }
        return rect;
    }

    private int getClientWidth() {
        int n10 = this.getMeasuredWidth();
        int n11 = this.getPaddingLeft();
        n10 -= n11;
        n11 = this.getPaddingRight();
        return n10 - n11;
    }

    private ViewPager$ItemInfo infoForCurrentScrollPosition() {
        Object object;
        int n10;
        float f10;
        int n11;
        float f11;
        float f12;
        int n12;
        int n13 = this.getClientWidth();
        float f13 = 0.0f;
        PagerAdapter pagerAdapter = null;
        if (n13 > 0) {
            n12 = this.getScrollX();
            f12 = n12;
            f11 = n13;
            f12 /= f11;
        } else {
            n12 = 0;
            f12 = 0.0f;
        }
        if (n13 > 0) {
            n11 = this.mPageMargin;
            f11 = n11;
            f10 = n13;
            f11 /= f10;
        } else {
            n11 = 0;
            f11 = 0.0f;
        }
        n13 = 0;
        f10 = 0.0f;
        Object object2 = null;
        int n14 = 1;
        int n15 = -1;
        int n16 = n14;
        float f14 = 0.0f;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mItems)).size()); ++i10) {
            int n17;
            object = (ViewPager$ItemInfo)this.mItems.get(i10);
            if (n16 == 0 && (n17 = ((ViewPager$ItemInfo)object).position) != (n15 += n14)) {
                object = this.mTempItem;
                ((ViewPager$ItemInfo)object).offset = f13 = f13 + f14 + f11;
                ((ViewPager$ItemInfo)object).position = n15;
                pagerAdapter = this.mAdapter;
                ((ViewPager$ItemInfo)object).widthFactor = f13 = pagerAdapter.getPageWidth(n15);
                i10 += -1;
            }
            f13 = ((ViewPager$ItemInfo)object).offset;
            f14 = ((ViewPager$ItemInfo)object).widthFactor + f13 + f11;
            if (n16 == 0 && (n15 = (int)(f12 == f13 ? 0 : (f12 > f13 ? 1 : -1))) < 0) {
                return object2;
            }
            n13 = (int)(f12 == f14 ? 0 : (f12 < f14 ? -1 : 1));
            if (n13 >= 0 && i10 != (n13 = ((ArrayList)(object2 = this.mItems)).size() - n14)) {
                n15 = ((ViewPager$ItemInfo)object).position;
                f14 = ((ViewPager$ItemInfo)object).widthFactor;
                n16 = 0;
                object2 = object;
                continue;
            }
            return object;
        }
        return object2;
    }

    private static boolean isDecorView(View object) {
        boolean bl2;
        object = object.getClass();
        Class<ViewPager$DecorView> clazz = ViewPager$DecorView.class;
        if ((object = ((Class)object).getAnnotation(clazz)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private boolean isGutterDrag(float f10, float f11) {
        void var6_13;
        float f12;
        float f13;
        int n10;
        int n11;
        int n12;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18 = this.mGutterSize;
        float f19 = f10 - f18;
        Object object = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
        if (object < 0 && (f17 = (f16 = f11 - 0.0f) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) > 0 || (f15 = (f14 = f10 - (f18 = (float)(n12 = (n11 = this.getWidth()) - (n10 = this.mGutterSize)))) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) > 0 && (f13 = (f12 = f11 - 0.0f) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) < 0) {
            boolean bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
        }
        return (boolean)var6_13;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getActionIndex();
        int n12 = motionEvent.getPointerId(n11);
        if (n12 == (n10 = this.mActivePointerId)) {
            int n13;
            float f10;
            n11 = n11 == 0 ? 1 : 0;
            this.mLastMotionX = f10 = motionEvent.getX(n11);
            this.mActivePointerId = n13 = motionEvent.getPointerId(n11);
            motionEvent = this.mVelocityTracker;
            if (motionEvent != null) {
                motionEvent.clear();
            }
        }
    }

    private boolean pageScrolled(int n10) {
        Object object = this.mItems;
        int n11 = ((ArrayList)object).size();
        String string2 = "onPageScrolled did not call superclass implementation";
        if (n11 == 0) {
            n10 = (int)(this.mFirstLayout ? 1 : 0);
            if (n10 != 0) {
                return false;
            }
            this.mCalledSuper = false;
            float f10 = 0.0f;
            IllegalStateException illegalStateException = null;
            this.onPageScrolled(0, 0.0f, 0);
            n10 = (int)(this.mCalledSuper ? 1 : 0);
            if (n10 != 0) {
                return false;
            }
            illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        object = this.infoForCurrentScrollPosition();
        int n12 = this.getClientWidth();
        int n13 = this.mPageMargin;
        int n14 = n12 + n13;
        float f11 = n13;
        float f12 = n12;
        f11 /= f12;
        int n15 = ((ViewPager$ItemInfo)object).position;
        float f13 = (float)n10 / f12;
        f12 = ((ViewPager$ItemInfo)object).offset;
        f13 -= f12;
        float f14 = ((ViewPager$ItemInfo)object).widthFactor + f11;
        f13 /= f14;
        f14 = (float)n14 * f13;
        n11 = (int)f14;
        this.mCalledSuper = false;
        this.onPageScrolled(n15, f13, n11);
        n10 = (int)(this.mCalledSuper ? 1 : 0);
        if (n10 != 0) {
            return true;
        }
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    private boolean performDrag(float f10) {
        Object object;
        int n10;
        int n11;
        float f11 = this.mLastMotionX - f10;
        this.mLastMotionX = f10;
        int n12 = this.getScrollX();
        f10 = (float)n12 + f11;
        int n13 = this.getClientWidth();
        f11 = n13;
        float f12 = this.mFirstOffset * f11;
        float f13 = this.mLastOffset * f11;
        Object object2 = this.mItems;
        int n14 = 0;
        object2 = (ViewPager$ItemInfo)((ArrayList)object2).get(0);
        Object object3 = this.mItems;
        int n15 = ((ArrayList)object3).size();
        int n16 = 1;
        object3 = (ViewPager$ItemInfo)((ArrayList)object3).get(n15 -= n16);
        n15 = ((ViewPager$ItemInfo)object2).position;
        if (n15 != 0) {
            f12 = ((ViewPager$ItemInfo)object2).offset * f11;
            n11 = 0;
            object2 = null;
        } else {
            n11 = n16;
        }
        n15 = ((ViewPager$ItemInfo)object3).position;
        PagerAdapter pagerAdapter = this.mAdapter;
        int n17 = pagerAdapter.getCount() - n16;
        if (n15 != n17) {
            f13 = ((ViewPager$ItemInfo)object3).offset * f11;
            n10 = 0;
            object3 = null;
        } else {
            n10 = n16;
        }
        n15 = (int)(f10 == f12 ? 0 : (f10 < f12 ? -1 : 1));
        if (n15 < 0) {
            if (n11 != 0) {
                f10 = f12 - f10;
                EdgeEffect edgeEffect = this.mLeftEdge;
                f10 = Math.abs(f10) / f11;
                edgeEffect.onPull(f10);
                n14 = n16;
            }
            f10 = f12;
        } else {
            object = f10 == f13 ? 0 : (f10 > f13 ? 1 : -1);
            if (object > 0) {
                if (n10 != 0) {
                    f10 -= f13;
                    EdgeEffect edgeEffect = this.mRightEdge;
                    f10 = Math.abs(f10) / f11;
                    edgeEffect.onPull(f10);
                    n14 = n16;
                }
                f10 = f13;
            }
        }
        f11 = this.mLastMotionX;
        object = (int)f10;
        f13 = object;
        this.mLastMotionX = f11 += (f10 -= f13);
        n12 = this.getScrollY();
        this.scrollTo((int)object, n12);
        this.pageScrolled((int)object);
        return n14 != 0;
    }

    private void recomputeScrollPosition(int n10, int n11, int n12, int n13) {
        ArrayList arrayList;
        int n14;
        if (n11 > 0 && (n14 = (arrayList = this.mItems).isEmpty()) == 0) {
            arrayList = this.mScroller;
            n14 = arrayList.isFinished();
            if (n14 == 0) {
                Scroller scroller = this.mScroller;
                n11 = this.getCurrentItem();
                n12 = this.getClientWidth();
                scroller.setFinalX(n11 *= n12);
            } else {
                n14 = this.getPaddingLeft();
                n10 -= n14;
                n14 = this.getPaddingRight();
                n10 = n10 - n14 + n12;
                n12 = this.getPaddingLeft();
                n11 -= n12;
                n12 = this.getPaddingRight();
                n11 = n11 - n12 + n13;
                n12 = this.getScrollX();
                float f10 = n12;
                float f11 = n11;
                f10 /= f11;
                float f12 = n10;
                n10 = (int)(f10 *= f12);
                n11 = this.getScrollY();
                this.scrollTo(n10, n11);
            }
        } else {
            float f13;
            n11 = this.mCurItem;
            ViewPager$ItemInfo viewPager$ItemInfo = this.infoForPosition(n11);
            if (viewPager$ItemInfo != null) {
                f13 = viewPager$ItemInfo.offset;
                float f14 = this.mLastOffset;
                f13 = Math.min(f13, f14);
            } else {
                n11 = 0;
                f13 = 0.0f;
                viewPager$ItemInfo = null;
            }
            n12 = this.getPaddingLeft();
            n10 -= n12;
            n12 = this.getPaddingRight();
            float f15 = n10 - n12;
            n10 = (int)(f13 *= f15);
            n11 = this.getScrollX();
            if (n10 != n11) {
                f13 = 0.0f;
                viewPager$ItemInfo = null;
                this.completeScroll(false);
                n11 = this.getScrollY();
                this.scrollTo(n10, n11);
            }
        }
    }

    private void removeNonDecorViews() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)this.getChildAt(i10).getLayoutParams();
            n10 = (int)(viewPager$LayoutParams.isDecor ? 1 : 0);
            if (n10 != 0) continue;
            this.removeViewAt(i10);
            i10 += -1;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean bl2) {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(bl2);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        this.endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        EdgeEffect edgeEffect = this.mLeftEdge;
        boolean bl2 = edgeEffect.isFinished();
        if (!bl2 && !(bl2 = (edgeEffect = this.mRightEdge).isFinished())) {
            bl2 = false;
            edgeEffect = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void scrollToItem(int n10, boolean bl2, int n11, boolean bl3) {
        int n12;
        ViewPager$ItemInfo viewPager$ItemInfo = this.infoForPosition(n10);
        if (viewPager$ItemInfo != null) {
            int n13 = this.getClientWidth();
            float f10 = n13;
            float f11 = this.mFirstOffset;
            float f12 = viewPager$ItemInfo.offset;
            float f13 = this.mLastOffset;
            f12 = Math.min(f12, f13);
            f12 = Math.max(f11, f12);
            n12 = (int)(f10 *= f12);
        } else {
            n12 = 0;
            viewPager$ItemInfo = null;
            float f14 = 0.0f;
        }
        if (bl2) {
            this.smoothScrollTo(n12, 0, n11);
            if (bl3) {
                this.dispatchOnPageSelected(n10);
            }
        } else {
            if (bl3) {
                this.dispatchOnPageSelected(n10);
            }
            this.completeScroll(false);
            this.scrollTo(n12, 0);
            this.pageScrolled(n12);
        }
    }

    private void setScrollingCacheEnabled(boolean bl2) {
        boolean bl3 = this.mScrollingCacheEnabled;
        if (bl3 != bl2) {
            this.mScrollingCacheEnabled = bl2;
        }
    }

    private void sortChildDrawingOrder() {
        int n10 = this.mDrawingOrder;
        if (n10 != 0) {
            ArrayList arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = arrayList = new ArrayList();
            } else {
                arrayList.clear();
            }
            n10 = this.getChildCount();
            ViewPager$ViewPositionComparator viewPager$ViewPositionComparator = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                View view = this.getChildAt(i10);
                ArrayList arrayList2 = this.mDrawingOrderedChildren;
                arrayList2.add(view);
            }
            arrayList = this.mDrawingOrderedChildren;
            viewPager$ViewPositionComparator = sPositionComparator;
            Collections.sort(arrayList, viewPager$ViewPositionComparator);
        }
    }

    public void addFocusables(ArrayList arrayList, int n10, int n11) {
        int n12;
        int n13 = arrayList.size();
        int n14 = this.getDescendantFocusability();
        if (n14 != (n12 = 393216)) {
            int n15;
            for (n12 = 0; n12 < (n15 = this.getChildCount()); ++n12) {
                int n16;
                ViewPager$ItemInfo viewPager$ItemInfo;
                View view = this.getChildAt(n12);
                int n17 = view.getVisibility();
                if (n17 != 0 || (viewPager$ItemInfo = this.infoForChild(view)) == null || (n17 = viewPager$ItemInfo.position) != (n16 = this.mCurItem)) continue;
                view.addFocusables(arrayList, n10, n11);
            }
        }
        if (n14 != (n10 = 262144) || n13 == (n10 = arrayList.size())) {
            n10 = (int)(this.isFocusable() ? 1 : 0);
            if (n10 == 0) {
                return;
            }
            n10 = 1;
            if ((n11 &= n10) == n10 && (n10 = (int)(this.isInTouchMode() ? 1 : 0)) != 0 && (n10 = (int)(this.isFocusableInTouchMode() ? 1 : 0)) == 0) {
                return;
            }
            if (arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    public ViewPager$ItemInfo addNewItem(int n10, int n11) {
        ArrayList arrayList;
        float f10;
        Object object;
        ViewPager$ItemInfo viewPager$ItemInfo = new ViewPager$ItemInfo();
        viewPager$ItemInfo.position = n10;
        viewPager$ItemInfo.object = object = this.mAdapter.instantiateItem(this, n10);
        object = this.mAdapter;
        viewPager$ItemInfo.widthFactor = f10 = ((PagerAdapter)object).getPageWidth(n10);
        if (n11 >= 0 && n11 < (n10 = (arrayList = this.mItems).size())) {
            arrayList = this.mItems;
            arrayList.add(n11, viewPager$ItemInfo);
        } else {
            arrayList = this.mItems;
            arrayList.add(viewPager$ItemInfo);
        }
        return viewPager$ItemInfo;
    }

    public void addOnAdapterChangeListener(ViewPager$OnAdapterChangeListener viewPager$OnAdapterChangeListener) {
        ArrayList arrayList = this.mAdapterChangeListeners;
        if (arrayList == null) {
            this.mAdapterChangeListeners = arrayList = new ArrayList();
        }
        this.mAdapterChangeListeners.add(viewPager$OnAdapterChangeListener);
    }

    public void addOnPageChangeListener(ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        ArrayList arrayList = this.mOnPageChangeListeners;
        if (arrayList == null) {
            this.mOnPageChangeListeners = arrayList = new ArrayList();
        }
        this.mOnPageChangeListeners.add(viewPager$OnPageChangeListener);
    }

    public void addTouchables(ArrayList arrayList) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            int n11;
            ViewPager$ItemInfo viewPager$ItemInfo;
            View view = this.getChildAt(i10);
            int n12 = view.getVisibility();
            if (n12 != 0 || (viewPager$ItemInfo = this.infoForChild(view)) == null || (n12 = viewPager$ItemInfo.position) != (n11 = this.mCurItem)) continue;
            view.addTouchables(arrayList);
        }
    }

    public void addView(View object, int n10, ViewGroup.LayoutParams layoutParams) {
        boolean bl2 = this.checkLayoutParams(layoutParams);
        if (!bl2) {
            layoutParams = this.generateLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        layoutParams2 = (ViewPager$LayoutParams)layoutParams;
        boolean bl3 = layoutParams2.isDecor;
        boolean bl4 = ViewPager.isDecorView(object);
        layoutParams2.isDecor = bl3 |= bl4;
        bl4 = this.mInLayout;
        if (bl4) {
            if (layoutParams2 != null && bl3) {
                object = new IllegalStateException("Cannot add pager decor view during layout");
                throw object;
            }
            layoutParams2.needsMeasure = bl3 = true;
            this.addViewInLayout((View)object, n10, layoutParams);
        } else {
            super.addView(object, n10, layoutParams);
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean arrowScroll(int var1_1) {
        block15: {
            block16: {
                block17: {
                    block13: {
                        var2_2 = this.findFocus();
                        var3_3 = 1;
                        var4_4 = 0;
                        var5_5 = null;
                        var6_6 = null;
                        if (var2_2 == this) lbl-1000:
                        // 2 sources

                        {
                            while (true) {
                                var7_9 = 0;
                                var2_2 = null;
                                break block13;
                                break;
                            }
                        }
                        if (var2_2 != null) {
                            block14: {
                                var8_10 = var2_2.getParent();
                                while ((var9_7 = var8_10 instanceof ViewGroup) != 0) {
                                    if (var8_10 == this) {
                                        var10_8 = var3_3;
                                        break block14;
                                    }
                                    var8_10 = var8_10.getParent();
                                }
                                var10_8 = 0;
                                var8_10 = null;
                            }
                            if (var10_8 == 0) {
                                var8_10 = new StringBuilder();
                                var11_11 = var2_2.getClass().getSimpleName();
                                var8_10.append(var11_11);
                                var2_2 = var2_2.getParent();
                                while ((var9_7 = var2_2 instanceof ViewGroup) != 0) {
                                    var8_10.append(" => ");
                                    var11_11 = var2_2.getClass().getSimpleName();
                                    var8_10.append(var11_11);
                                    var2_2 = ((ViewParent)var2_2).getParent();
                                }
                                var2_2 = new StringBuilder();
                                var11_11 = "arrowScroll tried to find focus based on non-child current focused view ";
                                var2_2.append(var11_11);
                                var8_10 = var8_10.toString();
                                var2_2.append((String)var8_10);
                                var2_2 = var2_2.toString();
                                var8_10 = "ViewPager";
                                Log.e((String)var8_10, (String)var2_2);
                                ** continue;
                            }
                        }
                    }
                    var6_6 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, (View)var2_2, var1_1);
                    var10_8 = 66;
                    var9_7 = 17;
                    if (var6_6 == null || var6_6 == var2_2) break block16;
                    if (var1_1 == var9_7) {
                        var12_12 = this.mTempRect;
                        var12_12 = this.getChildRectInPagerCoordinates(var12_12, var6_6);
                        var3_3 = var12_12.left;
                        var5_5 = this.mTempRect;
                        var5_5 = this.getChildRectInPagerCoordinates(var5_5, (View)var2_2);
                        var4_4 = var5_5.left;
                        var7_9 = var2_2 != null && var3_3 >= var4_4 ? (int)this.pageLeft() : (int)var6_6.requestFocus();
lbl61:
                        // 3 sources

                        while (true) {
                            var4_4 = var7_9;
                            break block15;
                            break;
                        }
                    }
                    if (var1_1 != var10_8) break block15;
                    var12_13 = this.mTempRect;
                    var12_13 = this.getChildRectInPagerCoordinates(var12_13, var6_6);
                    var3_3 = var12_13.left;
                    var5_5 = this.mTempRect;
                    var5_5 = this.getChildRectInPagerCoordinates(var5_5, (View)var2_2);
                    var4_4 = var5_5.left;
                    if (var2_2 == null || var3_3 > var4_4) break block17;
                    var7_9 = (int)this.pageRight();
                    ** GOTO lbl61
                }
                var7_9 = (int)var6_6.requestFocus();
                ** while (true)
            }
            if (var1_1 != var9_7 && var1_1 != var3_3) {
                if (var1_1 == var10_8 || var1_1 == (var7_9 = 2)) {
                    var4_4 = this.pageRight();
                }
            } else {
                var4_4 = this.pageLeft();
            }
        }
        if (var4_4 != 0) {
            var1_1 = SoundEffectConstants.getContantForFocusDirection((int)var1_1);
            this.playSoundEffect(var1_1);
        }
        return (boolean)var4_4;
    }

    public boolean beginFakeDrag() {
        boolean bl2 = this.mIsBeingDragged;
        if (bl2) {
            return false;
        }
        this.mFakeDragging = bl2 = true;
        this.setScrollState((int)(bl2 ? 1 : 0));
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = velocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long l10 = SystemClock.uptimeMillis();
        velocityTracker = MotionEvent.obtain((long)l10, (long)l10, (int)0, (float)0.0f, (float)0.0f, (int)0);
        this.mVelocityTracker.addMovement((MotionEvent)velocityTracker);
        velocityTracker.recycle();
        this.mFakeDragBeginTime = l10;
        return bl2;
    }

    public boolean canScroll(View view, boolean bl2, int n10, int n11, int n12) {
        int n13;
        block6: {
            block5: {
                int n14 = view instanceof ViewGroup;
                n13 = 1;
                if (n14 != 0) {
                    View view2 = view;
                    view2 = (ViewGroup)view;
                    int n15 = view.getScrollX();
                    int n16 = view.getScrollY();
                    for (int i10 = view2.getChildCount() - n13; i10 >= 0; i10 += -1) {
                        int n17;
                        int n18 = n11 + n15;
                        View view3 = view2.getChildAt(i10);
                        int n19 = view3.getLeft();
                        if (n18 < n19 || n18 >= (n19 = view3.getRight()) || (n19 = n12 + n16) < (n17 = view3.getTop()) || n19 >= (n17 = view3.getBottom())) continue;
                        int n20 = view3.getLeft();
                        n20 = n18 - n20;
                        n18 = view3.getTop();
                        int n21 = n19 - n18;
                        n19 = 1;
                        n17 = n10;
                        n18 = (int)(this.canScroll(view3, n19 != 0, n10, n20, n21) ? 1 : 0);
                        if (n18 == 0) continue;
                        return n13 != 0;
                    }
                }
                if (!bl2) break block5;
                n14 = n10;
                n14 = -n10;
                boolean bl3 = view.canScrollHorizontally(n14);
                if (bl3) break block6;
            }
            n13 = 0;
        }
        return n13 != 0;
    }

    public boolean canScrollHorizontally(int n10) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean bl2 = false;
        if (pagerAdapter == null) {
            return false;
        }
        int n11 = this.getClientWidth();
        int n12 = this.getScrollX();
        boolean bl3 = true;
        if (n10 < 0) {
            float f10 = n11;
            float f11 = this.mFirstOffset;
            n10 = (int)(f10 *= f11);
            if (n12 > n10) {
                bl2 = bl3;
            }
            return bl2;
        }
        if (n10 > 0) {
            float f12 = n11;
            float f13 = this.mLastOffset;
            n10 = (int)(f12 *= f13);
            if (n12 < n10) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2;
        boolean bl3 = layoutParams instanceof ViewPager$LayoutParams;
        if (bl3 && (bl2 = super.checkLayoutParams(layoutParams))) {
            bl2 = true;
        } else {
            bl2 = false;
            layoutParams = null;
        }
        return bl2;
    }

    public void clearOnPageChangeListeners() {
        List list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        int n10;
        this.mIsScrollStarted = n10 = 1;
        Scroller scroller = this.mScroller;
        int n11 = scroller.isFinished();
        if (n11 == 0 && (n11 = (scroller = this.mScroller).computeScrollOffset()) != 0) {
            n10 = this.getScrollX();
            n11 = this.getScrollY();
            Scroller scroller2 = this.mScroller;
            int n12 = scroller2.getCurrX();
            Scroller scroller3 = this.mScroller;
            int n13 = scroller3.getCurrY();
            if (n10 != n12 || n11 != n13) {
                this.scrollTo(n12, n13);
                n10 = (int)(this.pageScrolled(n12) ? 1 : 0);
                if (n10 == 0) {
                    this.mScroller.abortAnimation();
                    n10 = 0;
                    this.scrollTo(0, n13);
                }
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
            return;
        }
        this.completeScroll(n10 != 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void dataSetChanged() {
        Object object;
        int n10;
        int n11;
        Object object2 = this.mAdapter;
        this.mExpectedAdapterCount = n11 = ((PagerAdapter)object2).getCount();
        Object object3 = this.mItems;
        int n12 = ((ArrayList)object3).size();
        int n13 = this.mOffscreenPageLimit * 2;
        int n14 = 1;
        if (n12 < (n13 += n14) && (n12 = ((ArrayList)(object3 = this.mItems)).size()) < n11) {
            n12 = n14;
        } else {
            n12 = 0;
            object3 = null;
        }
        n13 = this.mCurItem;
        Object var8_8 = null;
        int n15 = 0;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mItems)).size()); i10 += n14) {
            int n16;
            object = (ViewPager$ItemInfo)this.mItems.get(i10);
            PagerAdapter pagerAdapter = this.mAdapter;
            Object object4 = ((ViewPager$ItemInfo)object).object;
            int n17 = pagerAdapter.getItemPosition(object4);
            if (n17 == (n16 = -1)) continue;
            n16 = -2;
            if (n17 == n16) {
                object3 = this.mItems;
                ((ArrayList)object3).remove(i10);
                i10 += -1;
                if (n15 == 0) {
                    object3 = this.mAdapter;
                    ((PagerAdapter)object3).startUpdate(this);
                    n15 = n14;
                }
                object3 = this.mAdapter;
                n17 = ((ViewPager$ItemInfo)object).position;
                object4 = ((ViewPager$ItemInfo)object).object;
                ((PagerAdapter)object3).destroyItem(this, n17, object4);
                n12 = this.mCurItem;
                n10 = ((ViewPager$ItemInfo)object).position;
                if (n12 == n10) {
                    n13 = n11 + -1;
                    n12 = Math.min(n12, n13);
                    n13 = n12 = Math.max(0, n12);
                }
            } else {
                n16 = ((ViewPager$ItemInfo)object).position;
                if (n16 == n17) continue;
                n12 = this.mCurItem;
                if (n16 == n12) {
                    n13 = n17;
                }
                ((ViewPager$ItemInfo)object).position = n17;
            }
            n12 = n14;
        }
        if (n15 != 0) {
            object2 = this.mAdapter;
            ((PagerAdapter)object2).finishUpdate(this);
        }
        object2 = this.mItems;
        Comparator comparator = COMPARATOR;
        Collections.sort(object2, comparator);
        if (n12 != 0) {
            n11 = this.getChildCount();
            object3 = null;
            for (n12 = 0; n12 < n11; ++n12) {
                ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)this.getChildAt(n12).getLayoutParams();
                n15 = viewPager$LayoutParams.isDecor;
                if (n15 != 0) continue;
                n15 = 0;
                viewPager$LayoutParams.widthFactor = 0.0f;
            }
            this.setCurrentItemInternal(n13, false, n14 != 0);
            this.requestLayout();
        }
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

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int n10;
        int n11 = accessibilityEvent.getEventType();
        if (n11 == (n10 = 4096)) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        n11 = this.getChildCount();
        n10 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            boolean bl2;
            int n12;
            ViewPager$ItemInfo viewPager$ItemInfo;
            View view = this.getChildAt(i10);
            int n13 = view.getVisibility();
            if (n13 != 0 || (viewPager$ItemInfo = this.infoForChild(view)) == null || (n13 = viewPager$ItemInfo.position) != (n12 = this.mCurItem) || !(bl2 = view.dispatchPopulateAccessibilityEvent(accessibilityEvent))) continue;
            return true;
        }
        return false;
    }

    public float distanceInfluenceForSnapDuration(float f10) {
        return (float)Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public void draw(Canvas canvas) {
        Object object;
        int n10;
        super.draw(canvas);
        int n11 = this.getOverScrollMode();
        int n12 = 0;
        if (n11 != 0 && (n11 != (n10 = 1) || (object = this.mAdapter) == null || (n11 = ((PagerAdapter)object).getCount()) <= n10)) {
            this.mLeftEdge.finish();
            canvas = this.mRightEdge;
            canvas.finish();
        } else {
            EdgeEffect edgeEffect;
            EdgeEffect edgeEffect2;
            float f10;
            float f11;
            float f12;
            int n13;
            int n14;
            object = this.mLeftEdge;
            n11 = (int)(object.isFinished() ? 1 : 0);
            if (n11 == 0) {
                n11 = canvas.save();
                n10 = this.getHeight();
                n14 = this.getPaddingTop();
                n10 -= n14;
                n14 = this.getPaddingBottom();
                n10 -= n14;
                n14 = this.getWidth();
                canvas.rotate(270.0f);
                n13 = -n10;
                int n15 = this.getPaddingTop();
                f12 = n13 += n15;
                f11 = this.mFirstOffset;
                f10 = n14;
                canvas.translate(f12, f11 *= f10);
                edgeEffect2 = this.mLeftEdge;
                edgeEffect2.setSize(n10, n14);
                edgeEffect = this.mLeftEdge;
                n10 = (int)(edgeEffect.draw(canvas) ? 1 : 0);
                n12 = 0 | n10;
                canvas.restoreToCount(n11);
            }
            if ((n11 = (int)((object = this.mRightEdge).isFinished() ? 1 : 0)) == 0) {
                n11 = canvas.save();
                n10 = this.getWidth();
                n14 = this.getHeight();
                n13 = this.getPaddingTop();
                n14 -= n13;
                n13 = this.getPaddingBottom();
                n14 -= n13;
                canvas.rotate(90.0f);
                n13 = -this.getPaddingTop();
                f12 = n13;
                f11 = -(this.mLastOffset + 1.0f);
                f10 = n10;
                canvas.translate(f12, f11 *= f10);
                edgeEffect2 = this.mRightEdge;
                edgeEffect2.setSize(n14, n10);
                edgeEffect = this.mRightEdge;
                n10 = (int)(edgeEffect.draw(canvas) ? 1 : 0);
                n12 |= n10;
                canvas.restoreToCount(n11);
            }
        }
        if (n12 != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void drawableStateChanged() {
        boolean bl2;
        super.drawableStateChanged();
        Drawable drawable2 = this.mMarginDrawable;
        if (drawable2 != null && (bl2 = drawable2.isStateful())) {
            int[] nArray = this.getDrawableState();
            drawable2.setState(nArray);
        }
    }

    public void endFakeDrag() {
        int n10 = this.mFakeDragging;
        if (n10 != 0) {
            PagerAdapter pagerAdapter = this.mAdapter;
            if (pagerAdapter != null) {
                boolean bl2;
                pagerAdapter = this.mVelocityTracker;
                float f10 = this.mMaximumVelocity;
                pagerAdapter.computeCurrentVelocity(1000, f10);
                int bl22 = this.mActivePointerId;
                float f11 = pagerAdapter.getXVelocity(bl22);
                n10 = (int)f11;
                this.mPopulatePending = bl2 = true;
                int n11 = this.getClientWidth();
                int n12 = this.getScrollX();
                ViewPager$ItemInfo viewPager$ItemInfo = this.infoForCurrentScrollPosition();
                int n13 = viewPager$ItemInfo.position;
                float f12 = n12;
                f10 = n11;
                f12 /= f10;
                f10 = viewPager$ItemInfo.offset;
                f12 -= f10;
                f10 = viewPager$ItemInfo.widthFactor;
                f12 /= f10;
                f10 = this.mLastMotionX;
                float f13 = this.mInitialMotionX;
                n11 = (int)(f10 -= f13);
                n11 = this.determineTargetPage(n13, f12, n10, n11);
                this.setCurrentItemInternal(n11, bl2, bl2, n10);
            }
            this.endDrag();
            this.mFakeDragging = false;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        throw illegalStateException;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        block4: {
            block0: {
                int n10;
                block1: {
                    block2: {
                        int n11;
                        block3: {
                            n11 = keyEvent.getAction();
                            if (n11 != 0) break block0;
                            n11 = keyEvent.getKeyCode();
                            int n12 = 21;
                            n10 = 2;
                            if (n11 == n12) break block1;
                            n12 = 22;
                            if (n11 == n12) break block2;
                            n12 = 61;
                            if (n11 != n12) break block0;
                            n11 = (int)(keyEvent.hasNoModifiers() ? 1 : 0);
                            if (n11 == 0) break block3;
                            bl2 = this.arrowScroll(n10);
                            break block4;
                        }
                        n11 = 1;
                        bl2 = keyEvent.hasModifiers(n11);
                        if (!bl2) break block0;
                        bl2 = this.arrowScroll(n11);
                        break block4;
                    }
                    bl2 = keyEvent.hasModifiers(n10);
                    bl2 = bl2 ? this.pageRight() : this.arrowScroll(66);
                    break block4;
                }
                bl2 = keyEvent.hasModifiers(n10);
                bl2 = bl2 ? this.pageLeft() : this.arrowScroll(17);
                break block4;
            }
            bl2 = false;
            keyEvent = null;
        }
        return bl2;
    }

    public void fakeDragBy(float f10) {
        int n10 = this.mFakeDragging;
        if (n10 != 0) {
            PagerAdapter pagerAdapter;
            int n11;
            float f11;
            PagerAdapter pagerAdapter2 = this.mAdapter;
            if (pagerAdapter2 == null) {
                return;
            }
            this.mLastMotionX = f11 = this.mLastMotionX + f10;
            n10 = this.getScrollX();
            f11 = (float)n10 - f10;
            int n12 = this.getClientWidth();
            f10 = n12;
            float f12 = this.mFirstOffset * f10;
            float f13 = this.mLastOffset * f10;
            ViewPager$ItemInfo viewPager$ItemInfo = (ViewPager$ItemInfo)this.mItems.get(0);
            Object object = this.mItems;
            int n13 = ((ArrayList)object).size() + -1;
            object = (ViewPager$ItemInfo)((ArrayList)object).get(n13);
            n13 = viewPager$ItemInfo.position;
            if (n13 != 0) {
                f12 = viewPager$ItemInfo.offset * f10;
            }
            if ((n11 = ((ViewPager$ItemInfo)object).position) != (n13 = (pagerAdapter = this.mAdapter).getCount() + -1)) {
                f13 = ((ViewPager$ItemInfo)object).offset * f10;
            }
            if ((n12 = (int)(f11 == f12 ? 0 : (f11 < f12 ? -1 : 1))) < 0) {
                f11 = f12;
            } else {
                n12 = (int)(f11 == f13 ? 0 : (f11 > f13 ? 1 : -1));
                if (n12 > 0) {
                    f11 = f13;
                }
            }
            f10 = this.mLastMotionX;
            int n14 = (int)f11;
            f13 = n14;
            this.mLastMotionX = f10 += (f11 -= f13);
            n12 = this.getScrollY();
            this.scrollTo(n14, n12);
            this.pageScrolled(n14);
            long l10 = SystemClock.uptimeMillis();
            long l11 = this.mFakeDragBeginTime;
            float f14 = this.mLastMotionX;
            MotionEvent motionEvent = MotionEvent.obtain((long)l11, (long)l10, (int)2, (float)f14, (float)0.0f, (int)0);
            this.mVelocityTracker.addMovement(motionEvent);
            motionEvent.recycle();
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        throw illegalStateException;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewPager$LayoutParams viewPager$LayoutParams = new ViewPager$LayoutParams();
        return viewPager$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        ViewPager$LayoutParams viewPager$LayoutParams = new ViewPager$LayoutParams(context, attributeSet);
        return viewPager$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getChildDrawingOrder(int n10, int n11) {
        int n12 = this.mDrawingOrder;
        int n13 = 2;
        if (n12 == n13) {
            n11 = (n10 += -1) - n11;
        }
        return ((ViewPager$LayoutParams)((View)this.mDrawingOrderedChildren.get((int)n11)).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ViewPager$ItemInfo infoForAnyChild(View view) {
        ViewParent viewParent;
        while ((viewParent = view.getParent()) != this) {
            boolean bl2;
            if (viewParent != null && (bl2 = viewParent instanceof View)) {
                view = viewParent;
                view = (View)viewParent;
                continue;
            }
            return null;
        }
        return this.infoForChild(view);
    }

    public ViewPager$ItemInfo infoForChild(View view) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mItems)).size()); ++i10) {
            object = (ViewPager$ItemInfo)this.mItems.get(i10);
            PagerAdapter pagerAdapter = this.mAdapter;
            Object object2 = ((ViewPager$ItemInfo)object).object;
            boolean bl2 = pagerAdapter.isViewFromObject(view, object2);
            if (!bl2) continue;
            return object;
        }
        return null;
    }

    public ViewPager$ItemInfo infoForPosition(int n10) {
        Object object;
        int n11;
        for (int i10 = 0; i10 < (n11 = ((ArrayList)(object = this.mItems)).size()); ++i10) {
            object = (ViewPager$ItemInfo)this.mItems.get(i10);
            int n12 = ((ViewPager$ItemInfo)object).position;
            if (n12 != n10) continue;
            return object;
        }
        return null;
    }

    public void initViewPager() {
        int n10;
        int n11;
        int n12;
        Scroller scroller;
        ViewPager$4 viewPager$4 = null;
        this.setWillNotDraw(false);
        this.setDescendantFocusability(262144);
        int n13 = 1;
        this.setFocusable(n13 != 0);
        Object object = this.getContext();
        Interpolator interpolator2 = sInterpolator;
        this.mScroller = scroller = new Scroller(object, interpolator2);
        scroller = ViewConfiguration.get((Context)object);
        interpolator2 = object.getResources().getDisplayMetrics();
        float f10 = interpolator2.density;
        this.mTouchSlop = n12 = scroller.getScaledPagingTouchSlop();
        float f11 = 400.0f * f10;
        this.mMinimumVelocity = n12 = (int)f11;
        this.mMaximumVelocity = n11 = scroller.getScaledMaximumFlingVelocity();
        scroller = new EdgeEffect(object);
        this.mLeftEdge = scroller;
        scroller = new EdgeEffect(object);
        this.mRightEdge = scroller;
        this.mFlingDistance = n10 = (int)(25.0f * f10);
        this.mCloseEnough = n10 = (int)(2.0f * f10);
        float f12 = 16.0f;
        this.mDefaultGutterSize = n10 = (int)(f10 *= f12);
        object = new ViewPager$MyAccessibilityDelegate(this);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)object);
        n10 = ViewCompat.getImportantForAccessibility((View)this);
        if (n10 == 0) {
            ViewCompat.setImportantForAccessibility((View)this, n13);
        }
        viewPager$4 = new ViewPager$4(this);
        ViewCompat.setOnApplyWindowInsetsListener((View)this, viewPager$4);
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    public void onDetachedFromWindow() {
        boolean bl2;
        Runnable runnable = this.mEndScrollRunnable;
        this.removeCallbacks(runnable);
        runnable = this.mScroller;
        if (runnable != null && !(bl2 = runnable.isFinished())) {
            runnable = this.mScroller;
            runnable.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        Object object;
        ViewPager viewPager = this;
        super.onDraw(canvas);
        int n10 = this.mPageMargin;
        if (n10 > 0 && (object = this.mMarginDrawable) != null && (n10 = ((ArrayList)(object = this.mItems)).size()) > 0 && (object = this.mAdapter) != null) {
            n10 = this.getScrollX();
            int n11 = this.getWidth();
            int n12 = this.mPageMargin;
            float f10 = n12;
            float f11 = n11;
            f10 /= f11;
            Object object2 = this.mItems;
            int n13 = 0;
            object2 = (ViewPager$ItemInfo)((ArrayList)object2).get(0);
            float f12 = ((ViewPager$ItemInfo)object2).offset;
            ArrayList arrayList = this.mItems;
            int n14 = arrayList.size();
            Object object3 = this.mItems;
            int n15 = n14 + -1;
            object3 = (ViewPager$ItemInfo)((ArrayList)object3).get(n15);
            int n16 = ((ViewPager$ItemInfo)object3).position;
            for (int i10 = ((ViewPager$ItemInfo)object2).position; i10 < n16; ++i10) {
                float f13;
                PagerAdapter pagerAdapter;
                float f14;
                float f15;
                while (i10 > (n15 = ((ViewPager$ItemInfo)object2).position) && n13 < n14) {
                    object2 = viewPager.mItems;
                    object2 = (ViewPager$ItemInfo)((ArrayList)object2).get(++n13);
                }
                if (i10 == n15) {
                    f12 = ((ViewPager$ItemInfo)object2).offset;
                    f15 = ((ViewPager$ItemInfo)object2).widthFactor;
                    f14 = (f12 + f15) * f11;
                    f12 = f12 + f15 + f10;
                } else {
                    pagerAdapter = viewPager.mAdapter;
                    f15 = pagerAdapter.getPageWidth(i10);
                    f14 = (f12 + f15) * f11;
                    f12 += (f15 += f10);
                }
                f15 = (float)viewPager.mPageMargin + f14;
                float f16 = n10;
                n15 = (int)(f15 == f16 ? 0 : (f15 > f16 ? 1 : -1));
                if (n15 > 0) {
                    pagerAdapter = viewPager.mMarginDrawable;
                    int n17 = Math.round(f14);
                    int n18 = viewPager.mTopPageBounds;
                    float f17 = (float)viewPager.mPageMargin + f14;
                    int n19 = Math.round(f17);
                    f13 = f10;
                    n12 = viewPager.mBottomPageBounds;
                    pagerAdapter.setBounds(n17, n18, n19, n12);
                    Drawable drawable2 = viewPager.mMarginDrawable;
                    pagerAdapter = canvas;
                    drawable2.draw(canvas);
                } else {
                    pagerAdapter = canvas;
                    f13 = f10;
                }
                f10 = n10 + n11;
                n12 = (int)(f14 == f10 ? 0 : (f14 > f10 ? 1 : -1));
                if (n12 > 0) break;
                f10 = f13;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onInterceptTouchEvent(MotionEvent var1_1) {
        block16: {
            block18: {
                block17: {
                    var2_2 = this;
                    var3_3 = var1_1;
                    var4_4 = var1_1.getAction() & 255;
                    var5_5 = 3;
                    var6_6 = 4.2E-45f;
                    if (var4_4 == var5_5 || var4_4 == (var7_7 = 1)) break block16;
                    if (var4_4 != 0) {
                        var5_5 = (int)this.mIsBeingDragged;
                        if (var5_5 != 0) {
                            return (boolean)var7_7;
                        }
                        var5_5 = this.mIsUnableToDrag;
                        if (var5_5 != 0) {
                            return false;
                        }
                    }
                    var5_5 = 2;
                    var6_6 = 2.8E-45f;
                    if (var4_4 == 0) break block17;
                    if (var4_4 != var5_5) {
                        var5_5 = 6;
                        var6_6 = 8.4E-45f;
                        if (var4_4 == var5_5) {
                            this.onSecondaryPointerUp(var1_1);
                        }
                    } else {
                        var4_4 = var2_2.mActivePointerId;
                        var5_5 = -1;
                        var6_6 = 0.0f / 0.0f;
                        if (var4_4 != var5_5) {
                            var4_4 = var3_3.findPointerIndex(var4_4);
                            var8_8 = var3_3.getX(var4_4);
                            var6_6 = var2_2.mLastMotionX;
                            var6_6 = var8_8 - var6_6;
                            var9_9 = Math.abs(var6_6);
                            var10_10 = var3_3.getY(var4_4);
                            var11_11 = var2_2.mInitialMotionY;
                            var12_13 = Math.abs(var10_10 - var11_11);
                            var4_4 = 0;
                            var11_11 = 0.0f;
                            var13_14 /* !! */  = null;
                            cfr_temp_0 = var6_6 - 0.0f;
                            var14_15 /* !! */  = (float)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                            if (var14_15 /* !! */  != false && (var4_4 = (int)this.isGutterDrag(var11_11 = var2_2.mLastMotionX, var6_6)) == 0) {
                                var15_16 = (int)var6_6;
                                var16_17 = (int)var8_8;
                                var17_18 = (int)var10_10;
                                var13_14 /* !! */  = this;
                                var18_19 = this;
                                var4_4 = this.canScroll((View)this, false, var15_16, var16_17, var17_18);
                                if (var4_4 != 0) {
                                    var2_2.mLastMotionX = var8_8;
                                    var2_2.mLastMotionY = var10_10;
                                    var2_2.mIsUnableToDrag = var7_7;
                                    return false;
                                }
                            }
                            if ((var5_5 = (int)((cfr_temp_1 = var9_9 - (var6_6 = (float)(var4_4 = var2_2.mTouchSlop))) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) > 0 && (var5_5 = (int)((cfr_temp_2 = (var9_9 *= (var6_6 = 0.5f)) - var12_13) == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1))) > 0) {
                                var2_2.mIsBeingDragged = var7_7;
                                this.requestParentDisallowInterceptTouchEvent((boolean)var7_7);
                                this.setScrollState(var7_7);
                                var11_11 = var2_2.mInitialMotionX;
                                var5_5 = var2_2.mTouchSlop;
                                var6_6 = var5_5;
                                var11_11 = var14_15 /* !! */  > 0 ? (var11_11 += var6_6) : (var11_11 -= var6_6);
                                var2_2.mLastMotionX = var11_11;
                                var2_2.mLastMotionY = var10_10;
                                this.setScrollingCacheEnabled((boolean)var7_7);
                            } else {
                                var11_11 = var4_4;
                                cfr_temp_3 = var12_13 - var11_11;
                                if ((var4_4 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1))) > 0) {
                                    var2_2.mIsUnableToDrag = var7_7;
                                }
                            }
                            var4_4 = (int)var2_2.mIsBeingDragged;
                            if (var4_4 != 0 && (var4_4 = this.performDrag(var8_8)) != 0) {
                                ViewCompat.postInvalidateOnAnimation((View)this);
                            }
                        }
                    }
                    break block18;
                }
                var2_2.mInitialMotionX = var11_12 = var1_1.getX();
                var2_2.mLastMotionX = var11_12;
                var2_2.mInitialMotionY = var11_12 = var1_1.getY();
                var2_2.mLastMotionY = var11_12;
                var2_2.mActivePointerId = var4_4 = var3_3.getPointerId(0);
                var2_2.mIsUnableToDrag = false;
                var2_2.mIsScrollStarted = var7_7;
                var13_14 /* !! */  = var2_2.mScroller;
                var13_14 /* !! */ .computeScrollOffset();
                var4_4 = var2_2.mScrollState;
                if (var4_4 != var5_5) ** GOTO lbl-1000
                var13_14 /* !! */  = var2_2.mScroller;
                var4_4 = var13_14 /* !! */ .getFinalX();
                var18_20 = var2_2.mScroller;
                var5_5 = var18_20.getCurrX();
                if ((var4_4 = Math.abs(var4_4 - var5_5)) > (var5_5 = var2_2.mCloseEnough)) {
                    var13_14 /* !! */  = var2_2.mScroller;
                    var13_14 /* !! */ .abortAnimation();
                    var2_2.mPopulatePending = false;
                    this.populate();
                    var2_2.mIsBeingDragged = var7_7;
                    this.requestParentDisallowInterceptTouchEvent((boolean)var7_7);
                    this.setScrollState(var7_7);
                } else lbl-1000:
                // 2 sources

                {
                    this.completeScroll(false);
                    var2_2.mIsBeingDragged = false;
                }
            }
            var13_14 /* !! */  = var2_2.mVelocityTracker;
            if (var13_14 /* !! */  == null) {
                var2_2.mVelocityTracker = var13_14 /* !! */  = VelocityTracker.obtain();
            }
            var2_2.mVelocityTracker.addMovement(var3_3);
            return var2_2.mIsBeingDragged;
        }
        this.resetTouch();
        return false;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14;
        int n15;
        int n16;
        ViewPager viewPager = this;
        int n17 = this.getChildCount();
        int n18 = n12 - n10;
        int n19 = n13 - n11;
        int n20 = this.getPaddingLeft();
        int n21 = this.getPaddingTop();
        int n22 = this.getPaddingRight();
        int n23 = this.getPaddingBottom();
        int n24 = this.getScrollX();
        int n25 = 0;
        float f10 = 0.0f;
        ViewPager$ItemInfo viewPager$ItemInfo = null;
        int n26 = 0;
        while (true) {
            block5: {
                int n27;
                View view;
                block14: {
                    int n28;
                    block15: {
                        block11: {
                            block12: {
                                block13: {
                                    block9: {
                                        block10: {
                                            block6: {
                                                block7: {
                                                    block8: {
                                                        n16 = 8;
                                                        if (n25 >= n17) break;
                                                        view = viewPager.getChildAt(n25);
                                                        n15 = view.getVisibility();
                                                        if (n15 == n16) break block5;
                                                        ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)view.getLayoutParams();
                                                        n15 = (int)(viewPager$LayoutParams.isDecor ? 1 : 0);
                                                        if (n15 == 0) break block5;
                                                        n16 = viewPager$LayoutParams.gravity;
                                                        n15 = n16 & 7;
                                                        n16 &= 0x70;
                                                        n27 = 1;
                                                        if (n15 == n27) break block6;
                                                        n27 = 3;
                                                        if (n15 == n27) break block7;
                                                        n27 = 5;
                                                        if (n15 == n27) break block8;
                                                        n15 = n20;
                                                        break block9;
                                                    }
                                                    n15 = n18 - n22;
                                                    n27 = view.getMeasuredWidth();
                                                    n15 -= n27;
                                                    n27 = view.getMeasuredWidth();
                                                    n22 += n27;
                                                    break block10;
                                                }
                                                n15 = view.getMeasuredWidth() + n20;
                                                break block9;
                                            }
                                            n15 = view.getMeasuredWidth();
                                            n15 = Math.max((n18 - n15) / 2, n20);
                                        }
                                        n28 = n15;
                                        n15 = n20;
                                        n20 = n28;
                                    }
                                    n27 = 16;
                                    if (n16 == n27) break block11;
                                    n27 = 48;
                                    if (n16 == n27) break block12;
                                    n27 = 80;
                                    if (n16 == n27) break block13;
                                    n16 = n21;
                                    break block14;
                                }
                                n16 = n19 - n23;
                                n27 = view.getMeasuredHeight();
                                n16 -= n27;
                                n27 = view.getMeasuredHeight();
                                n23 += n27;
                                break block15;
                            }
                            n16 = view.getMeasuredHeight() + n21;
                            break block14;
                        }
                        n16 = view.getMeasuredHeight();
                        n16 = Math.max((n19 - n16) / 2, n21);
                    }
                    n28 = n16;
                    n16 = n21;
                    n21 = n28;
                }
                n27 = view.getMeasuredWidth() + (n20 += n24);
                int n29 = view.getMeasuredHeight();
                n14 = n21 + n29;
                view.layout(n20, n21, n27, n14);
                ++n26;
                n21 = n16;
                n20 = n15;
            }
            ++n25;
        }
        n18 = n18 - n20 - n22;
        for (n22 = 0; n22 < n17; ++n22) {
            int n30;
            View view = viewPager.getChildAt(n22);
            n14 = view.getVisibility();
            if (n14 == n16) continue;
            ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)view.getLayoutParams();
            n25 = (int)(viewPager$LayoutParams.isDecor ? 1 : 0);
            if (n25 != 0 || (viewPager$ItemInfo = viewPager.infoForChild(view)) == null) continue;
            float f11 = n18;
            f10 = viewPager$ItemInfo.offset * f11;
            n25 = (int)f10 + n20;
            n15 = (int)(viewPager$LayoutParams.needsMeasure ? 1 : 0);
            if (n15 != 0) {
                viewPager$LayoutParams.needsMeasure = false;
                float f12 = viewPager$LayoutParams.widthFactor;
                n14 = (int)(f11 * f12);
                n30 = 0x40000000;
                f11 = 2.0f;
                n14 = View.MeasureSpec.makeMeasureSpec((int)n14, (int)n30);
                n15 = n19 - n21 - n23;
                n30 = View.MeasureSpec.makeMeasureSpec((int)n15, (int)n30);
                view.measure(n14, n30);
            }
            n14 = view.getMeasuredWidth() + n25;
            n30 = view.getMeasuredHeight() + n21;
            view.layout(n25, n21, n14, n30);
        }
        viewPager.mTopPageBounds = n21;
        viewPager.mBottomPageBounds = n19 -= n23;
        viewPager.mDecorChildCount = n26;
        n17 = (int)(viewPager.mFirstLayout ? 1 : 0);
        if (n17 != 0) {
            n17 = viewPager.mCurItem;
            n18 = 0;
            viewPager.scrollToItem(n17, false, 0, false);
        } else {
            n18 = 0;
        }
        viewPager.mFirstLayout = false;
    }

    /*
     * Unable to fully structure code
     */
    public void onMeasure(int var1_1, int var2_2) {
        var3_3 = 0;
        var1_1 = ViewGroup.getDefaultSize((int)0, (int)var1_1);
        var2_2 = ViewGroup.getDefaultSize((int)0, (int)var2_2);
        this.setMeasuredDimension(var1_1, var2_2);
        var1_1 = this.getMeasuredWidth();
        var2_2 = var1_1 / 10;
        var4_4 = this.mDefaultGutterSize;
        this.mGutterSize = var2_2 = Math.min(var2_2, var4_4);
        var2_2 = this.getPaddingLeft();
        var1_1 -= var2_2;
        var2_2 = this.getPaddingRight();
        var1_1 -= var2_2;
        var2_2 = this.getMeasuredHeight();
        var4_4 = this.getPaddingTop();
        var2_2 -= var4_4;
        var4_4 = this.getPaddingBottom();
        var2_2 -= var4_4;
        var4_4 = this.getChildCount();
        var5_5 = 0;
        var6_6 = null;
        var7_7 = 0.0f;
        while (true) {
            block20: {
                var8_8 = 8;
                var9_9 = 1;
                var10_10 = 1.4E-45f;
                var11_11 = 0x40000000;
                var12_12 = 2.0f;
                if (var5_5 >= var4_4) break;
                var13_13 = this.getChildAt(var5_5);
                var14_14 = var13_13.getVisibility();
                if (var14_14 == var8_8 || (var15_15 = (ViewPager$LayoutParams)var13_13.getLayoutParams()) == null || (var14_14 = (int)var15_15.isDecor) == 0) break block20;
                var14_14 = var15_15.gravity;
                var16_16 = var14_14 & 7;
                var17_17 = 48;
                var18_18 = 6.7E-44f;
                if ((var14_14 &= 112) == var17_17) ** GOTO lbl-1000
                var17_17 = 80;
                var18_18 = 1.12E-43f;
                if (var14_14 != var17_17) {
                    var14_14 = 0;
                } else lbl-1000:
                // 2 sources

                {
                    var14_14 = var9_9;
                }
                var17_17 = 3;
                var18_18 = 4.2E-45f;
                if (var16_16 != var17_17) {
                    var17_17 = 5;
                    var18_18 = 7.0E-45f;
                    if (var16_16 != var17_17) {
                        var9_9 = 0;
                        var10_10 = 0.0f;
                    }
                }
                var16_16 = -1 << -1;
                var19_19 = -0.0f;
                if (var14_14 != 0) {
                    var17_17 = var16_16;
                    var18_18 = var19_19;
                    var16_16 = var11_11;
                    var19_19 = var12_12;
                } else if (var9_9 != 0) {
                    var17_17 = var11_11;
                    var18_18 = var12_12;
                } else {
                    var17_17 = var16_16;
                    var18_18 = var19_19;
                }
                var20_20 = var15_15.width;
                var21_21 = -1;
                var22_22 = -2;
                if (var20_20 != var22_22) {
                    if (var20_20 == var21_21) {
                        var20_20 = var1_1;
                    }
                    var16_16 = var11_11;
                    var19_19 = var12_12;
                } else {
                    var20_20 = var1_1;
                }
                var8_8 = var15_15.height;
                if (var8_8 != var22_22) {
                    if (var8_8 == var21_21) {
                        var8_8 = var2_2;
                    }
                } else {
                    var8_8 = var2_2;
                    var11_11 = var17_17;
                    var12_12 = var18_18;
                }
                var16_16 = View.MeasureSpec.makeMeasureSpec((int)var20_20, (int)var16_16);
                var8_8 = View.MeasureSpec.makeMeasureSpec((int)var8_8, (int)var11_11);
                var13_13.measure(var16_16, var8_8);
                if (var14_14 != 0) {
                    var8_8 = var13_13.getMeasuredHeight();
                    var2_2 -= var8_8;
                } else if (var9_9 != 0) {
                    var8_8 = var13_13.getMeasuredWidth();
                    var1_1 -= var8_8;
                }
            }
            ++var5_5;
        }
        this.mChildWidthMeasureSpec = var4_4 = View.MeasureSpec.makeMeasureSpec((int)var1_1, (int)var11_11);
        this.mChildHeightMeasureSpec = var2_2 = View.MeasureSpec.makeMeasureSpec((int)var2_2, (int)var11_11);
        this.mInLayout = var9_9;
        this.populate();
        this.mInLayout = false;
        var2_2 = this.getChildCount();
        while (var3_3 < var2_2) {
            var23_23 = this.getChildAt(var3_3);
            var5_5 = var23_23.getVisibility();
            if (var5_5 != var8_8 && ((var6_6 = (ViewPager$LayoutParams)var23_23.getLayoutParams()) == null || (var9_9 = var6_6.isDecor) == 0)) {
                var10_10 = var1_1;
                var7_7 = var6_6.widthFactor;
                var5_5 = View.MeasureSpec.makeMeasureSpec((int)((int)(var10_10 *= var7_7)), (int)var11_11);
                var9_9 = this.mChildHeightMeasureSpec;
                var23_23.measure(var5_5, var9_9);
            }
            ++var3_3;
        }
    }

    public void onPageScrolled(int n10, float f10, int n11) {
        int n12;
        int n13;
        int n14;
        int n15;
        block5: {
            n15 = this.mDecorChildCount;
            n14 = 0;
            n13 = 1;
            if (n15 <= 0) break block5;
            n15 = this.getScrollX();
            n12 = this.getPaddingLeft();
            int n16 = this.getPaddingRight();
            int n17 = this.getWidth();
            int n18 = this.getChildCount();
            for (int i10 = 0; i10 < n18; ++i10) {
                int n19;
                int n20;
                View view;
                block9: {
                    block10: {
                        block6: {
                            block7: {
                                block8: {
                                    view = this.getChildAt(i10);
                                    ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)view.getLayoutParams();
                                    n20 = viewPager$LayoutParams.isDecor;
                                    if (n20 == 0) continue;
                                    n19 = viewPager$LayoutParams.gravity & 7;
                                    if (n19 == n13) break block6;
                                    n20 = 3;
                                    if (n19 == n20) break block7;
                                    n20 = 5;
                                    if (n19 == n20) break block8;
                                    n19 = n12;
                                    break block9;
                                }
                                n19 = n17 - n16;
                                n20 = view.getMeasuredWidth();
                                n19 -= n20;
                                n20 = view.getMeasuredWidth();
                                n16 += n20;
                                break block10;
                            }
                            n19 = view.getWidth() + n12;
                            break block9;
                        }
                        n19 = view.getMeasuredWidth();
                        n19 = Math.max((n17 - n19) / 2, n12);
                    }
                    int n21 = n19;
                    n19 = n12;
                    n12 = n21;
                }
                n12 += n15;
                n20 = view.getLeft();
                if ((n12 -= n20) != 0) {
                    view.offsetLeftAndRight(n12);
                }
                n12 = n19;
            }
        }
        this.dispatchOnPageScrolled(n10, f10, n11);
        ViewPager$PageTransformer viewPager$PageTransformer = this.mPageTransformer;
        if (viewPager$PageTransformer != null) {
            n10 = this.getScrollX();
            int n22 = this.getChildCount();
            while (n14 < n22) {
                View view = this.getChildAt(n14);
                ViewPager$LayoutParams viewPager$LayoutParams = (ViewPager$LayoutParams)view.getLayoutParams();
                n15 = (int)(viewPager$LayoutParams.isDecor ? 1 : 0);
                if (n15 == 0) {
                    n15 = view.getLeft() - n10;
                    float f11 = n15;
                    n12 = this.getClientWidth();
                    float f12 = n12;
                    ViewPager$PageTransformer viewPager$PageTransformer2 = this.mPageTransformer;
                    viewPager$PageTransformer2.transformPage(view, f11 /= f12);
                }
                ++n14;
            }
        }
        this.mCalledSuper = n13;
    }

    /*
     * WARNING - void declaration
     */
    public boolean onRequestFocusInDescendants(int n10, Rect rect) {
        int n11;
        int bl2 = this.getChildCount();
        int bl3 = n10 & 2;
        int n12 = -1;
        boolean bl4 = true;
        if (bl3 != 0) {
            n11 = bl2;
            bl2 = 0;
            boolean bl5 = bl4;
        } else {
            bl2 += -1;
            int n13 = n12;
        }
        while (bl2 != n11) {
            void var4_7;
            boolean bl6;
            int n14;
            ViewPager$ItemInfo viewPager$ItemInfo;
            View view = this.getChildAt(bl2);
            int n15 = view.getVisibility();
            if (n15 == 0 && (viewPager$ItemInfo = this.infoForChild(view)) != null && (n15 = viewPager$ItemInfo.position) == (n14 = this.mCurItem) && (bl6 = view.requestFocus(n10, rect))) {
                return bl4;
            }
            bl2 += var4_7;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable object) {
        int n10 = object instanceof ViewPager$SavedState;
        if (n10 == 0) {
            super.onRestoreInstanceState(object);
            return;
        }
        object = (ViewPager$SavedState)object;
        Object object2 = object.getSuperState();
        super.onRestoreInstanceState((Parcelable)object2);
        object2 = this.mAdapter;
        if (object2 != null) {
            Parcelable parcelable = object.adapterState;
            ClassLoader classLoader = object.loader;
            ((PagerAdapter)object2).restoreState(parcelable, classLoader);
            int n11 = object.position;
            n10 = 0;
            object2 = null;
            boolean bl2 = true;
            this.setCurrentItemInternal(n11, false, bl2);
        } else {
            this.mRestoredCurItem = n10 = object.position;
            object2 = object.adapterState;
            this.mRestoredAdapterState = object2;
            object = object.loader;
            this.mRestoredClassLoader = object;
        }
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        Object object = super.onSaveInstanceState();
        ViewPager$SavedState viewPager$SavedState = new ViewPager$SavedState((Parcelable)object);
        viewPager$SavedState.position = n10 = this.mCurItem;
        object = this.mAdapter;
        if (object != null) {
            object = ((PagerAdapter)object).saveState();
            viewPager$SavedState.adapterState = object;
        }
        return viewPager$SavedState;
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        if (n10 != n12) {
            n11 = this.mPageMargin;
            this.recomputeScrollPosition(n10, n12, n11, n11);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block18: {
            block22: {
                block19: {
                    block20: {
                        block21: {
                            var2_2 = this.mFakeDragging;
                            var3_3 = true;
                            if (var2_2) {
                                return var3_3;
                            }
                            var2_2 = var1_1.getAction();
                            var4_4 = 0;
                            var5_5 = 0.0f;
                            if (!var2_2 && (var2_2 = var1_1.getEdgeFlags())) {
                                return false;
                            }
                            var6_6 = this.mAdapter;
                            if (var6_6 == null || !(var2_2 = var6_6.getCount())) break block18;
                            var6_6 = this.mVelocityTracker;
                            if (var6_6 == null) {
                                var6_6 = VelocityTracker.obtain();
                                this.mVelocityTracker = var6_6;
                            }
                            var6_6 = this.mVelocityTracker;
                            var6_6.addMovement(var1_1);
                            var2_2 = var1_1.getAction() & 255;
                            if (!var2_2) break block19;
                            if (var2_2 == var3_3) break block20;
                            var7_7 = 2 != 0;
                            var8_9 = 2.8E-45f;
                            if (var2_2 == var7_7) break block21;
                            var7_7 = 3 != 0;
                            var8_9 = 4.2E-45f;
                            if (var2_2 != var7_7) {
                                var7_7 = 5 != 0;
                                var8_9 = 7.0E-45f;
                                if (var2_2 != var7_7) {
                                    var7_7 = 6 != 0;
                                    var8_9 = 8.4E-45f;
                                    if (var2_2 == var7_7) {
                                        this.onSecondaryPointerUp(var1_1);
                                        var2_2 = this.mActivePointerId;
                                        var2_2 = var1_1.findPointerIndex((int)var2_2);
                                        this.mLastMotionX = var9_11 = var1_1.getX((int)var2_2);
                                    }
                                } else {
                                    var2_2 = var1_1.getActionIndex();
                                    this.mLastMotionX = var8_9 = var1_1.getX((int)var2_2);
                                    this.mActivePointerId = var10_14 = var1_1.getPointerId((int)var2_2);
                                }
                            } else {
                                var10_15 = this.mIsBeingDragged;
                                if (var10_15 != 0) {
                                    var10_15 = this.mCurItem;
                                    this.scrollToItem(var10_15, var3_3, 0, false);
                                    var4_4 = (int)this.resetTouch();
                                }
                            }
                            break block22;
                        }
                        var2_2 = this.mIsBeingDragged;
                        if (var2_2) ** GOTO lbl90
                        var2_2 = this.mActivePointerId;
                        var2_2 = var1_1.findPointerIndex((int)var2_2);
                        var7_7 = -1 != 0;
                        var8_9 = 0.0f / 0.0f;
                        if (var2_2 == var7_7) {
                            var4_4 = (int)this.resetTouch();
                        } else {
                            var8_9 = var1_1.getX((int)var2_2);
                            var11_19 = this.mLastMotionX;
                            var11_19 = Math.abs(var8_9 - var11_19);
                            var12_20 = var1_1.getY((int)var2_2);
                            var13_23 = this.mLastMotionY;
                            var13_23 = Math.abs(var12_20 - var13_23);
                            var14_25 = this.mTouchSlop;
                            cfr_temp_0 = var11_19 - var14_25;
                            var15_26 /* !! */  = (float)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                            if (var15_26 /* !! */  > 0 && (var16_28 = var11_19 == var13_23 ? 0 : (var11_19 > var13_23 ? 1 : -1)) > 0) {
                                this.mIsBeingDragged = var3_3;
                                this.requestParentDisallowInterceptTouchEvent(var3_3);
                                var11_19 = this.mInitialMotionX;
                                var17_29 = false;
                                var13_23 = 0.0f;
                                cfr_temp_1 = (var8_9 -= var11_19) - 0.0f;
                                var7_7 = cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1);
                                if (var7_7 > false) {
                                    var7_7 = this.mTouchSlop;
                                    var8_9 = (float)var7_7;
                                    var11_19 += var8_9;
                                } else {
                                    var7_7 = this.mTouchSlop;
                                    var8_9 = (float)var7_7;
                                    var11_19 -= var8_9;
                                }
                                this.mLastMotionX = var11_19;
                                this.mLastMotionY = var12_20;
                                this.setScrollState((int)var3_3);
                                this.setScrollingCacheEnabled(var3_3);
                                var6_6 = this.getParent();
                                if (var6_6 != null) {
                                    var6_6.requestDisallowInterceptTouchEvent(var3_3);
                                }
                            }
lbl90:
                            // 6 sources

                            if (var2_2 = (boolean)this.mIsBeingDragged) {
                                var2_2 = this.mActivePointerId;
                                var2_2 = var1_1.findPointerIndex((int)var2_2);
                                var9_12 = var1_1.getX((int)var2_2);
                                var10_16 = this.performDrag(var9_12);
                                var4_4 = 0 | var10_16;
                            }
                        }
                        break block22;
                    }
                    var2_2 = this.mIsBeingDragged;
                    if (var2_2) {
                        var6_6 = this.mVelocityTracker;
                        var8_10 = this.mMaximumVelocity;
                        var6_6.computeCurrentVelocity(1000, var8_10);
                        var4_4 = this.mActivePointerId;
                        var12_21 = var6_6.getXVelocity(var4_4);
                        var2_2 = (int)var12_21;
                        this.mPopulatePending = var3_3;
                        var4_4 = this.getClientWidth();
                        var7_8 = this.getScrollX();
                        var18_31 = this.infoForCurrentScrollPosition();
                        var17_30 = this.mPageMargin;
                        var13_24 = var17_30;
                        var5_5 = var4_4;
                        var13_24 /= var5_5;
                        var15_27 = var18_31.position;
                        var8_10 = (float)var7_8 / var5_5;
                        var5_5 = var18_31.offset;
                        var8_10 -= var5_5;
                        var5_5 = var18_31.widthFactor + var13_24;
                        var8_10 /= var5_5;
                        var4_4 = this.mActivePointerId;
                        var4_4 = var1_1.findPointerIndex(var4_4);
                        var9_13 = var1_1.getX(var4_4);
                        var5_5 = this.mInitialMotionX;
                        var10_17 = (int)(var9_13 -= var5_5);
                        var10_17 = this.determineTargetPage(var15_27, var8_10, (int)var2_2, var10_17);
                        this.setCurrentItemInternal(var10_17, var3_3, var3_3, (int)var2_2);
                        var4_4 = (int)this.resetTouch();
                    }
                    break block22;
                }
                var6_6 = this.mScroller;
                var6_6.abortAnimation();
                this.mPopulatePending = false;
                this.populate();
                this.mInitialMotionX = var12_22 = var1_1.getX();
                this.mLastMotionX = var12_22;
                this.mInitialMotionY = var12_22 = var1_1.getY();
                this.mLastMotionY = var12_22;
                this.mActivePointerId = var10_18 = var1_1.getPointerId(0);
            }
            if (var4_4 != 0) {
                ViewCompat.postInvalidateOnAnimation((View)this);
            }
            return var3_3;
        }
        return false;
    }

    public boolean pageLeft() {
        int n10 = this.mCurItem;
        if (n10 > 0) {
            int n11 = 1;
            this.setCurrentItem(n10 -= n11, n11 != 0);
            return n11 != 0;
        }
        return false;
    }

    public boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            int n10 = this.mCurItem;
            int n11 = pagerAdapter.getCount();
            int n12 = 1;
            if (n10 < (n11 -= n12)) {
                n11 = this.mCurItem + n12;
                this.setCurrentItem(n11, n12 != 0);
                return n12 != 0;
            }
        }
        return false;
    }

    public void populate() {
        int n10 = this.mCurItem;
        this.populate(n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void populate(int var1_1) {
        block33: {
            block34: {
                block39: {
                    block32: {
                        var2_2 = this;
                        var3_3 = var1_1;
                        var4_4 = this.mCurItem;
                        if (var4_4 != var1_1) {
                            var5_5 = this.infoForPosition(var4_4);
                            this.mCurItem = var1_1;
                        } else {
                            var4_4 = 0;
                            var5_5 = null;
                        }
                        var6_6 = var2_2.mAdapter;
                        if (var6_6 == null) {
                            this.sortChildDrawingOrder();
                            return;
                        }
                        var3_3 = (int)var2_2.mPopulatePending;
                        if (var3_3 != 0) {
                            this.sortChildDrawingOrder();
                            return;
                        }
                        var6_6 = this.getWindowToken();
                        if (var6_6 == null) {
                            return;
                        }
                        var6_6 = var2_2.mAdapter;
                        var6_6.startUpdate(var2_2);
                        var3_3 = var2_2.mOffscreenPageLimit;
                        var7_7 = var2_2.mCurItem - var3_3;
                        var8_8 = 0;
                        var9_9 = 0.0f;
                        var10_10 = null;
                        var7_7 = Math.max(0, var7_7);
                        var11_11 = var2_2.mAdapter;
                        var12_12 = var11_11.getCount();
                        var13_13 = var12_12 + -1;
                        var14_14 = var2_2.mCurItem + var3_3;
                        var3_3 = Math.min(var13_13, var14_14);
                        var13_13 = var2_2.mExpectedAdapterCount;
                        if (var12_12 != var13_13) break block33;
                        for (var13_13 = 0; var13_13 < (var14_14 = (var15_15 = var2_2.mItems).size()); ++var13_13) {
                            var15_15 = (ViewPager$ItemInfo)var2_2.mItems.get(var13_13);
                            var16_16 = var15_15.position;
                            var17_17 = var2_2.mCurItem;
                            if (var16_16 < var17_17) continue;
                            if (var16_16 != var17_17) break;
                            break block32;
                        }
                        var14_14 = 0;
                        var15_15 = null;
                    }
                    if (var15_15 == null && var12_12 > 0) {
                        var14_14 = var2_2.mCurItem;
                        var15_15 = var2_2.addNewItem(var14_14, var13_13);
                    }
                    var16_16 = 0;
                    if (var15_15 == null) break block34;
                    var17_17 = var13_13 + -1;
                    if (var17_17 >= 0) {
                        var18_18 = (ViewPager$ItemInfo)var2_2.mItems.get(var17_17);
                    } else {
                        var19_19 = 0;
                        var20_20 = 0.0f;
                        var18_18 = null;
                    }
                    var21_21 = this.getClientWidth();
                    var22_22 = 2.0f;
                    if (var21_21 <= 0) {
                        var23_23 = 0.0f;
                    } else {
                        var23_23 = var15_15.widthFactor;
                        var23_23 = var22_22 - var23_23;
                        var24_24 = this.getPaddingLeft();
                        var25_25 = var24_24;
                        var26_26 = var21_21;
                        var23_23 += (var25_25 /= var26_26);
                    }
                    var24_24 = 0;
                    var25_25 = 0.0f;
                    for (var27_27 = var2_2.mCurItem + -1; var27_27 >= 0; var27_27 += -1) {
                        block36: {
                            block37: {
                                block38: {
                                    block35: {
                                        var28_28 /* !! */  = (float)(var25_25 == var23_23 ? 0 : (var25_25 > var23_23 ? 1 : -1));
                                        if (var28_28 /* !! */  < 0 || var27_27 >= var7_7) break block35;
                                        if (var18_18 == null) break;
                                        var8_8 = var18_18.position;
                                        if (var27_27 != var8_8 || (var8_8 = (int)var18_18.scrolling) != 0) break block36;
                                        var2_2.mItems.remove(var17_17);
                                        var10_10 = var2_2.mAdapter;
                                        var18_18 = var18_18.object;
                                        var10_10.destroyItem(var2_2, var27_27, var18_18);
                                        var13_13 += -1;
                                        if ((var17_17 += -1) < 0) ** GOTO lbl-1000
                                        var10_10 = (ViewPager$ItemInfo)var2_2.mItems.get(var17_17);
                                        break block37;
                                    }
                                    if (var18_18 == null || var27_27 != (var8_8 = var18_18.position)) break block38;
                                    var9_9 = var18_18.widthFactor;
                                    var25_25 += var9_9;
                                    if ((var17_17 += -1) < 0) ** GOTO lbl-1000
                                    var10_10 = (ViewPager$ItemInfo)var2_2.mItems.get(var17_17);
                                    break block37;
                                }
                                var8_8 = var17_17 + 1;
                                var10_10 = var2_2.addNewItem(var27_27, var8_8);
                                var9_9 = var10_10.widthFactor;
                                var25_25 += var9_9;
                                ++var13_13;
                                if (var17_17 >= 0) {
                                    var10_10 = (ViewPager$ItemInfo)var2_2.mItems.get(var17_17);
                                } else lbl-1000:
                                // 3 sources

                                {
                                    var8_8 = 0;
                                    var9_9 = 0.0f;
                                    var10_10 = null;
                                }
                            }
                            var18_18 = var10_10;
                        }
                        var8_8 = 0;
                        var9_9 = 0.0f;
                        var10_10 = null;
                    }
                    var26_26 = var15_15.widthFactor;
                    var7_7 = var13_13 + 1;
                    var8_8 = (int)(var26_26 == var22_22 ? 0 : (var26_26 < var22_22 ? -1 : 1));
                    if (var8_8 >= 0) break block39;
                    var10_10 = var2_2.mItems;
                    var8_8 = var10_10.size();
                    if (var7_7 < var8_8) {
                        var10_10 = (ViewPager$ItemInfo)var2_2.mItems.get(var7_7);
                    } else {
                        var8_8 = 0;
                        var9_9 = 0.0f;
                        var10_10 = null;
                    }
                    if (var21_21 <= 0) {
                        var17_17 = 0;
                        var29_29 = 0.0f;
                    } else {
                        var17_17 = this.getPaddingRight();
                        var29_29 = var17_17;
                        var20_20 = var21_21;
                        var29_29 = var29_29 / var20_20 + var22_22;
                    }
                    var19_19 = var2_2.mCurItem;
                    block6: while (++var19_19 < var12_12) {
                        block40: {
                            var21_21 = (int)(var26_26 == var29_29 ? 0 : (var26_26 > var29_29 ? 1 : -1));
                            if (var21_21 >= 0 && var19_19 > var3_3) {
                                if (var10_10 == null) break;
                                var21_21 = var10_10.position;
                                if (var19_19 != var21_21 || (var21_21 = (int)var10_10.scrolling) != 0) continue;
                                var2_2.mItems.remove(var7_7);
                                var30_30 = var2_2.mAdapter;
                                var10_10 = var10_10.object;
                                var30_30.destroyItem(var2_2, var19_19, var10_10);
                                var10_10 = var2_2.mItems;
                                var8_8 = var10_10.size();
                                if (var7_7 < var8_8) {
                                    var10_10 = (ViewPager$ItemInfo)var2_2.mItems.get(var7_7);
                                    continue;
                                }
lbl149:
                                // 4 sources

                                while (true) {
                                    var8_8 = 0;
                                    var9_9 = 0.0f;
                                    var10_10 = null;
                                    continue block6;
                                    break;
                                }
                            }
                            if (var10_10 == null || var19_19 != (var21_21 = var10_10.position)) break block40;
                            var9_9 = var10_10.widthFactor;
                            var26_26 += var9_9;
                            var10_10 = var2_2.mItems;
                            var8_8 = var10_10.size();
                            if (++var7_7 >= var8_8) ** GOTO lbl149
                            var10_10 = (ViewPager$ItemInfo)var2_2.mItems.get(var7_7);
                            continue;
                        }
                        var10_10 = var2_2.addNewItem(var19_19, var7_7);
                        var9_9 = var10_10.widthFactor;
                        var26_26 += var9_9;
                        if (++var7_7 >= (var8_8 = (var10_10 = var2_2.mItems).size())) ** continue;
                        var10_10 = (ViewPager$ItemInfo)var2_2.mItems.get(var7_7);
                    }
                }
                var2_2.calculatePageOffsets((ViewPager$ItemInfo)var15_15, var13_13, (ViewPager$ItemInfo)var5_5);
                var6_6 = var2_2.mAdapter;
                var4_4 = var2_2.mCurItem;
                var31_31 /* !! */  = var15_15.object;
                var6_6.setPrimaryItem(var2_2, var4_4, (Object)var31_31 /* !! */ );
            }
            var6_6 = var2_2.mAdapter;
            var6_6.finishUpdate(var2_2);
            var3_3 = this.getChildCount();
            var5_5 = null;
            for (var4_4 = 0; var4_4 < var3_3; ++var4_4) {
                var31_31 /* !! */  = var2_2.getChildAt(var4_4);
                var32_33 = (ViewPager$LayoutParams)var31_31 /* !! */ .getLayoutParams();
                var32_33.childIndex = var4_4;
                var8_8 = var32_33.isDecor;
                if (var8_8 != 0 || (var8_8 = (cfr_temp_0 = (var9_9 = var32_33.widthFactor) - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1)) != 0 || (var31_31 /* !! */  = var2_2.infoForChild(var31_31 /* !! */ )) == null) continue;
                var32_33.widthFactor = var9_9 = var31_31 /* !! */ .widthFactor;
                var32_33.position = var27_27 = var31_31 /* !! */ .position;
            }
            this.sortChildDrawingOrder();
            var3_3 = (int)this.hasFocus();
            if (var3_3 != 0) {
                var6_6 = this.findFocus();
                if (var6_6 != null) {
                    var31_31 /* !! */  = var2_2.infoForAnyChild((View)var6_6);
                } else {
                    var27_27 = 0;
                    var26_26 = 0.0f;
                    var31_31 /* !! */  = null;
                }
                if (var31_31 /* !! */  == null || (var3_3 = var31_31 /* !! */ .position) != (var4_4 = var2_2.mCurItem)) {
                    var9_9 = 0.0f;
                    var10_10 = null;
                    for (var8_8 = 0; var8_8 < (var3_3 = this.getChildCount()) && ((var5_5 = var2_2.infoForChild((View)(var6_6 = var2_2.getChildAt(var8_8)))) == null || (var4_4 = var5_5.position) != (var27_27 = var2_2.mCurItem) || (var3_3 = (int)var6_6.requestFocus(var4_4 = 2)) == 0); ++var8_8) {
                    }
                }
            }
            return;
        }
        var6_6 = this.getResources();
        var4_4 = this.getId();
        try {
            var6_6 = var6_6.getResourceName(var4_4);
        }
        catch (Resources.NotFoundException v0) {
            var3_3 = this.getId();
            var6_6 = Integer.toHexString(var3_3);
        }
        var31_32 = new StringBuilder();
        var31_32.append("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
        var7_7 = var2_2.mExpectedAdapterCount;
        var31_32.append(var7_7);
        var31_32.append(", found: ");
        var31_32.append(var12_12);
        var31_32.append(" Pager id: ");
        var31_32.append((String)var6_6);
        var31_32.append(" Pager class: ");
        var6_6 = this.getClass();
        var31_32.append(var6_6);
        var31_32.append(" Problematic adapter: ");
        var6_6 = var2_2.mAdapter.getClass();
        var31_32.append(var6_6);
        var6_6 = var31_32.toString();
        var5_5 = new IllegalStateException((String)var6_6);
        throw var5_5;
    }

    public void removeOnAdapterChangeListener(ViewPager$OnAdapterChangeListener viewPager$OnAdapterChangeListener) {
        List list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(viewPager$OnAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        List list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(viewPager$OnPageChangeListener);
        }
    }

    public void removeView(View view) {
        boolean bl2 = this.mInLayout;
        if (bl2) {
            this.removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        int n10;
        Object object;
        Object object2;
        int n11;
        Object object3 = this.mAdapter;
        int n12 = 0;
        List list = null;
        int n13 = 0;
        if (object3 != null) {
            ((PagerAdapter)object3).setViewPagerObserver(null);
            this.mAdapter.startUpdate(this);
            object3 = null;
            for (int i10 = 0; i10 < (n11 = (object2 = this.mItems).size()); ++i10) {
                object2 = (ViewPager$ItemInfo)this.mItems.get(i10);
                object = this.mAdapter;
                n10 = ((ViewPager$ItemInfo)object2).position;
                object2 = ((ViewPager$ItemInfo)object2).object;
                ((PagerAdapter)object).destroyItem(this, n10, object2);
            }
            this.mAdapter.finishUpdate(this);
            object3 = this.mItems;
            ((ArrayList)object3).clear();
            this.removeNonDecorViews();
            this.mCurItem = 0;
            this.scrollTo(0, 0);
        }
        object3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            boolean bl2;
            object2 = this.mObserver;
            if (object2 == null) {
                object2 = new ViewPager$PagerObserver(this);
                this.mObserver = object2;
            }
            object2 = this.mAdapter;
            object = this.mObserver;
            ((PagerAdapter)object2).setViewPagerObserver((DataSetObserver)object);
            this.mPopulatePending = false;
            n11 = (int)(this.mFirstLayout ? 1 : 0);
            this.mFirstLayout = bl2 = true;
            PagerAdapter pagerAdapter2 = this.mAdapter;
            this.mExpectedAdapterCount = n10 = pagerAdapter2.getCount();
            n10 = this.mRestoredCurItem;
            if (n10 >= 0) {
                object2 = this.mAdapter;
                pagerAdapter2 = this.mRestoredAdapterState;
                ClassLoader classLoader = this.mRestoredClassLoader;
                ((PagerAdapter)object2).restoreState((Parcelable)pagerAdapter2, classLoader);
                n11 = this.mRestoredCurItem;
                this.setCurrentItemInternal(n11, false, bl2);
                this.mRestoredCurItem = n11 = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (n11 == 0) {
                this.populate();
            } else {
                this.requestLayout();
            }
        }
        if ((list = this.mAdapterChangeListeners) != null && (n12 = list.isEmpty()) == 0) {
            list = this.mAdapterChangeListeners;
            n12 = list.size();
            while (n13 < n12) {
                object2 = (ViewPager$OnAdapterChangeListener)this.mAdapterChangeListeners.get(n13);
                object2.onAdapterChanged(this, (PagerAdapter)object3, pagerAdapter);
                ++n13;
            }
        }
    }

    public void setCurrentItem(int n10) {
        this.mPopulatePending = false;
        boolean bl2 = this.mFirstLayout ^ true;
        this.setCurrentItemInternal(n10, bl2, false);
    }

    public void setCurrentItem(int n10, boolean bl2) {
        this.mPopulatePending = false;
        this.setCurrentItemInternal(n10, bl2, false);
    }

    public void setCurrentItemInternal(int n10, boolean bl2, boolean bl3) {
        this.setCurrentItemInternal(n10, bl2, bl3, 0);
    }

    public void setCurrentItemInternal(int n10, boolean bl2, boolean n11, int n12) {
        int n13;
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean bl3 = false;
        if (pagerAdapter != null && (n13 = pagerAdapter.getCount()) > 0) {
            boolean bl4;
            PagerAdapter pagerAdapter2;
            ArrayList arrayList;
            if (n11 == 0 && (n11 = this.mCurItem) == n10 && (n11 = (arrayList = this.mItems).size()) != 0) {
                this.setScrollingCacheEnabled(false);
                return;
            }
            n11 = 1;
            if (n10 < 0) {
                n10 = 0;
                pagerAdapter2 = null;
            } else {
                pagerAdapter = this.mAdapter;
                n13 = pagerAdapter.getCount();
                if (n10 >= n13) {
                    pagerAdapter2 = this.mAdapter;
                    n10 = pagerAdapter2.getCount() - n11;
                }
            }
            n13 = this.mOffscreenPageLimit;
            int n14 = this.mCurItem;
            int n15 = n14 + n13;
            if (n10 > n15 || n10 < (n14 -= n13)) {
                Object object;
                pagerAdapter = null;
                for (n13 = 0; n13 < (n14 = ((ArrayList)(object = this.mItems)).size()); ++n13) {
                    object = (ViewPager$ItemInfo)this.mItems.get(n13);
                    ((ViewPager$ItemInfo)object).scrolling = n11;
                }
            }
            if ((n13 = this.mCurItem) != n10) {
                bl4 = n11;
            }
            if ((n11 = (int)(this.mFirstLayout ? 1 : 0)) != 0) {
                this.mCurItem = n10;
                if (bl4) {
                    this.dispatchOnPageSelected(n10);
                }
                this.requestLayout();
            } else {
                this.populate(n10);
                this.scrollToItem(n10, bl2, n12, bl4);
            }
            return;
        }
        this.setScrollingCacheEnabled(false);
    }

    public ViewPager$OnPageChangeListener setInternalPageChangeListener(ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        ViewPager$OnPageChangeListener viewPager$OnPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = viewPager$OnPageChangeListener;
        return viewPager$OnPageChangeListener2;
    }

    public void setOffscreenPageLimit(int n10) {
        int n11 = 1;
        if (n10 < n11) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "Requested offscreen page limit ";
            charSequence.append(string2);
            charSequence.append(n10);
            charSequence.append(" too small; defaulting to ");
            charSequence.append(n11);
            String string3 = charSequence.toString();
            charSequence = TAG;
            Log.w((String)charSequence, (String)string3);
            n10 = n11;
        }
        if (n10 != (n11 = this.mOffscreenPageLimit)) {
            this.mOffscreenPageLimit = n10;
            this.populate();
        }
    }

    public void setOnPageChangeListener(ViewPager$OnPageChangeListener viewPager$OnPageChangeListener) {
        this.mOnPageChangeListener = viewPager$OnPageChangeListener;
    }

    public void setPageMargin(int n10) {
        int n11 = this.mPageMargin;
        this.mPageMargin = n10;
        int n12 = this.getWidth();
        this.recomputeScrollPosition(n12, n12, n10, n11);
        this.requestLayout();
    }

    public void setPageMarginDrawable(int n10) {
        Drawable drawable2 = ContextCompat.getDrawable(this.getContext(), n10);
        this.setPageMarginDrawable(drawable2);
    }

    public void setPageMarginDrawable(Drawable drawable2) {
        boolean bl2;
        this.mMarginDrawable = drawable2;
        if (drawable2 != null) {
            this.refreshDrawableState();
        }
        if (drawable2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    public void setPageTransformer(boolean bl2, ViewPager$PageTransformer viewPager$PageTransformer) {
        this.setPageTransformer(bl2, viewPager$PageTransformer, 2);
    }

    public void setPageTransformer(boolean bl2, ViewPager$PageTransformer viewPager$PageTransformer, int n10) {
        int n11;
        int n12 = 1;
        int n13 = viewPager$PageTransformer != null ? n12 : 0;
        ViewPager$PageTransformer viewPager$PageTransformer2 = this.mPageTransformer;
        if (viewPager$PageTransformer2 != null) {
            n11 = n12;
        } else {
            n11 = 0;
            viewPager$PageTransformer2 = null;
        }
        if (n13 != n11) {
            n11 = n12;
        } else {
            n11 = 0;
            viewPager$PageTransformer2 = null;
        }
        this.mPageTransformer = viewPager$PageTransformer;
        this.setChildrenDrawingOrderEnabled(n13 != 0);
        if (n13 != 0) {
            if (bl2) {
                n12 = 2;
            }
            this.mDrawingOrder = n12;
            this.mPageTransformerLayerType = n10;
        } else {
            this.mDrawingOrder = 0;
        }
        if (n11 != 0) {
            this.populate();
        }
    }

    public void setScrollState(int n10) {
        int n11 = this.mScrollState;
        if (n11 == n10) {
            return;
        }
        this.mScrollState = n10;
        ViewPager$PageTransformer viewPager$PageTransformer = this.mPageTransformer;
        if (viewPager$PageTransformer != null) {
            if (n10 != 0) {
                n11 = 1;
            } else {
                n11 = 0;
                viewPager$PageTransformer = null;
            }
            this.enableLayers(n11 != 0);
        }
        this.dispatchOnScrollStateChanged(n10);
    }

    public void smoothScrollTo(int n10, int n11) {
        this.smoothScrollTo(n10, n11, 0);
    }

    public void smoothScrollTo(int n10, int n11, int n12) {
        float f10;
        int n13 = this.getChildCount();
        if (n13 == 0) {
            this.setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        int n14 = 1;
        float f11 = Float.MIN_VALUE;
        if (scroller != null && (n13 = (int)(scroller.isFinished() ? 1 : 0)) == 0) {
            n13 = n14;
            f10 = f11;
        } else {
            n13 = 0;
            scroller = null;
            f10 = 0.0f;
        }
        if (n13 != 0) {
            n13 = (int)(this.mIsScrollStarted ? 1 : 0);
            if (n13 != 0) {
                scroller = this.mScroller;
                n13 = scroller.getCurrX();
            } else {
                scroller = this.mScroller;
                n13 = scroller.getStartX();
            }
            Scroller scroller2 = this.mScroller;
            scroller2.abortAnimation();
            this.setScrollingCacheEnabled(false);
        } else {
            n13 = this.getScrollX();
        }
        int n15 = n13;
        int n16 = this.getScrollY();
        int n17 = n10 - n13;
        int n18 = n11 - n16;
        if (n17 == 0 && n18 == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
            return;
        }
        this.setScrollingCacheEnabled(n14 != 0);
        this.setScrollState(2);
        n10 = this.getClientWidth();
        n11 = n10 / 2;
        n13 = Math.abs(n17);
        f10 = n13;
        n14 = 1065353216;
        f11 = 1.0f;
        f10 *= f11;
        float f12 = n10;
        f10 /= f12;
        f10 = Math.min(f11, f10);
        float f13 = n11;
        f10 = this.distanceInfluenceForSnapDuration(f10) * f13;
        f13 += f10;
        n12 = Math.abs(n12);
        if (n12 > 0) {
            f12 = 1000.0f;
            float f14 = n12;
            f13 = Math.abs(f13 / f14) * f12;
            n10 = Math.round(f13) * 4;
        } else {
            PagerAdapter pagerAdapter = this.mAdapter;
            n12 = this.mCurItem;
            f13 = pagerAdapter.getPageWidth(n12);
            f12 *= f13;
            n11 = Math.abs(n17);
            f13 = n11;
            n12 = this.mPageMargin;
            float f15 = n12;
            f13 = f13 / (f12 += f15) + f11;
            f12 = 100.0f;
            n10 = (int)(f13 *= f12);
        }
        int n19 = Math.min(n10, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(n15, n16, n17, n18, n19);
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public boolean verifyDrawable(Drawable drawable2) {
        boolean bl2;
        Drawable drawable3;
        boolean bl3 = super.verifyDrawable(drawable2);
        if (!bl3 && drawable2 != (drawable3 = this.mMarginDrawable)) {
            bl2 = false;
            drawable2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

