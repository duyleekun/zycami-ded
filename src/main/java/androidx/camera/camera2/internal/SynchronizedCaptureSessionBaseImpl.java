/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CaptureRequest
 *  android.os.Handler
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.CaptureSessionRepository;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl$1;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener$OpenerImpl;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.a.d.a1;
import b.a.a.d.b1;
import b.a.a.d.z0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class SynchronizedCaptureSessionBaseImpl
extends SynchronizedCaptureSession$StateCallback
implements SynchronizedCaptureSession,
SynchronizedCaptureSessionOpener$OpenerImpl {
    private static final String TAG = "SyncCaptureSessionBase";
    public CameraCaptureSessionCompat mCameraCaptureSessionCompat;
    public final CaptureSessionRepository mCaptureSessionRepository;
    public SynchronizedCaptureSession$StateCallback mCaptureSessionStateCallback;
    private boolean mClosed;
    public final Handler mCompatHandler;
    public final Executor mExecutor;
    public final Object mLock;
    public CallbackToFutureAdapter$Completer mOpenCaptureSessionCompleter;
    public ListenableFuture mOpenCaptureSessionFuture;
    private boolean mOpenerDisabled;
    private final ScheduledExecutorService mScheduledExecutorService;
    private ListenableFuture mStartingSurface;

    public SynchronizedCaptureSessionBaseImpl(CaptureSessionRepository captureSessionRepository, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        Object object;
        this.mLock = object = new Object();
        this.mClosed = false;
        this.mOpenerDisabled = false;
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mCompatHandler = handler;
        this.mExecutor = executor;
        this.mScheduledExecutorService = scheduledExecutorService;
    }

    private /* synthetic */ void a(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionRepository.onCaptureSessionClosed(this);
        this.mCaptureSessionStateCallback.onClosed(synchronizedCaptureSession);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Object c(CameraDeviceCompat object, SessionConfigurationCompat object2, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object3 = this.mLock;
        synchronized (object3) {
            boolean bl2;
            CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer2 = this.mOpenCaptureSessionCompleter;
            if (callbackToFutureAdapter$Completer2 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                callbackToFutureAdapter$Completer2 = null;
            }
            String string2 = "The openCaptureSessionCompleter can only set once!";
            Preconditions.checkState(bl2, string2);
            this.mOpenCaptureSessionCompleter = callbackToFutureAdapter$Completer;
            ((CameraDeviceCompat)object).createCaptureSession((SessionConfigurationCompat)object2);
            object = new StringBuilder();
            object2 = "openCaptureSession[session=";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(this);
            object2 = "]";
            ((StringBuilder)object).append((String)object2);
            return ((StringBuilder)object).toString();
        }
    }

    private void debugLog(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Logger.d(TAG, string2);
    }

    private /* synthetic */ ListenableFuture e(List object, List object2) {
        this.debugLog("getSurface...done");
        boolean bl2 = object2.contains(null);
        if (bl2) {
            int n10 = object2.indexOf(null);
            object = (DeferrableSurface)object.get(n10);
            object2 = new DeferrableSurface$SurfaceClosedException("Surface closed", (DeferrableSurface)object);
            return Futures.immediateFailedFuture((Throwable)object2);
        }
        boolean bl3 = object2.isEmpty();
        if (bl3) {
            object = new IllegalArgumentException("Unable to open capture session without surfaces");
            return Futures.immediateFailedFuture((Throwable)object);
        }
        return Futures.immediateFuture(object2);
    }

    public void abortCaptures() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().abortCaptures();
    }

    public /* synthetic */ void b(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.a(synchronizedCaptureSession);
    }

    public int captureBurstRequests(List list, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        CameraCaptureSessionCompat cameraCaptureSessionCompat = this.mCameraCaptureSessionCompat;
        Executor executor = this.getExecutor();
        return cameraCaptureSessionCompat.captureBurstRequests(list, executor, captureCallback);
    }

    public int captureBurstRequests(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureBurstRequests(list, executor, captureCallback);
    }

    public int captureSingleRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        CameraCaptureSessionCompat cameraCaptureSessionCompat = this.mCameraCaptureSessionCompat;
        Executor executor = this.getExecutor();
        return cameraCaptureSessionCompat.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    public int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    public void close() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCaptureSessionRepository.onCaptureSessionClosing(this);
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().close();
    }

    public void createCaptureSessionCompat(CameraCaptureSession object) {
        CameraCaptureSessionCompat cameraCaptureSessionCompat = this.mCameraCaptureSessionCompat;
        if (cameraCaptureSessionCompat == null) {
            cameraCaptureSessionCompat = this.mCompatHandler;
            object = CameraCaptureSessionCompat.toCameraCaptureSessionCompat(object, (Handler)cameraCaptureSessionCompat);
            this.mCameraCaptureSessionCompat = object;
        }
    }

    public SessionConfigurationCompat createSessionConfigurationCompat(int n10, List list, SynchronizedCaptureSession$StateCallback object) {
        this.mCaptureSessionStateCallback = object;
        Executor executor = this.getExecutor();
        SynchronizedCaptureSessionBaseImpl$1 synchronizedCaptureSessionBaseImpl$1 = new SynchronizedCaptureSessionBaseImpl$1(this);
        object = new SessionConfigurationCompat(n10, list, executor, synchronizedCaptureSessionBaseImpl$1);
        return object;
    }

    public /* synthetic */ Object d(CameraDeviceCompat cameraDeviceCompat, SessionConfigurationCompat sessionConfigurationCompat, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.c(cameraDeviceCompat, sessionConfigurationCompat, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ ListenableFuture f(List list, List list2) {
        return this.e(list, list2);
    }

    public CameraDevice getDevice() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        return this.mCameraCaptureSessionCompat.toCameraCaptureSession().getDevice();
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public SynchronizedCaptureSession$StateCallback getStateCallback() {
        return this;
    }

    public ListenableFuture getSynchronizedBlocker(String string2) {
        return Futures.immediateFuture(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isCameraCaptureSessionOpen() {
        Object object = this.mLock;
        synchronized (object) {
            ListenableFuture listenableFuture = this.mOpenCaptureSessionFuture;
            if (listenableFuture == null) return false;
            return true;
        }
    }

    public void onActive(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionStateCallback.onActive(synchronizedCaptureSession);
    }

    public void onCaptureQueueEmpty(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionStateCallback.onCaptureQueueEmpty(synchronizedCaptureSession);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onClosed(SynchronizedCaptureSession object) {
        ListenableFuture listenableFuture;
        Object object2 = this.mLock;
        synchronized (object2) {
            boolean bl2 = this.mClosed;
            if (bl2) return;
            this.mClosed = bl2 = true;
            listenableFuture = this.mOpenCaptureSessionFuture;
            String string2 = "Need to call openCaptureSession before using this API.";
            Preconditions.checkNotNull(listenableFuture, string2);
            listenableFuture = this.mOpenCaptureSessionFuture;
        }
        if (listenableFuture == null) return;
        object2 = new b1(this, (SynchronizedCaptureSession)object);
        object = CameraXExecutors.directExecutor();
        listenableFuture.addListener((Runnable)object2, (Executor)object);
    }

    public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionRepository.onCaptureSessionConfigureFail(this);
        this.mCaptureSessionStateCallback.onConfigureFailed(synchronizedCaptureSession);
    }

    public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionRepository.onCaptureSessionCreated(this);
        this.mCaptureSessionStateCallback.onConfigured(synchronizedCaptureSession);
    }

    public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.mCaptureSessionStateCallback.onReady(synchronizedCaptureSession);
    }

    public void onSurfacePrepared(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        this.mCaptureSessionStateCallback.onSurfacePrepared(synchronizedCaptureSession, surface);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture openCaptureSession(CameraDevice object, SessionConfigurationCompat object2) {
        Object object3 = this.mLock;
        synchronized (object3) {
            boolean bl2 = this.mOpenerDisabled;
            if (bl2) {
                object2 = "Opener is disabled";
                object = new CancellationException((String)object2);
                return Futures.immediateFailedFuture((Throwable)object);
            }
            Object object4 = this.mCaptureSessionRepository;
            ((CaptureSessionRepository)object4).onCreateCaptureSession(this);
            object4 = this.mCompatHandler;
            object = CameraDeviceCompat.toCameraDeviceCompat(object, (Handler)object4);
            object4 = new z0(this, (CameraDeviceCompat)object, (SessionConfigurationCompat)object2);
            object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object4);
            this.mOpenCaptureSessionFuture = object;
            return Futures.nonCancellationPropagating((ListenableFuture)object);
        }
    }

    public int setRepeatingBurstRequests(List list, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        CameraCaptureSessionCompat cameraCaptureSessionCompat = this.mCameraCaptureSessionCompat;
        Executor executor = this.getExecutor();
        return cameraCaptureSessionCompat.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    public int setRepeatingBurstRequests(List list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        CameraCaptureSessionCompat cameraCaptureSessionCompat = this.mCameraCaptureSessionCompat;
        Executor executor = this.getExecutor();
        return cameraCaptureSessionCompat.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        return this.mCameraCaptureSessionCompat.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture startWithDeferrableSurface(List object, long l10) {
        Object object2 = this.mLock;
        synchronized (object2) {
            boolean bl2 = this.mOpenerDisabled;
            if (bl2) {
                String string2 = "Opener is disabled";
                object = new CancellationException(string2);
                return Futures.immediateFailedFuture((Throwable)object);
            }
            Executor executor = this.getExecutor();
            ScheduledExecutorService scheduledExecutorService = this.mScheduledExecutorService;
            ListenableFuture listenableFuture = DeferrableSurfaces.surfaceListWithTimeout((Collection)object, false, l10, executor, scheduledExecutorService);
            listenableFuture = FutureChain.from(listenableFuture);
            a1 a12 = new a1(this, (List)object);
            object = this.getExecutor();
            this.mStartingSurface = object = ((FutureChain)listenableFuture).transformAsync(a12, (Executor)object);
            return Futures.nonCancellationPropagating((ListenableFuture)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean stop() {
        boolean bl2;
        Future future;
        boolean bl3;
        block9: {
            bl3 = true;
            future = null;
            try {
                ListenableFuture listenableFuture;
                Object object = this.mLock;
                // MONITORENTER : object
                bl2 = this.mOpenerDisabled;
                if (!bl2) {
                    listenableFuture = this.mStartingSurface;
                    if (listenableFuture != null) {
                        future = listenableFuture;
                    }
                    this.mOpenerDisabled = bl3;
                }
                if (!(bl2 = this.isCameraCaptureSessionOpen())) {
                    bl2 = bl3;
                    break block9;
                }
                bl2 = false;
                listenableFuture = null;
            }
            catch (Throwable throwable) {
                if (future == null) throw throwable;
                future.cancel(bl3);
                throw throwable;
            }
        }
        // MONITOREXIT : object
        if (future == null) return bl2;
        future.cancel(bl3);
        return bl2;
    }

    public void stopRepeating() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat, "Need to call openCaptureSession before using this API.");
        this.mCameraCaptureSessionCompat.toCameraCaptureSession().stopRepeating();
    }

    public CameraCaptureSessionCompat toCameraCaptureSessionCompat() {
        Preconditions.checkNotNull(this.mCameraCaptureSessionCompat);
        return this.mCameraCaptureSessionCompat;
    }
}

