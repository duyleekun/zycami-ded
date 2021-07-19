/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package androidx.camera.core;

import android.os.SystemClock;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultListener;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class ImageCapture$CaptureCallbackChecker$1
implements ImageCapture$CaptureCallbackChecker$CaptureResultListener {
    public final /* synthetic */ ImageCapture.CaptureCallbackChecker this$0;
    public final /* synthetic */ ImageCapture$CaptureCallbackChecker$CaptureResultChecker val$checker;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;
    public final /* synthetic */ Object val$defValue;
    public final /* synthetic */ long val$startTimeInMs;
    public final /* synthetic */ long val$timeoutInMs;

    public ImageCapture$CaptureCallbackChecker$1(ImageCapture.CaptureCallbackChecker captureCallbackChecker, ImageCapture$CaptureCallbackChecker$CaptureResultChecker imageCapture$CaptureCallbackChecker$CaptureResultChecker, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, long l10, long l11, Object object) {
        this.this$0 = captureCallbackChecker;
        this.val$checker = imageCapture$CaptureCallbackChecker$CaptureResultChecker;
        this.val$completer = callbackToFutureAdapter$Completer;
        this.val$startTimeInMs = l10;
        this.val$timeoutInMs = l11;
        this.val$defValue = object;
    }

    public boolean onCaptureResult(CameraCaptureResult object) {
        ImageCapture$CaptureCallbackChecker$CaptureResultChecker imageCapture$CaptureCallbackChecker$CaptureResultChecker = this.val$checker;
        object = imageCapture$CaptureCallbackChecker$CaptureResultChecker.check((CameraCaptureResult)object);
        boolean bl2 = true;
        if (object != null) {
            this.val$completer.set(object);
            return bl2;
        }
        long l10 = this.val$startTimeInMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 > 0) {
            l10 = SystemClock.elapsedRealtime();
            l11 = this.val$startTimeInMs;
            long l13 = (l10 -= l11) - (l11 = this.val$timeoutInMs);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 > 0) {
                object = this.val$completer;
                Object object3 = this.val$defValue;
                ((CallbackToFutureAdapter$Completer)object).set(object3);
                return bl2;
            }
        }
        return false;
    }
}

