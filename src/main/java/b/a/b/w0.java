/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ProcessingImageReader$2;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public final class w0
implements Runnable {
    public final /* synthetic */ ProcessingImageReader$2 a;
    public final /* synthetic */ ImageReaderProxy$OnImageAvailableListener b;

    public /* synthetic */ w0(ProcessingImageReader$2 var1_1, ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a = var1_1;
        this.b = imageReaderProxy$OnImageAvailableListener;
    }

    public final void run() {
        ProcessingImageReader$2 processingImageReader$2 = this.a;
        ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener = this.b;
        processingImageReader$2.b(imageReaderProxy$OnImageAvailableListener);
    }
}

