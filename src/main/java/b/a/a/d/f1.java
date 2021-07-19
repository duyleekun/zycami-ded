/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 */
package b.a.a.d;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final class f1
implements AsyncFunction {
    public final /* synthetic */ SynchronizedCaptureSessionImpl a;
    public final /* synthetic */ CameraDevice b;
    public final /* synthetic */ SessionConfigurationCompat c;

    public /* synthetic */ f1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat) {
        this.a = synchronizedCaptureSessionImpl;
        this.b = cameraDevice;
        this.c = sessionConfigurationCompat;
    }

    public final ListenableFuture apply(Object object) {
        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl = this.a;
        CameraDevice cameraDevice = this.b;
        SessionConfigurationCompat sessionConfigurationCompat = this.c;
        object = (List)object;
        return synchronizedCaptureSessionImpl.n(cameraDevice, sessionConfigurationCompat, (List)object);
    }
}

