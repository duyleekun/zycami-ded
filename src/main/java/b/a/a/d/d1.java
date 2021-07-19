/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;

public final class d1
implements Runnable {
    public final /* synthetic */ SynchronizedCaptureSessionImpl a;

    public /* synthetic */ d1(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        this.a = synchronizedCaptureSessionImpl;
    }

    public final void run() {
        this.a.h();
    }
}

