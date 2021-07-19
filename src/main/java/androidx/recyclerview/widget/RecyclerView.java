/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.LayoutTransition
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.FocusFinder
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.animation.Interpolator
 *  android.widget.EdgeEffect
 *  android.widget.OverScroller
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.FastScroller;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.GapWorker$LayoutPrefetchRegistryImpl;
import androidx.recyclerview.widget.RecyclerView$2;
import androidx.recyclerview.widget.RecyclerView$3;
import androidx.recyclerview.widget.RecyclerView$4;
import androidx.recyclerview.widget.RecyclerView$5;
import androidx.recyclerview.widget.RecyclerView$6;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView$ChildDrawingOrderCallback;
import androidx.recyclerview.widget.RecyclerView$EdgeEffectFactory;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorListener;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView$ItemAnimatorRestoreListener;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView$OnFlingListener;
import androidx.recyclerview.widget.RecyclerView$OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.RecyclerView$RecycledViewPool;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$RecyclerListener;
import androidx.recyclerview.widget.RecyclerView$RecyclerViewDataObserver;
import androidx.recyclerview.widget.RecyclerView$SavedState;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewCacheExtension;
import androidx.recyclerview.widget.RecyclerView$ViewFlinger;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewInfoStore;
import androidx.recyclerview.widget.ViewInfoStore$ProcessCallback;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
extends ViewGroup
implements ScrollingView,
NestedScrollingChild2,
NestedScrollingChild3 {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    public static final boolean ALLOW_THREAD_GAP_WORK = false;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final int INVALID_POINTER = 255;
    public static final int INVALID_TYPE = 255;
    private static final Class[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS;
    public static final long NO_ID = 255L;
    public static final int NO_POSITION = 255;
    public static final boolean POST_UPDATES_ON_ANIMATION = false;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    public static final Interpolator sQuinticInterpolator;
    public RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    public RecyclerView$Adapter mAdapter;
    public AdapterHelper mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private RecyclerView$ChildDrawingOrderCallback mChildDrawingOrderCallback;
    public ChildHelper mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private RecyclerView$EdgeEffectFactory mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public GapWorker mGapWorker;
    public boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private RecyclerView$OnItemTouchListener mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public RecyclerView$ItemAnimator mItemAnimator;
    private RecyclerView$ItemAnimator$ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    public final ArrayList mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    public RecyclerView$LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerView$RecyclerViewDataObserver mObserver;
    private List mOnChildAttachStateListeners;
    private RecyclerView$OnFlingListener mOnFlingListener;
    private final ArrayList mOnItemTouchListeners;
    public final List mPendingAccessibilityImportanceChange;
    public RecyclerView$SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public GapWorker$LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    public final RecyclerView$Recycler mRecycler;
    public RecyclerView$RecyclerListener mRecyclerListener;
    public final List mRecyclerListeners;
    public final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private RecyclerView$OnScrollListener mScrollListener;
    private List mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    public final RecyclerView$State mState;
    public final Rect mTempRect;
    private final Rect mTempRect2;
    public final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    public final RecyclerView$ViewFlinger mViewFlinger;
    private final ViewInfoStore$ProcessCallback mViewInfoProcessCallback;
    public final ViewInfoStore mViewInfoStore;

    static {
        Class<Integer> clazz;
        int n10 = 1;
        Object[] objectArray = new int[n10];
        objectArray[0] = 16843830;
        NESTED_SCROLLING_ATTRS = objectArray;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 != n12 && n11 != (n12 = 19) && n11 != (n12 = 20)) {
            n12 = 0;
            clazz = null;
        } else {
            n12 = n10;
        }
        FORCE_INVALIDATE_DISPLAY_LIST = n12;
        n12 = 23;
        if (n11 >= n12) {
            n12 = n10;
        } else {
            n12 = 0;
            clazz = null;
        }
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = n12;
        n12 = 16;
        if (n11 >= n12) {
            n12 = n10;
        } else {
            n12 = 0;
            clazz = null;
        }
        POST_UPDATES_ON_ANIMATION = n12;
        n12 = 21;
        if (n11 >= n12) {
            n12 = n10;
        } else {
            n12 = 0;
            clazz = null;
        }
        ALLOW_THREAD_GAP_WORK = n12;
        n12 = 15;
        int n13 = n11 <= n12 ? n10 : 0;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = n13;
        if (n11 <= n12) {
            n11 = n10;
        } else {
            n11 = 0;
            objectArray = null;
        }
        IGNORE_DETACHED_FOCUSED_CHILD = n11;
        objectArray = new Class[4];
        objectArray[0] = (int)Context.class;
        objectArray[n10] = (int)AttributeSet.class;
        clazz = Integer.TYPE;
        objectArray[2] = (int)clazz;
        objectArray[3] = (int)clazz;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = (Class[])objectArray;
        RecyclerView$3 recyclerView$3 = new RecyclerView$3();
        sQuinticInterpolator = recyclerView$3;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.recyclerViewStyle;
        this(context, attributeSet, n10);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        float f10;
        int n12;
        float f11;
        int n13;
        ArrayList arrayList = new ArrayList(this);
        this.mObserver = arrayList;
        arrayList = new ArrayList(this);
        this.mRecycler = arrayList;
        arrayList = new ArrayList();
        this.mViewInfoStore = arrayList;
        arrayList = new ArrayList(this);
        this.mUpdateChildViewsRunnable = arrayList;
        arrayList = new ArrayList();
        this.mTempRect = arrayList;
        arrayList = new ArrayList();
        this.mTempRect2 = arrayList;
        arrayList = new ArrayList();
        this.mTempRectF = arrayList;
        this.mRecyclerListeners = arrayList = new ArrayList();
        this.mItemDecorations = arrayList = new ArrayList();
        this.mOnItemTouchListeners = arrayList = new ArrayList();
        arrayList = null;
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        Object object = new RecyclerView$EdgeEffectFactory();
        this.mEdgeEffectFactory = object;
        this.mItemAnimator = object = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = n13 = -1;
        this.mScaledHorizontalScrollFactor = f11 = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = f11;
        boolean bl2 = true;
        f11 = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = bl2;
        Object object2 = new RecyclerView$ViewFlinger(this);
        this.mViewFlinger = object2;
        int n14 = ALLOW_THREAD_GAP_WORK;
        if (n14 != 0) {
            object2 = new GapWorker$LayoutPrefetchRegistryImpl();
        } else {
            n14 = 0;
            object2 = null;
        }
        this.mPrefetchRegistry = object2;
        this.mState = object2 = new RecyclerView$State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = object2 = new RecyclerView$ItemAnimatorRestoreListener(this);
        this.mPostedAnimatorRunner = false;
        n14 = 2;
        Object object3 = new int[n14];
        this.mMinMaxLayoutPositions = object3;
        object3 = new int[n14];
        this.mScrollOffset = object3;
        object3 = new int[n14];
        this.mNestedOffsets = object3;
        object3 = new int[n14];
        this.mReusableIntPair = object3;
        object3 = new ArrayList;
        super();
        this.mPendingAccessibilityImportanceChange = object3;
        object3 = new RecyclerView$2;
        super(this);
        this.mItemAnimatorRunner = object3;
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        object3 = new RecyclerView$4;
        super(this);
        this.mViewInfoProcessCallback = object3;
        this.setScrollContainer(bl2);
        this.setFocusableInTouchMode(bl2);
        object3 = ViewConfiguration.get((Context)context);
        this.mTouchSlop = n12 = object3.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = f10 = ViewConfigurationCompat.getScaledHorizontalScrollFactor((ViewConfiguration)object3, context);
        this.mScaledVerticalScrollFactor = f10 = ViewConfigurationCompat.getScaledVerticalScrollFactor((ViewConfiguration)object3, context);
        this.mMinFlingVelocity = n12 = object3.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = n11 = object3.getScaledMaximumFlingVelocity();
        n11 = this.getOverScrollMode();
        if (n11 == n14) {
            n14 = (int)(bl2 ? 1 : 0);
        } else {
            n14 = 0;
            object2 = null;
        }
        this.setWillNotDraw(n14 != 0);
        object2 = this.mItemAnimator;
        object3 = this.mItemAnimatorListener;
        ((RecyclerView$ItemAnimator)object2).setListener((RecyclerView$ItemAnimator$ItemAnimatorListener)object3);
        this.initAdapterManager();
        this.initChildrenHelper();
        this.initAutofill();
        n14 = ViewCompat.getImportantForAccessibility((View)this);
        if (n14 == 0) {
            ViewCompat.setImportantForAccessibility((View)this, (int)(bl2 ? 1 : 0));
        }
        object2 = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.mAccessibilityManager = object2;
        object2 = new RecyclerViewAccessibilityDelegate(this);
        this.setAccessibilityDelegateCompat((RecyclerViewAccessibilityDelegate)object2);
        Object object4 = R$styleable.RecyclerView;
        object2 = context.obtainStyledAttributes(attributeSet, object4, n10, 0);
        object3 = this;
        Object object5 = context;
        Object object6 = attributeSet;
        ViewCompat.saveAttributeDataForStyleable((View)this, context, object4, attributeSet, (TypedArray)object2, n10, 0);
        n11 = R$styleable.RecyclerView_layoutManager;
        object6 = object2.getString(n11);
        n11 = R$styleable.RecyclerView_android_descendantFocusability;
        n11 = object2.getInt(n11, n13);
        if (n11 == n13) {
            n13 = 262144;
            this.setDescendantFocusability(n13);
        }
        n13 = R$styleable.RecyclerView_android_clipToPadding;
        n13 = (int)(object2.getBoolean(n13, bl2) ? 1 : 0);
        this.mClipToPadding = n13;
        n13 = R$styleable.RecyclerView_fastScrollEnabled;
        n13 = (int)(object2.getBoolean(n13, false) ? 1 : 0);
        this.mEnableFastScroller = n13;
        if (n13 != 0) {
            n13 = R$styleable.RecyclerView_fastScrollVerticalThumbDrawable;
            object = (StateListDrawable)object2.getDrawable(n13);
            n11 = R$styleable.RecyclerView_fastScrollVerticalTrackDrawable;
            object3 = object2.getDrawable(n11);
            n12 = R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable;
            object5 = (StateListDrawable)object2.getDrawable(n12);
            int n15 = R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable;
            object4 = object2.getDrawable(n15);
            this.initFastScroller((StateListDrawable)object, (Drawable)object3, (StateListDrawable)object5, (Drawable)object4);
        }
        object2.recycle();
        object5 = this;
        object4 = context;
        this.createLayoutManager(context, (String)object6, attributeSet, n10, 0);
        n13 = Build.VERSION.SDK_INT;
        n14 = 21;
        if (n13 >= n14) {
            object4 = NESTED_SCROLLING_ATTRS;
            object = context.obtainStyledAttributes(attributeSet, object4, n10, 0);
            object3 = this;
            object5 = context;
            object6 = attributeSet;
            ViewCompat.saveAttributeDataForStyleable((View)this, context, object4, attributeSet, (TypedArray)object, n10, 0);
            bl2 = object.getBoolean(0, bl2);
            object.recycle();
        }
        this.setNestedScrollingEnabled(bl2);
    }

    public static /* synthetic */ void access$000(RecyclerView recyclerView, View view, int n10, ViewGroup.LayoutParams layoutParams) {
        recyclerView.attachViewToParent(view, n10, layoutParams);
    }

    public static /* synthetic */ void access$100(RecyclerView recyclerView, int n10) {
        recyclerView.detachViewFromParent(n10);
    }

    public static /* synthetic */ boolean access$200(RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }

    public static /* synthetic */ void access$300(RecyclerView recyclerView, int n10, int n11) {
        recyclerView.setMeasuredDimension(n10, n11);
    }

    /*
     * WARNING - void declaration
     */
    private void addAnimatingView(RecyclerView$ViewHolder object) {
        void var5_7;
        View view = ((RecyclerView$ViewHolder)object).itemView;
        ViewParent viewParent = view.getParent();
        boolean bl3 = true;
        if (viewParent == this) {
            boolean bl2 = bl3;
        } else {
            boolean bl2 = false;
            viewParent = null;
        }
        RecyclerView$Recycler recyclerView$Recycler = this.mRecycler;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.getChildViewHolder(view);
        recyclerView$Recycler.unscrapView(recyclerView$ViewHolder);
        boolean bl4 = ((RecyclerView$ViewHolder)object).isTmpDetached();
        if (bl4) {
            object = this.mChildHelper;
            int n10 = -1;
            recyclerView$Recycler = view.getLayoutParams();
            ((ChildHelper)object).attachViewToParent(view, n10, (ViewGroup.LayoutParams)recyclerView$Recycler, bl3);
        } else if (var5_7 == false) {
            object = this.mChildHelper;
            ((ChildHelper)object).addView(view, bl3);
        } else {
            object = this.mChildHelper;
            ((ChildHelper)object).hide(view);
        }
    }

    private void animateChange(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2, boolean bl2, boolean bl3) {
        boolean bl4;
        Object object;
        recyclerView$ViewHolder.setIsRecyclable(false);
        if (bl2) {
            this.addAnimatingView(recyclerView$ViewHolder);
        }
        if (recyclerView$ViewHolder != recyclerView$ViewHolder2) {
            if (bl3) {
                this.addAnimatingView(recyclerView$ViewHolder2);
            }
            recyclerView$ViewHolder.mShadowedHolder = recyclerView$ViewHolder2;
            this.addAnimatingView(recyclerView$ViewHolder);
            object = this.mRecycler;
            ((RecyclerView$Recycler)object).unscrapView(recyclerView$ViewHolder);
            recyclerView$ViewHolder2.setIsRecyclable(false);
            recyclerView$ViewHolder2.mShadowingHolder = recyclerView$ViewHolder;
        }
        if (bl4 = ((RecyclerView$ItemAnimator)(object = this.mItemAnimator)).animateChange(recyclerView$ViewHolder, recyclerView$ViewHolder2, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2)) {
            this.postAnimationRunner();
        }
    }

    private void cancelScroll() {
        this.resetScroll();
        this.setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        WeakReference weakReference = recyclerView$ViewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            weakReference = (View)weakReference.get();
            while (weakReference != null) {
                View view = recyclerView$ViewHolder.itemView;
                if (weakReference == view) {
                    return;
                }
                boolean bl2 = (weakReference = weakReference.getParent()) instanceof View;
                if (bl2) {
                    weakReference = (View)weakReference;
                    continue;
                }
                weakReference = null;
            }
            recyclerView$ViewHolder.mNestedRecyclerView = null;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void createLayoutManager(Context object, String string2, AttributeSet object2, int n10, int n11) {
        void var3_13;
        String string3;
        String string4 = ": Could not instantiate the LayoutManager: ";
        if (string3 == null) return;
        boolean bl2 = (string3 = string3.trim()).isEmpty();
        if (bl2) return;
        string3 = this.getFullClassName((Context)object, string3);
        try {
            Object object3;
            Object object4;
            bl2 = this.isInEditMode();
            if (bl2) {
                object4 = this.getClass();
                object4 = ((Class)object4).getClassLoader();
            } else {
                object4 = object.getClassLoader();
            }
            object4 = Class.forName(string3, false, (ClassLoader)object4);
            Object[] objectArray = RecyclerView$LayoutManager.class;
            object4 = ((Class)object4).asSubclass(objectArray);
            objectArray = null;
            int n12 = 1;
            try {
                void var5_20;
                void var4_19;
                object3 = LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
                object3 = ((Class)object4).getConstructor((Class<?>)object3);
                int n13 = 4;
                Object[] objectArray2 = new Object[n13];
                objectArray2[0] = object;
                objectArray2[n12] = var3_13;
                int n14 = 2;
                Integer n15 = (int)var4_19;
                objectArray2[n14] = n15;
                n14 = 3;
                Integer n16 = (int)var5_20;
                objectArray2[n14] = n16;
                objectArray = objectArray2;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                try {
                    Class[] classArray = new Class[]{};
                    object3 = ((Class)object4).getConstructor(classArray);
                }
                catch (NoSuchMethodException noSuchMethodException2) {
                    noSuchMethodException2.initCause(noSuchMethodException);
                    StringBuilder stringBuilder = new StringBuilder();
                    object4 = var3_13.getPositionDescription();
                    stringBuilder.append((String)object4);
                    object4 = ": Error creating LayoutManager ";
                    stringBuilder.append((String)object4);
                    stringBuilder.append(string3);
                    String string5 = stringBuilder.toString();
                    IllegalStateException illegalStateException = new IllegalStateException(string5, noSuchMethodException2);
                    throw illegalStateException;
                }
            }
            ((Constructor)object3).setAccessible(n12 != 0);
            Object t10 = ((Constructor)object3).newInstance(objectArray);
            RecyclerView$LayoutManager recyclerView$LayoutManager = (RecyclerView$LayoutManager)t10;
            this.setLayoutManager(recyclerView$LayoutManager);
            return;
        }
        catch (ClassCastException classCastException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string6 = var3_13.getPositionDescription();
            stringBuilder.append(string6);
            stringBuilder.append(": Class is not a LayoutManager ");
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3, classCastException);
            throw illegalStateException;
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = var3_13.getPositionDescription();
            stringBuilder.append(string7);
            stringBuilder.append(": Cannot access non-public constructor ");
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3, illegalAccessException);
            throw illegalStateException;
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string8 = var3_13.getPositionDescription();
            stringBuilder.append(string8);
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3, instantiationException);
            throw illegalStateException;
        }
        catch (InvocationTargetException invocationTargetException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string9 = var3_13.getPositionDescription();
            stringBuilder.append(string9);
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3, invocationTargetException);
            throw illegalStateException;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string10 = var3_13.getPositionDescription();
            stringBuilder.append(string10);
            stringBuilder.append(": Unable to find LayoutManager ");
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3, classNotFoundException);
            throw illegalStateException;
        }
    }

    private boolean didChildRangeChange(int n10, int n11) {
        int[] nArray = this.mMinMaxLayoutPositions;
        this.findMinMaxChildLayoutPositions(nArray);
        nArray = this.mMinMaxLayoutPositions;
        boolean bl2 = false;
        int n12 = nArray[0];
        boolean bl3 = true;
        if (n12 != n10 || (n10 = nArray[bl3]) != n11) {
            bl2 = bl3;
        }
        return bl2;
    }

    private void dispatchContentChangedIfNecessary() {
        int n10 = this.mEatenAccessibilityChangeFlags;
        boolean bl2 = false;
        AccessibilityEvent accessibilityEvent = null;
        this.mEatenAccessibilityChangeFlags = 0;
        if (n10 != 0 && (bl2 = this.isAccessibilityEnabled())) {
            accessibilityEvent = AccessibilityEvent.obtain();
            int n11 = 2048;
            accessibilityEvent.setEventType(n11);
            AccessibilityEventCompat.setContentChangeTypes(accessibilityEvent, n10);
            this.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    private void dispatchLayoutStep1() {
        Object object;
        List list;
        Object object2;
        Object object3;
        boolean bl2;
        Object object4;
        Object object5;
        boolean bl3;
        Object object6 = this.mState;
        int n10 = 1;
        ((RecyclerView$State)object6).assertLayoutStep(n10);
        object6 = this.mState;
        this.fillRemainingScrollValues((RecyclerView$State)object6);
        this.mState.mIsMeasuring = false;
        this.startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        this.onEnterLayoutOrScroll();
        this.processAdapterUpdatesAndSetAnimationFlags();
        this.saveFocusInfo();
        object6 = this.mState;
        boolean n11 = ((RecyclerView$State)object6).mRunSimpleAnimations;
        if (!n11 || !(bl3 = this.mItemsChanged)) {
            n10 = 0;
            object5 = null;
        }
        ((RecyclerView$State)object6).mTrackOldChangeHolders = n10;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        n10 = (int)(((RecyclerView$State)object6).mRunPredictiveAnimations ? 1 : 0);
        ((RecyclerView$State)object6).mInPreLayout = n10;
        object5 = this.mAdapter;
        ((RecyclerView$State)object6).mItemCount = n10 = ((RecyclerView$Adapter)object5).getItemCount();
        object6 = this.mMinMaxLayoutPositions;
        this.findMinMaxChildLayoutPositions((int[])object6);
        object6 = this.mState;
        int n12 = ((RecyclerView$State)object6).mRunSimpleAnimations;
        if (n12 != 0) {
            object6 = this.mChildHelper;
            n12 = ((ChildHelper)object6).getChildCount();
            object5 = null;
            for (n10 = 0; n10 < n12; ++n10) {
                object4 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(n10));
                bl2 = ((RecyclerView$ViewHolder)object4).shouldIgnore();
                if (bl2 || (bl2 = ((RecyclerView$ViewHolder)object4).isInvalid()) && !(bl2 = ((RecyclerView$Adapter)(object3 = this.mAdapter)).hasStableIds())) continue;
                object3 = this.mItemAnimator;
                object2 = this.mState;
                int n13 = RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView$ViewHolder)object4);
                list = ((RecyclerView$ViewHolder)object4).getUnmodifiedPayloads();
                object3 = ((RecyclerView$ItemAnimator)object3).recordPreLayoutInformation((RecyclerView$State)object2, (RecyclerView$ViewHolder)object4, n13, list);
                object2 = this.mViewInfoStore;
                ((ViewInfoStore)object2).addToPreLayout((RecyclerView$ViewHolder)object4, (RecyclerView$ItemAnimator$ItemHolderInfo)object3);
                object3 = this.mState;
                bl2 = ((RecyclerView$State)object3).mTrackOldChangeHolders;
                if (!bl2 || !(bl2 = ((RecyclerView$ViewHolder)object4).isUpdated()) || (bl2 = ((RecyclerView$ViewHolder)object4).isRemoved()) || (bl2 = ((RecyclerView$ViewHolder)object4).shouldIgnore()) || (bl2 = ((RecyclerView$ViewHolder)object4).isInvalid())) continue;
                long l10 = this.getChangedHolderKey((RecyclerView$ViewHolder)object4);
                object = this.mViewInfoStore;
                ((ViewInfoStore)object).addToOldChangeHolders(l10, (RecyclerView$ViewHolder)object4);
            }
        }
        object6 = this.mState;
        n12 = (int)(((RecyclerView$State)object6).mRunPredictiveAnimations ? 1 : 0);
        if (n12 != 0) {
            this.saveOldPositions();
            object6 = this.mState;
            n10 = (int)(((RecyclerView$State)object6).mStructureChanged ? 1 : 0);
            ((RecyclerView$State)object6).mStructureChanged = false;
            object4 = this.mLayout;
            object3 = this.mRecycler;
            ((RecyclerView$LayoutManager)object4).onLayoutChildren((RecyclerView$Recycler)object3, (RecyclerView$State)object6);
            this.mState.mStructureChanged = n10;
            object6 = null;
            for (n12 = 0; n12 < (n10 = ((ChildHelper)(object5 = this.mChildHelper)).getChildCount()); ++n12) {
                object5 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(n12));
                int n14 = ((RecyclerView$ViewHolder)object5).shouldIgnore();
                if (n14 != 0 || (n14 = ((ViewInfoStore)(object4 = this.mViewInfoStore)).isInPreLayout((RecyclerView$ViewHolder)object5)) != 0) continue;
                n14 = RecyclerView$ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView$ViewHolder)object5);
                bl2 = ((RecyclerView$ViewHolder)object5).hasAnyOfTheFlags(8192);
                if (!bl2) {
                    n14 |= 0x1000;
                }
                object2 = this.mItemAnimator;
                object = this.mState;
                list = ((RecyclerView$ViewHolder)object5).getUnmodifiedPayloads();
                object4 = ((RecyclerView$ItemAnimator)object2).recordPreLayoutInformation((RecyclerView$State)object, (RecyclerView$ViewHolder)object5, n14, list);
                if (bl2) {
                    this.recordAnimationInfoIfBouncedHiddenView((RecyclerView$ViewHolder)object5, (RecyclerView$ItemAnimator$ItemHolderInfo)object4);
                    continue;
                }
                object3 = this.mViewInfoStore;
                ((ViewInfoStore)object3).addToAppearedInPreLayoutHolders((RecyclerView$ViewHolder)object5, (RecyclerView$ItemAnimator$ItemHolderInfo)object4);
            }
            this.clearOldPositions();
        } else {
            this.clearOldPositions();
        }
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    private void dispatchLayoutStep2() {
        Object object;
        boolean bl2;
        int n10;
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        Object object2 = this.mState;
        ((RecyclerView$State)object2).mItemCount = n10 = this.mAdapter.getItemCount();
        object2 = this.mState;
        n10 = 0;
        ((RecyclerView$State)object2).mDeletedInvisibleItemCountSincePreviousLayout = 0;
        object2 = this.mPendingSavedState;
        if (object2 != null && (bl2 = ((RecyclerView$Adapter)(object2 = this.mAdapter)).canRestoreState())) {
            object2 = this.mPendingSavedState.mLayoutState;
            if (object2 != null) {
                object = this.mLayout;
                ((RecyclerView$LayoutManager)object).onRestoreInstanceState((Parcelable)object2);
            }
            bl2 = false;
            object2 = null;
            this.mPendingSavedState = null;
        }
        object2 = this.mState;
        ((RecyclerView$State)object2).mInPreLayout = false;
        object = this.mLayout;
        RecyclerView$Recycler recyclerView$Recycler = this.mRecycler;
        ((RecyclerView$LayoutManager)object).onLayoutChildren(recyclerView$Recycler, (RecyclerView$State)object2);
        object2 = this.mState;
        ((RecyclerView$State)object2).mStructureChanged = false;
        boolean bl3 = ((RecyclerView$State)object2).mRunSimpleAnimations;
        if (bl3 && (object = this.mItemAnimator) != null) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        ((RecyclerView$State)object2).mRunSimpleAnimations = bl3;
        ((RecyclerView$State)object2).mLayoutStep = 4;
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        Object object;
        int n10;
        Object object2;
        int n11;
        this.mState.assertLayoutStep(4);
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        Object object3 = this.mState;
        ((RecyclerView$State)object3).mLayoutStep = n11 = 1;
        Object object4 = ((RecyclerView$State)object3).mRunSimpleAnimations;
        if (object4 != 0) {
            object3 = this.mChildHelper;
            for (object4 = ((ChildHelper)object3).getChildCount() - n11; object4 >= 0; object4 += -1) {
                boolean bl2;
                object2 = this.mChildHelper.getChildAt((int)object4);
                RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt((View)object2);
                n10 = (int)(recyclerView$ViewHolder.shouldIgnore() ? 1 : 0);
                if (n10 != 0) continue;
                long l10 = this.getChangedHolderKey(recyclerView$ViewHolder);
                Object object5 = this.mItemAnimator;
                Object object6 = this.mState;
                object5 = ((RecyclerView$ItemAnimator)object5).recordPostLayoutInformation((RecyclerView$State)object6, recyclerView$ViewHolder);
                object6 = this.mViewInfoStore.getFromOldChangeHolders(l10);
                if (object6 != null && !(bl2 = ((RecyclerView$ViewHolder)object6).shouldIgnore())) {
                    boolean bl3 = this.mViewInfoStore.isDisappearing((RecyclerView$ViewHolder)object6);
                    Object object7 = this.mViewInfoStore;
                    boolean bl4 = ((ViewInfoStore)object7).isDisappearing(recyclerView$ViewHolder);
                    if (bl3 && object6 == recyclerView$ViewHolder) {
                        object2 = this.mViewInfoStore;
                        ((ViewInfoStore)object2).addToPostLayout(recyclerView$ViewHolder, (RecyclerView$ItemAnimator$ItemHolderInfo)object5);
                        continue;
                    }
                    object7 = this.mViewInfoStore.popFromPreLayout((RecyclerView$ViewHolder)object6);
                    this.mViewInfoStore.addToPostLayout(recyclerView$ViewHolder, (RecyclerView$ItemAnimator$ItemHolderInfo)object5);
                    object5 = this.mViewInfoStore;
                    RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo = ((ViewInfoStore)object5).popFromPostLayout(recyclerView$ViewHolder);
                    if (object7 == null) {
                        this.handleMissingPreInfoForChangeError(l10, recyclerView$ViewHolder, (RecyclerView$ViewHolder)object6);
                        continue;
                    }
                    object = this;
                    object5 = object6;
                    object6 = object7;
                    object7 = recyclerView$ItemAnimator$ItemHolderInfo;
                    this.animateChange((RecyclerView$ViewHolder)object5, recyclerView$ViewHolder, (RecyclerView$ItemAnimator$ItemHolderInfo)object6, recyclerView$ItemAnimator$ItemHolderInfo, bl3, bl4);
                    continue;
                }
                object2 = this.mViewInfoStore;
                ((ViewInfoStore)object2).addToPostLayout(recyclerView$ViewHolder, (RecyclerView$ItemAnimator$ItemHolderInfo)object5);
            }
            object3 = this.mViewInfoStore;
            object2 = this.mViewInfoProcessCallback;
            ((ViewInfoStore)object3).process((ViewInfoStore$ProcessCallback)object2);
        }
        object3 = this.mLayout;
        object2 = this.mRecycler;
        ((RecyclerView$LayoutManager)object3).removeAndRecycleScrapInt((RecyclerView$Recycler)object2);
        object3 = this.mState;
        ((RecyclerView$State)object3).mPreviousLayoutItemCount = n10 = ((RecyclerView$State)object3).mItemCount;
        n10 = 0;
        object2 = null;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        ((RecyclerView$State)object3).mRunSimpleAnimations = false;
        ((RecyclerView$State)object3).mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        object3 = this.mRecycler.mChangedScrap;
        if (object3 != null) {
            ((ArrayList)object3).clear();
        }
        object3 = this.mLayout;
        int n12 = (int)(((RecyclerView$LayoutManager)object3).mPrefetchMaxObservedInInitialPrefetch ? 1 : 0);
        if (n12 != false) {
            ((RecyclerView$LayoutManager)object3).mPrefetchMaxCountObserved = 0;
            ((RecyclerView$LayoutManager)object3).mPrefetchMaxObservedInInitialPrefetch = false;
            object3 = this.mRecycler;
            ((RecyclerView$Recycler)object3).updateViewCacheSize();
        }
        object3 = this.mLayout;
        object = this.mState;
        ((RecyclerView$LayoutManager)object3).onLayoutCompleted((RecyclerView$State)object);
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        object3 = this.mMinMaxLayoutPositions;
        n12 = object3[0];
        object4 = object3[n11];
        object4 = this.didChildRangeChange(n12, (int)object4);
        if (object4 != 0) {
            this.dispatchOnScrolled(0, 0);
        }
        this.recoverFocusFromState();
        this.resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        RecyclerView$OnItemTouchListener recyclerView$OnItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (recyclerView$OnItemTouchListener == null) {
            int n10 = motionEvent.getAction();
            if (n10 == 0) {
                return false;
            }
            return this.findInterceptingOnItemTouchListener(motionEvent);
        }
        recyclerView$OnItemTouchListener.onTouchEvent(this, motionEvent);
        boolean bl2 = motionEvent.getAction();
        boolean bl3 = 3 != 0;
        boolean bl4 = true;
        if (bl2 == bl3 || bl2 == bl4) {
            boolean bl5 = false;
            motionEvent = null;
            this.mInterceptingOnItemTouchListener = null;
        }
        return bl4;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        ArrayList arrayList = this.mOnItemTouchListeners;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            RecyclerView$OnItemTouchListener recyclerView$OnItemTouchListener = (RecyclerView$OnItemTouchListener)this.mOnItemTouchListeners.get(i10);
            int n12 = recyclerView$OnItemTouchListener.onInterceptTouchEvent(this, motionEvent);
            if (n12 == 0 || n10 == (n12 = 3)) continue;
            this.mInterceptingOnItemTouchListener = recyclerView$OnItemTouchListener;
            return true;
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] nArray) {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getChildCount();
        int n11 = 1;
        if (n10 == 0) {
            nArray[0] = n10 = -1;
            nArray[n11] = n10;
            return;
        }
        int n12 = -1 >>> 1;
        int n13 = -1 << -1;
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(i10));
            boolean bl2 = recyclerView$ViewHolder.shouldIgnore();
            if (bl2) continue;
            int n14 = recyclerView$ViewHolder.getLayoutPosition();
            if (n14 < n12) {
                n12 = n14;
            }
            if (n14 <= n13) continue;
            n13 = n14;
        }
        nArray[0] = n12;
        nArray[n11] = n13;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        int n10 = view instanceof ViewGroup;
        if (n10 == 0) {
            return null;
        }
        n10 = view instanceof RecyclerView;
        if (n10 != 0) {
            return (RecyclerView)view;
        }
        view = (ViewGroup)view;
        n10 = view.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView recyclerView = RecyclerView.findNestedRecyclerView(view.getChildAt(i10));
            if (recyclerView == null) continue;
            return recyclerView;
        }
        return null;
    }

    private View findNextViewToFocus() {
        RecyclerView$ViewHolder recyclerView$ViewHolder;
        View view;
        RecyclerView$State recyclerView$State = this.mState;
        int n10 = recyclerView$State.mFocusedItemPosition;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 0;
            view = null;
        }
        int n12 = recyclerView$State.getItemCount();
        for (n11 = n10; n11 < n12 && (recyclerView$ViewHolder = this.findViewHolderForAdapterPosition(n11)) != null; ++n11) {
            View view2 = recyclerView$ViewHolder.itemView;
            boolean bl2 = view2.hasFocusable();
            if (!bl2) continue;
            return recyclerView$ViewHolder.itemView;
        }
        n12 = Math.min(n12, n10) + -1;
        while (true) {
            n10 = 0;
            view = null;
            if (n12 < 0) break;
            RecyclerView$ViewHolder recyclerView$ViewHolder2 = this.findViewHolderForAdapterPosition(n12);
            if (recyclerView$ViewHolder2 == null) {
                return null;
            }
            view = recyclerView$ViewHolder2.itemView;
            n10 = (int)(view.hasFocusable() ? 1 : 0);
            if (n10 != 0) {
                return recyclerView$ViewHolder2.itemView;
            }
            n12 += -1;
        }
        return null;
    }

    public static RecyclerView$ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((RecyclerView$LayoutParams)view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        Rect rect2 = recyclerView$LayoutParams.mDecorInsets;
        int n10 = view.getLeft();
        int n11 = rect2.left;
        n10 -= n11;
        n11 = recyclerView$LayoutParams.leftMargin;
        n10 -= n11;
        n11 = view.getTop();
        int n12 = rect2.top;
        n11 -= n12;
        n12 = recyclerView$LayoutParams.topMargin;
        n11 -= n12;
        n12 = view.getRight();
        int n13 = rect2.right;
        n12 += n13;
        n13 = recyclerView$LayoutParams.rightMargin;
        int n14 = view.getBottom();
        int n15 = rect2.bottom;
        n14 += n15;
        int n16 = recyclerView$LayoutParams.bottomMargin;
        rect.set(n10, n11, n12 += n13, n14 += n16);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int n10;
        int n11 = view.getId();
        while ((n10 = view.isFocused()) == 0 && (n10 = view instanceof ViewGroup) != 0 && (n10 = view.hasFocus()) != 0) {
            int n12;
            n10 = (view = ((ViewGroup)view).getFocusedChild()).getId();
            if (n10 == (n12 = -1)) continue;
            n11 = view.getId();
        }
        return n11;
    }

    private String getFullClassName(Context object, String string2) {
        char c10;
        CharSequence charSequence = null;
        char c11 = string2.charAt(0);
        if (c11 == (c10 = '.')) {
            charSequence = new StringBuilder();
            object = object.getPackageName();
            charSequence.append((String)object);
            charSequence.append(string2);
            return charSequence.toString();
        }
        object = ".";
        boolean bl2 = string2.contains((CharSequence)object);
        if (bl2) {
            return string2;
        }
        object = new StringBuilder();
        charSequence = RecyclerView.class.getPackage().getName();
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append(c10);
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mScrollingChildHelper;
        if (nestedScrollingChildHelper == null) {
            this.mScrollingChildHelper = nestedScrollingChildHelper = new NestedScrollingChildHelper((View)this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long l10, RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder object) {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            long l11;
            long l12;
            long l13;
            RecyclerView$ViewHolder recyclerView$ViewHolder2 = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(i10));
            if (recyclerView$ViewHolder2 == recyclerView$ViewHolder || (l13 = (l12 = (l11 = this.getChangedHolderKey(recyclerView$ViewHolder2)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) continue;
            Object object2 = this.mAdapter;
            String string2 = " \n View Holder 2:";
            if (object2 != null && (bl2 = ((RecyclerView$Adapter)object2).hasStableIds())) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                ((StringBuilder)object).append(recyclerView$ViewHolder2);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(recyclerView$ViewHolder);
                string2 = this.exceptionLabel();
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                object2 = new IllegalStateException(string2);
                throw object2;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
            ((StringBuilder)object).append(recyclerView$ViewHolder2);
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(recyclerView$ViewHolder);
            string2 = this.exceptionLabel();
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object2 = new IllegalStateException(string2);
            throw object2;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
        charSequence.append(object);
        charSequence.append(" cannot be found but it is necessary for ");
        charSequence.append(recyclerView$ViewHolder);
        String string3 = this.exceptionLabel();
        charSequence.append(string3);
        charSequence = charSequence.toString();
        Log.e((String)TAG, (String)charSequence);
    }

    private boolean hasUpdatedView() {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            boolean bl3;
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getChildAt(i10));
            if (recyclerView$ViewHolder == null || (bl3 = recyclerView$ViewHolder.shouldIgnore()) || !(bl2 = recyclerView$ViewHolder.isUpdated())) continue;
            return true;
        }
        return false;
    }

    private void initAutofill() {
        int n10 = ViewCompat.getImportantForAutofill((View)this);
        if (n10 == 0) {
            n10 = 8;
            ViewCompat.setImportantForAutofill((View)this, n10);
        }
    }

    private void initChildrenHelper() {
        ChildHelper childHelper;
        RecyclerView$5 recyclerView$5 = new RecyclerView$5(this);
        this.mChildHelper = childHelper = new ChildHelper(recyclerView$5);
    }

    private boolean isPreferredNextFocus(View object, View object2, int n10) {
        int n11 = 0;
        if (object2 != null && object2 != this && object2 != object) {
            int n12;
            int n13;
            int n14;
            int n15;
            View view = this.findContainingItemView((View)object2);
            if (view == null) {
                return false;
            }
            int n16 = 1;
            float f10 = Float.MIN_VALUE;
            if (object == null) {
                return n16 != 0;
            }
            View view2 = this.findContainingItemView((View)object);
            if (view2 == null) {
                return n16 != 0;
            }
            view2 = this.mTempRect;
            int n17 = object.getWidth();
            int n18 = object.getHeight();
            view2.set(0, 0, n17, n18);
            view2 = this.mTempRect2;
            n17 = object2.getWidth();
            n18 = object2.getHeight();
            view2.set(0, 0, n17, n18);
            view2 = this.mTempRect;
            this.offsetDescendantRectToMyCoords((View)object, (Rect)view2);
            object = this.mTempRect2;
            this.offsetDescendantRectToMyCoords((View)object2, (Rect)object);
            object = this.mLayout;
            int n19 = ((RecyclerView$LayoutManager)object).getLayoutDirection();
            int n20 = -1;
            n19 = n19 == n16 ? n20 : n16;
            view2 = this.mTempRect;
            n17 = view2.left;
            Rect rect = this.mTempRect2;
            int n21 = rect.left;
            n17 = (n17 < n21 || (n15 = view2.right) <= n21) && (n15 = view2.right) < (n14 = rect.right) ? n16 : (((n15 = view2.right) > (n14 = rect.right) || n17 >= n14) && n17 > n21 ? n20 : 0);
            n21 = view2.top;
            n15 = rect.top;
            if ((n21 < n15 || (n14 = view2.bottom) <= n15) && (n14 = view2.bottom) < (n13 = rect.bottom)) {
                n20 = n16;
            } else {
                n12 = view2.bottom;
                n18 = rect.bottom;
                if (n12 <= n18 && n21 < n18 || n21 <= n15) {
                    n20 = 0;
                    object2 = null;
                }
            }
            if (n10 != n16) {
                n12 = 2;
                if (n10 != n12) {
                    n19 = 17;
                    if (n10 != n19) {
                        n19 = 33;
                        if (n10 != n19) {
                            n19 = 66;
                            if (n10 != n19) {
                                n19 = 130;
                                if (n10 == n19) {
                                    if (n20 > 0) {
                                        n11 = n16;
                                    }
                                    return n11 != 0;
                                }
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("Invalid direction: ");
                                ((StringBuilder)object2).append(n10);
                                String string2 = this.exceptionLabel();
                                ((StringBuilder)object2).append(string2);
                                object2 = ((StringBuilder)object2).toString();
                                object = new IllegalArgumentException((String)object2);
                                throw object;
                            }
                            if (n17 > 0) {
                                n11 = n16;
                            }
                            return n11 != 0;
                        }
                        if (n20 < 0) {
                            n11 = n16;
                        }
                        return n11 != 0;
                    }
                    if (n17 < 0) {
                        n11 = n16;
                    }
                    return n11 != 0;
                }
                if (n20 > 0 || n20 == 0 && (n17 *= n19) > 0) {
                    n11 = n16;
                }
                return n11 != 0;
            }
            if (n20 < 0 || n20 == 0 && (n17 *= n19) < 0) {
                n11 = n16;
            }
        }
        return n11 != 0;
    }

    private void nestedScrollByInternal(int n10, int n11, MotionEvent object, int n12) {
        int[] nArray;
        int n13;
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null) {
            Log.e((String)TAG, (String)"Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        boolean bl2 = this.mLayoutSuppressed;
        if (bl2) {
            return;
        }
        Object object2 = this.mReusableIntPair;
        int n14 = 0;
        object2[0] = 0;
        int n15 = 1;
        object2[n15] = 0;
        int n16 = recyclerView$LayoutManager.canScrollHorizontally();
        object2 = this.mLayout;
        bl2 = ((RecyclerView$LayoutManager)object2).canScrollVertically();
        if (n16 != 0) {
            n13 = n15;
        } else {
            n13 = 0;
            nArray = null;
        }
        if (bl2) {
            n13 |= 2;
        }
        this.startNestedScroll(n13, n12);
        int n17 = n16 != 0 ? n10 : 0;
        int n18 = bl2 ? n11 : 0;
        int[] nArray2 = this.mReusableIntPair;
        int[] nArray3 = this.mScrollOffset;
        n13 = (int)(this.dispatchNestedPreScroll(n17, n18, nArray2, nArray3, n12) ? 1 : 0);
        if (n13 != 0) {
            nArray = this.mReusableIntPair;
            int n19 = nArray[0];
            n10 -= n19;
            n15 = nArray[n15];
            n11 -= n15;
        }
        if (n16 != 0) {
            n16 = n10;
        } else {
            n16 = 0;
            recyclerView$LayoutManager = null;
        }
        if (bl2) {
            n14 = n11;
        }
        this.scrollByInternal(n16, n14, (MotionEvent)object, n12);
        object = this.mGapWorker;
        if (object != null && (n10 != 0 || n11 != 0)) {
            ((GapWorker)object).postFromTraversal(this, n10, n11);
        }
        this.stopNestedScroll(n12);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getActionIndex();
        int n12 = motionEvent.getPointerId(n11);
        if (n12 == (n10 = this.mScrollPointerId)) {
            int n13;
            n11 = n11 == 0 ? 1 : 0;
            this.mScrollPointerId = n12 = motionEvent.getPointerId(n11);
            float f10 = motionEvent.getX(n11);
            n10 = 0x3F000000;
            float f11 = 0.5f;
            this.mLastTouchX = n12 = (int)(f10 += f11);
            this.mInitialTouchX = n12;
            float f12 = motionEvent.getY(n11) + f11;
            this.mLastTouchY = n13 = (int)f12;
            this.mInitialTouchY = n13;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        boolean bl2;
        Object object = this.mItemAnimator;
        if (object != null && (bl2 = ((RecyclerView$LayoutManager)(object = this.mLayout)).supportsPredictiveItemAnimations())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    private void processAdapterUpdatesAndSetAnimationFlags() {
        block9: {
            var1_1 = this.mDataSetHasChangedAfterLayout;
            if (var1_1) {
                var2_2 = this.mAdapterHelper;
                var2_2.reset();
                var1_1 = this.mDispatchItemsChangedEvent;
                if (var1_1) {
                    var2_2 = this.mLayout;
                    var2_2.onItemsChanged(this);
                }
            }
            if (var1_1 = this.predictiveItemAnimationsEnabled()) {
                var2_2 = this.mAdapterHelper;
                var2_2.preProcess();
            } else {
                var2_2 = this.mAdapterHelper;
                var2_2.consumeUpdatesInOnePass();
            }
            var1_1 = this.mItemsAddedOrRemoved;
            var3_3 = false;
            var4_4 = true;
            if (!var1_1 && !(var1_1 = this.mItemsChanged)) {
                var1_1 = false;
                var2_2 = null;
            } else {
                var1_1 = var4_4;
            }
            var5_5 = this.mState;
            var6_6 = this.mFirstLayoutComplete;
            if (!var6_6 || (var7_7 = this.mItemAnimator) == null) ** GOTO lbl-1000
            var6_6 = this.mDataSetHasChangedAfterLayout;
            if (var6_6 || var1_1) break block9;
            var8_8 = this.mLayout;
            var9_9 = var8_8.mRequestedSimpleAnimations;
            if (!var9_9) ** GOTO lbl-1000
        }
        if (!var6_6 || (var6_6 = (var7_7 = this.mAdapter).hasStableIds())) {
            var6_6 = var4_4;
        } else lbl-1000:
        // 3 sources

        {
            var6_6 = false;
            var7_7 = null;
        }
        var5_5.mRunSimpleAnimations = var6_6;
        var5_5 = this.mState;
        var6_6 = var5_5.mRunSimpleAnimations;
        if (var6_6 && var1_1 && !(var1_1 = this.mDataSetHasChangedAfterLayout) && (var1_1 = this.predictiveItemAnimationsEnabled())) {
            var3_3 = var4_4;
        }
        var5_5.mRunPredictiveAnimations = var3_3;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void pullGlows(float var1_1, float var2_2, float var3_3, float var4_4) {
        cfr_temp_0 = var2_2 - 0.0f;
        var5_5 /* !! */  = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1);
        var6_6 = 1065353216;
        var7_7 = 1.0f;
        var8_8 = true;
        var9_9 = 1.4E-45f;
        if (var5_5 /* !! */  < 0) {
            this.ensureLeftGlow();
            var10_10 = this.mLeftGlow;
            var11_12 = -var2_2;
            var12_13 = this.getWidth();
            var11_12 /= var12_13;
            var13_15 = this.getHeight();
            var12_13 = var13_15;
            var3_3 /= var12_13;
            var3_3 = var7_7 - var3_3;
            EdgeEffectCompat.onPull(var10_10, var11_12, var3_3);
lbl18:
            // 2 sources

            while (true) {
                var14_18 = var8_8;
                var3_3 = var9_9;
                break;
            }
        } else {
            cfr_temp_1 = var2_2 - 0.0f;
            var5_5 /* !! */  = (float)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
            if (var5_5 /* !! */  > 0) {
                this.ensureRightGlow();
                var10_11 = this.mRightGlow;
                var15_17 = this.getWidth();
                var11_12 = var15_17;
                var11_12 = var2_2 / var11_12;
                var13_16 = this.getHeight();
                var12_14 = var13_16;
                EdgeEffectCompat.onPull(var10_11, var11_12, var3_3 /= var12_14);
                ** continue;
            }
            var14_18 = false;
            var3_3 = 0.0f;
            var16_19 = null;
        }
        var5_5 /* !! */  = (cfr_temp_2 = var4_4 - 0.0f) == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1);
        if (var5_5 /* !! */  < 0) {
            this.ensureTopGlow();
            var16_19 = this.mTopGlow;
            var17_20 = -var4_4;
            var7_7 = this.getHeight();
            var17_20 /= var7_7;
            var6_6 = this.getWidth();
            var7_7 = var6_6;
            EdgeEffectCompat.onPull(var16_19, var17_20, var1_1 /= var7_7);
        } else {
            cfr_temp_3 = var4_4 - 0.0f;
            var5_5 /* !! */  = (float)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
            if (var5_5 /* !! */  > 0) {
                this.ensureBottomGlow();
                var16_19 = this.mBottomGlow;
                var5_5 /* !! */  = this.getHeight();
                var17_21 = var5_5 /* !! */ ;
                var17_21 = var4_4 / var17_21;
                var15_17 = this.getWidth();
                var11_12 = var15_17;
                EdgeEffectCompat.onPull(var16_19, var17_21, var7_7 -= (var1_1 /= var11_12));
            } else {
                var8_8 = var14_18;
                var9_9 = var3_3;
            }
        }
        if (var8_8 || (var18_22 = (cfr_temp_4 = var2_2 - 0.0f) == 0.0f ? 0 : (cfr_temp_4 > 0.0f ? 1 : -1)) != false || (var18_22 = (cfr_temp_5 = var4_4 - 0.0f) == 0.0f ? 0 : (cfr_temp_5 > 0.0f ? 1 : -1)) != false) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    private void recoverFocusFromState() {
        int n10;
        Object object;
        int n11 = this.mPreserveFocusAfterLayout;
        if (n11 != 0 && (object = this.mAdapter) != null && (n11 = this.hasFocus()) != 0 && (n11 = this.getDescendantFocusability()) != (n10 = 393216) && ((n11 = this.getDescendantFocusability()) != (n10 = 131072) || (n11 = (int)(this.isFocused() ? 1 : 0)) == 0)) {
            View view;
            ChildHelper childHelper;
            boolean bl2;
            long l10;
            Object object2;
            n11 = (int)(this.isFocused() ? 1 : 0);
            if (n11 == 0) {
                object = this.getFocusedChild();
                n10 = (int)(IGNORE_DETACHED_FOCUSED_CHILD ? 1 : 0);
                if (n10 != 0 && ((object2 = object.getParent()) == null || (n10 = (int)(object.hasFocus() ? 1 : 0)) == 0)) {
                    object = this.mChildHelper;
                    n11 = ((ChildHelper)object).getChildCount();
                    if (n11 == 0) {
                        this.requestFocus();
                        return;
                    }
                } else {
                    object2 = this.mChildHelper;
                    n11 = (int)(((ChildHelper)object2).isHidden((View)object) ? 1 : 0);
                    if (n11 == 0) {
                        return;
                    }
                }
            }
            object = this.mState;
            long l11 = ((RecyclerView$State)object).mFocusedItemId;
            long l12 = -1;
            n11 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
            n10 = 0;
            object2 = null;
            if (n11 != 0 && (n11 = (int)(((RecyclerView$Adapter)(object = this.mAdapter)).hasStableIds() ? 1 : 0)) != 0) {
                l10 = this.mState.mFocusedItemId;
                object = this.findViewHolderForItemId(l10);
            } else {
                n11 = 0;
                object = null;
            }
            if (object != null && !(bl2 = (childHelper = this.mChildHelper).isHidden(view = ((RecyclerView$ViewHolder)object).itemView)) && (bl2 = (childHelper = ((RecyclerView$ViewHolder)object).itemView).hasFocusable())) {
                object2 = ((RecyclerView$ViewHolder)object).itemView;
            } else {
                object = this.mChildHelper;
                n11 = ((ChildHelper)object).getChildCount();
                if (n11 > 0) {
                    object2 = this.findNextViewToFocus();
                }
            }
            if (object2 != null) {
                object = this.mState;
                n11 = ((RecyclerView$State)object).mFocusedSubChildId;
                l10 = n11;
                long l13 = l10 - l12;
                Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object3 != false && (object = object2.findViewById(n11)) != null && (object3 = (Object)object.isFocusable()) != false) {
                    object2 = object;
                }
                object2.requestFocus();
            }
        }
    }

    private void releaseGlows() {
        boolean bl2;
        boolean bl3;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            edgeEffect = this.mLeftGlow;
            bl3 = edgeEffect.isFinished();
        } else {
            bl3 = false;
            edgeEffect = null;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            edgeEffect2 = this.mTopGlow;
            bl2 = edgeEffect2.isFinished();
            bl3 |= bl2;
        }
        if ((edgeEffect2 = this.mRightGlow) != null) {
            edgeEffect2.onRelease();
            edgeEffect2 = this.mRightGlow;
            bl2 = edgeEffect2.isFinished();
            bl3 |= bl2;
        }
        if ((edgeEffect2 = this.mBottomGlow) != null) {
            edgeEffect2.onRelease();
            edgeEffect2 = this.mBottomGlow;
            bl2 = edgeEffect2.isFinished();
            bl3 |= bl2;
        }
        if (bl3) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        int n10;
        Object object = view2 != null ? view2 : view;
        Rect rect = this.mTempRect;
        int n11 = object.getWidth();
        int n12 = object.getHeight();
        rect.set(0, 0, n11, n12);
        object = object.getLayoutParams();
        boolean bl2 = object instanceof RecyclerView$LayoutParams;
        if (bl2) {
            object = (RecyclerView$LayoutParams)((Object)object);
            bl2 = object.mInsetsDirty;
            if (!bl2) {
                object = object.mDecorInsets;
                rect = this.mTempRect;
                n11 = rect.left;
                n12 = object.left;
                rect.left = n11 -= n12;
                n11 = rect.right;
                n12 = object.right;
                rect.right = n11 += n12;
                n11 = rect.top;
                n12 = object.top;
                rect.top = n11 -= n12;
                n11 = rect.bottom;
                n10 = object.bottom;
                rect.bottom = n11 += n10;
            }
        }
        if (view2 != null) {
            object = this.mTempRect;
            this.offsetDescendantRectToMyCoords(view2, (Rect)object);
            object = this.mTempRect;
            this.offsetRectIntoDescendantCoords(view, (Rect)object);
        }
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        Rect rect2 = this.mTempRect;
        n10 = this.mFirstLayoutComplete;
        bl2 = true;
        boolean bl3 = n10 ^ true;
        boolean bl4 = view2 == null ? bl2 : false;
        recyclerView$LayoutManager.requestChildRectangleOnScreen(this, view, rect2, bl3, bl4);
    }

    private void resetFocusInfo() {
        int n10;
        RecyclerView$State recyclerView$State = this.mState;
        recyclerView$State.mFocusedItemId = -1;
        recyclerView$State.mFocusedItemPosition = n10 = -1;
        recyclerView$State.mFocusedSubChildId = n10;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        this.stopNestedScroll(0);
        this.releaseGlows();
    }

    private void saveFocusInfo() {
        Object object;
        boolean bl2 = this.mPreserveFocusAfterLayout;
        int n10 = 0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = null;
        if (bl2 && (bl2 = this.hasFocus()) && (object = this.mAdapter) != null) {
            object = this.getFocusedChild();
        } else {
            bl2 = false;
            object = null;
        }
        if (object != null) {
            recyclerView$ViewHolder = this.findContainingViewHolder((View)object);
        }
        if (recyclerView$ViewHolder == null) {
            this.resetFocusInfo();
        } else {
            object = this.mState;
            RecyclerView$Adapter recyclerView$Adapter = this.mAdapter;
            int n11 = recyclerView$Adapter.hasStableIds();
            long l10 = n11 != 0 ? recyclerView$ViewHolder.getItemId() : (long)-1;
            ((RecyclerView$State)object).mFocusedItemId = l10;
            object = this.mState;
            n11 = this.mDataSetHasChangedAfterLayout;
            n11 = n11 != 0 ? -1 : ((n11 = (int)(recyclerView$ViewHolder.isRemoved() ? 1 : 0)) != 0 ? recyclerView$ViewHolder.mOldPosition : recyclerView$ViewHolder.getAbsoluteAdapterPosition());
            ((RecyclerView$State)object).mFocusedItemPosition = n11;
            object = this.mState;
            recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
            ((RecyclerView$State)object).mFocusedSubChildId = n10 = this.getDeepestFocusedViewWithId((View)recyclerView$ViewHolder);
        }
    }

    private void setAdapterInternal(RecyclerView$Adapter object, boolean bl2, boolean bl3) {
        Object object2 = this.mAdapter;
        if (object2 != null) {
            RecyclerView$RecyclerViewDataObserver recyclerView$RecyclerViewDataObserver = this.mObserver;
            ((RecyclerView$Adapter)object2).unregisterAdapterDataObserver(recyclerView$RecyclerViewDataObserver);
            object2 = this.mAdapter;
            ((RecyclerView$Adapter)object2).onDetachedFromRecyclerView(this);
        }
        if (!bl2 || bl3) {
            this.removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        RecyclerView$Adapter recyclerView$Adapter = this.mAdapter;
        this.mAdapter = object;
        if (object != null) {
            object2 = this.mObserver;
            ((RecyclerView$Adapter)object).registerAdapterDataObserver((RecyclerView$AdapterDataObserver)object2);
            ((RecyclerView$Adapter)object).onAttachedToRecyclerView(this);
        }
        if ((object = this.mLayout) != null) {
            object2 = this.mAdapter;
            ((RecyclerView$LayoutManager)object).onAdapterChanged(recyclerView$Adapter, (RecyclerView$Adapter)object2);
        }
        object = this.mRecycler;
        object2 = this.mAdapter;
        ((RecyclerView$Recycler)object).onAdapterChanged(recyclerView$Adapter, (RecyclerView$Adapter)object2, bl2);
        this.mState.mStructureChanged = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager != null) {
            recyclerView$LayoutManager.stopSmoothScroller();
        }
    }

    public void absorbGlows(int n10, int n11) {
        int n12;
        boolean bl2;
        EdgeEffect edgeEffect;
        if (n10 < 0) {
            this.ensureLeftGlow();
            edgeEffect = this.mLeftGlow;
            bl2 = edgeEffect.isFinished();
            if (bl2) {
                edgeEffect = this.mLeftGlow;
                n12 = -n10;
                edgeEffect.onAbsorb(n12);
            }
        } else if (n10 > 0) {
            this.ensureRightGlow();
            edgeEffect = this.mRightGlow;
            bl2 = edgeEffect.isFinished();
            if (bl2) {
                edgeEffect = this.mRightGlow;
                edgeEffect.onAbsorb(n10);
            }
        }
        if (n11 < 0) {
            this.ensureTopGlow();
            edgeEffect = this.mTopGlow;
            bl2 = edgeEffect.isFinished();
            if (bl2) {
                edgeEffect = this.mTopGlow;
                n12 = -n11;
                edgeEffect.onAbsorb(n12);
            }
        } else if (n11 > 0) {
            this.ensureBottomGlow();
            edgeEffect = this.mBottomGlow;
            bl2 = edgeEffect.isFinished();
            if (bl2) {
                edgeEffect = this.mBottomGlow;
                edgeEffect.onAbsorb(n11);
            }
        }
        if (n10 != 0 || n11 != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void addFocusables(ArrayList arrayList, int n10, int n11) {
        boolean bl2;
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null || !(bl2 = recyclerView$LayoutManager.onAddFocusables(this, arrayList, n10, n11))) {
            super.addFocusables(arrayList, n10, n11);
        }
    }

    public void addItemDecoration(RecyclerView$ItemDecoration recyclerView$ItemDecoration) {
        this.addItemDecoration(recyclerView$ItemDecoration, -1);
    }

    public void addItemDecoration(RecyclerView$ItemDecoration recyclerView$ItemDecoration, int n10) {
        boolean bl2;
        Object object = this.mLayout;
        if (object != null) {
            String string2 = "Cannot add item decoration during a scroll  or layout";
            ((RecyclerView$LayoutManager)object).assertNotInLayoutOrScroll(string2);
        }
        if (bl2 = ((ArrayList)(object = this.mItemDecorations)).isEmpty()) {
            bl2 = false;
            object = null;
            this.setWillNotDraw(false);
        }
        if (n10 < 0) {
            ArrayList arrayList = this.mItemDecorations;
            arrayList.add(recyclerView$ItemDecoration);
        } else {
            object = this.mItemDecorations;
            ((ArrayList)object).add(n10, recyclerView$ItemDecoration);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    public void addOnChildAttachStateChangeListener(RecyclerView$OnChildAttachStateChangeListener recyclerView$OnChildAttachStateChangeListener) {
        ArrayList arrayList = this.mOnChildAttachStateListeners;
        if (arrayList == null) {
            this.mOnChildAttachStateListeners = arrayList = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(recyclerView$OnChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(RecyclerView$OnItemTouchListener recyclerView$OnItemTouchListener) {
        this.mOnItemTouchListeners.add(recyclerView$OnItemTouchListener);
    }

    public void addOnScrollListener(RecyclerView$OnScrollListener recyclerView$OnScrollListener) {
        ArrayList arrayList = this.mScrollListeners;
        if (arrayList == null) {
            this.mScrollListeners = arrayList = new ArrayList();
        }
        this.mScrollListeners.add(recyclerView$OnScrollListener);
    }

    public void addRecyclerListener(RecyclerView$RecyclerListener recyclerView$RecyclerListener) {
        boolean bl2 = recyclerView$RecyclerListener != null;
        Preconditions.checkArgument(bl2, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(recyclerView$RecyclerListener);
    }

    public void animateAppearance(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        recyclerView$ViewHolder.setIsRecyclable(false);
        RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mItemAnimator;
        boolean bl2 = recyclerView$ItemAnimator.animateAppearance(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
        if (bl2) {
            this.postAnimationRunner();
        }
    }

    public void animateDisappearance(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        this.addAnimatingView(recyclerView$ViewHolder);
        recyclerView$ViewHolder.setIsRecyclable(false);
        RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mItemAnimator;
        boolean bl2 = recyclerView$ItemAnimator.animateDisappearance(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
        if (bl2) {
            this.postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String object) {
        boolean bl2 = this.isComputingLayout();
        if (!bl2) {
            if (object == null) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
                String string2 = this.exceptionLabel();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                object = new IllegalStateException((String)charSequence);
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = this.exceptionLabel();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
    }

    public void assertNotInLayoutOrScroll(String object) {
        boolean bl2 = this.isComputingLayout();
        if (bl2) {
            if (object == null) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
                String string2 = this.exceptionLabel();
                charSequence.append(string2);
                charSequence = charSequence.toString();
                object = new IllegalStateException((String)charSequence);
                throw object;
            }
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
        int n10 = this.mDispatchScrollCounter;
        if (n10 > 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string3 = this.exceptionLabel();
            charSequence.append(string3);
            charSequence = charSequence.toString();
            object = new IllegalStateException((String)charSequence);
            charSequence = TAG;
            string3 = "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.";
            Log.w((String)charSequence, (String)string3, (Throwable)object);
        }
    }

    public boolean canReuseUpdatedViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        List list;
        boolean bl2;
        RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mItemAnimator;
        if (recyclerView$ItemAnimator != null && !(bl2 = recyclerView$ItemAnimator.canReuseUpdatedViewHolder(recyclerView$ViewHolder, list = recyclerView$ViewHolder.getUnmodifiedPayloads()))) {
            bl2 = false;
            recyclerView$ViewHolder = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams object) {
        RecyclerView$LayoutManager recyclerView$LayoutManager;
        boolean bl2;
        boolean bl3 = object instanceof RecyclerView$LayoutParams;
        if (bl3 && (bl2 = (recyclerView$LayoutManager = this.mLayout).checkLayoutParams((RecyclerView$LayoutParams)((Object)(object = (RecyclerView$LayoutParams)((Object)object)))))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void clearOldPositions() {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            boolean bl2 = recyclerView$ViewHolder.shouldIgnore();
            if (bl2) continue;
            recyclerView$ViewHolder.clearOldPosition();
        }
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        int n10 = 0;
        RecyclerView$State recyclerView$State = null;
        if (recyclerView$LayoutManager == null) {
            return 0;
        }
        boolean bl2 = recyclerView$LayoutManager.canScrollHorizontally();
        if (bl2) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$State = this.mState;
            n10 = recyclerView$LayoutManager.computeHorizontalScrollExtent(recyclerView$State);
        }
        return n10;
    }

    public int computeHorizontalScrollOffset() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        int n10 = 0;
        RecyclerView$State recyclerView$State = null;
        if (recyclerView$LayoutManager == null) {
            return 0;
        }
        boolean bl2 = recyclerView$LayoutManager.canScrollHorizontally();
        if (bl2) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$State = this.mState;
            n10 = recyclerView$LayoutManager.computeHorizontalScrollOffset(recyclerView$State);
        }
        return n10;
    }

    public int computeHorizontalScrollRange() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        int n10 = 0;
        RecyclerView$State recyclerView$State = null;
        if (recyclerView$LayoutManager == null) {
            return 0;
        }
        boolean bl2 = recyclerView$LayoutManager.canScrollHorizontally();
        if (bl2) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$State = this.mState;
            n10 = recyclerView$LayoutManager.computeHorizontalScrollRange(recyclerView$State);
        }
        return n10;
    }

    public int computeVerticalScrollExtent() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        int n10 = 0;
        RecyclerView$State recyclerView$State = null;
        if (recyclerView$LayoutManager == null) {
            return 0;
        }
        boolean bl2 = recyclerView$LayoutManager.canScrollVertically();
        if (bl2) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$State = this.mState;
            n10 = recyclerView$LayoutManager.computeVerticalScrollExtent(recyclerView$State);
        }
        return n10;
    }

    public int computeVerticalScrollOffset() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        int n10 = 0;
        RecyclerView$State recyclerView$State = null;
        if (recyclerView$LayoutManager == null) {
            return 0;
        }
        boolean bl2 = recyclerView$LayoutManager.canScrollVertically();
        if (bl2) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$State = this.mState;
            n10 = recyclerView$LayoutManager.computeVerticalScrollOffset(recyclerView$State);
        }
        return n10;
    }

    public int computeVerticalScrollRange() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        int n10 = 0;
        RecyclerView$State recyclerView$State = null;
        if (recyclerView$LayoutManager == null) {
            return 0;
        }
        boolean bl2 = recyclerView$LayoutManager.canScrollVertically();
        if (bl2) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$State = this.mState;
            n10 = recyclerView$LayoutManager.computeVerticalScrollRange(recyclerView$State);
        }
        return n10;
    }

    public void considerReleasingGlowsOnScroll(int n10, int n11) {
        EdgeEffect edgeEffect;
        boolean bl2;
        int n12;
        EdgeEffect edgeEffect2 = this.mLeftGlow;
        if (edgeEffect2 != null && (n12 = edgeEffect2.isFinished()) == 0 && n10 > 0) {
            this.mLeftGlow.onRelease();
            edgeEffect2 = this.mLeftGlow;
            n12 = edgeEffect2.isFinished();
        } else {
            n12 = 0;
            edgeEffect2 = null;
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null && !(bl2 = edgeEffect3.isFinished()) && n10 < 0) {
            this.mRightGlow.onRelease();
            edgeEffect = this.mRightGlow;
            n10 = (int)(edgeEffect.isFinished() ? 1 : 0);
            n12 |= n10;
        }
        if ((edgeEffect = this.mTopGlow) != null && (n10 = (int)(edgeEffect.isFinished() ? 1 : 0)) == 0 && n11 > 0) {
            this.mTopGlow.onRelease();
            edgeEffect = this.mTopGlow;
            n10 = (int)(edgeEffect.isFinished() ? 1 : 0);
            n12 |= n10;
        }
        if ((edgeEffect = this.mBottomGlow) != null && (n10 = (int)(edgeEffect.isFinished() ? 1 : 0)) == 0 && n11 < 0) {
            this.mBottomGlow.onRelease();
            edgeEffect = this.mBottomGlow;
            n10 = (int)(edgeEffect.isFinished() ? 1 : 0);
            n12 |= n10;
        }
        if (n12 != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void consumePendingUpdateOperations() {
        boolean bl2 = this.mFirstLayoutComplete;
        String string2 = TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG;
        if (bl2 && !(bl2 = this.mDataSetHasChangedAfterLayout)) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            bl2 = adapterHelper.hasPendingUpdates();
            if (!bl2) {
                return;
            }
            adapterHelper = this.mAdapterHelper;
            int n10 = 4;
            bl2 = adapterHelper.hasAnyUpdateTypes(n10);
            if (bl2 && !(bl2 = (adapterHelper = this.mAdapterHelper).hasAnyUpdateTypes(n10 = 11))) {
                TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                this.startInterceptRequestLayout();
                this.onEnterLayoutOrScroll();
                adapterHelper = this.mAdapterHelper;
                adapterHelper.preProcess();
                bl2 = this.mLayoutWasDefered;
                if (!bl2) {
                    bl2 = this.hasUpdatedView();
                    if (bl2) {
                        this.dispatchLayout();
                    } else {
                        adapterHelper = this.mAdapterHelper;
                        adapterHelper.consumePostponedUpdates();
                    }
                }
                bl2 = true;
                this.stopInterceptRequestLayout(bl2);
                this.onExitLayoutOrScroll();
                TraceCompat.endSection();
            } else {
                adapterHelper = this.mAdapterHelper;
                bl2 = adapterHelper.hasPendingUpdates();
                if (bl2) {
                    TraceCompat.beginSection(string2);
                    this.dispatchLayout();
                    TraceCompat.endSection();
                }
            }
            return;
        }
        TraceCompat.beginSection(string2);
        this.dispatchLayout();
        TraceCompat.endSection();
    }

    public void defaultOnMeasure(int n10, int n11) {
        int n12 = this.getPaddingLeft();
        int n13 = this.getPaddingRight();
        n12 += n13;
        n13 = ViewCompat.getMinimumWidth((View)this);
        n10 = RecyclerView$LayoutManager.chooseSize(n10, n12, n13);
        n12 = this.getPaddingTop();
        n13 = this.getPaddingBottom();
        n12 += n13;
        n13 = ViewCompat.getMinimumHeight((View)this);
        n11 = RecyclerView$LayoutManager.chooseSize(n11, n12, n13);
        this.setMeasuredDimension(n10, n11);
    }

    public void dispatchChildAttached(View view) {
        Object object = RecyclerView.getChildViewHolderInt(view);
        this.onChildAttachedToWindow(view);
        Object object2 = this.mAdapter;
        if (object2 != null && object != null) {
            ((RecyclerView$Adapter)object2).onViewAttachedToWindow((RecyclerView$ViewHolder)object);
        }
        if ((object = this.mOnChildAttachStateListeners) != null) {
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                object2 = (RecyclerView$OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i10);
                object2.onChildViewAttachedToWindow(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        Object object = RecyclerView.getChildViewHolderInt(view);
        this.onChildDetachedFromWindow(view);
        Object object2 = this.mAdapter;
        if (object2 != null && object != null) {
            ((RecyclerView$Adapter)object2).onViewDetachedFromWindow((RecyclerView$ViewHolder)object);
        }
        if ((object = this.mOnChildAttachStateListeners) != null) {
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                object2 = (RecyclerView$OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i10);
                object2.onChildViewDetachedFromWindow(view);
            }
        }
    }

    public void dispatchLayout() {
        int n10;
        Object object = this.mAdapter;
        Object object2 = TAG;
        if (object == null) {
            Log.w((String)object2, (String)"No adapter attached; skipping layout");
            return;
        }
        object = this.mLayout;
        if (object == null) {
            Log.e((String)object2, (String)"No layout manager attached; skipping layout");
            return;
        }
        object = this.mState;
        int n11 = 0;
        object2 = null;
        ((RecyclerView$State)object).mIsMeasuring = false;
        int n12 = this.mLastAutoMeasureSkippedDueToExact;
        int n13 = 1;
        if (n12 != 0 && ((n12 = this.mLastAutoMeasureNonExactMeasuredWidth) != (n10 = this.getWidth()) || (n12 = this.mLastAutoMeasureNonExactMeasuredHeight) != (n10 = this.getHeight()))) {
            n12 = n13;
        } else {
            n12 = 0;
            object = null;
        }
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        object2 = this.mState;
        n11 = ((RecyclerView$State)object2).mLayoutStep;
        if (n11 == n13) {
            this.dispatchLayoutStep1();
            object = this.mLayout;
            ((RecyclerView$LayoutManager)object).setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
        } else {
            object2 = this.mAdapterHelper;
            n11 = (int)(((AdapterHelper)object2).hasUpdates() ? 1 : 0);
            if (n11 == 0 && n12 == 0 && (n12 = ((RecyclerView$LayoutManager)(object = this.mLayout)).getWidth()) == (n11 = this.getWidth()) && (n12 = ((RecyclerView$LayoutManager)(object = this.mLayout)).getHeight()) == (n11 = this.getHeight())) {
                object = this.mLayout;
                ((RecyclerView$LayoutManager)object).setExactMeasureSpecsFrom(this);
            } else {
                object = this.mLayout;
                ((RecyclerView$LayoutManager)object).setExactMeasureSpecsFrom(this);
                this.dispatchLayoutStep2();
            }
        }
        this.dispatchLayoutStep3();
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean bl2) {
        return this.getScrollingChildHelper().dispatchNestedFling(f10, f11, bl2);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.getScrollingChildHelper().dispatchNestedPreFling(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2) {
        return this.getScrollingChildHelper().dispatchNestedPreScroll(n10, n11, nArray, nArray2);
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2, int n12) {
        return this.getScrollingChildHelper().dispatchNestedPreScroll(n10, n11, nArray, nArray2, n12);
    }

    public final void dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray, int n14, int[] nArray2) {
        this.getScrollingChildHelper().dispatchNestedScroll(n10, n11, n12, n13, nArray, n14, nArray2);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray) {
        return this.getScrollingChildHelper().dispatchNestedScroll(n10, n11, n12, n13, nArray);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray, int n14) {
        return this.getScrollingChildHelper().dispatchNestedScroll(n10, n11, n12, n13, nArray, n14);
    }

    public void dispatchOnScrollStateChanged(int n10) {
        Object object = this.mLayout;
        if (object != null) {
            ((RecyclerView$LayoutManager)object).onScrollStateChanged(n10);
        }
        this.onScrollStateChanged(n10);
        object = this.mScrollListener;
        if (object != null) {
            ((RecyclerView$OnScrollListener)object).onScrollStateChanged(this, n10);
        }
        if ((object = this.mScrollListeners) != null) {
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                RecyclerView$OnScrollListener recyclerView$OnScrollListener = (RecyclerView$OnScrollListener)this.mScrollListeners.get(i10);
                recyclerView$OnScrollListener.onScrollStateChanged(this, n10);
            }
        }
    }

    public void dispatchOnScrolled(int n10, int n11) {
        int n12;
        this.mDispatchScrollCounter = n12 = this.mDispatchScrollCounter + 1;
        n12 = this.getScrollX();
        int n13 = this.getScrollY();
        int n14 = n12 - n10;
        int n15 = n13 - n11;
        this.onScrollChanged(n12, n13, n14, n15);
        this.onScrolled(n10, n11);
        Object object = this.mScrollListener;
        if (object != null) {
            ((RecyclerView$OnScrollListener)object).onScrolled(this, n10, n11);
        }
        if ((object = this.mScrollListeners) != null) {
            for (n12 = object.size() + -1; n12 >= 0; n12 += -1) {
                RecyclerView$OnScrollListener recyclerView$OnScrollListener = (RecyclerView$OnScrollListener)this.mScrollListeners.get(n12);
                recyclerView$OnScrollListener.onScrolled(this, n10, n11);
            }
        }
        this.mDispatchScrollCounter = n10 = this.mDispatchScrollCounter + -1;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        List list = this.mPendingAccessibilityImportanceChange;
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            int n10;
            int n11;
            RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)this.mPendingAccessibilityImportanceChange.get(i10);
            ViewParent viewParent = recyclerView$ViewHolder.itemView.getParent();
            if (viewParent != this || (n11 = recyclerView$ViewHolder.shouldIgnore()) != 0 || (n11 = recyclerView$ViewHolder.mPendingAccessibilityState) == (n10 = -1)) continue;
            View view = recyclerView$ViewHolder.itemView;
            ViewCompat.setImportantForAccessibility(view, n11);
            recyclerView$ViewHolder.mPendingAccessibilityState = n10;
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        this.onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }

    public void dispatchSaveInstanceState(SparseArray sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas object) {
        int n10;
        int n11;
        float f10;
        int n12;
        float f11;
        int n13;
        int n14;
        RecyclerView$State recyclerView$State;
        RecyclerView$ItemDecoration recyclerView$ItemDecoration;
        int n15;
        super.draw((Canvas)object);
        ArrayList arrayList = this.mItemDecorations;
        int n16 = arrayList.size();
        int n17 = 0;
        float f12 = 0.0f;
        for (n15 = 0; n15 < n16; ++n15) {
            recyclerView$ItemDecoration = (RecyclerView$ItemDecoration)this.mItemDecorations.get(n15);
            recyclerView$State = this.mState;
            recyclerView$ItemDecoration.onDrawOver((Canvas)object, this, recyclerView$State);
        }
        arrayList = this.mLeftGlow;
        n15 = 1;
        f12 = Float.MIN_VALUE;
        if (arrayList != null && (n16 = (int)(arrayList.isFinished() ? 1 : 0)) == 0) {
            float f13;
            n16 = object.save();
            n14 = this.mClipToPadding;
            if (n14 != 0) {
                n14 = this.getPaddingBottom();
            } else {
                n14 = 0;
                recyclerView$ItemDecoration = null;
                f13 = 0.0f;
            }
            object.rotate(270.0f);
            f13 = -this.getHeight() + n14;
            n13 = 0;
            f11 = 0.0f;
            recyclerView$State = null;
            object.translate(f13, 0.0f);
            recyclerView$ItemDecoration = this.mLeftGlow;
            if (recyclerView$ItemDecoration != null && (n14 = (int)(recyclerView$ItemDecoration.draw((Canvas)object) ? 1 : 0)) != 0) {
                n14 = n15;
                f13 = f12;
            } else {
                n14 = 0;
                recyclerView$ItemDecoration = null;
                f13 = 0.0f;
            }
            object.restoreToCount(n16);
        } else {
            n14 = 0;
            recyclerView$ItemDecoration = null;
            float f14 = 0.0f;
        }
        arrayList = this.mTopGlow;
        if (arrayList != null && (n16 = (int)(arrayList.isFinished() ? 1 : 0)) == 0) {
            n16 = object.save();
            n13 = this.mClipToPadding;
            if (n13 != 0) {
                n13 = this.getPaddingLeft();
                f11 = n13;
                n12 = this.getPaddingTop();
                f10 = n12;
                object.translate(f11, f10);
            }
            if ((recyclerView$State = this.mTopGlow) != null && (n13 = (int)(recyclerView$State.draw((Canvas)object) ? 1 : 0)) != 0) {
                n13 = n15;
                f11 = f12;
            } else {
                n13 = 0;
                recyclerView$State = null;
                f11 = 0.0f;
            }
            n14 |= n13;
            object.restoreToCount(n16);
        }
        if ((arrayList = this.mRightGlow) != null && (n16 = (int)(arrayList.isFinished() ? 1 : 0)) == 0) {
            n16 = object.save();
            n13 = this.getWidth();
            n12 = this.mClipToPadding;
            if (n12 != 0) {
                n12 = this.getPaddingTop();
            } else {
                n12 = 0;
                f10 = 0.0f;
            }
            n11 = 1119092736;
            float f15 = 90.0f;
            object.rotate(f15);
            f10 = n12;
            n13 = -n13;
            f11 = n13;
            object.translate(f10, f11);
            recyclerView$State = this.mRightGlow;
            if (recyclerView$State != null && (n13 = (int)(recyclerView$State.draw((Canvas)object) ? 1 : 0)) != 0) {
                n13 = n15;
                f11 = f12;
            } else {
                n13 = 0;
                recyclerView$State = null;
                f11 = 0.0f;
            }
            n14 |= n13;
            object.restoreToCount(n16);
        }
        if ((arrayList = this.mBottomGlow) != null && (n16 = (int)(arrayList.isFinished() ? 1 : 0)) == 0) {
            n16 = object.save();
            f11 = 180.0f;
            object.rotate(f11);
            n13 = (int)(this.mClipToPadding ? 1 : 0);
            if (n13 != 0) {
                n13 = -this.getWidth();
                n12 = this.getPaddingRight();
                f11 = n13 += n12;
                n12 = -this.getHeight();
                n11 = this.getPaddingBottom();
                f10 = n12 += n11;
                object.translate(f11, f10);
            } else {
                n13 = -this.getWidth();
                f11 = n13;
                n12 = -this.getHeight();
                f10 = n12;
                object.translate(f11, f10);
            }
            recyclerView$State = this.mBottomGlow;
            if (recyclerView$State != null && (n13 = (int)(recyclerView$State.draw((Canvas)object) ? 1 : 0)) != 0) {
                n17 = n15;
            }
            n14 |= n17;
            object.restoreToCount(n16);
        }
        if (n14 != 0 || (object = this.mItemAnimator) == null || (n10 = ((ArrayList)(object = this.mItemDecorations)).size()) <= 0 || (n10 = (int)(((RecyclerView$ItemAnimator)(object = this.mItemAnimator)).isRunning() ? 1 : 0)) == 0) {
            n15 = n14;
        }
        if (n15 != 0) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l10) {
        return super.drawChild(canvas, view, l10);
    }

    public void ensureBottomGlow() {
        EdgeEffect edgeEffect = this.mBottomGlow;
        if (edgeEffect != null) {
            return;
        }
        this.mBottomGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        int n10 = this.mClipToPadding;
        if (n10 != 0) {
            n10 = this.getMeasuredWidth();
            int n11 = this.getPaddingLeft();
            n10 -= n11;
            n11 = this.getPaddingRight();
            n10 -= n11;
            n11 = this.getMeasuredHeight();
            int n12 = this.getPaddingTop();
            n11 -= n12;
            n12 = this.getPaddingBottom();
            edgeEffect.setSize(n10, n11 -= n12);
        } else {
            n10 = this.getMeasuredWidth();
            int n13 = this.getMeasuredHeight();
            edgeEffect.setSize(n10, n13);
        }
    }

    public void ensureLeftGlow() {
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            return;
        }
        this.mLeftGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        int n10 = this.mClipToPadding;
        if (n10 != 0) {
            n10 = this.getMeasuredHeight();
            int n11 = this.getPaddingTop();
            n10 -= n11;
            n11 = this.getPaddingBottom();
            n10 -= n11;
            n11 = this.getMeasuredWidth();
            int n12 = this.getPaddingLeft();
            n11 -= n12;
            n12 = this.getPaddingRight();
            edgeEffect.setSize(n10, n11 -= n12);
        } else {
            n10 = this.getMeasuredHeight();
            int n13 = this.getMeasuredWidth();
            edgeEffect.setSize(n10, n13);
        }
    }

    public void ensureRightGlow() {
        EdgeEffect edgeEffect = this.mRightGlow;
        if (edgeEffect != null) {
            return;
        }
        this.mRightGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        int n10 = this.mClipToPadding;
        if (n10 != 0) {
            n10 = this.getMeasuredHeight();
            int n11 = this.getPaddingTop();
            n10 -= n11;
            n11 = this.getPaddingBottom();
            n10 -= n11;
            n11 = this.getMeasuredWidth();
            int n12 = this.getPaddingLeft();
            n11 -= n12;
            n12 = this.getPaddingRight();
            edgeEffect.setSize(n10, n11 -= n12);
        } else {
            n10 = this.getMeasuredHeight();
            int n13 = this.getMeasuredWidth();
            edgeEffect.setSize(n10, n13);
        }
    }

    public void ensureTopGlow() {
        EdgeEffect edgeEffect = this.mTopGlow;
        if (edgeEffect != null) {
            return;
        }
        this.mTopGlow = edgeEffect = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        int n10 = this.mClipToPadding;
        if (n10 != 0) {
            n10 = this.getMeasuredWidth();
            int n11 = this.getPaddingLeft();
            n10 -= n11;
            n11 = this.getPaddingRight();
            n10 -= n11;
            n11 = this.getMeasuredHeight();
            int n12 = this.getPaddingTop();
            n11 -= n12;
            n12 = this.getPaddingBottom();
            edgeEffect.setSize(n10, n11 -= n12);
        } else {
            n10 = this.getMeasuredWidth();
            int n13 = this.getMeasuredHeight();
            edgeEffect.setSize(n10, n13);
        }
    }

    public String exceptionLabel() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", adapter:");
        object = this.mAdapter;
        stringBuilder.append(object);
        stringBuilder.append(", layout:");
        object = this.mLayout;
        stringBuilder.append(object);
        stringBuilder.append(", context:");
        object = this.getContext();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    public final void fillRemainingScrollValues(RecyclerView$State recyclerView$State) {
        int n10;
        int n11 = this.getScrollState();
        if (n11 == (n10 = 2)) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            n10 = overScroller.getFinalX();
            int n12 = overScroller.getCurrX();
            recyclerView$State.mRemainingScrollHorizontal = n10 -= n12;
            n10 = overScroller.getFinalY();
            n11 = overScroller.getCurrY();
            recyclerView$State.mRemainingScrollVertical = n10 -= n11;
        } else {
            n11 = 0;
            Object var4_5 = null;
            recyclerView$State.mRemainingScrollHorizontal = 0;
            recyclerView$State.mRemainingScrollVertical = 0;
        }
    }

    public View findChildViewUnder(float f10, float f11) {
        ChildHelper childHelper = this.mChildHelper;
        for (int i10 = childHelper.getChildCount() + -1; i10 >= 0; i10 += -1) {
            float f12;
            float f13;
            float f14;
            float f15;
            View view = this.mChildHelper.getChildAt(i10);
            float f16 = view.getTranslationX();
            float f17 = view.getTranslationY();
            float f18 = (float)view.getLeft() + f16;
            float f19 = f10 - f18;
            Object object = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
            if (object < 0 || (f15 = (f14 = f10 - (f18 = (float)(object = (Object)view.getRight()) + f16)) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1)) > 0 || (f15 = (f13 = f11 - (f16 = (float)view.getTop() + f17)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) < 0 || (f15 = (f12 = f11 - (f16 = (float)view.getBottom() + f17)) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) > 0) continue;
            return view;
        }
        return null;
    }

    public View findContainingItemView(View view) {
        boolean bl2;
        ViewParent viewParent = view.getParent();
        while (viewParent != null && viewParent != this && (bl2 = viewParent instanceof View)) {
            view = viewParent;
            view = (View)viewParent;
            viewParent = view.getParent();
        }
        if (viewParent != this) {
            view = null;
        }
        return view;
    }

    public RecyclerView$ViewHolder findContainingViewHolder(View object) {
        object = (object = this.findContainingItemView((View)object)) == null ? null : this.getChildViewHolder((View)object);
        return object;
    }

    public RecyclerView$ViewHolder findViewHolderForAdapterPosition(int n10) {
        int n11 = this.mDataSetHasChangedAfterLayout;
        boolean bl2 = false;
        Object object = null;
        if (n11 != 0) {
            return null;
        }
        ChildHelper childHelper = this.mChildHelper;
        n11 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            if (recyclerView$ViewHolder == null || (n12 = recyclerView$ViewHolder.isRemoved()) != 0 || (n12 = this.getAdapterPositionInRecyclerView(recyclerView$ViewHolder)) != n10) continue;
            object = this.mChildHelper;
            View view = recyclerView$ViewHolder.itemView;
            bl2 = ((ChildHelper)object).isHidden(view);
            if (bl2) {
                object = recyclerView$ViewHolder;
                continue;
            }
            return recyclerView$ViewHolder;
        }
        return object;
    }

    public RecyclerView$ViewHolder findViewHolderForItemId(long l10) {
        int n10;
        Object object = this.mAdapter;
        boolean bl2 = false;
        Object object2 = null;
        if (object != null && (n10 = ((RecyclerView$Adapter)object).hasStableIds()) != 0) {
            object = this.mChildHelper;
            n10 = ((ChildHelper)object).getUnfilteredChildCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                long l11;
                long l12;
                boolean bl3;
                RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
                if (recyclerView$ViewHolder == null || (bl3 = recyclerView$ViewHolder.isRemoved()) || (bl3 = (l12 = (l11 = recyclerView$ViewHolder.getItemId()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) continue;
                object2 = this.mChildHelper;
                View view = recyclerView$ViewHolder.itemView;
                bl2 = ((ChildHelper)object2).isHidden(view);
                if (bl2) {
                    object2 = recyclerView$ViewHolder;
                    continue;
                }
                return recyclerView$ViewHolder;
            }
        }
        return object2;
    }

    public RecyclerView$ViewHolder findViewHolderForLayoutPosition(int n10) {
        return this.findViewHolderForPosition(n10, false);
    }

    public RecyclerView$ViewHolder findViewHolderForPosition(int n10) {
        return this.findViewHolderForPosition(n10, false);
    }

    public RecyclerView$ViewHolder findViewHolderForPosition(int n10, boolean bl2) {
        ChildHelper childHelper = this.mChildHelper;
        int n11 = childHelper.getUnfilteredChildCount();
        boolean bl3 = false;
        Object object = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            if (recyclerView$ViewHolder == null || (n12 = recyclerView$ViewHolder.isRemoved()) != 0 || (!bl2 ? (n12 = recyclerView$ViewHolder.getLayoutPosition()) != n10 : (n12 = recyclerView$ViewHolder.mPosition) != n10)) continue;
            object = this.mChildHelper;
            View view = recyclerView$ViewHolder.itemView;
            bl3 = ((ChildHelper)object).isHidden(view);
            if (bl3) {
                object = recyclerView$ViewHolder;
                continue;
            }
            return recyclerView$ViewHolder;
        }
        return object;
    }

    public boolean fling(int n10, int n11) {
        int n12;
        int n13;
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        int n14 = 0;
        if (recyclerView$LayoutManager == null) {
            Log.e((String)TAG, (String)"Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        boolean bl2 = this.mLayoutSuppressed;
        if (bl2) {
            return false;
        }
        int n15 = recyclerView$LayoutManager.canScrollHorizontally();
        RecyclerView$LayoutManager recyclerView$LayoutManager2 = this.mLayout;
        bl2 = recyclerView$LayoutManager2.canScrollVertically();
        if (n15 == 0 || (n13 = Math.abs(n10)) < (n12 = this.mMinFlingVelocity)) {
            n10 = 0;
        }
        if (!bl2 || (n13 = Math.abs(n11)) < (n12 = this.mMinFlingVelocity)) {
            n11 = 0;
        }
        if (n10 == 0 && n11 == 0) {
            return false;
        }
        float f10 = n10;
        float f11 = n11;
        int n16 = this.dispatchNestedPreFling(f10, f11);
        if (!n16) {
            n16 = 1;
            int n17 = n15 == 0 && !bl2 ? 0 : n16;
            this.dispatchNestedFling(f10, f11, n17 != 0);
            RecyclerView$OnFlingListener recyclerView$OnFlingListener = this.mOnFlingListener;
            if (recyclerView$OnFlingListener != null && (n13 = (int)(recyclerView$OnFlingListener.onFling(n10, n11) ? 1 : 0)) != 0) {
                return n16 != 0;
            }
            if (n17) {
                if (n15 != 0) {
                    n14 = n16;
                }
                if (bl2) {
                    n14 |= 2;
                }
                this.startNestedScroll(n14, n16);
                n15 = this.mMaxFlingVelocity;
                n14 = -n15;
                n10 = Math.min(n10, n15);
                n10 = Math.max(n14, n10);
                n15 = this.mMaxFlingVelocity;
                n14 = -n15;
                n11 = Math.min(n11, n15);
                n11 = Math.max(n14, n11);
                this.mViewFlinger.fling(n10, n11);
                return n16 != 0;
            }
        }
        return false;
    }

    public View focusSearch(View view, int n10) {
        Object object;
        int n11;
        int n12;
        Object object2 = this.mLayout.onInterceptFocusSearch(view, n10);
        if (object2 != null) {
            return object2;
        }
        object2 = this.mAdapter;
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        if (object2 != null && (object2 = this.mLayout) != null && (n12 = this.isComputingLayout()) == 0 && (n12 = this.mLayoutSuppressed) == 0) {
            n12 = n13;
        } else {
            n12 = 0;
            object2 = null;
        }
        Object object3 = FocusFinder.getInstance();
        if (n12 != 0 && (n10 == (n11 = 2) || n10 == n13)) {
            RecyclerView$State recyclerView$State;
            int n14;
            object2 = this.mLayout;
            n12 = (int)(((RecyclerView$LayoutManager)object2).canScrollVertically() ? 1 : 0);
            if (n12 != 0) {
                n12 = n10 == n11 ? 130 : 33;
                View view2 = object3.findNextFocus((ViewGroup)this, view, n12);
                if (view2 == null) {
                    n14 = n13;
                } else {
                    n14 = 0;
                    view2 = null;
                }
                boolean bl2 = FORCE_ABS_FOCUS_SEARCH_DIRECTION;
                if (bl2) {
                    n10 = n12;
                }
            } else {
                n14 = 0;
                Object var9_10 = null;
            }
            if (n14 == 0 && (n12 = (int)(((RecyclerView$LayoutManager)(object2 = this.mLayout)).canScrollHorizontally() ? 1 : 0)) != 0) {
                object2 = this.mLayout;
                n12 = ((RecyclerView$LayoutManager)object2).getLayoutDirection();
                if (n12 == n13) {
                    n12 = n13;
                } else {
                    n12 = 0;
                    object2 = null;
                }
                if (n10 == n11) {
                    n11 = n13;
                } else {
                    n11 = 0;
                    recyclerView$State = null;
                }
                n12 = (n12 ^= n11) != 0 ? 66 : 17;
                recyclerView$State = object3.findNextFocus((ViewGroup)this, view, n12);
                if (recyclerView$State != null) {
                    n13 = 0;
                    object = null;
                    f10 = 0.0f;
                }
                n11 = (int)(FORCE_ABS_FOCUS_SEARCH_DIRECTION ? 1 : 0);
                if (n11 != 0) {
                    n10 = n12;
                }
                n14 = n13;
            }
            if (n14 != 0) {
                this.consumePendingUpdateOperations();
                object2 = this.findContainingItemView(view);
                if (object2 == null) {
                    return null;
                }
                this.startInterceptRequestLayout();
                object2 = this.mLayout;
                object = this.mRecycler;
                recyclerView$State = this.mState;
                ((RecyclerView$LayoutManager)object2).onFocusSearchFailed(view, n10, (RecyclerView$Recycler)object, recyclerView$State);
                this.stopInterceptRequestLayout(false);
            }
            object2 = object3.findNextFocus((ViewGroup)this, view, n10);
        } else {
            object = object3.findNextFocus((ViewGroup)this, view, n10);
            if (object == null && n12 != 0) {
                this.consumePendingUpdateOperations();
                object2 = this.findContainingItemView(view);
                if (object2 == null) {
                    return null;
                }
                this.startInterceptRequestLayout();
                object2 = this.mLayout;
                object = this.mRecycler;
                object3 = this.mState;
                object2 = ((RecyclerView$LayoutManager)object2).onFocusSearchFailed(view, n10, (RecyclerView$Recycler)object, (RecyclerView$State)object3);
                this.stopInterceptRequestLayout(false);
            } else {
                object2 = object;
            }
        }
        if (object2 != null && (n13 = (int)(object2.hasFocusable() ? 1 : 0)) == 0) {
            object = this.getFocusedChild();
            if (object == null) {
                return super.focusSearch(view, n10);
            }
            this.requestChildOnScreen((View)object2, null);
            return view;
        }
        n13 = (int)(this.isPreferredNextFocus(view, (View)object2, n10) ? 1 : 0);
        if (n13 == 0) {
            object2 = super.focusSearch(view, n10);
        }
        return object2;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        Object object = this.mLayout;
        if (object != null) {
            return ((RecyclerView$LayoutManager)object).generateDefaultLayoutParams();
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("RecyclerView has no LayoutManager");
        String string2 = this.exceptionLabel();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet object) {
        Object object2 = this.mLayout;
        if (object2 != null) {
            Context context = this.getContext();
            return ((RecyclerView$LayoutManager)object2).generateLayoutParams(context, (AttributeSet)object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("RecyclerView has no LayoutManager");
        String string2 = this.exceptionLabel();
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        Object object2 = this.mLayout;
        if (object2 != null) {
            return ((RecyclerView$LayoutManager)object2).generateLayoutParams((ViewGroup.LayoutParams)object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("RecyclerView has no LayoutManager");
        String string2 = this.exceptionLabel();
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public RecyclerView$Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean bl2 = recyclerView$ViewHolder.hasAnyOfTheFlags(524);
        if (!bl2 && (bl2 = recyclerView$ViewHolder.isBound())) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            int n10 = recyclerView$ViewHolder.mPosition;
            return adapterHelper.applyPendingUpdatesToPosition(n10);
        }
        return -1;
    }

    public int getBaseline() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager != null) {
            return recyclerView$LayoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        long l10;
        RecyclerView$Adapter recyclerView$Adapter = this.mAdapter;
        boolean bl2 = recyclerView$Adapter.hasStableIds();
        if (bl2) {
            l10 = recyclerView$ViewHolder.getItemId();
        } else {
            int n10 = recyclerView$ViewHolder.mPosition;
            l10 = n10;
        }
        return l10;
    }

    public int getChildAdapterPosition(View object) {
        int n10 = (object = RecyclerView.getChildViewHolderInt((View)object)) != null ? ((RecyclerView$ViewHolder)object).getAbsoluteAdapterPosition() : -1;
        return n10;
    }

    public int getChildDrawingOrder(int n10, int n11) {
        RecyclerView$ChildDrawingOrderCallback recyclerView$ChildDrawingOrderCallback = this.mChildDrawingOrderCallback;
        if (recyclerView$ChildDrawingOrderCallback == null) {
            return super.getChildDrawingOrder(n10, n11);
        }
        return recyclerView$ChildDrawingOrderCallback.onGetChildDrawingOrder(n10, n11);
    }

    public long getChildItemId(View object) {
        boolean bl2;
        RecyclerView$Adapter recyclerView$Adapter = this.mAdapter;
        long l10 = -1;
        if (recyclerView$Adapter != null && (bl2 = recyclerView$Adapter.hasStableIds()) && (object = RecyclerView.getChildViewHolderInt((View)object)) != null) {
            l10 = ((RecyclerView$ViewHolder)object).getItemId();
        }
        return l10;
    }

    public int getChildLayoutPosition(View object) {
        int n10 = (object = RecyclerView.getChildViewHolderInt((View)object)) != null ? ((RecyclerView$ViewHolder)object).getLayoutPosition() : -1;
        return n10;
    }

    public int getChildPosition(View view) {
        return this.getChildAdapterPosition(view);
    }

    public RecyclerView$ViewHolder getChildViewHolder(View object) {
        Object object2 = object.getParent();
        if (object2 != null && object2 != this) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View ");
            stringBuilder.append(object);
            stringBuilder.append(" is not a direct child of ");
            stringBuilder.append(this);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        return RecyclerView.getChildViewHolderInt(object);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public RecyclerView$EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public RecyclerView$ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        boolean bl2 = recyclerView$LayoutParams.mInsetsDirty;
        if (!bl2) {
            return recyclerView$LayoutParams.mDecorInsets;
        }
        RecyclerView$State recyclerView$State = this.mState;
        bl2 = recyclerView$State.isPreLayout();
        if (bl2 && ((bl2 = recyclerView$LayoutParams.isItemChanged()) || (bl2 = recyclerView$LayoutParams.isViewInvalid()))) {
            return recyclerView$LayoutParams.mDecorInsets;
        }
        recyclerView$State = recyclerView$LayoutParams.mDecorInsets;
        recyclerView$State.set(0, 0, 0, 0);
        ArrayList arrayList = this.mItemDecorations;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            this.mTempRect.set(0, 0, 0, 0);
            RecyclerView$ItemDecoration recyclerView$ItemDecoration = (RecyclerView$ItemDecoration)this.mItemDecorations.get(i10);
            Rect rect = this.mTempRect;
            RecyclerView$State recyclerView$State2 = this.mState;
            recyclerView$ItemDecoration.getItemOffsets(rect, view, this, recyclerView$State2);
            int n11 = ((Rect)recyclerView$State).left;
            rect = this.mTempRect;
            int n12 = rect.left;
            ((Rect)recyclerView$State).left = n11 += n12;
            n11 = ((Rect)recyclerView$State).top;
            n12 = rect.top;
            ((Rect)recyclerView$State).top = n11 += n12;
            n11 = ((Rect)recyclerView$State).right;
            n12 = rect.right;
            ((Rect)recyclerView$State).right = n11 += n12;
            n11 = ((Rect)recyclerView$State).bottom;
            int n13 = rect.bottom;
            ((Rect)recyclerView$State).bottom = n11 += n13;
        }
        recyclerView$LayoutParams.mInsetsDirty = false;
        return recyclerView$State;
    }

    public RecyclerView$ItemDecoration getItemDecorationAt(int n10) {
        int n11 = this.getItemDecorationCount();
        if (n10 >= 0 && n10 < n11) {
            return (RecyclerView$ItemDecoration)this.mItemDecorations.get(n10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public RecyclerView$LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        boolean bl2 = ALLOW_THREAD_GAP_WORK;
        if (bl2) {
            return System.nanoTime();
        }
        return 0L;
    }

    public RecyclerView$OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecyclerView$RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return this.getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int n10) {
        return this.getScrollingChildHelper().hasNestedScrollingParent(n10);
    }

    public boolean hasPendingAdapterUpdates() {
        AdapterHelper adapterHelper;
        boolean bl2 = this.mFirstLayoutComplete;
        if (bl2 && !(bl2 = this.mDataSetHasChangedAfterLayout) && !(bl2 = (adapterHelper = this.mAdapterHelper).hasPendingUpdates())) {
            bl2 = false;
            adapterHelper = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void initAdapterManager() {
        AdapterHelper adapterHelper;
        RecyclerView$6 recyclerView$6 = new RecyclerView$6(this);
        this.mAdapterHelper = adapterHelper = new AdapterHelper(recyclerView$6);
    }

    public void initFastScroller(StateListDrawable object, Drawable object2, StateListDrawable object3, Drawable drawable2) {
        if (object != null && object2 != null && object3 != null && drawable2 != null) {
            Resources resources = this.getContext().getResources();
            int n10 = R$dimen.fastscroll_default_thickness;
            int n11 = resources.getDimensionPixelSize(n10);
            n10 = R$dimen.fastscroll_minimum_range;
            int n12 = resources.getDimensionPixelSize(n10);
            n10 = R$dimen.fastscroll_margin;
            int n13 = resources.getDimensionPixelOffset(n10);
            FastScroller fastScroller = new FastScroller(this, (StateListDrawable)object, (Drawable)object2, (StateListDrawable)object3, drawable2, n11, n12, n13);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Trying to set fast scroller without both required drawables.");
        object3 = this.exceptionLabel();
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        Object object = this.mItemDecorations;
        int n10 = ((ArrayList)object).size();
        if (n10 == 0) {
            return;
        }
        object = this.mLayout;
        if (object != null) {
            String string2 = "Cannot invalidate item decorations during a scroll or layout";
            ((RecyclerView$LayoutManager)object).assertNotInLayoutOrScroll(string2);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        boolean bl2;
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null && (bl2 = accessibilityManager.isEnabled())) {
            bl2 = true;
        } else {
            bl2 = false;
            accessibilityManager = null;
        }
        return bl2;
    }

    public boolean isAnimating() {
        boolean bl2;
        RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mItemAnimator;
        if (recyclerView$ItemAnimator != null && (bl2 = recyclerView$ItemAnimator.isRunning())) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView$ItemAnimator = null;
        }
        return bl2;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        int n10 = this.mLayoutOrScrollCounter;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isLayoutFrozen() {
        return this.isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return this.getScrollingChildHelper().isNestedScrollingEnabled();
    }

    public void jumpToPositionForSmoothScroller(int n10) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null) {
            return;
        }
        this.setScrollState(2);
        this.mLayout.scrollToPosition(n10);
        this.awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)this.mChildHelper.getUnfilteredChildAt(i10).getLayoutParams();
            recyclerView$LayoutParams.mInsetsDirty = bl2 = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    public void markKnownViewsInvalid() {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            if (recyclerView$ViewHolder == null || (n11 = recyclerView$ViewHolder.shouldIgnore()) != 0) continue;
            n11 = 6;
            recyclerView$ViewHolder.addFlags(n11);
        }
        this.markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void nestedScrollBy(int n10, int n11) {
        this.nestedScrollByInternal(n10, n11, null, 1);
    }

    public void offsetChildrenHorizontal(int n10) {
        ChildHelper childHelper = this.mChildHelper;
        int n11 = childHelper.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = this.mChildHelper.getChildAt(i10);
            view.offsetLeftAndRight(n10);
        }
    }

    public void offsetChildrenVertical(int n10) {
        ChildHelper childHelper = this.mChildHelper;
        int n11 = childHelper.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = this.mChildHelper.getChildAt(i10);
            view.offsetTopAndBottom(n10);
        }
    }

    public void offsetPositionRecordsForInsert(int n10, int n11) {
        ChildHelper childHelper = this.mChildHelper;
        int n12 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13;
            Object object = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            if (object == null || (n13 = ((RecyclerView$ViewHolder)object).shouldIgnore()) != 0 || (n13 = ((RecyclerView$ViewHolder)object).mPosition) < n10) continue;
            ((RecyclerView$ViewHolder)object).offsetPosition(n11, false);
            object = this.mState;
            n13 = 1;
            ((RecyclerView$State)object).mStructureChanged = n13;
        }
        this.mRecycler.offsetPositionRecordsForInsert(n10, n11);
        this.requestLayout();
    }

    public void offsetPositionRecordsForMove(int n10, int n11) {
        int n12;
        int n13;
        int n14;
        ChildHelper childHelper = this.mChildHelper;
        int n15 = childHelper.getUnfilteredChildCount();
        int n16 = 1;
        if (n10 < n11) {
            n14 = -1;
            n13 = n10;
            n12 = n11;
        } else {
            n12 = n10;
            n13 = n11;
            n14 = n16;
        }
        for (int i10 = 0; i10 < n15; ++i10) {
            int n17;
            Object object = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            if (object == null || (n17 = ((RecyclerView$ViewHolder)object).mPosition) < n13 || n17 > n12) continue;
            if (n17 == n10) {
                n17 = n11 - n10;
                ((RecyclerView$ViewHolder)object).offsetPosition(n17, false);
            } else {
                ((RecyclerView$ViewHolder)object).offsetPosition(n14, false);
            }
            object = this.mState;
            ((RecyclerView$State)object).mStructureChanged = n16;
        }
        this.mRecycler.offsetPositionRecordsForMove(n10, n11);
        this.requestLayout();
    }

    public void offsetPositionRecordsForRemove(int n10, int n11, boolean bl2) {
        int n12 = n10 + n11;
        ChildHelper childHelper = this.mChildHelper;
        int n13 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n13; ++i10) {
            int n14;
            Object object = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            if (object == null || (n14 = ((RecyclerView$ViewHolder)object).shouldIgnore()) != 0) continue;
            n14 = ((RecyclerView$ViewHolder)object).mPosition;
            boolean bl3 = true;
            if (n14 >= n12) {
                n14 = -n11;
                ((RecyclerView$ViewHolder)object).offsetPosition(n14, bl2);
                object = this.mState;
                ((RecyclerView$State)object).mStructureChanged = bl3;
                continue;
            }
            if (n14 < n10) continue;
            n14 = n10 + -1;
            int n15 = -n11;
            ((RecyclerView$ViewHolder)object).flagRemovedAndOffsetPosition(n14, n15, bl2);
            object = this.mState;
            ((RecyclerView$State)object).mStructureChanged = bl3;
        }
        this.mRecycler.offsetPositionRecordsForRemove(n10, n11, bl2);
        this.requestLayout();
    }

    public void onAttachedToWindow() {
        Object object;
        super.onAttachedToWindow();
        boolean bl2 = false;
        Object object2 = null;
        this.mLayoutOrScrollCounter = 0;
        boolean bl3 = true;
        float f10 = Float.MIN_VALUE;
        this.mIsAttached = bl3;
        int n10 = this.mFirstLayoutComplete;
        if (n10 == 0 || (n10 = this.isLayoutRequested()) != 0) {
            bl3 = false;
            object = null;
            f10 = 0.0f;
        }
        this.mFirstLayoutComplete = bl3;
        object = this.mLayout;
        if (object != null) {
            ((RecyclerView$LayoutManager)object).dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        bl2 = ALLOW_THREAD_GAP_WORK;
        if (bl2) {
            object2 = GapWorker.sGapWorker;
            this.mGapWorker = object = (GapWorker)((ThreadLocal)object2).get();
            if (object == null) {
                long l10;
                float f11;
                float f12;
                this.mGapWorker = object = new GapWorker();
                object = ViewCompat.getDisplay((View)this);
                n10 = 1114636288;
                float f13 = 60.0f;
                int n11 = this.isInEditMode();
                if (n11 == 0 && object != null && (n11 = (int)((f12 = (f10 = object.getRefreshRate()) - (f11 = 30.0f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) >= 0) {
                    f13 = f10;
                }
                object = this.mGapWorker;
                n11 = 1315859240;
                f11 = 1.0E9f / f13;
                ((GapWorker)object).mFrameIntervalNs = l10 = (long)f11;
                ((ThreadLocal)object2).set(object);
            }
            object2 = this.mGapWorker;
            ((GapWorker)object2).add(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Object object = this.mItemAnimator;
        if (object != null) {
            ((RecyclerView$ItemAnimator)object).endAnimations();
        }
        this.stopScroll();
        boolean bl2 = false;
        this.mIsAttached = false;
        object = this.mLayout;
        if (object != null) {
            RecyclerView$Recycler recyclerView$Recycler = this.mRecycler;
            ((RecyclerView$LayoutManager)object).dispatchDetachedFromWindow(this, recyclerView$Recycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        object = this.mItemAnimatorRunner;
        this.removeCallbacks((Runnable)object);
        object = this.mViewInfoStore;
        ((ViewInfoStore)object).onDetach();
        bl2 = ALLOW_THREAD_GAP_WORK;
        if (bl2 && (object = this.mGapWorker) != null) {
            ((GapWorker)object).remove(this);
            bl2 = false;
            object = null;
            this.mGapWorker = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.mItemDecorations;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$ItemDecoration recyclerView$ItemDecoration = (RecyclerView$ItemDecoration)this.mItemDecorations.get(i10);
            RecyclerView$State recyclerView$State = this.mState;
            recyclerView$ItemDecoration.onDraw(canvas, this, recyclerView$State);
        }
    }

    public void onEnterLayoutOrScroll() {
        int n10;
        this.mLayoutOrScrollCounter = n10 = this.mLayoutOrScrollCounter + 1;
    }

    public void onExitLayoutOrScroll() {
        this.onExitLayoutOrScroll(true);
    }

    public void onExitLayoutOrScroll(boolean bl2) {
        int n10 = this.mLayoutOrScrollCounter;
        int n11 = 1;
        this.mLayoutOrScrollCounter = n10 -= n11;
        if (n10 < n11) {
            n10 = 0;
            this.mLayoutOrScrollCounter = 0;
            if (bl2) {
                this.dispatchContentChangedIfNecessary();
                this.dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean onGenericMotionEvent(MotionEvent var1_1) {
        block10: {
            block9: {
                block11: {
                    block12: {
                        var2_2 = this.mLayout;
                        if (var2_2 == null) {
                            return false;
                        }
                        var3_3 = this.mLayoutSuppressed;
                        if (var3_3 != 0) {
                            return false;
                        }
                        var3_3 = var1_1.getAction();
                        var4_4 = 8;
                        var5_5 = 1.1E-44f;
                        if (var3_3 != var4_4) break block10;
                        var3_3 = var1_1.getSource() & 2;
                        var4_4 = 0;
                        var5_5 = 0.0f;
                        if (var3_3 == 0) break block11;
                        var2_2 = this.mLayout;
                        var3_3 = (int)var2_2.canScrollVertically();
                        if (var3_3 != 0) {
                            var3_3 = 9;
                            var6_6 = -var1_1.getAxisValue(var3_3);
                        } else {
                            var3_3 = 0;
                            var2_2 = null;
                            var6_6 = 0.0f;
                        }
                        var7_7 = this.mLayout;
                        var8_8 = (int)var7_7.canScrollHorizontally();
                        if (var8_8 == 0) break block12;
                        var8_8 = 10;
                        var9_9 = var1_1.getAxisValue(var8_8);
                        break block9;
                    }
lbl31:
                    // 2 sources

                    while (true) {
                        var8_8 = 0;
                        var7_7 = null;
                        var9_9 = 0.0f;
                        break block9;
                        break;
                    }
                }
                var3_3 = var1_1.getSource();
                var8_8 = 0x400000;
                var9_9 = 5.877472E-39f;
                if ((var3_3 &= var8_8) == 0) ** GOTO lbl-1000
                var3_3 = 26;
                var6_6 = var1_1.getAxisValue(var3_3);
                var7_7 = this.mLayout;
                var8_8 = (int)var7_7.canScrollVertically();
                if (var8_8 != 0) {
                    var6_6 = -var6_6;
                    ** continue;
                }
                var7_7 = this.mLayout;
                var8_8 = (int)var7_7.canScrollHorizontally();
                if (var8_8 != 0) {
                    var9_9 = var6_6;
                    var3_3 = 0;
                    var2_2 = null;
                    var6_6 = 0.0f;
                } else lbl-1000:
                // 2 sources

                {
                    var3_3 = 0;
                    var2_2 = null;
                    var6_6 = 0.0f;
                    var8_8 = 0;
                    var7_7 = null;
                    var9_9 = 0.0f;
                }
            }
            var10_10 = (cfr_temp_0 = var6_6 - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
            if (var10_10 != false || (var4_4 = (int)((cfr_temp_1 = var9_9 - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) != 0) {
                var5_5 = this.mScaledHorizontalScrollFactor;
                var4_4 = (int)(var9_9 * var5_5);
                var9_9 = this.mScaledVerticalScrollFactor;
                var3_3 = (int)(var6_6 *= var9_9);
                var8_8 = 1;
                var9_9 = 1.4E-45f;
                this.nestedScrollByInternal(var4_4, var3_3, var1_1, var8_8);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent object) {
        int n10;
        int n11 = this.mLayoutSuppressed;
        int n12 = 0;
        if (n11 != 0) {
            return false;
        }
        float f10 = 0.0f;
        RecyclerView$LayoutManager recyclerView$LayoutManager = null;
        this.mInterceptingOnItemTouchListener = null;
        n11 = this.findInterceptingOnItemTouchListener((MotionEvent)object);
        int n13 = 1;
        float f11 = Float.MIN_VALUE;
        if (n11 != 0) {
            this.cancelScroll();
            return n13 != 0;
        }
        recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null) {
            return false;
        }
        n11 = recyclerView$LayoutManager.canScrollHorizontally();
        RecyclerView$LayoutManager recyclerView$LayoutManager2 = this.mLayout;
        int n14 = recyclerView$LayoutManager2.canScrollVertically();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker = this.mVelocityTracker;
        velocityTracker.addMovement(object);
        int n15 = object.getActionMasked();
        int n16 = object.getActionIndex();
        int n17 = 2;
        float f12 = 0.5f;
        if (n15 != 0) {
            if (n15 != n13) {
                if (n15 != n17) {
                    n11 = 3;
                    f10 = 4.2E-45f;
                    if (n15 != n11) {
                        n11 = 5;
                        f10 = 7.0E-45f;
                        if (n15 != n11) {
                            n11 = 6;
                            f10 = 8.4E-45f;
                            if (n15 == n11) {
                                this.onPointerUp((MotionEvent)object);
                            }
                        } else {
                            this.mScrollPointerId = n11 = object.getPointerId(n16);
                            f10 = object.getX(n16) + f12;
                            this.mLastTouchX = n11 = (int)f10;
                            this.mInitialTouchX = n11;
                            float f13 = object.getY(n16) + f12;
                            this.mLastTouchY = n10 = (int)f13;
                            this.mInitialTouchY = n10;
                        }
                    } else {
                        this.cancelScroll();
                    }
                } else {
                    n15 = this.mScrollPointerId;
                    if ((n15 = object.findPointerIndex(n15)) < 0) {
                        object = new StringBuilder();
                        object.append("Error processing scroll; pointer index for id ");
                        n11 = this.mScrollPointerId;
                        object.append(n11);
                        object.append(" not found. Did any MotionEvents get skipped?");
                        object = object.toString();
                        Log.e((String)TAG, (String)object);
                        return false;
                    }
                    float f14 = object.getX(n15) + f12;
                    n16 = (int)f14;
                    float f15 = object.getY(n15) + f12;
                    n10 = (int)f15;
                    n15 = this.mScrollState;
                    if (n15 != n13) {
                        n15 = this.mInitialTouchX;
                        n15 = n16 - n15;
                        n17 = this.mInitialTouchY;
                        n17 = n10 - n17;
                        if (n11 != 0 && (n11 = Math.abs(n15)) > (n15 = this.mTouchSlop)) {
                            this.mLastTouchX = n16;
                            n11 = n13;
                            f10 = f11;
                        } else {
                            n11 = 0;
                            recyclerView$LayoutManager = null;
                            f10 = 0.0f;
                        }
                        if (n14 != 0 && (n14 = Math.abs(n17)) > (n15 = this.mTouchSlop)) {
                            this.mLastTouchY = n10;
                            n11 = n13;
                            f10 = f11;
                        }
                        if (n11 != 0) {
                            this.setScrollState(n13);
                        }
                    }
                }
            } else {
                object = this.mVelocityTracker;
                object.clear();
                this.stopNestedScroll(0);
            }
        } else {
            n15 = (int)(this.mIgnoreMotionEventTillDown ? 1 : 0);
            if (n15 != 0) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = n15 = object.getPointerId(0);
            float f16 = object.getX() + f12;
            this.mLastTouchX = n15 = (int)f16;
            this.mInitialTouchX = n15;
            float f17 = object.getY() + f12;
            this.mLastTouchY = n10 = (int)f17;
            this.mInitialTouchY = n10;
            n10 = this.mScrollState;
            if (n10 == n17) {
                object = this.getParent();
                object.requestDisallowInterceptTouchEvent(n13 != 0);
                this.setScrollState(n13);
                this.stopNestedScroll(n13);
            }
            object = this.mNestedOffsets;
            object[n13] = (MotionEvent)false;
            object[0] = (MotionEvent)false;
            if (n14 != 0) {
                n11 |= 2;
            }
            this.startNestedScroll(n11, 0);
        }
        n10 = this.mScrollState;
        if (n10 == n13) {
            n12 = n13;
        }
        return n12 != 0;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        this.dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onMeasure(int n10, int n11) {
        Object object = this.mLayout;
        if (object == null) {
            this.defaultOnMeasure(n10, n11);
            return;
        }
        int n12 = ((RecyclerView$LayoutManager)object).isAutoMeasureEnabled();
        int n13 = 1;
        int n14 = 0;
        RecyclerView$State recyclerView$State = null;
        if (n12 != 0) {
            n12 = View.MeasureSpec.getMode((int)n10);
            int n15 = View.MeasureSpec.getMode((int)n11);
            RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
            RecyclerView$Recycler recyclerView$Recycler = this.mRecycler;
            RecyclerView$State recyclerView$State2 = this.mState;
            recyclerView$LayoutManager.onMeasure(recyclerView$Recycler, recyclerView$State2, n10, n11);
            int n16 = 0x40000000;
            if (n12 == n16 && n15 == n16) {
                n14 = n13;
            }
            this.mLastAutoMeasureSkippedDueToExact = n14;
            if (n14 != 0 || (object = this.mAdapter) == null) return;
            object = this.mState;
            n12 = ((RecyclerView$State)object).mLayoutStep;
            if (n12 == n13) {
                this.dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(n10, n11);
            this.mState.mIsMeasuring = n13;
            this.dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(n10, n11);
            object = this.mLayout;
            n12 = (int)(((RecyclerView$LayoutManager)object).shouldMeasureTwice() ? 1 : 0);
            if (n12 != 0) {
                object = this.mLayout;
                n14 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)n16);
                n15 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)n16);
                ((RecyclerView$LayoutManager)object).setMeasureSpecs(n14, n15);
                this.mState.mIsMeasuring = n13;
                this.dispatchLayoutStep2();
                object = this.mLayout;
                ((RecyclerView$LayoutManager)object).setMeasuredDimensionFromChildren(n10, n11);
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = n10 = this.getMeasuredWidth();
            this.mLastAutoMeasureNonExactMeasuredHeight = n10 = this.getMeasuredHeight();
            return;
        } else {
            Object object2;
            n12 = (int)(this.mHasFixedSize ? 1 : 0);
            if (n12 != 0) {
                object = this.mLayout;
                RecyclerView$Recycler recyclerView$Recycler = this.mRecycler;
                recyclerView$State = this.mState;
                ((RecyclerView$LayoutManager)object).onMeasure(recyclerView$Recycler, recyclerView$State, n10, n11);
                return;
            }
            n12 = (int)(this.mAdapterUpdateDuringMeasure ? 1 : 0);
            if (n12 != 0) {
                this.startInterceptRequestLayout();
                this.onEnterLayoutOrScroll();
                this.processAdapterUpdatesAndSetAnimationFlags();
                this.onExitLayoutOrScroll();
                object = this.mState;
                boolean bl2 = ((RecyclerView$State)object).mRunPredictiveAnimations;
                if (bl2) {
                    ((RecyclerView$State)object).mInPreLayout = n13;
                } else {
                    this.mAdapterHelper.consumeUpdatesInOnePass();
                    object = this.mState;
                    ((RecyclerView$State)object).mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                this.stopInterceptRequestLayout(false);
            } else {
                object = this.mState;
                n12 = (int)(((RecyclerView$State)object).mRunPredictiveAnimations ? 1 : 0);
                if (n12 != 0) {
                    n10 = this.getMeasuredWidth();
                    n11 = this.getMeasuredHeight();
                    this.setMeasuredDimension(n10, n11);
                    return;
                }
            }
            object = this.mAdapter;
            if (object != null) {
                object2 = this.mState;
                ((RecyclerView$State)object2).mItemCount = n12 = ((RecyclerView$Adapter)object).getItemCount();
            } else {
                object = this.mState;
                ((RecyclerView$State)object).mItemCount = 0;
            }
            this.startInterceptRequestLayout();
            object = this.mLayout;
            object2 = this.mRecycler;
            RecyclerView$State recyclerView$State3 = this.mState;
            ((RecyclerView$LayoutManager)object).onMeasure((RecyclerView$Recycler)object2, recyclerView$State3, n10, n11);
            this.stopInterceptRequestLayout(false);
            RecyclerView$State recyclerView$State4 = this.mState;
            recyclerView$State4.mInPreLayout = false;
        }
    }

    public boolean onRequestFocusInDescendants(int n10, Rect rect) {
        boolean bl2 = this.isComputingLayout();
        if (bl2) {
            return false;
        }
        return super.onRequestFocusInDescendants(n10, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof RecyclerView$SavedState;
        if (!bl2) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (RecyclerView$SavedState)parcelable;
        this.mPendingSavedState = parcelable;
        parcelable = parcelable.getSuperState();
        super.onRestoreInstanceState(parcelable);
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Object object = super.onSaveInstanceState();
        RecyclerView$SavedState recyclerView$SavedState = new RecyclerView$SavedState((Parcelable)object);
        object = this.mPendingSavedState;
        if (object != null) {
            recyclerView$SavedState.copyFrom((RecyclerView$SavedState)object);
        } else {
            object = this.mLayout;
            if (object != null) {
                object = ((RecyclerView$LayoutManager)object).onSaveInstanceState();
                recyclerView$SavedState.mLayoutState = object;
            } else {
                object = null;
                recyclerView$SavedState.mLayoutState = null;
            }
        }
        return recyclerView$SavedState;
    }

    public void onScrollStateChanged(int n10) {
    }

    public void onScrolled(int n10, int n11) {
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        if (n10 != n12 || n11 != n13) {
            this.invalidateGlows();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block42: {
            block46: {
                block43: {
                    block49: {
                        block48: {
                            block44: {
                                block47: {
                                    block45: {
                                        var2_2 = this;
                                        var3_3 = var1_1;
                                        var4_4 /* !! */  = this.mLayoutSuppressed;
                                        var5_5 = 0;
                                        if (var4_4 /* !! */  != 0 || (var4_4 /* !! */  = this.mIgnoreMotionEventTillDown) != 0) break block42;
                                        var4_4 /* !! */  = this.dispatchToOnItemTouchListeners(var1_1);
                                        var6_6 = 1;
                                        var7_7 = 1.4E-45f;
                                        if (var4_4 /* !! */  != 0) {
                                            this.cancelScroll();
                                            return (boolean)var6_6;
                                        }
                                        var8_8 = this.mLayout;
                                        if (var8_8 == null) {
                                            return false;
                                        }
                                        var9_9 = var8_8.canScrollHorizontally();
                                        var10_10 = this.mLayout.canScrollVertically();
                                        var8_8 = this.mVelocityTracker;
                                        if (var8_8 == null) {
                                            var8_8 = VelocityTracker.obtain();
                                            this.mVelocityTracker = var8_8;
                                        }
                                        var4_4 /* !! */  = var1_1.getActionMasked();
                                        var11_11 /* !! */  = var1_1.getActionIndex();
                                        if (var4_4 /* !! */  == 0) {
                                            var12_12 /* !! */  = var2_2.mNestedOffsets;
                                            var12_12 /* !! */ [var6_6] = 0;
                                            var12_12 /* !! */ [0] = 0;
                                        }
                                        var13_13 = MotionEvent.obtain((MotionEvent)var1_1);
                                        var12_12 /* !! */  = var2_2.mNestedOffsets;
                                        var14_14 = var12_12 /* !! */ [0];
                                        var15_15 = var14_14;
                                        var16_16 = var12_12 /* !! */ [var6_6];
                                        var13_13.offsetLocation(var15_15, var16_16);
                                        var17_17 = 0x3F000000;
                                        var16_16 = 0.5f;
                                        if (var4_4 /* !! */  == 0) break block43;
                                        if (var4_4 /* !! */  == var6_6) break block44;
                                        var14_14 = 2;
                                        var15_15 = 2.8E-45f;
                                        if (var4_4 /* !! */  == var14_14) break block45;
                                        var14_14 = 3;
                                        var15_15 = 4.2E-45f;
                                        if (var4_4 /* !! */  != var14_14) {
                                            var14_14 = 5;
                                            var15_15 = 7.0E-45f;
                                            if (var4_4 /* !! */  != var14_14) {
                                                var11_11 /* !! */  = 6;
                                                var18_18 = 8.4E-45f;
                                                if (var4_4 /* !! */  == var11_11 /* !! */ ) {
                                                    this.onPointerUp(var1_1);
                                                }
                                            } else {
                                                var2_2.mScrollPointerId = var4_4 /* !! */  = var3_3.getPointerId(var11_11 /* !! */ );
                                                var2_2.mLastTouchX = var4_4 /* !! */  = (int)(var3_3.getX(var11_11 /* !! */ ) + var16_16);
                                                var2_2.mInitialTouchX = var4_4 /* !! */ ;
                                                var19_21 = var3_3.getY(var11_11 /* !! */ ) + var16_16;
                                                var2_2.mLastTouchY = var4_4 /* !! */  = (int)var19_21;
                                                var2_2.mInitialTouchY = var4_4 /* !! */ ;
                                            }
                                        } else {
                                            this.cancelScroll();
                                        }
                                        break block46;
                                    }
                                    var4_4 /* !! */  = var2_2.mScrollPointerId;
                                    if ((var4_4 /* !! */  = var3_3.findPointerIndex(var4_4 /* !! */ )) < 0) {
                                        var8_8 = new StringBuilder();
                                        var8_8.append("Error processing scroll; pointer index for id ");
                                        var11_11 /* !! */  = var2_2.mScrollPointerId;
                                        var8_8.append(var11_11 /* !! */ );
                                        var8_8.append(" not found. Did any MotionEvents get skipped?");
                                        var8_8 = var8_8.toString();
                                        Log.e((String)"RecyclerView", (String)var8_8);
                                        return false;
                                    }
                                    var18_19 = var3_3.getX(var4_4 /* !! */ ) + var16_16;
                                    var20_25 = (int)var18_19;
                                    var19_22 = var3_3.getY(var4_4 /* !! */ ) + var16_16;
                                    var21_26 = (int)var19_22;
                                    var4_4 /* !! */  = var2_2.mLastTouchX - var20_25;
                                    var11_11 /* !! */  = var2_2.mLastTouchY - var21_26;
                                    var17_17 = var2_2.mScrollState;
                                    if (var17_17 == var6_6) break block47;
                                    if (var9_9 == 0) ** GOTO lbl-1000
                                    if (var4_4 /* !! */  > 0) {
                                        var17_17 = var2_2.mTouchSlop;
                                        var4_4 /* !! */  -= var17_17;
                                        var4_4 /* !! */  = Math.max(0, var4_4 /* !! */ );
                                    } else {
                                        var17_17 = var2_2.mTouchSlop;
                                        var4_4 /* !! */  += var17_17;
                                        var4_4 /* !! */  = Math.min(0, var4_4 /* !! */ );
                                    }
                                    if (var4_4 /* !! */  != 0) {
                                        var17_17 = var6_6;
                                        var16_16 = var7_7;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var17_17 = 0;
                                        var12_12 /* !! */  = null;
                                        var16_16 = 0.0f;
                                    }
                                    if (var10_10) {
                                        if (var11_11 /* !! */  > 0) {
                                            var14_14 = var2_2.mTouchSlop;
                                            var11_11 /* !! */  -= var14_14;
                                            var11_11 /* !! */  = Math.max(0, var11_11 /* !! */ );
                                        } else {
                                            var14_14 = var2_2.mTouchSlop;
                                            var11_11 /* !! */  += var14_14;
                                            var11_11 /* !! */  = Math.min(0, var11_11 /* !! */ );
                                        }
                                        if (var11_11 /* !! */  != 0) {
                                            var17_17 = var6_6;
                                            var16_16 = var7_7;
                                        }
                                    }
                                    if (var17_17 != 0) {
                                        var2_2.setScrollState(var6_6);
                                    }
                                }
                                var22_27 = var4_4 /* !! */ ;
                                var23_28 = var11_11 /* !! */ ;
                                var4_4 /* !! */  = var2_2.mScrollState;
                                if (var4_4 /* !! */  == var6_6) {
                                    var24_29 = var2_2.mReusableIntPair;
                                    var24_29[0] = 0;
                                    var24_29[var6_6] = 0;
                                    if (var9_9 != 0) {
                                        var11_11 /* !! */  = var22_27;
                                    } else {
                                        var11_11 /* !! */  = 0;
                                        var25_30 = null;
                                        var18_19 = 0.0f;
                                    }
                                    if (var10_10) {
                                        var17_17 = var23_28;
                                    } else {
                                        var17_17 = 0;
                                        var12_12 /* !! */  = null;
                                        var16_16 = 0.0f;
                                    }
                                    var26_33 = var2_2.mScrollOffset;
                                    var8_8 = this;
                                    var4_4 /* !! */  = (int)this.dispatchNestedPreScroll(var11_11 /* !! */ , var17_17, var24_29, var26_33, 0);
                                    if (var4_4 /* !! */  != 0) {
                                        var8_8 = var2_2.mReusableIntPair;
                                        var11_11 /* !! */  = (int)var8_8[0];
                                        var22_27 -= var11_11 /* !! */ ;
                                        var4_4 /* !! */  = (int)var8_8[var6_6];
                                        var23_28 -= var4_4 /* !! */ ;
                                        var8_8 = var2_2.mNestedOffsets;
                                        var11_11 /* !! */  = (int)var8_8[0];
                                        var12_12 /* !! */  = var2_2.mScrollOffset;
                                        var14_14 = var12_12 /* !! */ [0];
                                        var8_8[0] = var11_11 /* !! */  += var14_14;
                                        var11_11 /* !! */  = (int)var8_8[var6_6];
                                        var17_17 = var12_12 /* !! */ [var6_6];
                                        var8_8[var6_6] = var11_11 /* !! */  += var17_17;
                                        var8_8 = this.getParent();
                                        var8_8.requestDisallowInterceptTouchEvent((boolean)var6_6);
                                    }
                                    var4_4 /* !! */  = var23_28;
                                    var25_30 = var2_2.mScrollOffset;
                                    var17_17 = var25_30[0];
                                    var2_2.mLastTouchX = var20_25 -= var17_17;
                                    var11_11 /* !! */  = var25_30[var6_6];
                                    var2_2.mLastTouchY = var21_26 -= var11_11 /* !! */ ;
                                    if (var9_9 != 0) {
                                        var11_11 /* !! */  = var22_27;
                                    } else {
                                        var11_11 /* !! */  = 0;
                                        var25_30 = null;
                                        var18_19 = 0.0f;
                                    }
                                    if (var10_10) {
                                        var17_17 = var4_4 /* !! */ ;
                                    } else {
                                        var17_17 = 0;
                                        var12_12 /* !! */  = null;
                                        var16_16 = 0.0f;
                                    }
                                    var11_11 /* !! */  = (int)var2_2.scrollByInternal(var11_11 /* !! */ , var17_17, var3_3, 0);
                                    if (var11_11 /* !! */  != 0) {
                                        var25_30 = this.getParent();
                                        var25_30.requestDisallowInterceptTouchEvent((boolean)var6_6);
                                    }
                                    if ((var25_30 = (Object)var2_2.mGapWorker) != null && (var22_27 != 0 || var4_4 /* !! */  != 0)) {
                                        var25_30.postFromTraversal(var2_2, var22_27, var4_4 /* !! */ );
                                    }
                                }
                                break block46;
                            }
                            var2_2.mVelocityTracker.addMovement(var13_13);
                            var8_8 = var2_2.mVelocityTracker;
                            var11_11 /* !! */  = 1000;
                            var18_20 = 1.401E-42f;
                            var17_17 = var2_2.mMaxFlingVelocity;
                            var16_16 = var17_17;
                            var8_8.computeCurrentVelocity(var11_11 /* !! */ , var16_16);
                            var4_4 /* !! */  = 0;
                            var19_23 = 0.0f;
                            var8_8 = null;
                            if (var9_9 != 0) {
                                var25_31 = var2_2.mVelocityTracker;
                                var17_17 = var2_2.mScrollPointerId;
                                var18_20 = -var25_31.getXVelocity(var17_17);
                            } else {
                                var11_11 /* !! */  = 0;
                                var25_32 = null;
                                var18_20 = 0.0f;
                            }
                            if (var10_10) {
                                var12_12 /* !! */  = (int[])var2_2.mVelocityTracker;
                                var14_14 = var2_2.mScrollPointerId;
                                var16_16 = -var12_12 /* !! */ .getYVelocity(var14_14);
                            } else {
                                var17_17 = 0;
                                var12_12 /* !! */  = null;
                                var16_16 = 0.0f;
                            }
                            var14_14 = (int)((cfr_temp_0 = var18_20 - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                            if (var14_14 == 0 && (var4_4 /* !! */  = (int)((cfr_temp_1 = var16_16 - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) == 0) break block48;
                            var4_4 /* !! */  = (int)var18_20;
                            var11_11 /* !! */  = (int)var16_16;
                            if ((var4_4 /* !! */  = (int)var2_2.fling(var4_4 /* !! */ , var11_11 /* !! */ )) != 0) break block49;
                        }
                        var2_2.setScrollState(0);
                    }
                    this.resetScroll();
                    var5_5 = var6_6;
                    break block46;
                }
                var2_2.mScrollPointerId = var4_4 /* !! */  = var3_3.getPointerId(0);
                var2_2.mLastTouchX = var4_4 /* !! */  = (int)(var1_1.getX() + var16_16);
                var2_2.mInitialTouchX = var4_4 /* !! */ ;
                var19_24 = var1_1.getY() + var16_16;
                var2_2.mLastTouchY = var4_4 /* !! */  = (int)var19_24;
                var2_2.mInitialTouchY = var4_4 /* !! */ ;
                if (var10_10) {
                    var9_9 |= 2;
                }
                var2_2.startNestedScroll(var9_9, 0);
            }
            if (var5_5 == 0) {
                var8_8 = var2_2.mVelocityTracker;
                var8_8.addMovement(var13_13);
            }
            var13_13.recycle();
            return (boolean)var6_6;
        }
        return false;
    }

    public void postAnimationRunner() {
        boolean bl2 = this.mPostedAnimatorRunner;
        if (!bl2 && (bl2 = this.mIsAttached)) {
            Runnable runnable = this.mItemAnimatorRunner;
            ViewCompat.postOnAnimation((View)this, runnable);
            this.mPostedAnimatorRunner = bl2 = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean bl2) {
        boolean bl3 = this.mDispatchItemsChangedEvent;
        this.mDispatchItemsChangedEvent = bl2 |= bl3;
        this.mDataSetHasChangedAfterLayout = true;
        this.markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        int n10 = 8192;
        recyclerView$ViewHolder.setFlags(0, n10);
        RecyclerView$State recyclerView$State = this.mState;
        boolean bl2 = recyclerView$State.mTrackOldChangeHolders;
        if (bl2 && (bl2 = recyclerView$ViewHolder.isUpdated()) && !(bl2 = recyclerView$ViewHolder.isRemoved()) && !(bl2 = recyclerView$ViewHolder.shouldIgnore())) {
            long l10 = this.getChangedHolderKey(recyclerView$ViewHolder);
            ViewInfoStore viewInfoStore = this.mViewInfoStore;
            viewInfoStore.addToOldChangeHolders(l10, recyclerView$ViewHolder);
        }
        this.mViewInfoStore.addToPreLayout(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo);
    }

    public void removeAndRecycleViews() {
        Object object = this.mItemAnimator;
        if (object != null) {
            ((RecyclerView$ItemAnimator)object).endAnimations();
        }
        if ((object = this.mLayout) != null) {
            RecyclerView$Recycler recyclerView$Recycler = this.mRecycler;
            ((RecyclerView$LayoutManager)object).removeAndRecycleAllViews(recyclerView$Recycler);
            object = this.mLayout;
            recyclerView$Recycler = this.mRecycler;
            ((RecyclerView$LayoutManager)object).removeAndRecycleScrapInt(recyclerView$Recycler);
        }
        this.mRecycler.clear();
    }

    public boolean removeAnimatingView(View object) {
        this.startInterceptRequestLayout();
        ChildHelper childHelper = this.mChildHelper;
        boolean bl2 = childHelper.removeViewIfHidden((View)object);
        if (bl2) {
            object = RecyclerView.getChildViewHolderInt(object);
            this.mRecycler.unscrapView((RecyclerView$ViewHolder)object);
            RecyclerView$Recycler recyclerView$Recycler = this.mRecycler;
            recyclerView$Recycler.recycleViewHolderInternal((RecyclerView$ViewHolder)object);
        }
        boolean bl3 = bl2 ^ true;
        this.stopInterceptRequestLayout(bl3);
        return bl2;
    }

    public void removeDetachedView(View object, boolean bl2) {
        Object object2 = RecyclerView.getChildViewHolderInt(object);
        if (object2 != null) {
            boolean bl3 = ((RecyclerView$ViewHolder)object2).isTmpDetached();
            if (bl3) {
                ((RecyclerView$ViewHolder)object2).clearTmpDetachFlag();
            } else {
                bl3 = ((RecyclerView$ViewHolder)object2).shouldIgnore();
                if (!bl3) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                    charSequence.append(object2);
                    object2 = this.exceptionLabel();
                    charSequence.append((String)object2);
                    charSequence = charSequence.toString();
                    object = new IllegalArgumentException((String)charSequence);
                    throw object;
                }
            }
        }
        object.clearAnimation();
        this.dispatchChildDetached((View)object);
        super.removeDetachedView(object, bl2);
    }

    /*
     * WARNING - void declaration
     */
    public void removeItemDecoration(RecyclerView$ItemDecoration object) {
        Object object2 = this.mLayout;
        if (object2 != null) {
            String string2 = "Cannot remove item decoration during a scroll  or layout";
            ((RecyclerView$LayoutManager)object2).assertNotInLayoutOrScroll(string2);
        }
        object2 = this.mItemDecorations;
        ((ArrayList)object2).remove(object);
        object = this.mItemDecorations;
        boolean n10 = ((ArrayList)object).isEmpty();
        if (n10) {
            void var4_8;
            int n11;
            int n12 = this.getOverScrollMode();
            if (n12 == (n11 = 2)) {
                boolean bl2 = true;
            } else {
                boolean bl3 = false;
                object = null;
            }
            this.setWillNotDraw((boolean)var4_8);
        }
        this.markItemDecorInsetsDirty();
        this.requestLayout();
    }

    public void removeItemDecorationAt(int n10) {
        int n11 = this.getItemDecorationCount();
        if (n10 >= 0 && n10 < n11) {
            RecyclerView$ItemDecoration recyclerView$ItemDecoration = this.getItemDecorationAt(n10);
            this.removeItemDecoration(recyclerView$ItemDecoration);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append(" is an invalid index for size ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public void removeOnChildAttachStateChangeListener(RecyclerView$OnChildAttachStateChangeListener recyclerView$OnChildAttachStateChangeListener) {
        List list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(recyclerView$OnChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(RecyclerView$OnItemTouchListener recyclerView$OnItemTouchListener) {
        this.mOnItemTouchListeners.remove(recyclerView$OnItemTouchListener);
        RecyclerView$OnItemTouchListener recyclerView$OnItemTouchListener2 = this.mInterceptingOnItemTouchListener;
        if (recyclerView$OnItemTouchListener2 == recyclerView$OnItemTouchListener) {
            recyclerView$OnItemTouchListener = null;
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(RecyclerView$OnScrollListener recyclerView$OnScrollListener) {
        List list = this.mScrollListeners;
        if (list != null) {
            list.remove(recyclerView$OnScrollListener);
        }
    }

    public void removeRecyclerListener(RecyclerView$RecyclerListener recyclerView$RecyclerListener) {
        this.mRecyclerListeners.remove(recyclerView$RecyclerListener);
    }

    public void repositionShadowingViews() {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.mChildHelper.getChildAt(i10);
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.getChildViewHolder(view);
            if (recyclerView$ViewHolder == null || (recyclerView$ViewHolder = recyclerView$ViewHolder.mShadowingHolder) == null) continue;
            recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
            int n11 = view.getLeft();
            int n12 = view.getTop();
            int n13 = recyclerView$ViewHolder.getLeft();
            if (n11 == n13 && n12 == (n13 = recyclerView$ViewHolder.getTop())) continue;
            n13 = recyclerView$ViewHolder.getWidth() + n11;
            int n14 = recyclerView$ViewHolder.getHeight() + n12;
            recyclerView$ViewHolder.layout(n11, n12, n13, n14);
        }
    }

    public void requestChildFocus(View view, View view2) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        RecyclerView$State recyclerView$State = this.mState;
        boolean bl2 = recyclerView$LayoutManager.onRequestChildFocus(this, recyclerView$State, view, view2);
        if (!bl2 && view2 != null) {
            this.requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        ArrayList arrayList = this.mOnItemTouchListeners;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$OnItemTouchListener recyclerView$OnItemTouchListener = (RecyclerView$OnItemTouchListener)this.mOnItemTouchListeners.get(i10);
            recyclerView$OnItemTouchListener.onRequestDisallowInterceptTouchEvent(bl2);
        }
        super.requestDisallowInterceptTouchEvent(bl2);
    }

    public void requestLayout() {
        int n10 = this.mInterceptRequestLayoutDepth;
        if (n10 == 0 && (n10 = (int)(this.mLayoutSuppressed ? 1 : 0)) == 0) {
            super.requestLayout();
        } else {
            n10 = 1;
            this.mLayoutWasDefered = n10;
        }
    }

    public void saveOldPositions() {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.getUnfilteredChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i10));
            boolean bl2 = recyclerView$ViewHolder.shouldIgnore();
            if (bl2) continue;
            recyclerView$ViewHolder.saveOldPosition();
        }
    }

    public void scrollBy(int n10, int n11) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null) {
            Log.e((String)TAG, (String)"Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        boolean bl2 = this.mLayoutSuppressed;
        if (bl2) {
            return;
        }
        boolean bl3 = recyclerView$LayoutManager.canScrollHorizontally();
        RecyclerView$LayoutManager recyclerView$LayoutManager2 = this.mLayout;
        bl2 = recyclerView$LayoutManager2.canScrollVertically();
        if (bl3 || bl2) {
            if (!bl3) {
                n10 = 0;
            }
            if (!bl2) {
                n11 = 0;
            }
            bl3 = false;
            recyclerView$LayoutManager = null;
            this.scrollByInternal(n10, n11, null, 0);
        }
    }

    /*
     * WARNING - void declaration
     */
    public boolean scrollByInternal(int n10, int n11, MotionEvent motionEvent, int n12) {
        void var14_16;
        int n13;
        int n14;
        int n16;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        RecyclerView recyclerView = this;
        MotionEvent motionEvent2 = motionEvent;
        this.consumePendingUpdateOperations();
        Object object5 = this.mAdapter;
        boolean bl2 = true;
        if (object5 != null) {
            object5 = this.mReusableIntPair;
            object5[0] = false;
            object5[bl2] = false;
            this.scrollStep(n10, n11, (int[])object5);
            object5 = this.mReusableIntPair;
            object4 = object5[0];
            object3 = object5[bl2];
            object2 = n10 - object4;
            object = n11 - object3;
            n16 = object3;
            Object n15 = object4;
            n14 = object2;
            n13 = object;
        } else {
            n16 = 0;
            boolean bl3 = false;
            n14 = 0;
            n13 = 0;
        }
        object5 = recyclerView.mItemDecorations;
        object3 = ((ArrayList)object5).isEmpty();
        if (!object3) {
            this.invalidate();
        }
        int[] nArray = recyclerView.mReusableIntPair;
        nArray[0] = 0;
        nArray[bl2] = 0;
        int[] nArray2 = recyclerView.mScrollOffset;
        object5 = this;
        object4 = var14_16;
        object2 = n16;
        object = n14;
        int n15 = n13;
        int n17 = n12;
        this.dispatchNestedScroll((int)var14_16, n16, n14, n13, nArray2, n12, nArray);
        object5 = recyclerView.mReusableIntPair;
        object4 = object5[0];
        object4 = n14 - object4;
        object2 = object5[bl2];
        object2 = n13 - object2;
        object = object5[0];
        if (object == 0 && !(object3 = object5[bl2])) {
            object3 = 0;
            object5 = null;
        } else {
            object3 = bl2;
        }
        object = recyclerView.mLastTouchX;
        int[] nArray3 = recyclerView.mScrollOffset;
        int n18 = nArray3[0];
        recyclerView.mLastTouchX = object -= n18;
        object = recyclerView.mLastTouchY;
        n18 = nArray3[bl2];
        recyclerView.mLastTouchY = object -= n18;
        int[] nArray4 = recyclerView.mNestedOffsets;
        n18 = nArray4[0];
        n17 = nArray3[0];
        nArray4[0] = n18 += n17;
        n18 = nArray4[bl2];
        n15 = nArray3[bl2];
        nArray4[bl2] = n18 += n15;
        object = this.getOverScrollMode();
        n15 = 2;
        float f10 = 2.8E-45f;
        if (object != n15) {
            if (motionEvent2 != null) {
                float f11 = 1.1482E-41f;
                object = MotionEventCompat.isFromSource(motionEvent2, 8194);
                if (object == 0) {
                    f11 = motionEvent.getX();
                    float f12 = (float)object4;
                    f10 = motionEvent.getY();
                    float f13 = object2;
                    recyclerView.pullGlows(f11, f12, f10, f13);
                }
            }
            this.considerReleasingGlowsOnScroll(n10, n11);
        }
        if (var14_16 != false || n16 != 0) {
            recyclerView.dispatchOnScrolled((int)var14_16, n16);
        }
        if ((object4 = (Object)this.awakenScrollBars()) == false) {
            this.invalidate();
        }
        if (!object3 && var14_16 == false && n16 == 0) {
            bl2 = false;
        }
        return bl2;
    }

    public void scrollStep(int n10, int n11, int[] nArray) {
        RecyclerView$State recyclerView$State;
        RecyclerView$Recycler recyclerView$Recycler;
        RecyclerView$LayoutManager recyclerView$LayoutManager;
        this.startInterceptRequestLayout();
        this.onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        RecyclerView$State recyclerView$State2 = this.mState;
        this.fillRemainingScrollValues(recyclerView$State2);
        recyclerView$State2 = null;
        if (n10 != 0) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$Recycler = this.mRecycler;
            recyclerView$State = this.mState;
            n10 = recyclerView$LayoutManager.scrollHorizontallyBy(n10, recyclerView$Recycler, recyclerView$State);
        } else {
            n10 = 0;
        }
        if (n11 != 0) {
            recyclerView$LayoutManager = this.mLayout;
            recyclerView$Recycler = this.mRecycler;
            recyclerView$State = this.mState;
            n11 = recyclerView$LayoutManager.scrollVerticallyBy(n11, recyclerView$Recycler, recyclerView$State);
        } else {
            n11 = 0;
        }
        TraceCompat.endSection();
        this.repositionShadowingViews();
        this.onExitLayoutOrScroll();
        this.stopInterceptRequestLayout(false);
        if (nArray != null) {
            nArray[0] = n10;
            n10 = 1;
            nArray[n10] = n11;
        }
    }

    public void scrollTo(int n10, int n11) {
        Log.w((String)TAG, (String)"RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int n10) {
        boolean bl2 = this.mLayoutSuppressed;
        if (bl2) {
            return;
        }
        this.stopScroll();
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null) {
            Log.e((String)TAG, (String)"Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        recyclerView$LayoutManager.scrollToPosition(n10);
        this.awakenScrollBars();
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        boolean bl2 = this.shouldDeferAccessibilityEvent(accessibilityEvent);
        if (bl2) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate((View)this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(RecyclerView$Adapter recyclerView$Adapter) {
        this.setLayoutFrozen(false);
        this.setAdapterInternal(recyclerView$Adapter, false, true);
        this.processDataSetCompletelyChanged(false);
        this.requestLayout();
    }

    public void setChildDrawingOrderCallback(RecyclerView$ChildDrawingOrderCallback recyclerView$ChildDrawingOrderCallback) {
        boolean bl2;
        RecyclerView$ChildDrawingOrderCallback recyclerView$ChildDrawingOrderCallback2 = this.mChildDrawingOrderCallback;
        if (recyclerView$ChildDrawingOrderCallback == recyclerView$ChildDrawingOrderCallback2) {
            return;
        }
        this.mChildDrawingOrderCallback = recyclerView$ChildDrawingOrderCallback;
        if (recyclerView$ChildDrawingOrderCallback != null) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView$ChildDrawingOrderCallback = null;
        }
        this.setChildrenDrawingOrderEnabled(bl2);
    }

    public boolean setChildImportantForAccessibilityInternal(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        boolean bl2 = this.isComputingLayout();
        if (bl2) {
            recyclerView$ViewHolder.mPendingAccessibilityState = n10;
            this.mPendingAccessibilityImportanceChange.add(recyclerView$ViewHolder);
            return false;
        }
        ViewCompat.setImportantForAccessibility(recyclerView$ViewHolder.itemView, n10);
        return true;
    }

    public void setClipToPadding(boolean bl2) {
        boolean bl3 = this.mClipToPadding;
        if (bl2 != bl3) {
            this.invalidateGlows();
        }
        this.mClipToPadding = bl2;
        super.setClipToPadding(bl2);
        bl2 = this.mFirstLayoutComplete;
        if (bl2) {
            this.requestLayout();
        }
    }

    public void setEdgeEffectFactory(RecyclerView$EdgeEffectFactory recyclerView$EdgeEffectFactory) {
        Preconditions.checkNotNull(recyclerView$EdgeEffectFactory);
        this.mEdgeEffectFactory = recyclerView$EdgeEffectFactory;
        this.invalidateGlows();
    }

    public void setHasFixedSize(boolean bl2) {
        this.mHasFixedSize = bl2;
    }

    public void setItemAnimator(RecyclerView$ItemAnimator recyclerView$ItemAnimator) {
        Object object = this.mItemAnimator;
        if (object != null) {
            ((RecyclerView$ItemAnimator)object).endAnimations();
            object = this.mItemAnimator;
            ((RecyclerView$ItemAnimator)object).setListener(null);
        }
        this.mItemAnimator = recyclerView$ItemAnimator;
        if (recyclerView$ItemAnimator != null) {
            object = this.mItemAnimatorListener;
            recyclerView$ItemAnimator.setListener((RecyclerView$ItemAnimator$ItemAnimatorListener)object);
        }
    }

    public void setItemViewCacheSize(int n10) {
        this.mRecycler.setViewCacheSize(n10);
    }

    public void setLayoutFrozen(boolean bl2) {
        this.suppressLayout(bl2);
    }

    public void setLayoutManager(RecyclerView$LayoutManager object) {
        Object object2;
        Object object3 = this.mLayout;
        if (object == object3) {
            return;
        }
        this.stopScroll();
        object3 = this.mLayout;
        if (object3 != null) {
            object3 = this.mItemAnimator;
            if (object3 != null) {
                ((RecyclerView$ItemAnimator)object3).endAnimations();
            }
            object3 = this.mLayout;
            object2 = this.mRecycler;
            ((RecyclerView$LayoutManager)object3).removeAndRecycleAllViews((RecyclerView$Recycler)object2);
            object3 = this.mLayout;
            object2 = this.mRecycler;
            ((RecyclerView$LayoutManager)object3).removeAndRecycleScrapInt((RecyclerView$Recycler)object2);
            object3 = this.mRecycler;
            ((RecyclerView$Recycler)object3).clear();
            boolean bl2 = this.mIsAttached;
            if (bl2) {
                object3 = this.mLayout;
                object2 = this.mRecycler;
                ((RecyclerView$LayoutManager)object3).dispatchDetachedFromWindow(this, (RecyclerView$Recycler)object2);
            }
            object3 = this.mLayout;
            object2 = null;
            ((RecyclerView$LayoutManager)object3).setRecyclerView(null);
            this.mLayout = null;
        } else {
            object3 = this.mRecycler;
            ((RecyclerView$Recycler)object3).clear();
        }
        object3 = this.mChildHelper;
        ((ChildHelper)object3).removeAllViewsUnfiltered();
        this.mLayout = object;
        if (object != null) {
            object3 = ((RecyclerView$LayoutManager)object).mRecyclerView;
            if (object3 == null) {
                ((RecyclerView$LayoutManager)object).setRecyclerView(this);
                boolean bl3 = this.mIsAttached;
                if (bl3) {
                    object = this.mLayout;
                    ((RecyclerView$LayoutManager)object).dispatchAttachedToWindow(this);
                }
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("LayoutManager ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" is already attached to a RecyclerView:");
                object = ((RecyclerView$LayoutManager)object).mRecyclerView.exceptionLabel();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                object3 = new IllegalArgumentException((String)object);
                throw object3;
            }
        }
        this.mRecycler.updateViewCacheSize();
        this.requestLayout();
    }

    public void setLayoutTransition(LayoutTransition object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            Animator animator2;
            int n12;
            Animator animator3;
            n10 = 0;
            Animator animator4 = null;
            if (object == null) {
                this.suppressLayout(false);
                return;
            }
            n11 = 4;
            animator4 = object.getAnimator(0);
            if (animator4 == null && (animator3 = object.getAnimator(n10 = 1)) == null && (animator3 = object.getAnimator(n12 = 2)) == null && (animator3 = object.getAnimator(n12 = 3)) == null && (animator2 = object.getAnimator(n11)) == null) {
                this.suppressLayout(n10 != 0);
                return;
            }
        }
        if (object == null) {
            super.setLayoutTransition(null);
            return;
        }
        object = new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        throw object;
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.getScrollingChildHelper().setNestedScrollingEnabled(bl2);
    }

    public void setOnFlingListener(RecyclerView$OnFlingListener recyclerView$OnFlingListener) {
        this.mOnFlingListener = recyclerView$OnFlingListener;
    }

    public void setOnScrollListener(RecyclerView$OnScrollListener recyclerView$OnScrollListener) {
        this.mScrollListener = recyclerView$OnScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean bl2) {
        this.mPreserveFocusAfterLayout = bl2;
    }

    public void setRecycledViewPool(RecyclerView$RecycledViewPool recyclerView$RecycledViewPool) {
        this.mRecycler.setRecycledViewPool(recyclerView$RecycledViewPool);
    }

    public void setRecyclerListener(RecyclerView$RecyclerListener recyclerView$RecyclerListener) {
        this.mRecyclerListener = recyclerView$RecyclerListener;
    }

    public void setScrollState(int n10) {
        int n11 = this.mScrollState;
        if (n10 == n11) {
            return;
        }
        this.mScrollState = n10;
        n11 = 2;
        if (n10 != n11) {
            this.stopScrollersInternal();
        }
        this.dispatchOnScrollStateChanged(n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setScrollingTouchSlop(int n10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.getContext());
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                this.mTouchSlop = n10 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "setScrollingTouchSlop(): bad argument constant ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append("; using default value");
            String string3 = stringBuilder.toString();
            String string4 = TAG;
            Log.w((String)string4, (String)string3);
        }
        this.mTouchSlop = n10 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(RecyclerView$ViewCacheExtension recyclerView$ViewCacheExtension) {
        this.mRecycler.setViewCacheExtension(recyclerView$ViewCacheExtension);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean bl2 = this.isComputingLayout();
        int n10 = 0;
        if (bl2) {
            int n11;
            if (accessibilityEvent != null) {
                n11 = AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent);
            } else {
                n11 = 0;
                accessibilityEvent = null;
            }
            if (n11 != 0) {
                n10 = n11;
            }
            this.mEatenAccessibilityChangeFlags = n11 = this.mEatenAccessibilityChangeFlags | n10;
            return true;
        }
        return false;
    }

    public void smoothScrollBy(int n10, int n11) {
        this.smoothScrollBy(n10, n11, null);
    }

    public void smoothScrollBy(int n10, int n11, Interpolator interpolator2) {
        this.smoothScrollBy(n10, n11, interpolator2, -1 << -1);
    }

    public void smoothScrollBy(int n10, int n11, Interpolator interpolator2, int n12) {
        this.smoothScrollBy(n10, n11, interpolator2, n12, false);
    }

    public void smoothScrollBy(int n10, int n11, Interpolator interpolator2, int n12, boolean bl2) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null) {
            Log.e((String)TAG, (String)"Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        int n13 = this.mLayoutSuppressed;
        if (n13 != 0) {
            return;
        }
        int n14 = recyclerView$LayoutManager.canScrollHorizontally();
        n13 = 0;
        if (n14 == 0) {
            n10 = 0;
        }
        if ((n14 = (recyclerView$LayoutManager = this.mLayout).canScrollVertically()) == 0) {
            n11 = 0;
        }
        if (n10 != 0 || n11 != 0) {
            n14 = -1 << -1;
            int n15 = 1;
            if (n12 != n14 && n12 <= 0) {
                n14 = 0;
                recyclerView$LayoutManager = null;
            } else {
                n14 = n15;
            }
            if (n14 != 0) {
                if (bl2) {
                    if (n10 != 0) {
                        n13 = n15;
                    }
                    if (n11 != 0) {
                        n13 |= 2;
                    }
                    this.startNestedScroll(n13, n15);
                }
                RecyclerView$ViewFlinger recyclerView$ViewFlinger = this.mViewFlinger;
                recyclerView$ViewFlinger.smoothScrollBy(n10, n11, n12, interpolator2);
            } else {
                this.scrollBy(n10, n11);
            }
        }
    }

    public void smoothScrollToPosition(int n10) {
        boolean bl2 = this.mLayoutSuppressed;
        if (bl2) {
            return;
        }
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayout;
        if (recyclerView$LayoutManager == null) {
            Log.e((String)TAG, (String)"Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        RecyclerView$State recyclerView$State = this.mState;
        recyclerView$LayoutManager.smoothScrollToPosition(this, recyclerView$State, n10);
    }

    public void startInterceptRequestLayout() {
        int n10 = this.mInterceptRequestLayoutDepth;
        int n11 = 1;
        this.mInterceptRequestLayoutDepth = n10 += n11;
        if (n10 == n11 && (n10 = (int)(this.mLayoutSuppressed ? 1 : 0)) == 0) {
            n10 = 0;
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int n10) {
        return this.getScrollingChildHelper().startNestedScroll(n10);
    }

    public boolean startNestedScroll(int n10, int n11) {
        return this.getScrollingChildHelper().startNestedScroll(n10, n11);
    }

    public void stopInterceptRequestLayout(boolean bl2) {
        int n10;
        int n11;
        int n12 = this.mInterceptRequestLayoutDepth;
        int n13 = 1;
        if (n12 < n13) {
            this.mInterceptRequestLayoutDepth = n13;
        }
        n12 = 0;
        if (!bl2 && (n11 = this.mLayoutSuppressed) == 0) {
            this.mLayoutWasDefered = false;
        }
        if ((n11 = this.mInterceptRequestLayoutDepth) == n13) {
            boolean bl3;
            Object object;
            boolean bl4;
            boolean bl5;
            if (bl2 && (bl5 = this.mLayoutWasDefered) && !(bl4 = this.mLayoutSuppressed) && (object = this.mLayout) != null && (object = this.mAdapter) != null) {
                this.dispatchLayout();
            }
            if (!(bl3 = this.mLayoutSuppressed)) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth = n10 = this.mInterceptRequestLayoutDepth - n13;
    }

    public void stopNestedScroll() {
        this.getScrollingChildHelper().stopNestedScroll();
    }

    public void stopNestedScroll(int n10) {
        this.getScrollingChildHelper().stopNestedScroll(n10);
    }

    public void stopScroll() {
        this.setScrollState(0);
        this.stopScrollersInternal();
    }

    public final void suppressLayout(boolean bl2) {
        boolean bl3 = this.mLayoutSuppressed;
        if (bl2 != bl3) {
            Object object = "Do not suppressLayout in layout or scroll";
            this.assertNotInLayoutOrScroll((String)object);
            if (!bl2) {
                bl2 = false;
                Object var4_4 = null;
                this.mLayoutSuppressed = false;
                bl3 = this.mLayoutWasDefered;
                if (bl3 && (object = this.mLayout) != null && (object = this.mAdapter) != null) {
                    this.requestLayout();
                }
                this.mLayoutWasDefered = false;
            } else {
                long l10 = SystemClock.uptimeMillis();
                int n10 = 3;
                MotionEvent motionEvent = MotionEvent.obtain((long)l10, (long)l10, (int)n10, (float)0.0f, (float)0.0f, (int)0);
                this.onTouchEvent(motionEvent);
                this.mLayoutSuppressed = bl2 = true;
                this.mIgnoreMotionEventTillDown = bl2;
                this.stopScroll();
            }
        }
    }

    public void swapAdapter(RecyclerView$Adapter recyclerView$Adapter, boolean bl2) {
        this.setLayoutFrozen(false);
        boolean bl3 = true;
        this.setAdapterInternal(recyclerView$Adapter, bl3, bl2);
        this.processDataSetCompletelyChanged(bl3);
        this.requestLayout();
    }

    public void viewRangeUpdate(int n10, int n11, Object object) {
        ChildHelper childHelper = this.mChildHelper;
        int n12 = childHelper.getUnfilteredChildCount();
        int n13 = n10 + n11;
        for (int i10 = 0; i10 < n12; ++i10) {
            boolean bl2;
            int n14;
            Object object2 = this.mChildHelper.getUnfilteredChildAt(i10);
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(object2);
            if (recyclerView$ViewHolder == null || (n14 = recyclerView$ViewHolder.shouldIgnore()) != 0 || (n14 = recyclerView$ViewHolder.mPosition) < n10 || n14 >= n13) continue;
            n14 = 2;
            recyclerView$ViewHolder.addFlags(n14);
            recyclerView$ViewHolder.addChangePayload(object);
            object2 = (RecyclerView$LayoutParams)object2.getLayoutParams();
            object2.mInsetsDirty = bl2 = true;
        }
        this.mRecycler.viewRangeUpdate(n10, n11);
    }
}

