/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture$ImageCaptureRequest;

public final class y
implements Runnable {
    public final /* synthetic */ ImageCapture$ImageCaptureRequest a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Throwable d;

    public /* synthetic */ y(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest, int n10, String string2, Throwable throwable) {
        this.a = imageCapture$ImageCaptureRequest;
        this.b = n10;
        this.c = string2;
        this.d = throwable;
    }

    public final void run() {
        ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest = this.a;
        int n10 = this.b;
        String string2 = this.c;
        Throwable throwable = this.d;
        imageCapture$ImageCaptureRequest.d(n10, string2, throwable);
    }
}

