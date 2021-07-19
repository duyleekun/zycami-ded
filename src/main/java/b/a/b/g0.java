/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class g0
implements ImageReaderProxy$OnImageAvailableListener {
    public final /* synthetic */ CallbackToFutureAdapter$Completer a;

    public /* synthetic */ g0(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.a = callbackToFutureAdapter$Completer;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageCapture.w(this.a, imageReaderProxy);
    }
}

