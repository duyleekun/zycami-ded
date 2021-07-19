/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SafeCloseImageReaderProxy;

public final class b1
implements ForwardingImageProxy$OnImageCloseListener {
    public final /* synthetic */ SafeCloseImageReaderProxy a;

    public /* synthetic */ b1(SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        this.a = safeCloseImageReaderProxy;
    }

    public final void onImageClose(ImageProxy imageProxy) {
        this.a.b(imageProxy);
    }
}

