/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public final class r0
implements ImageReaderProxy$OnImageAvailableListener {
    public final /* synthetic */ MetadataImageReader a;

    public /* synthetic */ r0(MetadataImageReader metadataImageReader) {
        this.a = metadataImageReader;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.a.d(imageReaderProxy);
    }
}

