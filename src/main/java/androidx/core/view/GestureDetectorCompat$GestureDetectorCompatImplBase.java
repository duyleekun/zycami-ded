/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 */
package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl;
import androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler;

public class GestureDetectorCompat$GestureDetectorCompatImplBase
implements GestureDetectorCompat$GestureDetectorCompatImpl {
    private static final int DOUBLE_TAP_TIMEOUT = 0;
    private static final int LONGPRESS_TIMEOUT = 0;
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT;
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    public MotionEvent mCurrentDownEvent;
    public boolean mDeferConfirmSingleTap;
    public GestureDetector.OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    public final GestureDetector.OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    public boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;

    static {
        LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    }

    public GestureDetectorCompat$GestureDetectorCompatImplBase(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler gestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler = new GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(this, handler);
            this.mHandler = gestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler;
        } else {
            super(this);
            this.mHandler = handler;
        }
        this.mListener = onGestureListener;
        boolean bl2 = onGestureListener instanceof GestureDetector.OnDoubleTapListener;
        if (bl2) {
            onGestureListener = (GestureDetector.OnDoubleTapListener)onGestureListener;
            this.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)onGestureListener);
        }
        this.init(context);
    }

    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        boolean bl2 = this.mInLongPress;
        if (bl2) {
            this.mInLongPress = false;
        }
    }

    private void cancelTaps() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mIsDoubleTapping = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        boolean bl2 = this.mInLongPress;
        if (bl2) {
            this.mInLongPress = false;
        }
    }

    private void init(Context object) {
        if (object != null) {
            GestureDetector.OnGestureListener onGestureListener = this.mListener;
            if (onGestureListener != null) {
                int n10;
                int n11;
                this.mIsLongpressEnabled = true;
                object = ViewConfiguration.get((Context)object);
                int n12 = object.getScaledTouchSlop();
                int n13 = object.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = n11 = object.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = n10 = object.getScaledMaximumFlingVelocity();
                n12 *= n12;
                this.mTouchSlopSquare = n12;
                n13 *= n13;
                this.mDoubleTapSlopSquare = n13;
                return;
            }
            object = new IllegalArgumentException("OnGestureListener must not be null");
            throw object;
        }
        object = new IllegalArgumentException("Context must not be null");
        throw object;
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        int n10 = this.mAlwaysInBiggerTapRegion;
        boolean bl2 = false;
        if (n10 == 0) {
            return false;
        }
        long l10 = motionEvent3.getEventTime();
        long l11 = motionEvent2.getEventTime();
        long l12 = (l10 -= l11) - (l11 = (long)DOUBLE_TAP_TIMEOUT);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return false;
        }
        float f10 = motionEvent.getX();
        object = (int)f10;
        float f11 = motionEvent3.getX();
        n10 = (int)f11;
        object -= n10;
        float f12 = motionEvent.getY();
        int n11 = (int)f12;
        float f13 = motionEvent3.getY();
        int n12 = (int)f13;
        n11 -= n12;
        object *= object;
        n11 *= n11;
        if ((object += n11) < (n11 = this.mDoubleTapSlopSquare)) {
            bl2 = true;
        }
        return bl2;
    }

    public void dispatchLongPress() {
        this.mHandler.removeMessages(3);
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = true;
        GestureDetector.OnGestureListener onGestureListener = this.mListener;
        MotionEvent motionEvent = this.mCurrentDownEvent;
        onGestureListener.onLongPress(motionEvent);
    }

    public boolean isLongpressEnabled() {
        return this.mIsLongpressEnabled;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block28: {
            block29: {
                block34: {
                    block36: {
                        block37: {
                            block35: {
                                block30: {
                                    block33: {
                                        block32: {
                                            block31: {
                                                var2_2 = var1_1.getAction();
                                                var3_3 = this.mVelocityTracker;
                                                if (var3_3 == null) {
                                                    this.mVelocityTracker = var3_3 = VelocityTracker.obtain();
                                                }
                                                var3_3 = this.mVelocityTracker;
                                                var3_3.addMovement(var1_1);
                                                var4_4 = 6;
                                                var5_5 = 8.4E-45f;
                                                var6_6 = 1;
                                                var7_7 = 1.4E-45f;
                                                var8_8 = 0;
                                                var9_9 = null;
                                                if ((var2_2 &= 255) == var4_4) {
                                                    var10_10 = var6_6;
                                                    var11_11 = var7_7;
                                                } else {
                                                    var10_10 = 0;
                                                    var11_11 = 0.0f;
                                                }
                                                if (var10_10 != 0) {
                                                    var12_12 = var1_1.getActionIndex();
                                                } else {
                                                    var12_12 = -1;
                                                    var13_13 = 0.0f / 0.0f;
                                                }
                                                var14_14 = var1_1.getPointerCount();
                                                var15_15 = 0;
                                                var16_16 = 0.0f;
                                                var17_17 = null;
                                                var19_19 = null;
                                                var20_20 = 0.0f;
                                                var21_21 = null;
                                                var22_22 = 0.0f;
                                                var23_23 = 0.0f;
                                                for (var18_18 = 0; var18_18 < var14_14; ++var18_18) {
                                                    if (var12_12 == var18_18) continue;
                                                    var24_24 = var1_1.getX(var18_18);
                                                    var22_22 += var24_24;
                                                    var24_24 = var1_1.getY(var18_18);
                                                    var23_23 += var24_24;
                                                }
                                                var10_10 = var10_10 != 0 ? var14_14 + -1 : var14_14;
                                                var11_11 = var10_10;
                                                var22_22 /= var11_11;
                                                var23_23 /= var11_11;
                                                var10_10 = 2;
                                                var11_11 = 2.8E-45f;
                                                var12_12 = 3;
                                                var13_13 = 4.2E-45f;
                                                if (var2_2 == 0) break block29;
                                                var18_18 = 1000;
                                                var20_20 = 1.401E-42f;
                                                if (var2_2 == var6_6) break block30;
                                                if (var2_2 == var10_10) break block31;
                                                if (var2_2 != var12_12) {
                                                    var6_6 = 5;
                                                    var7_7 = 7.0E-45f;
                                                    if (var2_2 != var6_6) {
                                                        if (var2_2 == var4_4) {
                                                            this.mLastFocusX = var22_22;
                                                            this.mDownFocusX = var22_22;
                                                            this.mLastFocusY = var23_23;
                                                            this.mDownFocusY = var23_23;
                                                            var25_25 = this.mVelocityTracker;
                                                            var5_5 = this.mMaximumFlingVelocity;
                                                            var25_25.computeCurrentVelocity(var18_18, var5_5);
                                                            var2_2 = var1_1.getActionIndex();
                                                            var4_4 = var1_1.getPointerId(var2_2);
                                                            var26_30 = this.mVelocityTracker;
                                                            var7_7 = var26_30.getXVelocity(var4_4);
                                                            var5_5 = this.mVelocityTracker.getYVelocity(var4_4);
                                                            var11_11 = 0.0f;
                                                            for (var10_10 = 0; var10_10 < var14_14; ++var10_10) {
                                                                if (var10_10 == var2_2) continue;
                                                                var12_12 = var1_1.getPointerId(var10_10);
                                                                var19_19 = this.mVelocityTracker;
                                                                var20_20 = var19_19.getXVelocity(var12_12) * var7_7;
                                                                var21_21 = this.mVelocityTracker;
                                                                var13_13 = var21_21.getYVelocity(var12_12) * var5_5;
                                                                cfr_temp_0 = (var20_20 += var13_13) - 0.0f;
                                                                if ((var12_12 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1))) >= 0) continue;
                                                                var1_1 = this.mVelocityTracker;
                                                                var1_1.clear();
                                                                break block28;
                                                            }
                                                        }
                                                    } else {
                                                        this.mLastFocusX = var22_22;
                                                        this.mDownFocusX = var22_22;
                                                        this.mLastFocusY = var23_23;
                                                        this.mDownFocusY = var23_23;
                                                        this.cancelTaps();
                                                    }
                                                } else {
                                                    this.cancel();
                                                }
                                                break block28;
                                            }
                                            var2_2 = (int)this.mInLongPress;
                                            if (var2_2 != 0) break block28;
                                            var27_32 = this.mLastFocusX - var22_22;
                                            var5_5 = this.mLastFocusY - var23_23;
                                            var14_14 = (int)this.mIsDoubleTapping;
                                            if (var14_14 == 0) break block32;
                                            var25_26 = this.mDoubleTapListener;
                                            var28_35 = var25_26.onDoubleTapEvent(var1_1);
                                            var8_8 = 0 | var28_35;
                                            break block28;
                                        }
                                        var14_14 = (int)this.mAlwaysInTapRegion;
                                        if (var14_14 == 0) break block33;
                                        var29_38 = this.mDownFocusX;
                                        var29_38 = var22_22 - var29_38;
                                        var14_14 = (int)var29_38;
                                        var16_16 = this.mDownFocusY;
                                        var16_16 = var23_23 - var16_16;
                                        var15_15 = (int)var16_16;
                                        var14_14 *= var14_14;
                                        var15_15 *= var15_15;
                                        if ((var14_14 += var15_15) > (var15_15 = this.mTouchSlopSquare)) {
                                            var17_17 = this.mListener;
                                            var19_19 = this.mCurrentDownEvent;
                                            var28_36 = (int)var17_17.onScroll(var19_19, var1_1, var27_32, var5_5);
                                            this.mLastFocusX = var22_22;
                                            this.mLastFocusY = var23_23;
                                            this.mAlwaysInTapRegion = false;
                                            this.mHandler.removeMessages(var12_12);
                                            this.mHandler.removeMessages(var6_6);
                                            var25_27 = this.mHandler;
                                            var25_27.removeMessages(var10_10);
                                        } else {
                                            var28_36 = 0;
                                            var1_1 = null;
                                        }
                                        var2_2 = this.mTouchSlopSquare;
                                        if (var14_14 > var2_2) {
                                            this.mAlwaysInBiggerTapRegion = false;
                                        }
                                        break block34;
                                    }
                                    var7_7 = Math.abs(var27_32);
                                    var10_10 = 1065353216;
                                    var11_11 = 1.0f;
                                    cfr_temp_1 = var7_7 - var11_11;
                                    var6_6 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                                    if (var6_6 >= 0 || (var6_6 = (int)((cfr_temp_2 = (var7_7 = Math.abs(var5_5)) - var11_11) == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1))) >= 0) {
                                        var26_31 = this.mListener;
                                        var9_9 = this.mCurrentDownEvent;
                                        var8_8 = (int)var26_31.onScroll(var9_9, var1_1, var27_32, var5_5);
                                        this.mLastFocusX = var22_22;
                                        this.mLastFocusY = var23_23;
                                    }
                                    break block28;
                                }
                                this.mStillDown = false;
                                var25_28 = MotionEvent.obtain((MotionEvent)var1_1);
                                var4_4 = (int)this.mIsDoubleTapping;
                                if (var4_4 == 0) break block35;
                                var3_3 = this.mDoubleTapListener;
                                var28_36 = var3_3.onDoubleTapEvent(var1_1) | 0;
                                break block36;
                            }
                            var4_4 = (int)this.mInLongPress;
                            if (var4_4 == 0) break block37;
                            var1_1 = this.mHandler;
                            var1_1.removeMessages(var12_12);
                            this.mInLongPress = false;
                            ** GOTO lbl-1000
                        }
                        var4_4 = (int)this.mAlwaysInTapRegion;
                        if (var4_4 != 0) {
                            var3_3 = this.mListener;
                            var4_4 = (int)var3_3.onSingleTapUp(var1_1);
                            var12_12 = (int)this.mDeferConfirmSingleTap;
                            if (var12_12 != 0 && (var30_40 = this.mDoubleTapListener) != null) {
                                var30_40.onSingleTapConfirmed(var1_1);
                            }
                            var28_36 = var4_4;
                        } else {
                            var3_3 = this.mVelocityTracker;
                            var12_12 = var1_1.getPointerId(0);
                            var14_14 = this.mMaximumFlingVelocity;
                            var29_39 = var14_14;
                            var3_3.computeCurrentVelocity(var18_18, var29_39);
                            var29_39 = var3_3.getYVelocity(var12_12);
                            var5_5 = var3_3.getXVelocity(var12_12);
                            var13_13 = Math.abs(var29_39);
                            var15_15 = this.mMinimumFlingVelocity;
                            var16_16 = var15_15;
                            var12_12 = (int)(var13_13 == var16_16 ? 0 : (var13_13 > var16_16 ? 1 : -1));
                            if (var12_12 <= 0 && (var12_12 = (int)((cfr_temp_3 = (var13_13 = Math.abs(var5_5)) - (var16_16 = (float)(var15_15 = this.mMinimumFlingVelocity))) == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1))) <= 0) lbl-1000:
                            // 2 sources

                            {
                                var28_36 = 0;
                                var1_1 = null;
                            } else {
                                var30_41 = this.mListener;
                                var17_17 = this.mCurrentDownEvent;
                                var28_36 = (int)var30_41.onFling(var17_17, var1_1, var5_5, var29_39);
                            }
                        }
                    }
                    var3_3 = this.mPreviousUpEvent;
                    if (var3_3 != null) {
                        var3_3.recycle();
                    }
                    this.mPreviousUpEvent = var25_28;
                    var25_28 = this.mVelocityTracker;
                    if (var25_28 != null) {
                        var25_28.recycle();
                        var2_2 = 0;
                        var27_33 = 0.0f;
                        var25_28 = null;
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(var6_6);
                    var25_28 = this.mHandler;
                    var25_28.removeMessages(var10_10);
                }
                var8_8 = var28_36;
                break block28;
            }
            var25_29 = this.mDoubleTapListener;
            if (var25_29 == null) ** GOTO lbl232
            var25_29 = this.mHandler;
            var2_2 = (int)var25_29.hasMessages(var12_12);
            if (var2_2 != 0) {
                var3_3 = this.mHandler;
                var3_3.removeMessages(var12_12);
            }
            if ((var3_3 = this.mCurrentDownEvent) != null && (var31_42 = this.mPreviousUpEvent) != null && var2_2 != 0 && (var2_2 = (int)this.isConsideredDoubleTap((MotionEvent)var3_3, var31_42, var1_1)) != 0) {
                this.mIsDoubleTapping = var6_6;
                var25_29 = this.mDoubleTapListener;
                var3_3 = this.mCurrentDownEvent;
                var2_2 = var25_29.onDoubleTap((MotionEvent)var3_3) | 0;
                var3_3 = this.mDoubleTapListener;
                var4_4 = (int)var3_3.onDoubleTapEvent(var1_1);
                var2_2 |= var4_4;
            } else {
                var25_29 = this.mHandler;
                var4_4 = GestureDetectorCompat$GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT;
                var32_43 = var4_4;
                var25_29.sendEmptyMessageDelayed(var12_12, var32_43);
lbl232:
                // 2 sources

                var2_2 = 0;
                var25_29 = null;
                var27_34 = 0.0f;
            }
            this.mLastFocusX = var22_22;
            this.mDownFocusX = var22_22;
            this.mLastFocusY = var23_23;
            this.mDownFocusY = var23_23;
            var3_3 = this.mCurrentDownEvent;
            if (var3_3 != null) {
                var3_3.recycle();
            }
            var3_3 = MotionEvent.obtain((MotionEvent)var1_1);
            this.mCurrentDownEvent = var3_3;
            this.mAlwaysInTapRegion = var6_6;
            this.mAlwaysInBiggerTapRegion = var6_6;
            this.mStillDown = var6_6;
            this.mInLongPress = false;
            this.mDeferConfirmSingleTap = false;
            var4_4 = (int)this.mIsLongpressEnabled;
            if (var4_4 != 0) {
                this.mHandler.removeMessages(var10_10);
                var3_3 = this.mHandler;
                var9_9 = this.mCurrentDownEvent;
                var34_44 = var9_9.getDownTime();
                var36_45 = GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT;
                var34_44 += var36_45;
                var8_8 = GestureDetectorCompat$GestureDetectorCompatImplBase.LONGPRESS_TIMEOUT;
                var36_45 = var8_8;
                var3_3.sendEmptyMessageAtTime(var10_10, var34_44 += var36_45);
            }
            var3_3 = this.mHandler;
            var9_9 = this.mCurrentDownEvent;
            var38_46 = var9_9.getDownTime();
            var12_12 = GestureDetectorCompat$GestureDetectorCompatImplBase.TAP_TIMEOUT;
            var34_44 = var12_12;
            var3_3.sendEmptyMessageAtTime(var6_6, var38_46 += var34_44);
            var3_3 = this.mListener;
            var28_37 = var3_3.onDown(var1_1);
            var8_8 = var2_2 | var28_37;
        }
        return (boolean)var8_8;
    }

    public void setIsLongpressEnabled(boolean bl2) {
        this.mIsLongpressEnabled = bl2;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mDoubleTapListener = onDoubleTapListener;
    }
}

