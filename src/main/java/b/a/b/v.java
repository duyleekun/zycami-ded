/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.internal.YuvToJpegProcessor;

public final class v
implements Runnable {
    public final /* synthetic */ YuvToJpegProcessor a;

    public /* synthetic */ v(YuvToJpegProcessor yuvToJpegProcessor) {
        this.a = yuvToJpegProcessor;
    }

    public final void run() {
        ImageCapture.a(this.a);
    }
}

