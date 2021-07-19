/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;

public class MetadataImageReader$1
extends CameraCaptureCallback {
    public final /* synthetic */ MetadataImageReader this$0;

    public MetadataImageReader$1(MetadataImageReader metadataImageReader) {
        this.this$0 = metadataImageReader;
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        super.onCaptureCompleted(cameraCaptureResult);
        this.this$0.resultIncoming(cameraCaptureResult);
    }
}

