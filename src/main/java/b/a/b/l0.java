/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$OnImageCapturedCallback;
import java.util.concurrent.Executor;

public final class l0
implements Runnable {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ ImageCapture$OnImageCapturedCallback c;

    public /* synthetic */ l0(ImageCapture imageCapture, Executor executor, ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback) {
        this.a = imageCapture;
        this.b = executor;
        this.c = imageCapture$OnImageCapturedCallback;
    }

    public final void run() {
        ImageCapture imageCapture = this.a;
        Executor executor = this.b;
        ImageCapture$OnImageCapturedCallback imageCapture$OnImageCapturedCallback = this.c;
        imageCapture.r(executor, imageCapture$OnImageCapturedCallback);
    }
}

