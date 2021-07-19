/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$OnImageSavedCallback;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import java.util.concurrent.Executor;

public final class d0
implements Runnable {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ ImageCapture$OutputFileOptions b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ ImageCapture$OnImageSavedCallback d;

    public /* synthetic */ d0(ImageCapture imageCapture, ImageCapture$OutputFileOptions imageCapture$OutputFileOptions, Executor executor, ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback) {
        this.a = imageCapture;
        this.b = imageCapture$OutputFileOptions;
        this.c = executor;
        this.d = imageCapture$OnImageSavedCallback;
    }

    public final void run() {
        ImageCapture imageCapture = this.a;
        ImageCapture$OutputFileOptions imageCapture$OutputFileOptions = this.b;
        Executor executor = this.c;
        ImageCapture$OnImageSavedCallback imageCapture$OnImageSavedCallback = this.d;
        imageCapture.t(imageCapture$OutputFileOptions, executor, imageCapture$OnImageSavedCallback);
    }
}

