/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture$CaptureCallbackChecker;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class w
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ ImageCapture$CaptureCallbackChecker a;
    public final /* synthetic */ ImageCapture$CaptureCallbackChecker$CaptureResultChecker b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Object e;

    public /* synthetic */ w(ImageCapture$CaptureCallbackChecker imageCapture$CaptureCallbackChecker, ImageCapture$CaptureCallbackChecker$CaptureResultChecker imageCapture$CaptureCallbackChecker$CaptureResultChecker, long l10, long l11, Object object) {
        this.a = imageCapture$CaptureCallbackChecker;
        this.b = imageCapture$CaptureCallbackChecker$CaptureResultChecker;
        this.c = l10;
        this.d = l11;
        this.e = object;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ImageCapture$CaptureCallbackChecker imageCapture$CaptureCallbackChecker = this.a;
        ImageCapture$CaptureCallbackChecker$CaptureResultChecker imageCapture$CaptureCallbackChecker$CaptureResultChecker = this.b;
        long l10 = this.c;
        long l11 = this.d;
        Object object = this.e;
        return imageCapture$CaptureCallbackChecker.b(imageCapture$CaptureCallbackChecker$CaptureResultChecker, l10, l11, object, callbackToFutureAdapter$Completer);
    }
}

