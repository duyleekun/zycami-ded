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
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat$SessionConfigurationCompatImpl;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class SessionConfigurationCompat$SessionConfigurationCompatBaseImpl
implements SessionConfigurationCompat$SessionConfigurationCompatImpl {
    private final Executor mExecutor;
    private InputConfigurationCompat mInputConfig = null;
    private final List mOutputConfigurations;
    private CaptureRequest mSessionParameters = null;
    private int mSessionType;
    private final CameraCaptureSession.StateCallback mStateCallback;

    public SessionConfigurationCompat$SessionConfigurationCompatBaseImpl(int n10, List list, Executor executor, CameraCaptureSession.StateCallback stateCallback) {
        this.mSessionType = n10;
        List list2 = new List(list);
        this.mOutputConfigurations = list2 = Collections.unmodifiableList(list2);
        this.mStateCallback = stateCallback;
        this.mExecutor = executor;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof SessionConfigurationCompat$SessionConfigurationCompatBaseImpl;
        if (n10 != 0) {
            int n11;
            object = (SessionConfigurationCompat$SessionConfigurationCompatBaseImpl)object;
            Object object2 = this.mInputConfig;
            Object object3 = ((SessionConfigurationCompat$SessionConfigurationCompatBaseImpl)object).mInputConfig;
            n10 = Objects.equals(object2, object3);
            if (n10 != 0 && (n10 = this.mSessionType) == (n11 = ((SessionConfigurationCompat$SessionConfigurationCompatBaseImpl)object).mSessionType) && (n10 = (object2 = this.mOutputConfigurations).size()) == (n11 = (object3 = ((SessionConfigurationCompat$SessionConfigurationCompatBaseImpl)object).mOutputConfigurations).size())) {
                object2 = null;
                for (n10 = 0; n10 < (n11 = (object3 = this.mOutputConfigurations).size()); ++n10) {
                    Object e10;
                    object3 = (OutputConfigurationCompat)this.mOutputConfigurations.get(n10);
                    n11 = (int)(((OutputConfigurationCompat)object3).equals(e10 = ((SessionConfigurationCompat$SessionConfigurationCompatBaseImpl)object).mOutputConfigurations.get(n10)) ? 1 : 0);
                    if (n11 != 0) continue;
                    return false;
                }
                return bl2;
            }
        }
        return false;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public InputConfigurationCompat getInputConfiguration() {
        return this.mInputConfig;
    }

    public List getOutputConfigurations() {
        return this.mOutputConfigurations;
    }

    public Object getSessionConfiguration() {
        return null;
    }

    public CaptureRequest getSessionParameters() {
        return this.mSessionParameters;
    }

    public int getSessionType() {
        return this.mSessionType;
    }

    public CameraCaptureSession.StateCallback getStateCallback() {
        return this.mStateCallback;
    }

    public int hashCode() {
        int n10 = this.mOutputConfigurations.hashCode() ^ 0x1F;
        int n11 = (n10 << 5) - n10;
        InputConfigurationCompat inputConfigurationCompat = this.mInputConfig;
        if (inputConfigurationCompat == null) {
            n10 = 0;
            inputConfigurationCompat = null;
        } else {
            n10 = inputConfigurationCompat.hashCode();
        }
        n10 ^= n11;
        n11 = (n10 << 5) - n10;
        return this.mSessionType ^ n11;
    }

    public void setInputConfiguration(InputConfigurationCompat object) {
        int n10 = this.mSessionType;
        int n11 = 1;
        if (n10 != n11) {
            this.mInputConfig = object;
            return;
        }
        object = new UnsupportedOperationException("Method not supported for high speed session types");
        throw object;
    }

    public void setSessionParameters(CaptureRequest captureRequest) {
        this.mSessionParameters = captureRequest;
    }
}

