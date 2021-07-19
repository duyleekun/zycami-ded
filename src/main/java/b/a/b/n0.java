/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public final class n0
implements ImageReaderProxy$OnImageAvailableListener {
    public static final /* synthetic */ n0 a;

    static {
        n0 n02;
        a = n02 = new n0();
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageCapture.i(imageReaderProxy);
    }
}

