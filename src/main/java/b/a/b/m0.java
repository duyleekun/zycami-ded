/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$TakePictureState;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class m0
implements AsyncFunction {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ ImageCapture$TakePictureState b;

    public /* synthetic */ m0(ImageCapture imageCapture, ImageCapture$TakePictureState imageCapture$TakePictureState) {
        this.a = imageCapture;
        this.b = imageCapture$TakePictureState;
    }

    public final ListenableFuture apply(Object object) {
        ImageCapture imageCapture = this.a;
        ImageCapture$TakePictureState imageCapture$TakePictureState = this.b;
        object = (CameraCaptureResult)object;
        return imageCapture.k(imageCapture$TakePictureState, (CameraCaptureResult)object);
    }
}

