/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.CaptureResult$Key
 *  android.hardware.camera2.TotalCaptureResult
 *  android.hardware.camera2.params.MeteringRectangle
 *  android.os.Build$VERSION
 *  android.util.Rational
 */
package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.FocusMeteringControl$1;
import androidx.camera.camera2.internal.FocusMeteringControl$2;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import b.a.a.d.o0;
import b.a.a.d.p0;
import b.a.a.d.q0;
import b.a.a.d.r0;
import b.a.a.d.s0;
import b.a.a.d.t0;
import b.a.a.d.u0;
import b.a.a.d.v0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class FocusMeteringControl {
    private static final String TAG = "FocusMeteringControl";
    private MeteringRectangle[] mAeRects;
    private MeteringRectangle[] mAfRects;
    private ScheduledFuture mAutoCancelHandle;
    private MeteringRectangle[] mAwbRects;
    private final Camera2CameraControlImpl mCameraControl;
    public Integer mCurrentAfState;
    public MeteringRectangle[] mDefaultAeRects;
    public MeteringRectangle[] mDefaultAfRects;
    public MeteringRectangle[] mDefaultAwbRects;
    public final Executor mExecutor;
    public long mFocusTimeoutCounter;
    private volatile boolean mIsActive = false;
    public boolean mIsAutoFocusCompleted;
    public boolean mIsFocusSuccessful;
    private boolean mIsInAfAutoMode = false;
    public CallbackToFutureAdapter$Completer mRunningActionCompleter;
    public CallbackToFutureAdapter$Completer mRunningCancelCompleter;
    private final ScheduledExecutorService mScheduler;
    private Camera2CameraControlImpl$CaptureResultListener mSessionListenerForCancel;
    private Camera2CameraControlImpl$CaptureResultListener mSessionListenerForFocus;

    public FocusMeteringControl(Camera2CameraControlImpl camera2CameraControlImpl, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        Integer n10;
        this.mCurrentAfState = n10 = Integer.valueOf(0);
        this.mFocusTimeoutCounter = 0L;
        this.mIsAutoFocusCompleted = false;
        this.mIsFocusSuccessful = false;
        this.mSessionListenerForFocus = null;
        this.mSessionListenerForCancel = null;
        MeteringRectangle[] meteringRectangleArray = new MeteringRectangle[]{};
        this.mAfRects = meteringRectangleArray;
        meteringRectangleArray = new MeteringRectangle[]{};
        this.mAeRects = meteringRectangleArray;
        meteringRectangleArray = new MeteringRectangle[]{};
        this.mAwbRects = meteringRectangleArray;
        meteringRectangleArray = new MeteringRectangle[]{};
        this.mDefaultAfRects = meteringRectangleArray;
        meteringRectangleArray = new MeteringRectangle[]{};
        this.mDefaultAeRects = meteringRectangleArray;
        MeteringRectangle[] meteringRectangleArray2 = new MeteringRectangle[]{};
        this.mDefaultAwbRects = meteringRectangleArray2;
        this.mRunningActionCompleter = null;
        this.mRunningCancelCompleter = null;
        this.mCameraControl = camera2CameraControlImpl;
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
    }

    private /* synthetic */ void a(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.cancelFocusAndMeteringInternal(callbackToFutureAdapter$Completer);
    }

    private /* synthetic */ Object c(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        r0 r02 = new r0(this, callbackToFutureAdapter$Completer);
        executor.execute(r02);
        return "cancelFocusAndMetering";
    }

    private void completeActionFuture(boolean bl2) {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mRunningActionCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            FocusMeteringResult focusMeteringResult = FocusMeteringResult.create(bl2);
            callbackToFutureAdapter$Completer.set(focusMeteringResult);
            bl2 = false;
            focusMeteringResult = null;
            this.mRunningActionCompleter = null;
        }
    }

    private void completeCancelFuture() {
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mRunningCancelCompleter;
        if (callbackToFutureAdapter$Completer != null) {
            callbackToFutureAdapter$Completer.set(null);
            this.mRunningCancelCompleter = null;
        }
    }

    private void disableAutoCancel() {
        ScheduledFuture scheduledFuture = this.mAutoCancelHandle;
        if (scheduledFuture != null) {
            boolean bl2 = true;
            scheduledFuture.cancel(bl2);
            scheduledFuture = null;
            this.mAutoCancelHandle = null;
        }
    }

    private /* synthetic */ boolean e(int n10, TotalCaptureResult meteringRectangleArray) {
        MeteringRectangle[] meteringRectangleArray2;
        Object object = CaptureResult.CONTROL_AF_MODE;
        object = (Integer)meteringRectangleArray.get((CaptureResult.Key)object);
        meteringRectangleArray = meteringRectangleArray.getRequest();
        MeteringRectangle[] meteringRectangleArray3 = CaptureRequest.CONTROL_AF_REGIONS;
        meteringRectangleArray3 = (MeteringRectangle[])meteringRectangleArray.get((CaptureRequest.Key)meteringRectangleArray3);
        MeteringRectangle[] meteringRectangleArray4 = CaptureRequest.CONTROL_AE_REGIONS;
        meteringRectangleArray4 = (MeteringRectangle[])meteringRectangleArray.get((CaptureRequest.Key)meteringRectangleArray4);
        CaptureRequest.Key key = CaptureRequest.CONTROL_AWB_REGIONS;
        meteringRectangleArray = (MeteringRectangle[])meteringRectangleArray.get(key);
        int n11 = (Integer)object;
        if (n11 == n10 && (n10 = (int)(FocusMeteringControl.hasEqualRegions(meteringRectangleArray3, meteringRectangleArray2 = this.mDefaultAfRects) ? 1 : 0)) != 0 && (n10 = (int)(FocusMeteringControl.hasEqualRegions(meteringRectangleArray4, meteringRectangleArray2 = this.mDefaultAeRects) ? 1 : 0)) != 0 && (n10 = (int)(FocusMeteringControl.hasEqualRegions(meteringRectangleArray, meteringRectangleArray2 = this.mDefaultAwbRects) ? 1 : 0)) != 0) {
            this.completeCancelFuture();
            return true;
        }
        return false;
    }

    private void executeMeteringAction(MeteringRectangle[] object, MeteringRectangle[] object2, MeteringRectangle[] object3, FocusMeteringAction focusMeteringAction) {
        Object object4 = this.mCameraControl;
        Object object5 = this.mSessionListenerForFocus;
        ((Camera2CameraControlImpl)object4).removeCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object5);
        this.disableAutoCancel();
        this.mAfRects = object;
        this.mAeRects = object2;
        this.mAwbRects = object3;
        boolean bl2 = this.shouldTriggerAF();
        boolean bl3 = true;
        if (bl2) {
            this.mIsInAfAutoMode = bl3;
            this.mIsAutoFocusCompleted = false;
            this.mIsFocusSuccessful = false;
            this.mCameraControl.updateSessionConfigSynchronous();
            bl2 = false;
            object4 = null;
            this.triggerAf(null);
        } else {
            this.mIsInAfAutoMode = false;
            this.mIsAutoFocusCompleted = bl3;
            this.mIsFocusSuccessful = false;
            object4 = this.mCameraControl;
            ((Camera2CameraControlImpl)object4).updateSessionConfigSynchronous();
        }
        this.mCurrentAfState = object4 = Integer.valueOf(0);
        boolean bl4 = this.isAfModeSupported();
        object5 = object4;
        this.mSessionListenerForFocus = object4 = new s0(this, bl4, (MeteringRectangle[])object, (MeteringRectangle[])object2, (MeteringRectangle[])object3);
        object = this.mCameraControl;
        ((Camera2CameraControlImpl)object).addCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object4);
        boolean bl5 = focusMeteringAction.isAutoCancelEnabled();
        if (bl5) {
            long l10;
            this.mFocusTimeoutCounter = l10 = this.mFocusTimeoutCounter + 1L;
            object3 = new p0(this, l10);
            object = this.mScheduler;
            long l11 = focusMeteringAction.getAutoCancelDurationInMillis();
            object2 = TimeUnit.MILLISECONDS;
            this.mAutoCancelHandle = object = object.schedule((Runnable)object3, l11, (TimeUnit)((Object)object2));
        }
    }

    private void failActionFuture(String string2) {
        Object object = this.mCameraControl;
        Object object2 = this.mSessionListenerForFocus;
        ((Camera2CameraControlImpl)object).removeCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object2);
        object = this.mRunningActionCompleter;
        if (object != null) {
            object2 = new CameraControl$OperationCanceledException(string2);
            ((CallbackToFutureAdapter$Completer)object).setException((Throwable)object2);
            string2 = null;
            this.mRunningActionCompleter = null;
        }
    }

    private void failCancelFuture(String string2) {
        Object object = this.mCameraControl;
        Object object2 = this.mSessionListenerForCancel;
        ((Camera2CameraControlImpl)object).removeCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object2);
        object = this.mRunningCancelCompleter;
        if (object != null) {
            object2 = new CameraControl$OperationCanceledException(string2);
            ((CallbackToFutureAdapter$Completer)object).setException((Throwable)object2);
            string2 = null;
            this.mRunningCancelCompleter = null;
        }
    }

    private /* synthetic */ boolean g(boolean n10, MeteringRectangle[] key, MeteringRectangle[] meteringRectangleArray, MeteringRectangle[] meteringRectangleArray2, TotalCaptureResult meteringRectangleArray3) {
        MeteringRectangle[] meteringRectangleArray4;
        Object object = CaptureResult.CONTROL_AF_STATE;
        object = (Integer)meteringRectangleArray3.get((CaptureResult.Key)object);
        int n11 = this.shouldTriggerAF();
        boolean bl2 = true;
        if (n11 != 0) {
            if (n10 != 0 && object != null) {
                meteringRectangleArray4 = this.mCurrentAfState;
                n10 = meteringRectangleArray4.intValue();
                if (n10 == (n11 = 3)) {
                    n10 = (Integer)object;
                    if (n10 == (n11 = 4)) {
                        this.mIsFocusSuccessful = bl2;
                        this.mIsAutoFocusCompleted = bl2;
                    } else {
                        n10 = (Integer)object;
                        if (n10 == (n11 = 5)) {
                            this.mIsFocusSuccessful = false;
                            this.mIsAutoFocusCompleted = bl2;
                        }
                    }
                }
            } else {
                this.mIsFocusSuccessful = bl2;
                this.mIsAutoFocusCompleted = bl2;
            }
        }
        if ((n10 = this.mIsAutoFocusCompleted) != 0 && (meteringRectangleArray4 = meteringRectangleArray3.getRequest()) != null) {
            n10 = ((MeteringRectangle[])key).length;
            if (n10 == 0) {
                key = this.mDefaultAfRects;
            }
            n10 = meteringRectangleArray.length;
            if (n10 == 0) {
                meteringRectangleArray = this.mDefaultAeRects;
            }
            n10 = meteringRectangleArray2.length;
            if (n10 == 0) {
                meteringRectangleArray2 = this.mDefaultAwbRects;
            }
            meteringRectangleArray4 = meteringRectangleArray3.getRequest();
            meteringRectangleArray3 = CaptureRequest.CONTROL_AF_REGIONS;
            meteringRectangleArray3 = (MeteringRectangle[])meteringRectangleArray4.get((CaptureRequest.Key)meteringRectangleArray3);
            boolean bl3 = FocusMeteringControl.hasEqualRegions(meteringRectangleArray3, (MeteringRectangle[])key);
            if (bl3) {
                key = CaptureRequest.CONTROL_AE_REGIONS;
                bl3 = FocusMeteringControl.hasEqualRegions((MeteringRectangle[])(key = (CaptureRequest.Key)meteringRectangleArray4.get(key)), meteringRectangleArray);
                if (bl3 && (n10 = (int)(FocusMeteringControl.hasEqualRegions(meteringRectangleArray4 = (MeteringRectangle[])meteringRectangleArray4.get(key = CaptureRequest.CONTROL_AWB_REGIONS), meteringRectangleArray2) ? 1 : 0)) != 0) {
                    n10 = this.mIsFocusSuccessful ? 1 : 0;
                    this.completeActionFuture(n10 != 0);
                    return bl2;
                }
            }
        }
        if ((n10 = (meteringRectangleArray4 = this.mCurrentAfState).equals(object)) == 0 && object != null) {
            this.mCurrentAfState = object;
        }
        return false;
    }

    private int getDefaultTemplate() {
        return 1;
    }

    private static PointF getFovAdjustedPoint(MeteringPoint meteringPoint, Rational rational, Rational rational2) {
        Rational rational3 = meteringPoint.getSurfaceAspectRatio();
        if (rational3 != null) {
            rational2 = meteringPoint.getSurfaceAspectRatio();
        }
        float f10 = meteringPoint.getX();
        float f11 = meteringPoint.getY();
        rational3 = new PointF(f10, f11);
        int n10 = rational2.equals((Object)rational);
        if (n10 == 0) {
            n10 = rational2.compareTo(rational);
            f10 = 1.0f;
            double d10 = 2.0;
            double d11 = 1.0;
            if (n10 > 0) {
                double d12 = rational2.doubleValue();
                double d13 = rational.doubleValue();
                f11 = (float)(d12 /= d13);
                double d14 = ((double)f11 - d11) / d10;
                float f12 = (float)d14;
                float f13 = rational3.y;
                f12 += f13;
                rational3.y = f12 *= (f10 /= f11);
            } else {
                double d15 = rational.doubleValue();
                double d16 = rational2.doubleValue();
                f11 = (float)(d15 /= d16);
                double d17 = ((double)f11 - d11) / d10;
                float f14 = (float)d17;
                float f15 = rational3.x;
                f14 += f15;
                rational3.x = f14 *= (f10 /= f11);
            }
        }
        return rational3;
    }

    private static MeteringRectangle getMeteringRect(MeteringPoint meteringPoint, PointF pointF, Rect rect) {
        float f10 = rect.left;
        float f11 = pointF.x;
        float f12 = rect.width();
        int n10 = (int)(f10 + (f11 *= f12));
        f11 = rect.top;
        float f13 = pointF.y;
        f12 = rect.height();
        int n11 = (int)(f11 + (f13 *= f12));
        f11 = meteringPoint.getSize();
        f12 = rect.width();
        int n12 = (int)(f11 * f12);
        float f14 = meteringPoint.getSize();
        f12 = rect.height();
        int n13 = (int)(f14 * f12);
        int n14 = n10 - (n12 /= 2);
        int n15 = n11 - (n13 /= 2);
        Rect rect2 = new Rect(n14, n15, n10 += n12, n11 += n13);
        n13 = rect2.left;
        n11 = rect.right;
        n10 = rect.left;
        rect2.left = n13 = FocusMeteringControl.rangeLimit(n13, n11, n10);
        n13 = rect2.right;
        n11 = rect.right;
        n10 = rect.left;
        rect2.right = n13 = FocusMeteringControl.rangeLimit(n13, n11, n10);
        n13 = rect2.top;
        n11 = rect.bottom;
        n10 = rect.top;
        rect2.top = n13 = FocusMeteringControl.rangeLimit(n13, n11, n10);
        n13 = rect2.bottom;
        n11 = rect.bottom;
        int n16 = rect.top;
        rect2.bottom = n13 = FocusMeteringControl.rangeLimit(n13, n11, n16);
        meteringPoint = new MeteringRectangle(rect2, 1000);
        return meteringPoint;
    }

    private static int getRegionCount(MeteringRectangle[] meteringRectangleArray) {
        if (meteringRectangleArray == null) {
            return 0;
        }
        return meteringRectangleArray.length;
    }

    private static boolean hasEqualRegions(MeteringRectangle[] meteringRectangleArray, MeteringRectangle[] meteringRectangleArray2) {
        int n10;
        int n11 = FocusMeteringControl.getRegionCount(meteringRectangleArray);
        boolean bl2 = true;
        if (n11 == 0 && (n11 = FocusMeteringControl.getRegionCount(meteringRectangleArray2)) == 0) {
            return bl2;
        }
        n11 = FocusMeteringControl.getRegionCount(meteringRectangleArray);
        if (n11 != (n10 = FocusMeteringControl.getRegionCount(meteringRectangleArray2))) {
            return false;
        }
        if (meteringRectangleArray != null && meteringRectangleArray2 != null) {
            for (n11 = 0; n11 < (n10 = meteringRectangleArray.length); ++n11) {
                MeteringRectangle meteringRectangle = meteringRectangleArray[n11];
                MeteringRectangle meteringRectangle2 = meteringRectangleArray2[n11];
                n10 = meteringRectangle.equals(meteringRectangle2) ? 1 : 0;
                if (n10 != 0) continue;
                return false;
            }
        }
        return bl2;
    }

    private /* synthetic */ void i(long l10) {
        long l11 = this.mFocusTimeoutCounter;
        long l12 = l10 - l11;
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l13 == false) {
            this.cancelFocusAndMeteringWithoutAsyncResult();
        }
    }

    private boolean isAfModeSupported() {
        Camera2CameraControlImpl camera2CameraControlImpl = this.mCameraControl;
        int n10 = 1;
        int n11 = camera2CameraControlImpl.getSupportedAfMode(n10);
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private static boolean isValid(MeteringPoint meteringPoint) {
        float f10;
        float f11;
        int n10;
        float f12;
        float f13;
        float f14;
        float f15 = meteringPoint.getX();
        float f16 = f15 - 0.0f;
        float f17 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (f17 >= 0 && (f17 = (f14 = (f15 = meteringPoint.getX()) - (f13 = 1.0f)) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1)) <= 0 && (f17 = (f12 = (f15 = meteringPoint.getY()) - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) >= 0 && (n10 = (f11 = (f10 = meteringPoint.getY()) - f13) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
            meteringPoint = null;
        }
        return n10 != 0;
    }

    private /* synthetic */ void k(long l10) {
        Executor executor = this.mExecutor;
        o0 o02 = new o0(this, l10);
        executor.execute(o02);
    }

    private /* synthetic */ void m(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, FocusMeteringAction focusMeteringAction, Rational rational) {
        this.startFocusAndMeteringInternal(callbackToFutureAdapter$Completer, focusMeteringAction, rational);
    }

    private /* synthetic */ Object o(FocusMeteringAction focusMeteringAction, Rational rational, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        v0 v02 = new v0(this, callbackToFutureAdapter$Completer, focusMeteringAction, rational);
        executor.execute(v02);
        return "startFocusAndMetering";
    }

    private static int rangeLimit(int n10, int n11, int n12) {
        return Math.min(Math.max(n10, n12), n11);
    }

    private boolean shouldTriggerAF() {
        MeteringRectangle[] meteringRectangleArray = this.mAfRects;
        boolean bl2 = meteringRectangleArray.length;
        if (bl2 > false) {
            bl2 = true;
        } else {
            bl2 = false;
            meteringRectangleArray = null;
        }
        return bl2;
    }

    public void addFocusMeteringOptions(Camera2ImplConfig$Builder camera2ImplConfig$Builder) {
        int n10 = this.mIsInAfAutoMode;
        n10 = n10 != 0 ? 1 : 4;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
        Camera2CameraControlImpl camera2CameraControlImpl = this.mCameraControl;
        n10 = camera2CameraControlImpl.getSupportedAfMode(n10);
        MeteringRectangle[] meteringRectangleArray = Integer.valueOf(n10);
        camera2ImplConfig$Builder.setCaptureRequestOption(key, meteringRectangleArray);
        meteringRectangleArray = this.mAfRects;
        int n11 = meteringRectangleArray.length;
        if (n11 != 0) {
            key = CaptureRequest.CONTROL_AF_REGIONS;
            camera2ImplConfig$Builder.setCaptureRequestOption(key, meteringRectangleArray);
        }
        if ((n11 = (meteringRectangleArray = this.mAeRects).length) != 0) {
            key = CaptureRequest.CONTROL_AE_REGIONS;
            camera2ImplConfig$Builder.setCaptureRequestOption(key, meteringRectangleArray);
        }
        if ((n11 = (meteringRectangleArray = this.mAwbRects).length) != 0) {
            key = CaptureRequest.CONTROL_AWB_REGIONS;
            camera2ImplConfig$Builder.setCaptureRequestOption(key, meteringRectangleArray);
        }
    }

    public /* synthetic */ void b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a(callbackToFutureAdapter$Completer);
    }

    public void cancelAfAeTrigger(boolean n10, boolean bl2) {
        Object object;
        int n11;
        Object object2;
        boolean bl3 = this.mIsActive;
        if (!bl3) {
            return;
        }
        CaptureConfig$Builder captureConfig$Builder = new CaptureConfig$Builder();
        captureConfig$Builder.setUseRepeatingSurface(true);
        int n12 = this.getDefaultTemplate();
        captureConfig$Builder.setTemplateType(n12);
        Camera2ImplConfig$Builder camera2ImplConfig$Builder = new Camera2ImplConfig$Builder();
        int n13 = 2;
        if (n10 != 0) {
            object2 = CaptureRequest.CONTROL_AF_TRIGGER;
            Integer n14 = n13;
            camera2ImplConfig$Builder.setCaptureRequestOption((CaptureRequest.Key)object2, n14);
        }
        if ((n10 = Build.VERSION.SDK_INT) >= (n11 = 23) && bl2) {
            object2 = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
            object = n13;
            camera2ImplConfig$Builder.setCaptureRequestOption((CaptureRequest.Key)object2, object);
        }
        object2 = camera2ImplConfig$Builder.build();
        captureConfig$Builder.addImplementationOptions((Config)object2);
        object2 = this.mCameraControl;
        object = Collections.singletonList(captureConfig$Builder.build());
        ((Camera2CameraControlImpl)object2).submitCaptureRequestsInternal((List)object);
    }

    public ListenableFuture cancelFocusAndMetering() {
        q0 q02 = new q0(this);
        return CallbackToFutureAdapter.getFuture(q02);
    }

    public void cancelFocusAndMeteringInternal(CallbackToFutureAdapter$Completer object) {
        int n10;
        this.failCancelFuture("Cancelled by another cancelFocusAndMetering()");
        Object object2 = "Cancelled by cancelFocusAndMetering()";
        this.failActionFuture((String)object2);
        this.mRunningCancelCompleter = object;
        this.disableAutoCancel();
        object = this.mRunningCancelCompleter;
        if (object != null) {
            object = this.mCameraControl;
            n10 = 4;
            int bl2 = ((Camera2CameraControlImpl)object).getSupportedAfMode(n10);
            this.mSessionListenerForCancel = object2 = new t0(this, bl2);
            object = this.mCameraControl;
            ((Camera2CameraControlImpl)object).addCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object2);
        }
        boolean bl2 = this.shouldTriggerAF();
        n10 = 0;
        object2 = null;
        if (bl2) {
            boolean bl3 = true;
            this.cancelAfAeTrigger(bl3, false);
        }
        object = new MeteringRectangle[]{};
        this.mAfRects = object;
        object = new MeteringRectangle[]{};
        this.mAeRects = object;
        object = new MeteringRectangle[]{};
        this.mAwbRects = object;
        this.mIsInAfAutoMode = false;
        this.mCameraControl.updateSessionConfigSynchronous();
    }

    public void cancelFocusAndMeteringWithoutAsyncResult() {
        this.cancelFocusAndMeteringInternal(null);
    }

    public /* synthetic */ Object d(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.c(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ boolean f(int n10, TotalCaptureResult totalCaptureResult) {
        return this.e(n10, totalCaptureResult);
    }

    public /* synthetic */ boolean h(boolean bl2, MeteringRectangle[] meteringRectangleArray, MeteringRectangle[] meteringRectangleArray2, MeteringRectangle[] meteringRectangleArray3, TotalCaptureResult totalCaptureResult) {
        return this.g(bl2, meteringRectangleArray, meteringRectangleArray2, meteringRectangleArray3, totalCaptureResult);
    }

    public /* synthetic */ void j(long l10) {
        this.i(l10);
    }

    public /* synthetic */ void l(long l10) {
        this.k(l10);
    }

    public /* synthetic */ void n(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, FocusMeteringAction focusMeteringAction, Rational rational) {
        this.m(callbackToFutureAdapter$Completer, focusMeteringAction, rational);
    }

    public /* synthetic */ Object p(FocusMeteringAction focusMeteringAction, Rational rational, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.o(focusMeteringAction, rational, callbackToFutureAdapter$Completer);
    }

    public void setActive(boolean bl2) {
        boolean bl3 = this.mIsActive;
        if (bl2 == bl3) {
            return;
        }
        this.mIsActive = bl2;
        if (!(bl2 = this.mIsActive)) {
            this.cancelFocusAndMeteringWithoutAsyncResult();
        }
    }

    public void setDefaultRequestBuilder(CaptureRequest.Builder meteringRectangleArray) {
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
        key = (CaptureRequest.Key)meteringRectangleArray.get(key);
        this.mDefaultAfRects = key;
        key = CaptureRequest.CONTROL_AE_REGIONS;
        key = (CaptureRequest.Key)meteringRectangleArray.get(key);
        this.mDefaultAeRects = key;
        key = CaptureRequest.CONTROL_AWB_REGIONS;
        meteringRectangleArray = (MeteringRectangle[])meteringRectangleArray.get(key);
        this.mDefaultAwbRects = meteringRectangleArray;
    }

    public ListenableFuture startFocusAndMetering(FocusMeteringAction focusMeteringAction, Rational rational) {
        u0 u02 = new u0(this, focusMeteringAction, rational);
        return CallbackToFutureAdapter.getFuture(u02);
    }

    public void startFocusAndMeteringInternal(CallbackToFutureAdapter$Completer meteringRectangleArray, FocusMeteringAction object, Rational meteringRectangleArray2) {
        boolean bl2;
        MeteringPoint meteringPoint;
        int n10;
        ArrayList<Object> arrayList;
        int n11 = this.mIsActive;
        if (n11 == 0) {
            object = new CameraControl$OperationCanceledException("Camera is not active.");
            meteringRectangleArray.setException((Throwable)object);
            return;
        }
        Rect rect = ((FocusMeteringAction)object).getMeteringPointsAf();
        n11 = rect.isEmpty();
        if (n11 != 0 && (n11 = (rect = ((FocusMeteringAction)object).getMeteringPointsAe()).isEmpty()) != 0 && (n11 = (int)((rect = ((FocusMeteringAction)object).getMeteringPointsAwb()).isEmpty() ? 1 : 0)) != 0) {
            object = new IllegalArgumentException("No AF/AE/AWB MeteringPoints are added.");
            meteringRectangleArray.setException((Throwable)object);
            return;
        }
        rect = ((FocusMeteringAction)object).getMeteringPointsAf();
        n11 = rect.size();
        int n12 = this.mCameraControl.getMaxAfRegionCount();
        n11 = Math.min(n11, n12);
        List list = ((FocusMeteringAction)object).getMeteringPointsAe();
        n12 = list.size();
        int n13 = this.mCameraControl.getMaxAeRegionCount();
        n12 = Math.min(n12, n13);
        ArrayList<MeteringPoint> arrayList2 = ((FocusMeteringAction)object).getMeteringPointsAwb();
        n13 = arrayList2.size();
        Iterator iterator2 = this.mCameraControl;
        int n14 = ((Camera2CameraControlImpl)((Object)iterator2)).getMaxAwbRegionCount();
        if ((n14 = n11 + n12 + (n13 = Math.min(n13, n14))) <= 0) {
            object = new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera.");
            meteringRectangleArray.setException((Throwable)object);
            return;
        }
        iterator2 = new Iterator();
        Object object2 = new ArrayList();
        PointF pointF = new ArrayList();
        if (n11 > 0) {
            arrayList = ((FocusMeteringAction)object).getMeteringPointsAf();
            rect = arrayList.subList(0, n11);
            iterator2.addAll(rect);
        }
        if (n12 > 0) {
            rect = ((FocusMeteringAction)object).getMeteringPointsAe().subList(0, n12);
            object2.addAll(rect);
        }
        if (n13 > 0) {
            rect = ((FocusMeteringAction)object).getMeteringPointsAwb().subList(0, n13);
            pointF.addAll(rect);
        }
        rect = this.mCameraControl.getCropSensorRegion();
        n13 = rect.width();
        int n15 = rect.height();
        list = new Rational(n13, n15);
        if (meteringRectangleArray2 == null) {
            meteringRectangleArray2 = list;
        }
        arrayList2 = new ArrayList<MeteringPoint>();
        arrayList = new ArrayList<Object>();
        ArrayList<Object> arrayList3 = new ArrayList<Object>();
        iterator2 = iterator2.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            PointF pointF2;
            meteringPoint = (MeteringPoint)iterator2.next();
            int n16 = FocusMeteringControl.isValid(meteringPoint);
            if (n16 == 0 || (n16 = (meteringPoint = FocusMeteringControl.getMeteringRect(meteringPoint, pointF2 = FocusMeteringControl.getFovAdjustedPoint(meteringPoint, (Rational)list, (Rational)meteringRectangleArray2), rect)).getWidth()) == 0 || (n16 = meteringPoint.getHeight()) == 0) continue;
            arrayList2.add(meteringPoint);
        }
        iterator2 = object2.iterator();
        while (bl2 = iterator2.hasNext()) {
            object2 = (MeteringPoint)iterator2.next();
            n10 = FocusMeteringControl.isValid((MeteringPoint)object2);
            if (n10 == 0 || (n10 = (object2 = FocusMeteringControl.getMeteringRect((MeteringPoint)object2, (PointF)(meteringPoint = FocusMeteringControl.getFovAdjustedPoint((MeteringPoint)object2, (Rational)list, (Rational)meteringRectangleArray2)), rect)).getWidth()) == 0 || (n10 = object2.getHeight()) == 0) continue;
            arrayList.add(object2);
        }
        iterator2 = pointF.iterator();
        while (bl2 = iterator2.hasNext()) {
            object2 = (MeteringPoint)iterator2.next();
            int n17 = FocusMeteringControl.isValid((MeteringPoint)object2);
            if (n17 == 0 || (n17 = (object2 = FocusMeteringControl.getMeteringRect((MeteringPoint)object2, pointF = FocusMeteringControl.getFovAdjustedPoint((MeteringPoint)object2, (Rational)list, (Rational)meteringRectangleArray2), rect)).getWidth()) == 0 || (n17 = object2.getHeight()) == 0) continue;
            arrayList3.add(object2);
        }
        boolean bl3 = arrayList2.isEmpty();
        if (bl3 && (bl3 = arrayList.isEmpty()) && (bl3 = arrayList3.isEmpty())) {
            object = new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints are valid.");
            meteringRectangleArray.setException((Throwable)object);
            return;
        }
        meteringRectangleArray2 = "Cancelled by another startFocusAndMetering()";
        this.failActionFuture((String)meteringRectangleArray2);
        this.failCancelFuture((String)meteringRectangleArray2);
        this.disableAutoCancel();
        this.mRunningActionCompleter = meteringRectangleArray;
        meteringRectangleArray = new MeteringRectangle[]{};
        meteringRectangleArray = arrayList2.toArray(meteringRectangleArray);
        meteringRectangleArray2 = new MeteringRectangle[]{};
        meteringRectangleArray2 = arrayList.toArray(meteringRectangleArray2);
        rect = new MeteringRectangle[]{};
        rect = arrayList3.toArray((T[])rect);
        this.executeMeteringAction(meteringRectangleArray, meteringRectangleArray2, (MeteringRectangle[])rect, (FocusMeteringAction)object);
    }

    public void triggerAePrecapture(CallbackToFutureAdapter$Completer object) {
        boolean bl2 = this.mIsActive;
        if (!bl2) {
            if (object != null) {
                String string2 = "Camera is not active.";
                CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException(string2);
                ((CallbackToFutureAdapter$Completer)object).setException(cameraControl$OperationCanceledException);
            }
            return;
        }
        Object object2 = new CaptureConfig$Builder();
        int n10 = this.getDefaultTemplate();
        ((CaptureConfig$Builder)object2).setTemplateType(n10);
        n10 = 1;
        ((CaptureConfig$Builder)object2).setUseRepeatingSurface(n10 != 0);
        Camera2ImplConfig$Builder camera2ImplConfig$Builder = new Camera2ImplConfig$Builder();
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
        Object object3 = n10;
        camera2ImplConfig$Builder.setCaptureRequestOption(key, object3);
        object3 = camera2ImplConfig$Builder.build();
        ((CaptureConfig$Builder)object2).addImplementationOptions((Config)object3);
        object3 = new FocusMeteringControl$2(this, (CallbackToFutureAdapter$Completer)object);
        ((CaptureConfig$Builder)object2).addCameraCaptureCallback((CameraCaptureCallback)object3);
        object = this.mCameraControl;
        object2 = Collections.singletonList(((CaptureConfig$Builder)object2).build());
        ((Camera2CameraControlImpl)object).submitCaptureRequestsInternal((List)object2);
    }

    public void triggerAf(CallbackToFutureAdapter$Completer object) {
        boolean bl2 = this.mIsActive;
        if (!bl2) {
            if (object != null) {
                String string2 = "Camera is not active.";
                CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException(string2);
                ((CallbackToFutureAdapter$Completer)object).setException(cameraControl$OperationCanceledException);
            }
            return;
        }
        Object object2 = new CaptureConfig$Builder();
        int n10 = this.getDefaultTemplate();
        ((CaptureConfig$Builder)object2).setTemplateType(n10);
        n10 = 1;
        ((CaptureConfig$Builder)object2).setUseRepeatingSurface(n10 != 0);
        Camera2ImplConfig$Builder camera2ImplConfig$Builder = new Camera2ImplConfig$Builder();
        CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
        Object object3 = n10;
        camera2ImplConfig$Builder.setCaptureRequestOption(key, object3);
        object3 = camera2ImplConfig$Builder.build();
        ((CaptureConfig$Builder)object2).addImplementationOptions((Config)object3);
        object3 = new FocusMeteringControl$1(this, (CallbackToFutureAdapter$Completer)object);
        ((CaptureConfig$Builder)object2).addCameraCaptureCallback((CameraCaptureCallback)object3);
        object = this.mCameraControl;
        object2 = Collections.singletonList(((CaptureConfig$Builder)object2).build());
        ((Camera2CameraControlImpl)object).submitCaptureRequestsInternal((List)object2);
    }
}

