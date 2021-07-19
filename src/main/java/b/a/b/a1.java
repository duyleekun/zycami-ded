/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public final class a1
implements ImageReaderProxy$OnImageAvailableListener {
    public final /* synthetic */ SafeCloseImageReaderProxy a;
    public final /* synthetic */ ImageReaderProxy$OnImageAvailableListener b;

    public /* synthetic */ a1(SafeCloseImageReaderProxy safeCloseImageReaderProxy, ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a = safeCloseImageReaderProxy;
        this.b = imageReaderProxy$OnImageAvailableListener;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.a;
        ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener = this.b;
        safeCloseImageReaderProxy.d(imageReaderProxy$OnImageAvailableListener, imageReaderProxy);
    }
}

