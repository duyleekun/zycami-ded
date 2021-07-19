/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;

public final class a0
implements Runnable {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ ImageCapture$OnImageCapturedCallback b;

    public /* synthetic */ a0(ImageCapture imageCapture, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        this.a = imageCapture;
        this.b = imageCapture$OnImageCapturedCallback;
    }

    public final void run() {
        ImageCapture imageCapture = this.a;
        ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback = this.b;
        imageCapture.p(imageCapture$OnImageCapturedCallback);
    }
}

