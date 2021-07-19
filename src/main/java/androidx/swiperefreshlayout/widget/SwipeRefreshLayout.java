/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.AbsListView
 *  android.widget.ListView
 */
package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import androidx.swiperefreshlayout.widget.CircleImageView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$1;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$2;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$3;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$4;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$5;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$6;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$7;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$8;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnChildScrollUpCallback;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout$OnRefreshListener;

public class SwipeRefreshLayout
extends ViewGroup
implements NestedScrollingParent,
NestedScrollingChild {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = 0xFAFAFA;
    public static final int CIRCLE_DIAMETER = 40;
    public static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = 255;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = 255;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS;
    private static final String LOG_TAG;
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private SwipeRefreshLayout$OnChildScrollUpCallback mChildScrollUpCallback;
    private int mCircleDiameter;
    public CircleImageView mCircleView;
    private int mCircleViewIndex;
    public int mCurrentTargetOffsetTop;
    public int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    public int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    public SwipeRefreshLayout$OnRefreshListener mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public boolean mNotify;
    public int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    public CircularProgressDrawable mProgress;
    private Animation.AnimationListener mRefreshListener;
    public boolean mRefreshing = false;
    private boolean mReturningToStart;
    public boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    public int mSpinnerOffsetEnd;
    public float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance = -1.0f;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    public boolean mUsingCustomStart;

    static {
        LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
        int[] nArray = new int[]{0x101000E};
        LAYOUT_ATTRS = nArray;
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        int bl2;
        int n10 = 2;
        int[] nArray = new int[n10];
        this.mParentScrollConsumed = nArray;
        Object object = new int[n10];
        this.mParentOffsetInWindow = object;
        this.mActivePointerId = n10 = -1;
        this.mCircleViewIndex = n10;
        object = new SwipeRefreshLayout$1;
        super(this);
        this.mRefreshListener = (Animation.AnimationListener)object;
        object = (Object)new SwipeRefreshLayout$6;
        super(this);
        this.mAnimateToCorrectPosition = (Animation)object;
        object = (Object)new SwipeRefreshLayout$7;
        super(this);
        this.mAnimateToStartPosition = (Animation)object;
        this.mTouchSlop = n10 = ViewConfiguration.get((Context)context).getScaledTouchSlop();
        this.mMediumAnimationDuration = n10 = this.getResources().getInteger(0x10E0001);
        this.setWillNotDraw(false);
        object = new DecelerateInterpolator;
        super(2.0f);
        this.mDecelerateInterpolator = (DecelerateInterpolator)object;
        object = this.getResources().getDisplayMetrics();
        this.mCircleDiameter = bl2 = (int)(object.density * 40.0f);
        this.createProgressView();
        boolean bl3 = true;
        this.setChildrenDrawingOrderEnabled(bl3);
        this.mSpinnerOffsetEnd = n10 = (int)(object.density * 64.0f);
        this.mTotalDragDistance = f10 = (float)n10;
        object = new NestedScrollingParentHelper;
        super(this);
        this.mNestedScrollingParentHelper = (NestedScrollingParentHelper)object;
        object = new NestedScrollingChildHelper;
        super((View)this);
        this.mNestedScrollingChildHelper = (NestedScrollingChildHelper)object;
        this.setNestedScrollingEnabled(bl3);
        this.mCurrentTargetOffsetTop = n10 = -this.mCircleDiameter;
        this.mOriginalOffsetTop = n10;
        this.moveToStart(1.0f);
        object = LAYOUT_ATTRS;
        context = context.obtainStyledAttributes(attributeSet, object);
        boolean bl4 = context.getBoolean(0, bl3);
        this.setEnabled(bl4);
        context.recycle();
    }

    private void animateOffsetToCorrectPosition(int n10, Animation.AnimationListener animationListener) {
        this.mFrom = n10;
        this.mAnimateToCorrectPosition.reset();
        Object object = this.mAnimateToCorrectPosition;
        long l10 = 200L;
        object.setDuration(l10);
        object = this.mAnimateToCorrectPosition;
        DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
        object.setInterpolator((Interpolator)decelerateInterpolator);
        if (animationListener != null) {
            object = this.mCircleView;
            object.setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        object = this.mCircleView;
        animationListener = this.mAnimateToCorrectPosition;
        object.startAnimation((Animation)animationListener);
    }

    private void animateOffsetToStartPosition(int n10, Animation.AnimationListener animationListener) {
        boolean bl2 = this.mScale;
        if (bl2) {
            this.startScaleDownReturnToStartAnimation(n10, animationListener);
        } else {
            this.mFrom = n10;
            this.mAnimateToStartPosition.reset();
            Object object = this.mAnimateToStartPosition;
            long l10 = 200L;
            object.setDuration(l10);
            object = this.mAnimateToStartPosition;
            DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
            object.setInterpolator((Interpolator)decelerateInterpolator);
            if (animationListener != null) {
                object = this.mCircleView;
                object.setAnimationListener(animationListener);
            }
            this.mCircleView.clearAnimation();
            object = this.mCircleView;
            animationListener = this.mAnimateToStartPosition;
            object.startAnimation((Animation)animationListener);
        }
    }

    private void createProgressView() {
        Object object;
        Object object2 = this.getContext();
        this.mCircleView = object = new CircleImageView((Context)object2, -328966);
        object2 = this.getContext();
        object = new CircularProgressDrawable((Context)object2);
        this.mProgress = object;
        ((CircularProgressDrawable)((Object)object)).setStyle(1);
        object = this.mCircleView;
        object2 = this.mProgress;
        object.setImageDrawable((Drawable)object2);
        this.mCircleView.setVisibility(8);
        object = this.mCircleView;
        this.addView((View)object);
    }

    private void ensureTarget() {
        View view = this.mTarget;
        if (view == null) {
            int n10;
            view = null;
            for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
                CircleImageView circleImageView;
                View view2 = this.getChildAt(i10);
                boolean bl2 = view2.equals((Object)(circleImageView = this.mCircleView));
                if (bl2) continue;
                this.mTarget = view2;
                break;
            }
        }
    }

    private void finishSpinner(float f10) {
        float f11 = this.mTotalDragDistance;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            object = true;
            f10 = Float.MIN_VALUE;
            this.setRefreshing((boolean)object, (boolean)object);
        } else {
            object = false;
            f10 = 0.0f;
            this.mRefreshing = false;
            this.mProgress.setStartEndTrim(0.0f, 0.0f);
            f11 = 0.0f;
            Object object2 = null;
            int n10 = this.mScale;
            if (n10 == 0) {
                object2 = new SwipeRefreshLayout$5(this);
            }
            n10 = this.mCurrentTargetOffsetTop;
            this.animateOffsetToStartPosition(n10, (Animation.AnimationListener)object2);
            object2 = this.mProgress;
            ((CircularProgressDrawable)((Object)object2)).setArrowEnabled(false);
        }
    }

    private boolean isAnimationRunning(Animation animation) {
        boolean bl2;
        boolean bl3;
        if (animation != null && (bl3 = animation.hasStarted()) && !(bl2 = animation.hasEnded())) {
            bl2 = true;
        } else {
            bl2 = false;
            animation = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void moveSpinner(float f10) {
        CircularProgressDrawable circularProgressDrawable;
        float f11;
        float f12;
        CircularProgressDrawable circularProgressDrawable2;
        int n10;
        CircularProgressDrawable circularProgressDrawable3 = this.mProgress;
        circularProgressDrawable3.setArrowEnabled(true);
        float f13 = this.mTotalDragDistance;
        f13 = Math.abs(f10 / f13);
        float f14 = 1.0f;
        f13 = Math.min(f14, f13);
        double d10 = (double)f13 - 0.4;
        double d11 = 0.0;
        d10 = Math.max(d10, d11);
        float f15 = (float)d10 * 5.0f / 3.0f;
        float f16 = Math.abs(f10);
        float f17 = this.mTotalDragDistance;
        f16 -= f17;
        int n11 = this.mCustomSlingshotDistance;
        if (n11 <= 0) {
            n11 = (int)(this.mUsingCustomStart ? 1 : 0);
            if (n11 != 0) {
                n11 = this.mSpinnerOffsetEnd;
                n10 = this.mOriginalOffsetTop;
                n11 -= n10;
            } else {
                n11 = this.mSpinnerOffsetEnd;
            }
        }
        f17 = n11;
        n10 = 0x40000000;
        float f18 = 2.0f;
        float f19 = f17 * f18;
        f16 = Math.min(f16, f19) / f17;
        f19 = 0.0f;
        double d12 = Math.max(0.0f, f16) / 4.0f;
        double d13 = Math.pow(d12, 2.0);
        f16 = (float)(d12 -= d13) * f18;
        float f20 = f17 * f16 * f18;
        int n12 = this.mOriginalOffsetTop;
        f17 = f17 * f13 + f20;
        int n13 = (int)f17;
        n12 += n13;
        CircleImageView circleImageView = this.mCircleView;
        n13 = circleImageView.getVisibility();
        if (n13 != 0) {
            CircleImageView circleImageView2 = this.mCircleView;
            n11 = 0;
            f17 = 0.0f;
            circularProgressDrawable2 = null;
            circleImageView2.setVisibility(0);
        }
        if ((n13 = (int)(this.mScale ? 1 : 0)) == 0) {
            this.mCircleView.setScaleX(f14);
            CircleImageView circleImageView3 = this.mCircleView;
            circleImageView3.setScaleY(f14);
        }
        if ((n13 = (int)(this.mScale ? 1 : 0)) != 0) {
            f13 = this.mTotalDragDistance;
            f13 = f10 / f13;
            f13 = Math.min(f14, f13);
            this.setAnimationProgress(f13);
        }
        if ((f12 = (f11 = f10 - (f13 = this.mTotalDragDistance)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
            circularProgressDrawable = this.mProgress;
            f12 = circularProgressDrawable.getAlpha();
            n13 = 76;
            f13 = 1.06E-43f;
            if (f12 > n13 && (f12 = (float)this.isAnimationRunning((Animation)(circularProgressDrawable = this.mAlphaStartAnimation))) == false) {
                this.startProgressAlphaStartAnimation();
            }
        } else {
            circularProgressDrawable = this.mProgress;
            f12 = circularProgressDrawable.getAlpha();
            n13 = 255;
            f13 = 3.57E-43f;
            if (f12 < n13 && (f12 = (float)this.isAnimationRunning((Animation)(circularProgressDrawable = this.mAlphaMaxAnimation))) == false) {
                this.startProgressAlphaMaxAnimation();
            }
        }
        f10 = 0.8f;
        f13 = f15 * f10;
        circularProgressDrawable2 = this.mProgress;
        f10 = Math.min(f10, f13);
        circularProgressDrawable2.setStartEndTrim(0.0f, f10);
        circularProgressDrawable = this.mProgress;
        f13 = Math.min(f14, f15);
        circularProgressDrawable.setArrowScale(f13);
        f15 = f15 * 0.4f + -0.25f;
        f15 = (f15 + (f16 *= f18)) * 0.5f;
        this.mProgress.setProgressRotation(f15);
        f12 = this.mCurrentTargetOffsetTop;
        this.setTargetOffsetTopAndBottom(n12 -= f12);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getActionIndex();
        int n12 = motionEvent.getPointerId(n11);
        if (n12 == (n10 = this.mActivePointerId)) {
            int n13;
            n11 = n11 == 0 ? 1 : 0;
            this.mActivePointerId = n13 = motionEvent.getPointerId(n11);
        }
    }

    private void setColorViewAlpha(int n10) {
        this.mCircleView.getBackground().setAlpha(n10);
        this.mProgress.setAlpha(n10);
    }

    /*
     * WARNING - void declaration
     */
    private void setRefreshing(boolean bl2, boolean bl3) {
        boolean bl4 = this.mRefreshing;
        if (bl4 != bl2) {
            void var2_3;
            this.mNotify = var2_3;
            this.ensureTarget();
            this.mRefreshing = bl2;
            if (bl2) {
                int n10 = this.mCurrentTargetOffsetTop;
                Animation.AnimationListener animationListener = this.mRefreshListener;
                this.animateOffsetToCorrectPosition(n10, animationListener);
            } else {
                Animation.AnimationListener animationListener = this.mRefreshListener;
                this.startScaleDownAnimation(animationListener);
            }
        }
    }

    private Animation startAlphaAnimation(int n10, int n11) {
        SwipeRefreshLayout$4 swipeRefreshLayout$4 = new SwipeRefreshLayout$4(this, n10, n11);
        swipeRefreshLayout$4.setDuration(300L);
        this.mCircleView.setAnimationListener(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(swipeRefreshLayout$4);
        return swipeRefreshLayout$4;
    }

    private void startDragging(float f10) {
        float f11 = this.mInitialDownY;
        int n10 = this.mTouchSlop;
        float f12 = n10;
        float f13 = (f10 -= f11) - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object > 0 && (object = (Object)this.mIsBeingDragged) == false) {
            f10 = n10;
            this.mInitialMotionY = f11 += f10;
            object = true;
            f10 = Float.MIN_VALUE;
            this.mIsBeingDragged = object;
            CircularProgressDrawable circularProgressDrawable = this.mProgress;
            int n11 = 76;
            f11 = 1.06E-43f;
            circularProgressDrawable.setAlpha(n11);
        }
    }

    private void startProgressAlphaMaxAnimation() {
        Animation animation;
        int n10 = this.mProgress.getAlpha();
        this.mAlphaMaxAnimation = animation = this.startAlphaAnimation(n10, 255);
    }

    private void startProgressAlphaStartAnimation() {
        Animation animation;
        int n10 = this.mProgress.getAlpha();
        this.mAlphaStartAnimation = animation = this.startAlphaAnimation(n10, 76);
    }

    private void startScaleDownReturnToStartAnimation(int n10, Animation.AnimationListener animationListener) {
        float f10;
        this.mFrom = n10;
        this.mStartingScale = f10 = this.mCircleView.getScaleX();
        Object object = new SwipeRefreshLayout$8(this);
        this.mScaleDownToStartAnimation = object;
        long l10 = 150L;
        object.setDuration(l10);
        if (animationListener != null) {
            object = this.mCircleView;
            ((CircleImageView)((Object)object)).setAnimationListener(animationListener);
        }
        this.mCircleView.clearAnimation();
        object = this.mCircleView;
        animationListener = this.mScaleDownToStartAnimation;
        object.startAnimation((Animation)animationListener);
    }

    private void startScaleUpAnimation(Animation.AnimationListener object) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        Object object2 = new SwipeRefreshLayout$2(this);
        this.mScaleAnimation = object2;
        int n10 = this.mMediumAnimationDuration;
        long l10 = n10;
        object2.setDuration(l10);
        if (object != null) {
            object2 = this.mCircleView;
            ((CircleImageView)((Object)object2)).setAnimationListener((Animation.AnimationListener)object);
        }
        this.mCircleView.clearAnimation();
        object = this.mCircleView;
        object2 = this.mScaleAnimation;
        object.startAnimation((Animation)object2);
    }

    public boolean canChildScrollUp() {
        SwipeRefreshLayout$OnChildScrollUpCallback swipeRefreshLayout$OnChildScrollUpCallback = this.mChildScrollUpCallback;
        if (swipeRefreshLayout$OnChildScrollUpCallback != null) {
            View view = this.mTarget;
            return swipeRefreshLayout$OnChildScrollUpCallback.canChildScrollUp(this, view);
        }
        swipeRefreshLayout$OnChildScrollUpCallback = this.mTarget;
        boolean bl2 = swipeRefreshLayout$OnChildScrollUpCallback instanceof ListView;
        int n10 = -1;
        if (bl2) {
            return ListViewCompat.canScrollList((ListView)swipeRefreshLayout$OnChildScrollUpCallback, n10);
        }
        return swipeRefreshLayout$OnChildScrollUpCallback.canScrollVertically(n10);
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean bl2) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f10, f11, bl2);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int n10, int n11, int[] nArray, int[] nArray2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(n10, n11, nArray, nArray2);
    }

    public boolean dispatchNestedScroll(int n10, int n11, int n12, int n13, int[] nArray) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(n10, n11, n12, n13, nArray);
    }

    public int getChildDrawingOrder(int n10, int n11) {
        int n12 = this.mCircleViewIndex;
        if (n12 < 0) {
            return n11;
        }
        if (n11 == (n10 += -1)) {
            return n12;
        }
        if (n11 >= n12) {
            ++n11;
        }
        return n11;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void moveToStart(float f10) {
        int n10 = this.mFrom;
        int n11 = (int)((float)(this.mOriginalOffsetTop - n10) * f10);
        n10 += n11;
        n11 = this.mCircleView.getTop();
        this.setTargetOffsetTopAndBottom(n10 -= n11);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.reset();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        block5: {
            block9: {
                float f10;
                int n10;
                int n11;
                block6: {
                    int n12;
                    block7: {
                        block8: {
                            this.ensureTarget();
                            n11 = motionEvent.getActionMasked();
                            n10 = this.mReturningToStart;
                            if (n10 != 0 && n11 == 0) {
                                this.mReturningToStart = false;
                            }
                            if ((n10 = this.isEnabled()) == 0 || (n10 = this.mReturningToStart) != 0 || (n10 = this.canChildScrollUp()) != 0 || (n10 = this.mRefreshing) != 0 || (n10 = this.mNestedScrollInProgress) != 0) break block5;
                            if (n11 == 0) break block6;
                            n10 = 1;
                            n12 = -1;
                            if (n11 == n10) break block7;
                            n10 = 2;
                            if (n11 == n10) break block8;
                            n10 = 3;
                            if (n11 == n10) break block7;
                            n10 = 6;
                            if (n11 == n10) {
                                this.onSecondaryPointerUp(motionEvent);
                            }
                            break block9;
                        }
                        n11 = this.mActivePointerId;
                        if (n11 == n12) {
                            Log.e((String)LOG_TAG, (String)"Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        if ((n11 = motionEvent.findPointerIndex(n11)) < 0) {
                            return false;
                        }
                        float f11 = motionEvent.getY(n11);
                        this.startDragging(f11);
                        break block9;
                    }
                    this.mIsBeingDragged = false;
                    this.mActivePointerId = n12;
                    break block9;
                }
                n11 = this.mOriginalOffsetTop;
                CircleImageView circleImageView = this.mCircleView;
                n10 = circleImageView.getTop();
                this.setTargetOffsetTopAndBottom(n11 -= n10);
                this.mActivePointerId = n11 = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                n11 = motionEvent.findPointerIndex(n11);
                if (n11 < 0) {
                    return false;
                }
                this.mInitialDownY = f10 = motionEvent.getY(n11);
            }
            return this.mIsBeingDragged;
        }
        return false;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14 = this.getMeasuredWidth();
        int n15 = this.getMeasuredHeight();
        int n16 = this.getChildCount();
        if (n16 == 0) {
            return;
        }
        View view = this.mTarget;
        if (view == null) {
            this.ensureTarget();
        }
        if ((view = this.mTarget) == null) {
            return;
        }
        int n17 = this.getPaddingLeft();
        int n18 = this.getPaddingTop();
        int n19 = this.getPaddingLeft();
        n19 = n14 - n19;
        int n20 = this.getPaddingRight();
        n19 -= n20;
        n20 = this.getPaddingTop();
        n15 -= n20;
        n20 = this.getPaddingBottom();
        n15 -= n20;
        view.layout(n17, n18, n19 += n17, n15 += n18);
        n15 = this.mCircleView.getMeasuredWidth();
        n16 = this.mCircleView.getMeasuredHeight();
        CircleImageView circleImageView = this.mCircleView;
        int n21 = n14 / 2;
        n18 = n21 - (n15 /= 2);
        n19 = this.mCurrentTargetOffsetTop;
        int n22 = n21 + n15;
        circleImageView.layout(n18, n19, n22, n16 += n19);
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        Object object = this.mTarget;
        if (object == null) {
            this.ensureTarget();
        }
        if ((object = this.mTarget) == null) {
            return;
        }
        n11 = this.getMeasuredWidth();
        int n12 = this.getPaddingLeft();
        n11 -= n12;
        n12 = this.getPaddingRight();
        n11 -= n12;
        n12 = 0x40000000;
        n11 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n12);
        int n13 = this.getMeasuredHeight();
        int n14 = this.getPaddingTop();
        n13 -= n14;
        n14 = this.getPaddingBottom();
        n13 = View.MeasureSpec.makeMeasureSpec((int)(n13 - n14), (int)n12);
        object.measure(n11, n13);
        object = this.mCircleView;
        n11 = View.MeasureSpec.makeMeasureSpec((int)this.mCircleDiameter, (int)n12);
        n13 = this.mCircleDiameter;
        n12 = View.MeasureSpec.makeMeasureSpec((int)n13, (int)n12);
        object.measure(n11, n12);
        this.mCircleViewIndex = -1;
        object = null;
        for (n10 = 0; n10 < (n11 = this.getChildCount()); ++n10) {
            CircleImageView circleImageView;
            View view = this.getChildAt(n10);
            if (view != (circleImageView = this.mCircleView)) continue;
            this.mCircleViewIndex = n10;
            break;
        }
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean bl2) {
        return this.dispatchNestedFling(f10, f11, bl2);
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return this.dispatchNestedPreFling(f10, f11);
    }

    public void onNestedPreScroll(View object, int n10, int object2, int[] nArray) {
        float f10;
        int n11;
        float f11;
        float f12;
        float f13;
        float f14;
        Object object3 = 0;
        object = null;
        int n12 = 1;
        if (object2 > 0 && (f14 = (f13 = (f12 = this.mTotalUnconsumed) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0) {
            f11 = object2;
            float f15 = f11 - f12;
            Object object4 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object4 > 0) {
                n11 = (int)f12;
                nArray[n12] = n11 = object2 - n11;
                this.mTotalUnconsumed = 0.0f;
            } else {
                this.mTotalUnconsumed = f12 -= f11;
                nArray[n12] = object2;
            }
            f12 = this.mTotalUnconsumed;
            this.moveSpinner(f12);
        }
        if ((n11 = this.mUsingCustomStart) != 0 && object2 > 0 && (object3 = (f10 = (f12 = this.mTotalUnconsumed) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) == 0) {
            object3 = nArray[n12];
            if ((object3 = Math.abs(object2 - object3)) > 0) {
                object = this.mCircleView;
                n11 = 8;
                f12 = 1.1E-44f;
                object.setVisibility(n11);
            }
        }
        object = this.mParentScrollConsumed;
        n11 = 0;
        f12 = 0.0f;
        f14 = nArray[0];
        n10 -= f14;
        f14 = nArray[n12];
        object2 -= f14;
        f14 = 0.0f;
        f11 = 0.0f;
        if ((n10 = (int)(this.dispatchNestedPreScroll(n10, (int)object2, (int[])object, null) ? 1 : 0)) != 0) {
            n10 = nArray[0];
            object2 = object[0];
            nArray[0] = n10 += object2;
            n10 = nArray[n12];
            object3 = object[n12];
            nArray[n12] = n10 += object3;
        }
    }

    public void onNestedScroll(View object, int n10, int n11, int n12, int n13) {
        int[] nArray = this.mParentOffsetInWindow;
        this.dispatchNestedScroll(n10, n11, n12, n13, nArray);
        object = this.mParentOffsetInWindow;
        n10 = 1;
        float f10 = Float.MIN_VALUE;
        Object object2 = object[n10];
        if ((n13 += object2) < 0 && (object2 = (Object)this.canChildScrollUp()) == false) {
            float f11 = this.mTotalUnconsumed;
            n10 = Math.abs(n13);
            f10 = n10;
            this.mTotalUnconsumed = f11 += f10;
            this.moveSpinner(f11);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int n10) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, n10);
        int n11 = n10 & 2;
        this.startNestedScroll(n11);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int n10) {
        int n11 = this.isEnabled();
        n11 = n11 != 0 && (n11 = this.mReturningToStart) == 0 && (n11 = this.mRefreshing) == 0 && (n11 = n10 & 2) != 0 ? 1 : 0;
        return n11 != 0;
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        view = null;
        this.mNestedScrollInProgress = false;
        float f10 = this.mTotalUnconsumed;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (f12 > 0) {
            this.finishSpinner(f10);
            this.mTotalUnconsumed = 0.0f;
        }
        this.stopNestedScroll();
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        int n10 = motionEvent.getActionMasked();
        boolean bl3 = this.mReturningToStart;
        int n11 = 0;
        if (bl3 && n10 == 0) {
            this.mReturningToStart = false;
        }
        if (!(bl2 = this.isEnabled())) return false;
        boolean bl4 = this.mReturningToStart;
        if (bl4) return false;
        boolean bl5 = this.canChildScrollUp();
        if (bl5) return false;
        boolean bl6 = this.mRefreshing;
        if (bl6) return false;
        boolean bl7 = this.mNestedScrollInProgress;
        if (bl7) {
            return false;
        }
        int n12 = 1;
        if (n10 == 0) {
            int n13;
            this.mActivePointerId = n13 = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
            return n12 != 0;
        }
        int n14 = 0x3F000000;
        float f10 = 0.5f;
        if (n10 != n12) {
            int n15 = 2;
            if (n10 != n15) {
                int n16;
                n14 = 3;
                f10 = 4.2E-45f;
                if (n10 == n14) return false;
                n14 = 5;
                f10 = 7.0E-45f;
                if (n10 != n14) {
                    n11 = 6;
                    if (n10 != n11) {
                        return n12 != 0;
                    }
                    this.onSecondaryPointerUp(motionEvent);
                    return n12 != 0;
                }
                n10 = motionEvent.getActionIndex();
                if (n10 < 0) {
                    Log.e((String)LOG_TAG, (String)"Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.mActivePointerId = n16 = motionEvent.getPointerId(n10);
                return n12 != 0;
            }
            n10 = this.mActivePointerId;
            if ((n10 = motionEvent.findPointerIndex(n10)) < 0) {
                Log.e((String)LOG_TAG, (String)"Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float f11 = motionEvent.getY(n10);
            this.startDragging(f11);
            n10 = (int)(this.mIsBeingDragged ? 1 : 0);
            if (n10 == 0) return n12 != 0;
            float f12 = this.mInitialMotionY;
            f11 = (f11 - f12) * f10;
            f12 = 0.0f;
            float f13 = f11 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 <= 0) return false;
            this.moveSpinner(f11);
            return n12 != 0;
        }
        n10 = this.mActivePointerId;
        if ((n10 = motionEvent.findPointerIndex(n10)) < 0) {
            Log.e((String)LOG_TAG, (String)"Got ACTION_UP event but don't have an active pointer id.");
            return false;
        }
        boolean bl8 = this.mIsBeingDragged;
        if (bl8) {
            float f14 = motionEvent.getY(n10);
            float f15 = this.mInitialMotionY;
            f14 = (f14 - f15) * f10;
            this.mIsBeingDragged = false;
            this.finishSpinner(f14);
        }
        this.mActivePointerId = -1;
        return false;
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        View view;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (!(n10 < n11 && (n10 = (view = this.mTarget) instanceof AbsListView) != 0 || (view = this.mTarget) != null && (n10 = (int)(ViewCompat.isNestedScrollingEnabled(view) ? 1 : 0)) == 0)) {
            super.requestDisallowInterceptTouchEvent(bl2);
        }
    }

    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        CircleImageView circleImageView = this.mCircleView;
        int n10 = 8;
        circleImageView.setVisibility(n10);
        this.setColorViewAlpha(255);
        int n11 = this.mScale;
        if (n11 != 0) {
            n11 = 0;
            circleImageView = null;
            this.setAnimationProgress(0.0f);
        } else {
            n11 = this.mOriginalOffsetTop;
            n10 = this.mCurrentTargetOffsetTop;
            this.setTargetOffsetTopAndBottom(n11 -= n10);
        }
        this.mCurrentTargetOffsetTop = n11 = this.mCircleView.getTop();
    }

    public void setAnimationProgress(float f10) {
        this.mCircleView.setScaleX(f10);
        this.mCircleView.setScaleY(f10);
    }

    public void setColorScheme(int ... nArray) {
        this.setColorSchemeResources(nArray);
    }

    public void setColorSchemeColors(int ... nArray) {
        this.ensureTarget();
        this.mProgress.setColorSchemeColors(nArray);
    }

    public void setColorSchemeResources(int ... nArray) {
        int n10;
        Context context = this.getContext();
        int n11 = nArray.length;
        int[] nArray2 = new int[n11];
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            nArray2[i10] = n10 = ContextCompat.getColor(context, n10);
        }
        this.setColorSchemeColors(nArray2);
    }

    public void setDistanceToTriggerSync(int n10) {
        float f10;
        this.mTotalDragDistance = f10 = (float)n10;
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        if (!bl2) {
            this.reset();
        }
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(bl2);
    }

    public void setOnChildScrollUpCallback(SwipeRefreshLayout$OnChildScrollUpCallback swipeRefreshLayout$OnChildScrollUpCallback) {
        this.mChildScrollUpCallback = swipeRefreshLayout$OnChildScrollUpCallback;
    }

    public void setOnRefreshListener(SwipeRefreshLayout$OnRefreshListener swipeRefreshLayout$OnRefreshListener) {
        this.mListener = swipeRefreshLayout$OnRefreshListener;
    }

    public void setProgressBackgroundColor(int n10) {
        this.setProgressBackgroundColorSchemeResource(n10);
    }

    public void setProgressBackgroundColorSchemeColor(int n10) {
        this.mCircleView.setBackgroundColor(n10);
    }

    public void setProgressBackgroundColorSchemeResource(int n10) {
        n10 = ContextCompat.getColor(this.getContext(), n10);
        this.setProgressBackgroundColorSchemeColor(n10);
    }

    public void setProgressViewEndTarget(boolean bl2, int n10) {
        this.mSpinnerOffsetEnd = n10;
        this.mScale = bl2;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean bl2, int n10, int n11) {
        this.mScale = bl2;
        this.mOriginalOffsetTop = n10;
        this.mSpinnerOffsetEnd = n11;
        this.mUsingCustomStart = true;
        this.reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean n10) {
        int n11;
        if (n10 && (n11 = this.mRefreshing) != n10) {
            this.mRefreshing = n10;
            n10 = this.mUsingCustomStart;
            if (!n10) {
                n10 = this.mSpinnerOffsetEnd;
                n11 = this.mOriginalOffsetTop;
                n10 += n11;
            } else {
                n10 = this.mSpinnerOffsetEnd;
            }
            n11 = this.mCurrentTargetOffsetTop;
            this.setTargetOffsetTopAndBottom(n10 -= n11);
            this.mNotify = false;
            Animation.AnimationListener animationListener = this.mRefreshListener;
            this.startScaleUpAnimation(animationListener);
        } else {
            this.setRefreshing(n10 != 0, false);
        }
    }

    public void setSize(int n10) {
        float f10;
        int n11;
        if (n10 != 0) {
            n11 = 1;
            f10 = Float.MIN_VALUE;
            if (n10 != n11) {
                return;
            }
        }
        Object object = this.getResources().getDisplayMetrics();
        if (n10 == 0) {
            float f11 = 56.0f;
            f10 = object.density * f11;
            this.mCircleDiameter = n11 = (int)f10;
        } else {
            float f12 = 40.0f;
            f10 = object.density * f12;
            this.mCircleDiameter = n11 = (int)f10;
        }
        this.mCircleView.setImageDrawable(null);
        this.mProgress.setStyle(n10);
        CircleImageView circleImageView = this.mCircleView;
        object = this.mProgress;
        circleImageView.setImageDrawable((Drawable)object);
    }

    public void setSlingshotDistance(int n10) {
        this.mCustomSlingshotDistance = n10;
    }

    public void setTargetOffsetTopAndBottom(int n10) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom((View)this.mCircleView, n10);
        this.mCurrentTargetOffsetTop = n10 = this.mCircleView.getTop();
    }

    public boolean startNestedScroll(int n10) {
        return this.mNestedScrollingChildHelper.startNestedScroll(n10);
    }

    public void startScaleDownAnimation(Animation.AnimationListener object) {
        SwipeRefreshLayout$3 swipeRefreshLayout$3 = new SwipeRefreshLayout$3(this);
        this.mScaleDownAnimation = swipeRefreshLayout$3;
        swipeRefreshLayout$3.setDuration(150L);
        this.mCircleView.setAnimationListener((Animation.AnimationListener)object);
        this.mCircleView.clearAnimation();
        object = this.mCircleView;
        swipeRefreshLayout$3 = this.mScaleDownAnimation;
        object.startAnimation((Animation)swipeRefreshLayout$3);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }
}

