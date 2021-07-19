/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.params.OutputConfiguration
 *  android.os.Build$VERSION
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat$SessionConfigurationCompatApi28Impl;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat$SessionConfigurationCompatBaseImpl;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat$SessionConfigurationCompatImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class SessionConfigurationCompat {
    public static final int SESSION_HIGH_SPEED = 1;
    public static final int SESSION_REGULAR;
    private final SessionConfigurationCompat$SessionConfigurationCompatImpl mImpl;

    public SessionConfigurationCompat(int n10, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 < n12) {
            SessionConfigurationCompat$SessionConfigurationCompatBaseImpl sessionConfigurationCompat$SessionConfigurationCompatBaseImpl = new SessionConfigurationCompat$SessionConfigurationCompatBaseImpl(n10, list, executor, stateCallback);
            this.mImpl = sessionConfigurationCompat$SessionConfigurationCompatBaseImpl;
        } else {
            SessionConfigurationCompat$SessionConfigurationCompatApi28Impl sessionConfigurationCompat$SessionConfigurationCompatApi28Impl = new SessionConfigurationCompat$SessionConfigurationCompatApi28Impl(n10, list, executor, stateCallback);
            this.mImpl = sessionConfigurationCompat$SessionConfigurationCompatApi28Impl;
        }
    }

    private SessionConfigurationCompat(SessionConfigurationCompat$SessionConfigurationCompatImpl sessionConfigurationCompat$SessionConfigurationCompatImpl) {
        this.mImpl = sessionConfigurationCompat$SessionConfigurationCompatImpl;
    }

    public static List transformFromCompat(List object) {
        int n10 = object.size();
        ArrayList<OutputConfiguration> arrayList = new ArrayList<OutputConfiguration>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            OutputConfiguration outputConfiguration = (OutputConfiguration)((OutputConfigurationCompat)object.next()).unwrap();
            arrayList.add(outputConfiguration);
        }
        return arrayList;
    }

    public static List transformToCompat(List object) {
        int n10 = object.size();
        ArrayList<OutputConfigurationCompat> arrayList = new ArrayList<OutputConfigurationCompat>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            OutputConfigurationCompat outputConfigurationCompat = OutputConfigurationCompat.wrap((OutputConfiguration)object.next());
            arrayList.add(outputConfigurationCompat);
        }
        return arrayList;
    }

    public static SessionConfigurationCompat wrap(Object object) {
        SessionConfigurationCompat sessionConfigurationCompat = null;
        if (object == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 < n11) {
            return null;
        }
        SessionConfigurationCompat$SessionConfigurationCompatApi28Impl sessionConfigurationCompat$SessionConfigurationCompatApi28Impl = new SessionConfigurationCompat$SessionConfigurationCompatApi28Impl(object);
        sessionConfigurationCompat = new SessionConfigurationCompat(sessionConfigurationCompat$SessionConfigurationCompatApi28Impl);
        return sessionConfigurationCompat;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof SessionConfigurationCompat;
        if (!bl2) {
            return false;
        }
        SessionConfigurationCompat$SessionConfigurationCompatImpl sessionConfigurationCompat$SessionConfigurationCompatImpl = this.mImpl;
        object = ((SessionConfigurationCompat)object).mImpl;
        return sessionConfigurationCompat$SessionConfigurationCompatImpl.equals(object);
    }

    public Executor getExecutor() {
        return this.mImpl.getExecutor();
    }

    public InputConfigurationCompat getInputConfiguration() {
        return this.mImpl.getInputConfiguration();
    }

    public List getOutputConfigurations() {
        return this.mImpl.getOutputConfigurations();
    }

    public CaptureRequest getSessionParameters() {
        return this.mImpl.getSessionParameters();
    }

    public int getSessionType() {
        return this.mImpl.getSessionType();
    }

    public CameraCaptureSession.StateCallback getStateCallback() {
        return this.mImpl.getStateCallback();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public void setInputConfiguration(InputConfigurationCompat inputConfigurationCompat) {
        this.mImpl.setInputConfiguration(inputConfigurationCompat);
    }

    public void setSessionParameters(CaptureRequest captureRequest) {
        this.mImpl.setSessionParameters(captureRequest);
    }

    public Object unwrap() {
        return this.mImpl.getSessionConfiguration();
    }
}

