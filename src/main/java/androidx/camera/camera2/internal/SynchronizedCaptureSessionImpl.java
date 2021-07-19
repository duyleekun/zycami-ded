/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CaptureRequest
 *  android.os.Handler
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.CaptureSessionRepository;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl$1;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import b.a.a.d.c1;
import b.a.a.d.d1;
import b.a.a.d.f1;
import b.a.a.d.g1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public class SynchronizedCaptureSessionImpl
extends SynchronizedCaptureSessionBaseImpl {
    private static final String TAG = "SyncCaptureSessionImpl";
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;
    public CallbackToFutureAdapter$Completer mClosingDeferrableSurfaceCompleter;
    private final ListenableFuture mClosingDeferrableSurfaceFuture;
    private List mDeferrableSurfaces;
    private final Set mEnabledFeature;
    private boolean mHasSubmittedRepeating;
    private final Object mObjectLock;
    public ListenableFuture mOpeningCaptureSession;
    public CallbackToFutureAdapter$Completer mStartStreamingCompleter;
    private final ListenableFuture mStartStreamingFuture;
    public ListenableFuture mStartingSurface;

    public SynchronizedCaptureSessionImpl(Set object, CaptureSessionRepository object2, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        super((CaptureSessionRepository)object2, executor, scheduledExecutorService, handler);
        this.mObjectLock = object2 = new Object();
        object2 = new SynchronizedCaptureSessionImpl$1(this);
        this.mCaptureCallback = object2;
        this.mEnabledFeature = object;
        object2 = "wait_for_request";
        boolean bl2 = object.contains(object2);
        executor = null;
        if (bl2) {
            object2 = new g1(this);
            object2 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object2);
            this.mStartStreamingFuture = object2;
        } else {
            object2 = Futures.immediateFuture(null);
            this.mStartStreamingFuture = object2;
        }
        object2 = "deferrableSurface_close";
        boolean bl3 = object.contains(object2);
        if (bl3) {
            object = new c1(this);
            this.mClosingDeferrableSurfaceFuture = object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
        } else {
            this.mClosingDeferrableSurfaceFuture = object = Futures.immediateFuture(null);
        }
    }

    public static void forceOnClosed(Set object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            SynchronizedCaptureSession synchronizedCaptureSession = (SynchronizedCaptureSession)object.next();
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = synchronizedCaptureSession.getStateCallback();
            synchronizedCaptureSession$StateCallback.onClosed(synchronizedCaptureSession);
        }
    }

    private void forceOnConfigureFailed(Set object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            SynchronizedCaptureSession synchronizedCaptureSession = (SynchronizedCaptureSession)object.next();
            SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback = synchronizedCaptureSession.getStateCallback();
            synchronizedCaptureSession$StateCallback.onConfigureFailed(synchronizedCaptureSession);
        }
    }

    private /* synthetic */ void g() {
        this.debugLog("Session call super.close()");
        super.close();
    }

    private List getBlockerFuture(String string2, List object) {
        boolean bl2;
        ArrayList<ListenableFuture> arrayList = new ArrayList<ListenableFuture>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            ListenableFuture listenableFuture = ((SynchronizedCaptureSession)object.next()).getSynchronizedBlocker(string2);
            arrayList.add(listenableFuture);
        }
        return arrayList;
    }

    private /* synthetic */ Object i(CallbackToFutureAdapter$Completer object) {
        this.mStartStreamingCompleter = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("StartStreamingFuture[session=");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    private /* synthetic */ Object k(CallbackToFutureAdapter$Completer object) {
        this.mClosingDeferrableSurfaceCompleter = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("ClosingDeferrableSurfaceFuture[session=");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    private /* synthetic */ ListenableFuture m(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        return super.openCaptureSession(cameraDevice, sessionConfigurationCompat);
    }

    private /* synthetic */ ListenableFuture o(List list, long l10, List list2) {
        return super.startWithDeferrableSurface(list, l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        this.debugLog("Session call close()");
        Object object = this.mEnabledFeature;
        Object object2 = "wait_for_request";
        boolean bl2 = object.contains(object2);
        if (bl2) {
            object = this.mObjectLock;
            synchronized (object) {
                boolean bl3 = this.mHasSubmittedRepeating;
                if (!bl3) {
                    object2 = this.mStartStreamingFuture;
                    boolean bl4 = true;
                    object2.cancel(bl4);
                }
            }
        }
        object = this.mStartStreamingFuture;
        object2 = new d1(this);
        Executor executor = this.getExecutor();
        object.addListener((Runnable)object2, executor);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void closeConfiguredDeferrableSurfaces() {
        Object object = this.mObjectLock;
        synchronized (object) {
            Object object2 = this.mDeferrableSurfaces;
            if (object2 == null) {
                object2 = "deferrableSurface == null, maybe forceClose, skip close";
                this.debugLog((String)object2);
                return;
            }
            object2 = this.mEnabledFeature;
            Object object3 = "deferrableSurface_close";
            boolean bl2 = object2.contains(object3);
            if (bl2) {
                boolean bl3;
                object2 = this.mDeferrableSurfaces;
                object2 = object2.iterator();
                while (bl3 = object2.hasNext()) {
                    object3 = object2.next();
                    object3 = (DeferrableSurface)object3;
                    ((DeferrableSurface)object3).close();
                }
                object2 = "deferrableSurface closed";
                this.debugLog((String)object2);
                this.stopDeferrableSurface();
            }
            return;
        }
    }

    public void debugLog(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Logger.d(TAG, string2);
    }

    public ListenableFuture getSynchronizedBlocker(String string2) {
        string2.hashCode();
        String string3 = "wait_for_request";
        boolean bl2 = string2.equals(string3);
        if (!bl2) {
            string3 = "deferrableSurface_close";
            bl2 = string2.equals(string3);
            if (!bl2) {
                return super.getSynchronizedBlocker(string2);
            }
            return Futures.nonCancellationPropagating(this.mClosingDeferrableSurfaceFuture);
        }
        return Futures.nonCancellationPropagating(this.mStartStreamingFuture);
    }

    public /* synthetic */ void h() {
        this.g();
    }

    public /* synthetic */ Object j(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.i(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ Object l(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.k(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ ListenableFuture n(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        return this.m(cameraDevice, sessionConfigurationCompat, list);
    }

    public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.closeConfiguredDeferrableSurfaces();
        this.debugLog("onClosed()");
        super.onClosed(synchronizedCaptureSession);
    }

    public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        Object object;
        this.debugLog("Session onConfigured()");
        Set<Object> set = this.mEnabledFeature;
        Object object2 = "force_close";
        boolean bl2 = set.contains(object2);
        if (bl2) {
            SynchronizedCaptureSession synchronizedCaptureSession2;
            boolean bl3;
            set = new Set<Object>();
            object = this.mCaptureSessionRepository.getCreatingCaptureSessions().iterator();
            while ((bl3 = object.hasNext()) && (synchronizedCaptureSession2 = (SynchronizedCaptureSession)object.next()) != synchronizedCaptureSession) {
                set.add(synchronizedCaptureSession2);
            }
            this.forceOnConfigureFailed(set);
        }
        super.onConfigured(synchronizedCaptureSession);
        set = this.mEnabledFeature;
        bl2 = set.contains(object2);
        if (bl2) {
            boolean bl4;
            set = new Set<Object>();
            object2 = this.mCaptureSessionRepository.getCaptureSessions().iterator();
            while ((bl4 = object2.hasNext()) && (object = (SynchronizedCaptureSession)object2.next()) != synchronizedCaptureSession) {
                set.add(object);
            }
            SynchronizedCaptureSessionImpl.forceOnClosed(set);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture openCaptureSession(CameraDevice object, SessionConfigurationCompat sessionConfigurationCompat) {
        Object object2 = this.mObjectLock;
        synchronized (object2) {
            Object object3 = "wait_for_request";
            Object object4 = this.mCaptureSessionRepository;
            object4 = ((CaptureSessionRepository)object4).getClosingCaptureSession();
            object3 = this.getBlockerFuture((String)object3, (List)object4);
            object3 = Futures.successfulAsList((Collection)object3);
            object3 = FutureChain.from((ListenableFuture)object3);
            object4 = new f1(this, (CameraDevice)object, sessionConfigurationCompat);
            object = CameraXExecutors.directExecutor();
            object = ((FutureChain)object3).transformAsync((AsyncFunction)object4, (Executor)object);
            this.mOpeningCaptureSession = object;
            return Futures.nonCancellationPropagating((ListenableFuture)object);
        }
    }

    public /* synthetic */ ListenableFuture p(List list, long l10, List list2) {
        return this.o(list, l10, list2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int setSingleRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        Object object = this.mEnabledFeature;
        String string2 = "wait_for_request";
        boolean bl2 = object.contains(string2);
        if (!bl2) return super.setSingleRepeatingRequest(captureRequest, captureCallback);
        object = this.mObjectLock;
        synchronized (object) {
            CameraCaptureSession.CaptureCallback captureCallback2;
            int n10 = 1;
            this.mHasSubmittedRepeating = n10;
            int n11 = 2;
            CameraCaptureSession.CaptureCallback[] captureCallbackArray = new CameraCaptureSession.CaptureCallback[n11];
            captureCallbackArray[0] = captureCallback2 = this.mCaptureCallback;
            captureCallbackArray[n10] = captureCallback;
            captureCallback = Camera2CaptureCallbacks.createComboCallback(captureCallbackArray);
            return super.setSingleRepeatingRequest(captureRequest, captureCallback);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture startWithDeferrableSurface(List object, long l10) {
        Object object2 = this.mObjectLock;
        synchronized (object2) {
            this.mDeferrableSurfaces = object;
            Object object3 = Collections.emptyList();
            ArrayList<Object> arrayList = this.mEnabledFeature;
            Object object4 = "force_close";
            boolean bl2 = arrayList.contains(object4);
            if (bl2) {
                boolean bl3;
                object3 = this.mCaptureSessionRepository;
                object3 = ((CaptureSessionRepository)object3).registerDeferrableSurface(this, (List)object);
                arrayList = new ArrayList<Object>();
                object3 = object3.entrySet();
                object3 = object3.iterator();
                while (bl3 = object3.hasNext()) {
                    object4 = object3.next();
                    Object object5 = (object4 = (Map.Entry)object4).getKey();
                    if (object5 == this) continue;
                    object5 = object4.getValue();
                    List list = this.mDeferrableSurfaces;
                    boolean bl4 = Collections.disjoint(object5 = (Collection)object5, list);
                    if (bl4) continue;
                    object4 = object4.getKey();
                    object4 = (SynchronizedCaptureSession)object4;
                    arrayList.add(object4);
                }
                object3 = "deferrableSurface_close";
                object3 = this.getBlockerFuture((String)object3, arrayList);
            }
            object3 = Futures.successfulAsList(object3);
            object3 = FutureChain.from((ListenableFuture)object3);
            arrayList = new ArrayList<Object>(this, (List)object, l10);
            object = this.getExecutor();
            this.mStartingSurface = object = ((FutureChain)object3).transformAsync((AsyncFunction)((Object)arrayList), (Executor)object);
            return Futures.nonCancellationPropagating((ListenableFuture)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean stop() {
        Object object = this.mObjectLock;
        synchronized (object) {
            boolean bl2 = this.isCameraCaptureSessionOpen();
            if (bl2) {
                this.closeConfiguredDeferrableSurfaces();
                return super.stop();
            } else {
                ListenableFuture listenableFuture = this.mOpeningCaptureSession;
                boolean bl3 = true;
                if (listenableFuture != null) {
                    listenableFuture.cancel(bl3);
                }
                if ((listenableFuture = this.mStartingSurface) != null) {
                    listenableFuture.cancel(bl3);
                }
                this.stopDeferrableSurface();
            }
            return super.stop();
        }
    }

    public void stopDeferrableSurface() {
        Object object = this.mEnabledFeature;
        String string2 = "deferrableSurface_close";
        boolean bl2 = object.contains(string2);
        if (bl2) {
            this.mCaptureSessionRepository.unregisterDeferrableSurface(this);
            object = this.mClosingDeferrableSurfaceCompleter;
            if (object != null) {
                string2 = null;
                ((CallbackToFutureAdapter$Completer)object).set(null);
            }
        }
    }
}

