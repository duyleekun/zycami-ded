/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

public interface SynchronizedCaptureSessionOpener$OpenerImpl {
    public SessionConfigurationCompat createSessionConfigurationCompat(int var1, List var2, SynchronizedCaptureSession$StateCallback var3);

    public Executor getExecutor();

    public ListenableFuture openCaptureSession(CameraDevice var1, SessionConfigurationCompat var2);

    public ListenableFuture startWithDeferrableSurface(List var1, long var2);

    public boolean stop();
}

