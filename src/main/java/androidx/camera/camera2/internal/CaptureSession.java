/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraAccessException
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CaptureRequest
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.impl.CameraEventCallbacks;
import androidx.camera.camera2.impl.CameraEventCallbacks$ComboCameraEventCallback;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.Camera2CaptureRequestBuilder;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback$CaptureSequenceCallback;
import androidx.camera.camera2.internal.CaptureCallbackConverter;
import androidx.camera.camera2.internal.CaptureSession$2;
import androidx.camera.camera2.internal.CaptureSession$3;
import androidx.camera.camera2.internal.CaptureSession$State;
import androidx.camera.camera2.internal.CaptureSession$StateCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionStateCallbacks$Adapter;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurface$SurfaceClosedException;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.a.d.g0;
import b.a.a.d.h0;
import b.a.a.d.i0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class CaptureSession {
    private static final String TAG = "CaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000L;
    public CameraEventCallbacks mCameraEventCallbacks;
    public volatile Config mCameraEventOnRepeatingOptions;
    private final CameraCaptureSession.CaptureCallback mCaptureCallback;
    private final List mCaptureConfigs;
    private final CaptureSession$StateCallback mCaptureSessionStateCallback;
    public List mConfiguredDeferrableSurfaces;
    private Map mConfiguredSurfaceMap;
    public CallbackToFutureAdapter$Completer mReleaseCompleter;
    public ListenableFuture mReleaseFuture;
    public volatile SessionConfig mSessionConfig;
    public CaptureSession$State mState;
    public final Object mStateLock;
    public final StillCaptureFlow mStillCaptureFlow;
    public SynchronizedCaptureSession mSynchronizedCaptureSession;
    public SynchronizedCaptureSessionOpener mSynchronizedCaptureSessionOpener;

    public CaptureSession() {
        Object object = new Object();
        this.mStateLock = object;
        this.mCaptureConfigs = object = new Object();
        super(this);
        this.mCaptureCallback = object;
        object = OptionsBundle.emptyBundle();
        this.mCameraEventOnRepeatingOptions = object;
        object = CameraEventCallbacks.createEmptyCallback();
        this.mCameraEventCallbacks = object;
        super();
        this.mConfiguredSurfaceMap = object;
        this.mConfiguredDeferrableSurfaces = object = Collections.emptyList();
        object = CaptureSession$State.UNINITIALIZED;
        this.mState = object;
        super();
        this.mStillCaptureFlow = object;
        object = CaptureSession$State.INITIALIZED;
        this.mState = object;
        super(this);
        this.mCaptureSessionStateCallback = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void a(CameraCaptureSession object, int n10, boolean bl2) {
        object = this.mStateLock;
        synchronized (object) {
            CaptureSession$State captureSession$State = this.mState;
            CaptureSession$State captureSession$State2 = CaptureSession$State.OPENED;
            if (captureSession$State == captureSession$State2) {
                this.issueRepeatingCaptureRequests();
            }
            return;
        }
    }

    private /* synthetic */ ListenableFuture c(SessionConfig sessionConfig, CameraDevice cameraDevice, List list) {
        return this.openCaptureSession(list, sessionConfig, cameraDevice);
    }

    private CameraCaptureSession.CaptureCallback createCamera2CaptureCallback(List object, CameraCaptureSession.CaptureCallback ... captureCallbackArray) {
        int n10 = object.size();
        int n11 = captureCallbackArray.length;
        ArrayList<CameraCaptureSession.CaptureCallback> arrayList = new ArrayList<CameraCaptureSession.CaptureCallback>(n10 += n11);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            CameraCaptureSession.CaptureCallback captureCallback = CaptureCallbackConverter.toCaptureCallback((CameraCaptureCallback)object.next());
            arrayList.add(captureCallback);
        }
        Collections.addAll(arrayList, captureCallbackArray);
        return Camera2CaptureCallbacks.createComboCallback(arrayList);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Object e(CallbackToFutureAdapter$Completer object) {
        Object object2 = this.mStateLock;
        synchronized (object2) {
            boolean bl2;
            Object object3 = this.mReleaseCompleter;
            if (object3 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object3 = null;
            }
            String string2 = "Release completer expected to be null";
            Preconditions.checkState(bl2, string2);
            this.mReleaseCompleter = object;
            object = new StringBuilder();
            object3 = "Release[session=";
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(this);
            object3 = "]";
            ((StringBuilder)object).append((String)object3);
            return ((StringBuilder)object).toString();
        }
    }

    private static Config mergeOptions(List object) {
        boolean bl2;
        MutableOptionsBundle mutableOptionsBundle = MutableOptionsBundle.create();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Config config = ((CaptureConfig)object.next()).getImplementationOptions();
            Iterator iterator2 = config.listOptions().iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object2 = (Config$Option)iterator2.next();
                Object object3 = null;
                Object object4 = config.retrieveOption((Config$Option)object2, null);
                boolean bl4 = mutableOptionsBundle.containsOption((Config$Option)object2);
                if (bl4) {
                    object3 = mutableOptionsBundle.retrieveOption((Config$Option)object2, null);
                    bl4 = Objects.equals(object3, object4);
                    if (bl4) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string2 = "Detect conflicting option ";
                    stringBuilder.append(string2);
                    object2 = ((Config$Option)object2).getId();
                    stringBuilder.append((String)object2);
                    stringBuilder.append(" : ");
                    stringBuilder.append(object4);
                    stringBuilder.append(" != ");
                    stringBuilder.append(object3);
                    object2 = stringBuilder.toString();
                    object3 = TAG;
                    Logger.d((String)object3, (String)object2);
                    continue;
                }
                mutableOptionsBundle.insertOption((Config$Option)object2, object4);
            }
        }
        return mutableOptionsBundle;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ListenableFuture openCaptureSession(List object, SessionConfig object2, CameraDevice object3) {
        Object object4 = this.mStateLock;
        synchronized (object4) {
            int n10;
            Object object5 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object6 = this.mState;
            int n11 = ((Enum)object6).ordinal();
            int n12 = object5[n11];
            n11 = 1;
            if (n12 != n11 && n12 != (n10 = 2)) {
                int n13 = 3;
                if (n12 != n13) {
                    int n14 = 5;
                    if (n12 != n14) {
                        object2 = new StringBuilder();
                        object3 = "openCaptureSession() not execute in state: ";
                        ((StringBuilder)object2).append((String)object3);
                        object3 = this.mState;
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object = new CancellationException((String)object2);
                        return Futures.immediateFailedFuture((Throwable)object);
                    }
                } else {
                    Object object7;
                    Object object8;
                    int n15;
                    try {
                        object5 = this.mConfiguredDeferrableSurfaces;
                        DeferrableSurfaces.incrementAll((List)object5);
                    }
                    catch (DeferrableSurface$SurfaceClosedException deferrableSurface$SurfaceClosedException) {
                        object2 = this.mConfiguredDeferrableSurfaces;
                        object2.clear();
                        return Futures.immediateFailedFuture(deferrableSurface$SurfaceClosedException);
                    }
                    object5 = this.mConfiguredSurfaceMap;
                    object5.clear();
                    n12 = 0;
                    object5 = null;
                    Surface surface = null;
                    for (n13 = 0; n13 < (n15 = object.size()); ++n13) {
                        object8 = this.mConfiguredSurfaceMap;
                        Object object9 = this.mConfiguredDeferrableSurfaces;
                        object9 = object9.get(n13);
                        object9 = (DeferrableSurface)object9;
                        Object object10 = object.get(n13);
                        object10 = (Surface)object10;
                        object8.put(object9, object10);
                    }
                    object8 = new HashSet(object);
                    surface = new ArrayList(object8);
                    object = CaptureSession$State.OPENING;
                    this.mState = object;
                    object = TAG;
                    object8 = "Opening capture session.";
                    Logger.d((String)object, (String)object8);
                    object = new SynchronizedCaptureSession$StateCallback[n10];
                    object[0] = object7 = this.mCaptureSessionStateCallback;
                    object8 = ((SessionConfig)object2).getSessionStateCallbacks();
                    object[n11] = object7 = new SynchronizedCaptureSessionStateCallbacks$Adapter((List)object8);
                    object = SynchronizedCaptureSessionStateCallbacks.createComboCallback((SynchronizedCaptureSession$StateCallback[])object);
                    object6 = ((SessionConfig)object2).getImplementationOptions();
                    object7 = new Camera2ImplConfig((Config)object6);
                    object6 = CameraEventCallbacks.createEmptyCallback();
                    object6 = ((Camera2ImplConfig)object7).getCameraEventCallback((CameraEventCallbacks)object6);
                    this.mCameraEventCallbacks = object6;
                    object6 = ((CameraEventCallbacks)object6).createComboCallback();
                    object6 = ((CameraEventCallbacks$ComboCameraEventCallback)object6).onPresetSession();
                    object2 = ((SessionConfig)object2).getRepeatingCaptureConfig();
                    object2 = CaptureConfig$Builder.from((CaptureConfig)object2);
                    object6 = object6.iterator();
                    while ((n10 = (int)(object6.hasNext() ? 1 : 0)) != 0) {
                        object7 = object6.next();
                        object7 = (CaptureConfig)object7;
                        object7 = ((CaptureConfig)object7).getImplementationOptions();
                        ((CaptureConfig$Builder)object2).addImplementationOptions((Config)object7);
                    }
                    object6 = new ArrayList();
                    object7 = surface.iterator();
                    while ((n13 = (int)(object7.hasNext() ? 1 : 0)) != 0) {
                        surface = object7.next();
                        surface = surface;
                        object8 = new OutputConfigurationCompat(surface);
                        object6.add(object8);
                    }
                    object7 = this.mSynchronizedCaptureSessionOpener;
                    object = ((SynchronizedCaptureSessionOpener)object7).createSessionConfigurationCompat(0, (List)object6, (SynchronizedCaptureSession$StateCallback)object);
                    try {
                        object2 = ((CaptureConfig$Builder)object2).build();
                        object2 = Camera2CaptureRequestBuilder.buildWithoutTarget((CaptureConfig)object2, object3);
                        if (object2 != null) {
                            ((SessionConfigurationCompat)object).setSessionParameters((CaptureRequest)object2);
                        }
                        object2 = this.mSynchronizedCaptureSessionOpener;
                        return ((SynchronizedCaptureSessionOpener)object2).openCaptureSession((CameraDevice)object3, (SessionConfigurationCompat)object);
                    }
                    catch (CameraAccessException cameraAccessException) {
                        return Futures.immediateFailedFuture(cameraAccessException);
                    }
                }
            }
            object2 = new StringBuilder();
            object3 = "openCaptureSession() should not be possible in state: ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.mState;
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalStateException((String)object2);
            return Futures.immediateFailedFuture((Throwable)object);
        }
    }

    public /* synthetic */ void b(CameraCaptureSession cameraCaptureSession, int n10, boolean bl2) {
        this.a(cameraCaptureSession, n10, bl2);
    }

    public void cancelIssuedCaptureRequests() {
        Object object = this.mCaptureConfigs;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            boolean bl3;
            object = this.mCaptureConfigs.iterator();
            while (bl3 = object.hasNext()) {
                boolean bl4;
                Iterator iterator2 = ((CaptureConfig)object.next()).getCameraCaptureCallbacks().iterator();
                while (bl4 = iterator2.hasNext()) {
                    CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)iterator2.next();
                    cameraCaptureCallback.onCaptureCancelled();
                }
            }
            object = this.mCaptureConfigs;
            object.clear();
        }
    }

    public void clearConfiguredSurfaces() {
        DeferrableSurfaces.decrementAll(this.mConfiguredDeferrableSurfaces);
        this.mConfiguredDeferrableSurfaces.clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object = this.mStateLock;
        synchronized (object) {
            block11: {
                Object object2;
                block8: {
                    Object object3;
                    block9: {
                        Object object4;
                        int n10;
                        block10: {
                            object2 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
                            object3 = this.mState;
                            int n11 = ((Enum)object3).ordinal();
                            n10 = object2[n11];
                            n11 = 1;
                            if (n10 == n11) {
                                object2 = new IllegalStateException;
                                object3 = new StringBuilder();
                                Object object5 = "close() should not be possible in state: ";
                                ((StringBuilder)object3).append((String)object5);
                                object5 = this.mState;
                                ((StringBuilder)object3).append(object5);
                                object3 = ((StringBuilder)object3).toString();
                                object2((String)object3);
                                throw object2;
                            }
                            n11 = 2;
                            if (n10 == n11) break block8;
                            n11 = 3;
                            if (n10 == n11) break block9;
                            n11 = 4;
                            if (n10 == n11) break block10;
                            n11 = 5;
                            if (n10 != n11) break block11;
                            object2 = this.mSessionConfig;
                            if (object2 != null) {
                                object2 = this.mCameraEventCallbacks;
                                object2 = object2.createComboCallback();
                                n11 = (object2 = object2.onDisableSession()).isEmpty() ? 1 : 0;
                                if (n11 == 0) {
                                    try {
                                        object2 = this.setupConfiguredSurface((List)object2);
                                        this.issueCaptureRequests((List)object2);
                                    }
                                    catch (IllegalStateException illegalStateException) {
                                        object3 = TAG;
                                        object4 = "Unable to issue the request before close the capture session";
                                        Logger.e((String)object3, object4, illegalStateException);
                                    }
                                }
                            }
                        }
                        object2 = this.mSynchronizedCaptureSessionOpener;
                        object3 = new StringBuilder();
                        object4 = "The Opener shouldn't null in state:";
                        ((StringBuilder)object3).append((String)object4);
                        object4 = this.mState;
                        ((StringBuilder)object3).append(object4);
                        object3 = ((StringBuilder)object3).toString();
                        Preconditions.checkNotNull(object2, object3);
                        object2 = this.mSynchronizedCaptureSessionOpener;
                        object2.stop();
                        object2 = CaptureSession$State.CLOSED;
                        this.mState = (CaptureSession$State)((Object)object2);
                        n10 = 0;
                        object2 = null;
                        this.mSessionConfig = null;
                        break block11;
                    }
                    object2 = this.mSynchronizedCaptureSessionOpener;
                    object3 = new StringBuilder();
                    Object object6 = "The Opener shouldn't null in state:";
                    ((StringBuilder)object3).append((String)object6);
                    object6 = this.mState;
                    ((StringBuilder)object3).append(object6);
                    object3 = ((StringBuilder)object3).toString();
                    Preconditions.checkNotNull(object2, object3);
                    object2 = this.mSynchronizedCaptureSessionOpener;
                    object2.stop();
                }
                object2 = (Object)CaptureSession$State.RELEASED;
                this.mState = (CaptureSession$State)((Object)object2);
            }
            return;
        }
    }

    public /* synthetic */ ListenableFuture d(SessionConfig sessionConfig, CameraDevice cameraDevice, List list) {
        return this.c(sessionConfig, cameraDevice, list);
    }

    public /* synthetic */ Object f(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.e(callbackToFutureAdapter$Completer);
    }

    public void finishClose() {
        CaptureSession$State captureSession$State = this.mState;
        Object object = CaptureSession$State.RELEASED;
        if (captureSession$State == object) {
            Logger.d(TAG, "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.mState = object;
        captureSession$State = null;
        this.mSynchronizedCaptureSession = null;
        this.clearConfiguredSurfaces();
        object = this.mReleaseCompleter;
        if (object != null) {
            ((CallbackToFutureAdapter$Completer)object).set(null);
            this.mReleaseCompleter = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getCaptureConfigs() {
        Object object = this.mStateLock;
        synchronized (object) {
            List list = this.mCaptureConfigs;
            return Collections.unmodifiableList(list);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SessionConfig getSessionConfig() {
        Object object = this.mStateLock;
        synchronized (object) {
            return this.mSessionConfig;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CaptureSession$State getState() {
        Object object = this.mStateLock;
        synchronized (object) {
            return this.mState;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void issueBurstCaptureRequest(List object) {
        String string2 = TAG;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return;
        }
        try {
            boolean bl3;
            CameraBurstCaptureCallback cameraBurstCaptureCallback = new CameraBurstCaptureCallback();
            ArrayList<Object> arrayList = new ArrayList<Object>();
            String string3 = "Issuing capture request.";
            Logger.d(string2, string3);
            object = object.iterator();
            string3 = null;
            int n10 = 0;
            while (bl3 = object.hasNext()) {
                int n11;
                int n12;
                Object object2;
                int n13;
                Object object3;
                Object object4;
                block13: {
                    block12: {
                        Object object5;
                        boolean bl4;
                        object4 = object.next();
                        object3 = ((CaptureConfig)(object4 = (CaptureConfig)object4)).getSurfaces();
                        n13 = object3.isEmpty();
                        if (n13 != 0) {
                            object4 = "Skipping issuing empty capture request.";
                            Logger.d(string2, (String)object4);
                            continue;
                        }
                        object3 = ((CaptureConfig)object4).getSurfaces();
                        object3 = object3.iterator();
                        do {
                            n12 = object3.hasNext();
                            n11 = 1;
                            if (n12 == 0) break block12;
                            object2 = object3.next();
                        } while (bl4 = (object5 = this.mConfiguredSurfaceMap).containsKey(object2 = (DeferrableSurface)object2));
                        object3 = new StringBuilder();
                        object5 = "Skipping capture request with invalid surface: ";
                        ((StringBuilder)object3).append((String)object5);
                        ((StringBuilder)object3).append(object2);
                        object3 = ((StringBuilder)object3).toString();
                        Logger.d(string2, (String)object3);
                        n13 = 0;
                        object3 = null;
                        break block13;
                    }
                    n13 = n11;
                }
                if (n13 == 0) continue;
                n13 = ((CaptureConfig)object4).getTemplateType();
                if (n13 == (n12 = 2)) {
                    n10 = n11;
                }
                object3 = CaptureConfig$Builder.from((CaptureConfig)object4);
                object2 = this.mSessionConfig;
                if (object2 != null) {
                    object2 = this.mSessionConfig;
                    object2 = ((SessionConfig)object2).getRepeatingCaptureConfig();
                    object2 = ((CaptureConfig)object2).getImplementationOptions();
                    ((CaptureConfig$Builder)object3).addImplementationOptions((Config)object2);
                }
                object2 = this.mCameraEventOnRepeatingOptions;
                ((CaptureConfig$Builder)object3).addImplementationOptions((Config)object2);
                object2 = ((CaptureConfig)object4).getImplementationOptions();
                ((CaptureConfig$Builder)object3).addImplementationOptions((Config)object2);
                object3 = ((CaptureConfig$Builder)object3).build();
                object2 = this.mSynchronizedCaptureSession;
                object2 = object2.getDevice();
                Object object6 = this.mConfiguredSurfaceMap;
                object3 = Camera2CaptureRequestBuilder.build((CaptureConfig)object3, (CameraDevice)object2, (Map)object6);
                if (object3 == null) {
                    object = "Skipping issuing request without surface.";
                    Logger.d(string2, (String)object);
                    return;
                }
                object2 = new ArrayList();
                object4 = ((CaptureConfig)object4).getCameraCaptureCallbacks();
                object4 = object4.iterator();
                while ((n11 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                    object6 = object4.next();
                    object6 = (CameraCaptureCallback)object6;
                    CaptureCallbackConverter.toCaptureCallback((CameraCaptureCallback)object6, (List)object2);
                }
                cameraBurstCaptureCallback.addCamera2Callbacks((CaptureRequest)object3, (List)object2);
                arrayList.add(object3);
            }
            boolean bl5 = arrayList.isEmpty();
            if (bl5) {
                object = "Skipping issuing burst request due to no valid request elements";
                Logger.d(string2, (String)object);
                return;
            }
            object = this.mStillCaptureFlow;
            bl5 = ((StillCaptureFlow)object).shouldStopRepeatingBeforeCapture(arrayList, n10 != 0);
            if (bl5) {
                object = this.mSynchronizedCaptureSession;
                object.stopRepeating();
                object = new i0(this);
                cameraBurstCaptureCallback.setCaptureSequenceCallback((CameraBurstCaptureCallback$CaptureSequenceCallback)object);
            }
            object = this.mSynchronizedCaptureSession;
            object.captureBurstRequests(arrayList, cameraBurstCaptureCallback);
            return;
        }
        catch (CameraAccessException cameraAccessException) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "Unable to access camera: ";
            stringBuilder.append(string4);
            String string5 = cameraAccessException.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            Logger.e(string2, string5);
            Thread.dumpStack();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void issueCaptureRequests(List object) {
        Object object2 = this.mStateLock;
        synchronized (object2) {
            Object object3 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object4 = this.mState;
            int n10 = object4.ordinal();
            int n11 = object3[n10];
            switch (n11) {
                default: {
                    break;
                }
                case 6: 
                case 7: 
                case 8: {
                    object3 = "Cannot issue capture request on a closed/released session.";
                    object = new IllegalStateException((String)object3);
                    throw object;
                }
                case 5: {
                    object3 = this.mCaptureConfigs;
                    object3.addAll(object);
                    this.issuePendingCaptureRequest();
                    break;
                }
                case 2: 
                case 3: 
                case 4: {
                    object3 = this.mCaptureConfigs;
                    object3.addAll(object);
                    break;
                }
                case 1: {
                    object3 = new StringBuilder;
                    ((StringBuilder)object3)();
                    object4 = "issueCaptureRequests() should not be possible in state: ";
                    ((StringBuilder)object3).append((String)object4);
                    object4 = this.mState;
                    ((StringBuilder)object3).append(object4);
                    object3 = ((StringBuilder)object3).toString();
                    object = new IllegalStateException((String)object3);
                    throw object;
                }
            }
            return;
        }
    }

    public void issuePendingCaptureRequest() {
        List list = this.mCaptureConfigs;
        boolean bl2 = list.isEmpty();
        if (bl2) {
            return;
        }
        try {
            list = this.mCaptureConfigs;
            this.issueBurstCaptureRequest(list);
            return;
        }
        finally {
            this.mCaptureConfigs.clear();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void issueRepeatingCaptureRequests() {
        Object object = this.mSessionConfig;
        String string2 = TAG;
        if (object == null) {
            Logger.d(string2, "Skipping issueRepeatingCaptureRequests for no configuration case.");
            return;
        }
        object = this.mSessionConfig.getRepeatingCaptureConfig();
        Object object2 = ((CaptureConfig)object).getSurfaces();
        boolean bl2 = object2.isEmpty();
        String string3 = "Unable to access camera: ";
        if (bl2) {
            object = "Skipping issueRepeatingCaptureRequests for no surface.";
            Logger.d(string2, (String)object);
            try {
                object = this.mSynchronizedCaptureSession;
                object.stopRepeating();
                return;
            }
            catch (CameraAccessException cameraAccessException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string3);
                String string4 = cameraAccessException.getMessage();
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                Logger.e(string2, string4);
                Thread.dumpStack();
            }
            return;
        }
        object2 = "Issuing request for session.";
        try {
            CameraCaptureSession.CaptureCallback captureCallback;
            Logger.d(string2, (String)object2);
            object2 = CaptureConfig$Builder.from((CaptureConfig)object);
            Object object3 = this.mCameraEventCallbacks;
            object3 = ((CameraEventCallbacks)object3).createComboCallback();
            object3 = ((CameraEventCallbacks$ComboCameraEventCallback)object3).onRepeating();
            object3 = this.mCameraEventOnRepeatingOptions = (object3 = CaptureSession.mergeOptions((List)object3));
            ((CaptureConfig$Builder)object2).addImplementationOptions((Config)object3);
            object2 = ((CaptureConfig$Builder)object2).build();
            object3 = this.mSynchronizedCaptureSession;
            object3 = object3.getDevice();
            Map map = this.mConfiguredSurfaceMap;
            object2 = Camera2CaptureRequestBuilder.build((CaptureConfig)object2, (CameraDevice)object3, map);
            if (object2 == null) {
                object = "Skipping issuing empty request for session.";
                Logger.d(string2, (String)object);
                return;
            }
            object = ((CaptureConfig)object).getCameraCaptureCallbacks();
            int n10 = 1;
            object3 = new CameraCaptureSession.CaptureCallback[n10];
            map = null;
            object3[0] = captureCallback = this.mCaptureCallback;
            object = this.createCamera2CaptureCallback((List)object, (CameraCaptureSession.CaptureCallback[])object3);
            object3 = this.mSynchronizedCaptureSession;
            object3.setSingleRepeatingRequest((CaptureRequest)object2, (CameraCaptureSession.CaptureCallback)object);
            return;
        }
        catch (CameraAccessException cameraAccessException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            String string5 = cameraAccessException.getMessage();
            ((StringBuilder)object2).append(string5);
            string5 = ((StringBuilder)object2).toString();
            Logger.e(string2, string5);
            Thread.dumpStack();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture open(SessionConfig object, CameraDevice object2, SynchronizedCaptureSessionOpener object3) {
        Object object4 = this.mStateLock;
        synchronized (object4) {
            Object object5 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object6 = this.mState;
            int n10 = object6.ordinal();
            int n11 = object5[n10];
            n10 = 2;
            if (n11 != n10) {
                object = TAG;
                object2 = new StringBuilder();
                object3 = "Open not allowed in state: ";
                ((StringBuilder)object2).append((String)object3);
                object3 = this.mState;
                ((StringBuilder)object2).append(object3);
                object2 = ((StringBuilder)object2).toString();
                Logger.e((String)object, (String)object2);
                object2 = new StringBuilder();
                object3 = "open() should not allow the state: ";
                ((StringBuilder)object2).append((String)object3);
                object3 = this.mState;
                ((StringBuilder)object2).append(object3);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalStateException((String)object2);
                return Futures.immediateFailedFuture((Throwable)object);
            }
            object5 = (Object)CaptureSession$State.GET_SURFACE;
            this.mState = (CaptureSession$State)((Object)object5);
            object5 = ((SessionConfig)object).getSurfaces();
            object6 = new ArrayList(object5);
            this.mConfiguredDeferrableSurfaces = object6;
            this.mSynchronizedCaptureSessionOpener = object3;
            long l10 = 5000L;
            object3 = ((SynchronizedCaptureSessionOpener)object3).startWithDeferrableSurface((List)object6, l10);
            object3 = FutureChain.from((ListenableFuture)object3);
            object5 = new h0;
            object5(this, (SessionConfig)object, (CameraDevice)object2);
            object = this.mSynchronizedCaptureSessionOpener;
            object = ((SynchronizedCaptureSessionOpener)object).getExecutor();
            object = ((FutureChain)object3).transformAsync((AsyncFunction)object5, (Executor)object);
            object2 = new CaptureSession$2(this);
            object3 = this.mSynchronizedCaptureSessionOpener;
            object3 = ((SynchronizedCaptureSessionOpener)object3).getExecutor();
            Futures.addCallback((ListenableFuture)object, (FutureCallback)object2, (Executor)object3);
            return Futures.nonCancellationPropagating((ListenableFuture)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture release(boolean bl2) {
        Object object = this.mStateLock;
        synchronized (object) {
            Object object2 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object3 = this.mState;
            int n10 = object3.ordinal();
            int n11 = object2[n10];
            switch (n11) {
                default: {
                    break;
                }
                case 5: 
                case 6: {
                    Object object4;
                    object2 = this.mSynchronizedCaptureSession;
                    if (object2 != null) {
                        if (bl2) {
                            try {
                                object2.abortCaptures();
                            }
                            catch (CameraAccessException cameraAccessException) {
                                object2 = TAG;
                                object3 = "Unable to abort captures.";
                                Logger.e((String)object2, (String)object3, cameraAccessException);
                            }
                        }
                        object4 = this.mSynchronizedCaptureSession;
                        object4.close();
                    }
                }
                case 4: {
                    Object object4 = CaptureSession$State.RELEASING;
                    this.mState = object4;
                    object4 = this.mSynchronizedCaptureSessionOpener;
                    object2 = new StringBuilder();
                    object3 = "The Opener shouldn't null in state:";
                    ((StringBuilder)object2).append((String)object3);
                    object3 = this.mState;
                    ((StringBuilder)object2).append(object3);
                    object2 = ((StringBuilder)object2).toString();
                    Preconditions.checkNotNull(object4, object2);
                    object4 = this.mSynchronizedCaptureSessionOpener;
                    bl2 = ((SynchronizedCaptureSessionOpener)object4).stop();
                    if (bl2) {
                        this.finishClose();
                        break;
                    }
                }
                case 7: {
                    Object object4 = this.mReleaseFuture;
                    if (object4 != null) return this.mReleaseFuture;
                    object4 = new g0(this);
                    this.mReleaseFuture = object4 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object4);
                    return this.mReleaseFuture;
                }
                case 3: {
                    Object object5 = this.mSynchronizedCaptureSessionOpener;
                    object2 = new StringBuilder;
                    object2 = new StringBuilder();
                    object3 = "The Opener shouldn't null in state:";
                    ((StringBuilder)object2).append((String)object3);
                    object3 = this.mState;
                    ((StringBuilder)object2).append(object3);
                    object2 = ((StringBuilder)object2).toString();
                    Preconditions.checkNotNull(object5, object2);
                    object5 = this.mSynchronizedCaptureSessionOpener;
                    ((SynchronizedCaptureSessionOpener)object5).stop();
                }
                case 2: {
                    Object object5 = CaptureSession$State.RELEASED;
                    this.mState = object5;
                    break;
                }
                case 1: {
                    object2 = new StringBuilder;
                    object2 = new StringBuilder();
                    object3 = "release() should not be possible in state: ";
                    ((StringBuilder)object2).append((String)object3);
                    object3 = this.mState;
                    ((StringBuilder)object2).append(object3);
                    object2 = ((StringBuilder)object2).toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object2);
                    throw illegalStateException;
                }
            }
            return Futures.immediateFuture(null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setSessionConfig(SessionConfig object) {
        Object object2 = this.mStateLock;
        synchronized (object2) {
            Object object3 = CaptureSession$3.$SwitchMap$androidx$camera$camera2$internal$CaptureSession$State;
            Object object4 = this.mState;
            int n10 = object4.ordinal();
            int n11 = object3[n10];
            switch (n11) {
                default: {
                    break;
                }
                case 6: 
                case 7: 
                case 8: {
                    object3 = "Session configuration cannot be set on a closed/released session.";
                    object = new IllegalStateException((String)object3);
                    throw object;
                }
                case 5: {
                    this.mSessionConfig = object;
                    object3 = this.mConfiguredSurfaceMap;
                    object3 = object3.keySet();
                    object = ((SessionConfig)object).getSurfaces();
                    boolean bl2 = object3.containsAll((Collection<?>)object);
                    if (!bl2) {
                        object = TAG;
                        object3 = "Does not have the proper configured lists";
                        Logger.e((String)object, (String)object3);
                        return;
                    }
                    object = TAG;
                    object3 = "Attempting to submit CaptureRequest after setting";
                    Logger.d((String)object, (String)object3);
                    this.issueRepeatingCaptureRequests();
                    break;
                }
                case 2: 
                case 3: 
                case 4: {
                    this.mSessionConfig = object;
                    break;
                }
                case 1: {
                    object3 = new StringBuilder;
                    ((StringBuilder)object3)();
                    object4 = "setSessionConfig() should not be possible in state: ";
                    ((StringBuilder)object3).append((String)object4);
                    object4 = this.mState;
                    ((StringBuilder)object3).append(object4);
                    object3 = ((StringBuilder)object3).toString();
                    object = new IllegalStateException((String)object3);
                    throw object;
                }
            }
            return;
        }
    }

    public List setupConfiguredSurface(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Object object2 = CaptureConfig$Builder.from((CaptureConfig)object.next());
            int n10 = 1;
            ((CaptureConfig$Builder)object2).setTemplateType(n10);
            Iterator iterator2 = this.mSessionConfig.getRepeatingCaptureConfig().getSurfaces().iterator();
            while (bl3 = iterator2.hasNext()) {
                DeferrableSurface deferrableSurface = (DeferrableSurface)iterator2.next();
                ((CaptureConfig$Builder)object2).addSurface(deferrableSurface);
            }
            object2 = ((CaptureConfig$Builder)object2).build();
            arrayList.add(object2);
        }
        return arrayList;
    }
}

