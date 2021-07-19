/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CaptureRequest
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import java.util.List;
import java.util.concurrent.Executor;

public interface SessionConfigurationCompat$SessionConfigurationCompatImpl {
    public Executor getExecutor();

    public InputConfigurationCompat getInputConfiguration();

    public List getOutputConfigurations();

    public Object getSessionConfiguration();

    public CaptureRequest getSessionParameters();

    public int getSessionType();

    public CameraCaptureSession.StateCallback getStateCallback();

    public void setInputConfiguration(InputConfigurationCompat var1);

    public void setSessionParameters(CaptureRequest var1);
}

