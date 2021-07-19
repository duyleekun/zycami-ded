/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;

public class Preview$1
extends CameraCaptureCallback {
    public final /* synthetic */ Preview this$0;
    public final /* synthetic */ ImageInfoProcessor val$processor;

    public Preview$1(Preview preview, ImageInfoProcessor imageInfoProcessor) {
        this.this$0 = preview;
        this.val$processor = imageInfoProcessor;
    }

    public void onCaptureCompleted(CameraCaptureResult object) {
        super.onCaptureCompleted((CameraCaptureResult)object);
        ImageInfoProcessor imageInfoProcessor = this.val$processor;
        CameraCaptureResultImageInfo cameraCaptureResultImageInfo = new CameraCaptureResultImageInfo((CameraCaptureResult)object);
        boolean bl2 = imageInfoProcessor.process(cameraCaptureResultImageInfo);
        if (bl2) {
            object = this.this$0;
            ((UseCase)object).notifyUpdated();
        }
    }
}

