/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CaptureRequest
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

public interface SynchronizedCaptureSession {
    public void abortCaptures();

    public int captureBurstRequests(List var1, CameraCaptureSession.CaptureCallback var2);

    public int captureBurstRequests(List var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public int captureSingleRequest(CaptureRequest var1, CameraCaptureSession.CaptureCallback var2);

    public int captureSingleRequest(CaptureRequest var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public void close();

    public CameraDevice getDevice();

    public SynchronizedCaptureSession$StateCallback getStateCallback();

    public ListenableFuture getSynchronizedBlocker(String var1);

    public int setRepeatingBurstRequests(List var1, CameraCaptureSession.CaptureCallback var2);

    public int setRepeatingBurstRequests(List var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public int setSingleRepeatingRequest(CaptureRequest var1, CameraCaptureSession.CaptureCallback var2);

    public int setSingleRepeatingRequest(CaptureRequest var1, Executor var2, CameraCaptureSession.CaptureCallback var3);

    public void stopRepeating();

    public CameraCaptureSessionCompat toCameraCaptureSessionCompat();
}

