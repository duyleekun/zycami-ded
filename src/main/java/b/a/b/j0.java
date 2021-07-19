/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.CaptureStage;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import java.util.List;

public final class j0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ImageCapture a;
    public final /* synthetic */ CaptureConfig$Builder b;
    public final /* synthetic */ List c;
    public final /* synthetic */ CaptureStage d;

    public /* synthetic */ j0(ImageCapture imageCapture, CaptureConfig$Builder captureConfig$Builder, List list, CaptureStage captureStage) {
        this.a = imageCapture;
        this.b = captureConfig$Builder;
        this.c = list;
        this.d = captureStage;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ImageCapture imageCapture = this.a;
        CaptureConfig$Builder captureConfig$Builder = this.b;
        List list = this.c;
        CaptureStage captureStage = this.d;
        return imageCapture.g(captureConfig$Builder, list, captureStage, callbackToFutureAdapter$Completer);
    }
}

