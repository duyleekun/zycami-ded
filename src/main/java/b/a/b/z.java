/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture$ImageCaptureRequest;
import androidx.camera.core.ImageProxy;

public final class z
implements Runnable {
    public final /* synthetic */ ImageCapture$ImageCaptureRequest a;
    public final /* synthetic */ ImageProxy b;

    public /* synthetic */ z(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest, ImageProxy imageProxy) {
        this.a = imageCapture$ImageCaptureRequest;
        this.b = imageProxy;
    }

    public final void run() {
        ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest = this.a;
        ImageProxy imageProxy = this.b;
        imageCapture$ImageCaptureRequest.b(imageProxy);
    }
}

