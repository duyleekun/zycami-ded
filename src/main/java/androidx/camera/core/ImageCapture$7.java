/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;

public class ImageCapture$7
implements ImageCapture$CaptureCallbackChecker$CaptureResultChecker {
    public final /* synthetic */ ImageCapture this$0;

    public ImageCapture$7(ImageCapture imageCapture) {
        this.this$0 = imageCapture;
    }

    public Boolean check(CameraCaptureResult cameraCaptureResult) {
        boolean bl2;
        Object object = "ImageCapture";
        boolean bl3 = Logger.isDebugEnabled((String)object);
        if (bl3) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("checkCaptureResult, AE=");
            Enum enum_ = cameraCaptureResult.getAeState();
            charSequence.append(enum_);
            charSequence.append(" AF =");
            enum_ = cameraCaptureResult.getAfState();
            charSequence.append(enum_);
            charSequence.append(" AWB=");
            enum_ = cameraCaptureResult.getAwbState();
            charSequence.append(enum_);
            charSequence = charSequence.toString();
            Logger.d((String)object, (String)charSequence);
        }
        if (bl2 = ((ImageCapture)(object = this.this$0)).is3AConverged(cameraCaptureResult)) {
            return Boolean.TRUE;
        }
        return null;
    }
}

