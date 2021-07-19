/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public final class c
implements Runnable {
    public final /* synthetic */ AndroidImageReaderProxy a;
    public final /* synthetic */ ImageReaderProxy$OnImageAvailableListener b;

    public /* synthetic */ c(AndroidImageReaderProxy androidImageReaderProxy, ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a = androidImageReaderProxy;
        this.b = imageReaderProxy$OnImageAvailableListener;
    }

    public final void run() {
        AndroidImageReaderProxy androidImageReaderProxy = this.a;
        ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener = this.b;
        androidImageReaderProxy.b(imageReaderProxy$OnImageAvailableListener);
    }
}

