/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.SystemClock
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  android.view.animation.Interpolator
 */
package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper$ClampedScroller;
import androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable;

public abstract class AutoScrollHelper
implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = 0;
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    public boolean mAnimating;
    private final Interpolator mEdgeInterpolator;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges;
    private float[] mMaximumVelocity;
    private float[] mMinimumVelocity;
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    private float[] mRelativeEdges;
    private float[] mRelativeVelocity;
    private Runnable mRunnable;
    public final AutoScrollHelper$ClampedScroller mScroller;
    public final View mTarget;

    static {
        DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    }

    public AutoScrollHelper(View view) {
        Object object = new AutoScrollHelper$ClampedScroller();
        this.mScroller = object;
        this.mEdgeInterpolator = object;
        int n10 = 2;
        float[] fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = 0.0f;
        this.mRelativeEdges = fArray;
        fArray = new float[n10];
        fArray[0] = Float.MAX_VALUE;
        fArray[1] = Float.MAX_VALUE;
        this.mMaximumEdges = fArray;
        fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = 0.0f;
        this.mRelativeVelocity = fArray;
        fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = 0.0f;
        this.mMinimumVelocity = fArray;
        Object object2 = object = (Object)new float[n10];
        object2[0] = Float.MAX_VALUE;
        object2[1] = Float.MAX_VALUE;
        this.mMaximumVelocity = (float[])object;
        this.mTarget = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = 1575.0f * f10;
        float f12 = 0.5f;
        n10 = (int)(f11 + f12);
        int n11 = (int)(f10 * 315.0f + f12);
        f11 = n10;
        this.setMaximumVelocity(f11, f11);
        f10 = n11;
        this.setMinimumVelocity(f10, f10);
        this.setEdgeType(1);
        f10 = Float.MAX_VALUE;
        this.setMaximumEdges(f10, f10);
        f10 = 0.2f;
        this.setRelativeEdges(f10, f10);
        f10 = 1.0f;
        this.setRelativeVelocity(f10, f10);
        n11 = DEFAULT_ACTIVATION_DELAY;
        this.setActivationDelay(n11);
        n11 = 500;
        this.setRampUpDuration(n11);
        this.setRampDownDuration(n11);
    }

    private float computeTargetVelocity(int n10, float f10, float f11, float f12) {
        float[] fArray = this.mRelativeEdges;
        float f13 = fArray[n10];
        float[] fArray2 = this.mMaximumEdges;
        float f14 = fArray2[n10];
        f10 = this.getEdgeValue(f13, f11, f14, f10);
        f11 = 0.0f;
        float[] fArray3 = null;
        float f15 = f10 - 0.0f;
        Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object == false) {
            return 0.0f;
        }
        fArray3 = this.mRelativeVelocity;
        f11 = fArray3[n10];
        fArray2 = this.mMinimumVelocity;
        f14 = fArray2[n10];
        float[] fArray4 = this.mMaximumVelocity;
        float f16 = fArray4[n10];
        f11 *= f12;
        if (object > 0) {
            return AutoScrollHelper.constrain(f10 * f11, f14, f16);
        }
        return -AutoScrollHelper.constrain(-f10 * f11, f14, f16);
    }

    public static float constrain(float f10, float f11, float f12) {
        Object object = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        if (object > 0) {
            return f12;
        }
        Object object2 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object2 < 0) {
            return f11;
        }
        return f10;
    }

    public static int constrain(int n10, int n11, int n12) {
        if (n10 > n12) {
            return n12;
        }
        if (n10 < n11) {
            return n11;
        }
        return n10;
    }

    private float constrainEdgeValue(float f10, float f11) {
        float f12 = f11 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return 0.0f;
        }
        object = this.mEdgeType;
        int n10 = 1;
        if (object != false && object != n10) {
            float f13;
            n10 = 2;
            if (object == n10 && (object = (f13 = f10 - 0.0f) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) < 0) {
                f11 = -f11;
                return f10 / f11;
            }
        } else {
            Object object2 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
            if (object2 < 0) {
                float f14 = f10 - 0.0f;
                object2 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                float f15 = 1.0f;
                if (object2 >= 0) {
                    return f15 - (f10 /= f11);
                }
                boolean bl2 = this.mAnimating;
                if (bl2 && object == n10) {
                    return f15;
                }
            }
        }
        return 0.0f;
    }

    private float getEdgeValue(float f10, float f11, float f12, float f13) {
        block4: {
            block3: {
                Object object;
                block2: {
                    f10 = AutoScrollHelper.constrain(f10 * f11, 0.0f, f12);
                    f12 = this.constrainEdgeValue(f13, f10);
                    float f14 = (f10 = this.constrainEdgeValue(f11 -= f13, f10) - f12) - 0.0f;
                    object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                    if (object >= 0) break block2;
                    Interpolator interpolator2 = this.mEdgeInterpolator;
                    f10 = -f10;
                    f10 = -interpolator2.getInterpolation(f10);
                    break block3;
                }
                float f15 = f10 - 0.0f;
                object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                if (object <= 0) break block4;
                Interpolator interpolator3 = this.mEdgeInterpolator;
                f10 = interpolator3.getInterpolation(f10);
            }
            return AutoScrollHelper.constrain(f10, -1.0f, 1.0f);
        }
        return 0.0f;
    }

    private void requestStop() {
        boolean bl2 = this.mNeedsReset;
        if (bl2) {
            bl2 = false;
            Object var2_2 = null;
            this.mAnimating = false;
        } else {
            AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
            autoScrollHelper$ClampedScroller.requestStop();
        }
    }

    private void startAnimating() {
        boolean bl2;
        Runnable runnable = this.mRunnable;
        if (runnable == null) {
            this.mRunnable = runnable = new AutoScrollHelper$ScrollAnimationRunnable(this);
        }
        this.mAnimating = bl2 = true;
        this.mNeedsReset = bl2;
        int n10 = this.mAlreadyDelayed;
        if (n10 == 0 && (n10 = this.mActivationDelay) > 0) {
            View view = this.mTarget;
            Runnable runnable2 = this.mRunnable;
            long l10 = n10;
            ViewCompat.postOnAnimationDelayed(view, runnable2, l10);
        } else {
            Runnable runnable3 = this.mRunnable;
            runnable3.run();
        }
        this.mAlreadyDelayed = bl2;
    }

    public abstract boolean canTargetScrollHorizontally(int var1);

    public abstract boolean canTargetScrollVertically(int var1);

    public void cancelTargetTouch() {
        long l10 = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain((long)l10, (long)l10, (int)3, (float)0.0f, (float)0.0f, (int)0);
        this.mTarget.onTouchEvent(motionEvent);
        motionEvent.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    public boolean onTouch(View view, MotionEvent object) {
        int n10;
        int n11;
        int n12;
        block8: {
            float f10;
            int n13;
            block7: {
                block5: {
                    block6: {
                        int n14 = this.mEnabled;
                        n12 = 0;
                        if (n14 == 0) {
                            return false;
                        }
                        n14 = object.getActionMasked();
                        n11 = 1;
                        if (n14 == 0) break block5;
                        if (n14 == n11) break block6;
                        n13 = 2;
                        f10 = 2.8E-45f;
                        if (n14 == n13) break block7;
                        n10 = 3;
                        float f11 = 4.2E-45f;
                        if (n14 != n10) break block8;
                    }
                    this.requestStop();
                    break block8;
                }
                this.mNeedsCancel = n11;
                this.mAlreadyDelayed = false;
            }
            float f12 = object.getX();
            f10 = view.getWidth();
            View view2 = this.mTarget;
            int n15 = view2.getWidth();
            float f13 = n15;
            f12 = this.computeTargetVelocity(0, f12, f10, f13);
            float f14 = object.getY();
            float f15 = view.getHeight();
            View view3 = this.mTarget;
            n13 = view3.getHeight();
            f10 = n13;
            f15 = this.computeTargetVelocity(n11, f14, f15, f10);
            object = this.mScroller;
            ((AutoScrollHelper$ClampedScroller)object).setTargetVelocity(f12, f15);
            n10 = (int)(this.mAnimating ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(this.shouldAnimate() ? 1 : 0)) != 0) {
                this.startAnimating();
            }
        }
        n10 = this.mExclusive;
        if (n10 != 0 && (n10 = (int)(this.mAnimating ? 1 : 0)) != 0) {
            n12 = n11;
        }
        return n12 != 0;
    }

    public abstract void scrollTargetBy(int var1, int var2);

    public AutoScrollHelper setActivationDelay(int n10) {
        this.mActivationDelay = n10;
        return this;
    }

    public AutoScrollHelper setEdgeType(int n10) {
        this.mEdgeType = n10;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean bl2) {
        boolean bl3 = this.mEnabled;
        if (bl3 && !bl2) {
            this.requestStop();
        }
        this.mEnabled = bl2;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean bl2) {
        this.mExclusive = bl2;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f10, float f11) {
        float[] fArray = this.mMaximumEdges;
        fArray[0] = f10;
        fArray[1] = f11;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f10, float f11) {
        float[] fArray = this.mMaximumVelocity;
        float f12 = 1000.0f;
        fArray[0] = f10 /= f12;
        fArray[1] = f11 /= f12;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f10, float f11) {
        float[] fArray = this.mMinimumVelocity;
        float f12 = 1000.0f;
        fArray[0] = f10 /= f12;
        fArray[1] = f11 /= f12;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int n10) {
        this.mScroller.setRampDownDuration(n10);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int n10) {
        this.mScroller.setRampUpDuration(n10);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f10, float f11) {
        float[] fArray = this.mRelativeEdges;
        fArray[0] = f10;
        fArray[1] = f11;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f10, float f11) {
        float[] fArray = this.mRelativeVelocity;
        float f12 = 1000.0f;
        fArray[0] = f10 /= f12;
        fArray[1] = f11 /= f12;
        return this;
    }

    /*
     * WARNING - void declaration
     */
    public boolean shouldAnimate() {
        void var3_7;
        boolean bl2;
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        int n10 = autoScrollHelper$ClampedScroller.getVerticalDirection();
        int bl22 = autoScrollHelper$ClampedScroller.getHorizontalDirection();
        if (n10 != 0 && (n10 = (int)(this.canTargetScrollVertically(n10) ? 1 : 0)) != 0 || bl22 != 0 && (bl2 = this.canTargetScrollHorizontally(bl22))) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            autoScrollHelper$ClampedScroller = null;
        }
        return (boolean)var3_7;
    }
}

