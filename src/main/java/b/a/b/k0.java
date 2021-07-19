/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$ImageCaptureRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class k0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ ImageCapture$ImageCaptureRequest b;

    public /* synthetic */ k0(ImageCapture imageCapture, ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest) {
        this.a = imageCapture;
        this.b = imageCapture$ImageCaptureRequest;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ImageCapture imageCapture = this.a;
        ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest = this.b;
        return imageCapture.v(imageCapture$ImageCaptureRequest, callbackToFutureAdapter$Completer);
    }
}

