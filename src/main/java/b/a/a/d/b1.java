/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl;

public final class b1
implements Runnable {
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl a;
    public final /* synthetic */ SynchronizedCaptureSession b;

    public /* synthetic */ b1(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, SynchronizedCaptureSession synchronizedCaptureSession) {
        this.a = synchronizedCaptureSessionBaseImpl;
        this.b = synchronizedCaptureSession;
    }

    public final void run() {
        SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = this.a;
        SynchronizedCaptureSession synchronizedCaptureSession = this.b;
        synchronizedCaptureSessionBaseImpl.b(synchronizedCaptureSession);
    }
}

