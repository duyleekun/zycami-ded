/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;

public class ImageCapture$6
implements ImageCapture$CaptureCallbackChecker$CaptureResultChecker {
    public final /* synthetic */ ImageCapture this$0;

    public ImageCapture$6(ImageCapture imageCapture) {
        this.this$0 = imageCapture;
    }

    public CameraCaptureResult check(CameraCaptureResult cameraCaptureResult) {
        String string2 = "ImageCapture";
        boolean bl2 = Logger.isDebugEnabled(string2);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("preCaptureState, AE=");
            Enum enum_ = cameraCaptureResult.getAeState();
            charSequence.append(enum_);
            charSequence.append(" AF =");
            enum_ = cameraCaptureResult.getAfState();
            charSequence.append(enum_);
            charSequence.append(" AWB=");
            enum_ = cameraCaptureResult.getAwbState();
            charSequence.append(enum_);
            charSequence = charSequence.toString();
            Logger.d(string2, (String)charSequence);
        }
        return cameraCaptureResult;
    }
}

