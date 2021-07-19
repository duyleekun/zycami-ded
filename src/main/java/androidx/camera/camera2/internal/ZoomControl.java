/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 *  android.os.Build$VERSION
 *  android.os.Looper
 */
package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.os.Looper;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.camera.camera2.internal.AndroidRZoomImpl;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import androidx.camera.camera2.internal.CropRegionZoomImpl;
import androidx.camera.camera2.internal.ZoomControl$1;
import androidx.camera.camera2.internal.ZoomControl$ZoomImpl;
import androidx.camera.camera2.internal.ZoomStateImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b.a.a.d.j1;
import b.a.a.d.k1;
import b.a.a.d.l1;
import b.a.a.d.m1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class ZoomControl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private static final String TAG = "ZoomControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private Camera2CameraControlImpl$CaptureResultListener mCaptureResultListener;
    private final ZoomStateImpl mCurrentZoomState;
    private final Executor mExecutor;
    private boolean mIsActive = false;
    public final ZoomControl$ZoomImpl mZoomImpl;
    private final MutableLiveData mZoomStateLiveData;

    public ZoomControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat object, Executor object2) {
        ZoomControl$1 zoomControl$1 = new ZoomControl$1(this);
        this.mCaptureResultListener = zoomControl$1;
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = object2;
        this.mZoomImpl = object = ZoomControl.createZoomImpl((CameraCharacteristicsCompat)object);
        float f10 = object.getMaxZoom();
        float f11 = object.getMinZoom();
        this.mCurrentZoomState = object2 = new ZoomStateImpl(f10, f11);
        ((ZoomStateImpl)object2).setZoomRatio(1.0f);
        object2 = ImmutableZoomState.create((ZoomState)object2);
        this.mZoomStateLiveData = object = new MutableLiveData(object2);
        object = this.mCaptureResultListener;
        camera2CameraControlImpl.addCaptureResultListener((Camera2CameraControlImpl$CaptureResultListener)object);
    }

    private /* synthetic */ void a(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ZoomState zoomState) {
        this.submitCameraZoomRatio(callbackToFutureAdapter$Completer, zoomState);
    }

    private /* synthetic */ Object c(ZoomState zoomState, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        m1 m12 = new m1(this, callbackToFutureAdapter$Completer, zoomState);
        executor.execute(m12);
        return "setLinearZoom";
    }

    private static ZoomControl$ZoomImpl createZoomImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean bl2 = ZoomControl.isAndroidRZoomSupported(cameraCharacteristicsCompat);
        if (bl2) {
            AndroidRZoomImpl androidRZoomImpl = new AndroidRZoomImpl(cameraCharacteristicsCompat);
            return androidRZoomImpl;
        }
        CropRegionZoomImpl cropRegionZoomImpl = new CropRegionZoomImpl(cameraCharacteristicsCompat);
        return cropRegionZoomImpl;
    }

    private /* synthetic */ void e(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ZoomState zoomState) {
        this.submitCameraZoomRatio(callbackToFutureAdapter$Completer, zoomState);
    }

    private /* synthetic */ Object g(ZoomState zoomState, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Executor executor = this.mExecutor;
        j1 j12 = new j1(this, callbackToFutureAdapter$Completer, zoomState);
        executor.execute(j12);
        return "setZoomRatio";
    }

    public static ZoomState getDefaultZoomState(CameraCharacteristicsCompat object) {
        object = ZoomControl.createZoomImpl((CameraCharacteristicsCompat)object);
        float f10 = object.getMaxZoom();
        float f11 = object.getMinZoom();
        ZoomStateImpl zoomStateImpl = new ZoomStateImpl(f10, f11);
        zoomStateImpl.setZoomRatio(1.0f);
        return ImmutableZoomState.create(zoomStateImpl);
    }

    private static boolean isAndroidRZoomSupported(CameraCharacteristicsCompat object) {
        boolean bl2;
        CameraCharacteristics.Key key;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11 && (object = ((CameraCharacteristicsCompat)object).get(key = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void submitCameraZoomRatio(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ZoomState object) {
        boolean bl2 = this.mIsActive;
        if (!bl2) {
            ZoomStateImpl zoomStateImpl = this.mCurrentZoomState;
            synchronized (zoomStateImpl) {
                object = this.mCurrentZoomState;
                float f10 = 1.0f;
                ((ZoomStateImpl)object).setZoomRatio(f10);
                object = this.mCurrentZoomState;
                object = ImmutableZoomState.create((ZoomState)object);
            }
            this.updateLiveData((ZoomState)object);
            object = new CameraControl$OperationCanceledException("Camera is not active.");
            callbackToFutureAdapter$Completer.setException((Throwable)object);
            return;
        }
        this.updateLiveData((ZoomState)object);
        ZoomControl$ZoomImpl zoomControl$ZoomImpl = this.mZoomImpl;
        float f11 = object.getZoomRatio();
        zoomControl$ZoomImpl.setZoomRatio(f11, callbackToFutureAdapter$Completer);
        this.mCamera2CameraControlImpl.updateSessionConfigSynchronous();
    }

    private void updateLiveData(ZoomState zoomState) {
        Looper looper;
        Object object = Looper.myLooper();
        if (object == (looper = Looper.getMainLooper())) {
            object = this.mZoomStateLiveData;
            ((MutableLiveData)object).setValue(zoomState);
        } else {
            object = this.mZoomStateLiveData;
            ((MutableLiveData)object).postValue(zoomState);
        }
    }

    public void addZoomOption(Camera2ImplConfig$Builder camera2ImplConfig$Builder) {
        this.mZoomImpl.addRequestOption(camera2ImplConfig$Builder);
    }

    public /* synthetic */ void b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ZoomState zoomState) {
        this.a(callbackToFutureAdapter$Completer, zoomState);
    }

    public /* synthetic */ Object d(ZoomState zoomState, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.c(zoomState, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void f(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, ZoomState zoomState) {
        this.e(callbackToFutureAdapter$Completer, zoomState);
    }

    public Rect getCropSensorRegion() {
        return this.mZoomImpl.getCropSensorRegion();
    }

    public LiveData getZoomState() {
        return this.mZoomStateLiveData;
    }

    public /* synthetic */ Object h(ZoomState zoomState, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.g(zoomState, callbackToFutureAdapter$Completer);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setActive(boolean bl2) {
        ZoomState zoomState;
        boolean bl3 = this.mIsActive;
        if (bl3 == bl2) {
            return;
        }
        this.mIsActive = bl2;
        if (bl2) return;
        Object object = this.mCurrentZoomState;
        synchronized (object) {
            zoomState = this.mCurrentZoomState;
            float f10 = 1.0f;
            zoomState.setZoomRatio(f10);
            zoomState = this.mCurrentZoomState;
            zoomState = ImmutableZoomState.create(zoomState);
        }
        this.updateLiveData(zoomState);
        this.mZoomImpl.resetZoom();
        object = this.mCamera2CameraControlImpl;
        ((Camera2CameraControlImpl)object).updateSessionConfigSynchronous();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture setLinearZoom(float var1_1) {
        var2_2 = this.mCurrentZoomState;
        synchronized (var2_2) {
            block6: {
                var3_3 = this.mCurrentZoomState;
                var3_3.setLinearZoom(var1_1);
                var4_4 /* !! */  = this.mCurrentZoomState;
                var4_4 /* !! */  = ImmutableZoomState.create(var4_4 /* !! */ );
                ** GOTO lbl12
                {
                    catch (Throwable var4_5) {
                        break block6;
                    }
lbl12:
                    // 1 sources

                    // MONITOREXIT @DISABLED, blocks:[3, 5] lbl12 : MonitorExitStatement: MONITOREXIT : var2_2
                    this.updateLiveData(var4_4 /* !! */ );
                    var2_2 = new l1(this, var4_4 /* !! */ );
                    return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)var2_2);
                    catch (IllegalArgumentException var4_6) {}
                    return Futures.immediateFailedFuture(var4_6);
                }
            }
            throw var4_5;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture setZoomRatio(float var1_1) {
        var2_2 = this.mCurrentZoomState;
        synchronized (var2_2) {
            block6: {
                var3_3 = this.mCurrentZoomState;
                var3_3.setZoomRatio(var1_1);
                var4_4 /* !! */  = this.mCurrentZoomState;
                var4_4 /* !! */  = ImmutableZoomState.create(var4_4 /* !! */ );
                ** GOTO lbl12
                {
                    catch (Throwable var4_5) {
                        break block6;
                    }
lbl12:
                    // 1 sources

                    // MONITOREXIT @DISABLED, blocks:[3, 5] lbl12 : MonitorExitStatement: MONITOREXIT : var2_2
                    this.updateLiveData(var4_4 /* !! */ );
                    var2_2 = new k1(this, var4_4 /* !! */ );
                    return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)var2_2);
                    catch (IllegalArgumentException var4_6) {}
                    return Futures.immediateFailedFuture(var4_6);
                }
            }
            throw var4_5;
        }
    }
}

