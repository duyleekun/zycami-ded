/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.Gravity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityNodeInfo
 */
package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.CompositeOnPageChangeCallback;
import androidx.viewpager2.widget.FakeDrag;
import androidx.viewpager2.widget.PageTransformerAdapter;
import androidx.viewpager2.widget.ScrollEventAdapter;
import androidx.viewpager2.widget.ViewPager2$1;
import androidx.viewpager2.widget.ViewPager2$2;
import androidx.viewpager2.widget.ViewPager2$3;
import androidx.viewpager2.widget.ViewPager2$4;
import androidx.viewpager2.widget.ViewPager2$AccessibilityProvider;
import androidx.viewpager2.widget.ViewPager2$BasicAccessibilityProvider;
import androidx.viewpager2.widget.ViewPager2$LinearLayoutManagerImpl;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider;
import androidx.viewpager2.widget.ViewPager2$PageTransformer;
import androidx.viewpager2.widget.ViewPager2$PagerSnapHelperImpl;
import androidx.viewpager2.widget.ViewPager2$RecyclerViewImpl;
import androidx.viewpager2.widget.ViewPager2$SavedState;
import androidx.viewpager2.widget.ViewPager2$SmoothScrollToPosition;

public final class ViewPager2
extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = 255;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static boolean sFeatureEnhancedA11yEnabled = true;
    public ViewPager2$AccessibilityProvider mAccessibilityProvider;
    public int mCurrentItem;
    private RecyclerView$AdapterDataObserver mCurrentItemDataSetChangeObserver;
    public boolean mCurrentItemDirty;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private FakeDrag mFakeDragger;
    private LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private PageTransformerAdapter mPageTransformerAdapter;
    private PagerSnapHelper mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    public RecyclerView mRecyclerView;
    private RecyclerView$ItemAnimator mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    public ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    public ViewPager2(Context context) {
        super(context);
        int n10;
        Object object;
        this.mTmpContainerRect = object = new Rect();
        this.mTmpChildRect = object = new Rect();
        super(3);
        this.mExternalPageChangeCallbacks = object;
        this.mCurrentItemDirty = false;
        ViewPager2$1 viewPager2$1 = new ViewPager2$1(this);
        this.mCurrentItemDataSetChangeObserver = viewPager2$1;
        this.mPendingCurrentItem = n10 = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = n10;
        this.initialize(context, null);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        Object object;
        this.mTmpContainerRect = object = new Rect();
        this.mTmpChildRect = object = new Rect();
        super(3);
        this.mExternalPageChangeCallbacks = object;
        this.mCurrentItemDirty = false;
        ViewPager2$1 viewPager2$1 = new ViewPager2$1(this);
        this.mCurrentItemDataSetChangeObserver = viewPager2$1;
        this.mPendingCurrentItem = n10 = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = n10;
        this.initialize(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        Object object;
        this.mTmpContainerRect = object = new Rect();
        this.mTmpChildRect = object = new Rect();
        super(3);
        this.mExternalPageChangeCallbacks = object;
        this.mCurrentItemDirty = false;
        ViewPager2$1 viewPager2$1 = new ViewPager2$1(this);
        this.mCurrentItemDataSetChangeObserver = viewPager2$1;
        this.mPendingCurrentItem = n11 = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = n11;
        this.initialize(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        Object object;
        this.mTmpContainerRect = object = new Rect();
        this.mTmpChildRect = object = new Rect();
        super(3);
        this.mExternalPageChangeCallbacks = object;
        this.mCurrentItemDirty = false;
        ViewPager2$1 viewPager2$1 = new ViewPager2$1(this);
        this.mCurrentItemDataSetChangeObserver = viewPager2$1;
        this.mPendingCurrentItem = n11 = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = n11;
        this.initialize(context, attributeSet);
    }

    private RecyclerView$OnChildAttachStateChangeListener enforceChildFillListener() {
        ViewPager2$4 viewPager2$4 = new ViewPager2$4(this);
        return viewPager2$4;
    }

    private void initialize(Context object, AttributeSet object2) {
        int n10 = sFeatureEnhancedA11yEnabled;
        Object object3 = n10 != 0 ? new ViewPager2$PageAwareAccessibilityProvider(this) : new ViewPager2$BasicAccessibilityProvider(this);
        this.mAccessibilityProvider = object3;
        this.mRecyclerView = object3 = new ViewPager2$RecyclerViewImpl(this, (Context)object);
        int n11 = ViewCompat.generateViewId();
        object3.setId(n11);
        this.mRecyclerView.setDescendantFocusability(131072);
        this.mLayoutManager = object3 = new ViewPager2$LinearLayoutManagerImpl(this, (Context)object);
        this.mRecyclerView.setLayoutManager((RecyclerView$LayoutManager)object3);
        this.mRecyclerView.setScrollingTouchSlop(1);
        this.setOrientation((Context)object, (AttributeSet)object2);
        object = this.mRecyclerView;
        n10 = -1;
        object2 = new ViewGroup.LayoutParams(n10, n10);
        object.setLayoutParams((ViewGroup.LayoutParams)object2);
        object = this.mRecyclerView;
        object2 = this.enforceChildFillListener();
        ((RecyclerView)object).addOnChildAttachStateChangeListener((RecyclerView$OnChildAttachStateChangeListener)object2);
        this.mScrollEventAdapter = object = new ScrollEventAdapter(this);
        object3 = this.mRecyclerView;
        object2 = new FakeDrag(this, (ScrollEventAdapter)object, (RecyclerView)object3);
        this.mFakeDragger = object2;
        this.mPagerSnapHelper = object = new ViewPager2$PagerSnapHelperImpl(this);
        object2 = this.mRecyclerView;
        ((SnapHelper)object).attachToRecyclerView((RecyclerView)object2);
        object = this.mRecyclerView;
        object2 = this.mScrollEventAdapter;
        ((RecyclerView)object).addOnScrollListener((RecyclerView$OnScrollListener)object2);
        this.mPageChangeEventDispatcher = object = new CompositeOnPageChangeCallback(3);
        this.mScrollEventAdapter.setOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object);
        object = new ViewPager2$2(this);
        object2 = new ViewPager2$3(this);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object2);
        object = this.mAccessibilityProvider;
        object2 = this.mPageChangeEventDispatcher;
        object3 = this.mRecyclerView;
        ((ViewPager2$AccessibilityProvider)object).onInitialize((CompositeOnPageChangeCallback)object2, (RecyclerView)object3);
        object = this.mPageChangeEventDispatcher;
        object2 = this.mExternalPageChangeCallbacks;
        ((CompositeOnPageChangeCallback)object).addOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object2);
        object2 = this.mLayoutManager;
        this.mPageTransformerAdapter = object = new PageTransformerAdapter((LinearLayoutManager)object2);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback((ViewPager2$OnPageChangeCallback)object);
        object = this.mRecyclerView;
        object3 = object.getLayoutParams();
        this.attachViewToParent((View)object, 0, (ViewGroup.LayoutParams)object3);
    }

    private void registerCurrentItemDataSetTracker(RecyclerView$Adapter recyclerView$Adapter) {
        if (recyclerView$Adapter != null) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.mCurrentItemDataSetChangeObserver;
            recyclerView$Adapter.registerAdapterDataObserver(recyclerView$AdapterDataObserver);
        }
    }

    private void restorePendingState() {
        int n10;
        int n11 = this.mPendingCurrentItem;
        int n12 = -1;
        if (n11 == n12) {
            return;
        }
        RecyclerView$Adapter recyclerView$Adapter = this.getAdapter();
        if (recyclerView$Adapter == null) {
            return;
        }
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            n10 = recyclerView$Adapter instanceof StatefulAdapter;
            if (n10 != 0) {
                Object object = recyclerView$Adapter;
                object = (StatefulAdapter)((Object)recyclerView$Adapter);
                object.restoreState(parcelable);
            }
            parcelable = null;
            this.mPendingAdapterState = null;
        }
        n10 = this.mPendingCurrentItem;
        n11 = recyclerView$Adapter.getItemCount() + -1;
        n11 = Math.min(n10, n11);
        this.mCurrentItem = n11 = Math.max(0, n11);
        this.mPendingCurrentItem = n12;
        this.mRecyclerView.scrollToPosition(n11);
        this.mAccessibilityProvider.onRestorePendingState();
    }

    private void setOrientation(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.ViewPager2;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            this.saveAttributeDataForStyleable(context, nArray, attributeSet, typedArray, 0, 0);
        }
        try {
            int n12 = R$styleable.ViewPager2_android_orientation;
            attributeSet = null;
            n12 = typedArray.getInt(n12, 0);
            this.setOrientation(n12);
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView$Adapter recyclerView$Adapter) {
        if (recyclerView$Adapter != null) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.mCurrentItemDataSetChangeObserver;
            recyclerView$Adapter.unregisterAdapterDataObserver(recyclerView$AdapterDataObserver);
        }
    }

    public void addItemDecoration(RecyclerView$ItemDecoration recyclerView$ItemDecoration) {
        this.mRecyclerView.addItemDecoration(recyclerView$ItemDecoration);
    }

    public void addItemDecoration(RecyclerView$ItemDecoration recyclerView$ItemDecoration, int n10) {
        this.mRecyclerView.addItemDecoration(recyclerView$ItemDecoration, n10);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    public boolean canScrollHorizontally(int n10) {
        return this.mRecyclerView.canScrollHorizontally(n10);
    }

    public boolean canScrollVertically(int n10) {
        return this.mRecyclerView.canScrollVertically(n10);
    }

    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        int n10 = this.getId();
        Object object = (Parcelable)sparseArray.get(n10);
        int n11 = object instanceof ViewPager2$SavedState;
        if (n11 != 0) {
            object = (ViewPager2$SavedState)((Object)object);
            n10 = object.mRecyclerViewId;
            RecyclerView recyclerView = this.mRecyclerView;
            n11 = recyclerView.getId();
            Object object2 = sparseArray.get(n10);
            sparseArray.put(n11, object2);
            sparseArray.remove(n10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        this.restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean fakeDragBy(float f10) {
        return this.mFakeDragger.fakeDragBy(f10);
    }

    public CharSequence getAccessibilityClassName() {
        ViewPager2$AccessibilityProvider viewPager2$AccessibilityProvider = this.mAccessibilityProvider;
        boolean bl2 = viewPager2$AccessibilityProvider.handlesGetAccessibilityClassName();
        if (bl2) {
            return this.mAccessibilityProvider.onGetAccessibilityClassName();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView$Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public RecyclerView$ItemDecoration getItemDecorationAt(int n10) {
        return this.mRecyclerView.getItemDecorationAt(n10);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    public int getPageSize() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        int n11 = this.getOrientation();
        if (n11 == 0) {
            n11 = recyclerView.getWidth();
            int n12 = recyclerView.getPaddingLeft();
            n11 -= n12;
            n10 = recyclerView.getPaddingRight();
        } else {
            n11 = recyclerView.getHeight();
            int n13 = recyclerView.getPaddingTop();
            n11 -= n13;
            n10 = recyclerView.getPaddingBottom();
        }
        return n11 - n10;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    public boolean isRtl() {
        int n10;
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        int n11 = linearLayoutManager.getLayoutDirection();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14;
        int n15;
        int n16;
        int n17;
        int n18 = this.mRecyclerView.getMeasuredWidth();
        RecyclerView recyclerView = this.mRecyclerView;
        int n19 = recyclerView.getMeasuredHeight();
        Rect rect = this.mTmpContainerRect;
        rect.left = n17 = this.getPaddingLeft();
        rect = this.mTmpContainerRect;
        n15 -= n16;
        n16 = this.getPaddingRight();
        rect.right = n15 -= n16;
        Rect rect2 = this.mTmpContainerRect;
        rect2.top = n15 = this.getPaddingTop();
        rect2 = this.mTmpContainerRect;
        n20 -= n14;
        n14 = this.getPaddingBottom();
        rect2.bottom = n20 -= n14;
        rect2 = this.mTmpContainerRect;
        Rect rect3 = this.mTmpChildRect;
        Gravity.apply((int)0x800033, (int)n18, (int)n19, (Rect)rect2, (Rect)rect3);
        RecyclerView recyclerView2 = this.mRecyclerView;
        rect2 = this.mTmpChildRect;
        n14 = rect2.left;
        n15 = rect2.top;
        int n20 = rect2.right;
        n16 = rect2.bottom;
        recyclerView2.layout(n14, n15, n20, n16);
        boolean bl3 = this.mCurrentItemDirty;
        if (bl3) {
            this.updateCurrentItem();
        }
    }

    public void onMeasure(int n10, int n11) {
        RecyclerView recyclerView = this.mRecyclerView;
        this.measureChild((View)recyclerView, n10, n11);
        int n12 = this.mRecyclerView.getMeasuredWidth();
        int n13 = this.mRecyclerView.getMeasuredHeight();
        int n14 = this.mRecyclerView.getMeasuredState();
        int n15 = this.getPaddingLeft();
        int n16 = this.getPaddingRight();
        n12 += (n15 += n16);
        n15 = this.getPaddingTop();
        n16 = this.getPaddingBottom();
        n13 += (n15 += n16);
        n15 = this.getSuggestedMinimumWidth();
        n12 = Math.max(n12, n15);
        n15 = this.getSuggestedMinimumHeight();
        n13 = Math.max(n13, n15);
        n10 = ViewGroup.resolveSizeAndState((int)n12, (int)n10, (int)n14);
        n12 = n14 << 16;
        n11 = ViewGroup.resolveSizeAndState((int)n13, (int)n11, (int)n12);
        this.setMeasuredDimension(n10, n11);
    }

    public void onRestoreInstanceState(Parcelable object) {
        int n10 = object instanceof ViewPager2$SavedState;
        if (n10 == 0) {
            super.onRestoreInstanceState(object);
            return;
        }
        object = (ViewPager2$SavedState)((Object)object);
        Parcelable parcelable = object.getSuperState();
        super.onRestoreInstanceState(parcelable);
        this.mPendingCurrentItem = n10 = object.mCurrentItem;
        this.mPendingAdapterState = object = object.mAdapterState;
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        Object object = super.onSaveInstanceState();
        ViewPager2$SavedState viewPager2$SavedState = new ViewPager2$SavedState((Parcelable)object);
        object = this.mRecyclerView;
        viewPager2$SavedState.mRecyclerViewId = n10 = object.getId();
        n10 = this.mPendingCurrentItem;
        int n11 = -1;
        if (n10 == n11) {
            n10 = this.mCurrentItem;
        }
        viewPager2$SavedState.mCurrentItem = n10;
        object = this.mPendingAdapterState;
        if (object != null) {
            viewPager2$SavedState.mAdapterState = object;
        } else {
            object = this.mRecyclerView.getAdapter();
            n11 = object instanceof StatefulAdapter;
            if (n11 != 0) {
                viewPager2$SavedState.mAdapterState = object = ((StatefulAdapter)object).saveState();
            }
        }
        return viewPager2$SavedState;
    }

    public void onViewAdded(View object) {
        CharSequence charSequence = new StringBuilder();
        String string2 = ViewPager2.class.getSimpleName();
        charSequence.append(string2);
        charSequence.append(" does not support direct child views");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public boolean performAccessibilityAction(int n10, Bundle bundle) {
        ViewPager2$AccessibilityProvider viewPager2$AccessibilityProvider = this.mAccessibilityProvider;
        boolean bl2 = viewPager2$AccessibilityProvider.handlesPerformAccessibilityAction(n10, bundle);
        if (bl2) {
            return this.mAccessibilityProvider.onPerformAccessibilityAction(n10, bundle);
        }
        return super.performAccessibilityAction(n10, bundle);
    }

    public void registerOnPageChangeCallback(ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(viewPager2$OnPageChangeCallback);
    }

    public void removeItemDecoration(RecyclerView$ItemDecoration recyclerView$ItemDecoration) {
        this.mRecyclerView.removeItemDecoration(recyclerView$ItemDecoration);
    }

    public void removeItemDecorationAt(int n10) {
        this.mRecyclerView.removeItemDecorationAt(n10);
    }

    public void requestTransform() {
        ViewPager2$PageTransformer viewPager2$PageTransformer = this.mPageTransformerAdapter.getPageTransformer();
        if (viewPager2$PageTransformer == null) {
            return;
        }
        double d10 = this.mScrollEventAdapter.getRelativeScrollPosition();
        int n10 = (int)d10;
        double d11 = n10;
        float f10 = (float)(d10 - d11);
        int n11 = Math.round((float)this.getPageSize() * f10);
        this.mPageTransformerAdapter.onPageScrolled(n10, f10, n11);
    }

    public void setAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        RecyclerView$Adapter recyclerView$Adapter2 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(recyclerView$Adapter2);
        this.unregisterCurrentItemDataSetTracker(recyclerView$Adapter2);
        this.mRecyclerView.setAdapter(recyclerView$Adapter);
        this.mCurrentItem = 0;
        this.restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(recyclerView$Adapter);
        this.registerCurrentItemDataSetTracker(recyclerView$Adapter);
    }

    public void setCurrentItem(int n10) {
        this.setCurrentItem(n10, true);
    }

    public void setCurrentItem(int n10, boolean bl2) {
        boolean bl3 = this.isFakeDragging();
        if (!bl3) {
            this.setCurrentItemInternal(n10, bl2);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        throw illegalStateException;
    }

    public void setCurrentItemInternal(int n10, boolean n11) {
        double d10;
        Object object = this.getAdapter();
        if (object == null) {
            n11 = this.mPendingCurrentItem;
            int n12 = -1;
            if (n11 != n12) {
                this.mPendingCurrentItem = n10 = Math.max(n10, 0);
            }
            return;
        }
        int n13 = ((RecyclerView$Adapter)object).getItemCount();
        if (n13 <= 0) {
            return;
        }
        n10 = Math.max(n10, 0);
        int n14 = ((RecyclerView$Adapter)object).getItemCount() + -1;
        if ((n10 = Math.min(n10, n14)) == (n14 = this.mCurrentItem) && (n14 = (int)(((ScrollEventAdapter)(object = this.mScrollEventAdapter)).isIdle() ? 1 : 0)) != 0) {
            return;
        }
        n14 = this.mCurrentItem;
        if (n10 == n14 && n11 != 0) {
            return;
        }
        double d11 = n14;
        this.mCurrentItem = n10;
        this.mAccessibilityProvider.onSetNewCurrentItem();
        ScrollEventAdapter scrollEventAdapter = this.mScrollEventAdapter;
        n13 = (int)(scrollEventAdapter.isIdle() ? 1 : 0);
        if (n13 == 0) {
            object = this.mScrollEventAdapter;
            d11 = ((ScrollEventAdapter)object).getRelativeScrollPosition();
        }
        scrollEventAdapter = this.mScrollEventAdapter;
        scrollEventAdapter.notifyProgrammaticScroll(n10, n11 != 0);
        if (n11 == 0) {
            this.mRecyclerView.scrollToPosition(n10);
            return;
        }
        double d12 = n10;
        double d13 = Math.abs(d12 - d11);
        double d14 = d13 - (d10 = 3.0);
        n11 = (int)(d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1));
        if (n11 > 0) {
            RecyclerView recyclerView = this.mRecyclerView;
            n14 = (int)(d12 == d11 ? 0 : (d12 > d11 ? 1 : -1));
            n14 = n14 > 0 ? n10 + -3 : n10 + 3;
            recyclerView.scrollToPosition(n14);
            recyclerView = this.mRecyclerView;
            object = new ViewPager2$SmoothScrollToPosition(n10, recyclerView);
            recyclerView.post((Runnable)object);
        } else {
            RecyclerView recyclerView = this.mRecyclerView;
            recyclerView.smoothScrollToPosition(n10);
        }
    }

    public void setLayoutDirection(int n10) {
        super.setLayoutDirection(n10);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int n10) {
        int n11 = 1;
        if (n10 < n11 && n10 != (n11 = -1)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
            throw illegalArgumentException;
        }
        this.mOffscreenPageLimit = n10;
        this.mRecyclerView.requestLayout();
    }

    public void setOrientation(int n10) {
        this.mLayoutManager.setOrientation(n10);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public void setPageTransformer(ViewPager2$PageTransformer viewPager2$PageTransformer) {
        ViewPager2$PageTransformer viewPager2$PageTransformer2 = null;
        if (viewPager2$PageTransformer != null) {
            Object object;
            boolean bl2 = this.mSavedItemAnimatorPresent;
            if (!bl2) {
                this.mSavedItemAnimator = object = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = bl2 = true;
            }
            object = this.mRecyclerView;
            ((RecyclerView)object).setItemAnimator(null);
        } else {
            boolean bl3 = this.mSavedItemAnimatorPresent;
            if (bl3) {
                RecyclerView recyclerView = this.mRecyclerView;
                RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mSavedItemAnimator;
                recyclerView.setItemAnimator(recyclerView$ItemAnimator);
                this.mSavedItemAnimator = null;
                viewPager2$PageTransformer2 = null;
                this.mSavedItemAnimatorPresent = false;
            }
        }
        viewPager2$PageTransformer2 = this.mPageTransformerAdapter.getPageTransformer();
        if (viewPager2$PageTransformer == viewPager2$PageTransformer2) {
            return;
        }
        this.mPageTransformerAdapter.setPageTransformer(viewPager2$PageTransformer);
        this.requestTransform();
    }

    public void setUserInputEnabled(boolean bl2) {
        this.mUserInputEnabled = bl2;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void snapToPage() {
        Object object = this.mPagerSnapHelper;
        Object object2 = this.mLayoutManager;
        if ((object = ((PagerSnapHelper)object).findSnapView((RecyclerView$LayoutManager)object2)) == null) {
            return;
        }
        object2 = this.mPagerSnapHelper;
        Object object3 = this.mLayoutManager;
        object = ((PagerSnapHelper)object2).calculateDistanceToFinalSnap((RecyclerView$LayoutManager)object3, (View)object);
        boolean n10 = false;
        object2 = null;
        Object object4 = object[0];
        int n11 = 1;
        if (object4 != false || (object4 = object[n11]) != false) {
            object3 = this.mRecyclerView;
            Object object5 = object[0];
            Object object6 = object[n11];
            ((RecyclerView)object3).smoothScrollBy((int)object5, (int)object6);
        }
    }

    public void unregisterOnPageChangeCallback(ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(viewPager2$OnPageChangeCallback);
    }

    public void updateCurrentItem() {
        Object object = this.mPagerSnapHelper;
        if (object != null) {
            int n10;
            Object object2 = this.mLayoutManager;
            if ((object = ((PagerSnapHelper)object).findSnapView((RecyclerView$LayoutManager)object2)) == null) {
                return;
            }
            object2 = this.mLayoutManager;
            int n11 = ((RecyclerView$LayoutManager)object2).getPosition((View)object);
            if (n11 != (n10 = this.mCurrentItem) && (n10 = this.getScrollState()) == 0) {
                object2 = this.mPageChangeEventDispatcher;
                ((CompositeOnPageChangeCallback)object2).onPageSelected(n11);
            }
            this.mCurrentItemDirty = false;
            return;
        }
        object = new IllegalStateException("Design assumption violated.");
        throw object;
    }
}

