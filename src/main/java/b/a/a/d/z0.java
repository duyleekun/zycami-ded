/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class z0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl a;
    public final /* synthetic */ CameraDeviceCompat b;
    public final /* synthetic */ SessionConfigurationCompat c;

    public /* synthetic */ z0(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, CameraDeviceCompat cameraDeviceCompat, SessionConfigurationCompat sessionConfigurationCompat) {
        this.a = synchronizedCaptureSessionBaseImpl;
        this.b = cameraDeviceCompat;
        this.c = sessionConfigurationCompat;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = this.a;
        CameraDeviceCompat cameraDeviceCompat = this.b;
        SessionConfigurationCompat sessionConfigurationCompat = this.c;
        return synchronizedCaptureSessionBaseImpl.d(cameraDeviceCompat, sessionConfigurationCompat, callbackToFutureAdapter$Completer);
    }
}

