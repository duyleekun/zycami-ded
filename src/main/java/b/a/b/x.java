/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$ImageCaptureRequest;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class x
implements AsyncFunction {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ ImageCapture$ImageCaptureRequest b;

    public /* synthetic */ x(ImageCapture imageCapture, ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest) {
        this.a = imageCapture;
        this.b = imageCapture$ImageCaptureRequest;
    }

    public final ListenableFuture apply(Object object) {
        ImageCapture imageCapture = this.a;
        ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest = this.b;
        object = (Void)object;
        return imageCapture.y(imageCapture$ImageCaptureRequest, (Void)object);
    }
}

