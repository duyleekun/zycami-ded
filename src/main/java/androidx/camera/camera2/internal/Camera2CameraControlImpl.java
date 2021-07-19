/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.hardware.camera2.CaptureRequest$Key
 *  android.util.Rational
 */
package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CameraCaptureCallbackSet;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CameraControlSessionCallback;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.CaptureCallbackContainer;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.camera.camera2.internal.FocusMeteringControl;
import androidx.camera.camera2.internal.TorchControl;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.AeFpsRange;
import androidx.camera.camera2.internal.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraControlInternal$ControlUpdateCallback;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionPriority;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;
import b.a.a.d.a;
import b.a.a.d.b;
import b.a.a.d.g;
import b.a.a.d.h;
import b.a.a.d.i;
import b.a.a.d.j;
import b.a.a.d.k;
import b.a.a.d.l;
import b.a.a.d.m;
import b.a.a.d.n;
import b.a.a.d.o;
import b.a.a.d.y0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public class Camera2CameraControlImpl
implements CameraControlInternal {
    private static final String TAG = "Camera2CameraControlImp";
    private final AeFpsRange mAeFpsRange;
    private final AutoFlashAEModeDisabler mAutoFlashAEModeDisabler;
    private final Camera2CameraControl mCamera2CameraControl;
    private final Camera2CameraControlImpl$CameraCaptureCallbackSet mCameraCaptureCallbackSet;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private final CameraControlInternal$ControlUpdateCallback mControlUpdateCallback;
    public final Executor mExecutor;
    private final ExposureControl mExposureControl;
    private volatile int mFlashMode;
    private final FocusMeteringControl mFocusMeteringControl;
    private volatile boolean mIsTorchOn;
    private final Object mLock;
    public volatile Rational mPreviewAspectRatio;
    public final Camera2CameraControlImpl$CameraControlSessionCallback mSessionCallback;
    private final SessionConfig$Builder mSessionConfigBuilder;
    private final TorchControl mTorchControl;
    private int mUseCount;
    private final ZoomControl mZoomControl;

    public Camera2CameraControlImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, ScheduledExecutorService scheduledExecutorService, Executor executor, CameraControlInternal$ControlUpdateCallback cameraControlInternal$ControlUpdateCallback) {
        Object object = new ArrayList();
        Quirks quirks = new Quirks((List)object);
        object = this;
        this(cameraCharacteristicsCompat, scheduledExecutorService, executor, cameraControlInternal$ControlUpdateCallback, quirks);
    }

    public Camera2CameraControlImpl(CameraCharacteristicsCompat object, ScheduledExecutorService object2, Executor executor, CameraControlInternal$ControlUpdateCallback object3, Quirks quirks) {
        Object object4;
        this.mLock = object4 = new Object();
        this.mSessionConfigBuilder = object4 = new SessionConfig$Builder();
        this.mPreviewAspectRatio = null;
        this.mUseCount = 0;
        this.mIsTorchOn = false;
        this.mFlashMode = 2;
        Object object5 = new AutoFlashAEModeDisabler();
        this.mAutoFlashAEModeDisabler = object5;
        this.mCameraCaptureCallbackSet = object5 = new Camera2CameraControlImpl$CameraCaptureCallbackSet();
        this.mCameraCharacteristics = object;
        this.mControlUpdateCallback = object3;
        this.mExecutor = executor;
        super(executor);
        this.mSessionCallback = object3;
        int n10 = this.getDefaultTemplate();
        ((SessionConfig$Builder)object4).setTemplateType(n10);
        object3 = CaptureCallbackContainer.create((CameraCaptureSession.CaptureCallback)object3);
        ((SessionConfig$Builder)object4).addRepeatingCameraCaptureCallback((CameraCaptureCallback)object3);
        ((SessionConfig$Builder)object4).addRepeatingCameraCaptureCallback((CameraCaptureCallback)object5);
        super(this, (CameraCharacteristicsCompat)object, executor);
        this.mExposureControl = object3;
        super(this, (ScheduledExecutorService)object2, executor);
        this.mFocusMeteringControl = object3;
        this.mZoomControl = object2 = new ZoomControl(this, (CameraCharacteristicsCompat)object, executor);
        this.mTorchControl = object2 = new TorchControl(this, (CameraCharacteristicsCompat)object, executor);
        this.mAeFpsRange = object = new AeFpsRange(quirks);
        this.mCamera2CameraControl = object = new Camera2CameraControl(this, executor);
        object = new g(this);
        executor.execute((Runnable)object);
        this.updateSessionConfig();
    }

    public static /* synthetic */ void a() {
    }

    private /* synthetic */ void b(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraCaptureCallbackSet.addCaptureCallback(executor, cameraCaptureCallback);
    }

    private /* synthetic */ void d(boolean bl2, boolean bl3) {
        this.mFocusMeteringControl.cancelAfAeTrigger(bl2, bl3);
    }

    public static /* synthetic */ void f() {
    }

    private /* synthetic */ void g() {
        Camera2CameraControlImpl$CaptureResultListener camera2CameraControlImpl$CaptureResultListener = this.mCamera2CameraControl.getCaptureRequestListener();
        this.addCaptureResultListener(camera2CameraControlImpl$CaptureResultListener);
    }

    private int getSupportedAeMode(int n10) {
        Object object = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES;
        object = (int[])((CameraCharacteristicsCompat)object).get(key);
        key = null;
        if (object == null) {
            return 0;
        }
        boolean bl2 = this.isModeInList(n10, (int[])object);
        if (bl2) {
            return n10;
        }
        n10 = 1;
        boolean bl3 = this.isModeInList(n10, (int[])object);
        if (bl3) {
            return n10;
        }
        return 0;
    }

    private int getSupportedAwbMode(int n10) {
        Object object = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES;
        object = (int[])((CameraCharacteristicsCompat)object).get(key);
        key = null;
        if (object == null) {
            return 0;
        }
        boolean bl2 = this.isModeInList(n10, (int[])object);
        if (bl2) {
            return n10;
        }
        n10 = 1;
        boolean bl3 = this.isModeInList(n10, (int[])object);
        if (bl3) {
            return n10;
        }
        return 0;
    }

    private /* synthetic */ void i(CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraCaptureCallbackSet.removeCaptureCallback(cameraCaptureCallback);
    }

    private boolean isControlInUse() {
        int n10 = this.getUseCount();
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    private boolean isModeInList(int n10, int[] nArray) {
        for (int n11 : nArray) {
            if (n10 != n11) continue;
            return true;
        }
        return false;
    }

    private /* synthetic */ void k(List list) {
        this.submitCaptureRequestsInternal(list);
    }

    private /* synthetic */ void m(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.mFocusMeteringControl.triggerAePrecapture(callbackToFutureAdapter$Completer);
    }

    private /* synthetic */ Object o(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        m m10 = new m(this, callbackToFutureAdapter$Completer);
        executor.execute(m10);
        return "triggerAePrecapture";
    }

    private /* synthetic */ void q(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.mFocusMeteringControl.triggerAf(callbackToFutureAdapter$Completer);
    }

    private /* synthetic */ Object s(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        l l10 = new l(this, callbackToFutureAdapter$Completer);
        executor.execute(l10);
        return "triggerAf";
    }

    public void addCaptureResultListener(Camera2CameraControlImpl$CaptureResultListener camera2CameraControlImpl$CaptureResultListener) {
        this.mSessionCallback.addListener(camera2CameraControlImpl$CaptureResultListener);
    }

    public void addInteropConfig(Config object) {
        Object object2 = this.mCamera2CameraControl;
        object = CaptureRequestOptions$Builder.from((Config)object).build();
        object = ((Camera2CameraControl)object2).addCaptureRequestOptions((CaptureRequestOptions)object);
        object2 = j.a;
        Executor executor = CameraXExecutors.directExecutor();
        object.addListener((Runnable)object2, executor);
    }

    public void addSessionCameraCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        Executor executor2 = this.mExecutor;
        h h10 = new h(this, executor, cameraCaptureCallback);
        executor2.execute(h10);
    }

    public /* synthetic */ void c(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.b(executor, cameraCaptureCallback);
    }

    public void cancelAfAeTrigger(boolean bl2, boolean bl3) {
        boolean bl4 = this.isControlInUse();
        if (!bl4) {
            Logger.w(TAG, "Camera is not active.");
            return;
        }
        Executor executor = this.mExecutor;
        k k10 = new k(this, bl2, bl3);
        executor.execute(k10);
    }

    public ListenableFuture cancelFocusAndMetering() {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture(cameraControl$OperationCanceledException);
        }
        return Futures.nonCancellationPropagating(this.mFocusMeteringControl.cancelFocusAndMetering());
    }

    public void clearInteropConfig() {
        ListenableFuture listenableFuture = this.mCamera2CameraControl.clearCaptureRequestOptions();
        i i10 = i.a;
        Executor executor = CameraXExecutors.directExecutor();
        listenableFuture.addListener(i10, executor);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void decrementUseCount() {
        Object object = this.mLock;
        synchronized (object) {
            int n10 = this.mUseCount;
            if (n10 != 0) {
                this.mUseCount = n10 += -1;
                return;
            }
            String string2 = "Decrementing use count occurs more times than incrementing";
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
    }

    public /* synthetic */ void e(boolean bl2, boolean bl3) {
        this.d(bl2, bl3);
    }

    public ListenableFuture enableTorch(boolean bl2) {
        boolean bl3 = this.isControlInUse();
        if (!bl3) {
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture(cameraControl$OperationCanceledException);
        }
        return Futures.nonCancellationPropagating(this.mTorchControl.enableTorch(bl2));
    }

    public void enableTorchInternal(boolean bl2) {
        this.mIsTorchOn = bl2;
        if (!bl2) {
            Object object = new CaptureConfig$Builder();
            int n10 = this.getDefaultTemplate();
            ((CaptureConfig$Builder)object).setTemplateType(n10);
            n10 = 1;
            ((CaptureConfig$Builder)object).setUseRepeatingSurface(n10 != 0);
            Camera2ImplConfig$Builder camera2ImplConfig$Builder = new Camera2ImplConfig$Builder();
            Object object2 = CaptureRequest.CONTROL_AE_MODE;
            n10 = this.getSupportedAeMode(n10);
            Object object3 = n10;
            camera2ImplConfig$Builder.setCaptureRequestOption((CaptureRequest.Key)object2, object3);
            object3 = CaptureRequest.FLASH_MODE;
            object2 = 0;
            camera2ImplConfig$Builder.setCaptureRequestOption((CaptureRequest.Key)object3, object2);
            object3 = camera2ImplConfig$Builder.build();
            ((CaptureConfig$Builder)object).addImplementationOptions((Config)object3);
            object = Collections.singletonList(((CaptureConfig$Builder)object).build());
            this.submitCaptureRequestsInternal((List)object);
        }
        this.updateSessionConfigSynchronous();
    }

    public Camera2CameraControl getCamera2CameraControl() {
        return this.mCamera2CameraControl;
    }

    public Rect getCropSensorRegion() {
        return this.mZoomControl.getCropSensorRegion();
    }

    public int getDefaultTemplate() {
        return 1;
    }

    public ExposureControl getExposureControl() {
        return this.mExposureControl;
    }

    public int getFlashMode() {
        return this.mFlashMode;
    }

    public Config getInteropConfig() {
        return this.mCamera2CameraControl.getCamera2ImplConfig();
    }

    public int getMaxAeRegionCount() {
        int n10;
        Object object = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_MAX_REGIONS_AE;
        if ((object = (Integer)((CameraCharacteristicsCompat)object).get(key)) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = (Integer)object;
        }
        return n10;
    }

    public int getMaxAfRegionCount() {
        int n10;
        Object object = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_MAX_REGIONS_AF;
        if ((object = (Integer)((CameraCharacteristicsCompat)object).get(key)) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = (Integer)object;
        }
        return n10;
    }

    public int getMaxAwbRegionCount() {
        int n10;
        Object object = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_MAX_REGIONS_AWB;
        if ((object = (Integer)((CameraCharacteristicsCompat)object).get(key)) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = (Integer)object;
        }
        return n10;
    }

    public Rect getSensorRect() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        return (Rect)Preconditions.checkNotNull((Rect)cameraCharacteristicsCompat.get(key));
    }

    /*
     * Unable to fully structure code
     */
    public Config getSessionOptions() {
        block6: {
            block5: {
                block4: {
                    var1_1 = new Camera2ImplConfig$Builder();
                    var2_2 = CaptureRequest.CONTROL_MODE;
                    var3_3 = 1;
                    var4_4 = var3_3;
                    var1_1.setCaptureRequestOption((CaptureRequest.Key)var2_2, var4_4);
                    this.mFocusMeteringControl.addFocusMeteringOptions(var1_1);
                    this.mAeFpsRange.addAeFpsRangeOptions(var1_1);
                    var2_2 = this.mZoomControl;
                    var2_2.addZoomOption(var1_1);
                    var5_5 = this.mIsTorchOn;
                    var6_6 = 2;
                    if (var5_5 == 0) break block4;
                    var2_2 = CaptureRequest.FLASH_MODE;
                    var4_4 = var6_6;
                    var1_1.setCaptureRequestOption((CaptureRequest.Key)var2_2, var4_4);
                    ** GOTO lbl-1000
                }
                var5_5 = this.mFlashMode;
                if (var5_5 != 0) {
                    ** if (var5_5 == var3_3) goto lbl-1000
                }
                break block5;
lbl-1000:
                // 2 sources

                {
                    var5_5 = var3_3;
                    ** GOTO lbl31
                }
lbl-1000:
                // 1 sources

                {
                    var5_5 = 3;
                }
                break block6;
            }
            var2_2 = this.mAutoFlashAEModeDisabler;
            var5_5 = var2_2.getCorrectedAeMode(var6_6);
        }
        var4_4 = CaptureRequest.CONTROL_AE_MODE;
        var5_5 = this.getSupportedAeMode(var5_5);
        var2_2 = var5_5;
        var1_1.setCaptureRequestOption((CaptureRequest.Key)var4_4, var2_2);
        var2_2 = CaptureRequest.CONTROL_AWB_MODE;
        var3_3 = this.getSupportedAwbMode(var3_3);
        var7_7 = var3_3;
        var1_1.setCaptureRequestOption((CaptureRequest.Key)var2_2, var7_7);
        this.mExposureControl.setCaptureRequestOption(var1_1);
        var2_2 = this.mCamera2CameraControl.getCamera2ImplConfig();
        var7_7 = var2_2.listOptions().iterator();
        while ((var6_6 = (int)var7_7.hasNext()) != 0) {
            var4_4 = (Config$Option)var7_7.next();
            var8_8 = var1_1.getMutableConfig();
            var9_9 = Config$OptionPriority.ALWAYS_OVERRIDE;
            var10_10 = var2_2.retrieveOption((Config$Option)var4_4);
            var8_8.insertOption((Config$Option)var4_4, var9_9, var10_10);
        }
        return var1_1.build();
    }

    public int getSupportedAfMode(int n10) {
        Object object = this.mCameraCharacteristics;
        CameraCharacteristics.Key key = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
        object = (int[])((CameraCharacteristicsCompat)object).get(key);
        key = null;
        if (object == null) {
            return 0;
        }
        boolean bl2 = this.isModeInList(n10, (int[])object);
        if (bl2) {
            return n10;
        }
        n10 = 4;
        bl2 = this.isModeInList(n10, (int[])object);
        if (bl2) {
            return n10;
        }
        n10 = 1;
        boolean bl3 = this.isModeInList(n10, (int[])object);
        if (bl3) {
            return n10;
        }
        return 0;
    }

    public TorchControl getTorchControl() {
        return this.mTorchControl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getUseCount() {
        Object object = this.mLock;
        synchronized (object) {
            return this.mUseCount;
        }
    }

    public ZoomControl getZoomControl() {
        return this.mZoomControl;
    }

    public /* synthetic */ void h() {
        this.g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void incrementUseCount() {
        Object object = this.mLock;
        synchronized (object) {
            int n10;
            this.mUseCount = n10 = this.mUseCount + 1;
            return;
        }
    }

    public /* synthetic */ void j(CameraCaptureCallback cameraCaptureCallback) {
        this.i(cameraCaptureCallback);
    }

    public /* synthetic */ void l(List list) {
        this.k(list);
    }

    public /* synthetic */ void n(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.m(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ Object p(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.o(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void r(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.q(callbackToFutureAdapter$Completer);
    }

    public void removeCaptureResultListener(Camera2CameraControlImpl$CaptureResultListener camera2CameraControlImpl$CaptureResultListener) {
        this.mSessionCallback.removeListener(camera2CameraControlImpl$CaptureResultListener);
    }

    public void removeSessionCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        Executor executor = this.mExecutor;
        a a10 = new a(this, cameraCaptureCallback);
        executor.execute(a10);
    }

    public void setActive(boolean bl2) {
        this.mFocusMeteringControl.setActive(bl2);
        this.mZoomControl.setActive(bl2);
        this.mTorchControl.setActive(bl2);
        this.mExposureControl.setActive(bl2);
        this.mCamera2CameraControl.setActive(bl2);
    }

    public void setDefaultRequestBuilder(CaptureRequest.Builder builder) {
        this.mFocusMeteringControl.setDefaultRequestBuilder(builder);
    }

    public ListenableFuture setExposureCompensationIndex(int n10) {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture(cameraControl$OperationCanceledException);
        }
        return this.mExposureControl.setExposureCompensationIndex(n10);
    }

    public void setFlashMode(int n10) {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            Logger.w(TAG, "Camera is not active.");
            return;
        }
        this.mFlashMode = n10;
        this.updateSessionConfig();
    }

    public ListenableFuture setLinearZoom(float f10) {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture(cameraControl$OperationCanceledException);
        }
        return Futures.nonCancellationPropagating(this.mZoomControl.setLinearZoom(f10));
    }

    public void setPreviewAspectRatio(Rational rational) {
        this.mPreviewAspectRatio = rational;
    }

    public ListenableFuture setZoomRatio(float f10) {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture(cameraControl$OperationCanceledException);
        }
        return Futures.nonCancellationPropagating(this.mZoomControl.setZoomRatio(f10));
    }

    public ListenableFuture startFocusAndMetering(FocusMeteringAction object) {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            object = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture((Throwable)object);
        }
        FocusMeteringControl focusMeteringControl = this.mFocusMeteringControl;
        Rational rational = this.mPreviewAspectRatio;
        return Futures.nonCancellationPropagating(focusMeteringControl.startFocusAndMetering((FocusMeteringAction)object, rational));
    }

    public void submitCaptureRequests(List list) {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            Logger.w(TAG, "Camera is not active.");
            return;
        }
        Executor executor = this.mExecutor;
        n n10 = new n(this, list);
        executor.execute(n10);
    }

    public void submitCaptureRequestsInternal(List list) {
        this.mControlUpdateCallback.onCameraControlCaptureRequests(list);
    }

    public /* synthetic */ Object t(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.s(callbackToFutureAdapter$Completer);
    }

    public ListenableFuture triggerAePrecapture() {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture(cameraControl$OperationCanceledException);
        }
        o o10 = new o(this);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(o10));
    }

    public ListenableFuture triggerAf() {
        boolean bl2 = this.isControlInUse();
        if (!bl2) {
            CameraControl$OperationCanceledException cameraControl$OperationCanceledException = new CameraControl$OperationCanceledException("Camera is not active.");
            return Futures.immediateFailedFuture(cameraControl$OperationCanceledException);
        }
        b b10 = new b(this);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(b10));
    }

    public void updateSessionConfig() {
        Executor executor = this.mExecutor;
        y0 y02 = new y0(this);
        executor.execute(y02);
    }

    public void updateSessionConfigSynchronous() {
        Object object = this.mSessionConfigBuilder;
        Object object2 = this.getSessionOptions();
        ((SessionConfig$Builder)object).setImplementationOptions((Config)object2);
        object = this.mCamera2CameraControl.getCamera2ImplConfig();
        boolean bl2 = false;
        object2 = null;
        object = ((Camera2ImplConfig)object).getCaptureRequestTag(null);
        if (object != null && (bl2 = object instanceof Integer)) {
            object2 = this.mSessionConfigBuilder;
            object = (Integer)object;
            String string2 = "Camera2CameraControl";
            ((SessionConfig$Builder)object2).addTag(string2, (Integer)object);
        }
        object = this.mControlUpdateCallback;
        object2 = this.mSessionConfigBuilder.build();
        object.onCameraControlUpdateSessionConfig((SessionConfig)object2);
    }
}

