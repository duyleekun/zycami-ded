/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 *  android.hardware.camera2.CameraManager$AvailabilityCallback
 *  android.hardware.camera2.CaptureRequest$Builder
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.util.Rational
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Rational;
import android.view.Surface;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$1;
import androidx.camera.camera2.internal.Camera2CameraImpl$2;
import androidx.camera.camera2.internal.Camera2CameraImpl$3;
import androidx.camera.camera2.internal.Camera2CameraImpl$CameraAvailability;
import androidx.camera.camera2.internal.Camera2CameraImpl$ControlUpdateListenerInternal;
import androidx.camera.camera2.internal.Camera2CameraImpl$InternalState;
import androidx.camera.camera2.internal.Camera2CameraImpl$StateCallback;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.CameraDeviceStateCallbacks;
import androidx.camera.camera2.internal.CameraUnavailableExceptionHelper;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.CaptureSessionRepository;
import androidx.camera.camera2.internal.MeteringRepeatingSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener$Builder;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraControlInternal$ControlUpdateCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraInternal$State;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;
import androidx.camera.core.impl.SessionConfig$ValidatingBuilder;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.a.d.a0;
import b.a.a.d.b0;
import b.a.a.d.c0;
import b.a.a.d.d0;
import b.a.a.d.e0;
import b.a.a.d.f0;
import b.a.a.d.p;
import b.a.a.d.q;
import b.a.a.d.r;
import b.a.a.d.s;
import b.a.a.d.t;
import b.a.a.d.u;
import b.a.a.d.w;
import b.a.a.d.x;
import b.a.a.d.y;
import b.a.a.d.z;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public final class Camera2CameraImpl
implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera2CameraImpl";
    private final Camera2CameraImpl$CameraAvailability mCameraAvailability;
    private final Camera2CameraControlImpl mCameraControlInternal;
    public SessionConfig mCameraControlSessionConfig;
    public CameraDevice mCameraDevice;
    public int mCameraDeviceError;
    public final Camera2CameraInfoImpl mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateRegistry mCameraStateRegistry;
    public CaptureSession mCaptureSession;
    private final SynchronizedCaptureSessionOpener$Builder mCaptureSessionOpenerBuilder;
    private final CaptureSessionRepository mCaptureSessionRepository;
    public final Set mConfiguringForClose;
    private final Executor mExecutor;
    private MeteringRepeatingSession mMeteringRepeatingSession;
    private final Set mNotifyStateAttachedSet;
    private final LiveDataObservable mObservableState;
    public final AtomicInteger mReleaseRequestCount;
    public final Map mReleasedCaptureSessions;
    public volatile Camera2CameraImpl$InternalState mState;
    private final Camera2CameraImpl$StateCallback mStateCallback;
    private final UseCaseAttachState mUseCaseAttachState;
    public ListenableFuture mUserReleaseFuture;
    public CallbackToFutureAdapter$Completer mUserReleaseNotifier;

    public Camera2CameraImpl(CameraManagerCompat cameraManagerCompat, String string2, Camera2CameraInfoImpl object, CameraStateRegistry cameraStateRegistry, Executor executor, Handler handler) {
        Object object2;
        Object object3;
        Object object4 = Camera2CameraImpl$InternalState.INITIALIZED;
        this.mState = object4;
        this.mObservableState = object4;
        this.mCameraDeviceError = 0;
        Object object5 = SessionConfig.defaultEmptySessionConfig();
        this.mCameraControlSessionConfig = object5;
        this.mReleaseRequestCount = object5 = new AtomicInteger(0);
        Object object6 = new LinkedHashMap();
        this.mReleasedCaptureSessions = object6;
        super();
        this.mConfiguringForClose = object6;
        super();
        this.mNotifyStateAttachedSet = object6;
        this.mCameraManager = cameraManagerCompat;
        this.mCameraStateRegistry = cameraStateRegistry;
        object6 = CameraXExecutors.newHandlerExecutor(handler);
        this.mExecutor = executor = CameraXExecutors.newSequentialExecutor(executor);
        object5 = new Camera2CameraImpl$StateCallback(this, executor, (ScheduledExecutorService)object6);
        this.mStateCallback = object5;
        object5 = new UseCaseAttachState(string2);
        this.mUseCaseAttachState = object5;
        object5 = CameraInternal$State.CLOSED;
        ((LiveDataObservable)object4).postValue(object5);
        this.mCaptureSessionRepository = object4 = new CaptureSessionRepository(executor);
        object5 = new CaptureSession();
        this.mCaptureSession = object5;
        try {
            object3 = cameraManagerCompat.getCameraCharacteristicsCompat(string2);
        }
        catch (CameraAccessExceptionCompat cameraAccessExceptionCompat) {
            throw CameraUnavailableExceptionHelper.createFrom(cameraAccessExceptionCompat);
        }
        Object object7 = new Camera2CameraImpl$ControlUpdateListenerInternal(this);
        Quirks quirks = ((Camera2CameraInfoImpl)object).getCameraQuirks();
        object5 = object2;
        object2 = new Camera2CameraControlImpl((CameraCharacteristicsCompat)object3, (ScheduledExecutorService)object6, executor, (CameraControlInternal$ControlUpdateCallback)object7, quirks);
        this.mCameraControlInternal = object2;
        this.mCameraInfoInternal = object;
        ((Camera2CameraInfoImpl)object).linkWithCameraControl((Camera2CameraControlImpl)object2);
        int n10 = ((Camera2CameraInfoImpl)object).getSupportedHardwareLevel();
        object5 = object2;
        object3 = executor;
        object7 = object4;
        this.mCaptureSessionOpenerBuilder = object2 = new SynchronizedCaptureSessionOpener$Builder(executor, (ScheduledExecutorService)object6, handler, (CaptureSessionRepository)object4, n10);
        this.mCameraAvailability = object = new Camera2CameraImpl$CameraAvailability(this, string2);
        cameraStateRegistry.registerCamera(this, executor, (CameraStateRegistry$OnOpenAvailableListener)object);
        cameraManagerCompat.registerAvailabilityCallback(executor, (CameraManager.AvailabilityCallback)object);
    }

    private /* synthetic */ Object A(CallbackToFutureAdapter$Completer object) {
        Executor executor = this.mExecutor;
        q q10 = new q(this, (CallbackToFutureAdapter$Completer)object);
        executor.execute(q10);
        object = new StringBuilder();
        ((StringBuilder)object).append("Release[request=");
        int n10 = this.mReleaseRequestCount.getAndIncrement();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    public static /* synthetic */ void a(Camera2CameraImpl camera2CameraImpl) {
        camera2CameraImpl.openInternal();
    }

    private void addMeteringRepeating() {
        Object object = this.mMeteringRepeatingSession;
        if (object != null) {
            object = this.mUseCaseAttachState;
            CharSequence charSequence = new StringBuilder();
            Object object2 = this.mMeteringRepeatingSession.getName();
            ((StringBuilder)charSequence).append((String)object2);
            int n10 = this.mMeteringRepeatingSession.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            object2 = this.mMeteringRepeatingSession.getSessionConfig();
            ((UseCaseAttachState)object).setUseCaseAttached((String)charSequence, (SessionConfig)object2);
            object = this.mUseCaseAttachState;
            charSequence = new StringBuilder();
            object2 = this.mMeteringRepeatingSession.getName();
            ((StringBuilder)charSequence).append((String)object2);
            n10 = this.mMeteringRepeatingSession.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            object2 = this.mMeteringRepeatingSession.getSessionConfig();
            ((UseCaseAttachState)object).setUseCaseActive((String)charSequence, (SessionConfig)object2);
        }
    }

    private void addOrRemoveMeteringRepeatingUseCase() {
        Object object = this.mUseCaseAttachState.getAttachedBuilder().build();
        Object object2 = ((SessionConfig)object).getRepeatingCaptureConfig();
        List list = ((CaptureConfig)object2).getSurfaces();
        int n10 = list.size();
        List list2 = ((SessionConfig)object).getSurfaces();
        int n11 = list2.size();
        int n12 = (object = ((SessionConfig)object).getSurfaces()).isEmpty();
        if (n12 == 0) {
            object = ((CaptureConfig)object2).getSurfaces();
            n12 = object.isEmpty();
            if (n12 != 0) {
                object = this.mMeteringRepeatingSession;
                if (object == null) {
                    object2 = this.mCameraInfoInternal.getCameraCharacteristicsCompat();
                    this.mMeteringRepeatingSession = object = new MeteringRepeatingSession((CameraCharacteristicsCompat)object2);
                }
                this.addMeteringRepeating();
            } else {
                n12 = 1;
                if (n11 == n12 && n10 == n12) {
                    this.removeMeteringRepeating();
                } else {
                    n12 = 2;
                    if (n10 >= n12) {
                        this.removeMeteringRepeating();
                    } else {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("mMeteringRepeating is ATTACHED, SessionConfig Surfaces: ");
                        ((StringBuilder)object).append(n11);
                        ((StringBuilder)object).append(", CaptureConfig Surfaces: ");
                        ((StringBuilder)object).append(n10);
                        object = ((StringBuilder)object).toString();
                        object2 = TAG;
                        Logger.d((String)object2, (String)object);
                    }
                }
            }
        }
    }

    private /* synthetic */ void b(Collection collection) {
        try {
            this.tryAttachUseCases(collection);
            return;
        }
        finally {
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig$Builder object) {
        boolean bl2;
        Object object2 = ((CaptureConfig$Builder)object).getSurfaces();
        boolean bl3 = object2.isEmpty();
        String string2 = TAG;
        if (!bl3) {
            Logger.w(string2, "The capture config builder already has surface inside.");
            return false;
        }
        object2 = this.mUseCaseAttachState.getActiveAndAttachedSessionConfigs().iterator();
        while (bl2 = object2.hasNext()) {
            Object object3 = ((SessionConfig)object2.next()).getRepeatingCaptureConfig().getSurfaces();
            boolean bl4 = object3.isEmpty();
            if (bl4) continue;
            object3 = object3.iterator();
            while (bl4 = object3.hasNext()) {
                DeferrableSurface deferrableSurface = (DeferrableSurface)object3.next();
                ((CaptureConfig$Builder)object).addSurface(deferrableSurface);
            }
        }
        boolean bl5 = (object = ((CaptureConfig$Builder)object).getSurfaces()).isEmpty();
        if (bl5) {
            Logger.w(string2, "Unable to find a repeating surface to attach to CaptureConfig");
            return false;
        }
        return true;
    }

    private void clearCameraControlPreviewAspectRatio(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            UseCase useCase = (UseCase)object.next();
            bl2 = useCase instanceof Preview;
            if (!bl2) continue;
            object = this.mCameraControlInternal;
            bl2 = false;
            useCase = null;
            ((Camera2CameraControlImpl)object).setPreviewAspectRatio(null);
            break;
        }
    }

    private void closeInternal() {
        this.debugLog("Closing camera.");
        Object object = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.mState;
        int n10 = camera2CameraImpl$InternalState.ordinal();
        int n11 = object[n10];
        n10 = 2;
        boolean bl2 = false;
        if (n11 != n10) {
            n10 = 4;
            if (n11 != n10) {
                n10 = 5;
                if (n11 != n10 && n11 != (n10 = 6)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("close() ignored due to being in state: ");
                    camera2CameraImpl$InternalState = this.mState;
                    ((StringBuilder)object).append((Object)camera2CameraImpl$InternalState);
                    object = ((StringBuilder)object).toString();
                    this.debugLog((String)object);
                } else {
                    object = (Object)this.mStateCallback;
                    n11 = (int)(((Camera2CameraImpl$StateCallback)((Object)object)).cancelScheduledReopen() ? 1 : 0);
                    camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.CLOSING;
                    this.setState(camera2CameraImpl$InternalState);
                    if (n11) {
                        n11 = (int)(this.isSessionCloseComplete() ? 1 : 0);
                        Preconditions.checkState(n11 != 0);
                        this.finishClose();
                    }
                }
            } else {
                object = (Object)Camera2CameraImpl$InternalState.CLOSING;
                this.setState((Camera2CameraImpl$InternalState)((Object)object));
                this.closeCamera(false);
            }
        } else {
            object = this.mCameraDevice;
            if (object == null) {
                bl2 = true;
            }
            Preconditions.checkState(bl2);
            object = (Object)Camera2CameraImpl$InternalState.INITIALIZED;
            this.setState((Camera2CameraImpl$InternalState)((Object)object));
        }
    }

    private void configAndClose(boolean bl2) {
        Object object = new CaptureSession();
        this.mConfiguringForClose.add(object);
        this.resetCaptureSession(bl2);
        Object object2 = new SurfaceTexture(0);
        object2.setDefaultBufferSize(640, 480);
        Object object3 = new Surface((SurfaceTexture)object2);
        b0 b02 = new b0((Surface)object3, (SurfaceTexture)object2);
        object2 = new SessionConfig$Builder();
        Object object4 = new ImmediateSurface((Surface)object3);
        ((SessionConfig$Builder)object2).addNonRepeatingSurface((DeferrableSurface)object4);
        ((SessionConfig$Builder)object2).setTemplateType(1);
        this.debugLog("Start configAndClose.");
        object2 = ((SessionConfig$Builder)object2).build();
        object3 = (CameraDevice)Preconditions.checkNotNull(this.mCameraDevice);
        object4 = this.mCaptureSessionOpenerBuilder.build();
        object2 = ((CaptureSession)object).open((SessionConfig)object2, (CameraDevice)object3, (SynchronizedCaptureSessionOpener)object4);
        object3 = new d0(this, (CaptureSession)object, b02);
        object = this.mExecutor;
        object2.addListener((Runnable)object3, (Executor)object);
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        Object object = this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks();
        ArrayList<List> arrayList = new ArrayList<List>((Collection<List>)object);
        object = this.mStateCallback;
        arrayList.add((List)object);
        object = this.mCaptureSessionRepository.getCameraStateCallback();
        arrayList.add((List)object);
        return CameraDeviceStateCallbacks.createComboCallback(arrayList);
    }

    public static /* synthetic */ void d(Camera2CameraImpl camera2CameraImpl) {
        camera2CameraImpl.closeInternal();
    }

    private void debugLog(String string2, Throwable throwable) {
        Object[] objectArray = new Object[2];
        String string3 = this.toString();
        objectArray[0] = string3;
        objectArray[1] = string2;
        string2 = String.format("{%s} %s", objectArray);
        Logger.d(TAG, string2, throwable);
    }

    public static /* synthetic */ void e(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    private /* synthetic */ void f(CaptureSession captureSession, Runnable runnable) {
        this.releaseNoOpSession(captureSession, runnable);
    }

    public static String getErrorMessage(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            n11 = 5;
                            if (n10 != n11) {
                                return "UNKNOWN ERROR";
                            }
                            return "ERROR_CAMERA_SERVICE";
                        }
                        return "ERROR_CAMERA_DEVICE";
                    }
                    return "ERROR_CAMERA_DISABLED";
                }
                return "ERROR_MAX_CAMERAS_IN_USE";
            }
            return "ERROR_CAMERA_IN_USE";
        }
        return "ERROR_NONE";
    }

    private ListenableFuture getOrCreateUserReleaseFuture() {
        Object object = this.mUserReleaseFuture;
        if (object == null) {
            object = this.mState;
            Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.RELEASED;
            if (object != camera2CameraImpl$InternalState) {
                object = new w(this);
                this.mUserReleaseFuture = object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
            } else {
                this.mUserReleaseFuture = object = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    private /* synthetic */ void h(Collection collection) {
        this.tryDetachUseCases(collection);
    }

    private boolean isLegacyDevice() {
        int n10;
        Camera2CameraInfoImpl camera2CameraInfoImpl = (Camera2CameraInfoImpl)this.getCameraInfoInternal();
        int n11 = camera2CameraInfoImpl.getSupportedHardwareLevel();
        if (n11 == (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            camera2CameraInfoImpl = null;
        }
        return n11 != 0;
    }

    private /* synthetic */ Object j(CallbackToFutureAdapter$Completer object) {
        boolean bl2;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.mUserReleaseNotifier;
        if (callbackToFutureAdapter$Completer == null) {
            bl2 = true;
        } else {
            bl2 = false;
            callbackToFutureAdapter$Completer = null;
        }
        Preconditions.checkState(bl2, "Camera can only be released once, so release completer should be null on creation.");
        this.mUserReleaseNotifier = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("Release[camera=");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    private /* synthetic */ Object l(UseCase object, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object2 = this.mExecutor;
        t t10 = new t(this, callbackToFutureAdapter$Completer, (UseCase)object);
        try {
            object2.execute(t10);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object2 = "Unable to check if use case is attached. Camera executor shut down.";
            object = new RuntimeException((String)object2);
            callbackToFutureAdapter$Completer.setException((Throwable)object);
        }
        return "isUseCaseAttached";
    }

    private /* synthetic */ void n(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, UseCase object) {
        UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = ((UseCase)object).getName();
        stringBuilder.append(string2);
        int n10 = object.hashCode();
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        object = useCaseAttachState.isUseCaseAttached((String)object);
        callbackToFutureAdapter$Completer.set(object);
    }

    private void notifyStateAttachedToUseCases(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            UseCase useCase = (UseCase)object.next();
            Set set = this.mNotifyStateAttachedSet;
            CharSequence charSequence = new StringBuilder();
            String string2 = useCase.getName();
            ((StringBuilder)charSequence).append(string2);
            int n10 = useCase.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            boolean bl3 = set.contains(charSequence);
            if (bl3) continue;
            set = this.mNotifyStateAttachedSet;
            charSequence = new StringBuilder();
            string2 = useCase.getName();
            ((StringBuilder)charSequence).append(string2);
            n10 = useCase.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            set.add(charSequence);
            useCase.onStateAttached();
        }
    }

    private void notifyStateDetachedToUseCases(List object) {
        int n10;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = (UseCase)object.next();
            Set set = this.mNotifyStateAttachedSet;
            CharSequence charSequence = new StringBuilder();
            String string2 = ((UseCase)object2).getName();
            ((StringBuilder)charSequence).append(string2);
            int n11 = object2.hashCode();
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            boolean bl2 = set.contains(charSequence);
            if (!bl2) continue;
            ((UseCase)object2).onStateDetached();
            set = this.mNotifyStateAttachedSet;
            charSequence = new StringBuilder();
            string2 = ((UseCase)object2).getName();
            ((StringBuilder)charSequence).append(string2);
            n10 = object2.hashCode();
            ((StringBuilder)charSequence).append(n10);
            object2 = ((StringBuilder)charSequence).toString();
            set.remove(object2);
        }
    }

    private void openCameraDevice(boolean n10) {
        block9: {
            Object object;
            String string2 = "Unable to open camera due to ";
            if (n10 == 0) {
                object = this.mStateCallback;
                ((Camera2CameraImpl$StateCallback)((Object)object)).resetReopenMonitor();
            }
            this.mStateCallback.cancelScheduledReopen();
            this.debugLog("Opening camera.");
            object = Camera2CameraImpl$InternalState.OPENING;
            this.setState((Camera2CameraImpl$InternalState)((Object)object));
            object = this.mCameraManager;
            Object object2 = this.mCameraInfoInternal;
            object2 = ((Camera2CameraInfoImpl)object2).getCameraId();
            Executor executor = this.mExecutor;
            CameraDevice.StateCallback stateCallback = this.createDeviceStateCallback();
            try {
                ((CameraManagerCompat)object).openCamera((String)object2, executor, stateCallback);
            }
            catch (SecurityException securityException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                Object object3 = securityException.getMessage();
                ((StringBuilder)object2).append((String)object3);
                object3 = ((StringBuilder)object2).toString();
                this.debugLog((String)object3);
                object3 = Camera2CameraImpl$InternalState.REOPENING;
                this.setState((Camera2CameraImpl$InternalState)((Object)object3));
                object3 = this.mStateCallback;
                ((Camera2CameraImpl$StateCallback)((Object)object3)).scheduleCameraReopen();
            }
            catch (CameraAccessExceptionCompat cameraAccessExceptionCompat) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                string2 = cameraAccessExceptionCompat.getMessage();
                ((StringBuilder)object2).append(string2);
                string2 = ((StringBuilder)object2).toString();
                this.debugLog(string2);
                n10 = cameraAccessExceptionCompat.getReason();
                int n11 = 10001;
                if (n10 != n11) break block9;
                Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.INITIALIZED;
                this.setState(camera2CameraImpl$InternalState);
            }
        }
    }

    private void openInternal() {
        int n10;
        Object object = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.mState;
        int n11 = camera2CameraImpl$InternalState.ordinal();
        int n12 = object[n11];
        if (n12 != (n11 = 1) && n12 != (n10 = 2)) {
            n10 = 3;
            if (n12 != n10) {
                object = new StringBuilder;
                object();
                object.append("open() ignored due to being in state: ");
                camera2CameraImpl$InternalState = this.mState;
                object.append((Object)camera2CameraImpl$InternalState);
                object = object.toString();
                this.debugLog((String)object);
            } else {
                object = (Object)Camera2CameraImpl$InternalState.REOPENING;
                this.setState((Camera2CameraImpl$InternalState)((Object)object));
                n12 = (int)(this.isSessionCloseComplete() ? 1 : 0);
                if (n12 == 0 && (n12 = this.mCameraDeviceError) == 0) {
                    object = this.mCameraDevice;
                    if (object == null) {
                        n11 = 0;
                        camera2CameraImpl$InternalState = null;
                    }
                    Preconditions.checkState(n11 != 0, "Camera Device should be open if session close is not complete");
                    object = Camera2CameraImpl$InternalState.OPENED;
                    this.setState((Camera2CameraImpl$InternalState)((Object)object));
                    this.openCaptureSession();
                }
            }
        } else {
            this.tryForceOpenCameraDevice();
        }
    }

    private /* synthetic */ void p(UseCase object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Use case ");
        ((StringBuilder)object2).append(object);
        CharSequence charSequence = " ACTIVE";
        ((StringBuilder)object2).append((String)charSequence);
        object2 = ((StringBuilder)object2).toString();
        this.debugLog((String)object2);
        object2 = this.mUseCaseAttachState;
        charSequence = new StringBuilder();
        Object object3 = ((UseCase)object).getName();
        ((StringBuilder)charSequence).append((String)object3);
        int n10 = object.hashCode();
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        object3 = ((UseCase)object).getSessionConfig();
        ((UseCaseAttachState)object2).setUseCaseActive((String)charSequence, (SessionConfig)object3);
        object2 = this.mUseCaseAttachState;
        charSequence = new StringBuilder();
        object3 = ((UseCase)object).getName();
        ((StringBuilder)charSequence).append((String)object3);
        n10 = object.hashCode();
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        object = ((UseCase)object).getSessionConfig();
        try {
            ((UseCaseAttachState)object2).updateUseCase((String)charSequence, (SessionConfig)object);
            this.updateCaptureSessionConfig();
        }
        catch (NullPointerException nullPointerException) {
            object = "Failed to set already detached use case active";
            this.debugLog((String)object);
        }
    }

    private /* synthetic */ void r(UseCase object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Use case ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" INACTIVE");
        object2 = ((StringBuilder)object2).toString();
        this.debugLog((String)object2);
        object2 = this.mUseCaseAttachState;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = ((UseCase)object).getName();
        stringBuilder.append(string2);
        int n10 = object.hashCode();
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        ((UseCaseAttachState)object2).setUseCaseInactive((String)object);
        this.updateCaptureSessionConfig();
    }

    private ListenableFuture releaseInternal() {
        ListenableFuture listenableFuture = this.getOrCreateUserReleaseFuture();
        Object object = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
        int bl2 = this.mState.ordinal();
        boolean bl3 = object[bl2];
        boolean bl4 = false;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = null;
        switch (bl3) {
            default: {
                object = new StringBuilder;
                ((StringBuilder)object)();
                ((StringBuilder)object).append("release() ignored due to being in state: ");
                camera2CameraImpl$InternalState = this.mState;
                ((StringBuilder)object).append((Object)camera2CameraImpl$InternalState);
                object = ((StringBuilder)object).toString();
                this.debugLog((String)object);
                break;
            }
            case 4: {
                object = (Object)Camera2CameraImpl$InternalState.RELEASING;
                this.setState((Camera2CameraImpl$InternalState)((Object)object));
                this.closeCamera(false);
                break;
            }
            case 3: 
            case 5: 
            case 6: 
            case 7: {
                object = (Object)this.mStateCallback;
                bl3 = ((Camera2CameraImpl$StateCallback)((Object)object)).cancelScheduledReopen();
                camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.RELEASING;
                this.setState(camera2CameraImpl$InternalState);
                if (!bl3) break;
                bl3 = this.isSessionCloseComplete();
                Preconditions.checkState(bl3);
                this.finishClose();
                break;
            }
            case 1: 
            case 2: {
                boolean bl5;
                object = this.mCameraDevice;
                if (object == null) {
                    bl5 = true;
                }
                Preconditions.checkState(bl5);
                object = Camera2CameraImpl$InternalState.RELEASING;
                this.setState((Camera2CameraImpl$InternalState)((Object)object));
                bl3 = this.isSessionCloseComplete();
                Preconditions.checkState(bl3);
                this.finishClose();
            }
        }
        return listenableFuture;
    }

    private void removeMeteringRepeating() {
        Object object = this.mMeteringRepeatingSession;
        if (object != null) {
            object = this.mUseCaseAttachState;
            CharSequence charSequence = new StringBuilder();
            Object object2 = this.mMeteringRepeatingSession.getName();
            ((StringBuilder)charSequence).append((String)object2);
            int n10 = this.mMeteringRepeatingSession.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            ((UseCaseAttachState)object).setUseCaseDetached((String)charSequence);
            object = this.mUseCaseAttachState;
            charSequence = new StringBuilder();
            object2 = this.mMeteringRepeatingSession.getName();
            ((StringBuilder)charSequence).append((String)object2);
            object2 = this.mMeteringRepeatingSession;
            n10 = object2.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            ((UseCaseAttachState)object).setUseCaseInactive((String)charSequence);
            this.mMeteringRepeatingSession.clear();
            object = null;
            this.mMeteringRepeatingSession = null;
        }
    }

    private /* synthetic */ void t(UseCase object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Use case ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" RESET");
        object2 = ((StringBuilder)object2).toString();
        this.debugLog((String)object2);
        object2 = this.mUseCaseAttachState;
        CharSequence charSequence = new StringBuilder();
        String string2 = ((UseCase)object).getName();
        charSequence.append(string2);
        int n10 = object.hashCode();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        object = ((UseCase)object).getSessionConfig();
        ((UseCaseAttachState)object2).updateUseCase((String)charSequence, (SessionConfig)object);
        this.resetCaptureSession(false);
        this.updateCaptureSessionConfig();
        object = this.mState;
        object2 = Camera2CameraImpl$InternalState.OPENED;
        if (object == object2) {
            this.openCaptureSession();
        }
    }

    private void tryAttachUseCases(Collection object) {
        Object object2;
        boolean bl2;
        Object object3 = this.mUseCaseAttachState.getAttachedSessionConfigs();
        boolean bl3 = object3.isEmpty();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (UseCase)object.next();
            UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
            CharSequence charSequence = new StringBuilder();
            Object object4 = ((UseCase)object2).getName();
            ((StringBuilder)charSequence).append((String)object4);
            int n10 = object2.hashCode();
            ((StringBuilder)charSequence).append(n10);
            boolean bl4 = useCaseAttachState.isUseCaseAttached((String)(charSequence = ((StringBuilder)charSequence).toString()));
            if (bl4) continue;
            useCaseAttachState = this.mUseCaseAttachState;
            charSequence = new StringBuilder();
            object4 = ((UseCase)object2).getName();
            ((StringBuilder)charSequence).append((String)object4);
            n10 = object2.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            object4 = ((UseCase)object2).getSessionConfig();
            useCaseAttachState.setUseCaseAttached((String)charSequence, (SessionConfig)object4);
            try {
                arrayList.add(object2);
            }
            catch (NullPointerException nullPointerException) {
                object2 = "Failed to attach a detached use case";
                this.debugLog((String)object2);
            }
        }
        boolean bl5 = arrayList.isEmpty();
        if (bl5) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Use cases [");
        object2 = TextUtils.join((CharSequence)", ", arrayList);
        ((StringBuilder)object).append((String)object2);
        object2 = "] now ATTACHED";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        this.debugLog((String)object);
        if (bl3) {
            object = this.mCameraControlInternal;
            bl3 = true;
            ((Camera2CameraControlImpl)object).setActive(bl3);
            object = this.mCameraControlInternal;
            ((Camera2CameraControlImpl)object).incrementUseCount();
        }
        this.addOrRemoveMeteringRepeatingUseCase();
        this.updateCaptureSessionConfig();
        bl5 = false;
        this.resetCaptureSession(false);
        object = this.mState;
        object3 = Camera2CameraImpl$InternalState.OPENED;
        if (object == object3) {
            this.openCaptureSession();
        } else {
            this.openInternal();
        }
        this.updateCameraControlPreviewAspectRatio(arrayList);
    }

    private void tryDetachUseCases(Collection object) {
        Object object2;
        boolean bl2;
        Object object3 = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (UseCase)object.next();
            UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
            CharSequence charSequence = new StringBuilder();
            String string2 = ((UseCase)object2).getName();
            ((StringBuilder)charSequence).append(string2);
            int n10 = object2.hashCode();
            ((StringBuilder)charSequence).append(n10);
            boolean bl3 = useCaseAttachState.isUseCaseAttached((String)(charSequence = ((StringBuilder)charSequence).toString()));
            if (!bl3) continue;
            useCaseAttachState = this.mUseCaseAttachState;
            charSequence = new StringBuilder();
            string2 = ((UseCase)object2).getName();
            ((StringBuilder)charSequence).append(string2);
            n10 = object2.hashCode();
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            useCaseAttachState.removeUseCase((String)charSequence);
            object3.add(object2);
        }
        boolean bl4 = object3.isEmpty();
        if (bl4) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Use cases [");
        object2 = TextUtils.join((CharSequence)", ", object3);
        ((StringBuilder)object).append((String)object2);
        object2 = "] now DETACHED for camera";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        this.debugLog((String)object);
        this.clearCameraControlPreviewAspectRatio((Collection)object3);
        this.addOrRemoveMeteringRepeatingUseCase();
        object = this.mUseCaseAttachState.getAttachedSessionConfigs();
        bl4 = object.isEmpty();
        object3 = null;
        if (bl4) {
            this.mCameraControlInternal.decrementUseCount();
            this.resetCaptureSession(false);
            this.mCameraControlInternal.setActive(false);
            object = new CaptureSession();
            this.mCaptureSession = object;
            this.closeInternal();
        } else {
            this.updateCaptureSessionConfig();
            this.resetCaptureSession(false);
            object = this.mState;
            object3 = Camera2CameraImpl$InternalState.OPENED;
            if (object == object3) {
                this.openCaptureSession();
            }
        }
    }

    private void updateCameraControlPreviewAspectRatio(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            UseCase useCase = (UseCase)object.next();
            int n10 = useCase instanceof Preview;
            if (n10 == 0) continue;
            object = useCase.getAttachedSurfaceResolution();
            if (object == null) break;
            n10 = object.getWidth();
            int n11 = object.getHeight();
            useCase = new Rational(n10, n11);
            object = this.mCameraControlInternal;
            ((Camera2CameraControlImpl)object).setPreviewAspectRatio((Rational)useCase);
            break;
        }
    }

    private /* synthetic */ void v(UseCase object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Use case ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" UPDATED");
        object2 = ((StringBuilder)object2).toString();
        this.debugLog((String)object2);
        object2 = this.mUseCaseAttachState;
        CharSequence charSequence = new StringBuilder();
        String string2 = ((UseCase)object).getName();
        charSequence.append(string2);
        int n10 = object.hashCode();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        object = ((UseCase)object).getSessionConfig();
        ((UseCaseAttachState)object2).updateUseCase((String)charSequence, (SessionConfig)object);
        this.updateCaptureSessionConfig();
    }

    public static /* synthetic */ void x(SessionConfig$ErrorListener sessionConfig$ErrorListener, SessionConfig sessionConfig) {
        SessionConfig$SessionError sessionConfig$SessionError = SessionConfig$SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET;
        sessionConfig$ErrorListener.onError(sessionConfig, sessionConfig$SessionError);
    }

    private /* synthetic */ void y(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Futures.propagate(this.releaseInternal(), callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ Object B(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.A(callbackToFutureAdapter$Completer);
    }

    public void attachUseCases(Collection collection) {
        boolean bl2 = collection.isEmpty();
        if (!bl2) {
            this.mCameraControlInternal.incrementUseCount();
            Object object = new ArrayList(collection);
            this.notifyStateAttachedToUseCases((List)object);
            object = this.mExecutor;
            c0 c02 = new c0(this, collection);
            try {
                object.execute(c02);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                object = "Unable to attach use cases.";
                this.debugLog((String)object, rejectedExecutionException);
                Camera2CameraControlImpl camera2CameraControlImpl = this.mCameraControlInternal;
                camera2CameraControlImpl.decrementUseCount();
            }
        }
    }

    public /* synthetic */ void c(Collection collection) {
        this.b(collection);
    }

    public void close() {
        Executor executor = this.mExecutor;
        x x10 = new x(this);
        executor.execute(x10);
    }

    public void closeCamera(boolean bl2) {
        int n10;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.mState;
        Object object = Camera2CameraImpl$InternalState.CLOSING;
        if (camera2CameraImpl$InternalState != object && (camera2CameraImpl$InternalState = this.mState) != (object = Camera2CameraImpl$InternalState.RELEASING) && ((camera2CameraImpl$InternalState = this.mState) != (object = Camera2CameraImpl$InternalState.REOPENING) || (n10 = this.mCameraDeviceError) == 0)) {
            n10 = 0;
            camera2CameraImpl$InternalState = null;
        } else {
            n10 = 1;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: ");
        Object object2 = this.mState;
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(" (error: ");
        int n11 = this.mCameraDeviceError;
        object2 = Camera2CameraImpl.getErrorMessage(n11);
        ((StringBuilder)object).append((String)object2);
        object2 = ")";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        Preconditions.checkState(n10 != 0, (String)object);
        n10 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n10 > n12 && n10 < (n12 = 29) && (n10 = (int)(this.isLegacyDevice() ? 1 : 0)) != 0 && (n10 = this.mCameraDeviceError) == 0) {
            this.configAndClose(bl2);
        } else {
            this.resetCaptureSession(bl2);
        }
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    public void debugLog(String string2) {
        this.debugLog(string2, null);
    }

    public void detachUseCases(Collection collection) {
        boolean bl2 = collection.isEmpty();
        if (!bl2) {
            Object object = new ArrayList(collection);
            this.notifyStateDetachedToUseCases((List)object);
            object = this.mExecutor;
            p p10 = new p(this, collection);
            object.execute(p10);
        }
    }

    public SessionConfig findSessionConfigForSurface(DeferrableSurface deferrableSurface) {
        boolean bl2;
        Iterator iterator2 = this.mUseCaseAttachState.getAttachedSessionConfigs().iterator();
        while (bl2 = iterator2.hasNext()) {
            SessionConfig sessionConfig = (SessionConfig)iterator2.next();
            List list = sessionConfig.getSurfaces();
            boolean bl3 = list.contains(deferrableSurface);
            if (!bl3) continue;
            return sessionConfig;
        }
        return null;
    }

    public void finishClose() {
        boolean bl2;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.mState;
        Object object = Camera2CameraImpl$InternalState.RELEASING;
        if (camera2CameraImpl$InternalState != object && (camera2CameraImpl$InternalState = this.mState) != (object = Camera2CameraImpl$InternalState.CLOSING)) {
            bl2 = false;
            camera2CameraImpl$InternalState = null;
        } else {
            bl2 = true;
        }
        Preconditions.checkState(bl2);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        bl2 = false;
        camera2CameraImpl$InternalState = null;
        this.mCameraDevice = null;
        object = this.mState;
        Object object2 = Camera2CameraImpl$InternalState.CLOSING;
        if (object == object2) {
            camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.INITIALIZED;
            this.setState(camera2CameraImpl$InternalState);
        } else {
            object = this.mCameraManager;
            object2 = this.mCameraAvailability;
            ((CameraManagerCompat)object).unregisterAvailabilityCallback((CameraManager.AvailabilityCallback)object2);
            object = Camera2CameraImpl$InternalState.RELEASED;
            this.setState((Camera2CameraImpl$InternalState)((Object)object));
            object = this.mUserReleaseNotifier;
            if (object != null) {
                ((CallbackToFutureAdapter$Completer)object).set(null);
                this.mUserReleaseNotifier = null;
            }
        }
    }

    public /* synthetic */ void g(CaptureSession captureSession, Runnable runnable) {
        this.f(captureSession, runnable);
    }

    public Camera2CameraImpl$CameraAvailability getCameraAvailability() {
        return this.mCameraAvailability;
    }

    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    public Observable getCameraState() {
        return this.mObservableState;
    }

    public /* synthetic */ void i(Collection collection) {
        this.h(collection);
    }

    public boolean isSessionCloseComplete() {
        Object object = this.mReleasedCaptureSessions;
        boolean bl2 = object.isEmpty();
        if (bl2 && (bl2 = (object = this.mConfiguringForClose).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isUseCaseAttached(UseCase object) {
        void var1_4;
        Object object2 = new a0(this, (UseCase)object);
        object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object2);
        object = object.get();
        object = (Boolean)object;
        try {
            return (Boolean)object;
        }
        catch (ExecutionException executionException) {
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        object2 = new RuntimeException("Unable to check if use case is attached.", (Throwable)var1_4);
        throw object2;
    }

    public /* synthetic */ Object k(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.j(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ Object m(UseCase useCase, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.l(useCase, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void o(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, UseCase useCase) {
        this.n(callbackToFutureAdapter$Completer, useCase);
    }

    public void onUseCaseActive(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        Executor executor = this.mExecutor;
        u u10 = new u(this, useCase);
        executor.execute(u10);
    }

    public void onUseCaseInactive(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        Executor executor = this.mExecutor;
        e0 e02 = new e0(this, useCase);
        executor.execute(e02);
    }

    public void onUseCaseReset(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        Executor executor = this.mExecutor;
        f0 f02 = new f0(this, useCase);
        executor.execute(f02);
    }

    public void onUseCaseUpdated(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        Executor executor = this.mExecutor;
        z z10 = new z(this, useCase);
        executor.execute(z10);
    }

    public void open() {
        Executor executor = this.mExecutor;
        r r10 = new r(this);
        executor.execute(r10);
    }

    public void openCaptureSession() {
        boolean bl2;
        Object object = this.mState;
        Object object2 = Camera2CameraImpl$InternalState.OPENED;
        if (object == object2) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2);
        object = this.mUseCaseAttachState.getAttachedBuilder();
        boolean bl3 = ((SessionConfig$ValidatingBuilder)object).isValid();
        if (!bl3) {
            this.debugLog("Unable to create capture session due to conflicting configurations");
            return;
        }
        object2 = this.mCaptureSession;
        object = ((SessionConfig$ValidatingBuilder)object).build();
        Object object3 = (CameraDevice)Preconditions.checkNotNull(this.mCameraDevice);
        SynchronizedCaptureSessionOpener synchronizedCaptureSessionOpener = this.mCaptureSessionOpenerBuilder.build();
        object = ((CaptureSession)object2).open((SessionConfig)object, (CameraDevice)object3, synchronizedCaptureSessionOpener);
        object2 = new Camera2CameraImpl$2(this);
        object3 = this.mExecutor;
        Futures.addCallback((ListenableFuture)object, (FutureCallback)object2, (Executor)object3);
    }

    public void postSurfaceClosedError(SessionConfig sessionConfig) {
        ScheduledExecutorService scheduledExecutorService = CameraXExecutors.mainThreadExecutor();
        Object object = sessionConfig.getErrorListeners();
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            bl2 = false;
            object = (SessionConfig$ErrorListener)object.get(0);
            Object object2 = new Throwable();
            String string2 = "Posting surface closed";
            this.debugLog(string2, (Throwable)object2);
            object2 = new s((SessionConfig$ErrorListener)object, sessionConfig);
            scheduledExecutorService.execute((Runnable)object2);
        }
    }

    public /* synthetic */ void q(UseCase useCase) {
        this.p(useCase);
    }

    public ListenableFuture release() {
        y y10 = new y(this);
        return CallbackToFutureAdapter.getFuture(y10);
    }

    public void releaseNoOpSession(CaptureSession object, Runnable runnable) {
        this.mConfiguringForClose.remove(object);
        object = this.releaseSession((CaptureSession)object, false);
        Executor executor = CameraXExecutors.directExecutor();
        object.addListener(runnable, executor);
    }

    public ListenableFuture releaseSession(CaptureSession object, boolean bl2) {
        ((CaptureSession)object).close();
        ListenableFuture listenableFuture = ((CaptureSession)object).release(bl2);
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Releasing session in state ");
        String string2 = this.mState.name();
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        this.debugLog((String)object2);
        this.mReleasedCaptureSessions.put(object, listenableFuture);
        object2 = new Camera2CameraImpl$1(this, (CaptureSession)object);
        object = CameraXExecutors.directExecutor();
        Futures.addCallback(listenableFuture, (FutureCallback)object2, (Executor)object);
        return listenableFuture;
    }

    public void resetCaptureSession(boolean bl2) {
        CaptureSession captureSession;
        boolean bl3;
        CaptureSession captureSession2 = this.mCaptureSession;
        if (captureSession2 != null) {
            bl3 = true;
        } else {
            bl3 = false;
            captureSession2 = null;
        }
        Preconditions.checkState(bl3);
        this.debugLog("Resetting Capture Session");
        captureSession2 = this.mCaptureSession;
        SessionConfig sessionConfig = captureSession2.getSessionConfig();
        List list = captureSession2.getCaptureConfigs();
        this.mCaptureSession = captureSession = new CaptureSession();
        captureSession.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(list);
        this.releaseSession(captureSession2, bl2);
    }

    public /* synthetic */ void s(UseCase useCase) {
        this.r(useCase);
    }

    public void setState(Camera2CameraImpl$InternalState camera2CameraImpl$InternalState) {
        this.setState(camera2CameraImpl$InternalState, true);
    }

    public void setState(Camera2CameraImpl$InternalState object, boolean bl2) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Transitioning camera internal state: ");
        Object object3 = this.mState;
        ((StringBuilder)object2).append(object3);
        object3 = " --> ";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        this.debugLog((String)object2);
        this.mState = object;
        object2 = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
        int n10 = ((Enum)object).ordinal();
        Object object4 = object2[n10];
        switch (object4) {
            default: {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Unknown state: ");
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)object);
                throw illegalStateException;
            }
            case 8: {
                object = CameraInternal$State.RELEASED;
                break;
            }
            case 7: {
                object = CameraInternal$State.RELEASING;
                break;
            }
            case 5: 
            case 6: {
                object = CameraInternal$State.OPENING;
                break;
            }
            case 4: {
                object = CameraInternal$State.OPEN;
                break;
            }
            case 3: {
                object = CameraInternal$State.CLOSING;
                break;
            }
            case 2: {
                object = CameraInternal$State.PENDING_OPEN;
                break;
            }
            case 1: {
                object = CameraInternal$State.CLOSED;
            }
        }
        this.mCameraStateRegistry.markCameraState(this, (CameraInternal$State)((Object)object), bl2);
        this.mObservableState.postValue(object);
    }

    public void submitCaptureRequests(List object) {
        boolean bl2;
        ArrayList<CaptureConfig> arrayList = new ArrayList<CaptureConfig>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            CaptureConfig captureConfig = (CaptureConfig)object.next();
            CaptureConfig$Builder captureConfig$Builder = CaptureConfig$Builder.from(captureConfig);
            List list = captureConfig.getSurfaces();
            boolean bl3 = list.isEmpty();
            if (bl3 && (bl2 = captureConfig.isUseRepeatingSurface()) && !(bl2 = this.checkAndAttachRepeatingSurface(captureConfig$Builder))) continue;
            captureConfig = captureConfig$Builder.build();
            arrayList.add(captureConfig);
        }
        this.debugLog("Issue capture request");
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    public String toString() {
        Locale locale = Locale.US;
        Object object = this.hashCode();
        Object[] objectArray = new Object[]{object, object = this.mCameraInfoInternal.getCameraId()};
        return String.format(locale, "Camera@%x[id=%s]", objectArray);
    }

    public void tryForceOpenCameraDevice() {
        this.debugLog("Attempting to force open the camera.");
        Object object = this.mCameraStateRegistry;
        boolean bl2 = object.tryOpenCamera(this);
        if (!bl2) {
            this.debugLog("No cameras available. Waiting for available camera before opening camera.");
            object = Camera2CameraImpl$InternalState.PENDING_OPEN;
            this.setState((Camera2CameraImpl$InternalState)((Object)object));
            return;
        }
        this.openCameraDevice(false);
    }

    public void tryOpenCameraDevice(boolean bl2) {
        this.debugLog("Attempting to open the camera.");
        Object object = this.mCameraAvailability;
        boolean bl3 = ((Camera2CameraImpl$CameraAvailability)object).isCameraAvailable();
        if (bl3 && (bl3 = ((CameraStateRegistry)(object = this.mCameraStateRegistry)).tryOpenCamera(this))) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        if (!bl3) {
            this.debugLog("No cameras available. Waiting for available camera before opening camera.");
            Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.PENDING_OPEN;
            this.setState(camera2CameraImpl$InternalState);
            return;
        }
        this.openCameraDevice(bl2);
    }

    public /* synthetic */ void u(UseCase useCase) {
        this.t(useCase);
    }

    public void updateCaptureSessionConfig() {
        Object object = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
        boolean bl2 = ((SessionConfig$ValidatingBuilder)object).isValid();
        if (bl2) {
            Object object2 = this.mCameraControlSessionConfig;
            ((SessionConfig$ValidatingBuilder)object).add((SessionConfig)object2);
            object = ((SessionConfig$ValidatingBuilder)object).build();
            object2 = this.mCaptureSession;
            ((CaptureSession)object2).setSessionConfig((SessionConfig)object);
        } else {
            object = this.mCaptureSession;
            SessionConfig sessionConfig = this.mCameraControlSessionConfig;
            ((CaptureSession)object).setSessionConfig(sessionConfig);
        }
    }

    public void updateDefaultRequestBuilderToCameraControl(CameraDevice cameraDevice) {
        Object object = this.mCameraControlInternal;
        int n10 = ((Camera2CameraControlImpl)object).getDefaultTemplate();
        cameraDevice = cameraDevice.createCaptureRequest(n10);
        object = this.mCameraControlInternal;
        try {
            ((Camera2CameraControlImpl)object).setDefaultRequestBuilder((CaptureRequest.Builder)cameraDevice);
        }
        catch (CameraAccessException cameraAccessException) {
            object = TAG;
            String string2 = "fail to create capture request.";
            Logger.e((String)object, string2, cameraAccessException);
        }
    }

    public /* synthetic */ void w(UseCase useCase) {
        this.v(useCase);
    }

    public /* synthetic */ void z(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.y(callbackToFutureAdapter$Completer);
    }
}

