/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.widget.ItemTouchHelper$1;
import androidx.recyclerview.widget.ItemTouchHelper$2;
import androidx.recyclerview.widget.ItemTouchHelper$3;
import androidx.recyclerview.widget.ItemTouchHelper$4;
import androidx.recyclerview.widget.ItemTouchHelper$5;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.ItemTouchHelper$ItemTouchHelperGestureListener;
import androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ChildDrawingOrderCallback;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener;
import androidx.recyclerview.widget.RecyclerView$OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper
extends RecyclerView$ItemDecoration
implements RecyclerView$OnChildAttachStateChangeListener {
    public static final int ACTION_MODE_DRAG_MASK = 0xFF0000;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    public static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    private static final int ACTIVE_POINTER_ID_NONE = 255;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    private static final boolean DEBUG = false;
    public static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    private static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    private int mActionState;
    public int mActivePointerId;
    public ItemTouchHelper$Callback mCallback;
    private RecyclerView$ChildDrawingOrderCallback mChildDrawingOrderCallback;
    private List mDistances;
    private long mDragScrollStartTimeInMs;
    public float mDx;
    public float mDy;
    public GestureDetectorCompat mGestureDetector;
    public float mInitialTouchX;
    public float mInitialTouchY;
    private ItemTouchHelper$ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
    private float mMaxSwipeVelocity;
    private final RecyclerView$OnItemTouchListener mOnItemTouchListener;
    public View mOverdrawChild;
    public int mOverdrawChildPosition;
    public final List mPendingCleanup;
    public List mRecoverAnimations;
    public RecyclerView mRecyclerView;
    public final Runnable mScrollRunnable;
    public RecyclerView$ViewHolder mSelected;
    public int mSelectedFlags;
    private float mSelectedStartX;
    private float mSelectedStartY;
    private int mSlop;
    private List mSwapTargets;
    private float mSwipeEscapeVelocity;
    private final float[] mTmpPosition;
    private Rect mTmpRect;
    public VelocityTracker mVelocityTracker;

    public ItemTouchHelper(ItemTouchHelper$Callback itemTouchHelper$Callback) {
        int n10;
        Object object = new ArrayList();
        this.mPendingCleanup = object;
        object = new float[2];
        this.mTmpPosition = (float[])object;
        this.mSelected = null;
        this.mActivePointerId = n10 = -1;
        this.mActionState = 0;
        Object object2 = new ArrayList();
        this.mRecoverAnimations = object2;
        this.mScrollRunnable = object2 = new ItemTouchHelper$1(this);
        this.mChildDrawingOrderCallback = null;
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = n10;
        this.mOnItemTouchListener = object = new ItemTouchHelper$2(this);
        this.mCallback = itemTouchHelper$Callback;
    }

    private void addChildDrawingOrderCallback() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return;
        }
        Object object = this.mChildDrawingOrderCallback;
        if (object == null) {
            this.mChildDrawingOrderCallback = object = new ItemTouchHelper$5(this);
        }
        object = this.mRecyclerView;
        RecyclerView$ChildDrawingOrderCallback recyclerView$ChildDrawingOrderCallback = this.mChildDrawingOrderCallback;
        ((RecyclerView)object).setChildDrawingOrderCallback(recyclerView$ChildDrawingOrderCallback);
    }

    private int checkHorizontalSwipe(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        int n11 = n10 & 0xC;
        if (n11 != 0) {
            float f10;
            float f11 = this.mDx;
            int n12 = 0;
            float f12 = 0.0f;
            RecyclerView recyclerView = null;
            float f13 = f11 - 0.0f;
            n11 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            int n13 = 8;
            float f14 = 1.1E-44f;
            int n14 = 4;
            float f15 = 5.6E-45f;
            if (n11 > 0) {
                n11 = n13;
                f11 = f14;
            } else {
                n11 = n14;
                f11 = f15;
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                int n15 = this.mActivePointerId;
                int n16 = -1;
                float f16 = 0.0f / 0.0f;
                if (n15 > n16) {
                    float f17;
                    ItemTouchHelper$Callback itemTouchHelper$Callback;
                    float f18;
                    ItemTouchHelper$Callback itemTouchHelper$Callback2 = this.mCallback;
                    float f19 = this.mMaxSwipeVelocity;
                    f16 = itemTouchHelper$Callback2.getSwipeVelocityThreshold(f19);
                    velocityTracker.computeCurrentVelocity(1000, f16);
                    velocityTracker = this.mVelocityTracker;
                    n15 = this.mActivePointerId;
                    float f20 = velocityTracker.getXVelocity(n15);
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    n16 = this.mActivePointerId;
                    float f21 = velocityTracker2.getYVelocity(n16);
                    float f22 = f20 - 0.0f;
                    n12 = (int)(f22 == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1));
                    if (n12 <= 0) {
                        n13 = n14;
                        f14 = f15;
                    }
                    f12 = Math.abs(f20);
                    n14 = n13 & n10;
                    if (n14 != 0 && n11 == n13 && (n14 = (int)((f18 = f12 - (f15 = (itemTouchHelper$Callback = this.mCallback).getSwipeEscapeVelocity(f20 = this.mSwipeEscapeVelocity))) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1))) >= 0 && (n12 = (int)((f17 = f12 - (f15 = Math.abs(f21))) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1))) > 0) {
                        return n13;
                    }
                }
            }
            recyclerView = this.mRecyclerView;
            n12 = recyclerView.getWidth();
            f12 = n12;
            ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
            float f23 = itemTouchHelper$Callback.getSwipeThreshold(recyclerView$ViewHolder);
            f12 *= f23;
            int n17 = n10 & n11;
            if (n17 != 0 && (n17 = (int)((f10 = (f23 = Math.abs(this.mDx)) - f12) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) > 0) {
                return n11;
            }
        }
        return 0;
    }

    private int checkVerticalSwipe(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        int n11 = n10 & 3;
        if (n11 != 0) {
            float f10;
            float f11 = this.mDy;
            int n12 = 0;
            float f12 = 0.0f;
            RecyclerView recyclerView = null;
            float f13 = f11 - 0.0f;
            n11 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            int n13 = 2;
            float f14 = 2.8E-45f;
            int n14 = 1;
            float f15 = Float.MIN_VALUE;
            if (n11 > 0) {
                n11 = n13;
                f11 = f14;
            } else {
                n11 = n14;
                f11 = f15;
            }
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                int n15 = this.mActivePointerId;
                int n16 = -1;
                float f16 = 0.0f / 0.0f;
                if (n15 > n16) {
                    float f17;
                    ItemTouchHelper$Callback itemTouchHelper$Callback;
                    float f18;
                    ItemTouchHelper$Callback itemTouchHelper$Callback2 = this.mCallback;
                    float f19 = this.mMaxSwipeVelocity;
                    f16 = itemTouchHelper$Callback2.getSwipeVelocityThreshold(f19);
                    velocityTracker.computeCurrentVelocity(1000, f16);
                    velocityTracker = this.mVelocityTracker;
                    n15 = this.mActivePointerId;
                    float f20 = velocityTracker.getXVelocity(n15);
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    n16 = this.mActivePointerId;
                    float f21 = velocityTracker2.getYVelocity(n16);
                    float f22 = f21 - 0.0f;
                    n12 = (int)(f22 == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1));
                    if (n12 <= 0) {
                        n13 = n14;
                        f14 = f15;
                    }
                    f12 = Math.abs(f21);
                    n14 = n13 & n10;
                    if (n14 != 0 && n13 == n11 && (n14 = (int)((f18 = f12 - (f15 = (itemTouchHelper$Callback = this.mCallback).getSwipeEscapeVelocity(f21 = this.mSwipeEscapeVelocity))) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1))) >= 0 && (n12 = (int)((f17 = f12 - (f15 = Math.abs(f20))) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1))) > 0) {
                        return n13;
                    }
                }
            }
            recyclerView = this.mRecyclerView;
            n12 = recyclerView.getHeight();
            f12 = n12;
            ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
            float f23 = itemTouchHelper$Callback.getSwipeThreshold(recyclerView$ViewHolder);
            f12 *= f23;
            int n17 = n10 & n11;
            if (n17 != 0 && (n17 = (int)((f10 = (f23 = Math.abs(this.mDy)) - f12) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) > 0) {
                return n11;
            }
        }
        return 0;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        Object object = this.mRecyclerView;
        Object object2 = this.mOnItemTouchListener;
        ((RecyclerView)object).removeOnItemTouchListener((RecyclerView$OnItemTouchListener)object2);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        object = this.mRecoverAnimations;
        for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
            object2 = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(0);
            ((ItemTouchHelper$RecoverAnimation)object2).cancel();
            ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
            RecyclerView recyclerView = this.mRecyclerView;
            object2 = ((ItemTouchHelper$RecoverAnimation)object2).mViewHolder;
            itemTouchHelper$Callback.clearView(recyclerView, (RecyclerView$ViewHolder)object2);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        this.releaseVelocityTracker();
        this.stopGestureDetection();
    }

    private List findSwapTargets(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        ItemTouchHelper itemTouchHelper = this;
        Object object = recyclerView$ViewHolder;
        ArrayList arrayList = this.mSwapTargets;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.mSwapTargets = arrayList;
            this.mDistances = arrayList = new ArrayList();
        } else {
            arrayList.clear();
            arrayList = this.mDistances;
            arrayList.clear();
        }
        arrayList = itemTouchHelper.mCallback;
        int n10 = ((ItemTouchHelper$Callback)((Object)arrayList)).getBoundingBoxMargin();
        float f10 = itemTouchHelper.mSelectedStartX;
        float f11 = itemTouchHelper.mDx;
        int n11 = Math.round(f10 += f11) - n10;
        f11 = itemTouchHelper.mSelectedStartY;
        float f12 = itemTouchHelper.mDy;
        int n12 = Math.round(f11 += f12) - n10;
        View view = ((RecyclerView$ViewHolder)object).itemView;
        int n13 = view.getWidth() + n11;
        View view2 = ((RecyclerView$ViewHolder)object).itemView;
        int n14 = view2.getHeight() + n12 + n10;
        n10 = (n11 + (n13 += (n10 *= 2))) / 2;
        int n15 = (n12 + n14) / 2;
        RecyclerView$LayoutManager recyclerView$LayoutManager = itemTouchHelper.mRecyclerView.getLayoutManager();
        int n16 = recyclerView$LayoutManager.getChildCount();
        for (int i10 = 0; i10 < n16; ++i10) {
            Object object2;
            RecyclerView recyclerView;
            ItemTouchHelper$Callback itemTouchHelper$Callback;
            int n17;
            int n18;
            Object object3;
            Object object4 = recyclerView$LayoutManager.getChildAt(i10);
            if (object4 != (object3 = ((RecyclerView$ViewHolder)object).itemView) && (n18 = object4.getBottom()) >= n12 && (n18 = object4.getTop()) <= n14 && (n18 = object4.getRight()) >= n11 && (n18 = object4.getLeft()) <= n13 && (n17 = (itemTouchHelper$Callback = itemTouchHelper.mCallback).canDropOver(recyclerView = itemTouchHelper.mRecyclerView, (RecyclerView$ViewHolder)(object2 = itemTouchHelper.mSelected), (RecyclerView$ViewHolder)(object3 = itemTouchHelper.mRecyclerView.getChildViewHolder((View)object4)))) != 0) {
                int n19;
                n17 = object4.getLeft();
                int n20 = object4.getRight();
                n17 = (n17 + n20) / 2;
                n17 = Math.abs(n10 - n17);
                n20 = object4.getTop();
                int n21 = object4.getBottom();
                n20 = (n20 + n21) / 2;
                n21 = Math.abs(n15 - n20);
                n17 *= n17;
                n21 *= n21;
                n17 += n21;
                object4 = itemTouchHelper.mSwapTargets;
                n21 = object4.size();
                itemTouchHelper$Callback = null;
                int n22 = 0;
                recyclerView = null;
                for (n20 = 0; n20 < n21 && n17 > (n19 = ((Integer)(object = (Integer)itemTouchHelper.mDistances.get(n20))).intValue()); ++n20) {
                    ++n22;
                    object = recyclerView$ViewHolder;
                }
                itemTouchHelper.mSwapTargets.add(n22, object3);
                object = itemTouchHelper.mDistances;
                object2 = n17;
                object.add(n22, object2);
            }
            object = recyclerView$ViewHolder;
        }
        return itemTouchHelper.mSwapTargets;
    }

    private RecyclerView$ViewHolder findSwipedView(MotionEvent motionEvent) {
        boolean bl2;
        float f10;
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mRecyclerView.getLayoutManager();
        int n10 = this.mActivePointerId;
        int n11 = -1;
        float f11 = 0.0f / 0.0f;
        if (n10 == n11) {
            return null;
        }
        n10 = motionEvent.findPointerIndex(n10);
        f11 = motionEvent.getX(n10);
        float f12 = this.mInitialTouchX;
        f11 -= f12;
        float f13 = motionEvent.getY(n10);
        f12 = this.mInitialTouchY;
        f13 -= f12;
        f11 = Math.abs(f11);
        f13 = Math.abs(f13);
        int n12 = this.mSlop;
        float f14 = n12;
        float f15 = f11 - f14;
        Object object = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
        if (object < 0 && (n12 = (int)((f10 = f13 - (f12 = (float)n12)) == 0.0f ? 0 : (f10 < 0.0f ? -1 : 1))) < 0) {
            return null;
        }
        n12 = (int)(f11 == f13 ? 0 : (f11 > f13 ? 1 : -1));
        if (n12 > 0 && (n12 = (int)(recyclerView$LayoutManager.canScrollHorizontally() ? 1 : 0)) != 0) {
            return null;
        }
        n10 = (int)(f13 == f11 ? 0 : (f13 > f11 ? 1 : -1));
        if (n10 > 0 && (bl2 = recyclerView$LayoutManager.canScrollVertically())) {
            return null;
        }
        if ((motionEvent = this.findChildView(motionEvent)) == null) {
            return null;
        }
        return this.mRecyclerView.getChildViewHolder((View)motionEvent);
    }

    private void getSelectedDxDy(float[] fArray) {
        View view;
        int n10;
        View view2;
        float f10;
        float f11;
        int n11 = this.mSelectedFlags & 0xC;
        int n12 = 0;
        if (n11 != 0) {
            f11 = this.mSelectedStartX;
            f10 = this.mDx;
            f11 += f10;
            view2 = this.mSelected.itemView;
            n10 = view2.getLeft();
            f10 = n10;
            fArray[0] = f11 -= f10;
        } else {
            view = this.mSelected.itemView;
            fArray[0] = f11 = view.getTranslationX();
        }
        n11 = this.mSelectedFlags & 3;
        n12 = 1;
        if (n11 != 0) {
            f11 = this.mSelectedStartY;
            f10 = this.mDy;
            f11 += f10;
            view2 = this.mSelected.itemView;
            n10 = view2.getTop();
            f10 = n10;
            fArray[n12] = f11 -= f10;
        } else {
            view = this.mSelected.itemView;
            fArray[n12] = f11 = view.getTranslationY();
        }
    }

    private static boolean hitTest(View view, float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        int n10;
        float f16;
        float f17;
        float f18;
        Object object = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        if (object >= 0 && (f18 = (f17 = f10 - (f12 += (f16 = (float)(object = (Object)view.getWidth())))) == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1)) <= 0 && (f18 = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1)) >= 0 && (n10 = (f15 = f11 - (f13 += (f14 = (float)view.getHeight()))) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) <= 0) {
            n10 = 1;
            f14 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f14 = 0.0f;
            view = null;
        }
        return n10 != 0;
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            velocityTracker = null;
            this.mVelocityTracker = null;
        }
    }

    private void setupCallbacks() {
        int n10;
        this.mSlop = n10 = ViewConfiguration.get((Context)this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView$OnItemTouchListener recyclerView$OnItemTouchListener = this.mOnItemTouchListener;
        recyclerView.addOnItemTouchListener(recyclerView$OnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        this.startGestureDetection();
    }

    private void startGestureDetection() {
        Object object;
        this.mItemTouchHelperGestureListener = object = new ItemTouchHelper$ItemTouchHelperGestureListener(this);
        Context context = this.mRecyclerView.getContext();
        ItemTouchHelper$ItemTouchHelperGestureListener itemTouchHelper$ItemTouchHelperGestureListener = this.mItemTouchHelperGestureListener;
        object = new GestureDetectorCompat(context, (GestureDetector.OnGestureListener)itemTouchHelper$ItemTouchHelperGestureListener);
        this.mGestureDetector = object;
    }

    private void stopGestureDetection() {
        Object object = this.mItemTouchHelperGestureListener;
        if (object != null) {
            object.doNotReactToLongPress();
            this.mItemTouchHelperGestureListener = null;
        }
        if ((object = this.mGestureDetector) != null) {
            this.mGestureDetector = null;
        }
    }

    private int swipeIfNecessary(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        float f10;
        int n10 = this.mActionState;
        int n11 = 2;
        if (n10 == n11) {
            return 0;
        }
        Object object = this.mCallback;
        Object object2 = this.mRecyclerView;
        n10 = ((ItemTouchHelper$Callback)object).getMovementFlags((RecyclerView)object2, recyclerView$ViewHolder);
        object2 = this.mCallback;
        RecyclerView recyclerView = this.mRecyclerView;
        int n12 = ViewCompat.getLayoutDirection((View)recyclerView);
        n11 = ((ItemTouchHelper$Callback)object2).convertToAbsoluteDirection(n10, n12);
        n12 = 65280;
        float f11 = 9.1477E-41f;
        if ((n11 = (n11 & n12) >> 8) == 0) {
            return 0;
        }
        n10 = (n10 & n12) >> 8;
        f11 = Math.abs(this.mDx);
        float f12 = f11 - (f10 = Math.abs(this.mDy));
        n12 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
        if (n12 > 0) {
            n12 = this.checkHorizontalSwipe(recyclerView$ViewHolder, n11);
            if (n12 > 0) {
                int n13 = n10 & n12;
                if (n13 == 0) {
                    n13 = ViewCompat.getLayoutDirection((View)this.mRecyclerView);
                    return ItemTouchHelper$Callback.convertToRelativeDirection(n12, n13);
                }
                return n12;
            }
            int n14 = this.checkVerticalSwipe(recyclerView$ViewHolder, n11);
            if (n14 > 0) {
                return n14;
            }
        } else {
            n12 = this.checkVerticalSwipe(recyclerView$ViewHolder, n11);
            if (n12 > 0) {
                return n12;
            }
            int n15 = this.checkHorizontalSwipe(recyclerView$ViewHolder, n11);
            if (n15 > 0) {
                if ((n10 &= n15) == 0) {
                    object = this.mRecyclerView;
                    n10 = ViewCompat.getLayoutDirection((View)object);
                    n15 = ItemTouchHelper$Callback.convertToRelativeDirection(n15, n10);
                }
                return n15;
            }
        }
        return 0;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            this.destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            float f10;
            float f11;
            recyclerView = recyclerView.getResources();
            int n10 = R$dimen.item_touch_helper_swipe_escape_velocity;
            this.mSwipeEscapeVelocity = f11 = recyclerView.getDimension(n10);
            n10 = R$dimen.item_touch_helper_swipe_escape_max_velocity;
            this.mMaxSwipeVelocity = f10 = recyclerView.getDimension(n10);
            this.setupCallbacks();
        }
    }

    public void checkSelectForSwipe(int n10, MotionEvent motionEvent, int n11) {
        Object object;
        int n12;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.mSelected;
        if (recyclerView$ViewHolder == null && n10 == (n12 = 2) && (n10 = this.mActionState) != n12 && (n10 = (int)(((ItemTouchHelper$Callback)(object = this.mCallback)).isItemViewSwipeEnabled() ? 1 : 0)) != 0) {
            int n13;
            float f10;
            float f11;
            int n14;
            object = this.mRecyclerView;
            n10 = ((RecyclerView)object).getScrollState();
            if (n10 == (n14 = 1)) {
                return;
            }
            object = this.findSwipedView(motionEvent);
            if (object == null) {
                return;
            }
            ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
            RecyclerView recyclerView = this.mRecyclerView;
            int n15 = itemTouchHelper$Callback.getAbsoluteMovementFlags(recyclerView, (RecyclerView$ViewHolder)object);
            int n16 = 65280;
            float f12 = 9.1477E-41f;
            if ((n15 = (n15 & n16) >> 8) == 0) {
                return;
            }
            f12 = motionEvent.getX(n11);
            float f13 = motionEvent.getY(n11);
            float f14 = this.mInitialTouchX;
            f12 -= f14;
            f14 = this.mInitialTouchY;
            f13 -= f14;
            f14 = Math.abs(f12);
            float f15 = Math.abs(f13);
            int n17 = this.mSlop;
            float f16 = n17;
            float f17 = f14 - f16;
            Object object2 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
            if (object2 < 0 && (n17 = (int)((f11 = f15 - (f10 = (float)n17)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1))) < 0) {
                return;
            }
            float f18 = f14 == f15 ? 0 : (f14 > f15 ? 1 : -1);
            f15 = 0.0f;
            if (f18 > 0) {
                float f19 = f12 - 0.0f;
                n11 = (int)(f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1));
                if (n11 < 0 && (n11 = n15 & 4) == 0) {
                    return;
                }
                float f20 = f12 - 0.0f;
                n11 = (int)(f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1));
                if (n11 > 0 && (n11 = n15 & 8) == 0) {
                    return;
                }
            } else {
                float f21 = f13 - 0.0f;
                n16 = (int)(f21 == 0.0f ? 0 : (f21 < 0.0f ? -1 : 1));
                if (n16 < 0 && (n16 = n15 & 1) == 0) {
                    return;
                }
                float f22 = f13 - 0.0f;
                n11 = (int)(f22 == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1));
                if (n11 > 0 && (n11 = n15 & 2) == 0) {
                    return;
                }
            }
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            n11 = 0;
            f13 = 0.0f;
            this.mActivePointerId = n13 = motionEvent.getPointerId(0);
            this.select((RecyclerView$ViewHolder)object, n14);
        }
    }

    public void endRecoverAnimation(RecyclerView$ViewHolder recyclerView$ViewHolder, boolean bl2) {
        List list = this.mRecoverAnimations;
        for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
            boolean bl3;
            ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(i10);
            RecyclerView$ViewHolder recyclerView$ViewHolder2 = itemTouchHelper$RecoverAnimation.mViewHolder;
            if (recyclerView$ViewHolder2 != recyclerView$ViewHolder) continue;
            itemTouchHelper$RecoverAnimation.mOverridden = bl3 = itemTouchHelper$RecoverAnimation.mOverridden | bl2;
            bl3 = itemTouchHelper$RecoverAnimation.mEnded;
            if (!bl3) {
                itemTouchHelper$RecoverAnimation.cancel();
            }
            this.mRecoverAnimations.remove(i10);
            return;
        }
    }

    public ItemTouchHelper$RecoverAnimation findAnimation(MotionEvent motionEvent) {
        List list = this.mRecoverAnimations;
        int n10 = list.isEmpty();
        if (n10 != 0) {
            return null;
        }
        motionEvent = this.findChildView(motionEvent);
        list = this.mRecoverAnimations;
        for (n10 = list.size() + -1; n10 >= 0; n10 += -1) {
            ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(n10);
            View view = itemTouchHelper$RecoverAnimation.mViewHolder.itemView;
            if (view != motionEvent) continue;
            return itemTouchHelper$RecoverAnimation;
        }
        return null;
    }

    public View findChildView(MotionEvent motionEvent) {
        boolean bl2;
        float f10;
        float f11;
        float f12 = motionEvent.getX();
        float f13 = motionEvent.getY();
        Object object = this.mSelected;
        if (object != null) {
            object = ((RecyclerView$ViewHolder)object).itemView;
            f11 = this.mSelectedStartX;
            float f14 = this.mDx;
            f11 += f14;
            f14 = this.mSelectedStartY;
            f10 = this.mDy;
            bl2 = ItemTouchHelper.hitTest((View)object, f12, f13, f11, f14 += f10);
            if (bl2) {
                return object;
            }
        }
        object = this.mRecoverAnimations;
        for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
            ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(i10);
            View view = itemTouchHelper$RecoverAnimation.mViewHolder.itemView;
            f10 = itemTouchHelper$RecoverAnimation.mX;
            f11 = itemTouchHelper$RecoverAnimation.mY;
            bl2 = ItemTouchHelper.hitTest(view, f12, f13, f10, f11);
            if (!bl2) continue;
            return view;
        }
        return this.mRecyclerView.findChildViewUnder(f12, f13);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView$State recyclerView$State) {
        rect.setEmpty();
    }

    public boolean hasRunningRecoverAnim() {
        List list = this.mRecoverAnimations;
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation = (ItemTouchHelper$RecoverAnimation)this.mRecoverAnimations.get(i10);
            boolean bl2 = itemTouchHelper$RecoverAnimation.mEnded;
            if (bl2) continue;
            return true;
        }
        return false;
    }

    public void moveIfNecessary(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        Object object;
        int n10;
        Object object2 = this.mRecyclerView;
        int n11 = object2.isLayoutRequested();
        if (n11 != 0) {
            return;
        }
        n11 = this.mActionState;
        int n12 = 2;
        float f10 = 2.8E-45f;
        if (n11 != n12) {
            return;
        }
        object2 = this.mCallback;
        float f11 = ((ItemTouchHelper$Callback)object2).getMoveThreshold(recyclerView$ViewHolder);
        f10 = this.mSelectedStartX;
        float f12 = this.mDx;
        int n13 = (int)(f10 + f12);
        f10 = this.mSelectedStartY;
        f12 = this.mDy;
        int n14 = (int)(f10 + f12);
        Object object3 = recyclerView$ViewHolder.itemView;
        n12 = object3.getTop();
        f10 = Math.abs(n14 - n12);
        float f13 = f10 - (f12 = (float)(n10 = (object = recyclerView$ViewHolder.itemView).getHeight()) * f11);
        if ((n12 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1))) < 0) {
            object3 = recyclerView$ViewHolder.itemView;
            n12 = object3.getLeft();
            f10 = n12 = Math.abs(n13 - n12);
            float f14 = f10 - (f12 = (float)(n10 = (object = recyclerView$ViewHolder.itemView).getWidth()) * f11);
            n11 = (int)(f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1));
            if (n11 < 0) {
                return;
            }
        }
        if ((n12 = (object2 = this.findSwapTargets(recyclerView$ViewHolder)).size()) == 0) {
            return;
        }
        object3 = this.mCallback;
        RecyclerView$ViewHolder recyclerView$ViewHolder2 = ((ItemTouchHelper$Callback)object3).chooseDropTarget(recyclerView$ViewHolder, (List)object2, n13, n14);
        if (recyclerView$ViewHolder2 == null) {
            this.mSwapTargets.clear();
            this.mDistances.clear();
            return;
        }
        int n15 = recyclerView$ViewHolder2.getAbsoluteAdapterPosition();
        int n16 = recyclerView$ViewHolder.getAbsoluteAdapterPosition();
        object2 = this.mCallback;
        object3 = this.mRecyclerView;
        n11 = (int)(((ItemTouchHelper$Callback)object2).onMove((RecyclerView)object3, recyclerView$ViewHolder, recyclerView$ViewHolder2) ? 1 : 0);
        if (n11 != 0) {
            object = this.mCallback;
            RecyclerView recyclerView = this.mRecyclerView;
            ((ItemTouchHelper$Callback)object).onMoved(recyclerView, recyclerView$ViewHolder, n16, recyclerView$ViewHolder2, n15, n13, n14);
        }
    }

    public void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = velocityTracker = VelocityTracker.obtain();
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View object) {
        this.removeChildDrawingOrderCallbackIfNecessary((View)object);
        Object object2 = this.mRecyclerView;
        object = ((RecyclerView)object2).getChildViewHolder((View)object);
        if (object == null) {
            return;
        }
        object2 = this.mSelected;
        Object object3 = null;
        if (object2 != null && object == object2) {
            object = null;
            this.select(null, 0);
        } else {
            this.endRecoverAnimation((RecyclerView$ViewHolder)object, false);
            object2 = this.mPendingCleanup;
            object3 = object.itemView;
            boolean bl2 = object2.remove(object3);
            if (bl2) {
                object2 = this.mCallback;
                object3 = this.mRecyclerView;
                ((ItemTouchHelper$Callback)object2).clearView((RecyclerView)object3, (RecyclerView$ViewHolder)object);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView$State object) {
        Object object2;
        Object object3;
        int n10 = -1;
        Object object4 = 0.0f / 0.0f;
        this.mOverdrawChildPosition = n10;
        object = this.mSelected;
        Object object5 = 0.0f;
        if (object != null) {
            object = this.mTmpPosition;
            this.getSelectedDxDy((float[])object);
            object = this.mTmpPosition;
            object5 = object[0];
            int n11 = 1;
            object3 = object4 = (Object)object[n11];
            object2 = object5;
        } else {
            object2 = 0.0f;
            object3 = 0.0f;
        }
        ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.mSelected;
        List list = this.mRecoverAnimations;
        int n12 = this.mActionState;
        itemTouchHelper$Callback.onDraw(canvas, recyclerView, recyclerView$ViewHolder, list, n12, (float)object2, (float)object3);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView$State object) {
        Object object2;
        Object object3;
        object = this.mSelected;
        Object object4 = 0.0f;
        if (object != null) {
            object = this.mTmpPosition;
            this.getSelectedDxDy((float[])object);
            object = this.mTmpPosition;
            object4 = object[0];
            int n10 = 1;
            Object object5 = object[n10];
            object3 = object5;
            object2 = object4;
        } else {
            object2 = 0.0f;
            object3 = 0.0f;
        }
        ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.mSelected;
        List list = this.mRecoverAnimations;
        int n11 = this.mActionState;
        itemTouchHelper$Callback.onDrawOver(canvas, recyclerView, recyclerView$ViewHolder, list, n11, (float)object2, (float)object3);
    }

    public void postDispatchSwipe(ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation, int n10) {
        RecyclerView recyclerView = this.mRecyclerView;
        ItemTouchHelper$4 itemTouchHelper$4 = new ItemTouchHelper$4(this, itemTouchHelper$RecoverAnimation, n10);
        recyclerView.post(itemTouchHelper$4);
    }

    public void removeChildDrawingOrderCallbackIfNecessary(View view) {
        Object object = this.mOverdrawChild;
        if (view == object) {
            view = null;
            this.mOverdrawChild = null;
            object = this.mChildDrawingOrderCallback;
            if (object != null) {
                object = this.mRecyclerView;
                ((RecyclerView)object).setChildDrawingOrderCallback(null);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean scrollIfNecessary() {
        block15: {
            block13: {
                block14: {
                    block12: {
                        block11: {
                            var1_1 = this;
                            var2_2 = this.mSelected;
                            var3_3 /* !! */  = false;
                            var4_4 = -9223372036854775808L;
                            if (var2_2 == null) {
                                this.mDragScrollStartTimeInMs = var4_4;
                                return false;
                            }
                            var6_5 = System.currentTimeMillis();
                            var8_6 = this.mDragScrollStartTimeInMs;
                            cfr_temp_0 = var8_6 - var4_4;
                            var10_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                            var8_6 = var10_7 /* !! */  == false ? 0L : var6_5 - var8_6;
                            var2_2 = var1_1.mRecyclerView.getLayoutManager();
                            var11_8 = var1_1.mTmpRect;
                            if (var11_8 == null) {
                                var11_8 = new Rect();
                                var1_1.mTmpRect = var11_8;
                            }
                            var11_8 = var1_1.mSelected.itemView;
                            var12_9 /* !! */  = var1_1.mTmpRect;
                            var2_2.calculateItemDecorationsForChild((View)var11_8, var12_9 /* !! */ );
                            var13_10 = var2_2.canScrollHorizontally();
                            var14_11 = 0;
                            var12_9 /* !! */  = null;
                            if (var13_10 == 0) ** GOTO lbl-1000
                            var15_12 = var1_1.mSelectedStartX;
                            var16_13 = var1_1.mDx;
                            var13_10 = (int)(var15_12 += var16_13);
                            var17_14 /* !! */  = var1_1.mTmpRect;
                            var18_15 = var17_14 /* !! */ .left;
                            var18_15 = var13_10 - var18_15;
                            var19_16 = var1_1.mRecyclerView;
                            var20_17 = var19_16.getPaddingLeft();
                            var21_18 = var1_1.mDx;
                            cfr_temp_1 = var21_18 - 0.0f;
                            var22_19 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1));
                            if (var22_19 >= 0 || (var18_15 -= var20_17) >= 0) break block11;
                            var20_17 = var18_15;
                            break block12;
                        }
                        cfr_temp_2 = var21_18 - 0.0f;
                        var18_15 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1));
                        if (var18_15 <= 0) ** GOTO lbl-1000
                        var18_15 = var1_1.mSelected.itemView.getWidth();
                        var13_10 += var18_15;
                        var18_15 = var1_1.mTmpRect.right;
                        var13_10 += var18_15;
                        var17_14 /* !! */  = var1_1.mRecyclerView;
                        var18_15 = var17_14 /* !! */ .getWidth();
                        var19_16 = var1_1.mRecyclerView;
                        var20_17 = var19_16.getPaddingRight();
                        if ((var13_10 -= (var18_15 -= var20_17)) > 0) {
                            var20_17 = var13_10;
                        } else lbl-1000:
                        // 3 sources

                        {
                            var20_17 = 0;
                            var19_16 = null;
                            var21_18 = 0.0f;
                        }
                    }
                    var10_7 /* !! */  = (long)var2_2.canScrollVertically();
                    if (var10_7 /* !! */  == false) break block13;
                    var23_20 = var1_1.mSelectedStartY;
                    var15_12 = var1_1.mDy;
                    var10_7 /* !! */  = (int)(var23_20 += var15_12);
                    var11_8 = var1_1.mTmpRect;
                    var13_10 = var11_8.top;
                    var13_10 = (int)(var10_7 /* !! */  - var13_10);
                    var17_14 /* !! */  = var1_1.mRecyclerView;
                    var18_15 = var17_14 /* !! */ .getPaddingTop();
                    var16_13 = var1_1.mDy;
                    cfr_temp_3 = var16_13 - 0.0f;
                    var22_19 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 < 0.0f ? -1 : 1));
                    if (var22_19 >= 0 || (var13_10 -= var18_15) >= 0) break block14;
                    var10_7 /* !! */  = var13_10;
                    break block15;
                }
                cfr_temp_4 = var16_13 - 0.0f;
                var13_10 = (int)(cfr_temp_4 == 0.0f ? 0 : (cfr_temp_4 > 0.0f ? 1 : -1));
                if (var13_10 <= 0) break block13;
                var13_10 = var1_1.mSelected.itemView.getHeight();
                var10_7 /* !! */  += var13_10;
                var13_10 = var1_1.mTmpRect.bottom;
                var10_7 /* !! */  += var13_10;
                var11_8 = var1_1.mRecyclerView;
                var13_10 = var11_8.getHeight();
                var12_9 /* !! */  = var1_1.mRecyclerView;
                var14_11 = var12_9 /* !! */ .getPaddingBottom();
                if ((var10_7 /* !! */  -= (var13_10 -= var14_11)) > 0) break block15;
            }
            var10_7 /* !! */  = 0;
            var2_2 = null;
            var23_20 = 0.0f;
        }
        if (var20_17 != 0) {
            var11_8 = var1_1.mCallback;
            var12_9 /* !! */  = var1_1.mRecyclerView;
            var17_14 /* !! */  = var1_1.mSelected.itemView;
            var18_15 = var17_14 /* !! */ .getWidth();
            var24_21 = var1_1.mRecyclerView;
            var22_19 = var24_21.getWidth();
            var20_17 = var11_8.interpolateOutOfBoundsScroll((RecyclerView)var12_9 /* !! */ , var18_15, var20_17, var22_19, var8_6);
        }
        var25_22 = var20_17;
        if (var10_7 /* !! */  != false) {
            var11_8 = var1_1.mCallback;
            var12_9 /* !! */  = var1_1.mRecyclerView;
            var17_14 /* !! */  = var1_1.mSelected.itemView;
            var18_15 = var17_14 /* !! */ .getHeight();
            var19_16 = var1_1.mRecyclerView;
            var22_19 = var19_16.getHeight();
            var20_17 = (int)var10_7 /* !! */ ;
            var10_7 /* !! */  = var25_22;
            var26_23 = var11_8.interpolateOutOfBoundsScroll((RecyclerView)var12_9 /* !! */ , var18_15, var20_17, var22_19, var8_6);
            var20_17 = var25_22;
            var10_7 /* !! */  = var26_23;
        }
        if (var20_17 == 0 && var10_7 /* !! */  == false) {
            var1_1.mDragScrollStartTimeInMs = var4_4;
            return false;
        }
        var8_6 = var1_1.mDragScrollStartTimeInMs;
        cfr_temp_5 = var8_6 - var4_4;
        var3_3 /* !! */  = cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1);
        if (!var3_3 /* !! */ ) {
            var1_1.mDragScrollStartTimeInMs = var6_5;
        }
        var1_1.mRecyclerView.scrollBy(var20_17, (int)var10_7 /* !! */ );
        return true;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void select(RecyclerView$ViewHolder var1_1, int var2_2) {
        block19: {
            block14: {
                block18: {
                    block15: {
                        block17: {
                            block16: {
                                var3_3 = this;
                                var4_4 = var1_1;
                                var5_5 = var2_2;
                                var6_6 = this.mSelected;
                                if (var1_1 == var6_6 && var2_2 == (var7_7 = this.mActionState)) {
                                    return;
                                }
                                var3_3.mDragScrollStartTimeInMs = var8_8 = -9223372036854775808L;
                                var10_9 = var3_3.mActionState;
                                var11_10 = 1;
                                var3_3.endRecoverAnimation(var4_4, (boolean)var11_10);
                                var3_3.mActionState = var5_5;
                                var12_11 = 2;
                                var13_12 = 2.8E-45f;
                                if (var5_5 == var12_11) {
                                    if (var4_4 != null) {
                                        var6_6 = var4_4.itemView;
                                        var3_3.mOverdrawChild = var6_6;
                                        this.addChildDrawingOrderCallback();
                                    } else {
                                        var6_6 = new IllegalArgumentException("Must pass a ViewHolder when dragging");
                                        throw var6_6;
                                    }
                                }
                                var7_7 = var5_5 * 8;
                                var14_13 = 8;
                                var15_14 = 1.1E-44f;
                                var7_7 += var14_13;
                                var7_7 = var11_10 << var7_7;
                                var16_15 = var7_7 + -1;
                                var17_16 = var3_3.mSelected;
                                var18_17 = false;
                                if (var17_16 == null) break block14;
                                var6_6 = var17_16.itemView.getParent();
                                if (var6_6 == null) break block15;
                                var19_18 = var10_9 == var12_11 ? 0 : (var7_7 = var3_3.swipeIfNecessary(var17_16));
                                this.releaseVelocityTracker();
                                var7_7 = 4;
                                var20_19 = 5.6E-45f;
                                var21_20 = 0;
                                var22_21 = null;
                                if (var19_18 == var11_10 || var19_18 == var12_11) break block16;
                                if (var19_18 == var7_7 || var19_18 == var14_13) ** GOTO lbl-1000
                                var23_22 = 16;
                                var24_23 = 2.24E-44f;
                                if (var19_18 == var23_22) ** GOTO lbl-1000
                                var23_22 = 32;
                                var24_23 = 4.5E-44f;
                                if (var19_18 != var23_22) {
                                    var25_24 = 0.0f;
                                    var26_25 = 0.0f;
                                } else lbl-1000:
                                // 3 sources

                                {
                                    var24_23 = Math.signum(var3_3.mDx);
                                    var27_26 = var3_3.mRecyclerView;
                                    var28_28 = var27_26.getWidth();
                                    var29_29 = var28_28;
                                    var26_25 = 0.0f;
                                    var25_24 = var24_23 *= var29_29;
                                }
                                break block17;
                            }
                            var24_23 = Math.signum(var3_3.mDy);
                            var27_27 = var3_3.mRecyclerView;
                            var28_28 = var27_27.getHeight();
                            var29_29 = var28_28;
                            var25_24 = 0.0f;
                            var26_25 = var24_23 *= var29_29;
                        }
                        if (var10_9 == var12_11) {
                            var30_30 = var14_13;
                            var31_31 /* !! */  = var15_14;
                        } else if (var19_18 > 0) {
                            var30_30 = var12_11;
                            var31_31 /* !! */  = var13_12;
                        } else {
                            var30_30 = var7_7;
                            var31_31 /* !! */  = var20_19;
                        }
                        var6_6 = var3_3.mTmpPosition;
                        var3_3.getSelectedDxDy((float[])var6_6);
                        var6_6 = var3_3.mTmpPosition;
                        var32_32 = var6_6[0];
                        var33_33 = var6_6[var11_10];
                        var6_6 = var34_34;
                        var22_21 = this;
                        var35_35 = var17_16;
                        var28_28 = var30_30;
                        var29_29 = var31_31 /* !! */ ;
                        var12_11 = var30_30;
                        var13_12 = var31_31 /* !! */ ;
                        var31_31 /* !! */  = (float)var33_33;
                        var34_34 = new ItemTouchHelper$3(this, var17_16, var30_30, var10_9, (float)var32_32, (float)var33_33, var25_24, var26_25, var19_18, var17_16);
                        var6_6 = var3_3.mCallback;
                        var22_21 = var3_3.mRecyclerView;
                        var24_23 = var25_24 - var32_32;
                        var29_29 = var26_25 - var33_33;
                        var8_8 = var6_6.getAnimationDuration((RecyclerView)var22_21, var30_30, var24_23, var29_29);
                        var34_34.setDuration(var8_8);
                        var6_6 = var3_3.mRecoverAnimations;
                        var6_6.add(var34_34);
                        var34_34.start();
                        var18_17 = true;
                        break block18;
                    }
                    var6_6 = var17_16;
                    var22_21 = var17_16.itemView;
                    var3_3.removeChildDrawingOrderCallbackIfNecessary((View)var22_21);
                    var22_21 = var3_3.mCallback;
                    var35_35 = var3_3.mRecyclerView;
                    var22_21.clearView((RecyclerView)var35_35, var17_16);
                    var18_17 = false;
                }
                var7_7 = 0;
                var20_19 = 0.0f;
                var6_6 = null;
                var3_3.mSelected = null;
                break block19;
            }
            var18_17 = false;
        }
        if (var4_4 == null) ** GOTO lbl-1000
        var6_6 = var3_3.mCallback;
        var22_21 = var3_3.mRecyclerView;
        var7_7 = var6_6.getAbsoluteMovementFlags((RecyclerView)var22_21, var4_4) & var16_15;
        var21_20 = var3_3.mActionState * 8;
        var3_3.mSelectedFlags = var7_7 >>= var21_20;
        var3_3.mSelectedStartX = var20_19 = (float)var4_4.itemView.getLeft();
        var6_6 = var4_4.itemView;
        var3_3.mSelectedStartY = var20_19 = (float)var6_6.getTop();
        var3_3.mSelected = var4_4;
        var7_7 = 2;
        var20_19 = 2.8E-45f;
        if (var5_5 == var7_7) {
            var6_6 = var4_4.itemView;
            var21_20 = 0;
            var22_21 = null;
            var6_6.performHapticFeedback(0);
        } else lbl-1000:
        // 2 sources

        {
            var21_20 = 0;
            var22_21 = null;
        }
        var6_6 = var3_3.mRecyclerView.getParent();
        if (var6_6 != null) {
            var35_35 = var3_3.mSelected;
            var11_10 = var35_35 != null ? 1 : 0;
            var6_6.requestDisallowInterceptTouchEvent((boolean)var11_10);
        }
        if (!var18_17) {
            var6_6 = var3_3.mRecyclerView.getLayoutManager();
            var6_6.requestSimpleAnimationsInNextLayout();
        }
        var6_6 = var3_3.mCallback;
        var22_21 = var3_3.mSelected;
        var23_22 = var3_3.mActionState;
        var6_6.onSelectedChanged((RecyclerView$ViewHolder)var22_21, var23_22);
        var3_3.mRecyclerView.invalidate();
    }

    public void startDrag(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        RecyclerView recyclerView;
        ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
        Object object = this.mRecyclerView;
        boolean bl2 = itemTouchHelper$Callback.hasDragFlag((RecyclerView)object, recyclerView$ViewHolder);
        object = TAG;
        if (!bl2) {
            Log.e((String)object, (String)"Start drag has been called but dragging is not enabled");
            return;
        }
        itemTouchHelper$Callback = recyclerView$ViewHolder.itemView.getParent();
        if (itemTouchHelper$Callback != (recyclerView = this.mRecyclerView)) {
            Log.e((String)object, (String)"Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
            return;
        }
        this.obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.select(recyclerView$ViewHolder, 2);
    }

    public void startSwipe(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        RecyclerView recyclerView;
        ItemTouchHelper$Callback itemTouchHelper$Callback = this.mCallback;
        Object object = this.mRecyclerView;
        boolean bl2 = itemTouchHelper$Callback.hasSwipeFlag((RecyclerView)object, recyclerView$ViewHolder);
        object = TAG;
        if (!bl2) {
            Log.e((String)object, (String)"Start swipe has been called but swiping is not enabled");
            return;
        }
        itemTouchHelper$Callback = recyclerView$ViewHolder.itemView.getParent();
        if (itemTouchHelper$Callback != (recyclerView = this.mRecyclerView)) {
            Log.e((String)object, (String)"Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
            return;
        }
        this.obtainVelocityTracker();
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.select(recyclerView$ViewHolder, 1);
    }

    public void updateDxDy(MotionEvent motionEvent, int n10, int n11) {
        float f10 = motionEvent.getX(n11);
        float f11 = motionEvent.getY(n11);
        float f12 = this.mInitialTouchX;
        this.mDx = f10 -= f12;
        f12 = this.mInitialTouchY;
        this.mDy = f11 -= f12;
        int n12 = n10 & 4;
        n11 = 0;
        f12 = 0.0f;
        if (n12 == 0) {
            this.mDx = f11 = Math.max(0.0f, f10);
        }
        if ((n12 = n10 & 8) == 0) {
            f11 = this.mDx;
            this.mDx = f11 = Math.min(0.0f, f11);
        }
        if ((n12 = n10 & 1) == 0) {
            f11 = this.mDy;
            this.mDy = f11 = Math.max(0.0f, f11);
        }
        if ((n12 = n10 & 2) == 0) {
            f11 = this.mDy;
            this.mDy = f11 = Math.min(0.0f, f11);
        }
    }
}

