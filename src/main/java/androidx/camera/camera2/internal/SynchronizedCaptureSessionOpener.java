/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener$OpenerImpl;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

public final class SynchronizedCaptureSessionOpener {
    public static final String FEATURE_DEFERRABLE_SURFACE_CLOSE = "deferrableSurface_close";
    public static final String FEATURE_FORCE_CLOSE = "force_close";
    public static final String FEATURE_WAIT_FOR_REQUEST = "wait_for_request";
    private final SynchronizedCaptureSessionOpener$OpenerImpl mImpl;

    public SynchronizedCaptureSessionOpener(SynchronizedCaptureSessionOpener$OpenerImpl synchronizedCaptureSessionOpener$OpenerImpl) {
        this.mImpl = synchronizedCaptureSessionOpener$OpenerImpl;
    }

    public SessionConfigurationCompat createSessionConfigurationCompat(int n10, List list, SynchronizedCaptureSession$StateCallback synchronizedCaptureSession$StateCallback) {
        return this.mImpl.createSessionConfigurationCompat(n10, list, synchronizedCaptureSession$StateCallback);
    }

    public Executor getExecutor() {
        return this.mImpl.getExecutor();
    }

    public ListenableFuture openCaptureSession(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
        return this.mImpl.openCaptureSession(cameraDevice, sessionConfigurationCompat);
    }

    public ListenableFuture startWithDeferrableSurface(List list, long l10) {
        return this.mImpl.startWithDeferrableSurface(list, l10);
    }

    public boolean stop() {
        return this.mImpl.stop();
    }
}

