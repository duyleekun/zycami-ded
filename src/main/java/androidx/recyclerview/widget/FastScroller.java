/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.StateListDrawable
 *  android.view.MotionEvent
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.FastScroller$1;
import androidx.recyclerview.widget.FastScroller$2;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$OnItemTouchListener;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.RecyclerView$State;

public class FastScroller
extends RecyclerView$ItemDecoration
implements RecyclerView$OnItemTouchListener {
    private static final int ANIMATION_STATE_FADING_IN = 1;
    private static final int ANIMATION_STATE_FADING_OUT = 3;
    private static final int ANIMATION_STATE_IN = 2;
    private static final int ANIMATION_STATE_OUT = 0;
    private static final int DRAG_NONE = 0;
    private static final int DRAG_X = 1;
    private static final int DRAG_Y = 2;
    private static final int[] EMPTY_STATE_SET;
    private static final int HIDE_DELAY_AFTER_DRAGGING_MS = 1200;
    private static final int HIDE_DELAY_AFTER_VISIBLE_MS = 1500;
    private static final int HIDE_DURATION_MS = 500;
    private static final int[] PRESSED_STATE_SET;
    private static final int SCROLLBAR_FULL_OPAQUE = 255;
    private static final int SHOW_DURATION_MS = 500;
    private static final int STATE_DRAGGING = 2;
    private static final int STATE_HIDDEN = 0;
    private static final int STATE_VISIBLE = 1;
    public int mAnimationState;
    private int mDragState = 0;
    private final Runnable mHideRunnable;
    public float mHorizontalDragX;
    private final int[] mHorizontalRange;
    public int mHorizontalThumbCenterX;
    private final StateListDrawable mHorizontalThumbDrawable;
    private final int mHorizontalThumbHeight;
    public int mHorizontalThumbWidth;
    private final Drawable mHorizontalTrackDrawable;
    private final int mHorizontalTrackHeight;
    private final int mMargin;
    private boolean mNeedHorizontalScrollbar = false;
    private boolean mNeedVerticalScrollbar = false;
    private final RecyclerView$OnScrollListener mOnScrollListener;
    private RecyclerView mRecyclerView;
    private int mRecyclerViewHeight = 0;
    private int mRecyclerViewWidth = 0;
    private final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator;
    private int mState = 0;
    public float mVerticalDragY;
    private final int[] mVerticalRange;
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    public int mVerticalThumbHeight;
    private final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    private final int mVerticalTrackWidth;

    static {
        int[] nArray = new int[]{16842919};
        PRESSED_STATE_SET = nArray;
        EMPTY_STATE_SET = new int[0];
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable object, Drawable drawable2, StateListDrawable stateListDrawable, Drawable drawable3, int n10, int n11, int n12) {
        int n13 = 2;
        int[] nArray = new int[n13];
        this.mVerticalRange = nArray;
        nArray = new int[n13];
        this.mHorizontalRange = nArray;
        Object object2 = new float[n13];
        object2[0] = 0.0f;
        object2[1] = 1.0f;
        object2 = ValueAnimator.ofFloat((float[])object2);
        this.mShowHideAnimator = (ValueAnimator)object2;
        this.mAnimationState = 0;
        Object object3 = new FastScroller$1(this);
        this.mHideRunnable = object3;
        this.mOnScrollListener = object3 = new FastScroller$2(this);
        this.mVerticalThumbDrawable = object;
        this.mVerticalTrackDrawable = drawable2;
        this.mHorizontalThumbDrawable = stateListDrawable;
        this.mHorizontalTrackDrawable = drawable3;
        int n14 = object.getIntrinsicWidth();
        this.mVerticalThumbWidth = n14 = Math.max(n10, n14);
        n14 = drawable2.getIntrinsicWidth();
        this.mVerticalTrackWidth = n14 = Math.max(n10, n14);
        int n15 = stateListDrawable.getIntrinsicWidth();
        this.mHorizontalThumbHeight = n15 = Math.max(n10, n15);
        n15 = drawable3.getIntrinsicWidth();
        this.mHorizontalTrackHeight = n15 = Math.max(n10, n15);
        this.mScrollbarMinimumRange = n11;
        this.mMargin = n12;
        n15 = 255;
        object.setAlpha(n15);
        drawable2.setAlpha(n15);
        super(this);
        object2.addListener((Animator.AnimatorListener)object);
        super(this);
        object2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        this.attachToRecyclerView(recyclerView);
    }

    private void cancelHide() {
        RecyclerView recyclerView = this.mRecyclerView;
        Runnable runnable = this.mHideRunnable;
        recyclerView.removeCallbacks(runnable);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this);
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView$OnScrollListener recyclerView$OnScrollListener = this.mOnScrollListener;
        recyclerView.removeOnScrollListener(recyclerView$OnScrollListener);
        this.cancelHide();
    }

    private void drawHorizontalScrollbar(Canvas canvas) {
        int n10 = this.mRecyclerViewHeight;
        int n11 = this.mHorizontalThumbHeight;
        int n12 = this.mHorizontalThumbCenterX;
        int n13 = this.mHorizontalThumbWidth;
        int n14 = n13 / 2;
        n12 -= n14;
        this.mHorizontalThumbDrawable.setBounds(0, 0, n13, n11);
        Drawable drawable2 = this.mHorizontalTrackDrawable;
        n13 = this.mRecyclerViewWidth;
        n14 = this.mHorizontalTrackHeight;
        drawable2.setBounds(0, 0, n13, n14);
        float f10 = n10 -= n11;
        canvas.translate(0.0f, f10);
        this.mHorizontalTrackDrawable.draw(canvas);
        f10 = n12;
        canvas.translate(f10, 0.0f);
        this.mHorizontalThumbDrawable.draw(canvas);
        f10 = -n12;
        float f11 = -n10;
        canvas.translate(f10, f11);
    }

    private void drawVerticalScrollbar(Canvas canvas) {
        int n10 = this.mRecyclerViewWidth;
        int n11 = this.mVerticalThumbWidth;
        n10 -= n11;
        int n12 = this.mVerticalThumbCenterY;
        int n13 = this.mVerticalThumbHeight;
        int n14 = n13 / 2;
        n12 -= n14;
        StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
        stateListDrawable.setBounds(0, 0, n11, n13);
        Drawable drawable2 = this.mVerticalTrackDrawable;
        n13 = this.mVerticalTrackWidth;
        n14 = this.mRecyclerViewHeight;
        drawable2.setBounds(0, 0, n13, n14);
        n11 = (int)(this.isLayoutRTL() ? 1 : 0);
        if (n11 != 0) {
            Drawable drawable3 = this.mVerticalTrackDrawable;
            drawable3.draw(canvas);
            float f10 = this.mVerticalThumbWidth;
            float f11 = n12;
            canvas.translate(f10, f11);
            f10 = -1.0f;
            f11 = 1.0f;
            canvas.scale(f10, f11);
            StateListDrawable stateListDrawable2 = this.mVerticalThumbDrawable;
            stateListDrawable2.draw(canvas);
            canvas.scale(f10, f11);
            n10 = -this.mVerticalThumbWidth;
            f10 = n10;
            n11 = -n12;
            f11 = n11;
            canvas.translate(f10, f11);
        } else {
            float f12 = n10;
            n13 = 0;
            Object var12_15 = null;
            canvas.translate(f12, 0.0f);
            this.mVerticalTrackDrawable.draw(canvas);
            f12 = n12;
            canvas.translate(0.0f, f12);
            drawable2 = this.mVerticalThumbDrawable;
            drawable2.draw(canvas);
            n10 = -n10;
            float f13 = n10;
            n11 = -n12;
            f12 = n11;
            canvas.translate(f13, f12);
        }
    }

    private int[] getHorizontalRange() {
        int n10;
        int n11;
        int[] nArray = this.mHorizontalRange;
        nArray[0] = n11 = this.mMargin;
        nArray[1] = n10 = this.mRecyclerViewWidth - n11;
        return nArray;
    }

    private int[] getVerticalRange() {
        int n10;
        int n11;
        int[] nArray = this.mVerticalRange;
        nArray[0] = n11 = this.mMargin;
        nArray[1] = n10 = this.mRecyclerViewHeight - n11;
        return nArray;
    }

    private void horizontalScrollTo(float f10) {
        int n10;
        int n11;
        float f11;
        int[] nArray = this.getHorizontalRange();
        float f12 = nArray[0];
        f10 = Math.min((float)nArray[1], f10);
        float f13 = (f12 = Math.abs((float)this.mHorizontalThumbCenterX - (f10 = Math.max(f12, f10)))) - (f11 = 2.0f);
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object < 0) {
            return;
        }
        f11 = this.mHorizontalDragX;
        int n12 = this.mRecyclerView.computeHorizontalScrollRange();
        object = this.scrollTo(f11, f10, nArray, n12, n11 = this.mRecyclerView.computeHorizontalScrollOffset(), n10 = this.mRecyclerViewWidth);
        if (object != false) {
            RecyclerView recyclerView = this.mRecyclerView;
            recyclerView.scrollBy((int)object, 0);
        }
        this.mHorizontalDragX = f10;
    }

    private boolean isLayoutRTL() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        int n11 = ViewCompat.getLayoutDirection((View)recyclerView);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private void resetHideDelay(int n10) {
        this.cancelHide();
        RecyclerView recyclerView = this.mRecyclerView;
        Runnable runnable = this.mHideRunnable;
        long l10 = n10;
        recyclerView.postDelayed(runnable, l10);
    }

    private int scrollTo(float f10, float f11, int[] nArray, int n10, int n11, int n12) {
        int n13 = nArray[1];
        int n14 = nArray[0];
        if ((n13 -= n14) == 0) {
            return 0;
        }
        f11 -= f10;
        f10 = n13;
        f11 /= f10;
        f10 = n10 -= n12;
        int n15 = (int)(f11 *= f10);
        if ((n11 += n15) < n10 && n11 >= 0) {
            return n15;
        }
        return 0;
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this);
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView$OnScrollListener recyclerView$OnScrollListener = this.mOnScrollListener;
        recyclerView.addOnScrollListener(recyclerView$OnScrollListener);
    }

    private void verticalScrollTo(float f10) {
        int n10;
        int n11;
        float f11;
        int[] nArray = this.getVerticalRange();
        float f12 = nArray[0];
        f10 = Math.min((float)nArray[1], f10);
        float f13 = (f12 = Math.abs((float)this.mVerticalThumbCenterY - (f10 = Math.max(f12, f10)))) - (f11 = 2.0f);
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object < 0) {
            return;
        }
        f11 = this.mVerticalDragY;
        int n12 = this.mRecyclerView.computeVerticalScrollRange();
        object = this.scrollTo(f11, f10, nArray, n12, n11 = this.mRecyclerView.computeVerticalScrollOffset(), n10 = this.mRecyclerViewHeight);
        if (object != false) {
            RecyclerView recyclerView = this.mRecyclerView;
            recyclerView.scrollBy(0, (int)object);
        }
        this.mVerticalDragY = f10;
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
            this.setupCallbacks();
        }
    }

    public Drawable getHorizontalThumbDrawable() {
        return this.mHorizontalThumbDrawable;
    }

    public Drawable getHorizontalTrackDrawable() {
        return this.mHorizontalTrackDrawable;
    }

    public Drawable getVerticalThumbDrawable() {
        return this.mVerticalThumbDrawable;
    }

    public Drawable getVerticalTrackDrawable() {
        return this.mVerticalTrackDrawable;
    }

    public void hide(int n10) {
        block2: {
            float f10;
            ValueAnimator valueAnimator;
            int n11;
            int n12;
            block1: {
                block0: {
                    n12 = this.mAnimationState;
                    n11 = 2;
                    int n13 = 1;
                    if (n12 == n13) break block0;
                    if (n12 == n11) break block1;
                    break block2;
                }
                valueAnimator = this.mShowHideAnimator;
                valueAnimator.cancel();
            }
            this.mAnimationState = n12 = 3;
            valueAnimator = this.mShowHideAnimator;
            float[] fArray = new float[n11];
            Float f11 = (Float)valueAnimator.getAnimatedValue();
            fArray[0] = f10 = f11.floatValue();
            fArray[n13] = 0.0f;
            valueAnimator.setFloatValues(fArray);
            valueAnimator = this.mShowHideAnimator;
            long l10 = n10;
            valueAnimator.setDuration(l10);
            ValueAnimator valueAnimator2 = this.mShowHideAnimator;
            valueAnimator2.start();
        }
    }

    public boolean isDragging() {
        int n10 = this.mState;
        int n11 = 2;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isPointInsideHorizontalThumb(float f10, float f11) {
        int n10 = this.mRecyclerViewHeight;
        int n11 = this.mHorizontalThumbHeight;
        float f12 = n10 -= n11;
        float f13 = f11 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object < 0) return 0 != 0;
        int n12 = this.mHorizontalThumbCenterX;
        n10 = this.mHorizontalThumbWidth;
        n11 = n10 / 2;
        float f14 = n12 - n11;
        float f15 = f10 - f14;
        if ((n11 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1))) < 0) return 0 != 0;
        int n13 = n12 + (n10 /= 2);
        f11 = n13;
        float f16 = f10 - f11;
        Object object2 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
        if (object2 > 0) return 0 != 0;
        return 1 != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isPointInsideVerticalThumb(float f10, float f11) {
        void var5_13;
        block5: {
            float f12;
            float f13;
            int n10;
            int n11;
            block6: {
                block4: {
                    n11 = this.isLayoutRTL();
                    if (n11 == 0) break block4;
                    n11 = this.mVerticalThumbWidth;
                    float f14 = n11;
                    float f15 = f10 - f14;
                    Object object = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                    if (object > 0) break block5;
                    break block6;
                }
                n11 = this.mRecyclerViewWidth;
                n10 = this.mVerticalThumbWidth;
                float f16 = n11 -= n10;
                float f17 = f10 - f16;
                Object object = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
                if (object < 0) break block5;
            }
            int n12 = this.mVerticalThumbCenterY;
            n11 = this.mVerticalThumbHeight;
            n10 = n11 / 2;
            float f18 = n12 - n10;
            n10 = (int)(f11 == f18 ? 0 : (f11 > f18 ? 1 : -1));
            if (n10 >= 0 && (f13 = (f12 = f11 - (f10 = (float)(n12 + (n11 /= 2)))) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) <= 0) {
                return (boolean)var5_13;
            }
        }
        boolean bl2 = false;
        return (boolean)var5_13;
    }

    public boolean isVisible() {
        int n10 = this.mState;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView$State object) {
        int n10;
        int n11 = this.mRecyclerViewWidth;
        object = this.mRecyclerView;
        int n12 = object.getWidth();
        if (n11 == n12 && (n11 = this.mRecyclerViewHeight) == (n12 = (object = this.mRecyclerView).getHeight())) {
            n11 = this.mAnimationState;
            if (n11 != 0) {
                n11 = (int)(this.mNeedVerticalScrollbar ? 1 : 0);
                if (n11 != 0) {
                    this.drawVerticalScrollbar(canvas);
                }
                if ((n11 = (int)(this.mNeedHorizontalScrollbar ? 1 : 0)) != 0) {
                    this.drawHorizontalScrollbar(canvas);
                }
            }
            return;
        }
        this.mRecyclerViewWidth = n10 = this.mRecyclerView.getWidth();
        this.mRecyclerViewHeight = n10 = this.mRecyclerView.getHeight();
        this.setState(0);
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int n10;
        block7: {
            int n11;
            block8: {
                int n12;
                int n13;
                block6: {
                    n13 = this.mState;
                    n10 = 0;
                    n12 = 2;
                    n11 = 1;
                    if (n13 != n11) break block6;
                    float f10 = motionEvent.getX();
                    float f11 = motionEvent.getY();
                    n13 = this.isPointInsideVerticalThumb(f10, f11);
                    f11 = motionEvent.getX();
                    float f12 = motionEvent.getY();
                    boolean bl2 = this.isPointInsideHorizontalThumb(f11, f12);
                    int n14 = motionEvent.getAction();
                    if (n14 != 0 || n13 == 0 && !bl2) break block7;
                    if (bl2) {
                        this.mDragState = n11;
                        n13 = (int)motionEvent.getX();
                        this.mHorizontalDragX = f10 = (float)n13;
                    } else if (n13 != 0) {
                        this.mDragState = n12;
                        n13 = (int)motionEvent.getY();
                        this.mVerticalDragY = f10 = (float)n13;
                    }
                    this.setState(n12);
                    break block8;
                }
                if (n13 != n12) break block7;
            }
            n10 = n11;
        }
        return n10 != 0;
    }

    public void onRequestDisallowInterceptTouchEvent(boolean bl2) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int n10 = this.mState;
        if (n10 == 0) {
            return;
        }
        n10 = motionEvent.getAction();
        int n11 = 1;
        int n12 = 2;
        if (n10 == 0) {
            float f10 = motionEvent.getX();
            float f11 = motionEvent.getY();
            n10 = (int)(this.isPointInsideVerticalThumb(f10, f11) ? 1 : 0);
            f11 = motionEvent.getX();
            float f12 = motionEvent.getY();
            boolean bl2 = this.isPointInsideHorizontalThumb(f11, f12);
            if (n10 != 0 || bl2) {
                if (bl2) {
                    this.mDragState = n11;
                    n10 = (int)motionEvent.getX();
                    this.mHorizontalDragX = f10 = (float)n10;
                } else if (n10 != 0) {
                    this.mDragState = n12;
                    n10 = (int)motionEvent.getY();
                    this.mVerticalDragY = f10 = (float)n10;
                }
                this.setState(n12);
            }
        } else {
            n10 = motionEvent.getAction();
            if (n10 == n11 && (n10 = this.mState) == n12) {
                this.mVerticalDragY = 0.0f;
                this.mHorizontalDragX = 0.0f;
                this.setState(n11);
                n10 = 0;
                float f13 = 0.0f;
                this.mDragState = 0;
            } else {
                n10 = motionEvent.getAction();
                if (n10 == n12 && (n10 = this.mState) == n12) {
                    float f14;
                    this.show();
                    n10 = this.mDragState;
                    if (n10 == n11) {
                        f14 = motionEvent.getX();
                        this.horizontalScrollTo(f14);
                    }
                    if ((n10 = this.mDragState) == n12) {
                        f14 = motionEvent.getY();
                        this.verticalScrollTo(f14);
                    }
                }
            }
        }
    }

    public void requestRedraw() {
        this.mRecyclerView.invalidate();
    }

    public void setState(int n10) {
        Object object;
        int n11;
        int n12 = 2;
        if (n10 == n12 && (n11 = this.mState) != n12) {
            object = this.mVerticalThumbDrawable;
            int[] nArray = PRESSED_STATE_SET;
            object.setState(nArray);
            this.cancelHide();
        }
        if (n10 == 0) {
            this.requestRedraw();
        } else {
            this.show();
        }
        n11 = this.mState;
        if (n11 == n12 && n10 != n12) {
            StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
            object = EMPTY_STATE_SET;
            stateListDrawable.setState((int[])object);
            n12 = 1200;
            this.resetHideDelay(n12);
        } else {
            n12 = 1;
            if (n10 == n12) {
                n12 = 1500;
                this.resetHideDelay(n12);
            }
        }
        this.mState = n10;
    }

    public void show() {
        block3: {
            float f10;
            float f11;
            ValueAnimator valueAnimator;
            int n10;
            block2: {
                n10 = this.mAnimationState;
                if (n10 == 0) break block2;
                int n11 = 3;
                if (n10 != n11) break block3;
                valueAnimator = this.mShowHideAnimator;
                valueAnimator.cancel();
            }
            this.mAnimationState = n10 = 1;
            ValueAnimator valueAnimator2 = this.mShowHideAnimator;
            int n12 = 2;
            float[] fArray = new float[n12];
            Float f12 = (Float)valueAnimator2.getAnimatedValue();
            fArray[0] = f11 = f12.floatValue();
            fArray[n10] = f10 = 1.0f;
            valueAnimator2.setFloatValues(fArray);
            this.mShowHideAnimator.setDuration(500L);
            valueAnimator = this.mShowHideAnimator;
            long l10 = 0L;
            valueAnimator.setStartDelay(l10);
            valueAnimator = this.mShowHideAnimator;
            valueAnimator.start();
        }
    }

    public void updateScrollPosition(int n10, int n11) {
        float f10;
        float f11;
        RecyclerView recyclerView;
        RecyclerView recyclerView2 = this.mRecyclerView;
        int n12 = recyclerView2.computeVerticalScrollRange();
        int n13 = this.mRecyclerViewHeight;
        int n14 = n12 - n13;
        float f12 = 0.0f;
        int n15 = 1;
        float f13 = Float.MIN_VALUE;
        if (n14 > 0 && n13 >= (n14 = this.mScrollbarMinimumRange)) {
            n14 = n15;
        } else {
            n14 = 0;
            recyclerView = null;
        }
        this.mNeedVerticalScrollbar = n14;
        recyclerView = this.mRecyclerView;
        n14 = recyclerView.computeHorizontalScrollRange();
        int n16 = this.mRecyclerViewWidth;
        int n17 = n14 - n16;
        if (n17 > 0 && n16 >= (n17 = this.mScrollbarMinimumRange)) {
            n17 = n15;
            f11 = f13;
        } else {
            n17 = 0;
            f11 = 0.0f;
        }
        this.mNeedHorizontalScrollbar = n17;
        boolean bl2 = this.mNeedVerticalScrollbar;
        if (!bl2 && n17 == 0) {
            n10 = this.mState;
            if (n10 != 0) {
                this.setState(0);
            }
            return;
        }
        f12 = 2.0f;
        if (bl2) {
            f10 = n11;
            f11 = n13;
            float f14 = f11 / f12;
            f11 *= (f10 += f14);
            f10 = n12;
            this.mVerticalThumbCenterY = n11 = (int)(f11 /= f10);
            n11 = n13 * n13 / n12;
            this.mVerticalThumbHeight = n11 = Math.min(n13, n11);
        }
        if ((n11 = (int)(this.mNeedHorizontalScrollbar ? 1 : 0)) != 0) {
            float f15 = n10;
            f10 = n16;
            float f16 = f10 / f12;
            f10 *= (f15 += f16);
            f15 = n14;
            this.mHorizontalThumbCenterX = n10 = (int)(f10 /= f15);
            n10 = n16 * n16 / n14;
            this.mHorizontalThumbWidth = n10 = Math.min(n16, n10);
        }
        if ((n10 = this.mState) == 0 || n10 == n15) {
            this.setState(n15);
        }
    }
}

