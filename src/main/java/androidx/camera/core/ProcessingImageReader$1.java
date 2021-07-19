/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public class ProcessingImageReader$1
implements ImageReaderProxy$OnImageAvailableListener {
    public final /* synthetic */ ProcessingImageReader this$0;

    public ProcessingImageReader$1(ProcessingImageReader processingImageReader) {
        this.this$0 = processingImageReader;
    }

    public void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.this$0.imageIncoming(imageReaderProxy);
    }
}

