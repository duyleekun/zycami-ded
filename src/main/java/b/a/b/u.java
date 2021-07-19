/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$ImageCaptureRequest;
import androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$ImageCaptor;
import com.google.common.util.concurrent.ListenableFuture;

public final class u
implements ImageCapture$ImageCaptureRequestProcessor$ImageCaptor {
    public final /* synthetic */ ImageCapture a;

    public /* synthetic */ u(ImageCapture imageCapture) {
        this.a = imageCapture;
    }

    public final ListenableFuture capture(ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest) {
        return this.a.c(imageCapture$ImageCaptureRequest);
    }
}

