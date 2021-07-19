/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.params.InputConfiguration
 *  android.hardware.camera2.params.SessionConfiguration
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat$SessionConfigurationCompatImpl;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class SessionConfigurationCompat$SessionConfigurationCompatApi28Impl
implements SessionConfigurationCompat$SessionConfigurationCompatImpl {
    private final SessionConfiguration mObject;
    private final List mOutputConfigurations;

    public SessionConfigurationCompat$SessionConfigurationCompatApi28Impl(int n10, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        list = SessionConfigurationCompat.transformFromCompat(list);
        SessionConfiguration sessionConfiguration = new SessionConfiguration(n10, list, executor, stateCallback);
        this(sessionConfiguration);
    }

    public SessionConfigurationCompat$SessionConfigurationCompatApi28Impl(Object list) {
        list = (SessionConfiguration)list;
        this.mObject = list;
        this.mOutputConfigurations = list = Collections.unmodifiableList(SessionConfigurationCompat.transformToCompat(list.getOutputConfigurations()));
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof SessionConfigurationCompat$SessionConfigurationCompatApi28Impl;
        if (!bl2) {
            return false;
        }
        SessionConfiguration sessionConfiguration = this.mObject;
        object = ((SessionConfigurationCompat$SessionConfigurationCompatApi28Impl)object).mObject;
        return Objects.equals(sessionConfiguration, object);
    }

    public Executor getExecutor() {
        return this.mObject.getExecutor();
    }

    public InputConfigurationCompat getInputConfiguration() {
        return InputConfigurationCompat.wrap(this.mObject.getInputConfiguration());
    }

    public List getOutputConfigurations() {
        return this.mOutputConfigurations;
    }

    public Object getSessionConfiguration() {
        return this.mObject;
    }

    public CaptureRequest getSessionParameters() {
        return this.mObject.getSessionParameters();
    }

    public int getSessionType() {
        return this.mObject.getSessionType();
    }

    public CameraCaptureSession.StateCallback getStateCallback() {
        return this.mObject.getStateCallback();
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    public void setInputConfiguration(InputConfigurationCompat inputConfigurationCompat) {
        SessionConfiguration sessionConfiguration = this.mObject;
        inputConfigurationCompat = (InputConfiguration)inputConfigurationCompat.unwrap();
        sessionConfiguration.setInputConfiguration((InputConfiguration)inputConfigurationCompat);
    }

    public void setSessionParameters(CaptureRequest captureRequest) {
        this.mObject.setSessionParameters(captureRequest);
    }
}

