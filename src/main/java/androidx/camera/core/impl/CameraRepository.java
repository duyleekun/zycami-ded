/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.b.w1.c;
import b.a.b.w1.d;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class CameraRepository {
    private static final String TAG = "CameraRepository";
    private final Map mCameras;
    private final Object mCamerasLock;
    private CallbackToFutureAdapter$Completer mDeinitCompleter;
    private ListenableFuture mDeinitFuture;
    private final Set mReleasingCameras;

    public CameraRepository() {
        Cloneable cloneable = new Cloneable();
        this.mCamerasLock = cloneable;
        this.mCameras = cloneable = new Cloneable();
        this.mReleasingCameras = cloneable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Object a(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        Object object = this.mCamerasLock;
        synchronized (object) {
            this.mDeinitCompleter = callbackToFutureAdapter$Completer;
            return "CameraRepository-deinit";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void c(CameraInternal object) {
        Object object2 = this.mCamerasLock;
        synchronized (object2) {
            Set set = this.mReleasingCameras;
            set.remove(object);
            object = this.mReleasingCameras;
            boolean bl2 = object.isEmpty();
            if (bl2) {
                object = this.mDeinitCompleter;
                Preconditions.checkNotNull(object);
                object = this.mDeinitCompleter;
                set = null;
                ((CallbackToFutureAdapter$Completer)object).set(null);
                this.mDeinitCompleter = null;
                this.mDeinitFuture = null;
            }
            return;
        }
    }

    public /* synthetic */ Object b(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a(callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void d(CameraInternal cameraInternal) {
        this.c(cameraInternal);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture deinit() {
        Object object = this.mCamerasLock;
        synchronized (object) {
            Object object2 = this.mCameras;
            boolean bl2 = object2.isEmpty();
            if (bl2) {
                object2 = this.mDeinitFuture;
                if (object2 != null) return object2;
                bl2 = false;
                object2 = null;
                return Futures.immediateFuture(null);
            }
            object2 = this.mDeinitFuture;
            if (object2 == null) {
                object2 = new c(this);
                this.mDeinitFuture = object2 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object2);
            }
            Object object3 = this.mReleasingCameras;
            Object object4 = this.mCameras;
            object4 = object4.values();
            object3.addAll(object4);
            object3 = this.mCameras;
            object3 = object3.values();
            object3 = object3.iterator();
            while (true) {
                boolean bl3;
                if (!(bl3 = object3.hasNext())) {
                    object3 = this.mCameras;
                    object3.clear();
                    return object2;
                }
                object4 = object3.next();
                object4 = (CameraInternal)object4;
                ListenableFuture listenableFuture = object4.release();
                d d10 = new d(this, (CameraInternal)object4);
                object4 = CameraXExecutors.directExecutor();
                listenableFuture.addListener(d10, (Executor)object4);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraInternal getCamera(String string2) {
        Object object = this.mCamerasLock;
        synchronized (object) {
            Object object2 = this.mCameras;
            object2 = object2.get(string2);
            object2 = (CameraInternal)object2;
            if (object2 != null) {
                return object2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "Invalid camera: ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object2 = new IllegalArgumentException(string2);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set getCameraIds() {
        Object object = this.mCamerasLock;
        synchronized (object) {
            Object object2 = this.mCameras;
            object2 = object2.keySet();
            return new LinkedHashSet(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LinkedHashSet getCameras() {
        Object object = this.mCamerasLock;
        synchronized (object) {
            Object object2 = this.mCameras;
            object2 = object2.values();
            return new LinkedHashSet(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(CameraFactory cameraFactory) {
        Object object = this.mCamerasLock;
        synchronized (object) {
            try {
                try {
                    Object object2 = cameraFactory.getAvailableCameraIds();
                    object2 = object2.iterator();
                    while (true) {
                        boolean bl2;
                        if (!(bl2 = object2.hasNext())) {
                            return;
                        }
                        Object object3 = object2.next();
                        object3 = (String)object3;
                        Object object4 = TAG;
                        Object object5 = new StringBuilder();
                        String string2 = "Added camera: ";
                        ((StringBuilder)object5).append(string2);
                        ((StringBuilder)object5).append((String)object3);
                        object5 = ((StringBuilder)object5).toString();
                        Logger.d((String)object4, (String)object5);
                        object4 = this.mCameras;
                        object5 = cameraFactory.getCamera((String)object3);
                        object4.put(object3, object5);
                    }
                }
                catch (CameraUnavailableException cameraUnavailableException) {
                    InitializationException initializationException = new InitializationException(cameraUnavailableException);
                    throw initializationException;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}

