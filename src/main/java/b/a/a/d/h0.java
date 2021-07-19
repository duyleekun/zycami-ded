/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 */
package b.a.a.d;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final class h0
implements AsyncFunction {
    public final /* synthetic */ CaptureSession a;
    public final /* synthetic */ SessionConfig b;
    public final /* synthetic */ CameraDevice c;

    public /* synthetic */ h0(CaptureSession captureSession, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        this.a = captureSession;
        this.b = sessionConfig;
        this.c = cameraDevice;
    }

    public final ListenableFuture apply(Object object) {
        CaptureSession captureSession = this.a;
        SessionConfig sessionConfig = this.b;
        CameraDevice cameraDevice = this.c;
        object = (List)object;
        return captureSession.d(sessionConfig, cameraDevice, (List)object);
    }
}

