/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class CaptureSessionRepository {
    private final CameraDevice.StateCallback mCameraStateCallback;
    public final Set mCaptureSessions;
    public final Set mClosingCaptureSession;
    public final Set mCreatingCaptureSessions;
    public final Map mDeferrableSurfaceMap;
    public final Executor mExecutor;
    public final Object mLock;

    public CaptureSessionRepository(Executor executor) {
        Object object = new Object();
        this.mLock = object;
        this.mCaptureSessions = object = new Object();
        this.mClosingCaptureSession = object = new Object();
        this.mCreatingCaptureSessions = object = new Object();
        this.mDeferrableSurfaceMap = object;
        super(this);
        this.mCameraStateCallback = object;
        this.mExecutor = executor;
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

    public CameraDevice.StateCallback getCameraStateCallback() {
        return this.mCameraStateCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getCaptureSessions() {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mCaptureSessions;
            return new ArrayList(set);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getClosingCaptureSession() {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mClosingCaptureSession;
            return new ArrayList(set);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getCreatingCaptureSessions() {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mCreatingCaptureSessions;
            return new ArrayList(set);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCaptureSessionClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mCaptureSessions;
            set.remove(synchronizedCaptureSession);
            set = this.mClosingCaptureSession;
            set.remove(synchronizedCaptureSession);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCaptureSessionClosing(SynchronizedCaptureSession synchronizedCaptureSession) {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mClosingCaptureSession;
            set.add(synchronizedCaptureSession);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCaptureSessionConfigureFail(SynchronizedCaptureSession synchronizedCaptureSession) {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mCreatingCaptureSessions;
            set.remove(synchronizedCaptureSession);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCaptureSessionCreated(SynchronizedCaptureSession synchronizedCaptureSession) {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mCaptureSessions;
            set.add(synchronizedCaptureSession);
            set = this.mCreatingCaptureSessions;
            set.remove(synchronizedCaptureSession);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreateCaptureSession(SynchronizedCaptureSession synchronizedCaptureSession) {
        Object object = this.mLock;
        synchronized (object) {
            Set set = this.mCreatingCaptureSessions;
            set.add(synchronizedCaptureSession);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map registerDeferrableSurface(SynchronizedCaptureSession hashMap, List object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            Map map = this.mDeferrableSurfaceMap;
            map.put(hashMap, object);
            object = this.mDeferrableSurfaceMap;
            return new HashMap(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregisterDeferrableSurface(SynchronizedCaptureSession synchronizedCaptureSession) {
        Object object = this.mLock;
        synchronized (object) {
            Map map = this.mDeferrableSurfaceMap;
            map.remove(synchronizedCaptureSession);
            return;
        }
    }
}

