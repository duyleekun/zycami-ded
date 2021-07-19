/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.CaptureSessionRepository;
import b.a.a.d.j0;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

public class CaptureSessionRepository$1
extends CameraDevice.StateCallback {
    public final /* synthetic */ CaptureSessionRepository this$0;

    public CaptureSessionRepository$1(CaptureSessionRepository captureSessionRepository) {
        this.this$0 = captureSessionRepository;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Object object = this.this$0.mLock;
        synchronized (object) {
            Object object2 = this.this$0;
            object2 = ((CaptureSessionRepository)object2).mCreatingCaptureSessions;
            LinkedHashSet linkedHashSet2 = new LinkedHashSet(object2);
            linkedHashSet.addAll(linkedHashSet2);
            object2 = this.this$0;
            object2 = ((CaptureSessionRepository)object2).mCaptureSessions;
            linkedHashSet2 = new LinkedHashSet(object2);
            linkedHashSet.addAll(linkedHashSet2);
        }
        CaptureSessionRepository.forceOnClosed(linkedHashSet);
    }

    private void forceOnClosedCaptureSessions() {
        Executor executor = this.this$0.mExecutor;
        j0 j02 = new j0(this);
        executor.execute(j02);
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public void onDisconnected(CameraDevice cameraDevice) {
        this.forceOnClosedCaptureSessions();
    }

    public void onError(CameraDevice cameraDevice, int n10) {
        this.forceOnClosedCaptureSessions();
    }

    public void onOpened(CameraDevice cameraDevice) {
    }
}

