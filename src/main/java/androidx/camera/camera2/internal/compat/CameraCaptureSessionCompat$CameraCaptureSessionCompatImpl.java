/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

public interface CameraCaptureSessionCompat$CameraCaptureSessionCompatImpl {
    public int captureBurstRequests(List var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public int captureSingleRequest(CaptureRequest var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public int setRepeatingBurstRequests(List var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public int setSingleRepeatingRequest(CaptureRequest var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public CameraCaptureSession unwrap();
}

