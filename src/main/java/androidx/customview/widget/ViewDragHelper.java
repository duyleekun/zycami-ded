/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 */
package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper$1;
import androidx.customview.widget.ViewDragHelper$2;
import androidx.customview.widget.ViewDragHelper$Callback;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = 255;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator;
    private int mActivePointerId;
    private final ViewDragHelper$Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private final Runnable mSetIdleRunnable;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    static {
        ViewDragHelper$1 viewDragHelper$1 = new ViewDragHelper$1();
        sInterpolator = viewDragHelper$1;
    }

    private ViewDragHelper(Context object, ViewGroup viewGroup, ViewDragHelper$Callback viewDragHelper$Callback) {
        int n10;
        this.mActivePointerId = n10 = -1;
        ViewDragHelper$2 viewDragHelper$2 = new ViewDragHelper$2(this);
        this.mSetIdleRunnable = viewDragHelper$2;
        if (viewGroup != null) {
            if (viewDragHelper$Callback != null) {
                float f10;
                float f11;
                int n11;
                this.mParentView = viewGroup;
                this.mCallback = viewDragHelper$Callback;
                viewGroup = ViewConfiguration.get((Context)object);
                this.mDefaultEdgeSize = n11 = (int)(object.getResources().getDisplayMetrics().density * 20.0f + 0.5f);
                this.mEdgeSize = n11;
                this.mTouchSlop = n11 = viewGroup.getScaledTouchSlop();
                this.mMaxVelocity = f11 = (float)viewGroup.getScaledMaximumFlingVelocity();
                this.mMinVelocity = f10 = (float)viewGroup.getScaledMinimumFlingVelocity();
                viewDragHelper$Callback = sInterpolator;
                super(object, (Interpolator)viewDragHelper$Callback);
                this.mScroller = viewGroup;
                return;
            }
            super("Callback may not be null");
            throw object;
        }
        super("Parent view may not be null");
        throw object;
    }

    private boolean checkNewEdgeDrag(float f10, float f11, int n10, int n11) {
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        f10 = Math.abs(f10);
        f11 = Math.abs(f11);
        int[] nArray = this.mInitialEdgesTouched;
        int n12 = nArray[n10] & n11;
        boolean bl2 = false;
        if (n12 == n11 && (n12 = this.mTrackingEdges & n11) != 0 && (n12 = (nArray = this.mEdgeDragsLocked)[n10] & n11) != n11 && (n12 = (nArray = this.mEdgeDragsInProgress)[n10] & n11) != n11 && ((f16 = (f15 = f10 - (f14 = (float)(n12 = this.mTouchSlop))) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) > 0 || (n12 = (int)((f13 = f11 - (f12 = (float)n12)) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1))) > 0)) {
            float f17;
            float f18;
            Object object;
            n12 = 0x3F000000;
            f12 = 0.5f;
            float f19 = f10 - (f11 *= f12);
            Object object2 = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
            if (object2 < 0 && (object2 = (Object)((ViewDragHelper$Callback)(object = this.mCallback)).onEdgeLock(n11)) != false) {
                int[] nArray2 = this.mEdgeDragsLocked;
                object2 = nArray2[n10] | n11;
                nArray2[n10] = (int)object2;
                return false;
            }
            object = this.mEdgeDragsInProgress;
            object2 = object[n10] & n11;
            if (object2 == false && (f18 = (f17 = f10 - (f11 = (float)(object2 = (Object)this.mTouchSlop))) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1)) > 0) {
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private boolean checkTouchSlop(View view, float f10, float f11) {
        int n10;
        float f12;
        float f13;
        void var10_16;
        void var6_9;
        float f14;
        boolean bl2 = false;
        if (view == null) {
            return false;
        }
        ViewDragHelper$Callback viewDragHelper$Callback = this.mCallback;
        int bl3 = viewDragHelper$Callback.getViewHorizontalDragRange(view);
        boolean bl4 = true;
        float f15 = Float.MIN_VALUE;
        if (bl3 > 0) {
            boolean bl5 = bl4;
        } else {
            boolean bl6 = false;
            viewDragHelper$Callback = null;
        }
        ViewDragHelper$Callback viewDragHelper$Callback2 = this.mCallback;
        int n11 = viewDragHelper$Callback2.getViewVerticalDragRange(view);
        if (n11 > 0) {
            boolean bl7 = bl4;
            f14 = f15;
        } else {
            boolean bl8 = false;
            view = null;
            f14 = 0.0f;
        }
        if (var6_9 != false && var10_16 != false) {
            float f16;
            float f17;
            f10 *= f10;
            int n12 = this.mTouchSlop;
            f14 = n12 * n12;
            if ((f17 = (f16 = (f10 += (f11 *= f11)) - f14) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) > 0) {
                bl2 = bl4;
            }
            return bl2;
        }
        if (var6_9 != false) {
            int n13;
            f14 = Math.abs(f10);
            float f18 = f14 - (f10 = (float)(n13 = this.mTouchSlop));
            Object object = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
            if (object > 0) {
                bl2 = bl4;
            }
            return bl2;
        }
        if (var10_16 != false && (f13 = (f12 = (f14 = Math.abs(f11)) - (f10 = (float)(n10 = this.mTouchSlop))) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) > 0) {
            bl2 = bl4;
        }
        return bl2;
    }

    private float clampMag(float f10, float f11, float f12) {
        float f13 = Math.abs(f10);
        float f14 = f13 - f11;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object < 0) {
            return 0.0f;
        }
        object = f13 == f12 ? 0 : (f13 > f12 ? 1 : -1);
        if (object > 0) {
            float f15 = f10 - 0.0f;
            Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object2 <= 0) {
                f12 = -f12;
            }
            return f12;
        }
        return f10;
    }

    private int clampMag(int n10, int n11, int n12) {
        int n13 = Math.abs(n10);
        if (n13 < n11) {
            return 0;
        }
        if (n13 > n12) {
            if (n10 <= 0) {
                n12 = -n12;
            }
            return n12;
        }
        return n10;
    }

    private void clearMotionHistory() {
        float[] fArray = this.mInitialMotionX;
        if (fArray == null) {
            return;
        }
        Arrays.fill(fArray, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private void clearMotionHistory(int n10) {
        int n11;
        Object[] objectArray = this.mInitialMotionX;
        if (objectArray != null && (n11 = this.isPointerDown(n10)) != 0) {
            this.mInitialMotionX[n10] = 0.0f;
            this.mInitialMotionY[n10] = 0.0f;
            this.mLastMotionX[n10] = 0.0f;
            this.mLastMotionY[n10] = 0.0f;
            this.mInitialEdgesTouched[n10] = 0;
            this.mEdgeDragsInProgress[n10] = 0;
            objectArray = this.mEdgeDragsLocked;
            objectArray[n10] = 0.0f;
            n11 = this.mPointersDown;
            int n12 = 1;
            this.mPointersDown = n10 = ~(n12 << n10) & n11;
        }
    }

    private int computeAxisDuration(int n10, int n11, int n12) {
        if (n10 == 0) {
            return 0;
        }
        ViewGroup viewGroup = this.mParentView;
        int n13 = viewGroup.getWidth();
        int n14 = n13 / 2;
        int n15 = Math.abs(n10);
        float f10 = n15;
        float f11 = n13;
        f10 /= f11;
        n13 = 1065353216;
        f11 = 1.0f;
        f10 = Math.min(f11, f10);
        float f12 = n14;
        f10 = this.distanceInfluenceForSnapDuration(f10) * f12;
        f12 += f10;
        if ((n11 = Math.abs(n11)) > 0) {
            float f13 = 1000.0f;
            float f14 = n11;
            f12 /= f14;
            f14 = Math.abs(f12) * f13;
            n10 = Math.round(f14) * 4;
        } else {
            float f15 = Math.abs(n10);
            float f16 = n12;
            f15 = f15 / f16 + f11;
            n11 = 1132462080;
            f16 = 256.0f;
            n10 = (int)(f15 *= f16);
        }
        return Math.min(n10, 600);
    }

    private int computeSettleDuration(View view, int n10, int n11, int n12, int n13) {
        float f10;
        int n14 = (int)this.mMinVelocity;
        int n15 = (int)this.mMaxVelocity;
        n12 = this.clampMag(n12, n14, n15);
        float f11 = this.mMinVelocity;
        n14 = (int)f11;
        float f12 = this.mMaxVelocity;
        n15 = (int)f12;
        n13 = this.clampMag(n13, n14, n15);
        n14 = Math.abs(n10);
        n15 = Math.abs(n11);
        int n16 = Math.abs(n12);
        int n17 = Math.abs(n13);
        int n18 = n16 + n17;
        int n19 = n14 + n15;
        if (n12 != 0) {
            f11 = n16;
            f10 = n18;
        } else {
            f11 = n14;
            f10 = n19;
        }
        f11 /= f10;
        if (n13 != 0) {
            f12 = n17;
            f10 = n18;
        } else {
            f12 = n15;
            f10 = n19;
        }
        n16 = this.mCallback.getViewHorizontalDragRange(view);
        n10 = this.computeAxisDuration(n10, n12, n16);
        int n20 = this.mCallback.getViewVerticalDragRange(view);
        n20 = this.computeAxisDuration(n11, n13, n20);
        float f13 = (float)n10 * f11;
        float f14 = (float)n20 * (f12 /= f10);
        return (int)(f13 + f14);
    }

    public static ViewDragHelper create(ViewGroup object, float f10, ViewDragHelper$Callback viewDragHelper$Callback) {
        int n10;
        object = ViewDragHelper.create(object, viewDragHelper$Callback);
        float f11 = object.mTouchSlop;
        float f12 = 1.0f / f10;
        object.mTouchSlop = n10 = (int)(f11 * f12);
        return object;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, ViewDragHelper$Callback viewDragHelper$Callback) {
        Context context = viewGroup.getContext();
        ViewDragHelper viewDragHelper = new ViewDragHelper(context, viewGroup, viewDragHelper$Callback);
        return viewDragHelper;
    }

    private void dispatchViewReleased(float f10, float f11) {
        int n10;
        this.mReleaseInProgress = n10 = 1;
        ViewDragHelper$Callback viewDragHelper$Callback = this.mCallback;
        View view = this.mCapturedView;
        viewDragHelper$Callback.onViewReleased(view, f10, f11);
        f10 = 0.0f;
        this.mReleaseInProgress = false;
        int n11 = this.mDragState;
        if (n11 == n10) {
            this.setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f10) {
        return (float)Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int n10, int n11, int n12, int n13) {
        ViewDragHelper$Callback viewDragHelper$Callback;
        View view = this.mCapturedView;
        int n14 = view.getLeft();
        View view2 = this.mCapturedView;
        int n15 = view2.getTop();
        if (n12 != 0) {
            viewDragHelper$Callback = this.mCallback;
            View view3 = this.mCapturedView;
            n10 = viewDragHelper$Callback.clampViewPositionHorizontal(view3, n10, n12);
            viewDragHelper$Callback = this.mCapturedView;
            int n16 = n10 - n14;
            ViewCompat.offsetLeftAndRight((View)viewDragHelper$Callback, n16);
        }
        int n17 = n10;
        if (n13 != 0) {
            ViewDragHelper$Callback viewDragHelper$Callback2 = this.mCallback;
            viewDragHelper$Callback = this.mCapturedView;
            n11 = viewDragHelper$Callback2.clampViewPositionVertical((View)viewDragHelper$Callback, n11, n13);
            viewDragHelper$Callback2 = this.mCapturedView;
            int n18 = n11 - n15;
            ViewCompat.offsetTopAndBottom((View)viewDragHelper$Callback2, n18);
        }
        int n19 = n11;
        if (n12 != 0 || n13 != 0) {
            int n20 = n17 - n14;
            int n21 = n19 - n15;
            ViewDragHelper$Callback viewDragHelper$Callback3 = this.mCallback;
            View view4 = this.mCapturedView;
            viewDragHelper$Callback3.onViewPositionChanged(view4, n17, n19, n20, n21);
        }
    }

    private void ensureMotionHistorySizeForId(int n10) {
        int n11;
        Object[] objectArray = this.mInitialMotionX;
        if (objectArray == null || (n11 = objectArray.length) <= n10) {
            float[] fArray = new float[++n10];
            float[] fArray2 = new float[n10];
            float[] fArray3 = new float[n10];
            float[] fArray4 = new float[n10];
            int[] nArray = new int[n10];
            int[] nArray2 = new int[n10];
            int[] nArray3 = new int[n10];
            if (objectArray != null) {
                int n12 = objectArray.length;
                System.arraycopy(objectArray, 0, fArray, 0, n12);
                objectArray = this.mInitialMotionY;
                n12 = objectArray.length;
                System.arraycopy(objectArray, 0, fArray2, 0, n12);
                objectArray = this.mLastMotionX;
                n12 = objectArray.length;
                System.arraycopy(objectArray, 0, fArray3, 0, n12);
                objectArray = this.mLastMotionY;
                n12 = objectArray.length;
                System.arraycopy(objectArray, 0, fArray4, 0, n12);
                objectArray = this.mInitialEdgesTouched;
                n12 = objectArray.length;
                System.arraycopy(objectArray, 0, nArray, 0, n12);
                objectArray = this.mEdgeDragsInProgress;
                n12 = objectArray.length;
                System.arraycopy(objectArray, 0, nArray2, 0, n12);
                objectArray = this.mEdgeDragsLocked;
                n12 = objectArray.length;
                System.arraycopy(objectArray, 0, nArray3, 0, n12);
            }
            this.mInitialMotionX = fArray;
            this.mInitialMotionY = fArray2;
            this.mLastMotionX = fArray3;
            this.mLastMotionY = fArray4;
            this.mInitialEdgesTouched = nArray;
            this.mEdgeDragsInProgress = nArray2;
            this.mEdgeDragsLocked = nArray3;
        }
    }

    private boolean forceSettleCapturedViewAt(int n10, int n11, int n12, int n13) {
        int n14 = this.mCapturedView.getLeft();
        View view = this.mCapturedView;
        int n15 = view.getTop();
        if ((n10 -= n14) == 0 && (n11 -= n15) == 0) {
            this.mScroller.abortAnimation();
            this.setDragState(0);
            return false;
        }
        View view2 = this.mCapturedView;
        int n16 = n10;
        n16 = this.computeSettleDuration(view2, n10, n11, n12, n13);
        this.mScroller.startScroll(n14, n15, n10, n11, n16);
        this.setDragState(2);
        return true;
    }

    private int getEdgesTouched(int n10, int n11) {
        ViewGroup viewGroup = this.mParentView;
        int n12 = viewGroup.getLeft();
        int n13 = this.mEdgeSize;
        if (n10 < (n12 += n13)) {
            n12 = 1;
        } else {
            n12 = 0;
            viewGroup = null;
        }
        ViewGroup viewGroup2 = this.mParentView;
        n13 = viewGroup2.getTop();
        int n14 = this.mEdgeSize;
        if (n11 < (n13 += n14)) {
            n12 |= 4;
        }
        viewGroup2 = this.mParentView;
        n13 = viewGroup2.getRight();
        n14 = this.mEdgeSize;
        if (n10 > (n13 -= n14)) {
            n12 |= 2;
        }
        ViewGroup viewGroup3 = this.mParentView;
        n10 = viewGroup3.getBottom();
        n13 = this.mEdgeSize;
        if (n11 > (n10 -= n13)) {
            n12 |= 8;
        }
        return n12;
    }

    private boolean isValidPointerForActionMove(int n10) {
        boolean bl2 = this.isPointerDown(n10);
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring pointerId=");
            stringBuilder.append(n10);
            stringBuilder.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            String string2 = stringBuilder.toString();
            Log.e((String)TAG, (String)string2);
            return false;
        }
        return true;
    }

    private void releaseViewForPointerUp() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        float f10 = this.mMaxVelocity;
        velocityTracker.computeCurrentVelocity(1000, f10);
        velocityTracker = this.mVelocityTracker;
        int n10 = this.mActivePointerId;
        float f11 = velocityTracker.getXVelocity(n10);
        f10 = this.mMinVelocity;
        float f12 = this.mMaxVelocity;
        f11 = this.clampMag(f11, f10, f12);
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        int n11 = this.mActivePointerId;
        f10 = velocityTracker2.getYVelocity(n11);
        f12 = this.mMinVelocity;
        float f13 = this.mMaxVelocity;
        f10 = this.clampMag(f10, f12, f13);
        this.dispatchViewReleased(f11, f10);
    }

    private void reportNewEdgeDrags(float f10, float f11, int n10) {
        boolean bl2;
        int n11 = 1;
        int n12 = this.checkNewEdgeDrag(f10, f11, n10, n11);
        if (n12 == 0) {
            n11 = 0;
        }
        n12 = this.checkNewEdgeDrag(f11, f10, n10, 4);
        if (n12 != 0) {
            n11 |= 4;
        }
        if ((n12 = this.checkNewEdgeDrag(f10, f11, n10, 2)) != 0) {
            n11 |= 2;
        }
        if (bl2 = this.checkNewEdgeDrag(f11, f10, n10, n12 = 8)) {
            n11 |= 8;
        }
        if (n11 != 0) {
            int n13;
            Object object = this.mEdgeDragsInProgress;
            object[n10] = n13 = object[n10] | n11;
            object = this.mCallback;
            ((ViewDragHelper$Callback)object).onEdgeDragStarted(n11, n10);
        }
    }

    private void saveInitialMotion(float f10, float f11, int n10) {
        this.ensureMotionHistorySizeForId(n10);
        Object[] objectArray = this.mInitialMotionX;
        this.mLastMotionX[n10] = f10;
        objectArray[n10] = f10;
        objectArray = this.mInitialMotionY;
        this.mLastMotionY[n10] = f11;
        objectArray[n10] = f11;
        objectArray = this.mInitialEdgesTouched;
        int n11 = (int)f10;
        int n12 = (int)f11;
        n11 = this.getEdgesTouched(n11, n12);
        objectArray[n10] = n11;
        n11 = this.mPointersDown;
        n12 = 1 << n10;
        this.mPointersDown = n11 |= n12;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int n10 = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = motionEvent.getPointerId(i10);
            boolean bl2 = this.isValidPointerForActionMove(n11);
            if (!bl2) continue;
            float f10 = motionEvent.getX(i10);
            float f11 = motionEvent.getY(i10);
            float[] fArray = this.mLastMotionX;
            fArray[n11] = f10;
            float[] fArray2 = this.mLastMotionY;
            fArray2[n11] = f11;
        }
    }

    public void abort() {
        this.cancel();
        int n10 = this.mDragState;
        int n11 = 2;
        if (n10 == n11) {
            OverScroller overScroller = this.mScroller;
            n10 = overScroller.getCurrX();
            OverScroller overScroller2 = this.mScroller;
            n11 = overScroller2.getCurrY();
            this.mScroller.abortAnimation();
            int n12 = this.mScroller.getCurrX();
            OverScroller overScroller3 = this.mScroller;
            int n13 = overScroller3.getCurrY();
            ViewDragHelper$Callback viewDragHelper$Callback = this.mCallback;
            View view = this.mCapturedView;
            int n14 = n12 - n10;
            int n15 = n13 - n11;
            viewDragHelper$Callback.onViewPositionChanged(view, n12, n13, n14, n15);
        }
        this.setDragState(0);
    }

    public boolean canScroll(View view, boolean bl2, int n10, int n11, int n12, int n13) {
        int n14;
        block6: {
            block5: {
                int n15 = view instanceof ViewGroup;
                n14 = 1;
                if (n15 != 0) {
                    View view2 = view;
                    view2 = (ViewGroup)view;
                    int n16 = view.getScrollX();
                    int n17 = view.getScrollY();
                    for (int i10 = view2.getChildCount() - n14; i10 >= 0; i10 += -1) {
                        int n18;
                        int n19 = n12 + n16;
                        View view3 = view2.getChildAt(i10);
                        int n20 = view3.getLeft();
                        if (n19 < n20 || n19 >= (n20 = view3.getRight()) || (n20 = n13 + n17) < (n18 = view3.getTop()) || n20 >= (n18 = view3.getBottom())) continue;
                        int n21 = view3.getLeft();
                        int n22 = n19 - n21;
                        n19 = view3.getTop();
                        int n23 = n20 - n19;
                        n20 = 1;
                        n18 = n10;
                        n21 = n11;
                        n19 = (int)(this.canScroll(view3, n20 != 0, n10, n11, n22, n23) ? 1 : 0);
                        if (n19 == 0) continue;
                        return n14 != 0;
                    }
                }
                if (!bl2) break block5;
                n15 = n10;
                n15 = -n10;
                if ((n15 = (int)(view.canScrollHorizontally(n15) ? 1 : 0)) != 0) break block6;
                n15 = n11;
                n15 = -n11;
                boolean bl3 = view.canScrollVertically(n15);
                if (bl3) break block6;
            }
            n14 = 0;
        }
        return n14 != 0;
    }

    public void cancel() {
        int n10;
        this.mActivePointerId = n10 = -1;
        this.clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            n10 = 0;
            velocityTracker = null;
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View object, int n10) {
        ViewGroup viewGroup;
        ViewParent viewParent = object.getParent();
        if (viewParent == (viewGroup = this.mParentView)) {
            this.mCapturedView = object;
            this.mActivePointerId = n10;
            this.mCallback.onViewCaptured((View)object, n10);
            this.setDragState(1);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        viewParent = this.mParentView;
        charSequence.append(viewParent);
        charSequence.append(")");
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public boolean checkTouchSlop(int n10) {
        float[] fArray = this.mInitialMotionX;
        int n11 = fArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            boolean bl2 = this.checkTouchSlop(n10, i10);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public boolean checkTouchSlop(int n10, int n11) {
        float f10;
        float f11;
        void var1_5;
        void var3_15;
        float f12;
        int n12;
        boolean bl2 = this.isPointerDown(n12);
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        boolean bl4 = n10 & 1;
        boolean bl5 = true;
        float f13 = Float.MIN_VALUE;
        if (bl4 == bl5) {
            boolean bl6 = bl5;
        } else {
            boolean bl7 = false;
        }
        int n13 = 2;
        float f14 = 2.8E-45f;
        int n14 = n10 & n13;
        if (n14 == n13) {
            boolean bl8 = bl5;
            f12 = f13;
        } else {
            boolean bl9 = false;
            f12 = 0.0f;
        }
        float[] fArray = this.mLastMotionX;
        f14 = fArray[n12];
        float f15 = this.mInitialMotionX[n12];
        f14 -= f15;
        float[] fArray2 = this.mLastMotionY;
        f15 = fArray2[n12];
        float[] fArray3 = this.mInitialMotionY;
        float f16 = fArray3[n12];
        f15 -= f16;
        if (var3_15 != false && var1_5 != false) {
            float f17;
            float f18;
            f14 *= f14;
            int n15 = this.mTouchSlop;
            f12 = n15 * n15;
            if ((f18 = (f17 = (f14 += (f15 *= f15)) - f12) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1)) > 0) {
                bl3 = bl5;
            }
            return bl3;
        }
        if (var3_15 != false) {
            f12 = Math.abs(f14);
            float f19 = f12 - (f16 = (float)(n12 = this.mTouchSlop));
            Object object = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
            if (object > 0) {
                bl3 = bl5;
            }
            return bl3;
        }
        if (var1_5 != false && (f11 = (f10 = (f12 = Math.abs(f15)) - (f16 = (float)(n12 = this.mTouchSlop))) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) > 0) {
            bl3 = bl5;
        }
        return bl3;
    }

    public boolean continueSettling(boolean n10) {
        int n11 = this.mDragState;
        int n12 = 2;
        boolean bl2 = false;
        if (n11 == n12) {
            Object object = this.mScroller;
            n11 = (int)(object.computeScrollOffset() ? 1 : 0);
            OverScroller overScroller = this.mScroller;
            int n13 = overScroller.getCurrX();
            int n14 = this.mScroller.getCurrY();
            int n15 = this.mCapturedView.getLeft();
            int n16 = n13 - n15;
            Object object2 = this.mCapturedView;
            n15 = object2.getTop();
            int n17 = n14 - n15;
            if (n16 != 0) {
                object2 = this.mCapturedView;
                ViewCompat.offsetLeftAndRight((View)object2, n16);
            }
            if (n17 != 0) {
                object2 = this.mCapturedView;
                ViewCompat.offsetTopAndBottom((View)object2, n17);
            }
            if (n16 != 0 || n17 != 0) {
                object2 = this.mCallback;
                View view = this.mCapturedView;
                ((ViewDragHelper$Callback)object2).onViewPositionChanged(view, n13, n14, n16, n17);
            }
            if (n11 != 0 && n13 == (n15 = (object2 = this.mScroller).getFinalX()) && n14 == (n13 = (overScroller = this.mScroller).getFinalY())) {
                this.mScroller.abortAnimation();
                n11 = 0;
                object = null;
            }
            if (n11 == 0) {
                if (n10 != 0) {
                    ViewGroup viewGroup = this.mParentView;
                    object = this.mSetIdleRunnable;
                    viewGroup.post((Runnable)object);
                } else {
                    this.setDragState(0);
                }
            }
        }
        if ((n10 = this.mDragState) == n12) {
            bl2 = true;
        }
        return bl2;
    }

    public View findTopChildUnder(int n10, int n11) {
        ViewGroup viewGroup = this.mParentView;
        for (int i10 = viewGroup.getChildCount() + -1; i10 >= 0; i10 += -1) {
            ViewGroup viewGroup2 = this.mParentView;
            ViewDragHelper$Callback viewDragHelper$Callback = this.mCallback;
            int n12 = viewDragHelper$Callback.getOrderedChildIndex(i10);
            if (n10 < (n12 = (viewGroup2 = viewGroup2.getChildAt(n12)).getLeft()) || n10 >= (n12 = viewGroup2.getRight()) || n11 < (n12 = viewGroup2.getTop()) || n11 >= (n12 = viewGroup2.getBottom())) continue;
            return viewGroup2;
        }
        return null;
    }

    public void flingCapturedView(int n10, int n11, int n12, int n13) {
        boolean bl2 = this.mReleaseInProgress;
        if (bl2) {
            OverScroller overScroller = this.mScroller;
            int n14 = this.mCapturedView.getLeft();
            int n15 = this.mCapturedView.getTop();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            int n16 = this.mActivePointerId;
            n16 = (int)velocityTracker.getXVelocity(n16);
            velocityTracker = this.mVelocityTracker;
            int n17 = this.mActivePointerId;
            n17 = (int)velocityTracker.getYVelocity(n17);
            overScroller.fling(n14, n15, n16, n17, n10, n12, n11, n13);
            this.setDragState(2);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        throw illegalStateException;
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int n10, int n11) {
        View view = this.mCapturedView;
        return this.isViewUnder(view, n10, n11);
    }

    public boolean isEdgeTouched(int n10) {
        int[] nArray = this.mInitialEdgesTouched;
        int n11 = nArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            boolean bl2 = this.isEdgeTouched(n10, i10);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public boolean isEdgeTouched(int n10, int n11) {
        int[] nArray;
        boolean bl2 = this.isPointerDown(n11);
        n10 = bl2 && (n10 &= (n11 = (nArray = this.mInitialEdgesTouched)[n11])) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isPointerDown(int n10) {
        int n11 = 1;
        int n12 = this.mPointersDown;
        if ((n10 = n11 << n10 & n12) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isViewUnder(View view, int n10, int n11) {
        int n12;
        boolean bl2 = false;
        if (view == null) {
            return false;
        }
        int n13 = view.getLeft();
        if (n10 >= n13 && n10 < (n13 = view.getRight()) && n11 >= (n10 = view.getTop()) && n11 < (n12 = view.getBottom())) {
            bl2 = true;
        }
        return bl2;
    }

    public void processTouchEvent(MotionEvent object) {
        int n10;
        Object object2;
        int n11 = object.getActionMasked();
        int n12 = object.getActionIndex();
        if (n11 == 0) {
            this.cancel();
        }
        if ((object2 = this.mVelocityTracker) == null) {
            object2 = VelocityTracker.obtain();
            this.mVelocityTracker = object2;
        }
        this.mVelocityTracker.addMovement(object);
        float f10 = 0.0f;
        object2 = null;
        if (n11 != 0) {
            int n13 = 1;
            float f11 = Float.MIN_VALUE;
            if (n11 != n13) {
                int n14 = 2;
                float f12 = 2.8E-45f;
                if (n11 != n14) {
                    n14 = 3;
                    f12 = 4.2E-45f;
                    if (n11 != n14) {
                        n14 = 5;
                        f12 = 7.0E-45f;
                        if (n11 != n14) {
                            n14 = 6;
                            f12 = 8.4E-45f;
                            if (n11 == n14) {
                                n11 = object.getPointerId(n12);
                                n12 = this.mDragState;
                                if (n12 == n13 && n11 == (n12 = this.mActivePointerId)) {
                                    int n15;
                                    block28: {
                                        n12 = object.getPointerCount();
                                        while (true) {
                                            View view;
                                            float f13;
                                            int n16;
                                            float f14;
                                            View view2;
                                            int n17;
                                            n13 = -1;
                                            f11 = 0.0f / 0.0f;
                                            if (n10 >= n12) break;
                                            n14 = object.getPointerId(n10);
                                            if (n14 != (n17 = this.mActivePointerId) && (view2 = this.findTopChildUnder(n17 = (int)(f14 = object.getX(n10)), n16 = (int)(f13 = object.getY(n10)))) == (view = this.mCapturedView) && (n14 = (int)(this.tryCaptureViewForDrag(view, n14) ? 1 : 0)) != 0) {
                                                n15 = this.mActivePointerId;
                                                break block28;
                                            }
                                            ++n10;
                                        }
                                        n15 = n13;
                                        float f15 = f11;
                                    }
                                    if (n15 == n13) {
                                        this.releaseViewForPointerUp();
                                    }
                                }
                                this.clearMotionHistory(n11);
                            }
                        } else {
                            n11 = object.getPointerId(n12);
                            f10 = object.getX(n12);
                            float f16 = object.getY(n12);
                            this.saveInitialMotion(f10, f16, n11);
                            n12 = this.mDragState;
                            if (n12 == 0) {
                                n12 = (int)f10;
                                Object object3 = (int)f16;
                                object = this.findTopChildUnder(n12, (int)object3);
                                this.tryCaptureViewForDrag((View)object, n11);
                                object = this.mInitialEdgesTouched;
                                object3 = object[n11];
                                n12 = this.mTrackingEdges;
                                n10 = object3 & n12;
                                if (n10 != 0) {
                                    object2 = this.mCallback;
                                    ((ViewDragHelper$Callback)object2).onEdgeTouched((int)(object3 &= n12), n11);
                                }
                            } else {
                                n12 = (int)f10;
                                int n18 = (int)f16;
                                if ((n18 = (int)(this.isCapturedViewUnder(n12, n18) ? 1 : 0)) != 0) {
                                    object = this.mCapturedView;
                                    this.tryCaptureViewForDrag((View)object, n11);
                                }
                            }
                        }
                    } else {
                        int n19 = this.mDragState;
                        if (n19 == n13) {
                            n19 = 0;
                            float f17 = 0.0f;
                            object = null;
                            this.dispatchViewReleased(0.0f, 0.0f);
                        }
                        this.cancel();
                    }
                } else {
                    n11 = this.mDragState;
                    if (n11 == n13) {
                        n11 = this.mActivePointerId;
                        if ((n11 = (int)(this.isValidPointerForActionMove(n11) ? 1 : 0)) != 0) {
                            n11 = this.mActivePointerId;
                            n11 = object.findPointerIndex(n11);
                            float f18 = object.getX(n11);
                            float f19 = object.getY(n11);
                            object2 = this.mLastMotionX;
                            n13 = this.mActivePointerId;
                            f10 = (float)object2[n13];
                            n12 = (int)(f18 -= f10);
                            f10 = this.mLastMotionY[n13];
                            n11 = (int)(f19 -= f10);
                            object2 = this.mCapturedView;
                            n10 = object2.getLeft() + n12;
                            View view = this.mCapturedView;
                            n13 = view.getTop() + n11;
                            this.dragTo(n10, n13, n12, n11);
                            this.saveLastMotion((MotionEvent)object);
                        }
                    } else {
                        n11 = object.getPointerCount();
                        for (n10 = 0; n10 < n11; ++n10) {
                            n12 = object.getPointerId(n10);
                            n14 = (int)(this.isValidPointerForActionMove(n12) ? 1 : 0);
                            if (n14 == 0) continue;
                            f12 = object.getX(n10);
                            float f20 = object.getY(n10);
                            float[] fArray = this.mInitialMotionX;
                            float f21 = fArray[n12];
                            f21 = f12 - f21;
                            float[] fArray2 = this.mInitialMotionY;
                            float f22 = fArray2[n12];
                            f22 = f20 - f22;
                            this.reportNewEdgeDrags(f21, f22, n12);
                            int n20 = this.mDragState;
                            if (n20 == n13) break;
                            n14 = (int)f12;
                            int n21 = (int)f20;
                            View view = this.findTopChildUnder(n14, n21);
                            if ((n21 = (int)(this.checkTouchSlop(view, f21, f22) ? 1 : 0)) != 0 && (n12 = (int)(this.tryCaptureViewForDrag(view, n12) ? 1 : 0)) != 0) break;
                        }
                        this.saveLastMotion((MotionEvent)object);
                    }
                }
            } else {
                int n22 = this.mDragState;
                if (n22 == n13) {
                    this.releaseViewForPointerUp();
                }
                this.cancel();
            }
        } else {
            float f23 = object.getX();
            float f24 = object.getY();
            int n23 = object.getPointerId(0);
            n10 = (int)f23;
            int n24 = (int)f24;
            object2 = this.findTopChildUnder(n10, n24);
            this.saveInitialMotion(f23, f24, n23);
            this.tryCaptureViewForDrag((View)object2, n23);
            int[] nArray = this.mInitialEdgesTouched;
            n11 = nArray[n23];
            n12 = this.mTrackingEdges;
            n10 = n11 & n12;
            if (n10 != 0) {
                object2 = this.mCallback;
                ((ViewDragHelper$Callback)object2).onEdgeTouched(n11 &= n12, n23);
            }
        }
    }

    public void setDragState(int n10) {
        Object object = this.mParentView;
        Runnable runnable = this.mSetIdleRunnable;
        object.removeCallbacks(runnable);
        int n11 = this.mDragState;
        if (n11 != n10) {
            this.mDragState = n10;
            object = this.mCallback;
            ((ViewDragHelper$Callback)object).onViewDragStateChanged(n10);
            n10 = this.mDragState;
            if (n10 == 0) {
                n10 = 0;
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(int n10) {
        this.mEdgeSize = n10;
    }

    public void setEdgeTrackingEnabled(int n10) {
        this.mTrackingEdges = n10;
    }

    public void setMinVelocity(float f10) {
        this.mMinVelocity = f10;
    }

    public boolean settleCapturedViewAt(int n10, int n11) {
        int n12 = this.mReleaseInProgress;
        if (n12 != 0) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            int n13 = this.mActivePointerId;
            n12 = (int)velocityTracker.getXVelocity(n13);
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            int n14 = this.mActivePointerId;
            n13 = (int)velocityTracker2.getYVelocity(n14);
            return this.forceSettleCapturedViewAt(n10, n11, n12, n13);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        throw illegalStateException;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean shouldInterceptTouchEvent(MotionEvent var1_1) {
        block11: {
            block12: {
                block13: {
                    block14: {
                        block17: {
                            block15: {
                                block16: {
                                    var2_2 = this;
                                    var3_3 /* !! */  = var1_1;
                                    var4_4 /* !! */  = var1_1.getActionMasked();
                                    var5_5 = var1_1.getActionIndex();
                                    if (var4_4 /* !! */  == 0) {
                                        this.cancel();
                                    }
                                    if ((var6_6 = var2_2.mVelocityTracker) == null) {
                                        var6_6 = VelocityTracker.obtain();
                                        var2_2.mVelocityTracker = var6_6;
                                    }
                                    var6_6 = var2_2.mVelocityTracker;
                                    var6_6.addMovement(var3_3 /* !! */ );
                                    var7_7 = 2;
                                    var8_8 = 1;
                                    var9_9 = 1.4E-45f;
                                    if (var4_4 /* !! */  == 0) break block12;
                                    if (var4_4 /* !! */  == var8_8) break block13;
                                    if (var4_4 /* !! */  == var7_7) break block14;
                                    var10_10 = 3;
                                    var11_12 = 4.2E-45f;
                                    if (var4_4 /* !! */  == var10_10) break block13;
                                    var10_10 = 5;
                                    var11_12 = 7.0E-45f;
                                    if (var4_4 /* !! */  == var10_10) break block15;
                                    var7_7 = 6;
                                    if (var4_4 /* !! */  == var7_7) break block16;
lbl26:
                                    // 7 sources

                                    while (true) {
                                        var12_14 = 0;
                                        var13_15 = null;
                                        break block11;
                                        break;
                                    }
                                }
                                var14_17 /* !! */  = var3_3 /* !! */ .getPointerId(var5_5);
                                var2_2.clearMotionHistory(var14_17 /* !! */ );
                                ** GOTO lbl26
                            }
                            var4_4 /* !! */  = var3_3 /* !! */ .getPointerId(var5_5);
                            var11_12 = var3_3 /* !! */ .getX(var5_5);
                            var15_18 = var3_3 /* !! */ .getY(var5_5);
                            var2_2.saveInitialMotion(var11_12, var15_18, var4_4 /* !! */ );
                            var5_5 = var2_2.mDragState;
                            if (var5_5 != 0) break block17;
                            var3_3 /* !! */  = (MotionEvent)var2_2.mInitialEdgesTouched;
                            var14_17 /* !! */  = (int)var3_3 /* !! */ [var4_4 /* !! */ ];
                            var5_5 = var2_2.mTrackingEdges;
                            var7_7 = var14_17 /* !! */  & var5_5;
                            if (var7_7 != 0) {
                                var6_6 = var2_2.mCallback;
                                var6_6.onEdgeTouched(var14_17 /* !! */  &= var5_5, var4_4 /* !! */ );
                            }
                            ** GOTO lbl26
                        }
                        if (var5_5 != var7_7 || (var3_3 /* !! */  = var2_2.findTopChildUnder(var5_5 = (int)var11_12, var14_17 /* !! */  = (int)var15_18)) != (var16_19 = var2_2.mCapturedView)) ** GOTO lbl26
                        var2_2.tryCaptureViewForDrag((View)var3_3 /* !! */ , var4_4 /* !! */ );
                        ** GOTO lbl26
                    }
                    var17_22 = var2_2.mInitialMotionX;
                    if (var17_22 == null || (var17_22 = var2_2.mInitialMotionY) == null) ** GOTO lbl26
                    var4_4 /* !! */  = var1_1.getPointerCount();
                    var18_24 = 0.0f;
                    var16_20 = null;
                    for (var5_5 = 0; var5_5 < var4_4 /* !! */ ; ++var5_5) {
                        var7_7 = var3_3 /* !! */ .getPointerId(var5_5);
                        var10_11 = var2_2.isValidPointerForActionMove(var7_7);
                        if (var10_11 == 0) continue;
                        var11_13 = var3_3 /* !! */ .getX(var5_5);
                        var19_26 = var3_3 /* !! */ .getY(var5_5);
                        var20_27 = var2_2.mInitialMotionX;
                        var21_28 = var20_27[var7_7];
                        var21_28 = var11_13 - var21_28;
                        var22_29 = var2_2.mInitialMotionY;
                        var23_30 = var22_29[var7_7];
                        var23_30 = var19_26 - var23_30;
                        var10_11 = (int)var11_13;
                        var24_31 = (int)var19_26;
                        var25_32 = var2_2.findTopChildUnder(var10_11, var24_31);
                        if (var25_32 != null && (var24_31 = (int)var2_2.checkTouchSlop(var25_32, var21_28, var23_30)) != 0) {
                            var24_31 = var8_8;
                            var19_26 = var9_9;
                        } else {
                            var24_31 = 0;
                            var19_26 = 0.0f;
                        }
                        if (var24_31 != 0) {
                            var26_33 = var25_32.getLeft();
                            var27_34 = (int)var21_28;
                            var28_35 = var26_33 + var27_34;
                            var27_34 = var2_2.mCallback.clampViewPositionHorizontal(var25_32, var28_35, var27_34);
                            var28_35 = var25_32.getTop();
                            var29_36 = (int)var23_30;
                            var30_37 = var28_35 + var29_36;
                            var13_15 = var2_2.mCallback;
                            var12_14 = var13_15.clampViewPositionVertical(var25_32, var30_37, var29_36);
                            var31_38 = var2_2.mCallback;
                            var29_36 = var31_38.getViewHorizontalDragRange(var25_32);
                            var32_39 = var2_2.mCallback;
                            var30_37 = var32_39.getViewVerticalDragRange(var25_32);
                            if ((var29_36 == 0 || var29_36 > 0 && var27_34 == var26_33) && (var30_37 == 0 || var30_37 > 0 && var12_14 == var28_35)) break;
                        }
                        var2_2.reportNewEdgeDrags(var21_28, var23_30, var7_7);
                        var12_14 = var2_2.mDragState;
                        if (var12_14 == var8_8 || var24_31 != 0 && (var7_7 = (int)var2_2.tryCaptureViewForDrag(var25_32, var7_7)) != 0) break;
                    }
                    this.saveLastMotion(var1_1);
                    ** GOTO lbl26
                }
                this.cancel();
                ** while (true)
            }
            var33_40 = var1_1.getX();
            var18_25 = var1_1.getY();
            var12_14 = 0;
            var13_16 = null;
            var14_17 /* !! */  = var3_3 /* !! */ .getPointerId(0);
            var2_2.saveInitialMotion(var33_40, var18_25, var14_17 /* !! */ );
            var4_4 /* !! */  = (int)var33_40;
            var5_5 = (int)var18_25;
            var17_23 /* !! */  = var2_2.findTopChildUnder(var4_4 /* !! */ , var5_5);
            var16_21 = var2_2.mCapturedView;
            if (var17_23 /* !! */  == var16_21 && (var5_5 = var2_2.mDragState) == var7_7) {
                var2_2.tryCaptureViewForDrag(var17_23 /* !! */ , var14_17 /* !! */ );
            }
            if ((var7_7 = (var4_4 /* !! */  = (int)(var17_23 /* !! */  = (View)var2_2.mInitialEdgesTouched)[var14_17 /* !! */ ]) & (var5_5 = var2_2.mTrackingEdges)) != 0) {
                var6_6 = var2_2.mCallback;
                var6_6.onEdgeTouched(var4_4 /* !! */  &= var5_5, var14_17 /* !! */ );
            }
        }
        var14_17 /* !! */  = var2_2.mDragState;
        if (var14_17 /* !! */  == var8_8) {
            var12_14 = var8_8;
        }
        return (boolean)var12_14;
    }

    public boolean smoothSlideViewTo(View view, int n10, int n11) {
        View view2;
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        view = null;
        boolean bl2 = this.forceSettleCapturedViewAt(n10, n11, 0, 0);
        if (!bl2 && (n10 = this.mDragState) == 0 && (view2 = this.mCapturedView) != null) {
            n10 = 0;
            view2 = null;
            this.mCapturedView = null;
        }
        return bl2;
    }

    public boolean tryCaptureViewForDrag(View view, int n10) {
        int n11;
        Object object = this.mCapturedView;
        boolean bl2 = true;
        if (view == object && (n11 = this.mActivePointerId) == n10) {
            return bl2;
        }
        if (view != null && (n11 = (int)(((ViewDragHelper$Callback)(object = this.mCallback)).tryCaptureView(view, n10) ? 1 : 0)) != 0) {
            this.mActivePointerId = n10;
            this.captureChildView(view, n10);
            return bl2;
        }
        return false;
    }
}

